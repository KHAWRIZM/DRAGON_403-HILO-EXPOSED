package com.qiahao.nextvideo.room.help;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import com.oudi.utils.ktx.UiKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.oudi.utils.log.LogUtil;
import com.qiahao.base_common.BaseApplication;
import com.qiahao.base_common.common.BaseDialog;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.model.cp.MyCp;
import com.qiahao.base_common.model.eventBus.DelayEvent;
import com.qiahao.base_common.model.svip.SvipData;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.HiloBaseActivity;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.game.CreateSudData;
import com.qiahao.nextvideo.data.game.SUDGameAward;
import com.qiahao.nextvideo.data.game.SUDGameData;
import com.qiahao.nextvideo.data.model.GroupDetailBean;
import com.qiahao.nextvideo.data.model.MicroBean;
import com.qiahao.nextvideo.data.service.UserService;
import com.qiahao.nextvideo.databinding.FragmentGameRoomBinding;
import com.qiahao.nextvideo.databinding.ViewRoomGameBinding;
import com.qiahao.nextvideo.room.dialog.MicOperateBottomDialog;
import com.qiahao.nextvideo.room.dialog.MysteryDialog;
import com.qiahao.nextvideo.room.dialog.UserInfoBottomSheetDialog;
import com.qiahao.nextvideo.room.dialog.UserInfoCpDialog;
import com.qiahao.nextvideo.room.fragment.GameRoomFragment;
import com.qiahao.nextvideo.room.game.BackgammonIntroduceDialog;
import com.qiahao.nextvideo.room.game.CarromIntroduceDialog;
import com.qiahao.nextvideo.room.game.CrushEndDialog;
import com.qiahao.nextvideo.room.game.CrushIntroduceDialog;
import com.qiahao.nextvideo.room.game.DefaultSUDEndDialog;
import com.qiahao.nextvideo.room.game.DominoEndDialog;
import com.qiahao.nextvideo.room.game.DominoIntroduceDialog;
import com.qiahao.nextvideo.room.game.GameMicAdapter;
import com.qiahao.nextvideo.room.game.LudoEndDialog;
import com.qiahao.nextvideo.room.game.LudoIntroduceDialog;
import com.qiahao.nextvideo.room.game.UnoEndDialog;
import com.qiahao.nextvideo.room.game.UnoIntroduceDialog;
import com.qiahao.nextvideo.room.interfaces.UserInfoListener;
import com.qiahao.nextvideo.room.manager.MeetingRoomManager;
import com.qiahao.nextvideo.room.view.GroupInputLayoutView;
import com.qiahao.nextvideo.room.viewmodel.RoomViewModel;
import com.qiahao.nextvideo.sud.GameViewModel;
import com.qiahao.nextvideo.ui.reusable.uimodels.ImageUIModel;
import com.qiahao.nextvideo.ui.wallet.WalletActivity;
import com.qiahao.nextvideo.utilities.AppRequestUtils;
import com.qiahao.nextvideo.utilities.ViewUtilitiesKt;
import com.qiahao.nextvideo.utilities.animation.AnimationUtility;
import com.tencent.qcloud.tuicore.TUIConstants;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tech.sud.gip.core.ISudFSMStateHandle;
import tech.sud.mgp.SudMGPWrapper.decorator.SudFSMMGListener;
import tech.sud.mgp.SudMGPWrapper.decorator.SudFSTAPPDecorator;
import tech.sud.mgp.SudMGPWrapper.model.GameConfigModel;
import tech.sud.mgp.SudMGPWrapper.state.SudMGPAPPState;
import tech.sud.mgp.SudMGPWrapper.state.SudMGPMGState;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\tJ\b\u0010,\u001a\u00020*H\u0002J\b\u0010-\u001a\u00020*H\u0002J\b\u0010.\u001a\u00020*H\u0002J\u0006\u0010/\u001a\u00020*J\u0010\u00100\u001a\u00020*2\u0006\u0010+\u001a\u00020\tH\u0002J\u0010\u00101\u001a\u0002022\u0006\u0010+\u001a\u00020\tH\u0002J\u0010\u00103\u001a\u00020*2\u0006\u0010+\u001a\u00020\tH\u0002J\u0018\u00104\u001a\u00020*2\u0006\u00105\u001a\u0002022\u0006\u0010+\u001a\u00020\tH\u0002J\u0006\u00106\u001a\u000202J\b\u00107\u001a\u00020*H\u0002J\u0006\u00108\u001a\u00020*J\u0006\u00109\u001a\u00020*J\u0014\u0010:\u001a\u00020*2\f\u0010;\u001a\b\u0012\u0004\u0012\u00020\t0<J\u0016\u0010=\u001a\u00020*2\u0006\u0010>\u001a\u00020\t2\u0006\u0010?\u001a\u00020@J\u000e\u0010A\u001a\u00020*2\u0006\u0010>\u001a\u00020\tJ\u0018\u0010B\u001a\u00020*2\u0006\u0010+\u001a\u00020\t2\b\u0010C\u001a\u0004\u0018\u00010\u0001J\u0010\u0010D\u001a\u00020*2\u0006\u0010E\u001a\u00020FH\u0002J\u0016\u0010G\u001a\u00020*2\u0006\u0010H\u001a\u00020@2\u0006\u0010I\u001a\u00020\tJ \u0010J\u001a\u00020*2\u0006\u0010>\u001a\u00020\t2\b\u0010K\u001a\u0004\u0018\u00010L2\u0006\u0010M\u001a\u000202J3\u0010N\u001a\u00020*2\u0006\u0010H\u001a\u00020@2!\u0010O\u001a\u001d\u0012\u0013\u0012\u00110Q¢\u0006\f\bR\u0012\b\bS\u0012\u0004\b\b(T\u0012\u0004\u0012\u00020*0PH\u0002J\u0006\u0010U\u001a\u00020*J\u0006\u0010V\u001a\u00020*R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u0004\u0018\u00010!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001c\u0010&\u001a\u0004\u0018\u00010!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010#\"\u0004\b(\u0010%¨\u0006W"}, d2 = {"Lcom/qiahao/nextvideo/room/help/MatchGameHelp;", "", "fragment", "Lcom/qiahao/nextvideo/room/fragment/GameRoomFragment;", "<init>", "(Lcom/qiahao/nextvideo/room/fragment/GameRoomFragment;)V", "getFragment", "()Lcom/qiahao/nextvideo/room/fragment/GameRoomFragment;", "showGameType", "", "getShowGameType", "()I", "setShowGameType", "(I)V", "gameViewModel", "Lcom/qiahao/nextvideo/sud/GameViewModel;", "getGameViewModel", "()Lcom/qiahao/nextvideo/sud/GameViewModel;", "setGameViewModel", "(Lcom/qiahao/nextvideo/sud/GameViewModel;)V", "mUserInfoBottomSheetDialog", "Lcom/qiahao/nextvideo/room/dialog/UserInfoBottomSheetDialog;", "getMUserInfoBottomSheetDialog", "()Lcom/qiahao/nextvideo/room/dialog/UserInfoBottomSheetDialog;", "setMUserInfoBottomSheetDialog", "(Lcom/qiahao/nextvideo/room/dialog/UserInfoBottomSheetDialog;)V", "mUserInfoCpDialog", "Lcom/qiahao/nextvideo/room/dialog/UserInfoCpDialog;", "getMUserInfoCpDialog", "()Lcom/qiahao/nextvideo/room/dialog/UserInfoCpDialog;", "setMUserInfoCpDialog", "(Lcom/qiahao/nextvideo/room/dialog/UserInfoCpDialog;)V", "chatAnimatorSetShow", "Landroid/animation/AnimatorSet;", "getChatAnimatorSetShow", "()Landroid/animation/AnimatorSet;", "setChatAnimatorSetShow", "(Landroid/animation/AnimatorSet;)V", "chatAnimatorSetHide", "getChatAnimatorSetHide", "setChatAnimatorSetHide", "showGameView", "", "gameType", "initGameIcon", "initGameView", "initGameModel", "hideGameChat", "loadGame", "canShowGame", "", "setGameHeight", "setBg", "isShow", "isPlayGame", "changeGameMicType", "notificationMicChange", "showGameChat", "showMicSpeakWaveAnim", "list", "", "showFace", "position", "url", "", "refreshPosition", "showGameEnd", "data", "gameOneAgain", "dialog", "Lcom/qiahao/base_common/common/BaseDialog;", "showUserInfoDialog", "extraId", "micPosition", "showMicOperateBottomDialog", "micBean", "Lcom/qiahao/nextvideo/data/model/MicroBean;", "showLockLayout", "getUserInfoByExtraId", "onSuccess", "Lkotlin/Function1;", "Lcom/qiahao/base_common/model/common/User;", "Lkotlin/ParameterName;", "name", "user", "releaseGame", "releaseAnimation", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nMatchGameHelp.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MatchGameHelp.kt\ncom/qiahao/nextvideo/room/help/MatchGameHelp\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,975:1\n61#2,9:976\n61#2,9:985\n61#2,9:994\n1878#3,3:1003\n1#4:1006\n*S KotlinDebug\n*F\n+ 1 MatchGameHelp.kt\ncom/qiahao/nextvideo/room/help/MatchGameHelp\n*L\n127#1:976,9\n175#1:985,9\n180#1:994,9\n545#1:1003,3\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class MatchGameHelp {

    @Nullable
    private AnimatorSet chatAnimatorSetHide;

    @Nullable
    private AnimatorSet chatAnimatorSetShow;

    @NotNull
    private final GameRoomFragment fragment;

    @Nullable
    private GameViewModel gameViewModel;

    @Nullable
    private UserInfoBottomSheetDialog mUserInfoBottomSheetDialog;

    @Nullable
    private UserInfoCpDialog mUserInfoCpDialog;
    private int showGameType;

    public MatchGameHelp(@NotNull GameRoomFragment gameRoomFragment) {
        Intrinsics.checkNotNullParameter(gameRoomFragment, "fragment");
        this.fragment = gameRoomFragment;
    }

    private final boolean canShowGame(int gameType) {
        if (gameType == 1 && MeetingRoomManager.INSTANCE.getMLudoGameData() != null) {
            return true;
        }
        if (gameType == 2 && MeetingRoomManager.INSTANCE.getMUnoGameData() != null) {
            return true;
        }
        if (gameType == 10 && MeetingRoomManager.INSTANCE.getMDominoGameData() != null) {
            return true;
        }
        if (gameType == 11 && MeetingRoomManager.INSTANCE.getMCrushGameData() != null) {
            return true;
        }
        if (gameType == 18 && MeetingRoomManager.INSTANCE.getMCarromGameData() != null) {
            return true;
        }
        if (gameType == 21 && MeetingRoomManager.INSTANCE.getMJackaroGameData() != null) {
            return true;
        }
        if (gameType == 23 && MeetingRoomManager.INSTANCE.getMBackgammonGameData() != null) {
            return true;
        }
        return false;
    }

    private final void changeGameMicType() {
        GameMicAdapter gameMicAdapter;
        MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
        int micSize = meetingRoomManager.getMicSize(meetingRoomManager.getMCurrentRoomMicType());
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < micSize) {
            int i2 = i + 1;
            MicroBean microBean = (MicroBean) MeetingRoomManager.getMicQueue$default(MeetingRoomManager.INSTANCE, false, 1, null).get(Integer.valueOf(i2));
            if (microBean == null) {
                microBean = MicroBean.Companion.emptyMicroBean$default(MicroBean.INSTANCE, i, false, 2, null);
            }
            arrayList.add(microBean);
            i = i2;
        }
        GameRoomFragmentHelp mAudioHelp = this.fragment.getMAudioHelp();
        if (mAudioHelp != null && (gameMicAdapter = mAudioHelp.getGameMicAdapter()) != null) {
            gameMicAdapter.setList(arrayList);
        }
    }

    private final void gameOneAgain(BaseDialog dialog) {
        CreateSudData mCreateLudoData;
        int i = this.showGameType;
        if (i != 1) {
            if (i != 2) {
                if (i != 10) {
                    if (i != 11) {
                        if (i != 14) {
                            if (i != 18) {
                                if (i != 21) {
                                    if (i != 23) {
                                        mCreateLudoData = null;
                                    } else {
                                        mCreateLudoData = MeetingRoomManager.INSTANCE.getMCreateBackgammonData();
                                    }
                                } else {
                                    mCreateLudoData = MeetingRoomManager.INSTANCE.getMCreateJackaroData();
                                }
                            } else {
                                mCreateLudoData = MeetingRoomManager.INSTANCE.getMCreateCarromData();
                            }
                        } else {
                            mCreateLudoData = MeetingRoomManager.INSTANCE.getMCreateBalootData();
                        }
                    } else {
                        mCreateLudoData = MeetingRoomManager.INSTANCE.getMCreateCrushData();
                    }
                } else {
                    mCreateLudoData = MeetingRoomManager.INSTANCE.getMCreateDominoData();
                }
            } else {
                mCreateLudoData = MeetingRoomManager.INSTANCE.getMCreateUnoData();
            }
        } else {
            mCreateLudoData = MeetingRoomManager.INSTANCE.getMCreateLudoData();
        }
        LogUtil.e$default(LogUtil.INSTANCE, "eTag", "", false, 4, (Object) null);
        if (mCreateLudoData != null) {
            cf.c.c().l(new DelayEvent("HOME_OPEN_MATCH_GAME", mCreateLudoData));
            dialog.dismiss();
        }
    }

    private final void getUserInfoByExtraId(String extraId, final Function1<? super User, Unit> onSuccess) {
        RxUtilsKt.observeOnMainThread$default(UserService.roomUserInfo$default(UserService.INSTANCE.getShared(), extraId, null, 2, null), new Function1() { // from class: com.qiahao.nextvideo.room.help.p7
            public final Object invoke(Object obj) {
                Unit userInfoByExtraId$lambda$50;
                userInfoByExtraId$lambda$50 = MatchGameHelp.getUserInfoByExtraId$lambda$50(onSuccess, (ApiResponse) obj);
                return userInfoByExtraId$lambda$50;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.help.q7
            public final Object invoke(Object obj) {
                Unit userInfoByExtraId$lambda$51;
                userInfoByExtraId$lambda$51 = MatchGameHelp.getUserInfoByExtraId$lambda$51((Throwable) obj);
                return userInfoByExtraId$lambda$51;
            }
        }, (Function0) null, false, 12, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getUserInfoByExtraId$lambda$50(Function1 function1, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        User user = (User) apiResponse.getData();
        if (user != null) {
            function1.invoke(user);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getUserInfoByExtraId$lambda$51(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        return Unit.INSTANCE;
    }

    private final void initGameIcon() {
        int i;
        FragmentGameRoomBinding binding;
        ImageView imageView;
        Drawable drawable;
        int i2 = this.showGameType;
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 10) {
                    if (i2 != 11) {
                        if (i2 != 18) {
                            if (i2 != 21) {
                                if (i2 != 23) {
                                    i = 0;
                                } else {
                                    i = R.drawable.game_room_icon_backgammon;
                                }
                            } else {
                                i = R.drawable.game_room_icon_jackaro;
                            }
                        } else {
                            i = R.drawable.game_room_icon_carrom;
                        }
                    } else {
                        i = R.drawable.game_room_icon_crush;
                    }
                } else {
                    i = R.drawable.game_room_icon_domino;
                }
            } else {
                i = R.drawable.game_room_icon_uno;
            }
        } else {
            i = R.drawable.game_room_icon_ludo;
        }
        if (i != 0 && (binding = this.fragment.getBinding()) != null && (imageView = binding.gameIcon) != null) {
            Context context = this.fragment.getContext();
            if (context != null) {
                drawable = androidx.core.content.a.getDrawable(context, i);
            } else {
                drawable = null;
            }
            imageView.setImageDrawable(drawable);
        }
    }

    private final void initGameModel() {
        MutableLiveData<View> gameViewLiveData;
        if (this.gameViewModel == null) {
            final GameViewModel gameViewModel = new GameViewModel();
            gameViewModel.setGameCode(this.fragment.getMViewModel().getMGameCode());
            gameViewModel.setGameListener(new SudFSMMGListener() { // from class: com.qiahao.nextvideo.room.help.MatchGameHelp$initGameModel$1$1
                @Override // tech.sud.mgp.SudMGPWrapper.decorator.SudFSMMGListener
                public void onExpireCode(ISudFSMStateHandle handle, String dataJson) {
                    Intrinsics.checkNotNullParameter(handle, "handle");
                    GameViewModel gameViewModel2 = GameViewModel.this;
                    gameViewModel2.processOnExpireCode(gameViewModel2.getSudFSTAPPDecorator(), handle);
                }

                @Override // tech.sud.mgp.SudMGPWrapper.decorator.SudFSMMGListener
                public void onGameDestroyed() {
                }

                @Override // tech.sud.mgp.SudMGPWrapper.decorator.SudFSMMGListener
                public void onGameLoadingProgress(int stage, int retCode, int progress) {
                    rf.a.a(this, stage, retCode, progress);
                    if (progress == 100) {
                        this.initGameView();
                    }
                }

                @Override // tech.sud.mgp.SudMGPWrapper.decorator.SudFSMMGListener
                public /* synthetic */ void onGameLog(String str) {
                    rf.a.b(this, str);
                }

                @Override // tech.sud.mgp.SudMGPWrapper.decorator.SudFSMMGListener
                public /* synthetic */ void onGameMGBaseballDefaultState(ISudFSMStateHandle iSudFSMStateHandle, SudMGPMGState.MGBaseballDefaultState mGBaseballDefaultState) {
                    rf.a.c(this, iSudFSMStateHandle, mGBaseballDefaultState);
                }

                @Override // tech.sud.mgp.SudMGPWrapper.decorator.SudFSMMGListener
                public /* synthetic */ void onGameMGBaseballHideGameScene(ISudFSMStateHandle iSudFSMStateHandle, SudMGPMGState.MGBaseballHideGameScene mGBaseballHideGameScene) {
                    rf.a.d(this, iSudFSMStateHandle, mGBaseballHideGameScene);
                }

                @Override // tech.sud.mgp.SudMGPWrapper.decorator.SudFSMMGListener
                public /* synthetic */ void onGameMGBaseballMyRanking(ISudFSMStateHandle iSudFSMStateHandle, SudMGPMGState.MGBaseballMyRanking mGBaseballMyRanking) {
                    rf.a.e(this, iSudFSMStateHandle, mGBaseballMyRanking);
                }

                @Override // tech.sud.mgp.SudMGPWrapper.decorator.SudFSMMGListener
                public /* synthetic */ void onGameMGBaseballPrepareFinish(ISudFSMStateHandle iSudFSMStateHandle, SudMGPMGState.MGBaseballPrepareFinish mGBaseballPrepareFinish) {
                    rf.a.f(this, iSudFSMStateHandle, mGBaseballPrepareFinish);
                }

                @Override // tech.sud.mgp.SudMGPWrapper.decorator.SudFSMMGListener
                public /* synthetic */ void onGameMGBaseballRangeInfo(ISudFSMStateHandle iSudFSMStateHandle, SudMGPMGState.MGBaseballRangeInfo mGBaseballRangeInfo) {
                    rf.a.g(this, iSudFSMStateHandle, mGBaseballRangeInfo);
                }

                @Override // tech.sud.mgp.SudMGPWrapper.decorator.SudFSMMGListener
                public /* synthetic */ void onGameMGBaseballRanking(ISudFSMStateHandle iSudFSMStateHandle, SudMGPMGState.MGBaseballRanking mGBaseballRanking) {
                    rf.a.h(this, iSudFSMStateHandle, mGBaseballRanking);
                }

                @Override // tech.sud.mgp.SudMGPWrapper.decorator.SudFSMMGListener
                public /* synthetic */ void onGameMGBaseballSendDistance(ISudFSMStateHandle iSudFSMStateHandle, SudMGPMGState.MGBaseballSendDistance mGBaseballSendDistance) {
                    rf.a.i(this, iSudFSMStateHandle, mGBaseballSendDistance);
                }

                @Override // tech.sud.mgp.SudMGPWrapper.decorator.SudFSMMGListener
                public /* synthetic */ void onGameMGBaseballSetClickRect(ISudFSMStateHandle iSudFSMStateHandle, SudMGPMGState.MGBaseballSetClickRect mGBaseballSetClickRect) {
                    rf.a.j(this, iSudFSMStateHandle, mGBaseballSetClickRect);
                }

                @Override // tech.sud.mgp.SudMGPWrapper.decorator.SudFSMMGListener
                public /* synthetic */ void onGameMGBaseballShowGameScene(ISudFSMStateHandle iSudFSMStateHandle, SudMGPMGState.MGBaseballShowGameScene mGBaseballShowGameScene) {
                    rf.a.k(this, iSudFSMStateHandle, mGBaseballShowGameScene);
                }

                @Override // tech.sud.mgp.SudMGPWrapper.decorator.SudFSMMGListener
                public /* synthetic */ void onGameMGBaseballTextConfig(ISudFSMStateHandle iSudFSMStateHandle, SudMGPMGState.MGBaseballTextConfig mGBaseballTextConfig) {
                    rf.a.l(this, iSudFSMStateHandle, mGBaseballTextConfig);
                }

                @Override // tech.sud.mgp.SudMGPWrapper.decorator.SudFSMMGListener
                public /* synthetic */ void onGameMGCommonAPPCommonSelfXResp(ISudFSMStateHandle iSudFSMStateHandle, SudMGPMGState.MGCommonAPPCommonSelfXResp mGCommonAPPCommonSelfXResp) {
                    rf.a.m(this, iSudFSMStateHandle, mGCommonAPPCommonSelfXResp);
                }

                @Override // tech.sud.mgp.SudMGPWrapper.decorator.SudFSMMGListener
                public /* synthetic */ void onGameMGCommonAlert(ISudFSMStateHandle iSudFSMStateHandle, SudMGPMGState.MGCommonAlert mGCommonAlert) {
                    rf.a.n(this, iSudFSMStateHandle, mGCommonAlert);
                }

                @Override // tech.sud.mgp.SudMGPWrapper.decorator.SudFSMMGListener
                public /* synthetic */ void onGameMGCommonDestroyGameScene(ISudFSMStateHandle iSudFSMStateHandle, SudMGPMGState.MGCommonDestroyGameScene mGCommonDestroyGameScene) {
                    rf.a.o(this, iSudFSMStateHandle, mGCommonDestroyGameScene);
                }

                @Override // tech.sud.mgp.SudMGPWrapper.decorator.SudFSMMGListener
                public /* synthetic */ void onGameMGCommonGameASR(ISudFSMStateHandle iSudFSMStateHandle, SudMGPMGState.MGCommonGameASR mGCommonGameASR) {
                    rf.a.p(this, iSudFSMStateHandle, mGCommonGameASR);
                }

                @Override // tech.sud.mgp.SudMGPWrapper.decorator.SudFSMMGListener
                public /* synthetic */ void onGameMGCommonGameAddAIPlayers(ISudFSMStateHandle iSudFSMStateHandle, SudMGPMGState.MGCommonGameAddAIPlayers mGCommonGameAddAIPlayers) {
                    rf.a.q(this, iSudFSMStateHandle, mGCommonGameAddAIPlayers);
                }

                @Override // tech.sud.mgp.SudMGPWrapper.decorator.SudFSMMGListener
                public /* synthetic */ void onGameMGCommonGameBgMusicState(ISudFSMStateHandle iSudFSMStateHandle, SudMGPMGState.MGCommonGameBgMusicState mGCommonGameBgMusicState) {
                    rf.a.r(this, iSudFSMStateHandle, mGCommonGameBgMusicState);
                }

                @Override // tech.sud.mgp.SudMGPWrapper.decorator.SudFSMMGListener
                public /* synthetic */ void onGameMGCommonGameCreateOrder(ISudFSMStateHandle iSudFSMStateHandle, SudMGPMGState.MGCommonGameCreateOrder mGCommonGameCreateOrder) {
                    rf.a.s(this, iSudFSMStateHandle, mGCommonGameCreateOrder);
                }

                @Override // tech.sud.mgp.SudMGPWrapper.decorator.SudFSMMGListener
                public /* synthetic */ void onGameMGCommonGameDiscoAction(ISudFSMStateHandle iSudFSMStateHandle, SudMGPMGState.MGCommonGameDiscoAction mGCommonGameDiscoAction) {
                    rf.a.t(this, iSudFSMStateHandle, mGCommonGameDiscoAction);
                }

                @Override // tech.sud.mgp.SudMGPWrapper.decorator.SudFSMMGListener
                public /* synthetic */ void onGameMGCommonGameDiscoActionEnd(ISudFSMStateHandle iSudFSMStateHandle, SudMGPMGState.MGCommonGameDiscoActionEnd mGCommonGameDiscoActionEnd) {
                    rf.a.u(this, iSudFSMStateHandle, mGCommonGameDiscoActionEnd);
                }

                @Override // tech.sud.mgp.SudMGPWrapper.decorator.SudFSMMGListener
                public /* synthetic */ void onGameMGCommonGameFps(ISudFSMStateHandle iSudFSMStateHandle, SudMGPMGState.MGCommonGameFps mGCommonGameFps) {
                    rf.a.v(this, iSudFSMStateHandle, mGCommonGameFps);
                }

                @Override // tech.sud.mgp.SudMGPWrapper.decorator.SudFSMMGListener
                public /* synthetic */ void onGameMGCommonGameGetScore(ISudFSMStateHandle iSudFSMStateHandle, SudMGPMGState.MGCommonGameGetScore mGCommonGameGetScore) {
                    rf.a.w(this, iSudFSMStateHandle, mGCommonGameGetScore);
                }

                @Override // tech.sud.mgp.SudMGPWrapper.decorator.SudFSMMGListener
                public /* synthetic */ void onGameMGCommonGameIsAppChip(ISudFSMStateHandle iSudFSMStateHandle, SudMGPMGState.MGCommonGameIsAppChip mGCommonGameIsAppChip) {
                    rf.a.x(this, iSudFSMStateHandle, mGCommonGameIsAppChip);
                }

                @Override // tech.sud.mgp.SudMGPWrapper.decorator.SudFSMMGListener
                public /* synthetic */ void onGameMGCommonGameMoneyNotEnough(ISudFSMStateHandle iSudFSMStateHandle, SudMGPMGState.MGCommonGameMoneyNotEnough mGCommonGameMoneyNotEnough) {
                    rf.a.y(this, iSudFSMStateHandle, mGCommonGameMoneyNotEnough);
                }

                @Override // tech.sud.mgp.SudMGPWrapper.decorator.SudFSMMGListener
                public /* synthetic */ void onGameMGCommonGameNetworkState(ISudFSMStateHandle iSudFSMStateHandle, SudMGPMGState.MGCommonGameNetworkState mGCommonGameNetworkState) {
                    rf.a.z(this, iSudFSMStateHandle, mGCommonGameNetworkState);
                }

                @Override // tech.sud.mgp.SudMGPWrapper.decorator.SudFSMMGListener
                public /* synthetic */ void onGameMGCommonGameOverTip(ISudFSMStateHandle iSudFSMStateHandle, SudMGPMGState.MGCommonGameOverTip mGCommonGameOverTip) {
                    rf.a.A(this, iSudFSMStateHandle, mGCommonGameOverTip);
                }

                @Override // tech.sud.mgp.SudMGPWrapper.decorator.SudFSMMGListener
                public /* synthetic */ void onGameMGCommonGamePieceArriveEnd(ISudFSMStateHandle iSudFSMStateHandle, SudMGPMGState.MGCommonGamePieceArriveEnd mGCommonGamePieceArriveEnd) {
                    rf.a.B(this, iSudFSMStateHandle, mGCommonGamePieceArriveEnd);
                }

                @Override // tech.sud.mgp.SudMGPWrapper.decorator.SudFSMMGListener
                public /* synthetic */ void onGameMGCommonGamePlayerColor(ISudFSMStateHandle iSudFSMStateHandle, SudMGPMGState.MGCommonGamePlayerColor mGCommonGamePlayerColor) {
                    rf.a.C(this, iSudFSMStateHandle, mGCommonGamePlayerColor);
                }

                @Override // tech.sud.mgp.SudMGPWrapper.decorator.SudFSMMGListener
                public /* synthetic */ void onGameMGCommonGamePlayerIconPosition(ISudFSMStateHandle iSudFSMStateHandle, SudMGPMGState.MGCommonGamePlayerIconPosition mGCommonGamePlayerIconPosition) {
                    rf.a.D(this, iSudFSMStateHandle, mGCommonGamePlayerIconPosition);
                }

                @Override // tech.sud.mgp.SudMGPWrapper.decorator.SudFSMMGListener
                public /* synthetic */ void onGameMGCommonGamePlayerManagedState(ISudFSMStateHandle iSudFSMStateHandle, SudMGPMGState.MGCommonGamePlayerManagedState mGCommonGamePlayerManagedState) {
                    rf.a.E(this, iSudFSMStateHandle, mGCommonGamePlayerManagedState);
                }

                @Override // tech.sud.mgp.SudMGPWrapper.decorator.SudFSMMGListener
                public /* synthetic */ void onGameMGCommonGamePlayerMonopolyCards(ISudFSMStateHandle iSudFSMStateHandle, SudMGPMGState.MGCommonGamePlayerMonopolyCards mGCommonGamePlayerMonopolyCards) {
                    rf.a.F(this, iSudFSMStateHandle, mGCommonGamePlayerMonopolyCards);
                }

                @Override // tech.sud.mgp.SudMGPWrapper.decorator.SudFSMMGListener
                public /* synthetic */ void onGameMGCommonGamePlayerPairSingular(ISudFSMStateHandle iSudFSMStateHandle, SudMGPMGState.MGCommonGamePlayerPairSingular mGCommonGamePlayerPairSingular) {
                    rf.a.G(this, iSudFSMStateHandle, mGCommonGamePlayerPairSingular);
                }

                @Override // tech.sud.mgp.SudMGPWrapper.decorator.SudFSMMGListener
                public /* synthetic */ void onGameMGCommonGamePlayerRanks(ISudFSMStateHandle iSudFSMStateHandle, SudMGPMGState.MGCommonGamePlayerRanks mGCommonGamePlayerRanks) {
                    rf.a.H(this, iSudFSMStateHandle, mGCommonGamePlayerRanks);
                }

                @Override // tech.sud.mgp.SudMGPWrapper.decorator.SudFSMMGListener
                public /* synthetic */ void onGameMGCommonGamePlayerScores(ISudFSMStateHandle iSudFSMStateHandle, SudMGPMGState.MGCommonGamePlayerScores mGCommonGamePlayerScores) {
                    rf.a.I(this, iSudFSMStateHandle, mGCommonGamePlayerScores);
                }

                @Override // tech.sud.mgp.SudMGPWrapper.decorator.SudFSMMGListener
                public /* synthetic */ void onGameMGCommonGamePrepareFinish(ISudFSMStateHandle iSudFSMStateHandle, SudMGPMGState.MGCommonGamePrepareFinish mGCommonGamePrepareFinish) {
                    rf.a.J(this, iSudFSMStateHandle, mGCommonGamePrepareFinish);
                }

                @Override // tech.sud.mgp.SudMGPWrapper.decorator.SudFSMMGListener
                public /* synthetic */ void onGameMGCommonGameRule(ISudFSMStateHandle iSudFSMStateHandle, SudMGPMGState.MGCommonGameRule mGCommonGameRule) {
                    rf.a.K(this, iSudFSMStateHandle, mGCommonGameRule);
                }

                @Override // tech.sud.mgp.SudMGPWrapper.decorator.SudFSMMGListener
                public /* synthetic */ void onGameMGCommonGameSendBurstWord(ISudFSMStateHandle iSudFSMStateHandle, SudMGPMGState.MGCommonGameSendBurstWord mGCommonGameSendBurstWord) {
                    rf.a.L(this, iSudFSMStateHandle, mGCommonGameSendBurstWord);
                }

                @Override // tech.sud.mgp.SudMGPWrapper.decorator.SudFSMMGListener
                public /* synthetic */ void onGameMGCommonGameSetScore(ISudFSMStateHandle iSudFSMStateHandle, SudMGPMGState.MGCommonGameSetScore mGCommonGameSetScore) {
                    rf.a.M(this, iSudFSMStateHandle, mGCommonGameSetScore);
                }

                @Override // tech.sud.mgp.SudMGPWrapper.decorator.SudFSMMGListener
                public /* synthetic */ void onGameMGCommonGameSettings(ISudFSMStateHandle iSudFSMStateHandle, SudMGPMGState.MGCommonGameSettings mGCommonGameSettings) {
                    rf.a.N(this, iSudFSMStateHandle, mGCommonGameSettings);
                }

                @Override // tech.sud.mgp.SudMGPWrapper.decorator.SudFSMMGListener
                public /* synthetic */ void onGameMGCommonGameSettle(ISudFSMStateHandle iSudFSMStateHandle, SudMGPMGState.MGCommonGameSettle mGCommonGameSettle) {
                    rf.a.O(this, iSudFSMStateHandle, mGCommonGameSettle);
                }

                @Override // tech.sud.mgp.SudMGPWrapper.decorator.SudFSMMGListener
                public /* synthetic */ void onGameMGCommonGameSound(ISudFSMStateHandle iSudFSMStateHandle, SudMGPMGState.MGCommonGameSound mGCommonGameSound) {
                    rf.a.P(this, iSudFSMStateHandle, mGCommonGameSound);
                }

                @Override // tech.sud.mgp.SudMGPWrapper.decorator.SudFSMMGListener
                public /* synthetic */ void onGameMGCommonGameSoundList(ISudFSMStateHandle iSudFSMStateHandle, SudMGPMGState.MGCommonGameSoundList mGCommonGameSoundList) {
                    rf.a.Q(this, iSudFSMStateHandle, mGCommonGameSoundList);
                }

                @Override // tech.sud.mgp.SudMGPWrapper.decorator.SudFSMMGListener
                public /* synthetic */ void onGameMGCommonGameSoundState(ISudFSMStateHandle iSudFSMStateHandle, SudMGPMGState.MGCommonGameSoundState mGCommonGameSoundState) {
                    rf.a.R(this, iSudFSMStateHandle, mGCommonGameSoundState);
                }

                @Override // tech.sud.mgp.SudMGPWrapper.decorator.SudFSMMGListener
                public void onGameMGCommonGameState(ISudFSMStateHandle handle, SudMGPMGState.MGCommonGameState model) {
                    Intrinsics.checkNotNullParameter(handle, "handle");
                    rf.a.S(this, handle, model);
                }

                @Override // tech.sud.mgp.SudMGPWrapper.decorator.SudFSMMGListener
                public /* synthetic */ void onGameMGCommonGameUiCustomConfig(ISudFSMStateHandle iSudFSMStateHandle, SudMGPMGState.MGCommonGameUiCustomConfig mGCommonGameUiCustomConfig) {
                    rf.a.T(this, iSudFSMStateHandle, mGCommonGameUiCustomConfig);
                }

                @Override // tech.sud.mgp.SudMGPWrapper.decorator.SudFSMMGListener
                public /* synthetic */ void onGameMGCommonHideGameScene(ISudFSMStateHandle iSudFSMStateHandle, SudMGPMGState.MGCommonHideGameScene mGCommonHideGameScene) {
                    rf.a.U(this, iSudFSMStateHandle, mGCommonHideGameScene);
                }

                @Override // tech.sud.mgp.SudMGPWrapper.decorator.SudFSMMGListener
                public /* synthetic */ void onGameMGCommonKeyWordToHit(ISudFSMStateHandle iSudFSMStateHandle, SudMGPMGState.MGCommonKeyWordToHit mGCommonKeyWordToHit) {
                    rf.a.V(this, iSudFSMStateHandle, mGCommonKeyWordToHit);
                }

                @Override // tech.sud.mgp.SudMGPWrapper.decorator.SudFSMMGListener
                public /* synthetic */ void onGameMGCommonPlayerRoleId(ISudFSMStateHandle iSudFSMStateHandle, SudMGPMGState.MGCommonPlayerRoleId mGCommonPlayerRoleId) {
                    rf.a.W(this, iSudFSMStateHandle, mGCommonPlayerRoleId);
                }

                @Override // tech.sud.mgp.SudMGPWrapper.decorator.SudFSMMGListener
                public /* synthetic */ void onGameMGCommonPublicMessage(ISudFSMStateHandle iSudFSMStateHandle, SudMGPMGState.MGCommonPublicMessage mGCommonPublicMessage) {
                    rf.a.X(this, iSudFSMStateHandle, mGCommonPublicMessage);
                }

                @Override // tech.sud.mgp.SudMGPWrapper.decorator.SudFSMMGListener
                public /* synthetic */ void onGameMGCommonSelfClickCancelJoinBtn(ISudFSMStateHandle iSudFSMStateHandle, SudMGPMGState.MGCommonSelfClickCancelJoinBtn mGCommonSelfClickCancelJoinBtn) {
                    rf.a.Y(this, iSudFSMStateHandle, mGCommonSelfClickCancelJoinBtn);
                }

                @Override // tech.sud.mgp.SudMGPWrapper.decorator.SudFSMMGListener
                public /* synthetic */ void onGameMGCommonSelfClickCancelReadyBtn(ISudFSMStateHandle iSudFSMStateHandle, SudMGPMGState.MGCommonSelfClickCancelReadyBtn mGCommonSelfClickCancelReadyBtn) {
                    rf.a.Z(this, iSudFSMStateHandle, mGCommonSelfClickCancelReadyBtn);
                }

                @Override // tech.sud.mgp.SudMGPWrapper.decorator.SudFSMMGListener
                public /* synthetic */ void onGameMGCommonSelfClickExitGameBtn(ISudFSMStateHandle iSudFSMStateHandle, SudMGPMGState.MGCommonSelfClickExitGameBtn mGCommonSelfClickExitGameBtn) {
                    rf.a.a0(this, iSudFSMStateHandle, mGCommonSelfClickExitGameBtn);
                }

                @Override // tech.sud.mgp.SudMGPWrapper.decorator.SudFSMMGListener
                public /* synthetic */ void onGameMGCommonSelfClickGameSettleAgainBtn(ISudFSMStateHandle iSudFSMStateHandle, SudMGPMGState.MGCommonSelfClickGameSettleAgainBtn mGCommonSelfClickGameSettleAgainBtn) {
                    rf.a.b0(this, iSudFSMStateHandle, mGCommonSelfClickGameSettleAgainBtn);
                }

                @Override // tech.sud.mgp.SudMGPWrapper.decorator.SudFSMMGListener
                public /* synthetic */ void onGameMGCommonSelfClickGameSettleCloseBtn(ISudFSMStateHandle iSudFSMStateHandle, SudMGPMGState.MGCommonSelfClickGameSettleCloseBtn mGCommonSelfClickGameSettleCloseBtn) {
                    rf.a.c0(this, iSudFSMStateHandle, mGCommonSelfClickGameSettleCloseBtn);
                }

                @Override // tech.sud.mgp.SudMGPWrapper.decorator.SudFSMMGListener
                public /* synthetic */ void onGameMGCommonSelfClickGoldBtn(ISudFSMStateHandle iSudFSMStateHandle, SudMGPMGState.MGCommonSelfClickGoldBtn mGCommonSelfClickGoldBtn) {
                    rf.a.d0(this, iSudFSMStateHandle, mGCommonSelfClickGoldBtn);
                }

                @Override // tech.sud.mgp.SudMGPWrapper.decorator.SudFSMMGListener
                public /* synthetic */ void onGameMGCommonSelfClickGood(ISudFSMStateHandle iSudFSMStateHandle, SudMGPMGState.MGCommonSelfClickGood mGCommonSelfClickGood) {
                    rf.a.e0(this, iSudFSMStateHandle, mGCommonSelfClickGood);
                }

                @Override // tech.sud.mgp.SudMGPWrapper.decorator.SudFSMMGListener
                public /* synthetic */ void onGameMGCommonSelfClickJoinBtn(ISudFSMStateHandle iSudFSMStateHandle, SudMGPMGState.MGCommonSelfClickJoinBtn mGCommonSelfClickJoinBtn) {
                    rf.a.f0(this, iSudFSMStateHandle, mGCommonSelfClickJoinBtn);
                }

                @Override // tech.sud.mgp.SudMGPWrapper.decorator.SudFSMMGListener
                public /* synthetic */ void onGameMGCommonSelfClickPoop(ISudFSMStateHandle iSudFSMStateHandle, SudMGPMGState.MGCommonSelfClickPoop mGCommonSelfClickPoop) {
                    rf.a.g0(this, iSudFSMStateHandle, mGCommonSelfClickPoop);
                }

                @Override // tech.sud.mgp.SudMGPWrapper.decorator.SudFSMMGListener
                public /* synthetic */ void onGameMGCommonSelfClickReadyBtn(ISudFSMStateHandle iSudFSMStateHandle, SudMGPMGState.MGCommonSelfClickReadyBtn mGCommonSelfClickReadyBtn) {
                    rf.a.h0(this, iSudFSMStateHandle, mGCommonSelfClickReadyBtn);
                }

                @Override // tech.sud.mgp.SudMGPWrapper.decorator.SudFSMMGListener
                public /* synthetic */ void onGameMGCommonSelfClickShareBtn(ISudFSMStateHandle iSudFSMStateHandle, SudMGPMGState.MGCommonSelfClickShareBtn mGCommonSelfClickShareBtn) {
                    rf.a.i0(this, iSudFSMStateHandle, mGCommonSelfClickShareBtn);
                }

                @Override // tech.sud.mgp.SudMGPWrapper.decorator.SudFSMMGListener
                public /* synthetic */ void onGameMGCommonSelfClickStartBtn(ISudFSMStateHandle iSudFSMStateHandle, SudMGPMGState.MGCommonSelfClickStartBtn mGCommonSelfClickStartBtn) {
                    rf.a.j0(this, iSudFSMStateHandle, mGCommonSelfClickStartBtn);
                }

                @Override // tech.sud.mgp.SudMGPWrapper.decorator.SudFSMMGListener
                public /* synthetic */ void onGameMGCommonSelfHeadphone(ISudFSMStateHandle iSudFSMStateHandle, SudMGPMGState.MGCommonSelfHeadphone mGCommonSelfHeadphone) {
                    rf.a.k0(this, iSudFSMStateHandle, mGCommonSelfHeadphone);
                }

                @Override // tech.sud.mgp.SudMGPWrapper.decorator.SudFSMMGListener
                public /* synthetic */ void onGameMGCommonSelfMicrophone(ISudFSMStateHandle iSudFSMStateHandle, SudMGPMGState.MGCommonSelfMicrophone mGCommonSelfMicrophone) {
                    rf.a.l0(this, iSudFSMStateHandle, mGCommonSelfMicrophone);
                }

                @Override // tech.sud.mgp.SudMGPWrapper.decorator.SudFSMMGListener
                public /* synthetic */ void onGameMGCommonSetClickRect(ISudFSMStateHandle iSudFSMStateHandle, SudMGPMGState.MGCommonSetClickRect mGCommonSetClickRect) {
                    rf.a.m0(this, iSudFSMStateHandle, mGCommonSetClickRect);
                }

                @Override // tech.sud.mgp.SudMGPWrapper.decorator.SudFSMMGListener
                public /* synthetic */ void onGameMGCommonShowGameScene(ISudFSMStateHandle iSudFSMStateHandle, SudMGPMGState.MGCommonShowGameScene mGCommonShowGameScene) {
                    rf.a.n0(this, iSudFSMStateHandle, mGCommonShowGameScene);
                }

                @Override // tech.sud.mgp.SudMGPWrapper.decorator.SudFSMMGListener
                public /* synthetic */ void onGameMGCommonUsersInfo(ISudFSMStateHandle iSudFSMStateHandle, SudMGPMGState.MGCommonUsersInfo mGCommonUsersInfo) {
                    rf.a.o0(this, iSudFSMStateHandle, mGCommonUsersInfo);
                }

                @Override // tech.sud.mgp.SudMGPWrapper.decorator.SudFSMMGListener
                public /* synthetic */ void onGameMGCommonWorstTeammate(ISudFSMStateHandle iSudFSMStateHandle, SudMGPMGState.MGCommonWorstTeammate mGCommonWorstTeammate) {
                    rf.a.p0(this, iSudFSMStateHandle, mGCommonWorstTeammate);
                }

                @Override // tech.sud.mgp.SudMGPWrapper.decorator.SudFSMMGListener
                public /* synthetic */ void onGameMGCustomCrClickSeat(ISudFSMStateHandle iSudFSMStateHandle, SudMGPMGState.MGCustomCrClickSeat mGCustomCrClickSeat) {
                    rf.a.q0(this, iSudFSMStateHandle, mGCustomCrClickSeat);
                }

                @Override // tech.sud.mgp.SudMGPWrapper.decorator.SudFSMMGListener
                public /* synthetic */ void onGameMGCustomCrRoomInitData(ISudFSMStateHandle iSudFSMStateHandle, SudMGPMGState.MGCustomCrRoomInitData mGCustomCrRoomInitData) {
                    rf.a.r0(this, iSudFSMStateHandle, mGCustomCrRoomInitData);
                }

                @Override // tech.sud.mgp.SudMGPWrapper.decorator.SudFSMMGListener
                public /* synthetic */ void onGameMGCustomRocketBuyComponent(ISudFSMStateHandle iSudFSMStateHandle, SudMGPMGState.MGCustomRocketBuyComponent mGCustomRocketBuyComponent) {
                    rf.a.s0(this, iSudFSMStateHandle, mGCustomRocketBuyComponent);
                }

                @Override // tech.sud.mgp.SudMGPWrapper.decorator.SudFSMMGListener
                public /* synthetic */ void onGameMGCustomRocketClickLockComponent(ISudFSMStateHandle iSudFSMStateHandle, SudMGPMGState.MGCustomRocketClickLockComponent mGCustomRocketClickLockComponent) {
                    rf.a.t0(this, iSudFSMStateHandle, mGCustomRocketClickLockComponent);
                }

                @Override // tech.sud.mgp.SudMGPWrapper.decorator.SudFSMMGListener
                public /* synthetic */ void onGameMGCustomRocketComponentList(ISudFSMStateHandle iSudFSMStateHandle, SudMGPMGState.MGCustomRocketComponentList mGCustomRocketComponentList) {
                    rf.a.u0(this, iSudFSMStateHandle, mGCustomRocketComponentList);
                }

                @Override // tech.sud.mgp.SudMGPWrapper.decorator.SudFSMMGListener
                public /* synthetic */ void onGameMGCustomRocketConfig(ISudFSMStateHandle iSudFSMStateHandle, SudMGPMGState.MGCustomRocketConfig mGCustomRocketConfig) {
                    rf.a.v0(this, iSudFSMStateHandle, mGCustomRocketConfig);
                }

                @Override // tech.sud.mgp.SudMGPWrapper.decorator.SudFSMMGListener
                public /* synthetic */ void onGameMGCustomRocketCreateModel(ISudFSMStateHandle iSudFSMStateHandle, SudMGPMGState.MGCustomRocketCreateModel mGCustomRocketCreateModel) {
                    rf.a.w0(this, iSudFSMStateHandle, mGCustomRocketCreateModel);
                }

                @Override // tech.sud.mgp.SudMGPWrapper.decorator.SudFSMMGListener
                public /* synthetic */ void onGameMGCustomRocketDynamicFirePrice(ISudFSMStateHandle iSudFSMStateHandle, SudMGPMGState.MGCustomRocketDynamicFirePrice mGCustomRocketDynamicFirePrice) {
                    rf.a.x0(this, iSudFSMStateHandle, mGCustomRocketDynamicFirePrice);
                }

                @Override // tech.sud.mgp.SudMGPWrapper.decorator.SudFSMMGListener
                public /* synthetic */ void onGameMGCustomRocketFireModel(ISudFSMStateHandle iSudFSMStateHandle, SudMGPMGState.MGCustomRocketFireModel mGCustomRocketFireModel) {
                    rf.a.y0(this, iSudFSMStateHandle, mGCustomRocketFireModel);
                }

                @Override // tech.sud.mgp.SudMGPWrapper.decorator.SudFSMMGListener
                public /* synthetic */ void onGameMGCustomRocketFlyClick(ISudFSMStateHandle iSudFSMStateHandle, SudMGPMGState.MGCustomRocketFlyClick mGCustomRocketFlyClick) {
                    rf.a.z0(this, iSudFSMStateHandle, mGCustomRocketFlyClick);
                }

                @Override // tech.sud.mgp.SudMGPWrapper.decorator.SudFSMMGListener
                public /* synthetic */ void onGameMGCustomRocketFlyEnd(ISudFSMStateHandle iSudFSMStateHandle, SudMGPMGState.MGCustomRocketFlyEnd mGCustomRocketFlyEnd) {
                    rf.a.A0(this, iSudFSMStateHandle, mGCustomRocketFlyEnd);
                }

                @Override // tech.sud.mgp.SudMGPWrapper.decorator.SudFSMMGListener
                public /* synthetic */ void onGameMGCustomRocketHideGameScene(ISudFSMStateHandle iSudFSMStateHandle, SudMGPMGState.MGCustomRocketHideGameScene mGCustomRocketHideGameScene) {
                    rf.a.B0(this, iSudFSMStateHandle, mGCustomRocketHideGameScene);
                }

                @Override // tech.sud.mgp.SudMGPWrapper.decorator.SudFSMMGListener
                public /* synthetic */ void onGameMGCustomRocketModelList(ISudFSMStateHandle iSudFSMStateHandle, SudMGPMGState.MGCustomRocketModelList mGCustomRocketModelList) {
                    rf.a.C0(this, iSudFSMStateHandle, mGCustomRocketModelList);
                }

                @Override // tech.sud.mgp.SudMGPWrapper.decorator.SudFSMMGListener
                public /* synthetic */ void onGameMGCustomRocketOrderRecordList(ISudFSMStateHandle iSudFSMStateHandle, SudMGPMGState.MGCustomRocketOrderRecordList mGCustomRocketOrderRecordList) {
                    rf.a.D0(this, iSudFSMStateHandle, mGCustomRocketOrderRecordList);
                }

                @Override // tech.sud.mgp.SudMGPWrapper.decorator.SudFSMMGListener
                public /* synthetic */ void onGameMGCustomRocketPlayEffectFinish(ISudFSMStateHandle iSudFSMStateHandle, SudMGPMGState.MGCustomRocketPlayEffectFinish mGCustomRocketPlayEffectFinish) {
                    rf.a.E0(this, iSudFSMStateHandle, mGCustomRocketPlayEffectFinish);
                }

                @Override // tech.sud.mgp.SudMGPWrapper.decorator.SudFSMMGListener
                public /* synthetic */ void onGameMGCustomRocketPlayEffectStart(ISudFSMStateHandle iSudFSMStateHandle, SudMGPMGState.MGCustomRocketPlayEffectStart mGCustomRocketPlayEffectStart) {
                    rf.a.F0(this, iSudFSMStateHandle, mGCustomRocketPlayEffectStart);
                }

                @Override // tech.sud.mgp.SudMGPWrapper.decorator.SudFSMMGListener
                public /* synthetic */ void onGameMGCustomRocketPrepareFinish(ISudFSMStateHandle iSudFSMStateHandle, SudMGPMGState.MGCustomRocketPrepareFinish mGCustomRocketPrepareFinish) {
                    rf.a.G0(this, iSudFSMStateHandle, mGCustomRocketPrepareFinish);
                }

                @Override // tech.sud.mgp.SudMGPWrapper.decorator.SudFSMMGListener
                public /* synthetic */ void onGameMGCustomRocketReplaceComponent(ISudFSMStateHandle iSudFSMStateHandle, SudMGPMGState.MGCustomRocketReplaceComponent mGCustomRocketReplaceComponent) {
                    rf.a.H0(this, iSudFSMStateHandle, mGCustomRocketReplaceComponent);
                }

                @Override // tech.sud.mgp.SudMGPWrapper.decorator.SudFSMMGListener
                public /* synthetic */ void onGameMGCustomRocketRoomRecordList(ISudFSMStateHandle iSudFSMStateHandle, SudMGPMGState.MGCustomRocketRoomRecordList mGCustomRocketRoomRecordList) {
                    rf.a.I0(this, iSudFSMStateHandle, mGCustomRocketRoomRecordList);
                }

                @Override // tech.sud.mgp.SudMGPWrapper.decorator.SudFSMMGListener
                public /* synthetic */ void onGameMGCustomRocketSaveSignColor(ISudFSMStateHandle iSudFSMStateHandle, SudMGPMGState.MGCustomRocketSaveSignColor mGCustomRocketSaveSignColor) {
                    rf.a.J0(this, iSudFSMStateHandle, mGCustomRocketSaveSignColor);
                }

                @Override // tech.sud.mgp.SudMGPWrapper.decorator.SudFSMMGListener
                public /* synthetic */ void onGameMGCustomRocketSetClickRect(ISudFSMStateHandle iSudFSMStateHandle, SudMGPMGState.MGCustomRocketSetClickRect mGCustomRocketSetClickRect) {
                    rf.a.K0(this, iSudFSMStateHandle, mGCustomRocketSetClickRect);
                }

                @Override // tech.sud.mgp.SudMGPWrapper.decorator.SudFSMMGListener
                public /* synthetic */ void onGameMGCustomRocketSetDefaultModel(ISudFSMStateHandle iSudFSMStateHandle, SudMGPMGState.MGCustomRocketSetDefaultModel mGCustomRocketSetDefaultModel) {
                    rf.a.L0(this, iSudFSMStateHandle, mGCustomRocketSetDefaultModel);
                }

                @Override // tech.sud.mgp.SudMGPWrapper.decorator.SudFSMMGListener
                public /* synthetic */ void onGameMGCustomRocketShowGameScene(ISudFSMStateHandle iSudFSMStateHandle, SudMGPMGState.MGCustomRocketShowGameScene mGCustomRocketShowGameScene) {
                    rf.a.M0(this, iSudFSMStateHandle, mGCustomRocketShowGameScene);
                }

                @Override // tech.sud.mgp.SudMGPWrapper.decorator.SudFSMMGListener
                public /* synthetic */ void onGameMGCustomRocketUploadModelIcon(ISudFSMStateHandle iSudFSMStateHandle, SudMGPMGState.MGCustomRocketUploadModelIcon mGCustomRocketUploadModelIcon) {
                    rf.a.N0(this, iSudFSMStateHandle, mGCustomRocketUploadModelIcon);
                }

                @Override // tech.sud.mgp.SudMGPWrapper.decorator.SudFSMMGListener
                public /* synthetic */ void onGameMGCustomRocketUserInfo(ISudFSMStateHandle iSudFSMStateHandle, SudMGPMGState.MGCustomRocketUserInfo mGCustomRocketUserInfo) {
                    rf.a.O0(this, iSudFSMStateHandle, mGCustomRocketUserInfo);
                }

                @Override // tech.sud.mgp.SudMGPWrapper.decorator.SudFSMMGListener
                public /* synthetic */ void onGameMGCustomRocketUserRecordList(ISudFSMStateHandle iSudFSMStateHandle, SudMGPMGState.MGCustomRocketUserRecordList mGCustomRocketUserRecordList) {
                    rf.a.P0(this, iSudFSMStateHandle, mGCustomRocketUserRecordList);
                }

                @Override // tech.sud.mgp.SudMGPWrapper.decorator.SudFSMMGListener
                public /* synthetic */ void onGameMGCustomRocketVerifySign(ISudFSMStateHandle iSudFSMStateHandle, SudMGPMGState.MGCustomRocketVerifySign mGCustomRocketVerifySign) {
                    rf.a.Q0(this, iSudFSMStateHandle, mGCustomRocketVerifySign);
                }

                @Override // tech.sud.mgp.SudMGPWrapper.decorator.SudFSMMGListener
                public void onGameStarted() {
                }

                @Override // tech.sud.mgp.SudMGPWrapper.decorator.SudFSMMGListener
                public /* synthetic */ boolean onGameStateChange(ISudFSMStateHandle iSudFSMStateHandle, String str, String str2) {
                    return rf.a.R0(this, iSudFSMStateHandle, str, str2);
                }

                @Override // tech.sud.mgp.SudMGPWrapper.decorator.SudFSMMGListener
                public void onGetGameCfg(ISudFSMStateHandle handle, String dataJson) {
                    Intrinsics.checkNotNullParameter(handle, "handle");
                    GameViewModel.this.processOnGetGameCfg(handle, dataJson);
                }

                @Override // tech.sud.mgp.SudMGPWrapper.decorator.SudFSMMGListener
                public void onGetGameViewInfo(ISudFSMStateHandle handle, String dataJson) {
                    Intrinsics.checkNotNullParameter(handle, "handle");
                    GameViewModel gameViewModel2 = GameViewModel.this;
                    gameViewModel2.processOnGetGameViewInfo(gameViewModel2.getGameView(), handle);
                }

                @Override // tech.sud.mgp.SudMGPWrapper.decorator.SudFSMMGListener
                public /* synthetic */ void onPlayerMGCommonGameCountdownTime(ISudFSMStateHandle iSudFSMStateHandle, String str, SudMGPMGState.MGCommonGameCountdownTime mGCommonGameCountdownTime) {
                    rf.a.S0(this, iSudFSMStateHandle, str, mGCommonGameCountdownTime);
                }

                @Override // tech.sud.mgp.SudMGPWrapper.decorator.SudFSMMGListener
                public /* synthetic */ void onPlayerMGCommonPlayerCaptain(ISudFSMStateHandle iSudFSMStateHandle, String str, SudMGPMGState.MGCommonPlayerCaptain mGCommonPlayerCaptain) {
                    rf.a.T0(this, iSudFSMStateHandle, str, mGCommonPlayerCaptain);
                }

                @Override // tech.sud.mgp.SudMGPWrapper.decorator.SudFSMMGListener
                public /* synthetic */ void onPlayerMGCommonPlayerChangeSeat(ISudFSMStateHandle iSudFSMStateHandle, String str, SudMGPMGState.MGCommonPlayerChangeSeat mGCommonPlayerChangeSeat) {
                    rf.a.U0(this, iSudFSMStateHandle, str, mGCommonPlayerChangeSeat);
                }

                @Override // tech.sud.mgp.SudMGPWrapper.decorator.SudFSMMGListener
                public /* synthetic */ void onPlayerMGCommonPlayerIn(ISudFSMStateHandle iSudFSMStateHandle, String str, SudMGPMGState.MGCommonPlayerIn mGCommonPlayerIn) {
                    rf.a.V0(this, iSudFSMStateHandle, str, mGCommonPlayerIn);
                }

                @Override // tech.sud.mgp.SudMGPWrapper.decorator.SudFSMMGListener
                public /* synthetic */ void onPlayerMGCommonPlayerOnline(ISudFSMStateHandle iSudFSMStateHandle, String str, SudMGPMGState.MGCommonPlayerOnline mGCommonPlayerOnline) {
                    rf.a.W0(this, iSudFSMStateHandle, str, mGCommonPlayerOnline);
                }

                @Override // tech.sud.mgp.SudMGPWrapper.decorator.SudFSMMGListener
                public /* synthetic */ void onPlayerMGCommonPlayerPlaying(ISudFSMStateHandle iSudFSMStateHandle, String str, SudMGPMGState.MGCommonPlayerPlaying mGCommonPlayerPlaying) {
                    rf.a.X0(this, iSudFSMStateHandle, str, mGCommonPlayerPlaying);
                }

                @Override // tech.sud.mgp.SudMGPWrapper.decorator.SudFSMMGListener
                public /* synthetic */ void onPlayerMGCommonPlayerReady(ISudFSMStateHandle iSudFSMStateHandle, String str, SudMGPMGState.MGCommonPlayerReady mGCommonPlayerReady) {
                    rf.a.Y0(this, iSudFSMStateHandle, str, mGCommonPlayerReady);
                }

                @Override // tech.sud.mgp.SudMGPWrapper.decorator.SudFSMMGListener
                public /* synthetic */ void onPlayerMGCommonSelfClickGamePlayerIcon(ISudFSMStateHandle iSudFSMStateHandle, String str, SudMGPMGState.MGCommonSelfClickGamePlayerIcon mGCommonSelfClickGamePlayerIcon) {
                    rf.a.Z0(this, iSudFSMStateHandle, str, mGCommonSelfClickGamePlayerIcon);
                }

                @Override // tech.sud.mgp.SudMGPWrapper.decorator.SudFSMMGListener
                public /* synthetic */ void onPlayerMGCommonSelfDieStatus(ISudFSMStateHandle iSudFSMStateHandle, String str, SudMGPMGState.MGCommonSelfDieStatus mGCommonSelfDieStatus) {
                    rf.a.a1(this, iSudFSMStateHandle, str, mGCommonSelfDieStatus);
                }

                @Override // tech.sud.mgp.SudMGPWrapper.decorator.SudFSMMGListener
                public /* synthetic */ void onPlayerMGCommonSelfObStatus(ISudFSMStateHandle iSudFSMStateHandle, String str, SudMGPMGState.MGCommonSelfObStatus mGCommonSelfObStatus) {
                    rf.a.b1(this, iSudFSMStateHandle, str, mGCommonSelfObStatus);
                }

                @Override // tech.sud.mgp.SudMGPWrapper.decorator.SudFSMMGListener
                public /* synthetic */ void onPlayerMGCommonSelfSelectStatus(ISudFSMStateHandle iSudFSMStateHandle, String str, SudMGPMGState.MGCommonSelfSelectStatus mGCommonSelfSelectStatus) {
                    rf.a.c1(this, iSudFSMStateHandle, str, mGCommonSelfSelectStatus);
                }

                @Override // tech.sud.mgp.SudMGPWrapper.decorator.SudFSMMGListener
                public /* synthetic */ void onPlayerMGCommonSelfTurnStatus(ISudFSMStateHandle iSudFSMStateHandle, String str, SudMGPMGState.MGCommonSelfTurnStatus mGCommonSelfTurnStatus) {
                    rf.a.d1(this, iSudFSMStateHandle, str, mGCommonSelfTurnStatus);
                }

                @Override // tech.sud.mgp.SudMGPWrapper.decorator.SudFSMMGListener
                public /* synthetic */ void onPlayerMGDGErroranswer(ISudFSMStateHandle iSudFSMStateHandle, String str, SudMGPMGState.MGDGErroranswer mGDGErroranswer) {
                    rf.a.e1(this, iSudFSMStateHandle, str, mGDGErroranswer);
                }

                @Override // tech.sud.mgp.SudMGPWrapper.decorator.SudFSMMGListener
                public /* synthetic */ void onPlayerMGDGPainting(ISudFSMStateHandle iSudFSMStateHandle, String str, SudMGPMGState.MGDGPainting mGDGPainting) {
                    rf.a.f1(this, iSudFSMStateHandle, str, mGDGPainting);
                }

                @Override // tech.sud.mgp.SudMGPWrapper.decorator.SudFSMMGListener
                public /* synthetic */ void onPlayerMGDGScore(ISudFSMStateHandle iSudFSMStateHandle, String str, SudMGPMGState.MGDGScore mGDGScore) {
                    rf.a.g1(this, iSudFSMStateHandle, str, mGDGScore);
                }

                @Override // tech.sud.mgp.SudMGPWrapper.decorator.SudFSMMGListener
                public /* synthetic */ void onPlayerMGDGSelecting(ISudFSMStateHandle iSudFSMStateHandle, String str, SudMGPMGState.MGDGSelecting mGDGSelecting) {
                    rf.a.h1(this, iSudFSMStateHandle, str, mGDGSelecting);
                }

                @Override // tech.sud.mgp.SudMGPWrapper.decorator.SudFSMMGListener
                public /* synthetic */ void onPlayerMGDGTotalscore(ISudFSMStateHandle iSudFSMStateHandle, String str, SudMGPMGState.MGDGTotalscore mGDGTotalscore) {
                    rf.a.i1(this, iSudFSMStateHandle, str, mGDGTotalscore);
                }

                @Override // tech.sud.mgp.SudMGPWrapper.decorator.SudFSMMGListener
                public /* synthetic */ boolean onPlayerStateChange(ISudFSMStateHandle iSudFSMStateHandle, String str, String str2, String str3) {
                    return rf.a.j1(this, iSudFSMStateHandle, str, str2, str3);
                }
            });
            this.gameViewModel = gameViewModel;
            SudFSTAPPDecorator sudFSTAPPDecorator = gameViewModel.getSudFSTAPPDecorator();
            if (sudFSTAPPDecorator != null) {
                sudFSTAPPDecorator.setOnNotifyStateChangeListener(new SudFSTAPPDecorator.OnNotifyStateChangeListener() { // from class: com.qiahao.nextvideo.room.help.s7
                    @Override // tech.sud.mgp.SudMGPWrapper.decorator.SudFSTAPPDecorator.OnNotifyStateChangeListener
                    public final void onNotifyStateChange(String str, String str2) {
                        MatchGameHelp.initGameModel$lambda$9(MatchGameHelp.this, str, str2);
                    }
                });
            }
            GameViewModel gameViewModel2 = this.gameViewModel;
            if (gameViewModel2 != null && (gameViewLiveData = gameViewModel2.getGameViewLiveData()) != null) {
                gameViewLiveData.observe(this.fragment, new MatchGameHelp$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.room.help.t7
                    public final Object invoke(Object obj) {
                        Unit initGameModel$lambda$10;
                        initGameModel$lambda$10 = MatchGameHelp.initGameModel$lambda$10(MatchGameHelp.this, (View) obj);
                        return initGameModel$lambda$10;
                    }
                }));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initGameModel$lambda$10(MatchGameHelp matchGameHelp, View view) {
        FragmentGameRoomBinding binding;
        ViewRoomGameBinding viewRoomGameBinding;
        FrameLayout frameLayout;
        ViewRoomGameBinding viewRoomGameBinding2;
        FrameLayout frameLayout2;
        FragmentGameRoomBinding binding2 = matchGameHelp.fragment.getBinding();
        if (binding2 != null && (viewRoomGameBinding2 = binding2.gameLayout) != null && (frameLayout2 = viewRoomGameBinding2.gameView) != null) {
            frameLayout2.removeAllViews();
        }
        if (view != null && (binding = matchGameHelp.fragment.getBinding()) != null && (viewRoomGameBinding = binding.gameLayout) != null && (frameLayout = viewRoomGameBinding.gameView) != null) {
            frameLayout.addView(view, -1, -1);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initGameModel$lambda$9(MatchGameHelp matchGameHelp, String str, String str2) {
        ViewRoomGameBinding viewRoomGameBinding;
        ImageView imageView;
        Drawable drawable;
        ViewRoomGameBinding viewRoomGameBinding2;
        View root;
        Context context;
        int i;
        GameConfigModel gameConfigModel;
        int i2;
        if (Intrinsics.areEqual(str, SudMGPAPPState.APP_COMMON_OPEN_SOUND)) {
            SudMGPAPPState.APPCommonOpenSound aPPCommonOpenSound = (SudMGPAPPState.APPCommonOpenSound) BaseApplication.Companion.getGSON().j(str2, SudMGPAPPState.APPCommonOpenSound.class);
            GameViewModel gameViewModel = matchGameHelp.gameViewModel;
            if (gameViewModel != null && (gameConfigModel = gameViewModel.getGameConfigModel()) != null) {
                if (!aPPCommonOpenSound.isOpen) {
                    i2 = 0;
                } else {
                    i2 = 100;
                }
                gameConfigModel.gameSoundVolume = i2;
            }
            FragmentGameRoomBinding binding = matchGameHelp.fragment.getBinding();
            if (binding != null && (viewRoomGameBinding = binding.gameLayout) != null && (imageView = viewRoomGameBinding.sound) != null) {
                FragmentGameRoomBinding binding2 = matchGameHelp.fragment.getBinding();
                if (binding2 != null && (viewRoomGameBinding2 = binding2.gameLayout) != null && (root = viewRoomGameBinding2.getRoot()) != null && (context = root.getContext()) != null) {
                    if (!aPPCommonOpenSound.isOpen) {
                        i = R.drawable.uno_prepare_icon_sound_no;
                    } else {
                        i = R.drawable.uno_prepare_icon_sound;
                    }
                    drawable = androidx.core.content.a.getDrawable(context, i);
                } else {
                    drawable = null;
                }
                imageView.setImageDrawable(drawable);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initGameView() {
        Integer valueOf;
        ViewRoomGameBinding viewRoomGameBinding;
        final ImageView imageView;
        ViewRoomGameBinding viewRoomGameBinding2;
        final ImageView imageView2;
        SudFSTAPPDecorator sudFSTAPPDecorator;
        GameConfigModel gameConfigModel;
        ViewRoomGameBinding viewRoomGameBinding3;
        ImageView imageView3;
        ViewRoomGameBinding viewRoomGameBinding4;
        View root;
        Context context;
        int i;
        GameConfigModel gameConfigModel2;
        ViewRoomGameBinding viewRoomGameBinding5;
        TextView textView;
        GameConfigModel gameConfigModel3;
        ViewRoomGameBinding viewRoomGameBinding6;
        final ImageView imageView4;
        ViewRoomGameBinding viewRoomGameBinding7;
        ConstraintLayout constraintLayout;
        FragmentGameRoomBinding binding = this.fragment.getBinding();
        boolean z = false;
        if (binding != null && (viewRoomGameBinding7 = binding.gameLayout) != null && (constraintLayout = viewRoomGameBinding7.gameTitleLayout) != null) {
            constraintLayout.setVisibility(0);
        }
        FragmentGameRoomBinding binding2 = this.fragment.getBinding();
        final long j = 800;
        if (binding2 != null && (viewRoomGameBinding6 = binding2.gameLayout) != null && (imageView4 = viewRoomGameBinding6.add) != null) {
            imageView4.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.help.MatchGameHelp$initGameView$$inlined$singleClick$default$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(imageView4) > j || (imageView4 instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(imageView4, currentTimeMillis);
                        Context context2 = this.getFragment().getContext();
                        if (context2 != null) {
                            WalletActivity.INSTANCE.start(context2);
                        }
                    }
                }
            });
        }
        int i2 = this.showGameType;
        Drawable drawable = null;
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 10) {
                    if (i2 != 11) {
                        if (i2 != 18) {
                            if (i2 != 21) {
                                if (i2 != 23) {
                                    valueOf = 0;
                                } else {
                                    SUDGameData mBackgammonGameData = MeetingRoomManager.INSTANCE.getMBackgammonGameData();
                                    if (mBackgammonGameData != null) {
                                        valueOf = Integer.valueOf(mBackgammonGameData.getDiamond());
                                    }
                                    valueOf = null;
                                }
                            } else {
                                SUDGameData mJackaroGameData = MeetingRoomManager.INSTANCE.getMJackaroGameData();
                                if (mJackaroGameData != null) {
                                    valueOf = Integer.valueOf(mJackaroGameData.getDiamond());
                                }
                                valueOf = null;
                            }
                        } else {
                            SUDGameData mCarromGameData = MeetingRoomManager.INSTANCE.getMCarromGameData();
                            if (mCarromGameData != null) {
                                valueOf = Integer.valueOf(mCarromGameData.getDiamond());
                            }
                            valueOf = null;
                        }
                    } else {
                        SUDGameData mCrushGameData = MeetingRoomManager.INSTANCE.getMCrushGameData();
                        if (mCrushGameData != null) {
                            valueOf = Integer.valueOf(mCrushGameData.getDiamond());
                        }
                        valueOf = null;
                    }
                } else {
                    SUDGameData mDominoGameData = MeetingRoomManager.INSTANCE.getMDominoGameData();
                    if (mDominoGameData != null) {
                        valueOf = Integer.valueOf(mDominoGameData.getDiamond());
                    }
                    valueOf = null;
                }
            } else {
                SUDGameData mUnoGameData = MeetingRoomManager.INSTANCE.getMUnoGameData();
                if (mUnoGameData != null) {
                    valueOf = Integer.valueOf(mUnoGameData.getDiamond());
                }
                valueOf = null;
            }
        } else {
            SUDGameData mLudoGameData = MeetingRoomManager.INSTANCE.getMLudoGameData();
            if (mLudoGameData != null) {
                valueOf = Integer.valueOf(mLudoGameData.getDiamond());
            }
            valueOf = null;
        }
        GameViewModel gameViewModel = this.gameViewModel;
        if (gameViewModel != null && (gameConfigModel3 = gameViewModel.getGameConfigModel()) != null) {
            gameConfigModel3.gameSoundVolume = 100;
        }
        FragmentGameRoomBinding binding3 = this.fragment.getBinding();
        if (binding3 != null && (viewRoomGameBinding5 = binding3.gameLayout) != null && (textView = viewRoomGameBinding5.diamondText) != null) {
            textView.setText(String.valueOf(valueOf));
        }
        FragmentGameRoomBinding binding4 = this.fragment.getBinding();
        if (binding4 != null && (viewRoomGameBinding3 = binding4.gameLayout) != null && (imageView3 = viewRoomGameBinding3.sound) != null) {
            FragmentGameRoomBinding binding5 = this.fragment.getBinding();
            if (binding5 != null && (viewRoomGameBinding4 = binding5.gameLayout) != null && (root = viewRoomGameBinding4.getRoot()) != null && (context = root.getContext()) != null) {
                GameViewModel gameViewModel2 = this.gameViewModel;
                if (gameViewModel2 != null && (gameConfigModel2 = gameViewModel2.getGameConfigModel()) != null && gameConfigModel2.gameSoundVolume == 100) {
                    i = R.drawable.uno_prepare_icon_sound;
                } else {
                    i = R.drawable.uno_prepare_icon_sound_no;
                }
                drawable = androidx.core.content.a.getDrawable(context, i);
            }
            imageView3.setImageDrawable(drawable);
        }
        GameViewModel gameViewModel3 = this.gameViewModel;
        if (gameViewModel3 != null && (sudFSTAPPDecorator = gameViewModel3.getSudFSTAPPDecorator()) != null) {
            GameViewModel gameViewModel4 = this.gameViewModel;
            if (gameViewModel4 != null && (gameConfigModel = gameViewModel4.getGameConfigModel()) != null && gameConfigModel.gameSoundVolume == 100) {
                z = true;
            }
            sudFSTAPPDecorator.notifyAPPCommonOpenSound(z);
        }
        FragmentGameRoomBinding binding6 = this.fragment.getBinding();
        if (binding6 != null && (viewRoomGameBinding2 = binding6.gameLayout) != null && (imageView2 = viewRoomGameBinding2.sound) != null) {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.help.MatchGameHelp$initGameView$$inlined$singleClick$default$2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SudFSTAPPDecorator sudFSTAPPDecorator2;
                    GameConfigModel gameConfigModel4;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(imageView2) > j || (imageView2 instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(imageView2, currentTimeMillis);
                        GameViewModel gameViewModel5 = this.getGameViewModel();
                        boolean z2 = false;
                        if (gameViewModel5 != null && (gameConfigModel4 = gameViewModel5.getGameConfigModel()) != null && gameConfigModel4.gameSoundVolume == 100) {
                            z2 = true;
                        }
                        GameViewModel gameViewModel6 = this.getGameViewModel();
                        if (gameViewModel6 != null && (sudFSTAPPDecorator2 = gameViewModel6.getSudFSTAPPDecorator()) != null) {
                            sudFSTAPPDecorator2.notifyAPPCommonOpenSound(!z2);
                        }
                    }
                }
            });
        }
        FragmentGameRoomBinding binding7 = this.fragment.getBinding();
        if (binding7 != null && (viewRoomGameBinding = binding7.gameLayout) != null && (imageView = viewRoomGameBinding.information) != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.help.MatchGameHelp$initGameView$$inlined$singleClick$default$3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(imageView) > j || (imageView instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(imageView, currentTimeMillis);
                        FragmentActivity activity = this.getFragment().getActivity();
                        if (activity != null) {
                            int showGameType = this.getShowGameType();
                            if (showGameType != 1) {
                                if (showGameType != 2) {
                                    if (showGameType != 10) {
                                        if (showGameType != 11) {
                                            if (showGameType != 18) {
                                                if (showGameType != 21) {
                                                    if (showGameType == 23) {
                                                        new BackgammonIntroduceDialog(activity).show();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                new CarromIntroduceDialog(activity).show();
                                                return;
                                            }
                                            new CarromIntroduceDialog(activity).show();
                                            return;
                                        }
                                        new CrushIntroduceDialog(activity).show();
                                        return;
                                    }
                                    new DominoIntroduceDialog(activity).show();
                                    return;
                                }
                                new UnoIntroduceDialog(activity).show();
                                return;
                            }
                            new LudoIntroduceDialog(activity).show();
                        }
                    }
                }
            });
        }
    }

    private final void loadGame(final int gameType) {
        HiloUtils.INSTANCE.runInMainThread(new Runnable() { // from class: com.qiahao.nextvideo.room.help.k7
            @Override // java.lang.Runnable
            public final void run() {
                MatchGameHelp.loadGame$lambda$14(MatchGameHelp.this, gameType);
            }
        }, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void loadGame$lambda$14(MatchGameHelp matchGameHelp, int i) {
        GameViewModel gameViewModel;
        FragmentActivity activity = matchGameHelp.fragment.getActivity();
        if (activity != null) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 10) {
                        if (i != 11) {
                            if (i != 18) {
                                if (i != 21) {
                                    if (i == 23 && (gameViewModel = matchGameHelp.gameViewModel) != null) {
                                        gameViewModel.switchGame(activity, MeetingRoomManager.INSTANCE.getMGroupId(), 1925744787773059073L);
                                        return;
                                    }
                                    return;
                                }
                                GameViewModel gameViewModel2 = matchGameHelp.gameViewModel;
                                if (gameViewModel2 != null) {
                                    gameViewModel2.switchGame(activity, MeetingRoomManager.INSTANCE.getMGroupId(), 1848188045807976450L);
                                    return;
                                }
                                return;
                            }
                            GameViewModel gameViewModel3 = matchGameHelp.gameViewModel;
                            if (gameViewModel3 != null) {
                                gameViewModel3.switchGame(activity, MeetingRoomManager.INSTANCE.getMGroupId(), 1777154372100497410L);
                                return;
                            }
                            return;
                        }
                        GameViewModel gameViewModel4 = matchGameHelp.gameViewModel;
                        if (gameViewModel4 != null) {
                            gameViewModel4.switchGame(activity, MeetingRoomManager.INSTANCE.getMGroupId(), 1664525565526667266L);
                            return;
                        }
                        return;
                    }
                    GameViewModel gameViewModel5 = matchGameHelp.gameViewModel;
                    if (gameViewModel5 != null) {
                        gameViewModel5.switchGame(activity, MeetingRoomManager.INSTANCE.getMGroupId(), 1537330258004504578L);
                        return;
                    }
                    return;
                }
                GameViewModel gameViewModel6 = matchGameHelp.gameViewModel;
                if (gameViewModel6 != null) {
                    gameViewModel6.switchGame(activity, MeetingRoomManager.INSTANCE.getMGroupId(), 1472142559912517633L);
                    return;
                }
                return;
            }
            GameViewModel gameViewModel7 = matchGameHelp.gameViewModel;
            if (gameViewModel7 != null) {
                gameViewModel7.switchGame(activity, MeetingRoomManager.INSTANCE.getMGroupId(), 1468180338417074177L);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:113:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void setBg(boolean isShow, int gameType) {
        ImageView imageView;
        ImageView imageView2;
        int i;
        ImageView imageView3;
        boolean z;
        ImageView imageView4;
        boolean z2;
        int i2;
        ImageView imageView5;
        ImageView imageView6;
        ImageView imageView7;
        ImageView imageView8;
        ImageView imageView9;
        ImageView imageView10;
        FragmentGameRoomBinding binding;
        ImageView imageView11;
        int i3;
        ImageView imageView12;
        ImageView imageView13;
        String str;
        boolean z3;
        Integer valueOf = Integer.valueOf(R.drawable.bg_meeting_room1);
        String str2 = null;
        Drawable drawable = null;
        Drawable drawable2 = null;
        Drawable drawable3 = null;
        Drawable drawable4 = null;
        Drawable drawable5 = null;
        Drawable drawable6 = null;
        boolean z4 = false;
        if (isShow) {
            GroupDetailBean groupDetailBean = (GroupDetailBean) this.fragment.getMViewModel().getMGroupDetailBean().getValue();
            if (groupDetailBean != null) {
                Integer themeId = groupDetailBean.getThemeId();
                if (themeId != null) {
                    i3 = themeId.intValue();
                } else {
                    i3 = 0;
                }
                if (i3 > 0) {
                    String themeUrl = groupDetailBean.getThemeUrl();
                    if (themeUrl != null) {
                        if (themeUrl.length() > 0) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (z3) {
                            z4 = true;
                        }
                    }
                    if (z4) {
                        FragmentGameRoomBinding binding2 = this.fragment.getBinding();
                        if (binding2 != null && (imageView13 = binding2.defaultBackGround) != null) {
                            ImageUIModel.Companion companion = ImageUIModel.INSTANCE;
                            GroupDetailBean groupDetailBean2 = (GroupDetailBean) this.fragment.getMViewModel().getMGroupDetailBean().getValue();
                            if (groupDetailBean2 != null) {
                                str = groupDetailBean2.getThemeUrl();
                            } else {
                                str = null;
                            }
                            ViewUtilitiesKt.bind(imageView13, companion.roomBackGroupFull(str, R.drawable.bg_meeting_room1));
                        }
                    }
                }
                FragmentGameRoomBinding binding3 = this.fragment.getBinding();
                if (binding3 != null && (imageView12 = binding3.defaultBackGround) != null) {
                    i2 = 1;
                    ImageKtxKt.loadImage$default(imageView12, (String) null, (Uri) null, (File) null, valueOf, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
                    if (gameType == i2) {
                        if (gameType != 2) {
                            if (gameType != 10) {
                                if (gameType != 11) {
                                    if (gameType != 18) {
                                        if (gameType != 21) {
                                            if (gameType == 23 && (binding = this.fragment.getBinding()) != null && (imageView11 = binding.meetingRoomThemBackGroup) != null) {
                                                Context context = this.fragment.getContext();
                                                if (context != null) {
                                                    drawable = androidx.core.content.a.getDrawable(context, R.drawable.backgammon_room_bg);
                                                }
                                                imageView11.setImageDrawable(drawable);
                                                return;
                                            }
                                            return;
                                        }
                                        FragmentGameRoomBinding binding4 = this.fragment.getBinding();
                                        if (binding4 != null && (imageView10 = binding4.meetingRoomThemBackGroup) != null) {
                                            Context context2 = this.fragment.getContext();
                                            if (context2 != null) {
                                                drawable2 = androidx.core.content.a.getDrawable(context2, R.drawable.jackaro_room_bg);
                                            }
                                            imageView10.setImageDrawable(drawable2);
                                            return;
                                        }
                                        return;
                                    }
                                    FragmentGameRoomBinding binding5 = this.fragment.getBinding();
                                    if (binding5 != null && (imageView9 = binding5.meetingRoomThemBackGroup) != null) {
                                        Context context3 = this.fragment.getContext();
                                        if (context3 != null) {
                                            drawable3 = androidx.core.content.a.getDrawable(context3, R.drawable.carrom_room_bg);
                                        }
                                        imageView9.setImageDrawable(drawable3);
                                        return;
                                    }
                                    return;
                                }
                                FragmentGameRoomBinding binding6 = this.fragment.getBinding();
                                if (binding6 != null && (imageView8 = binding6.meetingRoomThemBackGroup) != null) {
                                    Context context4 = this.fragment.getContext();
                                    if (context4 != null) {
                                        drawable4 = androidx.core.content.a.getDrawable(context4, R.drawable.crush_room_bg);
                                    }
                                    imageView8.setImageDrawable(drawable4);
                                    return;
                                }
                                return;
                            }
                            FragmentGameRoomBinding binding7 = this.fragment.getBinding();
                            if (binding7 != null && (imageView7 = binding7.meetingRoomThemBackGroup) != null) {
                                Context context5 = this.fragment.getContext();
                                if (context5 != null) {
                                    drawable5 = androidx.core.content.a.getDrawable(context5, R.drawable.domino_room_bg);
                                }
                                imageView7.setImageDrawable(drawable5);
                                return;
                            }
                            return;
                        }
                        FragmentGameRoomBinding binding8 = this.fragment.getBinding();
                        if (binding8 != null && (imageView6 = binding8.meetingRoomThemBackGroup) != null) {
                            Context context6 = this.fragment.getContext();
                            if (context6 != null) {
                                drawable6 = androidx.core.content.a.getDrawable(context6, R.drawable.uno_room_bg);
                            }
                            imageView6.setImageDrawable(drawable6);
                            return;
                        }
                        return;
                    }
                    FragmentGameRoomBinding binding9 = this.fragment.getBinding();
                    if (binding9 != null && (imageView5 = binding9.meetingRoomThemBackGroup) != null) {
                        ImageKtxKt.loadImage$default(imageView5, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.ludo_room_bg), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
                        return;
                    }
                    return;
                }
            }
            i2 = 1;
            if (gameType == i2) {
            }
        } else {
            GroupDetailBean groupDetailBean3 = (GroupDetailBean) this.fragment.getMViewModel().getMGroupDetailBean().getValue();
            if (groupDetailBean3 != null) {
                Integer themeId2 = groupDetailBean3.getThemeId();
                if (themeId2 != null) {
                    i = themeId2.intValue();
                } else {
                    i = 0;
                }
                if (i > 0) {
                    String themeUrl2 = groupDetailBean3.getThemeUrl();
                    if (themeUrl2 != null) {
                        if (themeUrl2.length() > 0) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (z2) {
                            z = true;
                            if (z) {
                                FragmentGameRoomBinding binding10 = this.fragment.getBinding();
                                if (binding10 != null && (imageView4 = binding10.meetingRoomThemBackGroup) != null) {
                                    ImageUIModel.Companion companion2 = ImageUIModel.INSTANCE;
                                    GroupDetailBean groupDetailBean4 = (GroupDetailBean) this.fragment.getMViewModel().getMGroupDetailBean().getValue();
                                    if (groupDetailBean4 != null) {
                                        str2 = groupDetailBean4.getThemeUrl();
                                    }
                                    ViewUtilitiesKt.bind(imageView4, companion2.roomBackGroupFull(str2, R.drawable.bg_meeting_room1));
                                }
                            }
                        }
                    }
                    z = false;
                    if (z) {
                    }
                }
                FragmentGameRoomBinding binding11 = this.fragment.getBinding();
                if (binding11 != null && (imageView3 = binding11.meetingRoomThemBackGroup) != null) {
                    ImageKtxKt.loadImage$default(imageView3, (String) null, (Uri) null, (File) null, valueOf, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
                }
            }
            FragmentGameRoomBinding binding12 = this.fragment.getBinding();
            if (binding12 != null && (imageView2 = binding12.meetingRoomThemBackGroup) != null) {
                imageView2.setAlpha(1.0f);
            }
            FragmentGameRoomBinding binding13 = this.fragment.getBinding();
            if (binding13 != null && (imageView = binding13.defaultBackGround) != null) {
                ImageKtxKt.loadImage$default(imageView, (String) null, (Uri) null, (File) null, valueOf, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
            }
        }
    }

    private final void setGameHeight(int gameType) {
        View root;
        ViewGroup.LayoutParams layoutParams;
        ViewRoomGameBinding viewRoomGameBinding;
        FrameLayout frameLayout;
        ViewRoomGameBinding viewRoomGameBinding2;
        FrameLayout frameLayout2;
        View root2;
        View root3;
        View root4;
        View root5;
        View root6;
        View root7;
        int px = UiKtxKt.toPX(420);
        int i = 0;
        if (gameType != 1) {
            if (gameType != 2) {
                if (gameType != 10) {
                    if (gameType != 11) {
                        if (gameType != 18) {
                            if (gameType != 21) {
                                if (gameType == 23) {
                                    FragmentGameRoomBinding binding = this.fragment.getBinding();
                                    if (binding != null && (root7 = binding.getRoot()) != null) {
                                        i = root7.getWidth();
                                    }
                                    px = (i * 80) / 62;
                                }
                            } else {
                                FragmentGameRoomBinding binding2 = this.fragment.getBinding();
                                if (binding2 != null && (root6 = binding2.getRoot()) != null) {
                                    i = root6.getWidth();
                                }
                                px = (i * 80) / 62;
                            }
                        } else {
                            FragmentGameRoomBinding binding3 = this.fragment.getBinding();
                            if (binding3 != null && (root5 = binding3.getRoot()) != null) {
                                i = root5.getWidth();
                            }
                            px = (i * 80) / 62;
                        }
                    } else {
                        FragmentGameRoomBinding binding4 = this.fragment.getBinding();
                        if (binding4 != null && (root4 = binding4.getRoot()) != null) {
                            i = root4.getWidth();
                        }
                        px = (i * 80) / 70;
                    }
                } else {
                    FragmentGameRoomBinding binding5 = this.fragment.getBinding();
                    if (binding5 != null && (root3 = binding5.getRoot()) != null) {
                        i = root3.getWidth();
                    }
                    px = (i * 74) / 72;
                }
            } else {
                FragmentGameRoomBinding binding6 = this.fragment.getBinding();
                if (binding6 != null && (root2 = binding6.getRoot()) != null) {
                    i = root2.getWidth();
                }
                px = (i * 74) / 72;
            }
        } else {
            FragmentGameRoomBinding binding7 = this.fragment.getBinding();
            if (binding7 != null && (root = binding7.getRoot()) != null) {
                i = root.getWidth();
            }
            px = (i * 74) / 72;
        }
        FragmentGameRoomBinding binding8 = this.fragment.getBinding();
        if (binding8 != null && (viewRoomGameBinding2 = binding8.gameLayout) != null && (frameLayout2 = viewRoomGameBinding2.gameView) != null) {
            layoutParams = frameLayout2.getLayoutParams();
        } else {
            layoutParams = null;
        }
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.b bVar = (ConstraintLayout.b) layoutParams;
        ((ViewGroup.MarginLayoutParams) bVar).height = px;
        ((ViewGroup.MarginLayoutParams) bVar).width = -1;
        FragmentGameRoomBinding binding9 = this.fragment.getBinding();
        if (binding9 != null && (viewRoomGameBinding = binding9.gameLayout) != null && (frameLayout = viewRoomGameBinding.gameView) != null) {
            frameLayout.setLayoutParams(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showGameEnd$lambda$41$lambda$28$lambda$26(MatchGameHelp matchGameHelp, LudoEndDialog ludoEndDialog) {
        matchGameHelp.gameOneAgain(ludoEndDialog);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showGameEnd$lambda$41$lambda$28$lambda$27(MatchGameHelp matchGameHelp, DialogInterface dialogInterface) {
        matchGameHelp.fragment.exit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showGameEnd$lambda$41$lambda$31$lambda$29(MatchGameHelp matchGameHelp, UnoEndDialog unoEndDialog) {
        matchGameHelp.gameOneAgain(unoEndDialog);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showGameEnd$lambda$41$lambda$31$lambda$30(MatchGameHelp matchGameHelp, DialogInterface dialogInterface) {
        matchGameHelp.fragment.exit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showGameEnd$lambda$41$lambda$34$lambda$32(MatchGameHelp matchGameHelp, DominoEndDialog dominoEndDialog) {
        matchGameHelp.gameOneAgain(dominoEndDialog);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showGameEnd$lambda$41$lambda$34$lambda$33(MatchGameHelp matchGameHelp, DialogInterface dialogInterface) {
        matchGameHelp.fragment.exit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showGameEnd$lambda$41$lambda$37$lambda$35(MatchGameHelp matchGameHelp, CrushEndDialog crushEndDialog) {
        matchGameHelp.gameOneAgain(crushEndDialog);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showGameEnd$lambda$41$lambda$37$lambda$36(MatchGameHelp matchGameHelp, DialogInterface dialogInterface) {
        matchGameHelp.fragment.exit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showGameEnd$lambda$41$lambda$40$lambda$38(MatchGameHelp matchGameHelp, DefaultSUDEndDialog defaultSUDEndDialog) {
        matchGameHelp.gameOneAgain(defaultSUDEndDialog);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showGameEnd$lambda$41$lambda$40$lambda$39(MatchGameHelp matchGameHelp, DialogInterface dialogInterface) {
        matchGameHelp.fragment.exit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r2v10, types: [android.app.Dialog, com.qiahao.nextvideo.room.dialog.UserInfoCpDialog] */
    public static final Unit showUserInfoDialog$lambda$46$lambda$45(final FragmentActivity fragmentActivity, int i, final MatchGameHelp matchGameHelp, User user) {
        boolean z;
        boolean z2;
        Intrinsics.checkNotNullParameter(user, "it");
        if (fragmentActivity instanceof HiloBaseActivity) {
            HiloBaseActivity.dismissProgressDialog$default((HiloBaseActivity) fragmentActivity, false, null, 3, null);
        }
        SvipData svip = user.getSvip();
        if (svip != null && svip.isMystery()) {
            new MysteryDialog(fragmentActivity, user, i).setListener(new MysteryDialog.MysteryDialogListener() { // from class: com.qiahao.nextvideo.room.help.MatchGameHelp$showUserInfoDialog$1$1$1
                @Override // com.qiahao.nextvideo.room.dialog.MysteryDialog.MysteryDialogListener
                public void downMic(int micPosition) {
                    RoomViewModel.downMic$default(MatchGameHelp.this.getFragment().getMViewModel(), micPosition, false, 2, null);
                }

                @Override // com.qiahao.nextvideo.room.dialog.MysteryDialog.MysteryDialogListener
                public void muteMic(int micPosition, boolean isMyself) {
                    MatchGameHelp.this.getFragment().getMViewModel().muteMic(micPosition);
                }

                @Override // com.qiahao.nextvideo.room.dialog.MysteryDialog.MysteryDialogListener
                public void unMuteMic(int micPosition) {
                    MatchGameHelp.this.getFragment().getMViewModel().unMuteMic(micPosition);
                }
            }).show();
            return Unit.INSTANCE;
        }
        UserInfoListener userInfoListener = new UserInfoListener() { // from class: com.qiahao.nextvideo.room.help.MatchGameHelp$showUserInfoDialog$1$1$listener$1
            @Override // com.qiahao.nextvideo.room.interfaces.UserInfoListener
            public void callUser(String extraId, String userName) {
                GroupInputLayoutView groupInputLayoutView;
                GroupInputLayoutView groupInputLayoutView2;
                Intrinsics.checkNotNullParameter(extraId, "extraId");
                Intrinsics.checkNotNullParameter(userName, "userName");
                FragmentGameRoomBinding binding = MatchGameHelp.this.getFragment().getBinding();
                if (binding != null && (groupInputLayoutView2 = binding.groupInput) != null) {
                    groupInputLayoutView2.updateInputText(userName, extraId, true);
                }
                FragmentGameRoomBinding binding2 = MatchGameHelp.this.getFragment().getBinding();
                if (binding2 != null && (groupInputLayoutView = binding2.groupInput) != null) {
                    groupInputLayoutView.showSoftInput();
                }
                MatchGameHelp.this.getFragment().showSoftKeyBoard();
            }

            @Override // com.qiahao.nextvideo.room.interfaces.UserInfoListener
            public void downMic(int micPosition) {
                RoomViewModel.downMic$default(MatchGameHelp.this.getFragment().getMViewModel(), micPosition, false, 2, null);
            }

            @Override // com.qiahao.nextvideo.room.interfaces.UserInfoListener
            public void giftShow(String extraId, String userName) {
                Intrinsics.checkNotNullParameter(extraId, "extraId");
                Intrinsics.checkNotNullParameter(userName, "userName");
                GameRoomFragmentHelp mAudioHelp = MatchGameHelp.this.getFragment().getMAudioHelp();
                if (mAudioHelp != null) {
                    mAudioHelp.showSendGiftPanel(extraId, userName, false);
                }
            }

            @Override // com.qiahao.nextvideo.room.interfaces.UserInfoListener
            public void inviteUserUpMic(String userId) {
                Intrinsics.checkNotNullParameter(userId, TUIConstants.TUILive.USER_ID);
                MatchGameHelp.this.getFragment().getMViewModel().inviteUserUpMic(userId);
            }

            @Override // com.qiahao.nextvideo.room.interfaces.UserInfoListener
            public void kickDownMic(int micPosition) {
                MatchGameHelp.this.getFragment().getMViewModel().downMic(micPosition, true);
            }

            @Override // com.qiahao.nextvideo.room.interfaces.UserInfoListener
            public void muteMic(int micPosition, boolean isMyself) {
                MatchGameHelp.this.getFragment().getMViewModel().muteMic(micPosition);
            }

            @Override // com.qiahao.nextvideo.room.interfaces.UserInfoListener
            public void unMuteMic(int micPosition) {
                MatchGameHelp.this.getFragment().getMViewModel().unMuteMic(micPosition);
            }

            @Override // com.qiahao.nextvideo.room.interfaces.UserInfoListener
            public void videoRequesPermiss() {
                androidx.core.app.b.g(fragmentActivity, new String[]{"android.permission.CAMERA", "android.permission.RECORD_AUDIO"}, 102);
            }
        };
        MyCp cp = user.getCp();
        if (cp != null && cp.isDynamicCard()) {
            String mGroupId = matchGameHelp.fragment.getMViewModel().getMGroupId();
            GroupDetailBean groupDetailBean = (GroupDetailBean) matchGameHelp.fragment.getMViewModel().getMGroupDetailBean().getValue();
            if (groupDetailBean != null) {
                z2 = groupDetailBean.getMicOn();
            } else {
                z2 = true;
            }
            ?? userInfoCpDialog = new UserInfoCpDialog(fragmentActivity, user, i, mGroupId, z2);
            userInfoCpDialog.setUserInfoListener(userInfoListener);
            matchGameHelp.mUserInfoCpDialog = userInfoCpDialog;
            userInfoCpDialog.show();
            return Unit.INSTANCE;
        }
        String mGroupId2 = matchGameHelp.fragment.getMViewModel().getMGroupId();
        GroupDetailBean groupDetailBean2 = (GroupDetailBean) matchGameHelp.fragment.getMViewModel().getMGroupDetailBean().getValue();
        if (groupDetailBean2 != null) {
            z = groupDetailBean2.getMicOn();
        } else {
            z = true;
        }
        UserInfoBottomSheetDialog userInfoBottomSheetDialog = new UserInfoBottomSheetDialog(fragmentActivity, user, i, mGroupId2, z);
        userInfoBottomSheetDialog.setUserInfoListener(userInfoListener);
        matchGameHelp.mUserInfoBottomSheetDialog = userInfoBottomSheetDialog;
        userInfoBottomSheetDialog.show();
        return Unit.INSTANCE;
    }

    @Nullable
    public final AnimatorSet getChatAnimatorSetHide() {
        return this.chatAnimatorSetHide;
    }

    @Nullable
    public final AnimatorSet getChatAnimatorSetShow() {
        return this.chatAnimatorSetShow;
    }

    @NotNull
    public final GameRoomFragment getFragment() {
        return this.fragment;
    }

    @Nullable
    public final GameViewModel getGameViewModel() {
        return this.gameViewModel;
    }

    @Nullable
    public final UserInfoBottomSheetDialog getMUserInfoBottomSheetDialog() {
        return this.mUserInfoBottomSheetDialog;
    }

    @Nullable
    public final UserInfoCpDialog getMUserInfoCpDialog() {
        return this.mUserInfoCpDialog;
    }

    public final int getShowGameType() {
        return this.showGameType;
    }

    public final void hideGameChat() {
        FrameLayout frameLayout;
        AnimatorSet animatorSet;
        FragmentGameRoomBinding binding = this.fragment.getBinding();
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.chatAnimatorSetHide = animatorSet2;
        animatorSet2.setDuration(300L);
        if (binding != null && (frameLayout = binding.gameChatLayout) != null && (animatorSet = this.chatAnimatorSetHide) != null) {
            AnimationUtility animationUtility = AnimationUtility.INSTANCE;
            animatorSet.playTogether(animationUtility.translationY(frameLayout, 0, frameLayout.getHeight()), animationUtility.alpha(frameLayout, false));
        }
        AnimatorSet animatorSet3 = this.chatAnimatorSetHide;
        if (animatorSet3 != null) {
            animatorSet3.addListener(new Animator.AnimatorListener() { // from class: com.qiahao.nextvideo.room.help.MatchGameHelp$hideGameChat$1$2
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    ImageView imageView;
                    FrameLayout frameLayout2;
                    FrameLayout frameLayout3;
                    Intrinsics.checkNotNullParameter(animation, "animation");
                    FragmentGameRoomBinding binding2 = MatchGameHelp.this.getFragment().getBinding();
                    if (binding2 != null && (frameLayout3 = binding2.gameChatLayout) != null) {
                        frameLayout3.setVisibility(8);
                    }
                    FragmentGameRoomBinding binding3 = MatchGameHelp.this.getFragment().getBinding();
                    if (binding3 != null && (frameLayout2 = binding3.gameChatLayout) != null) {
                        frameLayout2.removeAllViews();
                    }
                    MatchGameHelp.this.getFragment().initChatLayout();
                    FragmentGameRoomBinding binding4 = MatchGameHelp.this.getFragment().getBinding();
                    if (binding4 != null && (imageView = binding4.showChat) != null) {
                        imageView.setVisibility(0);
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                }
            });
        }
        AnimatorSet animatorSet4 = this.chatAnimatorSetHide;
        if (animatorSet4 != null) {
            animatorSet4.start();
        }
    }

    public final boolean isPlayGame() {
        ViewRoomGameBinding viewRoomGameBinding;
        FrameLayout frameLayout;
        FragmentGameRoomBinding binding = this.fragment.getBinding();
        boolean z = false;
        if (binding != null && (viewRoomGameBinding = binding.gameLayout) != null && (frameLayout = viewRoomGameBinding.gameView) != null && frameLayout.getChildCount() == 0) {
            z = true;
        }
        return !z;
    }

    public final void notificationMicChange() {
        Integer num;
        GameMicAdapter gameMicAdapter;
        List data;
        List list;
        GameMicAdapter gameMicAdapter2;
        GameMicAdapter gameMicAdapter3;
        GameMicAdapter gameMicAdapter4;
        List data2;
        GameRoomFragmentHelp mAudioHelp = this.fragment.getMAudioHelp();
        if (mAudioHelp != null && (gameMicAdapter4 = mAudioHelp.getGameMicAdapter()) != null && (data2 = gameMicAdapter4.getData()) != null) {
            num = Integer.valueOf(data2.size());
        } else {
            num = null;
        }
        MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
        int micSize = meetingRoomManager.getMicSize(meetingRoomManager.getMCurrentRoomMicType());
        if (num != null && num.intValue() == micSize) {
            GameRoomFragmentHelp mAudioHelp2 = this.fragment.getMAudioHelp();
            if (mAudioHelp2 != null && (gameMicAdapter = mAudioHelp2.getGameMicAdapter()) != null && (data = gameMicAdapter.getData()) != null) {
                int i = 0;
                for (Object obj : data) {
                    int i2 = i + 1;
                    if (i < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    MicroBean microBean = (MicroBean) obj;
                    MicroBean microBean2 = (MicroBean) MeetingRoomManager.getMicQueue$default(MeetingRoomManager.INSTANCE, false, 1, null).get(Integer.valueOf(i2));
                    if (microBean2 == null) {
                        microBean2 = MicroBean.Companion.emptyMicroBean$default(MicroBean.INSTANCE, i, false, 2, null);
                    }
                    if (!microBean.checkDataIsEqual(microBean2)) {
                        GameRoomFragmentHelp mAudioHelp3 = this.fragment.getMAudioHelp();
                        if (mAudioHelp3 != null && (gameMicAdapter3 = mAudioHelp3.getGameMicAdapter()) != null) {
                            list = gameMicAdapter3.getData();
                        } else {
                            list = null;
                        }
                        Intrinsics.checkNotNull(list);
                        list.set(i, microBean2);
                        GameRoomFragmentHelp mAudioHelp4 = this.fragment.getMAudioHelp();
                        if (mAudioHelp4 != null && (gameMicAdapter2 = mAudioHelp4.getGameMicAdapter()) != null) {
                            gameMicAdapter2.notifyItemChanged(i, microBean2);
                        }
                    }
                    i = i2;
                }
                return;
            }
            return;
        }
        changeGameMicType();
    }

    public final void refreshPosition(int position) {
        int i;
        GameRoomFragmentHelp mAudioHelp;
        GameMicAdapter gameMicAdapter;
        MicroBean microBean;
        GameMicAdapter gameMicAdapter2;
        List data;
        GameMicAdapter gameMicAdapter3;
        List data2;
        GameRoomFragmentHelp mAudioHelp2 = this.fragment.getMAudioHelp();
        if (mAudioHelp2 != null && (gameMicAdapter3 = mAudioHelp2.getGameMicAdapter()) != null && (data2 = gameMicAdapter3.getData()) != null) {
            i = data2.size();
        } else {
            i = 0;
        }
        if (position < i && position >= 0 && (mAudioHelp = this.fragment.getMAudioHelp()) != null && (gameMicAdapter = mAudioHelp.getGameMicAdapter()) != null) {
            GameRoomFragmentHelp mAudioHelp3 = this.fragment.getMAudioHelp();
            if (mAudioHelp3 != null && (gameMicAdapter2 = mAudioHelp3.getGameMicAdapter()) != null && (data = gameMicAdapter2.getData()) != null) {
                microBean = (MicroBean) data.get(position);
            } else {
                microBean = null;
            }
            gameMicAdapter.notifyItemChanged(position, microBean);
        }
    }

    public final void releaseAnimation() {
        AnimatorSet animatorSet = this.chatAnimatorSetShow;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        AnimatorSet animatorSet2 = this.chatAnimatorSetShow;
        if (animatorSet2 != null) {
            animatorSet2.removeAllListeners();
        }
        AnimatorSet animatorSet3 = this.chatAnimatorSetHide;
        if (animatorSet3 != null) {
            animatorSet3.cancel();
        }
        AnimatorSet animatorSet4 = this.chatAnimatorSetHide;
        if (animatorSet4 != null) {
            animatorSet4.removeAllListeners();
        }
    }

    public final void releaseGame() {
        String gameCode;
        ViewRoomGameBinding viewRoomGameBinding;
        FrameLayout frameLayout;
        String gameCode2;
        String gameCode3;
        String gameCode4;
        String gameCode5;
        String gameCode6;
        SUDGameData mBackgammonGameData;
        String gameCode7;
        int i = this.showGameType;
        String str = "";
        if (i != 1) {
            if (i != 2) {
                if (i != 10) {
                    if (i != 11) {
                        if (i != 18) {
                            if (i != 21) {
                                if (i == 23 && (mBackgammonGameData = MeetingRoomManager.INSTANCE.getMBackgammonGameData()) != null) {
                                    AppRequestUtils appRequestUtils = AppRequestUtils.INSTANCE;
                                    long gameId = mBackgammonGameData.getGameId();
                                    GameViewModel gameViewModel = this.gameViewModel;
                                    if (gameViewModel != null && (gameCode7 = gameViewModel.getGameCode()) != null) {
                                        str = gameCode7;
                                    }
                                    appRequestUtils.sudGameEnd(gameId, 2, str);
                                }
                            } else {
                                SUDGameData mJackaroGameData = MeetingRoomManager.INSTANCE.getMJackaroGameData();
                                if (mJackaroGameData != null) {
                                    AppRequestUtils appRequestUtils2 = AppRequestUtils.INSTANCE;
                                    long gameId2 = mJackaroGameData.getGameId();
                                    GameViewModel gameViewModel2 = this.gameViewModel;
                                    if (gameViewModel2 != null && (gameCode6 = gameViewModel2.getGameCode()) != null) {
                                        str = gameCode6;
                                    }
                                    appRequestUtils2.sudGameEnd(gameId2, 2, str);
                                }
                            }
                        } else {
                            SUDGameData mCarromGameData = MeetingRoomManager.INSTANCE.getMCarromGameData();
                            if (mCarromGameData != null) {
                                AppRequestUtils appRequestUtils3 = AppRequestUtils.INSTANCE;
                                long gameId3 = mCarromGameData.getGameId();
                                GameViewModel gameViewModel3 = this.gameViewModel;
                                if (gameViewModel3 != null && (gameCode5 = gameViewModel3.getGameCode()) != null) {
                                    str = gameCode5;
                                }
                                appRequestUtils3.sudGameEnd(gameId3, 2, str);
                            }
                        }
                    } else {
                        SUDGameData mCrushGameData = MeetingRoomManager.INSTANCE.getMCrushGameData();
                        if (mCrushGameData != null) {
                            AppRequestUtils appRequestUtils4 = AppRequestUtils.INSTANCE;
                            long gameId4 = mCrushGameData.getGameId();
                            GameViewModel gameViewModel4 = this.gameViewModel;
                            if (gameViewModel4 != null && (gameCode4 = gameViewModel4.getGameCode()) != null) {
                                str = gameCode4;
                            }
                            appRequestUtils4.sudGameEnd(gameId4, 2, str);
                        }
                    }
                } else {
                    SUDGameData mDominoGameData = MeetingRoomManager.INSTANCE.getMDominoGameData();
                    if (mDominoGameData != null) {
                        AppRequestUtils appRequestUtils5 = AppRequestUtils.INSTANCE;
                        long gameId5 = mDominoGameData.getGameId();
                        GameViewModel gameViewModel5 = this.gameViewModel;
                        if (gameViewModel5 != null && (gameCode3 = gameViewModel5.getGameCode()) != null) {
                            str = gameCode3;
                        }
                        appRequestUtils5.sudGameEnd(gameId5, 2, str);
                    }
                }
            } else {
                SUDGameData mUnoGameData = MeetingRoomManager.INSTANCE.getMUnoGameData();
                if (mUnoGameData != null) {
                    AppRequestUtils appRequestUtils6 = AppRequestUtils.INSTANCE;
                    long gameId6 = mUnoGameData.getGameId();
                    GameViewModel gameViewModel6 = this.gameViewModel;
                    if (gameViewModel6 != null && (gameCode2 = gameViewModel6.getGameCode()) != null) {
                        str = gameCode2;
                    }
                    appRequestUtils6.sudGameEnd(gameId6, 2, str);
                }
            }
        } else {
            SUDGameData mLudoGameData = MeetingRoomManager.INSTANCE.getMLudoGameData();
            if (mLudoGameData != null) {
                AppRequestUtils appRequestUtils7 = AppRequestUtils.INSTANCE;
                long gameId7 = mLudoGameData.getGameId();
                GameViewModel gameViewModel7 = this.gameViewModel;
                if (gameViewModel7 != null && (gameCode = gameViewModel7.getGameCode()) != null) {
                    str = gameCode;
                }
                appRequestUtils7.sudGameEnd(gameId7, 2, str);
            }
        }
        UserInfoBottomSheetDialog userInfoBottomSheetDialog = this.mUserInfoBottomSheetDialog;
        if (userInfoBottomSheetDialog != null) {
            userInfoBottomSheetDialog.dismiss();
        }
        this.mUserInfoBottomSheetDialog = null;
        UserInfoCpDialog userInfoCpDialog = this.mUserInfoCpDialog;
        if (userInfoCpDialog != null) {
            userInfoCpDialog.dismiss();
        }
        this.mUserInfoCpDialog = null;
        GameViewModel gameViewModel8 = this.gameViewModel;
        if (gameViewModel8 != null) {
            gameViewModel8.release();
        }
        GameViewModel gameViewModel9 = this.gameViewModel;
        if (gameViewModel9 != null) {
            gameViewModel9.setGameListener(null);
        }
        this.gameViewModel = null;
        FragmentGameRoomBinding binding = this.fragment.getBinding();
        if (binding != null && (viewRoomGameBinding = binding.gameLayout) != null && (frameLayout = viewRoomGameBinding.gameView) != null) {
            frameLayout.removeAllViews();
        }
    }

    public final void setChatAnimatorSetHide(@Nullable AnimatorSet animatorSet) {
        this.chatAnimatorSetHide = animatorSet;
    }

    public final void setChatAnimatorSetShow(@Nullable AnimatorSet animatorSet) {
        this.chatAnimatorSetShow = animatorSet;
    }

    public final void setGameViewModel(@Nullable GameViewModel gameViewModel) {
        this.gameViewModel = gameViewModel;
    }

    public final void setMUserInfoBottomSheetDialog(@Nullable UserInfoBottomSheetDialog userInfoBottomSheetDialog) {
        this.mUserInfoBottomSheetDialog = userInfoBottomSheetDialog;
    }

    public final void setMUserInfoCpDialog(@Nullable UserInfoCpDialog userInfoCpDialog) {
        this.mUserInfoCpDialog = userInfoCpDialog;
    }

    public final void setShowGameType(int i) {
        this.showGameType = i;
    }

    public final void showFace(int position, @NotNull String url) {
        int i;
        GameRoomFragmentHelp mAudioHelp;
        GameMicAdapter gameMicAdapter;
        GameMicAdapter gameMicAdapter2;
        List data;
        Intrinsics.checkNotNullParameter(url, "url");
        GameRoomFragmentHelp mAudioHelp2 = this.fragment.getMAudioHelp();
        if (mAudioHelp2 != null && (gameMicAdapter2 = mAudioHelp2.getGameMicAdapter()) != null && (data = gameMicAdapter2.getData()) != null) {
            i = data.size();
        } else {
            i = 0;
        }
        if (position < i && position >= 0 && (mAudioHelp = this.fragment.getMAudioHelp()) != null && (gameMicAdapter = mAudioHelp.getGameMicAdapter()) != null) {
            gameMicAdapter.notifyItemChanged(position, url);
        }
    }

    public final void showGameChat() {
        FrameLayout frameLayout;
        AnimatorSet animatorSet;
        FragmentGameRoomBinding binding = this.fragment.getBinding();
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.chatAnimatorSetShow = animatorSet2;
        animatorSet2.setDuration(300L);
        if (binding != null && (frameLayout = binding.gameChatLayout) != null && (animatorSet = this.chatAnimatorSetShow) != null) {
            AnimationUtility animationUtility = AnimationUtility.INSTANCE;
            ObjectAnimator translationY = animationUtility.translationY(frameLayout, frameLayout.getHeight(), 0);
            FrameLayout frameLayout2 = binding.gameChatLayout;
            Intrinsics.checkNotNullExpressionValue(frameLayout2, "gameChatLayout");
            animatorSet.playTogether(translationY, animationUtility.alpha(frameLayout2, true));
        }
        AnimatorSet animatorSet3 = this.chatAnimatorSetShow;
        if (animatorSet3 != null) {
            animatorSet3.addListener(new Animator.AnimatorListener() { // from class: com.qiahao.nextvideo.room.help.MatchGameHelp$showGameChat$1$2
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animation) {
                    FrameLayout frameLayout3;
                    ImageView imageView;
                    Intrinsics.checkNotNullParameter(animation, "animation");
                    FragmentGameRoomBinding binding2 = MatchGameHelp.this.getFragment().getBinding();
                    if (binding2 != null && (imageView = binding2.showChat) != null) {
                        imageView.setVisibility(8);
                    }
                    FragmentGameRoomBinding binding3 = MatchGameHelp.this.getFragment().getBinding();
                    if (binding3 != null && (frameLayout3 = binding3.gameChatLayout) != null) {
                        frameLayout3.setVisibility(0);
                    }
                }
            });
        }
        AnimatorSet animatorSet4 = this.chatAnimatorSetShow;
        if (animatorSet4 != null) {
            animatorSet4.start();
        }
    }

    /* JADX WARN: Type inference failed for: r4v2, types: [android.app.Dialog, com.qiahao.nextvideo.room.game.DefaultSUDEndDialog] */
    /* JADX WARN: Type inference failed for: r4v3, types: [android.app.Dialog, com.qiahao.nextvideo.room.game.CrushEndDialog] */
    /* JADX WARN: Type inference failed for: r4v4, types: [android.app.Dialog, com.qiahao.nextvideo.room.game.DominoEndDialog] */
    /* JADX WARN: Type inference failed for: r4v5, types: [com.qiahao.nextvideo.room.game.UnoEndDialog, android.app.Dialog] */
    /* JADX WARN: Type inference failed for: r4v6, types: [com.qiahao.nextvideo.room.game.LudoEndDialog, android.app.Dialog] */
    public final void showGameEnd(int gameType, @Nullable Object data) {
        FragmentActivity activity = this.fragment.getActivity();
        if (activity != null) {
            if (gameType == 1 && (data instanceof SUDGameAward)) {
                final ?? ludoEndDialog = new LudoEndDialog(activity, (SUDGameAward) data, true);
                ludoEndDialog.setListener(new Function0() { // from class: com.qiahao.nextvideo.room.help.u7
                    public final Object invoke() {
                        Unit showGameEnd$lambda$41$lambda$28$lambda$26;
                        showGameEnd$lambda$41$lambda$28$lambda$26 = MatchGameHelp.showGameEnd$lambda$41$lambda$28$lambda$26(MatchGameHelp.this, ludoEndDialog);
                        return showGameEnd$lambda$41$lambda$28$lambda$26;
                    }
                });
                ludoEndDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.qiahao.nextvideo.room.help.v7
                    @Override // android.content.DialogInterface.OnDismissListener
                    public final void onDismiss(DialogInterface dialogInterface) {
                        MatchGameHelp.showGameEnd$lambda$41$lambda$28$lambda$27(MatchGameHelp.this, dialogInterface);
                    }
                });
                ludoEndDialog.show();
                return;
            }
            if (gameType == 2 && (data instanceof SUDGameAward)) {
                final ?? unoEndDialog = new UnoEndDialog(activity, (SUDGameAward) data, true);
                unoEndDialog.setListener(new Function0() { // from class: com.qiahao.nextvideo.room.help.w7
                    public final Object invoke() {
                        Unit showGameEnd$lambda$41$lambda$31$lambda$29;
                        showGameEnd$lambda$41$lambda$31$lambda$29 = MatchGameHelp.showGameEnd$lambda$41$lambda$31$lambda$29(MatchGameHelp.this, unoEndDialog);
                        return showGameEnd$lambda$41$lambda$31$lambda$29;
                    }
                });
                unoEndDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.qiahao.nextvideo.room.help.x7
                    @Override // android.content.DialogInterface.OnDismissListener
                    public final void onDismiss(DialogInterface dialogInterface) {
                        MatchGameHelp.showGameEnd$lambda$41$lambda$31$lambda$30(MatchGameHelp.this, dialogInterface);
                    }
                });
                unoEndDialog.show();
                return;
            }
            if (gameType == 10 && (data instanceof SUDGameAward)) {
                final ?? dominoEndDialog = new DominoEndDialog(activity, (SUDGameAward) data, true);
                dominoEndDialog.setListener(new Function0() { // from class: com.qiahao.nextvideo.room.help.y7
                    public final Object invoke() {
                        Unit showGameEnd$lambda$41$lambda$34$lambda$32;
                        showGameEnd$lambda$41$lambda$34$lambda$32 = MatchGameHelp.showGameEnd$lambda$41$lambda$34$lambda$32(MatchGameHelp.this, dominoEndDialog);
                        return showGameEnd$lambda$41$lambda$34$lambda$32;
                    }
                });
                dominoEndDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.qiahao.nextvideo.room.help.z7
                    @Override // android.content.DialogInterface.OnDismissListener
                    public final void onDismiss(DialogInterface dialogInterface) {
                        MatchGameHelp.showGameEnd$lambda$41$lambda$34$lambda$33(MatchGameHelp.this, dialogInterface);
                    }
                });
                dominoEndDialog.show();
                return;
            }
            if (gameType == 11 && (data instanceof SUDGameAward)) {
                final ?? crushEndDialog = new CrushEndDialog(activity, (SUDGameAward) data, true);
                crushEndDialog.setListener(new Function0() { // from class: com.qiahao.nextvideo.room.help.l7
                    public final Object invoke() {
                        Unit showGameEnd$lambda$41$lambda$37$lambda$35;
                        showGameEnd$lambda$41$lambda$37$lambda$35 = MatchGameHelp.showGameEnd$lambda$41$lambda$37$lambda$35(MatchGameHelp.this, crushEndDialog);
                        return showGameEnd$lambda$41$lambda$37$lambda$35;
                    }
                });
                crushEndDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.qiahao.nextvideo.room.help.m7
                    @Override // android.content.DialogInterface.OnDismissListener
                    public final void onDismiss(DialogInterface dialogInterface) {
                        MatchGameHelp.showGameEnd$lambda$41$lambda$37$lambda$36(MatchGameHelp.this, dialogInterface);
                    }
                });
                crushEndDialog.show();
                return;
            }
            if ((gameType == 18 || gameType == 14 || gameType == 21 || gameType == 23) && (data instanceof SUDGameAward)) {
                final ?? defaultSUDEndDialog = new DefaultSUDEndDialog(activity, (SUDGameAward) data, true);
                defaultSUDEndDialog.setListener(new Function0() { // from class: com.qiahao.nextvideo.room.help.n7
                    public final Object invoke() {
                        Unit showGameEnd$lambda$41$lambda$40$lambda$38;
                        showGameEnd$lambda$41$lambda$40$lambda$38 = MatchGameHelp.showGameEnd$lambda$41$lambda$40$lambda$38(MatchGameHelp.this, defaultSUDEndDialog);
                        return showGameEnd$lambda$41$lambda$40$lambda$38;
                    }
                });
                defaultSUDEndDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.qiahao.nextvideo.room.help.o7
                    @Override // android.content.DialogInterface.OnDismissListener
                    public final void onDismiss(DialogInterface dialogInterface) {
                        MatchGameHelp.showGameEnd$lambda$41$lambda$40$lambda$39(MatchGameHelp.this, dialogInterface);
                    }
                });
                defaultSUDEndDialog.show();
            }
        }
    }

    public final void showGameView(int gameType) {
        if (!canShowGame(gameType)) {
            return;
        }
        this.showGameType = gameType;
        initGameModel();
        initGameIcon();
        initGameView();
        setGameHeight(this.showGameType);
        loadGame(this.showGameType);
        setBg(true, this.showGameType);
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [android.app.Dialog, com.qiahao.nextvideo.room.dialog.MicOperateBottomDialog] */
    public final void showMicOperateBottomDialog(int position, @Nullable MicroBean micBean, boolean showLockLayout) {
        String str;
        FragmentActivity activity;
        MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
        User user = UserStore.INSTANCE.getShared().getUser();
        if (user == null || (str = user.getExternalId()) == null) {
            str = "";
        }
        int roomUserRole = meetingRoomManager.getRoomUserRole(str);
        boolean z = true;
        if (roomUserRole > 1 && (activity = this.fragment.getActivity()) != null) {
            if (micBean == null || micBean.getMicForbid()) {
                z = false;
            }
            ?? micOperateBottomDialog = new MicOperateBottomDialog(activity, showLockLayout, z);
            micOperateBottomDialog.setMicOperateListener(new MatchGameHelp$showMicOperateBottomDialog$1$1$1(this, position, micBean));
            micOperateBottomDialog.show();
        }
    }

    public final void showMicSpeakWaveAnim(@NotNull List<Integer> list) {
        int i;
        List list2;
        GameRoomFragmentHelp mAudioHelp;
        GameMicAdapter gameMicAdapter;
        GameMicAdapter gameMicAdapter2;
        GameMicAdapter gameMicAdapter3;
        List data;
        Intrinsics.checkNotNullParameter(list, "list");
        GameRoomFragmentHelp mAudioHelp2 = this.fragment.getMAudioHelp();
        if (mAudioHelp2 != null && (gameMicAdapter3 = mAudioHelp2.getGameMicAdapter()) != null && (data = gameMicAdapter3.getData()) != null) {
            i = data.size();
        } else {
            i = 0;
        }
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            int intValue = list.get(i2).intValue() - 1;
            if (intValue < i && intValue >= 0) {
                GameRoomFragmentHelp mAudioHelp3 = this.fragment.getMAudioHelp();
                if (mAudioHelp3 != null && (gameMicAdapter2 = mAudioHelp3.getGameMicAdapter()) != null) {
                    list2 = gameMicAdapter2.getData();
                } else {
                    list2 = null;
                }
                Intrinsics.checkNotNull(list2);
                if (((MicroBean) list2.get(intValue)).getUser() != null && (mAudioHelp = this.fragment.getMAudioHelp()) != null && (gameMicAdapter = mAudioHelp.getGameMicAdapter()) != null) {
                    gameMicAdapter.notifyItemChanged(intValue, GameMicAdapter.PLAY_MIC_SPEAK);
                }
            }
        }
    }

    public final void showUserInfoDialog(@NotNull String extraId, final int micPosition) {
        Intrinsics.checkNotNullParameter(extraId, "extraId");
        final FragmentActivity activity = this.fragment.getActivity();
        if (activity != null && !activity.isFinishing() && !activity.isDestroyed()) {
            if (activity instanceof HiloBaseActivity) {
                HiloBaseActivity.showProgressDialog$default((HiloBaseActivity) activity, (String) null, false, (Function0) null, 7, (Object) null);
            }
            getUserInfoByExtraId(extraId, new Function1() { // from class: com.qiahao.nextvideo.room.help.r7
                public final Object invoke(Object obj) {
                    Unit showUserInfoDialog$lambda$46$lambda$45;
                    showUserInfoDialog$lambda$46$lambda$45 = MatchGameHelp.showUserInfoDialog$lambda$46$lambda$45(activity, micPosition, this, (User) obj);
                    return showUserInfoDialog$lambda$46$lambda$45;
                }
            });
        }
    }
}
