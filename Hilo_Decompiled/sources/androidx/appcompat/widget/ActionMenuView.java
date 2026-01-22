package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.l;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.qiahao.base_common.download.okDownload.DownloadProgress;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class ActionMenuView extends LinearLayoutCompat implements g.b, androidx.appcompat.view.menu.m {

    /* renamed from: a, reason: collision with root package name */
    private androidx.appcompat.view.menu.g f١٢٠٥a;

    /* renamed from: b, reason: collision with root package name */
    private Context f١٢٠٦b;

    /* renamed from: c, reason: collision with root package name */
    private int f١٢٠٧c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f١٢٠٨d;

    /* renamed from: e, reason: collision with root package name */
    private ActionMenuPresenter f١٢٠٩e;

    /* renamed from: f, reason: collision with root package name */
    private l.a f١٢١٠f;

    /* renamed from: g, reason: collision with root package name */
    g.a f١٢١١g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f١٢١٢h;

    /* renamed from: i, reason: collision with root package name */
    private int f١٢١٣i;

    /* renamed from: j, reason: collision with root package name */
    private int f١٢١٤j;

    /* renamed from: k, reason: collision with root package name */
    private int f١٢١٥k;

    /* renamed from: l, reason: collision with root package name */
    e f١٢١٦l;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public interface a {
        boolean c();

        boolean e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class b implements l.a {
        b() {
        }

        @Override // androidx.appcompat.view.menu.l.a
        public void a(androidx.appcompat.view.menu.g gVar, boolean z10) {
        }

        @Override // androidx.appcompat.view.menu.l.a
        public boolean b(androidx.appcompat.view.menu.g gVar) {
            return false;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class c extends LinearLayoutCompat.a {

        /* renamed from: a, reason: collision with root package name */
        public boolean f١٢١٧a;

        /* renamed from: b, reason: collision with root package name */
        public int f١٢١٨b;

        /* renamed from: c, reason: collision with root package name */
        public int f١٢١٩c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f١٢٢٠d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f١٢٢١e;

        /* renamed from: f, reason: collision with root package name */
        boolean f١٢٢٢f;

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public c(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public c(c cVar) {
            super((ViewGroup.LayoutParams) cVar);
            this.f١٢١٧a = cVar.f١٢١٧a;
        }

        public c(int i10, int i11) {
            super(i10, i11);
            this.f١٢١٧a = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class d implements g.a {
        d() {
        }

        @Override // androidx.appcompat.view.menu.g.a
        public boolean a(androidx.appcompat.view.menu.g gVar, MenuItem menuItem) {
            e eVar = ActionMenuView.this.f١٢١٦l;
            if (eVar != null && eVar.onMenuItemClick(menuItem)) {
                return true;
            }
            return false;
        }

        @Override // androidx.appcompat.view.menu.g.a
        public void b(androidx.appcompat.view.menu.g gVar) {
            g.a aVar = ActionMenuView.this.f١٢١١g;
            if (aVar != null) {
                aVar.b(gVar);
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public interface e {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public ActionMenuView(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int t(View view, int i10, int i11, int i12, int i13) {
        ActionMenuItemView actionMenuItemView;
        boolean z10;
        int i14;
        c cVar = (c) view.getLayoutParams();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i12) - i13, View.MeasureSpec.getMode(i12));
        if (view instanceof ActionMenuItemView) {
            actionMenuItemView = (ActionMenuItemView) view;
        } else {
            actionMenuItemView = null;
        }
        boolean z11 = false;
        if (actionMenuItemView != null && actionMenuItemView.k()) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (i11 > 0) {
            i14 = 2;
            if (!z10 || i11 >= 2) {
                view.measure(View.MeasureSpec.makeMeasureSpec(i11 * i10, Integer.MIN_VALUE), makeMeasureSpec);
                int measuredWidth = view.getMeasuredWidth();
                int i15 = measuredWidth / i10;
                if (measuredWidth % i10 != 0) {
                    i15++;
                }
                if (!z10 || i15 >= 2) {
                    i14 = i15;
                }
                if (!cVar.f١٢١٧a && z10) {
                    z11 = true;
                }
                cVar.f١٢٢٠d = z11;
                cVar.f١٢١٨b = i14;
                view.measure(View.MeasureSpec.makeMeasureSpec(i10 * i14, 1073741824), makeMeasureSpec);
                return i14;
            }
        }
        i14 = 0;
        if (!cVar.f١٢١٧a) {
            z11 = true;
        }
        cVar.f١٢٢٠d = z11;
        cVar.f١٢١٨b = i14;
        view.measure(View.MeasureSpec.makeMeasureSpec(i10 * i14, 1073741824), makeMeasureSpec);
        return i14;
    }

    /* JADX WARN: Type inference failed for: r14v12 */
    /* JADX WARN: Type inference failed for: r14v8 */
    /* JADX WARN: Type inference failed for: r14v9, types: [boolean, int] */
    private void u(int i10, int i11) {
        boolean z10;
        int i12;
        int i13;
        boolean z11;
        int i14;
        boolean z12;
        boolean z13;
        int i15;
        int i16;
        boolean z14;
        int i17;
        ?? r14;
        boolean z15;
        int i18;
        int mode = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i10);
        int size2 = View.MeasureSpec.getSize(i11);
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i11, paddingTop, -2);
        int i19 = size - paddingLeft;
        int i20 = this.f١٢١٤j;
        int i21 = i19 / i20;
        int i22 = i19 % i20;
        if (i21 == 0) {
            setMeasuredDimension(i19, 0);
            return;
        }
        int i23 = i20 + (i22 / i21);
        int childCount = getChildCount();
        int i24 = 0;
        int i25 = 0;
        boolean z16 = false;
        int i26 = 0;
        int i27 = 0;
        int i28 = 0;
        long j10 = 0;
        while (i25 < childCount) {
            View childAt = getChildAt(i25);
            int i29 = size2;
            if (childAt.getVisibility() != 8) {
                boolean z17 = childAt instanceof ActionMenuItemView;
                int i30 = i26 + 1;
                if (z17) {
                    int i31 = this.f١٢١٥k;
                    i17 = i30;
                    r14 = 0;
                    childAt.setPadding(i31, 0, i31, 0);
                } else {
                    i17 = i30;
                    r14 = 0;
                }
                c cVar = (c) childAt.getLayoutParams();
                cVar.f١٢٢٢f = r14;
                cVar.f١٢١٩c = r14;
                cVar.f١٢١٨b = r14;
                cVar.f١٢٢٠d = r14;
                ((LinearLayout.LayoutParams) cVar).leftMargin = r14;
                ((LinearLayout.LayoutParams) cVar).rightMargin = r14;
                if (z17 && ((ActionMenuItemView) childAt).k()) {
                    z15 = true;
                } else {
                    z15 = false;
                }
                cVar.f١٢٢١e = z15;
                if (cVar.f١٢١٧a) {
                    i18 = 1;
                } else {
                    i18 = i21;
                }
                int t10 = t(childAt, i23, i18, childMeasureSpec, paddingTop);
                i27 = Math.max(i27, t10);
                if (cVar.f١٢٢٠d) {
                    i28++;
                }
                if (cVar.f١٢١٧a) {
                    z16 = true;
                }
                i21 -= t10;
                i24 = Math.max(i24, childAt.getMeasuredHeight());
                if (t10 == 1) {
                    j10 |= 1 << i25;
                    i24 = i24;
                }
                i26 = i17;
            }
            i25++;
            size2 = i29;
        }
        int i32 = size2;
        if (z16 && i26 == 2) {
            z10 = true;
        } else {
            z10 = false;
        }
        boolean z18 = false;
        while (i28 > 0 && i21 > 0) {
            int i33 = 0;
            int i34 = 0;
            int i35 = Integer.MAX_VALUE;
            long j11 = 0;
            while (i34 < childCount) {
                boolean z19 = z18;
                c cVar2 = (c) getChildAt(i34).getLayoutParams();
                int i36 = i24;
                if (cVar2.f١٢٢٠d) {
                    int i37 = cVar2.f١٢١٨b;
                    if (i37 < i35) {
                        j11 = 1 << i34;
                        i35 = i37;
                        i33 = 1;
                    } else if (i37 == i35) {
                        i33++;
                        j11 |= 1 << i34;
                    }
                }
                i34++;
                i24 = i36;
                z18 = z19;
            }
            z11 = z18;
            i14 = i24;
            j10 |= j11;
            if (i33 > i21) {
                i12 = mode;
                i13 = i19;
                break;
            }
            int i38 = i35 + 1;
            int i39 = 0;
            while (i39 < childCount) {
                View childAt2 = getChildAt(i39);
                c cVar3 = (c) childAt2.getLayoutParams();
                int i40 = i19;
                int i41 = mode;
                long j12 = 1 << i39;
                if ((j11 & j12) == 0) {
                    if (cVar3.f١٢١٨b == i38) {
                        j10 |= j12;
                    }
                    z14 = z10;
                } else {
                    if (z10 && cVar3.f١٢٢١e && i21 == 1) {
                        int i42 = this.f١٢١٥k;
                        z14 = z10;
                        childAt2.setPadding(i42 + i23, 0, i42, 0);
                    } else {
                        z14 = z10;
                    }
                    cVar3.f١٢١٨b++;
                    cVar3.f١٢٢٢f = true;
                    i21--;
                }
                i39++;
                mode = i41;
                i19 = i40;
                z10 = z14;
            }
            i24 = i14;
            z18 = true;
        }
        i12 = mode;
        i13 = i19;
        z11 = z18;
        i14 = i24;
        if (!z16 && i26 == 1) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (i21 > 0 && j10 != 0 && (i21 < i26 - 1 || z12 || i27 > 1)) {
            float bitCount = Long.bitCount(j10);
            if (!z12) {
                if ((j10 & 1) != 0 && !((c) getChildAt(0).getLayoutParams()).f١٢٢١e) {
                    bitCount -= 0.5f;
                }
                int i43 = childCount - 1;
                if ((j10 & (1 << i43)) != 0 && !((c) getChildAt(i43).getLayoutParams()).f١٢٢١e) {
                    bitCount -= 0.5f;
                }
            }
            if (bitCount > DownloadProgress.UNKNOWN_PROGRESS) {
                i16 = (int) ((i21 * i23) / bitCount);
            } else {
                i16 = 0;
            }
            z13 = z11;
            for (int i44 = 0; i44 < childCount; i44++) {
                if ((j10 & (1 << i44)) != 0) {
                    View childAt3 = getChildAt(i44);
                    c cVar4 = (c) childAt3.getLayoutParams();
                    if (childAt3 instanceof ActionMenuItemView) {
                        cVar4.f١٢١٩c = i16;
                        cVar4.f١٢٢٢f = true;
                        if (i44 == 0 && !cVar4.f١٢٢١e) {
                            ((LinearLayout.LayoutParams) cVar4).leftMargin = (-i16) / 2;
                        }
                    } else if (cVar4.f١٢١٧a) {
                        cVar4.f١٢١٩c = i16;
                        cVar4.f١٢٢٢f = true;
                        ((LinearLayout.LayoutParams) cVar4).rightMargin = (-i16) / 2;
                    } else {
                        if (i44 != 0) {
                            ((LinearLayout.LayoutParams) cVar4).leftMargin = i16 / 2;
                        }
                        if (i44 != childCount - 1) {
                            ((LinearLayout.LayoutParams) cVar4).rightMargin = i16 / 2;
                        }
                    }
                    z13 = true;
                }
            }
        } else {
            z13 = z11;
        }
        if (z13) {
            for (int i45 = 0; i45 < childCount; i45++) {
                View childAt4 = getChildAt(i45);
                c cVar5 = (c) childAt4.getLayoutParams();
                if (cVar5.f١٢٢٢f) {
                    childAt4.measure(View.MeasureSpec.makeMeasureSpec((cVar5.f١٢١٨b * i23) + cVar5.f١٢١٩c, 1073741824), childMeasureSpec);
                }
            }
        }
        if (i12 != 1073741824) {
            i15 = i14;
        } else {
            i15 = i32;
        }
        setMeasuredDimension(i13, i15);
    }

    @Override // androidx.appcompat.view.menu.m
    public void b(androidx.appcompat.view.menu.g gVar) {
        this.f١٢٠٥a = gVar;
    }

    @Override // androidx.appcompat.view.menu.g.b
    public boolean c(androidx.appcompat.view.menu.i iVar) {
        return this.f١٢٠٥a.O(iVar, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof c;
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    public Menu getMenu() {
        if (this.f١٢٠٥a == null) {
            Context context = getContext();
            androidx.appcompat.view.menu.g gVar = new androidx.appcompat.view.menu.g(context);
            this.f١٢٠٥a = gVar;
            gVar.W(new d());
            ActionMenuPresenter actionMenuPresenter = new ActionMenuPresenter(context);
            this.f١٢٠٩e = actionMenuPresenter;
            actionMenuPresenter.M(true);
            ActionMenuPresenter actionMenuPresenter2 = this.f١٢٠٩e;
            l.a aVar = this.f١٢١٠f;
            if (aVar == null) {
                aVar = new b();
            }
            actionMenuPresenter2.c(aVar);
            this.f١٢٠٥a.c(this.f١٢٠٩e, this.f١٢٠٦b);
            this.f١٢٠٩e.K(this);
        }
        return this.f١٢٠٥a;
    }

    public Drawable getOverflowIcon() {
        getMenu();
        return this.f١٢٠٩e.D();
    }

    public int getPopupTheme() {
        return this.f١٢٠٧c;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int getWindowAnimations() {
        return 0;
    }

    public void j() {
        ActionMenuPresenter actionMenuPresenter = this.f١٢٠٩e;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.B();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public c generateDefaultLayoutParams() {
        c cVar = new c(-2, -2);
        ((LinearLayout.LayoutParams) cVar).gravity = 16;
        return cVar;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public c generateLayoutParams(AttributeSet attributeSet) {
        return new c(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public c generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        c cVar;
        if (layoutParams != null) {
            if (layoutParams instanceof c) {
                cVar = new c((c) layoutParams);
            } else {
                cVar = new c(layoutParams);
            }
            if (((LinearLayout.LayoutParams) cVar).gravity <= 0) {
                ((LinearLayout.LayoutParams) cVar).gravity = 16;
            }
            return cVar;
        }
        return generateDefaultLayoutParams();
    }

    public c n() {
        c generateDefaultLayoutParams = generateDefaultLayoutParams();
        generateDefaultLayoutParams.f١٢١٧a = true;
        return generateDefaultLayoutParams;
    }

    protected boolean o(int i10) {
        boolean z10 = false;
        if (i10 == 0) {
            return false;
        }
        KeyEvent.Callback childAt = getChildAt(i10 - 1);
        KeyEvent.Callback childAt2 = getChildAt(i10);
        if (i10 < getChildCount() && (childAt instanceof a)) {
            z10 = ((a) childAt).c();
        }
        if (i10 > 0 && (childAt2 instanceof a)) {
            return z10 | ((a) childAt2).e();
        }
        return z10;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ActionMenuPresenter actionMenuPresenter = this.f١٢٠٩e;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.h(false);
            if (this.f١٢٠٩e.H()) {
                this.f١٢٠٩e.E();
                this.f١٢٠٩e.N();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        j();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int i14;
        int width;
        int i15;
        if (!this.f١٢١٢h) {
            super.onLayout(z10, i10, i11, i12, i13);
            return;
        }
        int childCount = getChildCount();
        int i16 = (i13 - i11) / 2;
        int dividerWidth = getDividerWidth();
        int i17 = i12 - i10;
        int paddingRight = (i17 - getPaddingRight()) - getPaddingLeft();
        boolean b10 = a1.b(this);
        int i18 = 0;
        int i19 = 0;
        for (int i20 = 0; i20 < childCount; i20++) {
            View childAt = getChildAt(i20);
            if (childAt.getVisibility() != 8) {
                c cVar = (c) childAt.getLayoutParams();
                if (cVar.f١٢١٧a) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    if (o(i20)) {
                        measuredWidth += dividerWidth;
                    }
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (b10) {
                        i15 = getPaddingLeft() + ((LinearLayout.LayoutParams) cVar).leftMargin;
                        width = i15 + measuredWidth;
                    } else {
                        width = (getWidth() - getPaddingRight()) - ((LinearLayout.LayoutParams) cVar).rightMargin;
                        i15 = width - measuredWidth;
                    }
                    int i21 = i16 - (measuredHeight / 2);
                    childAt.layout(i15, i21, width, measuredHeight + i21);
                    paddingRight -= measuredWidth;
                    i18 = 1;
                } else {
                    paddingRight -= (childAt.getMeasuredWidth() + ((LinearLayout.LayoutParams) cVar).leftMargin) + ((LinearLayout.LayoutParams) cVar).rightMargin;
                    o(i20);
                    i19++;
                }
            }
        }
        if (childCount == 1 && i18 == 0) {
            View childAt2 = getChildAt(0);
            int measuredWidth2 = childAt2.getMeasuredWidth();
            int measuredHeight2 = childAt2.getMeasuredHeight();
            int i22 = (i17 / 2) - (measuredWidth2 / 2);
            int i23 = i16 - (measuredHeight2 / 2);
            childAt2.layout(i22, i23, measuredWidth2 + i22, measuredHeight2 + i23);
            return;
        }
        int i24 = i19 - (i18 ^ 1);
        if (i24 > 0) {
            i14 = paddingRight / i24;
        } else {
            i14 = 0;
        }
        int max = Math.max(0, i14);
        if (b10) {
            int width2 = getWidth() - getPaddingRight();
            for (int i25 = 0; i25 < childCount; i25++) {
                View childAt3 = getChildAt(i25);
                c cVar2 = (c) childAt3.getLayoutParams();
                if (childAt3.getVisibility() != 8 && !cVar2.f١٢١٧a) {
                    int i26 = width2 - ((LinearLayout.LayoutParams) cVar2).rightMargin;
                    int measuredWidth3 = childAt3.getMeasuredWidth();
                    int measuredHeight3 = childAt3.getMeasuredHeight();
                    int i27 = i16 - (measuredHeight3 / 2);
                    childAt3.layout(i26 - measuredWidth3, i27, i26, measuredHeight3 + i27);
                    width2 = i26 - ((measuredWidth3 + ((LinearLayout.LayoutParams) cVar2).leftMargin) + max);
                }
            }
            return;
        }
        int paddingLeft = getPaddingLeft();
        for (int i28 = 0; i28 < childCount; i28++) {
            View childAt4 = getChildAt(i28);
            c cVar3 = (c) childAt4.getLayoutParams();
            if (childAt4.getVisibility() != 8 && !cVar3.f١٢١٧a) {
                int i29 = paddingLeft + ((LinearLayout.LayoutParams) cVar3).leftMargin;
                int measuredWidth4 = childAt4.getMeasuredWidth();
                int measuredHeight4 = childAt4.getMeasuredHeight();
                int i30 = i16 - (measuredHeight4 / 2);
                childAt4.layout(i29, i30, i29 + measuredWidth4, measuredHeight4 + i30);
                paddingLeft = i29 + measuredWidth4 + ((LinearLayout.LayoutParams) cVar3).rightMargin + max;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
    public void onMeasure(int i10, int i11) {
        boolean z10;
        androidx.appcompat.view.menu.g gVar;
        boolean z11 = this.f١٢١٢h;
        if (View.MeasureSpec.getMode(i10) == 1073741824) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.f١٢١٢h = z10;
        if (z11 != z10) {
            this.f١٢١٣i = 0;
        }
        int size = View.MeasureSpec.getSize(i10);
        if (this.f١٢١٢h && (gVar = this.f١٢٠٥a) != null && size != this.f١٢١٣i) {
            this.f١٢١٣i = size;
            gVar.N(true);
        }
        int childCount = getChildCount();
        if (this.f١٢١٢h && childCount > 0) {
            u(i10, i11);
            return;
        }
        for (int i12 = 0; i12 < childCount; i12++) {
            c cVar = (c) getChildAt(i12).getLayoutParams();
            ((LinearLayout.LayoutParams) cVar).rightMargin = 0;
            ((LinearLayout.LayoutParams) cVar).leftMargin = 0;
        }
        super.onMeasure(i10, i11);
    }

    public boolean p() {
        ActionMenuPresenter actionMenuPresenter = this.f١٢٠٩e;
        if (actionMenuPresenter != null && actionMenuPresenter.E()) {
            return true;
        }
        return false;
    }

    public boolean q() {
        ActionMenuPresenter actionMenuPresenter = this.f١٢٠٩e;
        if (actionMenuPresenter != null && actionMenuPresenter.G()) {
            return true;
        }
        return false;
    }

    public boolean r() {
        ActionMenuPresenter actionMenuPresenter = this.f١٢٠٩e;
        if (actionMenuPresenter != null && actionMenuPresenter.H()) {
            return true;
        }
        return false;
    }

    public boolean s() {
        return this.f١٢٠٨d;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setExpandedActionViewsExclusive(boolean z10) {
        this.f١٢٠٩e.J(z10);
    }

    public void setOnMenuItemClickListener(e eVar) {
        this.f١٢١٦l = eVar;
    }

    public void setOverflowIcon(Drawable drawable) {
        getMenu();
        this.f١٢٠٩e.L(drawable);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setOverflowReserved(boolean z10) {
        this.f١٢٠٨d = z10;
    }

    public void setPopupTheme(int i10) {
        if (this.f١٢٠٧c != i10) {
            this.f١٢٠٧c = i10;
            if (i10 == 0) {
                this.f١٢٠٦b = getContext();
            } else {
                this.f١٢٠٦b = new ContextThemeWrapper(getContext(), i10);
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setPresenter(ActionMenuPresenter actionMenuPresenter) {
        this.f١٢٠٩e = actionMenuPresenter;
        actionMenuPresenter.K(this);
    }

    public androidx.appcompat.view.menu.g v() {
        return this.f١٢٠٥a;
    }

    public void w(l.a aVar, g.a aVar2) {
        this.f١٢١٠f = aVar;
        this.f١٢١١g = aVar2;
    }

    public boolean x() {
        ActionMenuPresenter actionMenuPresenter = this.f١٢٠٩e;
        if (actionMenuPresenter != null && actionMenuPresenter.N()) {
            return true;
        }
        return false;
    }

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBaselineAligned(false);
        float f10 = context.getResources().getDisplayMetrics().density;
        this.f١٢١٤j = (int) (56.0f * f10);
        this.f١٢١٥k = (int) (f10 * 4.0f);
        this.f١٢٠٦b = context;
        this.f١٢٠٧c = 0;
    }
}
