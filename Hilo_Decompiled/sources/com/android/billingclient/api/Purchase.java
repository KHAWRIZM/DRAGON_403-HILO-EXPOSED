package com.android.billingclient.api;

import android.text.TextUtils;
import com.qiahao.base_common.network.interceptors.HeaderInterceptor;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class Purchase {

    /* renamed from: a, reason: collision with root package name */
    private final String f٦٩٤١a;

    /* renamed from: b, reason: collision with root package name */
    private final String f٦٩٤٢b;

    /* renamed from: c, reason: collision with root package name */
    private final JSONObject f٦٩٤٣c;

    public Purchase(String str, String str2) {
        this.f٦٩٤١a = str;
        this.f٦٩٤٢b = str2;
        this.f٦٩٤٣c = new JSONObject(str);
    }

    private final ArrayList i() {
        ArrayList arrayList = new ArrayList();
        if (this.f٦٩٤٣c.has("productIds")) {
            JSONArray optJSONArray = this.f٦٩٤٣c.optJSONArray("productIds");
            if (optJSONArray != null) {
                for (int i10 = 0; i10 < optJSONArray.length(); i10++) {
                    arrayList.add(optJSONArray.optString(i10));
                }
            }
        } else if (this.f٦٩٤٣c.has("productId")) {
            arrayList.add(this.f٦٩٤٣c.optString("productId"));
        }
        return arrayList;
    }

    public String a() {
        String optString = this.f٦٩٤٣c.optString("orderId");
        if (TextUtils.isEmpty(optString)) {
            return null;
        }
        return optString;
    }

    public String b() {
        return this.f٦٩٤١a;
    }

    public List c() {
        return i();
    }

    public int d() {
        if (this.f٦٩٤٣c.optInt("purchaseState", 1) != 4) {
            return 1;
        }
        return 2;
    }

    public String e() {
        JSONObject jSONObject = this.f٦٩٤٣c;
        return jSONObject.optString(HeaderInterceptor.TOKEN, jSONObject.optString("purchaseToken"));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Purchase)) {
            return false;
        }
        Purchase purchase = (Purchase) obj;
        if (TextUtils.equals(this.f٦٩٤١a, purchase.b()) && TextUtils.equals(this.f٦٩٤٢b, purchase.f())) {
            return true;
        }
        return false;
    }

    public String f() {
        return this.f٦٩٤٢b;
    }

    public ArrayList g() {
        return i();
    }

    public boolean h() {
        return this.f٦٩٤٣c.optBoolean("acknowledged", true);
    }

    public int hashCode() {
        return this.f٦٩٤١a.hashCode();
    }

    public String toString() {
        return "Purchase. Json: ".concat(String.valueOf(this.f٦٩٤١a));
    }
}
