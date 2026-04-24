package Model;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;

public class ViesClasiques extends Via {
    private List<Llarg> llargs;

    public ViesClasiques(LocalDateTime data, String estat, String grau, int idCreador, int idSector, String orientacio, String nom, String restriccions, String tipusRoca) {
        super(data, estat, grau, idCreador, idSector, orientacio, nom, restriccions, tipusRoca);
        this.llargs = new ArrayList<>();
    }

    public void afegirLlarg(Llarg l) {
        this.llargs.add(l);
    }

    public List<Llarg> getLlargs() {
        return llargs;
    }
}