package Model;
import java.time.LocalDateTime;
import java.util.*;


public class Via {

    protected String nom;
    protected String grau;
    protected String orientacio;
    protected String estat;
    protected LocalDateTime data;
    protected String tipusRoc;
    protected String restriccions;

    //Para que el SQL lo identifique seguramente esté mal
    protected int idSector;
    protected int idCreador;

    public Via(LocalDateTime data, String estat, String grau, int idCreador, int idSector, String orientacio, String nom, String restriccions, String tipusRoc) {
        this.data = data;
        this.estat = estat;
        this.grau = grau;
        this.idCreador = idCreador;
        this.idSector = idSector;
        this.orientacio = orientacio;
        this.nom = nom;
        this.restriccions = restriccions;
        this.tipusRoc = tipusRoc;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public String getEstat() {
        return estat;
    }

    public void setEstat(String estat) {
        this.estat = estat;
    }

    public String getGrau() {
        return grau;
    }

    public void setGrau(String grau) {
        this.grau = grau;
    }

    public int getIdCreador() {
        return idCreador;
    }

    public void setIdCreador(int idCreador) {
        this.idCreador = idCreador;
    }

    public int getIdSector() {
        return idSector;
    }

    public void setIdSector(int idSector) {
        this.idSector = idSector;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getOrientacio() {
        return orientacio;
    }

    public void setOrientacio(String orientacio) {
        this.orientacio = orientacio;
    }

    public String getRestriccions() {
        return restriccions;
    }

    public void setRestriccions(String restriccions) {
        this.restriccions = restriccions;
    }

    public String getTipusRoc() {
        return tipusRoc;
    }

    public void setTipusRoc(String tipusRoc) {
        this.tipusRoc = tipusRoc;
    }
}

