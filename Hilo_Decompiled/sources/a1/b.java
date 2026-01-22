package a1;

import android.text.TextUtils;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public boolean f٨٥a;

    /* renamed from: b, reason: collision with root package name */
    public ArrayList f٨٦b;

    /* renamed from: c, reason: collision with root package name */
    public String f٨٧c;

    /* renamed from: d, reason: collision with root package name */
    public String f٨٨d = ViewHierarchyConstants.TEXT_KEY;

    /* renamed from: e, reason: collision with root package name */
    public boolean f٨٩e = true;

    /* renamed from: f, reason: collision with root package name */
    public boolean f٩٠f = true;

    public static b a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        b bVar = new b();
        try {
            JSONObject jSONObject = new JSONObject(str);
            bVar.f٨٥a = jSONObject.optBoolean("isOpen");
            JSONArray optJSONArray = jSONObject.optJSONArray("wordList");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                ArrayList arrayList = new ArrayList();
                for (int i10 = 0; i10 < optJSONArray.length(); i10++) {
                    String string = optJSONArray.getString(i10);
                    if (!string.isEmpty()) {
                        arrayList.add(string);
                    }
                }
                bVar.f٨٦b = arrayList;
            }
            bVar.f٨٧c = jSONObject.optString("wordLanguage");
            if (!jSONObject.isNull("wordType")) {
                bVar.f٨٨d = jSONObject.optString("wordType");
            }
            bVar.f٨٩e = jSONObject.optBoolean("enableIsHit");
            bVar.f٩٠f = jSONObject.optBoolean("enableIsReturnText");
            return bVar;
        } catch (Exception e10) {
            e10.printStackTrace();
            return bVar;
        }
    }
}
