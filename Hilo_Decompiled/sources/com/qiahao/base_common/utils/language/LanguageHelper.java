package com.qiahao.base_common.utils.language;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.LocaleList;
import android.util.DisplayMetrics;
import com.oudi.utils.store.IStore;
import com.oudi.utils.store.MMKVStore;
import com.qiahao.base_common.network.interceptors.HeaderInterceptor;
import fb.a;
import fb.b;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0005J\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u0006\u0010\t\u001a\u00020\u0005J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u0005J\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u0005H\u0002J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eJ\u0018\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0005H\u0002J\u0018\u0010\u0016\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0005H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/qiahao/base_common/utils/language/LanguageHelper;", "", "<init>", "()V", "currentLocale", "Ljava/util/Locale;", "getSystemLanguage", "getCurrentTimeZone", "", "getCurrentLanguage", "changeLanguageConfig", "", "locale", "changeLanguage", "Landroid/content/Context;", "context", "changeResources", "Landroid/content/res/Resources;", "wrapContext", "buildLocaleByLanguageTag", "languageTag", "defaultLocale", "limitSupportedLocale", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class LanguageHelper {

    @NotNull
    public static final LanguageHelper INSTANCE = new LanguageHelper();

    @Nullable
    private static Locale currentLocale;

    private LanguageHelper() {
    }

    private final Locale buildLocaleByLanguageTag(String languageTag, Locale defaultLocale) {
        try {
            if (languageTag.length() == 0) {
                return defaultLocale;
            }
            Locale forLanguageTag = Locale.forLanguageTag(languageTag);
            Intrinsics.checkNotNullExpressionValue(forLanguageTag, "forLanguageTag(...)");
            return limitSupportedLocale(forLanguageTag, defaultLocale);
        } catch (Exception unused) {
            return defaultLocale;
        }
    }

    private final Resources changeResources(Context context, Locale locale) {
        try {
            Resources resources = context.getResources();
            if (resources == null) {
                return null;
            }
            Configuration configuration = new Configuration(resources.getConfiguration());
            configuration.setLocale(locale);
            return new Resources(resources.getAssets(), resources.getDisplayMetrics(), configuration);
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }

    private final Locale limitSupportedLocale(Locale locale, Locale defaultLocale) {
        if (!Intrinsics.areEqual(locale, Locale.ENGLISH) && !Intrinsics.areEqual(locale, Locale.SIMPLIFIED_CHINESE) && !Intrinsics.areEqual(locale, Locale.TRADITIONAL_CHINESE) && !Intrinsics.areEqual(locale, Locale.CHINA)) {
            return defaultLocale;
        }
        return locale;
    }

    @NotNull
    public final Context changeLanguage(@NotNull Context context, @NotNull Locale locale) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(locale, "locale");
        changeResources(context, locale);
        currentLocale = locale;
        Locale.setDefault(locale);
        Resources resources = context.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        Configuration configuration = resources.getConfiguration();
        configuration.setLayoutDirection(locale);
        if (Build.VERSION.SDK_INT >= 24) {
            configuration.setLocale(locale);
            b.a();
            configuration.setLocales(a.a(new Locale[]{locale}));
            resources.updateConfiguration(configuration, displayMetrics);
            Context createConfigurationContext = context.createConfigurationContext(configuration);
            Intrinsics.checkNotNull(createConfigurationContext);
            return createConfigurationContext;
        }
        configuration.setLocale(locale);
        resources.updateConfiguration(configuration, displayMetrics);
        return context;
    }

    public final void changeLanguageConfig(@NotNull Locale locale) {
        Intrinsics.checkNotNullParameter(locale, "locale");
        IStore.DefaultImpls.setValue$default(MMKVStore.INSTANCE, HeaderInterceptor.LANGUAGE, locale.toLanguageTag(), null, 4, null);
    }

    @NotNull
    public final Locale getCurrentLanguage() {
        Locale locale = currentLocale;
        if (locale != null) {
            return locale;
        }
        String str = (String) IStore.DefaultImpls.getValue$default(MMKVStore.INSTANCE, HeaderInterceptor.LANGUAGE, "", null, 4, null);
        Locale systemLanguage = getSystemLanguage();
        Locale CHINA = Locale.CHINA;
        Intrinsics.checkNotNullExpressionValue(CHINA, "CHINA");
        Locale buildLocaleByLanguageTag = buildLocaleByLanguageTag(str, limitSupportedLocale(systemLanguage, CHINA));
        currentLocale = buildLocaleByLanguageTag;
        return buildLocaleByLanguageTag;
    }

    @Nullable
    public final String getCurrentTimeZone() {
        return TimeZone.getDefault().getDisplayName(false, 0);
    }

    @NotNull
    public final Locale getSystemLanguage() {
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

    @Nullable
    public final Context wrapContext(@Nullable Context context) {
        if (context == null) {
            return null;
        }
        return changeLanguage(context, getSystemLanguage());
    }
}
