package lf;

import android.content.Context;
import android.content.SharedPreferences;
import com.taobao.accs.common.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import mf.c;
import org.json.JSONException;
import org.json.JSONObject;
import re.d;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public final class b {
    public final SharedPreferences a;

    public b(Context context) {
        this.a = context.getSharedPreferences("sudrt_sp_game_package", 0);
    }

    public static /* synthetic */ int a(d dVar, d dVar2) {
        long j = dVar.f - dVar2.f;
        if (0 == j) {
            return 0;
        }
        if (j > 0) {
            return 1;
        }
        return -1;
    }

    public final ArrayList b() {
        ArrayList arrayList = new ArrayList(0);
        for (String str : this.a.getString("sudrt_package_game_id_list", "").split(";")) {
            d a = nf.a.a(this.a.getString(str, ""));
            if (a != null) {
                arrayList.add(a);
            }
        }
        Collections.sort(arrayList, new Comparator() { // from class: lf.a
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return b.a((d) obj, (d) obj2);
            }
        });
        return arrayList;
    }

    public final void c(long j) {
        SharedPreferences.Editor edit = this.a.edit();
        edit.remove(String.valueOf(j));
        String str = "";
        String[] split = this.a.getString("sudrt_package_game_id_list", "").split(";");
        String valueOf = String.valueOf(j);
        for (String str2 : split) {
            if (!valueOf.equals(str2)) {
                if (str.isEmpty()) {
                    str = str2;
                } else {
                    str = str + ";" + str2;
                }
            }
        }
        edit.putString("sudrt_package_game_id_list", str);
        edit.apply();
    }

    public final void d(me.a aVar) {
        SharedPreferences.Editor edit = this.a.edit();
        edit.remove("sudrt_game_ut_core_info");
        edit.apply();
    }

    public final void e(c cVar) {
        String str;
        String str2 = "ut_embbed_" + String.valueOf(cVar.a);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("mgId", cVar.a);
            jSONObject.put("fGamePackageMd5", cVar.b);
            str = jSONObject.toString();
        } catch (JSONException unused) {
            str = null;
        }
        SharedPreferences.Editor edit = this.a.edit();
        if (str != null && !str.isEmpty()) {
            edit.putString(str2, str);
        } else {
            edit.remove(str2);
        }
        edit.apply();
    }

    public final void f(d dVar) {
        String str;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("mgId", dVar.a);
            jSONObject.put(Constants.SP_KEY_VERSION, dVar.b);
            jSONObject.put("url", dVar.c);
            jSONObject.put("fNameMd5", dVar.d);
            jSONObject.put("fTotalSize", dVar.e);
            jSONObject.put("lastUseTimestamp", dVar.f);
            str = jSONObject.toString();
        } catch (JSONException unused) {
            str = null;
        }
        SharedPreferences.Editor edit = this.a.edit();
        if (str != null && !str.isEmpty()) {
            edit.putString(String.valueOf(dVar.a), str);
        } else {
            edit.remove(String.valueOf(dVar.a));
        }
        edit.apply();
        long j = dVar.a;
        SharedPreferences.Editor edit2 = this.a.edit();
        String[] split = this.a.getString("sudrt_package_game_id_list", "").split(";");
        String valueOf = String.valueOf(j);
        int length = split.length;
        int i = 0;
        while (true) {
            if (i < length) {
                if (valueOf.equals(split[i])) {
                    break;
                } else {
                    i++;
                }
            } else {
                for (String str2 : split) {
                    valueOf = valueOf + ";" + str2;
                }
                edit2.putString("sudrt_package_game_id_list", valueOf);
            }
        }
        edit2.apply();
    }
}
