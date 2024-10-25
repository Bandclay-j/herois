package br.com.senac.herois.entity;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "equipe")
public class Equipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String nome;

    @OneToMany(mappedBy = "equipe")
    private Set<SuperHeroi> superHerois;

    public Equipe() {
    }

    public Equipe(int id, String nome, Set<SuperHeroi> superHerois) {
        this.id = id;
        this.nome = nome;
        this.superHerois = superHerois;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<SuperHeroi> getSuperHerois() {
        return superHerois;
    }

    public void setSuperHerois(Set<SuperHeroi> superHerois) {
        this.superHerois = superHerois;
    }

}
