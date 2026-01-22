package androidx.appcompat.widget;

import android.R;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.InputFilter;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.Property;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import androidx.annotation.FloatRange;
import androidx.core.view.d1;
import androidx.emoji2.text.f;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class SwitchCompat extends CompoundButton {
    private static final Property S = new a(Float.class, "thumbPos");
    private static final int[] T = {R.attr.state_checked};
    private int A;

    /* renamed from: B, reason: collision with root package name */
    private int f١٤٢٠B;
    private int C;
    private int D;
    private int E;
    private int F;
    private int G;
    private boolean H;
    private final TextPaint I;
    private ColorStateList J;
    private Layout K;
    private Layout L;
    private TransformationMethod M;
    ObjectAnimator N;
    private final r O;
    private h P;
    private b Q;
    private final Rect R;

    /* renamed from: a, reason: collision with root package name */
    private Drawable f١٤٢١a;

    /* renamed from: b, reason: collision with root package name */
    private ColorStateList f١٤٢٢b;

    /* renamed from: c, reason: collision with root package name */
    private PorterDuff.Mode f١٤٢٣c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f١٤٢٤d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f١٤٢٥e;

    /* renamed from: f, reason: collision with root package name */
    private Drawable f١٤٢٦f;

    /* renamed from: g, reason: collision with root package name */
    private ColorStateList f١٤٢٧g;

    /* renamed from: h, reason: collision with root package name */
    private PorterDuff.Mode f١٤٢٨h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f١٤٢٩i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f١٤٣٠j;

    /* renamed from: k, reason: collision with root package name */
    private int f١٤٣١k;

    /* renamed from: l, reason: collision with root package name */
    private int f١٤٣٢l;

    /* renamed from: m, reason: collision with root package name */
    private int f١٤٣٣m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f١٤٣٤n;

    /* renamed from: o, reason: collision with root package name */
    private CharSequence f١٤٣٥o;

    /* renamed from: p, reason: collision with root package name */
    private CharSequence f١٤٣٦p;

    /* renamed from: q, reason: collision with root package name */
    private CharSequence f١٤٣٧q;

    /* renamed from: r, reason: collision with root package name */
    private CharSequence f١٤٣٨r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f١٤٣٩s;

    /* renamed from: t, reason: collision with root package name */
    private int f١٤٤٠t;

    /* renamed from: u, reason: collision with root package name */
    private int f١٤٤١u;

    /* renamed from: v, reason: collision with root package name */
    private float f١٤٤٢v;

    /* renamed from: w, reason: collision with root package name */
    private float f١٤٤٣w;

    /* renamed from: x, reason: collision with root package name */
    private VelocityTracker f١٤٤٤x;

    /* renamed from: y, reason: collision with root package name */
    private int f١٤٤٥y;

    /* renamed from: z, reason: collision with root package name */
    float f١٤٤٦z;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class a extends Property {
        a(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(SwitchCompat switchCompat) {
            return Float.valueOf(switchCompat.f١٤٤٦z);
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(SwitchCompat switchCompat, Float f10) {
            switchCompat.setThumbPosition(f10.floatValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class b extends f.AbstractC٠٠٣٩f {

        /* renamed from: a, reason: collision with root package name */
        private final Reference f١٤٤٧a;

        b(SwitchCompat switchCompat) {
            this.f١٤٤٧a = new WeakReference(switchCompat);
        }

        @Override // androidx.emoji2.text.f.AbstractC٠٠٣٩f
        public void a(Throwable th) {
            SwitchCompat switchCompat = (SwitchCompat) this.f١٤٤٧a.get();
            if (switchCompat != null) {
                switchCompat.j();
            }
        }

        @Override // androidx.emoji2.text.f.AbstractC٠٠٣٩f
        public void b() {
            SwitchCompat switchCompat = (SwitchCompat) this.f١٤٤٧a.get();
            if (switchCompat != null) {
                switchCompat.j();
            }
        }
    }

    public SwitchCompat(Context context) {
        this(context, null);
    }

    private void a(boolean z10) {
        float f10;
        if (z10) {
            f10 = 1.0f;
        } else {
            f10 = DownloadProgress.UNKNOWN_PROGRESS;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, (Property<SwitchCompat, Float>) S, f10);
        this.N = ofFloat;
        ofFloat.setDuration(250L);
        this.N.setAutoCancel(true);
        this.N.start();
    }

    private void b() {
        Drawable drawable = this.f١٤٢١a;
        if (drawable != null) {
            if (this.f١٤٢٤d || this.f١٤٢٥e) {
                Drawable mutate = h2.b.r(drawable).mutate();
                this.f١٤٢١a = mutate;
                if (this.f١٤٢٤d) {
                    h2.b.o(mutate, this.f١٤٢٢b);
                }
                if (this.f١٤٢٥e) {
                    h2.b.p(this.f١٤٢١a, this.f١٤٢٣c);
                }
                if (this.f١٤٢١a.isStateful()) {
                    this.f١٤٢١a.setState(getDrawableState());
                }
            }
        }
    }

    private void c() {
        Drawable drawable = this.f١٤٢٦f;
        if (drawable != null) {
            if (this.f١٤٢٩i || this.f١٤٣٠j) {
                Drawable mutate = h2.b.r(drawable).mutate();
                this.f١٤٢٦f = mutate;
                if (this.f١٤٢٩i) {
                    h2.b.o(mutate, this.f١٤٢٧g);
                }
                if (this.f١٤٣٠j) {
                    h2.b.p(this.f١٤٢٦f, this.f١٤٢٨h);
                }
                if (this.f١٤٢٦f.isStateful()) {
                    this.f١٤٢٦f.setState(getDrawableState());
                }
            }
        }
    }

    private void d() {
        ObjectAnimator objectAnimator = this.N;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    private void e(MotionEvent motionEvent) {
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.setAction(3);
        super.onTouchEvent(obtain);
        obtain.recycle();
    }

    private static float f(float f10, float f11, float f12) {
        return f10 < f11 ? f11 : f10 > f12 ? f12 : f10;
    }

    private CharSequence g(CharSequence charSequence) {
        TransformationMethod f10 = getEmojiTextViewHelper().f(this.M);
        if (f10 != null) {
            return f10.getTransformation(charSequence, this);
        }
        return charSequence;
    }

    private h getEmojiTextViewHelper() {
        if (this.P == null) {
            this.P = new h(this);
        }
        return this.P;
    }

    private boolean getTargetCheckedState() {
        if (this.f١٤٤٦z > 0.5f) {
            return true;
        }
        return false;
    }

    private int getThumbOffset() {
        float f10;
        if (a1.b(this)) {
            f10 = 1.0f - this.f١٤٤٦z;
        } else {
            f10 = this.f١٤٤٦z;
        }
        return (int) ((f10 * getThumbScrollRange()) + 0.5f);
    }

    private int getThumbScrollRange() {
        Rect rect;
        Drawable drawable = this.f١٤٢٦f;
        if (drawable != null) {
            Rect rect2 = this.R;
            drawable.getPadding(rect2);
            Drawable drawable2 = this.f١٤٢١a;
            if (drawable2 != null) {
                rect = c0.d(drawable2);
            } else {
                rect = c0.f١٤٧٤c;
            }
            return ((((this.A - this.C) - rect2.left) - rect2.right) - rect.left) - rect.right;
        }
        return 0;
    }

    private boolean h(float f10, float f11) {
        if (this.f١٤٢١a == null) {
            return false;
        }
        int thumbOffset = getThumbOffset();
        this.f١٤٢١a.getPadding(this.R);
        int i10 = this.E;
        int i11 = this.f١٤٤١u;
        int i12 = i10 - i11;
        int i13 = (this.D + thumbOffset) - i11;
        int i14 = this.C + i13;
        Rect rect = this.R;
        int i15 = i14 + rect.left + rect.right + i11;
        int i16 = this.G + i11;
        if (f10 <= i13 || f10 >= i15 || f11 <= i12 || f11 >= i16) {
            return false;
        }
        return true;
    }

    private Layout i(CharSequence charSequence) {
        int i10;
        TextPaint textPaint = this.I;
        if (charSequence != null) {
            i10 = (int) Math.ceil(Layout.getDesiredWidth(charSequence, textPaint));
        } else {
            i10 = 0;
        }
        return new StaticLayout(charSequence, textPaint, i10, Layout.Alignment.ALIGN_NORMAL, 1.0f, DownloadProgress.UNKNOWN_PROGRESS, true);
    }

    private void k() {
        if (Build.VERSION.SDK_INT >= 30) {
            CharSequence charSequence = this.f١٤٣٧q;
            if (charSequence == null) {
                charSequence = getResources().getString(androidx.appcompat.R.string.abc_capital_off);
            }
            d1.I0(this, charSequence);
        }
    }

    private void l() {
        if (Build.VERSION.SDK_INT >= 30) {
            CharSequence charSequence = this.f١٤٣٥o;
            if (charSequence == null) {
                charSequence = getResources().getString(androidx.appcompat.R.string.abc_capital_on);
            }
            d1.I0(this, charSequence);
        }
    }

    private void o(int i10, int i11) {
        Typeface typeface;
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 != 3) {
                    typeface = null;
                } else {
                    typeface = Typeface.MONOSPACE;
                }
            } else {
                typeface = Typeface.SERIF;
            }
        } else {
            typeface = Typeface.SANS_SERIF;
        }
        n(typeface, i11);
    }

    private void p() {
        if (this.Q == null && this.P.b() && androidx.emoji2.text.f.i()) {
            androidx.emoji2.text.f c10 = androidx.emoji2.text.f.c();
            int e10 = c10.e();
            if (e10 == 3 || e10 == 0) {
                b bVar = new b(this);
                this.Q = bVar;
                c10.t(bVar);
            }
        }
    }

    private void q(MotionEvent motionEvent) {
        boolean z10;
        this.f١٤٤٠t = 0;
        boolean z11 = true;
        if (motionEvent.getAction() == 1 && isEnabled()) {
            z10 = true;
        } else {
            z10 = false;
        }
        boolean isChecked = isChecked();
        if (z10) {
            this.f١٤٤٤x.computeCurrentVelocity(1000);
            float xVelocity = this.f١٤٤٤x.getXVelocity();
            if (Math.abs(xVelocity) > this.f١٤٤٥y) {
                if (!a1.b(this) ? xVelocity <= DownloadProgress.UNKNOWN_PROGRESS : xVelocity >= DownloadProgress.UNKNOWN_PROGRESS) {
                    z11 = false;
                }
            } else {
                z11 = getTargetCheckedState();
            }
        } else {
            z11 = isChecked;
        }
        if (z11 != isChecked) {
            playSoundEffect(0);
        }
        setChecked(z11);
        e(motionEvent);
    }

    private void setTextOffInternal(CharSequence charSequence) {
        this.f١٤٣٧q = charSequence;
        this.f١٤٣٨r = g(charSequence);
        this.L = null;
        if (this.f١٤٣٩s) {
            p();
        }
    }

    private void setTextOnInternal(CharSequence charSequence) {
        this.f١٤٣٥o = charSequence;
        this.f١٤٣٦p = g(charSequence);
        this.K = null;
        if (this.f١٤٣٩s) {
            p();
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        Rect rect;
        int i10;
        int i11;
        Rect rect2 = this.R;
        int i12 = this.D;
        int i13 = this.E;
        int i14 = this.F;
        int i15 = this.G;
        int thumbOffset = getThumbOffset() + i12;
        Drawable drawable = this.f١٤٢١a;
        if (drawable != null) {
            rect = c0.d(drawable);
        } else {
            rect = c0.f١٤٧٤c;
        }
        Drawable drawable2 = this.f١٤٢٦f;
        if (drawable2 != null) {
            drawable2.getPadding(rect2);
            int i16 = rect2.left;
            thumbOffset += i16;
            if (rect != null) {
                int i17 = rect.left;
                if (i17 > i16) {
                    i12 += i17 - i16;
                }
                int i18 = rect.top;
                int i19 = rect2.top;
                if (i18 > i19) {
                    i10 = (i18 - i19) + i13;
                } else {
                    i10 = i13;
                }
                int i20 = rect.right;
                int i21 = rect2.right;
                if (i20 > i21) {
                    i14 -= i20 - i21;
                }
                int i22 = rect.bottom;
                int i23 = rect2.bottom;
                if (i22 > i23) {
                    i11 = i15 - (i22 - i23);
                    this.f١٤٢٦f.setBounds(i12, i10, i14, i11);
                }
            } else {
                i10 = i13;
            }
            i11 = i15;
            this.f١٤٢٦f.setBounds(i12, i10, i14, i11);
        }
        Drawable drawable3 = this.f١٤٢١a;
        if (drawable3 != null) {
            drawable3.getPadding(rect2);
            int i24 = thumbOffset - rect2.left;
            int i25 = thumbOffset + this.C + rect2.right;
            this.f١٤٢١a.setBounds(i24, i13, i25, i15);
            Drawable background = getBackground();
            if (background != null) {
                h2.b.l(background, i24, i13, i25, i15);
            }
        }
        super.draw(canvas);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableHotspotChanged(float f10, float f11) {
        super.drawableHotspotChanged(f10, f11);
        Drawable drawable = this.f١٤٢١a;
        if (drawable != null) {
            h2.b.k(drawable, f10, f11);
        }
        Drawable drawable2 = this.f١٤٢٦f;
        if (drawable2 != null) {
            h2.b.k(drawable2, f10, f11);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        boolean z10;
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f١٤٢١a;
        if (drawable != null && drawable.isStateful()) {
            z10 = drawable.setState(drawableState);
        } else {
            z10 = false;
        }
        Drawable drawable2 = this.f١٤٢٦f;
        if (drawable2 != null && drawable2.isStateful()) {
            z10 |= drawable2.setState(drawableState);
        }
        if (z10) {
            invalidate();
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        if (!a1.b(this)) {
            return super.getCompoundPaddingLeft();
        }
        int compoundPaddingLeft = super.getCompoundPaddingLeft() + this.A;
        if (!TextUtils.isEmpty(getText())) {
            return compoundPaddingLeft + this.f١٤٣٣m;
        }
        return compoundPaddingLeft;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingRight() {
        if (a1.b(this)) {
            return super.getCompoundPaddingRight();
        }
        int compoundPaddingRight = super.getCompoundPaddingRight() + this.A;
        if (!TextUtils.isEmpty(getText())) {
            return compoundPaddingRight + this.f١٤٣٣m;
        }
        return compoundPaddingRight;
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return androidx.core.widget.l.o(super.getCustomSelectionActionModeCallback());
    }

    public boolean getShowText() {
        return this.f١٤٣٩s;
    }

    public boolean getSplitTrack() {
        return this.f١٤٣٤n;
    }

    public int getSwitchMinWidth() {
        return this.f١٤٣٢l;
    }

    public int getSwitchPadding() {
        return this.f١٤٣٣m;
    }

    public CharSequence getTextOff() {
        return this.f١٤٣٧q;
    }

    public CharSequence getTextOn() {
        return this.f١٤٣٥o;
    }

    public Drawable getThumbDrawable() {
        return this.f١٤٢١a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @FloatRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, to = 1.0d)
    public final float getThumbPosition() {
        return this.f١٤٤٦z;
    }

    public int getThumbTextPadding() {
        return this.f١٤٣١k;
    }

    public ColorStateList getThumbTintList() {
        return this.f١٤٢٢b;
    }

    public PorterDuff.Mode getThumbTintMode() {
        return this.f١٤٢٣c;
    }

    public Drawable getTrackDrawable() {
        return this.f١٤٢٦f;
    }

    public ColorStateList getTrackTintList() {
        return this.f١٤٢٧g;
    }

    public PorterDuff.Mode getTrackTintMode() {
        return this.f١٤٢٨h;
    }

    void j() {
        setTextOnInternal(this.f١٤٣٥o);
        setTextOffInternal(this.f١٤٣٧q);
        requestLayout();
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f١٤٢١a;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f١٤٢٦f;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        ObjectAnimator objectAnimator = this.N;
        if (objectAnimator != null && objectAnimator.isStarted()) {
            this.N.end();
            this.N = null;
        }
    }

    public void m(Context context, int i10) {
        p0 t10 = p0.t(context, i10, androidx.appcompat.R.styleable.TextAppearance);
        ColorStateList c10 = t10.c(androidx.appcompat.R.styleable.TextAppearance_android_textColor);
        if (c10 != null) {
            this.J = c10;
        } else {
            this.J = getTextColors();
        }
        int f10 = t10.f(androidx.appcompat.R.styleable.TextAppearance_android_textSize, 0);
        if (f10 != 0) {
            float f11 = f10;
            if (f11 != this.I.getTextSize()) {
                this.I.setTextSize(f11);
                requestLayout();
            }
        }
        o(t10.k(androidx.appcompat.R.styleable.TextAppearance_android_typeface, -1), t10.k(androidx.appcompat.R.styleable.TextAppearance_android_textStyle, -1));
        if (t10.a(androidx.appcompat.R.styleable.TextAppearance_textAllCaps, false)) {
            this.M = new u1.a(getContext());
        } else {
            this.M = null;
        }
        setTextOnInternal(this.f١٤٣٥o);
        setTextOffInternal(this.f١٤٣٧q);
        t10.x();
    }

    public void n(Typeface typeface, int i10) {
        Typeface create;
        int i11;
        float f10 = DownloadProgress.UNKNOWN_PROGRESS;
        boolean z10 = false;
        if (i10 > 0) {
            if (typeface == null) {
                create = Typeface.defaultFromStyle(i10);
            } else {
                create = Typeface.create(typeface, i10);
            }
            setSwitchTypeface(create);
            if (create != null) {
                i11 = create.getStyle();
            } else {
                i11 = 0;
            }
            int i12 = (~i11) & i10;
            TextPaint textPaint = this.I;
            if ((i12 & 1) != 0) {
                z10 = true;
            }
            textPaint.setFakeBoldText(z10);
            TextPaint textPaint2 = this.I;
            if ((i12 & 2) != 0) {
                f10 = -0.25f;
            }
            textPaint2.setTextSkewX(f10);
            return;
        }
        this.I.setFakeBoldText(false);
        this.I.setTextSkewX(DownloadProgress.UNKNOWN_PROGRESS);
        setSwitchTypeface(typeface);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public int[] onCreateDrawableState(int i10) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i10 + 1);
        if (isChecked()) {
            View.mergeDrawableStates(onCreateDrawableState, T);
        }
        return onCreateDrawableState;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        Layout layout;
        int width;
        super.onDraw(canvas);
        Rect rect = this.R;
        Drawable drawable = this.f١٤٢٦f;
        if (drawable != null) {
            drawable.getPadding(rect);
        } else {
            rect.setEmpty();
        }
        int i10 = this.E;
        int i11 = this.G;
        int i12 = i10 + rect.top;
        int i13 = i11 - rect.bottom;
        Drawable drawable2 = this.f١٤٢١a;
        if (drawable != null) {
            if (this.f١٤٣٤n && drawable2 != null) {
                Rect d10 = c0.d(drawable2);
                drawable2.copyBounds(rect);
                rect.left += d10.left;
                rect.right -= d10.right;
                int save = canvas.save();
                canvas.clipRect(rect, Region.Op.DIFFERENCE);
                drawable.draw(canvas);
                canvas.restoreToCount(save);
            } else {
                drawable.draw(canvas);
            }
        }
        int save2 = canvas.save();
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        if (getTargetCheckedState()) {
            layout = this.K;
        } else {
            layout = this.L;
        }
        if (layout != null) {
            int[] drawableState = getDrawableState();
            ColorStateList colorStateList = this.J;
            if (colorStateList != null) {
                this.I.setColor(colorStateList.getColorForState(drawableState, 0));
            }
            this.I.drawableState = drawableState;
            if (drawable2 != null) {
                Rect bounds = drawable2.getBounds();
                width = bounds.left + bounds.right;
            } else {
                width = getWidth();
            }
            canvas.translate((width / 2) - (layout.getWidth() / 2), ((i12 + i13) / 2) - (layout.getHeight() / 2));
            layout.draw(canvas);
        }
        canvas.restoreToCount(save2);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("android.widget.Switch");
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        CharSequence charSequence;
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("android.widget.Switch");
        if (Build.VERSION.SDK_INT < 30) {
            if (isChecked()) {
                charSequence = this.f١٤٣٥o;
            } else {
                charSequence = this.f١٤٣٧q;
            }
            if (!TextUtils.isEmpty(charSequence)) {
                CharSequence text = accessibilityNodeInfo.getText();
                if (TextUtils.isEmpty(text)) {
                    accessibilityNodeInfo.setText(charSequence);
                    return;
                }
                StringBuilder sb = new StringBuilder();
                sb.append(text);
                sb.append(' ');
                sb.append(charSequence);
                accessibilityNodeInfo.setText(sb);
            }
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int i14;
        int width;
        int i15;
        int i16;
        int i17;
        int i18;
        super.onLayout(z10, i10, i11, i12, i13);
        int i19 = 0;
        if (this.f١٤٢١a != null) {
            Rect rect = this.R;
            Drawable drawable = this.f١٤٢٦f;
            if (drawable != null) {
                drawable.getPadding(rect);
            } else {
                rect.setEmpty();
            }
            Rect d10 = c0.d(this.f١٤٢١a);
            i14 = Math.max(0, d10.left - rect.left);
            i19 = Math.max(0, d10.right - rect.right);
        } else {
            i14 = 0;
        }
        if (a1.b(this)) {
            i15 = getPaddingLeft() + i14;
            width = ((this.A + i15) - i14) - i19;
        } else {
            width = (getWidth() - getPaddingRight()) - i19;
            i15 = (width - this.A) + i14 + i19;
        }
        int gravity = getGravity() & 112;
        if (gravity != 16) {
            if (gravity != 80) {
                i17 = getPaddingTop();
                i16 = this.f١٤٢٠B;
            } else {
                i18 = getHeight() - getPaddingBottom();
                i17 = i18 - this.f١٤٢٠B;
                this.D = i15;
                this.E = i17;
                this.G = i18;
                this.F = width;
            }
        } else {
            int paddingTop = ((getPaddingTop() + getHeight()) - getPaddingBottom()) / 2;
            i16 = this.f١٤٢٠B;
            i17 = paddingTop - (i16 / 2);
        }
        i18 = i16 + i17;
        this.D = i15;
        this.E = i17;
        this.G = i18;
        this.F = width;
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i10, int i11) {
        int i12;
        int i13;
        int i14;
        int i15;
        if (this.f١٤٣٩s) {
            if (this.K == null) {
                this.K = i(this.f١٤٣٦p);
            }
            if (this.L == null) {
                this.L = i(this.f١٤٣٨r);
            }
        }
        Rect rect = this.R;
        Drawable drawable = this.f١٤٢١a;
        int i16 = 0;
        if (drawable != null) {
            drawable.getPadding(rect);
            i12 = (this.f١٤٢١a.getIntrinsicWidth() - rect.left) - rect.right;
            i13 = this.f١٤٢١a.getIntrinsicHeight();
        } else {
            i12 = 0;
            i13 = 0;
        }
        if (this.f١٤٣٩s) {
            i14 = Math.max(this.K.getWidth(), this.L.getWidth()) + (this.f١٤٣١k * 2);
        } else {
            i14 = 0;
        }
        this.C = Math.max(i14, i12);
        Drawable drawable2 = this.f١٤٢٦f;
        if (drawable2 != null) {
            drawable2.getPadding(rect);
            i16 = this.f١٤٢٦f.getIntrinsicHeight();
        } else {
            rect.setEmpty();
        }
        int i17 = rect.left;
        int i18 = rect.right;
        Drawable drawable3 = this.f١٤٢١a;
        if (drawable3 != null) {
            Rect d10 = c0.d(drawable3);
            i17 = Math.max(i17, d10.left);
            i18 = Math.max(i18, d10.right);
        }
        if (this.H) {
            i15 = Math.max(this.f١٤٣٢l, (this.C * 2) + i17 + i18);
        } else {
            i15 = this.f١٤٣٢l;
        }
        int max = Math.max(i16, i13);
        this.A = i15;
        this.f١٤٢٠B = max;
        super.onMeasure(i10, i11);
        if (getMeasuredHeight() < max) {
            setMeasuredDimension(getMeasuredWidthAndState(), max);
        }
    }

    @Override // android.view.View
    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        CharSequence charSequence;
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        if (isChecked()) {
            charSequence = this.f١٤٣٥o;
        } else {
            charSequence = this.f١٤٣٧q;
        }
        if (charSequence != null) {
            accessibilityEvent.getText().add(charSequence);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0012, code lost:
    
        if (r0 != 3) goto L٤٤;
     */
    @Override // android.widget.TextView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        float f10;
        this.f١٤٤٤x.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    int i10 = this.f١٤٤٠t;
                    if (i10 != 1) {
                        if (i10 == 2) {
                            float x10 = motionEvent.getX();
                            int thumbScrollRange = getThumbScrollRange();
                            float f11 = x10 - this.f١٤٤٢v;
                            if (thumbScrollRange != 0) {
                                f10 = f11 / thumbScrollRange;
                            } else if (f11 > DownloadProgress.UNKNOWN_PROGRESS) {
                                f10 = 1.0f;
                            } else {
                                f10 = -1.0f;
                            }
                            if (a1.b(this)) {
                                f10 = -f10;
                            }
                            float f12 = f(this.f١٤٤٦z + f10, DownloadProgress.UNKNOWN_PROGRESS, 1.0f);
                            if (f12 != this.f١٤٤٦z) {
                                this.f١٤٤٢v = x10;
                                setThumbPosition(f12);
                            }
                            return true;
                        }
                    } else {
                        float x11 = motionEvent.getX();
                        float y10 = motionEvent.getY();
                        if (Math.abs(x11 - this.f١٤٤٢v) > this.f١٤٤١u || Math.abs(y10 - this.f١٤٤٣w) > this.f١٤٤١u) {
                            this.f١٤٤٠t = 2;
                            getParent().requestDisallowInterceptTouchEvent(true);
                            this.f١٤٤٢v = x11;
                            this.f١٤٤٣w = y10;
                            return true;
                        }
                    }
                }
            }
            if (this.f١٤٤٠t == 2) {
                q(motionEvent);
                super.onTouchEvent(motionEvent);
                return true;
            }
            this.f١٤٤٠t = 0;
            this.f١٤٤٤x.clear();
        } else {
            float x12 = motionEvent.getX();
            float y11 = motionEvent.getY();
            if (isEnabled() && h(x12, y11)) {
                this.f١٤٤٠t = 1;
                this.f١٤٤٢v = x12;
                this.f١٤٤٣w = y11;
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z10) {
        super.setAllCaps(z10);
        getEmojiTextViewHelper().d(z10);
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z10) {
        float f10;
        super.setChecked(z10);
        boolean isChecked = isChecked();
        if (isChecked) {
            l();
        } else {
            k();
        }
        if (getWindowToken() != null && isLaidOut()) {
            a(isChecked);
            return;
        }
        d();
        if (isChecked) {
            f10 = 1.0f;
        } else {
            f10 = DownloadProgress.UNKNOWN_PROGRESS;
        }
        setThumbPosition(f10);
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(androidx.core.widget.l.p(this, callback));
    }

    public void setEmojiCompatEnabled(boolean z10) {
        getEmojiTextViewHelper().e(z10);
        setTextOnInternal(this.f١٤٣٥o);
        setTextOffInternal(this.f١٤٣٧q);
        requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void setEnforceSwitchWidth(boolean z10) {
        this.H = z10;
        invalidate();
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().a(inputFilterArr));
    }

    public void setShowText(boolean z10) {
        if (this.f١٤٣٩s != z10) {
            this.f١٤٣٩s = z10;
            requestLayout();
            if (z10) {
                p();
            }
        }
    }

    public void setSplitTrack(boolean z10) {
        this.f١٤٣٤n = z10;
        invalidate();
    }

    public void setSwitchMinWidth(int i10) {
        this.f١٤٣٢l = i10;
        requestLayout();
    }

    public void setSwitchPadding(int i10) {
        this.f١٤٣٣m = i10;
        requestLayout();
    }

    public void setSwitchTypeface(Typeface typeface) {
        if ((this.I.getTypeface() != null && !this.I.getTypeface().equals(typeface)) || (this.I.getTypeface() == null && typeface != null)) {
            this.I.setTypeface(typeface);
            requestLayout();
            invalidate();
        }
    }

    public void setTextOff(CharSequence charSequence) {
        setTextOffInternal(charSequence);
        requestLayout();
        if (!isChecked()) {
            k();
        }
    }

    public void setTextOn(CharSequence charSequence) {
        setTextOnInternal(charSequence);
        requestLayout();
        if (isChecked()) {
            l();
        }
    }

    public void setThumbDrawable(Drawable drawable) {
        Drawable drawable2 = this.f١٤٢١a;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f١٤٢١a = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    void setThumbPosition(float f10) {
        this.f١٤٤٦z = f10;
        invalidate();
    }

    public void setThumbResource(int i10) {
        setThumbDrawable(r1.a.b(getContext(), i10));
    }

    public void setThumbTextPadding(int i10) {
        this.f١٤٣١k = i10;
        requestLayout();
    }

    public void setThumbTintList(ColorStateList colorStateList) {
        this.f١٤٢٢b = colorStateList;
        this.f١٤٢٤d = true;
        b();
    }

    public void setThumbTintMode(PorterDuff.Mode mode) {
        this.f١٤٢٣c = mode;
        this.f١٤٢٥e = true;
        b();
    }

    public void setTrackDrawable(Drawable drawable) {
        Drawable drawable2 = this.f١٤٢٦f;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f١٤٢٦f = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setTrackResource(int i10) {
        setTrackDrawable(r1.a.b(getContext(), i10));
    }

    public void setTrackTintList(ColorStateList colorStateList) {
        this.f١٤٢٧g = colorStateList;
        this.f١٤٢٩i = true;
        c();
    }

    public void setTrackTintMode(PorterDuff.Mode mode) {
        this.f١٤٢٨h = mode;
        this.f١٤٣٠j = true;
        c();
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void toggle() {
        setChecked(!isChecked());
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        if (!super.verifyDrawable(drawable) && drawable != this.f١٤٢١a && drawable != this.f١٤٢٦f) {
            return false;
        }
        return true;
    }

    public SwitchCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, androidx.appcompat.R.attr.switchStyle);
    }

    public SwitchCompat(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f١٤٢٢b = null;
        this.f١٤٢٣c = null;
        this.f١٤٢٤d = false;
        this.f١٤٢٥e = false;
        this.f١٤٢٧g = null;
        this.f١٤٢٨h = null;
        this.f١٤٢٩i = false;
        this.f١٤٣٠j = false;
        this.f١٤٤٤x = VelocityTracker.obtain();
        this.H = true;
        this.R = new Rect();
        l0.a(this, getContext());
        TextPaint textPaint = new TextPaint(1);
        this.I = textPaint;
        textPaint.density = getResources().getDisplayMetrics().density;
        int[] iArr = androidx.appcompat.R.styleable.SwitchCompat;
        p0 v10 = p0.v(context, attributeSet, iArr, i10, 0);
        d1.o0(this, context, iArr, attributeSet, v10.r(), i10, 0);
        Drawable g10 = v10.g(androidx.appcompat.R.styleable.SwitchCompat_android_thumb);
        this.f١٤٢١a = g10;
        if (g10 != null) {
            g10.setCallback(this);
        }
        Drawable g11 = v10.g(androidx.appcompat.R.styleable.SwitchCompat_track);
        this.f١٤٢٦f = g11;
        if (g11 != null) {
            g11.setCallback(this);
        }
        setTextOnInternal(v10.p(androidx.appcompat.R.styleable.SwitchCompat_android_textOn));
        setTextOffInternal(v10.p(androidx.appcompat.R.styleable.SwitchCompat_android_textOff));
        this.f١٤٣٩s = v10.a(androidx.appcompat.R.styleable.SwitchCompat_showText, true);
        this.f١٤٣١k = v10.f(androidx.appcompat.R.styleable.SwitchCompat_thumbTextPadding, 0);
        this.f١٤٣٢l = v10.f(androidx.appcompat.R.styleable.SwitchCompat_switchMinWidth, 0);
        this.f١٤٣٣m = v10.f(androidx.appcompat.R.styleable.SwitchCompat_switchPadding, 0);
        this.f١٤٣٤n = v10.a(androidx.appcompat.R.styleable.SwitchCompat_splitTrack, false);
        ColorStateList c10 = v10.c(androidx.appcompat.R.styleable.SwitchCompat_thumbTint);
        if (c10 != null) {
            this.f١٤٢٢b = c10;
            this.f١٤٢٤d = true;
        }
        PorterDuff.Mode e10 = c0.e(v10.k(androidx.appcompat.R.styleable.SwitchCompat_thumbTintMode, -1), null);
        if (this.f١٤٢٣c != e10) {
            this.f١٤٢٣c = e10;
            this.f١٤٢٥e = true;
        }
        if (this.f١٤٢٤d || this.f١٤٢٥e) {
            b();
        }
        ColorStateList c11 = v10.c(androidx.appcompat.R.styleable.SwitchCompat_trackTint);
        if (c11 != null) {
            this.f١٤٢٧g = c11;
            this.f١٤٢٩i = true;
        }
        PorterDuff.Mode e11 = c0.e(v10.k(androidx.appcompat.R.styleable.SwitchCompat_trackTintMode, -1), null);
        if (this.f١٤٢٨h != e11) {
            this.f١٤٢٨h = e11;
            this.f١٤٣٠j = true;
        }
        if (this.f١٤٢٩i || this.f١٤٣٠j) {
            c();
        }
        int n10 = v10.n(androidx.appcompat.R.styleable.SwitchCompat_switchTextAppearance, 0);
        if (n10 != 0) {
            m(context, n10);
        }
        r rVar = new r(this);
        this.O = rVar;
        rVar.m(attributeSet, i10);
        v10.x();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f١٤٤١u = viewConfiguration.getScaledTouchSlop();
        this.f١٤٤٥y = viewConfiguration.getScaledMinimumFlingVelocity();
        getEmojiTextViewHelper().c(attributeSet, i10);
        refreshDrawableState();
        setChecked(isChecked());
    }
}
