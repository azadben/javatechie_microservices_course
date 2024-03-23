package com.javatechie.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.javatechie.config.MessagingConfig;
import com.javatechie.dto.PaymentRequest;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class PaytmClientApp2 {

    @RabbitListener(queues = MessagingConfig.QUEUE)
    public void processPaymentRequest(PaymentRequest request) {
        try {
            System.out.println("consumer (2) consumes : "+new ObjectMapper().writeValueAsString(request));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
