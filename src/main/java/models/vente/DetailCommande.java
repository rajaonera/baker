package main.java.models.vente;

import java.sql.Timestamp;

import mg.dao.annotation.Column;
import mg.dao.annotation.Table;
import mg.daoherana.DaoHerana;

@Table(name = "Vente_detailsCommande")
public class DetailCommande extends DaoHerana {
  @Column(isPK = true, name = "idDetailsCommande")
  private int id;

  @Column(name = "idCommande")
  private int commande;

  @Column(name = "idProduit")
  private int produit;

  @Column
  private double quantite;

  @Column(name = "date_ajout")
  private Timestamp date;

  public int getId() { return id; }

  public void setId(int id) { this.id = id; }

  public int getCommande() { return commande; }

  public void setCommande(int commande) { this.commande = commande; }

  public int getProduit() { return produit; }

  public void setProduit(int produit) { this.produit = produit; }

  public double getQuantite() { return quantite; }

  public void setQuantite(double quantite) { this.quantite = quantite; }

  public Timestamp getDate() { return date; }

  public void setDate(Timestamp date) { this.date = date; }
}
