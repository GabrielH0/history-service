package org.example.messaging;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.messaging.resource.PaymentResource;
import org.example.service.HistoryService;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class PaymentEventListenerImpl implements PaymentEventListener {

    private final HistoryService historyService;

    @Override
    @SqsListener("${aws.sqs.queueName}")
    public void receiveMessage(String message) {
        try {
            PaymentResource paymentResource = new ObjectMapper()
                    .registerModule(new JavaTimeModule())
                    .readValue(message, PaymentResource.class);
            historyService.savePayment(paymentResource);
        } catch (Exception e) {
            log.error("Failed to parse message: {}", message, e);
        }
    }
}
