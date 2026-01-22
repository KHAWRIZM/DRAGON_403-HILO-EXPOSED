package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
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
public class FragmentAudioRoomBindingImpl extends FragmentAudioRoomBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.frameLayout, 23);
        sparseIntArray.put(R.id.constraintLayout, 24);
        sparseIntArray.put(R.id.defaultBackGround, 25);
        sparseIntArray.put(R.id.meetingRoomThemBackGroup, 26);
        sparseIntArray.put(2131365197, 27);
        sparseIntArray.put(R.id.roomSvga, 28);
        sparseIntArray.put(R.id.roomImageHead, 29);
        sparseIntArray.put(R.id.close_mic_tip, 30);
        sparseIntArray.put(R.id.ll_group_name, 31);
        sparseIntArray.put(R.id.group_lock, 32);
        sparseIntArray.put(R.id.svipType, 33);
        sparseIntArray.put(R.id.group_support_medal, 34);
        sparseIntArray.put(R.id.ll_group_medal, 35);
        sparseIntArray.put(R.id.centerLayout, 36);
        sparseIntArray.put(R.id.meeting_room_online_member, 37);
        sparseIntArray.put(R.id.pk1v1, 38);
        sparseIntArray.put(R.id.micro_view, 39);
        sparseIntArray.put(R.id.gameRecycleView, 40);
        sparseIntArray.put(R.id.onLineLayout, 41);
        sparseIntArray.put(R.id.onLineText, 42);
        sparseIntArray.put(R.id.gameLayout, 43);
        sparseIntArray.put(R.id.chat_back, 44);
        sparseIntArray.put(R.id.gameChatLayout, 45);
        sparseIntArray.put(R.id.playLayout, 46);
        sparseIntArray.put(R.id.group_banner, 47);
        sparseIntArray.put(R.id.envelopeIcon, 48);
        sparseIntArray.put(R.id.envelopeTime, 49);
        sparseIntArray.put(R.id.pkBg, 50);
        sparseIntArray.put(R.id.gameTypeImage, 51);
        sparseIntArray.put(R.id.leftAvatarBg, 52);
        sparseIntArray.put(R.id.leftAvatar, 53);
        sparseIntArray.put(R.id.rightAvatarBg, 54);
        sparseIntArray.put(R.id.rightAvatar, 55);
        sparseIntArray.put(R.id.pkSearch, 56);
        sparseIntArray.put(R.id.redNumber, 57);
        sparseIntArray.put(R.id.join_unread_message_view, 58);
        sparseIntArray.put(R.id.gift_notices_container, 59);
        sparseIntArray.put(R.id.roomGameNotice, 60);
        sparseIntArray.put(R.id.user_enter_room_content, 61);
        sparseIntArray.put(R.id.global_room_broad_layout, 62);
        sparseIntArray.put(R.id.queuePlayer, 63);
        sparseIntArray.put(R.id.bg_all_black, 64);
        sparseIntArray.put(R.id.rocket_svga, 65);
        sparseIntArray.put(R.id.group_input_back, 66);
        sparseIntArray.put(R.id.group_input, 67);
    }

    public FragmentAudioRoomBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 68, sIncludes, sViewsWithIds));
    }

    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        View.OnClickListener onClickListener = this.mClick;
        if ((j & 3) != 0) {
            this.backgammonGame.setOnClickListener(onClickListener);
            this.balootGame.setOnClickListener(onClickListener);
            this.carromGame.setOnClickListener(onClickListener);
            this.changeGameModel.setOnClickListener(onClickListener);
            this.closeRoomImageView.setOnClickListener(onClickListener);
            this.crushGame.setOnClickListener(onClickListener);
            this.diamondGame.setOnClickListener(onClickListener);
            this.dominoGame.setOnClickListener(onClickListener);
            this.envelopeLayout.setOnClickListener(onClickListener);
            this.groupId.setOnClickListener(onClickListener);
            this.groupName.setOnClickListener(onClickListener);
            this.jackaroGame.setOnClickListener(onClickListener);
            this.ludoGame.setOnClickListener(onClickListener);
            this.meetingAvatar.setOnClickListener(onClickListener);
            this.meetingPerson.setOnClickListener(onClickListener);
            this.pkLayout.setOnClickListener(onClickListener);
            this.roomRocketEnter.setOnClickListener(onClickListener);
            this.showChat.setOnClickListener(onClickListener);
            this.smallLuckyFruit.setOnClickListener(onClickListener);
            this.smallRoulette.setOnClickListener(onClickListener);
            this.taskBtn.setOnClickListener(onClickListener);
            this.unoGame.setOnClickListener(onClickListener);
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
            this.mDirtyFlags = 2L;
        }
        requestRebind();
    }

    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // com.qiahao.nextvideo.databinding.FragmentAudioRoomBinding
    public void setClick(View.OnClickListener onClickListener) {
        this.mClick = onClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    public boolean setVariable(int i, Object obj) {
        if (2 == i) {
            setClick((View.OnClickListener) obj);
            return true;
        }
        return false;
    }

    private FragmentAudioRoomBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (ImageView) objArr[15], (ImageView) objArr[12], (View) objArr[64], (ImageView) objArr[13], (ConstraintLayout) objArr[36], (AppCompatImageView) objArr[2], (FrameLayout) objArr[44], (ImageView) objArr[30], (AppCompatImageView) objArr[1], (ConstraintLayout) objArr[24], (ImageView) objArr[11], (ImageView) objArr[25], (ImageView) objArr[18], (ImageView) objArr[10], (ImageView) objArr[48], (FrameLayout) objArr[16], (TextView) objArr[49], (FrameLayout) objArr[23], (FrameLayout) objArr[45], (FrameLayout) objArr[43], (RecyclerView) objArr[40], (ImageView) objArr[51], (LinearLayoutCompat) objArr[59], (GlobalRoomBroadCastLayout) objArr[62], (GroupBannerView) objArr[47], (ShineTextView) objArr[5], (GroupInputLayoutView) objArr[67], (FrameLayout) objArr[66], (ImageView) objArr[32], (NickTextView) objArr[4], (ImageView) objArr[34], (ImageView) objArr[14], (TextView) objArr[58], (QMUIRadiusImageView) objArr[53], (ImageView) objArr[52], (LinearLayout) objArr[35], (LinearLayout) objArr[31], (ImageView) objArr[8], (RoundedImageView) objArr[3], (ImageView) objArr[6], (MeetingRoomOnlineMemberLayout) objArr[37], (ImageView) objArr[26], (NewMicroView) objArr[39], (FrameLayout) objArr[41], (TextView) objArr[42], (FrameLayout) objArr[38], (ImageView) objArr[50], (ConstraintLayout) objArr[19], (PKSearchView) objArr[56], (ConstraintLayout) objArr[46], (LightQueueCombinationPlayer) objArr[63], (TextView) objArr[57], (QMUIRadiusImageView) objArr[55], (ImageView) objArr[54], (RocketSvgaCountdownView) objArr[65], (LinearLayoutCompat) objArr[60], (ImageView) objArr[29], (RoomRocketEnterView) objArr[20], (SVGAImageView) objArr[28], (ImageView) objArr[22], (ImageView) objArr[17], (ImageView) objArr[7], (ImageView) objArr[33], (ImageView) objArr[21], (ConstraintLayout) objArr[27], (ImageView) objArr[9], (LinearLayoutCompat) objArr[61]);
        this.mDirtyFlags = -1L;
        this.backgammonGame.setTag(null);
        this.balootGame.setTag(null);
        this.carromGame.setTag(null);
        this.changeGameModel.setTag(null);
        this.closeRoomImageView.setTag(null);
        this.crushGame.setTag(null);
        this.diamondGame.setTag(null);
        this.dominoGame.setTag(null);
        this.envelopeLayout.setTag(null);
        this.groupId.setTag(null);
        this.groupName.setTag(null);
        this.jackaroGame.setTag(null);
        this.ludoGame.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.meetingAvatar.setTag(null);
        this.meetingPerson.setTag(null);
        this.pkLayout.setTag(null);
        this.roomRocketEnter.setTag(null);
        this.showChat.setTag(null);
        this.smallLuckyFruit.setTag(null);
        this.smallRoulette.setTag(null);
        this.taskBtn.setTag(null);
        this.unoGame.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
