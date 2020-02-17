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
        return "Hello " + name + "!";
    }

    @GetMapping("/greetingWithParam")
    public String helloUserRequestParam(@RequestParam String name) {
        return "Hello " + name + "!";
    }

    @GetMapping("/greetingWithHeader")
    public String helloUserWithRequestHeader(@RequestHeader("name") String name) {
        return "Hello " + name + "!";
    }
}
