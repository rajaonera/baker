package main.java.models.stock;

import main.java.models.vente.Unite;
import mg.dao.annotation.Column;
import mg.dao.annotation.Table;
import mg.daoherana.DaoHerana;
import mg.daoherana.relations.BelongsTo;

import java.sql.Connection;

@Table(name = "Stock_matierePremiere")
@BelongsTo(model = Unite.class, parentKeyGetter = "getUnite", foreignKeyGetter = "getId", relationName = "unite")
public class MatierePremiere extends DaoHerana {
  @Column(isPK = true, name = "idMatierePremiere")
  private int id;

  @Column(name = "quantite")
  private double quantite;

  @Column(name = "nom")
  private String nom;

  @Column(name = "idUnite")
  private int unite;

  public int getId() { return id; }

  public void setId(int id) { this.id = id; }

  public int getUnite() { return unite; }

  public Unite getUnite(Connection connection) { return belongsTo("unite", connection); }

  public void setUnite(int unite) { this.unite = unite; }

  public double getQuantite() { return quantite; }

  public void setQuantite(double quantite) { this.quantite = quantite; }

  public String getNom() { return nom; }

  public void setNom(String nom) { this.nom = nom; }

}
