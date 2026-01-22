package com.airbnb.lottie;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.annotation.FloatRange;
import androidx.appcompat.widget.AppCompatImageView;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class LottieAnimationView extends AppCompatImageView {

    /* renamed from: n, reason: collision with root package name */
    private static final String f٦١١٨n = "LottieAnimationView";

    /* renamed from: o, reason: collision with root package name */
    private static final l0 f٦١١٩o = new l0() { // from class: com.airbnb.lottie.g
        @Override // com.airbnb.lottie.l0
        public final void onResult(Object obj) {
            LottieAnimationView.B((Throwable) obj);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private final l0 f٦١٢٠a;

    /* renamed from: b, reason: collision with root package name */
    private final l0 f٦١٢١b;

    /* renamed from: c, reason: collision with root package name */
    private l0 f٦١٢٢c;

    /* renamed from: d, reason: collision with root package name */
    private int f٦١٢٣d;

    /* renamed from: e, reason: collision with root package name */
    private final j0 f٦١٢٤e;

    /* renamed from: f, reason: collision with root package name */
    private String f٦١٢٥f;

    /* renamed from: g, reason: collision with root package name */
    private int f٦١٢٦g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f٦١٢٧h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f٦١٢٨i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f٦١٢٩j;

    /* renamed from: k, reason: collision with root package name */
    private final Set f٦١٣٠k;

    /* renamed from: l, reason: collision with root package name */
    private final Set f٦١٣١l;

    /* renamed from: m, reason: collision with root package name */
    private q0 f٦١٣٢m;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        String f٦١٣٣a;

        /* renamed from: b, reason: collision with root package name */
        int f٦١٣٤b;

        /* renamed from: c, reason: collision with root package name */
        float f٦١٣٥c;

        /* renamed from: d, reason: collision with root package name */
        boolean f٦١٣٦d;

        /* renamed from: e, reason: collision with root package name */
        String f٦١٣٧e;

        /* renamed from: f, reason: collision with root package name */
        int f٦١٣٨f;

        /* renamed from: g, reason: collision with root package name */
        int f٦١٣٩g;

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
        class a implements Parcelable.Creator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        /* synthetic */ SavedState(Parcel parcel, i iVar) {
            this(parcel);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeString(this.f٦١٣٣a);
            parcel.writeFloat(this.f٦١٣٥c);
            parcel.writeInt(this.f٦١٣٦d ? 1 : 0);
            parcel.writeString(this.f٦١٣٧e);
            parcel.writeInt(this.f٦١٣٨f);
            parcel.writeInt(this.f٦١٣٩g);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f٦١٣٣a = parcel.readString();
            this.f٦١٣٥c = parcel.readFloat();
            this.f٦١٣٦d = parcel.readInt() == 1;
            this.f٦١٣٧e = parcel.readString();
            this.f٦١٣٨f = parcel.readInt();
            this.f٦١٣٩g = parcel.readInt();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public enum a {
        SET_ANIMATION,
        SET_PROGRESS,
        SET_REPEAT_MODE,
        SET_REPEAT_COUNT,
        SET_IMAGE_ASSETS,
        PLAY_OPTION
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    private static class b implements l0 {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference f٦١٤٧a;

        public b(LottieAnimationView lottieAnimationView) {
            this.f٦١٤٧a = new WeakReference(lottieAnimationView);
        }

        @Override // com.airbnb.lottie.l0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(Throwable th) {
            LottieAnimationView lottieAnimationView = (LottieAnimationView) this.f٦١٤٧a.get();
            if (lottieAnimationView == null) {
                return;
            }
            if (lottieAnimationView.f٦١٢٣d != 0) {
                lottieAnimationView.setImageResource(lottieAnimationView.f٦١٢٣d);
            }
            (lottieAnimationView.f٦١٢٢c == null ? LottieAnimationView.f٦١١٩o : lottieAnimationView.f٦١٢٢c).onResult(th);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    private static class c implements l0 {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference f٦١٤٨a;

        public c(LottieAnimationView lottieAnimationView) {
            this.f٦١٤٨a = new WeakReference(lottieAnimationView);
        }

        @Override // com.airbnb.lottie.l0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(j jVar) {
            LottieAnimationView lottieAnimationView = (LottieAnimationView) this.f٦١٤٨a.get();
            if (lottieAnimationView == null) {
                return;
            }
            lottieAnimationView.setComposition(jVar);
        }
    }

    public LottieAnimationView(Context context) {
        super(context);
        this.f٦١٢٠a = new c(this);
        this.f٦١٢١b = new b(this);
        this.f٦١٢٣d = 0;
        this.f٦١٢٤e = new j0();
        this.f٦١٢٧h = false;
        this.f٦١٢٨i = false;
        this.f٦١٢٩j = true;
        this.f٦١٣٠k = new HashSet();
        this.f٦١٣١l = new HashSet();
        x(null, R.attr.lottieAnimationViewStyle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ o0 A(int i10) {
        if (this.f٦١٢٩j) {
            return s.u(getContext(), i10);
        }
        return s.v(getContext(), i10, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void B(Throwable th) {
        if (x3.l.k(th)) {
            x3.f.d("Unable to load composition.", th);
            return;
        }
        throw new IllegalStateException("Unable to parse composition", th);
    }

    private void H() {
        boolean y10 = y();
        setImageDrawable(null);
        setImageDrawable(this.f٦١٢٤e);
        if (y10) {
            this.f٦١٢٤e.A0();
        }
    }

    private void I(float f10, boolean z10) {
        if (z10) {
            this.f٦١٣٠k.add(a.SET_PROGRESS);
        }
        this.f٦١٢٤e.Z0(f10);
    }

    private void s() {
        q0 q0Var = this.f٦١٣٢m;
        if (q0Var != null) {
            q0Var.k(this.f٦١٢٠a);
            this.f٦١٣٢m.j(this.f٦١٢١b);
        }
    }

    private void setCompositionTask(q0 q0Var) {
        o0 e10 = q0Var.e();
        j0 j0Var = this.f٦١٢٤e;
        if (e10 != null && j0Var == getDrawable() && j0Var.J() == e10.b()) {
            return;
        }
        this.f٦١٣٠k.add(a.SET_ANIMATION);
        t();
        s();
        this.f٦١٣٢m = q0Var.d(this.f٦١٢٠a).c(this.f٦١٢١b);
    }

    private void t() {
        this.f٦١٢٤e.u();
    }

    private q0 v(final String str) {
        if (isInEditMode()) {
            return new q0(new Callable() { // from class: com.airbnb.lottie.f
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    o0 z10;
                    z10 = LottieAnimationView.this.z(str);
                    return z10;
                }
            }, true);
        }
        if (this.f٦١٢٩j) {
            return s.j(getContext(), str);
        }
        return s.k(getContext(), str, null);
    }

    private q0 w(final int i10) {
        if (isInEditMode()) {
            return new q0(new Callable() { // from class: com.airbnb.lottie.h
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    o0 A;
                    A = LottieAnimationView.this.A(i10);
                    return A;
                }
            }, true);
        }
        if (this.f٦١٢٩j) {
            return s.s(getContext(), i10);
        }
        return s.t(getContext(), i10, null);
    }

    private void x(AttributeSet attributeSet, int i10) {
        String string;
        boolean z10 = false;
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.LottieAnimationView, i10, 0);
        this.f٦١٢٩j = obtainStyledAttributes.getBoolean(R.styleable.LottieAnimationView_lottie_cacheComposition, true);
        int i11 = R.styleable.LottieAnimationView_lottie_rawRes;
        boolean hasValue = obtainStyledAttributes.hasValue(i11);
        int i12 = R.styleable.LottieAnimationView_lottie_fileName;
        boolean hasValue2 = obtainStyledAttributes.hasValue(i12);
        int i13 = R.styleable.LottieAnimationView_lottie_url;
        boolean hasValue3 = obtainStyledAttributes.hasValue(i13);
        if (hasValue && hasValue2) {
            throw new IllegalArgumentException("lottie_rawRes and lottie_fileName cannot be used at the same time. Please use only one at once.");
        }
        if (hasValue) {
            int resourceId = obtainStyledAttributes.getResourceId(i11, 0);
            if (resourceId != 0) {
                setAnimation(resourceId);
            }
        } else if (hasValue2) {
            String string2 = obtainStyledAttributes.getString(i12);
            if (string2 != null) {
                setAnimation(string2);
            }
        } else if (hasValue3 && (string = obtainStyledAttributes.getString(i13)) != null) {
            setAnimationFromUrl(string);
        }
        setFallbackResource(obtainStyledAttributes.getResourceId(R.styleable.LottieAnimationView_lottie_fallbackRes, 0));
        if (obtainStyledAttributes.getBoolean(R.styleable.LottieAnimationView_lottie_autoPlay, false)) {
            this.f٦١٢٨i = true;
        }
        if (obtainStyledAttributes.getBoolean(R.styleable.LottieAnimationView_lottie_loop, false)) {
            this.f٦١٢٤e.b1(-1);
        }
        int i14 = R.styleable.LottieAnimationView_lottie_repeatMode;
        if (obtainStyledAttributes.hasValue(i14)) {
            setRepeatMode(obtainStyledAttributes.getInt(i14, 1));
        }
        int i15 = R.styleable.LottieAnimationView_lottie_repeatCount;
        if (obtainStyledAttributes.hasValue(i15)) {
            setRepeatCount(obtainStyledAttributes.getInt(i15, -1));
        }
        int i16 = R.styleable.LottieAnimationView_lottie_speed;
        if (obtainStyledAttributes.hasValue(i16)) {
            setSpeed(obtainStyledAttributes.getFloat(i16, 1.0f));
        }
        int i17 = R.styleable.LottieAnimationView_lottie_clipToCompositionBounds;
        if (obtainStyledAttributes.hasValue(i17)) {
            setClipToCompositionBounds(obtainStyledAttributes.getBoolean(i17, true));
        }
        int i18 = R.styleable.LottieAnimationView_lottie_clipTextToBoundingBox;
        if (obtainStyledAttributes.hasValue(i18)) {
            setClipTextToBoundingBox(obtainStyledAttributes.getBoolean(i18, false));
        }
        int i19 = R.styleable.LottieAnimationView_lottie_defaultFontFileExtension;
        if (obtainStyledAttributes.hasValue(i19)) {
            setDefaultFontFileExtension(obtainStyledAttributes.getString(i19));
        }
        setImageAssetsFolder(obtainStyledAttributes.getString(R.styleable.LottieAnimationView_lottie_imageAssetsFolder));
        int i20 = R.styleable.LottieAnimationView_lottie_progress;
        I(obtainStyledAttributes.getFloat(i20, DownloadProgress.UNKNOWN_PROGRESS), obtainStyledAttributes.hasValue(i20));
        u(obtainStyledAttributes.getBoolean(R.styleable.LottieAnimationView_lottie_enableMergePathsForKitKatAndAbove, false));
        int i21 = R.styleable.LottieAnimationView_lottie_colorFilter;
        if (obtainStyledAttributes.hasValue(i21)) {
            q(new q3.e("**"), n0.K, new y3.c(new t0(r1.a.a(getContext(), obtainStyledAttributes.getResourceId(i21, -1)).getDefaultColor())));
        }
        int i22 = R.styleable.LottieAnimationView_lottie_renderMode;
        if (obtainStyledAttributes.hasValue(i22)) {
            s0 s0Var = s0.AUTOMATIC;
            int i23 = obtainStyledAttributes.getInt(i22, s0Var.ordinal());
            if (i23 >= s0.values().length) {
                i23 = s0Var.ordinal();
            }
            setRenderMode(s0.values()[i23]);
        }
        int i24 = R.styleable.LottieAnimationView_lottie_asyncUpdates;
        if (obtainStyledAttributes.hasValue(i24)) {
            com.airbnb.lottie.a aVar = com.airbnb.lottie.a.AUTOMATIC;
            int i25 = obtainStyledAttributes.getInt(i24, aVar.ordinal());
            if (i25 >= s0.values().length) {
                i25 = aVar.ordinal();
            }
            setAsyncUpdates(com.airbnb.lottie.a.values()[i25]);
        }
        setIgnoreDisabledSystemAnimations(obtainStyledAttributes.getBoolean(R.styleable.LottieAnimationView_lottie_ignoreDisabledSystemAnimations, false));
        int i26 = R.styleable.LottieAnimationView_lottie_useCompositionFrameRate;
        if (obtainStyledAttributes.hasValue(i26)) {
            setUseCompositionFrameRate(obtainStyledAttributes.getBoolean(i26, false));
        }
        obtainStyledAttributes.recycle();
        j0 j0Var = this.f٦١٢٤e;
        if (x3.l.f(getContext()) != DownloadProgress.UNKNOWN_PROGRESS) {
            z10 = true;
        }
        j0Var.f1(Boolean.valueOf(z10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ o0 z(String str) {
        if (this.f٦١٢٩j) {
            return s.l(getContext(), str);
        }
        return s.m(getContext(), str, null);
    }

    public void C() {
        this.f٦١٢٨i = false;
        this.f٦١٢٤e.w0();
    }

    public void D() {
        this.f٦١٣٠k.add(a.PLAY_OPTION);
        this.f٦١٢٤e.x0();
    }

    public void E() {
        this.f٦١٣٠k.add(a.PLAY_OPTION);
        this.f٦١٢٤e.A0();
    }

    public void F(InputStream inputStream, String str) {
        setCompositionTask(s.n(inputStream, str));
    }

    public void G(String str, String str2) {
        F(new ByteArrayInputStream(str.getBytes()), str2);
    }

    public com.airbnb.lottie.a getAsyncUpdates() {
        return this.f٦١٢٤e.E();
    }

    public boolean getAsyncUpdatesEnabled() {
        return this.f٦١٢٤e.F();
    }

    public boolean getClipTextToBoundingBox() {
        return this.f٦١٢٤e.H();
    }

    public boolean getClipToCompositionBounds() {
        return this.f٦١٢٤e.I();
    }

    public j getComposition() {
        Drawable drawable = getDrawable();
        j0 j0Var = this.f٦١٢٤e;
        if (drawable == j0Var) {
            return j0Var.J();
        }
        return null;
    }

    public long getDuration() {
        if (getComposition() != null) {
            return r0.d();
        }
        return 0L;
    }

    public int getFrame() {
        return this.f٦١٢٤e.M();
    }

    public String getImageAssetsFolder() {
        return this.f٦١٢٤e.O();
    }

    public boolean getMaintainOriginalImageBounds() {
        return this.f٦١٢٤e.Q();
    }

    public float getMaxFrame() {
        return this.f٦١٢٤e.S();
    }

    public float getMinFrame() {
        return this.f٦١٢٤e.T();
    }

    public r0 getPerformanceTracker() {
        return this.f٦١٢٤e.U();
    }

    @FloatRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, to = 1.0d)
    public float getProgress() {
        return this.f٦١٢٤e.V();
    }

    public s0 getRenderMode() {
        return this.f٦١٢٤e.W();
    }

    public int getRepeatCount() {
        return this.f٦١٢٤e.X();
    }

    public int getRepeatMode() {
        return this.f٦١٢٤e.Y();
    }

    public float getSpeed() {
        return this.f٦١٢٤e.Z();
    }

    @Override // android.view.View
    public void invalidate() {
        super.invalidate();
        Drawable drawable = getDrawable();
        if ((drawable instanceof j0) && ((j0) drawable).W() == s0.SOFTWARE) {
            this.f٦١٢٤e.invalidateSelf();
        }
    }

    @Override // android.widget.ImageView, android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        Drawable drawable2 = getDrawable();
        j0 j0Var = this.f٦١٢٤e;
        if (drawable2 == j0Var) {
            super.invalidateDrawable(j0Var);
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!isInEditMode() && this.f٦١٢٨i) {
            this.f٦١٢٤e.x0();
        }
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        int i10;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f٦١٢٥f = savedState.f٦١٣٣a;
        Set set = this.f٦١٣٠k;
        a aVar = a.SET_ANIMATION;
        if (!set.contains(aVar) && !TextUtils.isEmpty(this.f٦١٢٥f)) {
            setAnimation(this.f٦١٢٥f);
        }
        this.f٦١٢٦g = savedState.f٦١٣٤b;
        if (!this.f٦١٣٠k.contains(aVar) && (i10 = this.f٦١٢٦g) != 0) {
            setAnimation(i10);
        }
        if (!this.f٦١٣٠k.contains(a.SET_PROGRESS)) {
            I(savedState.f٦١٣٥c, false);
        }
        if (!this.f٦١٣٠k.contains(a.PLAY_OPTION) && savedState.f٦١٣٦d) {
            D();
        }
        if (!this.f٦١٣٠k.contains(a.SET_IMAGE_ASSETS)) {
            setImageAssetsFolder(savedState.f٦١٣٧e);
        }
        if (!this.f٦١٣٠k.contains(a.SET_REPEAT_MODE)) {
            setRepeatMode(savedState.f٦١٣٨f);
        }
        if (!this.f٦١٣٠k.contains(a.SET_REPEAT_COUNT)) {
            setRepeatCount(savedState.f٦١٣٩g);
        }
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f٦١٣٣a = this.f٦١٢٥f;
        savedState.f٦١٣٤b = this.f٦١٢٦g;
        savedState.f٦١٣٥c = this.f٦١٢٤e.V();
        savedState.f٦١٣٦d = this.f٦١٢٤e.e0();
        savedState.f٦١٣٧e = this.f٦١٢٤e.O();
        savedState.f٦١٣٨f = this.f٦١٢٤e.Y();
        savedState.f٦١٣٩g = this.f٦١٢٤e.X();
        return savedState;
    }

    public void q(q3.e eVar, Object obj, y3.c cVar) {
        this.f٦١٢٤e.q(eVar, obj, cVar);
    }

    public void r() {
        this.f٦١٢٨i = false;
        this.f٦١٣٠k.add(a.PLAY_OPTION);
        this.f٦١٢٤e.t();
    }

    public void setAnimation(int i10) {
        this.f٦١٢٦g = i10;
        this.f٦١٢٥f = null;
        setCompositionTask(w(i10));
    }

    @Deprecated
    public void setAnimationFromJson(String str) {
        G(str, null);
    }

    public void setAnimationFromUrl(String str) {
        q0 x10;
        if (this.f٦١٢٩j) {
            x10 = s.w(getContext(), str);
        } else {
            x10 = s.x(getContext(), str, null);
        }
        setCompositionTask(x10);
    }

    public void setApplyingOpacityToLayersEnabled(boolean z10) {
        this.f٦١٢٤e.C0(z10);
    }

    public void setAsyncUpdates(com.airbnb.lottie.a aVar) {
        this.f٦١٢٤e.D0(aVar);
    }

    public void setCacheComposition(boolean z10) {
        this.f٦١٢٩j = z10;
    }

    public void setClipTextToBoundingBox(boolean z10) {
        this.f٦١٢٤e.E0(z10);
    }

    public void setClipToCompositionBounds(boolean z10) {
        this.f٦١٢٤e.F0(z10);
    }

    public void setComposition(j jVar) {
        if (e.f٦١٦٠a) {
            Log.v(f٦١١٨n, "Set Composition \n" + jVar);
        }
        this.f٦١٢٤e.setCallback(this);
        this.f٦١٢٧h = true;
        boolean G0 = this.f٦١٢٤e.G0(jVar);
        if (this.f٦١٢٨i) {
            this.f٦١٢٤e.x0();
        }
        this.f٦١٢٧h = false;
        if (getDrawable() == this.f٦١٢٤e && !G0) {
            return;
        }
        if (!G0) {
            H();
        }
        onVisibilityChanged(this, getVisibility());
        requestLayout();
        Iterator it = this.f٦١٣١l.iterator();
        if (!it.hasNext()) {
            return;
        }
        androidx.appcompat.app.a0.a(it.next());
        throw null;
    }

    public void setDefaultFontFileExtension(String str) {
        this.f٦١٢٤e.H0(str);
    }

    public void setFailureListener(l0 l0Var) {
        this.f٦١٢٢c = l0Var;
    }

    public void setFallbackResource(int i10) {
        this.f٦١٢٣d = i10;
    }

    public void setFontAssetDelegate(com.airbnb.lottie.b bVar) {
        this.f٦١٢٤e.I0(bVar);
    }

    public void setFontMap(Map<String, Typeface> map) {
        this.f٦١٢٤e.J0(map);
    }

    public void setFrame(int i10) {
        this.f٦١٢٤e.K0(i10);
    }

    public void setIgnoreDisabledSystemAnimations(boolean z10) {
        this.f٦١٢٤e.L0(z10);
    }

    public void setImageAssetDelegate(com.airbnb.lottie.c cVar) {
        this.f٦١٢٤e.M0(cVar);
    }

    public void setImageAssetsFolder(String str) {
        this.f٦١٢٤e.N0(str);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        this.f٦١٢٦g = 0;
        this.f٦١٢٥f = null;
        s();
        super.setImageBitmap(bitmap);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        this.f٦١٢٦g = 0;
        this.f٦١٢٥f = null;
        s();
        super.setImageDrawable(drawable);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i10) {
        this.f٦١٢٦g = 0;
        this.f٦١٢٥f = null;
        s();
        super.setImageResource(i10);
    }

    public void setMaintainOriginalImageBounds(boolean z10) {
        this.f٦١٢٤e.O0(z10);
    }

    public void setMaxFrame(int i10) {
        this.f٦١٢٤e.P0(i10);
    }

    public void setMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) float f10) {
        this.f٦١٢٤e.R0(f10);
    }

    public void setMinAndMaxFrame(String str) {
        this.f٦١٢٤e.T0(str);
    }

    public void setMinFrame(int i10) {
        this.f٦١٢٤e.U0(i10);
    }

    public void setMinProgress(float f10) {
        this.f٦١٢٤e.W0(f10);
    }

    public void setOutlineMasksAndMattes(boolean z10) {
        this.f٦١٢٤e.X0(z10);
    }

    public void setPerformanceTrackingEnabled(boolean z10) {
        this.f٦١٢٤e.Y0(z10);
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f10) {
        I(f10, true);
    }

    public void setRenderMode(s0 s0Var) {
        this.f٦١٢٤e.a1(s0Var);
    }

    public void setRepeatCount(int i10) {
        this.f٦١٣٠k.add(a.SET_REPEAT_COUNT);
        this.f٦١٢٤e.b1(i10);
    }

    public void setRepeatMode(int i10) {
        this.f٦١٣٠k.add(a.SET_REPEAT_MODE);
        this.f٦١٢٤e.c1(i10);
    }

    public void setSafeMode(boolean z10) {
        this.f٦١٢٤e.d1(z10);
    }

    public void setSpeed(float f10) {
        this.f٦١٢٤e.e1(f10);
    }

    public void setTextDelegate(u0 u0Var) {
        this.f٦١٢٤e.g1(u0Var);
    }

    public void setUseCompositionFrameRate(boolean z10) {
        this.f٦١٢٤e.h1(z10);
    }

    public void u(boolean z10) {
        this.f٦١٢٤e.z(z10);
    }

    @Override // android.view.View
    public void unscheduleDrawable(Drawable drawable) {
        j0 j0Var;
        if (!this.f٦١٢٧h && drawable == (j0Var = this.f٦١٢٤e) && j0Var.d0()) {
            C();
        } else if (!this.f٦١٢٧h && (drawable instanceof j0)) {
            j0 j0Var2 = (j0) drawable;
            if (j0Var2.d0()) {
                j0Var2.w0();
            }
        }
        super.unscheduleDrawable(drawable);
    }

    public boolean y() {
        return this.f٦١٢٤e.d0();
    }

    public void setMaxFrame(String str) {
        this.f٦١٢٤e.Q0(str);
    }

    public void setMinFrame(String str) {
        this.f٦١٢٤e.V0(str);
    }

    public void setAnimation(String str) {
        this.f٦١٢٥f = str;
        this.f٦١٢٦g = 0;
        setCompositionTask(v(str));
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f٦١٢٠a = new c(this);
        this.f٦١٢١b = new b(this);
        this.f٦١٢٣d = 0;
        this.f٦١٢٤e = new j0();
        this.f٦١٢٧h = false;
        this.f٦١٢٨i = false;
        this.f٦١٢٩j = true;
        this.f٦١٣٠k = new HashSet();
        this.f٦١٣١l = new HashSet();
        x(attributeSet, R.attr.lottieAnimationViewStyle);
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f٦١٢٠a = new c(this);
        this.f٦١٢١b = new b(this);
        this.f٦١٢٣d = 0;
        this.f٦١٢٤e = new j0();
        this.f٦١٢٧h = false;
        this.f٦١٢٨i = false;
        this.f٦١٢٩j = true;
        this.f٦١٣٠k = new HashSet();
        this.f٦١٣١l = new HashSet();
        x(attributeSet, i10);
    }
}
