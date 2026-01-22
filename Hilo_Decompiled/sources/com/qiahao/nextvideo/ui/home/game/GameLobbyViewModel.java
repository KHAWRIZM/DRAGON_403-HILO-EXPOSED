package com.qiahao.nextvideo.ui.home.game;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.qiahao.base_common.model.ApiList;
import com.qiahao.base_common.model.BaseListData;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.base_common.viewmodel.BaseViewModel;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.game.GameBroadcast;
import com.qiahao.nextvideo.data.game.GameLobbyMatch;
import com.qiahao.nextvideo.data.game.HomeGameUser;
import com.qiahao.nextvideo.data.model.CreateGroupBean;
import com.qiahao.nextvideo.data.model.GameConfiguration;
import com.qiahao.nextvideo.data.service.GroupService;
import com.qiahao.nextvideo.network.AppServer;
import com.qiahao.nextvideo.sheep.GameMatchActivity;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.BaseMonitor;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 >2\u00020\u0001:\u0001>B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tJ\r\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u0003J\r\u0010\u000b\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\u0003J\r\u0010\f\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\u0003J\r\u0010\r\u001a\u00020\u0007¢\u0006\u0004\b\r\u0010\u0003J\r\u0010\u000e\u001a\u00020\u0007¢\u0006\u0004\b\u000e\u0010\u0003J\u000f\u0010\u000f\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\u000f\u0010\u0003R\"\u0010\u0010\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u0019R*\u0010\u001f\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u001d0\u001cj\b\u0012\u0004\u0012\u00020\u001d`\u001e0\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010\u0019R*\u0010!\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020 0\u001cj\b\u0012\u0004\u0012\u00020 `\u001e0\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\u0019R\u0017\u0010#\u001a\u00020\"8\u0006¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R \u0010)\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020(0'0\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010\u0019R(\u0010,\u001a\b\u0012\u0004\u0012\u00020+0*8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001a\u00103\u001a\b\u0012\u0004\u0012\u0002020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u0010\u0019R\u0019\u00107\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u0017048F¢\u0006\u0006\u001a\u0004\b5\u00106R\u0019\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a048F¢\u0006\u0006\u001a\u0004\b8\u00106R'\u00109\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u001d0\u001cj\b\u0012\u0004\u0012\u00020\u001d`\u001e048F¢\u0006\u0006\u001a\u0004\b\u000b\u00106R'\u0010\f\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020 0\u001cj\b\u0012\u0004\u0012\u00020 `\u001e048F¢\u0006\u0006\u001a\u0004\b:\u00106R\u001d\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020(0'048F¢\u0006\u0006\u001a\u0004\b;\u00106R\u0017\u0010=\u001a\b\u0012\u0004\u0012\u000202048F¢\u0006\u0006\u001a\u0004\b<\u00106¨\u0006?"}, d2 = {"Lcom/qiahao/nextvideo/ui/home/game/GameLobbyViewModel;", "Lcom/qiahao/base_common/viewmodel/BaseViewModel;", "<init>", "()V", "", GameMatchActivity.GAME_ID, Constants.KEY_MODEL, "", "joinMatch", "(II)V", "exitMatchGame", "getGameBroadcast", "homeGameList", "homeGameUserList", "createRoom", "onCleared", "mGameStatus", "I", "getMGameStatus", "()I", "setMGameStatus", "(I)V", "Landroidx/lifecycle/MutableLiveData;", "Lcom/qiahao/nextvideo/data/game/GameLobbyMatch;", "matchDataMutable", "Landroidx/lifecycle/MutableLiveData;", "Lcom/qiahao/nextvideo/data/model/CreateGroupBean;", "createRoomMutable", "Ljava/util/ArrayList;", "Lcom/qiahao/nextvideo/data/game/GameBroadcast;", "Lkotlin/collections/ArrayList;", "gameBroadcastMutable", "Lcom/qiahao/nextvideo/data/model/GameConfiguration;", "homeGameListMutable", "Lcom/qiahao/base_common/model/BaseListData;", "homeUserBaseData", "Lcom/qiahao/base_common/model/BaseListData;", "getHomeUserBaseData", "()Lcom/qiahao/base_common/model/BaseListData;", "", "Lcom/qiahao/nextvideo/data/game/HomeGameUser;", "homeGameUserListMutable", "Lma/b;", "", "exitSuccess", "Lma/b;", "getExitSuccess", "()Lma/b;", "setExitSuccess", "(Lma/b;)V", "", "errorMutable", "Landroidx/lifecycle/LiveData;", "getMatchData", "()Landroidx/lifecycle/LiveData;", "matchData", "getCreateRoom", "gameBroadcast", "getHomeGameList", "getHomeGameUserList", "getError", BaseMonitor.COUNT_ERROR, "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class GameLobbyViewModel extends BaseViewModel {

    @NotNull
    public static final String CREATE_ROOM = "CREATE_ROOM";

    @NotNull
    public static final String GAME_USER_LIST = "game_user_list";
    private int mGameStatus;

    @NotNull
    private final MutableLiveData<GameLobbyMatch> matchDataMutable = new MutableLiveData<>();

    @NotNull
    private final MutableLiveData<CreateGroupBean> createRoomMutable = new MutableLiveData<>();

    @NotNull
    private final MutableLiveData<ArrayList<GameBroadcast>> gameBroadcastMutable = new MutableLiveData<>();

    @NotNull
    private final MutableLiveData<ArrayList<GameConfiguration>> homeGameListMutable = new MutableLiveData<>();

    @NotNull
    private final BaseListData homeUserBaseData = new BaseListData();

    @NotNull
    private final MutableLiveData<List<HomeGameUser>> homeGameUserListMutable = new MutableLiveData<>();

    @NotNull
    private ma.b exitSuccess = new ma.b();

    @NotNull
    private final MutableLiveData<Throwable> errorMutable = new MutableLiveData<>();

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit createRoom$lambda$12(GameLobbyViewModel gameLobbyViewModel, ApiResponse apiResponse) {
        String str;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        UserStore.Companion companion = UserStore.INSTANCE;
        User user = companion.getShared().getUser();
        if (user != null) {
            CreateGroupBean createGroupBean = (CreateGroupBean) apiResponse.getData();
            if (createGroupBean != null) {
                str = createGroupBean.getImGroupId();
            } else {
                str = null;
            }
            user.setGroupId(str);
        }
        UserStore.refreshUserInfo$default(companion.getShared(), user, null, null, false, 14, null);
        gameLobbyViewModel.createRoomMutable.setValue(apiResponse.getData());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit createRoom$lambda$13(GameLobbyViewModel gameLobbyViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        gameLobbyViewModel.getMException().setValue(new Pair("CREATE_ROOM", th));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit exitMatchGame$lambda$2(GameLobbyViewModel gameLobbyViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        gameLobbyViewModel.exitSuccess.setValue(Boolean.TRUE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit exitMatchGame$lambda$3(GameLobbyViewModel gameLobbyViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        gameLobbyViewModel.errorMutable.setValue(th);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getGameBroadcast$lambda$5(GameLobbyViewModel gameLobbyViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        ArrayList arrayList = (ArrayList) apiResponse.getData();
        if (arrayList != null) {
            gameLobbyViewModel.gameBroadcastMutable.setValue(arrayList);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getGameBroadcast$lambda$6(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit homeGameList$lambda$8(GameLobbyViewModel gameLobbyViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        ArrayList arrayList = (ArrayList) apiResponse.getData();
        if (arrayList != null) {
            gameLobbyViewModel.homeGameListMutable.setValue(arrayList);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit homeGameList$lambda$9(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit homeGameUserList$lambda$10(GameLobbyViewModel gameLobbyViewModel, ApiResponse apiResponse) {
        Object arrayList;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        gameLobbyViewModel.homeUserBaseData.setList((ApiList) apiResponse.getData());
        MutableLiveData<List<HomeGameUser>> mutableLiveData = gameLobbyViewModel.homeGameUserListMutable;
        ApiList apiList = (ApiList) apiResponse.getData();
        if (apiList == null || (arrayList = apiList.getData()) == null) {
            arrayList = new ArrayList();
        }
        mutableLiveData.setValue(arrayList);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit homeGameUserList$lambda$11(GameLobbyViewModel gameLobbyViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        gameLobbyViewModel.getMException().setValue(new Pair(GAME_USER_LIST, th));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit joinMatch$lambda$0(GameLobbyViewModel gameLobbyViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        gameLobbyViewModel.mGameStatus = 1;
        gameLobbyViewModel.matchDataMutable.setValue(apiResponse.getData());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit joinMatch$lambda$1(GameLobbyViewModel gameLobbyViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        gameLobbyViewModel.errorMutable.setValue(th);
        return Unit.INSTANCE;
    }

    public final void createRoom() {
        RxUtilsKt.observeOnMainThread$default(GroupService.INSTANCE.getInstance().createGroup(), new Function1() { // from class: com.qiahao.nextvideo.ui.home.game.k
            public final Object invoke(Object obj) {
                Unit createRoom$lambda$12;
                createRoom$lambda$12 = GameLobbyViewModel.createRoom$lambda$12(GameLobbyViewModel.this, (ApiResponse) obj);
                return createRoom$lambda$12;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.home.game.l
            public final Object invoke(Object obj) {
                Unit createRoom$lambda$13;
                createRoom$lambda$13 = GameLobbyViewModel.createRoom$lambda$13(GameLobbyViewModel.this, (Throwable) obj);
                return createRoom$lambda$13;
            }
        }, (Function0) null, false, 12, (Object) null);
    }

    public final void exitMatchGame() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().exitLobbyMatch(), new Function1() { // from class: com.qiahao.nextvideo.ui.home.game.i
            public final Object invoke(Object obj) {
                Unit exitMatchGame$lambda$2;
                exitMatchGame$lambda$2 = GameLobbyViewModel.exitMatchGame$lambda$2(GameLobbyViewModel.this, (ApiResponse) obj);
                return exitMatchGame$lambda$2;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.home.game.j
            public final Object invoke(Object obj) {
                Unit exitMatchGame$lambda$3;
                exitMatchGame$lambda$3 = GameLobbyViewModel.exitMatchGame$lambda$3(GameLobbyViewModel.this, (Throwable) obj);
                return exitMatchGame$lambda$3;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    @NotNull
    public final LiveData<CreateGroupBean> getCreateRoom() {
        return this.createRoomMutable;
    }

    @NotNull
    public final LiveData<Throwable> getError() {
        return this.errorMutable;
    }

    @NotNull
    public final ma.b getExitSuccess() {
        return this.exitSuccess;
    }

    @NotNull
    public final LiveData<ArrayList<GameBroadcast>> getGameBroadcast() {
        return this.gameBroadcastMutable;
    }

    @NotNull
    public final LiveData<ArrayList<GameConfiguration>> getHomeGameList() {
        return this.homeGameListMutable;
    }

    @NotNull
    public final LiveData<List<HomeGameUser>> getHomeGameUserList() {
        return this.homeGameUserListMutable;
    }

    @NotNull
    public final BaseListData getHomeUserBaseData() {
        return this.homeUserBaseData;
    }

    public final int getMGameStatus() {
        return this.mGameStatus;
    }

    @NotNull
    public final LiveData<GameLobbyMatch> getMatchData() {
        return this.matchDataMutable;
    }

    public final void homeGameList() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().homeGameList(), new Function1() { // from class: com.qiahao.nextvideo.ui.home.game.g
            public final Object invoke(Object obj) {
                Unit homeGameList$lambda$8;
                homeGameList$lambda$8 = GameLobbyViewModel.homeGameList$lambda$8(GameLobbyViewModel.this, (ApiResponse) obj);
                return homeGameList$lambda$8;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.home.game.h
            public final Object invoke(Object obj) {
                Unit homeGameList$lambda$9;
                homeGameList$lambda$9 = GameLobbyViewModel.homeGameList$lambda$9((Throwable) obj);
                return homeGameList$lambda$9;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    public final void homeGameUserList() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().homeGameUserList(this.homeUserBaseData.nextPage(), this.homeUserBaseData.getPageSize()), new Function1() { // from class: com.qiahao.nextvideo.ui.home.game.a
            public final Object invoke(Object obj) {
                Unit homeGameUserList$lambda$10;
                homeGameUserList$lambda$10 = GameLobbyViewModel.homeGameUserList$lambda$10(GameLobbyViewModel.this, (ApiResponse) obj);
                return homeGameUserList$lambda$10;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.home.game.d
            public final Object invoke(Object obj) {
                Unit homeGameUserList$lambda$11;
                homeGameUserList$lambda$11 = GameLobbyViewModel.homeGameUserList$lambda$11(GameLobbyViewModel.this, (Throwable) obj);
                return homeGameUserList$lambda$11;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    public final void joinMatch(int gameId, int model) {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().lobbyMatch(gameId, model), new Function1() { // from class: com.qiahao.nextvideo.ui.home.game.b
            public final Object invoke(Object obj) {
                Unit joinMatch$lambda$0;
                joinMatch$lambda$0 = GameLobbyViewModel.joinMatch$lambda$0(GameLobbyViewModel.this, (ApiResponse) obj);
                return joinMatch$lambda$0;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.home.game.c
            public final Object invoke(Object obj) {
                Unit joinMatch$lambda$1;
                joinMatch$lambda$1 = GameLobbyViewModel.joinMatch$lambda$1(GameLobbyViewModel.this, (Throwable) obj);
                return joinMatch$lambda$1;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    protected void onCleared() {
        super.onCleared();
        this.homeUserBaseData.destroy();
    }

    public final void setExitSuccess(@NotNull ma.b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "<set-?>");
        this.exitSuccess = bVar;
    }

    public final void setMGameStatus(int i) {
        this.mGameStatus = i;
    }

    /* renamed from: getGameBroadcast, reason: collision with other method in class */
    public final void m٧٤getGameBroadcast() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().matchBroadcast(), new Function1() { // from class: com.qiahao.nextvideo.ui.home.game.e
            public final Object invoke(Object obj) {
                Unit gameBroadcast$lambda$5;
                gameBroadcast$lambda$5 = GameLobbyViewModel.getGameBroadcast$lambda$5(GameLobbyViewModel.this, (ApiResponse) obj);
                return gameBroadcast$lambda$5;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.home.game.f
            public final Object invoke(Object obj) {
                Unit gameBroadcast$lambda$6;
                gameBroadcast$lambda$6 = GameLobbyViewModel.getGameBroadcast$lambda$6((Throwable) obj);
                return gameBroadcast$lambda$6;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }
}
