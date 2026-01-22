package com.google.android.material.bottomsheet;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.d1;
import com.google.android.material.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import m2.g0;
import m2.j0;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class BottomSheetDragHandleView extends AppCompatImageView implements AccessibilityManager.AccessibilityStateChangeListener {

    /* renamed from: k, reason: collision with root package name */
    private static final int f٨٤٨٢k = R.style.Widget_Material3_BottomSheet_DragHandle;

    /* renamed from: a, reason: collision with root package name */
    private final AccessibilityManager f٨٤٨٣a;

    /* renamed from: b, reason: collision with root package name */
    private BottomSheetBehavior f٨٤٨٤b;

    /* renamed from: c, reason: collision with root package name */
    private final GestureDetector f٨٤٨٥c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f٨٤٨٦d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f٨٤٨٧e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f٨٤٨٨f;

    /* renamed from: g, reason: collision with root package name */
    private final String f٨٤٨٩g;

    /* renamed from: h, reason: collision with root package name */
    private final String f٨٤٩٠h;

    /* renamed from: i, reason: collision with root package name */
    private final BottomSheetBehavior.g f٨٤٩١i;

    /* renamed from: j, reason: collision with root package name */
    private final GestureDetector.OnGestureListener f٨٤٩٢j;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class a extends BottomSheetBehavior.g {
        a() {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.g
        public void onSlide(View view, float f10) {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.g
        public void onStateChanged(View view, int i10) {
            BottomSheetDragHandleView.this.t(i10);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class b extends GestureDetector.SimpleOnGestureListener {
        b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (BottomSheetDragHandleView.this.f٨٤٨٤b != null && BottomSheetDragHandleView.this.f٨٤٨٤b.C0()) {
                BottomSheetDragHandleView.this.f٨٤٨٤b.c(5);
                return true;
            }
            return super.onDoubleTap(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return BottomSheetDragHandleView.this.isClickable();
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            return BottomSheetDragHandleView.this.o();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class c extends androidx.core.view.a {
        c() {
        }

        @Override // androidx.core.view.a
        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onPopulateAccessibilityEvent(view, accessibilityEvent);
            if (accessibilityEvent.getEventType() == 1) {
                BottomSheetDragHandleView.this.o();
            }
        }
    }

    public BottomSheetDragHandleView(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean o() {
        boolean z10 = false;
        if (!r()) {
            return false;
        }
        if (!this.f٨٤٨٤b.A0() && !this.f٨٤٨٤b.i1()) {
            z10 = true;
        }
        int state = this.f٨٤٨٤b.getState();
        int i10 = 6;
        int i11 = 3;
        if (state == 4) {
            if (!z10) {
                i10 = 3;
            }
        } else if (state == 3) {
            if (!z10) {
                i10 = 4;
            }
        } else {
            if (!this.f٨٤٨٦d) {
                i11 = 4;
            }
            i10 = i11;
        }
        this.f٨٤٨٤b.c(i10);
        return true;
    }

    private BottomSheetBehavior p() {
        View view = this;
        while (true) {
            view = q(view);
            if (view != null) {
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                if (layoutParams instanceof CoordinatorLayout.f) {
                    CoordinatorLayout.c f10 = ((CoordinatorLayout.f) layoutParams).f();
                    if (f10 instanceof BottomSheetBehavior) {
                        return (BottomSheetBehavior) f10;
                    }
                }
            } else {
                return null;
            }
        }
    }

    private static View q(View view) {
        Object parent = view.getParent();
        if (parent instanceof View) {
            return (View) parent;
        }
        return null;
    }

    private boolean r() {
        if (this.f٨٤٨٤b != null) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean s(View view, j0.a aVar) {
        return o();
    }

    private void setBottomSheetBehavior(BottomSheetBehavior<?> bottomSheetBehavior) {
        BottomSheetBehavior bottomSheetBehavior2 = this.f٨٤٨٤b;
        if (bottomSheetBehavior2 != null) {
            bottomSheetBehavior2.I0(this.f٨٤٩١i);
            this.f٨٤٨٤b.N0(null);
            this.f٨٤٨٤b.O0(null);
        }
        this.f٨٤٨٤b = bottomSheetBehavior;
        if (bottomSheetBehavior != null) {
            bottomSheetBehavior.N0(this);
            this.f٨٤٨٤b.O0(this);
            t(this.f٨٤٨٤b.getState());
            this.f٨٤٨٤b.e0(this.f٨٤٩١i);
        }
        setClickable(r());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(int i10) {
        String str;
        if (i10 == 4) {
            this.f٨٤٨٦d = true;
        } else if (i10 == 3) {
            this.f٨٤٨٦d = false;
        }
        g0.a aVar = g0.a.f١٥٩٣٠i;
        if (this.f٨٤٨٦d) {
            str = this.f٨٤٨٩g;
        } else {
            str = this.f٨٤٩٠h;
        }
        d1.m0(this, aVar, str, new j0() { // from class: com.google.android.material.bottomsheet.e
            @Override // m2.j0
            public final boolean perform(View view, j0.a aVar2) {
                boolean s10;
                s10 = BottomSheetDragHandleView.this.s(view, aVar2);
                return s10;
            }
        });
    }

    @Override // android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener
    public void onAccessibilityStateChanged(boolean z10) {
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        setBottomSheetBehavior(p());
        AccessibilityManager accessibilityManager = this.f٨٤٨٣a;
        if (accessibilityManager != null) {
            accessibilityManager.addAccessibilityStateChangeListener(this);
            onAccessibilityStateChanged(this.f٨٤٨٣a.isEnabled());
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        AccessibilityManager accessibilityManager = this.f٨٤٨٣a;
        if (accessibilityManager != null) {
            accessibilityManager.removeAccessibilityStateChangeListener(this);
        }
        setBottomSheetBehavior(null);
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.f٨٤٨٨f && !this.f٨٤٨٧e) {
            return this.f٨٤٨٥c.onTouchEvent(motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        boolean z10;
        if (onClickListener != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.f٨٤٨٨f = z10;
        super.setOnClickListener(onClickListener);
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        boolean z10;
        if (onTouchListener != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.f٨٤٨٧e = z10;
        super.setOnTouchListener(onTouchListener);
    }

    public BottomSheetDragHandleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.bottomSheetDragHandleStyle);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public BottomSheetDragHandleView(Context context, AttributeSet attributeSet, int i10) {
        super(g8.a.d(context, attributeSet, i10, f٨٤٨٢k), attributeSet, i10);
        this.f٨٤٨٧e = false;
        this.f٨٤٨٨f = false;
        this.f٨٤٨٩g = getResources().getString(R.string.bottomsheet_action_expand);
        this.f٨٤٩٠h = getResources().getString(R.string.bottomsheet_action_collapse);
        this.f٨٤٩١i = new a();
        b bVar = new b();
        this.f٨٤٩٢j = bVar;
        Context context2 = getContext();
        this.f٨٤٨٥c = new GestureDetector(context2, bVar, new Handler(Looper.getMainLooper()));
        this.f٨٤٨٣a = (AccessibilityManager) context2.getSystemService("accessibility");
        d1.q0(this, new c());
    }
}
