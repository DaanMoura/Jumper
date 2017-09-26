package alura.daniel.elements;

import android.graphics.Canvas;

import java.util.ArrayList;
import java.util.List;

import alura.daniel.graphic.Tela;

/**
 * Created by daniel on 25/09/17.
 */

public class Canos {


    public static final int QUANTIDADE_DE_CANOS = 5;
    public static final int DISTANCIA_ENTRE_CANOS = 250;
    private List<Cano> canos = new ArrayList<Cano>();

    public Canos(Tela tela) {
        int posicaoInicial = 800;

        for (int i = 0; i < QUANTIDADE_DE_CANOS; i++) {
            posicaoInicial += DISTANCIA_ENTRE_CANOS;
            canos.add(new Cano(tela, posicaoInicial));
        }
    }

    public void desenhaNo(Canvas canvas) {
        for (Cano cano : canos) {
            cano.desenhaNo(canvas);
        }
    }

    public void move() {
        for (Cano cano : canos) {
            cano.move();
        }
    }
}
