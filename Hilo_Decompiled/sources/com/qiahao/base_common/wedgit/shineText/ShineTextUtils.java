package com.qiahao.base_common.wedgit.shineText;

import android.graphics.Color;
import android.text.TextUtils;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.qiahao.base_common.model.ShineColorData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010$\u001a\u0004\u0018\u00010\u00052\u0006\u0010%\u001a\u00020!J\u0018\u0010&\u001a\u0004\u0018\u00010\u00052\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020!J\u0018\u0010*\u001a\u0004\u0018\u00010\u00052\u0006\u0010+\u001a\u00020(2\u0006\u0010)\u001a\u00020!R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007R\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0007R\u0011\u0010\u0010\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0007R\u0011\u0010\u0012\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0007R\u0011\u0010\u0014\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0007R\u0011\u0010\u0016\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0007R\u0011\u0010\u0018\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0007R\u0011\u0010\u001a\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0007R\u0011\u0010\u001c\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0007R\u0011\u0010\u001e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0007R\u0014\u0010 \u001a\u00020!X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#¨\u0006,"}, d2 = {"Lcom/qiahao/base_common/wedgit/shineText/ShineTextUtils;", "", "<init>", "()V", "oneText", "Lcom/qiahao/base_common/model/ShineColorData;", "getOneText", "()Lcom/qiahao/base_common/model/ShineColorData;", "twoText", "getTwoText", "threeText", "getThreeText", "fourText", "getFourText", "fiveText", "getFiveText", "sixText", "getSixText", "svip3", "getSvip3", "svip4", "getSvip4", "svip5", "getSvip5", "svip6", "getSvip6", "svip7", "getSvip7", "noble6", "getNoble6", "countryText", "getCountryText", "regex", "", "getRegex", "()Ljava/lang/String;", "getShineColorData", ViewHierarchyConstants.TEXT_KEY, "getSvipNick", "svipLevel", "", "str", "getNoble", "nobleLevel", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class ShineTextUtils {

    @NotNull
    public static final ShineTextUtils INSTANCE = new ShineTextUtils();

    @NotNull
    private static final ShineColorData oneText = new ShineColorData(Color.parseColor("#B67E29"), new int[]{Color.parseColor("#FFFFF985"), Color.parseColor("#FFB67E29"), Color.parseColor("#FFB67E29"), Color.parseColor("#FFB67E29"), Color.parseColor("#FFB67E29"), Color.parseColor("#FFFFF985"), Color.parseColor("#FFB67E29"), Color.parseColor("#FFB67E29"), Color.parseColor("#FFB67E29"), Color.parseColor("#FFB67E29"), Color.parseColor("#FFFFF985")}, 0, 4, null);

    @NotNull
    private static final ShineColorData twoText = new ShineColorData(Color.parseColor("#E5392B"), new int[]{Color.parseColor("#FFFFF985"), Color.parseColor("#FFE5392B"), Color.parseColor("#FFE5392B"), Color.parseColor("#FFE5392B"), Color.parseColor("#FFE5392B"), Color.parseColor("#FFFFF985"), Color.parseColor("#FFE5392B"), Color.parseColor("#FFE5392B"), Color.parseColor("#FFE5392B"), Color.parseColor("#FFE5392B"), Color.parseColor("#FFFFF985")}, 0, 4, null);

    @NotNull
    private static final ShineColorData threeText = new ShineColorData(Color.parseColor("#DF43C8"), new int[]{Color.parseColor("#FFFFF985"), Color.parseColor("#FFDF43C8"), Color.parseColor("#FFDF43C8"), Color.parseColor("#FFDF43C8"), Color.parseColor("#FFDF43C8"), Color.parseColor("#FFFFF985"), Color.parseColor("#FFDF43C8"), Color.parseColor("#FFDF43C8"), Color.parseColor("#FFDF43C8"), Color.parseColor("#FFDF43C8"), Color.parseColor("#FFFFF985")}, 0, 4, null);

    @NotNull
    private static final ShineColorData fourText = new ShineColorData(Color.parseColor("#8830FF"), new int[]{Color.parseColor("#FFFFF985"), Color.parseColor("#FF8830FF"), Color.parseColor("#FF8830FF"), Color.parseColor("#FF8830FF"), Color.parseColor("#FF8830FF"), Color.parseColor("#FFFFF985"), Color.parseColor("#FF8830FF"), Color.parseColor("#FF8830FF"), Color.parseColor("#FF8830FF"), Color.parseColor("#FF8830FF"), Color.parseColor("#FFFFF985")}, 0, 4, null);

    @NotNull
    private static final ShineColorData fiveText = new ShineColorData(Color.parseColor("#3091ff"), new int[]{Color.parseColor("#ff3091ff"), Color.parseColor("#ff3091ff"), Color.parseColor("#ff3091ff")}, 0, 4, null);

    @NotNull
    private static final ShineColorData sixText = new ShineColorData(Color.parseColor("#64d15c"), new int[]{Color.parseColor("#ff64d15c"), Color.parseColor("#ff64d15c"), Color.parseColor("#ff64d15c")}, 0, 4, null);

    @NotNull
    private static final ShineColorData svip3 = new ShineColorData(Color.parseColor("#FF7700"), new int[]{Color.parseColor("#FFFFF985"), Color.parseColor("#FFFF7700"), Color.parseColor("#FFFF7700"), Color.parseColor("#FFFF7700"), Color.parseColor("#FFFF7700"), Color.parseColor("#FFFFF985")}, 0, 4, null);

    @NotNull
    private static final ShineColorData svip4 = new ShineColorData(Color.parseColor("#8830ff"), new int[]{Color.parseColor("#FFFFF985"), Color.parseColor("#FF8830ff"), Color.parseColor("#FF8830ff"), Color.parseColor("#FF8830ff"), Color.parseColor("#FF8830ff"), Color.parseColor("#FFFFF985")}, 0, 4, null);

    @NotNull
    private static final ShineColorData svip5 = new ShineColorData(Color.parseColor("#e5392b"), new int[]{Color.parseColor("#FFFFF985"), Color.parseColor("#FFe5392b"), Color.parseColor("#FFe5392b"), Color.parseColor("#FFe5392b"), Color.parseColor("#FFe5392b"), Color.parseColor("#FFFFF985")}, 0, 4, null);

    @NotNull
    private static final ShineColorData svip6 = new ShineColorData(Color.parseColor("#b67e29"), new int[]{Color.parseColor("#FFFFF985"), Color.parseColor("#FFb67e29"), Color.parseColor("#FFb67e29"), Color.parseColor("#FFb67e29"), Color.parseColor("#FFb67e29"), Color.parseColor("#FFFFF985")}, 0, 4, null);

    @NotNull
    private static final ShineColorData svip7 = new ShineColorData(Color.parseColor("#FFd88200"), new int[]{Color.parseColor("#FFfffcbe"), Color.parseColor("#FFd88200"), Color.parseColor("#FFd88200"), Color.parseColor("#FFd88200"), Color.parseColor("#FFd88200"), Color.parseColor("#FFfffcbe")}, 0, 4, null);

    @NotNull
    private static final ShineColorData noble6 = new ShineColorData(Color.parseColor("#FFda62ff"), new int[]{Color.parseColor("#FFda62ff"), Color.parseColor("#FFff513e"), Color.parseColor("#FFffe154"), Color.parseColor("#FF4bd175"), Color.parseColor("#FF43adff"), Color.parseColor("#FFda62ff")}, 0, 4, null);

    @NotNull
    private static final ShineColorData countryText = new ShineColorData(Color.parseColor("#FFFFFFFF"), new int[]{Color.parseColor("#FFFFFFFF"), Color.parseColor("#FFF2AF37"), Color.parseColor("#FFF2AF37"), Color.parseColor("#FFF2AF37"), Color.parseColor("#FFF2AF37")}, 0, 4, null);

    @NotNull
    private static final String regex = "[0-9]*";

    private ShineTextUtils() {
    }

    @NotNull
    public final ShineColorData getCountryText() {
        return countryText;
    }

    @NotNull
    public final ShineColorData getFiveText() {
        return fiveText;
    }

    @NotNull
    public final ShineColorData getFourText() {
        return fourText;
    }

    @Nullable
    public final ShineColorData getNoble(int nobleLevel, @NotNull String str) {
        ShineColorData shineColorData;
        Intrinsics.checkNotNullParameter(str, "str");
        if (nobleLevel != 6) {
            if (nobleLevel != 7) {
                if (nobleLevel > 6) {
                    shineColorData = noble6;
                } else {
                    shineColorData = null;
                }
            } else {
                shineColorData = noble6;
            }
        } else {
            shineColorData = noble6;
        }
        if (shineColorData != null) {
            shineColorData.setTextSize(str.length());
        }
        return shineColorData;
    }

    @NotNull
    public final ShineColorData getNoble6() {
        return noble6;
    }

    @NotNull
    public final ShineColorData getOneText() {
        return oneText;
    }

    @NotNull
    public final String getRegex() {
        return regex;
    }

    @Nullable
    public final ShineColorData getShineColorData(@NotNull String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        ShineColorData shineColorData = null;
        String obj = StringsKt.trim((CharSequence) StringsKt.replace$default(text, "ID:", "", false, 4, (Object) null)).toString();
        if (TextUtils.isEmpty(obj)) {
            return null;
        }
        if (new Regex(regex).matches(obj)) {
            if (obj.length() > 1) {
                if (TextUtils.isEmpty(StringsKt.replace$default(obj, StringsKt.first(obj) + "", "", false, 4, (Object) null))) {
                    shineColorData = fourText;
                }
            }
            switch (obj.length()) {
                case 1:
                    shineColorData = oneText;
                    break;
                case 2:
                    shineColorData = twoText;
                    break;
                case 3:
                    shineColorData = threeText;
                    break;
                case 4:
                    shineColorData = fourText;
                    break;
                case 5:
                    shineColorData = fiveText;
                    break;
                case 6:
                    shineColorData = sixText;
                    break;
            }
        } else {
            shineColorData = twoText;
        }
        if (shineColorData != null) {
            shineColorData.setTextSize(obj.length());
        }
        return shineColorData;
    }

    @NotNull
    public final ShineColorData getSixText() {
        return sixText;
    }

    @NotNull
    public final ShineColorData getSvip3() {
        return svip3;
    }

    @NotNull
    public final ShineColorData getSvip4() {
        return svip4;
    }

    @NotNull
    public final ShineColorData getSvip5() {
        return svip5;
    }

    @NotNull
    public final ShineColorData getSvip6() {
        return svip6;
    }

    @NotNull
    public final ShineColorData getSvip7() {
        return svip7;
    }

    @Nullable
    public final ShineColorData getSvipNick(int svipLevel, @NotNull String str) {
        ShineColorData shineColorData;
        Intrinsics.checkNotNullParameter(str, "str");
        if (svipLevel != 3) {
            if (svipLevel != 4) {
                if (svipLevel != 5) {
                    if (svipLevel != 6) {
                        if (svipLevel != 7) {
                            if (svipLevel > 7) {
                                shineColorData = svip7;
                            } else {
                                shineColorData = null;
                            }
                        } else {
                            shineColorData = svip7;
                        }
                    } else {
                        shineColorData = svip6;
                    }
                } else {
                    shineColorData = svip5;
                }
            } else {
                shineColorData = svip4;
            }
        } else {
            shineColorData = svip3;
        }
        if (shineColorData != null) {
            shineColorData.setTextSize(str.length());
        }
        return shineColorData;
    }

    @NotNull
    public final ShineColorData getThreeText() {
        return threeText;
    }

    @NotNull
    public final ShineColorData getTwoText() {
        return twoText;
    }
}
