package main.java.models.production;

import java.sql.Connection;

import mg.dao.annotation.Column;
import mg.daoherana.DaoHerana;
import mg.daoherana.relations.BelongsTo;
import mg.daoherana.relations.EagerLoad;

@BelongsTo(model = Recette.class, parentKeyGetter = "getRecette", foreignKeyGetter = "getId", relationName = "recette")
@BelongsTo(model = MatierePremiere.class, parentKeyGetter = "getMatierePremiere", foreignKeyGetter = "getId", relationName = "matierePremiere")
@EagerLoad({ "matierePremiere" })
public class RecetteLigne extends DaoHerana {
  @Column(name = "idRecetteLigne", isPK = true)
  private int id;

  @Column(name = "idRecette")
  private int recette;

  @Column(name = "idMatierePremiere")
  private int matierePremiere;

  @Column
  private double quantite;

  public int getId() { return id; }

  public void setId(int id) { this.id = id; }

  public int getRecette() { return recette; }

  public void setRecette(int recette) { this.recette = recette; }

  public int getMatierePremiere() { return matierePremiere; }

  public void setMatierePremiere(int matierePremiere) { this.matierePremiere = matierePremiere; }

  public double getQuantite() { return quantite; }

  public void setQuantite(double quantite) { this.quantite = quantite; }

  public MatierePremiere getMatierePremiere(Connection connection) { return belongsTo("matierePremiere", connection); }

  public Recette getRecette(Connection connection) { return belongsTo("recette", connection); }
}
