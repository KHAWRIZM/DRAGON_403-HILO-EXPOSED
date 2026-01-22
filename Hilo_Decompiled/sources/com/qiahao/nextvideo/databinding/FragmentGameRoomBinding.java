package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.base_common.player.combination.queue.LightQueueCombinationPlayer;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.room.view.GroupInputLayoutView;
import com.qiahao.nextvideo.room.view.micro.GameMicroView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class FragmentGameRoomBinding extends ViewDataBinding {
    public final View bgAllBlack;
    public final FrameLayout chatBack;
    public final ConstraintLayout constraintLayout;
    public final ImageView defaultBackGround;
    public final ImageView exit;
    public final FrameLayout frameLayout;
    public final FrameLayout gameChatLayout;
    public final ImageView gameIcon;
    public final ViewRoomGameBinding gameLayout;
    public final GameMicroView gameMic;
    public final LinearLayoutCompat giftNoticesContainer;
    public final GroupInputLayoutView groupInput;
    public final FrameLayout groupInputBack;
    protected View.OnClickListener mClick;
    public final ImageView meetingRoomThemBackGroup;
    public final LightQueueCombinationPlayer queuePlayer;
    public final LinearLayoutCompat roomGameNotice;
    public final ImageView showChat;
    public final ConstraintLayout topLayout;
    public final LinearLayoutCompat userEnterRoomContent;

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentGameRoomBinding(Object obj, View view, int i, View view2, FrameLayout frameLayout, ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, FrameLayout frameLayout2, FrameLayout frameLayout3, ImageView imageView3, ViewRoomGameBinding viewRoomGameBinding, GameMicroView gameMicroView, LinearLayoutCompat linearLayoutCompat, GroupInputLayoutView groupInputLayoutView, FrameLayout frameLayout4, ImageView imageView4, LightQueueCombinationPlayer lightQueueCombinationPlayer, LinearLayoutCompat linearLayoutCompat2, ImageView imageView5, ConstraintLayout constraintLayout2, LinearLayoutCompat linearLayoutCompat3) {
        super(obj, view, i);
        this.bgAllBlack = view2;
        this.chatBack = frameLayout;
        this.constraintLayout = constraintLayout;
        this.defaultBackGround = imageView;
        this.exit = imageView2;
        this.frameLayout = frameLayout2;
        this.gameChatLayout = frameLayout3;
        this.gameIcon = imageView3;
        this.gameLayout = viewRoomGameBinding;
        this.gameMic = gameMicroView;
        this.giftNoticesContainer = linearLayoutCompat;
        this.groupInput = groupInputLayoutView;
        this.groupInputBack = frameLayout4;
        this.meetingRoomThemBackGroup = imageView4;
        this.queuePlayer = lightQueueCombinationPlayer;
        this.roomGameNotice = linearLayoutCompat2;
        this.showChat = imageView5;
        this.topLayout = constraintLayout2;
        this.userEnterRoomContent = linearLayoutCompat3;
    }

    public static FragmentGameRoomBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static FragmentGameRoomBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public abstract void setClick(View.OnClickListener onClickListener);

    @Deprecated
    public static FragmentGameRoomBinding bind(View view, Object obj) {
        return (FragmentGameRoomBinding) ViewDataBinding.bind(obj, view, R.layout.fragment_game_room);
    }

    @Deprecated
    public static FragmentGameRoomBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentGameRoomBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_game_room, viewGroup, z, obj);
    }

    public static FragmentGameRoomBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static FragmentGameRoomBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentGameRoomBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_game_room, (ViewGroup) null, false, obj);
    }
}
