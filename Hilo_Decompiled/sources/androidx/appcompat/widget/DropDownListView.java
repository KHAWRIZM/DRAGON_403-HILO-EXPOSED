package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.appcompat.R;
import androidx.core.view.l1;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class DropDownListView extends ListView {

    /* renamed from: a, reason: collision with root package name */
    private final Rect f١٣٢١a;

    /* renamed from: b, reason: collision with root package name */
    private int f١٣٢٢b;

    /* renamed from: c, reason: collision with root package name */
    private int f١٣٢٣c;

    /* renamed from: d, reason: collision with root package name */
    private int f١٣٢٤d;

    /* renamed from: e, reason: collision with root package name */
    private int f١٣٢٥e;

    /* renamed from: f, reason: collision with root package name */
    private int f١٣٢٦f;

    /* renamed from: g, reason: collision with root package name */
    private d f١٣٢٧g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f١٣٢٨h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f١٣٢٩i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f١٣٣٠j;

    /* renamed from: k, reason: collision with root package name */
    private l1 f١٣٣١k;

    /* renamed from: l, reason: collision with root package name */
    private androidx.core.widget.h f١٣٣٢l;

    /* renamed from: m, reason: collision with root package name */
    f f١٣٣٣m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class a {
        static void a(View view, float f10, float f11) {
            view.drawableHotspotChanged(f10, f11);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    static class b {

        /* renamed from: a, reason: collision with root package name */
        private static Method f١٣٣٤a;

        /* renamed from: b, reason: collision with root package name */
        private static Method f١٣٣٥b;

        /* renamed from: c, reason: collision with root package name */
        private static Method f١٣٣٦c;

        /* renamed from: d, reason: collision with root package name */
        private static boolean f١٣٣٧d;

        static {
            try {
                Class cls = Integer.TYPE;
                Class cls2 = Float.TYPE;
                Method declaredMethod = AbsListView.class.getDeclaredMethod("positionSelector", cls, View.class, Boolean.TYPE, cls2, cls2);
                f١٣٣٤a = declaredMethod;
                declaredMethod.setAccessible(true);
                Method declaredMethod2 = AdapterView.class.getDeclaredMethod("setSelectedPositionInt", cls);
                f١٣٣٥b = declaredMethod2;
                declaredMethod2.setAccessible(true);
                Method declaredMethod3 = AdapterView.class.getDeclaredMethod("setNextSelectedPositionInt", cls);
                f١٣٣٦c = declaredMethod3;
                declaredMethod3.setAccessible(true);
                f١٣٣٧d = true;
            } catch (NoSuchMethodException e10) {
                e10.printStackTrace();
            }
        }

        static boolean a() {
            return f١٣٣٧d;
        }

        static void b(DropDownListView dropDownListView, int i10, View view) {
            try {
                f١٣٣٤a.invoke(dropDownListView, Integer.valueOf(i10), view, Boolean.FALSE, -1, -1);
                f١٣٣٥b.invoke(dropDownListView, Integer.valueOf(i10));
                f١٣٣٦c.invoke(dropDownListView, Integer.valueOf(i10));
            } catch (IllegalAccessException e10) {
                e10.printStackTrace();
            } catch (InvocationTargetException e11) {
                e11.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class c {
        static boolean a(AbsListView absListView) {
            return absListView.isSelectedChildViewEnabled();
        }

        static void b(AbsListView absListView, boolean z10) {
            absListView.setSelectedChildViewEnabled(z10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class d extends s1.c {

        /* renamed from: b, reason: collision with root package name */
        private boolean f١٣٣٨b;

        d(Drawable drawable) {
            super(drawable);
            this.f١٣٣٨b = true;
        }

        void c(boolean z10) {
            this.f١٣٣٨b = z10;
        }

        @Override // s1.c, android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            if (this.f١٣٣٨b) {
                super.draw(canvas);
            }
        }

        @Override // s1.c, android.graphics.drawable.Drawable
        public void setHotspot(float f10, float f11) {
            if (this.f١٣٣٨b) {
                super.setHotspot(f10, f11);
            }
        }

        @Override // s1.c, android.graphics.drawable.Drawable
        public void setHotspotBounds(int i10, int i11, int i12, int i13) {
            if (this.f١٣٣٨b) {
                super.setHotspotBounds(i10, i11, i12, i13);
            }
        }

        @Override // s1.c, android.graphics.drawable.Drawable
        public boolean setState(int[] iArr) {
            if (this.f١٣٣٨b) {
                return super.setState(iArr);
            }
            return false;
        }

        @Override // s1.c, android.graphics.drawable.Drawable
        public boolean setVisible(boolean z10, boolean z11) {
            if (this.f١٣٣٨b) {
                return super.setVisible(z10, z11);
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        private static final Field f١٣٣٩a;

        static {
            Field field = null;
            try {
                field = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
                field.setAccessible(true);
            } catch (NoSuchFieldException e10) {
                e10.printStackTrace();
            }
            f١٣٣٩a = field;
        }

        static boolean a(AbsListView absListView) {
            Field field = f١٣٣٩a;
            if (field != null) {
                try {
                    return field.getBoolean(absListView);
                } catch (IllegalAccessException e10) {
                    e10.printStackTrace();
                    return false;
                }
            }
            return false;
        }

        static void b(AbsListView absListView, boolean z10) {
            Field field = f١٣٣٩a;
            if (field != null) {
                try {
                    field.set(absListView, Boolean.valueOf(z10));
                } catch (IllegalAccessException e10) {
                    e10.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class f implements Runnable {
        f() {
        }

        public void a() {
            DropDownListView dropDownListView = DropDownListView.this;
            dropDownListView.f١٣٣٣m = null;
            dropDownListView.removeCallbacks(this);
        }

        public void b() {
            DropDownListView.this.post(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            DropDownListView dropDownListView = DropDownListView.this;
            dropDownListView.f١٣٣٣m = null;
            dropDownListView.drawableStateChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DropDownListView(Context context, boolean z10) {
        super(context, null, R.attr.dropDownListViewStyle);
        this.f١٣٢١a = new Rect();
        this.f١٣٢٢b = 0;
        this.f١٣٢٣c = 0;
        this.f١٣٢٤d = 0;
        this.f١٣٢٥e = 0;
        this.f١٣٢٩i = z10;
        setCacheColorHint(0);
    }

    private void a() {
        this.f١٣٣٠j = false;
        setPressed(false);
        drawableStateChanged();
        View childAt = getChildAt(this.f١٣٢٦f - getFirstVisiblePosition());
        if (childAt != null) {
            childAt.setPressed(false);
        }
        l1 l1Var = this.f١٣٣١k;
        if (l1Var != null) {
            l1Var.c();
            this.f١٣٣١k = null;
        }
    }

    private void b(View view, int i10) {
        performItemClick(view, i10, getItemIdAtPosition(i10));
    }

    private void c(Canvas canvas) {
        Drawable selector;
        if (!this.f١٣٢١a.isEmpty() && (selector = getSelector()) != null) {
            selector.setBounds(this.f١٣٢١a);
            selector.draw(canvas);
        }
    }

    private void f(int i10, View view) {
        Rect rect = this.f١٣٢١a;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        rect.left -= this.f١٣٢٢b;
        rect.top -= this.f١٣٢٣c;
        rect.right += this.f١٣٢٤d;
        rect.bottom += this.f١٣٢٥e;
        boolean k10 = k();
        if (view.isEnabled() != k10) {
            l(!k10);
            if (i10 != -1) {
                refreshDrawableState();
            }
        }
    }

    private void g(int i10, View view) {
        boolean z10;
        Drawable selector = getSelector();
        boolean z11 = true;
        if (selector != null && i10 != -1) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            selector.setVisible(false, false);
        }
        f(i10, view);
        if (z10) {
            Rect rect = this.f١٣٢١a;
            float exactCenterX = rect.exactCenterX();
            float exactCenterY = rect.exactCenterY();
            if (getVisibility() != 0) {
                z11 = false;
            }
            selector.setVisible(z11, false);
            h2.b.k(selector, exactCenterX, exactCenterY);
        }
    }

    private void h(int i10, View view, float f10, float f11) {
        g(i10, view);
        Drawable selector = getSelector();
        if (selector != null && i10 != -1) {
            h2.b.k(selector, f10, f11);
        }
    }

    private void i(View view, int i10, float f10, float f11) {
        View childAt;
        this.f١٣٣٠j = true;
        a.a(this, f10, f11);
        if (!isPressed()) {
            setPressed(true);
        }
        layoutChildren();
        int i11 = this.f١٣٢٦f;
        if (i11 != -1 && (childAt = getChildAt(i11 - getFirstVisiblePosition())) != null && childAt != view && childAt.isPressed()) {
            childAt.setPressed(false);
        }
        this.f١٣٢٦f = i10;
        a.a(view, f10 - view.getLeft(), f11 - view.getTop());
        if (!view.isPressed()) {
            view.setPressed(true);
        }
        h(i10, view, f10, f11);
        j(false);
        refreshDrawableState();
    }

    private void j(boolean z10) {
        d dVar = this.f١٣٢٧g;
        if (dVar != null) {
            dVar.c(z10);
        }
    }

    private boolean k() {
        if (Build.VERSION.SDK_INT >= 33) {
            return c.a(this);
        }
        return e.a(this);
    }

    private void l(boolean z10) {
        if (Build.VERSION.SDK_INT >= 33) {
            c.b(this, z10);
        } else {
            e.b(this, z10);
        }
    }

    private boolean m() {
        return this.f١٣٣٠j;
    }

    private void n() {
        Drawable selector = getSelector();
        if (selector != null && m() && isPressed()) {
            selector.setState(getDrawableState());
        }
    }

    public int d(int i10, int i11, int i12, int i13, int i14) {
        int makeMeasureSpec;
        int listPaddingTop = getListPaddingTop();
        int listPaddingBottom = getListPaddingBottom();
        int dividerHeight = getDividerHeight();
        Drawable divider = getDivider();
        ListAdapter adapter = getAdapter();
        if (adapter == null) {
            return listPaddingTop + listPaddingBottom;
        }
        int i15 = listPaddingTop + listPaddingBottom;
        if (dividerHeight <= 0 || divider == null) {
            dividerHeight = 0;
        }
        int count = adapter.getCount();
        View view = null;
        int i16 = 0;
        int i17 = 0;
        for (int i18 = 0; i18 < count; i18++) {
            int itemViewType = adapter.getItemViewType(i18);
            if (itemViewType != i16) {
                view = null;
                i16 = itemViewType;
            }
            view = adapter.getView(i18, view, this);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = generateDefaultLayoutParams();
                view.setLayoutParams(layoutParams);
            }
            int i19 = layoutParams.height;
            if (i19 > 0) {
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i19, 1073741824);
            } else {
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            }
            view.measure(i10, makeMeasureSpec);
            view.forceLayout();
            if (i18 > 0) {
                i15 += dividerHeight;
            }
            i15 += view.getMeasuredHeight();
            if (i15 >= i13) {
                if (i14 >= 0 && i18 > i14 && i17 > 0 && i15 != i13) {
                    return i17;
                }
                return i13;
            }
            if (i14 >= 0 && i18 >= i14) {
                i17 = i15;
            }
        }
        return i15;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        c(canvas);
        super.dispatchDraw(canvas);
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        if (this.f١٣٣٣m != null) {
            return;
        }
        super.drawableStateChanged();
        j(true);
        n();
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x000c, code lost:
    
        if (r0 != 3) goto L٨;
     */
    /* JADX WARN: Removed duplicated region for block: B:11:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0048 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean e(MotionEvent motionEvent, int i10) {
        boolean z10;
        boolean z11;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 1) {
            if (actionMasked == 2) {
                z10 = true;
            }
        } else {
            z10 = false;
        }
        int findPointerIndex = motionEvent.findPointerIndex(i10);
        if (findPointerIndex >= 0) {
            int x10 = (int) motionEvent.getX(findPointerIndex);
            int y10 = (int) motionEvent.getY(findPointerIndex);
            int pointToPosition = pointToPosition(x10, y10);
            if (pointToPosition == -1) {
                z11 = true;
                if (z10 || z11) {
                    a();
                }
                if (z10) {
                    if (this.f١٣٣٢l == null) {
                        this.f١٣٣٢l = new androidx.core.widget.h(this);
                    }
                    this.f١٣٣٢l.m(true);
                    this.f١٣٣٢l.onTouch(this, motionEvent);
                } else {
                    androidx.core.widget.h hVar = this.f١٣٣٢l;
                    if (hVar != null) {
                        hVar.m(false);
                    }
                }
                return z10;
            }
            View childAt = getChildAt(pointToPosition - getFirstVisiblePosition());
            i(childAt, pointToPosition, x10, y10);
            if (actionMasked == 1) {
                b(childAt, pointToPosition);
            }
            z11 = false;
            z10 = true;
            if (z10) {
            }
            a();
            if (z10) {
            }
            return z10;
        }
        z11 = false;
        z10 = false;
        if (z10) {
        }
        a();
        if (z10) {
        }
        return z10;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean hasFocus() {
        if (!this.f١٣٢٩i && !super.hasFocus()) {
            return false;
        }
        return true;
    }

    @Override // android.view.View
    public boolean hasWindowFocus() {
        if (!this.f١٣٢٩i && !super.hasWindowFocus()) {
            return false;
        }
        return true;
    }

    @Override // android.view.View
    public boolean isFocused() {
        if (!this.f١٣٢٩i && !super.isFocused()) {
            return false;
        }
        return true;
    }

    @Override // android.view.View
    public boolean isInTouchMode() {
        if ((this.f١٣٢٩i && this.f١٣٢٨h) || super.isInTouchMode()) {
            return true;
        }
        return false;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.f١٣٣٣m = null;
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 < 26) {
            return super.onHoverEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 10 && this.f١٣٣٣m == null) {
            f fVar = new f();
            this.f١٣٣٣m = fVar;
            fVar.b();
        }
        boolean onHoverEvent = super.onHoverEvent(motionEvent);
        if (actionMasked != 9 && actionMasked != 7) {
            setSelection(-1);
        } else {
            int pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
            if (pointToPosition != -1 && pointToPosition != getSelectedItemPosition()) {
                View childAt = getChildAt(pointToPosition - getFirstVisiblePosition());
                if (childAt.isEnabled()) {
                    requestFocus();
                    if (i10 >= 30 && b.a()) {
                        b.b(this, pointToPosition, childAt);
                    } else {
                        setSelectionFromTop(pointToPosition, childAt.getTop() - getTop());
                    }
                }
                n();
            }
        }
        return onHoverEvent;
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f١٣٢٦f = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        }
        f fVar = this.f١٣٣٣m;
        if (fVar != null) {
            fVar.a();
        }
        return super.onTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setListSelectionHidden(boolean z10) {
        this.f١٣٢٨h = z10;
    }

    @Override // android.widget.AbsListView
    public void setSelector(Drawable drawable) {
        d dVar;
        if (drawable != null) {
            dVar = new d(drawable);
        } else {
            dVar = null;
        }
        this.f١٣٢٧g = dVar;
        super.setSelector(dVar);
        Rect rect = new Rect();
        if (drawable != null) {
            drawable.getPadding(rect);
        }
        this.f١٣٢٢b = rect.left;
        this.f١٣٢٣c = rect.top;
        this.f١٣٢٤d = rect.right;
        this.f١٣٢٥e = rect.bottom;
    }
}
