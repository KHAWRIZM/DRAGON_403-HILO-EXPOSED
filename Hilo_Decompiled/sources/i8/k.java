package i8;

import android.app.Activity;
import android.app.SharedElementCallback;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.transition.Transition;
import android.view.View;
import android.view.Window;
import com.google.android.material.R;
import f8.o;
import f8.r;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class k extends SharedElementCallback {

    /* renamed from: f, reason: collision with root package name */
    private static WeakReference f١٤٧٧٥f;

    /* renamed from: d, reason: collision with root package name */
    private Rect f١٤٧٧٩d;

    /* renamed from: a, reason: collision with root package name */
    private boolean f١٤٧٧٦a = true;

    /* renamed from: b, reason: collision with root package name */
    private boolean f١٤٧٧٧b = true;

    /* renamed from: c, reason: collision with root package name */
    private boolean f١٤٧٧٨c = false;

    /* renamed from: e, reason: collision with root package name */
    private d f١٤٧٨٠e = new e();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class a extends l {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Window f١٤٧٨١a;

        a(Window window) {
            this.f١٤٧٨١a = window;
        }

        @Override // i8.l, android.transition.Transition.TransitionListener
        public void onTransitionEnd(Transition transition) {
            k.g(this.f١٤٧٨١a);
        }

        @Override // i8.l, android.transition.Transition.TransitionListener
        public void onTransitionStart(Transition transition) {
            k.f(this.f١٤٧٨١a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class b extends l {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Activity f١٤٧٨٣a;

        b(Activity activity) {
            this.f١٤٧٨٣a = activity;
        }

        @Override // i8.l, android.transition.Transition.TransitionListener
        public void onTransitionEnd(Transition transition) {
            View view;
            if (k.f١٤٧٧٥f != null && (view = (View) k.f١٤٧٧٥f.get()) != null) {
                view.setAlpha(1.0f);
                WeakReference unused = k.f١٤٧٧٥f = null;
            }
            this.f١٤٧٨٣a.finish();
            this.f١٤٧٨٣a.overridePendingTransition(0, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class c extends l {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Window f١٤٧٨٥a;

        c(Window window) {
            this.f١٤٧٨٥a = window;
        }

        @Override // i8.l, android.transition.Transition.TransitionListener
        public void onTransitionStart(Transition transition) {
            k.f(this.f١٤٧٨٥a);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public interface d {
        o a(View view);
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class e implements d {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // i8.k.d
        public o a(View view) {
            if (view instanceof r) {
                return ((r) view).getShapeAppearanceModel();
            }
            return null;
        }
    }

    private static Drawable e(Window window) {
        return window.getDecorView().getBackground();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void f(Window window) {
        Drawable e10 = e(window);
        if (e10 == null) {
            return;
        }
        e10.mutate().setColorFilter(androidx.core.graphics.d.a(0, androidx.core.graphics.e.CLEAR));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g(Window window) {
        Drawable e10 = e(window);
        if (e10 == null) {
            return;
        }
        e10.mutate().clearColorFilter();
    }

    private void h(Window window) {
        Transition sharedElementEnterTransition = window.getSharedElementEnterTransition();
        if (sharedElementEnterTransition instanceof j) {
            j jVar = (j) sharedElementEnterTransition;
            if (!this.f١٤٧٧٨c) {
                window.setSharedElementReenterTransition(null);
            }
            if (this.f١٤٧٧٧b) {
                j(window, jVar);
                jVar.addListener(new a(window));
            }
        }
    }

    private void i(Activity activity, Window window) {
        Transition sharedElementReturnTransition = window.getSharedElementReturnTransition();
        if (sharedElementReturnTransition instanceof j) {
            j jVar = (j) sharedElementReturnTransition;
            jVar.t(true);
            jVar.addListener(new b(activity));
            if (this.f١٤٧٧٧b) {
                j(window, jVar);
                jVar.addListener(new c(window));
            }
        }
    }

    private static void j(Window window, j jVar) {
        if (jVar.getDuration() >= 0) {
            window.setTransitionBackgroundFadeDuration(jVar.getDuration());
        }
    }

    @Override // android.app.SharedElementCallback
    public Parcelable onCaptureSharedElementSnapshot(View view, Matrix matrix, RectF rectF) {
        f١٤٧٧٥f = new WeakReference(view);
        return super.onCaptureSharedElementSnapshot(view, matrix, rectF);
    }

    @Override // android.app.SharedElementCallback
    public View onCreateSnapshotView(Context context, Parcelable parcelable) {
        WeakReference weakReference;
        View view;
        o a10;
        View onCreateSnapshotView = super.onCreateSnapshotView(context, parcelable);
        if (onCreateSnapshotView != null && (weakReference = f١٤٧٧٥f) != null && this.f١٤٧٨٠e != null && (view = (View) weakReference.get()) != null && (a10 = this.f١٤٧٨٠e.a(view)) != null) {
            onCreateSnapshotView.setTag(R.id.mtrl_motion_snapshot_view, a10);
        }
        return onCreateSnapshotView;
    }

    @Override // android.app.SharedElementCallback
    public void onMapSharedElements(List list, Map map) {
        View view;
        Activity a10;
        if (!list.isEmpty() && !map.isEmpty() && (view = (View) map.get(list.get(0))) != null && (a10 = com.google.android.material.internal.c.a(view.getContext())) != null) {
            Window window = a10.getWindow();
            if (this.f١٤٧٧٦a) {
                h(window);
            } else {
                i(a10, window);
            }
        }
    }

    @Override // android.app.SharedElementCallback
    public void onSharedElementEnd(List list, List list2, List list3) {
        if (!list2.isEmpty()) {
            View view = (View) list2.get(0);
            int i10 = R.id.mtrl_motion_snapshot_view;
            if (view.getTag(i10) instanceof View) {
                ((View) list2.get(0)).setTag(i10, null);
            }
        }
        if (!this.f١٤٧٧٦a && !list2.isEmpty()) {
            this.f١٤٧٧٩d = n.j((View) list2.get(0));
        }
        this.f١٤٧٧٦a = false;
    }

    @Override // android.app.SharedElementCallback
    public void onSharedElementStart(List list, List list2, List list3) {
        if (!list2.isEmpty() && !list3.isEmpty()) {
            ((View) list2.get(0)).setTag(R.id.mtrl_motion_snapshot_view, list3.get(0));
        }
        if (!this.f١٤٧٧٦a && !list2.isEmpty() && this.f١٤٧٧٩d != null) {
            View view = (View) list2.get(0);
            view.measure(View.MeasureSpec.makeMeasureSpec(this.f١٤٧٧٩d.width(), 1073741824), View.MeasureSpec.makeMeasureSpec(this.f١٤٧٧٩d.height(), 1073741824));
            Rect rect = this.f١٤٧٧٩d;
            view.layout(rect.left, rect.top, rect.right, rect.bottom);
        }
    }
}
