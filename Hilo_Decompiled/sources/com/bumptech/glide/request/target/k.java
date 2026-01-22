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
public abstract class k extends com.bumptech.glide.request.target.a {
    private static final String TAG = "ViewTarget";
    private static boolean isTagUsedAtLeastOnce;
    private static int tagId = R.id.glide_custom_view_target_tag;
    private View.OnAttachStateChangeListener attachStateListener;
    private boolean isAttachStateListenerAdded;
    private boolean isClearedByUs;
    private final b sizeDeterminer;
    protected final View view;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class a implements View.OnAttachStateChangeListener {
        a() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            k.this.resumeMyRequest();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            k.this.pauseMyRequest();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    static final class b {

        /* renamed from: e, reason: collision with root package name */
        static Integer f٧٥٤٣e;

        /* renamed from: a, reason: collision with root package name */
        private final View f٧٥٤٤a;

        /* renamed from: b, reason: collision with root package name */
        private final List f٧٥٤٥b = new ArrayList();

        /* renamed from: c, reason: collision with root package name */
        boolean f٧٥٤٦c;

        /* renamed from: d, reason: collision with root package name */
        private a f٧٥٤٧d;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        public static final class a implements ViewTreeObserver.OnPreDrawListener {

            /* renamed from: a, reason: collision with root package name */
            private final WeakReference f٧٥٤٨a;

            a(b bVar) {
                this.f٧٥٤٨a = new WeakReference(bVar);
            }

            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                if (Log.isLoggable(k.TAG, 2)) {
                    Log.v(k.TAG, "OnGlobalLayoutListener called attachStateListener=" + this);
                }
                b bVar = (b) this.f٧٥٤٨a.get();
                if (bVar != null) {
                    bVar.a();
                    return true;
                }
                return true;
            }
        }

        b(View view) {
            this.f٧٥٤٤a = view;
        }

        private static int c(Context context) {
            if (f٧٥٤٣e == null) {
                Display defaultDisplay = ((WindowManager) f5.k.d((WindowManager) context.getSystemService("window"))).getDefaultDisplay();
                Point point = new Point();
                defaultDisplay.getSize(point);
                f٧٥٤٣e = Integer.valueOf(Math.max(point.x, point.y));
            }
            return f٧٥٤٣e.intValue();
        }

        private int e(int i10, int i11, int i12) {
            int i13 = i11 - i12;
            if (i13 > 0) {
                return i13;
            }
            if (this.f٧٥٤٦c && this.f٧٥٤٤a.isLayoutRequested()) {
                return 0;
            }
            int i14 = i10 - i12;
            if (i14 > 0) {
                return i14;
            }
            if (this.f٧٥٤٤a.isLayoutRequested() || i11 != -2) {
                return 0;
            }
            if (Log.isLoggable(k.TAG, 4)) {
                Log.i(k.TAG, "Glide treats LayoutParams.WRAP_CONTENT as a request for an image the size of this device's screen dimensions. If you want to load the original image and are ok with the corresponding memory cost and OOMs (depending on the input size), use override(Target.SIZE_ORIGINAL). Otherwise, use LayoutParams.MATCH_PARENT, set layout_width and layout_height to fixed dimension, or use .override() with fixed dimensions.");
            }
            return c(this.f٧٥٤٤a.getContext());
        }

        private int f() {
            int i10;
            int paddingTop = this.f٧٥٤٤a.getPaddingTop() + this.f٧٥٤٤a.getPaddingBottom();
            ViewGroup.LayoutParams layoutParams = this.f٧٥٤٤a.getLayoutParams();
            if (layoutParams != null) {
                i10 = layoutParams.height;
            } else {
                i10 = 0;
            }
            return e(this.f٧٥٤٤a.getHeight(), i10, paddingTop);
        }

        private int g() {
            int i10;
            int paddingLeft = this.f٧٥٤٤a.getPaddingLeft() + this.f٧٥٤٤a.getPaddingRight();
            ViewGroup.LayoutParams layoutParams = this.f٧٥٤٤a.getLayoutParams();
            if (layoutParams != null) {
                i10 = layoutParams.width;
            } else {
                i10 = 0;
            }
            return e(this.f٧٥٤٤a.getWidth(), i10, paddingLeft);
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
            Iterator it = new ArrayList(this.f٧٥٤٥b).iterator();
            while (it.hasNext()) {
                ((i) it.next()).d(i10, i11);
            }
        }

        void a() {
            if (this.f٧٥٤٥b.isEmpty()) {
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
            ViewTreeObserver viewTreeObserver = this.f٧٥٤٤a.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this.f٧٥٤٧d);
            }
            this.f٧٥٤٧d = null;
            this.f٧٥٤٥b.clear();
        }

