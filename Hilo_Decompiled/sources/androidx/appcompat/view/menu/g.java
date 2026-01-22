package androidx.appcompat.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class g implements i2.a {
    private static final int[] A = {1, 4, 5, 3, 2, 0};

    /* renamed from: a, reason: collision with root package name */
    private final Context f١٠١٦a;

    /* renamed from: b, reason: collision with root package name */
    private final Resources f١٠١٧b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f١٠١٨c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f١٠١٩d;

    /* renamed from: e, reason: collision with root package name */
    private a f١٠٢٠e;

    /* renamed from: m, reason: collision with root package name */
    private ContextMenu.ContextMenuInfo f١٠٢٨m;

    /* renamed from: n, reason: collision with root package name */
    CharSequence f١٠٢٩n;

    /* renamed from: o, reason: collision with root package name */
    Drawable f١٠٣٠o;

    /* renamed from: p, reason: collision with root package name */
    View f١٠٣١p;

    /* renamed from: x, reason: collision with root package name */
    private i f١٠٣٩x;

    /* renamed from: z, reason: collision with root package name */
    private boolean f١٠٤١z;

    /* renamed from: l, reason: collision with root package name */
    private int f١٠٢٧l = 0;

    /* renamed from: q, reason: collision with root package name */
    private boolean f١٠٣٢q = false;

    /* renamed from: r, reason: collision with root package name */
    private boolean f١٠٣٣r = false;

    /* renamed from: s, reason: collision with root package name */
    private boolean f١٠٣٤s = false;

    /* renamed from: t, reason: collision with root package name */
    private boolean f١٠٣٥t = false;

    /* renamed from: u, reason: collision with root package name */
    private boolean f١٠٣٦u = false;

    /* renamed from: v, reason: collision with root package name */
    private ArrayList f١٠٣٧v = new ArrayList();

    /* renamed from: w, reason: collision with root package name */
    private CopyOnWriteArrayList f١٠٣٨w = new CopyOnWriteArrayList();

    /* renamed from: y, reason: collision with root package name */
    private boolean f١٠٤٠y = false;

    /* renamed from: f, reason: collision with root package name */
    private ArrayList f١٠٢١f = new ArrayList();

    /* renamed from: g, reason: collision with root package name */
    private ArrayList f١٠٢٢g = new ArrayList();

    /* renamed from: h, reason: collision with root package name */
    private boolean f١٠٢٣h = true;

    /* renamed from: i, reason: collision with root package name */
    private ArrayList f١٠٢٤i = new ArrayList();

    /* renamed from: j, reason: collision with root package name */
    private ArrayList f١٠٢٥j = new ArrayList();

    /* renamed from: k, reason: collision with root package name */
    private boolean f١٠٢٦k = true;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public interface a {
        boolean a(g gVar, MenuItem menuItem);

        void b(g gVar);
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public interface b {
        boolean c(i iVar);
    }

    public g(Context context) {
        this.f١٠١٦a = context;
        this.f١٠١٧b = context.getResources();
        g0(true);
    }

    private static int D(int i10) {
        int i11 = ((-65536) & i10) >> 16;
        if (i11 >= 0) {
            int[] iArr = A;
            if (i11 < iArr.length) {
                return (i10 & 65535) | (iArr[i11] << 16);
            }
        }
        throw new IllegalArgumentException("order does not contain a valid category.");
    }

    private void Q(int i10, boolean z10) {
        if (i10 >= 0 && i10 < this.f١٠٢١f.size()) {
            this.f١٠٢١f.remove(i10);
            if (z10) {
                N(true);
            }
        }
    }

    private void b0(int i10, CharSequence charSequence, int i11, Drawable drawable, View view) {
        Resources E = E();
        if (view != null) {
            this.f١٠٣١p = view;
            this.f١٠٢٩n = null;
            this.f١٠٣٠o = null;
        } else {
            if (i10 > 0) {
                this.f١٠٢٩n = E.getText(i10);
            } else if (charSequence != null) {
                this.f١٠٢٩n = charSequence;
            }
            if (i11 > 0) {
                this.f١٠٣٠o = androidx.core.content.a.getDrawable(w(), i11);
            } else if (drawable != null) {
                this.f١٠٣٠o = drawable;
            }
            this.f١٠٣١p = null;
        }
        N(false);
    }

    private i g(int i10, int i11, int i12, int i13, CharSequence charSequence, int i14) {
        return new i(this, i10, i11, i12, i13, charSequence, i14);
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0019, code lost:
    
        if (androidx.core.view.g1.l(android.view.ViewConfiguration.get(r2.f١٠١٦a), r2.f١٠١٦a) != false) goto L٩;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void g0(boolean z10) {
        boolean z11;
        if (z10) {
            z11 = true;
            if (this.f١٠١٧b.getConfiguration().keyboard != 1) {
            }
        }
        z11 = false;
        this.f١٠١٩d = z11;
    }

    private void i(boolean z10) {
        if (this.f١٠٣٨w.isEmpty()) {
            return;
        }
        i0();
        Iterator it = this.f١٠٣٨w.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            l lVar = (l) weakReference.get();
            if (lVar == null) {
                this.f١٠٣٨w.remove(weakReference);
            } else {
                lVar.h(z10);
            }
        }
        h0();
    }

    private void j(Bundle bundle) {
        Parcelable parcelable;
        SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:presenters");
        if (sparseParcelableArray != null && !this.f١٠٣٨w.isEmpty()) {
            Iterator it = this.f١٠٣٨w.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                l lVar = (l) weakReference.get();
                if (lVar == null) {
                    this.f١٠٣٨w.remove(weakReference);
                } else {
                    int id = lVar.getId();
                    if (id > 0 && (parcelable = (Parcelable) sparseParcelableArray.get(id)) != null) {
                        lVar.d(parcelable);
                    }
                }
            }
        }
    }

    private void k(Bundle bundle) {
        Parcelable g10;
        if (this.f١٠٣٨w.isEmpty()) {
            return;
        }
        SparseArray<? extends Parcelable> sparseArray = new SparseArray<>();
        Iterator it = this.f١٠٣٨w.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            l lVar = (l) weakReference.get();
            if (lVar == null) {
                this.f١٠٣٨w.remove(weakReference);
            } else {
                int id = lVar.getId();
                if (id > 0 && (g10 = lVar.g()) != null) {
                    sparseArray.put(id, g10);
                }
            }
        }
        bundle.putSparseParcelableArray("android:menu:presenters", sparseArray);
    }

    private boolean l(q qVar, l lVar) {
        boolean z10 = false;
        if (this.f١٠٣٨w.isEmpty()) {
            return false;
        }
        if (lVar != null) {
            z10 = lVar.e(qVar);
        }
        Iterator it = this.f١٠٣٨w.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            l lVar2 = (l) weakReference.get();
            if (lVar2 == null) {
                this.f١٠٣٨w.remove(weakReference);
            } else if (!z10) {
                z10 = lVar2.e(qVar);
            }
        }
        return z10;
    }

    private static int p(ArrayList arrayList, int i10) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (((i) arrayList.get(size)).f() <= i10) {
                return size + 1;
            }
        }
        return 0;
    }

    public View A() {
        return this.f١٠٣١p;
    }

    public ArrayList B() {
        t();
        return this.f١٠٢٥j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean C() {
        return this.f١٠٣٥t;
    }

    Resources E() {
        return this.f١٠١٧b;
    }

    public g F() {
        return this;
    }

    public ArrayList G() {
        if (!this.f١٠٢٣h) {
            return this.f١٠٢٢g;
        }
        this.f١٠٢٢g.clear();
        int size = this.f١٠٢١f.size();
        for (int i10 = 0; i10 < size; i10++) {
            i iVar = (i) this.f١٠٢١f.get(i10);
            if (iVar.isVisible()) {
                this.f١٠٢٢g.add(iVar);
            }
        }
        this.f١٠٢٣h = false;
        this.f١٠٢٦k = true;
        return this.f١٠٢٢g;
    }

    public boolean H() {
        return !this.f١٠٣٢q;
    }

    public boolean I() {
        return this.f١٠٤٠y;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean J() {
        return this.f١٠١٨c;
    }

    public boolean K() {
        return this.f١٠١٩d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void L(i iVar) {
        this.f١٠٢٦k = true;
        N(true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void M(i iVar) {
        this.f١٠٢٣h = true;
        N(true);
    }

    public void N(boolean z10) {
        if (!this.f١٠٣٢q) {
            if (z10) {
                this.f١٠٢٣h = true;
                this.f١٠٢٦k = true;
            }
            i(z10);
            return;
        }
        this.f١٠٣٣r = true;
        if (z10) {
            this.f١٠٣٤s = true;
        }
    }

    public boolean O(MenuItem menuItem, int i10) {
        return P(menuItem, null, i10);
    }

    public boolean P(MenuItem menuItem, l lVar, int i10) {
        boolean z10;
        i iVar = (i) menuItem;
        if (iVar == null || !iVar.isEnabled()) {
            return false;
        }
        boolean k10 = iVar.k();
        androidx.core.view.b a10 = iVar.a();
        if (a10 != null && a10.a()) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (iVar.j()) {
            k10 |= iVar.expandActionView();
            if (k10) {
                e(true);
            }
        } else if (!iVar.hasSubMenu() && !z10) {
            if ((i10 & 1) == 0) {
                e(true);
            }
        } else {
            if ((i10 & 4) == 0) {
                e(false);
            }
            if (!iVar.hasSubMenu()) {
                iVar.x(new q(w(), this, iVar));
            }
            q qVar = (q) iVar.getSubMenu();
            if (z10) {
                a10.e(qVar);
            }
            k10 |= l(qVar, lVar);
            if (!k10) {
                e(true);
            }
        }
        return k10;
    }

    public void R(l lVar) {
        Iterator it = this.f١٠٣٨w.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            l lVar2 = (l) weakReference.get();
            if (lVar2 == null || lVar2 == lVar) {
                this.f١٠٣٨w.remove(weakReference);
            }
        }
    }

    public void S(Bundle bundle) {
        MenuItem findItem;
        if (bundle == null) {
            return;
        }
        SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray(v());
        int size = size();
        for (int i10 = 0; i10 < size; i10++) {
            MenuItem item = getItem(i10);
            View actionView = item.getActionView();
            if (actionView != null && actionView.getId() != -1) {
                actionView.restoreHierarchyState(sparseParcelableArray);
            }
            if (item.hasSubMenu()) {
                ((q) item.getSubMenu()).S(bundle);
            }
        }
        int i11 = bundle.getInt("android:menu:expandedactionview");
        if (i11 > 0 && (findItem = findItem(i11)) != null) {
            findItem.expandActionView();
        }
    }

    public void T(Bundle bundle) {
        j(bundle);
    }

    public void U(Bundle bundle) {
        int size = size();
        SparseArray<? extends Parcelable> sparseArray = null;
        for (int i10 = 0; i10 < size; i10++) {
            MenuItem item = getItem(i10);
            View actionView = item.getActionView();
            if (actionView != null && actionView.getId() != -1) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                }
                actionView.saveHierarchyState(sparseArray);
                if (item.isActionViewExpanded()) {
                    bundle.putInt("android:menu:expandedactionview", item.getItemId());
                }
            }
            if (item.hasSubMenu()) {
                ((q) item.getSubMenu()).U(bundle);
            }
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(v(), sparseArray);
        }
    }

    public void V(Bundle bundle) {
        k(bundle);
    }

    public void W(a aVar) {
        this.f١٠٢٠e = aVar;
    }

    public g X(int i10) {
        this.f١٠٢٧l = i10;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Y(MenuItem menuItem) {
        boolean z10;
        int groupId = menuItem.getGroupId();
        int size = this.f١٠٢١f.size();
        i0();
        for (int i10 = 0; i10 < size; i10++) {
            i iVar = (i) this.f١٠٢١f.get(i10);
            if (iVar.getGroupId() == groupId && iVar.m() && iVar.isCheckable()) {
                if (iVar == menuItem) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                iVar.s(z10);
            }
        }
        h0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public g Z(int i10) {
        b0(0, null, i10, null, null);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MenuItem a(int i10, int i11, int i12, CharSequence charSequence) {
        int D = D(i12);
        i g10 = g(i10, i11, i12, D, charSequence, this.f١٠٢٧l);
        ContextMenu.ContextMenuInfo contextMenuInfo = this.f١٠٢٨m;
        if (contextMenuInfo != null) {
            g10.v(contextMenuInfo);
        }
        ArrayList arrayList = this.f١٠٢١f;
        arrayList.add(p(arrayList, D), g10);
        N(true);
        return g10;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public g a0(Drawable drawable) {
        b0(0, null, 0, drawable, null);
        return this;
    }

    @Override // android.view.Menu
    public MenuItem add(CharSequence charSequence) {
        return a(0, 0, 0, charSequence);
    }

    @Override // android.view.Menu
    public int addIntentOptions(int i10, int i11, int i12, ComponentName componentName, Intent[] intentArr, Intent intent, int i13, MenuItem[] menuItemArr) {
        int i14;
        Intent intent2;
        int i15;
        PackageManager packageManager = this.f١٠١٦a.getPackageManager();
        List<ResolveInfo> queryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        if (queryIntentActivityOptions != null) {
            i14 = queryIntentActivityOptions.size();
        } else {
            i14 = 0;
        }
        if ((i13 & 1) == 0) {
            removeGroup(i10);
        }
        for (int i16 = 0; i16 < i14; i16++) {
            ResolveInfo resolveInfo = queryIntentActivityOptions.get(i16);
            int i17 = resolveInfo.specificIndex;
            if (i17 < 0) {
                intent2 = intent;
            } else {
                intent2 = intentArr[i17];
            }
            Intent intent3 = new Intent(intent2);
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            intent3.setComponent(new ComponentName(activityInfo.applicationInfo.packageName, activityInfo.name));
            MenuItem intent4 = add(i10, i11, i12, resolveInfo.loadLabel(packageManager)).setIcon(resolveInfo.loadIcon(packageManager)).setIntent(intent3);
            if (menuItemArr != null && (i15 = resolveInfo.specificIndex) >= 0) {
                menuItemArr[i15] = intent4;
            }
        }
        return i14;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    public void b(l lVar) {
        c(lVar, this.f١٠١٦a);
    }

    public void c(l lVar, Context context) {
        this.f١٠٣٨w.add(new WeakReference(lVar));
        lVar.k(context, this);
        this.f١٠٢٦k = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public g c0(int i10) {
        b0(i10, null, 0, null, null);
        return this;
    }

    @Override // android.view.Menu
    public void clear() {
        i iVar = this.f١٠٣٩x;
        if (iVar != null) {
            f(iVar);
        }
        this.f١٠٢١f.clear();
        N(true);
    }

    public void clearHeader() {
        this.f١٠٣٠o = null;
        this.f١٠٢٩n = null;
        this.f١٠٣١p = null;
        N(false);
    }

    @Override // android.view.Menu
    public void close() {
        e(true);
    }

    public void d() {
        a aVar = this.f١٠٢٠e;
        if (aVar != null) {
            aVar.b(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public g d0(CharSequence charSequence) {
        b0(0, charSequence, 0, null, null);
        return this;
    }

    public final void e(boolean z10) {
        if (this.f١٠٣٦u) {
            return;
        }
        this.f١٠٣٦u = true;
        Iterator it = this.f١٠٣٨w.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            l lVar = (l) weakReference.get();
            if (lVar == null) {
                this.f١٠٣٨w.remove(weakReference);
            } else {
                lVar.a(this, z10);
            }
        }
        this.f١٠٣٦u = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public g e0(View view) {
        b0(0, null, 0, null, view);
        return this;
    }

    public boolean f(i iVar) {
        boolean z10 = false;
        if (!this.f١٠٣٨w.isEmpty() && this.f١٠٣٩x == iVar) {
            i0();
            Iterator it = this.f١٠٣٨w.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                l lVar = (l) weakReference.get();
                if (lVar == null) {
                    this.f١٠٣٨w.remove(weakReference);
                } else {
                    z10 = lVar.j(this, iVar);
                    if (z10) {
                        break;
                    }
                }
            }
            h0();
            if (z10) {
                this.f١٠٣٩x = null;
            }
        }
        return z10;
    }

    public void f0(boolean z10) {
        this.f١٠٤١z = z10;
    }

    @Override // android.view.Menu
    public MenuItem findItem(int i10) {
        MenuItem findItem;
        int size = size();
        for (int i11 = 0; i11 < size; i11++) {
            i iVar = (i) this.f١٠٢١f.get(i11);
            if (iVar.getItemId() == i10) {
                return iVar;
            }
            if (iVar.hasSubMenu() && (findItem = iVar.getSubMenu().findItem(i10)) != null) {
                return findItem;
            }
        }
        return null;
    }

    @Override // android.view.Menu
    public MenuItem getItem(int i10) {
        return (MenuItem) this.f١٠٢١f.get(i10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean h(g gVar, MenuItem menuItem) {
        a aVar = this.f١٠٢٠e;
        if (aVar != null && aVar.a(gVar, menuItem)) {
            return true;
        }
        return false;
    }

    public void h0() {
        this.f١٠٣٢q = false;
        if (this.f١٠٣٣r) {
            this.f١٠٣٣r = false;
            N(this.f١٠٣٤s);
        }
    }

    @Override // android.view.Menu
    public boolean hasVisibleItems() {
        if (this.f١٠٤١z) {
            return true;
        }
        int size = size();
        for (int i10 = 0; i10 < size; i10++) {
            if (((i) this.f١٠٢١f.get(i10)).isVisible()) {
                return true;
            }
        }
        return false;
    }

    public void i0() {
        if (!this.f١٠٣٢q) {
            this.f١٠٣٢q = true;
            this.f١٠٣٣r = false;
            this.f١٠٣٤s = false;
        }
    }

    @Override // android.view.Menu
    public boolean isShortcutKey(int i10, KeyEvent keyEvent) {
        if (r(i10, keyEvent) != null) {
            return true;
        }
        return false;
    }

    public boolean m(i iVar) {
        boolean z10 = false;
        if (this.f١٠٣٨w.isEmpty()) {
            return false;
        }
        i0();
        Iterator it = this.f١٠٣٨w.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            l lVar = (l) weakReference.get();
            if (lVar == null) {
                this.f١٠٣٨w.remove(weakReference);
            } else {
                z10 = lVar.b(this, iVar);
                if (z10) {
                    break;
                }
            }
        }
        h0();
        if (z10) {
            this.f١٠٣٩x = iVar;
        }
        return z10;
    }

    public int n(int i10) {
        return o(i10, 0);
    }

    public int o(int i10, int i11) {
        int size = size();
        if (i11 < 0) {
            i11 = 0;
        }
        while (i11 < size) {
            if (((i) this.f١٠٢١f.get(i11)).getGroupId() == i10) {
                return i11;
            }
            i11++;
        }
        return -1;
    }

    @Override // android.view.Menu
    public boolean performIdentifierAction(int i10, int i11) {
        return O(findItem(i10), i11);
    }

    @Override // android.view.Menu
    public boolean performShortcut(int i10, KeyEvent keyEvent, int i11) {
        boolean z10;
        i r10 = r(i10, keyEvent);
        if (r10 != null) {
            z10 = O(r10, i11);
        } else {
            z10 = false;
        }
        if ((i11 & 2) != 0) {
            e(true);
        }
        return z10;
    }

    public int q(int i10) {
        int size = size();
        for (int i11 = 0; i11 < size; i11++) {
            if (((i) this.f١٠٢١f.get(i11)).getItemId() == i10) {
                return i11;
            }
        }
        return -1;
    }

    i r(int i10, KeyEvent keyEvent) {
        char numericShortcut;
        ArrayList arrayList = this.f١٠٣٧v;
        arrayList.clear();
        s(arrayList, i10, keyEvent);
        if (arrayList.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        keyEvent.getKeyData(keyData);
        int size = arrayList.size();
        if (size == 1) {
            return (i) arrayList.get(0);
        }
        boolean J = J();
        for (int i11 = 0; i11 < size; i11++) {
            i iVar = (i) arrayList.get(i11);
            if (J) {
                numericShortcut = iVar.getAlphabeticShortcut();
            } else {
                numericShortcut = iVar.getNumericShortcut();
            }
            char[] cArr = keyData.meta;
            if ((numericShortcut == cArr[0] && (metaState & 2) == 0) || ((numericShortcut == cArr[2] && (metaState & 2) != 0) || (J && numericShortcut == '\b' && i10 == 67))) {
                return iVar;
            }
        }
        return null;
    }

    @Override // android.view.Menu
    public void removeGroup(int i10) {
        int n10 = n(i10);
        if (n10 >= 0) {
            int size = this.f١٠٢١f.size() - n10;
            int i11 = 0;
            while (true) {
                int i12 = i11 + 1;
                if (i11 >= size || ((i) this.f١٠٢١f.get(n10)).getGroupId() != i10) {
                    break;
                }
                Q(n10, false);
                i11 = i12;
            }
            N(true);
        }
    }

    @Override // android.view.Menu
    public void removeItem(int i10) {
        Q(q(i10), true);
    }

    void s(List list, int i10, KeyEvent keyEvent) {
        char numericShortcut;
        int numericModifiers;
        boolean J = J();
        int modifiers = keyEvent.getModifiers();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        if (!keyEvent.getKeyData(keyData) && i10 != 67) {
            return;
        }
        int size = this.f١٠٢١f.size();
        for (int i11 = 0; i11 < size; i11++) {
            i iVar = (i) this.f١٠٢١f.get(i11);
            if (iVar.hasSubMenu()) {
                ((g) iVar.getSubMenu()).s(list, i10, keyEvent);
            }
            if (J) {
                numericShortcut = iVar.getAlphabeticShortcut();
            } else {
                numericShortcut = iVar.getNumericShortcut();
            }
            if (J) {
                numericModifiers = iVar.getAlphabeticModifiers();
            } else {
                numericModifiers = iVar.getNumericModifiers();
            }
            if ((modifiers & 69647) == (numericModifiers & 69647) && numericShortcut != 0) {
                char[] cArr = keyData.meta;
                if ((numericShortcut == cArr[0] || numericShortcut == cArr[2] || (J && numericShortcut == '\b' && i10 == 67)) && iVar.isEnabled()) {
                    list.add(iVar);
                }
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupCheckable(int i10, boolean z10, boolean z11) {
        int size = this.f١٠٢١f.size();
        for (int i11 = 0; i11 < size; i11++) {
            i iVar = (i) this.f١٠٢١f.get(i11);
            if (iVar.getGroupId() == i10) {
                iVar.t(z11);
                iVar.setCheckable(z10);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupDividerEnabled(boolean z10) {
        this.f١٠٤٠y = z10;
    }

    @Override // android.view.Menu
    public void setGroupEnabled(int i10, boolean z10) {
        int size = this.f١٠٢١f.size();
        for (int i11 = 0; i11 < size; i11++) {
            i iVar = (i) this.f١٠٢١f.get(i11);
            if (iVar.getGroupId() == i10) {
                iVar.setEnabled(z10);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupVisible(int i10, boolean z10) {
        int size = this.f١٠٢١f.size();
        boolean z11 = false;
        for (int i11 = 0; i11 < size; i11++) {
            i iVar = (i) this.f١٠٢١f.get(i11);
            if (iVar.getGroupId() == i10 && iVar.y(z10)) {
                z11 = true;
            }
        }
        if (z11) {
            N(true);
        }
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z10) {
        this.f١٠١٨c = z10;
        N(false);
    }

    @Override // android.view.Menu
    public int size() {
        return this.f١٠٢١f.size();
    }

    public void t() {
        ArrayList G = G();
        if (!this.f١٠٢٦k) {
            return;
        }
        Iterator it = this.f١٠٣٨w.iterator();
        boolean z10 = false;
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            l lVar = (l) weakReference.get();
            if (lVar == null) {
                this.f١٠٣٨w.remove(weakReference);
            } else {
                z10 |= lVar.i();
            }
        }
        if (z10) {
            this.f١٠٢٤i.clear();
            this.f١٠٢٥j.clear();
            int size = G.size();
            for (int i10 = 0; i10 < size; i10++) {
                i iVar = (i) G.get(i10);
                if (iVar.l()) {
                    this.f١٠٢٤i.add(iVar);
                } else {
                    this.f١٠٢٥j.add(iVar);
                }
            }
        } else {
            this.f١٠٢٤i.clear();
            this.f١٠٢٥j.clear();
            this.f١٠٢٥j.addAll(G());
        }
        this.f١٠٢٦k = false;
    }

    public ArrayList u() {
        t();
        return this.f١٠٢٤i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String v() {
        return "android:menu:actionviewstates";
    }

    public Context w() {
        return this.f١٠١٦a;
    }

    public i x() {
        return this.f١٠٣٩x;
    }

    public Drawable y() {
        return this.f١٠٣٠o;
    }

    public CharSequence z() {
        return this.f١٠٢٩n;
    }

    @Override // android.view.Menu
    public MenuItem add(int i10) {
        return a(0, 0, 0, this.f١٠١٧b.getString(i10));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i10) {
        return addSubMenu(0, 0, 0, this.f١٠١٧b.getString(i10));
    }

    @Override // android.view.Menu
    public MenuItem add(int i10, int i11, int i12, CharSequence charSequence) {
        return a(i10, i11, i12, charSequence);
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i10, int i11, int i12, CharSequence charSequence) {
        i iVar = (i) a(i10, i11, i12, charSequence);
        q qVar = new q(this.f١٠١٦a, this, iVar);
        iVar.x(qVar);
        return qVar;
    }

    @Override // android.view.Menu
    public MenuItem add(int i10, int i11, int i12, int i13) {
        return a(i10, i11, i12, this.f١٠١٧b.getString(i13));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i10, int i11, int i12, int i13) {
        return addSubMenu(i10, i11, i12, this.f١٠١٧b.getString(i13));
    }
}
