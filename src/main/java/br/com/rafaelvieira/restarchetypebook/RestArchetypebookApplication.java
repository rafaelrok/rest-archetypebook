package br.com.rafaelvieira.restarchetypebook;

import br.com.rafaelvieira.restarchetypebook.config.FileStorageConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({
        FileStorageConfig.class
})
public class RestArchetypebookApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestArchetypebookApplication.class, args);
    }

}
