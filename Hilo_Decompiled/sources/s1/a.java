package s1;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.StateSet;
import androidx.appcompat.resources.R;
import androidx.appcompat.widget.h0;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import androidx.core.content.res.k;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import s1.b;
import s1.e;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class a extends s1.e implements h2.g {

    /* renamed from: o, reason: collision with root package name */
    private c f١٧٦٠٦o;

    /* renamed from: p, reason: collision with root package name */
    private g f١٧٦٠٧p;

    /* renamed from: q, reason: collision with root package name */
    private int f١٧٦٠٨q;

    /* renamed from: r, reason: collision with root package name */
    private int f١٧٦٠٩r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f١٧٦١٠s;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class b extends g {

        /* renamed from: a, reason: collision with root package name */
        private final Animatable f١٧٦١١a;

        b(Animatable animatable) {
            super();
            this.f١٧٦١١a = animatable;
        }

        @Override // s1.a.g
        public void c() {
            this.f١٧٦١١a.start();
        }

        @Override // s1.a.g
        public void d() {
            this.f١٧٦١١a.stop();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class c extends e.a {
        LongSparseArray K;
        SparseArrayCompat L;

        c(c cVar, a aVar, Resources resources) {
            super(cVar, aVar, resources);
            if (cVar != null) {
                this.K = cVar.K;
                this.L = cVar.L;
            } else {
                this.K = new LongSparseArray();
                this.L = new SparseArrayCompat();
            }
        }

        private static long D(int i10, int i11) {
            return i11 | (i10 << 32);
        }

        int B(int[] iArr, Drawable drawable, int i10) {
            int z10 = super.z(iArr, drawable);
            this.L.put(z10, Integer.valueOf(i10));
            return z10;
        }

        int C(int i10, int i11, Drawable drawable, boolean z10) {
            long j10;
            int a10 = super.a(drawable);
            long D = D(i10, i11);
            if (z10) {
                j10 = 8589934592L;
            } else {
                j10 = 0;
            }
            long j11 = a10;
            this.K.append(D, Long.valueOf(j11 | j10));
            if (z10) {
                this.K.append(D(i11, i10), Long.valueOf(4294967296L | j11 | j10));
            }
            return a10;
        }

        int E(int i10) {
            if (i10 < 0) {
                return 0;
            }
            return ((Integer) this.L.get(i10, 0)).intValue();
        }

        int F(int[] iArr) {
            int A = super.A(iArr);
            if (A >= 0) {
                return A;
            }
            return super.A(StateSet.WILD_CARD);
        }

        int G(int i10, int i11) {
            return (int) ((Long) this.K.get(D(i10, i11), -1L)).longValue();
        }

        boolean H(int i10, int i11) {
            if ((((Long) this.K.get(D(i10, i11), -1L)).longValue() & 4294967296L) != 0) {
                return true;
            }
            return false;
        }

        boolean I(int i10, int i11) {
            if ((((Long) this.K.get(D(i10, i11), -1L)).longValue() & 8589934592L) != 0) {
                return true;
            }
            return false;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new a(this, null);
        }

        @Override // s1.e.a, s1.b.d
        void r() {
            this.K = this.K.m٢٤clone();
            this.L = this.L.m٢٥clone();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new a(this, resources);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class d extends g {

        /* renamed from: a, reason: collision with root package name */
        private final androidx.vectordrawable.graphics.drawable.e f١٧٦١٢a;

        d(androidx.vectordrawable.graphics.drawable.e eVar) {
            super();
            this.f١٧٦١٢a = eVar;
        }

        @Override // s1.a.g
        public void c() {
            this.f١٧٦١٢a.start();
        }

        @Override // s1.a.g
        public void d() {
            this.f١٧٦١٢a.stop();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class e extends g {

        /* renamed from: a, reason: collision with root package name */
        private final ObjectAnimator f١٧٦١٣a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean f١٧٦١٤b;

        e(AnimationDrawable animationDrawable, boolean z10, boolean z11) {
            super();
            int i10;
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            if (z10) {
                i10 = numberOfFrames - 1;
            } else {
                i10 = 0;
            }
            int i11 = z10 ? 0 : numberOfFrames - 1;
            f fVar = new f(animationDrawable, z10);
            ObjectAnimator ofInt = ObjectAnimator.ofInt(animationDrawable, "currentIndex", i10, i11);
            ofInt.setAutoCancel(true);
            ofInt.setDuration(fVar.a());
            ofInt.setInterpolator(fVar);
            this.f١٧٦١٤b = z11;
            this.f١٧٦١٣a = ofInt;
        }

        @Override // s1.a.g
        public boolean a() {
            return this.f١٧٦١٤b;
        }

        @Override // s1.a.g
        public void b() {
            this.f١٧٦١٣a.reverse();
        }

        @Override // s1.a.g
        public void c() {
            this.f١٧٦١٣a.start();
        }

        @Override // s1.a.g
        public void d() {
            this.f١٧٦١٣a.cancel();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    private static class f implements TimeInterpolator {

        /* renamed from: a, reason: collision with root package name */
        private int[] f١٧٦١٥a;

        /* renamed from: b, reason: collision with root package name */
        private int f١٧٦١٦b;

        /* renamed from: c, reason: collision with root package name */
        private int f١٧٦١٧c;

        f(AnimationDrawable animationDrawable, boolean z10) {
            b(animationDrawable, z10);
        }

        int a() {
            return this.f١٧٦١٧c;
        }

        int b(AnimationDrawable animationDrawable, boolean z10) {
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            this.f١٧٦١٦b = numberOfFrames;
            int[] iArr = this.f١٧٦١٥a;
            if (iArr == null || iArr.length < numberOfFrames) {
                this.f١٧٦١٥a = new int[numberOfFrames];
            }
            int[] iArr2 = this.f١٧٦١٥a;
            int i10 = 0;
            for (int i11 = 0; i11 < numberOfFrames; i11++) {
                int duration = animationDrawable.getDuration(z10 ? (numberOfFrames - i11) - 1 : i11);
                iArr2[i11] = duration;
                i10 += duration;
            }
            this.f١٧٦١٧c = i10;
            return i10;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f10) {
            float f11;
            int i10 = (int) ((f10 * this.f١٧٦١٧c) + 0.5f);
            int i11 = this.f١٧٦١٦b;
            int[] iArr = this.f١٧٦١٥a;
            int i12 = 0;
            while (i12 < i11) {
                int i13 = iArr[i12];
                if (i10 < i13) {
                    break;
                }
                i10 -= i13;
                i12++;
            }
            if (i12 < i11) {
                f11 = i10 / this.f١٧٦١٧c;
            } else {
                f11 = DownloadProgress.UNKNOWN_PROGRESS;
            }
            return (i12 / i11) + f11;
        }
    }

    public a() {
        this(null, null);
    }

    public static a l(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        String name = xmlPullParser.getName();
        if (name.equals("animated-selector")) {
            a aVar = new a();
            aVar.m(context, resources, xmlPullParser, attributeSet, theme);
            return aVar;
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid animated-selector tag " + name);
    }

    private void n(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        int depth = xmlPullParser.getDepth() + 1;
        while (true) {
            int next = xmlPullParser.next();
            if (next != 1) {
                int depth2 = xmlPullParser.getDepth();
                if (depth2 >= depth || next != 3) {
                    if (next == 2 && depth2 <= depth) {
                        if (xmlPullParser.getName().equals("item")) {
                            p(context, resources, xmlPullParser, attributeSet, theme);
                        } else if (xmlPullParser.getName().equals("transition")) {
                            q(context, resources, xmlPullParser, attributeSet, theme);
                        }
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    private void o() {
        onStateChange(getState());
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0034, code lost:
    
        if (r5 != 2) goto L١٧;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0040, code lost:
    
        if (r7.getName().equals("vector") == false) goto L١٦;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0042, code lost:
    
        r5 = androidx.vectordrawable.graphics.drawable.j.c(r6, r7, r8, r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0047, code lost:
    
        r5 = t1.a.a(r6, r7, r8, r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0064, code lost:
    
        throw new org.xmlpull.v1.XmlPullParserException(r7.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0065, code lost:
    
        if (r5 == null) goto L٢٢;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x006d, code lost:
    
        return r4.f١٧٦٠٦o.B(r0, r5, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0086, code lost:
    
        throw new org.xmlpull.v1.XmlPullParserException(r7.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0029, code lost:
    
        if (r5 == null) goto L٨;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x002b, code lost:
    
        r5 = r7.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0030, code lost:
    
        if (r5 != 4) goto L٢٤;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int p(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        Drawable drawable;
        TypedArray k10 = k.k(resources, theme, attributeSet, R.styleable.AnimatedStateListDrawableItem);
        int resourceId = k10.getResourceId(R.styleable.AnimatedStateListDrawableItem_android_id, 0);
        int resourceId2 = k10.getResourceId(R.styleable.AnimatedStateListDrawableItem_android_drawable, -1);
        if (resourceId2 > 0) {
            drawable = h0.h().j(context, resourceId2);
        } else {
            drawable = null;
        }
        k10.recycle();
        int[] j10 = j(attributeSet);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x003c, code lost:
    
        if (r4 != 2) goto L١٧;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0048, code lost:
    
        if (r10.getName().equals("animated-vector") == false) goto L١٦;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x004a, code lost:
    
        r4 = androidx.vectordrawable.graphics.drawable.e.b(r8, r9, r10, r11, r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x004f, code lost:
    
        r4 = t1.a.a(r9, r10, r11, r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x006c, code lost:
    
        throw new org.xmlpull.v1.XmlPullParserException(r10.getPositionDescription() + ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x006d, code lost:
    
        if (r4 == null) goto L٢٦;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x006f, code lost:
    
        if (r1 == (-1)) goto L٢٤;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0071, code lost:
    
        if (r3 == (-1)) goto L٢٤;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0079, code lost:
    
        return r7.f١٧٦٠٦o.C(r1, r3, r4, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0094, code lost:
    
        throw new org.xmlpull.v1.XmlPullParserException(r10.getPositionDescription() + ": <transition> tag requires 'fromId' & 'toId' attributes");
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00ad, code lost:
    
        throw new org.xmlpull.v1.XmlPullParserException(r10.getPositionDescription() + ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0031, code lost:
    
        if (r4 == null) goto L٨;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0033, code lost:
    
        r4 = r10.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0038, code lost:
    
        if (r4 != 4) goto L٢٨;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int q(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        Drawable drawable;
        TypedArray k10 = k.k(resources, theme, attributeSet, R.styleable.AnimatedStateListDrawableTransition);
        int resourceId = k10.getResourceId(R.styleable.AnimatedStateListDrawableTransition_android_fromId, -1);
        int resourceId2 = k10.getResourceId(R.styleable.AnimatedStateListDrawableTransition_android_toId, -1);
        int resourceId3 = k10.getResourceId(R.styleable.AnimatedStateListDrawableTransition_android_drawable, -1);
        if (resourceId3 > 0) {
            drawable = h0.h().j(context, resourceId3);
        } else {
            drawable = null;
        }
        boolean z10 = k10.getBoolean(R.styleable.AnimatedStateListDrawableTransition_android_reversible, false);
        k10.recycle();
    }

    private boolean r(int i10) {
        int c10;
        int G;
        g bVar;
        g gVar = this.f١٧٦٠٧p;
        if (gVar != null) {
            if (i10 == this.f١٧٦٠٨q) {
                return true;
            }
            if (i10 == this.f١٧٦٠٩r && gVar.a()) {
                gVar.b();
                this.f١٧٦٠٨q = this.f١٧٦٠٩r;
                this.f١٧٦٠٩r = i10;
                return true;
            }
            c10 = this.f١٧٦٠٨q;
            gVar.d();
        } else {
            c10 = c();
        }
        this.f١٧٦٠٧p = null;
        this.f١٧٦٠٩r = -1;
        this.f١٧٦٠٨q = -1;
        c cVar = this.f١٧٦٠٦o;
        int E = cVar.E(c10);
        int E2 = cVar.E(i10);
        if (E2 == 0 || E == 0 || (G = cVar.G(E, E2)) < 0) {
            return false;
        }
        boolean I = cVar.I(E, E2);
        g(G);
        Object current = getCurrent();
        if (current instanceof AnimationDrawable) {
            bVar = new e((AnimationDrawable) current, cVar.H(E, E2), I);
        } else if (current instanceof androidx.vectordrawable.graphics.drawable.e) {
            bVar = new d((androidx.vectordrawable.graphics.drawable.e) current);
        } else {
            if (current instanceof Animatable) {
                bVar = new b((Animatable) current);
            }
            return false;
        }
        bVar.c();
        this.f١٧٦٠٧p = bVar;
        this.f١٧٦٠٩r = c10;
        this.f١٧٦٠٨q = i10;
        return true;
    }

    private void s(TypedArray typedArray) {
        c cVar = this.f١٧٦٠٦o;
        cVar.f١٧٦٣٦d |= t1.a.b(typedArray);
        cVar.x(typedArray.getBoolean(R.styleable.AnimatedStateListDrawableCompat_android_variablePadding, cVar.f١٧٦٤١i));
        cVar.t(typedArray.getBoolean(R.styleable.AnimatedStateListDrawableCompat_android_constantSize, cVar.f١٧٦٤٤l));
        cVar.u(typedArray.getInt(R.styleable.AnimatedStateListDrawableCompat_android_enterFadeDuration, cVar.A));
        cVar.v(typedArray.getInt(R.styleable.AnimatedStateListDrawableCompat_android_exitFadeDuration, cVar.f١٧٦٣٢B));
        setDither(typedArray.getBoolean(R.styleable.AnimatedStateListDrawableCompat_android_dither, cVar.f١٧٦٥٦x));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // s1.e, s1.b
    public void h(b.d dVar) {
        super.h(dVar);
        if (dVar instanceof c) {
            this.f١٧٦٠٦o = (c) dVar;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // s1.b, android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        super.jumpToCurrentState();
        g gVar = this.f١٧٦٠٧p;
        if (gVar != null) {
            gVar.d();
            this.f١٧٦٠٧p = null;
            g(this.f١٧٦٠٨q);
            this.f١٧٦٠٨q = -1;
            this.f١٧٦٠٩r = -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // s1.b
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public c b() {
        return new c(this.f١٧٦٠٦o, this, null);
    }

    public void m(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        TypedArray k10 = k.k(resources, theme, attributeSet, R.styleable.AnimatedStateListDrawableCompat);
        setVisible(k10.getBoolean(R.styleable.AnimatedStateListDrawableCompat_android_visible, true), true);
        s(k10);
        i(resources);
        k10.recycle();
        n(context, resources, xmlPullParser, attributeSet, theme);
        o();
    }

    @Override // s1.e, s1.b, android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.f١٧٦١٠s && super.mutate() == this) {
            this.f١٧٦٠٦o.r();
            this.f١٧٦١٠s = true;
        }
        return this;
    }

    @Override // s1.e, android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        boolean z10;
        int F = this.f١٧٦٠٦o.F(iArr);
        if (F != c() && (r(F) || g(F))) {
            z10 = true;
        } else {
            z10 = false;
        }
        Drawable current = getCurrent();
        if (current != null) {
            return z10 | current.setState(iArr);
        }
        return z10;
    }

    @Override // s1.b, android.graphics.drawable.Drawable
    public boolean setVisible(boolean z10, boolean z11) {
        boolean visible = super.setVisible(z10, z11);
        g gVar = this.f١٧٦٠٧p;
        if (gVar != null && (visible || z11)) {
            if (z10) {
                gVar.c();
            } else {
                jumpToCurrentState();
            }
        }
        return visible;
    }

    a(c cVar, Resources resources) {
        super(null);
        this.f١٧٦٠٨q = -1;
        this.f١٧٦٠٩r = -1;
        h(new c(cVar, this, resources));
        onStateChange(getState());
        jumpToCurrentState();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static abstract class g {
        private g() {
        }

        public boolean a() {
            return false;
        }

        public abstract void c();

        public abstract void d();

        public void b() {
        }
    }
}
