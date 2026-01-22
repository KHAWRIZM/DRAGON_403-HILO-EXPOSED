package com.qiahao.base_common.utils;

import android.graphics.Color;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.qiahao.base_common.R;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u0015\u0010\b\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u0015\u0010\t\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u0015\u0010\n\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u0015\u0010\u000b\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u0015\u0010\f\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u0015\u0010\r\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u0015\u0010\u000e\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007¨\u0006\u000f"}, d2 = {"Lcom/qiahao/base_common/utils/GameTypeUtils;", "", "<init>", "()V", "getProgressBgColor", "", FirebaseAnalytics.Param.LEVEL, "(Ljava/lang/Integer;)I", "getProgressStartColor", "getProgressEndColor", "getProgressTextBgColor", "getTipTextColor", "getProgressTextColor", "getTitleColor", "getSubTitleColor", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class GameTypeUtils {

    @NotNull
    public static final GameTypeUtils INSTANCE = new GameTypeUtils();

    private GameTypeUtils() {
    }

    public final int getProgressBgColor(@Nullable Integer level) {
        int i10;
        if (level != null && level.intValue() == 1) {
            return Color.parseColor("#2B9B32");
        }
        if (level != null && level.intValue() == 2) {
            return Color.parseColor("#547FA4");
        }
        if (level != null && level.intValue() == 3) {
            return Color.parseColor("#BC411F");
        }
        if (level != null && level.intValue() == 4) {
            return Color.parseColor("#4651DB");
        }
        if (level != null && level.intValue() == 5) {
            return Color.parseColor("#7E24D0");
        }
        if (level != null && level.intValue() == 6) {
            return Color.parseColor("#BC0120");
        }
        if (level != null && level.intValue() == 7) {
            return Color.parseColor("#4C15FF");
        }
        if (level != null && level.intValue() == 8) {
            return Color.parseColor("#7100C5");
        }
        if (level != null && level.intValue() == 9) {
            return Color.parseColor("#880149");
        }
        if (level != null && level.intValue() == 10) {
            return Color.parseColor("#B27C00");
        }
        if (level != null && level.intValue() == 11) {
            return Color.parseColor("#11642B");
        }
        if (level != null && level.intValue() == 12) {
            return Color.parseColor("#112A64");
        }
        if (level != null && level.intValue() == 13) {
            return Color.parseColor("#2A1164");
        }
        if (level != null && level.intValue() == 14) {
            return Color.parseColor("#641152");
        }
        if (level != null && level.intValue() == 15) {
            return Color.parseColor("#671415");
        }
        if (level != null) {
            i10 = level.intValue();
        } else {
            i10 = 0;
        }
        if (i10 > 15) {
            return Color.parseColor("#671415");
        }
        return Color.parseColor("#ffffff");
    }

    public final int getProgressEndColor(@Nullable Integer level) {
        if ((level == null || level.intValue() != 1) && ((level == null || level.intValue() != 2) && ((level == null || level.intValue() != 3) && ((level == null || level.intValue() != 4) && ((level == null || level.intValue() != 5) && ((level == null || level.intValue() != 6) && ((level == null || level.intValue() != 7) && ((level == null || level.intValue() != 8) && ((level == null || level.intValue() != 9) && (level == null || level.intValue() != 10)))))))))) {
            if (level != null && level.intValue() == 11) {
                return R.color.color_ADFFCD;
            }
            if (level != null && level.intValue() == 12) {
                return R.color.color_BCD9FF;
            }
            if (level != null && level.intValue() == 13) {
                return R.color.color_E0CCFF;
            }
            if (level != null && level.intValue() == 14) {
                return R.color.color_FFC9E3;
            }
            if (level != null && level.intValue() == 15) {
                return R.color.color_FFD3D4;
            }
            return R.color.white;
        }
        return R.color.white;
    }

    public final int getProgressStartColor(@Nullable Integer level) {
        int i10;
        if (level != null && level.intValue() == 1) {
            return Color.parseColor("#50FF54");
        }
        if (level != null && level.intValue() == 2) {
            return Color.parseColor("#669CC6");
        }
        if (level != null && level.intValue() == 3) {
            return Color.parseColor("#FF8400");
        }
        if (level != null && level.intValue() == 4) {
            return Color.parseColor("#9593FF");
        }
        if (level != null && level.intValue() == 5) {
            return Color.parseColor("#C8AAFE");
        }
        if (level != null && level.intValue() == 6) {
            return Color.parseColor("#C8AAFE");
        }
        if (level != null && level.intValue() == 7) {
            return Color.parseColor("#7B78FF");
        }
        if (level != null && level.intValue() == 8) {
            return Color.parseColor("#C8AAFE");
        }
        if (level != null && level.intValue() == 9) {
            return Color.parseColor("#FF518B");
        }
        if (level != null && level.intValue() == 10) {
            return Color.parseColor("#DC9632");
        }
        if (level != null && level.intValue() == 11) {
            return Color.parseColor("#05C766");
        }
        if (level != null && level.intValue() == 12) {
            return Color.parseColor("#4AABFF");
        }
        if (level != null && level.intValue() == 13) {
            return Color.parseColor("#AB7BFF");
        }
        if (level != null && level.intValue() == 14) {
            return Color.parseColor("#FF66FD");
        }
        if (level != null && level.intValue() == 15) {
            return Color.parseColor("#FF696B");
        }
        if (level != null) {
            i10 = level.intValue();
        } else {
            i10 = 0;
        }
        if (i10 > 15) {
            return Color.parseColor("#FF696B");
        }
        return Color.parseColor("#ffffff");
    }

    public final int getProgressTextBgColor(@Nullable Integer level) {
        int i10;
        if (level != null && level.intValue() == 1) {
            return Color.parseColor("#2B9B32");
        }
        if (level != null && level.intValue() == 2) {
            return Color.parseColor("#547FA4");
        }
        if (level != null && level.intValue() == 3) {
            return Color.parseColor("#BC411F");
        }
        if (level != null && level.intValue() == 4) {
            return Color.parseColor("#4651DB");
        }
        if (level != null && level.intValue() == 5) {
            return Color.parseColor("#7E24D0");
        }
        if (level != null && level.intValue() == 6) {
            return Color.parseColor("#BC0120");
        }
        if (level != null && level.intValue() == 7) {
            return Color.parseColor("#4C15FF");
        }
        if (level != null && level.intValue() == 8) {
            return Color.parseColor("#7100C5");
        }
        if (level != null && level.intValue() == 9) {
            return Color.parseColor("#880149");
        }
        if (level != null && level.intValue() == 10) {
            return Color.parseColor("#B27C00");
        }
        if (level != null && level.intValue() == 11) {
            return Color.parseColor("#0EC41D");
        }
        if (level != null && level.intValue() == 12) {
            return Color.parseColor("#57A3FF");
        }
        if (level != null && level.intValue() == 13) {
            return Color.parseColor("#8C57FF");
        }
        if (level != null && level.intValue() == 14) {
            return Color.parseColor("#FF3ADB");
        }
        if (level != null && level.intValue() == 15) {
            return Color.parseColor("#FF3A40");
        }
        if (level != null) {
            i10 = level.intValue();
        } else {
            i10 = 0;
        }
        if (i10 > 15) {
            return Color.parseColor("#FF3A40");
        }
        return Color.parseColor("#ffffff");
    }

    public final int getProgressTextColor(@Nullable Integer level) {
        if ((level == null || level.intValue() != 1) && ((level == null || level.intValue() != 2) && ((level == null || level.intValue() != 3) && ((level == null || level.intValue() != 4) && ((level == null || level.intValue() != 5) && ((level == null || level.intValue() != 6) && ((level == null || level.intValue() != 7) && ((level == null || level.intValue() != 8) && ((level == null || level.intValue() != 9) && ((level == null || level.intValue() != 10) && ((level == null || level.intValue() != 11) && ((level == null || level.intValue() != 12) && ((level == null || level.intValue() != 13) && ((level == null || level.intValue() != 14) && (level == null || level.intValue() != 15))))))))))))))) {
            return R.color.white;
        }
        return R.color.white;
    }

    public final int getSubTitleColor(@Nullable Integer level) {
        int i10;
        if (level != null && level.intValue() == 1) {
            return Color.parseColor("#91FF82");
        }
        if (level != null && level.intValue() == 2) {
            return Color.parseColor("#C3E3FF");
        }
        if (level != null && level.intValue() == 3) {
            return Color.parseColor("#FEEF9B");
        }
        if (level != null && level.intValue() == 4) {
            return Color.parseColor("#9BBCFF");
        }
        if (level != null && level.intValue() == 5) {
            return Color.parseColor("#C8AAFE");
        }
        if (level != null && level.intValue() == 6) {
            return Color.parseColor("#FF8993");
        }
        if (level != null && level.intValue() == 7) {
            return Color.parseColor("#BBABFF");
        }
        if (level != null && level.intValue() == 8) {
            return Color.parseColor("#EEABFF");
        }
        if (level != null && level.intValue() == 9) {
            return Color.parseColor("#FF6598");
        }
        if (level != null && level.intValue() == 10) {
            return Color.parseColor("#FFDC50");
        }
        if (level != null && level.intValue() == 11) {
            return Color.parseColor("#FFEC0F");
        }
        if (level != null && level.intValue() == 12) {
            return Color.parseColor("#FFEC0F");
        }
        if (level != null && level.intValue() == 13) {
            return Color.parseColor("#FFEC0F");
        }
        if (level != null && level.intValue() == 14) {
            return Color.parseColor("#FFEC0F");
        }
        if (level != null && level.intValue() == 15) {
            return Color.parseColor("#FFEC0F");
        }
        if (level != null) {
            i10 = level.intValue();
        } else {
            i10 = 0;
        }
        if (i10 > 15) {
            return Color.parseColor("#FFEC0F");
        }
        return Color.parseColor("#ffffff");
    }

    public final int getTipTextColor(@Nullable Integer level) {
        if ((level == null || level.intValue() != 1) && ((level == null || level.intValue() != 2) && ((level == null || level.intValue() != 3) && ((level == null || level.intValue() != 4) && ((level == null || level.intValue() != 5) && ((level == null || level.intValue() != 6) && ((level == null || level.intValue() != 7) && ((level == null || level.intValue() != 8) && ((level == null || level.intValue() != 9) && ((level == null || level.intValue() != 10) && ((level == null || level.intValue() != 11) && ((level == null || level.intValue() != 12) && ((level == null || level.intValue() != 13) && ((level == null || level.intValue() != 14) && (level == null || level.intValue() != 15))))))))))))))) {
            return R.color.white;
        }
        return R.color.white;
    }

    public final int getTitleColor(@Nullable Integer level) {
        int i10;
        if (level != null && level.intValue() == 1) {
            return Color.parseColor("#91FF82");
        }
        if (level != null && level.intValue() == 2) {
            return Color.parseColor("#C3E3FF");
        }
        if (level != null && level.intValue() == 3) {
            return Color.parseColor("#FEEF9B");
        }
        if (level != null && level.intValue() == 4) {
            return Color.parseColor("#9BBCFF");
        }
        if (level != null && level.intValue() == 5) {
            return Color.parseColor("#C8AAFE");
        }
        if (level != null && level.intValue() == 6) {
            return Color.parseColor("#FF8993");
        }
        if (level != null && level.intValue() == 7) {
            return Color.parseColor("#BBABFF");
        }
        if (level != null && level.intValue() == 8) {
            return Color.parseColor("#EEABFF");
        }
        if (level != null && level.intValue() == 9) {
            return Color.parseColor("#FF6598");
        }
        if (level != null && level.intValue() == 10) {
            return Color.parseColor("#FFDC50");
        }
        if (level != null && level.intValue() == 11) {
            return Color.parseColor("#ECFFF1");
        }
        if (level != null && level.intValue() == 12) {
            return Color.parseColor("#ECF9FF");
        }
        if (level != null && level.intValue() == 13) {
            return Color.parseColor("#EEECFF");
        }
        if (level != null && level.intValue() == 14) {
            return Color.parseColor("#FFECED");
        }
        if (level != null && level.intValue() == 15) {
            return Color.parseColor("#FFECED");
        }
        if (level != null) {
            i10 = level.intValue();
        } else {
            i10 = 0;
        }
        if (i10 > 15) {
            return Color.parseColor("#FFECED");
        }
        return Color.parseColor("#ffffff");
    }
}
