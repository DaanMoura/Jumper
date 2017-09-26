package alura.daniel.elements;

import android.graphics.Canvas;
import android.graphics.Paint;

import alura.daniel.graphic.Cores;
import alura.daniel.graphic.Tela;

/**al
 * Created by daniel on 25/09/17.
 */

public class Cano {
    private static final int TAMANHO_DO_CANO = 400;
    private static final int LARGURA_DO_CANO = 120;
    private static final Paint VERDE = Cores.getCorDoCano();
    private final Tela tela;
    private int alturaDoCanoInferior;
    private int posicao;

    public Cano(Tela tela, int posicao) {
        this.tela = tela;
        this.alturaDoCanoInferior = tela.getAltura() - TAMANHO_DO_CANO;
        this.posicao = posicao;
    }

    public void desenhaNo(Canvas canvas) {
        desenhaCanoInferiorNo(canvas);
    }

    private void desenhaCanoInferiorNo(Canvas canvas) {
        canvas.drawRect(posicao, alturaDoCanoInferior, posicao + LARGURA_DO_CANO, tela.getAltura(), VERDE);
    }

    public void move() {
        posicao -= 5;
    }
}
