package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.qiahao.base_common.player.combination.queue.LightQueueCombinationPlayer;
import com.qiahao.nextvideo.R;
import com.tencent.qcloud.tuicore.component.RoundCornerImageView;
import com.tencent.qcloud.tuikit.tuichat.hilo.HiloChatStrangeView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class ActivityChatStrangeBindingImpl extends ActivityChatStrangeBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131362433, 1);
        sparseIntArray.put(2131362100, 2);
        sparseIntArray.put(R.id.linearLayout, 3);
        sparseIntArray.put(R.id.bar, 4);
        sparseIntArray.put(R.id.backImageView, 5);
        sparseIntArray.put(2131365189, 6);
        sparseIntArray.put(2131365152, 7);
        sparseIntArray.put(R.id.svipType, 8);
        sparseIntArray.put(R.id.newUser, 9);
        sparseIntArray.put(R.id.endImage, 10);
        sparseIntArray.put(R.id.reportImage, 11);
        sparseIntArray.put(R.id.closeImage, 12);
        sparseIntArray.put(R.id.strangeTitleGroup, 13);
        sparseIntArray.put(R.id.chatView, 14);
        sparseIntArray.put(R.id.queuePlayer, 15);
    }

    public ActivityChatStrangeBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 16, sIncludes, sViewsWithIds));
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

    private ActivityChatStrangeBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (FrameLayout) objArr[0], (AppCompatImageView) objArr[5], (View) objArr[4], (RoundCornerImageView) objArr[2], (HiloChatStrangeView) objArr[14], (AppCompatImageView) objArr[12], (ConstraintLayout) objArr[1], (AppCompatImageView) objArr[10], (LinearLayoutCompat) objArr[3], (TextView) objArr[9], (LightQueueCombinationPlayer) objArr[15], (AppCompatImageView) objArr[11], (Group) objArr[13], (ImageView) objArr[8], (AppCompatTextView) objArr[7], (AppCompatTextView) objArr[6]);
        this.mDirtyFlags = -1L;
        this.activityMainContainer.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
