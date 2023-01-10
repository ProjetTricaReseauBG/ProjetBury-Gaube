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

    public TournoisJpaEntity(String name,String jeux,int nbPart,int visible,long numerot){
        this.numerot = Long.parseLong("0");
        this.name=name;
        this.jeux=jeux;
        this.nbPart=nbPart;
        this.visible=visible;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numerot")
    private Long numerot;

    @Column(name = "nametournois")
    private String name;

    @Column(name = "jeux")
    private String jeux;

    @Column(name = "nbpart")
    private int nbPart;

    @Column(name = "visible")
    private int visible;


}
