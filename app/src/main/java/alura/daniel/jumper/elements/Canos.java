package alura.daniel.jumper.elements;

import android.content.Context;
import android.graphics.Canvas;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import alura.daniel.jumper.engine.Som;
import alura.daniel.jumper.graphic.Tela;

/**
 * Created by daniel on 25/09/17.
 */

public class Canos {


    public static final int QUANTIDADE_DE_CANOS = 3;
    public static final int DISTANCIA_ENTRE_CANOS = 500;
    private Context context;
    private List<Cano> canos = new ArrayList<Cano>();
    private Tela tela;
    private Pontuacao pontuacao;
    private Som som;

    public Canos(Tela tela, Pontuacao pontuacao, Context context, Som som) {
        int posicaoInicial = 800;
        this.tela = tela;
        this.pontuacao = pontuacao;
        this.context = context;
        this.som = som;
        for (int i = 0; i < QUANTIDADE_DE_CANOS; i++) {
            posicaoInicial += DISTANCIA_ENTRE_CANOS;
            canos.add(new Cano(tela, posicaoInicial, context));
        }
    }

    public void desenhaNo(Canvas canvas) {
        for (Cano cano : canos) {
            cano.desenhaNo(canvas);
        }
    }

    public void move() {
        ListIterator <Cano> iterator = canos.listIterator();
        while (iterator.hasNext()) {
            Cano cano = (Cano) iterator.next();
            cano.move();
            if(cano.saiuDaTela()) {
                som.toca(Som.PONTO);
                pontuacao.aumenta();
                iterator.remove();
                Cano outroCano = new Cano(tela, getMaximo() + DISTANCIA_ENTRE_CANOS, context);
                iterator.add(outroCano);
            }
        }
    }

    public int getMaximo() {
        int maximo = 0;
        for (Cano cano: canos) {
            maximo = Math.max(cano.getPosicao(), maximo);
        }
        return maximo;
    }

    public boolean temColisaoCom(Passaro passaro) {
        for (Cano cano: canos) {
            if (cano.temColisaoHorizontalCom(passaro) &&
                    cano.temColisaoVerticalCom(passaro)) {
                return true;
            }
        }
        return false;
    }
}
