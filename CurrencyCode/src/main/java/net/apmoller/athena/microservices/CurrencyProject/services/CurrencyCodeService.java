package net.apmoller.athena.microservices.CurrencyProject.services;

import net.apmoller.athena.microservices.CurrencyProject.dto.CurrencyCodeDto;
import net.apmoller.athena.microservices.CurrencyProject.exception.CodeViewException;
import net.apmoller.athena.microservices.CurrencyProject.repository.CurrencyCodeRepository;
import net.apmoller.athena.microservices.CurrencyProject.util.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CurrencyCodeService
{
    @Autowired
    private CurrencyCodeRepository currencyCodeRepository;

    //GET ALL CURRENCY CODE DATAS
    public Flux<CurrencyCodeDto> getAllCurrencyCodeDatas()
    {
        return currencyCodeRepository.findAll()
                .map(AppUtils::currencyCodeEntityToDto);
    }

    //INSERT CURRENCY CODE DATA
    public Mono<CurrencyCodeDto> saveCurrencyCodeData(Mono<CurrencyCodeDto> currencyCodeDtoMono)
    {
        return currencyCodeDtoMono.map(AppUtils::currencyCodeDtoToEntity)
                .flatMap(currencyCodeRepository::insert)
                .map(AppUtils::currencyCodeEntityToDto);

    }

    //GET CURRENCY CODE DATA BY ID
    public Mono<CurrencyCodeDto> getCurrencyCodeDataByCode(String id) throws CodeViewException
    {
        return currencyCodeRepository.findById(id).map(AppUtils::currencyCodeEntityToDto).switchIfEmpty(Mono.defer(()->Mono.error(new CodeViewException("Invalid ID Found"))));
    }

}
