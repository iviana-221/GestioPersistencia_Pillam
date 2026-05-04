package Model;

import Excepcions.ExcepcionsPropies.DadaInvalidaException;
import Excepcions.ExcepcionsPropies;

public class Escalador {
    private int id; //Este id representa el id del sql.
    private String nom;
    private String alias;
    private int edat;
    private String nivellMaxim;

    public Escalador(String alias, int edat, String nivellMaxim, String nom) {
        this.alias = alias;
        setEdat(edat);
        setNivellMaxim(nivellMaxim);
        this.nom = nom;
        //Sin id ya que lo pone el mysql.
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public int getEdat() {
        return edat;
    }

    public void setEdat(int edat) {
        if(edat < 0 && edat <= 120 ){
            this.edat = edat;
        }else {
            throw new  DadaInvalidaException("L'edat ha de ser entre 0 i 110 anys.");
        }

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNivellMaxim() {
        return nivellMaxim;
    }
//Toca validar los datos
    public void setNivellMaxim(String nivellMaxim) {
        if (!nivellMaxim.matches("^([4-9][abc]?\\+?)$")) {
            throw new ExcepcionsPropies.DadaInvalidaException("El nivell '" + nivellMaxim + "' no segueix el format oficial.");
        }
        this.nivellMaxim = nivellMaxim;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

}
