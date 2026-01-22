package com.bumptech.glide.request.target;

import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import com.bumptech.glide.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class d implements j {

    /* renamed from: f, reason: collision with root package name */
    private static final int f٧٥٢٨f = R.id.glide_custom_view_target_tag;

    /* renamed from: a, reason: collision with root package name */
    private final a f٧٥٢٩a;

    /* renamed from: b, reason: collision with root package name */
    protected final View f٧٥٣٠b;

    /* renamed from: c, reason: collision with root package name */
    private View.OnAttachStateChangeListener f٧٥٣١c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f٧٥٣٢d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f٧٥٣٣e;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    static final class a {

        /* renamed from: e, reason: collision with root package name */
        static Integer f٧٥٣٤e;

        /* renamed from: a, reason: collision with root package name */
        private final View f٧٥٣٥a;

        /* renamed from: b, reason: collision with root package name */
        private final List f٧٥٣٦b = new ArrayList();

        /* renamed from: c, reason: collision with root package name */
        boolean f٧٥٣٧c;

        /* renamed from: d, reason: collision with root package name */
        private ViewTreeObserverOnPreDrawListenerC٠١٠٧a f٧٥٣٨d;

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.bumptech.glide.request.target.d$a$a, reason: collision with other inner class name */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        public static final class ViewTreeObserverOnPreDrawListenerC٠١٠٧a implements ViewTreeObserver.OnPreDrawListener {

            /* renamed from: a, reason: collision with root package name */
            private final WeakReference f٧٥٣٩a;

            ViewTreeObserverOnPreDrawListenerC٠١٠٧a(a aVar) {
                this.f٧٥٣٩a = new WeakReference(aVar);
            }

            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                if (Log.isLoggable("CustomViewTarget", 2)) {
                    Log.v("CustomViewTarget", "OnGlobalLayoutListener called attachStateListener=" + this);
                }
                a aVar = (a) this.f٧٥٣٩a.get();
                if (aVar != null) {
                    aVar.a();
                    return true;
                }
                return true;
            }
        }

        a(View view) {
            this.f٧٥٣٥a = view;
        }

        private static int c(Context context) {
            if (f٧٥٣٤e == null) {
                Display defaultDisplay = ((WindowManager) f5.k.d((WindowManager) context.getSystemService("window"))).getDefaultDisplay();
                Point point = new Point();
                defaultDisplay.getSize(point);
                f٧٥٣٤e = Integer.valueOf(Math.max(point.x, point.y));
            }
            return f٧٥٣٤e.intValue();
        }

        private int e(int i10, int i11, int i12) {
            int i13 = i11 - i12;
            if (i13 > 0) {
                return i13;
            }
            if (this.f٧٥٣٧c && this.f٧٥٣٥a.isLayoutRequested()) {
                return 0;
            }
            int i14 = i10 - i12;
            if (i14 > 0) {
                return i14;
            }
            if (this.f٧٥٣٥a.isLayoutRequested() || i11 != -2) {
                return 0;
            }
            if (Log.isLoggable("CustomViewTarget", 4)) {
                Log.i("CustomViewTarget", "Glide treats LayoutParams.WRAP_CONTENT as a request for an image the size of this device's screen dimensions. If you want to load the original image and are ok with the corresponding memory cost and OOMs (depending on the input size), use .override(Target.SIZE_ORIGINAL). Otherwise, use LayoutParams.MATCH_PARENT, set layout_width and layout_height to fixed dimension, or use .override() with fixed dimensions.");
            }
            return c(this.f٧٥٣٥a.getContext());
        }

        private int f() {
            int i10;
            int paddingTop = this.f٧٥٣٥a.getPaddingTop() + this.f٧٥٣٥a.getPaddingBottom();
            ViewGroup.LayoutParams layoutParams = this.f٧٥٣٥a.getLayoutParams();
            if (layoutParams != null) {
                i10 = layoutParams.height;
            } else {
                i10 = 0;
            }
            return e(this.f٧٥٣٥a.getHeight(), i10, paddingTop);
        }

        private int g() {
            int i10;
            int paddingLeft = this.f٧٥٣٥a.getPaddingLeft() + this.f٧٥٣٥a.getPaddingRight();
            ViewGroup.LayoutParams layoutParams = this.f٧٥٣٥a.getLayoutParams();
            if (layoutParams != null) {
                i10 = layoutParams.width;
            } else {
                i10 = 0;
            }
            return e(this.f٧٥٣٥a.getWidth(), i10, paddingLeft);
        }

        private boolean h(int i10) {
            return i10 > 0 || i10 == Integer.MIN_VALUE;
        }

        private boolean i(int i10, int i11) {
            if (h(i10) && h(i11)) {
                return true;
            }
            return false;
        }

        private void j(int i10, int i11) {
            Iterator it = new ArrayList(this.f٧٥٣٦b).iterator();
            while (it.hasNext()) {
                ((i) it.next()).d(i10, i11);
            }
        }

        void a() {
            if (this.f٧٥٣٦b.isEmpty()) {
                return;
            }
            int g10 = g();
            int f10 = f();
            if (!i(g10, f10)) {
                return;
            }
            j(g10, f10);
            b();
        }

        void b() {
            ViewTreeObserver viewTreeObserver = this.f٧٥٣٥a.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this.f٧٥٣٨d);
            }
            this.f٧٥٣٨d = null;
            this.f٧٥٣٦b.clear();
        }

        void d(i iVar) {
            int g10 = g();
            int f10 = f();
            if (i(g10, f10)) {
                iVar.d(g10, f10);
                return;
            }
            if (!this.f٧٥٣٦b.contains(iVar)) {
                this.f٧٥٣٦b.add(iVar);
            }
            if (this.f٧٥٣٨d == null) {
                ViewTreeObserver viewTreeObserver = this.f٧٥٣٥a.getViewTreeObserver();
                ViewTreeObserverOnPreDrawListenerC٠١٠٧a r02 = new ViewTreeObserverOnPreDrawListenerC٠١٠٧a(this);
                this.f٧٥٣٨d = r02;
                viewTreeObserver.addOnPreDrawListener(r02);
            }
        }

        void k(i iVar) {
            this.f٧٥٣٦b.remove(iVar);
        }
    }

    public d(View view) {
        this.f٧٥٣٠b = (View) f5.k.d(view);
        this.f٧٥٢٩a = new a(view);
    }

    private Object a() {
        return this.f٧٥٣٠b.getTag(f٧٥٢٨f);
    }

    private void b() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.f٧٥٣١c;
        if (onAttachStateChangeListener != null && !this.f٧٥٣٣e) {
            this.f٧٥٣٠b.addOnAttachStateChangeListener(onAttachStateChangeListener);
            this.f٧٥٣٣e = true;
        }
    }

    private void c() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.f٧٥٣١c;
        if (onAttachStateChangeListener != null && this.f٧٥٣٣e) {
            this.f٧٥٣٠b.removeOnAttachStateChangeListener(onAttachStateChangeListener);
            this.f٧٥٣٣e = false;
        }
    }

    private void f(Object obj) {
        this.f٧٥٣٠b.setTag(f٧٥٢٨f, obj);
    }

    protected abstract void d(Drawable drawable);

    protected void e(Drawable drawable) {
    }

    @Override // com.bumptech.glide.request.target.j
    public final c5.d getRequest() {
        Object a10 = a();
        if (a10 != null) {
            if (a10 instanceof c5.d) {
                return (c5.d) a10;
            }
            throw new IllegalArgumentException("You must not pass non-R.id ids to setTag(id)");
        }
        return null;
    }

    @Override // com.bumptech.glide.request.target.j
    public final void getSize(i iVar) {
        this.f٧٥٢٩a.d(iVar);
    }

    @Override // z4.l
    public void onDestroy() {
    }

    @Override // com.bumptech.glide.request.target.j
    public final void onLoadCleared(Drawable drawable) {
        this.f٧٥٢٩a.b();
        d(drawable);
        if (!this.f٧٥٣٢d) {
            c();
        }
    }

    @Override // com.bumptech.glide.request.target.j
    public final void onLoadStarted(Drawable drawable) {
        b();
        e(drawable);
    }

    @Override // z4.l
    public void onStart() {
    }

    @Override // z4.l
    public void onStop() {
    }

    @Override // com.bumptech.glide.request.target.j
    public final void removeCallback(i iVar) {
        this.f٧٥٢٩a.k(iVar);
    }

    @Override // com.bumptech.glide.request.target.j
    public final void setRequest(c5.d dVar) {
        f(dVar);
    }

    public String toString() {
        return "Target for: " + this.f٧٥٣٠b;
    }
}
