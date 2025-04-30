package main.java.models.vente;

import mg.daoherana.DaoHerana;
import mg.daoherana.relations.HasMany;

import java.sql.Connection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import main.java.models.production.Recette;
import mg.dao.annotation.Column;
import mg.dao.annotation.Table;

@Table(name = "Vente_Produit")
@HasMany(model = Recette.class, parentKeyGetter = "getId", foreignKeyGetter = "getProduit", relationName = "recette")
public class Produit extends DaoHerana {
  @Column(isPK = true, name = "idProduit")
  private int id;

  @Column
  private String nom;

  public int getId() { return id; }

  public void setId(int id) { this.id = id; }

  public String getNom() { return nom; }

  public void setNom(String nom) { this.nom = nom; }

  public List<Recette> getRecettes(Connection connection) { return hasMany("recette", connection); }

  public Optional<Recette> getRecette(String nomRecette, Connection connection) {
    return getRecettes(connection).stream().filter((e) -> e.getNom().equals(nomRecette)).findAny();
  }
}