package net.jaumebalmes.comptadors;

import net.jaumebalmes.comptadors.model.Client;
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
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

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
        String applicationURL = "http://localhost:8080/controlGas/";

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
        String applicationURL = "http://localhost:8080/controlGas/";

        String createComptadorURL = applicationURL + "Comptador/";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Comptador> request =
                new HttpEntity<Comptador>(comptador, headers);

        Comptador comptadorResponse = restTemplate.
                postForObject(createComptadorURL, request, Comptador.class);

        return comptadorResponse;
    }

    private Comptador actualitzaComptador(Comptador comptador) {

        String applicationURL = "http://localhost:8080/controlGas/";

        String createComptadorURL = applicationURL + "Comptador/";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Comptador> request =
                new HttpEntity<Comptador>(comptador, headers);

        HttpEntity<Comptador> response = restTemplate.exchange(createComptadorURL, HttpMethod.PUT, request, Comptador.class);
        Comptador comptadorResponse = response.getBody();

        return comptadorResponse;
    }

    private Client createClient(Client client) {
        String applicationURL = "http://localhost:8080/controlGas/";

        String createClientURL = applicationURL + "Client/";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Client> request =
                new HttpEntity<Client>(client, headers);

        Client clientResponse = restTemplate.
                postForObject(createClientURL, request, Client.class);

        return clientResponse;
    }



    @Bean
    public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
        return args -> {


            // create user
            Client client = new Client();
            client.setNom("Pep");
            client.setCognoms("Gaig Capdemunt");
            client.setDni("33456789P");
            Client clientRemote = createClient(client);
            log.info(clientRemote.toString());

            // create comptador
            Comptador comptador = new Comptador();
            comptador.setCodi("124F");
            comptador.setAdreca("Carrer Peu de la Creu 23, Manresa");
            comptador.setClient(clientRemote);

            Comptador comptadorRemote=createComptador(comptador);
            log.info(comptadorRemote.toString());

            // create lectura
            Lectura lectura = new Lectura();
            lectura.setData(new Date());
            lectura.setComptador(comptadorRemote);
            lectura.setValor(234567.34);
            Lectura lecturaRemote = createLectura(lectura);
            log.info(lecturaRemote.toString());

            //add ultima lectura to comptador
            comptadorRemote.setUltimaLecturaFacturada(lecturaRemote);
            comptadorRemote = actualitzaComptador(comptadorRemote);
            log.info(comptadorRemote.toString());
        };
    }
/*
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

*/
}
