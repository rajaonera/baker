package main.java.models.stock;

import mg.dao.annotation.Column;
import mg.dao.annotation.Table;
import mg.daoherana.DaoHerana;

import java.sql.Timestamp;
import java.util.Map;

@Table(name = "Stock_Mouvement_produit")
public class MouvProduit extends DaoHerana {
  @Column(isPK = true, name = "idMouvement")
  private int id;

  @Column
  private String status;

  @Column
  private double quantite;

  @Column(name = "date_mouvement")
  private Timestamp date;

  @Column(name = "idProduit")
  private int produit;

  public int getId() { return id; }

  public void setId(int id) { this.id = id; }

  public String getStatus() { return status; }

  public void setStatus(String status) { this.status = status; }

  public double getQuantite() { return quantite; }

  public void setQuantite(double quantite) { this.quantite = quantite; }

  public Timestamp getDate() { return date; }

  public void setDate(Timestamp date) { this.date = date; }

  public int getProduit() { return produit; }

  public void setProduit(int produit) { this.produit = produit; }

  private static Map<String, Boolean> mapBaba = Map.of("entree", true, "sortie", false);

  public boolean getStatusBoolean() { return mapBaba.get(status); }
}
