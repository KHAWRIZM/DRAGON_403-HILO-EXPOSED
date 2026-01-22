package com.qiahao.nextvideo.utilities;

import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.game.GameLobby;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u000e\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\f"}, d2 = {"Lcom/qiahao/nextvideo/utilities/GameHallUtils;", "", "<init>", "()V", "getGameIcon", "", "tab", "", "isSelect", "", "(Ljava/lang/String;Z)Ljava/lang/Integer;", "getGameTitle", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class GameHallUtils {

    @NotNull
    public static final GameHallUtils INSTANCE = new GameHallUtils();

    private GameHallUtils() {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Nullable
    public final Integer getGameIcon(@NotNull String tab, boolean isSelect) {
        int i;
        int i2;
        int i3;
        int i4;
        Intrinsics.checkNotNullParameter(tab, "tab");
        switch (tab.hashCode()) {
            case -1326189720:
                if (tab.equals(GameLobby.TAB_DOMINO)) {
                    if (isSelect) {
                        i = R.drawable.home_dominoes_select;
                    } else {
                        i = R.drawable.home_dominoes_default;
                    }
                    return Integer.valueOf(i);
                }
                return null;
            case 115958:
                if (tab.equals(GameLobby.TAB_UNO)) {
                    if (isSelect) {
                        i2 = R.drawable.home_uno_selected;
                    } else {
                        i2 = R.drawable.home_uno_default;
                    }
                    return Integer.valueOf(i2);
                }
                return null;
            case 3333076:
                if (tab.equals(GameLobby.TAB_LUDO)) {
                    if (isSelect) {
                        i3 = R.drawable.home_ludo_selected;
                    } else {
                        i3 = R.drawable.home_ludo_default;
                    }
                    return Integer.valueOf(i3);
                }
                return null;
            case 106069776:
                if (tab.equals("other")) {
                    if (isSelect) {
                        i4 = R.drawable.home_other_selected;
                    } else {
                        i4 = R.drawable.home_other_default;
                    }
                    return Integer.valueOf(i4);
                }
                return null;
            default:
                return null;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @NotNull
    public final String getGameTitle(@NotNull String tab) {
        Intrinsics.checkNotNullParameter(tab, "tab");
        switch (tab.hashCode()) {
            case -1326189720:
                if (tab.equals(GameLobby.TAB_DOMINO)) {
                    return ResourcesKtxKt.getStringById(this, 2131952584);
                }
                return "";
            case 115958:
                if (tab.equals(GameLobby.TAB_UNO)) {
                    return ResourcesKtxKt.getStringById(this, 2131954363);
                }
                return "";
            case 3333076:
                if (tab.equals(GameLobby.TAB_LUDO)) {
                    return ResourcesKtxKt.getStringById(this, 2131953277);
                }
                return "";
            case 106069776:
                if (tab.equals("other")) {
                    return ResourcesKtxKt.getStringById(this, 2131953596);
                }
                return "";
            default:
                return "";
        }
    }
}
