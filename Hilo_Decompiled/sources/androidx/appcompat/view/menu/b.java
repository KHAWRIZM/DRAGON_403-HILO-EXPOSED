package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.l;
import androidx.appcompat.view.menu.m;
import java.util.ArrayList;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class b implements l {

    /* renamed from: a, reason: collision with root package name */
    protected Context f٩٤٩a;

    /* renamed from: b, reason: collision with root package name */
    protected Context f٩٥٠b;

    /* renamed from: c, reason: collision with root package name */
    protected g f٩٥١c;

    /* renamed from: d, reason: collision with root package name */
    protected LayoutInflater f٩٥٢d;

    /* renamed from: e, reason: collision with root package name */
    protected LayoutInflater f٩٥٣e;

    /* renamed from: f, reason: collision with root package name */
    private l.a f٩٥٤f;

    /* renamed from: g, reason: collision with root package name */
    private int f٩٥٥g;

    /* renamed from: h, reason: collision with root package name */
    private int f٩٥٦h;

    /* renamed from: i, reason: collision with root package name */
    protected m f٩٥٧i;

    /* renamed from: j, reason: collision with root package name */
    private int f٩٥٨j;

    public b(Context context, int i10, int i11) {
        this.f٩٤٩a = context;
        this.f٩٥٢d = LayoutInflater.from(context);
        this.f٩٥٥g = i10;
        this.f٩٥٦h = i11;
    }

    @Override // androidx.appcompat.view.menu.l
    public void a(g gVar, boolean z10) {
        l.a aVar = this.f٩٥٤f;
        if (aVar != null) {
            aVar.a(gVar, z10);
        }
    }

    @Override // androidx.appcompat.view.menu.l
    public boolean b(g gVar, i iVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.l
    public void c(l.a aVar) {
        this.f٩٥٤f = aVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v4, types: [androidx.appcompat.view.menu.g] */
    @Override // androidx.appcompat.view.menu.l
    public boolean e(q qVar) {
        l.a aVar = this.f٩٥٤f;
        q qVar2 = qVar;
        if (aVar != null) {
            if (qVar == null) {
                qVar2 = this.f٩٥١c;
            }
            return aVar.b(qVar2);
        }
        return false;
    }

    @Override // androidx.appcompat.view.menu.l
    public int getId() {
        return this.f٩٥٨j;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.appcompat.view.menu.l
    public void h(boolean z10) {
        i iVar;
        ViewGroup viewGroup = (ViewGroup) this.f٩٥٧i;
        if (viewGroup == null) {
            return;
        }
        g gVar = this.f٩٥١c;
        int i10 = 0;
        if (gVar != null) {
            gVar.t();
            ArrayList G = this.f٩٥١c.G();
            int size = G.size();
            int i11 = 0;
            for (int i12 = 0; i12 < size; i12++) {
                i iVar2 = (i) G.get(i12);
                if (t(i11, iVar2)) {
                    View childAt = viewGroup.getChildAt(i11);
                    if (childAt instanceof m.a) {
                        iVar = ((m.a) childAt).getItemData();
                    } else {
                        iVar = null;
                    }
                    View q10 = q(iVar2, childAt, viewGroup);
                    if (iVar2 != iVar) {
                        q10.setPressed(false);
                        q10.jumpDrawablesToCurrentState();
                    }
                    if (q10 != childAt) {
                        l(q10, i11);
                    }
                    i11++;
                }
            }
            i10 = i11;
        }
        while (i10 < viewGroup.getChildCount()) {
            if (!o(viewGroup, i10)) {
                i10++;
            }
        }
    }

    @Override // androidx.appcompat.view.menu.l
    public boolean j(g gVar, i iVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.l
    public void k(Context context, g gVar) {
        this.f٩٥٠b = context;
        this.f٩٥٣e = LayoutInflater.from(context);
        this.f٩٥١c = gVar;
    }

    protected void l(View view, int i10) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        ((ViewGroup) this.f٩٥٧i).addView(view, i10);
    }

    public abstract void m(i iVar, m.a aVar);

    public m.a n(ViewGroup viewGroup) {
        return (m.a) this.f٩٥٢d.inflate(this.f٩٥٦h, viewGroup, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean o(ViewGroup viewGroup, int i10) {
        viewGroup.removeViewAt(i10);
        return true;
    }

    public l.a p() {
        return this.f٩٥٤f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public View q(i iVar, View view, ViewGroup viewGroup) {
        m.a aVar;
        if (view instanceof m.a) {
            aVar = (m.a) view;
        } else {
            aVar = n(viewGroup);
        }
        m(iVar, aVar);
        return (View) aVar;
    }

    public m r(ViewGroup viewGroup) {
        if (this.f٩٥٧i == null) {
            m mVar = (m) this.f٩٥٢d.inflate(this.f٩٥٥g, viewGroup, false);
            this.f٩٥٧i = mVar;
            mVar.b(this.f٩٥١c);
            h(true);
        }
        return this.f٩٥٧i;
    }

    public void s(int i10) {
        this.f٩٥٨j = i10;
    }

    public abstract boolean t(int i10, i iVar);
}
