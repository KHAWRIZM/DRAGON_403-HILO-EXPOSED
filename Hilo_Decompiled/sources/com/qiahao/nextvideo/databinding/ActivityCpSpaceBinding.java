package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.recyclerview.widget.RecyclerView;
import com.qiahao.base_common.utils.image.HiloImageView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.view.CpLevelView;
import com.zhpan.bannerview.BannerViewPager;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ActivityCpSpaceBinding extends ViewDataBinding {
    public final FrameLayout activityMainContainer;
    public final ImageView addImage;
    public final HiloImageView applyAvatar;
    public final TextView applyContent;
    public final BannerViewPager banner;
    public final TextView bindCp;
    public final Group bindGroup;
    public final ImageView buttonBg;
    public final ImageView certificate;
    public final Group certificateGroup;
    public final TextView certificateText;
    public final CpLevelView cpLevel;
    public final TextView cpTip;
    public final TextView day;
    public final ImageView dayLine;
    public final TextView dayNumber;
    public final TextView fell;
    public final TextView keepTip;
    public final HiloImageView leftAvatar;
    public final AppCompatImageView leftButton;
    public final ImageView leftIcon;
    public final TextView leftName;
    public final ImageView memorial;
    public final Group memorialGroup;
    public final TextView memorialText;
    public final TextView myCp;
    public final FrameLayout myCpLayout;
    public final Group pointGroup;
    public final ConstraintLayout pointLayout;
    public final TextView pointNumber;
    public final TextView pointText;
    public final TextView pointTip;
    public final FrameLayout privilegeLayout;
    public final TextView privilegeTitle;
    public final ProgressBar progressBar;
    public final ImageView progressBg;
    public final TextView progressEnd;
    public final TextView progressStart;
    public final RecyclerView recyclerView;
    public final TextView revoke;
    public final HiloImageView rightAvatar;
    public final AppCompatImageView rightButton;
    public final ImageView rightIcon;
    public final TextView rightName;
    public final ImageView stage;
    public final TextView time;
    public final IncludeTitleBinding titleBar;
    public final ImageView topBg;
    public final ImageView topIcon;
    public final ImageView topLine;
    public final View touchBanner;
    public final ConstraintLayout unBindApply;
    public final ImageView unBindAvatar;
    public final Group unBindGroup;
    public final TextView unBindText;
    public final TextView visit;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivityCpSpaceBinding(Object obj, View view, int i, FrameLayout frameLayout, ImageView imageView, HiloImageView hiloImageView, TextView textView, BannerViewPager bannerViewPager, TextView textView2, Group group, ImageView imageView2, ImageView imageView3, Group group2, TextView textView3, CpLevelView cpLevelView, TextView textView4, TextView textView5, ImageView imageView4, TextView textView6, TextView textView7, TextView textView8, HiloImageView hiloImageView2, AppCompatImageView appCompatImageView, ImageView imageView5, TextView textView9, ImageView imageView6, Group group3, TextView textView10, TextView textView11, FrameLayout frameLayout2, Group group4, ConstraintLayout constraintLayout, TextView textView12, TextView textView13, TextView textView14, FrameLayout frameLayout3, TextView textView15, ProgressBar progressBar, ImageView imageView7, TextView textView16, TextView textView17, RecyclerView recyclerView, TextView textView18, HiloImageView hiloImageView3, AppCompatImageView appCompatImageView2, ImageView imageView8, TextView textView19, ImageView imageView9, TextView textView20, IncludeTitleBinding includeTitleBinding, ImageView imageView10, ImageView imageView11, ImageView imageView12, View view2, ConstraintLayout constraintLayout2, ImageView imageView13, Group group5, TextView textView21, TextView textView22) {
        super(obj, view, i);
        this.activityMainContainer = frameLayout;
        this.addImage = imageView;
        this.applyAvatar = hiloImageView;
        this.applyContent = textView;
        this.banner = bannerViewPager;
        this.bindCp = textView2;
        this.bindGroup = group;
        this.buttonBg = imageView2;
        this.certificate = imageView3;
        this.certificateGroup = group2;
        this.certificateText = textView3;
        this.cpLevel = cpLevelView;
        this.cpTip = textView4;
        this.day = textView5;
        this.dayLine = imageView4;
        this.dayNumber = textView6;
        this.fell = textView7;
        this.keepTip = textView8;
        this.leftAvatar = hiloImageView2;
        this.leftButton = appCompatImageView;
        this.leftIcon = imageView5;
        this.leftName = textView9;
        this.memorial = imageView6;
        this.memorialGroup = group3;
        this.memorialText = textView10;
        this.myCp = textView11;
        this.myCpLayout = frameLayout2;
        this.pointGroup = group4;
        this.pointLayout = constraintLayout;
        this.pointNumber = textView12;
        this.pointText = textView13;
        this.pointTip = textView14;
        this.privilegeLayout = frameLayout3;
        this.privilegeTitle = textView15;
        this.progressBar = progressBar;
        this.progressBg = imageView7;
        this.progressEnd = textView16;
        this.progressStart = textView17;
        this.recyclerView = recyclerView;
        this.revoke = textView18;
        this.rightAvatar = hiloImageView3;
        this.rightButton = appCompatImageView2;
        this.rightIcon = imageView8;
        this.rightName = textView19;
        this.stage = imageView9;
        this.time = textView20;
        this.titleBar = includeTitleBinding;
        this.topBg = imageView10;
        this.topIcon = imageView11;
        this.topLine = imageView12;
        this.touchBanner = view2;
        this.unBindApply = constraintLayout2;
        this.unBindAvatar = imageView13;
        this.unBindGroup = group5;
        this.unBindText = textView21;
        this.visit = textView22;
    }

    public static ActivityCpSpaceBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ActivityCpSpaceBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ActivityCpSpaceBinding bind(View view, Object obj) {
        return (ActivityCpSpaceBinding) ViewDataBinding.bind(obj, view, R.layout.activity_cp_space);
    }

    @Deprecated
    public static ActivityCpSpaceBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityCpSpaceBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_cp_space, viewGroup, z, obj);
    }

    public static ActivityCpSpaceBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ActivityCpSpaceBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityCpSpaceBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_cp_space, (ViewGroup) null, false, obj);
    }
}
