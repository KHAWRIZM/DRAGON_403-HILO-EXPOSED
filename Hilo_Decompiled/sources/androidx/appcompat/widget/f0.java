package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import androidx.appcompat.R;
import java.lang.reflect.Method;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class f0 implements androidx.appcompat.view.menu.o {
    private static Method G;
    private static Method H;
    private static Method I;
    private Runnable A;

    /* renamed from: B, reason: collision with root package name */
    final Handler f١٥١٣B;
    private final Rect C;
    private Rect D;
    private boolean E;
    PopupWindow F;

    /* renamed from: a, reason: collision with root package name */
    private Context f١٥١٤a;

    /* renamed from: b, reason: collision with root package name */
    private ListAdapter f١٥١٥b;

    /* renamed from: c, reason: collision with root package name */
    DropDownListView f١٥١٦c;

    /* renamed from: d, reason: collision with root package name */
    private int f١٥١٧d;

    /* renamed from: e, reason: collision with root package name */
    private int f١٥١٨e;

    /* renamed from: f, reason: collision with root package name */
    private int f١٥١٩f;

    /* renamed from: g, reason: collision with root package name */
    private int f١٥٢٠g;

    /* renamed from: h, reason: collision with root package name */
    private int f١٥٢١h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f١٥٢٢i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f١٥٢٣j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f١٥٢٤k;

    /* renamed from: l, reason: collision with root package name */
    private int f١٥٢٥l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f١٥٢٦m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f١٥٢٧n;

    /* renamed from: o, reason: collision with root package name */
    int f١٥٢٨o;

    /* renamed from: p, reason: collision with root package name */
    private View f١٥٢٩p;

    /* renamed from: q, reason: collision with root package name */
    private int f١٥٣٠q;

    /* renamed from: r, reason: collision with root package name */
    private DataSetObserver f١٥٣١r;

    /* renamed from: s, reason: collision with root package name */
    private View f١٥٣٢s;

    /* renamed from: t, reason: collision with root package name */
    private Drawable f١٥٣٣t;

    /* renamed from: u, reason: collision with root package name */
    private AdapterView.OnItemClickListener f١٥٣٤u;

    /* renamed from: v, reason: collision with root package name */
    private AdapterView.OnItemSelectedListener f١٥٣٥v;

    /* renamed from: w, reason: collision with root package name */
    final i f١٥٣٦w;

    /* renamed from: x, reason: collision with root package name */
    private final h f١٥٣٧x;

    /* renamed from: y, reason: collision with root package name */
    private final g f١٥٣٨y;

    /* renamed from: z, reason: collision with root package name */
    private final e f١٥٣٩z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            View r10 = f0.this.r();
            if (r10 != null && r10.getWindowToken() != null) {
                f0.this.show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class b implements AdapterView.OnItemSelectedListener {
        b() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView adapterView, View view, int i10, long j10) {
            DropDownListView dropDownListView;
            if (i10 != -1 && (dropDownListView = f0.this.f١٥١٦c) != null) {
                dropDownListView.setListSelectionHidden(false);
            }
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView adapterView) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class c {
        static int a(PopupWindow popupWindow, View view, int i10, boolean z10) {
            return popupWindow.getMaxAvailableHeight(view, i10, z10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class d {
        static void a(PopupWindow popupWindow, Rect rect) {
            popupWindow.setEpicenterBounds(rect);
        }

        static void b(PopupWindow popupWindow, boolean z10) {
            popupWindow.setIsClippedToScreen(z10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            f0.this.p();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    private class f extends DataSetObserver {
        f() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            if (f0.this.isShowing()) {
                f0.this.show();
            }
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            f0.this.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class g implements AbsListView.OnScrollListener {
        g() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i10, int i11, int i12) {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i10) {
            if (i10 == 1 && !f0.this.y() && f0.this.F.getContentView() != null) {
                f0 f0Var = f0.this;
                f0Var.f١٥١٣B.removeCallbacks(f0Var.f١٥٣٦w);
                f0.this.f١٥٣٦w.run();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class h implements View.OnTouchListener {
        h() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            PopupWindow popupWindow;
            int action = motionEvent.getAction();
            int x10 = (int) motionEvent.getX();
            int y10 = (int) motionEvent.getY();
            if (action == 0 && (popupWindow = f0.this.F) != null && popupWindow.isShowing() && x10 >= 0 && x10 < f0.this.F.getWidth() && y10 >= 0 && y10 < f0.this.F.getHeight()) {
                f0 f0Var = f0.this;
                f0Var.f١٥١٣B.postDelayed(f0Var.f١٥٣٦w, 250L);
                return false;
            }
            if (action == 1) {
                f0 f0Var2 = f0.this;
                f0Var2.f١٥١٣B.removeCallbacks(f0Var2.f١٥٣٦w);
                return false;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class i implements Runnable {
        i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            DropDownListView dropDownListView = f0.this.f١٥١٦c;
            if (dropDownListView != null && dropDownListView.isAttachedToWindow() && f0.this.f١٥١٦c.getCount() > f0.this.f١٥١٦c.getChildCount()) {
                int childCount = f0.this.f١٥١٦c.getChildCount();
                f0 f0Var = f0.this;
                if (childCount <= f0Var.f١٥٢٨o) {
                    f0Var.F.setInputMethodMode(2);
                    f0.this.show();
                }
            }
        }
    }

    static {
        if (Build.VERSION.SDK_INT <= 28) {
            try {
                G = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", Boolean.TYPE);
            } catch (NoSuchMethodException unused) {
                Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
            try {
                I = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", Rect.class);
            } catch (NoSuchMethodException unused2) {
                Log.i("ListPopupWindow", "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
            }
        }
        if (Build.VERSION.SDK_INT <= 23) {
            try {
                H = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", View.class, Integer.TYPE, Boolean.TYPE);
            } catch (NoSuchMethodException unused3) {
                Log.i("ListPopupWindow", "Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.");
            }
        }
    }

    public f0(Context context) {
        this(context, null, R.attr.listPopupWindowStyle);
    }

    private void A() {
        View view = this.f١٥٢٩p;
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f١٥٢٩p);
            }
        }
    }

    private void J(boolean z10) {
        if (Build.VERSION.SDK_INT <= 28) {
            Method method = G;
            if (method != null) {
                try {
                    method.invoke(this.F, Boolean.valueOf(z10));
                    return;
                } catch (Exception unused) {
                    Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
                    return;
                }
            }
            return;
        }
        d.b(this.F, z10);
    }

    private int o() {
        int i10;
        int i11;
        int makeMeasureSpec;
        int i12;
        boolean z10 = true;
        if (this.f١٥١٦c == null) {
            Context context = this.f١٥١٤a;
            this.A = new a();
            DropDownListView q10 = q(context, !this.E);
            this.f١٥١٦c = q10;
            Drawable drawable = this.f١٥٣٣t;
            if (drawable != null) {
                q10.setSelector(drawable);
            }
            this.f١٥١٦c.setAdapter(this.f١٥١٥b);
            this.f١٥١٦c.setOnItemClickListener(this.f١٥٣٤u);
            this.f١٥١٦c.setFocusable(true);
            this.f١٥١٦c.setFocusableInTouchMode(true);
            this.f١٥١٦c.setOnItemSelectedListener(new b());
            this.f١٥١٦c.setOnScrollListener(this.f١٥٣٨y);
            AdapterView.OnItemSelectedListener onItemSelectedListener = this.f١٥٣٥v;
            if (onItemSelectedListener != null) {
                this.f١٥١٦c.setOnItemSelectedListener(onItemSelectedListener);
            }
            View view = this.f١٥١٦c;
            View view2 = this.f١٥٢٩p;
            if (view2 != null) {
                LinearLayout linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(1);
                ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0, 1.0f);
                int i13 = this.f١٥٣٠q;
                if (i13 != 0) {
                    if (i13 != 1) {
                        Log.e("ListPopupWindow", "Invalid hint position " + this.f١٥٣٠q);
                    } else {
                        linearLayout.addView(view, layoutParams);
                        linearLayout.addView(view2);
                    }
                } else {
                    linearLayout.addView(view2);
                    linearLayout.addView(view, layoutParams);
                }
                int i14 = this.f١٥١٨e;
                if (i14 >= 0) {
                    i12 = Integer.MIN_VALUE;
                } else {
                    i14 = 0;
                    i12 = 0;
                }
                view2.measure(View.MeasureSpec.makeMeasureSpec(i14, i12), 0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) view2.getLayoutParams();
                i10 = view2.getMeasuredHeight() + layoutParams2.topMargin + layoutParams2.bottomMargin;
                view = linearLayout;
            } else {
                i10 = 0;
            }
            this.F.setContentView(view);
        } else {
            View view3 = this.f١٥٢٩p;
            if (view3 != null) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) view3.getLayoutParams();
                i10 = view3.getMeasuredHeight() + layoutParams3.topMargin + layoutParams3.bottomMargin;
            } else {
                i10 = 0;
            }
        }
        Drawable background = this.F.getBackground();
        if (background != null) {
            background.getPadding(this.C);
            Rect rect = this.C;
            int i15 = rect.top;
            i11 = rect.bottom + i15;
            if (!this.f١٥٢٢i) {
                this.f١٥٢٠g = -i15;
            }
        } else {
            this.C.setEmpty();
            i11 = 0;
        }
        if (this.F.getInputMethodMode() != 2) {
            z10 = false;
        }
        int s10 = s(r(), this.f١٥٢٠g, z10);
        if (!this.f١٥٢٦m && this.f١٥١٧d != -1) {
            int i16 = this.f١٥١٨e;
            if (i16 != -2) {
                if (i16 != -1) {
                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i16, 1073741824);
                } else {
                    int i17 = this.f١٥١٤a.getResources().getDisplayMetrics().widthPixels;
                    Rect rect2 = this.C;
                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i17 - (rect2.left + rect2.right), 1073741824);
                }
            } else {
                int i18 = this.f١٥١٤a.getResources().getDisplayMetrics().widthPixels;
                Rect rect3 = this.C;
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i18 - (rect3.left + rect3.right), Integer.MIN_VALUE);
            }
            int d10 = this.f١٥١٦c.d(makeMeasureSpec, 0, -1, s10 - i10, -1);
            if (d10 > 0) {
                i10 += i11 + this.f١٥١٦c.getPaddingTop() + this.f١٥١٦c.getPaddingBottom();
            }
            return d10 + i10;
        }
        return s10 + i11;
    }

    private int s(View view, int i10, boolean z10) {
        if (Build.VERSION.SDK_INT <= 23) {
            Method method = H;
            if (method != null) {
                try {
                    return ((Integer) method.invoke(this.F, view, Integer.valueOf(i10), Boolean.valueOf(z10))).intValue();
                } catch (Exception unused) {
                    Log.i("ListPopupWindow", "Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.");
                }
            }
            return this.F.getMaxAvailableHeight(view, i10);
        }
        return c.a(this.F, view, i10, z10);
    }

    public void B(View view) {
        this.f١٥٣٢s = view;
    }

    public void C(int i10) {
        this.F.setAnimationStyle(i10);
    }

    public void D(int i10) {
        Drawable background = this.F.getBackground();
        if (background != null) {
            background.getPadding(this.C);
            Rect rect = this.C;
            this.f١٥١٨e = rect.left + rect.right + i10;
            return;
        }
        M(i10);
    }

    public void E(int i10) {
        this.f١٥٢٥l = i10;
    }

    public void F(Rect rect) {
        Rect rect2;
        if (rect != null) {
            rect2 = new Rect(rect);
        } else {
            rect2 = null;
        }
        this.D = rect2;
    }

    public void G(int i10) {
        this.F.setInputMethodMode(i10);
    }

    public void H(boolean z10) {
        this.E = z10;
        this.F.setFocusable(z10);
    }

    public void I(boolean z10) {
        this.f١٥٢٤k = true;
        this.f١٥٢٣j = z10;
    }

    public void K(int i10) {
        this.f١٥٣٠q = i10;
    }

    public void L(int i10) {
        DropDownListView dropDownListView = this.f١٥١٦c;
        if (isShowing() && dropDownListView != null) {
            dropDownListView.setListSelectionHidden(false);
            dropDownListView.setSelection(i10);
            if (dropDownListView.getChoiceMode() != 0) {
                dropDownListView.setItemChecked(i10, true);
            }
        }
    }

    public void M(int i10) {
        this.f١٥١٨e = i10;
    }

    public void b(Drawable drawable) {
        this.F.setBackgroundDrawable(drawable);
    }

    public int c() {
        return this.f١٥١٩f;
    }

    public void d(int i10) {
        this.f١٥١٩f = i10;
    }

    @Override // androidx.appcompat.view.menu.o
    public void dismiss() {
        this.F.dismiss();
        A();
        this.F.setContentView(null);
        this.f١٥١٦c = null;
        this.f١٥١٣B.removeCallbacks(this.f١٥٣٦w);
    }

    public Drawable f() {
        return this.F.getBackground();
    }

    public void h(int i10) {
        this.f١٥٢٠g = i10;
        this.f١٥٢٢i = true;
    }

    @Override // androidx.appcompat.view.menu.o
    public boolean isShowing() {
        return this.F.isShowing();
    }

    public int k() {
        if (!this.f١٥٢٢i) {
            return 0;
        }
        return this.f١٥٢٠g;
    }

    public void l(ListAdapter listAdapter) {
        DataSetObserver dataSetObserver = this.f١٥٣١r;
        if (dataSetObserver == null) {
            this.f١٥٣١r = new f();
        } else {
            ListAdapter listAdapter2 = this.f١٥١٥b;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.f١٥١٥b = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.f١٥٣١r);
        }
        DropDownListView dropDownListView = this.f١٥١٦c;
        if (dropDownListView != null) {
            dropDownListView.setAdapter(this.f١٥١٥b);
        }
    }

    @Override // androidx.appcompat.view.menu.o
    public ListView n() {
        return this.f١٥١٦c;
    }

    public void p() {
        DropDownListView dropDownListView = this.f١٥١٦c;
        if (dropDownListView != null) {
            dropDownListView.setListSelectionHidden(true);
            dropDownListView.requestLayout();
        }
    }

    DropDownListView q(Context context, boolean z10) {
        return new DropDownListView(context, z10);
    }

    public View r() {
        return this.f١٥٣٢s;
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.F.setOnDismissListener(onDismissListener);
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.f١٥٣٤u = onItemClickListener;
    }

    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        this.f١٥٣٥v = onItemSelectedListener;
    }

    @Override // androidx.appcompat.view.menu.o
    public void show() {
        boolean z10;
        int i10;
        int i11;
        int i12;
        int i13;
        int o10 = o();
        boolean y10 = y();
        androidx.core.widget.j.b(this.F, this.f١٥٢١h);
        boolean z11 = true;
        if (this.F.isShowing()) {
            if (!r().isAttachedToWindow()) {
                return;
            }
            int i14 = this.f١٥١٨e;
            if (i14 == -1) {
                i14 = -1;
            } else if (i14 == -2) {
                i14 = r().getWidth();
            }
            int i15 = this.f١٥١٧d;
            if (i15 == -1) {
                if (!y10) {
                    o10 = -1;
                }
                if (y10) {
                    PopupWindow popupWindow = this.F;
                    if (this.f١٥١٨e == -1) {
                        i13 = -1;
                    } else {
                        i13 = 0;
                    }
                    popupWindow.setWidth(i13);
                    this.F.setHeight(0);
                } else {
                    PopupWindow popupWindow2 = this.F;
                    if (this.f١٥١٨e == -1) {
                        i12 = -1;
                    } else {
                        i12 = 0;
                    }
                    popupWindow2.setWidth(i12);
                    this.F.setHeight(-1);
                }
            } else if (i15 != -2) {
                o10 = i15;
            }
            PopupWindow popupWindow3 = this.F;
            if (this.f١٥٢٧n || this.f١٥٢٦m) {
                z11 = false;
            }
            popupWindow3.setOutsideTouchable(z11);
            PopupWindow popupWindow4 = this.F;
            View r10 = r();
            int i16 = this.f١٥١٩f;
            int i17 = this.f١٥٢٠g;
            if (i14 < 0) {
                i10 = -1;
            } else {
                i10 = i14;
            }
            if (o10 < 0) {
                i11 = -1;
            } else {
                i11 = o10;
            }
            popupWindow4.update(r10, i16, i17, i10, i11);
            return;
        }
        int i18 = this.f١٥١٨e;
        if (i18 == -1) {
            i18 = -1;
        } else if (i18 == -2) {
            i18 = r().getWidth();
        }
        int i19 = this.f١٥١٧d;
        if (i19 == -1) {
            o10 = -1;
        } else if (i19 != -2) {
            o10 = i19;
        }
        this.F.setWidth(i18);
        this.F.setHeight(o10);
        J(true);
        PopupWindow popupWindow5 = this.F;
        if (!this.f١٥٢٧n && !this.f١٥٢٦m) {
            z10 = true;
        } else {
            z10 = false;
        }
        popupWindow5.setOutsideTouchable(z10);
        this.F.setTouchInterceptor(this.f١٥٣٧x);
        if (this.f١٥٢٤k) {
            androidx.core.widget.j.a(this.F, this.f١٥٢٣j);
        }
        if (Build.VERSION.SDK_INT <= 28) {
            Method method = I;
            if (method != null) {
                try {
                    method.invoke(this.F, this.D);
                } catch (Exception e10) {
                    Log.e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", e10);
                }
            }
        } else {
            d.a(this.F, this.D);
        }
        androidx.core.widget.j.c(this.F, r(), this.f١٥١٩f, this.f١٥٢٠g, this.f١٥٢٥l);
        this.f١٥١٦c.setSelection(-1);
        if (!this.E || this.f١٥١٦c.isInTouchMode()) {
            p();
        }
        if (!this.E) {
            this.f١٥١٣B.post(this.f١٥٣٩z);
        }
    }

    public Object t() {
        if (!isShowing()) {
            return null;
        }
        return this.f١٥١٦c.getSelectedItem();
    }

    public long u() {
        if (!isShowing()) {
            return Long.MIN_VALUE;
        }
        return this.f١٥١٦c.getSelectedItemId();
    }

    public int v() {
        if (!isShowing()) {
            return -1;
        }
        return this.f١٥١٦c.getSelectedItemPosition();
    }

    public View w() {
        if (!isShowing()) {
            return null;
        }
        return this.f١٥١٦c.getSelectedView();
    }

    public int x() {
        return this.f١٥١٨e;
    }

    public boolean y() {
        if (this.F.getInputMethodMode() == 2) {
            return true;
        }
        return false;
    }

    public boolean z() {
        return this.E;
    }

    public f0(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0);
    }

    public f0(Context context, AttributeSet attributeSet, int i10, int i11) {
        this.f١٥١٧d = -2;
        this.f١٥١٨e = -2;
        this.f١٥٢١h = 1002;
        this.f١٥٢٥l = 0;
        this.f١٥٢٦m = false;
        this.f١٥٢٧n = false;
        this.f١٥٢٨o = Integer.MAX_VALUE;
        this.f١٥٣٠q = 0;
        this.f١٥٣٦w = new i();
        this.f١٥٣٧x = new h();
        this.f١٥٣٨y = new g();
        this.f١٥٣٩z = new e();
        this.C = new Rect();
        this.f١٥١٤a = context;
        this.f١٥١٣B = new Handler(context.getMainLooper());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ListPopupWindow, i10, i11);
        this.f١٥١٩f = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.ListPopupWindow_android_dropDownHorizontalOffset, 0);
        int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.ListPopupWindow_android_dropDownVerticalOffset, 0);
        this.f١٥٢٠g = dimensionPixelOffset;
        if (dimensionPixelOffset != 0) {
            this.f١٥٢٢i = true;
        }
        obtainStyledAttributes.recycle();
        k kVar = new k(context, attributeSet, i10, i11);
        this.F = kVar;
        kVar.setInputMethodMode(1);
    }
}
