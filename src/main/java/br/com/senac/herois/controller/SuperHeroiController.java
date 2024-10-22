package br.com.senac.herois.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.senac.herois.repository.SuperHeroiRepository;


@RestController
public class SuperHeroiController {

    private SuperHeroiRepository superHeroiRepository;

    @GetMapping("/superHerois")
    public ResponseEntity<?> getDadosSuperHerois() {
        return new ResponseEntity<>(superHeroiRepository.findAll(), HttpStatus.OK);
    }
    
}
