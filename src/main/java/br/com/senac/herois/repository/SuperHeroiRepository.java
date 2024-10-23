package br.com.senac.herois.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.senac.herois.entity.Equipe;
import br.com.senac.herois.entity.SuperHeroi;

public interface SuperHeroiRepository extends JpaRepository<SuperHeroi, Integer> {

    ArrayList<SuperHeroi> findByApelidoLike(String apelido);

    ArrayList<SuperHeroi> findBySuperPoderLike(String superPoder);

    ArrayList<SuperHeroi> findByEquipe(Equipe equipe);
}
