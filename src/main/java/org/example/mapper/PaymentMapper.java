package org.example.mapper;

import org.example.messaging.resource.PaymentResource;
import org.example.model.Payment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PaymentMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "externalId", source = "paymentId")
    @Mapping(target = "status", source = "paymentStatus")
    Payment map(PaymentResource paymentResource);
}
