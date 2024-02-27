package org.example.repository;

import org.example.model.Payment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PaymentRepository extends MongoRepository<Payment, String> {
}
