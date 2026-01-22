package z4;

import android.R;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bumptech.glide.Glide;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import v4.z;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class o implements Handler.Callback {

    /* renamed from: f, reason: collision with root package name */
    private static final b f١٩٤٥٤f = new a();

    /* renamed from: a, reason: collision with root package name */
    private volatile com.bumptech.glide.j f١٩٤٥٥a;

    /* renamed from: b, reason: collision with root package name */
    private final b f١٩٤٥٦b;

    /* renamed from: c, reason: collision with root package name */
    private final androidx.collection.a f١٩٤٥٧c = new androidx.collection.a();

    /* renamed from: d, reason: collision with root package name */
    private final i f١٩٤٥٨d;

    /* renamed from: e, reason: collision with root package name */
    private final m f١٩٤٥٩e;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class a implements b {
        a() {
        }

        @Override // z4.o.b
        public com.bumptech.glide.j a(Glide glide, j jVar, p pVar, Context context) {
            return new com.bumptech.glide.j(glide, jVar, pVar, context);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public interface b {
        com.bumptech.glide.j a(Glide glide, j jVar, p pVar, Context context);
    }

    public o(b bVar) {
        bVar = bVar == null ? f١٩٤٥٤f : bVar;
        this.f١٩٤٥٦b = bVar;
        this.f١٩٤٥٩e = new m(bVar);
        this.f١٩٤٥٨d = b();
    }

    private static void a(Activity activity) {
        if (!activity.isDestroyed()) {
        } else {
            throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
        }
    }

    private static i b() {
        if (z.f١٨٥٦٥f && z.f١٨٥٦٤e) {
            return new h();
        }
        return new f();
    }

    private static Activity c(Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return c(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    private static void d(Collection collection, Map map) {
        if (collection == null) {
            return;
        }
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            Fragment fragment = (Fragment) it.next();
            if (fragment != null && fragment.getView() != null) {
                map.put(fragment.getView(), fragment);
                d(fragment.getChildFragmentManager().getFragments(), map);
            }
        }
    }

    private Fragment e(View view, FragmentActivity fragmentActivity) {
        this.f١٩٤٥٧c.clear();
        d(fragmentActivity.getSupportFragmentManager().getFragments(), this.f١٩٤٥٧c);
        View findViewById = fragmentActivity.findViewById(R.id.content);
        Fragment fragment = null;
        while (!view.equals(findViewById) && (fragment = (Fragment) this.f١٩٤٥٧c.get(view)) == null && (view.getParent() instanceof View)) {
            view = (View) view.getParent();
        }
        this.f١٩٤٥٧c.clear();
        return fragment;
    }

    private com.bumptech.glide.j j(Context context) {
        if (this.f١٩٤٥٥a == null) {
            synchronized (this) {
                try {
                    if (this.f١٩٤٥٥a == null) {
                        this.f١٩٤٥٥a = this.f١٩٤٥٦b.a(Glide.get(context.getApplicationContext()), new z4.a(), new g(), context.getApplicationContext());
                    }
                } finally {
                }
            }
        }
        return this.f١٩٤٥٥a;
    }

    private static boolean k(Context context) {
        Activity c10 = c(context);
        if (c10 != null && c10.isFinishing()) {
            return false;
        }
        return true;
    }

    public com.bumptech.glide.j f(Context context) {
        if (context != null) {
            if (f5.l.t() && !(context instanceof Application)) {
                if (context instanceof FragmentActivity) {
                    return i((FragmentActivity) context);
                }
                if (context instanceof ContextWrapper) {
                    ContextWrapper contextWrapper = (ContextWrapper) context;
                    if (contextWrapper.getBaseContext().getApplicationContext() != null) {
                        return f(contextWrapper.getBaseContext());
                    }
                }
            }
            return j(context);
        }
        throw new IllegalArgumentException("You cannot start a load on a null Context");
    }

    public com.bumptech.glide.j g(View view) {
        if (f5.l.s()) {
            return f(view.getContext().getApplicationContext());
        }
        f5.k.d(view);
        f5.k.e(view.getContext(), "Unable to obtain a request manager for a view without a Context");
        Activity c10 = c(view.getContext());
        if (c10 == null) {
            return f(view.getContext().getApplicationContext());
        }
        if (c10 instanceof FragmentActivity) {
            FragmentActivity fragmentActivity = (FragmentActivity) c10;
            Fragment e10 = e(view, fragmentActivity);
            if (e10 != null) {
                return h(e10);
            }
            return i(fragmentActivity);
        }
        return f(view.getContext().getApplicationContext());
    }

    public com.bumptech.glide.j h(Fragment fragment) {
        f5.k.e(fragment.getContext(), "You cannot start a load on a fragment before it is attached or after it is destroyed");
        if (f5.l.s()) {
            return f(fragment.getContext().getApplicationContext());
        }
        if (fragment.getActivity() != null) {
            this.f١٩٤٥٨d.a(fragment.getActivity());
        }
        FragmentManager childFragmentManager = fragment.getChildFragmentManager();
        Context context = fragment.getContext();
        return this.f١٩٤٥٩e.b(context, Glide.get(context.getApplicationContext()), fragment.getLifecycle(), childFragmentManager, fragment.isVisible());
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        return false;
    }

    public com.bumptech.glide.j i(FragmentActivity fragmentActivity) {
        if (f5.l.s()) {
            return f(fragmentActivity.getApplicationContext());
        }
        a(fragmentActivity);
        this.f١٩٤٥٨d.a(fragmentActivity);
        boolean k10 = k(fragmentActivity);
        return this.f١٩٤٥٩e.b(fragmentActivity, Glide.get(fragmentActivity.getApplicationContext()), fragmentActivity.getLifecycle(), fragmentActivity.getSupportFragmentManager(), k10);
    }
}
