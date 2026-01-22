package com.github.gzuliyujiang.wheelpicker;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import q6.g;
import s6.f;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class SexPicker extends OptionPicker {

    /* renamed from: r, reason: collision with root package name */
    public static String f٧٩٧٣r = "[{\"id\":0,\"name\":\"保密\",\"english\":\"Secrecy\"},\n{\"id\":1,\"name\":\"男\",\"english\":\"Male\"},\n{\"id\":2,\"name\":\"女\",\"english\":\"Female\"}]";

    /* renamed from: q, reason: collision with root package name */
    private boolean f٧٩٧٤q;

    @Override // com.github.gzuliyujiang.wheelpicker.OptionPicker
    protected List L() {
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(f٧٩٧٣r);
            int length = jSONArray.length();
            for (int i10 = 0; i10 < length; i10++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i10);
                f fVar = new f();
                fVar.d(jSONObject.getString("id"));
                fVar.e(jSONObject.getString("name"));
                fVar.c(jSONObject.getString("english"));
                if (this.f٧٩٧٤q || !"0".equals(fVar.b())) {
                    arrayList.add(fVar);
                }
            }
        } catch (JSONException e10) {
            g.a(e10);
        }
        return arrayList;
    }
}
