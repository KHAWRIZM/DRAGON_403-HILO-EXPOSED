package com.tencent.qcloud.tuikit.tuichat.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;
import com.tencent.qcloud.tuikit.tuichat.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class HiloMessageUnionFirstBindingImpl extends HiloMessageUnionFirstBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.chat_time_tv, 1);
        sparseIntArray.put(R.id.cl_content, 2);
        sparseIntArray.put(R.id.left_user_icon_view, 3);
        sparseIntArray.put(R.id.right_user_icon_view, 4);
        sparseIntArray.put(R.id.msg_content_ll, 5);
        sparseIntArray.put(R.id.msg_body_tv, 6);
        sparseIntArray.put(R.id.left_user_icon_views, 7);
        sparseIntArray.put(R.id.content_image_iv, 8);
        sparseIntArray.put(R.id.message_container, 9);
        sparseIntArray.put(R.id.gift_pic1, 10);
        sparseIntArray.put(R.id.gift_value1, 11);
        sparseIntArray.put(R.id.gift_pic2, 12);
        sparseIntArray.put(R.id.gift_value2, 13);
        sparseIntArray.put(R.id.gift_pic3, 14);
        sparseIntArray.put(R.id.gift_value3, 15);
        sparseIntArray.put(R.id.gift_pic4, 16);
        sparseIntArray.put(R.id.gift_value4, 17);
    }

    public HiloMessageUnionFirstBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 18, sIncludes, sViewsWithIds));
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

    private HiloMessageUnionFirstBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (TextView) objArr[1], (ConstraintLayout) objArr[2], (ImageView) objArr[8], (ImageView) objArr[10], (ImageView) objArr[12], (ImageView) objArr[14], (ImageView) objArr[16], (TextView) objArr[11], (TextView) objArr[13], (TextView) objArr[15], (TextView) objArr[17], (QMUIRadiusImageView) objArr[3], (QMUIRadiusImageView) objArr[7], (TextView) objArr[9], (TextView) objArr[6], (LinearLayout) objArr[5], (QMUIRadiusImageView) objArr[4]);
        this.mDirtyFlags = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
