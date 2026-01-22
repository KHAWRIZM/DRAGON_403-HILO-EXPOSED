package com.tencent.qcloud.tuikit.tuichat.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.lifecycle.LifecycleOwner;
import com.qiahao.base_common.R;
import com.qiahao.base_common.databinding.IncludeFamilyNamePlateBinding;
import com.qiahao.base_common.wedgit.HiloGradeView;
import com.tencent.qcloud.tuikit.tuichat.BR;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class IncludeMessageTitleChatBindingImpl extends IncludeMessageTitleChatBinding {
    private static final ViewDataBinding.i sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final LinearLayout mboundView1;

    static {
        ViewDataBinding.i iVar = new ViewDataBinding.i(12);
        sIncludes = iVar;
        iVar.a(1, new String[]{"include_family_name_plate"}, new int[]{2}, new int[]{R.layout.include_family_name_plate});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(com.tencent.qcloud.tuikit.tuichat.R.id.user_name_tv, 3);
        sparseIntArray.put(com.tencent.qcloud.tuikit.tuichat.R.id.user_tag, 4);
        sparseIntArray.put(com.tencent.qcloud.tuikit.tuichat.R.id.wealth_level, 5);
        sparseIntArray.put(com.tencent.qcloud.tuikit.tuichat.R.id.charm_level, 6);
        sparseIntArray.put(com.tencent.qcloud.tuikit.tuichat.R.id.img_beauty_account, 7);
        sparseIntArray.put(com.tencent.qcloud.tuikit.tuichat.R.id.icon_vip, 8);
        sparseIntArray.put(com.tencent.qcloud.tuikit.tuichat.R.id.svip, 9);
        sparseIntArray.put(com.tencent.qcloud.tuikit.tuichat.R.id.icon_noble, 10);
        sparseIntArray.put(com.tencent.qcloud.tuikit.tuichat.R.id.ll_medal, 11);
    }

    public IncludeMessageTitleChatBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 12, sIncludes, sViewsWithIds));
    }

    private boolean onChangeFamilyNamePlate(IncludeFamilyNamePlateBinding includeFamilyNamePlateBinding, int i) {
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
        ViewDataBinding.executeBindingsOn(this.familyNamePlate);
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            try {
                if (this.mDirtyFlags != 0) {
                    return true;
                }
                if (this.familyNamePlate.hasPendingBindings()) {
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
        this.familyNamePlate.invalidateAll();
        requestRebind();
    }

    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return onChangeFamilyNamePlate((IncludeFamilyNamePlateBinding) obj, i2);
    }

    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.familyNamePlate.setLifecycleOwner(lifecycleOwner);
    }

    public boolean setVariable(int i, Object obj) {
        return true;
    }

    private IncludeMessageTitleChatBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 1, (HiloGradeView) objArr[6], (IncludeFamilyNamePlateBinding) objArr[2], (ImageView) objArr[10], (ImageView) objArr[8], (ImageView) objArr[7], (LinearLayout) objArr[11], (LinearLayout) objArr[0], (ImageView) objArr[9], (TextView) objArr[3], (ImageView) objArr[4], (HiloGradeView) objArr[5]);
        this.mDirtyFlags = -1L;
        setContainedBinding(this.familyNamePlate);
        this.llNameTime.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[1];
        this.mboundView1 = linearLayout;
        linearLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
