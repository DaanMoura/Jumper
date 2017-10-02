package alura.daniel.jumper.elements;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

import alura.daniel.jumper.engine.Som;
import alura.daniel.jumper.graphic.Cores;
import alura.daniel.jumper.graphic.Tela;
import alura.daniel.jumper.R;

/**
 * Created by daniel on 21/09/17.
 */

public class Passaro {

    public static final float X = 100;
    public static final int RAIO = 50;
    private static final Paint VERMELHO = Cores.getCorDoPassaro();
    private Bitmap passaro;
    private float altura;
    private float velocidade = 1;
    private final Tela tela;
    private Som som;

    public Passaro(Tela tela, Context context, Som som) {
        this.tela = tela;
        this.altura = tela.getAltura()/2;
        this.som = som;
        Bitmap bp = BitmapFactory.decodeResource(context.getResources(), R.drawable.passaro);
        this.passaro = Bitmap.createScaledBitmap(bp, RAIO*2, RAIO*2, false);
    }

    public void desenhaNo(Canvas canvas) {
        canvas.drawBitmap(passaro, X - RAIO, altura - RAIO, null);
//        canvas.drawCircle(X, altura, RAIO, VERMELHO);
    }

    public void cai() {
        boolean chegouNoChao = altura + RAIO > tela.getAltura();

        if(!chegouNoChao) {
            this.altura += 5*velocidade;
        }

    }

    public void pula() {
        if(altura > RAIO) {
            som.toca(Som.PULO);
            this.altura -= 310;
            setVelocidade(1);
        }
    }

    public float getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(float velocidade) {
        this.velocidade = velocidade;
    }

    public float getAltura() {
        return altura;
    }

}
