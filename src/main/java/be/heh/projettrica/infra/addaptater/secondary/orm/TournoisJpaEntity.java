package be.heh.projettrica.infra.addaptater.secondary.orm;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "tournois")
public class TournoisJpaEntity {
    //constructeur vide
    public TournoisJpaEntity(){

    }

    public TournoisJpaEntity(String name,String jeux,int nbPart,int visible,Date datet){
        this.name=name;
        this.jeux=jeux;
        this.nbPart=nbPart;
        this.visible=visible;
        this.date=datet;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "numerot")
    private Long nProd;

    @Column(name = "nametournois")
    private String name;

    @Column(name = "jeux")
    private String jeux;

    @Column(name = "nbpart")
    private int nbPart;

    @Column(name = "visible")
    private int visible;

    @Column(name = "datet")
    private Date date;

}
