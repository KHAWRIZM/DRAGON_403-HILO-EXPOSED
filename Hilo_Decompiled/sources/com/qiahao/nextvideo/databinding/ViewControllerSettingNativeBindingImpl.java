package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.lifecycle.LifecycleOwner;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.reusable.views.SwitchButton;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class ViewControllerSettingNativeBindingImpl extends ViewControllerSettingNativeBinding {
    private static final ViewDataBinding.i sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView1;

    static {
        ViewDataBinding.i iVar = new ViewDataBinding.i(31);
        sIncludes = iVar;
        iVar.a(1, new String[]{"include_title"}, new int[]{2}, new int[]{R.layout.include_title});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.account, 3);
        sparseIntArray.put(R.id.accountDivideView, 4);
        sparseIntArray.put(R.id.changePassword, 5);
        sparseIntArray.put(R.id.changePasswordDivideView, 6);
        sparseIntArray.put(R.id.giftBanner, 7);
        sparseIntArray.put(R.id.giftBannerSwitchView, 8);
        sparseIntArray.put(R.id.giftBannerDivideView, 9);
        sparseIntArray.put(R.id.notificationSetting, 10);
        sparseIntArray.put(R.id.notificationView, 11);
        sparseIntArray.put(R.id.match_notification_container, 12);
        sparseIntArray.put(R.id.matching_notification_switch_view, 13);
        sparseIntArray.put(R.id.match_notification_container_divide_view, 14);
        sparseIntArray.put(R.id.connected_log_button, 15);
        sparseIntArray.put(R.id.connected_log_button_divide_view, 16);
        sparseIntArray.put(R.id.blocked_users_button, 17);
        sparseIntArray.put(R.id.commit_suggest_button, 18);
        sparseIntArray.put(R.id.ll_transfer, 19);
        sparseIntArray.put(R.id.transfer_button, 20);
        sparseIntArray.put(R.id.promoteLayout, 21);
        sparseIntArray.put(R.id.promoterButton, 22);
        sparseIntArray.put(R.id.clear_cache_button, 23);
        sparseIntArray.put(R.id.cache_size_text_view, 24);
        sparseIntArray.put(R.id.platform_policy_button, 25);
        sparseIntArray.put(R.id.commit_star_button, 26);
        sparseIntArray.put(R.id.commit_agora_log, 27);
        sparseIntArray.put(R.id.commit_operation_log, 28);
        sparseIntArray.put(R.id.exit_account_button, 29);
        sparseIntArray.put(R.id.loginFrameLayout, 30);
    }

    public ViewControllerSettingNativeBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 31, sIncludes, sViewsWithIds));
    }

    private boolean onChangeTitleBar(IncludeTitleBinding includeTitleBinding, int i) {
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
        ViewDataBinding.executeBindingsOn(this.titleBar);
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            try {
                if (this.mDirtyFlags != 0) {
                    return true;
                }
                if (this.titleBar.hasPendingBindings()) {
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
        this.titleBar.invalidateAll();
        requestRebind();
    }

    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return onChangeTitleBar((IncludeTitleBinding) obj, i2);
    }

    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.titleBar.setLifecycleOwner(lifecycleOwner);
    }

    public boolean setVariable(int i, Object obj) {
        return true;
    }

    private ViewControllerSettingNativeBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 1, (FrameLayout) objArr[3], (View) objArr[4], (FrameLayout) objArr[0], (AppCompatTextView) objArr[17], (AppCompatTextView) objArr[24], (FrameLayout) objArr[5], (View) objArr[6], (AppCompatTextView) objArr[23], (FrameLayout) objArr[27], (FrameLayout) objArr[28], (AppCompatTextView) objArr[26], (AppCompatTextView) objArr[18], (FrameLayout) objArr[15], (View) objArr[16], (AppCompatTextView) objArr[29], (FrameLayout) objArr[7], (View) objArr[9], (SwitchButton) objArr[8], (LinearLayout) objArr[19], (FrameLayout) objArr[30], (FrameLayout) objArr[12], (View) objArr[14], (SwitchButton) objArr[13], (FrameLayout) objArr[10], (View) objArr[11], (AppCompatTextView) objArr[25], (LinearLayoutCompat) objArr[21], (AppCompatTextView) objArr[22], (IncludeTitleBinding) objArr[2], (AppCompatTextView) objArr[20]);
        this.mDirtyFlags = -1L;
        this.activityMainContainer.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[1];
        this.mboundView1 = constraintLayout;
        constraintLayout.setTag(null);
        setContainedBinding(this.titleBar);
        setRootTag(view);
        invalidateAll();
    }
}
