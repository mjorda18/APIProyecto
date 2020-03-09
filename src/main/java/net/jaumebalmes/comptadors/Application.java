package net.jaumebalmes.comptadors;

import net.jaumebalmes.comptadors.model.Comptador;
import net.jaumebalmes.comptadors.model.Lectura;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import net.jaumebalmes.comptadors.controllers.FacturaController;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Application {
    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Autowired
    RestTemplate restTemplate;

    private Lectura createLectura(Lectura lectura) {
        String applicationURL = "http://localhost/controlGas/"

        String createLecturaURL = applicationURL + "Lectura/";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Lectura> request =
                new HttpEntity<Lectura>(lectura, headers);

        Lectura lecturaResponse = restTemplate.
                postForObject(createLecturaURL, request, Lectura.class);

        return lecturaResponse;
    }

    private Comptador createComptador(Comptador comptador) {
        String applicationURL = "http://localhost/controlGas/"

        String createComptadorURL = applicationURL + "Comptador/";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Comptador> request =
                new HttpEntity<Comptador>(comptador, headers);

        Comptador comptadorResponse = restTemplate.
                postForObject(createComptadorURL, request, Comptador.class);

        return comptadorResponse;
    }

    @Bean
    public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
        return args -> {

            // create lectura
            Lectura lectura = new Lectura();
            lectura.setData();
            lectura.setComptador();
            lectura.setValor();
            Lectura createdLectura = createLectura(lectura);
            log.info(createdLectura.toString());

        };
    }

    @Bean CommandLineRunner createTestScenario() {
        return (args) -> {

            FacturaController facturaController = new FacturaController();
            facturaController.calculaFactures();
        };
    }

    @Bean CommandLineRunner calculaFactures() {
        return (args) -> {
            FacturaController facturaController = new FacturaController();
            facturaController.calculaFactures();
        };
    }


}
