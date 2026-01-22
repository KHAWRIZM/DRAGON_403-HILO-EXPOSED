package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.qiahao.nextvideo.R;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class CellConversationBindingImpl extends CellConversationBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final FrameLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.hilo_inform_or_help, 1);
        sparseIntArray.put(R.id.user_avatar_cimage_view, 2);
        sparseIntArray.put(R.id.online_status, 3);
        sparseIntArray.put(2131363182, 4);
        sparseIntArray.put(R.id.unread_message_count_text_view, 5);
        sparseIntArray.put(R.id.nickname_text_view, 6);
        sparseIntArray.put(2131363500, 7);
        sparseIntArray.put(R.id.last_message_text_view, 8);
        sparseIntArray.put(R.id.message_in_date_text_view, 9);
        sparseIntArray.put(R.id.video_call_image_view, 10);
        sparseIntArray.put(2131363173, 11);
    }

    public CellConversationBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 12, sIncludes, sViewsWithIds));
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

    private CellConversationBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (ImageView) objArr[1], (ImageView) objArr[11], (ImageView) objArr[4], (AppCompatTextView) objArr[8], (View) objArr[7], (AppCompatTextView) objArr[9], (AppCompatTextView) objArr[6], (View) objArr[3], (AppCompatButton) objArr[5], (QMUIRadiusImageView) objArr[2], (AppCompatImageView) objArr[10]);
        this.mDirtyFlags = -1L;
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.mboundView0 = frameLayout;
        frameLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
