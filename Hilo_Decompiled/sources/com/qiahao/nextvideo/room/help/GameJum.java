package com.qiahao.nextvideo.room.help;

import android.content.Context;
import com.google.gson.reflect.TypeToken;
import com.oudi.core.callback.SuperCallBack;
import com.oudi.core.support.ActivityLifecycleManager;
import com.oudi.utils.store.IStore;
import com.oudi.utils.store.MMKVStore;
import com.qiahao.base_common.BaseApplication;
import com.qiahao.base_common.common.BaseActivity;
import com.qiahao.base_common.navigation.NavigationHelper;
import com.qiahao.nextvideo.data.model.GameConfiguration;
import com.qiahao.nextvideo.data.model.GameUrlConfig;
import com.qiahao.nextvideo.sheep.GameMatchActivity;
import com.qiahao.nextvideo.ui.home.game.MatchGameActivity;
import com.qiahao.nextvideo.ui.webview.H5GameDialog;
import com.qiahao.nextvideo.ui.webview.H5GemGameDialog;
import com.taobao.accs.common.Constants;
import com.tencent.qcloud.tuicore.TUIConstants;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ6\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\u000b¨\u0006\u0013"}, d2 = {"Lcom/qiahao/nextvideo/room/help/GameJum;", "", "<init>", "()V", "showGame", "", "context", "Landroid/content/Context;", "gameConfiguration", "Lcom/qiahao/nextvideo/data/model/GameConfiguration;", "getGameUrl", "", GameMatchActivity.GAME_ID, "", "matchGame", GameMatchActivity.MATH_ID, Constants.KEY_MODE, "gameType", TUIConstants.TUILive.ROOM_ID, "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nGameJum.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GameJum.kt\ncom/qiahao/nextvideo/room/help/GameJum\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,103:1\n1869#2,2:104\n*S KotlinDebug\n*F\n+ 1 GameJum.kt\ncom/qiahao/nextvideo/room/help/GameJum\n*L\n62#1:104,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class GameJum {

    @NotNull
    public static final GameJum INSTANCE = new GameJum();

    private GameJum() {
    }

    public static /* synthetic */ void matchGame$default(GameJum gameJum, int i, int i2, int i3, int i4, String str, int i5, Object obj) {
        int i6;
        int i7;
        int i8;
        if ((i5 & 1) != 0) {
            i6 = 0;
        } else {
            i6 = i;
        }
        if ((i5 & 4) != 0) {
            i7 = 0;
        } else {
            i7 = i3;
        }
        if ((i5 & 8) != 0) {
            i8 = 0;
        } else {
            i8 = i4;
        }
        if ((i5 & 16) != 0) {
            str = "";
        }
        gameJum.matchGame(i6, i2, i7, i8, str);
    }

    @NotNull
    public final String getGameUrl(int r8) {
        try {
            ArrayList<GameUrlConfig> arrayList = (ArrayList) BaseApplication.Companion.getGSON().k((String) IStore.DefaultImpls.getValue$default(MMKVStore.INSTANCE, "game_url", "", (String) null, 4, (Object) null), new TypeToken<ArrayList<GameUrlConfig>>() { // from class: com.qiahao.nextvideo.room.help.GameJum$getGameUrl$typeToken$1
            }.getType());
            if (arrayList == null) {
                return "";
            }
            while (true) {
                String str = "";
                for (GameUrlConfig gameUrlConfig : arrayList) {
                    Integer gameId = gameUrlConfig.getGameId();
                    if (gameId != null && r8 == gameId.intValue() && (str = gameUrlConfig.getGameUrl()) == null) {
                        break;
                    }
                }
                return str;
            }
        } catch (Exception unused) {
            return "";
        }
    }

    public final void matchGame(int r3, int r4, int r5, int gameType, @NotNull String r7) {
        Intrinsics.checkNotNullParameter(r7, TUIConstants.TUILive.ROOM_ID);
        Context currentActivity = ActivityLifecycleManager.INSTANCE.currentActivity();
        if (currentActivity != null) {
            Context context = (BaseActivity) currentActivity;
            if (r4 != 1 && r4 != 2) {
                if (r4 != 9) {
                    if (r4 != 21 && r4 != 41) {
                        if (r4 != 15) {
                            if (r4 != 16) {
                                return;
                            }
                        }
                    }
                }
                GameMatchActivity.INSTANCE.startActivity(context, r3, r4, r7);
                return;
            }
            MatchGameActivity.INSTANCE.startActivity(context, r4, gameType, r5);
        }
    }

    public final void showGame(@NotNull Context context, @NotNull GameConfiguration gameConfiguration) {
        int i;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(gameConfiguration, "gameConfiguration");
        Integer gameType = gameConfiguration.getGameType();
        String str = "";
        if (gameType != null && gameType.intValue() == 0) {
            if (Intrinsics.areEqual(gameConfiguration.isFull(), Boolean.TRUE)) {
                NavigationHelper navigationHelper = NavigationHelper.INSTANCE;
                String url = gameConfiguration.getUrl();
                if (url != null) {
                    str = url;
                }
                NavigationHelper.jump$default(navigationHelper, str, (SuperCallBack) null, 2, (Object) null);
                return;
            }
            new H5GameDialog(context, gameConfiguration).show();
            return;
        }
        int i2 = 0;
        if ((gameType == null || gameType.intValue() != 7) && (gameType == null || gameType.intValue() != 9)) {
            if (gameType != null && gameType.intValue() == 8) {
                if (Intrinsics.areEqual(gameConfiguration.isFull(), Boolean.TRUE)) {
                    NavigationHelper navigationHelper2 = NavigationHelper.INSTANCE;
                    String url2 = gameConfiguration.getUrl();
                    if (url2 != null) {
                        str = url2;
                    }
                    NavigationHelper.jump$default(navigationHelper2, str, (SuperCallBack) null, 2, (Object) null);
                    return;
                }
                Integer gameId = gameConfiguration.getGameId();
                if (gameId != null) {
                    i2 = gameId.intValue();
                }
                new H5GemGameDialog(context, i2).show();
                return;
            }
            return;
        }
        GameMatchActivity.Companion companion = GameMatchActivity.INSTANCE;
        Integer gameId2 = gameConfiguration.getGameId();
        if (gameId2 != null) {
            i = gameId2.intValue();
        } else {
            i = 0;
        }
        GameMatchActivity.Companion.startActivity$default(companion, context, 0, i, null, 8, null);
    }
}
