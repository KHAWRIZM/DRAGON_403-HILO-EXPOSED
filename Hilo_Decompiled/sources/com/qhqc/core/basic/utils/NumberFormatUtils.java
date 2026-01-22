package com.qhqc.core.basic.utils;

import android.text.TextUtils;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.qhqc.core.basic.ktx.CompatKtxKt;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0007J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004J\u001a\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0007J\u0018\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u000f\u001a\u00020\u0010J\u0016\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0010J\u001a\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/qhqc/core/basic/utils/NumberFormatUtils;", "", "()V", "FORMAT_DEF", "", "FORMAT_K", "FORMAT_K0", "FORMAT_K2", "FORMAT_M", "FORMAT_M0", "FORMAT_M2", "decimalFormat", "d", "", "pattern", "locale", "Ljava/util/Locale;", "l", "", "s", "valueToScientific", "value", "", "valueToScientific2", "basic_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class NumberFormatUtils {

    @NotNull
    private static final String FORMAT_DEF = "%1$.0f";

    @NotNull
    private static final String FORMAT_K = "%1$.1fK";

    @NotNull
    private static final String FORMAT_K0 = "%1$.1fK";

    @NotNull
    private static final String FORMAT_K2 = "%1$.2fK";

    @NotNull
    private static final String FORMAT_M = "%1$.1fM";

    @NotNull
    private static final String FORMAT_M0 = "%1$.1fM";

    @NotNull
    private static final String FORMAT_M2 = "%1$.2fM";

    @NotNull
    public static final NumberFormatUtils INSTANCE = new NumberFormatUtils();

    private NumberFormatUtils() {
    }

    public static /* synthetic */ String decimalFormat$default(NumberFormatUtils numberFormatUtils, double d10, String str, Locale ENGLISH, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            ENGLISH = Locale.ENGLISH;
            Intrinsics.checkNotNullExpressionValue(ENGLISH, "ENGLISH");
        }
        return numberFormatUtils.decimalFormat(d10, str, ENGLISH);
    }

    public static /* synthetic */ String valueToScientific$default(NumberFormatUtils numberFormatUtils, int i10, Locale locale, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            locale = CompatKtxKt.getLocal();
        }
        return numberFormatUtils.valueToScientific(i10, locale);
    }

    public static /* synthetic */ String valueToScientific2$default(NumberFormatUtils numberFormatUtils, double d10, Locale locale, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
        }
        return numberFormatUtils.valueToScientific2(d10, locale);
    }

    @JvmOverloads
    @NotNull
    public final String decimalFormat(double d10, @Nullable String str) {
        return decimalFormat$default(this, d10, str, null, 4, null);
    }

    @JvmOverloads
    @NotNull
    public final String valueToScientific(double d10) {
        return valueToScientific$default(this, d10, (Locale) null, 2, (Object) null);
    }

    @JvmOverloads
    @NotNull
    public final String valueToScientific2(double d10) {
        return valueToScientific2$default(this, d10, null, 2, null);
    }

    public static /* synthetic */ String valueToScientific$default(NumberFormatUtils numberFormatUtils, double d10, Locale locale, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
        }
        return numberFormatUtils.valueToScientific(d10, locale);
    }

    @NotNull
    public final String decimalFormat(@NotNull String s10, @Nullable String pattern) {
        Intrinsics.checkNotNullParameter(s10, "s");
        try {
            return decimalFormat$default(this, Double.parseDouble(s10), pattern, null, 4, null);
        } catch (Exception unused) {
            return s10;
        }
    }

    @NotNull
    public final String valueToScientific(int value, @NotNull Locale locale) {
        Intrinsics.checkNotNullParameter(locale, "locale");
        return valueToScientific(value * 1.0d, locale);
    }

    @JvmOverloads
    @NotNull
    public final String valueToScientific2(double value, @NotNull Locale locale) {
        Intrinsics.checkNotNullParameter(locale, "locale");
        if (value >= 1000000.0d) {
            double doubleValue = BigDecimal.valueOf(value).divide(BigDecimal.valueOf(1000000L), 2, RoundingMode.FLOOR).doubleValue();
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format(locale, FORMAT_M2, Arrays.copyOf(new Object[]{Double.valueOf(doubleValue)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            return format;
        }
        if (value >= 1000.0d) {
            double doubleValue2 = BigDecimal.valueOf(value).divide(BigDecimal.valueOf(1000L), 2, RoundingMode.FLOOR).doubleValue();
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            String format2 = String.format(locale, FORMAT_K2, Arrays.copyOf(new Object[]{Double.valueOf(doubleValue2)}, 1));
            Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
            return format2;
        }
        StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
        String format3 = String.format(locale, FORMAT_DEF, Arrays.copyOf(new Object[]{Double.valueOf(value)}, 1));
        Intrinsics.checkNotNullExpressionValue(format3, "format(...)");
        return format3;
    }

    @NotNull
    public final String valueToScientific(@NotNull String value, @NotNull Locale locale) {
        double d10;
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(locale, "locale");
        try {
            d10 = Double.parseDouble(value);
        } catch (NumberFormatException unused) {
            d10 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        }
        return valueToScientific(d10, locale);
    }

    @NotNull
    public final String decimalFormat(long l10, @Nullable String pattern) {
        try {
            return decimalFormat$default(this, Double.parseDouble(String.valueOf(l10)), pattern, null, 4, null);
        } catch (Exception unused) {
            return String.valueOf(l10);
        }
    }

    @JvmOverloads
    @NotNull
    public final String valueToScientific(double value, @NotNull Locale locale) {
        Intrinsics.checkNotNullParameter(locale, "locale");
        if (value >= 1000000.0d) {
            double doubleValue = BigDecimal.valueOf(value).divide(BigDecimal.valueOf(1000000L), 1, RoundingMode.FLOOR).doubleValue();
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format(locale, "%1$.1fM", Arrays.copyOf(new Object[]{Double.valueOf(doubleValue)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            return format;
        }
        if (value >= 1000.0d) {
            double doubleValue2 = BigDecimal.valueOf(value).divide(BigDecimal.valueOf(1000L), 1, RoundingMode.FLOOR).doubleValue();
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            String format2 = String.format(locale, "%1$.1fK", Arrays.copyOf(new Object[]{Double.valueOf(doubleValue2)}, 1));
            Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
            return format2;
        }
        StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
        String format3 = String.format(locale, FORMAT_DEF, Arrays.copyOf(new Object[]{Double.valueOf(value)}, 1));
        Intrinsics.checkNotNullExpressionValue(format3, "format(...)");
        return format3;
    }

    @JvmOverloads
    @NotNull
    public final String decimalFormat(double d10, @Nullable String pattern, @NotNull Locale locale) {
        Intrinsics.checkNotNullParameter(locale, "locale");
        if (TextUtils.isEmpty(pattern)) {
            pattern = ",###";
        }
        NumberFormat numberFormat = NumberFormat.getInstance(locale);
        Intrinsics.checkNotNull(numberFormat, "null cannot be cast to non-null type java.text.DecimalFormat");
        DecimalFormat decimalFormat = (DecimalFormat) numberFormat;
        decimalFormat.applyPattern(pattern);
        String format = decimalFormat.format(d10);
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }
}
