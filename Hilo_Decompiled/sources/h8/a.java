package h8;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.graphics.x;
import c8.c;
import c8.e;
import com.google.android.material.R;
import com.google.android.material.internal.e0;
import com.google.android.material.internal.h0;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import f8.g;
import f8.h;
import f8.i;
import f8.l;
import io.agora.rtc.Constants;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class a extends i implements e0.b {

    /* renamed from: b0, reason: collision with root package name */
    private static final int f١٤٥٣٥b0 = R.style.Widget_MaterialComponents_Tooltip;

    /* renamed from: c0, reason: collision with root package name */
    private static final int f١٤٥٣٦c0 = R.attr.tooltipStyle;
    private CharSequence J;
    private final Context K;
    private final Paint.FontMetrics L;
    private final e0 M;
    private final View.OnLayoutChangeListener N;
    private final Rect O;
    private int P;
    private int Q;
    private int R;
    private int S;
    private boolean T;
    private int U;
    private int V;
    private float W;
    private float X;
    private float Y;
    private float Z;

    /* renamed from: a0, reason: collision with root package name */
    private float f١٤٥٣٧a0;

    /* renamed from: h8.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class ViewOnLayoutChangeListenerC٠١٦٦a implements View.OnLayoutChangeListener {
        ViewOnLayoutChangeListenerC٠١٦٦a() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
            a.this.Q0(view);
        }
    }

    private a(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.L = new Paint.FontMetrics();
        e0 e0Var = new e0(this);
        this.M = e0Var;
        this.N = new ViewOnLayoutChangeListenerC٠١٦٦a();
        this.O = new Rect();
        this.W = 1.0f;
        this.X = 1.0f;
        this.Y = 0.5f;
        this.Z = 0.5f;
        this.f١٤٥٣٧a0 = 1.0f;
        this.K = context;
        e0Var.g().density = context.getResources().getDisplayMetrics().density;
        e0Var.g().setTextAlign(Paint.Align.CENTER);
    }

    private float C0() {
        int i10;
        if (((this.O.right - getBounds().right) - this.V) - this.S < 0) {
            i10 = ((this.O.right - getBounds().right) - this.V) - this.S;
        } else if (((this.O.left - getBounds().left) - this.V) + this.S > 0) {
            i10 = ((this.O.left - getBounds().left) - this.V) + this.S;
        } else {
            return DownloadProgress.UNKNOWN_PROGRESS;
        }
        return i10;
    }

    private float D0() {
        this.M.g().getFontMetrics(this.L);
        Paint.FontMetrics fontMetrics = this.L;
        return (fontMetrics.descent + fontMetrics.ascent) / 2.0f;
    }

    private float E0(Rect rect) {
        return rect.centerY() - D0();
    }

    public static a F0(Context context, AttributeSet attributeSet, int i10, int i11) {
        a aVar = new a(context, attributeSet, i10, i11);
        aVar.K0(attributeSet, i10, i11);
        return aVar;
    }

    private g G0() {
        float f10 = -C0();
        float width = (float) ((getBounds().width() - (this.U * Math.sqrt(2.0d))) / 2.0d);
        return new l(new h(this.U), Math.min(Math.max(f10, -width), width));
    }

    private void I0(Canvas canvas) {
        if (this.J == null) {
            return;
        }
        int E0 = (int) E0(getBounds());
        if (this.M.e() != null) {
            this.M.g().drawableState = getState();
            this.M.n(this.K);
            this.M.g().setAlpha((int) (this.f١٤٥٣٧a0 * 255.0f));
        }
        CharSequence charSequence = this.J;
        canvas.drawText(charSequence, 0, charSequence.length(), r0.centerX(), E0, this.M.g());
    }

    private float J0() {
        CharSequence charSequence = this.J;
        if (charSequence == null) {
            return DownloadProgress.UNKNOWN_PROGRESS;
        }
        return this.M.h(charSequence.toString());
    }

    private void K0(AttributeSet attributeSet, int i10, int i11) {
        TypedArray i12 = h0.i(this.K, attributeSet, R.styleable.Tooltip, i10, i11, new int[0]);
        this.U = this.K.getResources().getDimensionPixelSize(R.dimen.mtrl_tooltip_arrowSize);
        boolean z10 = i12.getBoolean(R.styleable.Tooltip_showMarker, true);
        this.T = z10;
        if (z10) {
            setShapeAppearanceModel(getShapeAppearanceModel().w().s(G0()).m());
        } else {
            this.U = 0;
        }
        O0(i12.getText(R.styleable.Tooltip_android_text));
        e h10 = c.h(this.K, i12, R.styleable.Tooltip_android_textAppearance);
        if (h10 != null) {
            int i13 = R.styleable.Tooltip_android_textColor;
            if (i12.hasValue(i13)) {
                h10.n(c.a(this.K, i12, i13));
            }
        }
        P0(h10);
        h0(ColorStateList.valueOf(i12.getColor(R.styleable.Tooltip_backgroundTint, v7.a.j(x.l(v7.a.c(this.K, android.R.attr.colorBackground, a.class.getCanonicalName()), 229), x.l(v7.a.c(this.K, R.attr.colorOnBackground, a.class.getCanonicalName()), Constants.ERR_PUBLISH_STREAM_NOT_AUTHORIZED)))));
        t0(ColorStateList.valueOf(v7.a.c(this.K, R.attr.colorSurface, a.class.getCanonicalName())));
        this.P = i12.getDimensionPixelSize(R.styleable.Tooltip_android_padding, 0);
        this.Q = i12.getDimensionPixelSize(R.styleable.Tooltip_android_minWidth, 0);
        this.R = i12.getDimensionPixelSize(R.styleable.Tooltip_android_minHeight, 0);
        this.S = i12.getDimensionPixelSize(R.styleable.Tooltip_android_layout_margin, 0);
        i12.recycle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q0(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        this.V = iArr[0];
        view.getWindowVisibleDisplayFrame(this.O);
    }

    public void H0(View view) {
        if (view == null) {
            return;
        }
        view.removeOnLayoutChangeListener(this.N);
    }

    public void L0(float f10, float f11) {
        this.Y = f10;
        this.Z = f11;
        invalidateSelf();
    }

    public void M0(View view) {
        if (view == null) {
            return;
        }
        Q0(view);
        view.addOnLayoutChangeListener(this.N);
    }

    public void N0(float f10) {
        this.W = f10;
        this.X = f10;
        this.f١٤٥٣٧a0 = p7.a.b(DownloadProgress.UNKNOWN_PROGRESS, 1.0f, 0.19f, 1.0f, f10);
        invalidateSelf();
    }

    public void O0(CharSequence charSequence) {
        if (!TextUtils.equals(this.J, charSequence)) {
            this.J = charSequence;
            this.M.m(true);
            invalidateSelf();
        }
    }

    public void P0(e eVar) {
        this.M.k(eVar, this.K);
    }

    @Override // com.google.android.material.internal.e0.b
    public void a() {
        invalidateSelf();
    }

    @Override // f8.i, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        canvas.save();
        float C0 = C0();
        float f10 = (float) (-((this.U * Math.sqrt(2.0d)) - this.U));
        canvas.scale(this.W, this.X, getBounds().left + (getBounds().width() * this.Y), getBounds().top + (getBounds().height() * this.Z));
        canvas.translate(C0, f10);
        super.draw(canvas);
        I0(canvas);
        canvas.restore();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) Math.max(this.M.g().getTextSize(), this.R);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return (int) Math.max((this.P * 2) + J0(), this.Q);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // f8.i, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        if (this.T) {
            setShapeAppearanceModel(getShapeAppearanceModel().w().s(G0()).m());
        }
    }

    @Override // f8.i, android.graphics.drawable.Drawable, com.google.android.material.internal.e0.b
    public boolean onStateChange(int[] iArr) {
        return super.onStateChange(iArr);
    }
}
