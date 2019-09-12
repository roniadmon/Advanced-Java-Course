package ofek.java.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class ParamController {

    @GetMapping("/greeting")
    public String hello() {
        return "Hello!";
    }

    @GetMapping("/greeting/{name}")
    public String helloUserPathVariable(@PathVariable String name) {
        return "Hello with PathVariable: " + name;
    }

    @GetMapping("/greetingParam")
    public String helloUserRequestParam(@RequestParam String name) {
        return "Hello with RequestParam: " + name;
    }

    @GetMapping("/greetingHeader")
    public String helloUserWithRequestHeader(@RequestHeader("name") String name) {
        return "Hello with RequestHeader: " + name;
    }
}
