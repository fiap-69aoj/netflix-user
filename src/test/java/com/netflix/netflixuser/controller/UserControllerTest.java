package com.netflix.netflixuser.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * @author flaoliveira
 * @version : $<br/>
 * : $
 * @since 06/11/2019 15:18
 */
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class UserControllerTest {

    final String BASE_PATH = "http://localhost:8090/users";

    private RestTemplate restTemplate;

    private ObjectMapper MAPPER = new ObjectMapper();

    @Before
    public void setUp() throws Exception {
        restTemplate = new RestTemplate();
    }

    @Test
    public void testCreatePerson() throws JsonProcessingException {
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
        HttpEntity entity = new HttpEntity(headers);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("http://localhost:8090/users/teste");

        final ResponseEntity<String> exchange = restTemplate
                .exchange(builder.build().encode().toUri(), HttpMethod.GET, entity, String.class);

        Assert.assertNotNull(exchange.getBody());
    }



}