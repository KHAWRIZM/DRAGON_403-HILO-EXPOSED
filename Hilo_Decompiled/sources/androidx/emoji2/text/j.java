package androidx.emoji2.text;

import android.graphics.Paint;
import android.text.style.ReplacementSpan;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class j extends ReplacementSpan {

    /* renamed from: b, reason: collision with root package name */
    private final p f٣٦٥٠b;

    /* renamed from: a, reason: collision with root package name */
    private final Paint.FontMetricsInt f٣٦٤٩a = new Paint.FontMetricsInt();

    /* renamed from: c, reason: collision with root package name */
    private short f٣٦٥١c = -1;

    /* renamed from: d, reason: collision with root package name */
    private short f٣٦٥٢d = -1;

    /* renamed from: e, reason: collision with root package name */
    private float f٣٦٥٣e = 1.0f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(p pVar) {
        androidx.core.util.h.h(pVar, "rasterizer cannot be null");
        this.f٣٦٥٠b = pVar;
    }

    public final p a() {
        return this.f٣٦٥٠b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int b() {
        return this.f٣٦٥١c;
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i10, int i11, Paint.FontMetricsInt fontMetricsInt) {
        paint.getFontMetricsInt(this.f٣٦٤٩a);
        Paint.FontMetricsInt fontMetricsInt2 = this.f٣٦٤٩a;
        this.f٣٦٥٣e = (Math.abs(fontMetricsInt2.descent - fontMetricsInt2.ascent) * 1.0f) / this.f٣٦٥٠b.e();
        this.f٣٦٥٢d = (short) (this.f٣٦٥٠b.e() * this.f٣٦٥٣e);
        short i12 = (short) (this.f٣٦٥٠b.i() * this.f٣٦٥٣e);
        this.f٣٦٥١c = i12;
        if (fontMetricsInt != null) {
            Paint.FontMetricsInt fontMetricsInt3 = this.f٣٦٤٩a;
            fontMetricsInt.ascent = fontMetricsInt3.ascent;
            fontMetricsInt.descent = fontMetricsInt3.descent;
            fontMetricsInt.top = fontMetricsInt3.top;
            fontMetricsInt.bottom = fontMetricsInt3.bottom;
        }
        return i12;
    }
}
