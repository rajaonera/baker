package main.java.models.production;

import java.sql.Connection;
import java.util.ArrayList;

import main.java.models.vente.Produit;
import mg.dao.annotation.Column;
import mg.dao.annotation.Table;
import mg.daoherana.DaoHerana;
import mg.daoherana.relations.BelongsTo;
import mg.daoherana.relations.EagerLoad;
import mg.daoherana.relations.HasMany;

@Table(name = "Prod_Recette")
@BelongsTo(model = Produit.class, parentKeyGetter = "getProduit", foreignKeyGetter = "getId", relationName = "produit")
@HasMany(model = RecetteLigne.class, parentKeyGetter = "getId", foreignKeyGetter = "getRecette", relationName = "recetteLigne")
@EagerLoad({ "recetteLigne" })
public class Recette extends DaoHerana {
  @Column(name = "idRecette", isPK = true)
  private int id;

  @Column(name = "idProduit")
  private int produit;

  @Column
  private String nom;

  @Column
  private int nbrPersonne;

  public int getId() { return id; }

  public void setId(int id) { this.id = id; }

  public int getProduit() { return produit; }

  public void setProduit(int produit) { this.produit = produit; }

  public String getNom() { return nom; }

  public void setNom(String nom) { this.nom = nom; }

  public int getNbrPersonne() { return nbrPersonne; }

  public void setNbrPersonne(int nbrPersonne) { this.nbrPersonne = nbrPersonne; }

  public Produit getProduit(Connection connection) { return belongsTo("produit", connection); }

  public ArrayList<RecetteLigne> getRecetteLigne(Connection connection) { return hasMany("recetteLigne", connection); }
}
