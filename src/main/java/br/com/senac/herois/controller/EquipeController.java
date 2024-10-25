package br.com.senac.herois.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.senac.herois.repository.EquipeRepository;


@RestController
public class EquipeController {

    private EquipeRepository equipeRepository;

    public EquipeRepository getEquipeRepository() {
        return equipeRepository;
    }

    public void setEquipeRepository(EquipeRepository equipeRepository) {
        this.equipeRepository = equipeRepository;
    }

    @GetMapping("/equipe")
    public ResponseEntity<?> getEquipes() {
        return new ResponseEntity<>(equipeRepository.findAll(), HttpStatus.OK);
    }
    
}
