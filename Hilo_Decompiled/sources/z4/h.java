package z4;

import android.app.Activity;
import android.view.View;
import android.view.ViewTreeObserver;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;
import v4.z;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
final class h implements i {

    /* renamed from: a, reason: collision with root package name */
    final Set f١٩٤٤٠a = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: b, reason: collision with root package name */
    volatile boolean f١٩٤٤١b;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class a implements ViewTreeObserver.OnDrawListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f١٩٤٤٢a;

        /* renamed from: z4.h$a$a, reason: collision with other inner class name */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        class RunnableC٠٢٥٥a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ ViewTreeObserver.OnDrawListener f١٩٤٤٤a;

            RunnableC٠٢٥٥a(ViewTreeObserver.OnDrawListener onDrawListener) {
                this.f١٩٤٤٤a = onDrawListener;
            }

            @Override // java.lang.Runnable
            public void run() {
                z.b().h();
                h.this.f١٩٤٤١b = true;
                h.b(a.this.f١٩٤٤٢a, this.f١٩٤٤٤a);
                h.this.f١٩٤٤٠a.clear();
            }
        }

        a(View view) {
            this.f١٩٤٤٢a = view;
        }

        @Override // android.view.ViewTreeObserver.OnDrawListener
        public void onDraw() {
            f5.l.w(new RunnableC٠٢٥٥a(this));
        }
    }

    static void b(View view, ViewTreeObserver.OnDrawListener onDrawListener) {
        view.getViewTreeObserver().removeOnDrawListener(onDrawListener);
    }

    @Override // z4.i
    public void a(Activity activity) {
        if (this.f١٩٤٤١b || !this.f١٩٤٤٠a.add(activity)) {
            return;
        }
        View decorView = activity.getWindow().getDecorView();
        decorView.getViewTreeObserver().addOnDrawListener(new a(decorView));
    }
}
