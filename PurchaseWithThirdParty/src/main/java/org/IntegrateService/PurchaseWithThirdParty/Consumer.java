package org.IntegrateService.PurchaseWithThirdParty;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;
import java.net.http.HttpTimeoutException;
import java.time.Duration;
import java.util.HashMap;

import org.IntegrateService.PurchaseWithThirdParty.Model.PurchaseVoucheRequest;
import org.IntegrateService.PurchaseWithThirdParty.Model.SendSMSVoucherRequest;
import org.IntegrateService.PurchaseWithThirdParty.Model.VoucherResponseMessage;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;

@Component
public class Consumer {	
    public static final String ROUTING_KEY = "response.phone";

	@Autowired
	RabbitTemplate asyncRabbitTemplate;
	
    @RabbitListener(queues = "request")
    public VoucherResponseMessage receive(PurchaseVoucheRequest purchaseVoucheRequest) throws IOException, InterruptedException, URISyntaxException {
		VoucherResponseMessage voucherResponseMessage = new VoucherResponseMessage();
		voucherResponseMessage.setIsSuccess(false);
    	try {
	    	System.out.println(purchaseVoucheRequest.getPhoneNumber());
	        var values = new HashMap<String, Integer>() {{
	            put("price", 50);
	        }};
	        var objectMapper = new ObjectMapper();
	        String requestBody = "";

			requestBody = objectMapper.writeValueAsString(values);
	    	// create a client
	    	var client = HttpClient.newHttpClient();
	    	// create a request
	    	var request = HttpRequest.newBuilder(new URI("http://localhost:9999/RetriveVoucheCode"))
				.timeout(Duration.ofSeconds(10))
				.header("Content-Type", "application/json")
				.POST(HttpRequest.BodyPublishers.ofString(requestBody))
				.build();
	    	long start = System.currentTimeMillis();
	    	var responseFromThirdPt = client.send(request, BodyHandlers.ofString());
			System.out.println("responseFromThirdPt.body(): "+responseFromThirdPt.body());

	    	if(responseFromThirdPt.statusCode() == 202) {
	    		try {
			    	var result = objectMapper.readValue(responseFromThirdPt.body(), VoucherResponseMessage.class);
			    	long end = System.currentTimeMillis();
			    	if(end-start >=2900) {
			    		SendSMSVoucherRequest sendSMSVoucherRequest = new SendSMSVoucherRequest();
//			    		sendSMSVoucherRequest = (SendSMSVoucherRequest) voucherResponseMessage;
			    		sendSMSVoucherRequest.setId(purchaseVoucheRequest.getId());
			    		sendSMSVoucherRequest.setVoucherCode(result.getVoucherCode());
			    		asyncRabbitTemplate.convertAndSend(
				  				  "reflectoring.cars",
				  				  ROUTING_KEY,
				  				sendSMSVoucherRequest);
			    	}
			    	else {
				    	voucherResponseMessage.setIsSuccess(true);
				    	voucherResponseMessage.setVoucherCode(result.getVoucherCode());
						System.out.println("end-start: "+(end-start));
			    	}
	    		}
	    		catch(UnrecognizedPropertyException ex) {
	    			System.out.println("ex "+ex);
			    	voucherResponseMessage.setMessage("Error When Parse Data");
	    		}
	    	}
	    	else {
		    	voucherResponseMessage.setMessage("Error When Retrive Data");
	    	}
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			voucherResponseMessage.setMessage("Error When Parse JSON");
		}
		catch (HttpTimeoutException ex) {
			voucherResponseMessage.setMessage("Error When Parse JSON");
		}
		catch (Exception e) {
			System.out.println("e: "+e);
			// TODO: handle exception
			voucherResponseMessage.setMessage("Error");
		}
    	System.out.println(voucherResponseMessage.getMessage());
		return voucherResponseMessage;
    }


}
