package main.java.models.vente;

import mg.dao.annotation.Column;
import mg.dao.annotation.Table;
import mg.daoherana.DaoHerana;

@Table(name = "Vente_client")
public class Client extends DaoHerana {
  @Column(isPK = true, name = "idClient")
  private int id;

  @Column
  private String nom;

  @Column
  private String username;

  @Column
  private String password;

  public int getId() { return id; }

  public void setId(int id) { this.id = id; }

  public String getNom() { return nom; }

  public void setNom(String nom) { this.nom = nom; }

  public String getUsername() { return username; }

  public void setUsername(String username) { this.username = username; }

  public String getPassword() { return password; }

  public void setPassword(String password) { this.password = password; }
}
