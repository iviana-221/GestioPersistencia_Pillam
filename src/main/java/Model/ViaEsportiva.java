package Model;

import Excepcions.ExcepcionsPropies;
import Excepcions.ExcepcionsPropies.MetresInvalidsException;


import java.time.LocalDateTime;

public class ViaEsportiva extends Via {
    private int llargada;
    private String ancoratge;
    private String tipoRoca;

    public ViaEsportiva(LocalDateTime data, String estat, String grau, int idCreador, int idSector, String orientacio, String nom, String restriccions, String tipusRoc, String ancoratge, int llargada, String tipoRoca) {
        super(data, estat, grau, idCreador, idSector, orientacio, nom, restriccions, tipusRoc);
        this.ancoratge = ancoratge;
        this.tipoRoca = tipoRoca;

        //Si el dato está mal avisamos antes de que se cree.
        setLlargada(llargada);
    }

    public String getAncoratge() {
        return ancoratge;
    }

    public void setAncoratge(String ancoratge) {
        this.ancoratge = ancoratge;
    }

    public int getLlargada() {
        return llargada;
    }

    public void setLlargada(int llargada) {
        if(llargada <= 30 && llargada >= 5){
            this.llargada = llargada;
        } else {
            throw new MetresInvalidsException(llargada);
        }

    }

    public String getTipoRoca() {
        return tipoRoca;
    }

    public void setTipoRoca(String tipoRoca) {
        this.tipoRoca = tipoRoca;
    }
}













