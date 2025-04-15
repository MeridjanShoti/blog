package it.epicode.blog.utente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/utenti")
public class UtenteController {
    @Autowired
    private UtenteService utenteService;
    @GetMapping
    public List<Utente> getAll(){
        return utenteService.findAll();
    }
    @GetMapping("/{id}")
    public Utente getById(@PathVariable Long id){
        return utenteService.findById(id);
    }
    @PostMapping
    public Utente save(@RequestBody Utente utente){
        return utenteService.save(utente);
    }
}
