package tk.johan.wsspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@ComponentScan//({"tk.johan.sprjpadata.services","tk.johan.sprjpadata.app"})
@EnableAutoConfiguration
@EnableJpaRepositories("tk.johan.wsspring.JPARepositories")
@SpringBootApplication
public class WsspringApplication {

    public static void main(String[] args) {
        SpringApplication.run(WsspringApplication.class, args);
    }


}

@RestController
class ErrorPageController implements ErrorController {

    private static final String PATH = "/error";

    @ResponseStatus(value= HttpStatus.NOT_FOUND, reason="Not Found")
    @RequestMapping(value = PATH)
    public String error() {
        return "This is a Error Message, likely unreachable";
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }
}