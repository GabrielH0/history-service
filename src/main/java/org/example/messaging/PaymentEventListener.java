package org.example.messaging;

public interface PaymentEventListener {

    void receiveMessage(String message);
}
