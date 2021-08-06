package net.apmoller.athena.microservices.CurrencyProject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CurrencyCodeDto
{
    private String currencyCodeId;
    //    private String fromCurrency;
    private int currencyCount;
    private String conversionKey;
    //    private String roundingOffPoint;
//    private String createdBy;
//    private Date createdDate;
    private double total;
    private int conversionFactor;
}