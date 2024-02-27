package org.example.messaging;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PaymentEventListenerImpl implements PaymentEventListener {

    @Override
    @SqsListener("${aws.sqs.queueName}")
    public void receiveMessage(String message) {
        log.info("Received message: {}", message);
    }
}
