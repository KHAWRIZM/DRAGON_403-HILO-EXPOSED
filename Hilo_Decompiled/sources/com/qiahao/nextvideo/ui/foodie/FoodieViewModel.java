package com.qiahao.nextvideo.ui.foodie;

import android.content.Context;
import androidx.lifecycle.MutableLiveData;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.network.interceptors.HiloException;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.base_common.viewmodel.BaseViewModel;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.foodie.FoodieDrawResult;
import com.qiahao.nextvideo.data.foodie.FoodieGameInfo;
import com.qiahao.nextvideo.data.foodie.FoodieItem;
import com.qiahao.nextvideo.data.foodie.FoodieRepeat;
import com.qiahao.nextvideo.network.AppServer;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.android.agoo.common.AgooConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 r2\u00020\u0001:\u0001rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020\u001fJ\u0006\u0010F\u001a\u00020?J\u001e\u0010G\u001a\u00020?2\u0006\u0010H\u001a\u00020\r2\u0006\u0010I\u001a\u00020\r2\u0006\u0010J\u001a\u00020\u000eJ\u0006\u0010P\u001a\u00020?J\u000e\u0010Q\u001a\u00020?2\u0006\u0010J\u001a\u00020\u000eJ\u000e\u0010V\u001a\u00020?2\u0006\u0010W\u001a\u00020SJ\u0006\u0010[\u001a\u00020?J\u000e\u0010\\\u001a\u00020?2\u0006\u0010]\u001a\u00020^J\u0015\u0010_\u001a\u0004\u0018\u00010?2\u0006\u0010H\u001a\u00020`¢\u0006\u0002\u0010aJ\u0006\u0010b\u001a\u00020(J\u0006\u0010c\u001a\u00020(J\r\u0010d\u001a\u0004\u0018\u00010?¢\u0006\u0002\u0010eJ\u000e\u0010l\u001a\u00020?2\u0006\u0010m\u001a\u00020nJ\b\u0010o\u001a\u00020?H\u0014J\u0006\u0010p\u001a\u00020?J\u0006\u0010q\u001a\u00020?R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR,\u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f0\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\b\"\u0004\b\u0010\u0010\nR \u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\b\"\u0004\b\u0013\u0010\nR \u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\b\"\u0004\b\u0017\u0010\nR \u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\b\"\u0004\b\u001a\u0010\nR \u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00150\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\b\"\u0004\b\u001d\u0010\nR\u001a\u0010\u001e\u001a\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R \u0010$\u001a\b\u0012\u0004\u0012\u00020\u001f0\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\b\"\u0004\b&\u0010\nR\u001a\u0010'\u001a\u00020(X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010)\"\u0004\b*\u0010+R\u001a\u0010,\u001a\u00020(X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010)\"\u0004\b.\u0010+R\u0010\u0010/\u001a\u0004\u0018\u000100X\u0082\u000e¢\u0006\u0002\n\u0000R \u00101\u001a\b\u0012\u0004\u0012\u00020\r02X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\"\u00107\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001080\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\b\"\u0004\b:\u0010\nR\"\u0010;\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001080\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\b\"\u0004\b=\u0010\nR\u001c\u0010A\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER(\u0010K\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020M\u0018\u00010L0\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010\b\"\u0004\bO\u0010\nR \u0010R\u001a\b\u0012\u0004\u0012\u00020S0\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010\b\"\u0004\bU\u0010\nR \u0010X\u001a\b\u0012\u0004\u0012\u00020(0\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010\b\"\u0004\bZ\u0010\nR\u001c\u0010f\u001a\u0004\u0018\u00010gX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bh\u0010i\"\u0004\bj\u0010k¨\u0006s"}, d2 = {"Lcom/qiahao/nextvideo/ui/foodie/FoodieViewModel;", "Lcom/qiahao/base_common/viewmodel/BaseViewModel;", "<init>", "()V", "gameInfoObserver", "Landroidx/lifecycle/MutableLiveData;", "Lcom/qiahao/nextvideo/data/foodie/FoodieGameInfo;", "getGameInfoObserver", "()Landroidx/lifecycle/MutableLiveData;", "setGameInfoObserver", "(Landroidx/lifecycle/MutableLiveData;)V", "placeBetObserver", "Lkotlin/Pair;", "", "Lcom/qiahao/nextvideo/data/foodie/FoodieItem;", "getPlaceBetObserver", "setPlaceBetObserver", "animObserver", "getAnimObserver", "setAnimObserver", "gameInfoError", "Lcom/qiahao/base_common/network/interceptors/HiloException;", "getGameInfoError", "setGameInfoError", "recordError", "getRecordError", "setRecordError", "placeError", "getPlaceError", "setPlaceError", "pageState", "Lcom/qiahao/nextvideo/ui/foodie/FoodiePageState;", "getPageState", "()Lcom/qiahao/nextvideo/ui/foodie/FoodiePageState;", "setPageState", "(Lcom/qiahao/nextvideo/ui/foodie/FoodiePageState;)V", "pageStateObserver", "getPageStateObserver", "setPageStateObserver", "isOtherDialogShowing", "", "()Z", "setOtherDialogShowing", "(Z)V", "hasData", "getHasData", "setHasData", "mMusicHelper", "Lcom/qiahao/nextvideo/ui/foodie/FoodieMusicHelper;", "selectedPositionSet", "", "getSelectedPositionSet", "()Ljava/util/Set;", "setSelectedPositionSet", "(Ljava/util/Set;)V", "mFoodieRepeatData", "Lcom/qiahao/nextvideo/data/foodie/FoodieRepeat;", "getMFoodieRepeatData", "setMFoodieRepeatData", "mFoodieRepeat", "getMFoodieRepeat", "setMFoodieRepeat", "changePageState", "", "s", "gameInfo", "getGameInfo", "()Lcom/qiahao/nextvideo/data/foodie/FoodieGameInfo;", "setGameInfo", "(Lcom/qiahao/nextvideo/data/foodie/FoodieGameInfo;)V", "requestFoodieGameInfo", "placeBet", "type", "money", "item", "outsideRankObserver", "", "Lcom/qiahao/nextvideo/data/foodie/FoodieDrawResult;", "getOutsideRankObserver", "setOutsideRankObserver", "requestOutSideRank", "pressFoodieItem", "rewardObserver", "", "getRewardObserver", "setRewardObserver", "onRewardChange", "reward", "resultActivityFinishObserver", "getResultActivityFinishObserver", "setResultActivityFinishObserver", "onResultActivityFinish", "initMusicHelper", "context", "Landroid/content/Context;", "playMusic", "Lcom/qiahao/nextvideo/ui/foodie/FoodieMusicType;", "(Lcom/qiahao/nextvideo/ui/foodie/FoodieMusicType;)Lkotlin/Unit;", "isMute", "switchMute", "destroyMusic", "()Lkotlin/Unit;", "hotIconHelper", "Lcom/qiahao/nextvideo/ui/foodie/FoodieHotIconHelper;", "getHotIconHelper", "()Lcom/qiahao/nextvideo/ui/foodie/FoodieHotIconHelper;", "setHotIconHelper", "(Lcom/qiahao/nextvideo/ui/foodie/FoodieHotIconHelper;)V", "initHotIconHelper", AgooConstants.OPEN_ACTIIVTY_NAME, "Lcom/qiahao/nextvideo/ui/foodie/FoodieGameDialog;", "onCleared", "foodieRepeatData", "foodieRepeat", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class FoodieViewModel extends BaseViewModel {

    @NotNull
    public static final String GAME_INFO = "GAME_INFO";

    @NotNull
    public static final String PLACE_BET = "PLACE_BET";

    @Nullable
    private FoodieGameInfo gameInfo;
    private boolean hasData;

    @Nullable
    private FoodieHotIconHelper hotIconHelper;
    private boolean isOtherDialogShowing;

    @Nullable
    private FoodieMusicHelper mMusicHelper;

    @NotNull
    private MutableLiveData<FoodieGameInfo> gameInfoObserver = new MutableLiveData<>();

    @NotNull
    private MutableLiveData<Pair<Integer, FoodieItem>> placeBetObserver = new MutableLiveData<>();

    @NotNull
    private MutableLiveData<FoodieItem> animObserver = new MutableLiveData<>();

    @NotNull
    private MutableLiveData<HiloException> gameInfoError = new MutableLiveData<>();

    @NotNull
    private MutableLiveData<HiloException> recordError = new MutableLiveData<>();

    @NotNull
    private MutableLiveData<HiloException> placeError = new MutableLiveData<>();

    @NotNull
    private FoodiePageState pageState = FoodiePageState.NORMAL;

    @NotNull
    private MutableLiveData<FoodiePageState> pageStateObserver = new MutableLiveData<>();

    @NotNull
    private Set<Integer> selectedPositionSet = new LinkedHashSet();

    @NotNull
    private MutableLiveData<FoodieRepeat> mFoodieRepeatData = new MutableLiveData<>();

    @NotNull
    private MutableLiveData<FoodieRepeat> mFoodieRepeat = new MutableLiveData<>();

    @NotNull
    private MutableLiveData<List<FoodieDrawResult>> outsideRankObserver = new MutableLiveData<>();

    @NotNull
    private MutableLiveData<Long> rewardObserver = new MutableLiveData<>();

    @NotNull
    private MutableLiveData<Boolean> resultActivityFinishObserver = new MutableLiveData<>();

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit foodieRepeat$lambda$10(FoodieViewModel foodieViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        if (th instanceof HiloException) {
            foodieViewModel.recordError.setValue(th);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit foodieRepeat$lambda$9(FoodieViewModel foodieViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        FoodieGameInfo foodieGameInfo = (FoodieGameInfo) foodieViewModel.gameInfoObserver.getValue();
        if (foodieGameInfo != null) {
            foodieGameInfo.setAutoBet(Boolean.TRUE);
        }
        foodieViewModel.mFoodieRepeat.setValue(apiResponse.getData());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit foodieRepeatData$lambda$7(FoodieViewModel foodieViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        foodieViewModel.mFoodieRepeatData.setValue(apiResponse.getData());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit foodieRepeatData$lambda$8(FoodieViewModel foodieViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        if (th instanceof HiloException) {
            foodieViewModel.recordError.setValue(th);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit placeBet$lambda$3(int i, FoodieViewModel foodieViewModel, FoodieItem foodieItem, ApiResponse apiResponse) {
        double d;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        UserStore.Companion companion = UserStore.INSTANCE;
        UserStore shared = companion.getShared();
        User user = companion.getShared().getUser();
        if (user != null) {
            d = user.getDiamondNum();
        } else {
            d = 0.0d;
        }
        UserStore.refreshDiamondOrGem$default(shared, d - i, 0.0d, 2, null);
        foodieViewModel.placeBetObserver.setValue(new Pair(Integer.valueOf(i), foodieItem));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit placeBet$lambda$4(FoodieViewModel foodieViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        foodieViewModel.getMException().setValue(new Pair(PLACE_BET, th));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit requestFoodieGameInfo$lambda$1(FoodieViewModel foodieViewModel, ApiResponse apiResponse) {
        double d;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        FoodieGameInfo foodieGameInfo = (FoodieGameInfo) apiResponse.getData();
        if (foodieGameInfo != null) {
            foodieViewModel.gameInfo = foodieGameInfo;
            foodieViewModel.gameInfoObserver.setValue(foodieGameInfo);
            UserStore shared = UserStore.INSTANCE.getShared();
            Double diamondNum = foodieGameInfo.getDiamondNum();
            if (diamondNum != null) {
                d = diamondNum.doubleValue();
            } else {
                d = 0.0d;
            }
            UserStore.refreshDiamondOrGem$default(shared, d, 0.0d, 2, null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit requestFoodieGameInfo$lambda$2(FoodieViewModel foodieViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        foodieViewModel.getMException().setValue(new Pair(GAME_INFO, th));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit requestOutSideRank$lambda$5(FoodieViewModel foodieViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        foodieViewModel.outsideRankObserver.setValue(apiResponse.getData());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit requestOutSideRank$lambda$6(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        return Unit.INSTANCE;
    }

    public final void changePageState(@NotNull FoodiePageState s) {
        Intrinsics.checkNotNullParameter(s, "s");
        this.pageState = s;
        this.pageStateObserver.setValue(s);
    }

    @Nullable
    public final Unit destroyMusic() {
        FoodieMusicHelper foodieMusicHelper = this.mMusicHelper;
        if (foodieMusicHelper != null) {
            foodieMusicHelper.destroy();
            return Unit.INSTANCE;
        }
        return null;
    }

    public final void foodieRepeat() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().foodieRepeat(), new Function1() { // from class: com.qiahao.nextvideo.ui.foodie.m1
            public final Object invoke(Object obj) {
                Unit foodieRepeat$lambda$9;
                foodieRepeat$lambda$9 = FoodieViewModel.foodieRepeat$lambda$9(FoodieViewModel.this, (ApiResponse) obj);
                return foodieRepeat$lambda$9;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.foodie.n1
            public final Object invoke(Object obj) {
                Unit foodieRepeat$lambda$10;
                foodieRepeat$lambda$10 = FoodieViewModel.foodieRepeat$lambda$10(FoodieViewModel.this, (Throwable) obj);
                return foodieRepeat$lambda$10;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    public final void foodieRepeatData() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().foodieRepeatData(), new Function1() { // from class: com.qiahao.nextvideo.ui.foodie.k1
            public final Object invoke(Object obj) {
                Unit foodieRepeatData$lambda$7;
                foodieRepeatData$lambda$7 = FoodieViewModel.foodieRepeatData$lambda$7(FoodieViewModel.this, (ApiResponse) obj);
                return foodieRepeatData$lambda$7;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.foodie.l1
            public final Object invoke(Object obj) {
                Unit foodieRepeatData$lambda$8;
                foodieRepeatData$lambda$8 = FoodieViewModel.foodieRepeatData$lambda$8(FoodieViewModel.this, (Throwable) obj);
                return foodieRepeatData$lambda$8;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    @NotNull
    public final MutableLiveData<FoodieItem> getAnimObserver() {
        return this.animObserver;
    }

    @Nullable
    public final FoodieGameInfo getGameInfo() {
        return this.gameInfo;
    }

    @NotNull
    public final MutableLiveData<HiloException> getGameInfoError() {
        return this.gameInfoError;
    }

    @NotNull
    public final MutableLiveData<FoodieGameInfo> getGameInfoObserver() {
        return this.gameInfoObserver;
    }

    public final boolean getHasData() {
        return this.hasData;
    }

    @Nullable
    public final FoodieHotIconHelper getHotIconHelper() {
        return this.hotIconHelper;
    }

    @NotNull
    public final MutableLiveData<FoodieRepeat> getMFoodieRepeat() {
        return this.mFoodieRepeat;
    }

    @NotNull
    public final MutableLiveData<FoodieRepeat> getMFoodieRepeatData() {
        return this.mFoodieRepeatData;
    }

    @NotNull
    public final MutableLiveData<List<FoodieDrawResult>> getOutsideRankObserver() {
        return this.outsideRankObserver;
    }

    @NotNull
    public final FoodiePageState getPageState() {
        return this.pageState;
    }

    @NotNull
    public final MutableLiveData<FoodiePageState> getPageStateObserver() {
        return this.pageStateObserver;
    }

    @NotNull
    public final MutableLiveData<Pair<Integer, FoodieItem>> getPlaceBetObserver() {
        return this.placeBetObserver;
    }

    @NotNull
    public final MutableLiveData<HiloException> getPlaceError() {
        return this.placeError;
    }

    @NotNull
    public final MutableLiveData<HiloException> getRecordError() {
        return this.recordError;
    }

    @NotNull
    public final MutableLiveData<Boolean> getResultActivityFinishObserver() {
        return this.resultActivityFinishObserver;
    }

    @NotNull
    public final MutableLiveData<Long> getRewardObserver() {
        return this.rewardObserver;
    }

    @NotNull
    public final Set<Integer> getSelectedPositionSet() {
        return this.selectedPositionSet;
    }

    public final void initHotIconHelper(@NotNull FoodieGameDialog activity) {
        Intrinsics.checkNotNullParameter(activity, AgooConstants.OPEN_ACTIIVTY_NAME);
        if (this.hotIconHelper == null) {
            this.hotIconHelper = new FoodieHotIconHelper(activity);
        }
    }

    public final void initMusicHelper(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.mMusicHelper = new FoodieMusicHelper(context);
    }

    public final boolean isMute() {
        FoodieMusicHelper foodieMusicHelper = this.mMusicHelper;
        if (foodieMusicHelper != null) {
            return foodieMusicHelper.getMIsMute();
        }
        return false;
    }

    /* renamed from: isOtherDialogShowing, reason: from getter */
    public final boolean getIsOtherDialogShowing() {
        return this.isOtherDialogShowing;
    }

    protected void onCleared() {
        super.onCleared();
        FoodieHotIconHelper foodieHotIconHelper = this.hotIconHelper;
        if (foodieHotIconHelper != null) {
            foodieHotIconHelper.destroy();
        }
    }

    public final void onResultActivityFinish() {
        this.resultActivityFinishObserver.setValue(Boolean.TRUE);
    }

    public final void onRewardChange(long reward) {
        this.rewardObserver.setValue(Long.valueOf(reward));
    }

    public final void placeBet(int type, final int money, @NotNull final FoodieItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().foodieStake(type, money), new Function1() { // from class: com.qiahao.nextvideo.ui.foodie.g1
            public final Object invoke(Object obj) {
                Unit placeBet$lambda$3;
                placeBet$lambda$3 = FoodieViewModel.placeBet$lambda$3(money, this, item, (ApiResponse) obj);
                return placeBet$lambda$3;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.foodie.h1
            public final Object invoke(Object obj) {
                Unit placeBet$lambda$4;
                placeBet$lambda$4 = FoodieViewModel.placeBet$lambda$4(FoodieViewModel.this, (Throwable) obj);
                return placeBet$lambda$4;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    @Nullable
    public final Unit playMusic(@NotNull FoodieMusicType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        FoodieMusicHelper foodieMusicHelper = this.mMusicHelper;
        if (foodieMusicHelper != null) {
            foodieMusicHelper.playMusic(type);
            return Unit.INSTANCE;
        }
        return null;
    }

    public final void pressFoodieItem(@NotNull FoodieItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        this.animObserver.setValue(item);
    }

    public final void requestFoodieGameInfo() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().foodieGameInfo(), new Function1() { // from class: com.qiahao.nextvideo.ui.foodie.i1
            public final Object invoke(Object obj) {
                Unit requestFoodieGameInfo$lambda$1;
                requestFoodieGameInfo$lambda$1 = FoodieViewModel.requestFoodieGameInfo$lambda$1(FoodieViewModel.this, (ApiResponse) obj);
                return requestFoodieGameInfo$lambda$1;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.foodie.j1
            public final Object invoke(Object obj) {
                Unit requestFoodieGameInfo$lambda$2;
                requestFoodieGameInfo$lambda$2 = FoodieViewModel.requestFoodieGameInfo$lambda$2(FoodieViewModel.this, (Throwable) obj);
                return requestFoodieGameInfo$lambda$2;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    public final void requestOutSideRank() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().foodieRank(), new Function1() { // from class: com.qiahao.nextvideo.ui.foodie.e1
            public final Object invoke(Object obj) {
                Unit requestOutSideRank$lambda$5;
                requestOutSideRank$lambda$5 = FoodieViewModel.requestOutSideRank$lambda$5(FoodieViewModel.this, (ApiResponse) obj);
                return requestOutSideRank$lambda$5;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.foodie.f1
            public final Object invoke(Object obj) {
                Unit requestOutSideRank$lambda$6;
                requestOutSideRank$lambda$6 = FoodieViewModel.requestOutSideRank$lambda$6((Throwable) obj);
                return requestOutSideRank$lambda$6;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    public final void setAnimObserver(@NotNull MutableLiveData<FoodieItem> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.animObserver = mutableLiveData;
    }

    public final void setGameInfo(@Nullable FoodieGameInfo foodieGameInfo) {
        this.gameInfo = foodieGameInfo;
    }

    public final void setGameInfoError(@NotNull MutableLiveData<HiloException> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.gameInfoError = mutableLiveData;
    }

    public final void setGameInfoObserver(@NotNull MutableLiveData<FoodieGameInfo> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.gameInfoObserver = mutableLiveData;
    }

    public final void setHasData(boolean z) {
        this.hasData = z;
    }

    public final void setHotIconHelper(@Nullable FoodieHotIconHelper foodieHotIconHelper) {
        this.hotIconHelper = foodieHotIconHelper;
    }

    public final void setMFoodieRepeat(@NotNull MutableLiveData<FoodieRepeat> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.mFoodieRepeat = mutableLiveData;
    }

    public final void setMFoodieRepeatData(@NotNull MutableLiveData<FoodieRepeat> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.mFoodieRepeatData = mutableLiveData;
    }

    public final void setOtherDialogShowing(boolean z) {
        this.isOtherDialogShowing = z;
    }

    public final void setOutsideRankObserver(@NotNull MutableLiveData<List<FoodieDrawResult>> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.outsideRankObserver = mutableLiveData;
    }

    public final void setPageState(@NotNull FoodiePageState foodiePageState) {
        Intrinsics.checkNotNullParameter(foodiePageState, "<set-?>");
        this.pageState = foodiePageState;
    }

    public final void setPageStateObserver(@NotNull MutableLiveData<FoodiePageState> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.pageStateObserver = mutableLiveData;
    }

    public final void setPlaceBetObserver(@NotNull MutableLiveData<Pair<Integer, FoodieItem>> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.placeBetObserver = mutableLiveData;
    }

    public final void setPlaceError(@NotNull MutableLiveData<HiloException> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.placeError = mutableLiveData;
    }

    public final void setRecordError(@NotNull MutableLiveData<HiloException> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.recordError = mutableLiveData;
    }

    public final void setResultActivityFinishObserver(@NotNull MutableLiveData<Boolean> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.resultActivityFinishObserver = mutableLiveData;
    }

    public final void setRewardObserver(@NotNull MutableLiveData<Long> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.rewardObserver = mutableLiveData;
    }

    public final void setSelectedPositionSet(@NotNull Set<Integer> set) {
        Intrinsics.checkNotNullParameter(set, "<set-?>");
        this.selectedPositionSet = set;
    }

    public final boolean switchMute() {
        FoodieMusicHelper foodieMusicHelper = this.mMusicHelper;
        if (foodieMusicHelper != null) {
            return foodieMusicHelper.switchMute();
        }
        return false;
    }
}
