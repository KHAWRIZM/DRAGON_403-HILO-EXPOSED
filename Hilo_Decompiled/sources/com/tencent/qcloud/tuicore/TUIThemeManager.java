package com.tencent.qcloud.tuicore;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import android.webkit.WebView;
import androidx.appcompat.app.g;
import androidx.core.os.l;
import com.tencent.qcloud.tuicore.util.SPUtils;
import com.tencent.qcloud.tuicore.util.TUIBuild;
import com.tencent.qcloud.tuicore.util.TUIUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class TUIThemeManager {
    public static final String LANGUAGE_EN = "en";
    public static final String LANGUAGE_ZH_CN = "zh";
    private static final String SP_KEY_LANGUAGE = "language";
    private static final String SP_KEY_THEME = "theme";
    private static final String SP_THEME_AND_LANGUAGE_NAME = "TUIThemeAndLanguage";
    private static final String TAG = "TUIThemeManager";
    public static final int THEME_LIGHT = 0;
    public static final int THEME_LIVELY = 1;
    public static final int THEME_SERIOUS = 2;
    private String currentLanguage;
    private int currentThemeID;
    private Locale defaultLocale;
    private boolean isInit;
    private final Map<String, Locale> languageMap;
    private final Map<Integer, List<Integer>> themeResIDMap;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public static class ThemeAndLanguageCallback implements Application.ActivityLifecycleCallbacks {
        ThemeAndLanguageCallback() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            TUIThemeManager.getInstance().applyTheme(activity);
            TUIThemeManager.getInstance().applyLanguage(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public static final class ThemeManagerHolder {
        private static final TUIThemeManager instance = new TUIThemeManager();

        private ThemeManagerHolder() {
        }
    }

    public static void addLanguage(String str, Locale locale) {
        Log.i(TAG, "addLanguage language=" + str + " locale=" + locale);
        getInstance().languageMap.put(str, locale);
    }

    public static void addLightTheme(int i) {
        addTheme(0, i);
    }

    public static void addLivelyTheme(int i) {
        addTheme(1, i);
    }

    public static void addSeriousTheme(int i) {
        addTheme(2, i);
    }

    public static void addTheme(int i, int i2) {
        if (i2 == 0) {
            Log.e(TAG, "addTheme failed, theme resID is zero");
            return;
        }
        Log.i(TAG, "addTheme themeID=" + i + " resID=" + i2);
        List<Integer> list = getInstance().themeResIDMap.get(Integer.valueOf(i));
        if (list == null) {
            list = new ArrayList<>();
            getInstance().themeResIDMap.put(Integer.valueOf(i), list);
        }
        if (list.contains(Integer.valueOf(i2))) {
            return;
        }
        list.add(Integer.valueOf(i2));
        getInstance().applyTheme(ServiceInitializer.getAppContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void applyTheme(Context context) {
        if (context == null) {
            return;
        }
        Resources.Theme theme = context.getTheme();
        if (theme == null) {
            context.setTheme(R.style.TUIBaseTheme);
            theme = context.getTheme();
        }
        mergeTheme(theme);
    }

    public static int getAttrResId(Context context, int i) {
        if (context != null && i != 0) {
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(i, typedValue, true);
            return typedValue.resourceId;
        }
        return 0;
    }

    public static TUIThemeManager getInstance() {
        return ThemeManagerHolder.instance;
    }

    private void mergeTheme(Resources.Theme theme) {
        List<Integer> list;
        if (theme == null || (list = this.themeResIDMap.get(Integer.valueOf(this.currentThemeID))) == null) {
            return;
        }
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            theme.applyStyle(it.next().intValue(), true);
        }
    }

    public static void setTheme(Context context) {
        getInstance().setThemeInternal(context);
    }

    private void setThemeInternal(Context context) {
        if (context == null) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        if (!this.isInit) {
            this.isInit = true;
            if (applicationContext instanceof Application) {
                ((Application) applicationContext).registerActivityLifecycleCallbacks(new ThemeAndLanguageCallback());
            }
            Locale locale = getLocale(applicationContext);
            SPUtils sPUtils = SPUtils.getInstance(SP_THEME_AND_LANGUAGE_NAME);
            this.currentLanguage = sPUtils.getString(SP_KEY_LANGUAGE, locale.getLanguage());
            this.currentThemeID = sPUtils.getInt(SP_KEY_THEME, 0);
            applyLanguage(applicationContext);
        }
        applyTheme(applicationContext);
    }

    public static void setWebViewLanguage(Context context) {
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                WebView.setDataDirectorySuffix(TUIUtil.getProcessName());
            }
            new WebView(context).destroy();
        } catch (Throwable th) {
            Log.e(TAG, "init language settings failed, " + th.getMessage());
        }
    }

    public void applyLanguage(Context context) {
        if (context == null) {
            return;
        }
        Locale locale = this.languageMap.get(this.currentLanguage);
        if (locale == null && (locale = this.defaultLocale) == null) {
            locale = getLocale(context);
        }
        Resources resources = context.getResources();
        Configuration configuration = resources.getConfiguration();
        configuration.locale = locale;
        if (TUIBuild.getVersionInt() >= 17) {
            configuration.setLocale(locale);
        }
        resources.updateConfiguration(configuration, null);
        if (Build.VERSION.SDK_INT >= 25) {
            context.createConfigurationContext(configuration).getResources().updateConfiguration(configuration, resources.getDisplayMetrics());
        }
    }

    public void changeLanguage(Context context, String str) {
        if (context == null || TextUtils.equals(str, this.currentLanguage)) {
            return;
        }
        this.currentLanguage = str;
        SPUtils.getInstance(SP_THEME_AND_LANGUAGE_NAME).put(SP_KEY_LANGUAGE, str, true);
        applyLanguage(context.getApplicationContext());
        applyLanguage(context);
    }

    public void changeTheme(Context context, int i) {
        if (context == null || i == this.currentThemeID) {
            return;
        }
        this.currentThemeID = i;
        SPUtils.getInstance(SP_THEME_AND_LANGUAGE_NAME).put(SP_KEY_THEME, i, true);
        applyTheme(context.getApplicationContext());
        applyTheme(context);
    }

    public String getCurrentLanguage() {
        return this.currentLanguage;
    }

    public int getCurrentTheme() {
        return this.currentThemeID;
    }

    public Locale getLocale(Context context) {
        if (TUIBuild.getVersionInt() < 24) {
            return context.getResources().getConfiguration().locale;
        }
        return l.a(g.a(context.getResources().getConfiguration()), 0);
    }

    public void setDefaultLocale(Locale locale) {
        this.defaultLocale = locale;
    }

    private TUIThemeManager() {
        this.isInit = false;
        this.themeResIDMap = new HashMap();
        HashMap hashMap = new HashMap();
        this.languageMap = hashMap;
        this.currentThemeID = 0;
        this.currentLanguage = "";
        this.defaultLocale = null;
        hashMap.put(LANGUAGE_ZH_CN, Locale.SIMPLIFIED_CHINESE);
        hashMap.put(LANGUAGE_EN, Locale.ENGLISH);
    }
}
