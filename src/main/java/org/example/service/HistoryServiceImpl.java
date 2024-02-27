package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.mapper.PaymentMapper;
import org.example.messaging.resource.PaymentResource;
import org.example.model.Payment;
import org.example.repository.PaymentRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HistoryServiceImpl implements HistoryService {

    private final PaymentRepository paymentRepository;
    private final PaymentMapper paymentMapper;

    @Override
    public void savePayment(PaymentResource paymentResource) {
        Payment payment = paymentMapper.map(paymentResource);
        paymentRepository.save(payment);
    }
}
