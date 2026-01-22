package androidx.viewpager.widget;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.Scroller;
import androidx.core.view.d1;
import androidx.core.view.d2;
import androidx.core.view.j0;
import androidx.customview.view.AbsSavedState;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import kotlin.KotlinVersion;
import m2.g0;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class ViewPager extends ViewGroup {
    private static final int CLOSE_ENOUGH = 2;
    private static final boolean DEBUG = false;
    private static final int DEFAULT_GUTTER_SIZE = 16;
    private static final int DEFAULT_OFFSCREEN_PAGES = 1;
    private static final int DRAW_ORDER_DEFAULT = 0;
    private static final int DRAW_ORDER_FORWARD = 1;
    private static final int DRAW_ORDER_REVERSE = 2;
    private static final int INVALID_POINTER = -1;
    private static final int MAX_SETTLE_DURATION = 600;
    private static final int MIN_DISTANCE_FOR_FLING = 25;
    private static final int MIN_FLING_VELOCITY = 400;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    private static final String TAG = "ViewPager";
    private static final boolean USE_CACHE = false;
    private int mActivePointerId;
    androidx.viewpager.widget.a mAdapter;
    private List<i> mAdapterChangeListeners;
    private int mBottomPageBounds;
    private boolean mCalledSuper;
    private int mChildHeightMeasureSpec;
    private int mChildWidthMeasureSpec;
    private int mCloseEnough;
    int mCurItem;
    private int mDecorChildCount;
    private int mDefaultGutterSize;
    private int mDrawingOrder;
    private ArrayList<View> mDrawingOrderedChildren;
    private final Runnable mEndScrollRunnable;
    private int mExpectedAdapterCount;
    private long mFakeDragBeginTime;
    private boolean mFakeDragging;
    private boolean mFirstLayout;
    private float mFirstOffset;
    private int mFlingDistance;
    private int mGutterSize;
    private boolean mInLayout;
    private float mInitialMotionX;
    private float mInitialMotionY;
    private j mInternalPageChangeListener;
    private boolean mIsBeingDragged;
    private boolean mIsScrollStarted;
    private boolean mIsUnableToDrag;
    private final ArrayList<f> mItems;
    private float mLastMotionX;
    private float mLastMotionY;
    private float mLastOffset;
    private EdgeEffect mLeftEdge;
    private Drawable mMarginDrawable;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private boolean mNeedCalculatePageOffsets;
    private l mObserver;
    private int mOffscreenPageLimit;
    private j mOnPageChangeListener;
    private List<j> mOnPageChangeListeners;
    private int mPageMargin;
    private k mPageTransformer;
    private int mPageTransformerLayerType;
    private boolean mPopulatePending;
    private Parcelable mRestoredAdapterState;
    private ClassLoader mRestoredClassLoader;
    private int mRestoredCurItem;
    private EdgeEffect mRightEdge;
    private int mScrollState;
    private Scroller mScroller;
    private boolean mScrollingCacheEnabled;
    private final f mTempItem;
    private final Rect mTempRect;
    private int mTopPageBounds;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;
    static final int[] LAYOUT_ATTRS = {R.attr.layout_gravity};
    private static final Comparator<f> COMPARATOR = new a();
    private static final Interpolator sInterpolator = new b();
    private static final m sPositionComparator = new m();

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        int f٤٥٢٢a;

        /* renamed from: b, reason: collision with root package name */
        Parcelable f٤٥٢٣b;

        /* renamed from: c, reason: collision with root package name */
        ClassLoader f٤٥٢٤c;

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
        static class a implements Parcelable.ClassLoaderCreator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.f٤٥٢٢a + "}";
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.f٤٥٢٢a);
            parcel.writeParcelable(this.f٤٥٢٣b, i10);
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            classLoader = classLoader == null ? getClass().getClassLoader() : classLoader;
            this.f٤٥٢٢a = parcel.readInt();
            this.f٤٥٢٣b = parcel.readParcelable(classLoader);
            this.f٤٥٢٤c = classLoader;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    static class a implements Comparator {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(f fVar, f fVar2) {
            return fVar.f٤٥٢٩b - fVar2.f٤٥٢٩b;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    static class b implements Interpolator {
        b() {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f10) {
            float f11 = f10 - 1.0f;
            return (f11 * f11 * f11 * f11 * f11) + 1.0f;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewPager.this.setScrollState(0);
            ViewPager.this.populate();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class d implements j0 {

        /* renamed from: a, reason: collision with root package name */
        private final Rect f٤٥٢٦a = new Rect();

        d() {
        }

        @Override // androidx.core.view.j0
        public d2 onApplyWindowInsets(View view, d2 d2Var) {
            d2 c02 = d1.c0(view, d2Var);
            if (c02.q()) {
                return c02;
            }
            Rect rect = this.f٤٥٢٦a;
            rect.left = c02.k();
            rect.top = c02.m();
            rect.right = c02.l();
            rect.bottom = c02.j();
            int childCount = ViewPager.this.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                d2 j10 = d1.j(ViewPager.this.getChildAt(i10), c02);
                rect.left = Math.min(j10.k(), rect.left);
                rect.top = Math.min(j10.m(), rect.top);
                rect.right = Math.min(j10.l(), rect.right);
                rect.bottom = Math.min(j10.j(), rect.bottom);
            }
            return c02.r(rect.left, rect.top, rect.right, rect.bottom);
        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public @interface e {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class f {

        /* renamed from: a, reason: collision with root package name */
        Object f٤٥٢٨a;

        /* renamed from: b, reason: collision with root package name */
        int f٤٥٢٩b;

        /* renamed from: c, reason: collision with root package name */
        boolean f٤٥٣٠c;

        /* renamed from: d, reason: collision with root package name */
        float f٤٥٣١d;

        /* renamed from: e, reason: collision with root package name */
        float f٤٥٣٢e;

        f() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class h extends androidx.core.view.a {
        h() {
        }

        private boolean c() {
            androidx.viewpager.widget.a aVar = ViewPager.this.mAdapter;
            if (aVar != null && aVar.getCount() > 1) {
                return true;
            }
            return false;
        }

        @Override // androidx.core.view.a
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            androidx.viewpager.widget.a aVar;
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(ViewPager.class.getName());
            accessibilityEvent.setScrollable(c());
            if (accessibilityEvent.getEventType() == 4096 && (aVar = ViewPager.this.mAdapter) != null) {
                accessibilityEvent.setItemCount(aVar.getCount());
                accessibilityEvent.setFromIndex(ViewPager.this.mCurItem);
                accessibilityEvent.setToIndex(ViewPager.this.mCurItem);
            }
        }

        @Override // androidx.core.view.a
        public void onInitializeAccessibilityNodeInfo(View view, g0 g0Var) {
            super.onInitializeAccessibilityNodeInfo(view, g0Var);
            g0Var.o0(ViewPager.class.getName());
            g0Var.L0(c());
            if (ViewPager.this.canScrollHorizontally(1)) {
                g0Var.a(4096);
            }
            if (ViewPager.this.canScrollHorizontally(-1)) {
                g0Var.a(8192);
            }
        }

        @Override // androidx.core.view.a
        public boolean performAccessibilityAction(View view, int i10, Bundle bundle) {
            if (super.performAccessibilityAction(view, i10, bundle)) {
                return true;
            }
            if (i10 != 4096) {
                if (i10 != 8192 || !ViewPager.this.canScrollHorizontally(-1)) {
                    return false;
                }
                ViewPager viewPager = ViewPager.this;
                viewPager.setCurrentItem(viewPager.mCurItem - 1);
                return true;
            }
            if (!ViewPager.this.canScrollHorizontally(1)) {
                return false;
            }
            ViewPager viewPager2 = ViewPager.this;
            viewPager2.setCurrentItem(viewPager2.mCurItem + 1);
            return true;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public interface i {
        void a(ViewPager viewPager, androidx.viewpager.widget.a aVar, androidx.viewpager.widget.a aVar2);
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public interface j {
        void onPageScrollStateChanged(int i10);

        void onPageScrolled(int i10, float f10, int i11);

        void onPageSelected(int i10);
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public interface k {
        void transformPage(View view, float f10);
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    private class l extends DataSetObserver {
        l() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            ViewPager.this.dataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            ViewPager.this.dataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class m implements Comparator {
        m() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(View view, View view2) {
            g gVar = (g) view.getLayoutParams();
            g gVar2 = (g) view2.getLayoutParams();
            boolean z10 = gVar.f٤٥٣٣a;
            if (z10 != gVar2.f٤٥٣٣a) {
                if (z10) {
                    return 1;
                }
                return -1;
            }
            return gVar.f٤٥٣٧e - gVar2.f٤٥٣٧e;
        }
    }

    public ViewPager(Context context) {
        super(context);
        this.mItems = new ArrayList<>();
        this.mTempItem = new f();
        this.mTempRect = new Rect();
        this.mRestoredCurItem = -1;
        this.mRestoredAdapterState = null;
        this.mRestoredClassLoader = null;
        this.mFirstOffset = -3.4028235E38f;
        this.mLastOffset = Float.MAX_VALUE;
        this.mOffscreenPageLimit = 1;
        this.mActivePointerId = -1;
        this.mFirstLayout = true;
        this.mNeedCalculatePageOffsets = false;
        this.mEndScrollRunnable = new c();
        this.mScrollState = 0;
        initViewPager();
    }

    private void a(f fVar, int i10, f fVar2) {
        float f10;
        float f11;
        float f12;
        int i11;
        int i12;
        f fVar3;
        f fVar4;
        int count = this.mAdapter.getCount();
        int clientWidth = getClientWidth();
        if (clientWidth > 0) {
            f10 = this.mPageMargin / clientWidth;
        } else {
            f10 = DownloadProgress.UNKNOWN_PROGRESS;
        }
        if (fVar2 != null) {
            int i13 = fVar2.f٤٥٢٩b;
            int i14 = fVar.f٤٥٢٩b;
            if (i13 < i14) {
                float f13 = fVar2.f٤٥٣٢e + fVar2.f٤٥٣١d + f10;
                int i15 = i13 + 1;
                int i16 = 0;
                while (i15 <= fVar.f٤٥٢٩b && i16 < this.mItems.size()) {
                    f fVar5 = this.mItems.get(i16);
                    while (true) {
                        fVar4 = fVar5;
                        if (i15 <= fVar4.f٤٥٢٩b || i16 >= this.mItems.size() - 1) {
                            break;
                        }
                        i16++;
                        fVar5 = this.mItems.get(i16);
                    }
                    while (i15 < fVar4.f٤٥٢٩b) {
                        f13 += this.mAdapter.getPageWidth(i15) + f10;
                        i15++;
                    }
                    fVar4.f٤٥٣٢e = f13;
                    f13 += fVar4.f٤٥٣١d + f10;
                    i15++;
                }
            } else if (i13 > i14) {
                int size = this.mItems.size() - 1;
                float f14 = fVar2.f٤٥٣٢e;
                while (true) {
                    i13--;
                    if (i13 < fVar.f٤٥٢٩b || size < 0) {
                        break;
                    }
                    f fVar6 = this.mItems.get(size);
                    while (true) {
                        fVar3 = fVar6;
                        if (i13 >= fVar3.f٤٥٢٩b || size <= 0) {
                            break;
                        }
                        size--;
                        fVar6 = this.mItems.get(size);
                    }
                    while (i13 > fVar3.f٤٥٢٩b) {
                        f14 -= this.mAdapter.getPageWidth(i13) + f10;
                        i13--;
                    }
                    f14 -= fVar3.f٤٥٣١d + f10;
                    fVar3.f٤٥٣٢e = f14;
                }
            }
        }
        int size2 = this.mItems.size();
        float f15 = fVar.f٤٥٣٢e;
        int i17 = fVar.f٤٥٢٩b;
        int i18 = i17 - 1;
        if (i17 == 0) {
            f11 = f15;
        } else {
            f11 = -3.4028235E38f;
        }
        this.mFirstOffset = f11;
        int i19 = count - 1;
        if (i17 == i19) {
            f12 = (fVar.f٤٥٣١d + f15) - 1.0f;
        } else {
            f12 = Float.MAX_VALUE;
        }
        this.mLastOffset = f12;
        int i20 = i10 - 1;
        while (i20 >= 0) {
            f fVar7 = this.mItems.get(i20);
            while (true) {
                i12 = fVar7.f٤٥٢٩b;
                if (i18 <= i12) {
                    break;
                }
                f15 -= this.mAdapter.getPageWidth(i18) + f10;
                i18--;
            }
            f15 -= fVar7.f٤٥٣١d + f10;
            fVar7.f٤٥٣٢e = f15;
            if (i12 == 0) {
                this.mFirstOffset = f15;
            }
            i20--;
            i18--;
        }
        float f16 = fVar.f٤٥٣٢e + fVar.f٤٥٣١d + f10;
        int i21 = fVar.f٤٥٢٩b + 1;
        int i22 = i10 + 1;
        while (i22 < size2) {
            f fVar8 = this.mItems.get(i22);
            while (true) {
                i11 = fVar8.f٤٥٢٩b;
                if (i21 >= i11) {
                    break;
                }
                f16 += this.mAdapter.getPageWidth(i21) + f10;
                i21++;
            }
            if (i11 == i19) {
                this.mLastOffset = (fVar8.f٤٥٣١d + f16) - 1.0f;
            }
            fVar8.f٤٥٣٢e = f16;
            f16 += fVar8.f٤٥٣١d + f10;
            i22++;
            i21++;
        }
        this.mNeedCalculatePageOffsets = false;
    }

    private void b(boolean z10) {
        boolean z11;
        if (this.mScrollState == 2) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            setScrollingCacheEnabled(false);
            if (!this.mScroller.isFinished()) {
                this.mScroller.abortAnimation();
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                int currX = this.mScroller.getCurrX();
                int currY = this.mScroller.getCurrY();
                if (scrollX != currX || scrollY != currY) {
                    scrollTo(currX, currY);
                    if (currX != scrollX) {
                        n(currX);
                    }
                }
            }
        }
        this.mPopulatePending = false;
        for (int i10 = 0; i10 < this.mItems.size(); i10++) {
            f fVar = this.mItems.get(i10);
            if (fVar.f٤٥٣٠c) {
                fVar.f٤٥٣٠c = false;
                z11 = true;
            }
        }
        if (z11) {
            if (z10) {
                d1.i0(this, this.mEndScrollRunnable);
            } else {
                this.mEndScrollRunnable.run();
            }
        }
    }

    private int c(int i10, float f10, int i11, int i12) {
        float f11;
        if (Math.abs(i12) > this.mFlingDistance && Math.abs(i11) > this.mMinimumVelocity) {
            if (i11 <= 0) {
                i10++;
            }
        } else {
            if (i10 >= this.mCurItem) {
                f11 = 0.4f;
            } else {
                f11 = 0.6f;
            }
            i10 += (int) (f10 + f11);
        }
        if (this.mItems.size() > 0) {
            return Math.max(this.mItems.get(0).f٤٥٢٩b, Math.min(i10, this.mItems.get(r4.size() - 1).f٤٥٢٩b));
        }
        return i10;
    }

    private void d(int i10, float f10, int i11) {
        j jVar = this.mOnPageChangeListener;
        if (jVar != null) {
            jVar.onPageScrolled(i10, f10, i11);
        }
        List<j> list = this.mOnPageChangeListeners;
        if (list != null) {
            int size = list.size();
            for (int i12 = 0; i12 < size; i12++) {
                j jVar2 = this.mOnPageChangeListeners.get(i12);
                if (jVar2 != null) {
                    jVar2.onPageScrolled(i10, f10, i11);
                }
            }
        }
        j jVar3 = this.mInternalPageChangeListener;
        if (jVar3 != null) {
            jVar3.onPageScrolled(i10, f10, i11);
        }
    }

    private void e(int i10) {
        j jVar = this.mOnPageChangeListener;
        if (jVar != null) {
            jVar.onPageSelected(i10);
        }
        List<j> list = this.mOnPageChangeListeners;
        if (list != null) {
            int size = list.size();
            for (int i11 = 0; i11 < size; i11++) {
                j jVar2 = this.mOnPageChangeListeners.get(i11);
                if (jVar2 != null) {
                    jVar2.onPageSelected(i10);
                }
            }
        }
        j jVar3 = this.mInternalPageChangeListener;
        if (jVar3 != null) {
            jVar3.onPageSelected(i10);
        }
    }

    private void f(int i10) {
        j jVar = this.mOnPageChangeListener;
        if (jVar != null) {
            jVar.onPageScrollStateChanged(i10);
        }
        List<j> list = this.mOnPageChangeListeners;
        if (list != null) {
            int size = list.size();
            for (int i11 = 0; i11 < size; i11++) {
                j jVar2 = this.mOnPageChangeListeners.get(i11);
                if (jVar2 != null) {
                    jVar2.onPageScrollStateChanged(i10);
                }
            }
        }
        j jVar3 = this.mInternalPageChangeListener;
        if (jVar3 != null) {
            jVar3.onPageScrollStateChanged(i10);
        }
    }

    private void g(boolean z10) {
        int i10;
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            if (z10) {
                i10 = this.mPageTransformerLayerType;
            } else {
                i10 = 0;
            }
            getChildAt(i11).setLayerType(i10, null);
        }
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    private void h() {
        this.mIsBeingDragged = false;
        this.mIsUnableToDrag = false;
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    private Rect i(Rect rect, View view) {
        if (rect == null) {
            rect = new Rect();
        }
        if (view == null) {
            rect.set(0, 0, 0, 0);
            return rect;
        }
        rect.left = view.getLeft();
        rect.right = view.getRight();
        rect.top = view.getTop();
        rect.bottom = view.getBottom();
        ViewParent parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = (ViewGroup) parent;
            rect.left += viewGroup.getLeft();
            rect.right += viewGroup.getRight();
            rect.top += viewGroup.getTop();
            rect.bottom += viewGroup.getBottom();
            parent = viewGroup.getParent();
        }
        return rect;
    }

    private f j() {
        float f10;
        float f11;
        int i10;
        int clientWidth = getClientWidth();
        float f12 = DownloadProgress.UNKNOWN_PROGRESS;
        if (clientWidth > 0) {
            f10 = getScrollX() / clientWidth;
        } else {
            f10 = DownloadProgress.UNKNOWN_PROGRESS;
        }
        if (clientWidth > 0) {
            f11 = this.mPageMargin / clientWidth;
        } else {
            f11 = DownloadProgress.UNKNOWN_PROGRESS;
        }
        f fVar = null;
        float f13 = DownloadProgress.UNKNOWN_PROGRESS;
        int i11 = -1;
        int i12 = 0;
        boolean z10 = true;
        while (i12 < this.mItems.size()) {
            f fVar2 = this.mItems.get(i12);
            if (!z10 && fVar2.f٤٥٢٩b != (i10 = i11 + 1)) {
                fVar2 = this.mTempItem;
                fVar2.f٤٥٣٢e = f12 + f13 + f11;
                fVar2.f٤٥٢٩b = i10;
                fVar2.f٤٥٣١d = this.mAdapter.getPageWidth(i10);
                i12--;
            }
            f fVar3 = fVar2;
            f12 = fVar3.f٤٥٣٢e;
            float f14 = fVar3.f٤٥٣١d + f12 + f11;
            if (!z10 && f10 < f12) {
                return fVar;
            }
            if (f10 >= f14 && i12 != this.mItems.size() - 1) {
                int i13 = fVar3.f٤٥٢٩b;
                float f15 = fVar3.f٤٥٣١d;
                i12++;
                z10 = false;
                i11 = i13;
                f13 = f15;
                fVar = fVar3;
            } else {
                return fVar3;
            }
        }
        return fVar;
    }

    private static boolean k(View view) {
        if (view.getClass().getAnnotation(e.class) != null) {
            return true;
        }
        return false;
    }

    private boolean l(float f10, float f11) {
        if ((f10 < this.mGutterSize && f11 > DownloadProgress.UNKNOWN_PROGRESS) || (f10 > getWidth() - this.mGutterSize && f11 < DownloadProgress.UNKNOWN_PROGRESS)) {
            return true;
        }
        return false;
    }

    private void m(MotionEvent motionEvent) {
        int i10;
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.mActivePointerId) {
            if (actionIndex == 0) {
                i10 = 1;
            } else {
                i10 = 0;
            }
            this.mLastMotionX = motionEvent.getX(i10);
            this.mActivePointerId = motionEvent.getPointerId(i10);
            VelocityTracker velocityTracker = this.mVelocityTracker;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    private boolean n(int i10) {
        if (this.mItems.size() == 0) {
            if (this.mFirstLayout) {
                return false;
            }
            this.mCalledSuper = false;
            onPageScrolled(0, DownloadProgress.UNKNOWN_PROGRESS, 0);
            if (this.mCalledSuper) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        f j10 = j();
        int clientWidth = getClientWidth();
        int i11 = this.mPageMargin;
        int i12 = clientWidth + i11;
        float f10 = clientWidth;
        int i13 = j10.f٤٥٢٩b;
        float f11 = ((i10 / f10) - j10.f٤٥٣٢e) / (j10.f٤٥٣١d + (i11 / f10));
        this.mCalledSuper = false;
        onPageScrolled(i13, f11, (int) (i12 * f11));
        if (this.mCalledSuper) {
            return true;
        }
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }

    private boolean o(float f10) {
        boolean z10;
        boolean z11;
        float f11 = this.mLastMotionX - f10;
        this.mLastMotionX = f10;
        float scrollX = getScrollX() + f11;
        float clientWidth = getClientWidth();
        float f12 = this.mFirstOffset * clientWidth;
        float f13 = this.mLastOffset * clientWidth;
        boolean z12 = false;
        f fVar = this.mItems.get(0);
        ArrayList<f> arrayList = this.mItems;
        f fVar2 = arrayList.get(arrayList.size() - 1);
        if (fVar.f٤٥٢٩b != 0) {
            f12 = fVar.f٤٥٣٢e * clientWidth;
            z10 = false;
        } else {
            z10 = true;
        }
        if (fVar2.f٤٥٢٩b != this.mAdapter.getCount() - 1) {
            f13 = fVar2.f٤٥٣٢e * clientWidth;
            z11 = false;
        } else {
            z11 = true;
        }
        if (scrollX < f12) {
            if (z10) {
                this.mLeftEdge.onPull(Math.abs(f12 - scrollX) / clientWidth);
                z12 = true;
            }
            scrollX = f12;
        } else if (scrollX > f13) {
            if (z11) {
                this.mRightEdge.onPull(Math.abs(scrollX - f13) / clientWidth);
                z12 = true;
            }
            scrollX = f13;
        }
        int i10 = (int) scrollX;
        this.mLastMotionX += scrollX - i10;
        scrollTo(i10, getScrollY());
        n(i10);
        return z12;
    }

    private void p(int i10, int i11, int i12, int i13) {
        float f10;
        if (i11 > 0 && !this.mItems.isEmpty()) {
            if (!this.mScroller.isFinished()) {
                this.mScroller.setFinalX(getCurrentItem() * getClientWidth());
                return;
            }
            scrollTo((int) ((getScrollX() / (((i11 - getPaddingLeft()) - getPaddingRight()) + i13)) * (((i10 - getPaddingLeft()) - getPaddingRight()) + i12)), getScrollY());
            return;
        }
        f infoForPosition = infoForPosition(this.mCurItem);
        if (infoForPosition != null) {
            f10 = Math.min(infoForPosition.f٤٥٣٢e, this.mLastOffset);
        } else {
            f10 = DownloadProgress.UNKNOWN_PROGRESS;
        }
        int paddingLeft = (int) (f10 * ((i10 - getPaddingLeft()) - getPaddingRight()));
        if (paddingLeft != getScrollX()) {
            b(false);
            scrollTo(paddingLeft, getScrollY());
        }
    }

    private void q() {
        int i10 = 0;
        while (i10 < getChildCount()) {
            if (!((g) getChildAt(i10).getLayoutParams()).f٤٥٣٣a) {
                removeViewAt(i10);
                i10--;
            }
            i10++;
        }
    }

    private void r(boolean z10) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z10);
        }
    }

    private boolean s() {
        this.mActivePointerId = -1;
        h();
        this.mLeftEdge.onRelease();
        this.mRightEdge.onRelease();
        if (!this.mLeftEdge.isFinished() && !this.mRightEdge.isFinished()) {
            return false;
        }
        return true;
    }

    private void setScrollingCacheEnabled(boolean z10) {
        if (this.mScrollingCacheEnabled != z10) {
            this.mScrollingCacheEnabled = z10;
        }
    }

    private void t(int i10, boolean z10, int i11, boolean z11) {
        int i12;
        f infoForPosition = infoForPosition(i10);
        if (infoForPosition != null) {
            i12 = (int) (getClientWidth() * Math.max(this.mFirstOffset, Math.min(infoForPosition.f٤٥٣٢e, this.mLastOffset)));
        } else {
            i12 = 0;
        }
        if (z10) {
            smoothScrollTo(i12, 0, i11);
            if (z11) {
                e(i10);
                return;
            }
            return;
        }
        if (z11) {
            e(i10);
        }
        b(false);
        scrollTo(i12, 0);
        n(i12);
    }

    private void u() {
        if (this.mDrawingOrder != 0) {
            ArrayList<View> arrayList = this.mDrawingOrderedChildren;
            if (arrayList == null) {
                this.mDrawingOrderedChildren = new ArrayList<>();
            } else {
                arrayList.clear();
            }
            int childCount = getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                this.mDrawingOrderedChildren.add(getChildAt(i10));
            }
            Collections.sort(this.mDrawingOrderedChildren, sPositionComparator);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i10, int i11) {
        f infoForChild;
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i12 = 0; i12 < getChildCount(); i12++) {
                View childAt = getChildAt(i12);
                if (childAt.getVisibility() == 0 && (infoForChild = infoForChild(childAt)) != null && infoForChild.f٤٥٢٩b == this.mCurItem) {
                    childAt.addFocusables(arrayList, i10, i11);
                }
            }
        }
        if ((descendantFocusability == 262144 && size != arrayList.size()) || !isFocusable()) {
            return;
        }
        if ((i11 & 1) == 1 && isInTouchMode() && !isFocusableInTouchMode()) {
            return;
        }
        arrayList.add(this);
    }

    f addNewItem(int i10, int i11) {
        f fVar = new f();
        fVar.f٤٥٢٩b = i10;
        fVar.f٤٥٢٨a = this.mAdapter.instantiateItem((ViewGroup) this, i10);
        fVar.f٤٥٣١d = this.mAdapter.getPageWidth(i10);
        if (i11 >= 0 && i11 < this.mItems.size()) {
            this.mItems.add(i11, fVar);
        } else {
            this.mItems.add(fVar);
        }
        return fVar;
    }

    public void addOnAdapterChangeListener(i iVar) {
        if (this.mAdapterChangeListeners == null) {
            this.mAdapterChangeListeners = new ArrayList();
        }
        this.mAdapterChangeListeners.add(iVar);
    }

    public void addOnPageChangeListener(j jVar) {
        if (this.mOnPageChangeListeners == null) {
            this.mOnPageChangeListeners = new ArrayList();
        }
        this.mOnPageChangeListeners.add(jVar);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addTouchables(ArrayList<View> arrayList) {
        f infoForChild;
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() == 0 && (infoForChild = infoForChild(childAt)) != null && infoForChild.f٤٥٢٩b == this.mCurItem) {
                childAt.addTouchables(arrayList);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i10, ViewGroup.LayoutParams layoutParams) {
        if (!checkLayoutParams(layoutParams)) {
            layoutParams = generateLayoutParams(layoutParams);
        }
        g gVar = (g) layoutParams;
        boolean k10 = gVar.f٤٥٣٣a | k(view);
        gVar.f٤٥٣٣a = k10;
        if (this.mInLayout) {
            if (!k10) {
                gVar.f٤٥٣٦d = true;
                addViewInLayout(view, i10, layoutParams);
                return;
            }
            throw new IllegalStateException("Cannot add pager decor view during layout");
        }
        super.addView(view, i10, layoutParams);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x00cc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean arrowScroll(int i10) {
        View findNextFocus;
        boolean pageLeft;
        View findFocus = findFocus();
        if (findFocus != this) {
            if (findFocus != null) {
                for (ViewParent parent = findFocus.getParent(); parent instanceof ViewGroup; parent = parent.getParent()) {
                    if (parent == this) {
                        break;
                    }
                }
                StringBuilder sb = new StringBuilder();
                sb.append(findFocus.getClass().getSimpleName());
                for (ViewParent parent2 = findFocus.getParent(); parent2 instanceof ViewGroup; parent2 = parent2.getParent()) {
                    sb.append(" => ");
                    sb.append(parent2.getClass().getSimpleName());
                }
                Log.e(TAG, "arrowScroll tried to find focus based on non-child current focused view " + sb.toString());
            }
            findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i10);
            if (findNextFocus == null && findNextFocus != findFocus) {
                if (i10 == 17) {
                    int i11 = i(this.mTempRect, findNextFocus).left;
                    int i12 = i(this.mTempRect, findFocus).left;
                    if (findFocus != null && i11 >= i12) {
                        pageLeft = pageLeft();
                    } else {
                        pageLeft = findNextFocus.requestFocus();
                    }
                } else {
                    if (i10 == 66) {
                        int i13 = i(this.mTempRect, findNextFocus).left;
                        int i14 = i(this.mTempRect, findFocus).left;
                        if (findFocus != null && i13 <= i14) {
                            pageLeft = pageRight();
                        } else {
                            pageLeft = findNextFocus.requestFocus();
                        }
                    }
                    pageLeft = false;
                }
            } else if (i10 == 17 && i10 != 1) {
                if (i10 == 66 || i10 == 2) {
                    pageLeft = pageRight();
                }
                pageLeft = false;
            } else {
                pageLeft = pageLeft();
            }
            if (pageLeft) {
                playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i10));
            }
            return pageLeft;
        }
        findFocus = null;
        findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i10);
        if (findNextFocus == null) {
        }
        if (i10 == 17) {
        }
        pageLeft = pageLeft();
        if (pageLeft) {
        }
        return pageLeft;
    }

    public boolean beginFakeDrag() {
        if (this.mIsBeingDragged) {
            return false;
        }
        this.mFakeDragging = true;
        setScrollState(1);
        this.mLastMotionX = DownloadProgress.UNKNOWN_PROGRESS;
        this.mInitialMotionX = DownloadProgress.UNKNOWN_PROGRESS;
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, 0);
        this.mVelocityTracker.addMovement(obtain);
        obtain.recycle();
        this.mFakeDragBeginTime = uptimeMillis;
        return true;
    }

    protected boolean canScroll(View view, boolean z10, int i10, int i11, int i12) {
        int i13;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i14 = i11 + scrollX;
                if (i14 >= childAt.getLeft() && i14 < childAt.getRight() && (i13 = i12 + scrollY) >= childAt.getTop() && i13 < childAt.getBottom() && canScroll(childAt, true, i10, i14 - childAt.getLeft(), i13 - childAt.getTop())) {
                    return true;
                }
            }
        }
        if (z10 && view.canScrollHorizontally(-i10)) {
            return true;
        }
        return false;
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i10) {
        if (this.mAdapter == null) {
            return false;
        }
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        if (i10 < 0) {
            if (scrollX <= ((int) (clientWidth * this.mFirstOffset))) {
                return false;
            }
            return true;
        }
        if (i10 <= 0 || scrollX >= ((int) (clientWidth * this.mLastOffset))) {
            return false;
        }
        return true;
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if ((layoutParams instanceof g) && super.checkLayoutParams(layoutParams)) {
            return true;
        }
        return false;
    }

    public void clearOnPageChangeListeners() {
        List<j> list = this.mOnPageChangeListeners;
        if (list != null) {
            list.clear();
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        this.mIsScrollStarted = true;
        if (!this.mScroller.isFinished() && this.mScroller.computeScrollOffset()) {
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.mScroller.getCurrX();
            int currY = this.mScroller.getCurrY();
            if (scrollX != currX || scrollY != currY) {
                scrollTo(currX, currY);
                if (!n(currX)) {
                    this.mScroller.abortAnimation();
                    scrollTo(0, currY);
                }
            }
            d1.h0(this);
            return;
        }
        b(true);
    }

    void dataSetChanged() {
        boolean z10;
        int count = this.mAdapter.getCount();
        this.mExpectedAdapterCount = count;
        if (this.mItems.size() < (this.mOffscreenPageLimit * 2) + 1 && this.mItems.size() < count) {
            z10 = true;
        } else {
            z10 = false;
        }
        int i10 = this.mCurItem;
        int i11 = 0;
        boolean z11 = false;
        while (i11 < this.mItems.size()) {
            f fVar = this.mItems.get(i11);
            int itemPosition = this.mAdapter.getItemPosition(fVar.f٤٥٢٨a);
            if (itemPosition != -1) {
                if (itemPosition == -2) {
                    this.mItems.remove(i11);
                    i11--;
                    if (!z11) {
                        this.mAdapter.startUpdate((ViewGroup) this);
                        z11 = true;
                    }
                    this.mAdapter.destroyItem((ViewGroup) this, fVar.f٤٥٢٩b, fVar.f٤٥٢٨a);
                    int i12 = this.mCurItem;
                    if (i12 == fVar.f٤٥٢٩b) {
                        i10 = Math.max(0, Math.min(i12, count - 1));
                    }
                } else {
                    int i13 = fVar.f٤٥٢٩b;
                    if (i13 != itemPosition) {
                        if (i13 == this.mCurItem) {
                            i10 = itemPosition;
                        }
                        fVar.f٤٥٢٩b = itemPosition;
                    }
                }
                z10 = true;
            }
            i11++;
        }
        if (z11) {
            this.mAdapter.finishUpdate((ViewGroup) this);
        }
        Collections.sort(this.mItems, COMPARATOR);
        if (z10) {
            int childCount = getChildCount();
            for (int i14 = 0; i14 < childCount; i14++) {
                g gVar = (g) getChildAt(i14).getLayoutParams();
                if (!gVar.f٤٥٣٣a) {
                    gVar.f٤٥٣٥c = DownloadProgress.UNKNOWN_PROGRESS;
                }
            }
            setCurrentItemInternal(i10, false, true);
            requestLayout();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!super.dispatchKeyEvent(keyEvent) && !executeKeyEvent(keyEvent)) {
            return false;
        }
        return true;
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        f infoForChild;
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() == 0 && (infoForChild = infoForChild(childAt)) != null && infoForChild.f٤٥٢٩b == this.mCurItem && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                return true;
            }
        }
        return false;
    }

    float distanceInfluenceForSnapDuration(float f10) {
        return (float) Math.sin((f10 - 0.5f) * 0.47123894f);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        androidx.viewpager.widget.a aVar;
        super.draw(canvas);
        int overScrollMode = getOverScrollMode();
        boolean z10 = false;
        if (overScrollMode != 0 && (overScrollMode != 1 || (aVar = this.mAdapter) == null || aVar.getCount() <= 1)) {
            this.mLeftEdge.finish();
            this.mRightEdge.finish();
        } else {
            if (!this.mLeftEdge.isFinished()) {
                int save = canvas.save();
                int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                int width = getWidth();
                canvas.rotate(270.0f);
                canvas.translate((-height) + getPaddingTop(), this.mFirstOffset * width);
                this.mLeftEdge.setSize(height, width);
                z10 = this.mLeftEdge.draw(canvas);
                canvas.restoreToCount(save);
            }
            if (!this.mRightEdge.isFinished()) {
                int save2 = canvas.save();
                int width2 = getWidth();
                int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate(-getPaddingTop(), (-(this.mLastOffset + 1.0f)) * width2);
                this.mRightEdge.setSize(height2, width2);
                z10 |= this.mRightEdge.draw(canvas);
                canvas.restoreToCount(save2);
            }
        }
        if (z10) {
            d1.h0(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.mMarginDrawable;
        if (drawable != null && drawable.isStateful()) {
            drawable.setState(getDrawableState());
        }
    }

    public void endFakeDrag() {
        if (this.mFakeDragging) {
            if (this.mAdapter != null) {
                VelocityTracker velocityTracker = this.mVelocityTracker;
                velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                int xVelocity = (int) velocityTracker.getXVelocity(this.mActivePointerId);
                this.mPopulatePending = true;
                int clientWidth = getClientWidth();
                int scrollX = getScrollX();
                f j10 = j();
                setCurrentItemInternal(c(j10.f٤٥٢٩b, ((scrollX / clientWidth) - j10.f٤٥٣٢e) / j10.f٤٥٣١d, xVelocity, (int) (this.mLastMotionX - this.mInitialMotionX)), true, true, xVelocity);
            }
            h();
            this.mFakeDragging = false;
            return;
        }
        throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
    }

    public boolean executeKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode != 21) {
                if (keyCode != 22) {
                    if (keyCode == 61) {
                        if (keyEvent.hasNoModifiers()) {
                            return arrowScroll(2);
                        }
                        if (keyEvent.hasModifiers(1)) {
                            return arrowScroll(1);
                        }
                    }
                } else {
                    if (keyEvent.hasModifiers(2)) {
                        return pageRight();
                    }
                    return arrowScroll(66);
                }
            } else {
                if (keyEvent.hasModifiers(2)) {
                    return pageLeft();
                }
                return arrowScroll(17);
            }
        }
        return false;
    }

    public void fakeDragBy(float f10) {
        if (this.mFakeDragging) {
            if (this.mAdapter == null) {
                return;
            }
            this.mLastMotionX += f10;
            float scrollX = getScrollX() - f10;
            float clientWidth = getClientWidth();
            float f11 = this.mFirstOffset * clientWidth;
            float f12 = this.mLastOffset * clientWidth;
            f fVar = this.mItems.get(0);
            f fVar2 = this.mItems.get(r4.size() - 1);
            if (fVar.f٤٥٢٩b != 0) {
                f11 = fVar.f٤٥٣٢e * clientWidth;
            }
            if (fVar2.f٤٥٢٩b != this.mAdapter.getCount() - 1) {
                f12 = fVar2.f٤٥٣٢e * clientWidth;
            }
            if (scrollX < f11) {
                scrollX = f11;
            } else if (scrollX > f12) {
                scrollX = f12;
            }
            int i10 = (int) scrollX;
            this.mLastMotionX += scrollX - i10;
            scrollTo(i10, getScrollY());
            n(i10);
            MotionEvent obtain = MotionEvent.obtain(this.mFakeDragBeginTime, SystemClock.uptimeMillis(), 2, this.mLastMotionX, DownloadProgress.UNKNOWN_PROGRESS, 0);
            this.mVelocityTracker.addMovement(obtain);
            obtain.recycle();
            return;
        }
        throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new g();
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    public androidx.viewpager.widget.a getAdapter() {
        return this.mAdapter;
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i10, int i11) {
        if (this.mDrawingOrder == 2) {
            i11 = (i10 - 1) - i11;
        }
        return ((g) this.mDrawingOrderedChildren.get(i11).getLayoutParams()).f٤٥٣٨f;
    }

    public int getCurrentItem() {
        return this.mCurItem;
    }

    public int getOffscreenPageLimit() {
        return this.mOffscreenPageLimit;
    }

    public int getPageMargin() {
        return this.mPageMargin;
    }

    f infoForAnyChild(View view) {
        while (true) {
            Object parent = view.getParent();
            if (parent != this) {
                if (parent != null && (parent instanceof View)) {
                    view = (View) parent;
                } else {
                    return null;
                }
            } else {
                return infoForChild(view);
            }
        }
    }

    f infoForChild(View view) {
        for (int i10 = 0; i10 < this.mItems.size(); i10++) {
            f fVar = this.mItems.get(i10);
            if (this.mAdapter.isViewFromObject(view, fVar.f٤٥٢٨a)) {
                return fVar;
            }
        }
        return null;
    }

    f infoForPosition(int i10) {
        for (int i11 = 0; i11 < this.mItems.size(); i11++) {
            f fVar = this.mItems.get(i11);
            if (fVar.f٤٥٢٩b == i10) {
                return fVar;
            }
        }
        return null;
    }

    void initViewPager() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.mScroller = new Scroller(context, sInterpolator);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f10 = context.getResources().getDisplayMetrics().density;
        this.mTouchSlop = viewConfiguration.getScaledPagingTouchSlop();
        this.mMinimumVelocity = (int) (400.0f * f10);
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mLeftEdge = new EdgeEffect(context);
        this.mRightEdge = new EdgeEffect(context);
        this.mFlingDistance = (int) (25.0f * f10);
        this.mCloseEnough = (int) (2.0f * f10);
        this.mDefaultGutterSize = (int) (f10 * 16.0f);
        d1.q0(this, new h());
        if (d1.B(this) == 0) {
            d1.z0(this, 1);
        }
        d1.E0(this, new d());
    }

    public boolean isFakeDragging() {
        return this.mFakeDragging;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mFirstLayout = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        removeCallbacks(this.mEndScrollRunnable);
        Scroller scroller = this.mScroller;
        if (scroller != null && !scroller.isFinished()) {
            this.mScroller.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int i10;
        float f10;
        float f11;
        super.onDraw(canvas);
        if (this.mPageMargin > 0 && this.mMarginDrawable != null && this.mItems.size() > 0 && this.mAdapter != null) {
            int scrollX = getScrollX();
            float width = getWidth();
            float f12 = this.mPageMargin / width;
            int i11 = 0;
            f fVar = this.mItems.get(0);
            float f13 = fVar.f٤٥٣٢e;
            int size = this.mItems.size();
            int i12 = fVar.f٤٥٢٩b;
            int i13 = this.mItems.get(size - 1).f٤٥٢٩b;
            while (i12 < i13) {
                while (true) {
                    i10 = fVar.f٤٥٢٩b;
                    if (i12 <= i10 || i11 >= size) {
                        break;
                    }
                    i11++;
                    fVar = this.mItems.get(i11);
                }
                if (i12 == i10) {
                    float f14 = fVar.f٤٥٣٢e;
                    float f15 = fVar.f٤٥٣١d;
                    f10 = (f14 + f15) * width;
                    f13 = f14 + f15 + f12;
                } else {
                    float pageWidth = this.mAdapter.getPageWidth(i12);
                    f10 = (f13 + pageWidth) * width;
                    f13 += pageWidth + f12;
                }
                if (this.mPageMargin + f10 > scrollX) {
                    f11 = f12;
                    this.mMarginDrawable.setBounds(Math.round(f10), this.mTopPageBounds, Math.round(this.mPageMargin + f10), this.mBottomPageBounds);
                    this.mMarginDrawable.draw(canvas);
                } else {
                    f11 = f12;
                }
                if (f10 <= scrollX + r2) {
                    i12++;
                    f12 = f11;
                } else {
                    return;
                }
            }
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        float f10;
        int action = motionEvent.getAction() & KotlinVersion.MAX_COMPONENT_VALUE;
        if (action != 3 && action != 1) {
            if (action != 0) {
                if (this.mIsBeingDragged) {
                    return true;
                }
                if (this.mIsUnableToDrag) {
                    return false;
                }
            }
            if (action != 0) {
                if (action != 2) {
                    if (action == 6) {
                        m(motionEvent);
                    }
                } else {
                    int i10 = this.mActivePointerId;
                    if (i10 != -1) {
                        int findPointerIndex = motionEvent.findPointerIndex(i10);
                        float x10 = motionEvent.getX(findPointerIndex);
                        float f11 = x10 - this.mLastMotionX;
                        float abs = Math.abs(f11);
                        float y10 = motionEvent.getY(findPointerIndex);
                        float abs2 = Math.abs(y10 - this.mInitialMotionY);
                        if (f11 != DownloadProgress.UNKNOWN_PROGRESS && !l(this.mLastMotionX, f11) && canScroll(this, false, (int) f11, (int) x10, (int) y10)) {
                            this.mLastMotionX = x10;
                            this.mLastMotionY = y10;
                            this.mIsUnableToDrag = true;
                            return false;
                        }
                        int i11 = this.mTouchSlop;
                        if (abs > i11 && abs * 0.5f > abs2) {
                            this.mIsBeingDragged = true;
                            r(true);
                            setScrollState(1);
                            float f12 = this.mInitialMotionX;
                            float f13 = this.mTouchSlop;
                            if (f11 > DownloadProgress.UNKNOWN_PROGRESS) {
                                f10 = f12 + f13;
                            } else {
                                f10 = f12 - f13;
                            }
                            this.mLastMotionX = f10;
                            this.mLastMotionY = y10;
                            setScrollingCacheEnabled(true);
                        } else if (abs2 > i11) {
                            this.mIsUnableToDrag = true;
                        }
                        if (this.mIsBeingDragged && o(x10)) {
                            d1.h0(this);
                        }
                    }
                }
            } else {
                float x11 = motionEvent.getX();
                this.mInitialMotionX = x11;
                this.mLastMotionX = x11;
                float y11 = motionEvent.getY();
                this.mInitialMotionY = y11;
                this.mLastMotionY = y11;
                this.mActivePointerId = motionEvent.getPointerId(0);
                this.mIsUnableToDrag = false;
                this.mIsScrollStarted = true;
                this.mScroller.computeScrollOffset();
                if (this.mScrollState == 2 && Math.abs(this.mScroller.getFinalX() - this.mScroller.getCurrX()) > this.mCloseEnough) {
                    this.mScroller.abortAnimation();
                    this.mPopulatePending = false;
                    populate();
                    this.mIsBeingDragged = true;
                    r(true);
                    setScrollState(1);
                } else {
                    b(false);
                    this.mIsBeingDragged = false;
                }
            }
            if (this.mVelocityTracker == null) {
                this.mVelocityTracker = VelocityTracker.obtain();
            }
            this.mVelocityTracker.addMovement(motionEvent);
            return this.mIsBeingDragged;
        }
        s();
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0094  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        boolean z11;
        f infoForChild;
        int max;
        int i14;
        int max2;
        int i15;
        int childCount = getChildCount();
        int i16 = i12 - i10;
        int i17 = i13 - i11;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int scrollX = getScrollX();
        int i18 = 0;
        for (int i19 = 0; i19 < childCount; i19++) {
            View childAt = getChildAt(i19);
            if (childAt.getVisibility() != 8) {
                g gVar = (g) childAt.getLayoutParams();
                if (gVar.f٤٥٣٣a) {
                    int i20 = gVar.f٤٥٣٤b;
                    int i21 = i20 & 7;
                    int i22 = i20 & 112;
                    if (i21 != 1) {
                        if (i21 != 3) {
                            if (i21 != 5) {
                                i14 = paddingLeft;
                            } else {
                                max = (i16 - paddingRight) - childAt.getMeasuredWidth();
                                paddingRight += childAt.getMeasuredWidth();
                            }
                        } else {
                            i14 = childAt.getMeasuredWidth() + paddingLeft;
                        }
                        if (i22 == 16) {
                            if (i22 != 48) {
                                if (i22 != 80) {
                                    i15 = paddingTop;
                                } else {
                                    max2 = (i17 - paddingBottom) - childAt.getMeasuredHeight();
                                    paddingBottom += childAt.getMeasuredHeight();
                                }
                            } else {
                                i15 = childAt.getMeasuredHeight() + paddingTop;
                            }
                            int i23 = paddingLeft + scrollX;
                            childAt.layout(i23, paddingTop, childAt.getMeasuredWidth() + i23, paddingTop + childAt.getMeasuredHeight());
                            i18++;
                            paddingTop = i15;
                            paddingLeft = i14;
                        } else {
                            max2 = Math.max((i17 - childAt.getMeasuredHeight()) / 2, paddingTop);
                        }
                        int i24 = max2;
                        i15 = paddingTop;
                        paddingTop = i24;
                        int i232 = paddingLeft + scrollX;
                        childAt.layout(i232, paddingTop, childAt.getMeasuredWidth() + i232, paddingTop + childAt.getMeasuredHeight());
                        i18++;
                        paddingTop = i15;
                        paddingLeft = i14;
                    } else {
                        max = Math.max((i16 - childAt.getMeasuredWidth()) / 2, paddingLeft);
                    }
                    int i25 = max;
                    i14 = paddingLeft;
                    paddingLeft = i25;
                    if (i22 == 16) {
                    }
                    int i242 = max2;
                    i15 = paddingTop;
                    paddingTop = i242;
                    int i2322 = paddingLeft + scrollX;
                    childAt.layout(i2322, paddingTop, childAt.getMeasuredWidth() + i2322, paddingTop + childAt.getMeasuredHeight());
                    i18++;
                    paddingTop = i15;
                    paddingLeft = i14;
                }
            }
        }
        int i26 = (i16 - paddingLeft) - paddingRight;
        for (int i27 = 0; i27 < childCount; i27++) {
            View childAt2 = getChildAt(i27);
            if (childAt2.getVisibility() != 8) {
                g gVar2 = (g) childAt2.getLayoutParams();
                if (!gVar2.f٤٥٣٣a && (infoForChild = infoForChild(childAt2)) != null) {
                    float f10 = i26;
                    int i28 = ((int) (infoForChild.f٤٥٣٢e * f10)) + paddingLeft;
                    if (gVar2.f٤٥٣٦d) {
                        gVar2.f٤٥٣٦d = false;
                        childAt2.measure(View.MeasureSpec.makeMeasureSpec((int) (f10 * gVar2.f٤٥٣٥c), 1073741824), View.MeasureSpec.makeMeasureSpec((i17 - paddingTop) - paddingBottom, 1073741824));
                    }
                    childAt2.layout(i28, paddingTop, childAt2.getMeasuredWidth() + i28, childAt2.getMeasuredHeight() + paddingTop);
                }
            }
        }
        this.mTopPageBounds = paddingTop;
        this.mBottomPageBounds = i17 - paddingBottom;
        this.mDecorChildCount = i18;
        if (this.mFirstLayout) {
            z11 = false;
            t(this.mCurItem, false, 0, false);
        } else {
            z11 = false;
        }
        this.mFirstLayout = z11;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0088  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onMeasure(int i10, int i11) {
        g gVar;
        g gVar2;
        boolean z10;
        int i12;
        int i13;
        int i14;
        setMeasuredDimension(View.getDefaultSize(0, i10), View.getDefaultSize(0, i11));
        int measuredWidth = getMeasuredWidth();
        this.mGutterSize = Math.min(measuredWidth / 10, this.mDefaultGutterSize);
        int paddingLeft = (measuredWidth - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        int i15 = 0;
        while (true) {
            boolean z11 = true;
            int i16 = 1073741824;
            if (i15 >= childCount) {
                break;
            }
            View childAt = getChildAt(i15);
            if (childAt.getVisibility() != 8 && (gVar2 = (g) childAt.getLayoutParams()) != null && gVar2.f٤٥٣٣a) {
                int i17 = gVar2.f٤٥٣٤b;
                int i18 = i17 & 7;
                int i19 = i17 & 112;
                if (i19 != 48 && i19 != 80) {
                    z10 = false;
                } else {
                    z10 = true;
                }
                if (i18 != 3 && i18 != 5) {
                    z11 = false;
                }
                int i20 = Integer.MIN_VALUE;
                if (z10) {
                    i20 = 1073741824;
                } else if (z11) {
                    i12 = 1073741824;
                    i13 = ((ViewGroup.LayoutParams) gVar2).width;
                    if (i13 == -2) {
                        if (i13 == -1) {
                            i13 = paddingLeft;
                        }
                        i20 = 1073741824;
                    } else {
                        i13 = paddingLeft;
                    }
                    i14 = ((ViewGroup.LayoutParams) gVar2).height;
                    if (i14 == -2) {
                        if (i14 == -1) {
                            i14 = measuredHeight;
                        }
                    } else {
                        i14 = measuredHeight;
                        i16 = i12;
                    }
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(i13, i20), View.MeasureSpec.makeMeasureSpec(i14, i16));
                    if (!z10) {
                        measuredHeight -= childAt.getMeasuredHeight();
                    } else if (z11) {
                        paddingLeft -= childAt.getMeasuredWidth();
                    }
                }
                i12 = Integer.MIN_VALUE;
                i13 = ((ViewGroup.LayoutParams) gVar2).width;
                if (i13 == -2) {
                }
                i14 = ((ViewGroup.LayoutParams) gVar2).height;
                if (i14 == -2) {
                }
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i13, i20), View.MeasureSpec.makeMeasureSpec(i14, i16));
                if (!z10) {
                }
            }
            i15++;
        }
        this.mChildWidthMeasureSpec = View.MeasureSpec.makeMeasureSpec(paddingLeft, 1073741824);
        this.mChildHeightMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        this.mInLayout = true;
        populate();
        this.mInLayout = false;
        int childCount2 = getChildCount();
        for (int i21 = 0; i21 < childCount2; i21++) {
            View childAt2 = getChildAt(i21);
            if (childAt2.getVisibility() != 8 && ((gVar = (g) childAt2.getLayoutParams()) == null || !gVar.f٤٥٣٣a)) {
                childAt2.measure(View.MeasureSpec.makeMeasureSpec((int) (paddingLeft * gVar.f٤٥٣٥c), 1073741824), this.mChildHeightMeasureSpec);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0065  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onPageScrolled(int i10, float f10, int i11) {
        int max;
        int i12;
        int left;
        if (this.mDecorChildCount > 0) {
            int scrollX = getScrollX();
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int width = getWidth();
            int childCount = getChildCount();
            for (int i13 = 0; i13 < childCount; i13++) {
                View childAt = getChildAt(i13);
                g gVar = (g) childAt.getLayoutParams();
                if (gVar.f٤٥٣٣a) {
                    int i14 = gVar.f٤٥٣٤b & 7;
                    if (i14 != 1) {
                        if (i14 != 3) {
                            if (i14 != 5) {
                                i12 = paddingLeft;
                            } else {
                                max = (width - paddingRight) - childAt.getMeasuredWidth();
                                paddingRight += childAt.getMeasuredWidth();
                            }
                        } else {
                            i12 = childAt.getWidth() + paddingLeft;
                        }
                        left = (paddingLeft + scrollX) - childAt.getLeft();
                        if (left != 0) {
                            childAt.offsetLeftAndRight(left);
                        }
                        paddingLeft = i12;
                    } else {
                        max = Math.max((width - childAt.getMeasuredWidth()) / 2, paddingLeft);
                    }
                    int i15 = max;
                    i12 = paddingLeft;
                    paddingLeft = i15;
                    left = (paddingLeft + scrollX) - childAt.getLeft();
                    if (left != 0) {
                    }
                    paddingLeft = i12;
                }
            }
        }
        d(i10, f10, i11);
        if (this.mPageTransformer != null) {
            int scrollX2 = getScrollX();
            int childCount2 = getChildCount();
            for (int i16 = 0; i16 < childCount2; i16++) {
                View childAt2 = getChildAt(i16);
                if (!((g) childAt2.getLayoutParams()).f٤٥٣٣a) {
                    this.mPageTransformer.transformPage(childAt2, (childAt2.getLeft() - scrollX2) / getClientWidth());
                }
            }
        }
        this.mCalledSuper = true;
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int i10, Rect rect) {
        int i11;
        int i12;
        int i13;
        f infoForChild;
        int childCount = getChildCount();
        if ((i10 & 2) != 0) {
            i12 = childCount;
            i11 = 0;
            i13 = 1;
        } else {
            i11 = childCount - 1;
            i12 = -1;
            i13 = -1;
        }
        while (i11 != i12) {
            View childAt = getChildAt(i11);
            if (childAt.getVisibility() == 0 && (infoForChild = infoForChild(childAt)) != null && infoForChild.f٤٥٢٩b == this.mCurItem && childAt.requestFocus(i10, rect)) {
                return true;
            }
            i11 += i13;
        }
        return false;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        androidx.viewpager.widget.a aVar = this.mAdapter;
        if (aVar != null) {
            aVar.restoreState(savedState.f٤٥٢٣b, savedState.f٤٥٢٤c);
            setCurrentItemInternal(savedState.f٤٥٢٢a, false, true);
        } else {
            this.mRestoredCurItem = savedState.f٤٥٢٢a;
            this.mRestoredAdapterState = savedState.f٤٥٢٣b;
            this.mRestoredClassLoader = savedState.f٤٥٢٤c;
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f٤٥٢٢a = this.mCurItem;
        androidx.viewpager.widget.a aVar = this.mAdapter;
        if (aVar != null) {
            savedState.f٤٥٢٣b = aVar.saveState();
        }
        return savedState;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        if (i10 != i12) {
            int i14 = this.mPageMargin;
            p(i10, i12, i14, i14);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        androidx.viewpager.widget.a aVar;
        float f10;
        if (this.mFakeDragging) {
            return true;
        }
        boolean z10 = false;
        if ((motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) || (aVar = this.mAdapter) == null || aVar.getCount() == 0) {
            return false;
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        int action = motionEvent.getAction() & KotlinVersion.MAX_COMPONENT_VALUE;
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action != 3) {
                        if (action != 5) {
                            if (action == 6) {
                                m(motionEvent);
                                this.mLastMotionX = motionEvent.getX(motionEvent.findPointerIndex(this.mActivePointerId));
                            }
                        } else {
                            int actionIndex = motionEvent.getActionIndex();
                            this.mLastMotionX = motionEvent.getX(actionIndex);
                            this.mActivePointerId = motionEvent.getPointerId(actionIndex);
                        }
                    } else if (this.mIsBeingDragged) {
                        t(this.mCurItem, true, 0, false);
                        z10 = s();
                    }
                } else {
                    if (!this.mIsBeingDragged) {
                        int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                        if (findPointerIndex == -1) {
                            z10 = s();
                        } else {
                            float x10 = motionEvent.getX(findPointerIndex);
                            float abs = Math.abs(x10 - this.mLastMotionX);
                            float y10 = motionEvent.getY(findPointerIndex);
                            float abs2 = Math.abs(y10 - this.mLastMotionY);
                            if (abs > this.mTouchSlop && abs > abs2) {
                                this.mIsBeingDragged = true;
                                r(true);
                                float f11 = this.mInitialMotionX;
                                if (x10 - f11 > DownloadProgress.UNKNOWN_PROGRESS) {
                                    f10 = f11 + this.mTouchSlop;
                                } else {
                                    f10 = f11 - this.mTouchSlop;
                                }
                                this.mLastMotionX = f10;
                                this.mLastMotionY = y10;
                                setScrollState(1);
                                setScrollingCacheEnabled(true);
                                ViewParent parent = getParent();
                                if (parent != null) {
                                    parent.requestDisallowInterceptTouchEvent(true);
                                }
                            }
                        }
                    }
                    if (this.mIsBeingDragged) {
                        z10 = o(motionEvent.getX(motionEvent.findPointerIndex(this.mActivePointerId)));
                    }
                }
            } else if (this.mIsBeingDragged) {
                VelocityTracker velocityTracker = this.mVelocityTracker;
                velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                int xVelocity = (int) velocityTracker.getXVelocity(this.mActivePointerId);
                this.mPopulatePending = true;
                int clientWidth = getClientWidth();
                int scrollX = getScrollX();
                f j10 = j();
                float f12 = clientWidth;
                setCurrentItemInternal(c(j10.f٤٥٢٩b, ((scrollX / f12) - j10.f٤٥٣٢e) / (j10.f٤٥٣١d + (this.mPageMargin / f12)), xVelocity, (int) (motionEvent.getX(motionEvent.findPointerIndex(this.mActivePointerId)) - this.mInitialMotionX)), true, true, xVelocity);
                z10 = s();
            }
        } else {
            this.mScroller.abortAnimation();
            this.mPopulatePending = false;
            populate();
            float x11 = motionEvent.getX();
            this.mInitialMotionX = x11;
            this.mLastMotionX = x11;
            float y11 = motionEvent.getY();
            this.mInitialMotionY = y11;
            this.mLastMotionY = y11;
            this.mActivePointerId = motionEvent.getPointerId(0);
        }
        if (z10) {
            d1.h0(this);
        }
        return true;
    }

    boolean pageLeft() {
        int i10 = this.mCurItem;
        if (i10 > 0) {
            setCurrentItem(i10 - 1, true);
            return true;
        }
        return false;
    }

    boolean pageRight() {
        androidx.viewpager.widget.a aVar = this.mAdapter;
        if (aVar != null && this.mCurItem < aVar.getCount() - 1) {
            setCurrentItem(this.mCurItem + 1, true);
            return true;
        }
        return false;
    }

    void populate() {
        populate(this.mCurItem);
    }

    public void removeOnAdapterChangeListener(i iVar) {
        List<i> list = this.mAdapterChangeListeners;
        if (list != null) {
            list.remove(iVar);
        }
    }

    public void removeOnPageChangeListener(j jVar) {
        List<j> list = this.mOnPageChangeListeners;
        if (list != null) {
            list.remove(jVar);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (this.mInLayout) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    public void setAdapter(androidx.viewpager.widget.a aVar) {
        androidx.viewpager.widget.a aVar2 = this.mAdapter;
        if (aVar2 != null) {
            aVar2.setViewPagerObserver(null);
            this.mAdapter.startUpdate((ViewGroup) this);
            for (int i10 = 0; i10 < this.mItems.size(); i10++) {
                f fVar = this.mItems.get(i10);
                this.mAdapter.destroyItem((ViewGroup) this, fVar.f٤٥٢٩b, fVar.f٤٥٢٨a);
            }
            this.mAdapter.finishUpdate((ViewGroup) this);
            this.mItems.clear();
            q();
            this.mCurItem = 0;
            scrollTo(0, 0);
        }
        androidx.viewpager.widget.a aVar3 = this.mAdapter;
        this.mAdapter = aVar;
        this.mExpectedAdapterCount = 0;
        if (aVar != null) {
            if (this.mObserver == null) {
                this.mObserver = new l();
            }
            this.mAdapter.setViewPagerObserver(this.mObserver);
            this.mPopulatePending = false;
            boolean z10 = this.mFirstLayout;
            this.mFirstLayout = true;
            this.mExpectedAdapterCount = this.mAdapter.getCount();
            if (this.mRestoredCurItem >= 0) {
                this.mAdapter.restoreState(this.mRestoredAdapterState, this.mRestoredClassLoader);
                setCurrentItemInternal(this.mRestoredCurItem, false, true);
                this.mRestoredCurItem = -1;
                this.mRestoredAdapterState = null;
                this.mRestoredClassLoader = null;
            } else if (!z10) {
                populate();
            } else {
                requestLayout();
            }
        }
        List<i> list = this.mAdapterChangeListeners;
        if (list != null && !list.isEmpty()) {
            int size = this.mAdapterChangeListeners.size();
            for (int i11 = 0; i11 < size; i11++) {
                this.mAdapterChangeListeners.get(i11).a(this, aVar3, aVar);
            }
        }
    }

    public void setCurrentItem(int i10) {
        this.mPopulatePending = false;
        setCurrentItemInternal(i10, !this.mFirstLayout, false);
    }

    void setCurrentItemInternal(int i10, boolean z10, boolean z11) {
        setCurrentItemInternal(i10, z10, z11, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public j setInternalPageChangeListener(j jVar) {
        j jVar2 = this.mInternalPageChangeListener;
        this.mInternalPageChangeListener = jVar;
        return jVar2;
    }

    public void setOffscreenPageLimit(int i10) {
        if (i10 < 1) {
            Log.w(TAG, "Requested offscreen page limit " + i10 + " too small; defaulting to 1");
            i10 = 1;
        }
        if (i10 != this.mOffscreenPageLimit) {
            this.mOffscreenPageLimit = i10;
            populate();
        }
    }

    @Deprecated
    public void setOnPageChangeListener(j jVar) {
        this.mOnPageChangeListener = jVar;
    }

    public void setPageMargin(int i10) {
        int i11 = this.mPageMargin;
        this.mPageMargin = i10;
        int width = getWidth();
        p(width, width, i10, i11);
        requestLayout();
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.mMarginDrawable = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    public void setPageTransformer(boolean z10, k kVar) {
        setPageTransformer(z10, kVar, 2);
    }

    void setScrollState(int i10) {
        boolean z10;
        if (this.mScrollState == i10) {
            return;
        }
        this.mScrollState = i10;
        if (this.mPageTransformer != null) {
            if (i10 != 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            g(z10);
        }
        f(i10);
    }

    void smoothScrollTo(int i10, int i11) {
        smoothScrollTo(i10, i11, 0);
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        if (!super.verifyDrawable(drawable) && drawable != this.mMarginDrawable) {
            return false;
        }
        return true;
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class g extends ViewGroup.LayoutParams {

        /* renamed from: a, reason: collision with root package name */
        public boolean f٤٥٣٣a;

        /* renamed from: b, reason: collision with root package name */
        public int f٤٥٣٤b;

        /* renamed from: c, reason: collision with root package name */
        float f٤٥٣٥c;

        /* renamed from: d, reason: collision with root package name */
        boolean f٤٥٣٦d;

        /* renamed from: e, reason: collision with root package name */
        int f٤٥٣٧e;

        /* renamed from: f, reason: collision with root package name */
        int f٤٥٣٨f;

        public g() {
            super(-1, -1);
            this.f٤٥٣٥c = DownloadProgress.UNKNOWN_PROGRESS;
        }

        public g(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f٤٥٣٥c = DownloadProgress.UNKNOWN_PROGRESS;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ViewPager.LAYOUT_ATTRS);
            this.f٤٥٣٤b = obtainStyledAttributes.getInteger(0, 48);
            obtainStyledAttributes.recycle();
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new g(getContext(), attributeSet);
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0060, code lost:
    
        if (r9 == r10) goto L٢٨;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0066, code lost:
    
        r8 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void populate(int i10) {
        f fVar;
        String hexString;
        f fVar2;
        f infoForChild;
        f fVar3;
        int i11 = this.mCurItem;
        if (i11 != i10) {
            fVar = infoForPosition(i11);
            this.mCurItem = i10;
        } else {
            fVar = null;
        }
        if (this.mAdapter == null) {
            u();
            return;
        }
        if (this.mPopulatePending) {
            u();
            return;
        }
        if (getWindowToken() == null) {
            return;
        }
        this.mAdapter.startUpdate((ViewGroup) this);
        int i12 = this.mOffscreenPageLimit;
        int max = Math.max(0, this.mCurItem - i12);
        int count = this.mAdapter.getCount();
        int min = Math.min(count - 1, this.mCurItem + i12);
        if (count == this.mExpectedAdapterCount) {
            int i13 = 0;
            while (true) {
                if (i13 >= this.mItems.size()) {
                    break;
                }
                fVar2 = this.mItems.get(i13);
                int i14 = fVar2.f٤٥٢٩b;
                int i15 = this.mCurItem;
                if (i14 < i15) {
                    i13++;
                }
            }
            if (fVar2 == null && count > 0) {
                fVar2 = addNewItem(this.mCurItem, i13);
            }
            if (fVar2 != null) {
                int i16 = i13 - 1;
                f fVar4 = i16 >= 0 ? this.mItems.get(i16) : null;
                int clientWidth = getClientWidth();
                float paddingLeft = clientWidth <= 0 ? DownloadProgress.UNKNOWN_PROGRESS : (2.0f - fVar2.f٤٥٣١d) + (getPaddingLeft() / clientWidth);
                float f10 = DownloadProgress.UNKNOWN_PROGRESS;
                for (int i17 = this.mCurItem - 1; i17 >= 0; i17--) {
                    if (f10 >= paddingLeft && i17 < max) {
                        if (fVar4 == null) {
                            break;
                        }
                        if (i17 == fVar4.f٤٥٢٩b && !fVar4.f٤٥٣٠c) {
                            this.mItems.remove(i16);
                            this.mAdapter.destroyItem((ViewGroup) this, i17, fVar4.f٤٥٢٨a);
                            i16--;
                            i13--;
                            if (i16 >= 0) {
                                fVar3 = this.mItems.get(i16);
                                fVar4 = fVar3;
                            }
                            fVar3 = null;
                            fVar4 = fVar3;
                        }
                    } else if (fVar4 != null && i17 == fVar4.f٤٥٢٩b) {
                        f10 += fVar4.f٤٥٣١d;
                        i16--;
                        if (i16 >= 0) {
                            fVar3 = this.mItems.get(i16);
                            fVar4 = fVar3;
                        }
                        fVar3 = null;
                        fVar4 = fVar3;
                    } else {
                        f10 += addNewItem(i17, i16 + 1).f٤٥٣١d;
                        i13++;
                        if (i16 >= 0) {
                            fVar3 = this.mItems.get(i16);
                            fVar4 = fVar3;
                        }
                        fVar3 = null;
                        fVar4 = fVar3;
                    }
                }
                float f11 = fVar2.f٤٥٣١d;
                int i18 = i13 + 1;
                if (f11 < 2.0f) {
                    f fVar5 = i18 < this.mItems.size() ? this.mItems.get(i18) : null;
                    float paddingRight = clientWidth <= 0 ? DownloadProgress.UNKNOWN_PROGRESS : (getPaddingRight() / clientWidth) + 2.0f;
                    int i19 = this.mCurItem;
                    while (true) {
                        i19++;
                        if (i19 >= count) {
                            break;
                        }
                        if (f11 >= paddingRight && i19 > min) {
                            if (fVar5 == null) {
                                break;
                            }
                            if (i19 == fVar5.f٤٥٢٩b && !fVar5.f٤٥٣٠c) {
                                this.mItems.remove(i18);
                                this.mAdapter.destroyItem((ViewGroup) this, i19, fVar5.f٤٥٢٨a);
                                if (i18 < this.mItems.size()) {
                                    fVar5 = this.mItems.get(i18);
                                }
                            }
                        } else if (fVar5 != null && i19 == fVar5.f٤٥٢٩b) {
                            f11 += fVar5.f٤٥٣١d;
                            i18++;
                            if (i18 < this.mItems.size()) {
                                fVar5 = this.mItems.get(i18);
                            }
                        } else {
                            f addNewItem = addNewItem(i19, i18);
                            i18++;
                            f11 += addNewItem.f٤٥٣١d;
                            fVar5 = i18 < this.mItems.size() ? this.mItems.get(i18) : null;
                        }
                    }
                }
                a(fVar2, i13, fVar);
                this.mAdapter.setPrimaryItem((ViewGroup) this, this.mCurItem, fVar2.f٤٥٢٨a);
            }
            this.mAdapter.finishUpdate((ViewGroup) this);
            int childCount = getChildCount();
            for (int i20 = 0; i20 < childCount; i20++) {
                View childAt = getChildAt(i20);
                g gVar = (g) childAt.getLayoutParams();
                gVar.f٤٥٣٨f = i20;
                if (!gVar.f٤٥٣٣a && gVar.f٤٥٣٥c == DownloadProgress.UNKNOWN_PROGRESS && (infoForChild = infoForChild(childAt)) != null) {
                    gVar.f٤٥٣٥c = infoForChild.f٤٥٣١d;
                    gVar.f٤٥٣٧e = infoForChild.f٤٥٢٩b;
                }
            }
            u();
            if (hasFocus()) {
                View findFocus = findFocus();
                f infoForAnyChild = findFocus != null ? infoForAnyChild(findFocus) : null;
                if (infoForAnyChild == null || infoForAnyChild.f٤٥٢٩b != this.mCurItem) {
                    for (int i21 = 0; i21 < getChildCount(); i21++) {
                        View childAt2 = getChildAt(i21);
                        f infoForChild2 = infoForChild(childAt2);
                        if (infoForChild2 != null && infoForChild2.f٤٥٢٩b == this.mCurItem && childAt2.requestFocus(2)) {
                            return;
                        }
                    }
                    return;
                }
                return;
            }
            return;
        }
        try {
            hexString = getResources().getResourceName(getId());
        } catch (Resources.NotFoundException unused) {
            hexString = Integer.toHexString(getId());
        }
        throw new IllegalStateException("The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: " + this.mExpectedAdapterCount + ", found: " + count + " Pager id: " + hexString + " Pager class: " + getClass() + " Problematic adapter: " + this.mAdapter.getClass());
    }

    void setCurrentItemInternal(int i10, boolean z10, boolean z11, int i11) {
        androidx.viewpager.widget.a aVar = this.mAdapter;
        if (aVar != null && aVar.getCount() > 0) {
            if (!z11 && this.mCurItem == i10 && this.mItems.size() != 0) {
                setScrollingCacheEnabled(false);
                return;
            }
            if (i10 < 0) {
                i10 = 0;
            } else if (i10 >= this.mAdapter.getCount()) {
                i10 = this.mAdapter.getCount() - 1;
            }
            int i12 = this.mOffscreenPageLimit;
            int i13 = this.mCurItem;
            if (i10 > i13 + i12 || i10 < i13 - i12) {
                for (int i14 = 0; i14 < this.mItems.size(); i14++) {
                    this.mItems.get(i14).f٤٥٣٠c = true;
                }
            }
            boolean z12 = this.mCurItem != i10;
            if (this.mFirstLayout) {
                this.mCurItem = i10;
                if (z12) {
                    e(i10);
                }
                requestLayout();
                return;
            }
            populate(i10);
            t(i10, z10, i11, z12);
            return;
        }
        setScrollingCacheEnabled(false);
    }

    public void setPageTransformer(boolean z10, k kVar, int i10) {
        boolean z11 = kVar != null;
        boolean z12 = z11 != (this.mPageTransformer != null);
        this.mPageTransformer = kVar;
        setChildrenDrawingOrderEnabled(z11);
        if (z11) {
            this.mDrawingOrder = z10 ? 2 : 1;
            this.mPageTransformerLayerType = i10;
        } else {
            this.mDrawingOrder = 0;
        }
        if (z12) {
            populate();
        }
    }

    void smoothScrollTo(int i10, int i11, int i12) {
        int scrollX;
        int abs;
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        Scroller scroller = this.mScroller;
        if (scroller != null && !scroller.isFinished()) {
            scrollX = this.mIsScrollStarted ? this.mScroller.getCurrX() : this.mScroller.getStartX();
            this.mScroller.abortAnimation();
            setScrollingCacheEnabled(false);
        } else {
            scrollX = getScrollX();
        }
        int i13 = scrollX;
        int scrollY = getScrollY();
        int i14 = i10 - i13;
        int i15 = i11 - scrollY;
        if (i14 == 0 && i15 == 0) {
            b(false);
            populate();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int clientWidth = getClientWidth();
        int i16 = clientWidth / 2;
        float f10 = clientWidth;
        float f11 = i16;
        float distanceInfluenceForSnapDuration = f11 + (distanceInfluenceForSnapDuration(Math.min(1.0f, (Math.abs(i14) * 1.0f) / f10)) * f11);
        int abs2 = Math.abs(i12);
        if (abs2 > 0) {
            abs = Math.round(Math.abs(distanceInfluenceForSnapDuration / abs2) * 1000.0f) * 4;
        } else {
            abs = (int) (((Math.abs(i14) / ((f10 * this.mAdapter.getPageWidth(this.mCurItem)) + this.mPageMargin)) + 1.0f) * 100.0f);
        }
        int min = Math.min(abs, MAX_SETTLE_DURATION);
        this.mIsScrollStarted = false;
        this.mScroller.startScroll(i13, scrollY, i14, i15, min);
        d1.h0(this);
    }

    public void setCurrentItem(int i10, boolean z10) {
        this.mPopulatePending = false;
        setCurrentItemInternal(i10, z10, false);
    }

    public void setPageMarginDrawable(int i10) {
        setPageMarginDrawable(androidx.core.content.a.getDrawable(getContext(), i10));
    }

    public ViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mItems = new ArrayList<>();
        this.mTempItem = new f();
        this.mTempRect = new Rect();
        this.mRestoredCurItem = -1;
        this.mRestoredAdapterState = null;
        this.mRestoredClassLoader = null;
        this.mFirstOffset = -3.4028235E38f;
        this.mLastOffset = Float.MAX_VALUE;
        this.mOffscreenPageLimit = 1;
        this.mActivePointerId = -1;
        this.mFirstLayout = true;
        this.mNeedCalculatePageOffsets = false;
        this.mEndScrollRunnable = new c();
        this.mScrollState = 0;
        initViewPager();
    }
}
