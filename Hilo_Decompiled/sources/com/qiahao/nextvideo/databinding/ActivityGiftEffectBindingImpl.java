package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.lifecycle.LifecycleOwner;
import com.qiahao.base_common.player.combination.queue.LightQueueCombinationPlayer;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class ActivityGiftEffectBindingImpl extends ActivityGiftEffectBinding {
    private static final ViewDataBinding.i sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView1;

    static {
        ViewDataBinding.i iVar = new ViewDataBinding.i(25);
        sIncludes = iVar;
        iVar.a(1, new String[]{"include_title"}, new int[]{2}, new int[]{R.layout.include_title});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131363500, 3);
        sparseIntArray.put(2131364717, 4);
        sparseIntArray.put(R.id.giftEffectText, 5);
        sparseIntArray.put(R.id.backGround, 6);
        sparseIntArray.put(R.id.addImage, 7);
        sparseIntArray.put(R.id.giftEffectBg, 8);
        sparseIntArray.put(R.id.close, 9);
        sparseIntArray.put(R.id.giftEffect, 10);
        sparseIntArray.put(2131365528, 11);
        sparseIntArray.put(R.id.diamond, 12);
        sparseIntArray.put(R.id.preview, 13);
        sparseIntArray.put(R.id.selectGroup, 14);
        sparseIntArray.put(R.id.instructionTitle1, 15);
        sparseIntArray.put(R.id.instructionTitle1One, 16);
        sparseIntArray.put(R.id.instructionTitle2, 17);
        sparseIntArray.put(R.id.instructionTitle2One, 18);
        sparseIntArray.put(R.id.instructionTitle3, 19);
        sparseIntArray.put(R.id.instructionTitle3One, 20);
        sparseIntArray.put(R.id.instructionTitle4, 21);
        sparseIntArray.put(R.id.instructionTitle4One, 22);
        sparseIntArray.put(R.id.submit, 23);
        sparseIntArray.put(R.id.queuePlayer, 24);
    }

    public ActivityGiftEffectBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 25, sIncludes, sViewsWithIds));
    }

    private boolean onChangeTitle(IncludeTitleBinding includeTitleBinding, int i) {
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
        ViewDataBinding.executeBindingsOn(this.title);
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            try {
                if (this.mDirtyFlags != 0) {
                    return true;
                }
                if (this.title.hasPendingBindings()) {
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
        this.title.invalidateAll();
        requestRebind();
    }

    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return onChangeTitle((IncludeTitleBinding) obj, i2);
    }

    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.title.setLifecycleOwner(lifecycleOwner);
    }

    public boolean setVariable(int i, Object obj) {
        return true;
    }

    private ActivityGiftEffectBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 1, (FrameLayout) objArr[0], (ImageView) objArr[7], (View) objArr[6], (ImageView) objArr[9], (TextView) objArr[12], (ImageView) objArr[10], (View) objArr[8], (TextView) objArr[5], (TextView) objArr[15], (TextView) objArr[16], (TextView) objArr[17], (TextView) objArr[18], (TextView) objArr[19], (TextView) objArr[20], (TextView) objArr[21], (TextView) objArr[22], (View) objArr[3], (TextView) objArr[13], (LightQueueCombinationPlayer) objArr[24], (NestedScrollView) objArr[4], (Group) objArr[14], (TextView) objArr[23], (IncludeTitleBinding) objArr[2], (TextView) objArr[11]);
        this.mDirtyFlags = -1L;
        this.activityMainContainer.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[1];
        this.mboundView1 = constraintLayout;
        constraintLayout.setTag(null);
        setContainedBinding(this.title);
        setRootTag(view);
        invalidateAll();
    }
}
