package tech.sud.runtime.component.file;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
import tech.sud.runtime.core.b;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public class LocalStorage {
    SharedPreferences a;

    public LocalStorage(String str) {
        this.a = null;
        Context b = b.b();
        if (b == null) {
            return;
        }
        this.a = b.getSharedPreferences(str, 0);
    }

    public void clear() {
        SharedPreferences sharedPreferences = this.a;
        if (sharedPreferences == null) {
            return;
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.clear();
        edit.apply();
    }

    public String getItem(String str) {
        SharedPreferences sharedPreferences = this.a;
        if (sharedPreferences == null) {
            return null;
        }
        return sharedPreferences.getString(str, null);
    }

    public String getItemKeyList() {
        SharedPreferences sharedPreferences = this.a;
        if (sharedPreferences == null) {
            return "";
        }
        try {
            Map<String, ?> all = sharedPreferences.getAll();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("limitSize", 10000);
            jSONObject.put("currentSize", all.size() * 10);
            JSONArray jSONArray = new JSONArray();
            Iterator<String> it = all.keySet().iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next());
            }
            jSONObject.put("keys", jSONArray);
            return jSONObject.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public void removeItem(String str) {
        SharedPreferences sharedPreferences = this.a;
        if (sharedPreferences == null) {
            return;
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.remove(str);
        edit.apply();
    }

    public void setItem(String str, String str2) {
        SharedPreferences sharedPreferences = this.a;
        if (sharedPreferences == null) {
            return;
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString(str, str2);
        edit.apply();
    }
}
