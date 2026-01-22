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
import com.qiahao.nextvideo.databinding.ViewGameCrushBinding;
import com.qiahao.nextvideo.room.dialog.RoomTipDialog;
import com.qiahao.nextvideo.room.fragment.AudioRoomFragment;
import com.qiahao.nextvideo.room.game.CreateCrushDialog;
import com.qiahao.nextvideo.room.game.CrushEndDialog;
import com.qiahao.nextvideo.room.game.CrushIntroduceDialog;
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

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010)\u001a\u00020*H\u0002J\b\u0010+\u001a\u0004\u0018\u00010,J\u0010\u0010-\u001a\u00020\t2\u0006\u0010.\u001a\u00020/H\u0002J\u0006\u00100\u001a\u00020*J\u0006\u00101\u001a\u000202J\b\u00103\u001a\u00020*H\u0002J\u0006\u00104\u001a\u00020*J\u0019\u00105\u001a\u00020*2\n\b\u0002\u00106\u001a\u0004\u0018\u000102H\u0002¢\u0006\u0002\u00107J\u001c\u00108\u001a\u00020*2\u0006\u00109\u001a\u00020:2\n\b\u0002\u0010;\u001a\u0004\u0018\u00010<H\u0002J\u000e\u0010=\u001a\u00020*2\u0006\u0010>\u001a\u00020?J\u0010\u0010@\u001a\u00020*2\b\b\u0002\u0010A\u001a\u000202R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010#\u001a\u0004\u0018\u00010$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u0006B"}, d2 = {"Lcom/qiahao/nextvideo/room/help/CrushGameHelp;", "", "fragment", "Lcom/qiahao/nextvideo/room/fragment/AudioRoomFragment;", "<init>", "(Lcom/qiahao/nextvideo/room/fragment/AudioRoomFragment;)V", "getFragment", "()Lcom/qiahao/nextvideo/room/fragment/AudioRoomFragment;", "mCrushBinding", "Lcom/qiahao/nextvideo/databinding/ViewGameCrushBinding;", "getMCrushBinding", "()Lcom/qiahao/nextvideo/databinding/ViewGameCrushBinding;", "setMCrushBinding", "(Lcom/qiahao/nextvideo/databinding/ViewGameCrushBinding;)V", "mCrushEndDialog", "Lcom/qiahao/nextvideo/room/game/CrushEndDialog;", "getMCrushEndDialog", "()Lcom/qiahao/nextvideo/room/game/CrushEndDialog;", "setMCrushEndDialog", "(Lcom/qiahao/nextvideo/room/game/CrushEndDialog;)V", "localGameStore", "", "getLocalGameStore", "()I", "setLocalGameStore", "(I)V", "gameProgress", "getGameProgress", "setGameProgress", "timerTask", "Landroid/os/CountDownTimer;", "getTimerTask", "()Landroid/os/CountDownTimer;", "setTimerTask", "(Landroid/os/CountDownTimer;)V", "gameViewModel", "Lcom/qiahao/nextvideo/sud/GameViewModel;", "getGameViewModel", "()Lcom/qiahao/nextvideo/sud/GameViewModel;", "setGameViewModel", "(Lcom/qiahao/nextvideo/sud/GameViewModel;)V", "createViewMode", "", "addCrushGameView", "Landroid/view/View;", "createCrushView", "context", "Landroid/content/Context;", "refreshGameData", "checkMyIsJoin", "", "startCountDown", "playerJoin", "exitGame", "isOwn", "(Ljava/lang/Boolean;)V", "refreshUser", "binding", "Lcom/qiahao/nextvideo/databinding/IncludeLudoItemBinding;", "playerData", "Lcom/qiahao/nextvideo/data/game/SUDPlayerData;", "showGameEndDialog", "ludoGameAward", "Lcom/qiahao/nextvideo/data/game/SUDGameAward;", "releaseGame", "callReport", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCrushGameHelp.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CrushGameHelp.kt\ncom/qiahao/nextvideo/room/help/CrushGameHelp\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,617:1\n61#2,9:618\n61#2,9:627\n61#2,9:636\n61#2,9:645\n61#2,9:654\n61#2,9:663\n61#2,9:672\n1869#3,2:681\n*S KotlinDebug\n*F\n+ 1 CrushGameHelp.kt\ncom/qiahao/nextvideo/room/help/CrushGameHelp\n*L\n307#1:618,9\n314#1:627,9\n340#1:636,9\n346#1:645,9\n352#1:654,9\n402#1:663,9\n403#1:672,9\n428#1:681,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class CrushGameHelp {

    @NotNull
    private final AudioRoomFragment fragment;
    private int gameProgress;

    @Nullable
    private GameViewModel gameViewModel;
    private int localGameStore;

    @Nullable
    private ViewGameCrushBinding mCrushBinding;

    @Nullable
    private CrushEndDialog mCrushEndDialog;

    @Nullable
    private CountDownTimer timerTask;

    public CrushGameHelp(@NotNull AudioRoomFragment audioRoomFragment) {
        Intrinsics.checkNotNullParameter(audioRoomFragment, "fragment");
        this.fragment = audioRoomFragment;
        nd.c subscribe = UserStore.INSTANCE.getShared().getUserObjectRelay().observeOn(RxUtilsKt.getMainThread()).subscribeOn(RxUtilsKt.getMainThread()).subscribe(new pd.g() { // from class: com.qiahao.nextvideo.room.help.CrushGameHelp.1
            public final void accept(UserObjectEvent userObjectEvent) {
                SUDGameData mCrushGameData;
                TextView textView;
                ViewGameCrushBinding mCrushBinding;
                TextView textView2;
                if (userObjectEvent != null) {
                    CrushGameHelp crushGameHelp = CrushGameHelp.this;
                    if (userObjectEvent.getType() != UserObjectEventType.REFRESH_MONEY || (mCrushGameData = MeetingRoomManager.INSTANCE.getMCrushGameData()) == null) {
                        return;
                    }
                    if (mCrushGameData.getStatus() != 0 && mCrushGameData.getStatus() != 2) {
                        if (mCrushGameData.getStatus() != 1 || (mCrushBinding = crushGameHelp.getMCrushBinding()) == null || (textView2 = mCrushBinding.diamondText) == null) {
                            return;
                        }
                        textView2.setText(String.valueOf(mCrushGameData.getDiamond()));
                        return;
                    }
                    LogUtil logUtil = LogUtil.INSTANCE;
                    UserStore.Companion companion = UserStore.INSTANCE;
                    User user = companion.getShared().getUser();
                    LogUtil.e$default(logUtil, "eTag", "刷新砖石打印金币" + (user != null ? Long.valueOf((long) user.getDiamondNum()) : null), false, 4, (Object) null);
                    ViewGameCrushBinding mCrushBinding2 = crushGameHelp.getMCrushBinding();
                    if (mCrushBinding2 == null || (textView = mCrushBinding2.diamondText) == null) {
                        return;
                    }
                    User user2 = companion.getShared().getUser();
                    textView.setText(String.valueOf(user2 != null ? Long.valueOf((long) user2.getDiamondNum()) : null));
                }
            }
        });
        Intrinsics.checkNotNullExpressionValue(subscribe, "subscribe(...)");
        RxUtilsKt.addTo(subscribe, audioRoomFragment.getMViewModel().getMCompositeDisposable());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit addCrushGameView$lambda$4$lambda$3(CrushGameHelp crushGameHelp, View view) {
        FrameLayout frameLayout;
        FrameLayout frameLayout2;
        if (view == null) {
            ViewGameCrushBinding viewGameCrushBinding = crushGameHelp.mCrushBinding;
            if (viewGameCrushBinding != null && (frameLayout2 = viewGameCrushBinding.crushGameLayout) != null) {
                frameLayout2.removeAllViews();
            }
        } else {
            ViewGameCrushBinding viewGameCrushBinding2 = crushGameHelp.mCrushBinding;
            if (viewGameCrushBinding2 != null && (frameLayout = viewGameCrushBinding2.crushGameLayout) != null) {
                frameLayout.addView(view, -1, -1);
            }
        }
        return Unit.INSTANCE;
    }

    private final ViewGameCrushBinding createCrushView(Context context) {
        ViewDataBinding h = androidx.databinding.g.h(LayoutInflater.from(context), R.layout.view_game_crush, (ViewGroup) null, false);
        Intrinsics.checkNotNullExpressionValue(h, "inflate(...)");
        return (ViewGameCrushBinding) h;
    }

    private final void createViewMode() {
        if (this.gameViewModel == null) {
            final GameViewModel gameViewModel = new GameViewModel();
            gameViewModel.setGameCode(this.fragment.getMViewModel().getMGameCode());
            gameViewModel.setGameListener(new SudFSMMGListener() { // from class: com.qiahao.nextvideo.room.help.CrushGameHelp$createViewMode$1$1
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
                    FrameLayout frameLayout;
                    Intrinsics.checkNotNullParameter(handle, "handle");
                    rf.a.S(this, handle, model);
                    boolean z = true;
                    int i = 0;
                    if (model != null && model.gameState == 2) {
                        SUDGameData mCrushGameData = MeetingRoomManager.INSTANCE.getMCrushGameData();
                        if (mCrushGameData != null) {
                            mCrushGameData.setStatus(1);
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
                            SUDGameData mCrushGameData2 = MeetingRoomManager.INSTANCE.getMCrushGameData();
                            if (mCrushGameData2 != null) {
                                mCrushGameData2.setStatus(0);
                            }
                            this.refreshGameData();
                        }
                    }
                    CrushGameHelp crushGameHelp = this;
                    if (model != null) {
                        i = model.gameState;
                    }
                    crushGameHelp.setLocalGameStore(i);
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
            SudFSTAPPDecorator sudFSTAPPDecorator = gameViewModel.getSudFSTAPPDecorator();
            if (sudFSTAPPDecorator != null) {
                sudFSTAPPDecorator.setOnNotifyStateChangeListener(new SudFSTAPPDecorator.OnNotifyStateChangeListener() { // from class: com.qiahao.nextvideo.room.help.n4
                    @Override // tech.sud.mgp.SudMGPWrapper.decorator.SudFSTAPPDecorator.OnNotifyStateChangeListener
                    public final void onNotifyStateChange(String str, String str2) {
                        CrushGameHelp.createViewMode$lambda$2(CrushGameHelp.this, str, str2);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createViewMode$lambda$2(CrushGameHelp crushGameHelp, String str, String str2) {
        int i;
        GameConfigModel gameConfigModel;
        int i2;
        if (Intrinsics.areEqual(str, SudMGPAPPState.APP_COMMON_OPEN_SOUND)) {
            SudMGPAPPState.APPCommonOpenSound aPPCommonOpenSound = (SudMGPAPPState.APPCommonOpenSound) BaseApplication.Companion.getGSON().j(str2, SudMGPAPPState.APPCommonOpenSound.class);
            GameViewModel gameViewModel = crushGameHelp.gameViewModel;
            if (gameViewModel != null && (gameConfigModel = gameViewModel.getGameConfigModel()) != null) {
                if (!aPPCommonOpenSound.isOpen) {
                    i2 = 0;
                } else {
                    i2 = 100;
                }
                gameConfigModel.gameSoundVolume = i2;
            }
            ViewGameCrushBinding viewGameCrushBinding = crushGameHelp.mCrushBinding;
            if (viewGameCrushBinding != null) {
                ImageView imageView = viewGameCrushBinding.sound;
                Context context = viewGameCrushBinding.getRoot().getContext();
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
        SUDGameData mCrushGameData = MeetingRoomManager.INSTANCE.getMCrushGameData();
        if (mCrushGameData != null) {
            RoomViewModel mViewModel = this.fragment.getMViewModel();
            long gameId = mCrushGameData.getGameId();
            GameViewModel gameViewModel = this.gameViewModel;
            if (gameViewModel == null || (str = gameViewModel.getGameCode()) == null) {
                str = "";
            }
            mViewModel.sudGameReport(gameId, 2, str, new Function0() { // from class: com.qiahao.nextvideo.room.help.l4
                public final Object invoke() {
                    Unit exitGame$lambda$24$lambda$22;
                    exitGame$lambda$24$lambda$22 = CrushGameHelp.exitGame$lambda$24$lambda$22(isOwn, this);
                    return exitGame$lambda$24$lambda$22;
                }
            }, new Function1() { // from class: com.qiahao.nextvideo.room.help.m4
                public final Object invoke(Object obj) {
                    Unit exitGame$lambda$24$lambda$23;
                    exitGame$lambda$24$lambda$23 = CrushGameHelp.exitGame$lambda$24$lambda$23(CrushGameHelp.this, (Throwable) obj);
                    return exitGame$lambda$24$lambda$23;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void exitGame$default(CrushGameHelp crushGameHelp, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = Boolean.FALSE;
        }
        crushGameHelp.exitGame(bool);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit exitGame$lambda$24$lambda$22(Boolean bool, CrushGameHelp crushGameHelp) {
        AudioGameHelp mGameHelp;
        if (Intrinsics.areEqual(bool, Boolean.TRUE) && (mGameHelp = crushGameHelp.fragment.getMGameHelp()) != null) {
            mGameHelp.releaseGame(true, false);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit exitGame$lambda$24$lambda$23(CrushGameHelp crushGameHelp, Throwable th) {
        String str;
        Intrinsics.checkNotNullParameter(th, "it");
        if (th instanceof HiloException) {
            HiloToasty.Companion companion = HiloToasty.Companion;
            Context context = crushGameHelp.fragment.getContext();
            String errorMessage = ((HiloException) th).getErrorMessage();
            if (errorMessage == null) {
                str = ResourcesKtxKt.getStringById(crushGameHelp, 2131952667);
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
    public static final Unit playerJoin$lambda$21$lambda$20(CrushGameHelp crushGameHelp, Throwable th) {
        String str;
        Intrinsics.checkNotNullParameter(th, "it");
        if (th instanceof HiloException) {
            HiloException hiloException = (HiloException) th;
            if (hiloException.getCode() == 4000) {
                final FragmentActivity activity = crushGameHelp.fragment.getActivity();
                if (activity != null) {
                    new RoomTipDialog(activity).setTipContent(ResourcesKtxKt.getStringById(crushGameHelp, 2131953126)).setDialogListener(new OnCommonDialogListener() { // from class: com.qiahao.nextvideo.room.help.CrushGameHelp$playerJoin$1$1$1$1
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
                Context context = crushGameHelp.fragment.getContext();
                String errorMessage = hiloException.getErrorMessage();
                if (errorMessage == null) {
                    str = ResourcesKtxKt.getStringById(crushGameHelp, 2131952667);
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

    static /* synthetic */ void refreshUser$default(CrushGameHelp crushGameHelp, IncludeLudoItemBinding includeLudoItemBinding, SUDPlayerData sUDPlayerData, int i, Object obj) {
        if ((i & 2) != 0) {
            sUDPlayerData = null;
        }
        crushGameHelp.refreshUser(includeLudoItemBinding, sUDPlayerData);
    }

    public static /* synthetic */ void releaseGame$default(CrushGameHelp crushGameHelp, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        crushGameHelp.releaseGame(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showGameEndDialog$lambda$32$lambda$31$lambda$29(final CrushGameHelp crushGameHelp, final FragmentActivity fragmentActivity, final CrushEndDialog crushEndDialog) {
        CreateSudData mCreateCrushData = MeetingRoomManager.INSTANCE.getMCreateCrushData();
        if (mCreateCrushData != null) {
            crushGameHelp.fragment.getMViewModel().createSudGame(mCreateCrushData, new Function0() { // from class: com.qiahao.nextvideo.room.help.j4
                public final Object invoke() {
                    Unit showGameEndDialog$lambda$32$lambda$31$lambda$29$lambda$28$lambda$26;
                    showGameEndDialog$lambda$32$lambda$31$lambda$29$lambda$28$lambda$26 = CrushGameHelp.showGameEndDialog$lambda$32$lambda$31$lambda$29$lambda$28$lambda$26(CrushGameHelp.this);
                    return showGameEndDialog$lambda$32$lambda$31$lambda$29$lambda$28$lambda$26;
                }
            }, new Function1() { // from class: com.qiahao.nextvideo.room.help.k4
                public final Object invoke(Object obj) {
                    Unit showGameEndDialog$lambda$32$lambda$31$lambda$29$lambda$28$lambda$27;
                    showGameEndDialog$lambda$32$lambda$31$lambda$29$lambda$28$lambda$27 = CrushGameHelp.showGameEndDialog$lambda$32$lambda$31$lambda$29$lambda$28$lambda$27(fragmentActivity, crushEndDialog, crushGameHelp, (Throwable) obj);
                    return showGameEndDialog$lambda$32$lambda$31$lambda$29$lambda$28$lambda$27;
                }
            });
        }
        AudioGameHelp mGameHelp = crushGameHelp.fragment.getMGameHelp();
        if (mGameHelp != null) {
            mGameHelp.releaseGame(true, false);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showGameEndDialog$lambda$32$lambda$31$lambda$29$lambda$28$lambda$26(CrushGameHelp crushGameHelp) {
        CrushEndDialog crushEndDialog = crushGameHelp.mCrushEndDialog;
        if (crushEndDialog != null) {
            crushEndDialog.dismiss();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showGameEndDialog$lambda$32$lambda$31$lambda$29$lambda$28$lambda$27(final FragmentActivity fragmentActivity, CrushEndDialog crushEndDialog, CrushGameHelp crushGameHelp, Throwable th) {
        if (th instanceof HiloException) {
            HiloException hiloException = (HiloException) th;
            if (hiloException.getCode() == 4000) {
                new RoomTipDialog(fragmentActivity).setTipContent(ResourcesKtxKt.getStringById(crushEndDialog, 2131953126)).setDialogListener(new OnCommonDialogListener() { // from class: com.qiahao.nextvideo.room.help.CrushGameHelp$showGameEndDialog$1$1$1$1$2$1
                    public void cancel() {
                        OnCommonDialogListener.DefaultImpls.cancel(this);
                    }

                    public void confirm() {
                        WalletActivity.INSTANCE.start(fragmentActivity);
                    }
                }).show();
            } else {
                HiloToasty.Companion companion = HiloToasty.Companion;
                Context context = crushGameHelp.fragment.getContext();
                String errorMessage = hiloException.getErrorMessage();
                if (errorMessage == null) {
                    errorMessage = ResourcesKtxKt.getStringById(crushEndDialog, 2131952667);
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
    public static final void showGameEndDialog$lambda$32$lambda$31$lambda$30(CrushGameHelp crushGameHelp, DialogInterface dialogInterface) {
        AudioGameHelp mGameHelp = crushGameHelp.fragment.getMGameHelp();
        if (mGameHelp != null) {
            mGameHelp.releaseGame(true, false);
        }
        crushGameHelp.mCrushEndDialog = null;
    }

    private final void startCountDown() {
        final FragmentActivity activity = this.fragment.getActivity();
        if (activity != null) {
            CountDownTimer countDownTimer = this.timerTask;
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            this.timerTask = null;
            CountDownTimer countDownTimer2 = new CountDownTimer() { // from class: com.qiahao.nextvideo.room.help.CrushGameHelp$startCountDown$1$1
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
                    ViewGameCrushBinding mCrushBinding = CrushGameHelp.this.getMCrushBinding();
                    if (mCrushBinding != null && (textView = mCrushBinding.waitText) != null) {
                        textView.setText(ResourcesKtxKt.getStringById(this, 2131953295));
                    }
                    String str2 = null;
                    CrushGameHelp.this.setTimerTask(null);
                    MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
                    SUDGameData mCrushGameData = meetingRoomManager.getMCrushGameData();
                    if (mCrushGameData != null) {
                        str = mCrushGameData.getExternalId();
                    } else {
                        str = null;
                    }
                    User user = UserStore.INSTANCE.getShared().getUser();
                    if (user != null) {
                        str2 = user.getExternalId();
                    }
                    if (Intrinsics.areEqual(str, str2)) {
                        SUDGameData mCrushGameData2 = meetingRoomManager.getMCrushGameData();
                        if (mCrushGameData2 != null && (players = mCrushGameData2.getPlayers()) != null) {
                            i = players.size();
                        } else {
                            i = 0;
                        }
                        if (i < 2) {
                            Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, CrushGameHelp.this.getFragment().getContext(), ResourcesKtxKt.getStringById(this, 2131953541), false, 4, (Object) null);
                            if (normal$default != null) {
                                normal$default.show();
                            }
                            CrushGameHelp.this.exitGame(Boolean.TRUE);
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
                    ViewGameCrushBinding mCrushBinding = CrushGameHelp.this.getMCrushBinding();
                    if (mCrushBinding != null && (textView = mCrushBinding.waitText) != null) {
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
    public final View addCrushGameView() {
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
            ViewGameCrushBinding viewGameCrushBinding = this.mCrushBinding;
            if (viewGameCrushBinding != null) {
                view2 = viewGameCrushBinding.getRoot();
            } else {
                view2 = null;
            }
            if (!Intrinsics.areEqual(view, view2)) {
                LogUtil.e$default(LogUtil.INSTANCE, "eTag", "添加Domino 游戏的View 之前需要删除", false, 4, (Object) null);
                FragmentAudioRoomBinding binding3 = this.fragment.getBinding();
                if (binding3 != null && (frameLayout = binding3.gameLayout) != null) {
                    frameLayout.removeAllViews();
                }
            }
        }
        createViewMode();
        FragmentAudioRoomBinding binding4 = this.fragment.getBinding();
        if ((binding4 != null && (frameLayout4 = binding4.gameLayout) != null && frameLayout4.getChildCount() == 0) || this.mCrushBinding == null) {
            LogUtil.e$default(LogUtil.INSTANCE, "eTag", "addDominoGameView  创建游戏的View", false, 4, (Object) null);
            Context context = this.fragment.getContext();
            if (context != null) {
                this.mCrushBinding = createCrushView(context);
                GameViewModel gameViewModel = this.gameViewModel;
                if (gameViewModel != null && (gameViewLiveData = gameViewModel.getGameViewLiveData()) != null) {
                    gameViewLiveData.observe(this.fragment, new CrushGameHelp$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.room.help.i4
                        public final Object invoke(Object obj) {
                            Unit addCrushGameView$lambda$4$lambda$3;
                            addCrushGameView$lambda$4$lambda$3 = CrushGameHelp.addCrushGameView$lambda$4$lambda$3(CrushGameHelp.this, (View) obj);
                            return addCrushGameView$lambda$4$lambda$3;
                        }
                    }));
                }
                FragmentAudioRoomBinding binding5 = this.fragment.getBinding();
                if (binding5 != null && (frameLayout3 = binding5.gameLayout) != null) {
                    ViewGameCrushBinding viewGameCrushBinding2 = this.mCrushBinding;
                    if (viewGameCrushBinding2 != null) {
                        view3 = viewGameCrushBinding2.getRoot();
                    } else {
                        view3 = null;
                    }
                    frameLayout3.addView(view3);
                }
                ViewGameCrushBinding viewGameCrushBinding3 = this.mCrushBinding;
                if (viewGameCrushBinding3 != null && (root2 = viewGameCrushBinding3.getRoot()) != null) {
                    layoutParams = root2.getLayoutParams();
                } else {
                    layoutParams = null;
                }
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.height = -1;
                layoutParams2.width = -1;
                layoutParams2.gravity = 17;
                ViewGameCrushBinding viewGameCrushBinding4 = this.mCrushBinding;
                if (viewGameCrushBinding4 != null && (root = viewGameCrushBinding4.getRoot()) != null) {
                    root.setLayoutParams(layoutParams2);
                }
            }
        }
        ViewGameCrushBinding viewGameCrushBinding5 = this.mCrushBinding;
        if (viewGameCrushBinding5 == null) {
            return null;
        }
        return viewGameCrushBinding5.getRoot();
    }

    public final boolean checkMyIsJoin() {
        ArrayList<SUDPlayerData> players;
        String str;
        SUDGameData mCrushGameData = MeetingRoomManager.INSTANCE.getMCrushGameData();
        boolean z = false;
        if (mCrushGameData != null && (players = mCrushGameData.getPlayers()) != null) {
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
    public final ViewGameCrushBinding getMCrushBinding() {
        return this.mCrushBinding;
    }

    @Nullable
    public final CrushEndDialog getMCrushEndDialog() {
        return this.mCrushEndDialog;
    }

    @Nullable
    public final CountDownTimer getTimerTask() {
        return this.timerTask;
    }

    public final void playerJoin() {
        String str;
        SUDGameData mCrushGameData = MeetingRoomManager.INSTANCE.getMCrushGameData();
        if (mCrushGameData != null) {
            RoomViewModel mViewModel = this.fragment.getMViewModel();
            long gameId = mCrushGameData.getGameId();
            GameViewModel gameViewModel = this.gameViewModel;
            if (gameViewModel == null || (str = gameViewModel.getGameCode()) == null) {
                str = "";
            }
            RoomViewModel.sudGameReport$default(mViewModel, gameId, 1, str, null, new Function1() { // from class: com.qiahao.nextvideo.room.help.o4
                public final Object invoke(Object obj) {
                    Unit playerJoin$lambda$21$lambda$20;
                    playerJoin$lambda$21$lambda$20 = CrushGameHelp.playerJoin$lambda$21$lambda$20(CrushGameHelp.this, (Throwable) obj);
                    return playerJoin$lambda$21$lambda$20;
                }
            }, 8, null);
        }
    }

    public final void refreshGameData() {
        ViewGameCrushBinding viewGameCrushBinding;
        int i;
        int i2;
        int i3;
        int i4;
        ConstraintLayout constraintLayout;
        FrameLayout frameLayout;
        boolean z;
        int i5;
        int i6;
        TextView textView;
        SudFSTAPPDecorator sudFSTAPPDecorator;
        boolean z2;
        GameConfigModel gameConfigModel;
        GameConfigModel gameConfigModel2;
        Long l;
        Long l2;
        ConstraintLayout constraintLayout2;
        FrameLayout frameLayout2;
        ConstraintLayout constraintLayout3;
        FrameLayout frameLayout3;
        SUDPlayerData sUDPlayerData;
        SUDPlayerData sUDPlayerData2;
        SUDPlayerData sUDPlayerData3;
        SUDPlayerData sUDPlayerData4;
        final SUDGameData mCrushGameData = MeetingRoomManager.INSTANCE.getMCrushGameData();
        if (mCrushGameData != null && (viewGameCrushBinding = this.mCrushBinding) != null) {
            TextView textView2 = viewGameCrushBinding.betDiamond;
            String format = String.format(ResourcesKtxKt.getStringById(this, 2131953280), Arrays.copyOf(new Object[]{String.valueOf(mCrushGameData.getDiamond())}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            textView2.setText(format);
            ArrayList<SUDPlayerData> players = mCrushGameData.getPlayers();
            if (players != null) {
                i = players.size();
            } else {
                i = 0;
            }
            String str = null;
            if (i >= 1) {
                IncludeLudoItemBinding includeLudoItemBinding = viewGameCrushBinding.oneUser;
                Intrinsics.checkNotNullExpressionValue(includeLudoItemBinding, "oneUser");
                ArrayList<SUDPlayerData> players2 = mCrushGameData.getPlayers();
                if (players2 != null) {
                    sUDPlayerData4 = players2.get(0);
                } else {
                    sUDPlayerData4 = null;
                }
                refreshUser(includeLudoItemBinding, sUDPlayerData4);
            } else {
                QMUIRadiusImageView qMUIRadiusImageView = viewGameCrushBinding.oneUser.avatar;
                Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView, "avatar");
                ImageKtxKt.loadImage$default(qMUIRadiusImageView, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.ludo_player_default_icon), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
                TextView textView3 = viewGameCrushBinding.oneUser.nickName;
                String format2 = String.format(ResourcesKtxKt.getStringById(this, 2131953291), Arrays.copyOf(new Object[]{1}, 1));
                Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
                textView3.setText(format2);
            }
            ArrayList<SUDPlayerData> players3 = mCrushGameData.getPlayers();
            if (players3 != null) {
                i2 = players3.size();
            } else {
                i2 = 0;
            }
            if (i2 > 1) {
                IncludeLudoItemBinding includeLudoItemBinding2 = viewGameCrushBinding.twoUser;
                Intrinsics.checkNotNullExpressionValue(includeLudoItemBinding2, "twoUser");
                ArrayList<SUDPlayerData> players4 = mCrushGameData.getPlayers();
                if (players4 != null) {
                    sUDPlayerData3 = players4.get(1);
                } else {
                    sUDPlayerData3 = null;
                }
                refreshUser(includeLudoItemBinding2, sUDPlayerData3);
            } else {
                QMUIRadiusImageView qMUIRadiusImageView2 = viewGameCrushBinding.twoUser.avatar;
                Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView2, "avatar");
                ImageKtxKt.loadImage$default(qMUIRadiusImageView2, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.ludo_player_default_icon), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
                TextView textView4 = viewGameCrushBinding.twoUser.nickName;
                String format3 = String.format(ResourcesKtxKt.getStringById(this, 2131953291), Arrays.copyOf(new Object[]{2}, 1));
                Intrinsics.checkNotNullExpressionValue(format3, "format(...)");
                textView4.setText(format3);
            }
            ArrayList<SUDPlayerData> players5 = mCrushGameData.getPlayers();
            if (players5 != null) {
                i3 = players5.size();
            } else {
                i3 = 0;
            }
            if (i3 > 2) {
                IncludeLudoItemBinding includeLudoItemBinding3 = viewGameCrushBinding.threeUser;
                Intrinsics.checkNotNullExpressionValue(includeLudoItemBinding3, "threeUser");
                ArrayList<SUDPlayerData> players6 = mCrushGameData.getPlayers();
                if (players6 != null) {
                    sUDPlayerData2 = players6.get(2);
                } else {
                    sUDPlayerData2 = null;
                }
                refreshUser(includeLudoItemBinding3, sUDPlayerData2);
            } else {
                QMUIRadiusImageView qMUIRadiusImageView3 = viewGameCrushBinding.threeUser.avatar;
                Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView3, "avatar");
                ImageKtxKt.loadImage$default(qMUIRadiusImageView3, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.ludo_player_default_icon), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
                TextView textView5 = viewGameCrushBinding.threeUser.nickName;
                String format4 = String.format(ResourcesKtxKt.getStringById(this, 2131953291), Arrays.copyOf(new Object[]{3}, 1));
                Intrinsics.checkNotNullExpressionValue(format4, "format(...)");
                textView5.setText(format4);
            }
            ArrayList<SUDPlayerData> players7 = mCrushGameData.getPlayers();
            if (players7 != null) {
                i4 = players7.size();
            } else {
                i4 = 0;
            }
            if (i4 > 3) {
                IncludeLudoItemBinding includeLudoItemBinding4 = viewGameCrushBinding.fourUser;
                Intrinsics.checkNotNullExpressionValue(includeLudoItemBinding4, "fourUser");
                ArrayList<SUDPlayerData> players8 = mCrushGameData.getPlayers();
                if (players8 != null) {
                    sUDPlayerData = players8.get(3);
                } else {
                    sUDPlayerData = null;
                }
                refreshUser(includeLudoItemBinding4, sUDPlayerData);
            } else {
                QMUIRadiusImageView qMUIRadiusImageView4 = viewGameCrushBinding.fourUser.avatar;
                Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView4, "avatar");
                ImageKtxKt.loadImage$default(qMUIRadiusImageView4, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.ludo_player_default_icon), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
                TextView textView6 = viewGameCrushBinding.fourUser.nickName;
                String format5 = String.format(ResourcesKtxKt.getStringById(this, 2131953291), Arrays.copyOf(new Object[]{4}, 1));
                Intrinsics.checkNotNullExpressionValue(format5, "format(...)");
                textView6.setText(format5);
            }
            if (this.gameProgress == 100) {
                if (mCrushGameData.getStatus() != 0 && mCrushGameData.getStatus() != 2) {
                    if (mCrushGameData.getStatus() == 1) {
                        viewGameCrushBinding.diamondText.setText(String.valueOf(mCrushGameData.getDiamond()));
                        viewGameCrushBinding.diamondTwo.setVisibility(0);
                        ViewGameCrushBinding viewGameCrushBinding2 = this.mCrushBinding;
                        if (viewGameCrushBinding2 != null && (frameLayout3 = viewGameCrushBinding2.crushGameLayout) != null) {
                            frameLayout3.setAlpha(1.0f);
                        }
                        ViewGameCrushBinding viewGameCrushBinding3 = this.mCrushBinding;
                        if (viewGameCrushBinding3 != null && (constraintLayout3 = viewGameCrushBinding3.prepareLayout) != null) {
                            constraintLayout3.setVisibility(8);
                        }
                        viewGameCrushBinding.diamond.setVisibility(8);
                        viewGameCrushBinding.add.setVisibility(8);
                    }
                } else {
                    LogUtil logUtil = LogUtil.INSTANCE;
                    UserStore.Companion companion = UserStore.INSTANCE;
                    User user = companion.getShared().getUser();
                    if (user != null) {
                        l = Long.valueOf((long) user.getDiamondNum());
                    } else {
                        l = null;
                    }
                    LogUtil.e$default(logUtil, "eTag", "打印金币" + l, false, 4, (Object) null);
                    TextView textView7 = viewGameCrushBinding.diamondText;
                    User user2 = companion.getShared().getUser();
                    if (user2 != null) {
                        l2 = Long.valueOf((long) user2.getDiamondNum());
                    } else {
                        l2 = null;
                    }
                    textView7.setText(String.valueOf(l2));
                    viewGameCrushBinding.diamond.setVisibility(0);
                    viewGameCrushBinding.add.setVisibility(0);
                    ViewGameCrushBinding viewGameCrushBinding4 = this.mCrushBinding;
                    if (viewGameCrushBinding4 != null && (frameLayout2 = viewGameCrushBinding4.crushGameLayout) != null) {
                        frameLayout2.setAlpha(0.01f);
                    }
                    ViewGameCrushBinding viewGameCrushBinding5 = this.mCrushBinding;
                    if (viewGameCrushBinding5 != null && (constraintLayout2 = viewGameCrushBinding5.prepareLayout) != null) {
                        constraintLayout2.setVisibility(0);
                    }
                    viewGameCrushBinding.diamondTwo.setVisibility(8);
                }
            } else {
                ViewGameCrushBinding viewGameCrushBinding6 = this.mCrushBinding;
                if (viewGameCrushBinding6 != null && (frameLayout = viewGameCrushBinding6.crushGameLayout) != null) {
                    frameLayout.setAlpha(1.0f);
                }
                ViewGameCrushBinding viewGameCrushBinding7 = this.mCrushBinding;
                if (viewGameCrushBinding7 != null && (constraintLayout = viewGameCrushBinding7.prepareLayout) != null) {
                    constraintLayout.setVisibility(8);
                }
                viewGameCrushBinding.diamondTwo.setVisibility(8);
            }
            final ImageView imageView = viewGameCrushBinding.add;
            final long j = 800;
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.help.CrushGameHelp$refreshGameData$lambda$15$$inlined$singleClick$default$1
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
            final ConstraintLayout constraintLayout4 = viewGameCrushBinding.prepareTop;
            final long j2 = 800;
            constraintLayout4.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.help.CrushGameHelp$refreshGameData$lambda$15$$inlined$singleClick$default$2
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
                        String externalId = mCrushGameData.getExternalId();
                        User user3 = UserStore.INSTANCE.getShared().getUser();
                        GameConfigLudo gameConfigLudo = null;
                        if (user3 != null) {
                            str2 = user3.getExternalId();
                        } else {
                            str2 = null;
                        }
                        if (Intrinsics.areEqual(externalId, str2) && (activity = this.getFragment().getActivity()) != null) {
                            CreateSudData createSudData = new CreateSudData(mCrushGameData.getGameType(), mCrushGameData.getMode(), mCrushGameData.getPiece(), mCrushGameData.getOnOff1(), mCrushGameData.getDiamond(), mCrushGameData.getAutoMatch(), MeetingRoomManager.INSTANCE.getMGroupId(), Long.valueOf(mCrushGameData.getGameId()));
                            GameViewModel gameViewModel = this.getGameViewModel();
                            if (gameViewModel != null) {
                                str3 = gameViewModel.getGameCode();
                            } else {
                                str3 = null;
                            }
                            GroupDetailBean groupDetailBean = (GroupDetailBean) this.getFragment().getMViewModel().getMGroupDetailBean().getValue();
                            if (groupDetailBean != null && (gameConfig = groupDetailBean.getGameConfig()) != null) {
                                gameConfigLudo = gameConfig.getDomino();
                            }
                            new CreateCrushDialog(activity, createSudData, str3, gameConfigLudo).show();
                        }
                    }
                }
            });
            ImageView imageView2 = viewGameCrushBinding.sound;
            Context context = viewGameCrushBinding.getRoot().getContext();
            GameViewModel gameViewModel = this.gameViewModel;
            if (gameViewModel != null && (gameConfigModel2 = gameViewModel.getGameConfigModel()) != null && gameConfigModel2.gameSoundVolume == 100) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                i5 = R.drawable.uno_prepare_icon_sound;
            } else {
                i5 = R.drawable.uno_prepare_icon_sound_no;
            }
            imageView2.setImageDrawable(androidx.core.content.a.getDrawable(context, i5));
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
            final ImageView imageView3 = viewGameCrushBinding.sound;
            imageView3.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.help.CrushGameHelp$refreshGameData$lambda$15$$inlined$singleClick$default$3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SudFSTAPPDecorator sudFSTAPPDecorator2;
                    SudFSTAPPDecorator sudFSTAPPDecorator3;
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
                        if (gameViewModel5 != null && (sudFSTAPPDecorator3 = gameViewModel5.getSudFSTAPPDecorator()) != null) {
                            sudFSTAPPDecorator3.notifyAPPCommonOpenBgMusic(!z3);
                        }
                        GameViewModel gameViewModel6 = this.getGameViewModel();
                        if (gameViewModel6 != null && (sudFSTAPPDecorator2 = gameViewModel6.getSudFSTAPPDecorator()) != null) {
                            sudFSTAPPDecorator2.notifyAPPCommonOpenSound(!z3);
                        }
                    }
                }
            });
            final ImageView imageView4 = viewGameCrushBinding.information;
            imageView4.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.help.CrushGameHelp$refreshGameData$lambda$15$$inlined$singleClick$default$4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(imageView4) > j || (imageView4 instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(imageView4, currentTimeMillis);
                        FragmentActivity activity = this.getFragment().getActivity();
                        if (activity != null) {
                            new CrushIntroduceDialog(activity).show();
                        }
                    }
                }
            });
            final ImageView imageView5 = viewGameCrushBinding.close;
            imageView5.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.help.CrushGameHelp$refreshGameData$lambda$15$$inlined$singleClick$default$5
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
            String externalId = mCrushGameData.getExternalId();
            User user3 = UserStore.INSTANCE.getShared().getUser();
            if (user3 != null) {
                str = user3.getExternalId();
            }
            if (Intrinsics.areEqual(externalId, str)) {
                viewGameCrushBinding.button.setText(ResourcesKtxKt.getStringById(this, 2131952968));
                viewGameCrushBinding.button.setTextColor(androidx.core.content.a.getColor(viewGameCrushBinding.getRoot().getContext(), 2131099870));
                viewGameCrushBinding.button.setBackground(androidx.core.content.a.getDrawable(viewGameCrushBinding.getRoot().getContext(), R.drawable.ludo_prepare_icon_quit));
            } else if (!checkMyIsJoin()) {
                viewGameCrushBinding.button.setText(ResourcesKtxKt.getStringById(this, 2131953154));
                viewGameCrushBinding.button.setTextColor(androidx.core.content.a.getColor(viewGameCrushBinding.getRoot().getContext(), 2131099959));
                viewGameCrushBinding.button.setBackground(androidx.core.content.a.getDrawable(viewGameCrushBinding.getRoot().getContext(), R.drawable.ludo_prepare_icon_start));
            } else {
                viewGameCrushBinding.button.setTextColor(androidx.core.content.a.getColor(viewGameCrushBinding.getRoot().getContext(), 2131099870));
                viewGameCrushBinding.button.setBackground(androidx.core.content.a.getDrawable(viewGameCrushBinding.getRoot().getContext(), R.drawable.ludo_prepare_icon_quit));
                viewGameCrushBinding.button.setText(ResourcesKtxKt.getStringById(this, 2131953815));
            }
            ArrayList<SUDPlayerData> players9 = mCrushGameData.getPlayers();
            if (players9 != null) {
                i6 = players9.size();
            } else {
                i6 = 0;
            }
            if (i6 >= 2) {
                startCountDown();
            } else {
                ViewGameCrushBinding viewGameCrushBinding8 = this.mCrushBinding;
                if (viewGameCrushBinding8 != null && (textView = viewGameCrushBinding8.waitText) != null) {
                    textView.setText(ResourcesKtxKt.getStringById(this, 2131953295));
                }
            }
            final ConstraintLayout constraintLayout5 = viewGameCrushBinding.prepareLayout;
            constraintLayout5.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.help.CrushGameHelp$refreshGameData$lambda$15$$inlined$singleClick$default$6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(constraintLayout5) > j || (constraintLayout5 instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(constraintLayout5, currentTimeMillis);
                        ConstraintLayout constraintLayout6 = constraintLayout5;
                    }
                }
            });
            final TextView textView8 = viewGameCrushBinding.button;
            final long j3 = 800;
            textView8.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.help.CrushGameHelp$refreshGameData$lambda$15$$inlined$singleClick$default$7
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    String str2;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView8) > j3 || (textView8 instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(textView8, currentTimeMillis);
                        String externalId2 = mCrushGameData.getExternalId();
                        UserStore.Companion companion2 = UserStore.INSTANCE;
                        User user4 = companion2.getShared().getUser();
                        String str3 = null;
                        if (user4 != null) {
                            str2 = user4.getExternalId();
                        } else {
                            str2 = null;
                        }
                        if (Intrinsics.areEqual(externalId2, str2)) {
                            this.exitGame(Boolean.TRUE);
                            return;
                        }
                        if (!this.checkMyIsJoin()) {
                            MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
                            User user5 = companion2.getShared().getUser();
                            if (user5 != null) {
                                str3 = user5.getExternalId();
                            }
                            if (meetingRoomManager.checkUserOnMic(str3)) {
                                this.playerJoin();
                                return;
                            }
                            AudioRoomDialogHelp mDialogHelp = this.getFragment().getMDialogHelp();
                            if (mDialogHelp != null) {
                                mDialogHelp.autoOnMic(RoomViewModel.MIC_JOIN_CRUSH);
                                return;
                            }
                            return;
                        }
                        CrushGameHelp.exitGame$default(this, null, 1, null);
                    }
                }
            });
        }
    }

    public final void releaseGame(boolean callReport) {
        FrameLayout frameLayout;
        SUDGameData mCrushGameData;
        String str;
        if (callReport && (mCrushGameData = MeetingRoomManager.INSTANCE.getMCrushGameData()) != null) {
            AppRequestUtils appRequestUtils = AppRequestUtils.INSTANCE;
            long gameId = mCrushGameData.getGameId();
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
        this.mCrushBinding = null;
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

    public final void setMCrushBinding(@Nullable ViewGameCrushBinding viewGameCrushBinding) {
        this.mCrushBinding = viewGameCrushBinding;
    }

    public final void setMCrushEndDialog(@Nullable CrushEndDialog crushEndDialog) {
        this.mCrushEndDialog = crushEndDialog;
    }

    public final void setTimerTask(@Nullable CountDownTimer countDownTimer) {
        this.timerTask = countDownTimer;
    }

    /* JADX WARN: Type inference failed for: r7v0, types: [android.app.Dialog, com.qiahao.nextvideo.room.game.CrushEndDialog] */
    public final void showGameEndDialog(@NotNull SUDGameAward ludoGameAward) {
        Intrinsics.checkNotNullParameter(ludoGameAward, "ludoGameAward");
        final FragmentActivity activity = this.fragment.getActivity();
        if (activity != null) {
            CrushEndDialog crushEndDialog = this.mCrushEndDialog;
            if (crushEndDialog != null && crushEndDialog != null) {
                crushEndDialog.dismiss();
            }
            final ?? crushEndDialog2 = new CrushEndDialog(activity, ludoGameAward, false, 4, null);
            crushEndDialog2.setListener(new Function0() { // from class: com.qiahao.nextvideo.room.help.g4
                public final Object invoke() {
                    Unit showGameEndDialog$lambda$32$lambda$31$lambda$29;
                    showGameEndDialog$lambda$32$lambda$31$lambda$29 = CrushGameHelp.showGameEndDialog$lambda$32$lambda$31$lambda$29(CrushGameHelp.this, activity, crushEndDialog2);
                    return showGameEndDialog$lambda$32$lambda$31$lambda$29;
                }
            });
            crushEndDialog2.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.qiahao.nextvideo.room.help.h4
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    CrushGameHelp.showGameEndDialog$lambda$32$lambda$31$lambda$30(CrushGameHelp.this, dialogInterface);
                }
            });
            this.mCrushEndDialog = crushEndDialog2;
            crushEndDialog2.show();
        }
    }
}
