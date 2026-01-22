package androidx.appcompat.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class m0 extends ContextWrapper {

    /* renamed from: c, reason: collision with root package name */
    private static final Object f١٦٠٩c = new Object();

    /* renamed from: d, reason: collision with root package name */
    private static ArrayList f١٦١٠d;

    /* renamed from: a, reason: collision with root package name */
    private final Resources f١٦١١a;

    /* renamed from: b, reason: collision with root package name */
    private final Resources.Theme f١٦١٢b;

    private m0(Context context) {
        super(context);
        if (z0.d()) {
            z0 z0Var = new z0(this, context.getResources());
            this.f١٦١١a = z0Var;
            Resources.Theme newTheme = z0Var.newTheme();
            this.f١٦١٢b = newTheme;
            newTheme.setTo(context.getTheme());
            return;
        }
        this.f١٦١١a = new o0(this, context.getResources());
        this.f١٦١٢b = null;
    }

    private static boolean a(Context context) {
        if (!(context instanceof m0) && !(context.getResources() instanceof o0) && !(context.getResources() instanceof z0)) {
            return z0.d();
        }
        return false;
    }

    public static Context b(Context context) {
        m0 m0Var;
        if (a(context)) {
            synchronized (f١٦٠٩c) {
                try {
                    ArrayList arrayList = f١٦١٠d;
                    if (arrayList == null) {
                        f١٦١٠d = new ArrayList();
                    } else {
                        for (int size = arrayList.size() - 1; size >= 0; size--) {
                            WeakReference weakReference = (WeakReference) f١٦١٠d.get(size);
                            if (weakReference == null || weakReference.get() == null) {
                                f١٦١٠d.remove(size);
                            }
                        }
                        for (int size2 = f١٦١٠d.size() - 1; size2 >= 0; size2--) {
                            WeakReference weakReference2 = (WeakReference) f١٦١٠d.get(size2);
                            if (weakReference2 != null) {
                                m0Var = (m0) weakReference2.get();
                            } else {
                                m0Var = null;
                            }
                            if (m0Var != null && m0Var.getBaseContext() == context) {
                                return m0Var;
                            }
                        }
                    }
                    m0 m0Var2 = new m0(context);
                    f١٦١٠d.add(new WeakReference(m0Var2));
                    return m0Var2;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return context;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return this.f١٦١١a.getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return this.f١٦١١a;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme theme = this.f١٦١٢b;
        if (theme == null) {
            return super.getTheme();
        }
        return theme;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i10) {
        Resources.Theme theme = this.f١٦١٢b;
        if (theme == null) {
            super.setTheme(i10);
        } else {
            theme.applyStyle(i10, true);
        }
    }
}
