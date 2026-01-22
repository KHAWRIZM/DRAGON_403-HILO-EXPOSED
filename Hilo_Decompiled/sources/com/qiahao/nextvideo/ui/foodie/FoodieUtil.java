package com.qiahao.nextvideo.ui.foodie;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\bJ\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\bJ\u000e\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\b¨\u0006\r"}, d2 = {"Lcom/qiahao/nextvideo/ui/foodie/FoodieUtil;", "", "<init>", "()V", "formatKValue", "", "value", "", "", "", "convertWithK", "getFoodieIcon", "type", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class FoodieUtil {

    @NotNull
    public static final FoodieUtil INSTANCE = new FoodieUtil();

    private FoodieUtil() {
    }

    @NotNull
    public final String convertWithK(int value) {
        if (value >= 1000) {
            double d = value / 1000.0d;
            int i = (int) d;
            if (d > i) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format = String.format(Locale.ENGLISH, "%.1f", Arrays.copyOf(new Object[]{Double.valueOf(d)}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                return format + "K";
            }
            return i + "K";
        }
        return String.valueOf(value);
    }

    @NotNull
    public final String formatKValue(double value) {
        String format = new DecimalFormat(",###").format(new BigDecimal(value).setScale(0, 3).doubleValue());
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }

    @NotNull
    public final String getFoodieIcon(int type) {
        if (type != 100) {
            if (type != 200) {
                switch (type) {
                    case 1:
                    default:
                        return "https://image.whoisamy.shop/Wagas/resource/game/foodie/fanqie.png";
                    case 2:
                        return "https://image.whoisamy.shop/Wagas/resource/game/foodie/luobo.png";
                    case 3:
                        return "https://image.whoisamy.shop/Wagas/resource/game/foodie/yumi.png";
                    case 4:
                        return "https://image.whoisamy.shop/Wagas/resource/game/foodie/baocai.png";
                    case 5:
                        return "https://image.whoisamy.shop/Wagas/resource/game/foodie/longxia.png";
                    case 6:
                        return "https://image.whoisamy.shop/Wagas/resource/game/foodie/niupai.png";
                    case 7:
                        return "https://image.whoisamy.shop/Wagas/resource/game/foodie/yu.png";
                    case 8:
                        return "https://image.whoisamy.shop/Wagas/resource/game/foodie/kaoji.png";
                }
            }
            return "https://image.whoisamy.shop/Wagas/resource/game/foodie/roulanzi.png";
        }
        return "https://image.whoisamy.shop/Wagas/resource/game/foodie/shucailan.png";
    }

    @NotNull
    public final String formatKValue(int value) {
        String format = new DecimalFormat(",###").format(new BigDecimal(value).setScale(0, 3).doubleValue());
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }

    @NotNull
    public final String formatKValue(long value) {
        String format = new DecimalFormat(",###").format(new BigDecimal(value).setScale(0, 3).doubleValue());
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }
}
