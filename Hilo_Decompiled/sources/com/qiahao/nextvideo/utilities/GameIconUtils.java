package com.qiahao.nextvideo.utilities;

import com.qiahao.nextvideo.R;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/qiahao/nextvideo/utilities/GameIconUtils;", "", "<init>", "()V", "gameIcon", "", "gameType", "(I)Ljava/lang/Integer;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class GameIconUtils {

    @NotNull
    public static final GameIconUtils INSTANCE = new GameIconUtils();

    private GameIconUtils() {
    }

    @Nullable
    public final Integer gameIcon(int gameType) {
        if (gameType != 1) {
            if (gameType != 2) {
                if (gameType != 21) {
                    switch (gameType) {
                        case 10:
                            return Integer.valueOf(R.drawable.game_item_icon_domino);
                        case 11:
                            return Integer.valueOf(R.drawable.game_item_icon_crush);
                        case 12:
                            return 2131231838;
                        case 13:
                            return 2131231841;
                        case 14:
                            return Integer.valueOf(R.drawable.game_item_icon_baloot);
                        default:
                            switch (gameType) {
                                case 17:
                                    return 2131231835;
                                case 18:
                                    return Integer.valueOf(R.drawable.game_item_icon_carrom);
                                case 19:
                                    return 2131231839;
                                default:
                                    return null;
                            }
                    }
                }
                return Integer.valueOf(R.drawable.game_item_icon_jackaro);
            }
            return Integer.valueOf(R.drawable.game_item_icon_uno);
        }
        return Integer.valueOf(R.drawable.game_item_icon_ludo);
    }
}
