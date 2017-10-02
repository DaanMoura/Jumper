package alura.daniel.jumper.engine;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;

import alura.daniel.jumper.R;

public class Som {
    public static int PULO;
    public static int PONTO;
    public static int COLISAO;
    private SoundPool soundPool;

    public Som(Context context) {
        soundPool = new SoundPool(3, AudioManager.STREAM_MUSIC, 0);
        PULO = soundPool.load(context, R.raw.pulo, 1);
        PONTO = soundPool.load(context, R.raw.pontos, 1);
        COLISAO = soundPool.load(context, R.raw.colisao, 1);
    }

    public void toca (int som) {
        soundPool.play(som, 1, 1, 1, 0, 1);
    }
}
