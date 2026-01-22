package com.qiahao.nextvideo.sud;

import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.path.AppController;
import com.qiahao.base_common.support.AppService;
import com.qiahao.base_common.utils.language.LanguageHelper;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.sud.BaseGameViewModel;
import com.taobao.accs.common.Constants;
import com.tencent.qcloud.tuicore.TUIConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.android.agoo.common.AgooConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tech.sud.gip.core.ISudFSMStateHandle;
import tech.sud.mgp.SudMGPWrapper.decorator.SudFSMMGListener;
import tech.sud.mgp.SudMGPWrapper.model.GameViewInfoModel;
import tech.sud.mgp.SudMGPWrapper.state.SudMGPMGState;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 R2\u00020\u0001:\u0001RB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J7\u0010\f\u001a\u00020\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0014¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0010\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0014¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0014\u001a\u00020\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0014¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\u0016\u0010\u0003J-\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u0019¢\u0006\u0004\b\u001d\u0010\u001eJ\r\u0010\u001f\u001a\u00020\u000b¢\u0006\u0004\b\u001f\u0010\u0003R$\u0010!\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R*\u0010(\u001a\n '*\u0004\u0018\u00010\u00060\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\"\u0010/\u001a\u00020.8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001f\u00106\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u0012058\u0006¢\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u00109R\"\u0010:\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b:\u0010)\u001a\u0004\b;\u0010+\"\u0004\b<\u0010-R\"\u0010=\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b=\u0010?\"\u0004\b@\u0010AR$\u0010C\u001a\u0004\u0018\u00010B8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u0014\u0010\u0007\u001a\u00020\u00068TX\u0094\u0004¢\u0006\u0006\u001a\u0004\bI\u0010+R\u0014\u0010\b\u001a\u00020\u00068TX\u0094\u0004¢\u0006\u0006\u001a\u0004\bJ\u0010+R\u0014\u0010L\u001a\u00020\u00068TX\u0094\u0004¢\u0006\u0006\u001a\u0004\bK\u0010+R\u0014\u0010N\u001a\u00020\u00068TX\u0094\u0004¢\u0006\u0006\u001a\u0004\bM\u0010+R\u0014\u0010O\u001a\u00020\u00178TX\u0094\u0004¢\u0006\u0006\u001a\u0004\bO\u0010?R\u0016\u0010Q\u001a\u0004\u0018\u00010B8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\bP\u0010F¨\u0006S"}, d2 = {"Lcom/qiahao/nextvideo/sud/GameViewModel;", "Lcom/qiahao/nextvideo/sud/BaseGameViewModel;", "<init>", "()V", "Landroidx/fragment/app/FragmentActivity;", AgooConstants.OPEN_ACTIIVTY_NAME, "", TUIConstants.TUILive.USER_ID, "appId", "Lcom/qiahao/nextvideo/sud/BaseGameViewModel$GameGetCodeListener;", "listener", "", "getCode", "(Landroidx/fragment/app/FragmentActivity;Ljava/lang/String;Ljava/lang/String;Lcom/qiahao/nextvideo/sud/BaseGameViewModel$GameGetCodeListener;)V", "Ltech/sud/mgp/SudMGPWrapper/model/GameViewInfoModel;", "gameViewInfoModel", "getGameRect", "(Ltech/sud/mgp/SudMGPWrapper/model/GameViewInfoModel;)V", "Landroid/view/View;", "gameView", "onAddGameView", "(Landroid/view/View;)V", "onRemoveGameView", "", "isIn", "", "seatIndex", "isSeatRandom", "teamId", "notifyAPPCommonSelfIn", "(ZIZI)V", "release", "Ltech/sud/mgp/SudMGPWrapper/model/GameViewInfoModel$GameViewRectModel;", "gameViewRectModel", "Ltech/sud/mgp/SudMGPWrapper/model/GameViewInfoModel$GameViewRectModel;", "getGameViewRectModel", "()Ltech/sud/mgp/SudMGPWrapper/model/GameViewInfoModel$GameViewRectModel;", "setGameViewRectModel", "(Ltech/sud/mgp/SudMGPWrapper/model/GameViewInfoModel$GameViewRectModel;)V", "kotlin.jvm.PlatformType", "language", "Ljava/lang/String;", "getLanguage", "()Ljava/lang/String;", "setLanguage", "(Ljava/lang/String;)V", "Lnd/a;", "mCompositeDisposable", "Lnd/a;", "getMCompositeDisposable", "()Lnd/a;", "setMCompositeDisposable", "(Lnd/a;)V", "Landroidx/lifecycle/MutableLiveData;", "gameViewLiveData", "Landroidx/lifecycle/MutableLiveData;", "getGameViewLiveData", "()Landroidx/lifecycle/MutableLiveData;", "gameCode", "getGameCode", "setGameCode", "isLoading", "Z", "()Z", "setLoading", "(Z)V", "Ltech/sud/mgp/SudMGPWrapper/decorator/SudFSMMGListener;", "gameListener", "Ltech/sud/mgp/SudMGPWrapper/decorator/SudFSMMGListener;", "getGameListener", "()Ltech/sud/mgp/SudMGPWrapper/decorator/SudFSMMGListener;", "setGameListener", "(Ltech/sud/mgp/SudMGPWrapper/decorator/SudFSMMGListener;)V", "getUserId", "getAppId", "getAppKey", Constants.KEY_APP_KEY, "getLanguageCode", "languageCode", "isTestEnv", "getSudFSMMGListener", "sudFSMMGListener", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class GameViewModel extends BaseGameViewModel {
    private static final boolean GAME_IS_TEST_ENV;

    @Nullable
    private GameViewInfoModel.GameViewRectModel gameViewRectModel;
    private boolean isLoading;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static String SudMGP_APP_ID = "1589554767245340674";

    @NotNull
    private static String SudMGP_APP_KEY = "mfygGFQB2LKYJmfoHOZGH2VYbzIZcFZn";
    private String language = LanguageHelper.INSTANCE.getSystemLanguage().getLanguage();

    @NotNull
    private nd.a mCompositeDisposable = new nd.a();

    @NotNull
    private final MutableLiveData<View> gameViewLiveData = new MutableLiveData<>();

    @NotNull
    private String gameCode = "";

    @Nullable
    private SudFSMMGListener gameListener = new SudFSMMGListener() { // from class: com.qiahao.nextvideo.sud.GameViewModel$gameListener$1
        @Override // tech.sud.mgp.SudMGPWrapper.decorator.SudFSMMGListener
        public void onExpireCode(ISudFSMStateHandle handle, String dataJson) {
            Intrinsics.checkNotNullParameter(handle, "handle");
            GameViewModel gameViewModel = GameViewModel.this;
            gameViewModel.processOnExpireCode(gameViewModel.getSudFSTAPPDecorator(), handle);
        }

        @Override // tech.sud.mgp.SudMGPWrapper.decorator.SudFSMMGListener
        public void onGameDestroyed() {
        }

        @Override // tech.sud.mgp.SudMGPWrapper.decorator.SudFSMMGListener
        public void onGameLoadingProgress(int stage, int retCode, int progress) {
            rf.a.a(this, stage, retCode, progress);
            GameViewModel.this.setLoading(true);
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
        public /* synthetic */ void onGameMGCommonGameState(ISudFSMStateHandle iSudFSMStateHandle, SudMGPMGState.MGCommonGameState mGCommonGameState) {
            rf.a.S(this, iSudFSMStateHandle, mGCommonGameState);
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
            GameViewModel gameViewModel = GameViewModel.this;
            gameViewModel.processOnGetGameViewInfo(gameViewModel.getGameView(), handle);
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
    };

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/qiahao/nextvideo/sud/GameViewModel$Companion;", "", "<init>", "()V", "SudMGP_APP_ID", "", "getSudMGP_APP_ID", "()Ljava/lang/String;", "setSudMGP_APP_ID", "(Ljava/lang/String;)V", "SudMGP_APP_KEY", "getSudMGP_APP_KEY", "setSudMGP_APP_KEY", "GAME_IS_TEST_ENV", "", "getGAME_IS_TEST_ENV", "()Z", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean getGAME_IS_TEST_ENV() {
            return GameViewModel.GAME_IS_TEST_ENV;
        }

        @NotNull
        public final String getSudMGP_APP_ID() {
            return GameViewModel.SudMGP_APP_ID;
        }

        @NotNull
        public final String getSudMGP_APP_KEY() {
            return GameViewModel.SudMGP_APP_KEY;
        }

        public final void setSudMGP_APP_ID(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            GameViewModel.SudMGP_APP_ID = str;
        }

        public final void setSudMGP_APP_KEY(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            GameViewModel.SudMGP_APP_KEY = str;
        }

        private Companion() {
        }
    }

    static {
        boolean z;
        AppService service = AppController.INSTANCE.getService();
        if (service != null) {
            z = service.checkServerDebug();
        } else {
            z = false;
        }
        GAME_IS_TEST_ENV = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCode$lambda$0(BaseGameViewModel.GameGetCodeListener gameGetCodeListener) {
        if (gameGetCodeListener != null) {
            gameGetCodeListener.onFailed();
        }
    }

    @Override // com.qiahao.nextvideo.sud.BaseGameViewModel
    @NotNull
    protected String getAppId() {
        return SudMGP_APP_ID;
    }

    @Override // com.qiahao.nextvideo.sud.BaseGameViewModel
    @NotNull
    protected String getAppKey() {
        return SudMGP_APP_KEY;
    }

    @Override // com.qiahao.nextvideo.sud.BaseGameViewModel
    protected void getCode(@Nullable FragmentActivity activity, @Nullable String userId, @Nullable String appId, @Nullable final BaseGameViewModel.GameGetCodeListener listener) {
        if (TextUtils.isEmpty(this.gameCode)) {
            getHandler().post(new Runnable() { // from class: com.qiahao.nextvideo.sud.c
                @Override // java.lang.Runnable
                public final void run() {
                    GameViewModel.getCode$lambda$0(BaseGameViewModel.GameGetCodeListener.this);
                }
            });
        } else if (listener != null) {
            listener.onSuccess(this.gameCode);
        }
    }

    @NotNull
    public final String getGameCode() {
        return this.gameCode;
    }

    @Nullable
    public final SudFSMMGListener getGameListener() {
        return this.gameListener;
    }

    @Override // com.qiahao.nextvideo.sud.BaseGameViewModel
    protected void getGameRect(@Nullable GameViewInfoModel gameViewInfoModel) {
        GameViewInfoModel.GameViewRectModel gameViewRectModel = new GameViewInfoModel.GameViewRectModel();
        gameViewRectModel.left = 20;
        gameViewRectModel.right = 20;
        gameViewRectModel.f٩٤top = 20;
        gameViewRectModel.bottom = 20;
        if (gameViewInfoModel != null) {
            gameViewInfoModel.view_game_rect = gameViewRectModel;
        }
    }

    @NotNull
    public final MutableLiveData<View> getGameViewLiveData() {
        return this.gameViewLiveData;
    }

    @Nullable
    public final GameViewInfoModel.GameViewRectModel getGameViewRectModel() {
        return this.gameViewRectModel;
    }

    public final String getLanguage() {
        return this.language;
    }

    @Override // com.qiahao.nextvideo.sud.BaseGameViewModel
    @NotNull
    protected String getLanguageCode() {
        String str = this.language;
        Intrinsics.checkNotNullExpressionValue(str, "language");
        return str;
    }

    @NotNull
    public final nd.a getMCompositeDisposable() {
        return this.mCompositeDisposable;
    }

    @Override // com.qiahao.nextvideo.sud.BaseGameViewModel
    @Nullable
    protected SudFSMMGListener getSudFSMMGListener() {
        return this.gameListener;
    }

    @Override // com.qiahao.nextvideo.sud.BaseGameViewModel
    @NotNull
    protected String getUserId() {
        String externalId;
        User user = UserStore.INSTANCE.getShared().getUser();
        if (user == null || (externalId = user.getExternalId()) == null) {
            return "";
        }
        return externalId;
    }

    /* renamed from: isLoading, reason: from getter */
    public final boolean getIsLoading() {
        return this.isLoading;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.sud.BaseGameViewModel
    public boolean isTestEnv() {
        return GAME_IS_TEST_ENV;
    }

    public final void notifyAPPCommonSelfIn(boolean isIn, int seatIndex, boolean isSeatRandom, int teamId) {
        getSudFSTAPPDecorator().notifyAPPCommonSelfIn(isIn, seatIndex, isSeatRandom, teamId);
    }

    @Override // com.qiahao.nextvideo.sud.BaseGameViewModel
    protected void onAddGameView(@Nullable View gameView) {
        this.gameViewLiveData.setValue(gameView);
    }

    @Override // com.qiahao.nextvideo.sud.BaseGameViewModel
    protected void onRemoveGameView() {
        this.gameViewLiveData.setValue((Object) null);
    }

    public final void release() {
        getGameConfigModel().gameSoundVolume = 100;
        this.gameCode = "";
        onDestroy();
    }

    public final void setGameCode(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.gameCode = str;
    }

    public final void setGameListener(@Nullable SudFSMMGListener sudFSMMGListener) {
        this.gameListener = sudFSMMGListener;
    }

    public final void setGameViewRectModel(@Nullable GameViewInfoModel.GameViewRectModel gameViewRectModel) {
        this.gameViewRectModel = gameViewRectModel;
    }

    public final void setLanguage(String str) {
        this.language = str;
    }

    public final void setLoading(boolean z) {
        this.isLoading = z;
    }

    public final void setMCompositeDisposable(@NotNull nd.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<set-?>");
        this.mCompositeDisposable = aVar;
    }
}
