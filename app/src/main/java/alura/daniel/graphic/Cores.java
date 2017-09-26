package alura.daniel.graphic;

import android.graphics.Paint;

/**
 * Created by daniel on 21/09/17.
 */

public class Cores {
    public static Paint getCorDoPassaro() {
        Paint paint = new Paint();
        paint.setColor(0xFFFF0000);
        return paint;
    }

    public static Paint getCorDoCano() {
        Paint paint = new Paint();
        paint.setColor(0xFF00FF00);
        return paint;
    }
}
