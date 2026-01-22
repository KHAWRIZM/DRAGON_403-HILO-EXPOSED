package com.qiahao.nextvideo.ui.reusable.views.recyclerview;

import android.annotation.SuppressLint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.IntRange;
import androidx.recyclerview.widget.RecyclerView;
import com.yalantis.ucrop.model.CustomIntentKey;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0015\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b \u0018\u0000 \u0082\u00012\u00020\u00012\u00020\u0002:\u0004\u0083\u0001\u0082\u0001B%\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ-\u0010\u0011\u001a\u00020\u00102\f\u0010\u000b\u001a\b\u0018\u00010\tR\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0003¢\u0006\u0004\b\u0011\u0010\u0012J+\u0010\u0016\u001a\u00020\u00102\n\u0010\u000b\u001a\u00060\tR\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0018\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010!\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u0003H\u0002¢\u0006\u0004\b!\u0010\"J\u001f\u0010%\u001a\u00020\u00102\u0006\u0010#\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u000eH\u0002¢\u0006\u0004\b%\u0010&J\u0017\u0010'\u001a\u00020\u00102\u0006\u0010#\u001a\u00020\u0003H\u0002¢\u0006\u0004\b'\u0010\"J\u0019\u0010)\u001a\u00020\u00102\b\u0010(\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b)\u0010*J%\u0010+\u001a\u00020\u00102\f\u0010\u000b\u001a\b\u0018\u00010\tR\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b+\u0010,J\u0019\u0010-\u001a\u00020\u00102\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b-\u0010.J/\u00100\u001a\u00020\u00032\u0006\u0010/\u001a\u00020\u00032\f\u0010\u000b\u001a\b\u0018\u00010\tR\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b0\u00101J/\u00103\u001a\u00020\u00032\u0006\u00102\u001a\u00020\u00032\f\u0010\u000b\u001a\b\u0018\u00010\tR\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b3\u00101J\u0017\u00104\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u0003H\u0016¢\u0006\u0004\b4\u0010\"J\u000f\u00106\u001a\u000205H\u0016¢\u0006\u0004\b6\u00107J3\u0010:\u001a\u00020\u00102\n\u0010\u000b\u001a\u00060\tR\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u00108\u001a\u00020\u00032\u0006\u00109\u001a\u00020\u0003H\u0016¢\u0006\u0004\b:\u0010;J\u000f\u0010<\u001a\u00020\u000eH\u0016¢\u0006\u0004\b<\u0010=J\u000f\u0010>\u001a\u00020\u000eH\u0016¢\u0006\u0004\b>\u0010=J\u000f\u0010A\u001a\u00020\u0003H\u0000¢\u0006\u0004\b?\u0010@J\u000f\u0010C\u001a\u00020\u0003H\u0000¢\u0006\u0004\bB\u0010@J\u0019\u0010F\u001a\u0004\u0018\u00010E2\u0006\u0010D\u001a\u00020\u0003H\u0016¢\u0006\u0004\bF\u0010GJ\u0017\u0010I\u001a\u00020\u001d2\u0006\u0010D\u001a\u00020\u0003H\u0000¢\u0006\u0004\bH\u0010\u001fJ\u000f\u0010K\u001a\u0004\u0018\u00010J¢\u0006\u0004\bK\u0010LJ\u0015\u0010N\u001a\u00020\u00102\u0006\u0010M\u001a\u00020\u000e¢\u0006\u0004\bN\u0010OJ\u0019\u0010Q\u001a\u00020\u00032\b\b\u0001\u0010P\u001a\u00020\u0003H\u0007¢\u0006\u0004\bQ\u0010\u001cJ+\u0010T\u001a\u00020\u00102\b\u0010R\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010S\u001a\u00020\u0003H\u0016¢\u0006\u0004\bT\u0010UJ\r\u0010V\u001a\u00020\u0010¢\u0006\u0004\bV\u0010WJ\r\u0010X\u001a\u00020\u0010¢\u0006\u0004\bX\u0010WJ\u0015\u0010Y\u001a\u00020\u00102\u0006\u0010#\u001a\u00020\u0003¢\u0006\u0004\bY\u0010\"J\u0017\u0010Z\u001a\u00020\u00102\u0006\u0010S\u001a\u00020\u0003H\u0016¢\u0006\u0004\bZ\u0010\"J\r\u0010[\u001a\u00020\u0010¢\u0006\u0004\b[\u0010WJ\r\u0010\\\u001a\u00020\u0010¢\u0006\u0004\b\\\u0010WJ\u0015\u0010_\u001a\u00020\u00102\u0006\u0010^\u001a\u00020]¢\u0006\u0004\b_\u0010`R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010aR\u0014\u0010\u0005\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010aR\u0016\u0010\u0006\u001a\u00020\u00038\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010aR\u0016\u0010b\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bb\u0010aR\u0014\u0010c\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bc\u0010aR\u001a\u0010e\u001a\b\u0012\u0004\u0012\u00020\u00130d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\be\u0010fR\u0016\u0010g\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bg\u0010aR\u0016\u0010h\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bh\u0010aR\u0016\u0010i\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bi\u0010aR\u0016\u0010j\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bj\u0010aR\u0016\u0010k\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bk\u0010aR\u0016\u0010l\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bl\u0010aR\u0016\u0010m\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bm\u0010aR\u0016\u0010n\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bn\u0010oR\u0018\u0010p\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bp\u0010qR\u0016\u0010r\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\br\u0010oR\u0016\u0010s\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bs\u0010aR\u0016\u0010t\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bt\u0010aR\u0018\u0010u\u001a\u0004\u0018\u00010]8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bu\u0010vR$\u0010x\u001a\u00020\u00032\u0006\u0010w\u001a\u00020\u00038\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\bx\u0010a\u001a\u0004\by\u0010@R\u0014\u0010{\u001a\u00020\u00038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bz\u0010@R\u0014\u0010}\u001a\u00020\u00038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b|\u0010@R\u0014\u0010\u007f\u001a\u00020\u00038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b~\u0010@R\u0016\u0010\u0081\u0001\u001a\u00020\u00038BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b\u0080\u0001\u0010@¨\u0006\u0084\u0001"}, d2 = {"Lcom/qiahao/nextvideo/ui/reusable/views/recyclerview/PagerGridLayoutManager;", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "Landroidx/recyclerview/widget/RecyclerView$SmoothScroller$ScrollVectorProvider;", "", "mRows", "mColumns", "mOrientation", "<init>", "(III)V", "Landroidx/recyclerview/widget/RecyclerView$Recycler;", "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "isStart", "", "recycleAndFillItems", "(Landroidx/recyclerview/widget/RecyclerView$Recycler;Landroidx/recyclerview/widget/RecyclerView$State;Z)V", "Landroid/graphics/Rect;", "displayRect", "i", "addOrRemove", "(Landroidx/recyclerview/widget/RecyclerView$Recycler;Landroid/graphics/Rect;I)V", "pos", "getItemFrameByPosition", "(I)Landroid/graphics/Rect;", "getPageIndexByPos", "(I)I", "", "getPageLeftTopByPosition", "(I)[I", "pageCount", "setPageCount", "(I)V", "pageIndex", "isScrolling", "setPageIndex", "(IZ)V", "scrollToPage", "view", "onAttachedToWindow", "(Landroidx/recyclerview/widget/RecyclerView;)V", "onLayoutChildren", "(Landroidx/recyclerview/widget/RecyclerView$Recycler;Landroidx/recyclerview/widget/RecyclerView$State;)V", "onLayoutCompleted", "(Landroidx/recyclerview/widget/RecyclerView$State;)V", "dx", "scrollHorizontallyBy", "(ILandroidx/recyclerview/widget/RecyclerView$Recycler;Landroidx/recyclerview/widget/RecyclerView$State;)I", "dy", "scrollVerticallyBy", "onScrollStateChanged", "Landroidx/recyclerview/widget/RecyclerView$LayoutParams;", "generateDefaultLayoutParams", "()Landroidx/recyclerview/widget/RecyclerView$LayoutParams;", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(Landroidx/recyclerview/widget/RecyclerView$Recycler;Landroidx/recyclerview/widget/RecyclerView$State;II)V", "canScrollHorizontally", "()Z", "canScrollVertically", "findNextPageFirstPos$app_googleRelease", "()I", "findNextPageFirstPos", "findPrePageFirstPos$app_googleRelease", "findPrePageFirstPos", "targetPosition", "Landroid/graphics/PointF;", "computeScrollVectorForPosition", "(I)Landroid/graphics/PointF;", "getSnapOffset$app_googleRelease", "getSnapOffset", "Landroid/view/View;", "findSnapView", "()Landroid/view/View;", "changeSelectInScrolling", "setChangeSelectInScrolling", "(Z)V", "orientation", "setOrientationType", "recyclerView", "position", "smoothScrollToPosition", "(Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$State;I)V", "smoothPrePage", "()V", "smoothNextPage", "smoothScrollToPage", "scrollToPosition", "prePage", "nextPage", "Lcom/qiahao/nextvideo/ui/reusable/views/recyclerview/PagerGridLayoutManager$PageListener;", "pageListener", "setPageListener", "(Lcom/qiahao/nextvideo/ui/reusable/views/recyclerview/PagerGridLayoutManager$PageListener;)V", "I", CustomIntentKey.EXTRA_OFFSET_X, "mOnePageSize", "Landroid/util/SparseArray;", "mItemFrames", "Landroid/util/SparseArray;", "mItemWidth", "mItemHeight", "mWidthUsed", "mHeightUsed", "mMaxScrollX", "mMaxScrollY", "mScrollState", "isAllowContinuousScroll", "Z", "mRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "mChangeSelectInScrolling", "mLastPageCount", "mLastPageIndex", "mPageListener", "Lcom/qiahao/nextvideo/ui/reusable/views/recyclerview/PagerGridLayoutManager$PageListener;", "value", CustomIntentKey.EXTRA_OFFSET_Y, "getOffsetY", "getUsableWidth", "usableWidth", "getUsableHeight", "usableHeight", "getTotalPageCount", "totalPageCount", "getPageIndexByOffset", "pageIndexByOffset", "Companion", "PageListener", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class PagerGridLayoutManager extends RecyclerView.LayoutManager implements RecyclerView.SmoothScroller.ScrollVectorProvider {
    public static final int HORIZONTAL = 1;
    public static final int VERTICAL = 0;
    private final int mColumns;
    private int mHeightUsed;
    private int mItemHeight;
    private int mItemWidth;
    private int mMaxScrollX;
    private int mMaxScrollY;
    private final int mOnePageSize;
    private int mOrientation;

    @Nullable
    private PageListener mPageListener;

    @Nullable
    private RecyclerView mRecyclerView;
    private final int mRows;
    private int mScrollState;
    private int mWidthUsed;
    private int offsetX;
    private int offsetY;
    private static final String TAG = PagerGridLayoutManager.class.getSimpleName();

    @NotNull
    private final SparseArray<Rect> mItemFrames = new SparseArray<>();
    private boolean isAllowContinuousScroll = true;
    private boolean mChangeSelectInScrolling = true;
    private int mLastPageCount = -1;
    private int mLastPageIndex = -1;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H&¨\u0006\b"}, d2 = {"Lcom/qiahao/nextvideo/ui/reusable/views/recyclerview/PagerGridLayoutManager$PageListener;", "", "onPageSizeChanged", "", "pageSize", "", "onPageSelect", "pageIndex", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public interface PageListener {
        void onPageSelect(int pageIndex);

        void onPageSizeChanged(int pageSize);
    }

    public PagerGridLayoutManager(@IntRange(from = 1, to = 100) int i, @IntRange(from = 1, to = 100) int i2, int i3) {
        this.mRows = i;
        this.mColumns = i2;
        this.mOrientation = i3;
        this.mOnePageSize = i * i2;
    }

    private final void addOrRemove(RecyclerView.Recycler recycler, Rect displayRect, int i) {
        View viewForPosition = recycler.getViewForPosition(i);
        Intrinsics.checkNotNullExpressionValue(viewForPosition, "getViewForPosition(...)");
        Rect itemFrameByPosition = getItemFrameByPosition(i);
        if (!Rect.intersects(displayRect, itemFrameByPosition)) {
            removeAndRecycleView(viewForPosition, recycler);
            return;
        }
        addView(viewForPosition);
        measureChildWithMargins(viewForPosition, this.mWidthUsed, this.mHeightUsed);
        RecyclerView.LayoutParams layoutParams = viewForPosition.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
        RecyclerView.LayoutParams layoutParams2 = layoutParams;
        layoutDecorated(viewForPosition, (itemFrameByPosition.left - this.offsetX) + ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin + getPaddingLeft(), (itemFrameByPosition.top - this.offsetY) + ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin + getPaddingTop(), ((itemFrameByPosition.right - this.offsetX) - ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin) + getPaddingLeft(), ((itemFrameByPosition.bottom - this.offsetY) - ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin) + getPaddingTop());
    }

    private final Rect getItemFrameByPosition(int pos) {
        int usableHeight;
        Rect rect = this.mItemFrames.get(pos);
        if (rect == null) {
            rect = new Rect();
            int i = pos / this.mOnePageSize;
            int i2 = 0;
            if (canScrollHorizontally()) {
                i2 = getUsableWidth() * i;
                usableHeight = 0;
            } else {
                usableHeight = getUsableHeight() * i;
            }
            int i3 = pos % this.mOnePageSize;
            int i4 = this.mColumns;
            int i5 = i3 / i4;
            int i6 = i3 - (i4 * i5);
            int i7 = this.mItemWidth;
            int i8 = i2 + (i6 * i7);
            int i9 = this.mItemHeight;
            int i10 = usableHeight + (i5 * i9);
            rect.left = i8;
            rect.top = i10;
            rect.right = i8 + i7;
            rect.bottom = i10 + i9;
            this.mItemFrames.put(pos, rect);
        }
        return rect;
    }

    private final int getPageIndexByOffset() {
        int i;
        if (canScrollVertically()) {
            int usableHeight = getUsableHeight();
            int i2 = this.offsetY;
            if (i2 <= 0 || usableHeight <= 0) {
                return 0;
            }
            i = i2 / usableHeight;
            if (i2 % usableHeight <= usableHeight / 2) {
                return i;
            }
        } else {
            int usableWidth = getUsableWidth();
            int i3 = this.offsetX;
            if (i3 <= 0 || usableWidth <= 0) {
                return 0;
            }
            i = i3 / usableWidth;
            if (i3 % usableWidth <= usableWidth / 2) {
                return i;
            }
        }
        return i + 1;
    }

    private final int getPageIndexByPos(int pos) {
        return pos / this.mOnePageSize;
    }

    private final int[] getPageLeftTopByPosition(int pos) {
        int[] iArr = new int[2];
        int pageIndexByPos = getPageIndexByPos(pos);
        if (canScrollHorizontally()) {
            iArr[0] = pageIndexByPos * getUsableWidth();
            iArr[1] = 0;
        } else {
            iArr[0] = 0;
            iArr[1] = pageIndexByPos * getUsableHeight();
        }
        return iArr;
    }

    private final int getTotalPageCount() {
        if (getItemCount() <= 0) {
            return 0;
        }
        int itemCount = getItemCount() / this.mOnePageSize;
        if (getItemCount() % this.mOnePageSize != 0) {
            return itemCount + 1;
        }
        return itemCount;
    }

    private final int getUsableHeight() {
        return (getHeight() - getPaddingTop()) - getPaddingBottom();
    }

    private final int getUsableWidth() {
        return (getWidth() - getPaddingLeft()) - getPaddingRight();
    }

    @SuppressLint({"CheckResult"})
    private final void recycleAndFillItems(RecyclerView.Recycler recycler, RecyclerView.State state, boolean isStart) {
        if (state.isPreLayout()) {
            return;
        }
        Rect rect = new Rect(this.offsetX - this.mItemWidth, this.offsetY - this.mItemHeight, getUsableWidth() + this.offsetX + this.mItemWidth, getUsableHeight() + this.offsetY + this.mItemHeight);
        int i = 0;
        rect.intersect(0, 0, this.mMaxScrollX + getUsableWidth(), this.mMaxScrollY + getUsableHeight());
        int pageIndexByOffset = getPageIndexByOffset();
        int i2 = this.mOnePageSize;
        int i3 = (pageIndexByOffset * i2) - (i2 * 2);
        if (i3 >= 0) {
            i = i3;
        }
        int i4 = (i2 * 4) + i;
        if (i4 > getItemCount()) {
            i4 = getItemCount();
        }
        Intrinsics.checkNotNull(recycler);
        detachAndScrapAttachedViews(recycler);
        if (isStart) {
            while (i < i4) {
                addOrRemove(recycler, rect, i);
                i++;
            }
        } else {
            int i5 = i4 - 1;
            if (i > i5) {
                return;
            }
            while (true) {
                addOrRemove(recycler, rect, i5);
                if (i5 != i) {
                    i5--;
                } else {
                    return;
                }
            }
        }
    }

    private final void scrollToPage(int pageIndex) {
        int usableWidth;
        int i;
        if (pageIndex >= 0 && pageIndex < this.mLastPageCount) {
            if (this.mRecyclerView == null) {
                Log.e(TAG, "RecyclerView Not Found!");
                return;
            }
            if (canScrollVertically()) {
                i = (getUsableHeight() * pageIndex) - this.offsetY;
                usableWidth = 0;
            } else {
                usableWidth = (getUsableWidth() * pageIndex) - this.offsetX;
                i = 0;
            }
            RecyclerView recyclerView = this.mRecyclerView;
            Intrinsics.checkNotNull(recyclerView);
            recyclerView.scrollBy(usableWidth, i);
            setPageIndex(pageIndex, false);
            return;
        }
        Log.e(TAG, "pageIndex = " + pageIndex + " is out of bounds, mast in [0, " + this.mLastPageCount + ")");
    }

    private final void setPageCount(int pageCount) {
        if (pageCount >= 0) {
            PageListener pageListener = this.mPageListener;
            if (pageListener != null && pageCount != this.mLastPageCount) {
                Intrinsics.checkNotNull(pageListener);
                pageListener.onPageSizeChanged(pageCount);
            }
            this.mLastPageCount = pageCount;
        }
    }

    private final void setPageIndex(int pageIndex, boolean isScrolling) {
        PageListener pageListener;
        if (pageIndex == this.mLastPageIndex) {
            return;
        }
        if (this.isAllowContinuousScroll) {
            this.mLastPageIndex = pageIndex;
        } else if (!isScrolling) {
            this.mLastPageIndex = pageIndex;
        }
        if ((!isScrolling || this.mChangeSelectInScrolling) && pageIndex >= 0 && (pageListener = this.mPageListener) != null) {
            Intrinsics.checkNotNull(pageListener);
            pageListener.onPageSelect(pageIndex);
        }
    }

    public boolean canScrollHorizontally() {
        if (this.mOrientation == 1) {
            return true;
        }
        return false;
    }

    public boolean canScrollVertically() {
        if (this.mOrientation == 0) {
            return true;
        }
        return false;
    }

    @Nullable
    public PointF computeScrollVectorForPosition(int targetPosition) {
        PointF pointF = new PointF();
        int[] snapOffset$app_googleRelease = getSnapOffset$app_googleRelease(targetPosition);
        pointF.x = snapOffset$app_googleRelease[0];
        pointF.y = snapOffset$app_googleRelease[1];
        return pointF;
    }

    public final int findNextPageFirstPos$app_googleRelease() {
        int i = this.mLastPageIndex + 1;
        if (i >= getTotalPageCount()) {
            i = getTotalPageCount() - 1;
        }
        return i * this.mOnePageSize;
    }

    public final int findPrePageFirstPos$app_googleRelease() {
        int i = this.mLastPageIndex - 1;
        if (i < 0) {
            i = 0;
        }
        return i * this.mOnePageSize;
    }

    @Nullable
    public final View findSnapView() {
        if (getFocusedChild() != null) {
            return getFocusedChild();
        }
        if (getChildCount() <= 0) {
            return null;
        }
        int pageIndexByOffset = getPageIndexByOffset() * this.mOnePageSize;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            Intrinsics.checkNotNull(childAt);
            if (getPosition(childAt) == pageIndexByOffset) {
                return getChildAt(i);
            }
        }
        return getChildAt(0);
    }

    @NotNull
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    public final int getOffsetY() {
        return this.offsetY;
    }

    @NotNull
    public final int[] getSnapOffset$app_googleRelease(int targetPosition) {
        int[] pageLeftTopByPosition = getPageLeftTopByPosition(targetPosition);
        return new int[]{pageLeftTopByPosition[0] - this.offsetX, pageLeftTopByPosition[1] - this.offsetY};
    }

    public final void nextPage() {
        scrollToPage(getPageIndexByOffset() + 1);
    }

    public void onAttachedToWindow(@Nullable RecyclerView view) {
        super.onAttachedToWindow(view);
        this.mRecyclerView = view;
    }

    public void onLayoutChildren(@Nullable RecyclerView.Recycler recycler, @NotNull RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (!state.isPreLayout() && state.didStructureChange()) {
            if (getItemCount() == 0) {
                Intrinsics.checkNotNull(recycler);
                removeAndRecycleAllViews(recycler);
                setPageCount(0);
                setPageIndex(0, false);
                return;
            }
            setPageCount(getTotalPageCount());
            setPageIndex(getPageIndexByOffset(), false);
            int itemCount = getItemCount() / this.mOnePageSize;
            if (getItemCount() % this.mOnePageSize != 0) {
                itemCount++;
            }
            if (canScrollHorizontally()) {
                int usableWidth = (itemCount - 1) * getUsableWidth();
                this.mMaxScrollX = usableWidth;
                this.mMaxScrollY = 0;
                if (this.offsetX > usableWidth) {
                    this.offsetX = usableWidth;
                }
            } else {
                this.mMaxScrollX = 0;
                int usableHeight = (itemCount - 1) * getUsableHeight();
                this.mMaxScrollY = usableHeight;
                if (this.offsetY > usableHeight) {
                    this.offsetY = usableHeight;
                }
            }
            if (this.mItemWidth <= 0) {
                this.mItemWidth = getUsableWidth() / this.mColumns;
            }
            if (this.mItemHeight <= 0) {
                this.mItemHeight = getUsableHeight() / this.mRows;
            }
            this.mWidthUsed = getUsableWidth() - this.mItemWidth;
            this.mHeightUsed = getUsableHeight() - this.mItemHeight;
            int i = this.mOnePageSize * 2;
            for (int i2 = 0; i2 < i; i2++) {
                getItemFrameByPosition(i2);
            }
            if (this.offsetX == 0 && this.offsetY == 0) {
                int i3 = this.mOnePageSize;
                for (int i4 = 0; i4 < i3 && i4 < getItemCount(); i4++) {
                    Intrinsics.checkNotNull(recycler);
                    View viewForPosition = recycler.getViewForPosition(i4);
                    Intrinsics.checkNotNullExpressionValue(viewForPosition, "getViewForPosition(...)");
                    addView(viewForPosition);
                    measureChildWithMargins(viewForPosition, this.mWidthUsed, this.mHeightUsed);
                }
            }
            recycleAndFillItems(recycler, state, true);
        }
    }

    public void onLayoutCompleted(@Nullable RecyclerView.State state) {
        super.onLayoutCompleted(state);
        Intrinsics.checkNotNull(state);
        if (state.isPreLayout()) {
            return;
        }
        setPageCount(getTotalPageCount());
        setPageIndex(getPageIndexByOffset(), false);
    }

    public void onMeasure(@NotNull RecyclerView.Recycler recycler, @NotNull RecyclerView.State state, int widthMeasureSpec, int heightMeasureSpec) {
        Intrinsics.checkNotNullParameter(recycler, "recycler");
        Intrinsics.checkNotNullParameter(state, "state");
        super.onMeasure(recycler, state, widthMeasureSpec, heightMeasureSpec);
        int size = View.MeasureSpec.getSize(widthMeasureSpec);
        int mode = View.MeasureSpec.getMode(widthMeasureSpec);
        int size2 = View.MeasureSpec.getSize(heightMeasureSpec);
        int mode2 = View.MeasureSpec.getMode(heightMeasureSpec);
        if (mode != 1073741824 && size > 0) {
            mode = 1073741824;
        }
        if (mode2 != 1073741824 && size2 > 0) {
            mode2 = 1073741824;
        }
        setMeasuredDimension(View.MeasureSpec.makeMeasureSpec(size, mode), View.MeasureSpec.makeMeasureSpec(size2, mode2));
    }

    public void onScrollStateChanged(int state) {
        this.mScrollState = state;
        super.onScrollStateChanged(state);
        if (state == 0) {
            setPageIndex(getPageIndexByOffset(), false);
        }
    }

    public final void prePage() {
        scrollToPage(getPageIndexByOffset() - 1);
    }

    public int scrollHorizontallyBy(int dx, @Nullable RecyclerView.Recycler recycler, @Nullable RecyclerView.State state) {
        int i = this.offsetX;
        int i2 = i + dx;
        int i3 = this.mMaxScrollX;
        if (i2 > i3) {
            dx = i3 - i;
        } else if (i2 < 0) {
            dx = 0 - i;
        }
        this.offsetX = i + dx;
        setPageIndex(getPageIndexByOffset(), true);
        offsetChildrenHorizontal(-dx);
        if (dx > 0) {
            Intrinsics.checkNotNull(state);
            recycleAndFillItems(recycler, state, true);
        } else {
            Intrinsics.checkNotNull(state);
            recycleAndFillItems(recycler, state, false);
        }
        return dx;
    }

    public void scrollToPosition(int position) {
        scrollToPage(getPageIndexByPos(position));
    }

    public int scrollVerticallyBy(int dy, @Nullable RecyclerView.Recycler recycler, @Nullable RecyclerView.State state) {
        int i = this.offsetY;
        int i2 = i + dy;
        int i3 = this.mMaxScrollY;
        if (i2 > i3) {
            dy = i3 - i;
        } else if (i2 < 0) {
            dy = 0 - i;
        }
        this.offsetY = i + dy;
        setPageIndex(getPageIndexByOffset(), true);
        offsetChildrenVertical(-dy);
        if (dy > 0) {
            Intrinsics.checkNotNull(state);
            recycleAndFillItems(recycler, state, true);
        } else {
            Intrinsics.checkNotNull(state);
            recycleAndFillItems(recycler, state, false);
        }
        return dy;
    }

    public final void setChangeSelectInScrolling(boolean changeSelectInScrolling) {
        this.mChangeSelectInScrolling = changeSelectInScrolling;
    }

    public final int setOrientationType(int orientation) {
        int i = this.mOrientation;
        if (i != orientation && this.mScrollState == 0) {
            this.mOrientation = orientation;
            this.mItemFrames.clear();
            int i2 = this.offsetX;
            this.offsetX = (this.offsetY / getUsableHeight()) * getUsableWidth();
            this.offsetY = (i2 / getUsableWidth()) * getUsableHeight();
            int i3 = this.mMaxScrollX;
            this.mMaxScrollX = (this.mMaxScrollY / getUsableHeight()) * getUsableWidth();
            this.mMaxScrollY = (i3 / getUsableWidth()) * getUsableHeight();
            return this.mOrientation;
        }
        return i;
    }

    public final void setPageListener(@NotNull PageListener pageListener) {
        Intrinsics.checkNotNullParameter(pageListener, "pageListener");
        this.mPageListener = pageListener;
    }

    public final void smoothNextPage() {
        smoothScrollToPage(getPageIndexByOffset() + 1);
    }

    public final void smoothPrePage() {
        smoothScrollToPage(getPageIndexByOffset() - 1);
    }

    public final void smoothScrollToPage(int pageIndex) {
        if (pageIndex >= 0 && pageIndex < this.mLastPageCount) {
            if (this.mRecyclerView == null) {
                Log.e(TAG, "RecyclerView Not Found!");
                return;
            }
            int pageIndexByOffset = getPageIndexByOffset();
            if (Math.abs(pageIndex - pageIndexByOffset) > 3) {
                if (pageIndex > pageIndexByOffset) {
                    scrollToPage(pageIndex - 3);
                } else if (pageIndex < pageIndexByOffset) {
                    scrollToPage(pageIndex + 3);
                }
            }
            RecyclerView recyclerView = this.mRecyclerView;
            Intrinsics.checkNotNull(recyclerView);
            PagerGridSmoothScroller pagerGridSmoothScroller = new PagerGridSmoothScroller(recyclerView);
            pagerGridSmoothScroller.setTargetPosition(pageIndex * this.mOnePageSize);
            startSmoothScroll(pagerGridSmoothScroller);
            return;
        }
        Log.e(TAG, "pageIndex is outOfIndex, must in [0, " + this.mLastPageCount + ").");
    }

    public void smoothScrollToPosition(@Nullable RecyclerView recyclerView, @Nullable RecyclerView.State state, int position) {
        smoothScrollToPage(getPageIndexByPos(position));
    }
}
