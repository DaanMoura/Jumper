package alura.daniel.jumper.engine;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import alura.daniel.jumper.elements.Canos;
import alura.daniel.jumper.elements.GameOver;
import alura.daniel.jumper.elements.Passaro;
import alura.daniel.jumper.elements.Pontuacao;
import alura.daniel.jumper.graphic.Tela;
import alura.daniel.jumper.R;

/**
 * Created by daniel on 21/09/17.
 */

public class Game extends SurfaceView implements Runnable, View.OnTouchListener {

    private Context context;
    private boolean isRunning = true;
    private SurfaceHolder holder = getHolder();
    private Passaro passaro;
    private Bitmap background;
    private Tela tela;
    private Canos canos;
    private Pontuacao pontuacao;
    private Som som;

    public Game(Context context) {
        super(context);
        this.context = context;
        this.tela = new Tela(context);
        som = new Som(context);

        inicializaElementos();
        setOnTouchListener(this);
    }

    private void inicializaElementos() {
        this.passaro = new Passaro(tela, context, som);
        this.pontuacao = new Pontuacao();
        this.canos = new Canos(tela, pontuacao, context, som);
        Bitmap back = BitmapFactory.decodeResource(getResources(), R.drawable.background);
        this.background = Bitmap.createScaledBitmap(back, back.getWidth(), tela.getAltura(), false);
    }

    @Override
    public void run() {
        while (true){
            while(isRunning) {
                if(!holder.getSurface().isValid()) continue;
                Canvas canvas = holder.lockCanvas();

                canvas.drawBitmap(background, 0, 0, null);

                passaro.desenhaNo(canvas);
                passaro.cai();
                canos.desenhaNo(canvas);
                canos.move();
                pontuacao.desenhaNo(canvas);

                if (new VerficadorDeColisoes(passaro, canos).temColisao()) {
                    som.toca(Som.COLISAO);
                    new GameOver(tela).desenhaNo(canvas);
                    isRunning = false;
                }

                holder.unlockCanvasAndPost(canvas);
                passaro.setVelocidade(passaro.getVelocidade() + 0.1f);
            }
        }

    }

    public void inicia() {
        isRunning = true;
    }

    public void pausa() {
        isRunning = false;
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if(isRunning)
            passaro.pula();
        else {
            inicializaElementos();
            inicia();
        }
        return false;
    }

}
