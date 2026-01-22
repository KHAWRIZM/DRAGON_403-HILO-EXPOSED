package androidx.core.view;

import android.view.View;
import android.view.ViewTreeObserver;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class m0 implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

    /* renamed from: a, reason: collision with root package name */
    private final View f٢٩٩٤a;

    /* renamed from: b, reason: collision with root package name */
    private ViewTreeObserver f٢٩٩٥b;

    /* renamed from: c, reason: collision with root package name */
    private final Runnable f٢٩٩٦c;

    private m0(View view, Runnable runnable) {
        this.f٢٩٩٤a = view;
        this.f٢٩٩٥b = view.getViewTreeObserver();
        this.f٢٩٩٦c = runnable;
    }

    public static m0 a(View view, Runnable runnable) {
        if (view != null) {
            if (runnable != null) {
                m0 m0Var = new m0(view, runnable);
                view.getViewTreeObserver().addOnPreDrawListener(m0Var);
                view.addOnAttachStateChangeListener(m0Var);
                return m0Var;
            }
            throw new NullPointerException("runnable == null");
        }
        throw new NullPointerException("view == null");
    }

    public void b() {
        if (this.f٢٩٩٥b.isAlive()) {
            this.f٢٩٩٥b.removeOnPreDrawListener(this);
        } else {
            this.f٢٩٩٤a.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        this.f٢٩٩٤a.removeOnAttachStateChangeListener(this);
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        b();
        this.f٢٩٩٦c.run();
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        this.f٢٩٩٥b = view.getViewTreeObserver();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        b();
    }
}
