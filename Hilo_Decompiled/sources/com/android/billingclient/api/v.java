package com.android.billingclient.api;

import android.text.TextUtils;
import com.android.billingclient.api.e0;
import com.google.android.gms.internal.play_billing.zzaa;
import com.google.android.gms.internal.play_billing.zzai;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class v {

    /* renamed from: a, reason: collision with root package name */
    private boolean f٧١٦٦a;

    /* renamed from: b, reason: collision with root package name */
    private String f٧١٦٧b;

    /* renamed from: c, reason: collision with root package name */
    private String f٧١٦٨c;

    /* renamed from: d, reason: collision with root package name */
    private c f٧١٦٩d;

    /* renamed from: e, reason: collision with root package name */
    private zzai f٧١٧٠e;

    /* renamed from: f, reason: collision with root package name */
    private ArrayList f٧١٧١f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f٧١٧٢g;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private String f٧١٧٣a;

        /* renamed from: b, reason: collision with root package name */
        private String f٧١٧٤b;

        /* renamed from: c, reason: collision with root package name */
        private List f٧١٧٥c;

        /* renamed from: d, reason: collision with root package name */
        private ArrayList f٧١٧٦d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f٧١٧٧e;

        /* renamed from: f, reason: collision with root package name */
        private c.a f٧١٧٨f;

        /* synthetic */ a(v1 v1Var) {
            c.a a10 = c.a();
            c.a.b(a10);
            this.f٧١٧٨f = a10;
        }

        public v a() {
            boolean z10;
            boolean z11;
            ArrayList arrayList;
            zzai zzk;
            ArrayList arrayList2 = this.f٧١٧٦d;
            boolean z12 = true;
            if (arrayList2 != null && !arrayList2.isEmpty()) {
                z10 = true;
            } else {
                z10 = false;
            }
            List list = this.f٧١٧٥c;
            if (list != null && !list.isEmpty()) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (!z10 && !z11) {
                throw new IllegalArgumentException("Details of the products must be provided.");
            }
            if (z10 && z11) {
                throw new IllegalArgumentException("Set SkuDetails or ProductDetailsParams, not both.");
            }
            b2 b2Var = null;
            if (z10) {
                if (!this.f٧١٧٦d.contains(null)) {
                    if (this.f٧١٧٦d.size() > 1) {
                        SkuDetails skuDetails = (SkuDetails) this.f٧١٧٦d.get(0);
                        String b10 = skuDetails.b();
                        ArrayList arrayList3 = this.f٧١٧٦d;
                        int size = arrayList3.size();
                        for (int i10 = 0; i10 < size; i10++) {
                            SkuDetails skuDetails2 = (SkuDetails) arrayList3.get(i10);
                            if (!b10.equals("play_pass_subs") && !skuDetails2.b().equals("play_pass_subs") && !b10.equals(skuDetails2.b())) {
                                throw new IllegalArgumentException("SKUs should have the same type.");
                            }
                        }
                        String f10 = skuDetails.f();
                        ArrayList arrayList4 = this.f٧١٧٦d;
                        int size2 = arrayList4.size();
                        for (int i11 = 0; i11 < size2; i11++) {
                            SkuDetails skuDetails3 = (SkuDetails) arrayList4.get(i11);
                            if (!b10.equals("play_pass_subs") && !skuDetails3.b().equals("play_pass_subs") && !f10.equals(skuDetails3.f())) {
                                throw new IllegalArgumentException("All SKUs must have the same package name.");
                            }
                        }
                    }
                } else {
                    throw new IllegalArgumentException("SKU cannot be null.");
                }
            } else {
                b bVar = (b) this.f٧١٧٥c.get(0);
                for (int i12 = 0; i12 < this.f٧١٧٥c.size(); i12++) {
                    b bVar2 = (b) this.f٧١٧٥c.get(i12);
                    if (bVar2 != null) {
                        if (i12 != 0 && !bVar2.b().c().equals(bVar.b().c()) && !bVar2.b().c().equals("play_pass_subs")) {
                            throw new IllegalArgumentException("All products should have same ProductType.");
                        }
                    } else {
                        throw new IllegalArgumentException("ProductDetailsParams cannot be null.");
                    }
                }
                String e10 = bVar.b().e();
                for (b bVar3 : this.f٧١٧٥c) {
                    if (!bVar.b().c().equals("play_pass_subs") && !bVar3.b().c().equals("play_pass_subs") && !e10.equals(bVar3.b().e())) {
                        throw new IllegalArgumentException("All products must have the same package name.");
                    }
                }
            }
            v vVar = new v(b2Var);
            if ((!z10 || ((SkuDetails) this.f٧١٧٦d.get(0)).f().isEmpty()) && (!z11 || ((b) this.f٧١٧٥c.get(0)).b().e().isEmpty())) {
                z12 = false;
            }
            vVar.f٧١٦٦a = z12;
            vVar.f٧١٦٧b = this.f٧١٧٣a;
            vVar.f٧١٦٨c = this.f٧١٧٤b;
            vVar.f٧١٦٩d = this.f٧١٧٨f.a();
            ArrayList arrayList5 = this.f٧١٧٦d;
            if (arrayList5 != null) {
                arrayList = new ArrayList(arrayList5);
            } else {
                arrayList = new ArrayList();
            }
            vVar.f٧١٧١f = arrayList;
            vVar.f٧١٧٢g = this.f٧١٧٧e;
            List list2 = this.f٧١٧٥c;
            if (list2 != null) {
                zzk = zzai.zzj(list2);
            } else {
                zzk = zzai.zzk();
            }
            vVar.f٧١٧٠e = zzk;
            return vVar;
        }

        public a b(String str) {
            this.f٧١٧٣a = str;
            return this;
        }

        public a c(List list) {
            this.f٧١٧٥c = new ArrayList(list);
            return this;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final e0 f٧١٧٩a;

        /* renamed from: b, reason: collision with root package name */
        private final String f٧١٨٠b;

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
        public static class a {

            /* renamed from: a, reason: collision with root package name */
            private e0 f٧١٨١a;

            /* renamed from: b, reason: collision with root package name */
            private String f٧١٨٢b;

            /* synthetic */ a(w1 w1Var) {
            }

            public b a() {
                zzaa.zzc(this.f٧١٨١a, "ProductDetails is required for constructing ProductDetailsParams.");
                if (this.f٧١٨١a.d() != null) {
                    zzaa.zzc(this.f٧١٨٢b, "offerToken is required for constructing ProductDetailsParams for subscriptions.");
                }
                return new b(this, null);
            }

            public a b(String str) {
                if (!TextUtils.isEmpty(str)) {
                    this.f٧١٨٢b = str;
                    return this;
                }
                throw new IllegalArgumentException("offerToken can not be empty");
            }

            public a c(e0 e0Var) {
                this.f٧١٨١a = e0Var;
                if (e0Var.a() != null) {
                    e0Var.a().getClass();
                    e0.b a10 = e0Var.a();
                    if (a10.b() != null) {
                        this.f٧١٨٢b = a10.b();
                    }
                }
                return this;
            }
        }

        /* synthetic */ b(a aVar, x1 x1Var) {
            this.f٧١٧٩a = aVar.f٧١٨١a;
            this.f٧١٨٠b = aVar.f٧١٨٢b;
        }

        public static a a() {
            return new a(null);
        }

        public final e0 b() {
            return this.f٧١٧٩a;
        }

        public final String c() {
            return this.f٧١٨٠b;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        private String f٧١٨٣a;

        /* renamed from: b, reason: collision with root package name */
        private String f٧١٨٤b;

        /* renamed from: c, reason: collision with root package name */
        private int f٧١٨٥c = 0;

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
        public static class a {

            /* renamed from: a, reason: collision with root package name */
            private String f٧١٨٦a;

            /* renamed from: b, reason: collision with root package name */
            private String f٧١٨٧b;

            /* renamed from: c, reason: collision with root package name */
            private boolean f٧١٨٨c;

            /* renamed from: d, reason: collision with root package name */
            private int f٧١٨٩d = 0;

            /* synthetic */ a(y1 y1Var) {
            }

            static /* synthetic */ a b(a aVar) {
                aVar.f٧١٨٨c = true;
                return aVar;
            }

            public c a() {
                boolean z10 = true;
                z1 z1Var = null;
                if (TextUtils.isEmpty(this.f٧١٨٦a) && TextUtils.isEmpty(null)) {
                    z10 = false;
                }
                boolean isEmpty = TextUtils.isEmpty(this.f٧١٨٧b);
                if (z10 && !isEmpty) {
                    throw new IllegalArgumentException("Please provide Old SKU purchase information(token/id) or original external transaction id, not both.");
                }
                if (!this.f٧١٨٨c && !z10 && isEmpty) {
                    throw new IllegalArgumentException("Old SKU purchase information(token/id) or original external transaction id must be provided.");
                }
                c cVar = new c(z1Var);
                cVar.f٧١٨٣a = this.f٧١٨٦a;
                cVar.f٧١٨٥c = this.f٧١٨٩d;
                cVar.f٧١٨٤b = this.f٧١٨٧b;
                return cVar;
            }
        }

        /* synthetic */ c(z1 z1Var) {
        }

        public static a a() {
            return new a(null);
        }

        final int b() {
            return this.f٧١٨٥c;
        }

        final String c() {
            return this.f٧١٨٣a;
        }

        final String d() {
            return this.f٧١٨٤b;
        }
    }

    /* synthetic */ v(b2 b2Var) {
    }

    public static a a() {
        return new a(null);
    }

    public final int b() {
        return this.f٧١٦٩d.b();
    }

    public final String c() {
        return this.f٧١٦٧b;
    }

    public final String d() {
        return this.f٧١٦٨c;
    }

    public final String e() {
        return this.f٧١٦٩d.c();
    }

    public final String f() {
        return this.f٧١٦٩d.d();
    }

    public final ArrayList g() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f٧١٧١f);
        return arrayList;
    }

    public final List h() {
        return this.f٧١٧٠e;
    }

    public final boolean p() {
        return this.f٧١٧٢g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean q() {
        if (this.f٧١٦٧b == null && this.f٧١٦٨c == null && this.f٧١٦٩d.d() == null && this.f٧١٦٩d.b() == 0 && !this.f٧١٦٦a && !this.f٧١٧٢g) {
            return false;
        }
        return true;
    }
}
