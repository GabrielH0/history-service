package org.example.service;

import org.example.messaging.resource.PaymentResource;

public interface HistoryService {

    void savePayment(PaymentResource paymentResource);
}
