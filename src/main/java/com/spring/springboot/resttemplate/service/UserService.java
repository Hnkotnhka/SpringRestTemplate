package com.spring.springboot.resttemplate.service;

import com.spring.springboot.resttemplate.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UserService {

    private static final String BASE_URL = "http://94.198.50.185:7081/api/users";
    
    private final RestTemplate restTemplate;

    @Autowired
    public UserService (RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getFullCode() {
        HttpHeaders headers = new HttpHeaders();

        ResponseEntity <String> response = restTemplate.exchange(
                BASE_URL,
                HttpMethod.GET,
                new HttpEntity<>(headers),
                String.class
        );

        List<String> cookies = response.getHeaders().get("Set-Cookie");
        String sessionId = cookies.get(0).split(";")[0];

        headers.set("Cookie", sessionId);
        headers.setContentType(MediaType.APPLICATION_JSON);

        User user = new User(3L,"James","Brown", (byte) 33);
        HttpEntity<User> postRequest = new HttpEntity<>(user, headers);
        ResponseEntity<String> postResponse = restTemplate.exchange(
                BASE_URL,
                HttpMethod.POST,
                postRequest,
                String.class
        );
        String codePart1 = postResponse.getBody();

        user.setName("Thomas");
        user.setLastName("Shelby");
        HttpEntity<User> putRequest = new HttpEntity<>(user, headers);
        ResponseEntity<String> putResponse = restTemplate.exchange(
                BASE_URL,
                HttpMethod.PUT,
                putRequest,
                String.class
        );
        String codePart2 = putResponse.getBody();

        HttpEntity<Void> deleteRequest = new HttpEntity<>(headers);
        ResponseEntity<String> deleteResponse = restTemplate.exchange(
                BASE_URL + "/3",
                HttpMethod.DELETE,
                deleteRequest,
                String.class
        );
        String codePart3 = deleteResponse.getBody();

        return codePart1 + codePart2 + codePart3;
    }
}
