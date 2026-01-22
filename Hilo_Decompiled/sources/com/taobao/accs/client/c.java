package com.taobao.accs.client;

import android.content.Context;
import com.taobao.accs.utl.ALog;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class c {
    private Context a;
    private ConcurrentMap<String, Integer> b = new ConcurrentHashMap();
    private String c = "ClientManager_";

    public c(Context context, String str, String str2, String str3) {
        if (context != null) {
            this.c += str;
            this.a = context.getApplicationContext();
            return;
        }
        throw new RuntimeException("Context is null!!");
    }

    public void a(String str) {
        Integer num = this.b.get(str);
        if (num == null || num.intValue() != 2) {
            this.b.put(str, 2);
        }
    }

    public void b(String str) {
        Integer num = this.b.get(str);
        if (num == null || num.intValue() != 4) {
            this.b.put(str, 4);
        }
    }

    public void c(String str) {
        Integer num = this.b.get(str);
        if (num == null || num.intValue() != 1) {
            this.b.put(str, 1);
        }
    }

    public boolean d(String str) {
        Integer num = this.b.get(str);
        ALog.i(this.c, "isAppBinded", "appStatus", num, "mBindStatus", this.b);
        if (num == null || num.intValue() != 2) {
            return false;
        }
        return true;
    }

    public boolean e(String str) {
        Integer num = this.b.get(str);
        if (num != null && num.intValue() == 4) {
            return true;
        }
        return false;
    }

    public boolean f(String str) {
        Integer num = this.b.get(str);
        if (num != null && num.intValue() == 1) {
            return true;
        }
        return false;
    }

    public void a() {
        try {
            this.b.clear();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
