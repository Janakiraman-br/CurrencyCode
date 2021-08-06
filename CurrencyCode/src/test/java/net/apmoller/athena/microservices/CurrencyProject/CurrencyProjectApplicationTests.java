package net.apmoller.athena.microservices.CurrencyProject;

//import com.fasterxml.jackson.databind.ObjectMapper;
//import net.apmoller.athena.microservices.CurrencyProject.dto.CurrencyCodeDto;
//import net.apmoller.athena.microservices.CurrencyProject.repository.CurrencyCodeRepository;
//import org.junit.Before;
//import org.junit.jupiter.api.Test;
//
//
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.web.context.WebApplicationContext;
//import reactor.core.publisher.Flux;
//
//import static org.junit.Assert.assertEquals;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//class CurrencyProjectApplicationTests {
//
//    private MockMvc mockMvc;
//
//    @Autowired
//    private WebApplicationContext context;
//
//    @Autowired
//    private ObjectMapper mapper;
//
//    @Autowired
//    private TestRestTemplate template;
//
//    @Before
//    public void setup() {
//        mockMvc = MockMvcBuilders.webAppContextSetup(context).apply(springSecurity()).build();
//    }
//
//    @Test
//    public void testSavePerson() throws Exception {
//
//        CurrencyCodeDto person = new CurrencyCodeDto("1","USD to IND",100,"100","2","JKR","JKR");
//        String jsonRequest = mapper.writeValueAsString(person);
//
//        MvcResult result = mockMvc
//                .perform(post("/currencycode").content(jsonRequest).contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk()).andReturn();
//
//        assertEquals(200, result.getResponse().getStatus());
//
//    }

//    @Test
//    public void testgetPersons() throws Exception {
//
//        MvcResult result = mockMvc.perform(get("/currencycode").contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk()).andReturn();
//
//        assertEquals(200, result.getResponse().getStatus());
//
//    }
//
//class CurrencyProjectApplicationTests {
//    @Test
//	public void getProductsTest(){
//		Flux<CurrencyCodeDto> productDtoFlux=Flux.just(new CurrencyCodeDto("1","USD to IND",100,"100","2","JKR","JKR",null,null));
//
//		when(service.getAllCurrencyCodeDatas()).thenReturn(productDtoFlux);
//
//		Flux<CurrencyCodeDto> responseBody = webTestClient.get().uri("/currencycode")
//				.exchange()
//				.expectStatus().isOk()
//				.returnResult(CurrencyCodeDto.class)
//				.getResponseBody();
//
//		StepVerifier.create(responseBody)
//				.expectSubscription()
//				.expectNext(new CurrencyCodeDto("1","USD to IND",100,"100","2","JKR","JKR",null,null))
//				.verifyComplete();
//
//	}
//	@Test
//	public void getProductTest(){
//		Mono<CurrencyCodeDto> productDtoMono=Mono.just(new CurrencyCodeDto("1","USD to IND",100,"100","2","JKR","JKR",null,null));
//		when(service.getCurrencyCodeDataByCode(any())).thenReturn(productDtoMono);
//
//		Flux<CurrencyCodeDto> responseBody = webTestClient.get().uri("/currencycode/1")
//				.exchange()
//				.expectStatus().isOk()
//				.returnResult(CurrencyCodeDto.class)
//				.getResponseBody();
//
//		StepVerifier.create(responseBody)
//				.expectSubscription()
//				.expectNextMatches(p->p.getCurrency_description().equals("USD to IND"))
//				.verifyComplete();
//	}
//}
