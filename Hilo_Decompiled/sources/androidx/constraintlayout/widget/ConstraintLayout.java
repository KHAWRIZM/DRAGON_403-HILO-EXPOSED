package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import c2.d;
import c2.e;
import c2.h;
import c2.k;
import c2.m;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import d2.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class ConstraintLayout extends ViewGroup {
    private static final boolean DEBUG = false;
    private static final boolean DEBUG_DRAW_CONSTRAINTS = false;
    public static final int DESIGN_INFO_ID = 0;
    private static final boolean MEASURE = false;
    private static final boolean OPTIMIZE_HEIGHT_CHANGE = false;
    private static final String TAG = "ConstraintLayout";
    private static final boolean USE_CONSTRAINTS_HELPER = true;
    public static final String VERSION = "ConstraintLayout-2.1.4";
    private static e sSharedValues;
    SparseArray<View> mChildrenByIds;
    private ArrayList<ConstraintHelper> mConstraintHelpers;
    protected androidx.constraintlayout.widget.b mConstraintLayoutSpec;
    private androidx.constraintlayout.widget.c mConstraintSet;
    private int mConstraintSetId;
    private d mConstraintsChangedListener;
    private HashMap<String, Integer> mDesignIds;
    protected boolean mDirtyHierarchy;
    private int mLastMeasureHeight;
    int mLastMeasureHeightMode;
    int mLastMeasureHeightSize;
    private int mLastMeasureWidth;
    int mLastMeasureWidthMode;
    int mLastMeasureWidthSize;
    protected c2.f mLayoutWidget;
    private int mMaxHeight;
    private int mMaxWidth;
    c mMeasurer;
    private z1.e mMetrics;
    private int mMinHeight;
    private int mMinWidth;
    private int mOnMeasureHeightMeasureSpec;
    private int mOnMeasureWidthMeasureSpec;
    private int mOptimizationLevel;
    private SparseArray<c2.e> mTempMapIdToWidget;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f٢٢٩٧a;

        static {
            int[] iArr = new int[e.b.values().length];
            f٢٢٩٧a = iArr;
            try {
                iArr[e.b.FIXED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f٢٢٩٧a[e.b.WRAP_CONTENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f٢٢٩٧a[e.b.MATCH_PARENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f٢٢٩٧a[e.b.MATCH_CONSTRAINT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class c implements b.InterfaceC٠١٥٠b {

        /* renamed from: a, reason: collision with root package name */
        ConstraintLayout f٢٣٤٩a;

        /* renamed from: b, reason: collision with root package name */
        int f٢٣٥٠b;

        /* renamed from: c, reason: collision with root package name */
        int f٢٣٥١c;

        /* renamed from: d, reason: collision with root package name */
        int f٢٣٥٢d;

        /* renamed from: e, reason: collision with root package name */
        int f٢٣٥٣e;

        /* renamed from: f, reason: collision with root package name */
        int f٢٣٥٤f;

        /* renamed from: g, reason: collision with root package name */
        int f٢٣٥٥g;

        public c(ConstraintLayout constraintLayout) {
            this.f٢٣٤٩a = constraintLayout;
        }

        private boolean d(int i10, int i11, int i12) {
            if (i10 == i11) {
                return true;
            }
            int mode = View.MeasureSpec.getMode(i10);
            View.MeasureSpec.getSize(i10);
            int mode2 = View.MeasureSpec.getMode(i11);
            int size = View.MeasureSpec.getSize(i11);
            if (mode2 == 1073741824) {
                if ((mode == Integer.MIN_VALUE || mode == 0) && i12 == size) {
                    return true;
                }
                return false;
            }
            return false;
        }

        @Override // d2.b.InterfaceC٠١٥٠b
        public final void a() {
            int childCount = this.f٢٣٤٩a.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = this.f٢٣٤٩a.getChildAt(i10);
                if (childAt instanceof Placeholder) {
                    ((Placeholder) childAt).b(this.f٢٣٤٩a);
                }
            }
            int size = this.f٢٣٤٩a.mConstraintHelpers.size();
            if (size > 0) {
                for (int i11 = 0; i11 < size; i11++) {
                    ((ConstraintHelper) this.f٢٣٤٩a.mConstraintHelpers.get(i11)).r(this.f٢٣٤٩a);
                }
            }
        }

        @Override // d2.b.InterfaceC٠١٥٠b
        public final void b(c2.e eVar, b.a aVar) {
            int makeMeasureSpec;
            int makeMeasureSpec2;
            boolean z10;
            boolean z11;
            boolean z12;
            boolean z13;
            boolean z14;
            boolean z15;
            int baseline;
            int i10;
            int i11;
            int i12;
            int i13;
            int i14;
            boolean z16;
            boolean z17;
            boolean z18;
            boolean z19;
            boolean z20;
            boolean z21;
            if (eVar == null) {
                return;
            }
            if (eVar.X() == 8 && !eVar.l0()) {
                aVar.f١٣٥٥١e = 0;
                aVar.f١٣٥٥٢f = 0;
                aVar.f١٣٥٥٣g = 0;
                return;
            }
            if (eVar.M() == null) {
                return;
            }
            e.b bVar = aVar.f١٣٥٤٧a;
            e.b bVar2 = aVar.f١٣٥٤٨b;
            int i15 = aVar.f١٣٥٤٩c;
            int i16 = aVar.f١٣٥٥٠d;
            int i17 = this.f٢٣٥٠b + this.f٢٣٥١c;
            int i18 = this.f٢٣٥٢d;
            View view = (View) eVar.u();
            int[] iArr = a.f٢٢٩٧a;
            int i19 = iArr[bVar.ordinal()];
            if (i19 != 1) {
                if (i19 != 2) {
                    if (i19 != 3) {
                        if (i19 != 4) {
                            makeMeasureSpec = 0;
                        } else {
                            makeMeasureSpec = ViewGroup.getChildMeasureSpec(this.f٢٣٥٤f, i18, -2);
                            if (eVar.f٥٧٤٥w == 1) {
                                z20 = true;
                            } else {
                                z20 = false;
                            }
                            int i20 = aVar.f١٣٥٥٦j;
                            if (i20 == b.a.f١٣٥٤٥l || i20 == b.a.f١٣٥٤٦m) {
                                if (view.getMeasuredHeight() == eVar.z()) {
                                    z21 = true;
                                } else {
                                    z21 = false;
                                }
                                if (aVar.f١٣٥٥٦j == b.a.f١٣٥٤٦m || !z20 || ((z20 && z21) || (view instanceof Placeholder) || eVar.p0())) {
                                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(eVar.Y(), 1073741824);
                                }
                            }
                        }
                    } else {
                        makeMeasureSpec = ViewGroup.getChildMeasureSpec(this.f٢٣٥٤f, i18 + eVar.D(), -1);
                    }
                } else {
                    makeMeasureSpec = ViewGroup.getChildMeasureSpec(this.f٢٣٥٤f, i18, -2);
                }
            } else {
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i15, 1073741824);
            }
            int i21 = iArr[bVar2.ordinal()];
            if (i21 != 1) {
                if (i21 != 2) {
                    if (i21 != 3) {
                        if (i21 != 4) {
                            makeMeasureSpec2 = 0;
                        } else {
                            makeMeasureSpec2 = ViewGroup.getChildMeasureSpec(this.f٢٣٥٥g, i17, -2);
                            if (eVar.f٥٧٤٧x == 1) {
                                z18 = true;
                            } else {
                                z18 = false;
                            }
                            int i22 = aVar.f١٣٥٥٦j;
                            if (i22 == b.a.f١٣٥٤٥l || i22 == b.a.f١٣٥٤٦m) {
                                if (view.getMeasuredWidth() == eVar.Y()) {
                                    z19 = true;
                                } else {
                                    z19 = false;
                                }
                                if (aVar.f١٣٥٥٦j == b.a.f١٣٥٤٦m || !z18 || ((z18 && z19) || (view instanceof Placeholder) || eVar.q0())) {
                                    makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(eVar.z(), 1073741824);
                                }
                            }
                        }
                    } else {
                        makeMeasureSpec2 = ViewGroup.getChildMeasureSpec(this.f٢٣٥٥g, i17 + eVar.W(), -1);
                    }
                } else {
                    makeMeasureSpec2 = ViewGroup.getChildMeasureSpec(this.f٢٣٥٥g, i17, -2);
                }
            } else {
                makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i16, 1073741824);
            }
            c2.f fVar = (c2.f) eVar.M();
            if (fVar != null && k.b(ConstraintLayout.this.mOptimizationLevel, 256) && view.getMeasuredWidth() == eVar.Y() && view.getMeasuredWidth() < fVar.Y() && view.getMeasuredHeight() == eVar.z() && view.getMeasuredHeight() < fVar.z() && view.getBaseline() == eVar.r() && !eVar.o0() && d(eVar.E(), makeMeasureSpec, eVar.Y()) && d(eVar.F(), makeMeasureSpec2, eVar.z())) {
                aVar.f١٣٥٥١e = eVar.Y();
                aVar.f١٣٥٥٢f = eVar.z();
                aVar.f١٣٥٥٣g = eVar.r();
                return;
            }
            e.b bVar3 = e.b.MATCH_CONSTRAINT;
            if (bVar == bVar3) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (bVar2 == bVar3) {
                z11 = true;
            } else {
                z11 = false;
            }
            e.b bVar4 = e.b.MATCH_PARENT;
            if (bVar2 != bVar4 && bVar2 != e.b.FIXED) {
                z12 = false;
            } else {
                z12 = true;
            }
            if (bVar != bVar4 && bVar != e.b.FIXED) {
                z13 = false;
            } else {
                z13 = true;
            }
            if (z10 && eVar.f٥٧١٢f0 > DownloadProgress.UNKNOWN_PROGRESS) {
                z14 = true;
            } else {
                z14 = false;
            }
            if (z11 && eVar.f٥٧١٢f0 > DownloadProgress.UNKNOWN_PROGRESS) {
                z15 = true;
            } else {
                z15 = false;
            }
            if (view == null) {
                return;
            }
            b bVar5 = (b) view.getLayoutParams();
            int i23 = aVar.f١٣٥٥٦j;
            if (i23 != b.a.f١٣٥٤٥l && i23 != b.a.f١٣٥٤٦m && z10 && eVar.f٥٧٤٥w == 0 && z11 && eVar.f٥٧٤٧x == 0) {
                i14 = -1;
                i12 = 0;
                baseline = 0;
                i10 = 0;
            } else {
                if ((view instanceof VirtualLayout) && (eVar instanceof m)) {
                    ((VirtualLayout) view).w((m) eVar, makeMeasureSpec, makeMeasureSpec2);
                } else {
                    view.measure(makeMeasureSpec, makeMeasureSpec2);
                }
                eVar.Z0(makeMeasureSpec, makeMeasureSpec2);
                int measuredWidth = view.getMeasuredWidth();
                int measuredHeight = view.getMeasuredHeight();
                baseline = view.getBaseline();
                int i24 = eVar.f٥٧٥١z;
                if (i24 > 0) {
                    i10 = Math.max(i24, measuredWidth);
                } else {
                    i10 = measuredWidth;
                }
                int i25 = eVar.A;
                if (i25 > 0) {
                    i10 = Math.min(i25, i10);
                }
                int i26 = eVar.C;
                if (i26 > 0) {
                    i12 = Math.max(i26, measuredHeight);
                    i11 = makeMeasureSpec;
                } else {
                    i11 = makeMeasureSpec;
                    i12 = measuredHeight;
                }
                int i27 = eVar.D;
                if (i27 > 0) {
                    i12 = Math.min(i27, i12);
                }
                if (!k.b(ConstraintLayout.this.mOptimizationLevel, 1)) {
                    if (z14 && z12) {
                        i10 = (int) ((i12 * eVar.f٥٧١٢f0) + 0.5f);
                    } else if (z15 && z13) {
                        i12 = (int) ((i10 / eVar.f٥٧١٢f0) + 0.5f);
                    }
                }
                if (measuredWidth != i10 || measuredHeight != i12) {
                    if (measuredWidth != i10) {
                        i13 = View.MeasureSpec.makeMeasureSpec(i10, 1073741824);
                    } else {
                        i13 = i11;
                    }
                    if (measuredHeight != i12) {
                        makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i12, 1073741824);
                    }
                    view.measure(i13, makeMeasureSpec2);
                    eVar.Z0(i13, makeMeasureSpec2);
                    i10 = view.getMeasuredWidth();
                    i12 = view.getMeasuredHeight();
                    baseline = view.getBaseline();
                }
                i14 = -1;
            }
            if (baseline != i14) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (i10 == aVar.f١٣٥٤٩c && i12 == aVar.f١٣٥٥٠d) {
                z17 = false;
            } else {
                z17 = true;
            }
            aVar.f١٣٥٥٥i = z17;
            if (bVar5.f٢٣١٢g0) {
                z16 = true;
            }
            if (z16 && baseline != -1 && eVar.r() != baseline) {
                aVar.f١٣٥٥٥i = true;
            }
            aVar.f١٣٥٥١e = i10;
            aVar.f١٣٥٥٢f = i12;
            aVar.f١٣٥٥٤h = z16;
            aVar.f١٣٥٥٣g = baseline;
        }

        public void c(int i10, int i11, int i12, int i13, int i14, int i15) {
            this.f٢٣٥٠b = i12;
            this.f٢٣٥١c = i13;
            this.f٢٣٥٢d = i14;
            this.f٢٣٥٣e = i15;
            this.f٢٣٥٤f = i10;
            this.f٢٣٥٥g = i11;
        }
    }

    public ConstraintLayout(Context context) {
        super(context);
        this.mChildrenByIds = new SparseArray<>();
        this.mConstraintHelpers = new ArrayList<>(4);
        this.mLayoutWidget = new c2.f();
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        this.mMaxWidth = Integer.MAX_VALUE;
        this.mMaxHeight = Integer.MAX_VALUE;
        this.mDirtyHierarchy = true;
        this.mOptimizationLevel = 257;
        this.mConstraintSet = null;
        this.mConstraintLayoutSpec = null;
        this.mConstraintSetId = -1;
        this.mDesignIds = new HashMap<>();
        this.mLastMeasureWidth = -1;
        this.mLastMeasureHeight = -1;
        this.mLastMeasureWidthSize = -1;
        this.mLastMeasureHeightSize = -1;
        this.mLastMeasureWidthMode = 0;
        this.mLastMeasureHeightMode = 0;
        this.mTempMapIdToWidget = new SparseArray<>();
        this.mMeasurer = new c(this);
        this.mOnMeasureWidthMeasureSpec = 0;
        this.mOnMeasureHeightMeasureSpec = 0;
        e(null, 0, 0);
    }

    private final c2.e c(int i10) {
        if (i10 == 0) {
            return this.mLayoutWidget;
        }
        View view = this.mChildrenByIds.get(i10);
        if (view == null && (view = findViewById(i10)) != null && view != this && view.getParent() == this) {
            onViewAdded(view);
        }
        if (view == this) {
            return this.mLayoutWidget;
        }
        if (view == null) {
            return null;
        }
        return ((b) view.getLayoutParams()).f٢٣٤٢v0;
    }

    private void e(AttributeSet attributeSet, int i10, int i11) {
        this.mLayoutWidget.F0(this);
        this.mLayoutWidget.a2(this.mMeasurer);
        this.mChildrenByIds.put(getId(), this);
        this.mConstraintSet = null;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_Layout, i10, i11);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i12 = 0; i12 < indexCount; i12++) {
                int index = obtainStyledAttributes.getIndex(i12);
                if (index == R.styleable.ConstraintLayout_Layout_android_minWidth) {
                    this.mMinWidth = obtainStyledAttributes.getDimensionPixelOffset(index, this.mMinWidth);
                } else if (index == R.styleable.ConstraintLayout_Layout_android_minHeight) {
                    this.mMinHeight = obtainStyledAttributes.getDimensionPixelOffset(index, this.mMinHeight);
                } else if (index == R.styleable.ConstraintLayout_Layout_android_maxWidth) {
                    this.mMaxWidth = obtainStyledAttributes.getDimensionPixelOffset(index, this.mMaxWidth);
                } else if (index == R.styleable.ConstraintLayout_Layout_android_maxHeight) {
                    this.mMaxHeight = obtainStyledAttributes.getDimensionPixelOffset(index, this.mMaxHeight);
                } else if (index == R.styleable.ConstraintLayout_Layout_layout_optimizationLevel) {
                    this.mOptimizationLevel = obtainStyledAttributes.getInt(index, this.mOptimizationLevel);
                } else if (index == R.styleable.ConstraintLayout_Layout_layoutDescription) {
                    int resourceId = obtainStyledAttributes.getResourceId(index, 0);
                    if (resourceId != 0) {
                        try {
                            parseLayoutDescription(resourceId);
                        } catch (Resources.NotFoundException unused) {
                            this.mConstraintLayoutSpec = null;
                        }
                    }
                } else if (index == R.styleable.ConstraintLayout_Layout_constraintSet) {
                    int resourceId2 = obtainStyledAttributes.getResourceId(index, 0);
                    try {
                        androidx.constraintlayout.widget.c cVar = new androidx.constraintlayout.widget.c();
                        this.mConstraintSet = cVar;
                        cVar.D(getContext(), resourceId2);
                    } catch (Resources.NotFoundException unused2) {
                        this.mConstraintSet = null;
                    }
                    this.mConstraintSetId = resourceId2;
                }
            }
            obtainStyledAttributes.recycle();
        }
        this.mLayoutWidget.b2(this.mOptimizationLevel);
    }

    private void g() {
        this.mDirtyHierarchy = true;
        this.mLastMeasureWidth = -1;
        this.mLastMeasureHeight = -1;
        this.mLastMeasureWidthSize = -1;
        this.mLastMeasureHeightSize = -1;
        this.mLastMeasureWidthMode = 0;
        this.mLastMeasureHeightMode = 0;
    }

    private int getPaddingWidth() {
        int max = Math.max(0, getPaddingLeft()) + Math.max(0, getPaddingRight());
        int max2 = Math.max(0, getPaddingStart()) + Math.max(0, getPaddingEnd());
        if (max2 > 0) {
            return max2;
        }
        return max;
    }

    public static e getSharedValues() {
        if (sSharedValues == null) {
            sSharedValues = new e();
        }
        return sSharedValues;
    }

    private void k() {
        boolean isInEditMode = isInEditMode();
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            c2.e viewWidget = getViewWidget(getChildAt(i10));
            if (viewWidget != null) {
                viewWidget.v0();
            }
        }
        if (isInEditMode) {
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = getChildAt(i11);
                try {
                    String resourceName = getResources().getResourceName(childAt.getId());
                    setDesignInformation(0, resourceName, Integer.valueOf(childAt.getId()));
                    int indexOf = resourceName.indexOf(47);
                    if (indexOf != -1) {
                        resourceName = resourceName.substring(indexOf + 1);
                    }
                    c(childAt.getId()).G0(resourceName);
                } catch (Resources.NotFoundException unused) {
                }
            }
        }
        if (this.mConstraintSetId != -1) {
            for (int i12 = 0; i12 < childCount; i12++) {
                View childAt2 = getChildAt(i12);
                if (childAt2.getId() == this.mConstraintSetId && (childAt2 instanceof Constraints)) {
                    this.mConstraintSet = ((Constraints) childAt2).getConstraintSet();
                }
            }
        }
        androidx.constraintlayout.widget.c cVar = this.mConstraintSet;
        if (cVar != null) {
            cVar.k(this, true);
        }
        this.mLayoutWidget.y1();
        int size = this.mConstraintHelpers.size();
        if (size > 0) {
            for (int i13 = 0; i13 < size; i13++) {
                this.mConstraintHelpers.get(i13).t(this);
            }
        }
        for (int i14 = 0; i14 < childCount; i14++) {
            View childAt3 = getChildAt(i14);
            if (childAt3 instanceof Placeholder) {
                ((Placeholder) childAt3).c(this);
            }
        }
        this.mTempMapIdToWidget.clear();
        this.mTempMapIdToWidget.put(0, this.mLayoutWidget);
        this.mTempMapIdToWidget.put(getId(), this.mLayoutWidget);
        for (int i15 = 0; i15 < childCount; i15++) {
            View childAt4 = getChildAt(i15);
            this.mTempMapIdToWidget.put(childAt4.getId(), getViewWidget(childAt4));
        }
        for (int i16 = 0; i16 < childCount; i16++) {
            View childAt5 = getChildAt(i16);
            c2.e viewWidget2 = getViewWidget(childAt5);
            if (viewWidget2 != null) {
                b bVar = (b) childAt5.getLayoutParams();
                this.mLayoutWidget.a(viewWidget2);
                applyConstraintsFromLayoutParams(isInEditMode, childAt5, viewWidget2, bVar, this.mTempMapIdToWidget);
            }
        }
    }

    private void l(c2.e eVar, b bVar, SparseArray sparseArray, int i10, d.b bVar2) {
        View view = this.mChildrenByIds.get(i10);
        c2.e eVar2 = (c2.e) sparseArray.get(i10);
        if (eVar2 != null && view != null && (view.getLayoutParams() instanceof b)) {
            bVar.f٢٣١٢g0 = true;
            d.b bVar3 = d.b.BASELINE;
            if (bVar2 == bVar3) {
                b bVar4 = (b) view.getLayoutParams();
                bVar4.f٢٣١٢g0 = true;
                bVar4.f٢٣٤٢v0.O0(true);
            }
            eVar.q(bVar3).b(eVar2.q(bVar2), bVar.D, bVar.C, true);
            eVar.O0(true);
            eVar.q(d.b.TOP).q();
            eVar.q(d.b.BOTTOM).q();
        }
    }

    private boolean m() {
        int childCount = getChildCount();
        boolean z10 = false;
        int i10 = 0;
        while (true) {
            if (i10 >= childCount) {
                break;
            }
            if (getChildAt(i10).isLayoutRequested()) {
                z10 = true;
                break;
            }
            i10++;
        }
        if (z10) {
            k();
        }
        return z10;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void applyConstraintsFromLayoutParams(boolean z10, View view, c2.e eVar, b bVar, SparseArray<c2.e> sparseArray) {
        c2.e eVar2;
        c2.e eVar3;
        c2.e eVar4;
        c2.e eVar5;
        int i10;
        bVar.c();
        bVar.f٢٣٤٤w0 = false;
        eVar.n1(view.getVisibility());
        if (bVar.f٢٣١٨j0) {
            eVar.X0(true);
            eVar.n1(8);
        }
        eVar.F0(view);
        if (view instanceof ConstraintHelper) {
            ((ConstraintHelper) view).p(eVar, this.mLayoutWidget.U1());
        }
        if (bVar.f٢٣١٤h0) {
            h hVar = (h) eVar;
            int i11 = bVar.f٢٣٣٦s0;
            int i12 = bVar.f٢٣٣٨t0;
            float f10 = bVar.f٢٣٤٠u0;
            if (f10 != -1.0f) {
                hVar.D1(f10);
                return;
            } else if (i11 != -1) {
                hVar.B1(i11);
                return;
            } else {
                if (i12 != -1) {
                    hVar.C1(i12);
                    return;
                }
                return;
            }
        }
        int i13 = bVar.f٢٣٢٢l0;
        int i14 = bVar.f٢٣٢٤m0;
        int i15 = bVar.f٢٣٢٦n0;
        int i16 = bVar.f٢٣٢٨o0;
        int i17 = bVar.f٢٣٣٠p0;
        int i18 = bVar.f٢٣٣٢q0;
        float f11 = bVar.f٢٣٣٤r0;
        int i19 = bVar.f٢٣٢٩p;
        if (i19 != -1) {
            c2.e eVar6 = sparseArray.get(i19);
            if (eVar6 != null) {
                eVar.m(eVar6, bVar.f٢٣٣٣r, bVar.f٢٣٣١q);
            }
        } else {
            if (i13 != -1) {
                c2.e eVar7 = sparseArray.get(i13);
                if (eVar7 != null) {
                    d.b bVar2 = d.b.LEFT;
                    eVar.g0(bVar2, eVar7, bVar2, ((ViewGroup.MarginLayoutParams) bVar).leftMargin, i17);
                }
            } else if (i14 != -1 && (eVar2 = sparseArray.get(i14)) != null) {
                eVar.g0(d.b.LEFT, eVar2, d.b.RIGHT, ((ViewGroup.MarginLayoutParams) bVar).leftMargin, i17);
            }
            if (i15 != -1) {
                c2.e eVar8 = sparseArray.get(i15);
                if (eVar8 != null) {
                    eVar.g0(d.b.RIGHT, eVar8, d.b.LEFT, ((ViewGroup.MarginLayoutParams) bVar).rightMargin, i18);
                }
            } else if (i16 != -1 && (eVar3 = sparseArray.get(i16)) != null) {
                d.b bVar3 = d.b.RIGHT;
                eVar.g0(bVar3, eVar3, bVar3, ((ViewGroup.MarginLayoutParams) bVar).rightMargin, i18);
            }
            int i20 = bVar.f٢٣١٥i;
            if (i20 != -1) {
                c2.e eVar9 = sparseArray.get(i20);
                if (eVar9 != null) {
                    d.b bVar4 = d.b.TOP;
                    eVar.g0(bVar4, eVar9, bVar4, ((ViewGroup.MarginLayoutParams) bVar).topMargin, bVar.f٢٣٤٥x);
                }
            } else {
                int i21 = bVar.f٢٣١٧j;
                if (i21 != -1 && (eVar4 = sparseArray.get(i21)) != null) {
                    eVar.g0(d.b.TOP, eVar4, d.b.BOTTOM, ((ViewGroup.MarginLayoutParams) bVar).topMargin, bVar.f٢٣٤٥x);
                }
            }
            int i22 = bVar.f٢٣١٩k;
            if (i22 != -1) {
                c2.e eVar10 = sparseArray.get(i22);
                if (eVar10 != null) {
                    eVar.g0(d.b.BOTTOM, eVar10, d.b.TOP, ((ViewGroup.MarginLayoutParams) bVar).bottomMargin, bVar.f٢٣٤٧z);
                }
            } else {
                int i23 = bVar.f٢٣٢١l;
                if (i23 != -1 && (eVar5 = sparseArray.get(i23)) != null) {
                    d.b bVar5 = d.b.BOTTOM;
                    eVar.g0(bVar5, eVar5, bVar5, ((ViewGroup.MarginLayoutParams) bVar).bottomMargin, bVar.f٢٣٤٧z);
                }
            }
            int i24 = bVar.f٢٣٢٣m;
            if (i24 != -1) {
                l(eVar, bVar, sparseArray, i24, d.b.BASELINE);
            } else {
                int i25 = bVar.f٢٣٢٥n;
                if (i25 != -1) {
                    l(eVar, bVar, sparseArray, i25, d.b.TOP);
                } else {
                    int i26 = bVar.f٢٣٢٧o;
                    if (i26 != -1) {
                        l(eVar, bVar, sparseArray, i26, d.b.BOTTOM);
                    }
                }
            }
            if (f11 >= DownloadProgress.UNKNOWN_PROGRESS) {
                eVar.Q0(f11);
            }
            float f12 = bVar.H;
            if (f12 >= DownloadProgress.UNKNOWN_PROGRESS) {
                eVar.h1(f12);
            }
        }
        if (z10 && ((i10 = bVar.X) != -1 || bVar.Y != -1)) {
            eVar.f1(i10, bVar.Y);
        }
        if (!bVar.f٢٣٠٨e0) {
            if (((ViewGroup.MarginLayoutParams) bVar).width == -1) {
                if (bVar.f٢٣٠٠a0) {
                    eVar.T0(e.b.MATCH_CONSTRAINT);
                } else {
                    eVar.T0(e.b.MATCH_PARENT);
                }
                eVar.q(d.b.LEFT).f٥٦٨٦g = ((ViewGroup.MarginLayoutParams) bVar).leftMargin;
                eVar.q(d.b.RIGHT).f٥٦٨٦g = ((ViewGroup.MarginLayoutParams) bVar).rightMargin;
            } else {
                eVar.T0(e.b.MATCH_CONSTRAINT);
                eVar.o1(0);
            }
        } else {
            eVar.T0(e.b.FIXED);
            eVar.o1(((ViewGroup.MarginLayoutParams) bVar).width);
            if (((ViewGroup.MarginLayoutParams) bVar).width == -2) {
                eVar.T0(e.b.WRAP_CONTENT);
            }
        }
        if (!bVar.f٢٣١٠f0) {
            if (((ViewGroup.MarginLayoutParams) bVar).height == -1) {
                if (bVar.f٢٣٠٢b0) {
                    eVar.k1(e.b.MATCH_CONSTRAINT);
                } else {
                    eVar.k1(e.b.MATCH_PARENT);
                }
                eVar.q(d.b.TOP).f٥٦٨٦g = ((ViewGroup.MarginLayoutParams) bVar).topMargin;
                eVar.q(d.b.BOTTOM).f٥٦٨٦g = ((ViewGroup.MarginLayoutParams) bVar).bottomMargin;
            } else {
                eVar.k1(e.b.MATCH_CONSTRAINT);
                eVar.P0(0);
            }
        } else {
            eVar.k1(e.b.FIXED);
            eVar.P0(((ViewGroup.MarginLayoutParams) bVar).height);
            if (((ViewGroup.MarginLayoutParams) bVar).height == -2) {
                eVar.k1(e.b.WRAP_CONTENT);
            }
        }
        eVar.H0(bVar.I);
        eVar.V0(bVar.L);
        eVar.m1(bVar.M);
        eVar.R0(bVar.N);
        eVar.i1(bVar.O);
        eVar.p1(bVar.f٢٣٠٦d0);
        eVar.U0(bVar.P, bVar.R, bVar.T, bVar.V);
        eVar.l1(bVar.Q, bVar.S, bVar.U, bVar.W);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Object tag;
        int size;
        ArrayList<ConstraintHelper> arrayList = this.mConstraintHelpers;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            for (int i10 = 0; i10 < size; i10++) {
                this.mConstraintHelpers.get(i10).s(this);
            }
        }
        super.dispatchDraw(canvas);
        if (isInEditMode()) {
            float width = getWidth();
            float height = getHeight();
            int childCount = getChildCount();
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = getChildAt(i11);
                if (childAt.getVisibility() != 8 && (tag = childAt.getTag()) != null && (tag instanceof String)) {
                    String[] split = ((String) tag).split(",");
                    if (split.length == 4) {
                        int parseInt = Integer.parseInt(split[0]);
                        int parseInt2 = Integer.parseInt(split[1]);
                        int parseInt3 = Integer.parseInt(split[2]);
                        int i12 = (int) ((parseInt / 1080.0f) * width);
                        int i13 = (int) ((parseInt2 / 1920.0f) * height);
                        Paint paint = new Paint();
                        paint.setColor(-65536);
                        float f10 = i12;
                        float f11 = i13;
                        float f12 = i12 + ((int) ((parseInt3 / 1080.0f) * width));
                        canvas.drawLine(f10, f11, f12, f11, paint);
                        float parseInt4 = i13 + ((int) ((Integer.parseInt(split[3]) / 1920.0f) * height));
                        canvas.drawLine(f12, f11, f12, parseInt4, paint);
                        canvas.drawLine(f12, parseInt4, f10, parseInt4, paint);
                        canvas.drawLine(f10, parseInt4, f10, f11, paint);
                        paint.setColor(-16711936);
                        canvas.drawLine(f10, f11, f12, parseInt4, paint);
                        canvas.drawLine(f10, parseInt4, f12, f11, paint);
                    }
                }
            }
        }
    }

    public void fillMetrics(z1.e eVar) {
        this.mLayoutWidget.M1(eVar);
    }

    @Override // android.view.View
    public void forceLayout() {
        g();
        super.forceLayout();
    }

    public Object getDesignInformation(int i10, Object obj) {
        if (i10 == 0 && (obj instanceof String)) {
            String str = (String) obj;
            HashMap<String, Integer> hashMap = this.mDesignIds;
            if (hashMap != null && hashMap.containsKey(str)) {
                return this.mDesignIds.get(str);
            }
            return null;
        }
        return null;
    }

    public int getMaxHeight() {
        return this.mMaxHeight;
    }

    public int getMaxWidth() {
        return this.mMaxWidth;
    }

    public int getMinHeight() {
        return this.mMinHeight;
    }

    public int getMinWidth() {
        return this.mMinWidth;
    }

    public int getOptimizationLevel() {
        return this.mLayoutWidget.O1();
    }

    public String getSceneString() {
        int id;
        StringBuilder sb = new StringBuilder();
        if (this.mLayoutWidget.f٥٧٢٩o == null) {
            int id2 = getId();
            if (id2 != -1) {
                this.mLayoutWidget.f٥٧٢٩o = getContext().getResources().getResourceEntryName(id2);
            } else {
                this.mLayoutWidget.f٥٧٢٩o = "parent";
            }
        }
        if (this.mLayoutWidget.v() == null) {
            c2.f fVar = this.mLayoutWidget;
            fVar.G0(fVar.f٥٧٢٩o);
            Log.v(TAG, " setDebugName " + this.mLayoutWidget.v());
        }
        Iterator it = this.mLayoutWidget.v1().iterator();
        while (it.hasNext()) {
            c2.e eVar = (c2.e) it.next();
            View view = (View) eVar.u();
            if (view != null) {
                if (eVar.f٥٧٢٩o == null && (id = view.getId()) != -1) {
                    eVar.f٥٧٢٩o = getContext().getResources().getResourceEntryName(id);
                }
                if (eVar.v() == null) {
                    eVar.G0(eVar.f٥٧٢٩o);
                    Log.v(TAG, " setDebugName " + eVar.v());
                }
            }
        }
        this.mLayoutWidget.Q(sb);
        return sb.toString();
    }

    public View getViewById(int i10) {
        return this.mChildrenByIds.get(i10);
    }

    public final c2.e getViewWidget(View view) {
        if (view == this) {
            return this.mLayoutWidget;
        }
        if (view != null) {
            if (view.getLayoutParams() instanceof b) {
                return ((b) view.getLayoutParams()).f٢٣٤٢v0;
            }
            view.setLayoutParams(generateLayoutParams(view.getLayoutParams()));
            if (view.getLayoutParams() instanceof b) {
                return ((b) view.getLayoutParams()).f٢٣٤٢v0;
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isRtl() {
        if ((getContext().getApplicationInfo().flags & 4194304) != 0 && 1 == getLayoutDirection()) {
            return true;
        }
        return false;
    }

    public void loadLayoutDescription(int i10) {
        if (i10 != 0) {
            try {
                this.mConstraintLayoutSpec = new androidx.constraintlayout.widget.b(getContext(), this, i10);
                return;
            } catch (Resources.NotFoundException unused) {
                this.mConstraintLayoutSpec = null;
                return;
            }
        }
        this.mConstraintLayoutSpec = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        View content;
        int childCount = getChildCount();
        boolean isInEditMode = isInEditMode();
        for (int i14 = 0; i14 < childCount; i14++) {
            View childAt = getChildAt(i14);
            b bVar = (b) childAt.getLayoutParams();
            c2.e eVar = bVar.f٢٣٤٢v0;
            if ((childAt.getVisibility() != 8 || bVar.f٢٣١٤h0 || bVar.f٢٣١٦i0 || bVar.f٢٣٢٠k0 || isInEditMode) && !bVar.f٢٣١٨j0) {
                int Z = eVar.Z();
                int a02 = eVar.a0();
                int Y = eVar.Y() + Z;
                int z11 = eVar.z() + a02;
                childAt.layout(Z, a02, Y, z11);
                if ((childAt instanceof Placeholder) && (content = ((Placeholder) childAt).getContent()) != null) {
                    content.setVisibility(0);
                    content.layout(Z, a02, Y, z11);
                }
            }
        }
        int size = this.mConstraintHelpers.size();
        if (size > 0) {
            for (int i15 = 0; i15 < size; i15++) {
                this.mConstraintHelpers.get(i15).q(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        if (this.mOnMeasureWidthMeasureSpec == i10) {
            int i12 = this.mOnMeasureHeightMeasureSpec;
        }
        if (!this.mDirtyHierarchy) {
            int childCount = getChildCount();
            int i13 = 0;
            while (true) {
                if (i13 >= childCount) {
                    break;
                }
                if (getChildAt(i13).isLayoutRequested()) {
                    this.mDirtyHierarchy = true;
                    break;
                }
                i13++;
            }
        }
        this.mOnMeasureWidthMeasureSpec = i10;
        this.mOnMeasureHeightMeasureSpec = i11;
        this.mLayoutWidget.d2(isRtl());
        if (this.mDirtyHierarchy) {
            this.mDirtyHierarchy = false;
            if (m()) {
                this.mLayoutWidget.f2();
            }
        }
        resolveSystem(this.mLayoutWidget, this.mOptimizationLevel, i10, i11);
        resolveMeasuredDimension(i10, i11, this.mLayoutWidget.Y(), this.mLayoutWidget.z(), this.mLayoutWidget.V1(), this.mLayoutWidget.T1());
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        super.onViewAdded(view);
        c2.e viewWidget = getViewWidget(view);
        if ((view instanceof Guideline) && !(viewWidget instanceof h)) {
            b bVar = (b) view.getLayoutParams();
            h hVar = new h();
            bVar.f٢٣٤٢v0 = hVar;
            bVar.f٢٣١٤h0 = true;
            hVar.E1(bVar.Z);
        }
        if (view instanceof ConstraintHelper) {
            ConstraintHelper constraintHelper = (ConstraintHelper) view;
            constraintHelper.v();
            ((b) view.getLayoutParams()).f٢٣١٦i0 = true;
            if (!this.mConstraintHelpers.contains(constraintHelper)) {
                this.mConstraintHelpers.add(constraintHelper);
            }
        }
        this.mChildrenByIds.put(view.getId(), view);
        this.mDirtyHierarchy = true;
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        this.mChildrenByIds.remove(view.getId());
        this.mLayoutWidget.x1(getViewWidget(view));
        this.mConstraintHelpers.remove(view);
        this.mDirtyHierarchy = true;
    }

    protected void parseLayoutDescription(int i10) {
        this.mConstraintLayoutSpec = new androidx.constraintlayout.widget.b(getContext(), this, i10);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        g();
        super.requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void resolveMeasuredDimension(int i10, int i11, int i12, int i13, boolean z10, boolean z11) {
        c cVar = this.mMeasurer;
        int i14 = cVar.f٢٣٥٣e;
        int resolveSizeAndState = View.resolveSizeAndState(i12 + cVar.f٢٣٥٢d, i10, 0);
        int resolveSizeAndState2 = View.resolveSizeAndState(i13 + i14, i11, 0) & 16777215;
        int min = Math.min(this.mMaxWidth, resolveSizeAndState & 16777215);
        int min2 = Math.min(this.mMaxHeight, resolveSizeAndState2);
        if (z10) {
            min |= 16777216;
        }
        if (z11) {
            min2 |= 16777216;
        }
        setMeasuredDimension(min, min2);
        this.mLastMeasureWidth = min;
        this.mLastMeasureHeight = min2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void resolveSystem(c2.f fVar, int i10, int i11, int i12) {
        int i13;
        int mode = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i11);
        int mode2 = View.MeasureSpec.getMode(i12);
        int size2 = View.MeasureSpec.getSize(i12);
        int max = Math.max(0, getPaddingTop());
        int max2 = Math.max(0, getPaddingBottom());
        int i14 = max + max2;
        int paddingWidth = getPaddingWidth();
        this.mMeasurer.c(i11, i12, max, max2, paddingWidth, i14);
        int max3 = Math.max(0, getPaddingStart());
        int max4 = Math.max(0, getPaddingEnd());
        if (max3 <= 0 && max4 <= 0) {
            i13 = Math.max(0, getPaddingLeft());
        } else if (isRtl()) {
            i13 = max4;
        } else {
            i13 = max3;
        }
        int i15 = size - paddingWidth;
        int i16 = size2 - i14;
        setSelfDimensionBehaviour(fVar, mode, i15, mode2, i16);
        fVar.W1(i10, mode, i15, mode2, i16, this.mLastMeasureWidth, this.mLastMeasureHeight, i13, max);
    }

    public void setConstraintSet(androidx.constraintlayout.widget.c cVar) {
        this.mConstraintSet = cVar;
    }

    public void setDesignInformation(int i10, Object obj, Object obj2) {
        if (i10 == 0 && (obj instanceof String) && (obj2 instanceof Integer)) {
            if (this.mDesignIds == null) {
                this.mDesignIds = new HashMap<>();
            }
            String str = (String) obj;
            int indexOf = str.indexOf("/");
            if (indexOf != -1) {
                str = str.substring(indexOf + 1);
            }
            Integer num = (Integer) obj2;
            num.intValue();
            this.mDesignIds.put(str, num);
        }
    }

    @Override // android.view.View
    public void setId(int i10) {
        this.mChildrenByIds.remove(getId());
        super.setId(i10);
        this.mChildrenByIds.put(getId(), this);
    }

    public void setMaxHeight(int i10) {
        if (i10 == this.mMaxHeight) {
            return;
        }
        this.mMaxHeight = i10;
        requestLayout();
    }

    public void setMaxWidth(int i10) {
        if (i10 == this.mMaxWidth) {
            return;
        }
        this.mMaxWidth = i10;
        requestLayout();
    }

    public void setMinHeight(int i10) {
        if (i10 == this.mMinHeight) {
            return;
        }
        this.mMinHeight = i10;
        requestLayout();
    }

    public void setMinWidth(int i10) {
        if (i10 == this.mMinWidth) {
            return;
        }
        this.mMinWidth = i10;
        requestLayout();
    }

    public void setOnConstraintsChanged(d dVar) {
        androidx.constraintlayout.widget.b bVar = this.mConstraintLayoutSpec;
        if (bVar != null) {
            bVar.c(dVar);
        }
    }

    public void setOptimizationLevel(int i10) {
        this.mOptimizationLevel = i10;
        this.mLayoutWidget.b2(i10);
    }

    protected void setSelfDimensionBehaviour(c2.f fVar, int i10, int i11, int i12, int i13) {
        e.b bVar;
        c cVar = this.mMeasurer;
        int i14 = cVar.f٢٣٥٣e;
        int i15 = cVar.f٢٣٥٢d;
        e.b bVar2 = e.b.FIXED;
        int childCount = getChildCount();
        if (i10 != Integer.MIN_VALUE) {
            if (i10 != 0) {
                if (i10 != 1073741824) {
                    bVar = bVar2;
                    i11 = 0;
                } else {
                    i11 = Math.min(this.mMaxWidth - i15, i11);
                    bVar = bVar2;
                }
            } else {
                bVar = e.b.WRAP_CONTENT;
                if (childCount == 0) {
                    i11 = Math.max(0, this.mMinWidth);
                }
                i11 = 0;
            }
        } else {
            bVar = e.b.WRAP_CONTENT;
            if (childCount == 0) {
                i11 = Math.max(0, this.mMinWidth);
            }
        }
        if (i12 != Integer.MIN_VALUE) {
            if (i12 != 0) {
                if (i12 == 1073741824) {
                    i13 = Math.min(this.mMaxHeight - i14, i13);
                }
                i13 = 0;
            } else {
                bVar2 = e.b.WRAP_CONTENT;
                if (childCount == 0) {
                    i13 = Math.max(0, this.mMinHeight);
                }
                i13 = 0;
            }
        } else {
            bVar2 = e.b.WRAP_CONTENT;
            if (childCount == 0) {
                i13 = Math.max(0, this.mMinHeight);
            }
        }
        if (i11 != fVar.Y() || i13 != fVar.z()) {
            fVar.S1();
        }
        fVar.q1(0);
        fVar.r1(0);
        fVar.b1(this.mMaxWidth - i15);
        fVar.a1(this.mMaxHeight - i14);
        fVar.e1(0);
        fVar.d1(0);
        fVar.T0(bVar);
        fVar.o1(i11);
        fVar.k1(bVar2);
        fVar.P0(i13);
        fVar.e1(this.mMinWidth - i15);
        fVar.d1(this.mMinHeight - i14);
    }

    public void setState(int i10, int i11, int i12) {
        androidx.constraintlayout.widget.b bVar = this.mConstraintLayoutSpec;
        if (bVar != null) {
            bVar.d(i10, i11, i12);
        }
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public b generateDefaultLayoutParams() {
        return new b(-2, -2);
    }

    @Override // android.view.ViewGroup
    public b generateLayoutParams(AttributeSet attributeSet) {
        return new b(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new b(layoutParams);
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mChildrenByIds = new SparseArray<>();
        this.mConstraintHelpers = new ArrayList<>(4);
        this.mLayoutWidget = new c2.f();
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        this.mMaxWidth = Integer.MAX_VALUE;
        this.mMaxHeight = Integer.MAX_VALUE;
        this.mDirtyHierarchy = true;
        this.mOptimizationLevel = 257;
        this.mConstraintSet = null;
        this.mConstraintLayoutSpec = null;
        this.mConstraintSetId = -1;
        this.mDesignIds = new HashMap<>();
        this.mLastMeasureWidth = -1;
        this.mLastMeasureHeight = -1;
        this.mLastMeasureWidthSize = -1;
        this.mLastMeasureHeightSize = -1;
        this.mLastMeasureWidthMode = 0;
        this.mLastMeasureHeightMode = 0;
        this.mTempMapIdToWidget = new SparseArray<>();
        this.mMeasurer = new c(this);
        this.mOnMeasureWidthMeasureSpec = 0;
        this.mOnMeasureHeightMeasureSpec = 0;
        e(attributeSet, 0, 0);
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.mChildrenByIds = new SparseArray<>();
        this.mConstraintHelpers = new ArrayList<>(4);
        this.mLayoutWidget = new c2.f();
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        this.mMaxWidth = Integer.MAX_VALUE;
        this.mMaxHeight = Integer.MAX_VALUE;
        this.mDirtyHierarchy = true;
        this.mOptimizationLevel = 257;
        this.mConstraintSet = null;
        this.mConstraintLayoutSpec = null;
        this.mConstraintSetId = -1;
        this.mDesignIds = new HashMap<>();
        this.mLastMeasureWidth = -1;
        this.mLastMeasureHeight = -1;
        this.mLastMeasureWidthSize = -1;
        this.mLastMeasureHeightSize = -1;
        this.mLastMeasureWidthMode = 0;
        this.mLastMeasureHeightMode = 0;
        this.mTempMapIdToWidget = new SparseArray<>();
        this.mMeasurer = new c(this);
        this.mOnMeasureWidthMeasureSpec = 0;
        this.mOnMeasureHeightMeasureSpec = 0;
        e(attributeSet, i10, 0);
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.mChildrenByIds = new SparseArray<>();
        this.mConstraintHelpers = new ArrayList<>(4);
        this.mLayoutWidget = new c2.f();
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        this.mMaxWidth = Integer.MAX_VALUE;
        this.mMaxHeight = Integer.MAX_VALUE;
        this.mDirtyHierarchy = true;
        this.mOptimizationLevel = 257;
        this.mConstraintSet = null;
        this.mConstraintLayoutSpec = null;
        this.mConstraintSetId = -1;
        this.mDesignIds = new HashMap<>();
        this.mLastMeasureWidth = -1;
        this.mLastMeasureHeight = -1;
        this.mLastMeasureWidthSize = -1;
        this.mLastMeasureHeightSize = -1;
        this.mLastMeasureWidthMode = 0;
        this.mLastMeasureHeightMode = 0;
        this.mTempMapIdToWidget = new SparseArray<>();
        this.mMeasurer = new c(this);
        this.mOnMeasureWidthMeasureSpec = 0;
        this.mOnMeasureHeightMeasureSpec = 0;
        e(attributeSet, i10, i11);
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class b extends ViewGroup.MarginLayoutParams {
        public int A;

        /* renamed from: B, reason: collision with root package name */
        public int f٢٢٩٨B;
        public int C;
        public int D;
        boolean E;
        boolean F;
        public float G;
        public float H;
        public String I;
        float J;
        int K;
        public float L;
        public float M;
        public int N;
        public int O;
        public int P;
        public int Q;
        public int R;
        public int S;
        public int T;
        public int U;
        public float V;
        public float W;
        public int X;
        public int Y;
        public int Z;

        /* renamed from: a, reason: collision with root package name */
        public int f٢٢٩٩a;

        /* renamed from: a0, reason: collision with root package name */
        public boolean f٢٣٠٠a0;

        /* renamed from: b, reason: collision with root package name */
        public int f٢٣٠١b;

        /* renamed from: b0, reason: collision with root package name */
        public boolean f٢٣٠٢b0;

        /* renamed from: c, reason: collision with root package name */
        public float f٢٣٠٣c;

        /* renamed from: c0, reason: collision with root package name */
        public String f٢٣٠٤c0;

        /* renamed from: d, reason: collision with root package name */
        public boolean f٢٣٠٥d;

        /* renamed from: d0, reason: collision with root package name */
        public int f٢٣٠٦d0;

        /* renamed from: e, reason: collision with root package name */
        public int f٢٣٠٧e;

        /* renamed from: e0, reason: collision with root package name */
        boolean f٢٣٠٨e0;

        /* renamed from: f, reason: collision with root package name */
        public int f٢٣٠٩f;

        /* renamed from: f0, reason: collision with root package name */
        boolean f٢٣١٠f0;

        /* renamed from: g, reason: collision with root package name */
        public int f٢٣١١g;

        /* renamed from: g0, reason: collision with root package name */
        boolean f٢٣١٢g0;

        /* renamed from: h, reason: collision with root package name */
        public int f٢٣١٣h;

        /* renamed from: h0, reason: collision with root package name */
        boolean f٢٣١٤h0;

        /* renamed from: i, reason: collision with root package name */
        public int f٢٣١٥i;

        /* renamed from: i0, reason: collision with root package name */
        boolean f٢٣١٦i0;

        /* renamed from: j, reason: collision with root package name */
        public int f٢٣١٧j;

        /* renamed from: j0, reason: collision with root package name */
        boolean f٢٣١٨j0;

        /* renamed from: k, reason: collision with root package name */
        public int f٢٣١٩k;

        /* renamed from: k0, reason: collision with root package name */
        boolean f٢٣٢٠k0;

        /* renamed from: l, reason: collision with root package name */
        public int f٢٣٢١l;

        /* renamed from: l0, reason: collision with root package name */
        int f٢٣٢٢l0;

        /* renamed from: m, reason: collision with root package name */
        public int f٢٣٢٣m;

        /* renamed from: m0, reason: collision with root package name */
        int f٢٣٢٤m0;

        /* renamed from: n, reason: collision with root package name */
        public int f٢٣٢٥n;

        /* renamed from: n0, reason: collision with root package name */
        int f٢٣٢٦n0;

        /* renamed from: o, reason: collision with root package name */
        public int f٢٣٢٧o;

        /* renamed from: o0, reason: collision with root package name */
        int f٢٣٢٨o0;

        /* renamed from: p, reason: collision with root package name */
        public int f٢٣٢٩p;

        /* renamed from: p0, reason: collision with root package name */
        int f٢٣٣٠p0;

        /* renamed from: q, reason: collision with root package name */
        public int f٢٣٣١q;

        /* renamed from: q0, reason: collision with root package name */
        int f٢٣٣٢q0;

        /* renamed from: r, reason: collision with root package name */
        public float f٢٣٣٣r;

        /* renamed from: r0, reason: collision with root package name */
        float f٢٣٣٤r0;

        /* renamed from: s, reason: collision with root package name */
        public int f٢٣٣٥s;

        /* renamed from: s0, reason: collision with root package name */
        int f٢٣٣٦s0;

        /* renamed from: t, reason: collision with root package name */
        public int f٢٣٣٧t;

        /* renamed from: t0, reason: collision with root package name */
        int f٢٣٣٨t0;

        /* renamed from: u, reason: collision with root package name */
        public int f٢٣٣٩u;

        /* renamed from: u0, reason: collision with root package name */
        float f٢٣٤٠u0;

        /* renamed from: v, reason: collision with root package name */
        public int f٢٣٤١v;

        /* renamed from: v0, reason: collision with root package name */
        c2.e f٢٣٤٢v0;

        /* renamed from: w, reason: collision with root package name */
        public int f٢٣٤٣w;

        /* renamed from: w0, reason: collision with root package name */
        public boolean f٢٣٤٤w0;

        /* renamed from: x, reason: collision with root package name */
        public int f٢٣٤٥x;

        /* renamed from: y, reason: collision with root package name */
        public int f٢٣٤٦y;

        /* renamed from: z, reason: collision with root package name */
        public int f٢٣٤٧z;

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
        private static class a {

            /* renamed from: a, reason: collision with root package name */
            public static final SparseIntArray f٢٣٤٨a;

            static {
                SparseIntArray sparseIntArray = new SparseIntArray();
                f٢٣٤٨a = sparseIntArray;
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth, 64);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight, 65);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintLeft_toLeftOf, 8);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintLeft_toRightOf, 9);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintRight_toLeftOf, 10);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintRight_toRightOf, 11);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintTop_toTopOf, 12);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintTop_toBottomOf, 13);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintBottom_toTopOf, 14);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintBottom_toBottomOf, 15);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_toBaselineOf, 16);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_toTopOf, 52);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_toBottomOf, 53);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintCircle, 2);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintCircleRadius, 3);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintCircleAngle, 4);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_editor_absoluteX, 49);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_editor_absoluteY, 50);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintGuide_begin, 5);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintGuide_end, 6);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintGuide_percent, 7);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_guidelineUseRtl, 67);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_android_orientation, 1);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintStart_toEndOf, 17);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintStart_toStartOf, 18);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintEnd_toStartOf, 19);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintEnd_toEndOf, 20);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginLeft, 21);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginTop, 22);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginRight, 23);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginBottom, 24);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginStart, 25);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginEnd, 26);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginBaseline, 55);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_marginBaseline, 54);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_bias, 29);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintVertical_bias, 30);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintDimensionRatio, 44);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_weight, 45);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintVertical_weight, 46);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_chainStyle, 47);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintVertical_chainStyle, 48);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constrainedWidth, 27);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constrainedHeight, 28);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_default, 31);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_default, 32);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_min, 33);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_max, 34);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_percent, 35);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_min, 36);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_max, 37);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_percent, 38);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintLeft_creator, 39);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintTop_creator, 40);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintRight_creator, 41);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintBottom_creator, 42);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_creator, 43);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintTag, 51);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_wrapBehaviorInParent, 66);
            }
        }

        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f٢٢٩٩a = -1;
            this.f٢٣٠١b = -1;
            this.f٢٣٠٣c = -1.0f;
            this.f٢٣٠٥d = true;
            this.f٢٣٠٧e = -1;
            this.f٢٣٠٩f = -1;
            this.f٢٣١١g = -1;
            this.f٢٣١٣h = -1;
            this.f٢٣١٥i = -1;
            this.f٢٣١٧j = -1;
            this.f٢٣١٩k = -1;
            this.f٢٣٢١l = -1;
            this.f٢٣٢٣m = -1;
            this.f٢٣٢٥n = -1;
            this.f٢٣٢٧o = -1;
            this.f٢٣٢٩p = -1;
            this.f٢٣٣١q = 0;
            this.f٢٣٣٣r = DownloadProgress.UNKNOWN_PROGRESS;
            this.f٢٣٣٥s = -1;
            this.f٢٣٣٧t = -1;
            this.f٢٣٣٩u = -1;
            this.f٢٣٤١v = -1;
            this.f٢٣٤٣w = Integer.MIN_VALUE;
            this.f٢٣٤٥x = Integer.MIN_VALUE;
            this.f٢٣٤٦y = Integer.MIN_VALUE;
            this.f٢٣٤٧z = Integer.MIN_VALUE;
            this.A = Integer.MIN_VALUE;
            this.f٢٢٩٨B = Integer.MIN_VALUE;
            this.C = Integer.MIN_VALUE;
            this.D = 0;
            this.E = true;
            this.F = true;
            this.G = 0.5f;
            this.H = 0.5f;
            this.I = null;
            this.J = DownloadProgress.UNKNOWN_PROGRESS;
            this.K = 1;
            this.L = -1.0f;
            this.M = -1.0f;
            this.N = 0;
            this.O = 0;
            this.P = 0;
            this.Q = 0;
            this.R = 0;
            this.S = 0;
            this.T = 0;
            this.U = 0;
            this.V = 1.0f;
            this.W = 1.0f;
            this.X = -1;
            this.Y = -1;
            this.Z = -1;
            this.f٢٣٠٠a0 = false;
            this.f٢٣٠٢b0 = false;
            this.f٢٣٠٤c0 = null;
            this.f٢٣٠٦d0 = 0;
            this.f٢٣٠٨e0 = true;
            this.f٢٣١٠f0 = true;
            this.f٢٣١٢g0 = false;
            this.f٢٣١٤h0 = false;
            this.f٢٣١٦i0 = false;
            this.f٢٣١٨j0 = false;
            this.f٢٣٢٠k0 = false;
            this.f٢٣٢٢l0 = -1;
            this.f٢٣٢٤m0 = -1;
            this.f٢٣٢٦n0 = -1;
            this.f٢٣٢٨o0 = -1;
            this.f٢٣٣٠p0 = Integer.MIN_VALUE;
            this.f٢٣٣٢q0 = Integer.MIN_VALUE;
            this.f٢٣٣٤r0 = 0.5f;
            this.f٢٣٤٢v0 = new c2.e();
            this.f٢٣٤٤w0 = false;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = obtainStyledAttributes.getIndex(i10);
                int i11 = a.f٢٣٤٨a.get(index);
                switch (i11) {
                    case 1:
                        this.Z = obtainStyledAttributes.getInt(index, this.Z);
                        break;
                    case 2:
                        int resourceId = obtainStyledAttributes.getResourceId(index, this.f٢٣٢٩p);
                        this.f٢٣٢٩p = resourceId;
                        if (resourceId == -1) {
                            this.f٢٣٢٩p = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 3:
                        this.f٢٣٣١q = obtainStyledAttributes.getDimensionPixelSize(index, this.f٢٣٣١q);
                        break;
                    case 4:
                        float f10 = obtainStyledAttributes.getFloat(index, this.f٢٣٣٣r) % 360.0f;
                        this.f٢٣٣٣r = f10;
                        if (f10 < DownloadProgress.UNKNOWN_PROGRESS) {
                            this.f٢٣٣٣r = (360.0f - f10) % 360.0f;
                            break;
                        } else {
                            break;
                        }
                    case 5:
                        this.f٢٢٩٩a = obtainStyledAttributes.getDimensionPixelOffset(index, this.f٢٢٩٩a);
                        break;
                    case 6:
                        this.f٢٣٠١b = obtainStyledAttributes.getDimensionPixelOffset(index, this.f٢٣٠١b);
                        break;
                    case 7:
                        this.f٢٣٠٣c = obtainStyledAttributes.getFloat(index, this.f٢٣٠٣c);
                        break;
                    case 8:
                        int resourceId2 = obtainStyledAttributes.getResourceId(index, this.f٢٣٠٧e);
                        this.f٢٣٠٧e = resourceId2;
                        if (resourceId2 == -1) {
                            this.f٢٣٠٧e = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 9:
                        int resourceId3 = obtainStyledAttributes.getResourceId(index, this.f٢٣٠٩f);
                        this.f٢٣٠٩f = resourceId3;
                        if (resourceId3 == -1) {
                            this.f٢٣٠٩f = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 10:
                        int resourceId4 = obtainStyledAttributes.getResourceId(index, this.f٢٣١١g);
                        this.f٢٣١١g = resourceId4;
                        if (resourceId4 == -1) {
                            this.f٢٣١١g = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 11:
                        int resourceId5 = obtainStyledAttributes.getResourceId(index, this.f٢٣١٣h);
                        this.f٢٣١٣h = resourceId5;
                        if (resourceId5 == -1) {
                            this.f٢٣١٣h = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 12:
                        int resourceId6 = obtainStyledAttributes.getResourceId(index, this.f٢٣١٥i);
                        this.f٢٣١٥i = resourceId6;
                        if (resourceId6 == -1) {
                            this.f٢٣١٥i = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 13:
                        int resourceId7 = obtainStyledAttributes.getResourceId(index, this.f٢٣١٧j);
                        this.f٢٣١٧j = resourceId7;
                        if (resourceId7 == -1) {
                            this.f٢٣١٧j = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 14:
                        int resourceId8 = obtainStyledAttributes.getResourceId(index, this.f٢٣١٩k);
                        this.f٢٣١٩k = resourceId8;
                        if (resourceId8 == -1) {
                            this.f٢٣١٩k = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 15:
                        int resourceId9 = obtainStyledAttributes.getResourceId(index, this.f٢٣٢١l);
                        this.f٢٣٢١l = resourceId9;
                        if (resourceId9 == -1) {
                            this.f٢٣٢١l = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 16:
                        int resourceId10 = obtainStyledAttributes.getResourceId(index, this.f٢٣٢٣m);
                        this.f٢٣٢٣m = resourceId10;
                        if (resourceId10 == -1) {
                            this.f٢٣٢٣m = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 17:
                        int resourceId11 = obtainStyledAttributes.getResourceId(index, this.f٢٣٣٥s);
                        this.f٢٣٣٥s = resourceId11;
                        if (resourceId11 == -1) {
                            this.f٢٣٣٥s = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 18:
                        int resourceId12 = obtainStyledAttributes.getResourceId(index, this.f٢٣٣٧t);
                        this.f٢٣٣٧t = resourceId12;
                        if (resourceId12 == -1) {
                            this.f٢٣٣٧t = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 19:
                        int resourceId13 = obtainStyledAttributes.getResourceId(index, this.f٢٣٣٩u);
                        this.f٢٣٣٩u = resourceId13;
                        if (resourceId13 == -1) {
                            this.f٢٣٣٩u = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 20:
                        int resourceId14 = obtainStyledAttributes.getResourceId(index, this.f٢٣٤١v);
                        this.f٢٣٤١v = resourceId14;
                        if (resourceId14 == -1) {
                            this.f٢٣٤١v = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 21:
                        this.f٢٣٤٣w = obtainStyledAttributes.getDimensionPixelSize(index, this.f٢٣٤٣w);
                        break;
                    case 22:
                        this.f٢٣٤٥x = obtainStyledAttributes.getDimensionPixelSize(index, this.f٢٣٤٥x);
                        break;
                    case 23:
                        this.f٢٣٤٦y = obtainStyledAttributes.getDimensionPixelSize(index, this.f٢٣٤٦y);
                        break;
                    case 24:
                        this.f٢٣٤٧z = obtainStyledAttributes.getDimensionPixelSize(index, this.f٢٣٤٧z);
                        break;
                    case 25:
                        this.A = obtainStyledAttributes.getDimensionPixelSize(index, this.A);
                        break;
                    case 26:
                        this.f٢٢٩٨B = obtainStyledAttributes.getDimensionPixelSize(index, this.f٢٢٩٨B);
                        break;
                    case 27:
                        this.f٢٣٠٠a0 = obtainStyledAttributes.getBoolean(index, this.f٢٣٠٠a0);
                        break;
                    case 28:
                        this.f٢٣٠٢b0 = obtainStyledAttributes.getBoolean(index, this.f٢٣٠٢b0);
                        break;
                    case 29:
                        this.G = obtainStyledAttributes.getFloat(index, this.G);
                        break;
                    case 30:
                        this.H = obtainStyledAttributes.getFloat(index, this.H);
                        break;
                    case 31:
                        int i12 = obtainStyledAttributes.getInt(index, 0);
                        this.P = i12;
                        if (i12 == 1) {
                            Log.e(ConstraintLayout.TAG, "layout_constraintWidth_default=\"wrap\" is deprecated.\nUse layout_width=\"WRAP_CONTENT\" and layout_constrainedWidth=\"true\" instead.");
                            break;
                        } else {
                            break;
                        }
                    case 32:
                        int i13 = obtainStyledAttributes.getInt(index, 0);
                        this.Q = i13;
                        if (i13 == 1) {
                            Log.e(ConstraintLayout.TAG, "layout_constraintHeight_default=\"wrap\" is deprecated.\nUse layout_height=\"WRAP_CONTENT\" and layout_constrainedHeight=\"true\" instead.");
                            break;
                        } else {
                            break;
                        }
                    case 33:
                        try {
                            this.R = obtainStyledAttributes.getDimensionPixelSize(index, this.R);
                            break;
                        } catch (Exception unused) {
                            if (obtainStyledAttributes.getInt(index, this.R) == -2) {
                                this.R = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 34:
                        try {
                            this.T = obtainStyledAttributes.getDimensionPixelSize(index, this.T);
                            break;
                        } catch (Exception unused2) {
                            if (obtainStyledAttributes.getInt(index, this.T) == -2) {
                                this.T = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 35:
                        this.V = Math.max(DownloadProgress.UNKNOWN_PROGRESS, obtainStyledAttributes.getFloat(index, this.V));
                        this.P = 2;
                        break;
                    case 36:
                        try {
                            this.S = obtainStyledAttributes.getDimensionPixelSize(index, this.S);
                            break;
                        } catch (Exception unused3) {
                            if (obtainStyledAttributes.getInt(index, this.S) == -2) {
                                this.S = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 37:
                        try {
                            this.U = obtainStyledAttributes.getDimensionPixelSize(index, this.U);
                            break;
                        } catch (Exception unused4) {
                            if (obtainStyledAttributes.getInt(index, this.U) == -2) {
                                this.U = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 38:
                        this.W = Math.max(DownloadProgress.UNKNOWN_PROGRESS, obtainStyledAttributes.getFloat(index, this.W));
                        this.Q = 2;
                        break;
                    default:
                        switch (i11) {
                            case 44:
                                androidx.constraintlayout.widget.c.I(this, obtainStyledAttributes.getString(index));
                                break;
                            case 45:
                                this.L = obtainStyledAttributes.getFloat(index, this.L);
                                break;
                            case 46:
                                this.M = obtainStyledAttributes.getFloat(index, this.M);
                                break;
                            case 47:
                                this.N = obtainStyledAttributes.getInt(index, 0);
                                break;
                            case 48:
                                this.O = obtainStyledAttributes.getInt(index, 0);
                                break;
                            case 49:
                                this.X = obtainStyledAttributes.getDimensionPixelOffset(index, this.X);
                                break;
                            case 50:
                                this.Y = obtainStyledAttributes.getDimensionPixelOffset(index, this.Y);
                                break;
                            case 51:
                                this.f٢٣٠٤c0 = obtainStyledAttributes.getString(index);
                                break;
                            case 52:
                                int resourceId15 = obtainStyledAttributes.getResourceId(index, this.f٢٣٢٥n);
                                this.f٢٣٢٥n = resourceId15;
                                if (resourceId15 == -1) {
                                    this.f٢٣٢٥n = obtainStyledAttributes.getInt(index, -1);
                                    break;
                                } else {
                                    break;
                                }
                            case 53:
                                int resourceId16 = obtainStyledAttributes.getResourceId(index, this.f٢٣٢٧o);
                                this.f٢٣٢٧o = resourceId16;
                                if (resourceId16 == -1) {
                                    this.f٢٣٢٧o = obtainStyledAttributes.getInt(index, -1);
                                    break;
                                } else {
                                    break;
                                }
                            case 54:
                                this.D = obtainStyledAttributes.getDimensionPixelSize(index, this.D);
                                break;
                            case 55:
                                this.C = obtainStyledAttributes.getDimensionPixelSize(index, this.C);
                                break;
                            default:
                                switch (i11) {
                                    case 64:
                                        androidx.constraintlayout.widget.c.G(this, obtainStyledAttributes, index, 0);
                                        this.E = true;
                                        break;
                                    case 65:
                                        androidx.constraintlayout.widget.c.G(this, obtainStyledAttributes, index, 1);
                                        this.F = true;
                                        break;
                                    case 66:
                                        this.f٢٣٠٦d0 = obtainStyledAttributes.getInt(index, this.f٢٣٠٦d0);
                                        break;
                                    case 67:
                                        this.f٢٣٠٥d = obtainStyledAttributes.getBoolean(index, this.f٢٣٠٥d);
                                        break;
                                }
                        }
                }
            }
            obtainStyledAttributes.recycle();
            c();
        }

        public String a() {
            return this.f٢٣٠٤c0;
        }

        public c2.e b() {
            return this.f٢٣٤٢v0;
        }

        public void c() {
            this.f٢٣١٤h0 = false;
            this.f٢٣٠٨e0 = true;
            this.f٢٣١٠f0 = true;
            int i10 = ((ViewGroup.MarginLayoutParams) this).width;
            if (i10 == -2 && this.f٢٣٠٠a0) {
                this.f٢٣٠٨e0 = false;
                if (this.P == 0) {
                    this.P = 1;
                }
            }
            int i11 = ((ViewGroup.MarginLayoutParams) this).height;
            if (i11 == -2 && this.f٢٣٠٢b0) {
                this.f٢٣١٠f0 = false;
                if (this.Q == 0) {
                    this.Q = 1;
                }
            }
            if (i10 == 0 || i10 == -1) {
                this.f٢٣٠٨e0 = false;
                if (i10 == 0 && this.P == 1) {
                    ((ViewGroup.MarginLayoutParams) this).width = -2;
                    this.f٢٣٠٠a0 = true;
                }
            }
            if (i11 == 0 || i11 == -1) {
                this.f٢٣١٠f0 = false;
                if (i11 == 0 && this.Q == 1) {
                    ((ViewGroup.MarginLayoutParams) this).height = -2;
                    this.f٢٣٠٢b0 = true;
                }
            }
            if (this.f٢٣٠٣c != -1.0f || this.f٢٢٩٩a != -1 || this.f٢٣٠١b != -1) {
                this.f٢٣١٤h0 = true;
                this.f٢٣٠٨e0 = true;
                this.f٢٣١٠f0 = true;
                if (!(this.f٢٣٤٢v0 instanceof h)) {
                    this.f٢٣٤٢v0 = new h();
                }
                ((h) this.f٢٣٤٢v0).E1(this.Z);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x004a  */
        /* JADX WARN: Removed duplicated region for block: B:15:0x0051  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0058  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x005e  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x0064  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x007a  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x0082  */
        @Override // android.view.ViewGroup.MarginLayoutParams, android.view.ViewGroup.LayoutParams
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void resolveLayoutDirection(int i10) {
            boolean z10;
            int i11;
            int i12;
            int i13;
            int i14;
            int i15 = ((ViewGroup.MarginLayoutParams) this).leftMargin;
            int i16 = ((ViewGroup.MarginLayoutParams) this).rightMargin;
            super.resolveLayoutDirection(i10);
            boolean z11 = false;
            if (1 == getLayoutDirection()) {
                z10 = true;
            } else {
                z10 = false;
            }
            this.f٢٣٢٦n0 = -1;
            this.f٢٣٢٨o0 = -1;
            this.f٢٣٢٢l0 = -1;
            this.f٢٣٢٤m0 = -1;
            this.f٢٣٣٠p0 = this.f٢٣٤٣w;
            this.f٢٣٣٢q0 = this.f٢٣٤٦y;
            float f10 = this.G;
            this.f٢٣٣٤r0 = f10;
            int i17 = this.f٢٢٩٩a;
            this.f٢٣٣٦s0 = i17;
            int i18 = this.f٢٣٠١b;
            this.f٢٣٣٨t0 = i18;
            float f11 = this.f٢٣٠٣c;
            this.f٢٣٤٠u0 = f11;
            if (z10) {
                int i19 = this.f٢٣٣٥s;
                if (i19 != -1) {
                    this.f٢٣٢٦n0 = i19;
                } else {
                    int i20 = this.f٢٣٣٧t;
                    if (i20 != -1) {
                        this.f٢٣٢٨o0 = i20;
                    }
                    i11 = this.f٢٣٣٩u;
                    if (i11 != -1) {
                        this.f٢٣٢٤m0 = i11;
                        z11 = true;
                    }
                    i12 = this.f٢٣٤١v;
                    if (i12 != -1) {
                        this.f٢٣٢٢l0 = i12;
                        z11 = true;
                    }
                    i13 = this.A;
                    if (i13 != Integer.MIN_VALUE) {
                        this.f٢٣٣٢q0 = i13;
                    }
                    i14 = this.f٢٢٩٨B;
                    if (i14 != Integer.MIN_VALUE) {
                        this.f٢٣٣٠p0 = i14;
                    }
                    if (z11) {
                        this.f٢٣٣٤r0 = 1.0f - f10;
                    }
                    if (this.f٢٣١٤h0 && this.Z == 1 && this.f٢٣٠٥d) {
                        if (f11 == -1.0f) {
                            this.f٢٣٤٠u0 = 1.0f - f11;
                            this.f٢٣٣٦s0 = -1;
                            this.f٢٣٣٨t0 = -1;
                        } else if (i17 != -1) {
                            this.f٢٣٣٨t0 = i17;
                            this.f٢٣٣٦s0 = -1;
                            this.f٢٣٤٠u0 = -1.0f;
                        } else if (i18 != -1) {
                            this.f٢٣٣٦s0 = i18;
                            this.f٢٣٣٨t0 = -1;
                            this.f٢٣٤٠u0 = -1.0f;
                        }
                    }
                }
                z11 = true;
                i11 = this.f٢٣٣٩u;
                if (i11 != -1) {
                }
                i12 = this.f٢٣٤١v;
                if (i12 != -1) {
                }
                i13 = this.A;
                if (i13 != Integer.MIN_VALUE) {
                }
                i14 = this.f٢٢٩٨B;
                if (i14 != Integer.MIN_VALUE) {
                }
                if (z11) {
                }
                if (this.f٢٣١٤h0) {
                    if (f11 == -1.0f) {
                    }
                }
            } else {
                int i21 = this.f٢٣٣٥s;
                if (i21 != -1) {
                    this.f٢٣٢٤m0 = i21;
                }
                int i22 = this.f٢٣٣٧t;
                if (i22 != -1) {
                    this.f٢٣٢٢l0 = i22;
                }
                int i23 = this.f٢٣٣٩u;
                if (i23 != -1) {
                    this.f٢٣٢٦n0 = i23;
                }
                int i24 = this.f٢٣٤١v;
                if (i24 != -1) {
                    this.f٢٣٢٨o0 = i24;
                }
                int i25 = this.A;
                if (i25 != Integer.MIN_VALUE) {
                    this.f٢٣٣٠p0 = i25;
                }
                int i26 = this.f٢٢٩٨B;
                if (i26 != Integer.MIN_VALUE) {
                    this.f٢٣٣٢q0 = i26;
                }
            }
            if (this.f٢٣٣٩u == -1 && this.f٢٣٤١v == -1 && this.f٢٣٣٧t == -1 && this.f٢٣٣٥s == -1) {
                int i27 = this.f٢٣١١g;
                if (i27 != -1) {
                    this.f٢٣٢٦n0 = i27;
                    if (((ViewGroup.MarginLayoutParams) this).rightMargin <= 0 && i16 > 0) {
                        ((ViewGroup.MarginLayoutParams) this).rightMargin = i16;
                    }
                } else {
                    int i28 = this.f٢٣١٣h;
                    if (i28 != -1) {
                        this.f٢٣٢٨o0 = i28;
                        if (((ViewGroup.MarginLayoutParams) this).rightMargin <= 0 && i16 > 0) {
                            ((ViewGroup.MarginLayoutParams) this).rightMargin = i16;
                        }
                    }
                }
                int i29 = this.f٢٣٠٧e;
                if (i29 != -1) {
                    this.f٢٣٢٢l0 = i29;
                    if (((ViewGroup.MarginLayoutParams) this).leftMargin <= 0 && i15 > 0) {
                        ((ViewGroup.MarginLayoutParams) this).leftMargin = i15;
                        return;
                    }
                    return;
                }
                int i30 = this.f٢٣٠٩f;
                if (i30 != -1) {
                    this.f٢٣٢٤m0 = i30;
                    if (((ViewGroup.MarginLayoutParams) this).leftMargin <= 0 && i15 > 0) {
                        ((ViewGroup.MarginLayoutParams) this).leftMargin = i15;
                    }
                }
            }
        }

        public b(int i10, int i11) {
            super(i10, i11);
            this.f٢٢٩٩a = -1;
            this.f٢٣٠١b = -1;
            this.f٢٣٠٣c = -1.0f;
            this.f٢٣٠٥d = true;
            this.f٢٣٠٧e = -1;
            this.f٢٣٠٩f = -1;
            this.f٢٣١١g = -1;
            this.f٢٣١٣h = -1;
            this.f٢٣١٥i = -1;
            this.f٢٣١٧j = -1;
            this.f٢٣١٩k = -1;
            this.f٢٣٢١l = -1;
            this.f٢٣٢٣m = -1;
            this.f٢٣٢٥n = -1;
            this.f٢٣٢٧o = -1;
            this.f٢٣٢٩p = -1;
            this.f٢٣٣١q = 0;
            this.f٢٣٣٣r = DownloadProgress.UNKNOWN_PROGRESS;
            this.f٢٣٣٥s = -1;
            this.f٢٣٣٧t = -1;
            this.f٢٣٣٩u = -1;
            this.f٢٣٤١v = -1;
            this.f٢٣٤٣w = Integer.MIN_VALUE;
            this.f٢٣٤٥x = Integer.MIN_VALUE;
            this.f٢٣٤٦y = Integer.MIN_VALUE;
            this.f٢٣٤٧z = Integer.MIN_VALUE;
            this.A = Integer.MIN_VALUE;
            this.f٢٢٩٨B = Integer.MIN_VALUE;
            this.C = Integer.MIN_VALUE;
            this.D = 0;
            this.E = true;
            this.F = true;
            this.G = 0.5f;
            this.H = 0.5f;
            this.I = null;
            this.J = DownloadProgress.UNKNOWN_PROGRESS;
            this.K = 1;
            this.L = -1.0f;
            this.M = -1.0f;
            this.N = 0;
            this.O = 0;
            this.P = 0;
            this.Q = 0;
            this.R = 0;
            this.S = 0;
            this.T = 0;
            this.U = 0;
            this.V = 1.0f;
            this.W = 1.0f;
            this.X = -1;
            this.Y = -1;
            this.Z = -1;
            this.f٢٣٠٠a0 = false;
            this.f٢٣٠٢b0 = false;
            this.f٢٣٠٤c0 = null;
            this.f٢٣٠٦d0 = 0;
            this.f٢٣٠٨e0 = true;
            this.f٢٣١٠f0 = true;
            this.f٢٣١٢g0 = false;
            this.f٢٣١٤h0 = false;
            this.f٢٣١٦i0 = false;
            this.f٢٣١٨j0 = false;
            this.f٢٣٢٠k0 = false;
            this.f٢٣٢٢l0 = -1;
            this.f٢٣٢٤m0 = -1;
            this.f٢٣٢٦n0 = -1;
            this.f٢٣٢٨o0 = -1;
            this.f٢٣٣٠p0 = Integer.MIN_VALUE;
            this.f٢٣٣٢q0 = Integer.MIN_VALUE;
            this.f٢٣٣٤r0 = 0.5f;
            this.f٢٣٤٢v0 = new c2.e();
            this.f٢٣٤٤w0 = false;
        }

        public b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f٢٢٩٩a = -1;
            this.f٢٣٠١b = -1;
            this.f٢٣٠٣c = -1.0f;
            this.f٢٣٠٥d = true;
            this.f٢٣٠٧e = -1;
            this.f٢٣٠٩f = -1;
            this.f٢٣١١g = -1;
            this.f٢٣١٣h = -1;
            this.f٢٣١٥i = -1;
            this.f٢٣١٧j = -1;
            this.f٢٣١٩k = -1;
            this.f٢٣٢١l = -1;
            this.f٢٣٢٣m = -1;
            this.f٢٣٢٥n = -1;
            this.f٢٣٢٧o = -1;
            this.f٢٣٢٩p = -1;
            this.f٢٣٣١q = 0;
            this.f٢٣٣٣r = DownloadProgress.UNKNOWN_PROGRESS;
            this.f٢٣٣٥s = -1;
            this.f٢٣٣٧t = -1;
            this.f٢٣٣٩u = -1;
            this.f٢٣٤١v = -1;
            this.f٢٣٤٣w = Integer.MIN_VALUE;
            this.f٢٣٤٥x = Integer.MIN_VALUE;
            this.f٢٣٤٦y = Integer.MIN_VALUE;
            this.f٢٣٤٧z = Integer.MIN_VALUE;
            this.A = Integer.MIN_VALUE;
            this.f٢٢٩٨B = Integer.MIN_VALUE;
            this.C = Integer.MIN_VALUE;
            this.D = 0;
            this.E = true;
            this.F = true;
            this.G = 0.5f;
            this.H = 0.5f;
            this.I = null;
            this.J = DownloadProgress.UNKNOWN_PROGRESS;
            this.K = 1;
            this.L = -1.0f;
            this.M = -1.0f;
            this.N = 0;
            this.O = 0;
            this.P = 0;
            this.Q = 0;
            this.R = 0;
            this.S = 0;
            this.T = 0;
            this.U = 0;
            this.V = 1.0f;
            this.W = 1.0f;
            this.X = -1;
            this.Y = -1;
            this.Z = -1;
            this.f٢٣٠٠a0 = false;
            this.f٢٣٠٢b0 = false;
            this.f٢٣٠٤c0 = null;
            this.f٢٣٠٦d0 = 0;
            this.f٢٣٠٨e0 = true;
            this.f٢٣١٠f0 = true;
            this.f٢٣١٢g0 = false;
            this.f٢٣١٤h0 = false;
            this.f٢٣١٦i0 = false;
            this.f٢٣١٨j0 = false;
            this.f٢٣٢٠k0 = false;
            this.f٢٣٢٢l0 = -1;
            this.f٢٣٢٤m0 = -1;
            this.f٢٣٢٦n0 = -1;
            this.f٢٣٢٨o0 = -1;
            this.f٢٣٣٠p0 = Integer.MIN_VALUE;
            this.f٢٣٣٢q0 = Integer.MIN_VALUE;
            this.f٢٣٣٤r0 = 0.5f;
            this.f٢٣٤٢v0 = new c2.e();
            this.f٢٣٤٤w0 = false;
        }
    }
}
