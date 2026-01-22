package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.recyclerview.widget.RecyclerView;
import com.makeramen.roundedimageview.RoundedImageView;
import com.opensource.svgaplayer.SVGAImageView;
import com.qiahao.base_common.player.combination.queue.LightQueueCombinationPlayer;
import com.qiahao.base_common.wedgit.shineText.NickTextView;
import com.qiahao.base_common.wedgit.shineText.ShineTextView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.room.rocket.RoomRocketEnterView;
import com.qiahao.nextvideo.room.view.GlobalRoomBroadCastLayout;
import com.qiahao.nextvideo.room.view.GroupBannerView;
import com.qiahao.nextvideo.room.view.GroupInputLayoutView;
import com.qiahao.nextvideo.room.view.MeetingRoomOnlineMemberLayout;
import com.qiahao.nextvideo.room.view.RocketSvgaCountdownView;
import com.qiahao.nextvideo.room.view.micro.NewMicroView;
import com.qiahao.nextvideo.view.PKSearchView;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class FragmentAudioRoomBinding extends ViewDataBinding {
    public final ImageView backgammonGame;
    public final ImageView balootGame;
    public final View bgAllBlack;
    public final ImageView carromGame;
    public final ConstraintLayout centerLayout;
    public final AppCompatImageView changeGameModel;
    public final FrameLayout chatBack;
    public final ImageView closeMicTip;
    public final AppCompatImageView closeRoomImageView;
    public final ConstraintLayout constraintLayout;
    public final ImageView crushGame;
    public final ImageView defaultBackGround;
    public final ImageView diamondGame;
    public final ImageView dominoGame;
    public final ImageView envelopeIcon;
    public final FrameLayout envelopeLayout;
    public final TextView envelopeTime;
    public final FrameLayout frameLayout;
    public final FrameLayout gameChatLayout;
    public final FrameLayout gameLayout;
    public final RecyclerView gameRecycleView;
    public final ImageView gameTypeImage;
    public final LinearLayoutCompat giftNoticesContainer;
    public final GlobalRoomBroadCastLayout globalRoomBroadLayout;
    public final GroupBannerView groupBanner;
    public final ShineTextView groupId;
    public final GroupInputLayoutView groupInput;
    public final FrameLayout groupInputBack;
    public final ImageView groupLock;
    public final NickTextView groupName;
    public final ImageView groupSupportMedal;
    public final ImageView jackaroGame;
    public final TextView joinUnreadMessageView;
    public final QMUIRadiusImageView leftAvatar;
    public final ImageView leftAvatarBg;
    public final LinearLayout llGroupMedal;
    public final LinearLayout llGroupName;
    public final ImageView ludoGame;
    protected View.OnClickListener mClick;
    public final RoundedImageView meetingAvatar;
    public final ImageView meetingPerson;
    public final MeetingRoomOnlineMemberLayout meetingRoomOnlineMember;
    public final ImageView meetingRoomThemBackGroup;
    public final NewMicroView microView;
    public final FrameLayout onLineLayout;
    public final TextView onLineText;
    public final FrameLayout pk1v1;
    public final ImageView pkBg;
    public final ConstraintLayout pkLayout;
    public final PKSearchView pkSearch;
    public final ConstraintLayout playLayout;
    public final LightQueueCombinationPlayer queuePlayer;
    public final TextView redNumber;
    public final QMUIRadiusImageView rightAvatar;
    public final ImageView rightAvatarBg;
    public final RocketSvgaCountdownView rocketSvga;
    public final LinearLayoutCompat roomGameNotice;
    public final ImageView roomImageHead;
    public final RoomRocketEnterView roomRocketEnter;
    public final SVGAImageView roomSvga;
    public final ImageView showChat;
    public final ImageView smallLuckyFruit;
    public final ImageView smallRoulette;
    public final ImageView svipType;
    public final ImageView taskBtn;
    public final ConstraintLayout titleBar;
    public final ImageView unoGame;
    public final LinearLayoutCompat userEnterRoomContent;

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentAudioRoomBinding(Object obj, View view, int i, ImageView imageView, ImageView imageView2, View view2, ImageView imageView3, ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView, FrameLayout frameLayout, ImageView imageView4, AppCompatImageView appCompatImageView2, ConstraintLayout constraintLayout2, ImageView imageView5, ImageView imageView6, ImageView imageView7, ImageView imageView8, ImageView imageView9, FrameLayout frameLayout2, TextView textView, FrameLayout frameLayout3, FrameLayout frameLayout4, FrameLayout frameLayout5, RecyclerView recyclerView, ImageView imageView10, LinearLayoutCompat linearLayoutCompat, GlobalRoomBroadCastLayout globalRoomBroadCastLayout, GroupBannerView groupBannerView, ShineTextView shineTextView, GroupInputLayoutView groupInputLayoutView, FrameLayout frameLayout6, ImageView imageView11, NickTextView nickTextView, ImageView imageView12, ImageView imageView13, TextView textView2, QMUIRadiusImageView qMUIRadiusImageView, ImageView imageView14, LinearLayout linearLayout, LinearLayout linearLayout2, ImageView imageView15, RoundedImageView roundedImageView, ImageView imageView16, MeetingRoomOnlineMemberLayout meetingRoomOnlineMemberLayout, ImageView imageView17, NewMicroView newMicroView, FrameLayout frameLayout7, TextView textView3, FrameLayout frameLayout8, ImageView imageView18, ConstraintLayout constraintLayout3, PKSearchView pKSearchView, ConstraintLayout constraintLayout4, LightQueueCombinationPlayer lightQueueCombinationPlayer, TextView textView4, QMUIRadiusImageView qMUIRadiusImageView2, ImageView imageView19, RocketSvgaCountdownView rocketSvgaCountdownView, LinearLayoutCompat linearLayoutCompat2, ImageView imageView20, RoomRocketEnterView roomRocketEnterView, SVGAImageView sVGAImageView, ImageView imageView21, ImageView imageView22, ImageView imageView23, ImageView imageView24, ImageView imageView25, ConstraintLayout constraintLayout5, ImageView imageView26, LinearLayoutCompat linearLayoutCompat3) {
        super(obj, view, i);
        this.backgammonGame = imageView;
        this.balootGame = imageView2;
        this.bgAllBlack = view2;
        this.carromGame = imageView3;
        this.centerLayout = constraintLayout;
        this.changeGameModel = appCompatImageView;
        this.chatBack = frameLayout;
        this.closeMicTip = imageView4;
        this.closeRoomImageView = appCompatImageView2;
        this.constraintLayout = constraintLayout2;
        this.crushGame = imageView5;
        this.defaultBackGround = imageView6;
        this.diamondGame = imageView7;
        this.dominoGame = imageView8;
        this.envelopeIcon = imageView9;
        this.envelopeLayout = frameLayout2;
        this.envelopeTime = textView;
        this.frameLayout = frameLayout3;
        this.gameChatLayout = frameLayout4;
        this.gameLayout = frameLayout5;
        this.gameRecycleView = recyclerView;
        this.gameTypeImage = imageView10;
        this.giftNoticesContainer = linearLayoutCompat;
        this.globalRoomBroadLayout = globalRoomBroadCastLayout;
        this.groupBanner = groupBannerView;
        this.groupId = shineTextView;
        this.groupInput = groupInputLayoutView;
        this.groupInputBack = frameLayout6;
        this.groupLock = imageView11;
        this.groupName = nickTextView;
        this.groupSupportMedal = imageView12;
        this.jackaroGame = imageView13;
        this.joinUnreadMessageView = textView2;
        this.leftAvatar = qMUIRadiusImageView;
        this.leftAvatarBg = imageView14;
        this.llGroupMedal = linearLayout;
        this.llGroupName = linearLayout2;
        this.ludoGame = imageView15;
        this.meetingAvatar = roundedImageView;
        this.meetingPerson = imageView16;
        this.meetingRoomOnlineMember = meetingRoomOnlineMemberLayout;
        this.meetingRoomThemBackGroup = imageView17;
        this.microView = newMicroView;
        this.onLineLayout = frameLayout7;
        this.onLineText = textView3;
        this.pk1v1 = frameLayout8;
        this.pkBg = imageView18;
        this.pkLayout = constraintLayout3;
        this.pkSearch = pKSearchView;
        this.playLayout = constraintLayout4;
        this.queuePlayer = lightQueueCombinationPlayer;
        this.redNumber = textView4;
        this.rightAvatar = qMUIRadiusImageView2;
        this.rightAvatarBg = imageView19;
        this.rocketSvga = rocketSvgaCountdownView;
        this.roomGameNotice = linearLayoutCompat2;
        this.roomImageHead = imageView20;
        this.roomRocketEnter = roomRocketEnterView;
        this.roomSvga = sVGAImageView;
        this.showChat = imageView21;
        this.smallLuckyFruit = imageView22;
        this.smallRoulette = imageView23;
        this.svipType = imageView24;
        this.taskBtn = imageView25;
        this.titleBar = constraintLayout5;
        this.unoGame = imageView26;
        this.userEnterRoomContent = linearLayoutCompat3;
    }

    public static FragmentAudioRoomBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static FragmentAudioRoomBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public abstract void setClick(View.OnClickListener onClickListener);

    @Deprecated
    public static FragmentAudioRoomBinding bind(View view, Object obj) {
        return (FragmentAudioRoomBinding) ViewDataBinding.bind(obj, view, R.layout.fragment_audio_room);
    }

    @Deprecated
    public static FragmentAudioRoomBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentAudioRoomBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_audio_room, viewGroup, z, obj);
    }

    public static FragmentAudioRoomBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static FragmentAudioRoomBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentAudioRoomBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_audio_room, (ViewGroup) null, false, obj);
    }
}
