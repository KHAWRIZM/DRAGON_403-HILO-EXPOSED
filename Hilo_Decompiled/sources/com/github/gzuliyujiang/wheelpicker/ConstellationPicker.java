package com.github.gzuliyujiang.wheelpicker;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import q6.g;
import s6.a;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class ConstellationPicker extends OptionPicker {

    /* renamed from: r, reason: collision with root package name */
    public static String f٧٩٥٧r = "[{\"id\":0,\"name\":\"不限\",\"startDate\":\"\",\"endDate\":\"\",\"english\":\"Unlimited\"},\n{\"id\":1,\"name\":\"白羊座\",\"startDate\":\"3-21\",\"endDate\":\"4-19\",\"english\":\"Aries\"},\n{\"id\":2,\"name\":\"金牛座\",\"startDate\":\"4-20\",\"endDate\":\"5-20\",\"english\":\"Taurus\"},\n{\"id\":3,\"name\":\"双子座\",\"startDate\":\"5-21\",\"endDate\":\"6-21\",\"english\":\"Gemini\"},\n{\"id\":4,\"name\":\"巨蟹座\",\"startDate\":\"6-22\",\"endDate\":\"7-22\",\"english\":\"Cancer\"},\n{\"id\":5,\"name\":\"狮子座\",\"startDate\":\"7-23\",\"endDate\":\"8-22\",\"english\":\"Leo\"},\n{\"id\":6,\"name\":\"处女座\",\"startDate\":\"8-23\",\"endDate\":\"9-22\",\"english\":\"Virgo\"},\n{\"id\":7,\"name\":\"天秤座\",\"startDate\":\"9-23\",\"endDate\":\"10-23\",\"english\":\"Libra\"},\n{\"id\":8,\"name\":\"天蝎座\",\"startDate\":\"10-24\",\"endDate\":\"11-22\",\"english\":\"Scorpio\"},\n{\"id\":9,\"name\":\"射手座\",\"startDate\":\"11-23\",\"endDate\":\"12-21\",\"english\":\"Sagittarius\"},\n{\"id\":10,\"name\":\"摩羯座\",\"startDate\":\"12-22\",\"endDate\":\"1-19\",\"english\":\"Capricorn\"},\n{\"id\":11,\"name\":\"水瓶座\",\"startDate\":\"1-20\",\"endDate\":\"2-18\",\"english\":\"Aquarius\"},\n{\"id\":12,\"name\":\"双鱼座\",\"startDate\":\"2-19\",\"endDate\":\"3-20\",\"english\":\"Pisces\"}]";

    /* renamed from: q, reason: collision with root package name */
    private boolean f٧٩٥٨q;

    @Override // com.github.gzuliyujiang.wheelpicker.OptionPicker
    protected List L() {
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(f٧٩٥٧r);
            int length = jSONArray.length();
            for (int i10 = 0; i10 < length; i10++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i10);
                a aVar = new a();
                aVar.e(jSONObject.getString("id"));
                aVar.g(jSONObject.getString("startDate"));
                aVar.c(jSONObject.getString("endDate"));
                aVar.f(jSONObject.getString("name"));
                aVar.d(jSONObject.getString("english"));
                if (this.f٧٩٥٨q || !"0".equals(aVar.b())) {
                    arrayList.add(aVar);
                }
            }
        } catch (JSONException e10) {
            g.a(e10);
        }
        return arrayList;
    }
}
