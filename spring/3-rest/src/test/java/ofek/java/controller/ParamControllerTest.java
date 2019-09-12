package ofek.java.controller;

import ofek.java.DemoApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {DemoApplication.class, RestTemplate.class}, webEnvironment = WebEnvironment.RANDOM_PORT)
public class ParamControllerTest {
    @LocalServerPort
    private int randomServerPort;

    private String BASE_URL;

    @Before
    public void setup() {
        BASE_URL = "http://localhost:" + randomServerPort + "/";
    }

    @Autowired
    RestTemplate restTemplate;

    @Test
    public void testHello() {
        String url = BASE_URL + "greeting";
        String responseBody = restTemplate.getForObject(url, String.class);
        assertEquals(responseBody, "Hello!");
    }

    @Test
    public void testHelloUserPathVariable() {
        String url = BASE_URL + "greeting/{name}";

        String responseBody = restTemplate.exchange(url,
                HttpMethod.GET,
                null,
                String.class,
                "user"
        ).getBody();
        assertEquals(responseBody, "Hello with PathVariable: user");
    }

    @Test
    public void testHelloUserRequestParam() {
        String url = BASE_URL + "greetingParam";

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("name", "user");

        String responseBody = restTemplate.exchange(builder.toUriString(),
                HttpMethod.GET,
                null,
                String.class,
                "user"
        ).getBody();
        assertEquals(responseBody, "Hello with RequestParam: user");
    }

    @Test
    public void testHelloUserWithRequestHeader() {
        String url = BASE_URL + "greetingHeader";

        HttpHeaders headers = new HttpHeaders();
        headers.set("name", "user");
        HttpEntity<?> entity = new HttpEntity<>(headers);

        String responseBody = restTemplate.exchange(url,
                HttpMethod.GET,
                entity,
                String.class
        ).getBody();
        assertEquals(responseBody, "Hello with RequestHeader: user");
    }
}
