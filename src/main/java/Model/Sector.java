package Model;

import Excepcions.ExcepcionsPropies;

public class Sector {
    private int id;
    private String nom;
    private int idEscola; //Es la clau forana de escola
    private double latitud;
    private double longitud;
    private String aproximacio;
    private String popularitat;
    private String restriccions;

    public Sector(String nom, int idEscola, double latitud, double longitud, String aproximacio, String popularitat, String restriccions) {
        this.nom = nom;
        this.idEscola = idEscola;
        this.latitud = latitud;
        this.longitud = longitud;
        this.aproximacio = aproximacio;
        setPopularitat(popularitat);
        this.restriccions = restriccions;
    }

    public String getAproximacio() {
        return aproximacio;
    }

    public void setAproximacio(String aproximacio) {
        this.aproximacio = aproximacio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdEscola() {
        return idEscola;
    }

    public void setIdEscola(int idEscola) {
        this.idEscola = idEscola;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPopularitat() {
        return popularitat;
    }

    public void setPopularitat(String popularitat) {
        if (!popularitat.matches("^(baixa|mitjana|alta)$")) {
            throw new ExcepcionsPropies.DadaInvalidaException("Popularitat ha de ser: baixa, mitjana o alta.");
        }
        this.popularitat = popularitat;
    }

    public String getRestriccions() {
        return restriccions;
    }

    public void setRestriccions(String restriccions) {
        this.restriccions = restriccions;
    }
}