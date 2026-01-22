package com.qiahao.nextvideo.sud;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.nextvideo.sheep.GameMatchActivity;
import com.taobao.accs.common.Constants;
import com.tencent.qcloud.tuicore.TUIConstants;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.android.agoo.common.AgooConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tech.sud.gip.core.ISudFSMStateHandle;
import tech.sud.gip.core.ISudFSTAPP;
import tech.sud.gip.core.ISudListenerInitSDK;
import tech.sud.mgp.SudMGPWrapper.decorator.SudFSMMGDecorator;
import tech.sud.mgp.SudMGPWrapper.decorator.SudFSMMGListener;
import tech.sud.mgp.SudMGPWrapper.decorator.SudFSTAPPDecorator;
import tech.sud.mgp.SudMGPWrapper.model.GameConfigModel;
import tech.sud.mgp.SudMGPWrapper.model.GameViewInfoModel;
import tech.sud.mgp.SudMGPWrapper.state.MGStateResponse;
import tech.sud.mgp.SudMGPWrapper.utils.SudJsonUtils;
import tech.sud.mgp.core.SudMGP;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001:\u0001QB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\nJ\u0018\u0010*\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\nH\u0002J \u0010+\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\n2\u0006\u0010,\u001a\u00020\u0005H\u0002J \u0010-\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010,\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\nH\u0002J\u0018\u0010.\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\nH\u0002J\u0006\u0010/\u001a\u00020&J\b\u00100\u001a\u00020&H\u0002J0\u00101\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(2\b\u00102\u001a\u0004\u0018\u00010\u00052\b\u00103\u001a\u0004\u0018\u00010\u00052\b\u00104\u001a\u0004\u0018\u000105H$J\u0012\u0010<\u001a\u00020&2\b\u0010=\u001a\u0004\u0018\u00010>H$J\u0012\u0010E\u001a\u00020&2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H$J\b\u0010F\u001a\u00020&H$J\u0016\u0010G\u001a\u00020&2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010H\u001a\u00020IJ\u0018\u0010J\u001a\u00020&2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010H\u001a\u00020IJ \u0010K\u001a\u00020&2\u0006\u0010H\u001a\u00020I2\u0006\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u00020MH\u0002J\u0018\u0010O\u001a\u00020&2\u0006\u0010H\u001a\u00020I2\b\u0010P\u001a\u0004\u0018\u00010\u0005R\"\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001b\u0010\u001b\u001a\u00020\u001c8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010!\u001a\u00020\"X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0014\u00102\u001a\u0004\u0018\u00010\u0005X¤\u0004¢\u0006\u0006\u001a\u0004\b6\u0010\bR\u0014\u00103\u001a\u0004\u0018\u00010\u0005X¤\u0004¢\u0006\u0006\u001a\u0004\b7\u0010\bR\u0012\u00108\u001a\u00020\u0005X¤\u0004¢\u0006\u0006\u001a\u0004\b9\u0010\bR\u0014\u0010:\u001a\u0004\u0018\u00010\u0005X¤\u0004¢\u0006\u0006\u001a\u0004\b;\u0010\bR\u0012\u0010?\u001a\u00020\u0014X¤\u0004¢\u0006\u0006\u001a\u0004\b?\u0010@R\u0014\u0010A\u001a\u0004\u0018\u00010BX¤\u0004¢\u0006\u0006\u001a\u0004\bC\u0010D¨\u0006R"}, d2 = {"Lcom/qiahao/nextvideo/sud/BaseGameViewModel;", "", "<init>", "()V", "value", "", "gameRoomId", "getGameRoomId", "()Ljava/lang/String;", "playingGameId", "", "sudFSTAPPDecorator", "Ltech/sud/mgp/SudMGPWrapper/decorator/SudFSTAPPDecorator;", "getSudFSTAPPDecorator", "()Ltech/sud/mgp/SudMGPWrapper/decorator/SudFSTAPPDecorator;", "sudFSMMGDecorator", "Ltech/sud/mgp/SudMGPWrapper/decorator/SudFSMMGDecorator;", "getSudFSMMGDecorator", "()Ltech/sud/mgp/SudMGPWrapper/decorator/SudFSMMGDecorator;", "isRunning", "", "gameView", "Landroid/view/View;", "getGameView", "()Landroid/view/View;", "setGameView", "(Landroid/view/View;)V", "gameConfigModel", "Ltech/sud/mgp/SudMGPWrapper/model/GameConfigModel;", "getGameConfigModel", "()Ltech/sud/mgp/SudMGPWrapper/model/GameConfigModel;", "gameConfigModel$delegate", "Lkotlin/Lazy;", "handler", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "switchGame", "", AgooConstants.OPEN_ACTIIVTY_NAME, "Landroidx/fragment/app/FragmentActivity;", GameMatchActivity.GAME_ID, "login", "initSdk", Constants.KEY_HTTP_CODE, "loadGame", "delayLoadGame", "onDestroy", "destroyMG", "getCode", TUIConstants.TUILive.USER_ID, "appId", "listener", "Lcom/qiahao/nextvideo/sud/BaseGameViewModel$GameGetCodeListener;", "getUserId", "getAppId", Constants.KEY_APP_KEY, "getAppKey", "languageCode", "getLanguageCode", "getGameRect", "gameViewInfoModel", "Ltech/sud/mgp/SudMGPWrapper/model/GameViewInfoModel;", "isTestEnv", "()Z", "sudFSMMGListener", "Ltech/sud/mgp/SudMGPWrapper/decorator/SudFSMMGListener;", "getSudFSMMGListener", "()Ltech/sud/mgp/SudMGPWrapper/decorator/SudFSMMGListener;", "onAddGameView", "onRemoveGameView", "processOnExpireCode", "handle", "Ltech/sud/gip/core/ISudFSMStateHandle;", "processOnGetGameViewInfo", "notifyGameViewInfo", "gameViewWidth", "", "gameViewHeight", "processOnGetGameCfg", "dataJson", "GameGetCodeListener", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class BaseGameViewModel {

    @Nullable
    private String gameRoomId;

    @Nullable
    private View gameView;
    private long playingGameId;

    @NotNull
    private final SudFSTAPPDecorator sudFSTAPPDecorator = new SudFSTAPPDecorator();

    @NotNull
    private final SudFSMMGDecorator sudFSMMGDecorator = new SudFSMMGDecorator();
    private boolean isRunning = true;

    /* renamed from: gameConfigModel$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy gameConfigModel = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.sud.b
        public final Object invoke() {
            GameConfigModel gameConfigModel_delegate$lambda$2;
            gameConfigModel_delegate$lambda$2 = BaseGameViewModel.gameConfigModel_delegate$lambda$2();
            return gameConfigModel_delegate$lambda$2;
        }
    });

    @NotNull
    private final Handler handler = new Handler(Looper.getMainLooper());

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&¨\u0006\u0007"}, d2 = {"Lcom/qiahao/nextvideo/sud/BaseGameViewModel$GameGetCodeListener;", "", "onSuccess", "", Constants.KEY_HTTP_CODE, "", "onFailed", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public interface GameGetCodeListener {
        void onFailed();

        void onSuccess(@NotNull String code);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void delayLoadGame(final FragmentActivity activity, final long gameId) {
        this.handler.postDelayed(new Runnable() { // from class: com.qiahao.nextvideo.sud.a
            @Override // java.lang.Runnable
            public final void run() {
                BaseGameViewModel.this.login(activity, gameId);
            }
        }, 5000L);
    }

    private final void destroyMG() {
        if (this.playingGameId > 0) {
            this.sudFSTAPPDecorator.destroyMG();
            this.sudFSMMGDecorator.destroyMG();
            this.playingGameId = 0L;
            this.gameView = null;
            onRemoveGameView();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GameConfigModel gameConfigModel_delegate$lambda$2() {
        GameConfigModel gameConfigModel = new GameConfigModel();
        GameConfigModel.GameUi gameUi = gameConfigModel.ui;
        gameUi.gameSettle.hide = true;
        gameUi.ping.hide = true;
        gameUi.version.hide = true;
        gameUi.game_bg.hide = true;
        gameUi.lobby_setting_btn.hide = true;
        gameUi.lobby_help_btn.hide = true;
        gameUi.lobby_players.hide = true;
        gameUi.lobby_player_kickout_icon.hide = true;
        GameConfigModel.GameLobbyGameSetting gameLobbyGameSetting = gameUi.lobby_game_setting;
        gameLobbyGameSetting.hide = true;
        gameUi.lobby_rule.hide = true;
        gameUi.join_btn.hide = true;
        gameUi.ready_btn.hide = true;
        gameUi.cancel_join_btn.hide = true;
        gameUi.cancel_ready_btn.hide = true;
        gameUi.start_btn.hide = true;
        gameUi.share_btn.hide = true;
        gameUi.game_setting_btn.hide = true;
        gameUi.game_settle_again_btn.hide = true;
        gameUi.game_setting_select_pnl.hide = true;
        gameUi.game_selected_tips.hide = true;
        gameUi.nft_avatar.hide = true;
        gameUi.game_table_image.hide = true;
        gameUi.level.hide = true;
        gameUi.game_opening.hide = true;
        GameConfigModel.UmoIcon umoIcon = gameUi.umo_icon;
        umoIcon.hide = true;
        gameUi.logo.hide = true;
        umoIcon.hide = true;
        gameUi.game_mvp.hide = true;
        gameUi.mask.transparent = true;
        gameUi.lobby_player_captain_icon.hide = true;
        gameUi.game_help_btn.hide = true;
        gameLobbyGameSetting.hide = true;
        return gameConfigModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initSdk(final FragmentActivity activity, final long gameId, final String code) {
        SudMGP.initSDK(activity, getAppId(), getAppKey(), isTestEnv(), new ISudListenerInitSDK() { // from class: com.qiahao.nextvideo.sud.BaseGameViewModel$initSdk$1
            @Override // tech.sud.gip.core.ISudListenerInitSDK
            public void onFailure(int errCode, String errMsg) {
                Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                if (BaseGameViewModel.this.isTestEnv()) {
                    Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, activity, "initSDK onFailure:" + errMsg + "(" + errCode + ")", false, 4, (Object) null);
                    if (normal$default != null) {
                        normal$default.show();
                    }
                }
                BaseGameViewModel.this.delayLoadGame(activity, gameId);
            }

            @Override // tech.sud.gip.core.ISudListenerInitSDK
            public void onSuccess() {
                BaseGameViewModel.this.loadGame(activity, code, gameId);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loadGame(FragmentActivity activity, String code, long gameId) {
        if (!activity.isDestroyed() && this.isRunning && gameId == this.playingGameId) {
            this.sudFSMMGDecorator.setSudFSMMGListener(getSudFSMMGListener());
            SudMGP.getCfg().setShowLoadingGameBg(false);
            ISudFSTAPP loadMG = SudMGP.loadMG(activity, getUserId(), this.gameRoomId, code, gameId, getLanguageCode(), this.sudFSMMGDecorator);
            SudMGP.getCfg().setShowLoadingGameBg(false);
            if (loadMG == null) {
                Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, activity, "loadMG params error", false, 4, (Object) null);
                if (normal$default != null) {
                    normal$default.show();
                }
                delayLoadGame(activity, gameId);
                return;
            }
            this.sudFSTAPPDecorator.setISudFSTAPP(loadMG);
            View gameView = loadMG.getGameView();
            this.gameView = gameView;
            onAddGameView(gameView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void login(final FragmentActivity activity, final long gameId) {
        if (!activity.isDestroyed() && gameId > 0) {
            getCode(activity, getUserId(), getAppId(), new GameGetCodeListener() { // from class: com.qiahao.nextvideo.sud.BaseGameViewModel$login$1
                @Override // com.qiahao.nextvideo.sud.BaseGameViewModel.GameGetCodeListener
                public void onFailed() {
                    BaseGameViewModel.this.delayLoadGame(activity, gameId);
                }

                @Override // com.qiahao.nextvideo.sud.BaseGameViewModel.GameGetCodeListener
                public void onSuccess(String code) {
                    boolean z;
                    long j;
                    Intrinsics.checkNotNullParameter(code, Constants.KEY_HTTP_CODE);
                    z = BaseGameViewModel.this.isRunning;
                    if (z) {
                        long j2 = gameId;
                        j = BaseGameViewModel.this.playingGameId;
                        if (j2 == j) {
                            BaseGameViewModel.this.initSdk(activity, gameId, code);
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifyGameViewInfo(ISudFSMStateHandle handle, int gameViewWidth, int gameViewHeight) {
        GameViewInfoModel gameViewInfoModel = new GameViewInfoModel();
        gameViewInfoModel.ret_code = 0;
        GameViewInfoModel.GameViewSizeModel gameViewSizeModel = gameViewInfoModel.view_size;
        gameViewSizeModel.width = gameViewWidth;
        gameViewSizeModel.height = gameViewHeight;
        getGameRect(gameViewInfoModel);
        handle.success(SudJsonUtils.toJson(gameViewInfoModel));
    }

    @Nullable
    protected abstract String getAppId();

    @NotNull
    protected abstract String getAppKey();

    protected abstract void getCode(@Nullable FragmentActivity activity, @Nullable String userId, @Nullable String appId, @Nullable GameGetCodeListener listener);

    @NotNull
    public final GameConfigModel getGameConfigModel() {
        return (GameConfigModel) this.gameConfigModel.getValue();
    }

    protected abstract void getGameRect(@Nullable GameViewInfoModel gameViewInfoModel);

    @Nullable
    public final String getGameRoomId() {
        return this.gameRoomId;
    }

    @Nullable
    public final View getGameView() {
        return this.gameView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final Handler getHandler() {
        return this.handler;
    }

    @Nullable
    protected abstract String getLanguageCode();

    @NotNull
    public final SudFSMMGDecorator getSudFSMMGDecorator() {
        return this.sudFSMMGDecorator;
    }

    @Nullable
    protected abstract SudFSMMGListener getSudFSMMGListener();

    @NotNull
    public final SudFSTAPPDecorator getSudFSTAPPDecorator() {
        return this.sudFSTAPPDecorator;
    }

    @Nullable
    protected abstract String getUserId();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean isTestEnv();

    protected abstract void onAddGameView(@Nullable View gameView);

    public final void onDestroy() {
        this.isRunning = false;
        destroyMG();
    }

    protected abstract void onRemoveGameView();

    public final void processOnExpireCode(@NotNull final SudFSTAPPDecorator sudFSTAPPDecorator, @NotNull final ISudFSMStateHandle handle) {
        Intrinsics.checkNotNullParameter(sudFSTAPPDecorator, "sudFSTAPPDecorator");
        Intrinsics.checkNotNullParameter(handle, "handle");
        getCode(null, getUserId(), getAppId(), new GameGetCodeListener() { // from class: com.qiahao.nextvideo.sud.BaseGameViewModel$processOnExpireCode$1
            @Override // com.qiahao.nextvideo.sud.BaseGameViewModel.GameGetCodeListener
            public void onFailed() {
                MGStateResponse mGStateResponse = new MGStateResponse();
                mGStateResponse.ret_code = -1;
                handle.failure(SudJsonUtils.toJson(mGStateResponse));
            }

            @Override // com.qiahao.nextvideo.sud.BaseGameViewModel.GameGetCodeListener
            public void onSuccess(String code) {
                boolean z;
                Intrinsics.checkNotNullParameter(code, Constants.KEY_HTTP_CODE);
                z = BaseGameViewModel.this.isRunning;
                if (!z) {
                    return;
                }
                MGStateResponse mGStateResponse = new MGStateResponse();
                mGStateResponse.ret_code = 0;
                sudFSTAPPDecorator.updateCode(code, null);
                handle.success(SudJsonUtils.toJson(mGStateResponse));
            }
        });
    }

    public final void processOnGetGameCfg(@NotNull ISudFSMStateHandle handle, @Nullable String dataJson) {
        Intrinsics.checkNotNullParameter(handle, "handle");
        handle.success(SudJsonUtils.toJson(getGameConfigModel()));
    }

    public final void processOnGetGameViewInfo(@Nullable final View gameView, @NotNull final ISudFSMStateHandle handle) {
        Intrinsics.checkNotNullParameter(handle, "handle");
        if (gameView != null) {
            int measuredWidth = gameView.getMeasuredWidth();
            int measuredHeight = gameView.getMeasuredHeight();
            if (measuredWidth > 0 && measuredHeight > 0) {
                notifyGameViewInfo(handle, measuredWidth, measuredHeight);
            } else {
                gameView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.qiahao.nextvideo.sud.BaseGameViewModel$processOnGetGameViewInfo$1$1
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    public void onGlobalLayout() {
                        gameView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                        this.notifyGameViewInfo(handle, gameView.getMeasuredWidth(), gameView.getMeasuredHeight());
                    }
                });
            }
        }
    }

    public final void setGameView(@Nullable View view) {
        this.gameView = view;
    }

    public final void switchGame(@NotNull FragmentActivity activity, @NotNull String gameRoomId, long gameId) {
        Intrinsics.checkNotNullParameter(activity, AgooConstants.OPEN_ACTIIVTY_NAME);
        Intrinsics.checkNotNullParameter(gameRoomId, "gameRoomId");
        if (TextUtils.isEmpty(gameRoomId)) {
            Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, activity, "gameRoomId can not be empty", false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
                return;
            }
            return;
        }
        if (!this.isRunning) {
            return;
        }
        if (this.playingGameId == gameId && Intrinsics.areEqual(gameRoomId, this.gameRoomId)) {
            return;
        }
        destroyMG();
        this.gameRoomId = gameRoomId;
        this.playingGameId = gameId;
        login(activity, gameId);
    }
}
