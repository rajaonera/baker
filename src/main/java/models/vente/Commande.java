package main.java.models.vente;

import mg.daoherana.DaoHerana;
import mg.dao.annotation.Column;
import mg.dao.annotation.Table;

@Table(name = "Vente_commande")
public class Commande extends DaoHerana {
  @Column(isPK = true, name = "idCommande")
  private int id;

  @Column(name = "idClient")
  private int client;

  @Column(name = "isSaled")
  private boolean saled;

  public int getId() { return id; }

  public void setId(int id) { this.id = id; }

  public int getClient() { return client; }

  public void setClient(int client) { this.client = client; }

  public boolean isSaled() { return saled; }

  public void setSaled(boolean saled) { this.saled = saled; }

}
