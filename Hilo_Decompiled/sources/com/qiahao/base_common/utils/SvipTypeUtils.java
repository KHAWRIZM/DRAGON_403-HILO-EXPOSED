package com.qiahao.base_common.utils;

import android.graphics.Color;
import com.qiahao.base_common.R;
import com.qiahao.base_common.model.cache.SVGAKey;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\f\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u0017\u0010\b\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u0017\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u000bJ\u0015\u0010\f\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\rJ\u0015\u0010\u000e\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\rJ\u0015\u0010\u000f\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\rJ\u0015\u0010\u0010\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\rJ\u0015\u0010\u0011\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\rJ\u0015\u0010\u0012\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\rJ\u0015\u0010\u0013\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\rJ\u0015\u0010\u0014\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\rJ\u0015\u0010\u0015\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\r¨\u0006\u0016"}, d2 = {"Lcom/qiahao/base_common/utils/SvipTypeUtils;", "", "<init>", "()V", "getSvipMedal", "", "svipLevel", "(Ljava/lang/Integer;)Ljava/lang/Integer;", "getSvipType", "getMicSVGA", "", "(Ljava/lang/Integer;)Ljava/lang/String;", "getProgressStartColor", "(Ljava/lang/Integer;)I", "getProgressEndColor", "getTipTextColor", "getProgressStartBgColor", "getProgressEndBgColor", "getProgressTextBgColor", "getProgressTextColor", "getGradingImage", "getTipBg", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class SvipTypeUtils {

    @NotNull
    public static final SvipTypeUtils INSTANCE = new SvipTypeUtils();

    private SvipTypeUtils() {
    }

    public final int getGradingImage(@Nullable Integer svipLevel) {
        if (svipLevel != null && svipLevel.intValue() == 1) {
            return R.drawable.svip_grading1;
        }
        if (svipLevel != null && svipLevel.intValue() == 2) {
            return R.drawable.svip_grading2;
        }
        if (svipLevel != null && svipLevel.intValue() == 3) {
            return R.drawable.svip_grading3;
        }
        if (svipLevel != null && svipLevel.intValue() == 4) {
            return R.drawable.svip_grading4;
        }
        if (svipLevel != null && svipLevel.intValue() == 5) {
            return R.drawable.svip_grading5;
        }
        if (svipLevel != null && svipLevel.intValue() == 6) {
            return R.drawable.svip_grading6;
        }
        if (svipLevel != null && svipLevel.intValue() == 7) {
            return R.drawable.svip_grading7;
        }
        if (svipLevel != null && svipLevel.intValue() == 8) {
            return R.drawable.svip_grading8;
        }
        if (svipLevel != null && svipLevel.intValue() == 9) {
            return R.drawable.svip_grading9;
        }
        if (svipLevel != null && svipLevel.intValue() == 10) {
            return R.drawable.svip_grading10;
        }
        if (svipLevel != null && svipLevel.intValue() == 11) {
            return R.drawable.svip_grading11;
        }
        return R.drawable.svip_grading11;
    }

    @Nullable
    public final String getMicSVGA(@Nullable Integer svipLevel) {
        int i10;
        if (svipLevel != null && svipLevel.intValue() == 4) {
            return SVGAKey.MIC_SVIP4;
        }
        if (svipLevel != null && svipLevel.intValue() == 5) {
            return SVGAKey.MIC_SVIP5;
        }
        if (svipLevel != null && svipLevel.intValue() == 6) {
            return SVGAKey.MIC_SVIP6;
        }
        if (svipLevel != null && svipLevel.intValue() == 7) {
            return SVGAKey.MIC_SVIP7;
        }
        if (svipLevel != null && svipLevel.intValue() == 8) {
            return SVGAKey.MIC_SVIP8;
        }
        if (svipLevel != null && svipLevel.intValue() == 9) {
            return SVGAKey.MIC_SVIP9;
        }
        if (svipLevel != null && svipLevel.intValue() == 10) {
            return SVGAKey.MIC_SVIP10;
        }
        if (svipLevel == null || svipLevel.intValue() != 11) {
            if (svipLevel != null) {
                i10 = svipLevel.intValue();
            } else {
                i10 = 0;
            }
            if (i10 <= 11) {
                return null;
            }
        }
        return SVGAKey.MIC_SVIP11;
    }

    public final int getProgressEndBgColor(@Nullable Integer svipLevel) {
        int i10;
        if (svipLevel != null && svipLevel.intValue() == 1) {
            return Color.parseColor("#5c7189");
        }
        if (svipLevel != null && svipLevel.intValue() == 2) {
            return Color.parseColor("#426d9e");
        }
        if (svipLevel != null && svipLevel.intValue() == 3) {
            return Color.parseColor("#ab691a");
        }
        if (svipLevel != null && svipLevel.intValue() == 4) {
            return Color.parseColor("#ac771a");
        }
        if (svipLevel != null && svipLevel.intValue() == 5) {
            return Color.parseColor("#68018e");
        }
        if ((svipLevel == null || svipLevel.intValue() != 6) && (svipLevel == null || svipLevel.intValue() != 7)) {
            if (svipLevel != null && svipLevel.intValue() == 8) {
                return Color.parseColor("#262036");
            }
            if (svipLevel != null && svipLevel.intValue() == 9) {
                return Color.parseColor("#362020");
            }
            if (svipLevel != null && svipLevel.intValue() == 10) {
                return Color.parseColor("#5E0909");
            }
            if (svipLevel != null && svipLevel.intValue() == 11) {
                return Color.parseColor("#7C500E");
            }
            if (svipLevel != null) {
                i10 = svipLevel.intValue();
            } else {
                i10 = 0;
            }
            if (i10 > 11) {
                return Color.parseColor("#7C500E");
            }
            return Color.parseColor("#ffffff");
        }
        return Color.parseColor("#202436");
    }

    public final int getProgressEndColor(@Nullable Integer svipLevel) {
        int i10;
        if ((svipLevel == null || svipLevel.intValue() != 1) && ((svipLevel == null || svipLevel.intValue() != 2) && ((svipLevel == null || svipLevel.intValue() != 3) && ((svipLevel == null || svipLevel.intValue() != 4) && ((svipLevel == null || svipLevel.intValue() != 5) && (svipLevel == null || svipLevel.intValue() != 6)))))) {
            if (svipLevel != null && svipLevel.intValue() == 7) {
                return R.color.white;
            }
            if (svipLevel != null && svipLevel.intValue() == 8) {
                return R.color.color_f1ccfd;
            }
            if (svipLevel != null && svipLevel.intValue() == 9) {
                return R.color.color_ffc042;
            }
            if (svipLevel != null && svipLevel.intValue() == 10) {
                return R.color.color_FF594A;
            }
            if (svipLevel != null && svipLevel.intValue() == 11) {
                return R.color.color_FFF2BC;
            }
            if (svipLevel != null) {
                i10 = svipLevel.intValue();
            } else {
                i10 = 0;
            }
            if (i10 > 11) {
                return R.color.color_FFF2BC;
            }
            return R.color.white;
        }
        return R.color.white;
    }

    public final int getProgressStartBgColor(@Nullable Integer svipLevel) {
        int i10;
        if (svipLevel != null && svipLevel.intValue() == 1) {
            return Color.parseColor("#5c7189");
        }
        if (svipLevel != null && svipLevel.intValue() == 2) {
            return Color.parseColor("#426d9e");
        }
        if (svipLevel != null && svipLevel.intValue() == 3) {
            return Color.parseColor("#ab691a");
        }
        if (svipLevel != null && svipLevel.intValue() == 4) {
            return Color.parseColor("#ac771a");
        }
        if (svipLevel != null && svipLevel.intValue() == 5) {
            return Color.parseColor("#8e018e");
        }
        if ((svipLevel == null || svipLevel.intValue() != 6) && (svipLevel == null || svipLevel.intValue() != 7)) {
            if (svipLevel != null && svipLevel.intValue() == 8) {
                return Color.parseColor("#231231");
            }
            if (svipLevel != null && svipLevel.intValue() == 9) {
                return Color.parseColor("#311212");
            }
            if (svipLevel != null && svipLevel.intValue() == 10) {
                return Color.parseColor("#5E0909");
            }
            if (svipLevel != null && svipLevel.intValue() == 11) {
                return Color.parseColor("#7C500E");
            }
            if (svipLevel != null) {
                i10 = svipLevel.intValue();
            } else {
                i10 = 0;
            }
            if (i10 > 11) {
                return Color.parseColor("#7C500E");
            }
            return Color.parseColor("#ffffff");
        }
        return Color.parseColor("#121831");
    }

    public final int getProgressStartColor(@Nullable Integer svipLevel) {
        int i10;
        if ((svipLevel == null || svipLevel.intValue() != 1) && ((svipLevel == null || svipLevel.intValue() != 2) && ((svipLevel == null || svipLevel.intValue() != 3) && ((svipLevel == null || svipLevel.intValue() != 4) && (svipLevel == null || svipLevel.intValue() != 5))))) {
            if (svipLevel != null && svipLevel.intValue() == 6) {
                return R.color.color_9da2c7;
            }
            if (svipLevel != null && svipLevel.intValue() == 7) {
                return R.color.color_ffe3a9;
            }
            if (svipLevel != null && svipLevel.intValue() == 8) {
                return R.color.color_ffdc7c;
            }
            if (svipLevel != null && svipLevel.intValue() == 9) {
                return R.color.color_ffeabf;
            }
            if (svipLevel != null && svipLevel.intValue() == 10) {
                return R.color.color_FFFC46;
            }
            if (svipLevel != null && svipLevel.intValue() == 11) {
                return R.color.color_FFED95;
            }
            if (svipLevel != null) {
                i10 = svipLevel.intValue();
            } else {
                i10 = 0;
            }
            if (i10 > 11) {
                return R.color.color_FFED95;
            }
            return R.color.white;
        }
        return R.color.white;
    }

    public final int getProgressTextBgColor(@Nullable Integer svipLevel) {
        int i10;
        if (svipLevel != null && svipLevel.intValue() == 1) {
            return R.color.color_5c7189;
        }
        if (svipLevel != null && svipLevel.intValue() == 2) {
            return R.color.color_234368;
        }
        if (svipLevel != null && svipLevel.intValue() == 3) {
            return R.color.color_8c5900;
        }
        if (svipLevel != null && svipLevel.intValue() == 4) {
            return R.color.color_ac771a;
        }
        if (svipLevel != null && svipLevel.intValue() == 5) {
            return R.color.color_540066;
        }
        if (svipLevel != null && svipLevel.intValue() == 6) {
            return R.color.color_9da2c7;
        }
        if ((svipLevel == null || svipLevel.intValue() != 7) && ((svipLevel == null || svipLevel.intValue() != 8) && (svipLevel == null || svipLevel.intValue() != 9))) {
            if (svipLevel != null && svipLevel.intValue() == 10) {
                return R.color.color_FF8D49;
            }
            if (svipLevel != null) {
                i10 = svipLevel.intValue();
            } else {
                i10 = 0;
            }
            if (i10 > 10) {
                return R.color.color_FF8D49;
            }
            return R.color.white;
        }
        return R.color.color_ffae00;
    }

    public final int getProgressTextColor(@Nullable Integer svipLevel) {
        if (svipLevel != null && svipLevel.intValue() == 1) {
            return R.color.color_5c7189;
        }
        if (svipLevel != null && svipLevel.intValue() == 2) {
            return R.color.color_234368;
        }
        if (svipLevel != null && svipLevel.intValue() == 3) {
            return R.color.color_8c5900;
        }
        if (svipLevel != null && svipLevel.intValue() == 4) {
            return R.color.color_ac771a;
        }
        if (svipLevel != null && svipLevel.intValue() == 5) {
            return R.color.color_540066;
        }
        if ((svipLevel == null || svipLevel.intValue() != 6) && ((svipLevel == null || svipLevel.intValue() != 7) && ((svipLevel == null || svipLevel.intValue() != 8) && ((svipLevel == null || svipLevel.intValue() != 9) && ((svipLevel == null || svipLevel.intValue() != 10) && (svipLevel == null || svipLevel.intValue() != 11)))))) {
            return R.color.white;
        }
        return R.color.white;
    }

    @Nullable
    public final Integer getSvipMedal(@Nullable Integer svipLevel) {
        int i10;
        if (svipLevel != null && svipLevel.intValue() == 1) {
            return Integer.valueOf(R.drawable.svip_medal1);
        }
        if (svipLevel != null && svipLevel.intValue() == 2) {
            return Integer.valueOf(R.drawable.svip_medal2);
        }
        if (svipLevel != null && svipLevel.intValue() == 3) {
            return Integer.valueOf(R.drawable.svip_medal3);
        }
        if (svipLevel != null && svipLevel.intValue() == 4) {
            return Integer.valueOf(R.drawable.svip_medal4);
        }
        if (svipLevel != null && svipLevel.intValue() == 5) {
            return Integer.valueOf(R.drawable.svip_medal5);
        }
        if (svipLevel != null && svipLevel.intValue() == 6) {
            return Integer.valueOf(R.drawable.svip_medal6);
        }
        if (svipLevel != null && svipLevel.intValue() == 7) {
            return Integer.valueOf(R.drawable.svip_medal7);
        }
        if (svipLevel != null && svipLevel.intValue() == 8) {
            return Integer.valueOf(R.drawable.svip_medal8);
        }
        if (svipLevel != null && svipLevel.intValue() == 9) {
            return Integer.valueOf(R.drawable.svip_medal9);
        }
        if (svipLevel != null && svipLevel.intValue() == 10) {
            return Integer.valueOf(R.drawable.svip_medal10);
        }
        if (svipLevel != null && svipLevel.intValue() == 11) {
            return Integer.valueOf(R.drawable.svip_medal11);
        }
        if (svipLevel != null) {
            i10 = svipLevel.intValue();
        } else {
            i10 = 0;
        }
        if (i10 > 11) {
            return Integer.valueOf(R.drawable.svip_medal11);
        }
        return null;
    }

    @Nullable
    public final Integer getSvipType(@Nullable Integer svipLevel) {
        int i10;
        if (svipLevel != null && svipLevel.intValue() == 1) {
            return Integer.valueOf(R.drawable.svip_type1);
        }
        if (svipLevel != null && svipLevel.intValue() == 2) {
            return Integer.valueOf(R.drawable.svip_type2);
        }
        if (svipLevel != null && svipLevel.intValue() == 3) {
            return Integer.valueOf(R.drawable.svip_type3);
        }
        if (svipLevel != null && svipLevel.intValue() == 4) {
            return Integer.valueOf(R.drawable.svip_type4);
        }
        if (svipLevel != null && svipLevel.intValue() == 5) {
            return Integer.valueOf(R.drawable.svip_type5);
        }
        if (svipLevel != null && svipLevel.intValue() == 6) {
            return Integer.valueOf(R.drawable.svip_type6);
        }
        if (svipLevel != null && svipLevel.intValue() == 7) {
            return Integer.valueOf(R.drawable.svip_type7);
        }
        if (svipLevel != null && svipLevel.intValue() == 8) {
            return Integer.valueOf(R.drawable.svip_type8);
        }
        if (svipLevel != null && svipLevel.intValue() == 9) {
            return Integer.valueOf(R.drawable.svip_type9);
        }
        if (svipLevel != null && svipLevel.intValue() == 10) {
            return Integer.valueOf(R.drawable.svip_type10);
        }
        if (svipLevel != null && svipLevel.intValue() == 11) {
            return Integer.valueOf(R.drawable.svip_type11);
        }
        if (svipLevel != null) {
            i10 = svipLevel.intValue();
        } else {
            i10 = 0;
        }
        if (i10 > 11) {
            return Integer.valueOf(R.drawable.svip_type11);
        }
        return null;
    }

    public final int getTipBg(@Nullable Integer svipLevel) {
        int i10;
        if (svipLevel != null && svipLevel.intValue() == 1) {
            return R.drawable.svip_tip_bg1;
        }
        if (svipLevel != null && svipLevel.intValue() == 2) {
            return R.drawable.svip_tip_bg2;
        }
        if (svipLevel != null && svipLevel.intValue() == 3) {
            return R.drawable.svip_tip_bg3;
        }
        if (svipLevel != null && svipLevel.intValue() == 4) {
            return R.drawable.svip_tip_bg4;
        }
        if (svipLevel != null && svipLevel.intValue() == 5) {
            return R.drawable.svip_tip_bg5;
        }
        if (svipLevel != null && svipLevel.intValue() == 6) {
            return R.drawable.svip_tip_bg6;
        }
        if (svipLevel != null && svipLevel.intValue() == 7) {
            return R.drawable.svip_tip_bg7;
        }
        if (svipLevel != null && svipLevel.intValue() == 8) {
            return R.drawable.svip_tip_bg8;
        }
        if (svipLevel != null && svipLevel.intValue() == 9) {
            return R.drawable.svip_tip_bg9;
        }
        if (svipLevel != null && svipLevel.intValue() == 10) {
            return R.drawable.svip_tip_bg10;
        }
        if (svipLevel != null && svipLevel.intValue() == 11) {
            return R.drawable.svip_tip_bg11;
        }
        if (svipLevel != null) {
            i10 = svipLevel.intValue();
        } else {
            i10 = 0;
        }
        if (i10 > 11) {
            return R.drawable.svip_tip_bg11;
        }
        return R.drawable.svip_tip_bg1;
    }

    public final int getTipTextColor(@Nullable Integer svipLevel) {
        int i10;
        if ((svipLevel == null || svipLevel.intValue() != 1) && ((svipLevel == null || svipLevel.intValue() != 2) && ((svipLevel == null || svipLevel.intValue() != 3) && ((svipLevel == null || svipLevel.intValue() != 4) && (svipLevel == null || svipLevel.intValue() != 5))))) {
            if (svipLevel != null && svipLevel.intValue() == 6) {
                return R.color.color_1c1f2e;
            }
            if ((svipLevel == null || svipLevel.intValue() != 7) && ((svipLevel == null || svipLevel.intValue() != 8) && ((svipLevel == null || svipLevel.intValue() != 9) && (svipLevel == null || svipLevel.intValue() != 10)))) {
                if (svipLevel != null) {
                    i10 = svipLevel.intValue();
                } else {
                    i10 = 0;
                }
                if (i10 > 10) {
                    return R.color.color_613000;
                }
                return R.color.white;
            }
            return R.color.color_613000;
        }
        return R.color.white;
    }
}
