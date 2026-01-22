package com.taobao.accs.utl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class JsonUtility {

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public static class JsonObjectBuilder {
        JSONObject jObject = new JSONObject();

        public JSONObject build() {
            return this.jObject;
        }

        public JsonObjectBuilder put(String str, String str2) {
            if (str2 != null && str != null) {
                try {
                    this.jObject.put(str, str2);
                } catch (JSONException unused) {
                }
            }
            return this;
        }

        public JsonObjectBuilder put(String str, Integer num) {
            if (num == null) {
                return this;
            }
            try {
                this.jObject.put(str, num);
            } catch (JSONException unused) {
            }
            return this;
        }

        public JsonObjectBuilder put(String str, Boolean bool) {
            if (bool == null) {
                return this;
            }
            try {
                this.jObject.put(str, bool);
            } catch (JSONException unused) {
            }
            return this;
        }

        public JsonObjectBuilder put(String str, Long l) {
            if (l == null) {
                return this;
            }
            try {
                this.jObject.put(str, l);
            } catch (JSONException unused) {
            }
            return this;
        }

        public JsonObjectBuilder put(String str, JSONArray jSONArray) {
            if (jSONArray == null) {
                return this;
            }
            try {
                this.jObject.put(str, jSONArray);
            } catch (JSONException unused) {
            }
            return this;
        }
    }

    public static Map<String, String> getMap(JSONObject jSONObject, String str) {
        HashMap hashMap = null;
        if (jSONObject == null) {
            return null;
        }
        if (jSONObject.has(str)) {
            JSONObject optJSONObject = jSONObject.optJSONObject(str);
            Iterator<String> keys = optJSONObject.keys();
            hashMap = new HashMap();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, optJSONObject.optString(next));
            }
        }
        return hashMap;
    }

    public static String getString(JSONObject jSONObject, String str, String str2) throws JSONException {
        String optString;
        if (jSONObject == null) {
            return str2;
        }
        if (jSONObject.has(str) && (optString = jSONObject.optString(str, null)) != null) {
            return optString;
        }
        return str2;
    }

    public static Map<String, String> toMap(JSONObject jSONObject) throws JSONException {
        String obj;
        HashMap hashMap = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (jSONObject.get(next) == null) {
                obj = null;
            } else {
                obj = jSONObject.get(next).toString();
            }
            hashMap.put(next, obj);
        }
        return hashMap;
    }
}
