package androidx.constraintlayout.motion.widget;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import androidx.constraintlayout.motion.widget.s;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.e;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class t {

    /* renamed from: a, reason: collision with root package name */
    private final MotionLayout f٢١٧٧a;

    /* renamed from: c, reason: collision with root package name */
    private HashSet f٢١٧٩c;

    /* renamed from: e, reason: collision with root package name */
    ArrayList f٢١٨١e;

    /* renamed from: b, reason: collision with root package name */
    private ArrayList f٢١٧٨b = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    private String f٢١٨٠d = "ViewTransitionController";

    /* renamed from: f, reason: collision with root package name */
    ArrayList f٢١٨٢f = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class a implements e.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ s f٢١٨٣a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f٢١٨٤b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f٢١٨٥c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f٢١٨٦d;

        a(s sVar, int i10, boolean z10, int i11) {
            this.f٢١٨٣a = sVar;
            this.f٢١٨٤b = i10;
            this.f٢١٨٥c = z10;
            this.f٢١٨٦d = i11;
        }
    }

    public t(MotionLayout motionLayout) {
        this.f٢١٧٧a = motionLayout;
    }

    private void f(s sVar, boolean z10) {
        ConstraintLayout.getSharedValues().a(sVar.h(), new a(sVar, sVar.h(), z10, sVar.g()));
    }

    public void a(s sVar) {
        this.f٢١٧٨b.add(sVar);
        this.f٢١٧٩c = null;
        if (sVar.i() == 4) {
            f(sVar, true);
        } else if (sVar.i() == 5) {
            f(sVar, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(s.b bVar) {
        if (this.f٢١٨١e == null) {
            this.f٢١٨١e = new ArrayList();
        }
        this.f٢١٨١e.add(bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        ArrayList arrayList = this.f٢١٨١e;
        if (arrayList == null) {
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((s.b) it.next()).a();
        }
        this.f٢١٨١e.removeAll(this.f٢١٨٢f);
        this.f٢١٨٢f.clear();
        if (this.f٢١٨١e.isEmpty()) {
            this.f٢١٨١e = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d(int i10, m mVar) {
        Iterator it = this.f٢١٧٨b.iterator();
        while (it.hasNext()) {
            s sVar = (s) it.next();
            if (sVar.e() == i10) {
                sVar.f٢١٤٤f.a(mVar);
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e() {
        this.f٢١٧٧a.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(s.b bVar) {
        this.f٢١٨٢f.add(bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(MotionEvent motionEvent) {
        s sVar;
        int currentState = this.f٢١٧٧a.getCurrentState();
        if (currentState == -1) {
            return;
        }
        if (this.f٢١٧٩c == null) {
            this.f٢١٧٩c = new HashSet();
            Iterator it = this.f٢١٧٨b.iterator();
            while (it.hasNext()) {
                s sVar2 = (s) it.next();
                int childCount = this.f٢١٧٧a.getChildCount();
                for (int i10 = 0; i10 < childCount; i10++) {
                    View childAt = this.f٢١٧٧a.getChildAt(i10);
                    if (sVar2.k(childAt)) {
                        childAt.getId();
                        this.f٢١٧٩c.add(childAt);
                    }
                }
            }
        }
        float x10 = motionEvent.getX();
        float y10 = motionEvent.getY();
        Rect rect = new Rect();
        int action = motionEvent.getAction();
        ArrayList arrayList = this.f٢١٨١e;
        if (arrayList != null && !arrayList.isEmpty()) {
            Iterator it2 = this.f٢١٨١e.iterator();
            while (it2.hasNext()) {
                ((s.b) it2.next()).d(action, x10, y10);
            }
        }
        if (action == 0 || action == 1) {
            androidx.constraintlayout.widget.c X = this.f٢١٧٧a.X(currentState);
            Iterator it3 = this.f٢١٧٨b.iterator();
            while (it3.hasNext()) {
                s sVar3 = (s) it3.next();
                if (sVar3.m(action)) {
                    Iterator it4 = this.f٢١٧٩c.iterator();
                    while (it4.hasNext()) {
                        View view = (View) it4.next();
                        if (sVar3.k(view)) {
                            view.getHitRect(rect);
                            if (rect.contains((int) x10, (int) y10)) {
                                sVar = sVar3;
                                sVar3.c(this, this.f٢١٧٧a, currentState, X, view);
                            } else {
                                sVar = sVar3;
                            }
                            sVar3 = sVar;
                        }
                    }
                }
            }
        }
    }
}
