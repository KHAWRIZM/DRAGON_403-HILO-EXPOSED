package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.core.view.d1;
import com.qiahao.base_common.download.okDownload.DownloadProgress;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class LinearLayoutCompat extends ViewGroup {
    private static final String ACCESSIBILITY_CLASS_NAME = "androidx.appcompat.widget.LinearLayoutCompat";
    public static final int HORIZONTAL = 0;
    private static final int INDEX_BOTTOM = 2;
    private static final int INDEX_CENTER_VERTICAL = 0;
    private static final int INDEX_FILL = 3;
    private static final int INDEX_TOP = 1;
    public static final int SHOW_DIVIDER_BEGINNING = 1;
    public static final int SHOW_DIVIDER_END = 4;
    public static final int SHOW_DIVIDER_MIDDLE = 2;
    public static final int SHOW_DIVIDER_NONE = 0;
    public static final int VERTICAL = 1;
    private static final int VERTICAL_GRAVITY_COUNT = 4;
    private boolean mBaselineAligned;
    private int mBaselineAlignedChildIndex;
    private int mBaselineChildTop;
    private Drawable mDivider;
    private int mDividerHeight;
    private int mDividerPadding;
    private int mDividerWidth;
    private int mGravity;
    private int[] mMaxAscent;
    private int[] mMaxDescent;
    private int mOrientation;
    private int mShowDividers;
    private int mTotalLength;
    private boolean mUseLargestChild;
    private float mWeightSum;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class a extends LinearLayout.LayoutParams {
        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public a(int i10, int i11) {
            super(i10, i11);
        }

        public a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public a(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }
    }

    public LinearLayoutCompat(Context context) {
        this(context, null);
    }

    private void e(int i10, int i11) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
        for (int i12 = 0; i12 < i10; i12++) {
            View virtualChildAt = getVirtualChildAt(i12);
            if (virtualChildAt.getVisibility() != 8) {
                a aVar = (a) virtualChildAt.getLayoutParams();
                if (((LinearLayout.LayoutParams) aVar).height == -1) {
                    int i13 = ((LinearLayout.LayoutParams) aVar).width;
                    ((LinearLayout.LayoutParams) aVar).width = virtualChildAt.getMeasuredWidth();
                    measureChildWithMargins(virtualChildAt, i11, 0, makeMeasureSpec, 0);
                    ((LinearLayout.LayoutParams) aVar).width = i13;
                }
            }
        }
    }

    private void f(int i10, int i11) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        for (int i12 = 0; i12 < i10; i12++) {
            View virtualChildAt = getVirtualChildAt(i12);
            if (virtualChildAt.getVisibility() != 8) {
                a aVar = (a) virtualChildAt.getLayoutParams();
                if (((LinearLayout.LayoutParams) aVar).width == -1) {
                    int i13 = ((LinearLayout.LayoutParams) aVar).height;
                    ((LinearLayout.LayoutParams) aVar).height = virtualChildAt.getMeasuredHeight();
                    measureChildWithMargins(virtualChildAt, makeMeasureSpec, 0, i11, 0);
                    ((LinearLayout.LayoutParams) aVar).height = i13;
                }
            }
        }
    }

    private void i(View view, int i10, int i11, int i12, int i13) {
        view.layout(i10, i11, i12 + i10, i13 + i11);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof a;
    }

    void drawDividersHorizontal(Canvas canvas) {
        int right;
        int left;
        int i10;
        int left2;
        int virtualChildCount = getVirtualChildCount();
        boolean b10 = a1.b(this);
        for (int i11 = 0; i11 < virtualChildCount; i11++) {
            View virtualChildAt = getVirtualChildAt(i11);
            if (virtualChildAt != null && virtualChildAt.getVisibility() != 8 && hasDividerBeforeChildAt(i11)) {
                a aVar = (a) virtualChildAt.getLayoutParams();
                if (b10) {
                    left2 = virtualChildAt.getRight() + ((LinearLayout.LayoutParams) aVar).rightMargin;
                } else {
                    left2 = (virtualChildAt.getLeft() - ((LinearLayout.LayoutParams) aVar).leftMargin) - this.mDividerWidth;
                }
                drawVerticalDivider(canvas, left2);
            }
        }
        if (hasDividerBeforeChildAt(virtualChildCount)) {
            View virtualChildAt2 = getVirtualChildAt(virtualChildCount - 1);
            if (virtualChildAt2 == null) {
                if (b10) {
                    right = getPaddingLeft();
                } else {
                    left = getWidth() - getPaddingRight();
                    i10 = this.mDividerWidth;
                    right = left - i10;
                }
            } else {
                a aVar2 = (a) virtualChildAt2.getLayoutParams();
                if (b10) {
                    left = virtualChildAt2.getLeft() - ((LinearLayout.LayoutParams) aVar2).leftMargin;
                    i10 = this.mDividerWidth;
                    right = left - i10;
                } else {
                    right = virtualChildAt2.getRight() + ((LinearLayout.LayoutParams) aVar2).rightMargin;
                }
            }
            drawVerticalDivider(canvas, right);
        }
    }

    void drawDividersVertical(Canvas canvas) {
        int bottom;
        int virtualChildCount = getVirtualChildCount();
        for (int i10 = 0; i10 < virtualChildCount; i10++) {
            View virtualChildAt = getVirtualChildAt(i10);
            if (virtualChildAt != null && virtualChildAt.getVisibility() != 8 && hasDividerBeforeChildAt(i10)) {
                drawHorizontalDivider(canvas, (virtualChildAt.getTop() - ((LinearLayout.LayoutParams) ((a) virtualChildAt.getLayoutParams())).topMargin) - this.mDividerHeight);
            }
        }
        if (hasDividerBeforeChildAt(virtualChildCount)) {
            View virtualChildAt2 = getVirtualChildAt(virtualChildCount - 1);
            if (virtualChildAt2 == null) {
                bottom = (getHeight() - getPaddingBottom()) - this.mDividerHeight;
            } else {
                bottom = virtualChildAt2.getBottom() + ((LinearLayout.LayoutParams) ((a) virtualChildAt2.getLayoutParams())).bottomMargin;
            }
            drawHorizontalDivider(canvas, bottom);
        }
    }

    void drawHorizontalDivider(Canvas canvas, int i10) {
        this.mDivider.setBounds(getPaddingLeft() + this.mDividerPadding, i10, (getWidth() - getPaddingRight()) - this.mDividerPadding, this.mDividerHeight + i10);
        this.mDivider.draw(canvas);
    }

    void drawVerticalDivider(Canvas canvas, int i10) {
        this.mDivider.setBounds(i10, getPaddingTop() + this.mDividerPadding, this.mDividerWidth + i10, (getHeight() - getPaddingBottom()) - this.mDividerPadding);
        this.mDivider.draw(canvas);
    }

    @Override // android.view.View
    public int getBaseline() {
        int i10;
        if (this.mBaselineAlignedChildIndex < 0) {
            return super.getBaseline();
        }
        int childCount = getChildCount();
        int i11 = this.mBaselineAlignedChildIndex;
        if (childCount > i11) {
            View childAt = getChildAt(i11);
            int baseline = childAt.getBaseline();
            if (baseline == -1) {
                if (this.mBaselineAlignedChildIndex == 0) {
                    return -1;
                }
                throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
            }
            int i12 = this.mBaselineChildTop;
            if (this.mOrientation == 1 && (i10 = this.mGravity & 112) != 48) {
                if (i10 != 16) {
                    if (i10 == 80) {
                        i12 = ((getBottom() - getTop()) - getPaddingBottom()) - this.mTotalLength;
                    }
                } else {
                    i12 += ((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.mTotalLength) / 2;
                }
            }
            return i12 + ((LinearLayout.LayoutParams) ((a) childAt.getLayoutParams())).topMargin + baseline;
        }
        throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
    }

    public int getBaselineAlignedChildIndex() {
        return this.mBaselineAlignedChildIndex;
    }

    int getChildrenSkipCount(View view, int i10) {
        return 0;
    }

    public Drawable getDividerDrawable() {
        return this.mDivider;
    }

    public int getDividerPadding() {
        return this.mDividerPadding;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int getDividerWidth() {
        return this.mDividerWidth;
    }

    public int getGravity() {
        return this.mGravity;
    }

    int getLocationOffset(View view) {
        return 0;
    }

    int getNextLocationOffset(View view) {
        return 0;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public int getShowDividers() {
        return this.mShowDividers;
    }

    View getVirtualChildAt(int i10) {
        return getChildAt(i10);
    }

    int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.mWeightSum;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean hasDividerBeforeChildAt(int i10) {
        if (i10 == 0) {
            if ((this.mShowDividers & 1) == 0) {
                return false;
            }
            return true;
        }
        if (i10 == getChildCount()) {
            if ((this.mShowDividers & 4) == 0) {
                return false;
            }
            return true;
        }
        if ((this.mShowDividers & 2) == 0) {
            return false;
        }
        for (int i11 = i10 - 1; i11 >= 0; i11--) {
            if (getChildAt(i11).getVisibility() != 8) {
                return true;
            }
        }
        return false;
    }

    public boolean isBaselineAligned() {
        return this.mBaselineAligned;
    }

    public boolean isMeasureWithLargestChildEnabled() {
        return this.mUseLargestChild;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00ec  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void layoutHorizontal(int i10, int i11, int i12, int i13) {
        int paddingLeft;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        boolean b10 = a1.b(this);
        int paddingTop = getPaddingTop();
        int i23 = i13 - i11;
        int paddingBottom = i23 - getPaddingBottom();
        int paddingBottom2 = (i23 - paddingTop) - getPaddingBottom();
        int virtualChildCount = getVirtualChildCount();
        int i24 = this.mGravity;
        int i25 = i24 & 112;
        boolean z10 = this.mBaselineAligned;
        int[] iArr = this.mMaxAscent;
        int[] iArr2 = this.mMaxDescent;
        int b11 = androidx.core.view.t.b(8388615 & i24, getLayoutDirection());
        if (b11 != 1) {
            if (b11 != 5) {
                paddingLeft = getPaddingLeft();
            } else {
                paddingLeft = ((getPaddingLeft() + i12) - i10) - this.mTotalLength;
            }
        } else {
            paddingLeft = getPaddingLeft() + (((i12 - i10) - this.mTotalLength) / 2);
        }
        if (b10) {
            i14 = virtualChildCount - 1;
            i15 = -1;
        } else {
            i14 = 0;
            i15 = 1;
        }
        int i26 = 0;
        while (i26 < virtualChildCount) {
            int i27 = i14 + (i15 * i26);
            View virtualChildAt = getVirtualChildAt(i27);
            if (virtualChildAt == null) {
                paddingLeft += measureNullChild(i27);
            } else if (virtualChildAt.getVisibility() != 8) {
                int measuredWidth = virtualChildAt.getMeasuredWidth();
                int measuredHeight = virtualChildAt.getMeasuredHeight();
                a aVar = (a) virtualChildAt.getLayoutParams();
                int i28 = i26;
                if (z10) {
                    i16 = virtualChildCount;
                    if (((LinearLayout.LayoutParams) aVar).height != -1) {
                        i17 = virtualChildAt.getBaseline();
                        i18 = ((LinearLayout.LayoutParams) aVar).gravity;
                        if (i18 < 0) {
                            i18 = i25;
                        }
                        i19 = i18 & 112;
                        i20 = i25;
                        if (i19 == 16) {
                            if (i19 != 48) {
                                if (i19 != 80) {
                                    i21 = paddingTop;
                                } else {
                                    i21 = (paddingBottom - measuredHeight) - ((LinearLayout.LayoutParams) aVar).bottomMargin;
                                    if (i17 != -1) {
                                        i21 -= iArr2[2] - (virtualChildAt.getMeasuredHeight() - i17);
                                    }
                                }
                            } else {
                                i21 = ((LinearLayout.LayoutParams) aVar).topMargin + paddingTop;
                                if (i17 != -1) {
                                    i21 += iArr[1] - i17;
                                }
                            }
                        } else {
                            i21 = ((((paddingBottom2 - measuredHeight) / 2) + paddingTop) + ((LinearLayout.LayoutParams) aVar).topMargin) - ((LinearLayout.LayoutParams) aVar).bottomMargin;
                        }
                        if (hasDividerBeforeChildAt(i27)) {
                            paddingLeft += this.mDividerWidth;
                        }
                        int i29 = ((LinearLayout.LayoutParams) aVar).leftMargin + paddingLeft;
                        i22 = paddingTop;
                        i(virtualChildAt, i29 + getLocationOffset(virtualChildAt), i21, measuredWidth, measuredHeight);
                        int nextLocationOffset = i29 + measuredWidth + ((LinearLayout.LayoutParams) aVar).rightMargin + getNextLocationOffset(virtualChildAt);
                        i26 = i28 + getChildrenSkipCount(virtualChildAt, i27);
                        paddingLeft = nextLocationOffset;
                        i26++;
                        virtualChildCount = i16;
                        i25 = i20;
                        paddingTop = i22;
                    }
                } else {
                    i16 = virtualChildCount;
                }
                i17 = -1;
                i18 = ((LinearLayout.LayoutParams) aVar).gravity;
                if (i18 < 0) {
                }
                i19 = i18 & 112;
                i20 = i25;
                if (i19 == 16) {
                }
                if (hasDividerBeforeChildAt(i27)) {
                }
                int i292 = ((LinearLayout.LayoutParams) aVar).leftMargin + paddingLeft;
                i22 = paddingTop;
                i(virtualChildAt, i292 + getLocationOffset(virtualChildAt), i21, measuredWidth, measuredHeight);
                int nextLocationOffset2 = i292 + measuredWidth + ((LinearLayout.LayoutParams) aVar).rightMargin + getNextLocationOffset(virtualChildAt);
                i26 = i28 + getChildrenSkipCount(virtualChildAt, i27);
                paddingLeft = nextLocationOffset2;
                i26++;
                virtualChildCount = i16;
                i25 = i20;
                paddingTop = i22;
            }
            i22 = paddingTop;
            i16 = virtualChildCount;
            i20 = i25;
            i26++;
            virtualChildCount = i16;
            i25 = i20;
            paddingTop = i22;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00a1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void layoutVertical(int i10, int i11, int i12, int i13) {
        int paddingTop;
        int i14;
        int i15;
        int i16;
        int paddingLeft = getPaddingLeft();
        int i17 = i12 - i10;
        int paddingRight = i17 - getPaddingRight();
        int paddingRight2 = (i17 - paddingLeft) - getPaddingRight();
        int virtualChildCount = getVirtualChildCount();
        int i18 = this.mGravity;
        int i19 = i18 & 112;
        int i20 = i18 & 8388615;
        if (i19 != 16) {
            if (i19 != 80) {
                paddingTop = getPaddingTop();
            } else {
                paddingTop = ((getPaddingTop() + i13) - i11) - this.mTotalLength;
            }
        } else {
            paddingTop = getPaddingTop() + (((i13 - i11) - this.mTotalLength) / 2);
        }
        int i21 = 0;
        while (i21 < virtualChildCount) {
            View virtualChildAt = getVirtualChildAt(i21);
            if (virtualChildAt == null) {
                paddingTop += measureNullChild(i21);
            } else if (virtualChildAt.getVisibility() != 8) {
                int measuredWidth = virtualChildAt.getMeasuredWidth();
                int measuredHeight = virtualChildAt.getMeasuredHeight();
                a aVar = (a) virtualChildAt.getLayoutParams();
                int i22 = ((LinearLayout.LayoutParams) aVar).gravity;
                if (i22 < 0) {
                    i22 = i20;
                }
                int b10 = androidx.core.view.t.b(i22, getLayoutDirection()) & 7;
                if (b10 != 1) {
                    if (b10 != 5) {
                        i16 = ((LinearLayout.LayoutParams) aVar).leftMargin + paddingLeft;
                        int i23 = i16;
                        if (hasDividerBeforeChildAt(i21)) {
                            paddingTop += this.mDividerHeight;
                        }
                        int i24 = paddingTop + ((LinearLayout.LayoutParams) aVar).topMargin;
                        i(virtualChildAt, i23, i24 + getLocationOffset(virtualChildAt), measuredWidth, measuredHeight);
                        int nextLocationOffset = i24 + measuredHeight + ((LinearLayout.LayoutParams) aVar).bottomMargin + getNextLocationOffset(virtualChildAt);
                        i21 += getChildrenSkipCount(virtualChildAt, i21);
                        paddingTop = nextLocationOffset;
                    } else {
                        i14 = paddingRight - measuredWidth;
                        i15 = ((LinearLayout.LayoutParams) aVar).rightMargin;
                    }
                } else {
                    i14 = ((paddingRight2 - measuredWidth) / 2) + paddingLeft + ((LinearLayout.LayoutParams) aVar).leftMargin;
                    i15 = ((LinearLayout.LayoutParams) aVar).rightMargin;
                }
                i16 = i14 - i15;
                int i232 = i16;
                if (hasDividerBeforeChildAt(i21)) {
                }
                int i242 = paddingTop + ((LinearLayout.LayoutParams) aVar).topMargin;
                i(virtualChildAt, i232, i242 + getLocationOffset(virtualChildAt), measuredWidth, measuredHeight);
                int nextLocationOffset2 = i242 + measuredHeight + ((LinearLayout.LayoutParams) aVar).bottomMargin + getNextLocationOffset(virtualChildAt);
                i21 += getChildrenSkipCount(virtualChildAt, i21);
                paddingTop = nextLocationOffset2;
            }
            i21++;
        }
    }

    void measureChildBeforeLayout(View view, int i10, int i11, int i12, int i13, int i14) {
        measureChildWithMargins(view, i11, i12, i13, i14);
    }

    /* JADX WARN: Removed duplicated region for block: B:200:0x0455  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01d5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void measureHorizontal(int i10, int i11) {
        boolean z10;
        int[] iArr;
        int i12;
        int max;
        int i13;
        int i14;
        int i15;
        int max2;
        int i16;
        int i17;
        int i18;
        float f10;
        boolean z11;
        int i19;
        boolean z12;
        int baseline;
        int i20;
        int i21;
        int i22;
        int i23;
        int i24;
        int i25;
        boolean z13;
        boolean z14;
        View view;
        int i26;
        boolean z15;
        int measuredHeight;
        int childrenSkipCount;
        int baseline2;
        int i27;
        this.mTotalLength = 0;
        int virtualChildCount = getVirtualChildCount();
        int mode = View.MeasureSpec.getMode(i10);
        int mode2 = View.MeasureSpec.getMode(i11);
        if (this.mMaxAscent == null || this.mMaxDescent == null) {
            this.mMaxAscent = new int[4];
            this.mMaxDescent = new int[4];
        }
        int[] iArr2 = this.mMaxAscent;
        int[] iArr3 = this.mMaxDescent;
        iArr2[3] = -1;
        iArr2[2] = -1;
        iArr2[1] = -1;
        iArr2[0] = -1;
        iArr3[3] = -1;
        iArr3[2] = -1;
        iArr3[1] = -1;
        iArr3[0] = -1;
        boolean z16 = this.mBaselineAligned;
        boolean z17 = this.mUseLargestChild;
        int i28 = 1073741824;
        if (mode == 1073741824) {
            z10 = true;
        } else {
            z10 = false;
        }
        float f11 = DownloadProgress.UNKNOWN_PROGRESS;
        int i29 = 0;
        int i30 = 0;
        int i31 = 0;
        int i32 = 0;
        int i33 = 0;
        boolean z18 = false;
        int i34 = 0;
        boolean z19 = true;
        boolean z20 = false;
        while (true) {
            iArr = iArr3;
            if (i29 >= virtualChildCount) {
                break;
            }
            View virtualChildAt = getVirtualChildAt(i29);
            if (virtualChildAt == null) {
                this.mTotalLength += measureNullChild(i29);
            } else if (virtualChildAt.getVisibility() == 8) {
                i29 += getChildrenSkipCount(virtualChildAt, i29);
            } else {
                if (hasDividerBeforeChildAt(i29)) {
                    this.mTotalLength += this.mDividerWidth;
                }
                a aVar = (a) virtualChildAt.getLayoutParams();
                float f12 = ((LinearLayout.LayoutParams) aVar).weight;
                float f13 = f11 + f12;
                if (mode == i28 && ((LinearLayout.LayoutParams) aVar).width == 0 && f12 > DownloadProgress.UNKNOWN_PROGRESS) {
                    if (z10) {
                        this.mTotalLength += ((LinearLayout.LayoutParams) aVar).leftMargin + ((LinearLayout.LayoutParams) aVar).rightMargin;
                    } else {
                        int i35 = this.mTotalLength;
                        this.mTotalLength = Math.max(i35, ((LinearLayout.LayoutParams) aVar).leftMargin + i35 + ((LinearLayout.LayoutParams) aVar).rightMargin);
                    }
                    if (z16) {
                        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                        virtualChildAt.measure(makeMeasureSpec, makeMeasureSpec);
                        i25 = i29;
                        z13 = z17;
                        z14 = z16;
                        view = virtualChildAt;
                    } else {
                        i25 = i29;
                        z13 = z17;
                        z14 = z16;
                        view = virtualChildAt;
                        i26 = 1073741824;
                        z18 = true;
                        if (mode2 == i26 && ((LinearLayout.LayoutParams) aVar).height == -1) {
                            z15 = true;
                            z20 = true;
                        } else {
                            z15 = false;
                        }
                        int i36 = ((LinearLayout.LayoutParams) aVar).topMargin + ((LinearLayout.LayoutParams) aVar).bottomMargin;
                        measuredHeight = view.getMeasuredHeight() + i36;
                        i34 = View.combineMeasuredStates(i34, view.getMeasuredState());
                        if (z14 && (baseline2 = view.getBaseline()) != -1) {
                            i27 = ((LinearLayout.LayoutParams) aVar).gravity;
                            if (i27 < 0) {
                                i27 = this.mGravity;
                            }
                            int i37 = (((i27 & 112) >> 4) & (-2)) >> 1;
                            iArr2[i37] = Math.max(iArr2[i37], baseline2);
                            iArr[i37] = Math.max(iArr[i37], measuredHeight - baseline2);
                        }
                        i31 = Math.max(i31, measuredHeight);
                        if (!z19 && ((LinearLayout.LayoutParams) aVar).height == -1) {
                            z19 = true;
                        } else {
                            z19 = false;
                        }
                        if (((LinearLayout.LayoutParams) aVar).weight <= DownloadProgress.UNKNOWN_PROGRESS) {
                            if (!z15) {
                                i36 = measuredHeight;
                            }
                            i33 = Math.max(i33, i36);
                        } else {
                            int i38 = i33;
                            if (!z15) {
                                i36 = measuredHeight;
                            }
                            i32 = Math.max(i32, i36);
                            i33 = i38;
                        }
                        int i39 = i25;
                        childrenSkipCount = getChildrenSkipCount(view, i39) + i39;
                        f11 = f13;
                        i29 = childrenSkipCount + 1;
                        iArr3 = iArr;
                        z17 = z13;
                        z16 = z14;
                        i28 = 1073741824;
                    }
                } else {
                    if (((LinearLayout.LayoutParams) aVar).width == 0 && f12 > DownloadProgress.UNKNOWN_PROGRESS) {
                        ((LinearLayout.LayoutParams) aVar).width = -2;
                        i23 = 0;
                    } else {
                        i23 = Integer.MIN_VALUE;
                    }
                    if (f13 == DownloadProgress.UNKNOWN_PROGRESS) {
                        i24 = this.mTotalLength;
                    } else {
                        i24 = 0;
                    }
                    i25 = i29;
                    int i40 = i23;
                    z13 = z17;
                    z14 = z16;
                    measureChildBeforeLayout(virtualChildAt, i25, i10, i24, i11, 0);
                    if (i40 != Integer.MIN_VALUE) {
                        ((LinearLayout.LayoutParams) aVar).width = i40;
                    }
                    int measuredWidth = virtualChildAt.getMeasuredWidth();
                    if (z10) {
                        view = virtualChildAt;
                        this.mTotalLength += ((LinearLayout.LayoutParams) aVar).leftMargin + measuredWidth + ((LinearLayout.LayoutParams) aVar).rightMargin + getNextLocationOffset(view);
                    } else {
                        view = virtualChildAt;
                        int i41 = this.mTotalLength;
                        this.mTotalLength = Math.max(i41, i41 + measuredWidth + ((LinearLayout.LayoutParams) aVar).leftMargin + ((LinearLayout.LayoutParams) aVar).rightMargin + getNextLocationOffset(view));
                    }
                    if (z13) {
                        i30 = Math.max(measuredWidth, i30);
                    }
                }
                i26 = 1073741824;
                if (mode2 == i26) {
                }
                z15 = false;
                int i362 = ((LinearLayout.LayoutParams) aVar).topMargin + ((LinearLayout.LayoutParams) aVar).bottomMargin;
                measuredHeight = view.getMeasuredHeight() + i362;
                i34 = View.combineMeasuredStates(i34, view.getMeasuredState());
                if (z14) {
                    i27 = ((LinearLayout.LayoutParams) aVar).gravity;
                    if (i27 < 0) {
                    }
                    int i372 = (((i27 & 112) >> 4) & (-2)) >> 1;
                    iArr2[i372] = Math.max(iArr2[i372], baseline2);
                    iArr[i372] = Math.max(iArr[i372], measuredHeight - baseline2);
                }
                i31 = Math.max(i31, measuredHeight);
                if (!z19) {
                }
                z19 = false;
                if (((LinearLayout.LayoutParams) aVar).weight <= DownloadProgress.UNKNOWN_PROGRESS) {
                }
                int i392 = i25;
                childrenSkipCount = getChildrenSkipCount(view, i392) + i392;
                f11 = f13;
                i29 = childrenSkipCount + 1;
                iArr3 = iArr;
                z17 = z13;
                z16 = z14;
                i28 = 1073741824;
            }
            childrenSkipCount = i29;
            z13 = z17;
            z14 = z16;
            i29 = childrenSkipCount + 1;
            iArr3 = iArr;
            z17 = z13;
            z16 = z14;
            i28 = 1073741824;
        }
        boolean z21 = z17;
        boolean z22 = z16;
        int i42 = i31;
        int i43 = i32;
        int i44 = i33;
        int i45 = i34;
        if (this.mTotalLength > 0 && hasDividerBeforeChildAt(virtualChildCount)) {
            this.mTotalLength += this.mDividerWidth;
        }
        int i46 = iArr2[1];
        if (i46 == -1 && iArr2[0] == -1 && iArr2[2] == -1 && iArr2[3] == -1) {
            max = i42;
            i12 = i45;
        } else {
            i12 = i45;
            max = Math.max(i42, Math.max(iArr2[3], Math.max(iArr2[0], Math.max(i46, iArr2[2]))) + Math.max(iArr[3], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))));
        }
        if (z21 && (mode == Integer.MIN_VALUE || mode == 0)) {
            this.mTotalLength = 0;
            int i47 = 0;
            while (i47 < virtualChildCount) {
                View virtualChildAt2 = getVirtualChildAt(i47);
                if (virtualChildAt2 == null) {
                    this.mTotalLength += measureNullChild(i47);
                } else if (virtualChildAt2.getVisibility() == 8) {
                    i47 += getChildrenSkipCount(virtualChildAt2, i47);
                } else {
                    a aVar2 = (a) virtualChildAt2.getLayoutParams();
                    if (z10) {
                        this.mTotalLength += ((LinearLayout.LayoutParams) aVar2).leftMargin + i30 + ((LinearLayout.LayoutParams) aVar2).rightMargin + getNextLocationOffset(virtualChildAt2);
                    } else {
                        int i48 = this.mTotalLength;
                        i22 = max;
                        this.mTotalLength = Math.max(i48, i48 + i30 + ((LinearLayout.LayoutParams) aVar2).leftMargin + ((LinearLayout.LayoutParams) aVar2).rightMargin + getNextLocationOffset(virtualChildAt2));
                        i47++;
                        max = i22;
                    }
                }
                i22 = max;
                i47++;
                max = i22;
            }
        }
        int i49 = max;
        int paddingLeft = this.mTotalLength + getPaddingLeft() + getPaddingRight();
        this.mTotalLength = paddingLeft;
        int resolveSizeAndState = View.resolveSizeAndState(Math.max(paddingLeft, getSuggestedMinimumWidth()), i10, 0);
        int i50 = (16777215 & resolveSizeAndState) - this.mTotalLength;
        if (!z18 && (i50 == 0 || f11 <= DownloadProgress.UNKNOWN_PROGRESS)) {
            i16 = Math.max(i43, i44);
            if (z21 && mode != 1073741824) {
                for (int i51 = 0; i51 < virtualChildCount; i51++) {
                    View virtualChildAt3 = getVirtualChildAt(i51);
                    if (virtualChildAt3 != null && virtualChildAt3.getVisibility() != 8 && ((LinearLayout.LayoutParams) ((a) virtualChildAt3.getLayoutParams())).weight > DownloadProgress.UNKNOWN_PROGRESS) {
                        virtualChildAt3.measure(View.MeasureSpec.makeMeasureSpec(i30, 1073741824), View.MeasureSpec.makeMeasureSpec(virtualChildAt3.getMeasuredHeight(), 1073741824));
                    }
                }
            }
            i14 = i11;
            i15 = virtualChildCount;
            i13 = i12;
        } else {
            float f14 = this.mWeightSum;
            if (f14 > DownloadProgress.UNKNOWN_PROGRESS) {
                f11 = f14;
            }
            iArr2[3] = -1;
            iArr2[2] = -1;
            iArr2[1] = -1;
            iArr2[0] = -1;
            iArr[3] = -1;
            iArr[2] = -1;
            iArr[1] = -1;
            iArr[0] = -1;
            this.mTotalLength = 0;
            int i52 = i43;
            i13 = i12;
            int i53 = -1;
            int i54 = 0;
            while (i54 < virtualChildCount) {
                View virtualChildAt4 = getVirtualChildAt(i54);
                if (virtualChildAt4 == null || virtualChildAt4.getVisibility() == 8) {
                    i17 = i50;
                    i18 = virtualChildCount;
                } else {
                    a aVar3 = (a) virtualChildAt4.getLayoutParams();
                    float f15 = ((LinearLayout.LayoutParams) aVar3).weight;
                    if (f15 > DownloadProgress.UNKNOWN_PROGRESS) {
                        int i55 = (int) ((i50 * f15) / f11);
                        float f16 = f11 - f15;
                        int i56 = i50 - i55;
                        i18 = virtualChildCount;
                        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i11, getPaddingTop() + getPaddingBottom() + ((LinearLayout.LayoutParams) aVar3).topMargin + ((LinearLayout.LayoutParams) aVar3).bottomMargin, ((LinearLayout.LayoutParams) aVar3).height);
                        if (((LinearLayout.LayoutParams) aVar3).width == 0) {
                            i21 = 1073741824;
                            if (mode == 1073741824) {
                                if (i55 <= 0) {
                                    i55 = 0;
                                }
                                virtualChildAt4.measure(View.MeasureSpec.makeMeasureSpec(i55, 1073741824), childMeasureSpec);
                                i13 = View.combineMeasuredStates(i13, virtualChildAt4.getMeasuredState() & (-16777216));
                                f11 = f16;
                                i17 = i56;
                            }
                        } else {
                            i21 = 1073741824;
                        }
                        int measuredWidth2 = virtualChildAt4.getMeasuredWidth() + i55;
                        if (measuredWidth2 < 0) {
                            measuredWidth2 = 0;
                        }
                        virtualChildAt4.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth2, i21), childMeasureSpec);
                        i13 = View.combineMeasuredStates(i13, virtualChildAt4.getMeasuredState() & (-16777216));
                        f11 = f16;
                        i17 = i56;
                    } else {
                        i17 = i50;
                        i18 = virtualChildCount;
                    }
                    if (z10) {
                        this.mTotalLength += virtualChildAt4.getMeasuredWidth() + ((LinearLayout.LayoutParams) aVar3).leftMargin + ((LinearLayout.LayoutParams) aVar3).rightMargin + getNextLocationOffset(virtualChildAt4);
                        f10 = f11;
                    } else {
                        int i57 = this.mTotalLength;
                        f10 = f11;
                        this.mTotalLength = Math.max(i57, virtualChildAt4.getMeasuredWidth() + i57 + ((LinearLayout.LayoutParams) aVar3).leftMargin + ((LinearLayout.LayoutParams) aVar3).rightMargin + getNextLocationOffset(virtualChildAt4));
                    }
                    if (mode2 != 1073741824 && ((LinearLayout.LayoutParams) aVar3).height == -1) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    int i58 = ((LinearLayout.LayoutParams) aVar3).topMargin + ((LinearLayout.LayoutParams) aVar3).bottomMargin;
                    int measuredHeight2 = virtualChildAt4.getMeasuredHeight() + i58;
                    i53 = Math.max(i53, measuredHeight2);
                    if (!z11) {
                        i58 = measuredHeight2;
                    }
                    int max3 = Math.max(i52, i58);
                    if (z19) {
                        i19 = -1;
                        if (((LinearLayout.LayoutParams) aVar3).height == -1) {
                            z12 = true;
                            if (z22 && (baseline = virtualChildAt4.getBaseline()) != i19) {
                                i20 = ((LinearLayout.LayoutParams) aVar3).gravity;
                                if (i20 < 0) {
                                    i20 = this.mGravity;
                                }
                                int i59 = (((i20 & 112) >> 4) & (-2)) >> 1;
                                iArr2[i59] = Math.max(iArr2[i59], baseline);
                                iArr[i59] = Math.max(iArr[i59], measuredHeight2 - baseline);
                            }
                            z19 = z12;
                            i52 = max3;
                            f11 = f10;
                        }
                    } else {
                        i19 = -1;
                    }
                    z12 = false;
                    if (z22) {
                        i20 = ((LinearLayout.LayoutParams) aVar3).gravity;
                        if (i20 < 0) {
                        }
                        int i592 = (((i20 & 112) >> 4) & (-2)) >> 1;
                        iArr2[i592] = Math.max(iArr2[i592], baseline);
                        iArr[i592] = Math.max(iArr[i592], measuredHeight2 - baseline);
                    }
                    z19 = z12;
                    i52 = max3;
                    f11 = f10;
                }
                i54++;
                i50 = i17;
                virtualChildCount = i18;
            }
            i14 = i11;
            i15 = virtualChildCount;
            this.mTotalLength += getPaddingLeft() + getPaddingRight();
            int i60 = iArr2[1];
            if (i60 == -1 && iArr2[0] == -1 && iArr2[2] == -1 && iArr2[3] == -1) {
                max2 = i53;
            } else {
                max2 = Math.max(i53, Math.max(iArr2[3], Math.max(iArr2[0], Math.max(i60, iArr2[2]))) + Math.max(iArr[3], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))));
            }
            i49 = max2;
            i16 = i52;
        }
        if (z19 || mode2 == 1073741824) {
            i16 = i49;
        }
        setMeasuredDimension(resolveSizeAndState | ((-16777216) & i13), View.resolveSizeAndState(Math.max(i16 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i14, i13 << 16));
        if (z20) {
            e(i15, i10);
        }
    }

    int measureNullChild(int i10) {
        return 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:156:0x031a, code lost:
    
        if (((android.widget.LinearLayout.LayoutParams) r14).width == (-1)) goto L١٤٧;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void measureVertical(int i10, int i11) {
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        boolean z10;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        int i24;
        int i25;
        int i26;
        int i27;
        int i28;
        View view;
        int i29;
        boolean z11;
        this.mTotalLength = 0;
        int virtualChildCount = getVirtualChildCount();
        int mode = View.MeasureSpec.getMode(i10);
        int mode2 = View.MeasureSpec.getMode(i11);
        int i30 = this.mBaselineAlignedChildIndex;
        boolean z12 = this.mUseLargestChild;
        float f10 = DownloadProgress.UNKNOWN_PROGRESS;
        int i31 = 0;
        int i32 = 0;
        int i33 = 0;
        int i34 = 0;
        int i35 = 0;
        int i36 = 0;
        boolean z13 = false;
        boolean z14 = true;
        boolean z15 = false;
        while (true) {
            int i37 = 8;
            int i38 = i34;
            if (i36 < virtualChildCount) {
                View virtualChildAt = getVirtualChildAt(i36);
                if (virtualChildAt == null) {
                    this.mTotalLength += measureNullChild(i36);
                    i24 = mode2;
                    i34 = i38;
                    i26 = virtualChildCount;
                } else {
                    int i39 = i31;
                    if (virtualChildAt.getVisibility() == 8) {
                        i36 += getChildrenSkipCount(virtualChildAt, i36);
                        i34 = i38;
                        i31 = i39;
                        i26 = virtualChildCount;
                        i24 = mode2;
                    } else {
                        if (hasDividerBeforeChildAt(i36)) {
                            this.mTotalLength += this.mDividerHeight;
                        }
                        a aVar = (a) virtualChildAt.getLayoutParams();
                        float f11 = ((LinearLayout.LayoutParams) aVar).weight;
                        float f12 = f10 + f11;
                        if (mode2 == 1073741824 && ((LinearLayout.LayoutParams) aVar).height == 0 && f11 > DownloadProgress.UNKNOWN_PROGRESS) {
                            int i40 = this.mTotalLength;
                            this.mTotalLength = Math.max(i40, ((LinearLayout.LayoutParams) aVar).topMargin + i40 + ((LinearLayout.LayoutParams) aVar).bottomMargin);
                            i29 = i33;
                            view = virtualChildAt;
                            i27 = i35;
                            i22 = i39;
                            i23 = i32;
                            z13 = true;
                            i24 = mode2;
                            i25 = i38;
                            i26 = virtualChildCount;
                            i28 = i36;
                        } else {
                            int i41 = i32;
                            if (((LinearLayout.LayoutParams) aVar).height == 0 && f11 > DownloadProgress.UNKNOWN_PROGRESS) {
                                ((LinearLayout.LayoutParams) aVar).height = -2;
                                i20 = 0;
                            } else {
                                i20 = Integer.MIN_VALUE;
                            }
                            if (f12 == DownloadProgress.UNKNOWN_PROGRESS) {
                                i21 = this.mTotalLength;
                            } else {
                                i21 = 0;
                            }
                            i22 = i39;
                            int i42 = i20;
                            i23 = i41;
                            int i43 = i33;
                            i24 = mode2;
                            i25 = i38;
                            i26 = virtualChildCount;
                            i27 = i35;
                            i28 = i36;
                            measureChildBeforeLayout(virtualChildAt, i36, i10, 0, i11, i21);
                            if (i42 != Integer.MIN_VALUE) {
                                ((LinearLayout.LayoutParams) aVar).height = i42;
                            }
                            int measuredHeight = virtualChildAt.getMeasuredHeight();
                            int i44 = this.mTotalLength;
                            view = virtualChildAt;
                            this.mTotalLength = Math.max(i44, i44 + measuredHeight + ((LinearLayout.LayoutParams) aVar).topMargin + ((LinearLayout.LayoutParams) aVar).bottomMargin + getNextLocationOffset(view));
                            if (z12) {
                                i29 = Math.max(measuredHeight, i43);
                            } else {
                                i29 = i43;
                            }
                        }
                        if (i30 >= 0 && i30 == i28 + 1) {
                            this.mBaselineChildTop = this.mTotalLength;
                        }
                        if (i28 < i30 && ((LinearLayout.LayoutParams) aVar).weight > DownloadProgress.UNKNOWN_PROGRESS) {
                            throw new RuntimeException("A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex.");
                        }
                        if (mode != 1073741824 && ((LinearLayout.LayoutParams) aVar).width == -1) {
                            z11 = true;
                            z15 = true;
                        } else {
                            z11 = false;
                        }
                        int i45 = ((LinearLayout.LayoutParams) aVar).leftMargin + ((LinearLayout.LayoutParams) aVar).rightMargin;
                        int measuredWidth = view.getMeasuredWidth() + i45;
                        int max = Math.max(i23, measuredWidth);
                        int combineMeasuredStates = View.combineMeasuredStates(i22, view.getMeasuredState());
                        if (z14 && ((LinearLayout.LayoutParams) aVar).width == -1) {
                            z14 = true;
                        } else {
                            z14 = false;
                        }
                        if (((LinearLayout.LayoutParams) aVar).weight > DownloadProgress.UNKNOWN_PROGRESS) {
                            if (!z11) {
                                i45 = measuredWidth;
                            }
                            i34 = Math.max(i25, i45);
                        } else {
                            if (!z11) {
                                i45 = measuredWidth;
                            }
                            i27 = Math.max(i27, i45);
                            i34 = i25;
                        }
                        int childrenSkipCount = getChildrenSkipCount(view, i28) + i28;
                        i33 = i29;
                        i32 = max;
                        f10 = f12;
                        i35 = i27;
                        i36 = childrenSkipCount;
                        i31 = combineMeasuredStates;
                    }
                }
                i36++;
                virtualChildCount = i26;
                mode2 = i24;
            } else {
                int i46 = i31;
                int i47 = i33;
                int i48 = i35;
                int i49 = mode2;
                int i50 = i32;
                int i51 = virtualChildCount;
                if (this.mTotalLength > 0) {
                    i12 = i51;
                    if (hasDividerBeforeChildAt(i12)) {
                        this.mTotalLength += this.mDividerHeight;
                    }
                } else {
                    i12 = i51;
                }
                if (z12 && (i49 == Integer.MIN_VALUE || i49 == 0)) {
                    this.mTotalLength = 0;
                    int i52 = 0;
                    while (i52 < i12) {
                        View virtualChildAt2 = getVirtualChildAt(i52);
                        if (virtualChildAt2 == null) {
                            this.mTotalLength += measureNullChild(i52);
                        } else if (virtualChildAt2.getVisibility() == i37) {
                            i52 += getChildrenSkipCount(virtualChildAt2, i52);
                        } else {
                            a aVar2 = (a) virtualChildAt2.getLayoutParams();
                            int i53 = this.mTotalLength;
                            this.mTotalLength = Math.max(i53, i53 + i47 + ((LinearLayout.LayoutParams) aVar2).topMargin + ((LinearLayout.LayoutParams) aVar2).bottomMargin + getNextLocationOffset(virtualChildAt2));
                        }
                        i52++;
                        i37 = 8;
                    }
                }
                int paddingTop = this.mTotalLength + getPaddingTop() + getPaddingBottom();
                this.mTotalLength = paddingTop;
                int resolveSizeAndState = View.resolveSizeAndState(Math.max(paddingTop, getSuggestedMinimumHeight()), i11, 0);
                int i54 = (16777215 & resolveSizeAndState) - this.mTotalLength;
                if (!z13 && (i54 == 0 || f10 <= DownloadProgress.UNKNOWN_PROGRESS)) {
                    i15 = Math.max(i48, i38);
                    if (z12 && i49 != 1073741824) {
                        for (int i55 = 0; i55 < i12; i55++) {
                            View virtualChildAt3 = getVirtualChildAt(i55);
                            if (virtualChildAt3 != null && virtualChildAt3.getVisibility() != 8 && ((LinearLayout.LayoutParams) ((a) virtualChildAt3.getLayoutParams())).weight > DownloadProgress.UNKNOWN_PROGRESS) {
                                virtualChildAt3.measure(View.MeasureSpec.makeMeasureSpec(virtualChildAt3.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(i47, 1073741824));
                            }
                        }
                    }
                    i14 = i10;
                    i13 = i46;
                } else {
                    float f13 = this.mWeightSum;
                    if (f13 > DownloadProgress.UNKNOWN_PROGRESS) {
                        f10 = f13;
                    }
                    this.mTotalLength = 0;
                    int i56 = i54;
                    int i57 = i48;
                    i13 = i46;
                    int i58 = 0;
                    while (i58 < i12) {
                        View virtualChildAt4 = getVirtualChildAt(i58);
                        if (virtualChildAt4.getVisibility() == 8) {
                            i16 = i56;
                        } else {
                            a aVar3 = (a) virtualChildAt4.getLayoutParams();
                            float f14 = ((LinearLayout.LayoutParams) aVar3).weight;
                            if (f14 > DownloadProgress.UNKNOWN_PROGRESS) {
                                int i59 = (int) ((i56 * f14) / f10);
                                float f15 = f10 - f14;
                                i16 = i56 - i59;
                                int childMeasureSpec = ViewGroup.getChildMeasureSpec(i10, getPaddingLeft() + getPaddingRight() + ((LinearLayout.LayoutParams) aVar3).leftMargin + ((LinearLayout.LayoutParams) aVar3).rightMargin, ((LinearLayout.LayoutParams) aVar3).width);
                                if (((LinearLayout.LayoutParams) aVar3).height == 0) {
                                    i19 = 1073741824;
                                    if (i49 == 1073741824) {
                                        if (i59 <= 0) {
                                            i59 = 0;
                                        }
                                        virtualChildAt4.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(i59, 1073741824));
                                        i13 = View.combineMeasuredStates(i13, virtualChildAt4.getMeasuredState() & (-256));
                                        f10 = f15;
                                    }
                                } else {
                                    i19 = 1073741824;
                                }
                                int measuredHeight2 = virtualChildAt4.getMeasuredHeight() + i59;
                                if (measuredHeight2 < 0) {
                                    measuredHeight2 = 0;
                                }
                                virtualChildAt4.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(measuredHeight2, i19));
                                i13 = View.combineMeasuredStates(i13, virtualChildAt4.getMeasuredState() & (-256));
                                f10 = f15;
                            } else {
                                i16 = i56;
                            }
                            int i60 = ((LinearLayout.LayoutParams) aVar3).leftMargin + ((LinearLayout.LayoutParams) aVar3).rightMargin;
                            int measuredWidth2 = virtualChildAt4.getMeasuredWidth() + i60;
                            i50 = Math.max(i50, measuredWidth2);
                            float f16 = f10;
                            if (mode != 1073741824) {
                                i17 = i13;
                                i18 = -1;
                            } else {
                                i17 = i13;
                                i18 = -1;
                            }
                            i60 = measuredWidth2;
                            int max2 = Math.max(i57, i60);
                            if (z14 && ((LinearLayout.LayoutParams) aVar3).width == i18) {
                                z10 = true;
                            } else {
                                z10 = false;
                            }
                            int i61 = this.mTotalLength;
                            this.mTotalLength = Math.max(i61, virtualChildAt4.getMeasuredHeight() + i61 + ((LinearLayout.LayoutParams) aVar3).topMargin + ((LinearLayout.LayoutParams) aVar3).bottomMargin + getNextLocationOffset(virtualChildAt4));
                            z14 = z10;
                            i13 = i17;
                            i57 = max2;
                            f10 = f16;
                        }
                        i58++;
                        i56 = i16;
                    }
                    i14 = i10;
                    this.mTotalLength += getPaddingTop() + getPaddingBottom();
                    i15 = i57;
                }
                if (z14 || mode == 1073741824) {
                    i15 = i50;
                }
                setMeasuredDimension(View.resolveSizeAndState(Math.max(i15 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i14, i13), resolveSizeAndState);
                if (z15) {
                    f(i12, i11);
                    return;
                }
                return;
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.mDivider == null) {
            return;
        }
        if (this.mOrientation == 1) {
            drawDividersVertical(canvas);
        } else {
            drawDividersHorizontal(canvas);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(ACCESSIBILITY_CLASS_NAME);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(ACCESSIBILITY_CLASS_NAME);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        if (this.mOrientation == 1) {
            layoutVertical(i10, i11, i12, i13);
        } else {
            layoutHorizontal(i10, i11, i12, i13);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        if (this.mOrientation == 1) {
            measureVertical(i10, i11);
        } else {
            measureHorizontal(i10, i11);
        }
    }

    public void setBaselineAligned(boolean z10) {
        this.mBaselineAligned = z10;
    }

    public void setBaselineAlignedChildIndex(int i10) {
        if (i10 >= 0 && i10 < getChildCount()) {
            this.mBaselineAlignedChildIndex = i10;
            return;
        }
        throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
    }

    public void setDividerDrawable(Drawable drawable) {
        if (drawable == this.mDivider) {
            return;
        }
        this.mDivider = drawable;
        boolean z10 = false;
        if (drawable != null) {
            this.mDividerWidth = drawable.getIntrinsicWidth();
            this.mDividerHeight = drawable.getIntrinsicHeight();
        } else {
            this.mDividerWidth = 0;
            this.mDividerHeight = 0;
        }
        if (drawable == null) {
            z10 = true;
        }
        setWillNotDraw(z10);
        requestLayout();
    }

    public void setDividerPadding(int i10) {
        this.mDividerPadding = i10;
    }

    public void setGravity(int i10) {
        if (this.mGravity != i10) {
            if ((8388615 & i10) == 0) {
                i10 |= 8388611;
            }
            if ((i10 & 112) == 0) {
                i10 |= 48;
            }
            this.mGravity = i10;
            requestLayout();
        }
    }

    public void setHorizontalGravity(int i10) {
        int i11 = i10 & 8388615;
        int i12 = this.mGravity;
        if ((8388615 & i12) != i11) {
            this.mGravity = i11 | ((-8388616) & i12);
            requestLayout();
        }
    }

    public void setMeasureWithLargestChildEnabled(boolean z10) {
        this.mUseLargestChild = z10;
    }

    public void setOrientation(int i10) {
        if (this.mOrientation != i10) {
            this.mOrientation = i10;
            requestLayout();
        }
    }

    public void setShowDividers(int i10) {
        if (i10 != this.mShowDividers) {
            requestLayout();
        }
        this.mShowDividers = i10;
    }

    public void setVerticalGravity(int i10) {
        int i11 = i10 & 112;
        int i12 = this.mGravity;
        if ((i12 & 112) != i11) {
            this.mGravity = i11 | (i12 & (-113));
            requestLayout();
        }
    }

    public void setWeightSum(float f10) {
        this.mWeightSum = Math.max(DownloadProgress.UNKNOWN_PROGRESS, f10);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public LinearLayoutCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public a generateDefaultLayoutParams() {
        int i10 = this.mOrientation;
        if (i10 == 0) {
            return new a(-2, -2);
        }
        if (i10 == 1) {
            return new a(-1, -2);
        }
        return null;
    }

    public LinearLayoutCompat(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.mBaselineAligned = true;
        this.mBaselineAlignedChildIndex = -1;
        this.mBaselineChildTop = 0;
        this.mGravity = 8388659;
        int[] iArr = R.styleable.LinearLayoutCompat;
        p0 v10 = p0.v(context, attributeSet, iArr, i10, 0);
        d1.o0(this, context, iArr, attributeSet, v10.r(), i10, 0);
        int k10 = v10.k(R.styleable.LinearLayoutCompat_android_orientation, -1);
        if (k10 >= 0) {
            setOrientation(k10);
        }
        int k11 = v10.k(R.styleable.LinearLayoutCompat_android_gravity, -1);
        if (k11 >= 0) {
            setGravity(k11);
        }
        boolean a10 = v10.a(R.styleable.LinearLayoutCompat_android_baselineAligned, true);
        if (!a10) {
            setBaselineAligned(a10);
        }
        this.mWeightSum = v10.i(R.styleable.LinearLayoutCompat_android_weightSum, -1.0f);
        this.mBaselineAlignedChildIndex = v10.k(R.styleable.LinearLayoutCompat_android_baselineAlignedChildIndex, -1);
        this.mUseLargestChild = v10.a(R.styleable.LinearLayoutCompat_measureWithLargestChild, false);
        setDividerDrawable(v10.g(R.styleable.LinearLayoutCompat_divider));
        this.mShowDividers = v10.k(R.styleable.LinearLayoutCompat_showDividers, 0);
        this.mDividerPadding = v10.f(R.styleable.LinearLayoutCompat_dividerPadding, 0);
        v10.x();
    }

    @Override // android.view.ViewGroup
    public a generateLayoutParams(AttributeSet attributeSet) {
        return new a(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public a generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof a) {
            return new a((ViewGroup.MarginLayoutParams) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new a((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new a(layoutParams);
    }
}
