package androidx.databinding;

import android.util.Log;
import android.view.View;
import androidx.annotation.RestrictTo;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class MergedDataBinderMapper extends e {

    /* renamed from: a, reason: collision with root package name */
    private Set f٣١٩٤a = new HashSet();

    /* renamed from: b, reason: collision with root package name */
    private List f٣١٩٥b = new CopyOnWriteArrayList();

    /* renamed from: c, reason: collision with root package name */
    private List f٣١٩٦c = new CopyOnWriteArrayList();

    private boolean b() {
        boolean z10 = false;
        for (String str : this.f٣١٩٦c) {
            try {
                Class<?> cls = Class.forName(str);
                if (e.class.isAssignableFrom(cls)) {
                    a((e) cls.newInstance());
                    this.f٣١٩٦c.remove(str);
                    z10 = true;
                }
            } catch (ClassNotFoundException unused) {
            } catch (IllegalAccessException e10) {
                Log.e("MergedDataBinderMapper", "unable to add feature mapper for " + str, e10);
            } catch (InstantiationException e11) {
                Log.e("MergedDataBinderMapper", "unable to add feature mapper for " + str, e11);
            }
        }
        return z10;
    }

    public void a(e eVar) {
        if (this.f٣١٩٤a.add(eVar.getClass())) {
            this.f٣١٩٥b.add(eVar);
            Iterator it = eVar.collectDependencies().iterator();
            while (it.hasNext()) {
                a((e) it.next());
            }
        }
    }

    @Override // androidx.databinding.e
    public ViewDataBinding getDataBinder(f fVar, View view, int i10) {
        Iterator it = this.f٣١٩٥b.iterator();
        while (it.hasNext()) {
            ViewDataBinding dataBinder = ((e) it.next()).getDataBinder(fVar, view, i10);
            if (dataBinder != null) {
                return dataBinder;
            }
        }
        if (b()) {
            return getDataBinder(fVar, view, i10);
        }
        return null;
    }

    @Override // androidx.databinding.e
    public int getLayoutId(String str) {
        Iterator it = this.f٣١٩٥b.iterator();
        while (it.hasNext()) {
            int layoutId = ((e) it.next()).getLayoutId(str);
            if (layoutId != 0) {
                return layoutId;
            }
        }
        if (b()) {
            return getLayoutId(str);
        }
        return 0;
    }

    @Override // androidx.databinding.e
    public ViewDataBinding getDataBinder(f fVar, View[] viewArr, int i10) {
        Iterator it = this.f٣١٩٥b.iterator();
        while (it.hasNext()) {
            ViewDataBinding dataBinder = ((e) it.next()).getDataBinder(fVar, viewArr, i10);
            if (dataBinder != null) {
                return dataBinder;
            }
        }
        if (b()) {
            return getDataBinder(fVar, viewArr, i10);
        }
        return null;
    }
}
