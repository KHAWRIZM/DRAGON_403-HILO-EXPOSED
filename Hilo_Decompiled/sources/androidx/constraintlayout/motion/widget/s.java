package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.Log;
import android.util.Xml;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import androidx.constraintlayout.motion.widget.p;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R;
import androidx.constraintlayout.widget.c;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class s {

    /* renamed from: w, reason: collision with root package name */
    private static String f٢١٣٨w = "ViewTransition";

    /* renamed from: a, reason: collision with root package name */
    private int f٢١٣٩a;

    /* renamed from: e, reason: collision with root package name */
    int f٢١٤٣e;

    /* renamed from: f, reason: collision with root package name */
    g f٢١٤٤f;

    /* renamed from: g, reason: collision with root package name */
    c.a f٢١٤٥g;

    /* renamed from: j, reason: collision with root package name */
    private int f٢١٤٨j;

    /* renamed from: k, reason: collision with root package name */
    private String f٢١٤٩k;

    /* renamed from: o, reason: collision with root package name */
    Context f٢١٥٣o;

    /* renamed from: b, reason: collision with root package name */
    private int f٢١٤٠b = -1;

    /* renamed from: c, reason: collision with root package name */
    private boolean f٢١٤١c = false;

    /* renamed from: d, reason: collision with root package name */
    private int f٢١٤٢d = 0;

    /* renamed from: h, reason: collision with root package name */
    private int f٢١٤٦h = -1;

    /* renamed from: i, reason: collision with root package name */
    private int f٢١٤٧i = -1;

    /* renamed from: l, reason: collision with root package name */
    private int f٢١٥٠l = 0;

    /* renamed from: m, reason: collision with root package name */
    private String f٢١٥١m = null;

    /* renamed from: n, reason: collision with root package name */
    private int f٢١٥٢n = -1;

    /* renamed from: p, reason: collision with root package name */
    private int f٢١٥٤p = -1;

    /* renamed from: q, reason: collision with root package name */
    private int f٢١٥٥q = -1;

    /* renamed from: r, reason: collision with root package name */
    private int f٢١٥٦r = -1;

    /* renamed from: s, reason: collision with root package name */
    private int f٢١٥٧s = -1;

    /* renamed from: t, reason: collision with root package name */
    private int f٢١٥٨t = -1;

    /* renamed from: u, reason: collision with root package name */
    private int f٢١٥٩u = -1;

    /* renamed from: v, reason: collision with root package name */
    private int f٢١٦٠v = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class a implements Interpolator {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ a2.c f٢١٦١a;

        a(s sVar, a2.c cVar) {
            this.f٢١٦١a = cVar;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f10) {
            return (float) this.f٢١٦١a.a(f10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private final int f٢١٦٢a;

        /* renamed from: b, reason: collision with root package name */
        private final int f٢١٦٣b;

        /* renamed from: c, reason: collision with root package name */
        long f٢١٦٤c;

        /* renamed from: d, reason: collision with root package name */
        m f٢١٦٥d;

        /* renamed from: e, reason: collision with root package name */
        int f٢١٦٦e;

        /* renamed from: f, reason: collision with root package name */
        int f٢١٦٧f;

        /* renamed from: h, reason: collision with root package name */
        t f٢١٦٩h;

        /* renamed from: i, reason: collision with root package name */
        Interpolator f٢١٧٠i;

        /* renamed from: k, reason: collision with root package name */
        float f٢١٧٢k;

        /* renamed from: l, reason: collision with root package name */
        float f٢١٧٣l;

        /* renamed from: m, reason: collision with root package name */
        long f٢١٧٤m;

        /* renamed from: o, reason: collision with root package name */
        boolean f٢١٧٦o;

        /* renamed from: g, reason: collision with root package name */
        a2.d f٢١٦٨g = new a2.d();

        /* renamed from: j, reason: collision with root package name */
        boolean f٢١٧١j = false;

        /* renamed from: n, reason: collision with root package name */
        Rect f٢١٧٥n = new Rect();

        b(t tVar, m mVar, int i10, int i11, int i12, Interpolator interpolator, int i13, int i14) {
            float f10;
            this.f٢١٧٦o = false;
            this.f٢١٦٩h = tVar;
            this.f٢١٦٥d = mVar;
            this.f٢١٦٦e = i10;
            this.f٢١٦٧f = i11;
            long nanoTime = System.nanoTime();
            this.f٢١٦٤c = nanoTime;
            this.f٢١٧٤m = nanoTime;
            this.f٢١٦٩h.b(this);
            this.f٢١٧٠i = interpolator;
            this.f٢١٦٢a = i13;
            this.f٢١٦٣b = i14;
            if (i12 == 3) {
                this.f٢١٧٦o = true;
            }
            if (i10 == 0) {
                f10 = Float.MAX_VALUE;
            } else {
                f10 = 1.0f / i10;
            }
            this.f٢١٧٣l = f10;
            a();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a() {
            if (this.f٢١٧١j) {
                c();
            } else {
                b();
            }
        }

        void b() {
            float interpolation;
            long nanoTime = System.nanoTime();
            long j10 = nanoTime - this.f٢١٧٤m;
            this.f٢١٧٤m = nanoTime;
            float f10 = this.f٢١٧٢k + (((float) (j10 * 1.0E-6d)) * this.f٢١٧٣l);
            this.f٢١٧٢k = f10;
            if (f10 >= 1.0f) {
                this.f٢١٧٢k = 1.0f;
            }
            Interpolator interpolator = this.f٢١٧٠i;
            if (interpolator == null) {
                interpolation = this.f٢١٧٢k;
            } else {
                interpolation = interpolator.getInterpolation(this.f٢١٧٢k);
            }
            float f11 = interpolation;
            m mVar = this.f٢١٦٥d;
            boolean x10 = mVar.x(mVar.f٢٠٢٠b, f11, nanoTime, this.f٢١٦٨g);
            if (this.f٢١٧٢k >= 1.0f) {
                if (this.f٢١٦٢a != -1) {
                    this.f٢١٦٥d.v().setTag(this.f٢١٦٢a, Long.valueOf(System.nanoTime()));
                }
                if (this.f٢١٦٣b != -1) {
                    this.f٢١٦٥d.v().setTag(this.f٢١٦٣b, null);
                }
                if (!this.f٢١٧٦o) {
                    this.f٢١٦٩h.g(this);
                }
            }
            if (this.f٢١٧٢k < 1.0f || x10) {
                this.f٢١٦٩h.e();
            }
        }

        void c() {
            float interpolation;
            long nanoTime = System.nanoTime();
            long j10 = nanoTime - this.f٢١٧٤m;
            this.f٢١٧٤m = nanoTime;
            float f10 = this.f٢١٧٢k - (((float) (j10 * 1.0E-6d)) * this.f٢١٧٣l);
            this.f٢١٧٢k = f10;
            if (f10 < DownloadProgress.UNKNOWN_PROGRESS) {
                this.f٢١٧٢k = DownloadProgress.UNKNOWN_PROGRESS;
            }
            Interpolator interpolator = this.f٢١٧٠i;
            if (interpolator == null) {
                interpolation = this.f٢١٧٢k;
            } else {
                interpolation = interpolator.getInterpolation(this.f٢١٧٢k);
            }
            float f11 = interpolation;
            m mVar = this.f٢١٦٥d;
            boolean x10 = mVar.x(mVar.f٢٠٢٠b, f11, nanoTime, this.f٢١٦٨g);
            if (this.f٢١٧٢k <= DownloadProgress.UNKNOWN_PROGRESS) {
                if (this.f٢١٦٢a != -1) {
                    this.f٢١٦٥d.v().setTag(this.f٢١٦٢a, Long.valueOf(System.nanoTime()));
                }
                if (this.f٢١٦٣b != -1) {
                    this.f٢١٦٥d.v().setTag(this.f٢١٦٣b, null);
                }
                this.f٢١٦٩h.g(this);
            }
            if (this.f٢١٧٢k > DownloadProgress.UNKNOWN_PROGRESS || x10) {
                this.f٢١٦٩h.e();
            }
        }

        public void d(int i10, float f10, float f11) {
            if (i10 != 1) {
                if (i10 == 2) {
                    this.f٢١٦٥d.v().getHitRect(this.f٢١٧٥n);
                    if (!this.f٢١٧٥n.contains((int) f10, (int) f11) && !this.f٢١٧١j) {
                        e(true);
                        return;
                    }
                    return;
                }
                return;
            }
            if (!this.f٢١٧١j) {
                e(true);
            }
        }

        void e(boolean z10) {
            int i10;
            float f10;
            this.f٢١٧١j = z10;
            if (z10 && (i10 = this.f٢١٦٧f) != -1) {
                if (i10 == 0) {
                    f10 = Float.MAX_VALUE;
                } else {
                    f10 = 1.0f / i10;
                }
                this.f٢١٧٣l = f10;
            }
            this.f٢١٦٩h.e();
            this.f٢١٧٤m = System.nanoTime();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Failed to find 'out' block for switch in B:19:0x0051. Please report as an issue. */
    public s(Context context, XmlPullParser xmlPullParser) {
        char c10;
        this.f٢١٥٣o = context;
        try {
            int eventType = xmlPullParser.getEventType();
            while (eventType != 1) {
                if (eventType != 2) {
                    if (eventType != 3) {
                        continue;
                    } else if ("ViewTransition".equals(xmlPullParser.getName())) {
                        return;
                    }
                } else {
                    String name = xmlPullParser.getName();
                    switch (name.hashCode()) {
                        case -1962203927:
                            if (name.equals("ConstraintOverride")) {
                                c10 = 2;
                                break;
                            }
                            c10 = 65535;
                            break;
                        case -1239391468:
                            if (name.equals("KeyFrameSet")) {
                                c10 = 1;
                                break;
                            }
                            c10 = 65535;
                            break;
                        case 61998586:
                            if (name.equals("ViewTransition")) {
                                c10 = 0;
                                break;
                            }
                            c10 = 65535;
                            break;
                        case 366511058:
                            if (name.equals("CustomMethod")) {
                                c10 = 4;
                                break;
                            }
                            c10 = 65535;
                            break;
                        case 1791837707:
                            if (name.equals("CustomAttribute")) {
                                c10 = 3;
                                break;
                            }
                            c10 = 65535;
                            break;
                        default:
                            c10 = 65535;
                            break;
                    }
                    if (c10 != 0) {
                        if (c10 != 1) {
                            if (c10 != 2) {
                                if (c10 != 3 && c10 != 4) {
                                    Log.e(f٢١٣٨w, androidx.constraintlayout.motion.widget.a.a() + " unknown tag " + name);
                                    Log.e(f٢١٣٨w, ".xml:" + xmlPullParser.getLineNumber());
                                } else {
                                    androidx.constraintlayout.widget.a.h(context, xmlPullParser, this.f٢١٤٥g.f٢٤٢١g);
                                }
                            } else {
                                this.f٢١٤٥g = androidx.constraintlayout.widget.c.m(context, xmlPullParser);
                            }
                        } else {
                            this.f٢١٤٤f = new g(context, xmlPullParser);
                        }
                    } else {
                        l(context, xmlPullParser);
                    }
                }
                eventType = xmlPullParser.next();
            }
        } catch (IOException e10) {
            e10.printStackTrace();
        } catch (XmlPullParserException e11) {
            e11.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j(View[] viewArr) {
        if (this.f٢١٥٤p != -1) {
            for (View view : viewArr) {
                view.setTag(this.f٢١٥٤p, Long.valueOf(System.nanoTime()));
            }
        }
        if (this.f٢١٥٥q != -1) {
            for (View view2 : viewArr) {
                view2.setTag(this.f٢١٥٥q, null);
            }
        }
    }

    private void l(Context context, XmlPullParser xmlPullParser) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.ViewTransition);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i10 = 0; i10 < indexCount; i10++) {
            int index = obtainStyledAttributes.getIndex(i10);
            if (index == R.styleable.ViewTransition_android_id) {
                this.f٢١٣٩a = obtainStyledAttributes.getResourceId(index, this.f٢١٣٩a);
            } else if (index == R.styleable.ViewTransition_motionTarget) {
                if (MotionLayout.E0) {
                    int resourceId = obtainStyledAttributes.getResourceId(index, this.f٢١٤٨j);
                    this.f٢١٤٨j = resourceId;
                    if (resourceId == -1) {
                        this.f٢١٤٩k = obtainStyledAttributes.getString(index);
                    }
                } else if (obtainStyledAttributes.peekValue(index).type == 3) {
                    this.f٢١٤٩k = obtainStyledAttributes.getString(index);
                } else {
                    this.f٢١٤٨j = obtainStyledAttributes.getResourceId(index, this.f٢١٤٨j);
                }
            } else if (index == R.styleable.ViewTransition_onStateTransition) {
                this.f٢١٤٠b = obtainStyledAttributes.getInt(index, this.f٢١٤٠b);
            } else if (index == R.styleable.ViewTransition_transitionDisable) {
                this.f٢١٤١c = obtainStyledAttributes.getBoolean(index, this.f٢١٤١c);
            } else if (index == R.styleable.ViewTransition_pathMotionArc) {
                this.f٢١٤٢d = obtainStyledAttributes.getInt(index, this.f٢١٤٢d);
            } else if (index == R.styleable.ViewTransition_duration) {
                this.f٢١٤٦h = obtainStyledAttributes.getInt(index, this.f٢١٤٦h);
            } else if (index == R.styleable.ViewTransition_upDuration) {
                this.f٢١٤٧i = obtainStyledAttributes.getInt(index, this.f٢١٤٧i);
            } else if (index == R.styleable.ViewTransition_viewTransitionMode) {
                this.f٢١٤٣e = obtainStyledAttributes.getInt(index, this.f٢١٤٣e);
            } else if (index == R.styleable.ViewTransition_motionInterpolator) {
                int i11 = obtainStyledAttributes.peekValue(index).type;
                if (i11 == 1) {
                    int resourceId2 = obtainStyledAttributes.getResourceId(index, -1);
                    this.f٢١٥٢n = resourceId2;
                    if (resourceId2 != -1) {
                        this.f٢١٥٠l = -2;
                    }
                } else if (i11 == 3) {
                    String string = obtainStyledAttributes.getString(index);
                    this.f٢١٥١m = string;
                    if (string != null && string.indexOf("/") > 0) {
                        this.f٢١٥٢n = obtainStyledAttributes.getResourceId(index, -1);
                        this.f٢١٥٠l = -2;
                    } else {
                        this.f٢١٥٠l = -1;
                    }
                } else {
                    this.f٢١٥٠l = obtainStyledAttributes.getInteger(index, this.f٢١٥٠l);
                }
            } else if (index == R.styleable.ViewTransition_setsTag) {
                this.f٢١٥٤p = obtainStyledAttributes.getResourceId(index, this.f٢١٥٤p);
            } else if (index == R.styleable.ViewTransition_clearsTag) {
                this.f٢١٥٥q = obtainStyledAttributes.getResourceId(index, this.f٢١٥٥q);
            } else if (index == R.styleable.ViewTransition_ifTagSet) {
                this.f٢١٥٦r = obtainStyledAttributes.getResourceId(index, this.f٢١٥٦r);
            } else if (index == R.styleable.ViewTransition_ifTagNotSet) {
                this.f٢١٥٧s = obtainStyledAttributes.getResourceId(index, this.f٢١٥٧s);
            } else if (index == R.styleable.ViewTransition_SharedValueId) {
                this.f٢١٥٩u = obtainStyledAttributes.getResourceId(index, this.f٢١٥٩u);
            } else if (index == R.styleable.ViewTransition_SharedValue) {
                this.f٢١٥٨t = obtainStyledAttributes.getInteger(index, this.f٢١٥٨t);
            }
        }
        obtainStyledAttributes.recycle();
    }

    private void n(p.b bVar, View view) {
        int i10 = this.f٢١٤٦h;
        if (i10 != -1) {
            bVar.E(i10);
        }
        bVar.H(this.f٢١٤٢d);
        bVar.F(this.f٢١٥٠l, this.f٢١٥١m, this.f٢١٥٢n);
        int id = view.getId();
        g gVar = this.f٢١٤٤f;
        if (gVar != null) {
            ArrayList d10 = gVar.d(-1);
            g gVar2 = new g();
            Iterator it = d10.iterator();
            while (it.hasNext()) {
                gVar2.c(((d) it.next()).clone().i(id));
            }
            bVar.t(gVar2);
        }
    }

    void b(t tVar, MotionLayout motionLayout, View view) {
        m mVar = new m(view);
        mVar.B(view);
        this.f٢١٤٤f.a(mVar);
        mVar.I(motionLayout.getWidth(), motionLayout.getHeight(), this.f٢١٤٦h, System.nanoTime());
        new b(tVar, mVar, this.f٢١٤٦h, this.f٢١٤٧i, this.f٢١٤٠b, f(motionLayout.getContext()), this.f٢١٥٤p, this.f٢١٥٥q);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(t tVar, MotionLayout motionLayout, int i10, androidx.constraintlayout.widget.c cVar, final View... viewArr) {
        if (this.f٢١٤١c) {
            return;
        }
        int i11 = this.f٢١٤٣e;
        if (i11 == 2) {
            b(tVar, motionLayout, viewArr[0]);
            return;
        }
        if (i11 == 1) {
            for (int i12 : motionLayout.getConstraintSetIds()) {
                if (i12 != i10) {
                    androidx.constraintlayout.widget.c X = motionLayout.X(i12);
                    for (View view : viewArr) {
                        c.a w10 = X.w(view.getId());
                        c.a aVar = this.f٢١٤٥g;
                        if (aVar != null) {
                            aVar.d(w10);
                            w10.f٢٤٢١g.putAll(this.f٢١٤٥g.f٢٤٢١g);
                        }
                    }
                }
            }
        }
        androidx.constraintlayout.widget.c cVar2 = new androidx.constraintlayout.widget.c();
        cVar2.p(cVar);
        for (View view2 : viewArr) {
            c.a w11 = cVar2.w(view2.getId());
            c.a aVar2 = this.f٢١٤٥g;
            if (aVar2 != null) {
                aVar2.d(w11);
                w11.f٢٤٢١g.putAll(this.f٢١٤٥g.f٢٤٢١g);
            }
        }
        motionLayout.u0(i10, cVar2);
        int i13 = R.id.view_transition;
        motionLayout.u0(i13, cVar);
        motionLayout.setState(i13, -1, -1);
        p.b bVar = new p.b(-1, motionLayout.f١٨٤٠a, i13, i10);
        for (View view3 : viewArr) {
            n(bVar, view3);
        }
        motionLayout.setTransition(bVar);
        motionLayout.o0(new Runnable() { // from class: androidx.constraintlayout.motion.widget.r
            @Override // java.lang.Runnable
            public final void run() {
                s.this.j(viewArr);
            }
        });
    }

    boolean d(View view) {
        boolean z10;
        boolean z11;
        int i10 = this.f٢١٥٦r;
        if (i10 == -1 || view.getTag(i10) != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        int i11 = this.f٢١٥٧s;
        if (i11 == -1 || view.getTag(i11) == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z10 || !z11) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int e() {
        return this.f٢١٣٩a;
    }

    Interpolator f(Context context) {
        int i10 = this.f٢١٥٠l;
        if (i10 != -2) {
            if (i10 != -1) {
                if (i10 != 0) {
                    if (i10 != 1) {
                        if (i10 != 2) {
                            if (i10 != 4) {
                                if (i10 != 5) {
                                    if (i10 != 6) {
                                        return null;
                                    }
                                    return new AnticipateInterpolator();
                                }
                                return new OvershootInterpolator();
                            }
                            return new BounceInterpolator();
                        }
                        return new DecelerateInterpolator();
                    }
                    return new AccelerateInterpolator();
                }
                return new AccelerateDecelerateInterpolator();
            }
            return new a(this, a2.c.c(this.f٢١٥١m));
        }
        return AnimationUtils.loadInterpolator(context, this.f٢١٥٢n);
    }

    public int g() {
        return this.f٢١٥٨t;
    }

    public int h() {
        return this.f٢١٥٩u;
    }

    public int i() {
        return this.f٢١٤٠b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean k(View view) {
        String str;
        if (view == null) {
            return false;
        }
        if ((this.f٢١٤٨j == -1 && this.f٢١٤٩k == null) || !d(view)) {
            return false;
        }
        if (view.getId() == this.f٢١٤٨j) {
            return true;
        }
        if (this.f٢١٤٩k == null || !(view.getLayoutParams() instanceof ConstraintLayout.b) || (str = ((ConstraintLayout.b) view.getLayoutParams()).f٢٣٠٤c0) == null || !str.matches(this.f٢١٤٩k)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean m(int i10) {
        int i11 = this.f٢١٤٠b;
        if (i11 == 1) {
            if (i10 != 0) {
                return false;
            }
            return true;
        }
        if (i11 == 2) {
            if (i10 != 1) {
                return false;
            }
            return true;
        }
        if (i11 != 3 || i10 != 0) {
            return false;
        }
        return true;
    }

    public String toString() {
        return "ViewTransition(" + androidx.constraintlayout.motion.widget.a.c(this.f٢١٥٣o, this.f٢١٣٩a) + ")";
    }
}
