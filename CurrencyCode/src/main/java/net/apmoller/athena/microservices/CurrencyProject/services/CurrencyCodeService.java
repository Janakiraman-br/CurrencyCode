package net.apmoller.athena.microservices.CurrencyProject.services;

import net.apmoller.athena.microservices.CurrencyProject.dto.CurrencyCodeDto;
import net.apmoller.athena.microservices.CurrencyProject.dto.CurrencyConversionDto;
import net.apmoller.athena.microservices.CurrencyProject.exception.CodeViewException;
import net.apmoller.athena.microservices.CurrencyProject.repository.CurrencyCodeRepository;
import net.apmoller.athena.microservices.CurrencyProject.util.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CurrencyCodeService
{
    @Autowired
    private CurrencyCodeRepository currencyCodeRepository;

    @Autowired
    WebClient.Builder webClientBuilder;


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
/*
    public Mono<Integer> getCalculatedAmount(Mono<Integer> count, String key)
    {
        Mono<CurrencyCodeDto> currencyCodeDto ;
        CurrencyCodeDto currencyCodeDto1;

       Mono<CurrencyConversionDto> currencyConversionDtoMono = webClientBuilder.build().get()
                .uri("http://localhost:8082/currencyconversion/conversionkey/"+key)
                .retrieve().bodyToMono(CurrencyConversionDto.class);

       Mono<Integer> factor = currencyConversionDtoMono.map(e->e.getConversionFactor());

       return factor*count;
       }
*/
/*
        Mono<CurrencyCodeDto> cast = currencyCodeDto.map(e -> e.setConversionFactor(currencyConversionDtoMono.map(a -> a.getConversionFactor()))).cast(CurrencyCodeDto.class);
 */



          /*
    return currencyConversionDtoMono.flatMap(a->webClientBuilder.build().get()

            .uri("http://localhost:8083/commodity/commoditygroupcode/"+a.getCommodityGroupCode())
        .retrieve().bodyToFlux(RsCommodityDto.class))
        .switchIfEmpty(Mono.defer(()-> Mono.error(new InvalidCodeException("Invalid Group Code"))));
*/

}
