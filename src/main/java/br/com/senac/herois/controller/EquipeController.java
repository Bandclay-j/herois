package br.com.senac.herois.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.senac.herois.repository.EquipeRepository;



@RestController
public class EquipeController {

    @Autowired
    private EquipeRepository equipeRepository;

    public EquipeRepository getEquipeRepository() {
        return equipeRepository;
    }

    public void setEquipeRepository(EquipeRepository equipeRepository) {
        this.equipeRepository = equipeRepository;
    }

    @GetMapping("/equipes")
    public ResponseEntity<?> getDadosEquipes() {
        return new ResponseEntity<>(equipeRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/equipes/{id}")
    public ResponseEntity<?> getDadosEquipe(@PathVariable int id) {
        return new ResponseEntity<>(equipeRepository.findById(id), HttpStatus.OK);
    }
    
}
