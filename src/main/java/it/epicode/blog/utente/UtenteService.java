package it.epicode.blog.utente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtenteService {
    @Autowired
    private UtenteRepository utenteRepository;
    public Utente save(Utente utente){
        return utenteRepository.save(utente);
    }
    public Utente update(Long id, Utente utente){
        if (!utenteRepository.existsById(id)){
            throw new IllegalArgumentException("Utente non trovato");
        } else {
            return utenteRepository.save(utente);
        }
    }
    public void delete(Long id){
        if (!utenteRepository.existsById(id)){
            throw new IllegalArgumentException("Utente non trovato");
        } else {
            utenteRepository.deleteById(id);
        }
    }
    public Utente findById(Long id){
        return utenteRepository.findById(id).orElseThrow();
    }
    public List<Utente> findAll(){
        return utenteRepository.findAll();
    }
}
