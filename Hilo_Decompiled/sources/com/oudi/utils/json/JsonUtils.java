package com.oudi.utils.json;

import android.util.Pair;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class JsonUtils {
    public static String replaceKey(String str, Pair<String, String> pair) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            jSONObject.put((String) pair.first, new JSONObject((String) pair.second));
            return jSONObject.toString();
        } catch (JSONException e10) {
            e10.printStackTrace();
            return str;
        }
    }
}
