package com.qiahao.nextvideo.ui.gameLevel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.base_common.viewmodel.BaseViewModel;
import com.qiahao.nextvideo.data.model.gameLevel.GameLevelData;
import com.qiahao.nextvideo.network.AppServer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\t\u001a\u00020\u000bR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/qiahao/nextvideo/ui/gameLevel/GameLevelViewModel;", "Lcom/qiahao/base_common/viewmodel/BaseViewModel;", "<init>", "()V", "gameLevelMutable", "Landroidx/lifecycle/MutableLiveData;", "Lcom/qiahao/nextvideo/data/model/gameLevel/GameLevelData;", "gameLevel", "Landroidx/lifecycle/LiveData;", "getGameLevel", "()Landroidx/lifecycle/LiveData;", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class GameLevelViewModel extends BaseViewModel {

    @NotNull
    private final MutableLiveData<GameLevelData> gameLevelMutable = new MutableLiveData<>();

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getGameLevel$lambda$1(GameLevelViewModel gameLevelViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        GameLevelData gameLevelData = (GameLevelData) apiResponse.getData();
        if (gameLevelData != null) {
            gameLevelViewModel.gameLevelMutable.setValue(gameLevelData);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getGameLevel$lambda$2(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        return Unit.INSTANCE;
    }

    @NotNull
    public final LiveData<GameLevelData> getGameLevel() {
        return this.gameLevelMutable;
    }

    /* renamed from: getGameLevel, reason: collision with other method in class */
    public final void m٧١getGameLevel() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().gameLevel(), new Function1() { // from class: com.qiahao.nextvideo.ui.gameLevel.p
            public final Object invoke(Object obj) {
                Unit gameLevel$lambda$1;
                gameLevel$lambda$1 = GameLevelViewModel.getGameLevel$lambda$1(GameLevelViewModel.this, (ApiResponse) obj);
                return gameLevel$lambda$1;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.gameLevel.q
            public final Object invoke(Object obj) {
                Unit gameLevel$lambda$2;
                gameLevel$lambda$2 = GameLevelViewModel.getGameLevel$lambda$2((Throwable) obj);
                return gameLevel$lambda$2;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }
}
