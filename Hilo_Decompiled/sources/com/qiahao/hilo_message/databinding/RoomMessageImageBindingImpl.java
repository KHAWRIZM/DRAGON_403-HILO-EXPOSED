package com.qiahao.hilo_message.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.lifecycle.LifecycleOwner;
import com.qiahao.hilo_message.R;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class RoomMessageImageBindingImpl extends RoomMessageImageBinding {
    private static final ViewDataBinding.i sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        ViewDataBinding.i iVar = new ViewDataBinding.i(10);
        sIncludes = iVar;
        iVar.a(0, new String[]{"include_message_title"}, new int[]{1}, new int[]{R.layout.include_message_title});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.avatar, 2);
        sparseIntArray.put(R.id.msgContent, 3);
        sparseIntArray.put(R.id.content_image_iv, 4);
        sparseIntArray.put(R.id.video_play_btn, 5);
        sparseIntArray.put(R.id.video_duration_tv, 6);
        sparseIntArray.put(R.id.stateLayout, 7);
        sparseIntArray.put(R.id.progress, 8);
        sparseIntArray.put(R.id.statusImg, 9);
    }

    public RoomMessageImageBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 10, sIncludes, sViewsWithIds));
    }

    private boolean onChangeTitleLayout(IncludeMessageTitleBinding includeMessageTitleBinding, int i10) {
        if (i10 == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        }
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
        ViewDataBinding.executeBindingsOn(this.titleLayout);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            try {
                if (this.mDirtyFlags != 0) {
                    return true;
                }
                if (this.titleLayout.hasPendingBindings()) {
                    return true;
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 2L;
        }
        this.titleLayout.invalidateAll();
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i10, Object obj, int i11) {
        if (i10 != 0) {
            return false;
        }
        return onChangeTitleLayout((IncludeMessageTitleBinding) obj, i11);
    }

    @Override // androidx.databinding.ViewDataBinding
    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.titleLayout.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i10, Object obj) {
        return true;
    }

    private RoomMessageImageBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 1, (QMUIRadiusImageView) objArr[2], (QMUIRadiusImageView) objArr[4], (ConstraintLayout) objArr[3], (ProgressBar) objArr[8], (ConstraintLayout) objArr[7], (ImageView) objArr[9], (IncludeMessageTitleBinding) objArr[1], (TextView) objArr[6], (ImageView) objArr[5]);
        this.mDirtyFlags = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        setContainedBinding(this.titleLayout);
        setRootTag(view);
        invalidateAll();
    }
}
