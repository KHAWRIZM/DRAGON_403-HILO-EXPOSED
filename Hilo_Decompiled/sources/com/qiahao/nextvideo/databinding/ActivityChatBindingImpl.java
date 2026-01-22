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
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.qiahao.base_common.player.combination.queue.LightQueueCombinationPlayer;
import com.qiahao.nextvideo.R;
import com.tencent.qcloud.tuikit.tuichat.hilo.HiloChatView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class ActivityChatBindingImpl extends ActivityChatBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131362433, 1);
        sparseIntArray.put(R.id.linearLayout, 2);
        sparseIntArray.put(R.id.bar, 3);
        sparseIntArray.put(R.id.backImageView, 4);
        sparseIntArray.put(2131365189, 5);
        sparseIntArray.put(R.id.svipType, 6);
        sparseIntArray.put(R.id.newUser, 7);
        sparseIntArray.put(R.id.endImage, 8);
        sparseIntArray.put(R.id.chatView, 9);
        sparseIntArray.put(R.id.queuePlayer, 10);
    }

    public ActivityChatBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 11, sIncludes, sViewsWithIds));
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

    private ActivityChatBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (FrameLayout) objArr[0], (AppCompatImageView) objArr[4], (View) objArr[3], (HiloChatView) objArr[9], (ConstraintLayout) objArr[1], (AppCompatImageView) objArr[8], (LinearLayoutCompat) objArr[2], (TextView) objArr[7], (LightQueueCombinationPlayer) objArr[10], (ImageView) objArr[6], (AppCompatTextView) objArr[5]);
        this.mDirtyFlags = -1L;
        this.activityMainContainer.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
