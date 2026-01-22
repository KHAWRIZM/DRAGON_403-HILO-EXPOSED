package qc;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import com.tencent.mmkv.MMKV;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class b extends a implements Animatable, ValueAnimator.AnimatorUpdateListener {
    protected ValueAnimator e;
    protected int b = 0;
    protected int c = 0;
    protected int d = 0;
    protected Path f = new Path();

    public b() {
        ValueAnimator ofInt = ValueAnimator.ofInt(30, MMKV.ExpireInHour);
        this.e = ofInt;
        ofInt.setDuration(10000L);
        this.e.setInterpolator(null);
        this.e.setRepeatCount(-1);
        this.e.setRepeatMode(1);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        int width = bounds.width();
        int height = bounds.height();
        float f = width;
        float max = Math.max(1.0f, f / 22.0f);
        if (this.b != width || this.c != height) {
            this.f.reset();
            Path path = this.f;
            float f2 = f - max;
            float f3 = height / 2.0f;
            Path.Direction direction = Path.Direction.CW;
            path.addCircle(f2, f3, max, direction);
            float f4 = f - (5.0f * max);
            this.f.addRect(f4, f3 - max, f2, f3 + max, direction);
            this.f.addCircle(f4, f3, max, direction);
            this.b = width;
            this.c = height;
        }
        canvas.save();
        float f5 = f / 2.0f;
        float f6 = height / 2.0f;
        canvas.rotate(this.d, f5, f6);
        for (int i = 0; i < 12; i++) {
            this.a.setAlpha((i + 5) * 17);
            canvas.rotate(30.0f, f5, f6);
            canvas.drawPath(this.f, this.a);
        }
        canvas.restore();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.e.isRunning();
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.d = (((Integer) valueAnimator.getAnimatedValue()).intValue() / 30) * 30;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        if (!this.e.isRunning()) {
            this.e.addUpdateListener(this);
            this.e.start();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        if (this.e.isRunning()) {
            this.e.removeAllListeners();
            this.e.removeAllUpdateListeners();
            this.e.cancel();
        }
    }
}
