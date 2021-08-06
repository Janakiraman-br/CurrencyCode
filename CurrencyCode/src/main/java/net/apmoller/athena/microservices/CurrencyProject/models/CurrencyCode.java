package net.apmoller.athena.microservices.CurrencyProject.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@AllArgsConstructor

@NoArgsConstructor
@Data
@Document(collection = "currencycode")

public class CurrencyCode
{
    @Id
    private String currencyCodeId;
    private String fromCurrency;
    private int currencyCount;
    private String conversionKey;
    private String roundingOffPoint;
    private String createdBy;
    private Date createdDate;

}
