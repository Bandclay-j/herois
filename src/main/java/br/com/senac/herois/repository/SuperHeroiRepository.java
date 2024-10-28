package br.com.senac.herois.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.senac.herois.entity.Equipe;
import br.com.senac.herois.entity.SuperHeroi;

public interface SuperHeroiRepository extends JpaRepository<SuperHeroi, Integer> {

    List<SuperHeroi> findByApelidoLike(String apelido);

    List<SuperHeroi> findBySuperPoderLike(String superPoder);

    List<SuperHeroi> findByEquipe(Equipe equipe);
}
