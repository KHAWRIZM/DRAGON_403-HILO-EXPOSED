package com.tencent.qcloud.tuikit.tuichat.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.qcloud.tuicore.component.gatherimage.UserIconView;
import com.tencent.qcloud.tuikit.tuichat.BR;
import com.tencent.qcloud.tuikit.tuichat.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class HiloMessageGiftBindingImpl extends HiloMessageGiftBinding {
    private static final ViewDataBinding.i sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final LinearLayout mboundView1;

    static {
        ViewDataBinding.i iVar = new ViewDataBinding.i(7);
        sIncludes = iVar;
        iVar.a(1, new String[]{"hilo_view_message_gift"}, new int[]{2}, new int[]{R.layout.hilo_view_message_gift});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.left_user_icon_view, 3);
        sparseIntArray.put(R.id.right_user_icon_view, 4);
        sparseIntArray.put(R.id.msg_content_ll, 5);
        sparseIntArray.put(R.id.message_container, 6);
    }

    public HiloMessageGiftBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 7, sIncludes, sViewsWithIds));
    }

    private boolean onChangeGiftContent(HiloViewMessageGiftBinding hiloViewMessageGiftBinding, int i) {
        if (i == BR._all) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        }
        return false;
    }

    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
        ViewDataBinding.executeBindingsOn(this.giftContent);
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            try {
                if (this.mDirtyFlags != 0) {
                    return true;
                }
                if (this.giftContent.hasPendingBindings()) {
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
        this.giftContent.invalidateAll();
        requestRebind();
    }

    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return onChangeGiftContent((HiloViewMessageGiftBinding) obj, i2);
    }

    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.giftContent.setLifecycleOwner(lifecycleOwner);
    }

    public boolean setVariable(int i, Object obj) {
        return true;
    }

    private HiloMessageGiftBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 1, (ConstraintLayout) objArr[0], (HiloViewMessageGiftBinding) objArr[2], (UserIconView) objArr[3], (TextView) objArr[6], (LinearLayout) objArr[5], (UserIconView) objArr[4]);
        this.mDirtyFlags = -1L;
        this.allContent.setTag(null);
        setContainedBinding(this.giftContent);
        LinearLayout linearLayout = (LinearLayout) objArr[1];
        this.mboundView1 = linearLayout;
        linearLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
