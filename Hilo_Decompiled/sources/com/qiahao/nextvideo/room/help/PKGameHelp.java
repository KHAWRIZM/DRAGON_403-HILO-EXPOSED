package com.qiahao.nextvideo.room.help;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Checkable;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.UiKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.interfaceing.OnCommonDialogListener;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.model.GroupDetailBean;
import com.qiahao.nextvideo.data.room.RoomPK;
import com.qiahao.nextvideo.data.room.RoomPKScore;
import com.qiahao.nextvideo.data.room.RoomPKScoreRes;
import com.qiahao.nextvideo.databinding.FragmentAudioRoomBinding;
import com.qiahao.nextvideo.databinding.IncludePkGoBinding;
import com.qiahao.nextvideo.databinding.RoomButtonPkBinding;
import com.qiahao.nextvideo.databinding.ViewGamePkBinding;
import com.qiahao.nextvideo.room.StartRoomUtils;
import com.qiahao.nextvideo.room.dialog.RoomTipDialog;
import com.qiahao.nextvideo.room.fragment.AudioRoomFragment;
import com.qiahao.nextvideo.room.manager.MeetingRoomManager;
import com.qiahao.nextvideo.room.view.micro.NewMicroView;
import com.qiahao.nextvideo.room.view.micro.OnMeetingRoomMicroItemClickListener;
import com.qiahao.nextvideo.room.view.micro.PKMicroView;
import com.qiahao.nextvideo.room.viewmodel.RoomViewModel;
import com.qiahao.nextvideo.ui.videocall.matchinguser.BalloonViewUtil;
import com.qiahao.nextvideo.view.PKButtonView;
import com.qiahao.nextvideo.view.PKLevelView;
import com.skydoves.balloon.Balloon;
import com.tencent.imsdk.v2.V2TIMManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010-\u001a\u0004\u0018\u00010.J\b\u0010/\u001a\u000200H\u0002J\b\u00101\u001a\u000200H\u0002J\b\u00102\u001a\u000200H\u0002J\u0017\u00103\u001a\u0002002\n\b\u0002\u00104\u001a\u0004\u0018\u000105¢\u0006\u0002\u00106J\u0006\u00107\u001a\u000200J\u001e\u00108\u001a\u0002002\f\u00109\u001a\b\u0012\u0004\u0012\u00020!0:2\b\b\u0002\u0010;\u001a\u000205J\u0016\u0010<\u001a\u0002002\u0006\u0010=\u001a\u00020!2\u0006\u0010>\u001a\u00020?J\u000e\u0010@\u001a\u0002002\u0006\u0010=\u001a\u00020!J\u000e\u0010A\u001a\u0002002\u0006\u0010B\u001a\u00020!J\u0006\u0010C\u001a\u000200J\b\u0010D\u001a\u000200H\u0002J\u0006\u0010E\u001a\u000200J\u0006\u0010F\u001a\u000200J\u0006\u0010G\u001a\u000200R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010#\"\u0004\b(\u0010%R\u0011\u0010)\u001a\u00020*¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,¨\u0006H"}, d2 = {"Lcom/qiahao/nextvideo/room/help/PKGameHelp;", "", "fragment", "Lcom/qiahao/nextvideo/room/fragment/AudioRoomFragment;", "<init>", "(Lcom/qiahao/nextvideo/room/fragment/AudioRoomFragment;)V", "getFragment", "()Lcom/qiahao/nextvideo/room/fragment/AudioRoomFragment;", "binding", "Lcom/qiahao/nextvideo/databinding/ViewGamePkBinding;", "getBinding", "()Lcom/qiahao/nextvideo/databinding/ViewGamePkBinding;", "setBinding", "(Lcom/qiahao/nextvideo/databinding/ViewGamePkBinding;)V", "timerTask", "Landroid/os/CountDownTimer;", "getTimerTask", "()Landroid/os/CountDownTimer;", "setTimerTask", "(Landroid/os/CountDownTimer;)V", "balloon", "Lcom/skydoves/balloon/Balloon;", "getBalloon", "()Lcom/skydoves/balloon/Balloon;", "setBalloon", "(Lcom/skydoves/balloon/Balloon;)V", "mLevelView", "Lcom/qiahao/nextvideo/view/PKLevelView;", "getMLevelView", "()Lcom/qiahao/nextvideo/view/PKLevelView;", "setMLevelView", "(Lcom/qiahao/nextvideo/view/PKLevelView;)V", "mDefaultViewHeight", "", "getMDefaultViewHeight", "()I", "setMDefaultViewHeight", "(I)V", "mViewChangeHeight", "getMViewChangeHeight", "setMViewChangeHeight", "mListener", "Lcom/qiahao/nextvideo/room/view/micro/OnMeetingRoomMicroItemClickListener;", "getMListener", "()Lcom/qiahao/nextvideo/room/view/micro/OnMeetingRoomMicroItemClickListener;", "addPKGameView", "Landroid/view/View;", "toRoomTip", "", "toOtherRoom", "clickRoomMute", "pkCountDown", "isEnd", "", "(Ljava/lang/Boolean;)V", "notificationMicChange", "showMicSpeakWaveAnim", "list", "", "isOther", "showFace", "position", "url", "", "refreshMicByPosition", "refreshSVIP", "level", "refreshPro", "refreshRoomMic", "pkEnd", "removePKView", "release", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nPKGameHelp.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PKGameHelp.kt\ncom/qiahao/nextvideo/room/help/PKGameHelp\n+ 2 ViewGroup.kt\nandroidx/core/view/ViewGroupKt\n+ 3 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,433:1\n51#2:434\n48#2:435\n61#3,9:436\n61#3,9:445\n61#3,9:454\n61#3,9:463\n61#3,9:472\n1869#4,2:481\n1869#4,2:483\n*S KotlinDebug\n*F\n+ 1 PKGameHelp.kt\ncom/qiahao/nextvideo/room/help/PKGameHelp\n*L\n112#1:434\n118#1:435\n132#1:436,9\n136#1:445,9\n142#1:454,9\n145#1:463,9\n148#1:472,9\n372#1:481,2\n385#1:483,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class PKGameHelp {

    @Nullable
    private Balloon balloon;

    @Nullable
    private ViewGamePkBinding binding;

    @NotNull
    private final AudioRoomFragment fragment;
    private int mDefaultViewHeight;

    @Nullable
    private PKLevelView mLevelView;

    @NotNull
    private final OnMeetingRoomMicroItemClickListener mListener;
    private int mViewChangeHeight;

    @Nullable
    private CountDownTimer timerTask;

    public PKGameHelp(@NotNull AudioRoomFragment audioRoomFragment) {
        Intrinsics.checkNotNullParameter(audioRoomFragment, "fragment");
        this.fragment = audioRoomFragment;
        this.mListener = new PKGameHelp$mListener$1(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void clickRoomMute() {
        int i;
        int i2;
        Integer role;
        Context context = this.fragment.getContext();
        if (context != null) {
            MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
            GroupDetailBean mGroupDetailBean = meetingRoomManager.getMGroupDetailBean();
            if (mGroupDetailBean != null && (role = mGroupDetailBean.getRole()) != null) {
                i = role.intValue();
            } else {
                i = 0;
            }
            if (i <= 1) {
                new RoomTipDialog(context).setTipContent(ResourcesKtxKt.getStringById(this, 2131953965)).show();
                return;
            }
            RoomTipDialog roomTipDialog = new RoomTipDialog(context);
            if (meetingRoomManager.getMRoomMute()) {
                i2 = 2131953963;
            } else {
                i2 = 2131953962;
            }
            roomTipDialog.setTipContent(ResourcesKtxKt.getStringById(this, i2)).setDialogListener(new OnCommonDialogListener() { // from class: com.qiahao.nextvideo.room.help.PKGameHelp$clickRoomMute$1$1
                public void cancel() {
                    OnCommonDialogListener.DefaultImpls.cancel(this);
                }

                public void confirm() {
                    PKGameHelp.this.getFragment().getMViewModel().changeOtherRoomMic(!MeetingRoomManager.INSTANCE.getMRoomMute() ? 1 : 0);
                }
            }).show();
        }
    }

    public static /* synthetic */ void pkCountDown$default(PKGameHelp pKGameHelp, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = Boolean.FALSE;
        }
        pKGameHelp.pkCountDown(bool);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit pkEnd$lambda$13(PKGameHelp pKGameHelp) {
        AudioRoomFragmentHelp mAudioHelp = pKGameHelp.fragment.getMAudioHelp();
        if (mAudioHelp != null) {
            mAudioHelp.checkPK();
        }
        MeetingRoomManager.INSTANCE.setMicMemberAllRemoteMute(false);
        return Unit.INSTANCE;
    }

    private final void refreshRoomMic() {
        RoomPKScoreRes roomPKPro;
        ArrayList<RoomPKScore> scoreInfo;
        ViewGamePkBinding viewGamePkBinding;
        ImageView imageView;
        Drawable drawable;
        int i;
        ImageView imageView2;
        ImageView imageView3;
        RoomPKScoreRes roomPKPro2;
        ArrayList<RoomPKScore> scoreInfo2;
        ViewGamePkBinding viewGamePkBinding2;
        ImageView imageView4;
        Drawable drawable2;
        int i2;
        ImageView imageView5;
        ImageView imageView6;
        MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
        RoomPK mpk = meetingRoomManager.getMPK();
        if (mpk != null && mpk.checkIsInvite()) {
            ViewGamePkBinding viewGamePkBinding3 = this.binding;
            if (viewGamePkBinding3 != null && (imageView6 = viewGamePkBinding3.redMic) != null) {
                imageView6.setVisibility(8);
            }
            ViewGamePkBinding viewGamePkBinding4 = this.binding;
            if (viewGamePkBinding4 != null && (imageView5 = viewGamePkBinding4.blueMic) != null) {
                imageView5.setVisibility(0);
            }
            RoomPK mpk2 = meetingRoomManager.getMPK();
            if (mpk2 != null && (roomPKPro2 = mpk2.getRoomPKPro()) != null && (scoreInfo2 = roomPKPro2.getScoreInfo()) != null) {
                for (RoomPKScore roomPKScore : scoreInfo2) {
                    if (!roomPKScore.checkIsInvite() && (viewGamePkBinding2 = this.binding) != null && (imageView4 = viewGamePkBinding2.blueMic) != null) {
                        Context context = this.fragment.getContext();
                        if (context != null) {
                            if (Intrinsics.areEqual(roomPKScore.isMute(), Boolean.TRUE)) {
                                i2 = R.drawable.pk_mic_blue_off;
                            } else {
                                i2 = R.drawable.pk_mic_blue_on;
                            }
                            drawable2 = androidx.core.content.a.getDrawable(context, i2);
                        } else {
                            drawable2 = null;
                        }
                        imageView4.setImageDrawable(drawable2);
                    }
                }
                return;
            }
            return;
        }
        ViewGamePkBinding viewGamePkBinding5 = this.binding;
        if (viewGamePkBinding5 != null && (imageView3 = viewGamePkBinding5.redMic) != null) {
            imageView3.setVisibility(0);
        }
        ViewGamePkBinding viewGamePkBinding6 = this.binding;
        if (viewGamePkBinding6 != null && (imageView2 = viewGamePkBinding6.blueMic) != null) {
            imageView2.setVisibility(8);
        }
        RoomPK mpk3 = meetingRoomManager.getMPK();
        if (mpk3 != null && (roomPKPro = mpk3.getRoomPKPro()) != null && (scoreInfo = roomPKPro.getScoreInfo()) != null) {
            for (RoomPKScore roomPKScore2 : scoreInfo) {
                if (roomPKScore2.checkIsInvite() && (viewGamePkBinding = this.binding) != null && (imageView = viewGamePkBinding.redMic) != null) {
                    Context context2 = this.fragment.getContext();
                    if (context2 != null) {
                        if (Intrinsics.areEqual(roomPKScore2.isMute(), Boolean.TRUE)) {
                            i = R.drawable.pk_mic_red_off;
                        } else {
                            i = R.drawable.pk_mic_red_on;
                        }
                        drawable = androidx.core.content.a.getDrawable(context2, i);
                    } else {
                        drawable = null;
                    }
                    imageView.setImageDrawable(drawable);
                }
            }
        }
    }

    public static /* synthetic */ void showMicSpeakWaveAnim$default(PKGameHelp pKGameHelp, List list, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        pKGameHelp.showMicSpeakWaveAnim(list, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void toOtherRoom() {
        RoomPK mpk;
        GroupDetailBean inviteGroup;
        String groupId;
        String str;
        RoomPK mpk2;
        GroupDetailBean receiveGroup;
        MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
        RoomPK mpk3 = meetingRoomManager.getMPK();
        if (mpk3 == null || !mpk3.checkIsInvite() ? (mpk = meetingRoomManager.getMPK()) == null || (inviteGroup = mpk.getInviteGroup()) == null || (groupId = inviteGroup.getGroupId()) == null : (mpk2 = meetingRoomManager.getMPK()) == null || (receiveGroup = mpk2.getReceiveGroup()) == null || (groupId = receiveGroup.getGroupId()) == null) {
            str = "";
        } else {
            str = groupId;
        }
        meetingRoomManager.emptyMicInit(10);
        StartRoomUtils.startRoom$default(StartRoomUtils.INSTANCE, str, null, null, null, null, null, null, null, 0, 0, null, 0, false, 8190, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void toRoomTip() {
        RoomPK mpk;
        GroupDetailBean inviteGroup;
        RoomPK mpk2;
        Context context = this.fragment.getContext();
        if (context != null) {
            RoomTipDialog roomTipDialog = new RoomTipDialog(context);
            String stringById = ResourcesKtxKt.getStringById(this, 2131952912);
            MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
            RoomPK mpk3 = meetingRoomManager.getMPK();
            String str = null;
            if (mpk3 == null || !mpk3.checkIsInvite() ? !((mpk = meetingRoomManager.getMPK()) == null || (inviteGroup = mpk.getInviteGroup()) == null) : !((mpk2 = meetingRoomManager.getMPK()) == null || (inviteGroup = mpk2.getReceiveGroup()) == null)) {
                str = inviteGroup.getCode();
            }
            String format = String.format(stringById, Arrays.copyOf(new Object[]{str}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            roomTipDialog.setTipContent(format).setConfirmContent(ResourcesKtxKt.getStringById(this, 2131952915)).setDialogListener(new OnCommonDialogListener() { // from class: com.qiahao.nextvideo.room.help.PKGameHelp$toRoomTip$1$1
                public void cancel() {
                    OnCommonDialogListener.DefaultImpls.cancel(this);
                }

                public void confirm() {
                    PKGameHelp.this.toOtherRoom();
                }
            }).show();
        }
    }

    @Nullable
    public final View addPKGameView() {
        PKButtonView pKButtonView;
        RoomButtonPkBinding rootBinding;
        final ImageView imageView;
        final ImageView imageView2;
        final ImageView imageView3;
        PKMicroView pKMicroView;
        PKMicroView pKMicroView2;
        IncludePkGoBinding includePkGoBinding;
        final View root;
        IncludePkGoBinding includePkGoBinding2;
        final View root2;
        IncludePkGoBinding includePkGoBinding3;
        View root3;
        IncludePkGoBinding includePkGoBinding4;
        View root4;
        FrameLayout frameLayout;
        Context context;
        FrameLayout frameLayout2;
        FrameLayout frameLayout3;
        FrameLayout frameLayout4;
        View view;
        View view2;
        FragmentAudioRoomBinding binding;
        FrameLayout frameLayout5;
        FrameLayout frameLayout6;
        FragmentAudioRoomBinding binding2 = this.fragment.getBinding();
        if (binding2 != null && (frameLayout4 = binding2.gameLayout) != null && frameLayout4.getChildCount() != 0) {
            FragmentAudioRoomBinding binding3 = this.fragment.getBinding();
            if (binding3 != null && (frameLayout6 = binding3.gameLayout) != null) {
                view = frameLayout6.getChildAt(0);
            } else {
                view = null;
            }
            ViewGamePkBinding viewGamePkBinding = this.binding;
            if (viewGamePkBinding != null) {
                view2 = viewGamePkBinding.getRoot();
            } else {
                view2 = null;
            }
            if (!Intrinsics.areEqual(view, view2) && (binding = this.fragment.getBinding()) != null && (frameLayout5 = binding.gameLayout) != null) {
                frameLayout5.removeAllViews();
            }
        }
        FragmentAudioRoomBinding binding4 = this.fragment.getBinding();
        if (binding4 != null && (frameLayout = binding4.gameLayout) != null && frameLayout.getChildCount() == 0 && this.binding == null && (context = this.fragment.getContext()) != null) {
            FragmentAudioRoomBinding binding5 = this.fragment.getBinding();
            if (binding5 != null && (frameLayout3 = binding5.gameLayout) != null) {
                frameLayout3.removeAllViews();
            }
            LayoutInflater from = LayoutInflater.from(context);
            FragmentAudioRoomBinding binding6 = this.fragment.getBinding();
            if (binding6 != null) {
                frameLayout2 = binding6.gameLayout;
            } else {
                frameLayout2 = null;
            }
            this.binding = (ViewGamePkBinding) androidx.databinding.g.h(from, R.layout.view_game_pk, frameLayout2, true);
        }
        ViewGamePkBinding viewGamePkBinding2 = this.binding;
        if (viewGamePkBinding2 != null && (includePkGoBinding4 = viewGamePkBinding2.redGo) != null && (root4 = includePkGoBinding4.getRoot()) != null) {
            ImageKtxKt.toHorizontalMirror(root4, R.drawable.pk_go_bg_left);
        }
        ViewGamePkBinding viewGamePkBinding3 = this.binding;
        if (viewGamePkBinding3 != null && (includePkGoBinding3 = viewGamePkBinding3.blueGo) != null && (root3 = includePkGoBinding3.getRoot()) != null) {
            ImageKtxKt.toHorizontalMirror(root3, R.drawable.pk_go_bg_right);
        }
        ViewGamePkBinding viewGamePkBinding4 = this.binding;
        final long j = 800;
        if (viewGamePkBinding4 != null && (includePkGoBinding2 = viewGamePkBinding4.redGo) != null && (root2 = includePkGoBinding2.getRoot()) != null) {
            root2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.help.PKGameHelp$addPKGameView$$inlined$singleClick$default$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(root2) > j || (root2 instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(root2, currentTimeMillis);
                        RoomPK mpk = MeetingRoomManager.INSTANCE.getMPK();
                        if (mpk == null || !mpk.checkIsInvite()) {
                            this.toOtherRoom();
                        }
                    }
                }
            });
        }
        ViewGamePkBinding viewGamePkBinding5 = this.binding;
        if (viewGamePkBinding5 != null && (includePkGoBinding = viewGamePkBinding5.blueGo) != null && (root = includePkGoBinding.getRoot()) != null) {
            root.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.help.PKGameHelp$addPKGameView$$inlined$singleClick$default$2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(root) > j || (root instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(root, currentTimeMillis);
                        RoomPK mpk = MeetingRoomManager.INSTANCE.getMPK();
                        if (mpk == null || mpk.checkIsInvite()) {
                            this.toOtherRoom();
                        }
                    }
                }
            });
        }
        ViewGamePkBinding viewGamePkBinding6 = this.binding;
        if (viewGamePkBinding6 != null && (pKMicroView2 = viewGamePkBinding6.leftMic) != null) {
            pKMicroView2.setOnMeetingRoomMicroItemClickListener(this.mListener);
        }
        ViewGamePkBinding viewGamePkBinding7 = this.binding;
        if (viewGamePkBinding7 != null && (pKMicroView = viewGamePkBinding7.rightMic) != null) {
            pKMicroView.setOnMeetingRoomMicroItemClickListener(this.mListener);
        }
        ViewGamePkBinding viewGamePkBinding8 = this.binding;
        if (viewGamePkBinding8 != null && (imageView3 = viewGamePkBinding8.redMic) != null) {
            imageView3.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.help.PKGameHelp$addPKGameView$$inlined$singleClick$default$3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(imageView3) > j || (imageView3 instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(imageView3, currentTimeMillis);
                        this.clickRoomMute();
                    }
                }
            });
        }
        ViewGamePkBinding viewGamePkBinding9 = this.binding;
        if (viewGamePkBinding9 != null && (imageView2 = viewGamePkBinding9.blueMic) != null) {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.help.PKGameHelp$addPKGameView$$inlined$singleClick$default$4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(imageView2) > j || (imageView2 instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(imageView2, currentTimeMillis);
                        this.clickRoomMute();
                    }
                }
            });
        }
        ViewGamePkBinding viewGamePkBinding10 = this.binding;
        if (viewGamePkBinding10 != null && (pKButtonView = viewGamePkBinding10.button) != null && (rootBinding = pKButtonView.getRootBinding()) != null && (imageView = rootBinding.chestSVGA) != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.help.PKGameHelp$addPKGameView$$inlined$singleClick$default$5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    View root5;
                    Context context2;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(imageView) > j || (imageView instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(imageView, currentTimeMillis);
                        ImageView imageView4 = (ImageView) imageView;
                        FragmentAudioRoomBinding binding7 = this.getFragment().getBinding();
                        if (binding7 != null && (root5 = binding7.getRoot()) != null && (context2 = root5.getContext()) != null) {
                            this.setMLevelView(new PKLevelView(context2));
                            PKGameHelp pKGameHelp = this;
                            BalloonViewUtil balloonViewUtil = BalloonViewUtil.INSTANCE;
                            PKLevelView mLevelView = pKGameHelp.getMLevelView();
                            Intrinsics.checkNotNull(mLevelView);
                            pKGameHelp.setBalloon(balloonViewUtil.createView(context2, mLevelView, UiKtxKt.toPX(10)));
                        }
                        Balloon balloon = this.getBalloon();
                        if (balloon != null) {
                            final PKGameHelp pKGameHelp2 = this;
                            balloon.setOnBalloonDismissListener(new Function0<Unit>() { // from class: com.qiahao.nextvideo.room.help.PKGameHelp$addPKGameView$6$2
                                public /* bridge */ /* synthetic */ Object invoke() {
                                    m٦١invoke();
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: collision with other method in class */
                                public final void m٦١invoke() {
                                    PKGameHelp.this.setMLevelView(null);
                                }
                            });
                        }
                        Balloon balloon2 = this.getBalloon();
                        if (balloon2 != null) {
                            balloon2.show(imageView4);
                        }
                    }
                }
            });
        }
        this.fragment.getMViewModel().requestBoxList();
        refreshRoomMic();
        ViewGamePkBinding viewGamePkBinding11 = this.binding;
        if (viewGamePkBinding11 == null) {
            return null;
        }
        return viewGamePkBinding11.getRoot();
    }

    @Nullable
    public final Balloon getBalloon() {
        return this.balloon;
    }

    @Nullable
    public final ViewGamePkBinding getBinding() {
        return this.binding;
    }

    @NotNull
    public final AudioRoomFragment getFragment() {
        return this.fragment;
    }

    public final int getMDefaultViewHeight() {
        return this.mDefaultViewHeight;
    }

    @Nullable
    public final PKLevelView getMLevelView() {
        return this.mLevelView;
    }

    @NotNull
    public final OnMeetingRoomMicroItemClickListener getMListener() {
        return this.mListener;
    }

    public final int getMViewChangeHeight() {
        return this.mViewChangeHeight;
    }

    @Nullable
    public final CountDownTimer getTimerTask() {
        return this.timerTask;
    }

    public final void notificationMicChange() {
        PKMicroView pKMicroView;
        PKMicroView pKMicroView2;
        ViewGamePkBinding viewGamePkBinding = this.binding;
        if (viewGamePkBinding != null && (pKMicroView2 = viewGamePkBinding.leftMic) != null) {
            pKMicroView2.refreshMic();
        }
        ViewGamePkBinding viewGamePkBinding2 = this.binding;
        if (viewGamePkBinding2 != null && (pKMicroView = viewGamePkBinding2.rightMic) != null) {
            pKMicroView.refreshMic();
        }
    }

    public final void pkCountDown(@Nullable Boolean isEnd) {
        long serverTime;
        Long endTimeUnix;
        Long punishEndTimeUnix;
        CountDownTimer countDownTimer = this.timerTask;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        long j = 0;
        if (Intrinsics.areEqual(isEnd, Boolean.TRUE)) {
            RoomPK mpk = MeetingRoomManager.INSTANCE.getMPK();
            if (mpk != null && (punishEndTimeUnix = mpk.getPunishEndTimeUnix()) != null) {
                j = punishEndTimeUnix.longValue();
            }
            serverTime = V2TIMManager.getInstance().getServerTime();
        } else {
            RoomPK mpk2 = MeetingRoomManager.INSTANCE.getMPK();
            if (mpk2 != null && (endTimeUnix = mpk2.getEndTimeUnix()) != null) {
                j = endTimeUnix.longValue();
            }
            serverTime = V2TIMManager.getInstance().getServerTime();
        }
        PKGameHelp$pkCountDown$1 pKGameHelp$pkCountDown$1 = new PKGameHelp$pkCountDown$1(isEnd, this, (j - serverTime) * 1000);
        this.timerTask = pKGameHelp$pkCountDown$1;
        pKGameHelp$pkCountDown$1.start();
    }

    public final void pkEnd() {
        NewMicroView newMicroView;
        MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
        if (meetingRoomManager.getMPK() == null) {
            return;
        }
        meetingRoomManager.setMPK(null);
        meetingRoomManager.setMRoomMute(false);
        CountDownTimer countDownTimer = this.timerTask;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.timerTask = null;
        Balloon balloon = this.balloon;
        if (balloon != null) {
            balloon.dismiss();
        }
        this.balloon = null;
        meetingRoomManager.getMBoxLevel().clear();
        meetingRoomManager.emptyMicInit(meetingRoomManager.getMicSize(meetingRoomManager.getMCurrentRoomMicType()));
        FragmentAudioRoomBinding binding = this.fragment.getBinding();
        if (binding != null && (newMicroView = binding.microView) != null) {
            newMicroView.changeMicType(meetingRoomManager.getMCurrentRoomMicType());
        }
        RoomViewModel.requestNewToken$default(this.fragment.getMViewModel(), new Function0() { // from class: com.qiahao.nextvideo.room.help.b8
            public final Object invoke() {
                Unit pkEnd$lambda$13;
                pkEnd$lambda$13 = PKGameHelp.pkEnd$lambda$13(PKGameHelp.this);
                return pkEnd$lambda$13;
            }
        }, null, 2, null);
    }

    public final void refreshMicByPosition(int position) {
        PKMicroView pKMicroView;
        PKMicroView pKMicroView2;
        RoomPK mpk = MeetingRoomManager.INSTANCE.getMPK();
        if (mpk != null && mpk.checkIsInvite()) {
            ViewGamePkBinding viewGamePkBinding = this.binding;
            if (viewGamePkBinding != null && (pKMicroView2 = viewGamePkBinding.leftMic) != null) {
                pKMicroView2.refreshMicByPosition(position);
                return;
            }
            return;
        }
        ViewGamePkBinding viewGamePkBinding2 = this.binding;
        if (viewGamePkBinding2 != null && (pKMicroView = viewGamePkBinding2.rightMic) != null) {
            pKMicroView.refreshMicByPosition(position);
        }
    }

    public final void refreshPro() {
        IncludePkGoBinding includePkGoBinding;
        TextView textView;
        IncludePkGoBinding includePkGoBinding2;
        Group group;
        IncludePkGoBinding includePkGoBinding3;
        TextView textView2;
        IncludePkGoBinding includePkGoBinding4;
        Group group2;
        IncludePkGoBinding includePkGoBinding5;
        TextView textView3;
        IncludePkGoBinding includePkGoBinding6;
        Group group3;
        IncludePkGoBinding includePkGoBinding7;
        TextView textView4;
        IncludePkGoBinding includePkGoBinding8;
        Group group4;
        PKMicroView pKMicroView;
        PKMicroView pKMicroView2;
        PKButtonView pKButtonView;
        ViewGamePkBinding viewGamePkBinding = this.binding;
        if (viewGamePkBinding != null && (pKButtonView = viewGamePkBinding.button) != null) {
            pKButtonView.refreshPro();
        }
        ViewGamePkBinding viewGamePkBinding2 = this.binding;
        if (viewGamePkBinding2 != null && (pKMicroView2 = viewGamePkBinding2.leftMic) != null) {
            pKMicroView2.refreshMic();
        }
        ViewGamePkBinding viewGamePkBinding3 = this.binding;
        if (viewGamePkBinding3 != null && (pKMicroView = viewGamePkBinding3.rightMic) != null) {
            pKMicroView.refreshMic();
        }
        PKLevelView pKLevelView = this.mLevelView;
        if (pKLevelView != null) {
            pKLevelView.refreshLevel();
        }
        refreshRoomMic();
        RoomPK mpk = MeetingRoomManager.INSTANCE.getMPK();
        if (mpk != null && mpk.checkIsInvite()) {
            ViewGamePkBinding viewGamePkBinding4 = this.binding;
            if (viewGamePkBinding4 != null && (includePkGoBinding8 = viewGamePkBinding4.redGo) != null && (group4 = includePkGoBinding8.group) != null) {
                group4.setVisibility(8);
            }
            ViewGamePkBinding viewGamePkBinding5 = this.binding;
            if (viewGamePkBinding5 != null && (includePkGoBinding7 = viewGamePkBinding5.redGo) != null && (textView4 = includePkGoBinding7.your) != null) {
                textView4.setVisibility(0);
            }
            ViewGamePkBinding viewGamePkBinding6 = this.binding;
            if (viewGamePkBinding6 != null && (includePkGoBinding6 = viewGamePkBinding6.blueGo) != null && (group3 = includePkGoBinding6.group) != null) {
                group3.setVisibility(0);
            }
            ViewGamePkBinding viewGamePkBinding7 = this.binding;
            if (viewGamePkBinding7 != null && (includePkGoBinding5 = viewGamePkBinding7.blueGo) != null && (textView3 = includePkGoBinding5.your) != null) {
                textView3.setVisibility(8);
                return;
            }
            return;
        }
        ViewGamePkBinding viewGamePkBinding8 = this.binding;
        if (viewGamePkBinding8 != null && (includePkGoBinding4 = viewGamePkBinding8.redGo) != null && (group2 = includePkGoBinding4.group) != null) {
            group2.setVisibility(0);
        }
        ViewGamePkBinding viewGamePkBinding9 = this.binding;
        if (viewGamePkBinding9 != null && (includePkGoBinding3 = viewGamePkBinding9.redGo) != null && (textView2 = includePkGoBinding3.your) != null) {
            textView2.setVisibility(8);
        }
        ViewGamePkBinding viewGamePkBinding10 = this.binding;
        if (viewGamePkBinding10 != null && (includePkGoBinding2 = viewGamePkBinding10.blueGo) != null && (group = includePkGoBinding2.group) != null) {
            group.setVisibility(8);
        }
        ViewGamePkBinding viewGamePkBinding11 = this.binding;
        if (viewGamePkBinding11 != null && (includePkGoBinding = viewGamePkBinding11.blueGo) != null && (textView = includePkGoBinding.your) != null) {
            textView.setVisibility(0);
        }
    }

    public final void refreshSVIP(int level) {
        PKMicroView pKMicroView;
        PKMicroView pKMicroView2;
        ViewGamePkBinding viewGamePkBinding = this.binding;
        if (viewGamePkBinding != null && (pKMicroView2 = viewGamePkBinding.leftMic) != null) {
            pKMicroView2.refreshSVIP(level);
        }
        ViewGamePkBinding viewGamePkBinding2 = this.binding;
        if (viewGamePkBinding2 != null && (pKMicroView = viewGamePkBinding2.rightMic) != null) {
            pKMicroView.refreshSVIP(level);
        }
    }

    public final void release() {
        CountDownTimer countDownTimer = this.timerTask;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.timerTask = null;
    }

    public final void removePKView() {
        FrameLayout frameLayout;
        FragmentAudioRoomBinding binding = this.fragment.getBinding();
        if (binding != null && (frameLayout = binding.gameLayout) != null) {
            frameLayout.removeAllViews();
        }
        this.binding = null;
    }

    public final void setBalloon(@Nullable Balloon balloon) {
        this.balloon = balloon;
    }

    public final void setBinding(@Nullable ViewGamePkBinding viewGamePkBinding) {
        this.binding = viewGamePkBinding;
    }

    public final void setMDefaultViewHeight(int i) {
        this.mDefaultViewHeight = i;
    }

    public final void setMLevelView(@Nullable PKLevelView pKLevelView) {
        this.mLevelView = pKLevelView;
    }

    public final void setMViewChangeHeight(int i) {
        this.mViewChangeHeight = i;
    }

    public final void setTimerTask(@Nullable CountDownTimer countDownTimer) {
        this.timerTask = countDownTimer;
    }

    public final void showFace(int position, @NotNull String url) {
        PKMicroView pKMicroView;
        PKMicroView pKMicroView2;
        Intrinsics.checkNotNullParameter(url, "url");
        RoomPK mpk = MeetingRoomManager.INSTANCE.getMPK();
        if (mpk != null && mpk.checkIsInvite()) {
            ViewGamePkBinding viewGamePkBinding = this.binding;
            if (viewGamePkBinding != null && (pKMicroView2 = viewGamePkBinding.leftMic) != null) {
                pKMicroView2.showFace(position, url);
                return;
            }
            return;
        }
        ViewGamePkBinding viewGamePkBinding2 = this.binding;
        if (viewGamePkBinding2 != null && (pKMicroView = viewGamePkBinding2.rightMic) != null) {
            pKMicroView.showFace(position, url);
        }
    }

    public final void showMicSpeakWaveAnim(@NotNull List<Integer> list, boolean isOther) {
        PKMicroView pKMicroView;
        PKMicroView pKMicroView2;
        PKMicroView pKMicroView3;
        PKMicroView pKMicroView4;
        Intrinsics.checkNotNullParameter(list, "list");
        RoomPK mpk = MeetingRoomManager.INSTANCE.getMPK();
        if (mpk != null && mpk.checkIsInvite()) {
            if (isOther) {
                ViewGamePkBinding viewGamePkBinding = this.binding;
                if (viewGamePkBinding != null && (pKMicroView4 = viewGamePkBinding.rightMic) != null) {
                    pKMicroView4.showMicSpeakWaveAnim(list);
                    return;
                }
                return;
            }
            ViewGamePkBinding viewGamePkBinding2 = this.binding;
            if (viewGamePkBinding2 != null && (pKMicroView3 = viewGamePkBinding2.leftMic) != null) {
                pKMicroView3.showMicSpeakWaveAnim(list);
                return;
            }
            return;
        }
        if (isOther) {
            ViewGamePkBinding viewGamePkBinding3 = this.binding;
            if (viewGamePkBinding3 != null && (pKMicroView2 = viewGamePkBinding3.leftMic) != null) {
                pKMicroView2.showMicSpeakWaveAnim(list);
                return;
            }
            return;
        }
        ViewGamePkBinding viewGamePkBinding4 = this.binding;
        if (viewGamePkBinding4 != null && (pKMicroView = viewGamePkBinding4.rightMic) != null) {
            pKMicroView.showMicSpeakWaveAnim(list);
        }
    }
}
