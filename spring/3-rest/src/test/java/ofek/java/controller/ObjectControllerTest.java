package ofek.java.controller;

import ofek.java.DemoApplication;
import ofek.java.entity.Employee;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {DemoApplication.class, RestTemplate.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ObjectControllerTest {
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
    public void testAllEmployees() {
        List<Employee> expected = Arrays.asList(
                new Employee(1, "A"),
                new Employee(2, "B")
        );

        String url = BASE_URL + "employees";
        ResponseEntity<List<Employee>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Employee>>() {
                }
        );
        List<Employee> employees = response.getBody();

        assertThat(employees).isEqualTo(expected);
    }
}
