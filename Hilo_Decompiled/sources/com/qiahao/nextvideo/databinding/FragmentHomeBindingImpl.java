package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.lifecycle.LifecycleOwner;
import com.oudi.widget.CustomTabLayout;
import com.oudi.widget.NoScrollViewPager;
import com.qiahao.base_common.player.combination.queue.LightQueueCombinationPlayer;
import com.qiahao.base_common.utils.image.HiloImageView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.flowingdrawer.FlowingDrawer;
import com.qiahao.nextvideo.flowingdrawer.FlowingMenuLayout;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class FragmentHomeBindingImpl extends FragmentHomeBinding {
    private static final ViewDataBinding.i sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        ViewDataBinding.i iVar = new ViewDataBinding.i(31);
        sIncludes = iVar;
        iVar.a(1, new String[]{"view_controller_home_drawer_head_layout"}, new int[]{2}, new int[]{R.layout.view_controller_home_drawer_head_layout});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.backGround, 3);
        sparseIntArray.put(R.id.video_preview_container, 4);
        sparseIntArray.put(R.id.cover_image_view, 5);
        sparseIntArray.put(2131365624, 6);
        sparseIntArray.put(2131362013, 7);
        sparseIntArray.put(R.id.tabBg, 8);
        sparseIntArray.put(R.id.tabLayout, 9);
        sparseIntArray.put(R.id.debug_button, 10);
        sparseIntArray.put(R.id.backGroup, 11);
        sparseIntArray.put(R.id.queuePlayer, 12);
        sparseIntArray.put(R.id.menu_layout, 13);
        sparseIntArray.put(R.id.like_container, 14);
        sparseIntArray.put(R.id.history_paired_container, 15);
        sparseIntArray.put(R.id.history_paired_count_text_view, 16);
        sparseIntArray.put(R.id.purchase_diamond_container, 17);
        sparseIntArray.put(R.id.walletIcon, 18);
        sparseIntArray.put(R.id.recharge, 19);
        sparseIntArray.put(R.id.earn_diamond, 20);
        sparseIntArray.put(2131364963, 21);
        sparseIntArray.put(R.id.nobility_container, 22);
        sparseIntArray.put(R.id.vip_container, 23);
        sparseIntArray.put(R.id.gameLayout, 24);
        sparseIntArray.put(R.id.power_content, 25);
        sparseIntArray.put(R.id.store_content, 26);
        sparseIntArray.put(R.id.medal_content, 27);
        sparseIntArray.put(R.id.level_content, 28);
        sparseIntArray.put(R.id.giftRecord, 29);
        sparseIntArray.put(R.id.setting_container, 30);
    }

    public FragmentHomeBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 31, sIncludes, sViewsWithIds));
    }

    private boolean onChangeDrawerHeadLayout(ViewControllerHomeDrawerHeadLayoutBinding viewControllerHomeDrawerHeadLayoutBinding, int i) {
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
        ViewDataBinding.executeBindingsOn(this.drawerHeadLayout);
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            try {
                if (this.mDirtyFlags != 0) {
                    return true;
                }
                if (this.drawerHeadLayout.hasPendingBindings()) {
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
        this.drawerHeadLayout.invalidateAll();
        requestRebind();
    }

    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return onChangeDrawerHeadLayout((ViewControllerHomeDrawerHeadLayoutBinding) obj, i2);
    }

    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.drawerHeadLayout.setLifecycleOwner(lifecycleOwner);
    }

    public boolean setVariable(int i, Object obj) {
        return true;
    }

    private FragmentHomeBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 1, (HiloImageView) objArr[7], (ImageView) objArr[3], (FrameLayout) objArr[11], (AppCompatImageView) objArr[5], (AppCompatImageButton) objArr[10], (ViewControllerHomeDrawerHeadLayoutBinding) objArr[2], (FlowingDrawer) objArr[0], (FrameLayout) objArr[20], (LinearLayoutCompat) objArr[1], (FrameLayout) objArr[24], (FrameLayout) objArr[29], (FrameLayout) objArr[15], (AppCompatTextView) objArr[16], (FrameLayout) objArr[28], (FrameLayout) objArr[14], (FrameLayout) objArr[27], (FlowingMenuLayout) objArr[13], (FrameLayout) objArr[22], (FrameLayout) objArr[25], (ConstraintLayout) objArr[17], (LightQueueCombinationPlayer) objArr[12], (TextView) objArr[19], (FrameLayout) objArr[30], (FrameLayout) objArr[26], (FrameLayout) objArr[21], (ImageView) objArr[8], (CustomTabLayout) objArr[9], (FrameLayout) objArr[4], (NoScrollViewPager) objArr[6], (FrameLayout) objArr[23], (AppCompatTextView) objArr[18]);
        this.mDirtyFlags = -1L;
        setContainedBinding(this.drawerHeadLayout);
        this.drawerlayout.setTag(null);
        this.flowingMenuLayoutContainer.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
