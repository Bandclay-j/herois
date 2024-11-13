package br.com.senac.herois.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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
import br.com.senac.herois.repository.EquipeRepository;
import br.com.senac.herois.repository.SuperHeroiRepository;




@RestController
public class EquipeController {

    @Autowired
    private EquipeRepository equipeRepository;

    @Autowired
    private SuperHeroiRepository superHeroiRepository;

    @GetMapping("/equipes")
    public ResponseEntity<?> getDadosEquipes() {
        return new ResponseEntity<>(equipeRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/equipes/{id}")
    public ResponseEntity<?> getDadosEquipe(@PathVariable int id) {
        return new ResponseEntity<>(equipeRepository.findById(id), HttpStatus.OK);
    }
    
    @PostMapping("/equipes")
    public ResponseEntity<?> salvaEquipe(@RequestBody Equipe entity) {
        Equipe equipeSalva;
        try {
            equipeSalva = equipeRepository.save(entity);
        } catch (Exception e) {
            return new ResponseEntity<String>("Erro ao salvar a equipe", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Equipe>(equipeSalva, HttpStatus.OK);
    }

    @PutMapping("equipes/{id}")
    public ResponseEntity<?> atualizaEquipe(@PathVariable int id, @RequestBody Equipe entity) {
        Optional<Equipe> equipeAtualizar = equipeRepository.findById(id);
        Equipe e = null;
        if (equipeAtualizar.isPresent()) {
            e = equipeAtualizar.get();
            e.setNome(entity.getNome());
            
            try {
                e = equipeRepository.save(e);
            } catch (Exception s) {
                return new ResponseEntity<String>("Erro ao atualizar a equipe", HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<Equipe>(e, HttpStatus.OK); 
        } else {
            return new ResponseEntity<String>("Equipe não encontrada", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/equipes/{id}")
    public ResponseEntity<String> deletaEquipe(@PathVariable int id) {
        Optional<Equipe> equipeExcluir = equipeRepository.findById(id);

        if (equipeExcluir.isPresent()) {
            try {
                // Excluir os superHerois associados antes de excluir a Equipe
                superHeroiRepository.findByEquipe(equipeExcluir.get()).forEach(superHeroi -> superHeroiRepository.delete(superHeroi));

                // Agora, exclua a equipe
                equipeRepository.delete(equipeExcluir.get());
                return new ResponseEntity<>("Equipe excluída com sucesso", HttpStatus.NO_CONTENT);
            } catch (Exception e) {
                return new ResponseEntity<>("Erro ao excluir a equipe", HttpStatus.BAD_REQUEST);
            }

        } else {
            return new ResponseEntity<>("Equipe não encontrada", HttpStatus.NOT_FOUND);
        }
    }
}
