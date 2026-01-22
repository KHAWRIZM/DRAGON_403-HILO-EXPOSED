package com.qiahao.nextvideo.room.help;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import com.oudi.utils.SpannableTextBuilder;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.oudi.utils.log.LogUtil;
import com.qiahao.base_common.BaseApplication;
import com.qiahao.base_common.interfaceing.OnCommonDialogListener;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.network.interceptors.HiloException;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.UserObjectEvent;
import com.qiahao.nextvideo.data.UserObjectEventType;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.game.CreateSudData;
import com.qiahao.nextvideo.data.game.GameConfig;
import com.qiahao.nextvideo.data.game.GameConfigLudo;
import com.qiahao.nextvideo.data.game.SUDGameAward;
import com.qiahao.nextvideo.data.game.SUDGameData;
import com.qiahao.nextvideo.data.game.SUDPlayerData;
import com.qiahao.nextvideo.data.model.GroupDetailBean;
import com.qiahao.nextvideo.databinding.FragmentAudioRoomBinding;
import com.qiahao.nextvideo.databinding.IncludeLudoItemBinding;
import com.qiahao.nextvideo.databinding.ViewGameLudoBinding;
import com.qiahao.nextvideo.room.dialog.RoomTipDialog;
import com.qiahao.nextvideo.room.fragment.AudioRoomFragment;
import com.qiahao.nextvideo.room.game.CreateLudoDialog;
import com.qiahao.nextvideo.room.game.LudoEndDialog;
import com.qiahao.nextvideo.room.game.LudoIntroduceDialog;
import com.qiahao.nextvideo.room.manager.MeetingRoomManager;
import com.qiahao.nextvideo.room.viewmodel.RoomViewModel;
import com.qiahao.nextvideo.sud.GameViewModel;
import com.qiahao.nextvideo.ui.wallet.WalletActivity;
import com.qiahao.nextvideo.utilities.AppRequestUtils;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.android.agoo.message.MessageService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tech.sud.gip.core.ISudFSMStateHandle;
import tech.sud.mgp.SudMGPWrapper.decorator.SudFSMMGListener;
import tech.sud.mgp.SudMGPWrapper.decorator.SudFSTAPPDecorator;
import tech.sud.mgp.SudMGPWrapper.model.GameConfigModel;
import tech.sud.mgp.SudMGPWrapper.state.SudMGPAPPState;
import tech.sud.mgp.SudMGPWrapper.state.SudMGPMGState;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010)\u001a\u00020*H\u0002J\b\u0010+\u001a\u0004\u0018\u00010,J\u0010\u0010-\u001a\u00020\t2\u0006\u0010.\u001a\u00020/H\u0002J\u0006\u00100\u001a\u00020*J\u0006\u00101\u001a\u000202J\b\u00103\u001a\u00020*H\u0002J\u0006\u00104\u001a\u00020*J\u0019\u00105\u001a\u00020*2\n\b\u0002\u00106\u001a\u0004\u0018\u000102H\u0002¢\u0006\u0002\u00107J\u001c\u00108\u001a\u00020*2\u0006\u00109\u001a\u00020:2\n\b\u0002\u0010;\u001a\u0004\u0018\u00010<H\u0002J\u000e\u0010=\u001a\u00020*2\u0006\u0010>\u001a\u00020?J\u0010\u0010@\u001a\u00020*2\b\b\u0002\u0010A\u001a\u000202R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010#\u001a\u0004\u0018\u00010$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u0006B"}, d2 = {"Lcom/qiahao/nextvideo/room/help/LudoGameHelp;", "", "fragment", "Lcom/qiahao/nextvideo/room/fragment/AudioRoomFragment;", "<init>", "(Lcom/qiahao/nextvideo/room/fragment/AudioRoomFragment;)V", "getFragment", "()Lcom/qiahao/nextvideo/room/fragment/AudioRoomFragment;", "mLudoBinding", "Lcom/qiahao/nextvideo/databinding/ViewGameLudoBinding;", "getMLudoBinding", "()Lcom/qiahao/nextvideo/databinding/ViewGameLudoBinding;", "setMLudoBinding", "(Lcom/qiahao/nextvideo/databinding/ViewGameLudoBinding;)V", "mLudoEndDialog", "Lcom/qiahao/nextvideo/room/game/LudoEndDialog;", "getMLudoEndDialog", "()Lcom/qiahao/nextvideo/room/game/LudoEndDialog;", "setMLudoEndDialog", "(Lcom/qiahao/nextvideo/room/game/LudoEndDialog;)V", "localGameStore", "", "getLocalGameStore", "()I", "setLocalGameStore", "(I)V", "gameProgress", "getGameProgress", "setGameProgress", "timerTask", "Landroid/os/CountDownTimer;", "getTimerTask", "()Landroid/os/CountDownTimer;", "setTimerTask", "(Landroid/os/CountDownTimer;)V", "gameViewModel", "Lcom/qiahao/nextvideo/sud/GameViewModel;", "getGameViewModel", "()Lcom/qiahao/nextvideo/sud/GameViewModel;", "setGameViewModel", "(Lcom/qiahao/nextvideo/sud/GameViewModel;)V", "createViewMode", "", "addLudoGameView", "Landroid/view/View;", "createLudoView", "context", "Landroid/content/Context;", "refreshGameData", "checkMyIsJoin", "", "startCountDown", "playerJoin", "exitGame", "isOwn", "(Ljava/lang/Boolean;)V", "refreshUser", "binding", "Lcom/qiahao/nextvideo/databinding/IncludeLudoItemBinding;", "playerData", "Lcom/qiahao/nextvideo/data/game/SUDPlayerData;", "showGameEndDialog", "ludoGameAward", "Lcom/qiahao/nextvideo/data/game/SUDGameAward;", "releaseGame", "callReport", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nLudoGameHelp.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LudoGameHelp.kt\ncom/qiahao/nextvideo/room/help/LudoGameHelp\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,626:1\n61#2,9:627\n61#2,9:636\n61#2,9:645\n61#2,9:654\n61#2,9:663\n61#2,9:672\n61#2,9:681\n1869#3,2:690\n*S KotlinDebug\n*F\n+ 1 LudoGameHelp.kt\ncom/qiahao/nextvideo/room/help/LudoGameHelp\n*L\n318#1:627,9\n325#1:636,9\n350#1:645,9\n355#1:654,9\n361#1:663,9\n411#1:672,9\n412#1:681,9\n437#1:690,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class LudoGameHelp {

    @NotNull
    private final AudioRoomFragment fragment;
    private int gameProgress;

    @Nullable
    private GameViewModel gameViewModel;
    private int localGameStore;

    @Nullable
    private ViewGameLudoBinding mLudoBinding;

    @Nullable
    private LudoEndDialog mLudoEndDialog;

    @Nullable
    private CountDownTimer timerTask;

    public LudoGameHelp(@NotNull AudioRoomFragment audioRoomFragment) {
        Intrinsics.checkNotNullParameter(audioRoomFragment, "fragment");
        this.fragment = audioRoomFragment;
        nd.c subscribe = UserStore.INSTANCE.getShared().getUserObjectRelay().observeOn(RxUtilsKt.getMainThread()).subscribeOn(RxUtilsKt.getMainThread()).subscribe(new pd.g() { // from class: com.qiahao.nextvideo.room.help.LudoGameHelp.1
            public final void accept(UserObjectEvent userObjectEvent) {
                SUDGameData mLudoGameData;
                TextView textView;
                ViewGameLudoBinding mLudoBinding;
                TextView textView2;
                if (userObjectEvent != null) {
                    LudoGameHelp ludoGameHelp = LudoGameHelp.this;
                    if (userObjectEvent.getType() != UserObjectEventType.REFRESH_MONEY || (mLudoGameData = MeetingRoomManager.INSTANCE.getMLudoGameData()) == null) {
                        return;
                    }
                    if (mLudoGameData.getStatus() != 0 && mLudoGameData.getStatus() != 2) {
                        if (mLudoGameData.getStatus() != 1 || (mLudoBinding = ludoGameHelp.getMLudoBinding()) == null || (textView2 = mLudoBinding.diamondText) == null) {
                            return;
                        }
                        textView2.setText(String.valueOf(mLudoGameData.getDiamond()));
                        return;
                    }
                    ViewGameLudoBinding mLudoBinding2 = ludoGameHelp.getMLudoBinding();
                    if (mLudoBinding2 == null || (textView = mLudoBinding2.diamondText) == null) {
                        return;
                    }
                    User user = UserStore.INSTANCE.getShared().getUser();
                    textView.setText(String.valueOf(user != null ? Long.valueOf((long) user.getDiamondNum()) : null));
                }
            }
        });
        Intrinsics.checkNotNullExpressionValue(subscribe, "subscribe(...)");
        RxUtilsKt.addTo(subscribe, audioRoomFragment.getMViewModel().getMCompositeDisposable());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit addLudoGameView$lambda$4$lambda$3(LudoGameHelp ludoGameHelp, View view) {
        FrameLayout frameLayout;
        FrameLayout frameLayout2;
        if (view == null) {
            ViewGameLudoBinding viewGameLudoBinding = ludoGameHelp.mLudoBinding;
            if (viewGameLudoBinding != null && (frameLayout2 = viewGameLudoBinding.ludoGameLayout) != null) {
                frameLayout2.removeAllViews();
            }
        } else {
            ViewGameLudoBinding viewGameLudoBinding2 = ludoGameHelp.mLudoBinding;
            if (viewGameLudoBinding2 != null && (frameLayout = viewGameLudoBinding2.ludoGameLayout) != null) {
                frameLayout.addView(view, -1, -1);
            }
        }
        return Unit.INSTANCE;
    }

    private final ViewGameLudoBinding createLudoView(Context context) {
        ViewDataBinding h = androidx.databinding.g.h(LayoutInflater.from(context), R.layout.view_game_ludo, (ViewGroup) null, false);
        Intrinsics.checkNotNullExpressionValue(h, "inflate(...)");
        return (ViewGameLudoBinding) h;
    }

    private final void createViewMode() {
        SudFSTAPPDecorator sudFSTAPPDecorator;
        if (this.gameViewModel == null) {
            final GameViewModel gameViewModel = new GameViewModel();
            gameViewModel.setGameCode(this.fragment.getMViewModel().getMGameCode());
            gameViewModel.setGameListener(new SudFSMMGListener() { // from class: com.qiahao.nextvideo.room.help.LudoGameHelp$createViewMode$1$1
                @Override // tech.sud.mgp.SudMGPWrapper.decorator.SudFSMMGListener
                public void onExpireCode(ISudFSMStateHandle handle, String dataJson) {
                    Intrinsics.checkNotNullParameter(handle, "handle");
                    GameViewModel gameViewModel2 = GameViewModel.this;
                    gameViewModel2.processOnExpireCode(gameViewModel2.getSudFSTAPPDecorator(), handle);
                }

                @Override // tech.sud.mgp.SudMGPWrapper.decorator.SudFSMMGListener
                public void onGameDestroyed() {
                    AudioGameHelp mGameHelp;
                    LogUtil.e$default(LogUtil.INSTANCE, "eTag", "游戏结束", false, 4, (Object) null);
                    if (GameViewModel.this.getIsLoading() && (mGameHelp = this.getFragment().getMGameHelp()) != null) {
                        AudioGameHelp.releaseGame$default(mGameHelp, false, false, 2, null);
                    }
                }

                @Override // tech.sud.mgp.SudMGPWrapper.decorator.SudFSMMGListener
                public void onGameLoadingProgress(int stage, int retCode, int progress) {
                    rf.a.a(this, stage, retCode, progress);
                    this.setGameProgress(progress);
                    if (progress == 100) {
                        LogUtil.e$default(LogUtil.INSTANCE, "eTag", "游戏加载完成", false, 4, (Object) null);
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
                public void onGameMGCommonGameAddAIPlayers(ISudFSMStateHandle handle, SudMGPMGState.MGCommonGameAddAIPlayers model) {
                    rf.a.q(this, handle, model);
                    LogUtil.e$default(LogUtil.INSTANCE, "eTag", "游戏通知app层添加陪玩机器人是否成功（2022-05-17新增）", false, 4, (Object) null);
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
                public void onGameMGCommonGameNetworkState(ISudFSMStateHandle handle, SudMGPMGState.MGCommonGameNetworkState model) {
                    rf.a.z(this, handle, model);
                    LogUtil.e$default(LogUtil.INSTANCE, "eTag", "游戏通知app层添当前网络连接状态", false, 4, (Object) null);
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
                public void onGameMGCommonGameSettle(ISudFSMStateHandle handle, SudMGPMGState.MGCommonGameSettle model) {
                    rf.a.O(this, handle, model);
                    LogUtil.e$default(LogUtil.INSTANCE, "eTag", "游戏结算弹窗", false, 4, (Object) null);
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
                    Integer num;
                    FrameLayout frameLayout;
                    Intrinsics.checkNotNullParameter(handle, "handle");
                    rf.a.S(this, handle, model);
                    LogUtil logUtil = LogUtil.INSTANCE;
                    if (model != null) {
                        num = Integer.valueOf(model.gameState);
                    } else {
                        num = null;
                    }
                    LogUtil.e$default(logUtil, "eTag", "游戏状态改变:" + num, false, 4, (Object) null);
                    boolean z = true;
                    int i = 0;
                    if (model != null && model.gameState == 2) {
                        SUDGameData mLudoGameData = MeetingRoomManager.INSTANCE.getMLudoGameData();
                        if (mLudoGameData != null) {
                            mLudoGameData.setStatus(1);
                        }
                        this.refreshGameData();
                    } else if (model != null && model.gameState == 0) {
                        if (this.getLocalGameStore() == 2) {
                            AudioGameHelp mGameHelp = this.getFragment().getMGameHelp();
                            if (mGameHelp != null) {
                                FragmentAudioRoomBinding binding = this.getFragment().getBinding();
                                if (binding == null || (frameLayout = binding.gameLayout) == null || frameLayout.getVisibility() != 0) {
                                    z = false;
                                }
                                mGameHelp.releaseGame(z, false);
                            }
                        } else {
                            SUDGameData mLudoGameData2 = MeetingRoomManager.INSTANCE.getMLudoGameData();
                            if (mLudoGameData2 != null) {
                                mLudoGameData2.setStatus(0);
                            }
                            this.refreshGameData();
                        }
                    }
                    LudoGameHelp ludoGameHelp = this;
                    if (model != null) {
                        i = model.gameState;
                    }
                    ludoGameHelp.setLocalGameStore(i);
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
                    LogUtil.e$default(LogUtil.INSTANCE, "eTag", "游戏开始", false, 4, (Object) null);
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
                public void onPlayerMGCommonPlayerCaptain(ISudFSMStateHandle handle, String userId, SudMGPMGState.MGCommonPlayerCaptain model) {
                    rf.a.T0(this, handle, userId, model);
                    LogUtil.e$default(LogUtil.INSTANCE, "eTag", "队长状态：" + userId, false, 4, (Object) null);
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
        }
        GameViewModel gameViewModel2 = this.gameViewModel;
        if (gameViewModel2 != null && (sudFSTAPPDecorator = gameViewModel2.getSudFSTAPPDecorator()) != null) {
            sudFSTAPPDecorator.setOnNotifyStateChangeListener(new SudFSTAPPDecorator.OnNotifyStateChangeListener() { // from class: com.qiahao.nextvideo.room.help.c7
                @Override // tech.sud.mgp.SudMGPWrapper.decorator.SudFSTAPPDecorator.OnNotifyStateChangeListener
                public final void onNotifyStateChange(String str, String str2) {
                    LudoGameHelp.createViewMode$lambda$2(LudoGameHelp.this, str, str2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createViewMode$lambda$2(LudoGameHelp ludoGameHelp, String str, String str2) {
        int i;
        GameConfigModel gameConfigModel;
        int i2;
        if (Intrinsics.areEqual(str, SudMGPAPPState.APP_COMMON_OPEN_SOUND)) {
            SudMGPAPPState.APPCommonOpenSound aPPCommonOpenSound = (SudMGPAPPState.APPCommonOpenSound) BaseApplication.Companion.getGSON().j(str2, SudMGPAPPState.APPCommonOpenSound.class);
            GameViewModel gameViewModel = ludoGameHelp.gameViewModel;
            if (gameViewModel != null && (gameConfigModel = gameViewModel.getGameConfigModel()) != null) {
                if (!aPPCommonOpenSound.isOpen) {
                    i2 = 0;
                } else {
                    i2 = 100;
                }
                gameConfigModel.gameSoundVolume = i2;
            }
            ViewGameLudoBinding viewGameLudoBinding = ludoGameHelp.mLudoBinding;
            if (viewGameLudoBinding != null) {
                ImageView imageView = viewGameLudoBinding.sound;
                Context context = viewGameLudoBinding.getRoot().getContext();
                if (!aPPCommonOpenSound.isOpen) {
                    i = R.drawable.uno_prepare_icon_sound_no;
                } else {
                    i = R.drawable.uno_prepare_icon_sound;
                }
                imageView.setImageDrawable(androidx.core.content.a.getDrawable(context, i));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void exitGame(final Boolean isOwn) {
        String str;
        SUDGameData mLudoGameData = MeetingRoomManager.INSTANCE.getMLudoGameData();
        if (mLudoGameData != null) {
            RoomViewModel mViewModel = this.fragment.getMViewModel();
            long gameId = mLudoGameData.getGameId();
            GameViewModel gameViewModel = this.gameViewModel;
            if (gameViewModel == null || (str = gameViewModel.getGameCode()) == null) {
                str = "";
            }
            mViewModel.sudGameReport(gameId, 2, str, new Function0() { // from class: com.qiahao.nextvideo.room.help.d7
                public final Object invoke() {
                    Unit exitGame$lambda$24$lambda$22;
                    exitGame$lambda$24$lambda$22 = LudoGameHelp.exitGame$lambda$24$lambda$22(isOwn, this);
                    return exitGame$lambda$24$lambda$22;
                }
            }, new Function1() { // from class: com.qiahao.nextvideo.room.help.e7
                public final Object invoke(Object obj) {
                    Unit exitGame$lambda$24$lambda$23;
                    exitGame$lambda$24$lambda$23 = LudoGameHelp.exitGame$lambda$24$lambda$23(LudoGameHelp.this, (Throwable) obj);
                    return exitGame$lambda$24$lambda$23;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void exitGame$default(LudoGameHelp ludoGameHelp, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = Boolean.FALSE;
        }
        ludoGameHelp.exitGame(bool);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit exitGame$lambda$24$lambda$22(Boolean bool, LudoGameHelp ludoGameHelp) {
        AudioGameHelp mGameHelp;
        if (Intrinsics.areEqual(bool, Boolean.TRUE) && (mGameHelp = ludoGameHelp.fragment.getMGameHelp()) != null) {
            mGameHelp.releaseGame(true, false);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit exitGame$lambda$24$lambda$23(LudoGameHelp ludoGameHelp, Throwable th) {
        String str;
        Intrinsics.checkNotNullParameter(th, "it");
        if (th instanceof HiloException) {
            HiloToasty.Companion companion = HiloToasty.Companion;
            Context context = ludoGameHelp.fragment.getContext();
            String errorMessage = ((HiloException) th).getErrorMessage();
            if (errorMessage == null) {
                str = ResourcesKtxKt.getStringById(ludoGameHelp, 2131952667);
            } else {
                str = errorMessage;
            }
            Toast normal$default = HiloToasty.Companion.normal$default(companion, context, str, false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit playerJoin$lambda$21$lambda$20(LudoGameHelp ludoGameHelp, Throwable th) {
        String str;
        Intrinsics.checkNotNullParameter(th, "it");
        if (th instanceof HiloException) {
            HiloException hiloException = (HiloException) th;
            if (hiloException.getCode() == 4000) {
                final FragmentActivity activity = ludoGameHelp.fragment.getActivity();
                if (activity != null) {
                    new RoomTipDialog(activity).setTipContent(ResourcesKtxKt.getStringById(ludoGameHelp, 2131953126)).setDialogListener(new OnCommonDialogListener() { // from class: com.qiahao.nextvideo.room.help.LudoGameHelp$playerJoin$1$1$1$1
                        public void cancel() {
                            OnCommonDialogListener.DefaultImpls.cancel(this);
                        }

                        public void confirm() {
                            WalletActivity.INSTANCE.start(activity);
                        }
                    }).show();
                }
            } else {
                HiloToasty.Companion companion = HiloToasty.Companion;
                Context context = ludoGameHelp.fragment.getContext();
                String errorMessage = hiloException.getErrorMessage();
                if (errorMessage == null) {
                    str = ResourcesKtxKt.getStringById(ludoGameHelp, 2131952667);
                } else {
                    str = errorMessage;
                }
                Toast normal$default = HiloToasty.Companion.normal$default(companion, context, str, false, 4, (Object) null);
                if (normal$default != null) {
                    normal$default.show();
                }
            }
        }
        return Unit.INSTANCE;
    }

    private final void refreshUser(IncludeLudoItemBinding binding, SUDPlayerData playerData) {
        User userTiny;
        if (playerData != null && (userTiny = playerData.getUserTiny()) != null) {
            QMUIRadiusImageView qMUIRadiusImageView = binding.avatar;
            Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView, "avatar");
            ImageKtxKt.loadImage$default(qMUIRadiusImageView, userTiny.getAvatar(), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, 2131232432, 2131232432, (c5.g) null, 40958, (Object) null);
            binding.nickName.setText(userTiny.getNick());
        }
    }

    static /* synthetic */ void refreshUser$default(LudoGameHelp ludoGameHelp, IncludeLudoItemBinding includeLudoItemBinding, SUDPlayerData sUDPlayerData, int i, Object obj) {
        if ((i & 2) != 0) {
            sUDPlayerData = null;
        }
        ludoGameHelp.refreshUser(includeLudoItemBinding, sUDPlayerData);
    }

    public static /* synthetic */ void releaseGame$default(LudoGameHelp ludoGameHelp, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        ludoGameHelp.releaseGame(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showGameEndDialog$lambda$32$lambda$31$lambda$29(final LudoGameHelp ludoGameHelp, final FragmentActivity fragmentActivity, final LudoEndDialog ludoEndDialog) {
        CreateSudData mCreateLudoData = MeetingRoomManager.INSTANCE.getMCreateLudoData();
        if (mCreateLudoData != null) {
            ludoGameHelp.fragment.getMViewModel().createSudGame(mCreateLudoData, new Function0() { // from class: com.qiahao.nextvideo.room.help.f7
                public final Object invoke() {
                    Unit showGameEndDialog$lambda$32$lambda$31$lambda$29$lambda$28$lambda$26;
                    showGameEndDialog$lambda$32$lambda$31$lambda$29$lambda$28$lambda$26 = LudoGameHelp.showGameEndDialog$lambda$32$lambda$31$lambda$29$lambda$28$lambda$26(LudoGameHelp.this);
                    return showGameEndDialog$lambda$32$lambda$31$lambda$29$lambda$28$lambda$26;
                }
            }, new Function1() { // from class: com.qiahao.nextvideo.room.help.g7
                public final Object invoke(Object obj) {
                    Unit showGameEndDialog$lambda$32$lambda$31$lambda$29$lambda$28$lambda$27;
                    showGameEndDialog$lambda$32$lambda$31$lambda$29$lambda$28$lambda$27 = LudoGameHelp.showGameEndDialog$lambda$32$lambda$31$lambda$29$lambda$28$lambda$27(fragmentActivity, ludoEndDialog, ludoGameHelp, (Throwable) obj);
                    return showGameEndDialog$lambda$32$lambda$31$lambda$29$lambda$28$lambda$27;
                }
            });
        }
        AudioGameHelp mGameHelp = ludoGameHelp.fragment.getMGameHelp();
        if (mGameHelp != null) {
            mGameHelp.releaseGame(true, false);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showGameEndDialog$lambda$32$lambda$31$lambda$29$lambda$28$lambda$26(LudoGameHelp ludoGameHelp) {
        LudoEndDialog ludoEndDialog = ludoGameHelp.mLudoEndDialog;
        if (ludoEndDialog != null) {
            ludoEndDialog.dismiss();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showGameEndDialog$lambda$32$lambda$31$lambda$29$lambda$28$lambda$27(final FragmentActivity fragmentActivity, LudoEndDialog ludoEndDialog, LudoGameHelp ludoGameHelp, Throwable th) {
        if (th instanceof HiloException) {
            HiloException hiloException = (HiloException) th;
            if (hiloException.getCode() == 4000) {
                new RoomTipDialog(fragmentActivity).setTipContent(ResourcesKtxKt.getStringById(ludoEndDialog, 2131953126)).setDialogListener(new OnCommonDialogListener() { // from class: com.qiahao.nextvideo.room.help.LudoGameHelp$showGameEndDialog$1$1$1$1$2$1
                    public void cancel() {
                        OnCommonDialogListener.DefaultImpls.cancel(this);
                    }

                    public void confirm() {
                        WalletActivity.INSTANCE.start(fragmentActivity);
                    }
                }).show();
            } else {
                HiloToasty.Companion companion = HiloToasty.Companion;
                Context context = ludoGameHelp.fragment.getContext();
                String errorMessage = hiloException.getErrorMessage();
                if (errorMessage == null) {
                    errorMessage = ResourcesKtxKt.getStringById(ludoEndDialog, 2131952667);
                }
                Toast normal$default = HiloToasty.Companion.normal$default(companion, context, errorMessage, false, 4, (Object) null);
                if (normal$default != null) {
                    normal$default.show();
                }
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showGameEndDialog$lambda$32$lambda$31$lambda$30(LudoGameHelp ludoGameHelp, DialogInterface dialogInterface) {
        AudioGameHelp mGameHelp = ludoGameHelp.fragment.getMGameHelp();
        if (mGameHelp != null) {
            mGameHelp.releaseGame(true, false);
        }
        ludoGameHelp.mLudoEndDialog = null;
    }

    private final void startCountDown() {
        final FragmentActivity activity = this.fragment.getActivity();
        if (activity != null) {
            CountDownTimer countDownTimer = this.timerTask;
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            this.timerTask = null;
            CountDownTimer countDownTimer2 = new CountDownTimer() { // from class: com.qiahao.nextvideo.room.help.LudoGameHelp$startCountDown$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(15000L, 1000L);
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    String str;
                    int i;
                    ArrayList<SUDPlayerData> players;
                    TextView textView;
                    ViewGameLudoBinding mLudoBinding = LudoGameHelp.this.getMLudoBinding();
                    if (mLudoBinding != null && (textView = mLudoBinding.waitText) != null) {
                        textView.setText(ResourcesKtxKt.getStringById(this, 2131953295));
                    }
                    String str2 = null;
                    LudoGameHelp.this.setTimerTask(null);
                    MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
                    SUDGameData mLudoGameData = meetingRoomManager.getMLudoGameData();
                    if (mLudoGameData != null) {
                        str = mLudoGameData.getExternalId();
                    } else {
                        str = null;
                    }
                    User user = UserStore.INSTANCE.getShared().getUser();
                    if (user != null) {
                        str2 = user.getExternalId();
                    }
                    if (Intrinsics.areEqual(str, str2)) {
                        SUDGameData mLudoGameData2 = meetingRoomManager.getMLudoGameData();
                        if (mLudoGameData2 != null && (players = mLudoGameData2.getPlayers()) != null) {
                            i = players.size();
                        } else {
                            i = 0;
                        }
                        if (i < 2) {
                            Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, LudoGameHelp.this.getFragment().getContext(), ResourcesKtxKt.getStringById(this, 2131953541), false, 4, (Object) null);
                            if (normal$default != null) {
                                normal$default.show();
                            }
                            LudoGameHelp.this.exitGame(Boolean.TRUE);
                        }
                    }
                }

                @Override // android.os.CountDownTimer
                public void onTick(long millisUntilFinished) {
                    String valueOf;
                    TextView textView;
                    if (millisUntilFinished < 1000) {
                        valueOf = MessageService.MSG_DB_READY_REPORT;
                    } else {
                        valueOf = String.valueOf((int) (millisUntilFinished / 1000));
                    }
                    ViewGameLudoBinding mLudoBinding = LudoGameHelp.this.getMLudoBinding();
                    if (mLudoBinding != null && (textView = mLudoBinding.waitText) != null) {
                        FragmentActivity fragmentActivity = activity;
                        SpannableTextBuilder.appendText$default(SpannableTextBuilder.appendText$default(SpannableTextBuilder.appendText$default(SpannableTextBuilder.appendText$default(new SpannableTextBuilder(textView), ResourcesKtxKt.getStringById(this, 2131953295), (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Boolean) null, (Function1) null, (Boolean) null, 254, (Object) null), "(", Integer.valueOf(androidx.core.content.a.getColor(fragmentActivity, 2131100008)), (Integer) null, (Integer) null, (Integer) null, (Boolean) null, (Function1) null, (Boolean) null, 252, (Object) null), valueOf + "s", Integer.valueOf(androidx.core.content.a.getColor(fragmentActivity, 2131100008)), (Integer) null, (Integer) null, (Integer) null, (Boolean) null, (Function1) null, (Boolean) null, 252, (Object) null), ")", Integer.valueOf(androidx.core.content.a.getColor(fragmentActivity, 2131100008)), (Integer) null, (Integer) null, (Integer) null, (Boolean) null, (Function1) null, (Boolean) null, 252, (Object) null).apply();
                    }
                }
            };
            this.timerTask = countDownTimer2;
            countDownTimer2.start();
        }
    }

    @Nullable
    public final View addLudoGameView() {
        View view;
        View view2;
        FrameLayout frameLayout;
        FrameLayout frameLayout2;
        ViewGroup.LayoutParams layoutParams;
        View root;
        View root2;
        FrameLayout frameLayout3;
        View view3;
        MutableLiveData<View> gameViewLiveData;
        FrameLayout frameLayout4;
        FrameLayout frameLayout5;
        FragmentAudioRoomBinding binding = this.fragment.getBinding();
        if (binding == null || (frameLayout5 = binding.gameLayout) == null || frameLayout5.getChildCount() != 0) {
            FragmentAudioRoomBinding binding2 = this.fragment.getBinding();
            if (binding2 != null && (frameLayout2 = binding2.gameLayout) != null) {
                view = frameLayout2.getChildAt(0);
            } else {
                view = null;
            }
            ViewGameLudoBinding viewGameLudoBinding = this.mLudoBinding;
            if (viewGameLudoBinding != null) {
                view2 = viewGameLudoBinding.getRoot();
            } else {
                view2 = null;
            }
            if (!Intrinsics.areEqual(view, view2)) {
                LogUtil.e$default(LogUtil.INSTANCE, "eTag", "添加Ludo 游戏的View 之前需要删除", false, 4, (Object) null);
                FragmentAudioRoomBinding binding3 = this.fragment.getBinding();
                if (binding3 != null && (frameLayout = binding3.gameLayout) != null) {
                    frameLayout.removeAllViews();
                }
            }
        }
        createViewMode();
        FragmentAudioRoomBinding binding4 = this.fragment.getBinding();
        if ((binding4 != null && (frameLayout4 = binding4.gameLayout) != null && frameLayout4.getChildCount() == 0) || this.mLudoBinding == null) {
            LogUtil.e$default(LogUtil.INSTANCE, "eTag", "addLudoGameView  创建游戏的View", false, 4, (Object) null);
            Context context = this.fragment.getContext();
            if (context != null) {
                this.mLudoBinding = createLudoView(context);
                GameViewModel gameViewModel = this.gameViewModel;
                if (gameViewModel != null && (gameViewLiveData = gameViewModel.getGameViewLiveData()) != null) {
                    gameViewLiveData.observe(this.fragment, new LudoGameHelp$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.room.help.h7
                        public final Object invoke(Object obj) {
                            Unit addLudoGameView$lambda$4$lambda$3;
                            addLudoGameView$lambda$4$lambda$3 = LudoGameHelp.addLudoGameView$lambda$4$lambda$3(LudoGameHelp.this, (View) obj);
                            return addLudoGameView$lambda$4$lambda$3;
                        }
                    }));
                }
                FragmentAudioRoomBinding binding5 = this.fragment.getBinding();
                if (binding5 != null && (frameLayout3 = binding5.gameLayout) != null) {
                    ViewGameLudoBinding viewGameLudoBinding2 = this.mLudoBinding;
                    if (viewGameLudoBinding2 != null) {
                        view3 = viewGameLudoBinding2.getRoot();
                    } else {
                        view3 = null;
                    }
                    frameLayout3.addView(view3);
                }
                ViewGameLudoBinding viewGameLudoBinding3 = this.mLudoBinding;
                if (viewGameLudoBinding3 != null && (root2 = viewGameLudoBinding3.getRoot()) != null) {
                    layoutParams = root2.getLayoutParams();
                } else {
                    layoutParams = null;
                }
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.height = -1;
                layoutParams2.width = -1;
                layoutParams2.gravity = 17;
                ViewGameLudoBinding viewGameLudoBinding4 = this.mLudoBinding;
                if (viewGameLudoBinding4 != null && (root = viewGameLudoBinding4.getRoot()) != null) {
                    root.setLayoutParams(layoutParams2);
                }
            }
        }
        ViewGameLudoBinding viewGameLudoBinding5 = this.mLudoBinding;
        if (viewGameLudoBinding5 == null) {
            return null;
        }
        return viewGameLudoBinding5.getRoot();
    }

    public final boolean checkMyIsJoin() {
        ArrayList<SUDPlayerData> players;
        String str;
        SUDGameData mLudoGameData = MeetingRoomManager.INSTANCE.getMLudoGameData();
        boolean z = false;
        if (mLudoGameData != null && (players = mLudoGameData.getPlayers()) != null) {
            Iterator<T> it = players.iterator();
            while (it.hasNext()) {
                User userTiny = ((SUDPlayerData) it.next()).getUserTiny();
                String str2 = null;
                if (userTiny != null) {
                    str = userTiny.getExternalId();
                } else {
                    str = null;
                }
                User user = UserStore.INSTANCE.getShared().getUser();
                if (user != null) {
                    str2 = user.getExternalId();
                }
                if (Intrinsics.areEqual(str, str2)) {
                    z = true;
                }
            }
        }
        return z;
    }

    @NotNull
    public final AudioRoomFragment getFragment() {
        return this.fragment;
    }

    public final int getGameProgress() {
        return this.gameProgress;
    }

    @Nullable
    public final GameViewModel getGameViewModel() {
        return this.gameViewModel;
    }

    public final int getLocalGameStore() {
        return this.localGameStore;
    }

    @Nullable
    public final ViewGameLudoBinding getMLudoBinding() {
        return this.mLudoBinding;
    }

    @Nullable
    public final LudoEndDialog getMLudoEndDialog() {
        return this.mLudoEndDialog;
    }

    @Nullable
    public final CountDownTimer getTimerTask() {
        return this.timerTask;
    }

    public final void playerJoin() {
        String str;
        SUDGameData mLudoGameData = MeetingRoomManager.INSTANCE.getMLudoGameData();
        if (mLudoGameData != null) {
            RoomViewModel mViewModel = this.fragment.getMViewModel();
            long gameId = mLudoGameData.getGameId();
            GameViewModel gameViewModel = this.gameViewModel;
            if (gameViewModel == null || (str = gameViewModel.getGameCode()) == null) {
                str = "";
            }
            RoomViewModel.sudGameReport$default(mViewModel, gameId, 1, str, null, new Function1() { // from class: com.qiahao.nextvideo.room.help.b7
                public final Object invoke(Object obj) {
                    Unit playerJoin$lambda$21$lambda$20;
                    playerJoin$lambda$21$lambda$20 = LudoGameHelp.playerJoin$lambda$21$lambda$20(LudoGameHelp.this, (Throwable) obj);
                    return playerJoin$lambda$21$lambda$20;
                }
            }, 8, null);
        }
    }

    public final void refreshGameData() {
        ViewGameLudoBinding viewGameLudoBinding;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        ConstraintLayout constraintLayout;
        FrameLayout frameLayout;
        boolean z;
        int i6;
        int i7;
        TextView textView;
        SudFSTAPPDecorator sudFSTAPPDecorator;
        boolean z2;
        GameConfigModel gameConfigModel;
        GameConfigModel gameConfigModel2;
        Long l;
        ConstraintLayout constraintLayout2;
        FrameLayout frameLayout2;
        ConstraintLayout constraintLayout3;
        FrameLayout frameLayout3;
        SUDPlayerData sUDPlayerData;
        SUDPlayerData sUDPlayerData2;
        SUDPlayerData sUDPlayerData3;
        SUDPlayerData sUDPlayerData4;
        final SUDGameData mLudoGameData = MeetingRoomManager.INSTANCE.getMLudoGameData();
        if (mLudoGameData != null && (viewGameLudoBinding = this.mLudoBinding) != null) {
            TextView textView2 = viewGameLudoBinding.betDiamond;
            String format = String.format(ResourcesKtxKt.getStringById(this, 2131953280), Arrays.copyOf(new Object[]{String.valueOf(mLudoGameData.getDiamond())}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            textView2.setText(format);
            TextView textView3 = viewGameLudoBinding.quick;
            if (mLudoGameData.getMode() == 1) {
                i = 2131953292;
            } else {
                i = 2131953282;
            }
            textView3.setText(ResourcesKtxKt.getStringById(this, i));
            ArrayList<SUDPlayerData> players = mLudoGameData.getPlayers();
            if (players != null) {
                i2 = players.size();
            } else {
                i2 = 0;
            }
            String str = null;
            if (i2 >= 1) {
                IncludeLudoItemBinding includeLudoItemBinding = viewGameLudoBinding.oneUser;
                Intrinsics.checkNotNullExpressionValue(includeLudoItemBinding, "oneUser");
                ArrayList<SUDPlayerData> players2 = mLudoGameData.getPlayers();
                if (players2 != null) {
                    sUDPlayerData4 = players2.get(0);
                } else {
                    sUDPlayerData4 = null;
                }
                refreshUser(includeLudoItemBinding, sUDPlayerData4);
            } else {
                QMUIRadiusImageView qMUIRadiusImageView = viewGameLudoBinding.oneUser.avatar;
                Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView, "avatar");
                ImageKtxKt.loadImage$default(qMUIRadiusImageView, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.ludo_player_default_icon), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
                TextView textView4 = viewGameLudoBinding.oneUser.nickName;
                String format2 = String.format(ResourcesKtxKt.getStringById(this, 2131953291), Arrays.copyOf(new Object[]{1}, 1));
                Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
                textView4.setText(format2);
            }
            ArrayList<SUDPlayerData> players3 = mLudoGameData.getPlayers();
            if (players3 != null) {
                i3 = players3.size();
            } else {
                i3 = 0;
            }
            if (i3 > 1) {
                IncludeLudoItemBinding includeLudoItemBinding2 = viewGameLudoBinding.twoUser;
                Intrinsics.checkNotNullExpressionValue(includeLudoItemBinding2, "twoUser");
                ArrayList<SUDPlayerData> players4 = mLudoGameData.getPlayers();
                if (players4 != null) {
                    sUDPlayerData3 = players4.get(1);
                } else {
                    sUDPlayerData3 = null;
                }
                refreshUser(includeLudoItemBinding2, sUDPlayerData3);
            } else {
                QMUIRadiusImageView qMUIRadiusImageView2 = viewGameLudoBinding.twoUser.avatar;
                Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView2, "avatar");
                ImageKtxKt.loadImage$default(qMUIRadiusImageView2, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.ludo_player_default_icon), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
                TextView textView5 = viewGameLudoBinding.twoUser.nickName;
                String format3 = String.format(ResourcesKtxKt.getStringById(this, 2131953291), Arrays.copyOf(new Object[]{2}, 1));
                Intrinsics.checkNotNullExpressionValue(format3, "format(...)");
                textView5.setText(format3);
            }
            ArrayList<SUDPlayerData> players5 = mLudoGameData.getPlayers();
            if (players5 != null) {
                i4 = players5.size();
            } else {
                i4 = 0;
            }
            if (i4 > 2) {
                IncludeLudoItemBinding includeLudoItemBinding3 = viewGameLudoBinding.threeUser;
                Intrinsics.checkNotNullExpressionValue(includeLudoItemBinding3, "threeUser");
                ArrayList<SUDPlayerData> players6 = mLudoGameData.getPlayers();
                if (players6 != null) {
                    sUDPlayerData2 = players6.get(2);
                } else {
                    sUDPlayerData2 = null;
                }
                refreshUser(includeLudoItemBinding3, sUDPlayerData2);
            } else {
                QMUIRadiusImageView qMUIRadiusImageView3 = viewGameLudoBinding.threeUser.avatar;
                Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView3, "avatar");
                ImageKtxKt.loadImage$default(qMUIRadiusImageView3, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.ludo_player_default_icon), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
                TextView textView6 = viewGameLudoBinding.threeUser.nickName;
                String format4 = String.format(ResourcesKtxKt.getStringById(this, 2131953291), Arrays.copyOf(new Object[]{3}, 1));
                Intrinsics.checkNotNullExpressionValue(format4, "format(...)");
                textView6.setText(format4);
            }
            ArrayList<SUDPlayerData> players7 = mLudoGameData.getPlayers();
            if (players7 != null) {
                i5 = players7.size();
            } else {
                i5 = 0;
            }
            if (i5 > 3) {
                IncludeLudoItemBinding includeLudoItemBinding4 = viewGameLudoBinding.fourUser;
                Intrinsics.checkNotNullExpressionValue(includeLudoItemBinding4, "fourUser");
                ArrayList<SUDPlayerData> players8 = mLudoGameData.getPlayers();
                if (players8 != null) {
                    sUDPlayerData = players8.get(3);
                } else {
                    sUDPlayerData = null;
                }
                refreshUser(includeLudoItemBinding4, sUDPlayerData);
            } else {
                QMUIRadiusImageView qMUIRadiusImageView4 = viewGameLudoBinding.fourUser.avatar;
                Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView4, "avatar");
                ImageKtxKt.loadImage$default(qMUIRadiusImageView4, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.ludo_player_default_icon), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
                TextView textView7 = viewGameLudoBinding.fourUser.nickName;
                String format5 = String.format(ResourcesKtxKt.getStringById(this, 2131953291), Arrays.copyOf(new Object[]{4}, 1));
                Intrinsics.checkNotNullExpressionValue(format5, "format(...)");
                textView7.setText(format5);
            }
            if (mLudoGameData.getPiece() == 2) {
                viewGameLudoBinding.pieces.setText(ResourcesKtxKt.getStringById(this, 2131953293));
            } else {
                viewGameLudoBinding.pieces.setText(ResourcesKtxKt.getStringById(this, 2131953286));
            }
            if (mLudoGameData.getOnOff1() == 1) {
                viewGameLudoBinding.magic.setVisibility(0);
            } else {
                viewGameLudoBinding.magic.setVisibility(8);
            }
            if (this.gameProgress == 100) {
                if (mLudoGameData.getStatus() != 0 && mLudoGameData.getStatus() != 2) {
                    if (mLudoGameData.getStatus() == 1) {
                        viewGameLudoBinding.diamondText.setText(String.valueOf(mLudoGameData.getDiamond()));
                        viewGameLudoBinding.diamondTwo.setVisibility(0);
                        ViewGameLudoBinding viewGameLudoBinding2 = this.mLudoBinding;
                        if (viewGameLudoBinding2 != null && (frameLayout3 = viewGameLudoBinding2.ludoGameLayout) != null) {
                            frameLayout3.setAlpha(1.0f);
                        }
                        ViewGameLudoBinding viewGameLudoBinding3 = this.mLudoBinding;
                        if (viewGameLudoBinding3 != null && (constraintLayout3 = viewGameLudoBinding3.prepareLayout) != null) {
                            constraintLayout3.setVisibility(8);
                        }
                        viewGameLudoBinding.diamond.setVisibility(8);
                        viewGameLudoBinding.add.setVisibility(8);
                    }
                } else {
                    TextView textView8 = viewGameLudoBinding.diamondText;
                    User user = UserStore.INSTANCE.getShared().getUser();
                    if (user != null) {
                        l = Long.valueOf((long) user.getDiamondNum());
                    } else {
                        l = null;
                    }
                    textView8.setText(String.valueOf(l));
                    viewGameLudoBinding.diamond.setVisibility(0);
                    viewGameLudoBinding.add.setVisibility(0);
                    ViewGameLudoBinding viewGameLudoBinding4 = this.mLudoBinding;
                    if (viewGameLudoBinding4 != null && (frameLayout2 = viewGameLudoBinding4.ludoGameLayout) != null) {
                        frameLayout2.setAlpha(0.01f);
                    }
                    ViewGameLudoBinding viewGameLudoBinding5 = this.mLudoBinding;
                    if (viewGameLudoBinding5 != null && (constraintLayout2 = viewGameLudoBinding5.prepareLayout) != null) {
                        constraintLayout2.setVisibility(0);
                    }
                    viewGameLudoBinding.diamondTwo.setVisibility(8);
                }
            } else {
                ViewGameLudoBinding viewGameLudoBinding6 = this.mLudoBinding;
                if (viewGameLudoBinding6 != null && (frameLayout = viewGameLudoBinding6.ludoGameLayout) != null) {
                    frameLayout.setAlpha(1.0f);
                }
                ViewGameLudoBinding viewGameLudoBinding7 = this.mLudoBinding;
                if (viewGameLudoBinding7 != null && (constraintLayout = viewGameLudoBinding7.prepareLayout) != null) {
                    constraintLayout.setVisibility(8);
                }
                viewGameLudoBinding.diamondTwo.setVisibility(8);
            }
            final ImageView imageView = viewGameLudoBinding.add;
            final long j = 800;
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.help.LudoGameHelp$refreshGameData$lambda$15$$inlined$singleClick$default$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(imageView) > j || (imageView instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(imageView, currentTimeMillis);
                        Context context = this.getFragment().getContext();
                        if (context != null) {
                            WalletActivity.INSTANCE.start(context);
                        }
                    }
                }
            });
            final ConstraintLayout constraintLayout4 = viewGameLudoBinding.prepareTop;
            final long j2 = 800;
            constraintLayout4.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.help.LudoGameHelp$refreshGameData$lambda$15$$inlined$singleClick$default$2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    String str2;
                    FragmentActivity activity;
                    String str3;
                    GameConfig gameConfig;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(constraintLayout4) > j2 || (constraintLayout4 instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(constraintLayout4, currentTimeMillis);
                        ConstraintLayout constraintLayout5 = constraintLayout4;
                        String externalId = mLudoGameData.getExternalId();
                        User user2 = UserStore.INSTANCE.getShared().getUser();
                        GameConfigLudo gameConfigLudo = null;
                        if (user2 != null) {
                            str2 = user2.getExternalId();
                        } else {
                            str2 = null;
                        }
                        if (Intrinsics.areEqual(externalId, str2) && (activity = this.getFragment().getActivity()) != null) {
                            CreateSudData createSudData = new CreateSudData(mLudoGameData.getGameType(), mLudoGameData.getMode(), mLudoGameData.getPiece(), mLudoGameData.getOnOff1(), mLudoGameData.getDiamond(), mLudoGameData.getAutoMatch(), MeetingRoomManager.INSTANCE.getMGroupId(), Long.valueOf(mLudoGameData.getGameId()));
                            GameViewModel gameViewModel = this.getGameViewModel();
                            if (gameViewModel != null) {
                                str3 = gameViewModel.getGameCode();
                            } else {
                                str3 = null;
                            }
                            GroupDetailBean groupDetailBean = (GroupDetailBean) this.getFragment().getMViewModel().getMGroupDetailBean().getValue();
                            if (groupDetailBean != null && (gameConfig = groupDetailBean.getGameConfig()) != null) {
                                gameConfigLudo = gameConfig.getLudo();
                            }
                            new CreateLudoDialog(activity, createSudData, str3, gameConfigLudo).show();
                        }
                    }
                }
            });
            ImageView imageView2 = viewGameLudoBinding.sound;
            Context context = viewGameLudoBinding.getRoot().getContext();
            GameViewModel gameViewModel = this.gameViewModel;
            if (gameViewModel != null && (gameConfigModel2 = gameViewModel.getGameConfigModel()) != null && gameConfigModel2.gameSoundVolume == 100) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                i6 = R.drawable.uno_prepare_icon_sound;
            } else {
                i6 = R.drawable.uno_prepare_icon_sound_no;
            }
            imageView2.setImageDrawable(androidx.core.content.a.getDrawable(context, i6));
            GameViewModel gameViewModel2 = this.gameViewModel;
            if (gameViewModel2 != null && (sudFSTAPPDecorator = gameViewModel2.getSudFSTAPPDecorator()) != null) {
                GameViewModel gameViewModel3 = this.gameViewModel;
                if (gameViewModel3 != null && (gameConfigModel = gameViewModel3.getGameConfigModel()) != null && gameConfigModel.gameSoundVolume == 100) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                sudFSTAPPDecorator.notifyAPPCommonOpenSound(z2);
            }
            final ImageView imageView3 = viewGameLudoBinding.sound;
            imageView3.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.help.LudoGameHelp$refreshGameData$lambda$15$$inlined$singleClick$default$3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SudFSTAPPDecorator sudFSTAPPDecorator2;
                    GameConfigModel gameConfigModel3;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(imageView3) > j || (imageView3 instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(imageView3, currentTimeMillis);
                        GameViewModel gameViewModel4 = this.getGameViewModel();
                        boolean z3 = false;
                        if (gameViewModel4 != null && (gameConfigModel3 = gameViewModel4.getGameConfigModel()) != null && gameConfigModel3.gameSoundVolume == 100) {
                            z3 = true;
                        }
                        GameViewModel gameViewModel5 = this.getGameViewModel();
                        if (gameViewModel5 != null && (sudFSTAPPDecorator2 = gameViewModel5.getSudFSTAPPDecorator()) != null) {
                            sudFSTAPPDecorator2.notifyAPPCommonOpenSound(!z3);
                        }
                    }
                }
            });
            final ImageView imageView4 = viewGameLudoBinding.information;
            imageView4.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.help.LudoGameHelp$refreshGameData$lambda$15$$inlined$singleClick$default$4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(imageView4) > j || (imageView4 instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(imageView4, currentTimeMillis);
                        FragmentActivity activity = this.getFragment().getActivity();
                        if (activity != null) {
                            new LudoIntroduceDialog(activity).show();
                        }
                    }
                }
            });
            final ImageView imageView5 = viewGameLudoBinding.close;
            imageView5.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.help.LudoGameHelp$refreshGameData$lambda$15$$inlined$singleClick$default$5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(imageView5) > j || (imageView5 instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(imageView5, currentTimeMillis);
                        AudioGameHelp mGameHelp = this.getFragment().getMGameHelp();
                        if (mGameHelp != null) {
                            AudioGameHelp.hideGameView$default(mGameHelp, null, 1, null);
                        }
                    }
                }
            });
            String externalId = mLudoGameData.getExternalId();
            User user2 = UserStore.INSTANCE.getShared().getUser();
            if (user2 != null) {
                str = user2.getExternalId();
            }
            if (Intrinsics.areEqual(externalId, str)) {
                viewGameLudoBinding.button.setText(ResourcesKtxKt.getStringById(this, 2131952968));
                viewGameLudoBinding.button.setTextColor(androidx.core.content.a.getColor(viewGameLudoBinding.getRoot().getContext(), 2131099870));
                viewGameLudoBinding.button.setBackground(androidx.core.content.a.getDrawable(viewGameLudoBinding.getRoot().getContext(), R.drawable.ludo_prepare_icon_quit));
            } else if (!checkMyIsJoin()) {
                viewGameLudoBinding.button.setText(ResourcesKtxKt.getStringById(this, 2131953154));
                viewGameLudoBinding.button.setTextColor(androidx.core.content.a.getColor(viewGameLudoBinding.getRoot().getContext(), 2131099959));
                viewGameLudoBinding.button.setBackground(androidx.core.content.a.getDrawable(viewGameLudoBinding.getRoot().getContext(), R.drawable.ludo_prepare_icon_start));
            } else {
                viewGameLudoBinding.button.setTextColor(androidx.core.content.a.getColor(viewGameLudoBinding.getRoot().getContext(), 2131099870));
                viewGameLudoBinding.button.setBackground(androidx.core.content.a.getDrawable(viewGameLudoBinding.getRoot().getContext(), R.drawable.ludo_prepare_icon_quit));
                viewGameLudoBinding.button.setText(ResourcesKtxKt.getStringById(this, 2131953815));
            }
            ArrayList<SUDPlayerData> players9 = mLudoGameData.getPlayers();
            if (players9 != null) {
                i7 = players9.size();
            } else {
                i7 = 0;
            }
            if (i7 >= 2) {
                startCountDown();
            } else {
                ViewGameLudoBinding viewGameLudoBinding8 = this.mLudoBinding;
                if (viewGameLudoBinding8 != null && (textView = viewGameLudoBinding8.waitText) != null) {
                    textView.setText(ResourcesKtxKt.getStringById(this, 2131953295));
                }
            }
            final ConstraintLayout constraintLayout5 = viewGameLudoBinding.prepareLayout;
            constraintLayout5.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.help.LudoGameHelp$refreshGameData$lambda$15$$inlined$singleClick$default$6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(constraintLayout5) > j || (constraintLayout5 instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(constraintLayout5, currentTimeMillis);
                        ConstraintLayout constraintLayout6 = constraintLayout5;
                    }
                }
            });
            final TextView textView9 = viewGameLudoBinding.button;
            final long j3 = 800;
            textView9.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.help.LudoGameHelp$refreshGameData$lambda$15$$inlined$singleClick$default$7
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    String str2;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView9) > j3 || (textView9 instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(textView9, currentTimeMillis);
                        String externalId2 = mLudoGameData.getExternalId();
                        UserStore.Companion companion = UserStore.INSTANCE;
                        User user3 = companion.getShared().getUser();
                        String str3 = null;
                        if (user3 != null) {
                            str2 = user3.getExternalId();
                        } else {
                            str2 = null;
                        }
                        if (Intrinsics.areEqual(externalId2, str2)) {
                            this.exitGame(Boolean.TRUE);
                            return;
                        }
                        if (!this.checkMyIsJoin()) {
                            MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
                            User user4 = companion.getShared().getUser();
                            if (user4 != null) {
                                str3 = user4.getExternalId();
                            }
                            if (meetingRoomManager.checkUserOnMic(str3)) {
                                this.playerJoin();
                                return;
                            }
                            AudioRoomDialogHelp mDialogHelp = this.getFragment().getMDialogHelp();
                            if (mDialogHelp != null) {
                                mDialogHelp.autoOnMic(RoomViewModel.MIC_JOIN_LUDO);
                                return;
                            }
                            return;
                        }
                        LudoGameHelp.exitGame$default(this, null, 1, null);
                    }
                }
            });
        }
    }

    public final void releaseGame(boolean callReport) {
        FrameLayout frameLayout;
        SUDGameData mLudoGameData;
        String str;
        if (callReport && (mLudoGameData = MeetingRoomManager.INSTANCE.getMLudoGameData()) != null) {
            AppRequestUtils appRequestUtils = AppRequestUtils.INSTANCE;
            long gameId = mLudoGameData.getGameId();
            GameViewModel gameViewModel = this.gameViewModel;
            if (gameViewModel == null || (str = gameViewModel.getGameCode()) == null) {
                str = "";
            }
            appRequestUtils.sudGameEnd(gameId, 2, str);
        }
        GameViewModel gameViewModel2 = this.gameViewModel;
        if (gameViewModel2 != null) {
            gameViewModel2.release();
        }
        GameViewModel gameViewModel3 = this.gameViewModel;
        if (gameViewModel3 != null) {
            gameViewModel3.setGameListener(null);
        }
        this.gameViewModel = null;
        FragmentAudioRoomBinding binding = this.fragment.getBinding();
        if (binding != null && (frameLayout = binding.gameLayout) != null) {
            frameLayout.removeAllViews();
        }
        this.mLudoBinding = null;
        this.localGameStore = 0;
        this.gameProgress = 0;
        CountDownTimer countDownTimer = this.timerTask;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.timerTask = null;
    }

    public final void setGameProgress(int i) {
        this.gameProgress = i;
    }

    public final void setGameViewModel(@Nullable GameViewModel gameViewModel) {
        this.gameViewModel = gameViewModel;
    }

    public final void setLocalGameStore(int i) {
        this.localGameStore = i;
    }

    public final void setMLudoBinding(@Nullable ViewGameLudoBinding viewGameLudoBinding) {
        this.mLudoBinding = viewGameLudoBinding;
    }

    public final void setMLudoEndDialog(@Nullable LudoEndDialog ludoEndDialog) {
        this.mLudoEndDialog = ludoEndDialog;
    }

    public final void setTimerTask(@Nullable CountDownTimer countDownTimer) {
        this.timerTask = countDownTimer;
    }

    /* JADX WARN: Type inference failed for: r7v0, types: [com.qiahao.nextvideo.room.game.LudoEndDialog, android.app.Dialog] */
    public final void showGameEndDialog(@NotNull SUDGameAward ludoGameAward) {
        Intrinsics.checkNotNullParameter(ludoGameAward, "ludoGameAward");
        final FragmentActivity activity = this.fragment.getActivity();
        if (activity != null) {
            LudoEndDialog ludoEndDialog = this.mLudoEndDialog;
            if (ludoEndDialog != null && ludoEndDialog != null) {
                ludoEndDialog.dismiss();
            }
            final ?? ludoEndDialog2 = new LudoEndDialog(activity, ludoGameAward, false, 4, null);
            ludoEndDialog2.setListener(new Function0() { // from class: com.qiahao.nextvideo.room.help.i7
                public final Object invoke() {
                    Unit showGameEndDialog$lambda$32$lambda$31$lambda$29;
                    showGameEndDialog$lambda$32$lambda$31$lambda$29 = LudoGameHelp.showGameEndDialog$lambda$32$lambda$31$lambda$29(LudoGameHelp.this, activity, ludoEndDialog2);
                    return showGameEndDialog$lambda$32$lambda$31$lambda$29;
                }
            });
            ludoEndDialog2.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.qiahao.nextvideo.room.help.j7
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    LudoGameHelp.showGameEndDialog$lambda$32$lambda$31$lambda$30(LudoGameHelp.this, dialogInterface);
                }
            });
            this.mLudoEndDialog = ludoEndDialog2;
            ludoEndDialog2.show();
        }
    }
}
