package net.jaumebalmes.comptadors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import net.jaumebalmes.comptadors.controllers.FacturaController;

@SpringBootApplication
public class Application {
    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Bean
    public CommandLineRunner demo() {
        return (args) -> {
            FacturaController facturaController = new FacturaController();
            facturaController.calculaFactures();
        };
    }

}