        void d(i iVar) {
            int g10 = g();
            int f10 = f();
            if (i(g10, f10)) {
                iVar.d(g10, f10);
                return;
            }
            if (!this.f٧٥٤٥b.contains(iVar)) {
                this.f٧٥٤٥b.add(iVar);
            }
            if (this.f٧٥٤٧d == null) {
                ViewTreeObserver viewTreeObserver = this.f٧٥٤٤a.getViewTreeObserver();
                a aVar = new a(this);
                this.f٧٥٤٧d = aVar;
                viewTreeObserver.addOnPreDrawListener(aVar);
            }
        }

        void k(i iVar) {
            this.f٧٥٤٥b.remove(iVar);
        }
    }

    public k(View view) {
        this.view = (View) f5.k.d(view);
        this.sizeDeterminer = new b(view);
    }

    private Object a() {
        return this.view.getTag(tagId);
    }

    private void b() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.attachStateListener;
        if (onAttachStateChangeListener != null && !this.isAttachStateListenerAdded) {
            this.view.addOnAttachStateChangeListener(onAttachStateChangeListener);
            this.isAttachStateListenerAdded = true;
        }
    }

    private void c() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.attachStateListener;
        if (onAttachStateChangeListener != null && this.isAttachStateListenerAdded) {
            this.view.removeOnAttachStateChangeListener(onAttachStateChangeListener);
            this.isAttachStateListenerAdded = false;
        }
    }

    private void d(Object obj) {
        isTagUsedAtLeastOnce = true;
        this.view.setTag(tagId, obj);
    }

    @Deprecated
    public static void setTagId(int i10) {
        if (!isTagUsedAtLeastOnce) {
            tagId = i10;
            return;
        }
        throw new IllegalArgumentException("You cannot set the tag id more than once or change the tag id after the first request has been made");
    }

    public final k clearOnDetach() {
        if (this.attachStateListener != null) {
            return this;
        }
        this.attachStateListener = new a();
        b();
        return this;
    }

    @Override // com.bumptech.glide.request.target.j
    public c5.d getRequest() {
        Object a10 = a();
        if (a10 != null) {
            if (a10 instanceof c5.d) {
                return (c5.d) a10;
            }
            throw new IllegalArgumentException("You must not call setTag() on a view Glide is targeting");
        }
        return null;
    }

    @Override // com.bumptech.glide.request.target.j
    public void getSize(i iVar) {
        this.sizeDeterminer.d(iVar);
    }

    public View getView() {
        return this.view;
    }

    @Override // com.bumptech.glide.request.target.a, com.bumptech.glide.request.target.j
    public void onLoadCleared(Drawable drawable) {
        super.onLoadCleared(drawable);
        this.sizeDeterminer.b();
        if (!this.isClearedByUs) {
            c();
        }
    }

    @Override // com.bumptech.glide.request.target.a, com.bumptech.glide.request.target.j
    public void onLoadStarted(Drawable drawable) {
        super.onLoadStarted(drawable);
        b();
    }

    void pauseMyRequest() {
        c5.d request = getRequest();
        if (request != null) {
            this.isClearedByUs = true;
            request.clear();
            this.isClearedByUs = false;
        }
    }

    @Override // com.bumptech.glide.request.target.j
    public void removeCallback(i iVar) {
        this.sizeDeterminer.k(iVar);
    }

    void resumeMyRequest() {
        c5.d request = getRequest();
        if (request != null && request.e()) {
            request.j();
        }
    }

    @Override // com.bumptech.glide.request.target.j
    public void setRequest(c5.d dVar) {
        d(dVar);
    }

    public String toString() {
        return "Target for: " + this.view;
    }

    public final k waitForLayout() {
        this.sizeDeterminer.f٧٥٤٦c = true;
        return this;
    }
}
