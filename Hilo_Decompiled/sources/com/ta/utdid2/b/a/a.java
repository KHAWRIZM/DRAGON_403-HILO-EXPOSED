package com.ta.utdid2.b.a;

import android.content.Context;
import android.content.SharedPreferences;
import com.ta.a.c.f;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class a {
    private SharedPreferences a;

    public a(Context context, String str, String str2) {
        this.a = null;
        if (context == null) {
            return;
        }
        this.a = context.getSharedPreferences(str2, 0);
    }

    public int a() {
        SharedPreferences sharedPreferences = this.a;
        int i = sharedPreferences != null ? sharedPreferences.getInt("type", 0) : 0;
        f.m١٢٧a("PersistentConfiguration", "getTypeFromSp type", Integer.valueOf(i));
        return i;
    }

    public String k() {
        SharedPreferences sharedPreferences = this.a;
        String str = "";
        if (sharedPreferences != null) {
            str = sharedPreferences.getString("UTDID2", "");
        }
        f.m١٢٧a("PersistentConfiguration", "getUtdidFromSp utdid", str);
        return str;
    }

    public void a(String str, int i) {
        if (this.a != null) {
            f.m١٢٧a("PersistentConfiguration", "writeUtdidToSp utdid", str);
            SharedPreferences.Editor edit = this.a.edit();
            edit.putString("UTDID2", str);
            edit.putInt("type", i);
            if (this.a.getLong("t2", 0L) == 0) {
                edit.putLong("t2", System.currentTimeMillis());
            }
            try {
                edit.commit();
            } catch (Exception unused) {
            }
        }
    }
}
