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
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.opensource.svgaplayer.SVGAImageView;
import com.qiahao.base_common.player.combination.queue.LightQueueCombinationPlayer;
import com.qiahao.base_common.utils.image.HiloImageView;
import com.qiahao.base_common.wedgit.HiloGradeView;
import com.qiahao.base_common.wedgit.shineText.CountryIDView;
import com.qiahao.base_common.wedgit.shineText.NickTextView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.reusable.views.GenderAgeTextView;
import com.qiahao.nextvideo.view.SlidingTabLayout;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.zhpan.bannerview.BannerViewPager;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class ActivityUserDetailBindingImpl extends ActivityUserDetailBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.refreshLayout, 1);
        sparseIntArray.put(R.id.common_id_content_container, 2);
        sparseIntArray.put(2131365217, 3);
        sparseIntArray.put(R.id.collapsing_toolbar_layout, 4);
        sparseIntArray.put(R.id.viewpager_photo, 5);
        sparseIntArray.put(R.id.photoBg, 6);
        sparseIntArray.put(R.id.nobleBg, 7);
        sparseIntArray.put(R.id.topWhiteBg, 8);
        sparseIntArray.put(R.id.follow, 9);
        sparseIntArray.put(R.id.fans, 10);
        sparseIntArray.put(R.id.visitor, 11);
        sparseIntArray.put(R.id.des, 12);
        sparseIntArray.put(R.id.recyclerSmallPhoto, 13);
        sparseIntArray.put(R.id.nameLinear, 14);
        sparseIntArray.put(R.id.newUser, 15);
        sparseIntArray.put(R.id.age_text_view, 16);
        sparseIntArray.put(R.id.countryFlagImageView, 17);
        sparseIntArray.put(2131365691, 18);
        sparseIntArray.put(2131362273, 19);
        sparseIntArray.put(R.id.activity_level, 20);
        sparseIntArray.put(2131363182, 21);
        sparseIntArray.put(R.id.countryID, 22);
        sparseIntArray.put(R.id.countrySVGA, 23);
        sparseIntArray.put(R.id.nickname_text_view, 24);
        sparseIntArray.put(R.id.svipType, 25);
        sparseIntArray.put(R.id.userAvatar, 26);
        sparseIntArray.put(R.id.userHeadSvga, 27);
        sparseIntArray.put(R.id.userHeadImg, 28);
        sparseIntArray.put(R.id.svipSVGA, 29);
        sparseIntArray.put(R.id.margeTop, 30);
        sparseIntArray.put(R.id.bar, 31);
        sparseIntArray.put(R.id.backImageView, 32);
        sparseIntArray.put(2131365189, 33);
        sparseIntArray.put(R.id.svipType1, 34);
        sparseIntArray.put(R.id.recyclerSmallPhoto1, 35);
        sparseIntArray.put(R.id.setting, 36);
        sparseIntArray.put(R.id.report, 37);
        sparseIntArray.put(R.id.tabLayout, 38);
        sparseIntArray.put(2131365640, 39);
        sparseIntArray.put(R.id.tabBg, 40);
        sparseIntArray.put(R.id.other_profile_view, 41);
        sparseIntArray.put(R.id.liked_image_button, 42);
        sparseIntArray.put(R.id.chat_image_button, 43);
        sparseIntArray.put(R.id.video_call_image_button, 44);
        sparseIntArray.put(R.id.room_image_button, 45);
        sparseIntArray.put(R.id.post_btn, 46);
        sparseIntArray.put(R.id.like_svga_image_view, 47);
        sparseIntArray.put(R.id.queuePlayer, 48);
    }

    public ActivityUserDetailBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 49, sIncludes, sViewsWithIds));
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

    private ActivityUserDetailBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (HiloGradeView) objArr[20], (FrameLayout) objArr[0], (GenderAgeTextView) objArr[16], (AppCompatImageView) objArr[32], (View) objArr[31], (HiloGradeView) objArr[19], (AppCompatImageView) objArr[43], (CollapsingToolbarLayout) objArr[4], (CoordinatorLayout) objArr[2], (AppCompatImageView) objArr[17], (CountryIDView) objArr[22], (SVGAImageView) objArr[23], (AppCompatTextView) objArr[12], (TextView) objArr[10], (TextView) objArr[9], (ImageView) objArr[21], (SVGAImageView) objArr[47], (AppCompatImageView) objArr[42], (Toolbar) objArr[30], (LinearLayoutCompat) objArr[14], (ImageView) objArr[15], (NickTextView) objArr[24], (LightQueueCombinationPlayer) objArr[7], (ConstraintLayout) objArr[41], (View) objArr[6], (AppCompatImageView) objArr[46], (LightQueueCombinationPlayer) objArr[48], (RecyclerView) objArr[13], (RecyclerView) objArr[35], (SmartRefreshLayout) objArr[1], (AppCompatImageView) objArr[37], (AppCompatImageButton) objArr[45], (AppCompatImageView) objArr[36], (SVGAImageView) objArr[29], (ImageView) objArr[25], (ImageView) objArr[34], (View) objArr[40], (SlidingTabLayout) objArr[38], (AppCompatTextView) objArr[33], (AppBarLayout) objArr[3], (ConstraintLayout) objArr[8], (HiloImageView) objArr[26], (ImageView) objArr[28], (SVGAImageView) objArr[27], (AppCompatImageButton) objArr[44], (ViewPager) objArr[39], (BannerViewPager) objArr[5], (TextView) objArr[11], (HiloGradeView) objArr[18]);
        this.mDirtyFlags = -1L;
        this.activityMainContainer.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
