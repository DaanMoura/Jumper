package alura.daniel.jumper.engine;

import alura.daniel.jumper.elements.Canos;
import alura.daniel.jumper.elements.Passaro;

public class VerficadorDeColisoes {
    private final Passaro passaro;
    private final Canos canos;

    public VerficadorDeColisoes(Passaro passaro, Canos canos) {
        this.passaro = passaro;
        this.canos = canos;
    }

    public boolean temColisao() {
        return canos.temColisaoCom(passaro);
    }
}
