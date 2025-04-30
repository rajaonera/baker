package main.java.models.vente;

import java.sql.Connection;
import java.util.ArrayList;

import mg.dao.annotation.Column;
import mg.dao.annotation.Table;
import mg.daoherana.DaoHerana;

@Table(name = "Vente_Unite")
public class Unite extends DaoHerana {
  @Column(isPK = true, name = "idUnite")
  private int id;

  public int getId() { return id; }

  public void setId(int id) { this.id = id; }

  @Column
  private String nom;

  public String getNom() { return nom; }

  public void setNom(String nom) { this.nom = nom; }

  @SuppressWarnings("unchecked")
  public Unite[] getAll(Connection connection) {
    ArrayList<Unite> unites = new ArrayList<>();
    var list = read("", connection);
    for (Object object : list)
      unites.add((Unite) object);
    return unites.toArray(new Unite[] {});
  }
}
