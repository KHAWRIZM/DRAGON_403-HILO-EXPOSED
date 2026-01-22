package com.google.android.material.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.view.menu.l;
import androidx.core.view.d1;
import androidx.core.view.d2;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate;
import com.google.android.material.R;
import java.util.ArrayList;
import m2.g0;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class q implements androidx.appcompat.view.menu.l {
    private int A;

    /* renamed from: B, reason: collision with root package name */
    int f٩٣٢٥B;

    /* renamed from: a, reason: collision with root package name */
    private NavigationMenuView f٩٣٢٦a;

    /* renamed from: b, reason: collision with root package name */
    LinearLayout f٩٣٢٧b;

    /* renamed from: c, reason: collision with root package name */
    private l.a f٩٣٢٨c;

    /* renamed from: d, reason: collision with root package name */
    androidx.appcompat.view.menu.g f٩٣٢٩d;

    /* renamed from: e, reason: collision with root package name */
    private int f٩٣٣٠e;

    /* renamed from: f, reason: collision with root package name */
    c f٩٣٣١f;

    /* renamed from: g, reason: collision with root package name */
    LayoutInflater f٩٣٣٢g;

    /* renamed from: i, reason: collision with root package name */
    ColorStateList f٩٣٣٤i;

    /* renamed from: l, reason: collision with root package name */
    ColorStateList f٩٣٣٧l;

    /* renamed from: m, reason: collision with root package name */
    ColorStateList f٩٣٣٨m;

    /* renamed from: n, reason: collision with root package name */
    Drawable f٩٣٣٩n;

    /* renamed from: o, reason: collision with root package name */
    RippleDrawable f٩٣٤٠o;

    /* renamed from: p, reason: collision with root package name */
    int f٩٣٤١p;

    /* renamed from: q, reason: collision with root package name */
    int f٩٣٤٢q;

    /* renamed from: r, reason: collision with root package name */
    int f٩٣٤٣r;

    /* renamed from: s, reason: collision with root package name */
    int f٩٣٤٤s;

    /* renamed from: t, reason: collision with root package name */
    int f٩٣٤٥t;

    /* renamed from: u, reason: collision with root package name */
    int f٩٣٤٦u;

    /* renamed from: v, reason: collision with root package name */
    int f٩٣٤٧v;

    /* renamed from: w, reason: collision with root package name */
    int f٩٣٤٨w;

    /* renamed from: x, reason: collision with root package name */
    boolean f٩٣٤٩x;

    /* renamed from: z, reason: collision with root package name */
    private int f٩٣٥١z;

    /* renamed from: h, reason: collision with root package name */
    int f٩٣٣٣h = 0;

    /* renamed from: j, reason: collision with root package name */
    int f٩٣٣٥j = 0;

    /* renamed from: k, reason: collision with root package name */
    boolean f٩٣٣٦k = true;

    /* renamed from: y, reason: collision with root package name */
    boolean f٩٣٥٠y = true;
    private int C = -1;
    final View.OnClickListener D = new a();

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean z10 = true;
            q.this.Y(true);
            androidx.appcompat.view.menu.i itemData = ((NavigationMenuItemView) view).getItemData();
            q qVar = q.this;
            boolean P = qVar.f٩٣٢٩d.P(itemData, qVar, 0);
            if (itemData != null && itemData.isCheckable() && P) {
                q.this.f٩٣٣١f.p(itemData);
            } else {
                z10 = false;
            }
            q.this.Y(false);
            if (z10) {
                q.this.h(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class b extends l {
        public b(View view) {
            super(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class c extends RecyclerView.Adapter {

        /* renamed from: a, reason: collision with root package name */
        private final ArrayList f٩٣٥٣a = new ArrayList();

        /* renamed from: b, reason: collision with root package name */
        private androidx.appcompat.view.menu.i f٩٣٥٤b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f٩٣٥٥c;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        public class a extends androidx.core.view.a {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f٩٣٥٧a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ boolean f٩٣٥٨b;

            a(int i10, boolean z10) {
                this.f٩٣٥٧a = i10;
                this.f٩٣٥٨b = z10;
            }

            @Override // androidx.core.view.a
            public void onInitializeAccessibilityNodeInfo(View view, m2.g0 g0Var) {
                super.onInitializeAccessibilityNodeInfo(view, g0Var);
                g0Var.r0(g0.f.a(c.this.e(this.f٩٣٥٧a), 1, 1, 1, this.f٩٣٥٨b, view.isSelected()));
            }
        }

        c() {
            m();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int e(int i10) {
            int i11 = i10;
            for (int i12 = 0; i12 < i10; i12++) {
                if (q.this.f٩٣٣١f.getItemViewType(i12) == 2 || q.this.f٩٣٣١f.getItemViewType(i12) == 3) {
                    i11--;
                }
            }
            return i11;
        }

        private void f(int i10, int i11) {
            while (i10 < i11) {
                ((g) this.f٩٣٥٣a.get(i10)).f٩٣٦٣b = true;
                i10++;
            }
        }

        private void m() {
            if (this.f٩٣٥٥c) {
                return;
            }
            this.f٩٣٥٥c = true;
            this.f٩٣٥٣a.clear();
            this.f٩٣٥٣a.add(new d());
            int size = q.this.f٩٣٢٩d.G().size();
            int i10 = -1;
            boolean z10 = false;
            int i11 = 0;
            for (int i12 = 0; i12 < size; i12++) {
                androidx.appcompat.view.menu.i iVar = (androidx.appcompat.view.menu.i) q.this.f٩٣٢٩d.G().get(i12);
                if (iVar.isChecked()) {
                    p(iVar);
                }
                if (iVar.isCheckable()) {
                    iVar.t(false);
                }
                if (iVar.hasSubMenu()) {
                    SubMenu subMenu = iVar.getSubMenu();
                    if (subMenu.hasVisibleItems()) {
                        if (i12 != 0) {
                            this.f٩٣٥٣a.add(new f(q.this.f٩٣٢٥B, 0));
                        }
                        this.f٩٣٥٣a.add(new g(iVar));
                        int size2 = this.f٩٣٥٣a.size();
                        int size3 = subMenu.size();
                        boolean z11 = false;
                        for (int i13 = 0; i13 < size3; i13++) {
                            androidx.appcompat.view.menu.i iVar2 = (androidx.appcompat.view.menu.i) subMenu.getItem(i13);
                            if (iVar2.isVisible()) {
                                if (!z11 && iVar2.getIcon() != null) {
                                    z11 = true;
                                }
                                if (iVar2.isCheckable()) {
                                    iVar2.t(false);
                                }
                                if (iVar2.isChecked()) {
                                    p(iVar2);
                                }
                                this.f٩٣٥٣a.add(new g(iVar2));
                            }
                        }
                        if (z11) {
                            f(size2, this.f٩٣٥٣a.size());
                        }
                    }
                } else {
                    int groupId = iVar.getGroupId();
                    if (groupId != i10) {
                        i11 = this.f٩٣٥٣a.size();
                        if (iVar.getIcon() != null) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        if (i12 != 0) {
                            i11++;
                            ArrayList arrayList = this.f٩٣٥٣a;
                            int i14 = q.this.f٩٣٢٥B;
                            arrayList.add(new f(i14, i14));
                        }
                    } else if (!z10 && iVar.getIcon() != null) {
                        f(i11, this.f٩٣٥٣a.size());
                        z10 = true;
                    }
                    g gVar = new g(iVar);
                    gVar.f٩٣٦٣b = z10;
                    this.f٩٣٥٣a.add(gVar);
                    i10 = groupId;
                }
            }
            this.f٩٣٥٥c = false;
        }

        private void o(View view, int i10, boolean z10) {
            d1.q0(view, new a(i10, z10));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void s() {
            for (int i10 = 0; i10 < this.f٩٣٥٣a.size(); i10++) {
                if (this.f٩٣٥٣a.get(i10) instanceof f) {
                    notifyItemChanged(i10);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void t() {
            for (int i10 = 0; i10 < this.f٩٣٥٣a.size(); i10++) {
                if ((this.f٩٣٥٣a.get(i10) instanceof g) && getItemViewType(i10) == 1) {
                    notifyItemChanged(i10);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void u() {
            for (int i10 = 0; i10 < this.f٩٣٥٣a.size(); i10++) {
                if ((this.f٩٣٥٣a.get(i10) instanceof g) && getItemViewType(i10) == 0) {
                    notifyItemChanged(i10);
                }
            }
        }

        public Bundle g() {
            View view;
            Bundle bundle = new Bundle();
            androidx.appcompat.view.menu.i iVar = this.f٩٣٥٤b;
            if (iVar != null) {
                bundle.putInt("android:menu:checked", iVar.getItemId());
            }
            SparseArray<? extends Parcelable> sparseArray = new SparseArray<>();
            int size = this.f٩٣٥٣a.size();
            for (int i10 = 0; i10 < size; i10++) {
                e eVar = (e) this.f٩٣٥٣a.get(i10);
                if (eVar instanceof g) {
                    androidx.appcompat.view.menu.i a10 = ((g) eVar).a();
                    if (a10 != null) {
                        view = a10.getActionView();
                    } else {
                        view = null;
                    }
                    if (view != null) {
                        ParcelableSparseArray parcelableSparseArray = new ParcelableSparseArray();
                        view.saveHierarchyState(parcelableSparseArray);
                        sparseArray.put(a10.getItemId(), parcelableSparseArray);
                    }
                }
            }
            bundle.putSparseParcelableArray("android:menu:action_views", sparseArray);
            return bundle;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.f٩٣٥٣a.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public long getItemId(int i10) {
            return i10;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i10) {
            e eVar = (e) this.f٩٣٥٣a.get(i10);
            if (eVar instanceof f) {
                return 2;
            }
            if (eVar instanceof d) {
                return 3;
            }
            if (eVar instanceof g) {
                if (((g) eVar).a().hasSubMenu()) {
                    return 1;
                }
                return 0;
            }
            throw new RuntimeException("Unknown item type.");
        }

        public androidx.appcompat.view.menu.i h() {
            return this.f٩٣٥٤b;
        }

        int i() {
            int i10 = 0;
            for (int i11 = 0; i11 < q.this.f٩٣٣١f.getItemCount(); i11++) {
                int itemViewType = q.this.f٩٣٣١f.getItemViewType(i11);
                if (itemViewType == 0 || itemViewType == 1) {
                    i10++;
                }
            }
            return i10;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(l lVar, int i10) {
            Drawable drawable;
            int itemViewType = getItemViewType(i10);
            if (itemViewType != 0) {
                if (itemViewType != 1) {
                    if (itemViewType == 2) {
                        f fVar = (f) this.f٩٣٥٣a.get(i10);
                        lVar.itemView.setPaddingRelative(q.this.f٩٣٤٥t, fVar.b(), q.this.f٩٣٤٦u, fVar.a());
                        return;
                    }
                    return;
                }
                TextView textView = (TextView) lVar.itemView;
                textView.setText(((g) this.f٩٣٥٣a.get(i10)).a().getTitle());
                androidx.core.widget.l.m(textView, q.this.f٩٣٣٣h);
                textView.setPaddingRelative(q.this.f٩٣٤٧v, textView.getPaddingTop(), q.this.f٩٣٤٨w, textView.getPaddingBottom());
                ColorStateList colorStateList = q.this.f٩٣٣٤i;
                if (colorStateList != null) {
                    textView.setTextColor(colorStateList);
                }
                o(textView, i10, true);
                return;
            }
            NavigationMenuItemView navigationMenuItemView = (NavigationMenuItemView) lVar.itemView;
            navigationMenuItemView.setIconTintList(q.this.f٩٣٣٨m);
            navigationMenuItemView.setTextAppearance(q.this.f٩٣٣٥j);
            ColorStateList colorStateList2 = q.this.f٩٣٣٧l;
            if (colorStateList2 != null) {
                navigationMenuItemView.setTextColor(colorStateList2);
            }
            Drawable drawable2 = q.this.f٩٣٣٩n;
            if (drawable2 != null) {
                drawable = drawable2.getConstantState().newDrawable();
            } else {
                drawable = null;
            }
            navigationMenuItemView.setBackground(drawable);
            RippleDrawable rippleDrawable = q.this.f٩٣٤٠o;
            if (rippleDrawable != null) {
                navigationMenuItemView.setForeground(rippleDrawable.getConstantState().newDrawable());
            }
            g gVar = (g) this.f٩٣٥٣a.get(i10);
            navigationMenuItemView.setNeedsEmptyIcon(gVar.f٩٣٦٣b);
            q qVar = q.this;
            int i11 = qVar.f٩٣٤١p;
            int i12 = qVar.f٩٣٤٢q;
            navigationMenuItemView.setPadding(i11, i12, i11, i12);
            navigationMenuItemView.setIconPadding(q.this.f٩٣٤٣r);
            q qVar2 = q.this;
            if (qVar2.f٩٣٤٩x) {
                navigationMenuItemView.setIconSize(qVar2.f٩٣٤٤s);
            }
            navigationMenuItemView.setMaxLines(q.this.f٩٣٥١z);
            navigationMenuItemView.l(gVar.a(), q.this.f٩٣٣٦k);
            o(navigationMenuItemView, i10, false);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public l onCreateViewHolder(ViewGroup viewGroup, int i10) {
            if (i10 != 0) {
                if (i10 != 1) {
                    if (i10 != 2) {
                        if (i10 != 3) {
                            return null;
                        }
                        return new b(q.this.f٩٣٢٧b);
                    }
                    return new j(q.this.f٩٣٣٢g, viewGroup);
                }
                return new k(q.this.f٩٣٣٢g, viewGroup);
            }
            q qVar = q.this;
            return new i(qVar.f٩٣٣٢g, viewGroup, qVar.D);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: l, reason: merged with bridge method [inline-methods] */
        public void onViewRecycled(l lVar) {
            if (lVar instanceof i) {
                ((NavigationMenuItemView) lVar.itemView).m();
            }
        }

        public void n(Bundle bundle) {
            androidx.appcompat.view.menu.i a10;
            View actionView;
            ParcelableSparseArray parcelableSparseArray;
            androidx.appcompat.view.menu.i a11;
            int i10 = bundle.getInt("android:menu:checked", 0);
            if (i10 != 0) {
                this.f٩٣٥٥c = true;
                int size = this.f٩٣٥٣a.size();
                int i11 = 0;
                while (true) {
                    if (i11 >= size) {
                        break;
                    }
                    e eVar = (e) this.f٩٣٥٣a.get(i11);
                    if ((eVar instanceof g) && (a11 = ((g) eVar).a()) != null && a11.getItemId() == i10) {
                        p(a11);
                        break;
                    }
                    i11++;
                }
                this.f٩٣٥٥c = false;
                m();
            }
            SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:action_views");
            if (sparseParcelableArray != null) {
                int size2 = this.f٩٣٥٣a.size();
                for (int i12 = 0; i12 < size2; i12++) {
                    e eVar2 = (e) this.f٩٣٥٣a.get(i12);
                    if ((eVar2 instanceof g) && (a10 = ((g) eVar2).a()) != null && (actionView = a10.getActionView()) != null && (parcelableSparseArray = (ParcelableSparseArray) sparseParcelableArray.get(a10.getItemId())) != null) {
                        actionView.restoreHierarchyState(parcelableSparseArray);
                    }
                }
            }
        }

        public void p(androidx.appcompat.view.menu.i iVar) {
            if (this.f٩٣٥٤b != iVar && iVar.isCheckable()) {
                androidx.appcompat.view.menu.i iVar2 = this.f٩٣٥٤b;
                if (iVar2 != null) {
                    iVar2.setChecked(false);
                }
                this.f٩٣٥٤b = iVar;
                iVar.setChecked(true);
            }
        }

        public void q(boolean z10) {
            this.f٩٣٥٥c = z10;
        }

        public void r() {
            int size = this.f٩٣٥٣a.size();
            m();
            notifyDataSetChanged();
            if (size == this.f٩٣٥٣a.size()) {
                notifyItemRangeChanged(0, this.f٩٣٥٣a.size());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class d implements e {
        d() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public interface e {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class f implements e {

        /* renamed from: a, reason: collision with root package name */
        private final int f٩٣٦٠a;

        /* renamed from: b, reason: collision with root package name */
        private final int f٩٣٦١b;

        public f(int i10, int i11) {
            this.f٩٣٦٠a = i10;
            this.f٩٣٦١b = i11;
        }

        public int a() {
            return this.f٩٣٦١b;
        }

        public int b() {
            return this.f٩٣٦٠a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class g implements e {

        /* renamed from: a, reason: collision with root package name */
        private final androidx.appcompat.view.menu.i f٩٣٦٢a;

        /* renamed from: b, reason: collision with root package name */
        boolean f٩٣٦٣b;

        g(androidx.appcompat.view.menu.i iVar) {
            this.f٩٣٦٢a = iVar;
        }

        public androidx.appcompat.view.menu.i a() {
            return this.f٩٣٦٢a;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    private class h extends RecyclerViewAccessibilityDelegate {
        h(RecyclerView recyclerView) {
            super(recyclerView);
        }

        @Override // androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate, androidx.core.view.a
        public void onInitializeAccessibilityNodeInfo(View view, m2.g0 g0Var) {
            super.onInitializeAccessibilityNodeInfo(view, g0Var);
            g0Var.q0(g0.e.a(q.this.f٩٣٣١f.i(), 1, false));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class i extends l {
        public i(LayoutInflater layoutInflater, ViewGroup viewGroup, View.OnClickListener onClickListener) {
            super(layoutInflater.inflate(R.layout.design_navigation_item, viewGroup, false));
            this.itemView.setOnClickListener(onClickListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class j extends l {
        public j(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            super(layoutInflater.inflate(R.layout.design_navigation_item_separator, viewGroup, false));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class k extends l {
        public k(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            super(layoutInflater.inflate(R.layout.design_navigation_item_subheader, viewGroup, false));
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    private static abstract class l extends RecyclerView.ViewHolder {
        public l(View view) {
            super(view);
        }
    }

    private boolean B() {
        if (q() > 0) {
            return true;
        }
        return false;
    }

    private void Z() {
        c cVar = this.f٩٣٣١f;
        if (cVar != null) {
            cVar.s();
        }
    }

    private void a0() {
        c cVar = this.f٩٣٣١f;
        if (cVar != null) {
            cVar.t();
        }
    }

    private void b0() {
        c cVar = this.f٩٣٣١f;
        if (cVar != null) {
            cVar.u();
        }
    }

    private void c0() {
        int i10;
        if (!B() && this.f٩٣٥٠y) {
            i10 = this.A;
        } else {
            i10 = 0;
        }
        NavigationMenuView navigationMenuView = this.f٩٣٢٦a;
        navigationMenuView.setPadding(0, i10, 0, navigationMenuView.getPaddingBottom());
    }

    public int A() {
        return this.f٩٣٤٧v;
    }

    public View C(int i10) {
        View inflate = this.f٩٣٣٢g.inflate(i10, (ViewGroup) this.f٩٣٢٧b, false);
        l(inflate);
        return inflate;
    }

    public void D(boolean z10) {
        if (this.f٩٣٥٠y != z10) {
            this.f٩٣٥٠y = z10;
            c0();
        }
    }

    public void E(androidx.appcompat.view.menu.i iVar) {
        this.f٩٣٣١f.p(iVar);
    }

    public void F(int i10) {
        this.f٩٣٤٦u = i10;
        Z();
    }

    public void G(int i10) {
        this.f٩٣٤٥t = i10;
        Z();
    }

    public void H(int i10) {
        this.f٩٣٣٠e = i10;
    }

    public void I(Drawable drawable) {
        this.f٩٣٣٩n = drawable;
        b0();
    }

    public void J(RippleDrawable rippleDrawable) {
        this.f٩٣٤٠o = rippleDrawable;
        b0();
    }

    public void K(int i10) {
        this.f٩٣٤١p = i10;
        b0();
    }

    public void L(int i10) {
        this.f٩٣٤٣r = i10;
        b0();
    }

    public void M(int i10) {
        if (this.f٩٣٤٤s != i10) {
            this.f٩٣٤٤s = i10;
            this.f٩٣٤٩x = true;
            b0();
        }
    }

    public void N(ColorStateList colorStateList) {
        this.f٩٣٣٨m = colorStateList;
        b0();
    }

    public void O(int i10) {
        this.f٩٣٥١z = i10;
        b0();
    }

    public void P(int i10) {
        this.f٩٣٣٥j = i10;
        b0();
    }

    public void Q(boolean z10) {
        this.f٩٣٣٦k = z10;
        b0();
    }

    public void R(ColorStateList colorStateList) {
        this.f٩٣٣٧l = colorStateList;
        b0();
    }

    public void S(int i10) {
        this.f٩٣٤٢q = i10;
        b0();
    }

    public void T(int i10) {
        this.C = i10;
        NavigationMenuView navigationMenuView = this.f٩٣٢٦a;
        if (navigationMenuView != null) {
            navigationMenuView.setOverScrollMode(i10);
        }
    }

    public void U(ColorStateList colorStateList) {
        this.f٩٣٣٤i = colorStateList;
        a0();
    }

    public void V(int i10) {
        this.f٩٣٤٨w = i10;
        a0();
    }

    public void W(int i10) {
        this.f٩٣٤٧v = i10;
        a0();
    }

    public void X(int i10) {
        this.f٩٣٣٣h = i10;
        a0();
    }

    public void Y(boolean z10) {
        c cVar = this.f٩٣٣١f;
        if (cVar != null) {
            cVar.q(z10);
        }
    }

    @Override // androidx.appcompat.view.menu.l
    public void a(androidx.appcompat.view.menu.g gVar, boolean z10) {
        l.a aVar = this.f٩٣٢٨c;
        if (aVar != null) {
            aVar.a(gVar, z10);
        }
    }

    @Override // androidx.appcompat.view.menu.l
    public boolean b(androidx.appcompat.view.menu.g gVar, androidx.appcompat.view.menu.i iVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.l
    public void d(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:list");
            if (sparseParcelableArray != null) {
                this.f٩٣٢٦a.restoreHierarchyState(sparseParcelableArray);
            }
            Bundle bundle2 = bundle.getBundle("android:menu:adapter");
            if (bundle2 != null) {
                this.f٩٣٣١f.n(bundle2);
            }
            SparseArray<Parcelable> sparseParcelableArray2 = bundle.getSparseParcelableArray("android:menu:header");
            if (sparseParcelableArray2 != null) {
                this.f٩٣٢٧b.restoreHierarchyState(sparseParcelableArray2);
            }
        }
    }

    @Override // androidx.appcompat.view.menu.l
    public boolean e(androidx.appcompat.view.menu.q qVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.l
    public Parcelable g() {
        Bundle bundle = new Bundle();
        if (this.f٩٣٢٦a != null) {
            SparseArray<Parcelable> sparseArray = new SparseArray<>();
            this.f٩٣٢٦a.saveHierarchyState(sparseArray);
            bundle.putSparseParcelableArray("android:menu:list", sparseArray);
        }
        c cVar = this.f٩٣٣١f;
        if (cVar != null) {
            bundle.putBundle("android:menu:adapter", cVar.g());
        }
        if (this.f٩٣٢٧b != null) {
            SparseArray<Parcelable> sparseArray2 = new SparseArray<>();
            this.f٩٣٢٧b.saveHierarchyState(sparseArray2);
            bundle.putSparseParcelableArray("android:menu:header", sparseArray2);
        }
        return bundle;
    }

    @Override // androidx.appcompat.view.menu.l
    public int getId() {
        return this.f٩٣٣٠e;
    }

    @Override // androidx.appcompat.view.menu.l
    public void h(boolean z10) {
        c cVar = this.f٩٣٣١f;
        if (cVar != null) {
            cVar.r();
        }
    }

    @Override // androidx.appcompat.view.menu.l
    public boolean i() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.l
    public boolean j(androidx.appcompat.view.menu.g gVar, androidx.appcompat.view.menu.i iVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.l
    public void k(Context context, androidx.appcompat.view.menu.g gVar) {
        this.f٩٣٣٢g = LayoutInflater.from(context);
        this.f٩٣٢٩d = gVar;
        this.f٩٣٢٥B = context.getResources().getDimensionPixelOffset(R.dimen.design_navigation_separator_vertical_padding);
    }

    public void l(View view) {
        this.f٩٣٢٧b.addView(view);
        NavigationMenuView navigationMenuView = this.f٩٣٢٦a;
        navigationMenuView.setPadding(0, 0, 0, navigationMenuView.getPaddingBottom());
    }

    public void m(d2 d2Var) {
        int m10 = d2Var.m();
        if (this.A != m10) {
            this.A = m10;
            c0();
        }
        NavigationMenuView navigationMenuView = this.f٩٣٢٦a;
        navigationMenuView.setPadding(0, navigationMenuView.getPaddingTop(), 0, d2Var.j());
        d1.j(this.f٩٣٢٧b, d2Var);
    }

    public androidx.appcompat.view.menu.i n() {
        return this.f٩٣٣١f.h();
    }

    public int o() {
        return this.f٩٣٤٦u;
    }

    public int p() {
        return this.f٩٣٤٥t;
    }

    public int q() {
        return this.f٩٣٢٧b.getChildCount();
    }

    public Drawable r() {
        return this.f٩٣٣٩n;
    }

    public int s() {
        return this.f٩٣٤١p;
    }

    public int t() {
        return this.f٩٣٤٣r;
    }

    public int u() {
        return this.f٩٣٥١z;
    }

    public ColorStateList v() {
        return this.f٩٣٣٧l;
    }

    public ColorStateList w() {
        return this.f٩٣٣٨m;
    }

    public int x() {
        return this.f٩٣٤٢q;
    }

    public androidx.appcompat.view.menu.m y(ViewGroup viewGroup) {
        if (this.f٩٣٢٦a == null) {
            NavigationMenuView navigationMenuView = (NavigationMenuView) this.f٩٣٣٢g.inflate(R.layout.design_navigation_menu, viewGroup, false);
            this.f٩٣٢٦a = navigationMenuView;
            navigationMenuView.setAccessibilityDelegateCompat(new h(this.f٩٣٢٦a));
            if (this.f٩٣٣١f == null) {
                c cVar = new c();
                this.f٩٣٣١f = cVar;
                cVar.setHasStableIds(true);
            }
            int i10 = this.C;
            if (i10 != -1) {
                this.f٩٣٢٦a.setOverScrollMode(i10);
            }
            LinearLayout linearLayout = (LinearLayout) this.f٩٣٣٢g.inflate(R.layout.design_navigation_item_header, (ViewGroup) this.f٩٣٢٦a, false);
            this.f٩٣٢٧b = linearLayout;
            linearLayout.setImportantForAccessibility(2);
            this.f٩٣٢٦a.setAdapter(this.f٩٣٣١f);
        }
        return this.f٩٣٢٦a;
    }

    public int z() {
        return this.f٩٣٤٨w;
    }
}
