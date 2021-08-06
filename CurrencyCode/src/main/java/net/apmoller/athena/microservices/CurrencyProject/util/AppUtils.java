package net.apmoller.athena.microservices.CurrencyProject.util;

import net.apmoller.athena.microservices.CurrencyProject.dto.CurrencyCodeDto;
import net.apmoller.athena.microservices.CurrencyProject.models.CurrencyCode;
import org.springframework.beans.BeanUtils;

public class AppUtils
{
    public static CurrencyCodeDto currencyCodeEntityToDto(CurrencyCode currencyCode)
    {
        CurrencyCodeDto currencyCodeDto=new CurrencyCodeDto();
        BeanUtils.copyProperties(currencyCode,currencyCodeDto); // Source,Destination ,Copying product components to productDto
        return currencyCodeDto;
    }
    public static CurrencyCode currencyCodeDtoToEntity(CurrencyCodeDto currencyCodeDto)
    {
        CurrencyCode currencyCode = new CurrencyCode();
        BeanUtils.copyProperties(currencyCodeDto,currencyCode);
        return currencyCode;
    }

}

