package x9;

import android.app.Activity;
import android.text.TextUtils;
import com.hjq.permissions.permission.base.IPermission;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import x9.n;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    private final Activity f١٩٠٢١a;

    /* renamed from: b, reason: collision with root package name */
    private final List f١٩٠٢٢b;

    /* renamed from: c, reason: collision with root package name */
    private final z9.a f١٩٠٢٣c;

    /* renamed from: d, reason: collision with root package name */
    private final w9.f f١٩٠٢٤d;

    /* renamed from: e, reason: collision with root package name */
    private final w9.d f١٩٠٢٥e;

    /* renamed from: f, reason: collision with root package name */
    private final w9.c f١٩٠٢٦f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Iterator f١٩٠٢٧a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Activity f١٩٠٢٨b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ z9.a f١٩٠٢٩c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ w9.d f١٩٠٣٠d;

        a(Iterator it, Activity activity, z9.a aVar, w9.d dVar) {
            this.f١٩٠٢٧a = it;
            this.f١٩٠٢٨b = activity;
            this.f١٩٠٢٩c = aVar;
            this.f١٩٠٣٠d = dVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(Activity activity, List list, z9.a aVar, w9.d dVar) {
            n.m(activity, list, aVar, dVar, this);
        }

        @Override // java.lang.Runnable
        public void run() {
            List list;
            loop0: do {
                list = null;
                while (true) {
                    if (!this.f١٩٠٢٧a.hasNext()) {
                        break loop0;
                    }
                    list = (List) this.f١٩٠٢٧a.next();
                    if (list != null && !list.isEmpty()) {
                        break;
                    }
                }
            } while (ka.a.h(this.f١٩٠٢٨b, list));
            final List list2 = list;
            if (list2 == null || list2.isEmpty()) {
                n.this.j();
                return;
            }
            boolean z10 = false;
            IPermission iPermission = (IPermission) list2.get(0);
            if (iPermission.z(this.f١٩٠٢٨b)) {
                List G = iPermission.G(this.f١٩٠٢٨b);
                boolean z11 = true;
                if (G != null && !G.isEmpty()) {
                    Iterator it = G.iterator();
                    while (it.hasNext()) {
                        if (((IPermission) it.next()).F(this.f١٩٠٢٨b)) {
                            z10 = true;
                        }
                    }
                    z11 = z10;
                }
                if (!z11) {
                    run();
                    return;
                }
            }
            int e10 = ka.a.e(this.f١٩٠٢٨b, list2);
            if (e10 == 0) {
                n.m(this.f١٩٠٢٨b, list2, this.f١٩٠٢٩c, this.f١٩٠٣٠d, this);
                return;
            }
            final Activity activity = this.f١٩٠٢٨b;
            final z9.a aVar = this.f١٩٠٢٩c;
            final w9.d dVar = this.f١٩٠٣٠d;
            ka.d.b(new Runnable() { // from class: x9.m
                @Override // java.lang.Runnable
                public final void run() {
                    n.a.this.b(activity, list2, aVar, dVar);
                }
            }, e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class b implements x9.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ w9.d f١٩٠٣٢a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Activity f١٩٠٣٣b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ List f١٩٠٣٤c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Runnable f١٩٠٣٥d;

        b(w9.d dVar, Activity activity, List list, Runnable runnable) {
            this.f١٩٠٣٢a = dVar;
            this.f١٩٠٣٣b = activity;
            this.f١٩٠٣٤c = list;
            this.f١٩٠٣٥d = runnable;
        }

        @Override // x9.b
        public void a() {
            this.f١٩٠٣٢a.b(this.f١٩٠٣٣b, this.f١٩٠٣٤c);
            this.f١٩٠٣٥d.run();
        }

        @Override // x9.b
        public void b() {
            this.f١٩٠٣٢a.b(this.f١٩٠٣٣b, this.f١٩٠٣٤c);
        }

        @Override // x9.b
        public void c() {
            this.f١٩٠٣٢a.c(this.f١٩٠٣٣b, this.f١٩٠٣٤c);
        }
    }

    public n(Activity activity, List list, z9.a aVar, w9.f fVar, w9.d dVar, w9.c cVar) {
        this.f١٩٠٢١a = activity;
        this.f١٩٠٢٢b = list;
        this.f١٩٠٢٣c = aVar;
        this.f١٩٠٢٤d = fVar;
        this.f١٩٠٢٥e = dVar;
        this.f١٩٠٢٦f = cVar;
    }

    private static List f(Activity activity, List list) {
        ArrayList arrayList = new ArrayList(list.size());
        ArrayList arrayList2 = new ArrayList(list.size());
        for (int i10 = 0; i10 < list.size(); i10++) {
            IPermission iPermission = (IPermission) list.get(i10);
            if (!ka.g.c(arrayList2, iPermission)) {
                arrayList2.add(iPermission);
                if (iPermission.m(activity) && !iPermission.F(activity)) {
                    if (iPermission.q(activity) == fa.a.START_ACTIVITY_FOR_RESULT) {
                        arrayList.add(ka.g.b(iPermission));
                    } else {
                        String k10 = iPermission.k(activity);
                        if (TextUtils.isEmpty(k10)) {
                            arrayList.add(ka.g.b(iPermission));
                        } else {
                            ArrayList arrayList3 = null;
                            ArrayList arrayList4 = null;
                            for (int i11 = i10; i11 < list.size(); i11++) {
                                IPermission iPermission2 = (IPermission) list.get(i11);
                                if (ka.g.l(iPermission2.k(activity), k10) && iPermission2.m(activity) && !iPermission2.F(activity)) {
                                    if (arrayList4 == null) {
                                        arrayList4 = new ArrayList();
                                    }
                                    arrayList4.add(iPermission2);
                                    if (!ka.g.c(arrayList2, iPermission2)) {
                                        arrayList2.add(iPermission2);
                                    }
                                }
                            }
                            if (arrayList4 != null && !arrayList4.isEmpty() && !ka.a.h(activity, arrayList4)) {
                                Iterator it = arrayList4.iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        break;
                                    }
                                    IPermission iPermission3 = (IPermission) it.next();
                                    if (iPermission3.z(activity)) {
                                        it.remove();
                                        arrayList3 = new ArrayList();
                                        arrayList3.add(iPermission3);
                                        break;
                                    }
                                }
                                if (!arrayList4.isEmpty()) {
                                    arrayList.add(arrayList4);
                                }
                                if (arrayList3 != null && !arrayList3.isEmpty()) {
                                    arrayList.add(arrayList3);
                                }
                            }
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        Activity activity = this.f١٩٠٢١a;
        List<IPermission> list = this.f١٩٠٢٢b;
        if (ka.g.o(activity)) {
            return;
        }
        ArrayList arrayList = new ArrayList(list.size());
        ArrayList arrayList2 = new ArrayList(list.size());
        for (IPermission iPermission : list) {
            if (iPermission.T(activity, false)) {
                arrayList.add(iPermission);
            } else {
                arrayList2.add(iPermission);
            }
        }
        this.f١٩٠٢٤d.onRequestPermissionEnd(activity, false, list, arrayList, arrayList2, this.f١٩٠٢٦f);
        k(activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void i(z9.a aVar, List list, fa.a aVar2, w9.d dVar, Activity activity, Runnable runnable) {
        aVar.a(list, aVar2, new b(dVar, activity, list, runnable));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        ka.d.b(new Runnable() { // from class: x9.l
            @Override // java.lang.Runnable
            public final void run() {
                n.this.g();
            }
        }, 100L);
    }

    private void k(final Activity activity) {
        ka.d.b(new Runnable() { // from class: x9.k
            @Override // java.lang.Runnable
            public final void run() {
                ca.b.d(activity);
            }
        }, 100L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void m(final Activity activity, final List list, final z9.a aVar, final w9.d dVar, final Runnable runnable) {
        if (list.isEmpty()) {
            runnable.run();
            return;
        }
        fa.a aVar2 = fa.a.REQUEST_PERMISSIONS;
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (((IPermission) it.next()).q(activity) != fa.a.REQUEST_PERMISSIONS) {
                aVar2 = fa.a.START_ACTIVITY_FOR_RESULT;
                break;
            }
        }
        final fa.a aVar3 = aVar2;
        if (!ka.h.n() && aVar3 == fa.a.REQUEST_PERMISSIONS) {
            runnable.run();
        } else {
            dVar.a(activity, list, new Runnable() { // from class: x9.j
                @Override // java.lang.Runnable
                public final void run() {
                    n.i(z9.a.this, list, aVar3, dVar, activity, runnable);
                }
            }, runnable);
        }
    }

    public void l() {
        if (this.f١٩٠٢٢b.isEmpty()) {
            return;
        }
        List f10 = f(this.f١٩٠٢١a, this.f١٩٠٢٢b);
        if (f10.isEmpty()) {
            g();
            return;
        }
        Iterator it = f10.iterator();
        List list = null;
        while (it.hasNext() && (list == null || list.isEmpty())) {
            list = (List) it.next();
        }
        if (list != null && !list.isEmpty()) {
            Activity activity = this.f١٩٠٢١a;
            z9.a aVar = this.f١٩٠٢٣c;
            w9.d dVar = this.f١٩٠٢٥e;
            ca.b.c(activity);
            m(activity, list, aVar, dVar, new a(it, activity, aVar, dVar));
            return;
        }
        g();
    }
}
