package androidx.core.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.ContentInfo;
import android.view.Display;
import android.view.KeyEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import androidx.core.R;
import androidx.core.view.a;
import androidx.core.view.d2;
import androidx.core.view.q1;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import m2.g0;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class d1 {

    /* renamed from: a, reason: collision with root package name */
    private static WeakHashMap f٢٩١٥a;

    /* renamed from: b, reason: collision with root package name */
    private static Method f٢٩١٦b;

    /* renamed from: c, reason: collision with root package name */
    private static Field f٢٩١٧c;

    /* renamed from: d, reason: collision with root package name */
    private static boolean f٢٩١٨d;

    /* renamed from: e, reason: collision with root package name */
    private static ThreadLocal f٢٩١٩e;

    /* renamed from: f, reason: collision with root package name */
    private static final int[] f٢٩٢٠f = {R.id.accessibility_custom_action_0, R.id.accessibility_custom_action_1, R.id.accessibility_custom_action_2, R.id.accessibility_custom_action_3, R.id.accessibility_custom_action_4, R.id.accessibility_custom_action_5, R.id.accessibility_custom_action_6, R.id.accessibility_custom_action_7, R.id.accessibility_custom_action_8, R.id.accessibility_custom_action_9, R.id.accessibility_custom_action_10, R.id.accessibility_custom_action_11, R.id.accessibility_custom_action_12, R.id.accessibility_custom_action_13, R.id.accessibility_custom_action_14, R.id.accessibility_custom_action_15, R.id.accessibility_custom_action_16, R.id.accessibility_custom_action_17, R.id.accessibility_custom_action_18, R.id.accessibility_custom_action_19, R.id.accessibility_custom_action_20, R.id.accessibility_custom_action_21, R.id.accessibility_custom_action_22, R.id.accessibility_custom_action_23, R.id.accessibility_custom_action_24, R.id.accessibility_custom_action_25, R.id.accessibility_custom_action_26, R.id.accessibility_custom_action_27, R.id.accessibility_custom_action_28, R.id.accessibility_custom_action_29, R.id.accessibility_custom_action_30, R.id.accessibility_custom_action_31};

    /* renamed from: g, reason: collision with root package name */
    private static final l0 f٢٩٢١g = new l0() { // from class: androidx.core.view.c1
        @Override // androidx.core.view.l0
        public final d onReceiveContent(d dVar) {
            d Y;
            Y = d1.Y(dVar);
            return Y;
        }
    };

    /* renamed from: h, reason: collision with root package name */
    private static final e f٢٩٢٢h = new e();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class a extends f {
        a(int i10, Class cls, int i11) {
            super(i10, cls, i11);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.core.view.d1.f
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public Boolean c(View view) {
            return Boolean.valueOf(l.c(view));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.core.view.d1.f
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public void d(View view, Boolean bool) {
            l.f(view, bool.booleanValue());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.core.view.d1.f
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public boolean g(Boolean bool, Boolean bool2) {
            return !a(bool, bool2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class b extends f {
        b(int i10, Class cls, int i11, int i12) {
            super(i10, cls, i11, i12);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.core.view.d1.f
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public CharSequence c(View view) {
            return l.a(view);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.core.view.d1.f
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public void d(View view, CharSequence charSequence) {
            l.e(view, charSequence);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.core.view.d1.f
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public boolean g(CharSequence charSequence, CharSequence charSequence2) {
            return !TextUtils.equals(charSequence, charSequence2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class c extends f {
        c(int i10, Class cls, int i11, int i12) {
            super(i10, cls, i11, i12);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.core.view.d1.f
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public CharSequence c(View view) {
            return n.a(view);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.core.view.d1.f
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public void d(View view, CharSequence charSequence) {
            n.c(view, charSequence);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.core.view.d1.f
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public boolean g(CharSequence charSequence, CharSequence charSequence2) {
            return !TextUtils.equals(charSequence, charSequence2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class d extends f {
        d(int i10, Class cls, int i11) {
            super(i10, cls, i11);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.core.view.d1.f
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public Boolean c(View view) {
            return Boolean.valueOf(l.b(view));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.core.view.d1.f
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public void d(View view, Boolean bool) {
            l.d(view, bool.booleanValue());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.core.view.d1.f
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public boolean g(Boolean bool, Boolean bool2) {
            return !a(bool, bool2);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    static class e implements ViewTreeObserver.OnGlobalLayoutListener, View.OnAttachStateChangeListener {

        /* renamed from: a, reason: collision with root package name */
        private final WeakHashMap f٢٩٢٣a = new WeakHashMap();

        e() {
        }

        private void b(Map.Entry entry) {
            boolean z10;
            int i10;
            View view = (View) entry.getKey();
            boolean booleanValue = ((Boolean) entry.getValue()).booleanValue();
            if (view.isShown() && view.getWindowVisibility() == 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (booleanValue != z10) {
                if (z10) {
                    i10 = 16;
                } else {
                    i10 = 32;
                }
                d1.Z(view, i10);
                entry.setValue(Boolean.valueOf(z10));
            }
        }

        private void c(View view) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(this);
        }

        private void e(View view) {
            view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }

        void a(View view) {
            boolean z10;
            WeakHashMap weakHashMap = this.f٢٩٢٣a;
            if (view.isShown() && view.getWindowVisibility() == 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            weakHashMap.put(view, Boolean.valueOf(z10));
            view.addOnAttachStateChangeListener(this);
            if (view.isAttachedToWindow()) {
                c(view);
            }
        }

        void d(View view) {
            this.f٢٩٢٣a.remove(view);
            view.removeOnAttachStateChangeListener(this);
            e(view);
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (Build.VERSION.SDK_INT < 28) {
                Iterator it = this.f٢٩٢٣a.entrySet().iterator();
                while (it.hasNext()) {
                    b((Map.Entry) it.next());
                }
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            c(view);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static abstract class f {

        /* renamed from: a, reason: collision with root package name */
        private final int f٢٩٢٤a;

        /* renamed from: b, reason: collision with root package name */
        private final Class f٢٩٢٥b;

        /* renamed from: c, reason: collision with root package name */
        private final int f٢٩٢٦c;

        /* renamed from: d, reason: collision with root package name */
        private final int f٢٩٢٧d;

        f(int i10, Class cls, int i11) {
            this(i10, cls, 0, i11);
        }

        private boolean b() {
            if (Build.VERSION.SDK_INT >= this.f٢٩٢٦c) {
                return true;
            }
            return false;
        }

        boolean a(Boolean bool, Boolean bool2) {
            boolean z10;
            boolean z11;
            if (bool != null && bool.booleanValue()) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (bool2 != null && bool2.booleanValue()) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z10 != z11) {
                return false;
            }
            return true;
        }

        abstract Object c(View view);

        abstract void d(View view, Object obj);

        Object e(View view) {
            if (b()) {
                return c(view);
            }
            Object tag = view.getTag(this.f٢٩٢٤a);
            if (this.f٢٩٢٥b.isInstance(tag)) {
                return tag;
            }
            return null;
        }

        void f(View view, Object obj) {
            if (b()) {
                d(view, obj);
            } else if (g(e(view), obj)) {
                d1.m(view);
                view.setTag(this.f٢٩٢٤a, obj);
                d1.Z(view, this.f٢٩٢٧d);
            }
        }

        abstract boolean g(Object obj, Object obj2);

        f(int i10, Class cls, int i11, int i12) {
            this.f٢٩٢٤a = i10;
            this.f٢٩٢٥b = cls;
            this.f٢٩٢٧d = i11;
            this.f٢٩٢٦c = i12;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class g {
        static WindowInsets a(View view, WindowInsets windowInsets) {
            return view.dispatchApplyWindowInsets(windowInsets);
        }

        static WindowInsets b(View view, WindowInsets windowInsets) {
            return view.onApplyWindowInsets(windowInsets);
        }

        static void c(View view) {
            view.requestApplyInsets();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    private static class h {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
        public class a implements View.OnApplyWindowInsetsListener {

            /* renamed from: a, reason: collision with root package name */
            d2 f٢٩٢٨a = null;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ View f٢٩٢٩b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ j0 f٢٩٣٠c;

            a(View view, j0 j0Var) {
                this.f٢٩٢٩b = view;
                this.f٢٩٣٠c = j0Var;
            }

            @Override // android.view.View.OnApplyWindowInsetsListener
            public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                d2 y10 = d2.y(windowInsets, view);
                int i10 = Build.VERSION.SDK_INT;
                if (i10 < 30) {
                    h.a(windowInsets, this.f٢٩٢٩b);
                    if (y10.equals(this.f٢٩٢٨a)) {
                        return this.f٢٩٣٠c.onApplyWindowInsets(view, y10).w();
                    }
                }
                this.f٢٩٢٨a = y10;
                d2 onApplyWindowInsets = this.f٢٩٣٠c.onApplyWindowInsets(view, y10);
                if (i10 >= 30) {
                    return onApplyWindowInsets.w();
                }
                d1.n0(view);
                return onApplyWindowInsets.w();
            }
        }

        static void a(WindowInsets windowInsets, View view) {
            View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = (View.OnApplyWindowInsetsListener) view.getTag(R.id.tag_window_insets_animation_callback);
            if (onApplyWindowInsetsListener != null) {
                onApplyWindowInsetsListener.onApplyWindowInsets(view, windowInsets);
            }
        }

        static d2 b(View view, d2 d2Var, Rect rect) {
            WindowInsets w10 = d2Var.w();
            if (w10 != null) {
                return d2.y(view.computeSystemWindowInsets(w10, rect), view);
            }
            rect.setEmpty();
            return d2Var;
        }

        static ColorStateList c(View view) {
            return view.getBackgroundTintList();
        }

        static PorterDuff.Mode d(View view) {
            return view.getBackgroundTintMode();
        }

        static float e(View view) {
            return view.getElevation();
        }

        public static d2 f(View view) {
            return d2.a.a(view);
        }

        static String g(View view) {
            return view.getTransitionName();
        }

        static float h(View view) {
            return view.getTranslationZ();
        }

        static float i(View view) {
            return view.getZ();
        }

        static boolean j(View view) {
            return view.isNestedScrollingEnabled();
        }

        static void k(View view, ColorStateList colorStateList) {
            view.setBackgroundTintList(colorStateList);
        }

        static void l(View view, PorterDuff.Mode mode) {
            view.setBackgroundTintMode(mode);
        }

        static void m(View view, float f10) {
            view.setElevation(f10);
        }

        static void n(View view, boolean z10) {
            view.setNestedScrollingEnabled(z10);
        }

        static void o(View view, j0 j0Var) {
            if (Build.VERSION.SDK_INT < 30) {
                view.setTag(R.id.tag_on_apply_window_listener, j0Var);
            }
            if (j0Var == null) {
                view.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) view.getTag(R.id.tag_window_insets_animation_callback));
            } else {
                view.setOnApplyWindowInsetsListener(new a(view, j0Var));
            }
        }

        static void p(View view, String str) {
            view.setTransitionName(str);
        }

        static void q(View view, float f10) {
            view.setTranslationZ(f10);
        }

        static void r(View view, float f10) {
            view.setZ(f10);
        }

        static void s(View view) {
            view.stopNestedScroll();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    private static class i {
        public static d2 a(View view) {
            WindowInsets rootWindowInsets = view.getRootWindowInsets();
            if (rootWindowInsets == null) {
                return null;
            }
            d2 x10 = d2.x(rootWindowInsets);
            x10.u(x10);
            x10.d(view.getRootView());
            return x10;
        }

        static void b(View view, int i10, int i11) {
            view.setScrollIndicators(i10, i11);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    static class j {
        static void a(View view, PointerIcon pointerIcon) {
            view.setPointerIcon(pointerIcon);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    static class k {
        static int a(View view) {
            return view.getImportantForAutofill();
        }

        static void b(View view, int i10) {
            view.setImportantForAutofill(i10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class l {
        static CharSequence a(View view) {
            return view.getAccessibilityPaneTitle();
        }

        static boolean b(View view) {
            return view.isAccessibilityHeading();
        }

        static boolean c(View view) {
            return view.isScreenReaderFocusable();
        }

        static void d(View view, boolean z10) {
            view.setAccessibilityHeading(z10);
        }

        static void e(View view, CharSequence charSequence) {
            view.setAccessibilityPaneTitle(charSequence);
        }

        static void f(View view, boolean z10) {
            view.setScreenReaderFocusable(z10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class m {
        static View.AccessibilityDelegate a(View view) {
            return view.getAccessibilityDelegate();
        }

        static void b(View view, Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i10, int i11) {
            view.saveAttributeDataForStyleable(context, iArr, attributeSet, typedArray, i10, i11);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class n {
        static CharSequence a(View view) {
            return view.getStateDescription();
        }

        public static d3 b(View view) {
            WindowInsetsController windowInsetsController = view.getWindowInsetsController();
            if (windowInsetsController != null) {
                return d3.g(windowInsetsController);
            }
            return null;
        }

        static void c(View view, CharSequence charSequence) {
            view.setStateDescription(charSequence);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    private static final class o {
        public static String[] a(View view) {
            return view.getReceiveContentMimeTypes();
        }

        public static androidx.core.view.d b(View view, androidx.core.view.d dVar) {
            ContentInfo f10 = dVar.f();
            ContentInfo performReceiveContent = view.performReceiveContent(f10);
            if (performReceiveContent == null) {
                return null;
            }
            if (performReceiveContent == f10) {
                return dVar;
            }
            return androidx.core.view.d.g(performReceiveContent);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    static class p {

        /* renamed from: d, reason: collision with root package name */
        private static final ArrayList f٢٩٣١d = new ArrayList();

        /* renamed from: a, reason: collision with root package name */
        private WeakHashMap f٢٩٣٢a = null;

        /* renamed from: b, reason: collision with root package name */
        private SparseArray f٢٩٣٣b = null;

        /* renamed from: c, reason: collision with root package name */
        private WeakReference f٢٩٣٤c = null;

        p() {
        }

        static p a(View view) {
            int i10 = R.id.tag_unhandled_key_event_manager;
            p pVar = (p) view.getTag(i10);
            if (pVar == null) {
                p pVar2 = new p();
                view.setTag(i10, pVar2);
                return pVar2;
            }
            return pVar;
        }

        private View c(View view, KeyEvent keyEvent) {
            WeakHashMap weakHashMap = this.f٢٩٣٢a;
            if (weakHashMap != null && weakHashMap.containsKey(view)) {
                if (view instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                        View c10 = c(viewGroup.getChildAt(childCount), keyEvent);
                        if (c10 != null) {
                            return c10;
                        }
                    }
                }
                if (e(view, keyEvent)) {
                    return view;
                }
            }
            return null;
        }

        private SparseArray d() {
            if (this.f٢٩٣٣b == null) {
                this.f٢٩٣٣b = new SparseArray();
            }
            return this.f٢٩٣٣b;
        }

        private boolean e(View view, KeyEvent keyEvent) {
            int size;
            ArrayList arrayList = (ArrayList) view.getTag(R.id.tag_unhandled_key_listeners);
            if (arrayList != null && arrayList.size() - 1 >= 0) {
                androidx.appcompat.app.a0.a(arrayList.get(size));
                throw null;
            }
            return false;
        }

        private void g() {
            WeakHashMap weakHashMap = this.f٢٩٣٢a;
            if (weakHashMap != null) {
                weakHashMap.clear();
            }
            ArrayList arrayList = f٢٩٣١d;
            if (arrayList.isEmpty()) {
                return;
            }
            synchronized (arrayList) {
                try {
                    if (this.f٢٩٣٢a == null) {
                        this.f٢٩٣٢a = new WeakHashMap();
                    }
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        ArrayList arrayList2 = f٢٩٣١d;
                        View view = (View) ((WeakReference) arrayList2.get(size)).get();
                        if (view == null) {
                            arrayList2.remove(size);
                        } else {
                            this.f٢٩٣٢a.put(view, Boolean.TRUE);
                            for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
                                this.f٢٩٣٢a.put((View) parent, Boolean.TRUE);
                            }
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        boolean b(View view, KeyEvent keyEvent) {
            if (keyEvent.getAction() == 0) {
                g();
            }
            View c10 = c(view, keyEvent);
            if (keyEvent.getAction() == 0) {
                int keyCode = keyEvent.getKeyCode();
                if (c10 != null && !KeyEvent.isModifierKey(keyCode)) {
                    d().put(keyCode, new WeakReference(c10));
                }
            }
            if (c10 != null) {
                return true;
            }
            return false;
        }

        boolean f(KeyEvent keyEvent) {
            WeakReference weakReference;
            int indexOfKey;
            WeakReference weakReference2 = this.f٢٩٣٤c;
            if (weakReference2 != null && weakReference2.get() == keyEvent) {
                return false;
            }
            this.f٢٩٣٤c = new WeakReference(keyEvent);
            SparseArray d10 = d();
            if (keyEvent.getAction() == 1 && (indexOfKey = d10.indexOfKey(keyEvent.getKeyCode())) >= 0) {
                weakReference = (WeakReference) d10.valueAt(indexOfKey);
                d10.removeAt(indexOfKey);
            } else {
                weakReference = null;
            }
            if (weakReference == null) {
                weakReference = (WeakReference) d10.get(keyEvent.getKeyCode());
            }
            if (weakReference == null) {
                return false;
            }
            View view = (View) weakReference.get();
            if (view != null && view.isAttachedToWindow()) {
                e(view, keyEvent);
            }
            return true;
        }
    }

    public static boolean A(View view) {
        return view.getFitsSystemWindows();
    }

    private static void A0(View view) {
        if (view.getImportantForAccessibility() == 0) {
            view.setImportantForAccessibility(1);
        }
    }

    public static int B(View view) {
        return view.getImportantForAccessibility();
    }

    public static void B0(View view, int i10) {
        if (Build.VERSION.SDK_INT >= 26) {
            k.b(view, i10);
        }
    }

    public static int C(View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            return k.a(view);
        }
        return 0;
    }

    public static void C0(View view, Paint paint) {
        view.setLayerPaint(paint);
    }

    public static int D(View view) {
        return view.getLayoutDirection();
    }

    public static void D0(View view, boolean z10) {
        h.n(view, z10);
    }

    public static int E(View view) {
        return view.getMinimumHeight();
    }

    public static void E0(View view, j0 j0Var) {
        h.o(view, j0Var);
    }

    public static int F(View view) {
        return view.getMinimumWidth();
    }

    public static void F0(View view, n0 n0Var) {
        Object obj;
        if (Build.VERSION.SDK_INT >= 24) {
            if (n0Var != null) {
                obj = n0Var.a();
            } else {
                obj = null;
            }
            j.a(view, b1.a(obj));
        }
    }

    public static String[] G(View view) {
        if (Build.VERSION.SDK_INT >= 31) {
            return o.a(view);
        }
        return (String[]) view.getTag(R.id.tag_on_receive_content_mime_types);
    }

    public static void G0(View view, boolean z10) {
        p0().f(view, Boolean.valueOf(z10));
    }

    public static int H(View view) {
        return view.getPaddingEnd();
    }

    public static void H0(View view, int i10, int i11) {
        if (Build.VERSION.SDK_INT >= 23) {
            i.b(view, i10, i11);
        }
    }

    public static int I(View view) {
        return view.getPaddingStart();
    }

    public static void I0(View view, CharSequence charSequence) {
        N0().f(view, charSequence);
    }

    public static ViewParent J(View view) {
        return view.getParentForAccessibility();
    }

    public static void J0(View view, String str) {
        h.p(view, str);
    }

    public static d2 K(View view) {
        if (Build.VERSION.SDK_INT >= 23) {
            return i.a(view);
        }
        return h.f(view);
    }

    public static void K0(View view, float f10) {
        h.q(view, f10);
    }

    public static CharSequence L(View view) {
        return (CharSequence) N0().e(view);
    }

    public static void L0(View view, q1.b bVar) {
        q1.d(view, bVar);
    }

    public static String M(View view) {
        return h.g(view);
    }

    public static void M0(View view, float f10) {
        h.r(view, f10);
    }

    public static float N(View view) {
        return h.h(view);
    }

    private static f N0() {
        return new c(R.id.tag_state_description, CharSequence.class, 64, 30);
    }

    public static d3 O(View view) {
        if (Build.VERSION.SDK_INT >= 30) {
            return n.b(view);
        }
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                Window window = ((Activity) context).getWindow();
                if (window == null) {
                    return null;
                }
                return p1.a(window, view);
            }
        }
        return null;
    }

    public static void O0(View view) {
        h.s(view);
    }

    public static int P(View view) {
        return view.getWindowSystemUiVisibility();
    }

    private static void P0(View view) {
        float translationY = view.getTranslationY();
        view.setTranslationY(1.0f + translationY);
        view.setTranslationY(translationY);
    }

    public static float Q(View view) {
        return h.i(view);
    }

    public static boolean R(View view) {
        if (p(view) != null) {
            return true;
        }
        return false;
    }

    public static boolean S(View view) {
        return view.hasTransientState();
    }

    public static boolean T(View view) {
        Boolean bool = (Boolean) b().e(view);
        if (bool != null && bool.booleanValue()) {
            return true;
        }
        return false;
    }

    public static boolean U(View view) {
        return view.isAttachedToWindow();
    }

    public static boolean V(View view) {
        return view.isLaidOut();
    }

    public static boolean W(View view) {
        return h.j(view);
    }

    public static boolean X(View view) {
        Boolean bool = (Boolean) p0().e(view);
        if (bool != null && bool.booleanValue()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ androidx.core.view.d Y(androidx.core.view.d dVar) {
        return dVar;
    }

    static void Z(View view, int i10) {
        boolean z10;
        AccessibilityManager accessibilityManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        if (!accessibilityManager.isEnabled()) {
            return;
        }
        if (r(view) != null && view.isShown() && view.getWindowVisibility() == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        int i11 = 32;
        if (view.getAccessibilityLiveRegion() == 0 && !z10) {
            if (i10 == 32) {
                AccessibilityEvent obtain = AccessibilityEvent.obtain();
                view.onInitializeAccessibilityEvent(obtain);
                obtain.setEventType(32);
                obtain.setContentChangeTypes(i10);
                obtain.setSource(view);
                view.onPopulateAccessibilityEvent(obtain);
                obtain.getText().add(r(view));
                accessibilityManager.sendAccessibilityEvent(obtain);
                return;
            }
            if (view.getParent() != null) {
                try {
                    view.getParent().notifySubtreeAccessibilityStateChanged(view, view, i10);
                    return;
                } catch (AbstractMethodError e10) {
                    Log.e("ViewCompat", view.getParent().getClass().getSimpleName() + " does not fully implement ViewParent", e10);
                    return;
                }
            }
            return;
        }
        AccessibilityEvent obtain2 = AccessibilityEvent.obtain();
        if (!z10) {
            i11 = 2048;
        }
        obtain2.setEventType(i11);
        obtain2.setContentChangeTypes(i10);
        if (z10) {
            obtain2.getText().add(r(view));
            A0(view);
        }
        view.sendAccessibilityEventUnchecked(obtain2);
    }

    public static void a0(View view, int i10) {
        boolean z10;
        if (Build.VERSION.SDK_INT >= 23) {
            view.offsetLeftAndRight(i10);
            return;
        }
        Rect y10 = y();
        Object parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            y10.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
            z10 = !y10.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        } else {
            z10 = false;
        }
        g(view, i10);
        if (z10 && y10.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
            ((View) parent).invalidate(y10);
        }
    }

    private static f b() {
        return new d(R.id.tag_accessibility_heading, Boolean.class, 28);
    }

    public static void b0(View view, int i10) {
        boolean z10;
        if (Build.VERSION.SDK_INT >= 23) {
            view.offsetTopAndBottom(i10);
            return;
        }
        Rect y10 = y();
        Object parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            y10.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
            z10 = !y10.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        } else {
            z10 = false;
        }
        h(view, i10);
        if (z10 && y10.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
            ((View) parent).invalidate(y10);
        }
    }

    public static int c(View view, CharSequence charSequence, m2.j0 j0Var) {
        int t10 = t(view, charSequence);
        if (t10 != -1) {
            d(view, new g0.a(t10, charSequence, j0Var));
        }
        return t10;
    }

    public static d2 c0(View view, d2 d2Var) {
        WindowInsets w10 = d2Var.w();
        if (w10 != null) {
            WindowInsets b10 = g.b(view, w10);
            if (!b10.equals(w10)) {
                return d2.y(b10, view);
            }
        }
        return d2Var;
    }

    private static void d(View view, g0.a aVar) {
        m(view);
        l0(aVar.b(), view);
        s(view).add(aVar);
        Z(view, 0);
    }

    public static void d0(View view, m2.g0 g0Var) {
        view.onInitializeAccessibilityNodeInfo(g0Var.U0());
    }

    public static l1 e(View view) {
        if (f٢٩١٥a == null) {
            f٢٩١٥a = new WeakHashMap();
        }
        l1 l1Var = (l1) f٢٩١٥a.get(view);
        if (l1Var == null) {
            l1 l1Var2 = new l1(view);
            f٢٩١٥a.put(view, l1Var2);
            return l1Var2;
        }
        return l1Var;
    }

    private static f e0() {
        return new b(R.id.tag_accessibility_pane_title, CharSequence.class, 8, 28);
    }

    public static boolean f(View view, int i10) {
        return view.canScrollVertically(i10);
    }

    public static boolean f0(View view, int i10, Bundle bundle) {
        return view.performAccessibilityAction(i10, bundle);
    }

    private static void g(View view, int i10) {
        view.offsetLeftAndRight(i10);
        if (view.getVisibility() == 0) {
            P0(view);
            Object parent = view.getParent();
            if (parent instanceof View) {
                P0((View) parent);
            }
        }
    }

    public static androidx.core.view.d g0(View view, androidx.core.view.d dVar) {
        if (Log.isLoggable("ViewCompat", 3)) {
            Log.d("ViewCompat", "performReceiveContent: " + dVar + ", view=" + view.getClass().getSimpleName() + "[" + view.getId() + "]");
        }
        if (Build.VERSION.SDK_INT >= 31) {
            return o.b(view, dVar);
        }
        k0 k0Var = (k0) view.getTag(R.id.tag_on_receive_content_listener);
        if (k0Var != null) {
            androidx.core.view.d a10 = k0Var.a(view, dVar);
            if (a10 == null) {
                return null;
            }
            return z(view).onReceiveContent(a10);
        }
        return z(view).onReceiveContent(dVar);
    }

    private static void h(View view, int i10) {
        view.offsetTopAndBottom(i10);
        if (view.getVisibility() == 0) {
            P0(view);
            Object parent = view.getParent();
            if (parent instanceof View) {
                P0((View) parent);
            }
        }
    }

    public static void h0(View view) {
        view.postInvalidateOnAnimation();
    }

    public static d2 i(View view, d2 d2Var, Rect rect) {
        return h.b(view, d2Var, rect);
    }

    public static void i0(View view, Runnable runnable) {
        view.postOnAnimation(runnable);
    }

    public static d2 j(View view, d2 d2Var) {
        WindowInsets w10 = d2Var.w();
        if (w10 != null) {
            WindowInsets a10 = g.a(view, w10);
            if (!a10.equals(w10)) {
                return d2.y(a10, view);
            }
        }
        return d2Var;
    }

    public static void j0(View view, Runnable runnable, long j10) {
        view.postOnAnimationDelayed(runnable, j10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean k(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return p.a(view).b(view, keyEvent);
    }

    public static void k0(View view, int i10) {
        l0(i10, view);
        Z(view, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean l(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return p.a(view).f(keyEvent);
    }

    private static void l0(int i10, View view) {
        List s10 = s(view);
        for (int i11 = 0; i11 < s10.size(); i11++) {
            if (((g0.a) s10.get(i11)).b() == i10) {
                s10.remove(i11);
                return;
            }
        }
    }

    static void m(View view) {
        androidx.core.view.a o10 = o(view);
        if (o10 == null) {
            o10 = new androidx.core.view.a();
        }
        q0(view, o10);
    }

    public static void m0(View view, g0.a aVar, CharSequence charSequence, m2.j0 j0Var) {
        if (j0Var == null && charSequence == null) {
            k0(view, aVar.b());
        } else {
            d(view, aVar.a(charSequence, j0Var));
        }
    }

    public static int n() {
        return View.generateViewId();
    }

    public static void n0(View view) {
        g.c(view);
    }

    public static androidx.core.view.a o(View view) {
        View.AccessibilityDelegate p10 = p(view);
        if (p10 == null) {
            return null;
        }
        if (p10 instanceof a.C٠٠٢٦a) {
            return ((a.C٠٠٢٦a) p10).f٢٨٩٢a;
        }
        return new androidx.core.view.a(p10);
    }

    public static void o0(View view, Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i10, int i11) {
        if (Build.VERSION.SDK_INT >= 29) {
            m.b(view, context, iArr, attributeSet, typedArray, i10, i11);
        }
    }

    private static View.AccessibilityDelegate p(View view) {
        if (Build.VERSION.SDK_INT >= 29) {
            return m.a(view);
        }
        return q(view);
    }

    private static f p0() {
        return new a(R.id.tag_screen_reader_focusable, Boolean.class, 28);
    }

    private static View.AccessibilityDelegate q(View view) {
        if (f٢٩١٨d) {
            return null;
        }
        if (f٢٩١٧c == null) {
            try {
                Field declaredField = View.class.getDeclaredField("mAccessibilityDelegate");
                f٢٩١٧c = declaredField;
                declaredField.setAccessible(true);
            } catch (Throwable unused) {
                f٢٩١٨d = true;
                return null;
            }
        }
        try {
            Object obj = f٢٩١٧c.get(view);
            if (!(obj instanceof View.AccessibilityDelegate)) {
                return null;
            }
            return (View.AccessibilityDelegate) obj;
        } catch (Throwable unused2) {
            f٢٩١٨d = true;
            return null;
        }
    }

    public static void q0(View view, androidx.core.view.a aVar) {
        View.AccessibilityDelegate bridge;
        if (aVar == null && (p(view) instanceof a.C٠٠٢٦a)) {
            aVar = new androidx.core.view.a();
        }
        A0(view);
        if (aVar == null) {
            bridge = null;
        } else {
            bridge = aVar.getBridge();
        }
        view.setAccessibilityDelegate(bridge);
    }

    public static CharSequence r(View view) {
        return (CharSequence) e0().e(view);
    }

    public static void r0(View view, boolean z10) {
        b().f(view, Boolean.valueOf(z10));
    }

    private static List s(View view) {
        int i10 = R.id.tag_accessibility_actions;
        ArrayList arrayList = (ArrayList) view.getTag(i10);
        if (arrayList == null) {
            ArrayList arrayList2 = new ArrayList();
            view.setTag(i10, arrayList2);
            return arrayList2;
        }
        return arrayList;
    }

    public static void s0(View view, CharSequence charSequence) {
        e0().f(view, charSequence);
        if (charSequence != null) {
            f٢٩٢٢h.a(view);
        } else {
            f٢٩٢٢h.d(view);
        }
    }

    private static int t(View view, CharSequence charSequence) {
        boolean z10;
        List s10 = s(view);
        for (int i10 = 0; i10 < s10.size(); i10++) {
            if (TextUtils.equals(charSequence, ((g0.a) s10.get(i10)).c())) {
                return ((g0.a) s10.get(i10)).b();
            }
        }
        int i11 = 0;
        int i12 = -1;
        while (true) {
            int[] iArr = f٢٩٢٠f;
            if (i11 >= iArr.length || i12 != -1) {
                break;
            }
            int i13 = iArr[i11];
            boolean z11 = true;
            for (int i14 = 0; i14 < s10.size(); i14++) {
                if (((g0.a) s10.get(i14)).b() != i13) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                z11 &= z10;
            }
            if (z11) {
                i12 = i13;
            }
            i11++;
        }
        return i12;
    }

    public static void t0(View view, Drawable drawable) {
        view.setBackground(drawable);
    }

    public static ColorStateList u(View view) {
        return h.c(view);
    }

    public static void u0(View view, ColorStateList colorStateList) {
        h.k(view, colorStateList);
    }

    public static PorterDuff.Mode v(View view) {
        return h.d(view);
    }

    public static void v0(View view, PorterDuff.Mode mode) {
        h.l(view, mode);
    }

    public static Display w(View view) {
        return view.getDisplay();
    }

    public static void w0(ViewGroup viewGroup, boolean z10) {
        if (f٢٩١٦b == null) {
            try {
                f٢٩١٦b = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", Boolean.TYPE);
            } catch (NoSuchMethodException e10) {
                Log.e("ViewCompat", "Unable to find childrenDrawingOrderEnabled", e10);
            }
            f٢٩١٦b.setAccessible(true);
        }
        try {
            f٢٩١٦b.invoke(viewGroup, Boolean.valueOf(z10));
        } catch (IllegalAccessException e11) {
            Log.e("ViewCompat", "Unable to invoke childrenDrawingOrderEnabled", e11);
        } catch (IllegalArgumentException e12) {
            Log.e("ViewCompat", "Unable to invoke childrenDrawingOrderEnabled", e12);
        } catch (InvocationTargetException e13) {
            Log.e("ViewCompat", "Unable to invoke childrenDrawingOrderEnabled", e13);
        }
    }

    public static float x(View view) {
        return h.e(view);
    }

    public static void x0(View view, float f10) {
        h.m(view, f10);
    }

    private static Rect y() {
        if (f٢٩١٩e == null) {
            f٢٩١٩e = new ThreadLocal();
        }
        Rect rect = (Rect) f٢٩١٩e.get();
        if (rect == null) {
            rect = new Rect();
            f٢٩١٩e.set(rect);
        }
        rect.setEmpty();
        return rect;
    }

    public static void y0(View view, boolean z10) {
        view.setFitsSystemWindows(z10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static l0 z(View view) {
        if (view instanceof l0) {
            return (l0) view;
        }
        return f٢٩٢١g;
    }

    public static void z0(View view, int i10) {
        view.setImportantForAccessibility(i10);
    }
}
