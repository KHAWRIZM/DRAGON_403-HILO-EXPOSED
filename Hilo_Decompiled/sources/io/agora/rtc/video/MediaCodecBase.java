package io.agora.rtc.video;

import android.media.MediaFormat;
import android.text.TextUtils;
import io.agora.rtc.internal.Logging;
import java.util.Iterator;
import org.json.JSONObject;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class MediaCodecBase {
    private static final String TAG = "MediaCodecBase";

    /* JADX INFO: Access modifiers changed from: protected */
    public void applyCustomConfig(MediaFormat mediaFormat, String str) {
        if (mediaFormat != null && !TextUtils.isEmpty(str)) {
            Logging.i(TAG, "applying custom config: " + str);
            try {
                JSONObject jSONObject = new JSONObject(str);
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    Object obj = jSONObject.get(next);
                    if (obj instanceof String) {
                        mediaFormat.setString(next, (String) obj);
                    } else if (obj instanceof Integer) {
                        mediaFormat.setInteger(next, ((Integer) obj).intValue());
                    } else if (obj instanceof JSONObject) {
                        JSONObject jSONObject2 = (JSONObject) obj;
                        String next2 = jSONObject2.keys().next();
                        if ("setInteger".equals(next)) {
                            mediaFormat.setInteger(next2, jSONObject2.getInt(next2));
                        } else if ("setLong".equals(next)) {
                            mediaFormat.setLong(next2, jSONObject2.getLong(next2));
                        } else if ("setFloat".equals(next)) {
                            mediaFormat.setFloat(next2, (float) jSONObject2.getDouble(next2));
                        } else if ("setString".equals(next)) {
                            mediaFormat.setString(next2, jSONObject2.getString(next2));
                        } else if ("setFeatureEnabled".equals(next)) {
                            mediaFormat.setFeatureEnabled(next2, jSONObject2.getBoolean(next2));
                        }
                    } else {
                        Logging.e(TAG, "unsupported config value type " + obj.getClass());
                    }
                }
            } catch (Exception e10) {
                Logging.e(TAG, "abort applying custom config: " + e10.getMessage());
                e10.printStackTrace();
            }
        }
    }
}
