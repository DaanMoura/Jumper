package alura.daniel.jumper.elements;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

import alura.daniel.jumper.R;
import alura.daniel.jumper.graphic.Cores;
import alura.daniel.jumper.graphic.Tela;

/**al
 * Created by daniel on 25/09/17.
 */

public class Cano {
    private static final int TAMANHO_DO_CANO = 400;
    private static final int LARGURA_DO_CANO = 150;
    private static final Paint VERDE = Cores.getCorDoCano();
    private final Tela tela;
    private final Bitmap canoInferior;
    private final Bitmap canoSuperior;
    private int alturaDoCanoInferior;
    private int alturaDoCanoSuperior;
    private int posicao;

    public Cano(Tela tela, int posicao, Context context) {
        this.tela = tela;
        this.alturaDoCanoInferior = tela.getAltura() - TAMANHO_DO_CANO - variacao();
        this.alturaDoCanoSuperior = TAMANHO_DO_CANO + variacao();
        this.posicao = posicao;
        Bitmap bm = BitmapFactory.decodeResource(context.getResources(), R.drawable.cano);
        canoInferior = Bitmap.createScaledBitmap(bm, LARGURA_DO_CANO, alturaDoCanoInferior, false);
        canoSuperior = Bitmap.createScaledBitmap(bm, LARGURA_DO_CANO, alturaDoCanoSuperior, false);
    }

    public void desenhaNo(Canvas canvas) {
        desenhaCanoInferiorNo(canvas);
        desenhaCanoSuperiorNo(canvas);
    }

    private void desenhaCanoInferiorNo(Canvas canvas) {
//        canvas.drawRect(posicao, alturaDoCanoInferior, posicao + LARGURA_DO_CANO, tela.getAltura(), VERDE);
        canvas.drawBitmap(canoInferior, posicao, alturaDoCanoInferior, null);
    }

    private void desenhaCanoSuperiorNo(Canvas canvas) {
//        canvas.drawRect(posicao, 0, posicao + LARGURA_DO_CANO, alturaDoCanoSuperior, VERDE);
        canvas.drawBitmap(canoSuperior, posicao, 0, null);
    }

    public void move() {
        posicao -= 5;
    }

    private int variacao() {
        return (int) (Math.random() * 260);
    }

    public boolean saiuDaTela() {
        return posicao + LARGURA_DO_CANO < 0;
    }

    public int getPosicao() {
        return posicao;
    }

    public boolean temColisaoHorizontalCom(Passaro passaro) {
        return this.posicao - Passaro.X < Passaro.RAIO;
    }

    public boolean temColisaoVerticalCom(Passaro passaro) {
        return passaro.getAltura() - Passaro.RAIO < this.alturaDoCanoSuperior
                || passaro.getAltura() + Passaro.RAIO > this.alturaDoCanoInferior;
    }
}
