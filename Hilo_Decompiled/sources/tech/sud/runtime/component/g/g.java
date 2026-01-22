package tech.sud.runtime.component.g;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import tech.sud.gip.core.view.round.RoundedDrawable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public class g {
    private final tech.sud.runtime.core.g a;
    private final a b;
    private TextPaint c = null;
    private int d;
    private int e;
    private boolean f;

    public g(tech.sud.runtime.core.g gVar) {
        this.a = gVar;
        this.b = gVar.b();
    }

    private static int a(int i) {
        return (i & 16777215) | RoundedDrawable.DEFAULT_BORDER_COLOR;
    }

    public int cutTextWithWidth(String str, float f) {
        this.c.setSubpixelText(true);
        String replace = str.replace('\t', ' ');
        return replace.substring(0, this.c.breakText(replace, true, f, null)).getBytes().length;
    }

    public float fontAscent() {
        return -this.e;
    }

    public float fontDescent() {
        return this.d - (-this.e);
    }

    public void generateTextBitmapData(String str, int i, boolean z, float f, float f2) {
        int i2;
        float f3;
        float f4;
        int i3;
        String replace = str.replace('\t', ' ');
        int round = Math.round(this.c.measureText(replace));
        int i4 = this.d;
        if (z) {
            int round2 = Math.round(f);
            round += round2;
            i4 += round2;
        }
        int i5 = i4;
        if (round != 0 && i5 != 0) {
            if (!z || f != 0.0f) {
                float f5 = round;
                int i6 = (int) (f5 * f2);
                float f6 = i5;
                int i7 = (int) (f6 * f2);
                int b = this.b.b();
                if (i6 > b) {
                    f3 = b / f5;
                    i2 = b;
                } else {
                    i2 = i6;
                    f3 = f2;
                }
                if (i7 > b) {
                    f4 = b / f6;
                    i3 = b;
                } else {
                    f4 = f2;
                    i3 = i7;
                }
                Canvas a = this.b.a(i2, i3);
                a.setMatrix(null);
                a.scale(f3, f4);
                if (z && f != 0.0f) {
                    float f7 = 0.5f * f;
                    a.translate(f7, f7);
                }
                if (z) {
                    this.c.setStyle(Paint.Style.STROKE);
                    this.c.setStrokeWidth(f);
                    this.c.setStrokeCap(Paint.Cap.ROUND);
                    this.c.setStrokeJoin(Paint.Join.ROUND);
                } else {
                    this.c.setStyle(Paint.Style.FILL);
                }
                this.c.setColor(a(i));
                a.drawText(replace, 0, replace.length(), 0.0f, -this.e, (Paint) this.c);
                this.a.a(i2, i3, this.b.c(), round, i5);
            }
        }
    }

    public void init(float f, boolean z, boolean z2, String str) {
        TextPaint textPaint = new TextPaint();
        this.c = textPaint;
        textPaint.setTextSize(f);
        this.c.setTextAlign(Paint.Align.LEFT);
        this.c.setAntiAlias(true);
        this.c.setTypeface(this.b.a(str));
        this.c.setFakeBoldText(z);
        if (z2) {
            this.c.setTextSkewX(-0.12f);
        }
        this.f = z;
        this.e = Math.round(this.c.getFontMetrics().ascent);
        this.d = Math.round(this.c.getFontMetrics().descent) - this.e;
    }

    public float textHeight(String str) {
        return this.d;
    }

    public float textWidth(String str) {
        return this.c.measureText(str.replace('\t', ' '));
    }
}
