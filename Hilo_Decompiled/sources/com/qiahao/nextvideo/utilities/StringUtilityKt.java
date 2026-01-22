package com.qiahao.nextvideo.utilities;

import com.qiahao.nextvideo.ui.family.FamilySettingFragment;
import com.taobao.accs.common.Constants;
import com.tencent.mmkv.MMKV;
import com.therouter.inject.DebugOnlyKt;
import java.io.Closeable;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.android.agoo.message.MessageService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\u001a\u0018\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u0002\u001a\u000e\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f\u001a\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e\u001a\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\f\u001a\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000e\u001a\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0013\u001a\u00020\u0014\u001a\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0013\u001a\u00020\u0015\u001a\u0010\u0010\u0016\u001a\u00020\u00012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u001a\u0010\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c\u001a\u0018\u0010\u001d\u001a\u00020\u00012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020\u001f\u001a\u001e\u0010!\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020\u000e\u001a\u001e\u0010!\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020\u00142\u0006\u0010#\u001a\u00020\u00142\u0006\u0010$\u001a\u00020\u0014\u001a\n\u0010%\u001a\u00020\u0002*\u00020\u0014\u001a\n\u0010%\u001a\u00020\u0002*\u00020\u0015\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0000\u0010\u0003\"\u0015\u0010\u0004\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0003\"\u0015\u0010\u0005\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0003\"\u0015\u0010\u0006\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0003¨\u0006&"}, d2 = {"isDigit", "", "", "(Ljava/lang/String;)Z", "isValidPhoneNumber", "isLetterDigitOrChinese", "isSpecialCharacter", "isNewerVersion", "current", Constants.SP_KEY_VERSION, "formatSecond2Hms", "totalSecs", "", "getNumberDigits", "", FamilySettingFragment.FAMILY_NUMBER, "formatNumberToLimitedDigits", "maxDigits", "regularizePrice", "price", "", "", "isNullOrEmpty", "string", "", "close", "", "c", "Ljava/io/Closeable;", "objectEquals", DebugOnlyKt.PACKAGE, "", "b", "constrain", "amount", "low", "high", "format2Bit", "app_googleRelease"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class StringUtilityKt {
    public static final void close(@Nullable Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static final float constrain(float f, float f2, float f3) {
        return f < f2 ? f2 : f > f3 ? f3 : f;
    }

    @NotNull
    public static final String format2Bit(float f) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%.2f", Arrays.copyOf(new Object[]{Float.valueOf(f)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }

    @Nullable
    public static final String formatNumberToLimitedDigits(int i, int i2) {
        if (getNumberDigits(i) > i2) {
            StringBuilder sb2 = new StringBuilder();
            int i3 = 1;
            if (1 <= i2) {
                while (true) {
                    sb2.append(MessageService.MSG_ACCS_NOTIFY_DISMISS);
                    if (i3 == i2) {
                        break;
                    }
                    i3++;
                }
            }
            sb2.append("+");
            return sb2.toString();
        }
        return String.valueOf(i);
    }

    @NotNull
    public static final String formatSecond2Hms(long j) {
        long j2 = MMKV.ExpireInHour;
        long j3 = j / j2;
        long j4 = 60;
        long j5 = (j % j2) / j4;
        long j6 = j % j4;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%02dh%02dm%02ds", Arrays.copyOf(new Object[]{Long.valueOf(j3), Long.valueOf(j5), Long.valueOf(j6)}, 3));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }

    public static final int getNumberDigits(int i) {
        if (i <= 0) {
            return 0;
        }
        return (int) (Math.log10(i) + 1);
    }

    public static final boolean isDigit(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return new Regex("\\d+").matches(str);
    }

    public static final boolean isLetterDigitOrChinese(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return !new Regex("^[a-z0-9A-Z一-龥]+$").matches(str);
    }

    public static final boolean isNewerVersion(@NotNull String str, @Nullable String str2) {
        int i;
        int i2;
        Intrinsics.checkNotNullParameter(str, "current");
        if (str2 == null) {
            return false;
        }
        List split$default = StringsKt.split$default(str, new String[]{"."}, false, 0, 6, (Object) null);
        List split$default2 = StringsKt.split$default(str2, new String[]{"."}, false, 0, 6, (Object) null);
        int min = Math.min(split$default.size(), split$default2.size());
        for (int i3 = 0; i3 < min; i3++) {
            Integer intOrNull = StringsKt.toIntOrNull((String) split$default.get(i3));
            if (intOrNull != null) {
                i = intOrNull.intValue();
            } else {
                i = 0;
            }
            Integer intOrNull2 = StringsKt.toIntOrNull((String) split$default2.get(i3));
            if (intOrNull2 != null) {
                i2 = intOrNull2.intValue();
            } else {
                i2 = 0;
            }
            if (i > i2) {
                return false;
            }
            if (i < i2) {
                return true;
            }
        }
        split$default.size();
        split$default2.size();
        return false;
    }

    public static final boolean isNullOrEmpty(@Nullable CharSequence charSequence) {
        if (charSequence != null && charSequence.length() != 0) {
            return false;
        }
        return true;
    }

    public static final boolean isSpecialCharacter(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return Pattern.compile("[ _`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]|\n|\r|\t").matcher(str).find();
    }

    public static final boolean isValidPhoneNumber(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (isDigit(str) && (str.length() == 11 || str.length() == 12)) {
            return true;
        }
        return false;
    }

    public static final boolean objectEquals(@Nullable Object obj, @NotNull Object obj2) {
        Intrinsics.checkNotNullParameter(obj2, "b");
        if (obj != obj2 && (obj == null || !Intrinsics.areEqual(obj, obj2))) {
            return false;
        }
        return true;
    }

    @Nullable
    public static final String regularizePrice(float f) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format(Locale.CHINESE, "%.2f", Arrays.copyOf(new Object[]{Float.valueOf(f)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }

    public static final int constrain(int i, int i2, int i3) {
        return i < i2 ? i2 : i > i3 ? i3 : i;
    }

    @NotNull
    public static final String format2Bit(double d) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%.2f", Arrays.copyOf(new Object[]{Double.valueOf(d)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }

    public static final int getNumberDigits(long j) {
        if (j <= 0) {
            return 0;
        }
        return (int) (Math.log10(j) + 1);
    }

    @Nullable
    public static final String regularizePrice(double d) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format(Locale.CHINESE, "%.2f", Arrays.copyOf(new Object[]{Double.valueOf(d)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }
}
