package com.qiahao.nextvideo.utilities.userproxy;

import com.qiahao.nextvideo.ui.family.FamilySettingFragment;
import com.qiahao.nextvideo.ui.wallet.ExchangeDetailActivity;
import com.qiahao.nextvideo.utilities.DebugToolsKt;
import com.squareup.wire.internal.MathMethodsKt;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.android.agoo.message.MessageService;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0005\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a \u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0001H\u0002\u001a\"\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r\u001a\u0018\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u000bH\u0002\u001a$\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00012\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rH\u0002\u001a\u0018\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b\u001a(\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000bH\u0002¨\u0006\u0015"}, d2 = {"rankNumberFormat", "", ExchangeDetailActivity.TYPE_DIAMOND, "", "formatWithUnit", "value", "divisor", "unit", "formatRankNumber", "amount", "decimal", "", "replenishment", "", "formatNumber", FamilySettingFragment.FAMILY_NUMBER, "", "zeroFill", "formatNumberWithSuffix", "formatWithSuffix", "suffix", "app_googleRelease"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class NumberUtilsKt {
    private static final String formatNumber(double d, int i) {
        String str = "%.1f";
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    str = "%.3f";
                }
            } else {
                str = "%.2f";
            }
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format(Locale.US, str, Arrays.copyOf(new Object[]{Double.valueOf(d)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return new Regex("\\.?0+$").replace(format, "");
    }

    @NotNull
    public static final String formatNumberWithSuffix(long j, int i) {
        String valueOf;
        double d = j;
        try {
            if (d >= 1.0E9d) {
                valueOf = formatWithSuffix(j, 1.0E9d, "B", i);
            } else if (d >= 1000000.0d) {
                valueOf = formatWithSuffix(j, 1000000.0d, "M", i);
            } else if (d >= 1000.0d) {
                valueOf = formatWithSuffix(j, 1000.0d, "K", i);
            } else {
                valueOf = String.valueOf(j);
            }
            return valueOf;
        } catch (Exception e) {
            DebugToolsKt.printfE("formatNumberWithSuffix", e.getLocalizedMessage());
            return MessageService.MSG_DB_READY_REPORT;
        }
    }

    public static /* synthetic */ String formatNumberWithSuffix$default(long j, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 3;
        }
        return formatNumberWithSuffix(j, i);
    }

    @NotNull
    public static final String formatRankNumber(long j, int i, boolean z) {
        double d = j;
        if (d >= 1000.0d && d < 1000000.0d) {
            return zeroFill(formatNumber(d / 1000.0d, i), i, z) + "K";
        }
        if (d >= 1000000.0d && d < 1.0E9d) {
            return zeroFill(formatNumber(d / 1000000.0d, i), i, z) + "M";
        }
        if (d >= 1.0E9d) {
            return zeroFill(formatNumber(d / 1.0E9d, i), i, z) + "B";
        }
        return zeroFill(String.valueOf(j), i, z);
    }

    public static /* synthetic */ String formatRankNumber$default(long j, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 2;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return formatRankNumber(j, i, z);
    }

    private static final String formatWithSuffix(long j, double d, String str, int i) {
        double d2 = j / d;
        String str2 = "%.1f";
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    str2 = "%.3f";
                }
            } else {
                str2 = "%.2f";
            }
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format(Locale.US, str2, Arrays.copyOf(new Object[]{Double.valueOf(d2)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return new Regex("\\.?0+$").replace(format, "") + str;
    }

    private static final String formatWithUnit(long j, long j2, String str) {
        String bigDecimal = new BigDecimal(j / j2).setScale(2, RoundingMode.DOWN).toString();
        Intrinsics.checkNotNullExpressionValue(bigDecimal, "toString(...)");
        String replace = new Regex("\\.?0+$").replace(bigDecimal, "");
        if (replace.length() > 4) {
            int indexOf$default = StringsKt.indexOf$default(replace, '.', 0, false, 6, (Object) null);
            if (1 <= indexOf$default && indexOf$default < 3) {
                replace = replace.substring(0, 4);
                Intrinsics.checkNotNullExpressionValue(replace, "substring(...)");
            } else {
                replace = replace.substring(0, indexOf$default);
                Intrinsics.checkNotNullExpressionValue(replace, "substring(...)");
            }
        }
        return replace + str;
    }

    @NotNull
    public static final String rankNumberFormat(long j) {
        if (j >= MathMethodsKt.NANOS_PER_SECOND) {
            return formatWithUnit(j, MathMethodsKt.NANOS_PER_SECOND, "B");
        }
        if (j >= 1000000) {
            return formatWithUnit(j, 1000000L, "M");
        }
        if (j >= 1000) {
            return formatWithUnit(j, 1000L, "K");
        }
        return String.valueOf(j);
    }

    private static final String zeroFill(String str, int i, boolean z) {
        if (!z) {
            if (StringsKt.contains$default(str, ".000", false, 2, (Object) null)) {
                return StringsKt.replace$default(str, ".000", "", false, 4, (Object) null);
            }
            if (StringsKt.contains$default(str, ".00", false, 2, (Object) null)) {
                return StringsKt.replace$default(str, ".00", "", false, 4, (Object) null);
            }
            if (StringsKt.contains$default(str, ".0", false, 2, (Object) null)) {
                return StringsKt.replace$default(str, ".0", "", false, 4, (Object) null);
            }
            return str;
        }
        return str;
    }

    static /* synthetic */ String zeroFill$default(String str, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 2;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return zeroFill(str, i, z);
    }
}
