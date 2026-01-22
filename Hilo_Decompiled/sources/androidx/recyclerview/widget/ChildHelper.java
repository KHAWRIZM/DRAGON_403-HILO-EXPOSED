package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class ChildHelper {
    private static final boolean DEBUG = false;
    private static final int REMOVE_STATUS_IN_REMOVE = 1;
    private static final int REMOVE_STATUS_IN_REMOVE_IF_HIDDEN = 2;
    private static final int REMOVE_STATUS_NONE = 0;
    private static final String TAG = "ChildrenHelper";
    final Callback mCallback;
    private View mViewInRemoveView;
    private int mRemoveStatus = 0;
    final Bucket mBucket = new Bucket();
    final List<View> mHiddenViews = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class Bucket {
        static final int BITS_PER_WORD = 64;
        static final long LAST_BIT = Long.MIN_VALUE;
        long mData = 0;
        Bucket mNext;

        Bucket() {
        }

        private void ensureNext() {
            if (this.mNext == null) {
                this.mNext = new Bucket();
            }
        }

        void clear(int i10) {
            if (i10 >= 64) {
                Bucket bucket = this.mNext;
                if (bucket != null) {
                    bucket.clear(i10 - 64);
                    return;
                }
                return;
            }
            this.mData &= ~(1 << i10);
        }

        int countOnesBefore(int i10) {
            Bucket bucket = this.mNext;
            if (bucket == null) {
                if (i10 >= 64) {
                    return Long.bitCount(this.mData);
                }
                return Long.bitCount(this.mData & ((1 << i10) - 1));
            }
            if (i10 < 64) {
                return Long.bitCount(this.mData & ((1 << i10) - 1));
            }
            return bucket.countOnesBefore(i10 - 64) + Long.bitCount(this.mData);
        }

        boolean get(int i10) {
            if (i10 >= 64) {
                ensureNext();
                return this.mNext.get(i10 - 64);
            }
            if ((this.mData & (1 << i10)) != 0) {
                return true;
            }
            return false;
        }

        void insert(int i10, boolean z10) {
            boolean z11;
            if (i10 >= 64) {
                ensureNext();
                this.mNext.insert(i10 - 64, z10);
                return;
            }
            long j10 = this.mData;
            if ((Long.MIN_VALUE & j10) != 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            long j11 = (1 << i10) - 1;
            this.mData = ((j10 & (~j11)) << 1) | (j10 & j11);
            if (z10) {
                set(i10);
            } else {
                clear(i10);
            }
            if (z11 || this.mNext != null) {
                ensureNext();
                this.mNext.insert(0, z11);
            }
        }

        boolean remove(int i10) {
            boolean z10;
            if (i10 >= 64) {
                ensureNext();
                return this.mNext.remove(i10 - 64);
            }
            long j10 = 1 << i10;
            long j11 = this.mData;
            if ((j11 & j10) != 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            long j12 = j11 & (~j10);
            this.mData = j12;
            long j13 = j10 - 1;
            this.mData = (j12 & j13) | Long.rotateRight((~j13) & j12, 1);
            Bucket bucket = this.mNext;
            if (bucket != null) {
                if (bucket.get(0)) {
                    set(63);
                }
                this.mNext.remove(0);
            }
            return z10;
        }

        void reset() {
            this.mData = 0L;
            Bucket bucket = this.mNext;
            if (bucket != null) {
                bucket.reset();
            }
        }

        void set(int i10) {
            if (i10 >= 64) {
                ensureNext();
                this.mNext.set(i10 - 64);
            } else {
                this.mData |= 1 << i10;
            }
        }

        public String toString() {
            if (this.mNext == null) {
                return Long.toBinaryString(this.mData);
            }
            return this.mNext.toString() + "xx" + Long.toBinaryString(this.mData);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public interface Callback {
        void addView(View view, int i10);

        void attachViewToParent(View view, int i10, ViewGroup.LayoutParams layoutParams);

        void detachViewFromParent(int i10);

        View getChildAt(int i10);

        int getChildCount();

        RecyclerView.ViewHolder getChildViewHolder(View view);

        int indexOfChild(View view);

        void onEnteredHiddenState(View view);

        void onLeftHiddenState(View view);

        void removeAllViews();

        void removeViewAt(int i10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ChildHelper(Callback callback) {
        this.mCallback = callback;
    }

    private int getOffset(int i10) {
        if (i10 < 0) {
            return -1;
        }
        int childCount = this.mCallback.getChildCount();
        int i11 = i10;
        while (i11 < childCount) {
            int countOnesBefore = i10 - (i11 - this.mBucket.countOnesBefore(i11));
            if (countOnesBefore == 0) {
                while (this.mBucket.get(i11)) {
                    i11++;
                }
                return i11;
            }
            i11 += countOnesBefore;
        }
        return -1;
    }

    private void hideViewInternal(View view) {
        this.mHiddenViews.add(view);
        this.mCallback.onEnteredHiddenState(view);
    }

    private boolean unhideViewInternal(View view) {
        if (this.mHiddenViews.remove(view)) {
            this.mCallback.onLeftHiddenState(view);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addView(View view, boolean z10) {
        addView(view, -1, z10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void attachViewToParent(View view, int i10, ViewGroup.LayoutParams layoutParams, boolean z10) {
        int offset;
        if (i10 < 0) {
            offset = this.mCallback.getChildCount();
        } else {
            offset = getOffset(i10);
        }
        this.mBucket.insert(offset, z10);
        if (z10) {
            hideViewInternal(view);
        }
        this.mCallback.attachViewToParent(view, offset, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void detachViewFromParent(int i10) {
        int offset = getOffset(i10);
        this.mBucket.remove(offset);
        this.mCallback.detachViewFromParent(offset);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View findHiddenNonRemovedView(int i10) {
        int size = this.mHiddenViews.size();
        for (int i11 = 0; i11 < size; i11++) {
            View view = this.mHiddenViews.get(i11);
            RecyclerView.ViewHolder childViewHolder = this.mCallback.getChildViewHolder(view);
            if (childViewHolder.getLayoutPosition() == i10 && !childViewHolder.isInvalid() && !childViewHolder.isRemoved()) {
                return view;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View getChildAt(int i10) {
        return this.mCallback.getChildAt(getOffset(i10));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getChildCount() {
        return this.mCallback.getChildCount() - this.mHiddenViews.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View getUnfilteredChildAt(int i10) {
        return this.mCallback.getChildAt(i10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getUnfilteredChildCount() {
        return this.mCallback.getChildCount();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void hide(View view) {
        int indexOfChild = this.mCallback.indexOfChild(view);
        if (indexOfChild >= 0) {
            this.mBucket.set(indexOfChild);
            hideViewInternal(view);
        } else {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int indexOfChild(View view) {
        int indexOfChild = this.mCallback.indexOfChild(view);
        if (indexOfChild == -1 || this.mBucket.get(indexOfChild)) {
            return -1;
        }
        return indexOfChild - this.mBucket.countOnesBefore(indexOfChild);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isHidden(View view) {
        return this.mHiddenViews.contains(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void removeAllViewsUnfiltered() {
        this.mBucket.reset();
        for (int size = this.mHiddenViews.size() - 1; size >= 0; size--) {
            this.mCallback.onLeftHiddenState(this.mHiddenViews.get(size));
            this.mHiddenViews.remove(size);
        }
        this.mCallback.removeAllViews();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void removeView(View view) {
        int i10 = this.mRemoveStatus;
        if (i10 != 1) {
            if (i10 != 2) {
                try {
                    this.mRemoveStatus = 1;
                    this.mViewInRemoveView = view;
                    int indexOfChild = this.mCallback.indexOfChild(view);
                    if (indexOfChild < 0) {
                        this.mRemoveStatus = 0;
                        this.mViewInRemoveView = null;
                        return;
                    }
                    if (this.mBucket.remove(indexOfChild)) {
                        unhideViewInternal(view);
                    }
                    this.mCallback.removeViewAt(indexOfChild);
                    this.mRemoveStatus = 0;
                    this.mViewInRemoveView = null;
                    return;
                } catch (Throwable th) {
                    this.mRemoveStatus = 0;
                    this.mViewInRemoveView = null;
                    throw th;
                }
            }
            throw new IllegalStateException("Cannot call removeView(At) within removeViewIfHidden");
        }
        throw new IllegalStateException("Cannot call removeView(At) within removeView(At)");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void removeViewAt(int i10) {
        int i11 = this.mRemoveStatus;
        if (i11 != 1) {
            if (i11 != 2) {
                try {
                    int offset = getOffset(i10);
                    View childAt = this.mCallback.getChildAt(offset);
                    if (childAt == null) {
                        this.mRemoveStatus = 0;
                        this.mViewInRemoveView = null;
                        return;
                    }
                    this.mRemoveStatus = 1;
                    this.mViewInRemoveView = childAt;
                    if (this.mBucket.remove(offset)) {
                        unhideViewInternal(childAt);
                    }
                    this.mCallback.removeViewAt(offset);
                    this.mRemoveStatus = 0;
                    this.mViewInRemoveView = null;
                    return;
                } catch (Throwable th) {
                    this.mRemoveStatus = 0;
                    this.mViewInRemoveView = null;
                    throw th;
                }
            }
            throw new IllegalStateException("Cannot call removeView(At) within removeViewIfHidden");
        }
        throw new IllegalStateException("Cannot call removeView(At) within removeView(At)");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean removeViewIfHidden(View view) {
        int i10 = this.mRemoveStatus;
        if (i10 == 1) {
            if (this.mViewInRemoveView == view) {
                return false;
            }
            throw new IllegalStateException("Cannot call removeViewIfHidden within removeView(At) for a different view");
        }
        if (i10 != 2) {
            try {
                this.mRemoveStatus = 2;
                int indexOfChild = this.mCallback.indexOfChild(view);
                if (indexOfChild == -1) {
                    unhideViewInternal(view);
                    return true;
                }
                if (!this.mBucket.get(indexOfChild)) {
                    return false;
                }
                this.mBucket.remove(indexOfChild);
                unhideViewInternal(view);
                this.mCallback.removeViewAt(indexOfChild);
                return true;
            } finally {
                this.mRemoveStatus = 0;
            }
        }
        throw new IllegalStateException("Cannot call removeViewIfHidden within removeViewIfHidden");
    }

    public String toString() {
        return this.mBucket.toString() + ", hidden list:" + this.mHiddenViews.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void unhide(View view) {
        int indexOfChild = this.mCallback.indexOfChild(view);
        if (indexOfChild >= 0) {
            if (this.mBucket.get(indexOfChild)) {
                this.mBucket.clear(indexOfChild);
                unhideViewInternal(view);
                return;
            } else {
                throw new RuntimeException("trying to unhide a view that was not hidden" + view);
            }
        }
        throw new IllegalArgumentException("view is not a child, cannot hide " + view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addView(View view, int i10, boolean z10) {
        int offset;
        if (i10 < 0) {
            offset = this.mCallback.getChildCount();
        } else {
            offset = getOffset(i10);
        }
        this.mBucket.insert(offset, z10);
        if (z10) {
            hideViewInternal(view);
        }
        this.mCallback.addView(view, offset);
    }
}
