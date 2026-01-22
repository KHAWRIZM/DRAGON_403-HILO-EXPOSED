package androidx.appcompat.view.menu;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.l;
import androidx.appcompat.view.menu.m;
import java.util.ArrayList;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class e implements l, AdapterView.OnItemClickListener {

    /* renamed from: a, reason: collision with root package name */
    Context f٩٩٨a;

    /* renamed from: b, reason: collision with root package name */
    LayoutInflater f٩٩٩b;

    /* renamed from: c, reason: collision with root package name */
    g f١٠٠٠c;

    /* renamed from: d, reason: collision with root package name */
    ExpandedMenuView f١٠٠١d;

    /* renamed from: e, reason: collision with root package name */
    int f١٠٠٢e;

    /* renamed from: f, reason: collision with root package name */
    int f١٠٠٣f;

    /* renamed from: g, reason: collision with root package name */
    int f١٠٠٤g;

    /* renamed from: h, reason: collision with root package name */
    private l.a f١٠٠٥h;

    /* renamed from: i, reason: collision with root package name */
    a f١٠٠٦i;

    /* renamed from: j, reason: collision with root package name */
    private int f١٠٠٧j;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    private class a extends BaseAdapter {

        /* renamed from: a, reason: collision with root package name */
        private int f١٠٠٨a = -1;

        public a() {
            a();
        }

        void a() {
            i x10 = e.this.f١٠٠٠c.x();
            if (x10 != null) {
                ArrayList B2 = e.this.f١٠٠٠c.B();
                int size = B2.size();
                for (int i10 = 0; i10 < size; i10++) {
                    if (((i) B2.get(i10)) == x10) {
                        this.f١٠٠٨a = i10;
                        return;
                    }
                }
            }
            this.f١٠٠٨a = -1;
        }

        @Override // android.widget.Adapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public i getItem(int i10) {
            ArrayList B2 = e.this.f١٠٠٠c.B();
            int i11 = i10 + e.this.f١٠٠٢e;
            int i12 = this.f١٠٠٨a;
            if (i12 >= 0 && i11 >= i12) {
                i11++;
            }
            return (i) B2.get(i11);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            int size = e.this.f١٠٠٠c.B().size() - e.this.f١٠٠٢e;
            if (this.f١٠٠٨a < 0) {
                return size;
            }
            return size - 1;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i10) {
            return i10;
        }

        @Override // android.widget.Adapter
        public View getView(int i10, View view, ViewGroup viewGroup) {
            if (view == null) {
                e eVar = e.this;
                view = eVar.f٩٩٩b.inflate(eVar.f١٠٠٤g, viewGroup, false);
            }
            ((m.a) view).g(getItem(i10), 0);
            return view;
        }

        @Override // android.widget.BaseAdapter
        public void notifyDataSetChanged() {
            a();
            super.notifyDataSetChanged();
        }
    }

    public e(Context context, int i10) {
        this(i10, 0);
        this.f٩٩٨a = context;
        this.f٩٩٩b = LayoutInflater.from(context);
    }

    @Override // androidx.appcompat.view.menu.l
    public void a(g gVar, boolean z10) {
        l.a aVar = this.f١٠٠٥h;
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
        this.f١٠٠٥h = aVar;
    }

    @Override // androidx.appcompat.view.menu.l
    public void d(Parcelable parcelable) {
        m((Bundle) parcelable);
    }

    @Override // androidx.appcompat.view.menu.l
    public boolean e(q qVar) {
        if (!qVar.hasVisibleItems()) {
            return false;
        }
        new h(qVar).d(null);
        l.a aVar = this.f١٠٠٥h;
        if (aVar != null) {
            aVar.b(qVar);
            return true;
        }
        return true;
    }

    public ListAdapter f() {
        if (this.f١٠٠٦i == null) {
            this.f١٠٠٦i = new a();
        }
        return this.f١٠٠٦i;
    }

    @Override // androidx.appcompat.view.menu.l
    public Parcelable g() {
        if (this.f١٠٠١d == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        n(bundle);
        return bundle;
    }

    @Override // androidx.appcompat.view.menu.l
    public int getId() {
        return this.f١٠٠٧j;
    }

    @Override // androidx.appcompat.view.menu.l
    public void h(boolean z10) {
        a aVar = this.f١٠٠٦i;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.l
    public boolean i() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.l
    public boolean j(g gVar, i iVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.l
    public void k(Context context, g gVar) {
        if (this.f١٠٠٣f != 0) {
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, this.f١٠٠٣f);
            this.f٩٩٨a = contextThemeWrapper;
            this.f٩٩٩b = LayoutInflater.from(contextThemeWrapper);
        } else if (this.f٩٩٨a != null) {
            this.f٩٩٨a = context;
            if (this.f٩٩٩b == null) {
                this.f٩٩٩b = LayoutInflater.from(context);
            }
        }
        this.f١٠٠٠c = gVar;
        a aVar = this.f١٠٠٦i;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    public m l(ViewGroup viewGroup) {
        if (this.f١٠٠١d == null) {
            this.f١٠٠١d = (ExpandedMenuView) this.f٩٩٩b.inflate(R.layout.abc_expanded_menu_layout, viewGroup, false);
            if (this.f١٠٠٦i == null) {
                this.f١٠٠٦i = new a();
            }
            this.f١٠٠١d.setAdapter((ListAdapter) this.f١٠٠٦i);
            this.f١٠٠١d.setOnItemClickListener(this);
        }
        return this.f١٠٠١d;
    }

    public void m(Bundle bundle) {
        SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:list");
        if (sparseParcelableArray != null) {
            this.f١٠٠١d.restoreHierarchyState(sparseParcelableArray);
        }
    }

    public void n(Bundle bundle) {
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        ExpandedMenuView expandedMenuView = this.f١٠٠١d;
        if (expandedMenuView != null) {
            expandedMenuView.saveHierarchyState(sparseArray);
        }
        bundle.putSparseParcelableArray("android:menu:list", sparseArray);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
        this.f١٠٠٠c.P(this.f١٠٠٦i.getItem(i10), this, 0);
    }

    public e(int i10, int i11) {
        this.f١٠٠٤g = i10;
        this.f١٠٠٣f = i11;
    }
}
