package androidx.activity;

import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import java.lang.reflect.Field;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class k implements LifecycleEventObserver {

    /* renamed from: b, reason: collision with root package name */
    private static int f٥٢١b;

    /* renamed from: c, reason: collision with root package name */
    private static Field f٥٢٢c;

    /* renamed from: d, reason: collision with root package name */
    private static Field f٥٢٣d;

    /* renamed from: e, reason: collision with root package name */
    private static Field f٥٢٤e;

    /* renamed from: a, reason: collision with root package name */
    private Activity f٥٢٥a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(Activity activity) {
        this.f٥٢٥a = activity;
    }

    private static void a() {
        try {
            f٥٢١b = 2;
            Field declaredField = InputMethodManager.class.getDeclaredField("mServedView");
            f٥٢٣d = declaredField;
            declaredField.setAccessible(true);
            Field declaredField2 = InputMethodManager.class.getDeclaredField("mNextServedView");
            f٥٢٤e = declaredField2;
            declaredField2.setAccessible(true);
            Field declaredField3 = InputMethodManager.class.getDeclaredField("mH");
            f٥٢٢c = declaredField3;
            declaredField3.setAccessible(true);
            f٥٢١b = 1;
        } catch (NoSuchFieldException unused) {
        }
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        if (event != Lifecycle.Event.ON_DESTROY) {
            return;
        }
        if (f٥٢١b == 0) {
            a();
        }
        if (f٥٢١b == 1) {
            InputMethodManager inputMethodManager = (InputMethodManager) this.f٥٢٥a.getSystemService("input_method");
            try {
                Object obj = f٥٢٢c.get(inputMethodManager);
                if (obj == null) {
                    return;
                }
                synchronized (obj) {
                    try {
                        try {
                            try {
                                View view = (View) f٥٢٣d.get(inputMethodManager);
                                if (view == null) {
                                    return;
                                }
                                if (view.isAttachedToWindow()) {
                                    return;
                                }
                                try {
                                    f٥٢٤e.set(inputMethodManager, null);
                                    inputMethodManager.isActive();
                                } catch (IllegalAccessException unused) {
                                }
                            } catch (ClassCastException unused2) {
                            }
                        } catch (IllegalAccessException unused3) {
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            } catch (IllegalAccessException unused4) {
            }
        }
    }
}
