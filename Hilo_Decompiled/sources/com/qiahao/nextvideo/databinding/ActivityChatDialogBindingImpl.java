package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.qiahao.base_common.player.combination.queue.LightQueueCombinationPlayer;
import com.qiahao.nextvideo.R;
import com.tencent.qcloud.tuikit.tuichat.hilo.HiloChatView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class ActivityChatDialogBindingImpl extends ActivityChatDialogBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.linearLayout, 1);
        sparseIntArray.put(R.id.bar, 2);
        sparseIntArray.put(R.id.backImageView, 3);
        sparseIntArray.put(2131365189, 4);
        sparseIntArray.put(R.id.svipType, 5);
        sparseIntArray.put(R.id.newUser, 6);
        sparseIntArray.put(R.id.endImage, 7);
        sparseIntArray.put(R.id.chatView, 8);
        sparseIntArray.put(R.id.queuePlayer, 9);
    }

    public ActivityChatDialogBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 10, sIncludes, sViewsWithIds));
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

    private ActivityChatDialogBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (AppCompatImageView) objArr[3], (View) objArr[2], (HiloChatView) objArr[8], (AppCompatImageView) objArr[7], (FrameLayout) objArr[0], (LinearLayoutCompat) objArr[1], (TextView) objArr[6], (LightQueueCombinationPlayer) objArr[9], (ImageView) objArr[5], (AppCompatTextView) objArr[4]);
        this.mDirtyFlags = -1L;
        this.frameLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
