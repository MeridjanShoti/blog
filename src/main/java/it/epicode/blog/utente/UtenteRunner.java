package it.epicode.blog.utente;

import it.epicode.blog.common.FakerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class UtenteRunner implements CommandLineRunner {
    @Autowired
    UtenteService utenteService;
    @Autowired
    UtenteRepository utenteRepository;
    @Autowired
    FakerConfig fakerConfig;
    @Override
    public void run(String... args) throws Exception {
        if(utenteRepository.count()==0){
            for (int i = 0; i < 10; i++) {
                Utente utente = new Utente();
                utente.setNome(fakerConfig.faker().name().firstName());
                utente.setCognome(fakerConfig.faker().name().lastName());
                utente.setEmail(fakerConfig.faker().internet().emailAddress());
                utente.setDataDiNascita(fakerConfig.faker().date().birthday().toString());
                utenteRepository.save(utente);
            }
        }

    }
}
