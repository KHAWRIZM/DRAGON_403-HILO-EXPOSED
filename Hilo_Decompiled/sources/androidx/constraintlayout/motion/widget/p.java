package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.R;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class p {

    /* renamed from: a, reason: collision with root package name */
    private final MotionLayout f٢٠٦٦a;

    /* renamed from: n, reason: collision with root package name */
    private MotionEvent f٢٠٧٩n;

    /* renamed from: q, reason: collision with root package name */
    private MotionLayout.h f٢٠٨٢q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f٢٠٨٣r;

    /* renamed from: s, reason: collision with root package name */
    final t f٢٠٨٤s;

    /* renamed from: t, reason: collision with root package name */
    float f٢٠٨٥t;

    /* renamed from: u, reason: collision with root package name */
    float f٢٠٨٦u;

    /* renamed from: b, reason: collision with root package name */
    androidx.constraintlayout.widget.f f٢٠٦٧b = null;

    /* renamed from: c, reason: collision with root package name */
    b f٢٠٦٨c = null;

    /* renamed from: d, reason: collision with root package name */
    private boolean f٢٠٦٩d = false;

    /* renamed from: e, reason: collision with root package name */
    private ArrayList f٢٠٧٠e = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    private b f٢٠٧١f = null;

    /* renamed from: g, reason: collision with root package name */
    private ArrayList f٢٠٧٢g = new ArrayList();

    /* renamed from: h, reason: collision with root package name */
    private SparseArray f٢٠٧٣h = new SparseArray();

    /* renamed from: i, reason: collision with root package name */
    private HashMap f٢٠٧٤i = new HashMap();

    /* renamed from: j, reason: collision with root package name */
    private SparseIntArray f٢٠٧٥j = new SparseIntArray();

    /* renamed from: k, reason: collision with root package name */
    private boolean f٢٠٧٦k = false;

    /* renamed from: l, reason: collision with root package name */
    private int f٢٠٧٧l = 400;

    /* renamed from: m, reason: collision with root package name */
    private int f٢٠٧٨m = 0;

    /* renamed from: o, reason: collision with root package name */
    private boolean f٢٠٨٠o = false;

    /* renamed from: p, reason: collision with root package name */
    private boolean f٢٠٨١p = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class a implements Interpolator {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ a2.c f٢٠٨٧a;

        a(p pVar, a2.c cVar) {
            this.f٢٠٨٧a = cVar;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f10) {
            return (float) this.f٢٠٨٧a.a(f10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(Context context, MotionLayout motionLayout, int i10) {
        this.f٢٠٦٦a = motionLayout;
        this.f٢٠٨٤s = new t(motionLayout);
        K(context, i10);
        SparseArray sparseArray = this.f٢٠٧٣h;
        int i11 = R.id.motion_base;
        sparseArray.put(i11, new androidx.constraintlayout.widget.c());
        this.f٢٠٧٤i.put("motion_base", Integer.valueOf(i11));
    }

    private boolean I(int i10) {
        int i11 = this.f٢٠٧٥j.get(i10);
        int size = this.f٢٠٧٥j.size();
        while (i11 > 0) {
            if (i11 == i10) {
                return true;
            }
            int i12 = size - 1;
            if (size < 0) {
                return true;
            }
            i11 = this.f٢٠٧٥j.get(i11);
            size = i12;
        }
        return false;
    }

    private boolean J() {
        if (this.f٢٠٨٢q != null) {
            return true;
        }
        return false;
    }

    private void K(Context context, int i10) {
        XmlResourceParser xml = context.getResources().getXml(i10);
        try {
            int eventType = xml.getEventType();
            b bVar = null;
            while (true) {
                char c10 = 1;
                if (eventType != 1) {
                    if (eventType != 0) {
                        if (eventType == 2) {
                            String name = xml.getName();
                            if (this.f٢٠٧٦k) {
                                System.out.println("parsing = " + name);
                            }
                            switch (name.hashCode()) {
                                case -1349929691:
                                    if (name.equals("ConstraintSet")) {
                                        c10 = 5;
                                        break;
                                    }
                                    break;
                                case -1239391468:
                                    if (name.equals("KeyFrameSet")) {
                                        c10 = '\b';
                                        break;
                                    }
                                    break;
                                case -687739768:
                                    if (name.equals("Include")) {
                                        c10 = 7;
                                        break;
                                    }
                                    break;
                                case 61998586:
                                    if (name.equals("ViewTransition")) {
                                        c10 = '\t';
                                        break;
                                    }
                                    break;
                                case 269306229:
                                    if (name.equals("Transition")) {
                                        break;
                                    }
                                    break;
                                case 312750793:
                                    if (name.equals("OnClick")) {
                                        c10 = 3;
                                        break;
                                    }
                                    break;
                                case 327855227:
                                    if (name.equals("OnSwipe")) {
                                        c10 = 2;
                                        break;
                                    }
                                    break;
                                case 793277014:
                                    if (name.equals("MotionScene")) {
                                        c10 = 0;
                                        break;
                                    }
                                    break;
                                case 1382829617:
                                    if (name.equals("StateSet")) {
                                        c10 = 4;
                                        break;
                                    }
                                    break;
                                case 1942574248:
                                    if (name.equals("include")) {
                                        c10 = 6;
                                        break;
                                    }
                                    break;
                            }
                            c10 = 65535;
                            switch (c10) {
                                case 0:
                                    O(context, xml);
                                    break;
                                case 1:
                                    ArrayList arrayList = this.f٢٠٧٠e;
                                    bVar = new b(this, context, xml);
                                    arrayList.add(bVar);
                                    if (this.f٢٠٦٨c == null && !bVar.f٢٠٨٩b) {
                                        this.f٢٠٦٨c = bVar;
                                        if (bVar.f٢٠٩٩l != null) {
                                            this.f٢٠٦٨c.f٢٠٩٩l.x(this.f٢٠٨٣r);
                                        }
                                    }
                                    if (!bVar.f٢٠٨٩b) {
                                        break;
                                    } else {
                                        if (bVar.f٢٠٩٠c == -1) {
                                            this.f٢٠٧١f = bVar;
                                        } else {
                                            this.f٢٠٧٢g.add(bVar);
                                        }
                                        this.f٢٠٧٠e.remove(bVar);
                                        break;
                                    }
                                case 2:
                                    if (bVar == null) {
                                        Log.v("MotionScene", " OnSwipe (" + context.getResources().getResourceEntryName(i10) + ".xml:" + xml.getLineNumber() + ")");
                                    }
                                    if (bVar == null) {
                                        break;
                                    } else {
                                        bVar.f٢٠٩٩l = new q(context, this.f٢٠٦٦a, xml);
                                        break;
                                    }
                                case 3:
                                    if (bVar == null) {
                                        break;
                                    } else {
                                        bVar.u(context, xml);
                                        break;
                                    }
                                case 4:
                                    this.f٢٠٦٧b = new androidx.constraintlayout.widget.f(context, xml);
                                    break;
                                case 5:
                                    L(context, xml);
                                    break;
                                case 6:
                                case 7:
                                    N(context, xml);
                                    break;
                                case '\b':
                                    g gVar = new g(context, xml);
                                    if (bVar == null) {
                                        break;
                                    } else {
                                        bVar.f٢٠٩٨k.add(gVar);
                                        break;
                                    }
                                case '\t':
                                    this.f٢٠٨٤s.a(new s(context, xml));
                                    break;
                            }
                        }
                    } else {
                        xml.getName();
                    }
                    eventType = xml.next();
                } else {
                    return;
                }
            }
        } catch (IOException e10) {
            e10.printStackTrace();
        } catch (XmlPullParserException e11) {
            e11.printStackTrace();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:23:0x00d1. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:9:0x0068. Please report as an issue. */
    private int L(Context context, XmlPullParser xmlPullParser) {
        char c10;
        char c11;
        androidx.constraintlayout.widget.c cVar = new androidx.constraintlayout.widget.c();
        cVar.R(false);
        int attributeCount = xmlPullParser.getAttributeCount();
        int i10 = -1;
        int i11 = -1;
        for (int i12 = 0; i12 < attributeCount; i12++) {
            String attributeName = xmlPullParser.getAttributeName(i12);
            String attributeValue = xmlPullParser.getAttributeValue(i12);
            if (this.f٢٠٧٦k) {
                System.out.println("id string = " + attributeValue);
            }
            attributeName.hashCode();
            switch (attributeName.hashCode()) {
                case -1496482599:
                    if (attributeName.equals("deriveConstraintsFrom")) {
                        c10 = 0;
                        break;
                    }
                    break;
                case -1153153640:
                    if (attributeName.equals("constraintRotate")) {
                        c10 = 1;
                        break;
                    }
                    break;
                case 3355:
                    if (attributeName.equals("id")) {
                        c10 = 2;
                        break;
                    }
                    break;
            }
            c10 = 65535;
            switch (c10) {
                case 0:
                    i11 = r(context, attributeValue);
                    break;
                case 1:
                    try {
                        cVar.f٢٤١١d = Integer.parseInt(attributeValue);
                    } catch (NumberFormatException unused) {
                        attributeValue.hashCode();
                        switch (attributeValue.hashCode()) {
                            case -768416914:
                                if (attributeValue.equals("x_left")) {
                                    c11 = 0;
                                    break;
                                }
                                break;
                            case 3317767:
                                if (attributeValue.equals(ViewHierarchyConstants.DIMENSION_LEFT_KEY)) {
                                    c11 = 1;
                                    break;
                                }
                                break;
                            case 3387192:
                                if (attributeValue.equals("none")) {
                                    c11 = 2;
                                    break;
                                }
                                break;
                            case 108511772:
                                if (attributeValue.equals("right")) {
                                    c11 = 3;
                                    break;
                                }
                                break;
                            case 1954540437:
                                if (attributeValue.equals("x_right")) {
                                    c11 = 4;
                                    break;
                                }
                                break;
                        }
                        c11 = 65535;
                        switch (c11) {
                            case 0:
                                cVar.f٢٤١١d = 4;
                                break;
                            case 1:
                                cVar.f٢٤١١d = 2;
                                break;
                            case 2:
                                cVar.f٢٤١١d = 0;
                                break;
                            case 3:
                                cVar.f٢٤١١d = 1;
                                break;
                            case 4:
                                cVar.f٢٤١١d = 3;
                                break;
                        }
                    }
                    break;
                case 2:
                    i10 = r(context, attributeValue);
                    this.f٢٠٧٤i.put(a0(attributeValue), Integer.valueOf(i10));
                    cVar.f٢٤٠٩b = androidx.constraintlayout.motion.widget.a.c(context, i10);
                    break;
            }
        }
        if (i10 != -1) {
            if (this.f٢٠٦٦a.f١٨٨٦x != 0) {
                cVar.S(true);
            }
            cVar.E(context, xmlPullParser);
            if (i11 != -1) {
                this.f٢٠٧٥j.put(i10, i11);
            }
            this.f٢٠٧٣h.put(i10, cVar);
        }
        return i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int M(Context context, int i10) {
        XmlResourceParser xml = context.getResources().getXml(i10);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                String name = xml.getName();
                if (2 == eventType && "ConstraintSet".equals(name)) {
                    return L(context, xml);
                }
            }
            return -1;
        } catch (IOException e10) {
            e10.printStackTrace();
            return -1;
        } catch (XmlPullParserException e11) {
            e11.printStackTrace();
            return -1;
        }
    }

    private void N(Context context, XmlPullParser xmlPullParser) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.include);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i10 = 0; i10 < indexCount; i10++) {
            int index = obtainStyledAttributes.getIndex(i10);
            if (index == R.styleable.include_constraintSet) {
                M(context, obtainStyledAttributes.getResourceId(index, -1));
            }
        }
        obtainStyledAttributes.recycle();
    }

    private void O(Context context, XmlPullParser xmlPullParser) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.MotionScene);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i10 = 0; i10 < indexCount; i10++) {
            int index = obtainStyledAttributes.getIndex(i10);
            if (index == R.styleable.MotionScene_defaultDuration) {
                int i11 = obtainStyledAttributes.getInt(index, this.f٢٠٧٧l);
                this.f٢٠٧٧l = i11;
                if (i11 < 8) {
                    this.f٢٠٧٧l = 8;
                }
            } else if (index == R.styleable.MotionScene_layoutDuringTransition) {
                this.f٢٠٧٨m = obtainStyledAttributes.getInteger(index, 0);
            }
        }
        obtainStyledAttributes.recycle();
    }

    private void S(int i10, MotionLayout motionLayout) {
        androidx.constraintlayout.widget.c cVar = (androidx.constraintlayout.widget.c) this.f٢٠٧٣h.get(i10);
        cVar.f٢٤١٠c = cVar.f٢٤٠٩b;
        int i11 = this.f٢٠٧٥j.get(i10);
        if (i11 > 0) {
            S(i11, motionLayout);
            androidx.constraintlayout.widget.c cVar2 = (androidx.constraintlayout.widget.c) this.f٢٠٧٣h.get(i11);
            if (cVar2 == null) {
                Log.e("MotionScene", "ERROR! invalid deriveConstraintsFrom: @id/" + androidx.constraintlayout.motion.widget.a.c(this.f٢٠٦٦a.getContext(), i11));
                return;
            }
            cVar.f٢٤١٠c += "/" + cVar2.f٢٤١٠c;
            cVar.M(cVar2);
        } else {
            cVar.f٢٤١٠c += "  layout";
            cVar.L(motionLayout);
        }
        cVar.h(cVar);
    }

    public static String a0(String str) {
        if (str == null) {
            return "";
        }
        int indexOf = str.indexOf(47);
        if (indexOf < 0) {
            return str;
        }
        return str.substring(indexOf + 1);
    }

    private int r(Context context, String str) {
        int i10;
        if (str.contains("/")) {
            i10 = context.getResources().getIdentifier(str.substring(str.indexOf(47) + 1), "id", context.getPackageName());
            if (this.f٢٠٧٦k) {
                System.out.println("id getMap res = " + i10);
            }
        } else {
            i10 = -1;
        }
        if (i10 == -1) {
            if (str.length() > 1) {
                return Integer.parseInt(str.substring(1));
            }
            Log.e("MotionScene", "error in parsing id");
            return i10;
        }
        return i10;
    }

    private int y(int i10) {
        int c10;
        androidx.constraintlayout.widget.f fVar = this.f٢٠٦٧b;
        if (fVar != null && (c10 = fVar.c(i10, -1, -1)) != -1) {
            return c10;
        }
        return i10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float A() {
        b bVar = this.f٢٠٦٨c;
        if (bVar != null && bVar.f٢٠٩٩l != null) {
            return this.f٢٠٦٨c.f٢٠٩٩l.l();
        }
        return DownloadProgress.UNKNOWN_PROGRESS;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float B() {
        b bVar = this.f٢٠٦٨c;
        if (bVar != null && bVar.f٢٠٩٩l != null) {
            return this.f٢٠٦٨c.f٢٠٩٩l.m();
        }
        return DownloadProgress.UNKNOWN_PROGRESS;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float C() {
        b bVar = this.f٢٠٦٨c;
        if (bVar != null && bVar.f٢٠٩٩l != null) {
            return this.f٢٠٦٨c.f٢٠٩٩l.n();
        }
        return DownloadProgress.UNKNOWN_PROGRESS;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float D() {
        b bVar = this.f٢٠٦٨c;
        if (bVar != null && bVar.f٢٠٩٩l != null) {
            return this.f٢٠٦٨c.f٢٠٩٩l.o();
        }
        return DownloadProgress.UNKNOWN_PROGRESS;
    }

    public float E() {
        b bVar = this.f٢٠٦٨c;
        if (bVar != null) {
            return bVar.f٢٠٩٦i;
        }
        return DownloadProgress.UNKNOWN_PROGRESS;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int F() {
        b bVar = this.f٢٠٦٨c;
        if (bVar != null) {
            return bVar.f٢٠٩١d;
        }
        return -1;
    }

    public b G(int i10) {
        Iterator it = this.f٢٠٧٠e.iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            if (bVar.f٢٠٨٨a == i10) {
                return bVar;
            }
        }
        return null;
    }

    public List H(int i10) {
        int y10 = y(i10);
        ArrayList arrayList = new ArrayList();
        Iterator it = this.f٢٠٧٠e.iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            if (bVar.f٢٠٩١d == y10 || bVar.f٢٠٩٠c == y10) {
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void P(float f10, float f11) {
        b bVar = this.f٢٠٦٨c;
        if (bVar != null && bVar.f٢٠٩٩l != null) {
            this.f٢٠٦٨c.f٢٠٩٩l.u(f10, f11);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Q(float f10, float f11) {
        b bVar = this.f٢٠٦٨c;
        if (bVar != null && bVar.f٢٠٩٩l != null) {
            this.f٢٠٦٨c.f٢٠٩٩l.v(f10, f11);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void R(MotionEvent motionEvent, int i10, MotionLayout motionLayout) {
        MotionLayout.h hVar;
        MotionEvent motionEvent2;
        RectF rectF = new RectF();
        if (this.f٢٠٨٢q == null) {
            this.f٢٠٨٢q = this.f٢٠٦٦a.e0();
        }
        this.f٢٠٨٢q.a(motionEvent);
        if (i10 != -1) {
            int action = motionEvent.getAction();
            boolean z10 = false;
            if (action != 0) {
                if (action == 2 && !this.f٢٠٨٠o) {
                    float rawY = motionEvent.getRawY() - this.f٢٠٨٦u;
                    float rawX = motionEvent.getRawX() - this.f٢٠٨٥t;
                    if ((rawX == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE && rawY == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) || (motionEvent2 = this.f٢٠٧٩n) == null) {
                        return;
                    }
                    b i11 = i(i10, rawX, rawY, motionEvent2);
                    if (i11 != null) {
                        motionLayout.setTransition(i11);
                        RectF p10 = this.f٢٠٦٨c.f٢٠٩٩l.p(this.f٢٠٦٦a, rectF);
                        if (p10 != null && !p10.contains(this.f٢٠٧٩n.getX(), this.f٢٠٧٩n.getY())) {
                            z10 = true;
                        }
                        this.f٢٠٨١p = z10;
                        this.f٢٠٦٨c.f٢٠٩٩l.z(this.f٢٠٨٥t, this.f٢٠٨٦u);
                    }
                }
            } else {
                this.f٢٠٨٥t = motionEvent.getRawX();
                this.f٢٠٨٦u = motionEvent.getRawY();
                this.f٢٠٧٩n = motionEvent;
                this.f٢٠٨٠o = false;
                if (this.f٢٠٦٨c.f٢٠٩٩l != null) {
                    RectF f10 = this.f٢٠٦٨c.f٢٠٩٩l.f(this.f٢٠٦٦a, rectF);
                    if (f10 != null && !f10.contains(this.f٢٠٧٩n.getX(), this.f٢٠٧٩n.getY())) {
                        this.f٢٠٧٩n = null;
                        this.f٢٠٨٠o = true;
                        return;
                    }
                    RectF p11 = this.f٢٠٦٨c.f٢٠٩٩l.p(this.f٢٠٦٦a, rectF);
                    if (p11 != null && !p11.contains(this.f٢٠٧٩n.getX(), this.f٢٠٧٩n.getY())) {
                        this.f٢٠٨١p = true;
                    } else {
                        this.f٢٠٨١p = false;
                    }
                    this.f٢٠٦٨c.f٢٠٩٩l.w(this.f٢٠٨٥t, this.f٢٠٨٦u);
                    return;
                }
                return;
            }
        }
        if (this.f٢٠٨٠o) {
            return;
        }
        b bVar = this.f٢٠٦٨c;
        if (bVar != null && bVar.f٢٠٩٩l != null && !this.f٢٠٨١p) {
            this.f٢٠٦٨c.f٢٠٩٩l.s(motionEvent, this.f٢٠٨٢q, i10, this);
        }
        this.f٢٠٨٥t = motionEvent.getRawX();
        this.f٢٠٨٦u = motionEvent.getRawY();
        if (motionEvent.getAction() == 1 && (hVar = this.f٢٠٨٢q) != null) {
            hVar.recycle();
            this.f٢٠٨٢q = null;
            int i12 = motionLayout.f١٨٥٠f;
            if (i12 != -1) {
                h(motionLayout, i12);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void T(MotionLayout motionLayout) {
        for (int i10 = 0; i10 < this.f٢٠٧٣h.size(); i10++) {
            int keyAt = this.f٢٠٧٣h.keyAt(i10);
            if (I(keyAt)) {
                Log.e("MotionScene", "Cannot be derived from yourself");
                return;
            }
            S(keyAt, motionLayout);
        }
    }

    public void U(int i10, androidx.constraintlayout.widget.c cVar) {
        this.f٢٠٧٣h.put(i10, cVar);
    }

    public void V(int i10) {
        b bVar = this.f٢٠٦٨c;
        if (bVar != null) {
            bVar.E(i10);
        } else {
            this.f٢٠٧٧l = i10;
        }
    }

    public void W(boolean z10) {
        this.f٢٠٨٣r = z10;
        b bVar = this.f٢٠٦٨c;
        if (bVar != null && bVar.f٢٠٩٩l != null) {
            this.f٢٠٦٨c.f٢٠٩٩l.x(this.f٢٠٨٣r);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0013, code lost:
    
        if (r2 != (-1)) goto L١٣;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void X(int i10, int i11) {
        int i12;
        int i13;
        androidx.constraintlayout.widget.f fVar = this.f٢٠٦٧b;
        if (fVar != null) {
            i12 = fVar.c(i10, -1, -1);
            if (i12 == -1) {
                i12 = i10;
            }
            i13 = this.f٢٠٦٧b.c(i11, -1, -1);
        } else {
            i12 = i10;
        }
        i13 = i11;
        b bVar = this.f٢٠٦٨c;
        if (bVar != null && bVar.f٢٠٩٠c == i11 && this.f٢٠٦٨c.f٢٠٩١d == i10) {
            return;
        }
        Iterator it = this.f٢٠٧٠e.iterator();
        while (it.hasNext()) {
            b bVar2 = (b) it.next();
            if ((bVar2.f٢٠٩٠c == i13 && bVar2.f٢٠٩١d == i12) || (bVar2.f٢٠٩٠c == i11 && bVar2.f٢٠٩١d == i10)) {
                this.f٢٠٦٨c = bVar2;
                if (bVar2 != null && bVar2.f٢٠٩٩l != null) {
                    this.f٢٠٦٨c.f٢٠٩٩l.x(this.f٢٠٨٣r);
                    return;
                }
                return;
            }
        }
        b bVar3 = this.f٢٠٧١f;
        Iterator it2 = this.f٢٠٧٢g.iterator();
        while (it2.hasNext()) {
            b bVar4 = (b) it2.next();
            if (bVar4.f٢٠٩٠c == i11) {
                bVar3 = bVar4;
            }
        }
        b bVar5 = new b(this, bVar3);
        bVar5.f٢٠٩١d = i12;
        bVar5.f٢٠٩٠c = i13;
        if (i12 != -1) {
            this.f٢٠٧٠e.add(bVar5);
        }
        this.f٢٠٦٨c = bVar5;
    }

    public void Y(b bVar) {
        this.f٢٠٦٨c = bVar;
        if (bVar != null && bVar.f٢٠٩٩l != null) {
            this.f٢٠٦٨c.f٢٠٩٩l.x(this.f٢٠٨٣r);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Z() {
        b bVar = this.f٢٠٦٨c;
        if (bVar != null && bVar.f٢٠٩٩l != null) {
            this.f٢٠٦٨c.f٢٠٩٩l.A();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b0() {
        Iterator it = this.f٢٠٧٠e.iterator();
        while (it.hasNext()) {
            if (((b) it.next()).f٢٠٩٩l != null) {
                return true;
            }
        }
        b bVar = this.f٢٠٦٨c;
        if (bVar != null && bVar.f٢٠٩٩l != null) {
            return true;
        }
        return false;
    }

    public void f(MotionLayout motionLayout, int i10) {
        Iterator it = this.f٢٠٧٠e.iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            if (bVar.f٢١٠٠m.size() > 0) {
                Iterator it2 = bVar.f٢١٠٠m.iterator();
                while (it2.hasNext()) {
                    ((b.a) it2.next()).c(motionLayout);
                }
            }
        }
        Iterator it3 = this.f٢٠٧٢g.iterator();
        while (it3.hasNext()) {
            b bVar2 = (b) it3.next();
            if (bVar2.f٢١٠٠m.size() > 0) {
                Iterator it4 = bVar2.f٢١٠٠m.iterator();
                while (it4.hasNext()) {
                    ((b.a) it4.next()).c(motionLayout);
                }
            }
        }
        Iterator it5 = this.f٢٠٧٠e.iterator();
        while (it5.hasNext()) {
            b bVar3 = (b) it5.next();
            if (bVar3.f٢١٠٠m.size() > 0) {
                Iterator it6 = bVar3.f٢١٠٠m.iterator();
                while (it6.hasNext()) {
                    ((b.a) it6.next()).a(motionLayout, i10, bVar3);
                }
            }
        }
        Iterator it7 = this.f٢٠٧٢g.iterator();
        while (it7.hasNext()) {
            b bVar4 = (b) it7.next();
            if (bVar4.f٢١٠٠m.size() > 0) {
                Iterator it8 = bVar4.f٢١٠٠m.iterator();
                while (it8.hasNext()) {
                    ((b.a) it8.next()).a(motionLayout, i10, bVar4);
                }
            }
        }
    }

    public boolean g(int i10, m mVar) {
        return this.f٢٠٨٤s.d(i10, mVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean h(MotionLayout motionLayout, int i10) {
        b bVar;
        if (J() || this.f٢٠٦٩d) {
            return false;
        }
        Iterator it = this.f٢٠٧٠e.iterator();
        while (it.hasNext()) {
            b bVar2 = (b) it.next();
            if (bVar2.f٢١٠١n != 0 && ((bVar = this.f٢٠٦٨c) != bVar2 || !bVar.D(2))) {
                if (i10 == bVar2.f٢٠٩١d && (bVar2.f٢١٠١n == 4 || bVar2.f٢١٠١n == 2)) {
                    MotionLayout.l lVar = MotionLayout.l.FINISHED;
                    motionLayout.setState(lVar);
                    motionLayout.setTransition(bVar2);
                    if (bVar2.f٢١٠١n == 4) {
                        motionLayout.n0();
                        motionLayout.setState(MotionLayout.l.SETUP);
                        motionLayout.setState(MotionLayout.l.MOVING);
                    } else {
                        motionLayout.setProgress(1.0f);
                        motionLayout.S(true);
                        motionLayout.setState(MotionLayout.l.SETUP);
                        motionLayout.setState(MotionLayout.l.MOVING);
                        motionLayout.setState(lVar);
                        motionLayout.f0();
                    }
                    return true;
                }
                if (i10 == bVar2.f٢٠٩٠c && (bVar2.f٢١٠١n == 3 || bVar2.f٢١٠١n == 1)) {
                    MotionLayout.l lVar2 = MotionLayout.l.FINISHED;
                    motionLayout.setState(lVar2);
                    motionLayout.setTransition(bVar2);
                    if (bVar2.f٢١٠١n == 3) {
                        motionLayout.p0();
                        motionLayout.setState(MotionLayout.l.SETUP);
                        motionLayout.setState(MotionLayout.l.MOVING);
                    } else {
                        motionLayout.setProgress(DownloadProgress.UNKNOWN_PROGRESS);
                        motionLayout.S(true);
                        motionLayout.setState(MotionLayout.l.SETUP);
                        motionLayout.setState(MotionLayout.l.MOVING);
                        motionLayout.setState(lVar2);
                        motionLayout.f0();
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public b i(int i10, float f10, float f11, MotionEvent motionEvent) {
        float f12;
        if (i10 != -1) {
            List<b> H = H(i10);
            RectF rectF = new RectF();
            float f13 = DownloadProgress.UNKNOWN_PROGRESS;
            b bVar = null;
            for (b bVar2 : H) {
                if (!bVar2.f٢١٠٢o && bVar2.f٢٠٩٩l != null) {
                    bVar2.f٢٠٩٩l.x(this.f٢٠٨٣r);
                    RectF p10 = bVar2.f٢٠٩٩l.p(this.f٢٠٦٦a, rectF);
                    if (p10 == null || motionEvent == null || p10.contains(motionEvent.getX(), motionEvent.getY())) {
                        RectF f14 = bVar2.f٢٠٩٩l.f(this.f٢٠٦٦a, rectF);
                        if (f14 == null || motionEvent == null || f14.contains(motionEvent.getX(), motionEvent.getY())) {
                            float a10 = bVar2.f٢٠٩٩l.a(f10, f11);
                            if (bVar2.f٢٠٩٩l.f٢١٢١l && motionEvent != null) {
                                a10 = ((float) (Math.atan2(f11 + r10, f10 + r9) - Math.atan2(motionEvent.getX() - bVar2.f٢٠٩٩l.f٢١١٨i, motionEvent.getY() - bVar2.f٢٠٩٩l.f٢١١٩j))) * 10.0f;
                            }
                            if (bVar2.f٢٠٩٠c == i10) {
                                f12 = -1.0f;
                            } else {
                                f12 = 1.1f;
                            }
                            float f15 = a10 * f12;
                            if (f15 > f13) {
                                bVar = bVar2;
                                f13 = f15;
                            }
                        }
                    }
                }
            }
            return bVar;
        }
        return this.f٢٠٦٨c;
    }

    public int j() {
        b bVar = this.f٢٠٦٨c;
        if (bVar != null) {
            return bVar.f٢١٠٣p;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int k() {
        b bVar = this.f٢٠٦٨c;
        if (bVar != null && bVar.f٢٠٩٩l != null) {
            return this.f٢٠٦٨c.f٢٠٩٩l.d();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public androidx.constraintlayout.widget.c l(int i10) {
        return m(i10, -1, -1);
    }

    androidx.constraintlayout.widget.c m(int i10, int i11, int i12) {
        int c10;
        if (this.f٢٠٧٦k) {
            PrintStream printStream = System.out;
            printStream.println("id " + i10);
            printStream.println("size " + this.f٢٠٧٣h.size());
        }
        androidx.constraintlayout.widget.f fVar = this.f٢٠٦٧b;
        if (fVar != null && (c10 = fVar.c(i10, i11, i12)) != -1) {
            i10 = c10;
        }
        if (this.f٢٠٧٣h.get(i10) == null) {
            Log.e("MotionScene", "Warning could not find ConstraintSet id/" + androidx.constraintlayout.motion.widget.a.c(this.f٢٠٦٦a.getContext(), i10) + " In MotionScene");
            SparseArray sparseArray = this.f٢٠٧٣h;
            return (androidx.constraintlayout.widget.c) sparseArray.get(sparseArray.keyAt(0));
        }
        return (androidx.constraintlayout.widget.c) this.f٢٠٧٣h.get(i10);
    }

    public int[] n() {
        int size = this.f٢٠٧٣h.size();
        int[] iArr = new int[size];
        for (int i10 = 0; i10 < size; i10++) {
            iArr[i10] = this.f٢٠٧٣h.keyAt(i10);
        }
        return iArr;
    }

    public ArrayList o() {
        return this.f٢٠٧٠e;
    }

    public int p() {
        b bVar = this.f٢٠٦٨c;
        if (bVar != null) {
            return bVar.f٢٠٩٥h;
        }
        return this.f٢٠٧٧l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int q() {
        b bVar = this.f٢٠٦٨c;
        if (bVar != null) {
            return bVar.f٢٠٩٠c;
        }
        return -1;
    }

    public Interpolator s() {
        int i10 = this.f٢٠٦٨c.f٢٠٩٢e;
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
            return new a(this, a2.c.c(this.f٢٠٦٨c.f٢٠٩٣f));
        }
        return AnimationUtils.loadInterpolator(this.f٢٠٦٦a.getContext(), this.f٢٠٦٨c.f٢٠٩٤g);
    }

    public void t(m mVar) {
        b bVar = this.f٢٠٦٨c;
        if (bVar == null) {
            b bVar2 = this.f٢٠٧١f;
            if (bVar2 != null) {
                Iterator it = bVar2.f٢٠٩٨k.iterator();
                while (it.hasNext()) {
                    ((g) it.next()).b(mVar);
                }
                return;
            }
            return;
        }
        Iterator it2 = bVar.f٢٠٩٨k.iterator();
        while (it2.hasNext()) {
            ((g) it2.next()).b(mVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float u() {
        b bVar = this.f٢٠٦٨c;
        if (bVar != null && bVar.f٢٠٩٩l != null) {
            return this.f٢٠٦٨c.f٢٠٩٩l.g();
        }
        return DownloadProgress.UNKNOWN_PROGRESS;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float v() {
        b bVar = this.f٢٠٦٨c;
        if (bVar != null && bVar.f٢٠٩٩l != null) {
            return this.f٢٠٦٨c.f٢٠٩٩l.h();
        }
        return DownloadProgress.UNKNOWN_PROGRESS;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean w() {
        b bVar = this.f٢٠٦٨c;
        if (bVar != null && bVar.f٢٠٩٩l != null) {
            return this.f٢٠٦٨c.f٢٠٩٩l.i();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float x(float f10, float f11) {
        b bVar = this.f٢٠٦٨c;
        if (bVar != null && bVar.f٢٠٩٩l != null) {
            return this.f٢٠٦٨c.f٢٠٩٩l.j(f10, f11);
        }
        return DownloadProgress.UNKNOWN_PROGRESS;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int z() {
        b bVar = this.f٢٠٦٨c;
        if (bVar != null && bVar.f٢٠٩٩l != null) {
            return this.f٢٠٦٨c.f٢٠٩٩l.k();
        }
        return 0;
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private int f٢٠٨٨a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f٢٠٨٩b;

        /* renamed from: c, reason: collision with root package name */
        private int f٢٠٩٠c;

        /* renamed from: d, reason: collision with root package name */
        private int f٢٠٩١d;

        /* renamed from: e, reason: collision with root package name */
        private int f٢٠٩٢e;

        /* renamed from: f, reason: collision with root package name */
        private String f٢٠٩٣f;

        /* renamed from: g, reason: collision with root package name */
        private int f٢٠٩٤g;

        /* renamed from: h, reason: collision with root package name */
        private int f٢٠٩٥h;

        /* renamed from: i, reason: collision with root package name */
        private float f٢٠٩٦i;

        /* renamed from: j, reason: collision with root package name */
        private final p f٢٠٩٧j;

        /* renamed from: k, reason: collision with root package name */
        private ArrayList f٢٠٩٨k;

        /* renamed from: l, reason: collision with root package name */
        private q f٢٠٩٩l;

        /* renamed from: m, reason: collision with root package name */
        private ArrayList f٢١٠٠m;

        /* renamed from: n, reason: collision with root package name */
        private int f٢١٠١n;

        /* renamed from: o, reason: collision with root package name */
        private boolean f٢١٠٢o;

        /* renamed from: p, reason: collision with root package name */
        private int f٢١٠٣p;

        /* renamed from: q, reason: collision with root package name */
        private int f٢١٠٤q;

        /* renamed from: r, reason: collision with root package name */
        private int f٢١٠٥r;

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
        public static class a implements View.OnClickListener {

            /* renamed from: a, reason: collision with root package name */
            private final b f٢١٠٦a;

            /* renamed from: b, reason: collision with root package name */
            int f٢١٠٧b;

            /* renamed from: c, reason: collision with root package name */
            int f٢١٠٨c;

            public a(Context context, b bVar, XmlPullParser xmlPullParser) {
                this.f٢١٠٧b = -1;
                this.f٢١٠٨c = 17;
                this.f٢١٠٦a = bVar;
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.OnClick);
                int indexCount = obtainStyledAttributes.getIndexCount();
                for (int i10 = 0; i10 < indexCount; i10++) {
                    int index = obtainStyledAttributes.getIndex(i10);
                    if (index == R.styleable.OnClick_targetId) {
                        this.f٢١٠٧b = obtainStyledAttributes.getResourceId(index, this.f٢١٠٧b);
                    } else if (index == R.styleable.OnClick_clickAction) {
                        this.f٢١٠٨c = obtainStyledAttributes.getInt(index, this.f٢١٠٨c);
                    }
                }
                obtainStyledAttributes.recycle();
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r7v4, types: [android.view.View] */
            public void a(MotionLayout motionLayout, int i10, b bVar) {
                boolean z10;
                boolean z11;
                boolean z12;
                boolean z13;
                int i11 = this.f٢١٠٧b;
                MotionLayout motionLayout2 = motionLayout;
                if (i11 != -1) {
                    motionLayout2 = motionLayout.findViewById(i11);
                }
                if (motionLayout2 != null) {
                    int i12 = bVar.f٢٠٩١d;
                    int i13 = bVar.f٢٠٩٠c;
                    if (i12 == -1) {
                        motionLayout2.setOnClickListener(this);
                        return;
                    }
                    int i14 = this.f٢١٠٨c;
                    boolean z14 = false;
                    if ((i14 & 1) != 0 && i10 == i12) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    if ((i14 & 256) != 0 && i10 == i12) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    boolean z15 = z10 | z11;
                    if ((i14 & 1) != 0 && i10 == i12) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    boolean z16 = z12 | z15;
                    if ((i14 & 16) != 0 && i10 == i13) {
                        z13 = true;
                    } else {
                        z13 = false;
                    }
                    boolean z17 = z16 | z13;
                    if ((i14 & 4096) != 0 && i10 == i13) {
                        z14 = true;
                    }
                    if (z17 | z14) {
                        motionLayout2.setOnClickListener(this);
                        return;
                    }
                    return;
                }
                Log.e("MotionScene", "OnClick could not find id " + this.f٢١٠٧b);
            }

            boolean b(b bVar, MotionLayout motionLayout) {
                b bVar2 = this.f٢١٠٦a;
                if (bVar2 != bVar) {
                    int i10 = bVar2.f٢٠٩٠c;
                    int i11 = this.f٢١٠٦a.f٢٠٩١d;
                    if (i11 == -1) {
                        if (motionLayout.f١٨٥٠f != i10) {
                            return true;
                        }
                        return false;
                    }
                    int i12 = motionLayout.f١٨٥٠f;
                    if (i12 == i11 || i12 == i10) {
                        return true;
                    }
                    return false;
                }
                return true;
            }

            public void c(MotionLayout motionLayout) {
                int i10 = this.f٢١٠٧b;
                if (i10 == -1) {
                    return;
                }
                View findViewById = motionLayout.findViewById(i10);
                if (findViewById == null) {
                    Log.e("MotionScene", " (*)  could not find id " + this.f٢١٠٧b);
                    return;
                }
                findViewById.setOnClickListener(null);
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                boolean z10;
                boolean z11;
                MotionLayout motionLayout = this.f٢١٠٦a.f٢٠٩٧j.f٢٠٦٦a;
                if (!motionLayout.d0()) {
                    return;
                }
                if (this.f٢١٠٦a.f٢٠٩١d == -1) {
                    int currentState = motionLayout.getCurrentState();
                    if (currentState == -1) {
                        motionLayout.q0(this.f٢١٠٦a.f٢٠٩٠c);
                        return;
                    }
                    b bVar = new b(this.f٢١٠٦a.f٢٠٩٧j, this.f٢١٠٦a);
                    bVar.f٢٠٩١d = currentState;
                    bVar.f٢٠٩٠c = this.f٢١٠٦a.f٢٠٩٠c;
                    motionLayout.setTransition(bVar);
                    motionLayout.n0();
                    return;
                }
                b bVar2 = this.f٢١٠٦a.f٢٠٩٧j.f٢٠٦٨c;
                int i10 = this.f٢١٠٨c;
                boolean z12 = false;
                if ((i10 & 1) == 0 && (i10 & 256) == 0) {
                    z10 = false;
                } else {
                    z10 = true;
                }
                if ((i10 & 16) == 0 && (i10 & 4096) == 0) {
                    z11 = false;
                } else {
                    z11 = true;
                }
                if (z10 && z11) {
                    b bVar3 = this.f٢١٠٦a.f٢٠٩٧j.f٢٠٦٨c;
                    b bVar4 = this.f٢١٠٦a;
                    if (bVar3 != bVar4) {
                        motionLayout.setTransition(bVar4);
                    }
                    if (motionLayout.getCurrentState() != motionLayout.getEndState() && motionLayout.getProgress() <= 0.5f) {
                        z12 = z10;
                        z11 = false;
                    }
                } else {
                    z12 = z10;
                }
                if (b(bVar2, motionLayout)) {
                    if (z12 && (this.f٢١٠٨c & 1) != 0) {
                        motionLayout.setTransition(this.f٢١٠٦a);
                        motionLayout.n0();
                        return;
                    }
                    if (z11 && (this.f٢١٠٨c & 16) != 0) {
                        motionLayout.setTransition(this.f٢١٠٦a);
                        motionLayout.p0();
                    } else if (z12 && (this.f٢١٠٨c & 256) != 0) {
                        motionLayout.setTransition(this.f٢١٠٦a);
                        motionLayout.setProgress(1.0f);
                    } else if (z11 && (this.f٢١٠٨c & 4096) != 0) {
                        motionLayout.setTransition(this.f٢١٠٦a);
                        motionLayout.setProgress(DownloadProgress.UNKNOWN_PROGRESS);
                    }
                }
            }
        }

        b(p pVar, b bVar) {
            this.f٢٠٨٨a = -1;
            this.f٢٠٨٩b = false;
            this.f٢٠٩٠c = -1;
            this.f٢٠٩١d = -1;
            this.f٢٠٩٢e = 0;
            this.f٢٠٩٣f = null;
            this.f٢٠٩٤g = -1;
            this.f٢٠٩٥h = 400;
            this.f٢٠٩٦i = DownloadProgress.UNKNOWN_PROGRESS;
            this.f٢٠٩٨k = new ArrayList();
            this.f٢٠٩٩l = null;
            this.f٢١٠٠m = new ArrayList();
            this.f٢١٠١n = 0;
            this.f٢١٠٢o = false;
            this.f٢١٠٣p = -1;
            this.f٢١٠٤q = 0;
            this.f٢١٠٥r = 0;
            this.f٢٠٩٧j = pVar;
            this.f٢٠٩٥h = pVar.f٢٠٧٧l;
            if (bVar != null) {
                this.f٢١٠٣p = bVar.f٢١٠٣p;
                this.f٢٠٩٢e = bVar.f٢٠٩٢e;
                this.f٢٠٩٣f = bVar.f٢٠٩٣f;
                this.f٢٠٩٤g = bVar.f٢٠٩٤g;
                this.f٢٠٩٥h = bVar.f٢٠٩٥h;
                this.f٢٠٩٨k = bVar.f٢٠٩٨k;
                this.f٢٠٩٦i = bVar.f٢٠٩٦i;
                this.f٢١٠٤q = bVar.f٢١٠٤q;
            }
        }

        private void v(p pVar, Context context, TypedArray typedArray) {
            int indexCount = typedArray.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArray.getIndex(i10);
                if (index == R.styleable.Transition_constraintSetEnd) {
                    this.f٢٠٩٠c = typedArray.getResourceId(index, -1);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f٢٠٩٠c);
                    if ("layout".equals(resourceTypeName)) {
                        androidx.constraintlayout.widget.c cVar = new androidx.constraintlayout.widget.c();
                        cVar.D(context, this.f٢٠٩٠c);
                        pVar.f٢٠٧٣h.append(this.f٢٠٩٠c, cVar);
                    } else if ("xml".equals(resourceTypeName)) {
                        this.f٢٠٩٠c = pVar.M(context, this.f٢٠٩٠c);
                    }
                } else if (index == R.styleable.Transition_constraintSetStart) {
                    this.f٢٠٩١d = typedArray.getResourceId(index, this.f٢٠٩١d);
                    String resourceTypeName2 = context.getResources().getResourceTypeName(this.f٢٠٩١d);
                    if ("layout".equals(resourceTypeName2)) {
                        androidx.constraintlayout.widget.c cVar2 = new androidx.constraintlayout.widget.c();
                        cVar2.D(context, this.f٢٠٩١d);
                        pVar.f٢٠٧٣h.append(this.f٢٠٩١d, cVar2);
                    } else if ("xml".equals(resourceTypeName2)) {
                        this.f٢٠٩١d = pVar.M(context, this.f٢٠٩١d);
                    }
                } else if (index == R.styleable.Transition_motionInterpolator) {
                    int i11 = typedArray.peekValue(index).type;
                    if (i11 == 1) {
                        int resourceId = typedArray.getResourceId(index, -1);
                        this.f٢٠٩٤g = resourceId;
                        if (resourceId != -1) {
                            this.f٢٠٩٢e = -2;
                        }
                    } else if (i11 == 3) {
                        String string = typedArray.getString(index);
                        this.f٢٠٩٣f = string;
                        if (string != null) {
                            if (string.indexOf("/") > 0) {
                                this.f٢٠٩٤g = typedArray.getResourceId(index, -1);
                                this.f٢٠٩٢e = -2;
                            } else {
                                this.f٢٠٩٢e = -1;
                            }
                        }
                    } else {
                        this.f٢٠٩٢e = typedArray.getInteger(index, this.f٢٠٩٢e);
                    }
                } else if (index == R.styleable.Transition_duration) {
                    int i12 = typedArray.getInt(index, this.f٢٠٩٥h);
                    this.f٢٠٩٥h = i12;
                    if (i12 < 8) {
                        this.f٢٠٩٥h = 8;
                    }
                } else if (index == R.styleable.Transition_staggered) {
                    this.f٢٠٩٦i = typedArray.getFloat(index, this.f٢٠٩٦i);
                } else if (index == R.styleable.Transition_autoTransition) {
                    this.f٢١٠١n = typedArray.getInteger(index, this.f٢١٠١n);
                } else if (index == R.styleable.Transition_android_id) {
                    this.f٢٠٨٨a = typedArray.getResourceId(index, this.f٢٠٨٨a);
                } else if (index == R.styleable.Transition_transitionDisable) {
                    this.f٢١٠٢o = typedArray.getBoolean(index, this.f٢١٠٢o);
                } else if (index == R.styleable.Transition_pathMotionArc) {
                    this.f٢١٠٣p = typedArray.getInteger(index, -1);
                } else if (index == R.styleable.Transition_layoutDuringTransition) {
                    this.f٢١٠٤q = typedArray.getInteger(index, 0);
                } else if (index == R.styleable.Transition_transitionFlags) {
                    this.f٢١٠٥r = typedArray.getInteger(index, 0);
                }
            }
            if (this.f٢٠٩١d == -1) {
                this.f٢٠٨٩b = true;
            }
        }

        private void w(p pVar, Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Transition);
            v(pVar, context, obtainStyledAttributes);
            obtainStyledAttributes.recycle();
        }

        public int A() {
            return this.f٢٠٩١d;
        }

        public q B() {
            return this.f٢٠٩٩l;
        }

        public boolean C() {
            return !this.f٢١٠٢o;
        }

        public boolean D(int i10) {
            if ((i10 & this.f٢١٠٥r) != 0) {
                return true;
            }
            return false;
        }

        public void E(int i10) {
            this.f٢٠٩٥h = Math.max(i10, 8);
        }

        public void F(int i10, String str, int i11) {
            this.f٢٠٩٢e = i10;
            this.f٢٠٩٣f = str;
            this.f٢٠٩٤g = i11;
        }

        public void G(int i10) {
            q B2 = B();
            if (B2 != null) {
                B2.y(i10);
            }
        }

        public void H(int i10) {
            this.f٢١٠٣p = i10;
        }

        public void t(g gVar) {
            this.f٢٠٩٨k.add(gVar);
        }

        public void u(Context context, XmlPullParser xmlPullParser) {
            this.f٢١٠٠m.add(new a(context, this, xmlPullParser));
        }

        public int x() {
            return this.f٢١٠١n;
        }

        public int y() {
            return this.f٢٠٩٠c;
        }

        public int z() {
            return this.f٢١٠٤q;
        }

        public b(int i10, p pVar, int i11, int i12) {
            this.f٢٠٨٨a = -1;
            this.f٢٠٨٩b = false;
            this.f٢٠٩٠c = -1;
            this.f٢٠٩١d = -1;
            this.f٢٠٩٢e = 0;
            this.f٢٠٩٣f = null;
            this.f٢٠٩٤g = -1;
            this.f٢٠٩٥h = 400;
            this.f٢٠٩٦i = DownloadProgress.UNKNOWN_PROGRESS;
            this.f٢٠٩٨k = new ArrayList();
            this.f٢٠٩٩l = null;
            this.f٢١٠٠m = new ArrayList();
            this.f٢١٠١n = 0;
            this.f٢١٠٢o = false;
            this.f٢١٠٣p = -1;
            this.f٢١٠٤q = 0;
            this.f٢١٠٥r = 0;
            this.f٢٠٨٨a = i10;
            this.f٢٠٩٧j = pVar;
            this.f٢٠٩١d = i11;
            this.f٢٠٩٠c = i12;
            this.f٢٠٩٥h = pVar.f٢٠٧٧l;
            this.f٢١٠٤q = pVar.f٢٠٧٨m;
        }

        b(p pVar, Context context, XmlPullParser xmlPullParser) {
            this.f٢٠٨٨a = -1;
            this.f٢٠٨٩b = false;
            this.f٢٠٩٠c = -1;
            this.f٢٠٩١d = -1;
            this.f٢٠٩٢e = 0;
            this.f٢٠٩٣f = null;
            this.f٢٠٩٤g = -1;
            this.f٢٠٩٥h = 400;
            this.f٢٠٩٦i = DownloadProgress.UNKNOWN_PROGRESS;
            this.f٢٠٩٨k = new ArrayList();
            this.f٢٠٩٩l = null;
            this.f٢١٠٠m = new ArrayList();
            this.f٢١٠١n = 0;
            this.f٢١٠٢o = false;
            this.f٢١٠٣p = -1;
            this.f٢١٠٤q = 0;
            this.f٢١٠٥r = 0;
            this.f٢٠٩٥h = pVar.f٢٠٧٧l;
            this.f٢١٠٤q = pVar.f٢٠٧٨m;
            this.f٢٠٩٧j = pVar;
            w(pVar, context, Xml.asAttributeSet(xmlPullParser));
        }
    }
}
