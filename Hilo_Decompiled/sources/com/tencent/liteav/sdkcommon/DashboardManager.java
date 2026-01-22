package com.tencent.liteav.sdkcommon;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;
import com.qiahao.nextvideo.utilities.userproxy.UserProxyUtility;
import com.tencent.liteav.base.ContextUtils;
import com.tencent.liteav.base.Log;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.sdkcommon.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@JNINamespace("liteav::dashboard")
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class DashboardManager {
    private static final int LOG_MAX_SIZE = 15000;
    private static final String TAG = "DashboardManager";
    private final Context mAppContext;
    private final g mDashboardManagerView;
    private boolean mIsInit;
    private final g.a mSelectedDashboardChangeListener;
    private String mSelectedDashboardId;
    private final Handler mUIHandler;
    private final ArrayList<String> mDashboards = new ArrayList<>();
    private final Map<String, String> mDashboardStatus = new HashMap();
    private final Map<String, StringBuilder> mDashboardLogs = new HashMap();

    public DashboardManager() {
        g.a aVar = new g.a() { // from class: com.tencent.liteav.sdkcommon.DashboardManager.1
            @Override // com.tencent.liteav.sdkcommon.g.a
            public final void a(int i) {
                if (DashboardManager.this.mDashboards.size() <= i) {
                    return;
                }
                DashboardManager dashboardManager = DashboardManager.this;
                dashboardManager.mSelectedDashboardId = (String) dashboardManager.mDashboards.get(i);
                if (!DashboardManager.this.mDashboards.contains(DashboardManager.this.mSelectedDashboardId)) {
                    return;
                }
                DashboardManager.this.mDashboardManagerView.b((String) DashboardManager.this.mDashboardStatus.get(DashboardManager.this.mSelectedDashboardId));
                StringBuilder sb2 = (StringBuilder) DashboardManager.this.mDashboardLogs.get(DashboardManager.this.mSelectedDashboardId);
                if (sb2 != null) {
                    DashboardManager.this.mDashboardManagerView.a(sb2.toString());
                } else {
                    DashboardManager.this.mDashboardManagerView.a("");
                }
            }
        };
        this.mSelectedDashboardChangeListener = aVar;
        LiteavLog.i(TAG, "java DashBoardManager Construct");
        this.mIsInit = false;
        Context applicationContext = ContextUtils.getApplicationContext();
        this.mAppContext = applicationContext;
        this.mDashboardManagerView = new g(applicationContext, aVar);
        this.mUIHandler = new Handler(Looper.getMainLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addDashboardInternal(String str) {
        if (!this.mDashboards.contains(str)) {
            this.mDashboards.add(str);
            g gVar = this.mDashboardManagerView;
            gVar.e.add(str);
            if (gVar.l == null) {
                gVar.l = gVar.e.getItem(0);
                gVar.o.a(0);
            }
            gVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void appendLogInternal(String str, String str2) {
        g gVar;
        TextView textView;
        if (this.mDashboards.contains(str)) {
            StringBuilder sb2 = this.mDashboardLogs.get(str);
            if (sb2 == null) {
                sb2 = new StringBuilder();
                this.mDashboardLogs.put(str, sb2);
            }
            sb2.append(str2);
            sb2.append("\n");
            if (sb2.length() > LOG_MAX_SIZE) {
                sb2.delete(0, sb2.length() / 2);
            }
            if (str.equals(this.mSelectedDashboardId) && (textView = (gVar = this.mDashboardManagerView).i) != null) {
                textView.append(str2 + "\n");
                ScrollView scrollView = gVar.k;
                if (scrollView != null && scrollView.getScrollY() + gVar.k.getHeight() + gVar.a(100) >= gVar.i.getMeasuredHeight()) {
                    gVar.d.post(i.a(gVar));
                }
            }
        }
    }

    private boolean checkPermission() {
        if (LiteavSystemInfo.getSystemOSVersionInt() > 23 && !ia.k.a(this.mAppContext)) {
            Toast.makeText(this.mAppContext, "no system alert window permission, please authorize", 0).show();
            return false;
        }
        return true;
    }

    private boolean init() {
        if (this.mIsInit) {
            return true;
        }
        g gVar = this.mDashboardManagerView;
        Context context = gVar.c;
        if (context == null) {
            Log.e("DashboardManagerView", "dashBoardManagerView context is null", new Object[0]);
        } else {
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            gVar.f = windowManager;
            if (windowManager == null) {
                Log.e("DashboardManagerView", "get windowManager is fail", new Object[0]);
            } else {
                windowManager.getDefaultDisplay().getMetrics(gVar.a);
                gVar.n = gVar.a.heightPixels - gVar.a(50);
                g gVar2 = this.mDashboardManagerView;
                if (Build.VERSION.SDK_INT >= 26) {
                    gVar2.b.type = 2038;
                } else {
                    gVar2.b.type = 2002;
                }
                WindowManager.LayoutParams layoutParams = gVar2.b;
                layoutParams.format = 1;
                layoutParams.gravity = 8388659;
                layoutParams.width = gVar2.a.widthPixels;
                layoutParams.height = gVar2.n;
                layoutParams.x = 0;
                layoutParams.y = 0;
                layoutParams.flags = 32;
                LinearLayout linearLayout = new LinearLayout(gVar2.c);
                linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                linearLayout.setOrientation(1);
                linearLayout.setOnTouchListener(new g.b(gVar2, (byte) 0));
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(gVar2.a(70), gVar2.a(40));
                Button button = new Button(gVar2.c);
                button.setText("Resize");
                button.setLayoutParams(layoutParams2);
                button.setOnClickListener(j.a(gVar2, button));
                Button button2 = new Button(gVar2.c);
                button2.setText("close");
                layoutParams2.leftMargin = gVar2.a(10);
                button2.setLayoutParams(layoutParams2);
                button2.setOnClickListener(k.a(gVar2));
                LinearLayout linearLayout2 = new LinearLayout(gVar2.c);
                linearLayout2.addView(button);
                linearLayout2.addView(button2);
                linearLayout2.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                linearLayout2.setOrientation(0);
                linearLayout2.setBackgroundColor(-7829368);
                linearLayout2.setAlpha(0.5f);
                linearLayout.addView(linearLayout2);
                Spinner spinner = new Spinner(gVar2.c);
                gVar2.j = spinner;
                spinner.setAdapter((SpinnerAdapter) gVar2.e);
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, gVar2.a(30));
                layoutParams3.topMargin = gVar2.a(2);
                gVar2.j.setLayoutParams(layoutParams3);
                gVar2.j.setOnItemSelectedListener(new g.c(gVar2, (byte) 0));
                gVar2.j.setBackgroundColor(-7829368);
                gVar2.j.setAlpha(0.5f);
                linearLayout.addView(gVar2.j);
                gVar2.h = new TextView(gVar2.c);
                LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, gVar2.a(UserProxyUtility.exitRoom));
                layoutParams4.topMargin = gVar2.a(10);
                layoutParams4.leftMargin = gVar2.a(10);
                layoutParams4.rightMargin = gVar2.a(3);
                gVar2.h.setLayoutParams(layoutParams4);
                gVar2.h.setTextColor(-65536);
                linearLayout.addView(gVar2.h);
                gVar2.k = new ScrollView(gVar2.c);
                LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, gVar2.b());
                layoutParams5.leftMargin = gVar2.a(10);
                layoutParams5.rightMargin = gVar2.a(3);
                gVar2.k.setLayoutParams(layoutParams5);
                gVar2.k.setVerticalScrollBarEnabled(true);
                gVar2.i = new TextView(gVar2.c);
                gVar2.i.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                gVar2.i.setTextColor(-65536);
                gVar2.k.addView(gVar2.i);
                gVar2.k.fullScroll(130);
                linearLayout.addView(gVar2.k);
                gVar2.g = linearLayout;
                gVar2.o.a(0);
                this.mIsInit = true;
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeAllDashboardInternal() {
        this.mDashboards.clear();
        this.mDashboardStatus.clear();
        this.mDashboardLogs.clear();
        g gVar = this.mDashboardManagerView;
        gVar.e.clear();
        gVar.l = null;
        TextView textView = gVar.h;
        if (textView != null) {
            textView.setText("");
        }
        TextView textView2 = gVar.i;
        if (textView2 != null) {
            textView2.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeDashboardInternal(String str) {
        if (this.mDashboards.contains(str)) {
            this.mDashboards.remove(str);
            this.mDashboardStatus.remove(str);
            this.mDashboardLogs.remove(str);
            g gVar = this.mDashboardManagerView;
            if (str.equals(gVar.l)) {
                int position = gVar.e.getPosition(gVar.l);
                if (position != gVar.e.getCount() - 1) {
                    int i = position + 1;
                    gVar.l = gVar.e.getItem(i);
                    gVar.o.a(position);
                    Spinner spinner = gVar.j;
                    if (spinner != null) {
                        spinner.setSelection(i);
                    }
                } else if (position > 0) {
                    int i2 = position - 1;
                    gVar.l = gVar.e.getItem(i2);
                    gVar.o.a(i2);
                    Spinner spinner2 = gVar.j;
                    if (spinner2 != null) {
                        spinner2.setSelection(i2);
                    }
                }
            }
            gVar.e.remove(str);
            if (gVar.e.getCount() == 0) {
                gVar.l = null;
            }
            gVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStatusInternal(String str, String str2) {
        if (this.mDashboards.contains(str)) {
            this.mDashboardStatus.put(str, str2);
            if (str.equals(this.mSelectedDashboardId)) {
                this.mDashboardManagerView.b(str2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDashboardInternal(boolean z) {
        if (z && (!checkPermission() || !init())) {
            LiteavLog.i(TAG, "init or check permission is fail");
        } else {
            this.mDashboardManagerView.a(z);
        }
    }

    public int addDashboard(String str) {
        LiteavLog.i(TAG, "addDashboard dashboardId = ".concat(String.valueOf(str)));
        this.mUIHandler.post(b.a(this, str));
        return 0;
    }

    public int appendLog(String str, String str2) {
        this.mUIHandler.post(f.a(this, str, str2));
        return 0;
    }

    public int removeAllDashboard() {
        LiteavLog.i(TAG, "removeAllDashboard ");
        this.mUIHandler.post(d.a(this));
        return 0;
    }

    public int removeDashboard(String str) {
        LiteavLog.i(TAG, "removeDashboard dashboardId = ".concat(String.valueOf(str)));
        this.mUIHandler.post(c.a(this, str));
        return 0;
    }

    public int setStatus(String str, String str2) {
        this.mUIHandler.post(e.a(this, str, str2));
        return 0;
    }

    public int showDashboard(boolean z) {
        LiteavLog.i(TAG, "showDashBoard isShow = ".concat(String.valueOf(z)));
        this.mUIHandler.post(a.a(this, z));
        return 0;
    }
}
