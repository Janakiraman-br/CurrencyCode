package net.apmoller.athena.microservices.CurrencyProject.controller;

import net.apmoller.athena.microservices.CurrencyProject.dto.CurrencyCodeDto;
import net.apmoller.athena.microservices.CurrencyProject.exception.CodeViewException;
import net.apmoller.athena.microservices.CurrencyProject.services.CurrencyCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/currencycode")
public class CurrencyCodeController
{
    @Autowired
    private CurrencyCodeService currencyCodeService;

    //GET ALL CURRENCY CODE DATA
    @GetMapping
    public Flux<CurrencyCodeDto> getAllCodeDatas()
    {
        return currencyCodeService.getAllCurrencyCodeDatas();
    }

    //INSERT CURRENCY CODE DATA
    @PostMapping
    public Mono<CurrencyCodeDto> saveCodeData(@RequestBody Mono<CurrencyCodeDto> currencyCodeDtoMono)
    {
        return currencyCodeService.saveCurrencyCodeData(currencyCodeDtoMono);
    }

    //GET CURRENCY CODE DATA BY ID
    @GetMapping("/{id}")
    public Mono<CurrencyCodeDto> getCodeDataByCode(@PathVariable String id) throws CodeViewException
    {
        return currencyCodeService.getCurrencyCodeDataByCode(id);
    }
}
