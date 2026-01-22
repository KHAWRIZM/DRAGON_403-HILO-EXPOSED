package a1;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public boolean f٧٩a;

    /* renamed from: b, reason: collision with root package name */
    public String f٨٠b;

    /* renamed from: c, reason: collision with root package name */
    public String f٨١c;

    /* renamed from: d, reason: collision with root package name */
    public String f٨٢d;

    /* renamed from: e, reason: collision with root package name */
    public List f٨٣e;

    /* renamed from: f, reason: collision with root package name */
    public List f٨٤f;

    public final String a() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("isHit", this.f٧٩a);
            jSONObject.put("keyWord", this.f٨٠b);
            jSONObject.put(ViewHierarchyConstants.TEXT_KEY, this.f٨١c);
            jSONObject.put("wordType", this.f٨٢d);
            List list = this.f٨٣e;
            if (list != null && list.size() > 0) {
                JSONArray jSONArray = new JSONArray();
                Iterator it = this.f٨٣e.iterator();
                while (it.hasNext()) {
                    jSONArray.put((String) it.next());
                }
                jSONObject.put("keyWordList", jSONArray);
            }
            List list2 = this.f٨٤f;
            if (list2 != null && list2.size() > 0) {
                JSONArray jSONArray2 = new JSONArray();
                Iterator it2 = this.f٨٤f.iterator();
                while (it2.hasNext()) {
                    jSONArray2.put((Integer) it2.next());
                }
                jSONObject.put("numberList", jSONArray2);
            }
            return jSONObject.toString();
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }
}
