package org.IntegrateService.PurchasePrepaidDataSIM.Configuration;

import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.AsyncRabbitTemplate;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.DirectMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.MessageListenerContainer;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AMQPConfig {
    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange("reflectoring.cars");
    }

    @Bean
    public MessageConverter jackson2MessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
  @Bean
  public RabbitTemplate asyncRabbitTemplate(ConnectionFactory connectionFactory){
	    RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
	    rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
	    rabbitTemplate.setReplyAddress(replyQueue().getName());
	    return rabbitTemplate;
  }
//    
//    @Bean
//    public AsyncRabbitTemplate asyncRabbitTemplate(RabbitTemplate rabbitTemplate){
//        return new AsyncRabbitTemplate(rabbitTemplate);
//    }
  @Bean
  public SimpleMessageListenerContainer replyListenerContainer(ConnectionFactory connectionFactory) {
      SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
      container.setReceiveTimeout(3000);
      container.setConnectionFactory(connectionFactory);
      container.setQueueNames(replyQueue().getName());
      container.setMessageListener(asyncRabbitTemplate(connectionFactory));
      return container;
  }

    @Bean
    public Queue replyQueue() {
        return new Queue("my.reply.queue");
    }
    
    @Bean
    public Queue response(){
        return new Queue("response");
    }
    
    @Bean
    public Queue responsePhone(){
        return new Queue("response.phone");
    }

    @Bean
    public Binding binding(DirectExchange directExchange,
                           Queue responsePhone) {
        return BindingBuilder.bind(responsePhone)
                .to(directExchange)
                .with("response.phone");
    }

	
}
