package com.taobao.accs.messenger;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import com.taobao.accs.utl.ALog;
import java.util.HashMap;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class a {
    private final Context a;
    private final HashMap<String, d> b = new HashMap<>();
    private boolean c;

    public a(Context context) {
        this.a = context;
    }

    public d a(String str) {
        d dVar = this.b.get(str);
        if (dVar == null || !dVar.a()) {
            return null;
        }
        return dVar;
    }

    public void b(String str, d dVar) {
        if (Build.VERSION.SDK_INT >= 24) {
            this.b.remove(str, dVar);
        } else if (this.b.get(str) == dVar) {
            this.b.remove(str);
        }
    }

    public void a(String str, d dVar) {
        b(str, dVar);
        if (this.c) {
            try {
                this.a.unbindService(dVar);
            } catch (Exception e) {
                ALog.e("ConnectionManager", "disconnect error: " + e.getMessage(), new Object[0]);
            }
        }
    }

    public void a(String str, Intent intent) {
        d dVar = this.b.get(str);
        if (dVar != null) {
            if (dVar.b()) {
                if (!dVar.c()) {
                    return;
                } else {
                    a(str, dVar);
                }
            } else {
                this.b.remove(str);
            }
            dVar = null;
        }
        if (dVar == null) {
            d dVar2 = new d(this.a, str, this);
            this.b.put(str, dVar2);
            this.c = this.a.bindService(a(intent), dVar2, 1);
        }
    }

    private static Intent a(Intent intent) {
        Intent intent2 = (Intent) intent.clone();
        intent2.replaceExtras(new Bundle());
        return intent2;
    }
}
