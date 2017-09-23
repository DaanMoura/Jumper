package alura.daniel.elements;

import android.graphics.Canvas;
import android.graphics.Paint;

import alura.daniel.graphic.Cores;

/**
 * Created by daniel on 21/09/17.
 */

public class Passaro {

    private static final float X = 100;
    private static final float RAIO = 50;
    private static final Paint VERMELHO = Cores.getCorDoPassaro();
    private float altura;

    public Passaro() {
        this.altura = 100;
    }

    public void desenhaNo(Canvas canvas) {
        canvas.drawCircle(X, altura, RAIO, VERMELHO);
    }

    public void cai() {
        this.altura += 5;
    }

    public void pula() {
        this.altura -= 150;
    }
}
