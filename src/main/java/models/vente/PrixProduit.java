package main.java.models.vente;

import java.sql.Timestamp;

import mg.dao.annotation.Column;
import mg.dao.annotation.Table;
import mg.daoherana.DaoHerana;

@Table(name = "Vente_PrixProduit")
public class PrixProduit extends DaoHerana {
  @Column(isPK = true, name = "idPrixProduit")
  private int id;

  @Column(name = "idProduit")
  private int produit;

  @Column
  private double prix;

  @Column(name = "date_ajout")
  private Timestamp date;

  public int getId() { return id; }

  public void setId(int id) { this.id = id; }

  public int getProduit() { return produit; }

  public void setProduit(int produit) { this.produit = produit; }

  public double getPrix() { return prix; }

  public void setPrix(double prix) { this.prix = prix; }

  public Timestamp getDate() { return date; }

  public void setDate(Timestamp date) { this.date = date; }
}
