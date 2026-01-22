package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.lifecycle.LifecycleOwner;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class RoomViewContactWrapperBindingImpl extends RoomViewContactWrapperBinding {
    private static final ViewDataBinding.i sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;

    static {
        ViewDataBinding.i iVar = new ViewDataBinding.i(3);
        sIncludes = iVar;
        iVar.a(0, new String[]{"dialog_message_list"}, new int[]{1}, new int[]{R.layout.dialog_message_list});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131365189, 2);
    }

    public RoomViewContactWrapperBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 3, sIncludes, sViewsWithIds));
    }

    private boolean onChangeContent(DialogMessageListBinding dialogMessageListBinding, int i) {
        if (i == 0) {
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
        ViewDataBinding.executeBindingsOn(this.content);
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            try {
                if (this.mDirtyFlags != 0) {
                    return true;
                }
                if (this.content.hasPendingBindings()) {
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
        this.content.invalidateAll();
        requestRebind();
    }

    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return onChangeContent((DialogMessageListBinding) obj, i2);
    }

    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.content.setLifecycleOwner(lifecycleOwner);
    }

    public boolean setVariable(int i, Object obj) {
        return true;
    }

    private RoomViewContactWrapperBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 1, (DialogMessageListBinding) objArr[1], (ConstraintLayout) objArr[2]);
        this.mDirtyFlags = -1L;
        setContainedBinding(this.content);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
