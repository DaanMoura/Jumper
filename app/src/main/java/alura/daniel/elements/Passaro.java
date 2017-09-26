package alura.daniel.elements;

import android.graphics.Canvas;
import android.graphics.Paint;

import alura.daniel.graphic.Cores;
import alura.daniel.graphic.Tela;
import alura.daniel.jumper.engine.Game;

/**
 * Created by daniel on 21/09/17.
 */

public class Passaro {

    private static final float X = 100;
    private static final float RAIO = 50;
    private static final Paint VERMELHO = Cores.getCorDoPassaro();
    private float altura;
    private float velocidade = 1;
    private final Tela tela;

    public Passaro(Tela tela) {
        this.tela = tela;
        this.altura = tela.getAltura()/2;
    }

    public void desenhaNo(Canvas canvas) {
        canvas.drawCircle(X, altura, RAIO, VERMELHO);
    }

    public void cai() {
        boolean chegouNoChao = altura + RAIO > tela.getAltura();

        if(!chegouNoChao) {
            this.altura += 5*velocidade;
        }

    }

    public void pula() {
        if(altura > RAIO) {
            this.altura -= 350;
            setVelocidade(1);
        }
    }

    public float getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(float velocidade) {
        this.velocidade = velocidade;
    }
}
