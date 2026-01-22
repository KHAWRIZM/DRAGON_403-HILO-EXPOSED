package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.reusable.CircleImageView;
import com.qiahao.nextvideo.view.RatioConstraintLayout;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class ViewChatRoomGameLuckyFruitResultBindingImpl extends ViewChatRoomGameLuckyFruitResultBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.view_result_content, 1);
        sparseIntArray.put(R.id.title_bg, 2);
        sparseIntArray.put(R.id.result_tv_round, 3);
        sparseIntArray.put(R.id.result_tv_time, 4);
        sparseIntArray.put(R.id.result_bg_light, 5);
        sparseIntArray.put(R.id.result_image, 6);
        sparseIntArray.put(R.id.result_ll_gold, 7);
        sparseIntArray.put(R.id.result_tv_hint, 8);
        sparseIntArray.put(R.id.result_tv_gold, 9);
        sparseIntArray.put(R.id.result_ll_hint, 10);
        sparseIntArray.put(R.id.winner_top3_tip, 11);
        sparseIntArray.put(R.id.result_user_view1, 12);
        sparseIntArray.put(R.id.result_avatar1, 13);
        sparseIntArray.put(R.id.result_name1, 14);
        sparseIntArray.put(R.id.result_user_gold1, 15);
        sparseIntArray.put(R.id.result_user_view2, 16);
        sparseIntArray.put(R.id.result_avatar2, 17);
        sparseIntArray.put(R.id.result_name2, 18);
        sparseIntArray.put(R.id.result_user_gold2, 19);
        sparseIntArray.put(R.id.result_user_view3, 20);
        sparseIntArray.put(R.id.result_avatar3, 21);
        sparseIntArray.put(R.id.result_name3, 22);
        sparseIntArray.put(R.id.result_user_gold3, 23);
        sparseIntArray.put(R.id.result_tv_hint2, 24);
    }

    public ViewChatRoomGameLuckyFruitResultBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 25, sIncludes, sViewsWithIds));
    }

    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
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
            this.mDirtyFlags = 1L;
        }
        requestRebind();
    }

    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, Object obj) {
        return true;
    }

    private ViewChatRoomGameLuckyFruitResultBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (CircleImageView) objArr[13], (CircleImageView) objArr[17], (CircleImageView) objArr[21], (ImageView) objArr[5], (ImageView) objArr[6], (LinearLayout) objArr[7], (LinearLayout) objArr[10], (TextView) objArr[14], (TextView) objArr[18], (TextView) objArr[22], (TextView) objArr[9], (TextView) objArr[8], (TextView) objArr[24], (TextView) objArr[3], (TextView) objArr[4], (TextView) objArr[15], (TextView) objArr[19], (TextView) objArr[23], (LinearLayout) objArr[12], (LinearLayout) objArr[16], (LinearLayout) objArr[20], (View) objArr[2], (FrameLayout) objArr[0], (RatioConstraintLayout) objArr[1], (TextView) objArr[11]);
        this.mDirtyFlags = -1L;
        this.viewResultBase.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
