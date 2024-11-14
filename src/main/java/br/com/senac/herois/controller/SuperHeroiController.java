package br.com.senac.herois.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.senac.herois.entity.Equipe;
import br.com.senac.herois.entity.SuperHeroi;
import br.com.senac.herois.repository.SuperHeroiRepository;


@RestController
public class SuperHeroiController {

    @Autowired
    private SuperHeroiRepository superHeroiRepository;

    @GetMapping("/superHeroi")
    public ResponseEntity<?> getDadosSuperHeroi() {
        return new ResponseEntity<>(superHeroiRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/superHeroi/{id}")
    public ResponseEntity<?> getSuperHeroiById(@PathVariable int id) {
        return new ResponseEntity<>(superHeroiRepository.findById(id), HttpStatus.OK);
    }
    
    @GetMapping("/superHeroi/apelido/{apelido}")
    public ResponseEntity<?> getSuperHeroiByApelido(@PathVariable String apelido) {
        return new ResponseEntity<>(superHeroiRepository.findByApelidoLike('%' + apelido + '%'), HttpStatus.OK);
    }

    @GetMapping("/superHeroi/poder/{poder}")
    public ResponseEntity<?> getSuperHeroiByPoder(@PathVariable String superPoder) {
        return new ResponseEntity<>(superHeroiRepository.findBySuperPoderLike('%' + superPoder + '%'), HttpStatus.OK);
    }

    @GetMapping("/superHeroi/equipe/{equipe}")
    public ResponseEntity<?> getSuperHeroiByEquipe(@PathVariable Equipe equipe) {
        return new ResponseEntity<>(superHeroiRepository.findByEquipe(equipe), HttpStatus.OK);
    }

    @PostMapping("/superHeroi")
    public ResponseEntity<?> salvarSuperHerois(@RequestBody SuperHeroi entity) {
        SuperHeroi superHeroi;
        try {
            superHeroi = superHeroiRepository.save(entity);
        } catch (Exception e) {
            return new ResponseEntity<>("Erro ao salvar o super Heroi", HttpStatus.BAD_REQUEST);        
        }

        return new ResponseEntity<>(superHeroi, HttpStatus.OK);
    }

    @PutMapping("/superHeroi/{id}")
    public ResponseEntity<?> atualizaSuperHeroi(@PathVariable int id, @RequestBody SuperHeroi entity) {
        
        Optional<SuperHeroi> superHeroiAtualizar = superHeroiRepository.findById(id);
        SuperHeroi sh;

        if (superHeroiAtualizar.isPresent()) {
            sh = superHeroiAtualizar.get();

            sh.setNome(entity.getNome());
            sh.setApelido(entity.getApelido());
            sh.setSuperPoder(entity.getSuperPoder());
            sh.setFraqueza(entity.getFraqueza());
            sh.setHistoriaOrigem(entity.getHistoriaOrigem());
            sh.setPrimeiraAparicao(entity.getPrimeiraAparicao());

            try {
                sh = superHeroiRepository.save(sh);
            } catch (Exception e) {
                return new ResponseEntity<>("Erro ao atualizar o super Heroi", HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>(sh, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Super Heroi não encontrado", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/superHeroi/{id}")
    public ResponseEntity<?> deletaSuperHeroi(@PathVariable int id) {
        
        Optional<SuperHeroi> superHeroiExcluir = superHeroiRepository.findById(id);
        SuperHeroi sh;

        if (superHeroiExcluir.isPresent()) {
            sh = superHeroiExcluir.get();

            try {
                superHeroiRepository.delete(sh);
            } catch (Exception e) {
                return new ResponseEntity<>("Erro ao deletar o super Heroi", HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>(sh, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Super Heroi não encontrado", HttpStatus.NOT_FOUND);
        }
    }
}
