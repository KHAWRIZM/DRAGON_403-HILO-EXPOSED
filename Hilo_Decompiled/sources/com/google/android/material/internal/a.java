package com.google.android.material.internal;

import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.internal.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private final Map f٩٢١٣a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private final Set f٩٢١٤b = new HashSet();

    /* renamed from: c, reason: collision with root package name */
    private b f٩٢١٥c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f٩٢١٦d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f٩٢١٧e;

    /* renamed from: com.google.android.material.internal.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class C٠١١٤a implements j.a {
        C٠١١٤a() {
        }

        @Override // com.google.android.material.internal.j.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(j jVar, boolean z10) {
            if (z10) {
                if (!a.this.g(jVar)) {
                    return;
                }
            } else {
                a aVar = a.this;
                if (!aVar.q(jVar, aVar.f٩٢١٧e)) {
                    return;
                }
            }
            a.this.m();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public interface b {
        void a(Set set);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g(j jVar) {
        int id = jVar.getId();
        if (this.f٩٢١٤b.contains(Integer.valueOf(id))) {
            return false;
        }
        j jVar2 = (j) this.f٩٢١٣a.get(Integer.valueOf(k()));
        if (jVar2 != null) {
            q(jVar2, false);
        }
        boolean add = this.f٩٢١٤b.add(Integer.valueOf(id));
        if (!jVar.isChecked()) {
            jVar.setChecked(true);
        }
        return add;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        b bVar = this.f٩٢١٥c;
        if (bVar != null) {
            bVar.a(i());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean q(j jVar, boolean z10) {
        int id = jVar.getId();
        if (!this.f٩٢١٤b.contains(Integer.valueOf(id))) {
            return false;
        }
        if (z10 && this.f٩٢١٤b.size() == 1 && this.f٩٢١٤b.contains(Integer.valueOf(id))) {
            jVar.setChecked(true);
            return false;
        }
        boolean remove = this.f٩٢١٤b.remove(Integer.valueOf(id));
        if (jVar.isChecked()) {
            jVar.setChecked(false);
        }
        return remove;
    }

    public void e(j jVar) {
        this.f٩٢١٣a.put(Integer.valueOf(jVar.getId()), jVar);
        if (jVar.isChecked()) {
            g(jVar);
        }
        jVar.setInternalOnCheckedChangeListener(new C٠١١٤a());
    }

    public void f(int i10) {
        j jVar = (j) this.f٩٢١٣a.get(Integer.valueOf(i10));
        if (jVar != null && g(jVar)) {
            m();
        }
    }

    public void h() {
        boolean isEmpty = this.f٩٢١٤b.isEmpty();
        Iterator it = this.f٩٢١٣a.values().iterator();
        while (it.hasNext()) {
            q((j) it.next(), false);
        }
        if (!isEmpty) {
            m();
        }
    }

    public Set i() {
        return new HashSet(this.f٩٢١٤b);
    }

    public List j(ViewGroup viewGroup) {
        Set i10 = i();
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < viewGroup.getChildCount(); i11++) {
            View childAt = viewGroup.getChildAt(i11);
            if ((childAt instanceof j) && i10.contains(Integer.valueOf(childAt.getId()))) {
                arrayList.add(Integer.valueOf(childAt.getId()));
            }
        }
        return arrayList;
    }

    public int k() {
        if (this.f٩٢١٦d && !this.f٩٢١٤b.isEmpty()) {
            return ((Integer) this.f٩٢١٤b.iterator().next()).intValue();
        }
        return -1;
    }

    public boolean l() {
        return this.f٩٢١٦d;
    }

    public void n(j jVar) {
        jVar.setInternalOnCheckedChangeListener(null);
        this.f٩٢١٣a.remove(Integer.valueOf(jVar.getId()));
        this.f٩٢١٤b.remove(Integer.valueOf(jVar.getId()));
    }

    public void o(boolean z10) {
        this.f٩٢١٧e = z10;
    }

    public void p(boolean z10) {
        if (this.f٩٢١٦d != z10) {
            this.f٩٢١٦d = z10;
            h();
        }
    }

    public void setOnCheckedStateChangeListener(b bVar) {
        this.f٩٢١٥c = bVar;
    }
}
