package com.qiahao.nextvideo.sheep;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.base_common.viewmodel.BaseViewModel;
import com.qiahao.nextvideo.data.service.UserService;
import com.qiahao.nextvideo.data.sheep.SheepMatchData;
import com.taobao.accs.utl.BaseMonitor;
import io.reactivex.rxjava3.core.i0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import userProxy.UserProxy1;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J%\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\r\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u000fR\"\u0010\u0010\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0016\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\"\u0010\u001a\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010 \u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010\u0011\u001a\u0004\b!\u0010\u0013\"\u0004\b\"\u0010\u0015R$\u0010$\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001c\u0010,\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010+0*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R(\u00100\u001a\b\u0012\u0004\u0012\u00020/0.8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001a\u00107\u001a\b\u0012\u0004\u0012\u0002060*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u0010-R\u0019\u0010;\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010+088F¢\u0006\u0006\u001a\u0004\b9\u0010:R\u0017\u0010=\u001a\b\u0012\u0004\u0012\u000206088F¢\u0006\u0006\u001a\u0004\b<\u0010:¨\u0006>"}, d2 = {"Lcom/qiahao/nextvideo/sheep/GameMatchViewModel;", "Lcom/qiahao/base_common/viewmodel/BaseViewModel;", "Lcom/qiahao/nextvideo/data/service/UserService;", "repository", "<init>", "(Lcom/qiahao/nextvideo/data/service/UserService;)V", "", "matchId", "lastMatchId", GameMatchActivity.GAME_ID, "", "joinMatch", "(III)V", "exitMatchGame", "(II)V", "Lcom/qiahao/nextvideo/data/service/UserService;", "mMathId", "I", "getMMathId", "()I", "setMMathId", "(I)V", "mGameId", "getMGameId", "setMGameId", "", "mRoomId", "Ljava/lang/String;", "getMRoomId", "()Ljava/lang/String;", "setMRoomId", "(Ljava/lang/String;)V", "mGameStatus", "getMGameStatus", "setMGameStatus", "LuserProxy/UserProxy1$SheepMatchSuccess;", "mMatchSuccess", "LuserProxy/UserProxy1$SheepMatchSuccess;", "getMMatchSuccess", "()LuserProxy/UserProxy1$SheepMatchSuccess;", "setMMatchSuccess", "(LuserProxy/UserProxy1$SheepMatchSuccess;)V", "Landroidx/lifecycle/MutableLiveData;", "Lcom/qiahao/nextvideo/data/sheep/SheepMatchData;", "matchDataMutable", "Landroidx/lifecycle/MutableLiveData;", "Lma/b;", "", "exitSuccess", "Lma/b;", "getExitSuccess", "()Lma/b;", "setExitSuccess", "(Lma/b;)V", "", "errorMutable", "Landroidx/lifecycle/LiveData;", "getMatchData", "()Landroidx/lifecycle/LiveData;", "matchData", "getError", BaseMonitor.COUNT_ERROR, "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class GameMatchViewModel extends BaseViewModel {

    @NotNull
    private final MutableLiveData<Throwable> errorMutable;

    @NotNull
    private ma.b exitSuccess;
    private int mGameId;
    private int mGameStatus;

    @Nullable
    private UserProxy1.SheepMatchSuccess mMatchSuccess;
    private int mMathId;

    @NotNull
    private String mRoomId;

    @NotNull
    private final MutableLiveData<SheepMatchData> matchDataMutable;

    @Nullable
    private final UserService repository;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public GameMatchViewModel() {
        this(r0, 1, r0);
        UserService userService = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit exitMatchGame$lambda$2(GameMatchViewModel gameMatchViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        gameMatchViewModel.exitSuccess.setValue(Boolean.TRUE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit exitMatchGame$lambda$3(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit joinMatch$lambda$0(GameMatchViewModel gameMatchViewModel, ApiResponse apiResponse) {
        int i;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        gameMatchViewModel.mGameStatus = 1;
        SheepMatchData sheepMatchData = (SheepMatchData) apiResponse.getData();
        if (sheepMatchData != null) {
            i = sheepMatchData.getMatchId();
        } else {
            i = 0;
        }
        gameMatchViewModel.mMathId = i;
        gameMatchViewModel.matchDataMutable.setValue(apiResponse.getData());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit joinMatch$lambda$1(GameMatchViewModel gameMatchViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        gameMatchViewModel.errorMutable.setValue(th);
        return Unit.INSTANCE;
    }

    public final void exitMatchGame(int matchId, int gameId) {
        i0<ApiResponse<Object>> exitSheep;
        nd.c observeOnMainThread$default;
        UserService userService = this.repository;
        if (userService != null && (exitSheep = userService.exitSheep(matchId, gameId)) != null && (observeOnMainThread$default = RxUtilsKt.observeOnMainThread$default(exitSheep, new Function1() { // from class: com.qiahao.nextvideo.sheep.j
            public final Object invoke(Object obj) {
                Unit exitMatchGame$lambda$2;
                exitMatchGame$lambda$2 = GameMatchViewModel.exitMatchGame$lambda$2(GameMatchViewModel.this, (ApiResponse) obj);
                return exitMatchGame$lambda$2;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.sheep.k
            public final Object invoke(Object obj) {
                Unit exitMatchGame$lambda$3;
                exitMatchGame$lambda$3 = GameMatchViewModel.exitMatchGame$lambda$3((Throwable) obj);
                return exitMatchGame$lambda$3;
            }
        }, (Function0) null, false, 12, (Object) null)) != null) {
            RxUtilsKt.addTo(observeOnMainThread$default, getMCompositeDisposable());
        }
    }

    @NotNull
    public final LiveData<Throwable> getError() {
        return this.errorMutable;
    }

    @NotNull
    public final ma.b getExitSuccess() {
        return this.exitSuccess;
    }

    public final int getMGameId() {
        return this.mGameId;
    }

    public final int getMGameStatus() {
        return this.mGameStatus;
    }

    @Nullable
    public final UserProxy1.SheepMatchSuccess getMMatchSuccess() {
        return this.mMatchSuccess;
    }

    public final int getMMathId() {
        return this.mMathId;
    }

    @NotNull
    public final String getMRoomId() {
        return this.mRoomId;
    }

    @NotNull
    public final LiveData<SheepMatchData> getMatchData() {
        return this.matchDataMutable;
    }

    public final void joinMatch(int matchId, int lastMatchId, int gameId) {
        i0<ApiResponse<SheepMatchData>> joinMatch;
        nd.c observeOnMainThread$default;
        UserService userService = this.repository;
        if (userService != null && (joinMatch = userService.joinMatch(matchId, lastMatchId, gameId)) != null && (observeOnMainThread$default = RxUtilsKt.observeOnMainThread$default(joinMatch, new Function1() { // from class: com.qiahao.nextvideo.sheep.h
            public final Object invoke(Object obj) {
                Unit joinMatch$lambda$0;
                joinMatch$lambda$0 = GameMatchViewModel.joinMatch$lambda$0(GameMatchViewModel.this, (ApiResponse) obj);
                return joinMatch$lambda$0;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.sheep.i
            public final Object invoke(Object obj) {
                Unit joinMatch$lambda$1;
                joinMatch$lambda$1 = GameMatchViewModel.joinMatch$lambda$1(GameMatchViewModel.this, (Throwable) obj);
                return joinMatch$lambda$1;
            }
        }, (Function0) null, false, 12, (Object) null)) != null) {
            RxUtilsKt.addTo(observeOnMainThread$default, getMCompositeDisposable());
        }
    }

    public final void setExitSuccess(@NotNull ma.b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "<set-?>");
        this.exitSuccess = bVar;
    }

    public final void setMGameId(int i) {
        this.mGameId = i;
    }

    public final void setMGameStatus(int i) {
        this.mGameStatus = i;
    }

    public final void setMMatchSuccess(@Nullable UserProxy1.SheepMatchSuccess sheepMatchSuccess) {
        this.mMatchSuccess = sheepMatchSuccess;
    }

    public final void setMMathId(int i) {
        this.mMathId = i;
    }

    public final void setMRoomId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mRoomId = str;
    }

    public GameMatchViewModel(@Nullable UserService userService) {
        this.repository = userService;
        this.mRoomId = "";
        this.matchDataMutable = new MutableLiveData<>();
        this.exitSuccess = new ma.b();
        this.errorMutable = new MutableLiveData<>();
    }

    public /* synthetic */ GameMatchViewModel(UserService userService, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new UserService() : userService);
    }
}
