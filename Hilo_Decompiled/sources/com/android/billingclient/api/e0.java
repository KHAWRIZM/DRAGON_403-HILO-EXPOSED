package com.android.billingclient.api;

import android.text.TextUtils;
import com.google.android.gms.internal.play_billing.zzai;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class e0 {

    /* renamed from: a, reason: collision with root package name */
    private final String f٦٩٧١a;

    /* renamed from: b, reason: collision with root package name */
    private final JSONObject f٦٩٧٢b;

    /* renamed from: c, reason: collision with root package name */
    private final String f٦٩٧٣c;

    /* renamed from: d, reason: collision with root package name */
    private final String f٦٩٧٤d;

    /* renamed from: e, reason: collision with root package name */
    private final String f٦٩٧٥e;

    /* renamed from: f, reason: collision with root package name */
    private final String f٦٩٧٦f;

    /* renamed from: g, reason: collision with root package name */
    private final String f٦٩٧٧g;

    /* renamed from: h, reason: collision with root package name */
    private final String f٦٩٧٨h;

    /* renamed from: i, reason: collision with root package name */
    private final String f٦٩٧٩i;

    /* renamed from: j, reason: collision with root package name */
    private final String f٦٩٨٠j;

    /* renamed from: k, reason: collision with root package name */
    private final String f٦٩٨١k;

    /* renamed from: l, reason: collision with root package name */
    private final List f٦٩٨٢l;

    /* renamed from: m, reason: collision with root package name */
    private final List f٦٩٨٣m;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final int f٦٩٨٤a;

        /* renamed from: b, reason: collision with root package name */
        private final int f٦٩٨٥b;

        a(JSONObject jSONObject) {
            this.f٦٩٨٤a = jSONObject.getInt("commitmentPaymentsCount");
            this.f٦٩٨٥b = jSONObject.optInt("subsequentCommitmentPaymentsCount");
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final String f٦٩٨٦a;

        /* renamed from: b, reason: collision with root package name */
        private final long f٦٩٨٧b;

        /* renamed from: c, reason: collision with root package name */
        private final String f٦٩٨٨c;

        /* renamed from: d, reason: collision with root package name */
        private final String f٦٩٨٩d;

        /* renamed from: e, reason: collision with root package name */
        private final String f٦٩٩٠e;

        /* renamed from: f, reason: collision with root package name */
        private final String f٦٩٩١f;

        /* renamed from: g, reason: collision with root package name */
        private final zzai f٦٩٩٢g;

        /* renamed from: h, reason: collision with root package name */
        private final Long f٦٩٩٣h;

        /* renamed from: i, reason: collision with root package name */
        private final o2 f٦٩٩٤i;

        /* renamed from: j, reason: collision with root package name */
        private final s2 f٦٩٩٥j;

        /* renamed from: k, reason: collision with root package name */
        private final p2 f٦٩٩٦k;

        /* renamed from: l, reason: collision with root package name */
        private final q2 f٦٩٩٧l;

        /* renamed from: m, reason: collision with root package name */
        private final r2 f٦٩٩٨m;

        b(JSONObject jSONObject) {
            Long l10;
            o2 o2Var;
            s2 s2Var;
            p2 p2Var;
            q2 q2Var;
            this.f٦٩٨٦a = jSONObject.optString("formattedPrice");
            this.f٦٩٨٧b = jSONObject.optLong("priceAmountMicros");
            this.f٦٩٨٨c = jSONObject.optString("priceCurrencyCode");
            String optString = jSONObject.optString("offerIdToken");
            this.f٦٩٨٩d = true == optString.isEmpty() ? null : optString;
            String optString2 = jSONObject.optString("offerId");
            this.f٦٩٩٠e = true == optString2.isEmpty() ? null : optString2;
            String optString3 = jSONObject.optString("purchaseOptionId");
            this.f٦٩٩١f = true == optString3.isEmpty() ? null : optString3;
            jSONObject.optInt("offerType");
            JSONArray optJSONArray = jSONObject.optJSONArray("offerTags");
            ArrayList arrayList = new ArrayList();
            if (optJSONArray != null) {
                for (int i10 = 0; i10 < optJSONArray.length(); i10++) {
                    arrayList.add(optJSONArray.getString(i10));
                }
            }
            this.f٦٩٩٢g = zzai.zzj(arrayList);
            if (jSONObject.has("fullPriceMicros")) {
                l10 = Long.valueOf(jSONObject.optLong("fullPriceMicros"));
            } else {
                l10 = null;
            }
            this.f٦٩٩٣h = l10;
            JSONObject optJSONObject = jSONObject.optJSONObject("discountDisplayInfo");
            if (optJSONObject == null) {
                o2Var = null;
            } else {
                o2Var = new o2(optJSONObject);
            }
            this.f٦٩٩٤i = o2Var;
            JSONObject optJSONObject2 = jSONObject.optJSONObject("validTimeWindow");
            if (optJSONObject2 == null) {
                s2Var = null;
            } else {
                s2Var = new s2(optJSONObject2);
            }
            this.f٦٩٩٥j = s2Var;
            JSONObject optJSONObject3 = jSONObject.optJSONObject("limitedQuantityInfo");
            if (optJSONObject3 == null) {
                p2Var = null;
            } else {
                p2Var = new p2(optJSONObject3);
            }
            this.f٦٩٩٦k = p2Var;
            JSONObject optJSONObject4 = jSONObject.optJSONObject("preorderDetails");
            if (optJSONObject4 == null) {
                q2Var = null;
            } else {
                q2Var = new q2(optJSONObject4);
            }
            this.f٦٩٩٧l = q2Var;
            JSONObject optJSONObject5 = jSONObject.optJSONObject("rentalDetails");
            this.f٦٩٩٨m = optJSONObject5 != null ? new r2(optJSONObject5) : null;
        }

        public String a() {
            return this.f٦٩٨٦a;
        }

        public final String b() {
            return this.f٦٩٨٩d;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        private final String f٦٩٩٩a;

        /* renamed from: b, reason: collision with root package name */
        private final long f٧٠٠٠b;

        /* renamed from: c, reason: collision with root package name */
        private final String f٧٠٠١c;

        /* renamed from: d, reason: collision with root package name */
        private final String f٧٠٠٢d;

        /* renamed from: e, reason: collision with root package name */
        private final int f٧٠٠٣e;

        /* renamed from: f, reason: collision with root package name */
        private final int f٧٠٠٤f;

        /* JADX INFO: Access modifiers changed from: package-private */
        public c(JSONObject jSONObject) {
            this.f٧٠٠٢d = jSONObject.optString("billingPeriod");
            this.f٧٠٠١c = jSONObject.optString("priceCurrencyCode");
            this.f٦٩٩٩a = jSONObject.optString("formattedPrice");
            this.f٧٠٠٠b = jSONObject.optLong("priceAmountMicros");
            this.f٧٠٠٤f = jSONObject.optInt("recurrenceMode");
            this.f٧٠٠٣e = jSONObject.optInt("billingCycleCount");
        }

        public String a() {
            return this.f٦٩٩٩a;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        private final List f٧٠٠٥a;

        d(JSONArray jSONArray) {
            ArrayList arrayList = new ArrayList();
            if (jSONArray != null) {
                for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i10);
                    if (optJSONObject != null) {
                        arrayList.add(new c(optJSONObject));
                    }
                }
            }
            this.f٧٠٠٥a = arrayList;
        }

        public List a() {
            return this.f٧٠٠٥a;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static final class e {

        /* renamed from: a, reason: collision with root package name */
        private final String f٧٠٠٦a;

        /* renamed from: b, reason: collision with root package name */
        private final String f٧٠٠٧b;

        /* renamed from: c, reason: collision with root package name */
        private final String f٧٠٠٨c;

        /* renamed from: d, reason: collision with root package name */
        private final d f٧٠٠٩d;

        /* renamed from: e, reason: collision with root package name */
        private final List f٧٠١٠e;

        /* renamed from: f, reason: collision with root package name */
        private final a f٧٠١١f;

        /* renamed from: g, reason: collision with root package name */
        private final t2 f٧٠١٢g;

        e(JSONObject jSONObject) {
            a aVar;
            this.f٧٠٠٦a = jSONObject.optString("basePlanId");
            String optString = jSONObject.optString("offerId");
            this.f٧٠٠٧b = true == optString.isEmpty() ? null : optString;
            this.f٧٠٠٨c = jSONObject.getString("offerIdToken");
            this.f٧٠٠٩d = new d(jSONObject.getJSONArray("pricingPhases"));
            JSONObject optJSONObject = jSONObject.optJSONObject("installmentPlanDetails");
            if (optJSONObject == null) {
                aVar = null;
            } else {
                aVar = new a(optJSONObject);
            }
            this.f٧٠١١f = aVar;
            JSONObject optJSONObject2 = jSONObject.optJSONObject("transitionPlanDetails");
            this.f٧٠١٢g = optJSONObject2 != null ? new t2(optJSONObject2) : null;
            ArrayList arrayList = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("offerTags");
            if (optJSONArray != null) {
                for (int i10 = 0; i10 < optJSONArray.length(); i10++) {
                    arrayList.add(optJSONArray.getString(i10));
                }
            }
            this.f٧٠١٠e = arrayList;
        }

        public String a() {
            return this.f٧٠٠٨c;
        }

        public d b() {
            return this.f٧٠٠٩d;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e0(String str) {
        ArrayList arrayList;
        this.f٦٩٧١a = str;
        JSONObject jSONObject = new JSONObject(str);
        this.f٦٩٧٢b = jSONObject;
        String optString = jSONObject.optString("productId");
        this.f٦٩٧٣c = optString;
        String optString2 = jSONObject.optString("type");
        this.f٦٩٧٤d = optString2;
        if (!TextUtils.isEmpty(optString)) {
            if (!TextUtils.isEmpty(optString2)) {
                this.f٦٩٧٥e = jSONObject.optString("title");
                this.f٦٩٧٦f = jSONObject.optString("name");
                this.f٦٩٧٧g = jSONObject.optString("description");
                this.f٦٩٧٩i = jSONObject.optString("packageDisplayName");
                this.f٦٩٨٠j = jSONObject.optString("iconUrl");
                this.f٦٩٧٨h = jSONObject.optString("skuDetailsToken");
                this.f٦٩٨١k = jSONObject.optString("serializedDocid");
                JSONArray optJSONArray = jSONObject.optJSONArray("subscriptionOfferDetails");
                if (optJSONArray != null) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i10 = 0; i10 < optJSONArray.length(); i10++) {
                        arrayList2.add(new e(optJSONArray.getJSONObject(i10)));
                    }
                    this.f٦٩٨٢l = arrayList2;
                } else {
                    if (!optString2.equals("subs") && !optString2.equals("play_pass_subs")) {
                        arrayList = null;
                    } else {
                        arrayList = new ArrayList();
                    }
                    this.f٦٩٨٢l = arrayList;
                }
                JSONObject optJSONObject = this.f٦٩٧٢b.optJSONObject("oneTimePurchaseOfferDetails");
                JSONArray optJSONArray2 = this.f٦٩٧٢b.optJSONArray("oneTimePurchaseOfferDetailsList");
                ArrayList arrayList3 = new ArrayList();
                if (optJSONArray2 != null) {
                    for (int i11 = 0; i11 < optJSONArray2.length(); i11++) {
                        arrayList3.add(new b(optJSONArray2.getJSONObject(i11)));
                    }
                    this.f٦٩٨٣m = arrayList3;
                    return;
                }
                if (optJSONObject != null) {
                    arrayList3.add(new b(optJSONObject));
                    this.f٦٩٨٣m = arrayList3;
                    return;
                } else {
                    this.f٦٩٨٣m = null;
                    return;
                }
            }
            throw new IllegalArgumentException("Product type cannot be empty.");
        }
        throw new IllegalArgumentException("Product id cannot be empty.");
    }

    public b a() {
        List list = this.f٦٩٨٣m;
        if (list != null && !list.isEmpty()) {
            return (b) this.f٦٩٨٣m.get(0);
        }
        return null;
    }

    public String b() {
        return this.f٦٩٧٣c;
    }

    public String c() {
        return this.f٦٩٧٤d;
    }

    public List d() {
        return this.f٦٩٨٢l;
    }

    public final String e() {
        return this.f٦٩٧٢b.optString(RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e0)) {
            return false;
        }
        return TextUtils.equals(this.f٦٩٧١a, ((e0) obj).f٦٩٧١a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String f() {
        return this.f٦٩٧٨h;
    }

    public String g() {
        return this.f٦٩٨١k;
    }

    public int hashCode() {
        return this.f٦٩٧١a.hashCode();
    }

    public String toString() {
        List list = this.f٦٩٨٢l;
        return "ProductDetails{jsonString='" + this.f٦٩٧١a + "', parsedJson=" + this.f٦٩٧٢b.toString() + ", productId='" + this.f٦٩٧٣c + "', productType='" + this.f٦٩٧٤d + "', title='" + this.f٦٩٧٥e + "', productDetailsToken='" + this.f٦٩٧٨h + "', subscriptionOfferDetails=" + String.valueOf(list) + "}";
    }
}
