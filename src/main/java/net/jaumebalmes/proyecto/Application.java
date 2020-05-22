package net.jaumebalmes.proyecto;


import net.jaumebalmes.proyecto.model.Emp;
import net.jaumebalmes.proyecto.model.Service;
import net.jaumebalmes.proyecto.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
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

    private Service createService(Service service) {
        String applicationURL = "http://localhost:8080/controlGas/";

        String createLecturaURL = applicationURL + "Service/";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Service> request =
                new HttpEntity<Service>(service, headers);

        Service serviceResponse = restTemplate.
                postForObject(createLecturaURL, request, Service.class);

        return serviceResponse;
    }

    private Emp createEmp(Emp emp) {
        String applicationURL = "http://localhost:8080/controlGas/";

        String createEmpURL = applicationURL + "Emp/";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Emp> request =
                new HttpEntity<Emp>(emp, headers);

        Emp empResponse = restTemplate.
                postForObject(createEmpURL, request, Emp.class);

        return empResponse;
    }

    private Emp actualitzaComptador(Emp comptador) {

        String applicationURL = "http://localhost:8080/controlGas/";

        String createEmpURL = applicationURL + "Emp/";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Emp> request =
                new HttpEntity<Emp>(comptador, headers);

        HttpEntity<Emp> response = restTemplate.exchange(createEmpURL, HttpMethod.PUT, request, Emp.class);
        Emp empResponse = response.getBody();

        return empResponse;
    }

    private User createClient(User user) {
        String applicationURL = "http://localhost:8080/controlGas/";

        String createUserURL = applicationURL + "User/";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<User> request =
                new HttpEntity<User>(user, headers);

        User userResponse = restTemplate.
                postForObject(createUserURL, request, User.class);

        return userResponse;
    }
    private User actualitzaUser(User user) {

        String applicationURL = "http://localhost:8080/controlGas/";

        String createUserURL = applicationURL + "User/";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<User> request =
                new HttpEntity<User>(user, headers);

        HttpEntity<User> response = restTemplate.exchange(createUserURL, HttpMethod.PUT, request, User.class);
        User userResponse = response.getBody();

        return userResponse;
    }



    @Bean
    public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
        return args -> {


            // create user
            User user = new User();
            user.setName("Pep");
            user.setSurename("Gaig Capdemunt");
            user.setUserName("pepG");
            user.setPassword("pepegaca");
            user.setPhone("9090909");
            user.setEmail("pep@gmail.com");
            user.setAge(29);
            user.setInmune(true);
            user.setPoblation("Barcelona");
            User userRemote = createClient(user);
            log.info(userRemote.toString());

            // create emp
            Emp emp = new Emp();
            emp.setName("Sanitat");
            emp.setAdress("Carrer Peu de la Creu 23, Manresa");
            emp.setDescription("Sanitat General");
            emp.setEmail("sanit@gmail.com");
            emp.setNumber(5);

            Emp empRemote=createEmp(emp);
            log.info(empRemote.toString());

            // create Service
            Service service = new Service();
            service.setType("Gestio");
            service.setDescripcio("Ajuda en la gestio de medicaments");
            service.setEmpresa(empRemote);
            Service serviceRemote = createService(service);
            log.info(serviceRemote.toString());

        };
    }
}
