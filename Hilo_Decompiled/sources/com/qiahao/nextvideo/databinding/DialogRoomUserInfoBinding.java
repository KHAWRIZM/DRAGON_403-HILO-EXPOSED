package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.opensource.svgaplayer.SVGAImageView;
import com.qiahao.base_common.databinding.IncludeFamilyNamePlateBinding;
import com.qiahao.base_common.databinding.IncludeGameLevelBinding;
import com.qiahao.base_common.player.combination.queue.LightQueueCombinationPlayer;
import com.qiahao.base_common.utils.image.HiloImageView;
import com.qiahao.base_common.wedgit.HiloGradeView;
import com.qiahao.base_common.wedgit.HiloMedalView;
import com.qiahao.base_common.wedgit.shineText.CountryIDView;
import com.qiahao.base_common.wedgit.shineText.NickTextView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.reusable.views.GenderAgeTextView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class DialogRoomUserInfoBinding extends ViewDataBinding {
    public final HiloGradeView activityLevel;
    public final GenderAgeTextView ageTextView;
    public final LinearLayout allContent;
    public final ConstraintLayout backHeight;
    public final View bottomLine;
    public final AppCompatImageView callUser;
    public final HiloGradeView charmLevel;
    public final View contentBg;
    public final CountryIDView countryID;
    public final SVGAImageView countrySVGA;
    public final TextView countryText;
    public final Group cpGroup;
    public final ImageView cpModel;
    public final IncludeFamilyNamePlateBinding familyNamePlate;
    public final IncludeGameLevelBinding gameLevel;
    public final ImageView iconNoble;
    public final ImageView iconNobleTwo;
    public final ImageView iconVip;
    public final ImageView imageInviteUserUpMic;
    public final ImageView imageLike;
    public final ImageView imageUserDownMic;
    public final ImageView imageUserInfo;
    public final ImageView imageUserLeaveRoom;
    public final ImageView imageUserMuteOpenMic;
    public final ImageView imageUserTag;
    public final ImageView imageViewCountry;
    public final LinearLayout llGift;
    public final LinearLayout llLevel;
    public final LinearLayout llLike;
    public final HiloMedalView llMeadl;
    public final LinearLayout llMessage;
    public final LinearLayout llUserInfo;
    public final LinearLayout llUserMicroRoomOperator;
    public final LinearLayout llUserOperator;
    public final LinearLayout llVideo;
    protected View.OnClickListener mClick;
    public final AppCompatImageView micMute;
    public final ImageView micUserHeadImg;
    public final ImageView micUserHeadImgTwo;
    public final SVGAImageView micUserHeadSvga;
    public final SVGAImageView micUserHeadSvgaTwo;
    public final ImageView newUser;
    public final ImageView nobleBg;
    public final SVGAImageView nobleSvga;
    public final LightQueueCombinationPlayer queuePlayer;
    public final AppCompatImageView reportImageView;
    public final ConstraintLayout rootBg;
    public final ImageView svipMedal;
    public final ImageView svipMedalTwo;
    public final ImageView svipType;
    public final View svipTypeLine;
    public final ImageView topView;
    public final HiloImageView userAvatar;
    public final HiloImageView userAvatarTwo;
    public final NickTextView userName;
    public final TextView userTagText;
    public final View userTagView;
    public final HiloGradeView wealthLevel;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogRoomUserInfoBinding(Object obj, View view, int i, HiloGradeView hiloGradeView, GenderAgeTextView genderAgeTextView, LinearLayout linearLayout, ConstraintLayout constraintLayout, View view2, AppCompatImageView appCompatImageView, HiloGradeView hiloGradeView2, View view3, CountryIDView countryIDView, SVGAImageView sVGAImageView, TextView textView, Group group, ImageView imageView, IncludeFamilyNamePlateBinding includeFamilyNamePlateBinding, IncludeGameLevelBinding includeGameLevelBinding, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, ImageView imageView7, ImageView imageView8, ImageView imageView9, ImageView imageView10, ImageView imageView11, ImageView imageView12, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, HiloMedalView hiloMedalView, LinearLayout linearLayout5, LinearLayout linearLayout6, LinearLayout linearLayout7, LinearLayout linearLayout8, LinearLayout linearLayout9, AppCompatImageView appCompatImageView2, ImageView imageView13, ImageView imageView14, SVGAImageView sVGAImageView2, SVGAImageView sVGAImageView3, ImageView imageView15, ImageView imageView16, SVGAImageView sVGAImageView4, LightQueueCombinationPlayer lightQueueCombinationPlayer, AppCompatImageView appCompatImageView3, ConstraintLayout constraintLayout2, ImageView imageView17, ImageView imageView18, ImageView imageView19, View view4, ImageView imageView20, HiloImageView hiloImageView, HiloImageView hiloImageView2, NickTextView nickTextView, TextView textView2, View view5, HiloGradeView hiloGradeView3) {
        super(obj, view, i);
        this.activityLevel = hiloGradeView;
        this.ageTextView = genderAgeTextView;
        this.allContent = linearLayout;
        this.backHeight = constraintLayout;
        this.bottomLine = view2;
        this.callUser = appCompatImageView;
        this.charmLevel = hiloGradeView2;
        this.contentBg = view3;
        this.countryID = countryIDView;
        this.countrySVGA = sVGAImageView;
        this.countryText = textView;
        this.cpGroup = group;
        this.cpModel = imageView;
        this.familyNamePlate = includeFamilyNamePlateBinding;
        this.gameLevel = includeGameLevelBinding;
        this.iconNoble = imageView2;
        this.iconNobleTwo = imageView3;
        this.iconVip = imageView4;
        this.imageInviteUserUpMic = imageView5;
        this.imageLike = imageView6;
        this.imageUserDownMic = imageView7;
        this.imageUserInfo = imageView8;
        this.imageUserLeaveRoom = imageView9;
        this.imageUserMuteOpenMic = imageView10;
        this.imageUserTag = imageView11;
        this.imageViewCountry = imageView12;
        this.llGift = linearLayout2;
        this.llLevel = linearLayout3;
        this.llLike = linearLayout4;
        this.llMeadl = hiloMedalView;
        this.llMessage = linearLayout5;
        this.llUserInfo = linearLayout6;
        this.llUserMicroRoomOperator = linearLayout7;
        this.llUserOperator = linearLayout8;
        this.llVideo = linearLayout9;
        this.micMute = appCompatImageView2;
        this.micUserHeadImg = imageView13;
        this.micUserHeadImgTwo = imageView14;
        this.micUserHeadSvga = sVGAImageView2;
        this.micUserHeadSvgaTwo = sVGAImageView3;
        this.newUser = imageView15;
        this.nobleBg = imageView16;
        this.nobleSvga = sVGAImageView4;
        this.queuePlayer = lightQueueCombinationPlayer;
        this.reportImageView = appCompatImageView3;
        this.rootBg = constraintLayout2;
        this.svipMedal = imageView17;
        this.svipMedalTwo = imageView18;
        this.svipType = imageView19;
        this.svipTypeLine = view4;
        this.topView = imageView20;
        this.userAvatar = hiloImageView;
        this.userAvatarTwo = hiloImageView2;
        this.userName = nickTextView;
        this.userTagText = textView2;
        this.userTagView = view5;
        this.wealthLevel = hiloGradeView3;
    }

    public static DialogRoomUserInfoBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static DialogRoomUserInfoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public abstract void setClick(View.OnClickListener onClickListener);

    @Deprecated
    public static DialogRoomUserInfoBinding bind(View view, Object obj) {
        return (DialogRoomUserInfoBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_room_user_info);
    }

    @Deprecated
    public static DialogRoomUserInfoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogRoomUserInfoBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_room_user_info, viewGroup, z, obj);
    }

    public static DialogRoomUserInfoBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static DialogRoomUserInfoBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogRoomUserInfoBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_room_user_info, (ViewGroup) null, false, obj);
    }
}
