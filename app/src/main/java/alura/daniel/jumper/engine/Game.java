package alura.daniel.jumper.engine;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import alura.daniel.elements.Cano;
import alura.daniel.elements.Canos;
import alura.daniel.elements.Passaro;
import alura.daniel.graphic.Tela;
import alura.daniel.jumper.R;

/**
 * Created by daniel on 21/09/17.
 */

public class Game extends SurfaceView implements Runnable, View.OnTouchListener {

    private boolean isRunning = true;
    private SurfaceHolder holder = getHolder();
    private Passaro passaro;
    private Bitmap background;
    private Tela tela;
    private Canos canos;

    public Game(Context context) {
        super(context);
        this.tela = new Tela(context);

        inicializaElementos();
        setOnTouchListener(this);
    }

    private void inicializaElementos() {
        this.passaro = new Passaro(tela);
        this.canos = new Canos(tela);
        Bitmap back = BitmapFactory.decodeResource(getResources(), R.drawable.background);
        this.background = Bitmap.createScaledBitmap(back, back.getWidth(), tela.getAltura(), false);
    }

    @Override
    public void run() {
        while(isRunning) {
            if(!holder.getSurface().isValid()) continue;
            Canvas canvas = holder.lockCanvas();

            canvas.drawBitmap(background, 0, 0, null);

            passaro.desenhaNo(canvas);
            passaro.cai();
            canos.desenhaNo(canvas);
            canos.move();

            holder.unlockCanvasAndPost(canvas);
            passaro.setVelocidade(passaro.getVelocidade() + 0.05f);
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
        passaro.pula();
        return false;
    }

}
