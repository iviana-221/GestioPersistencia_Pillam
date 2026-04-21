package Model;


public class ViaEsportiva extends Via {
    private int llargada;
    private String ancoratge;
    private String tipoRoca;

    public ViaEsportiva(String ancoratge, int llargada, String tipoRoca) {
        this.ancoratge = ancoratge;
        this.llargada = llargada;
        this.tipoRoca = tipoRoca;
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
        if(llargada < 30 && llargada > 5){
            this.llargada = llargada;
        }else {
            throw new IllegalArgumentException("La llaragda ha de ser entre 30 y 50 metres");
        }

    }

    public String getTipoRoca() {
        return tipoRoca;
    }

    public void setTipoRoca(String tipoRoca) {
        this.tipoRoca = tipoRoca;
    }
}
