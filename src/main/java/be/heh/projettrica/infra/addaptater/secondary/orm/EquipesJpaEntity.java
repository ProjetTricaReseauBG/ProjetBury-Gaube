package be.heh.projettrica.infra.addaptater.secondary.orm;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "equipes")
public class EquipesJpaEntity {
    //constructeur vide
    public EquipesJpaEntity(){

    }

    public EquipesJpaEntity(String name,String jeux,int nbplayer,int visible,int nbwin, long idequipe){
        this.name=name;
        this.jeux=jeux;
        this.nbplayer=nbplayer;
        this.visible=visible;
        this.nbwin=nbwin;
        this.idequipe = Long.parseLong("0");
    }


    @Column(name = "nameequipes")
    private String name;

    @Column(name = "jeux")
    private String jeux;

    @Column(name = "nbplayer")
    private int nbplayer;

    @Column(name = "visible")
    private int visible;

    @Column(name = "nbwin")
    private int nbwin;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idequipe")
    private long idequipe;

}
