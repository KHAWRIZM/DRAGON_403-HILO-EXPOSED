package com.google.android.gms.appinvite;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;
import com.google.android.gms.common.annotation.KeepForSdkWithMembers;
import java.util.ArrayList;

@KeepForSdkWithMembers
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class PreviewActivity extends Activity {
    public static final String ACTION_PREVIEW = "com.google.android.gms.appinvite.ACTION_PREVIEW";
    public static final String EXTRA_LAYOUT_RES_ID = "com.google.android.gms.appinvite.LAYOUT_RES_ID";
    public static final String EXTRA_TABS = "com.google.android.gms.appinvite.TABS";
    public static final String EXTRA_VIEWS = "com.google.android.gms.appinvite.VIEWS";
    public static final String KEY_TAB_CONTENT_ID = "tabContentId";
    public static final String KEY_TAB_TAG = "tabTag";
    public static final String KEY_TEXT_VIEW_IS_TITLE = "TextView_isTitle";
    public static final String KEY_TEXT_VIEW_TEXT = "TextView_text";
    public static final String KEY_TEXT_VIEW_TEXT_COLOR = "TextView_textColor";
    public static final String KEY_VIEW_BACKGROUND_COLOR = "View_backgroundColor";
    public static final String KEY_VIEW_ID = "View_id";
    public static final String KEY_VIEW_MIN_HEIGHT = "View_minHeight";
    public static final String KEY_VIEW_ON_CLICK_LISTENER = "View_onClickListener";
    public static final String KEY_WEB_VIEW_DATA = "WebView_data";
    public static final String ON_CLICK_LISTENER_CLOSE = "close";

    private final View zza(Context context, ViewGroup viewGroup, Bundle bundle) {
        char c10;
        View inflate = LayoutInflater.from(context).inflate(bundle.getInt(EXTRA_LAYOUT_RES_ID), viewGroup, false);
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(EXTRA_VIEWS);
        if (parcelableArrayList != null) {
            int size = parcelableArrayList.size();
            int i10 = 0;
            while (i10 < size) {
                Object obj = parcelableArrayList.get(i10);
                i10++;
                Bundle bundle2 = (Bundle) obj;
                View findViewById = inflate.findViewById(bundle2.getInt(KEY_VIEW_ID));
                for (String str : bundle2.keySet()) {
                    str.hashCode();
                    switch (str.hashCode()) {
                        case -1829808865:
                            if (str.equals(KEY_VIEW_MIN_HEIGHT)) {
                                c10 = 0;
                                break;
                            }
                            break;
                        case -499175494:
                            if (str.equals(KEY_TEXT_VIEW_TEXT)) {
                                c10 = 1;
                                break;
                            }
                            break;
                        case -111184848:
                            if (str.equals(KEY_WEB_VIEW_DATA)) {
                                c10 = 2;
                                break;
                            }
                            break;
                        case 573559753:
                            if (str.equals(KEY_TEXT_VIEW_TEXT_COLOR)) {
                                c10 = 3;
                                break;
                            }
                            break;
                        case 966644059:
                            if (str.equals(KEY_VIEW_BACKGROUND_COLOR)) {
                                c10 = 4;
                                break;
                            }
                            break;
                        case 1729346977:
                            if (str.equals(KEY_TEXT_VIEW_IS_TITLE)) {
                                c10 = 5;
                                break;
                            }
                            break;
                        case 1920443715:
                            if (str.equals(KEY_VIEW_ON_CLICK_LISTENER)) {
                                c10 = 6;
                                break;
                            }
                            break;
                    }
                    c10 = 65535;
                    switch (c10) {
                        case 0:
                            findViewById.setMinimumHeight(bundle2.getInt(str));
                            break;
                        case 1:
                            if (findViewById instanceof TextView) {
                                ((TextView) findViewById).setText(bundle2.getCharSequence(str));
                                break;
                            } else {
                                break;
                            }
                        case 2:
                            if (findViewById instanceof ViewGroup) {
                                WebView webView = new WebView(this);
                                webView.loadData(bundle2.getString(str), "text/html; charset=utf-8", "UTF-8");
                                ((ViewGroup) findViewById).addView(webView, new ViewGroup.LayoutParams(-1, -1));
                                break;
                            } else {
                                break;
                            }
                        case 3:
                            if (findViewById instanceof TextView) {
                                ((TextView) findViewById).setTextColor(bundle2.getInt(str));
                                break;
                            } else {
                                break;
                            }
                        case 4:
                            findViewById.setBackgroundColor(bundle2.getInt(str));
                            break;
                        case 5:
                            if ((findViewById instanceof TextView) && bundle2.getBoolean(str)) {
                                setTitle(((TextView) findViewById).getText());
                                break;
                            }
                            break;
                        case 6:
                            String string = bundle2.getString(str);
                            string.hashCode();
                            if (string.equals(ON_CLICK_LISTENER_CLOSE)) {
                                findViewById.setOnClickListener(new zzb(this));
                                break;
                            } else {
                                break;
                            }
                    }
                }
            }
        }
        return inflate;
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getCallingActivity() != null && "com.google.android.gms".equals(getCallingActivity().getPackageName())) {
            int i10 = 0;
            try {
                Context createPackageContext = createPackageContext("com.google.android.gms", 0);
                Bundle extras = getIntent().getExtras();
                View zza = zza(createPackageContext, null, extras);
                if (zza == null) {
                    finish();
                    return;
                }
                TabHost tabHost = (TabHost) zza.findViewById(android.R.id.tabhost);
                TabWidget tabWidget = (TabWidget) zza.findViewById(android.R.id.tabs);
                ArrayList parcelableArrayList = extras.getParcelableArrayList(EXTRA_TABS);
                if (tabHost != null && tabWidget != null && parcelableArrayList != null) {
                    tabHost.setup();
                    int size = parcelableArrayList.size();
                    while (i10 < size) {
                        Object obj = parcelableArrayList.get(i10);
                        i10++;
                        Bundle bundle2 = (Bundle) obj;
                        TabHost.TabSpec newTabSpec = tabHost.newTabSpec(bundle2.getString(KEY_TAB_TAG));
                        newTabSpec.setContent(bundle2.getInt(KEY_TAB_CONTENT_ID));
                        newTabSpec.setIndicator(zza(createPackageContext, tabWidget, bundle2));
                        tabHost.addTab(newTabSpec);
                    }
                }
                setContentView(zza);
                return;
            } catch (PackageManager.NameNotFoundException unused) {
                finish();
                return;
            }
        }
        finish();
    }
}
