package org.IntegrateService.PurchaseWithThirdParty.Configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
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
    public Queue queue() {
        return new Queue("request");
    }
    
    @Bean
    public Queue replyQueue() {
        return new Queue("my.reply.queue");
    }

    @Bean
    public RabbitTemplate asyncRabbitTemplate(ConnectionFactory connectionFactory){
    	System.out.println(connectionFactory.getHost());
    	System.out.println(connectionFactory.getPort());
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jackson2MessageConverter());
        return rabbitTemplate;
    }

    @Bean
    public Binding binding(DirectExchange directExchange,
                           Queue queue) {
        return BindingBuilder.bind(queue)
                .to(directExchange)
                .with("old.car");
    }
    
}
