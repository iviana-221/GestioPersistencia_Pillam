package Model;

public class Escola {
    private int id;
    private String nom;
    private String poblacio;
    private String aproximacio;
    private String popularitat;

    public Escola(String aproximacio, int id, String nom, String poblacio, String popularitat) {
        this.aproximacio = aproximacio;
        this.id = id;
        this.nom = nom;
        this.poblacio = poblacio;
        this.popularitat = popularitat;
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

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPoblacio() {
        return poblacio;
    }

    public void setPoblacio(String poblacio) {
        this.poblacio = poblacio;
    }

    public String getPopularitat() {
        return popularitat;
    }

    public void setPopularitat(String popularitat) {
        this.popularitat = popularitat;
    }
}
