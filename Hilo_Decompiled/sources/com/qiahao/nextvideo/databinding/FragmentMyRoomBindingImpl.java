package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.qiahao.nextvideo.R;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class FragmentMyRoomBindingImpl extends FragmentMyRoomBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.smart_refresh_layout, 4);
        sparseIntArray.put(R.id.common_id_content_container, 5);
        sparseIntArray.put(2131365217, 6);
        sparseIntArray.put(R.id.collapsing_toolbar_layout, 7);
        sparseIntArray.put(R.id.recycler_my, 8);
        sparseIntArray.put(R.id.imag, 9);
        sparseIntArray.put(2131365027, 10);
        sparseIntArray.put(2131365036, 11);
        sparseIntArray.put(R.id.linearLayout, 12);
        sparseIntArray.put(R.id.recycler_recently_group, 13);
        sparseIntArray.put(R.id.recycler_join_group, 14);
        sparseIntArray.put(R.id.empty_recently_or_joined, 15);
        sparseIntArray.put(R.id.ll_recommend_group, 16);
        sparseIntArray.put(R.id.recycler_recommend, 17);
    }

    public FragmentMyRoomBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 18, sIncludes, sViewsWithIds));
    }

    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        View.OnClickListener onClickListener = this.mClick;
        if ((j & 3) != 0) {
            this.createMyGroup.setOnClickListener(onClickListener);
            this.joinedText.setOnClickListener(onClickListener);
            this.recentlyText.setOnClickListener(onClickListener);
        }
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            try {
                if (this.mDirtyFlags != 0) {
                    return true;
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 2L;
        }
        requestRebind();
    }

    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // com.qiahao.nextvideo.databinding.FragmentMyRoomBinding
    public void setClick(View.OnClickListener onClickListener) {
        this.mClick = onClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    public boolean setVariable(int i, Object obj) {
        if (2 == i) {
            setClick((View.OnClickListener) obj);
            return true;
        }
        return false;
    }

    private FragmentMyRoomBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (CollapsingToolbarLayout) objArr[7], (CoordinatorLayout) objArr[5], (FrameLayout) objArr[0], (CardView) objArr[1], (TextView) objArr[15], (ImageView) objArr[9], (AppCompatTextView) objArr[3], (LinearLayout) objArr[12], (LinearLayout) objArr[16], (TextView) objArr[2], (RecyclerView) objArr[14], (RecyclerView) objArr[8], (RecyclerView) objArr[13], (RecyclerView) objArr[17], (SmartRefreshLayout) objArr[4], (TextView) objArr[10], (TextView) objArr[11], (AppBarLayout) objArr[6]);
        this.mDirtyFlags = -1L;
        this.container.setTag(null);
        this.createMyGroup.setTag(null);
        this.joinedText.setTag(null);
        this.recentlyText.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
