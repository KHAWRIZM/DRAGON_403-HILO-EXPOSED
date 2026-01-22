package com.qhqc.core.basic.ktx;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.LocaleList;
import androidx.core.content.a;
import com.qhqc.core.basic.router.provider.BasicModuleApp;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0004\u001a\u0006\u0010\u0000\u001a\u00020\u0001\u001a\n\u0010\u0002\u001a\u00020\u0003*\u00020\u0003\u001a\f\u0010\u0004\u001a\u0004\u0018\u00010\u0005*\u00020\u0003\u001a\n\u0010\u0006\u001a\u00020\u0007*\u00020\u0003\u001a'\u0010\b\u001a\u00020\u0007*\u00020\u00032\u0016\u0010\t\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000b0\n\"\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\f\u001a'\u0010\b\u001a\u00020\u0007*\u00020\u00072\u0016\u0010\t\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000b0\n\"\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\r\u001a'\u0010\u000e\u001a\u00020\u0007*\u00020\u00032\u0016\u0010\t\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000b0\n\"\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\f\u001a)\u0010\u000e\u001a\u0004\u0018\u00010\u0007*\u00020\u00072\u0016\u0010\t\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000b0\n\"\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\r¨\u0006\u000f"}, d2 = {"getLocal", "Ljava/util/Locale;", "getColor", "", "getDrawable", "Landroid/graphics/drawable/Drawable;", "getString", "", "messageFormat", "args", "", "", "(I[Ljava/lang/Object;)Ljava/lang/String;", "(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "toFormat", "basic_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class CompatKtxKt {
    public static final int getColor(int i10) {
        return a.getColor(BasicModuleApp.application(), i10);
    }

    @Nullable
    public static final Drawable getDrawable(int i10) {
        return a.getDrawable(BasicModuleApp.application(), i10);
    }

    @NotNull
    public static final Locale getLocal() {
        LocaleList localeList;
        Locale locale;
        if (Build.VERSION.SDK_INT >= 24) {
            localeList = LocaleList.getDefault();
            locale = localeList.get(0);
            Intrinsics.checkNotNull(locale);
            return locale;
        }
        Locale locale2 = Locale.getDefault();
        Intrinsics.checkNotNull(locale2);
        return locale2;
    }

    @NotNull
    public static final String getString(int i10) {
        String string = a.getString(BasicModuleApp.application(), i10);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    @NotNull
    public static final String messageFormat(@NotNull String str, @NotNull Object... args) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(args, "args");
        try {
            String format = MessageFormat.format(str, Arrays.copyOf(args, args.length));
            Intrinsics.checkNotNull(format);
            return format;
        } catch (Exception unused) {
            return str;
        }
    }

    @Nullable
    public static final String toFormat(@NotNull String str, @NotNull Object... args) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(args, "args");
        try {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            Locale local = getLocal();
            Object[] copyOf = Arrays.copyOf(args, args.length);
            String format = String.format(local, str, Arrays.copyOf(copyOf, copyOf.length));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            return format;
        } catch (Exception unused) {
            return str;
        }
    }

    @NotNull
    public static final String toFormat(int i10, @NotNull Object... args) {
        Intrinsics.checkNotNullParameter(args, "args");
        try {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            Locale local = getLocal();
            String string = getString(i10);
            Object[] copyOf = Arrays.copyOf(args, args.length);
            String format = String.format(local, string, Arrays.copyOf(copyOf, copyOf.length));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            return format;
        } catch (Exception unused) {
            return getString(i10);
        }
    }

    @NotNull
    public static final String messageFormat(int i10, @NotNull Object... args) {
        Intrinsics.checkNotNullParameter(args, "args");
        try {
            String format = MessageFormat.format(getString(i10), Arrays.copyOf(args, args.length));
            Intrinsics.checkNotNull(format);
            return format;
        } catch (Exception unused) {
            return getString(i10);
        }
    }
}
