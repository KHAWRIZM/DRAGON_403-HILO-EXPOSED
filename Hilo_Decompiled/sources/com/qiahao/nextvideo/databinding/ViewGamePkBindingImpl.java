package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.lifecycle.LifecycleOwner;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.room.view.micro.PKMicroView;
import com.qiahao.nextvideo.view.PKButtonView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class ViewGamePkBindingImpl extends ViewGamePkBinding {
    private static final ViewDataBinding.i sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final FrameLayout mboundView0;
    private final ConstraintLayout mboundView1;

    static {
        ViewDataBinding.i iVar = new ViewDataBinding.i(10);
        sIncludes = iVar;
        iVar.a(1, new String[]{"include_pk_go", "include_pk_go"}, new int[]{2, 3}, new int[]{R.layout.include_pk_go, R.layout.include_pk_go});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.leftMic, 4);
        sparseIntArray.put(R.id.rightMic, 5);
        sparseIntArray.put(2131365152, 6);
        sparseIntArray.put(R.id.redMic, 7);
        sparseIntArray.put(R.id.blueMic, 8);
        sparseIntArray.put(R.id.button, 9);
    }

    public ViewGamePkBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 10, sIncludes, sViewsWithIds));
    }

    private boolean onChangeBlueGo(IncludePkGoBinding includePkGoBinding, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeRedGo(IncludePkGoBinding includePkGoBinding, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        }
        return false;
    }

    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
        ViewDataBinding.executeBindingsOn(this.redGo);
        ViewDataBinding.executeBindingsOn(this.blueGo);
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            try {
                if (this.mDirtyFlags != 0) {
                    return true;
                }
                if (this.redGo.hasPendingBindings() || this.blueGo.hasPendingBindings()) {
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
            this.mDirtyFlags = 4L;
        }
        this.redGo.invalidateAll();
        this.blueGo.invalidateAll();
        requestRebind();
    }

    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            if (i != 1) {
                return false;
            }
            return onChangeRedGo((IncludePkGoBinding) obj, i2);
        }
        return onChangeBlueGo((IncludePkGoBinding) obj, i2);
    }

    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.redGo.setLifecycleOwner(lifecycleOwner);
        this.blueGo.setLifecycleOwner(lifecycleOwner);
    }

    public boolean setVariable(int i, Object obj) {
        return true;
    }

    private ViewGamePkBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 2, (IncludePkGoBinding) objArr[3], (ImageView) objArr[8], (PKButtonView) objArr[9], (PKMicroView) objArr[4], (IncludePkGoBinding) objArr[2], (ImageView) objArr[7], (PKMicroView) objArr[5], (TextView) objArr[6]);
        this.mDirtyFlags = -1L;
        setContainedBinding(this.blueGo);
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.mboundView0 = frameLayout;
        frameLayout.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[1];
        this.mboundView1 = constraintLayout;
        constraintLayout.setTag(null);
        setContainedBinding(this.redGo);
        setRootTag(view);
        invalidateAll();
    }
}
