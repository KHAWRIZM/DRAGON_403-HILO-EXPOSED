package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.reusable.views.SwitchButton;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ViewControllerSettingNativeBinding extends ViewDataBinding {
    public final FrameLayout account;
    public final View accountDivideView;
    public final FrameLayout activityMainContainer;
    public final AppCompatTextView blockedUsersButton;
    public final AppCompatTextView cacheSizeTextView;
    public final FrameLayout changePassword;
    public final View changePasswordDivideView;
    public final AppCompatTextView clearCacheButton;
    public final FrameLayout commitAgoraLog;
    public final FrameLayout commitOperationLog;
    public final AppCompatTextView commitStarButton;
    public final AppCompatTextView commitSuggestButton;
    public final FrameLayout connectedLogButton;
    public final View connectedLogButtonDivideView;
    public final AppCompatTextView exitAccountButton;
    public final FrameLayout giftBanner;
    public final View giftBannerDivideView;
    public final SwitchButton giftBannerSwitchView;
    public final LinearLayout llTransfer;
    public final FrameLayout loginFrameLayout;
    public final FrameLayout matchNotificationContainer;
    public final View matchNotificationContainerDivideView;
    public final SwitchButton matchingNotificationSwitchView;
    public final FrameLayout notificationSetting;
    public final View notificationView;
    public final AppCompatTextView platformPolicyButton;
    public final LinearLayoutCompat promoteLayout;
    public final AppCompatTextView promoterButton;
    public final IncludeTitleBinding titleBar;
    public final AppCompatTextView transferButton;

    /* JADX INFO: Access modifiers changed from: protected */
    public ViewControllerSettingNativeBinding(Object obj, View view, int i, FrameLayout frameLayout, View view2, FrameLayout frameLayout2, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, FrameLayout frameLayout3, View view3, AppCompatTextView appCompatTextView3, FrameLayout frameLayout4, FrameLayout frameLayout5, AppCompatTextView appCompatTextView4, AppCompatTextView appCompatTextView5, FrameLayout frameLayout6, View view4, AppCompatTextView appCompatTextView6, FrameLayout frameLayout7, View view5, SwitchButton switchButton, LinearLayout linearLayout, FrameLayout frameLayout8, FrameLayout frameLayout9, View view6, SwitchButton switchButton2, FrameLayout frameLayout10, View view7, AppCompatTextView appCompatTextView7, LinearLayoutCompat linearLayoutCompat, AppCompatTextView appCompatTextView8, IncludeTitleBinding includeTitleBinding, AppCompatTextView appCompatTextView9) {
        super(obj, view, i);
        this.account = frameLayout;
        this.accountDivideView = view2;
        this.activityMainContainer = frameLayout2;
        this.blockedUsersButton = appCompatTextView;
        this.cacheSizeTextView = appCompatTextView2;
        this.changePassword = frameLayout3;
        this.changePasswordDivideView = view3;
        this.clearCacheButton = appCompatTextView3;
        this.commitAgoraLog = frameLayout4;
        this.commitOperationLog = frameLayout5;
        this.commitStarButton = appCompatTextView4;
        this.commitSuggestButton = appCompatTextView5;
        this.connectedLogButton = frameLayout6;
        this.connectedLogButtonDivideView = view4;
        this.exitAccountButton = appCompatTextView6;
        this.giftBanner = frameLayout7;
        this.giftBannerDivideView = view5;
        this.giftBannerSwitchView = switchButton;
        this.llTransfer = linearLayout;
        this.loginFrameLayout = frameLayout8;
        this.matchNotificationContainer = frameLayout9;
        this.matchNotificationContainerDivideView = view6;
        this.matchingNotificationSwitchView = switchButton2;
        this.notificationSetting = frameLayout10;
        this.notificationView = view7;
        this.platformPolicyButton = appCompatTextView7;
        this.promoteLayout = linearLayoutCompat;
        this.promoterButton = appCompatTextView8;
        this.titleBar = includeTitleBinding;
        this.transferButton = appCompatTextView9;
    }

    public static ViewControllerSettingNativeBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ViewControllerSettingNativeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ViewControllerSettingNativeBinding bind(View view, Object obj) {
        return (ViewControllerSettingNativeBinding) ViewDataBinding.bind(obj, view, R.layout.view_controller_setting_native);
    }

    @Deprecated
    public static ViewControllerSettingNativeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ViewControllerSettingNativeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_controller_setting_native, viewGroup, z, obj);
    }

    public static ViewControllerSettingNativeBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ViewControllerSettingNativeBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ViewControllerSettingNativeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_controller_setting_native, (ViewGroup) null, false, obj);
    }
}
