package Model;

import Excepcions.ExcepcionsPropies;

public class Llarg {
    private int numero;
    private int metres;
    private String grau;

    public Llarg(int numero, int metres, String grau) {
        this.numero = numero;
        setMetres(metres);
        setGrau(grau);
    }

    public void setMetres(int metres) {
        if (metres < 15 || metres > 30) {
            throw new ExcepcionsPropies.MetresInvalidsException(metres);
        }
        this.metres = metres;
    }

    public void setGrau(String grau) {
        if (!grau.matches("^([4-9][abc]?\\+?)$")) {
            throw new ExcepcionsPropies.DadaInvalidaException("El grau del llarg '" + grau + "' no és vàlid.");
        }
        this.grau = grau;
    }

    public int getNumero() { return numero; }
    public int getMetres() { return metres; }
    public String getGrau() { return grau; }
}