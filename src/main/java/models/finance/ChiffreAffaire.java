package main.java.models.finance;

import mg.dao.annotation.Column;
import mg.dao.annotation.Table;
import mg.daoherana.DaoHerana;

@Table(name = "ChiffresAffaires")
public class ChiffreAffaire extends DaoHerana {
  @Column(name = "idChiffresAffaires")
  private int id;

}
