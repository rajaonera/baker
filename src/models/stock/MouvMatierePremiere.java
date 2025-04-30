package models.stock;

import main.java.models.stock.MatierePremiere;
import mg.dao.annotation.Column;
import mg.dao.annotation.Table;
import mg.daoherana.DaoHerana;
import mg.daoherana.relations.BelongsTo;
import mg.daoherana.relations.EagerLoad;

import java.sql.Connection;
import java.sql.Timestamp;

@Table(name = "Stock_Mouvement_matierePremiere")
@BelongsTo(model = MatierePremiere.class, parentKeyGetter = "getMatierePremiere", foreignKeyGetter = "getId", relationName = "matierePremiere")
@EagerLoad({"matierePremiere"})
public class MouvMatierePremiere extends DaoHerana {

  @Column(isPK = true, name = "idMouvement")
  private int id;

  @Column(name = "status")
  private String status;

  @Column
  private double quantite;

  @Column(name = "date_mouvement")
  private Timestamp date;

  @Column(name = "idMatierePremiere")
  private int matierePremiere;

  public int getId() { return id; }

  public void setId(int id) { this.id = id; }

  public String getStatus() { return status; }

  public void setStatus(String status) { this.status = status; }

  public double getQuantite() { return quantite; }

  public void setQuantite(double quantite) { this.quantite = quantite; }

  public Timestamp getDate() { return date; }

  public void setDate(Timestamp date) { this.date = date; }

  public int getMatierePremiere() { return matierePremiere; }

  public void setMatierePremiere(int matierePremiere) { this.matierePremiere = matierePremiere; }

  public MatierePremiere getMatierePremiere(Connection connection) {
    return belongsTo("matierePremiere", connection);
  }
}
