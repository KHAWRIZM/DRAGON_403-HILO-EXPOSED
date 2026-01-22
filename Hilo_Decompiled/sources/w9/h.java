package w9;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.hjq.permissions.permission.base.IPermission;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class h {

    /* renamed from: h, reason: collision with root package name */
    private static Class f١٨٧٢٧h;

    /* renamed from: i, reason: collision with root package name */
    private static Class f١٨٧٢٨i;

    /* renamed from: j, reason: collision with root package name */
    private static Boolean f١٨٧٢٩j;

    /* renamed from: a, reason: collision with root package name */
    private final List f١٨٧٣٠a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    private final Context f١٨٧٣١b;

    /* renamed from: c, reason: collision with root package name */
    private Fragment f١٨٧٣٢c;

    /* renamed from: d, reason: collision with root package name */
    private androidx.fragment.app.Fragment f١٨٧٣٣d;

    /* renamed from: e, reason: collision with root package name */
    private f f١٨٧٣٤e;

    /* renamed from: f, reason: collision with root package name */
    private d f١٨٧٣٥f;

    /* renamed from: g, reason: collision with root package name */
    private Boolean f١٨٧٣٦g;

    private h(Context context) {
        this.f١٨٧٣١b = context;
    }

    private static void b(Context context, List list, c cVar) {
        if (cVar == null) {
            return;
        }
        ArrayList arrayList = new ArrayList(list.size());
        ArrayList arrayList2 = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            IPermission iPermission = (IPermission) it.next();
            if (iPermission.T(context, false)) {
                arrayList.add(iPermission);
            } else {
                arrayList2.add(iPermission);
            }
        }
        cVar.onResult(arrayList, arrayList2);
    }

    private static z9.a c(Activity activity) {
        return f(activity, null, null);
    }

    private static z9.a d(Activity activity, Fragment fragment) {
        return f(activity, null, fragment);
    }

    private static z9.a e(Activity activity, androidx.fragment.app.Fragment fragment) {
        return f(activity, fragment, null);
    }

    private static z9.a f(Activity activity, androidx.fragment.app.Fragment fragment, Fragment fragment2) {
        z9.a bVar;
        if (fragment != null) {
            return new z9.c(fragment.getActivity(), fragment.getChildFragmentManager());
        }
        if (fragment2 != null) {
            return new z9.b(fragment2.getActivity(), fragment2.getChildFragmentManager());
        }
        if (activity instanceof FragmentActivity) {
            FragmentActivity fragmentActivity = (FragmentActivity) activity;
            bVar = new z9.c(fragmentActivity, fragmentActivity.getSupportFragmentManager());
        } else {
            bVar = new z9.b(activity, activity.getFragmentManager());
        }
        return bVar;
    }

    public static List g(Context context, List list) {
        return ka.a.d(context, list);
    }

    public static d h() {
        Class cls = f١٨٧٢٨i;
        if (cls != null) {
            try {
                return (d) cls.newInstance();
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
        return new a();
    }

    public static f i() {
        Class cls = f١٨٧٢٧h;
        if (cls != null) {
            try {
                return (f) cls.newInstance();
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
        return new b();
    }

    private boolean k(Context context) {
        if (this.f١٨٧٣٦g == null) {
            if (f١٨٧٢٩j == null) {
                f١٨٧٢٩j = Boolean.valueOf(ka.g.q(context));
            }
            this.f١٨٧٣٦g = f١٨٧٢٩j;
        }
        return this.f١٨٧٣٦g.booleanValue();
    }

    public static boolean l(Activity activity, List list) {
        return ka.a.g(activity, list);
    }

    public static boolean m(Context context, IPermission iPermission) {
        return iPermission.F(context);
    }

    public static boolean n(Context context, List list) {
        return ka.a.h(context, list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void o(Activity activity, List list, c cVar) {
        if (ka.g.o(activity)) {
            return;
        }
        b(activity, list, cVar);
    }

    public static void s(final Activity activity, final List list, final c cVar) {
        if (ka.g.o(activity)) {
            return;
        }
        if (list.isEmpty()) {
            ja.b.a(activity, ka.c.d(activity));
        } else {
            c(activity).a(list, fa.a.START_ACTIVITY_FOR_RESULT, new x9.b() { // from class: w9.g
                @Override // x9.b
                public final void a() {
                    h.o(activity, list, cVar);
                }

                @Override // x9.b
                public /* synthetic */ void b() {
                    x9.a.a(this);
                }

                @Override // x9.b
                public /* synthetic */ void c() {
                    x9.a.b(this);
                }
            });
        }
    }

    public static h t(Context context) {
        return new h(context);
    }

    public static h u(androidx.fragment.app.Fragment fragment) {
        return new h(fragment);
    }

    public h j(f fVar) {
        this.f١٨٧٣٤e = fVar;
        return this;
    }

    public h p(IPermission iPermission) {
        this.f١٨٧٣٠a.remove(iPermission);
        this.f١٨٧٣٠a.add(iPermission);
        return this;
    }

    public h q(List list) {
        if (list.isEmpty()) {
            return this;
        }
        for (int i10 = 0; i10 < list.size(); i10++) {
            p((IPermission) list.get(i10));
        }
        return this;
    }

    public void r(c cVar) {
        z9.a c10;
        if (this.f١٨٧٣١b == null) {
            return;
        }
        if (this.f١٨٧٣٤e == null) {
            this.f١٨٧٣٤e = i();
        }
        if (this.f١٨٧٣٥f == null) {
            this.f١٨٧٣٥f = h();
        }
        Context context = this.f١٨٧٣١b;
        Fragment fragment = this.f١٨٧٣٢c;
        androidx.fragment.app.Fragment fragment2 = this.f١٨٧٣٣d;
        f fVar = this.f١٨٧٣٤e;
        d dVar = this.f١٨٧٣٥f;
        ArrayList arrayList = new ArrayList(this.f١٨٧٣٠a);
        Activity m10 = ka.g.m(context);
        if (k(context)) {
            ka.b.a(m10);
            if (fragment != null) {
                ka.b.b(fragment);
            } else if (fragment2 != null) {
                ka.b.e(fragment2);
            }
            ka.b.c(m10, arrayList, da.b.b(context));
        }
        if (ka.g.o(m10)) {
            return;
        }
        ka.a.a(m10, arrayList);
        if (ka.a.h(context, arrayList)) {
            fVar.onRequestPermissionEnd(m10, true, arrayList, arrayList, new ArrayList(), cVar);
            return;
        }
        if (fragment2 != null) {
            if (ka.g.s(fragment2)) {
                return;
            } else {
                c10 = e(m10, fragment2);
            }
        } else if (fragment != null) {
            if (ka.g.r(fragment)) {
                return;
            } else {
                c10 = d(m10, fragment);
            }
        } else {
            c10 = c(m10);
        }
        fVar.onRequestPermissionStart(m10, arrayList, c10, dVar, cVar);
    }

    private h(androidx.fragment.app.Fragment fragment) {
        this.f١٨٧٣٣d = fragment;
        this.f١٨٧٣١b = fragment.getActivity();
    }
}
