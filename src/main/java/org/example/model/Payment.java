package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Data
@Document
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

    @Id
    private String id;
    private String externalId;
    private String amount;
    private Long userId;
    private Instant paymentDate;
    private String status;
}
