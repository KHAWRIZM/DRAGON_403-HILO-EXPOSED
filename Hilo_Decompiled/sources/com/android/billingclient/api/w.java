package com.android.billingclient.api;

import com.google.android.gms.internal.play_billing.zzb;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class w {

    /* renamed from: a, reason: collision with root package name */
    private int f٧١٩٤a;

    /* renamed from: b, reason: collision with root package name */
    private String f٧١٩٥b;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private int f٧١٩٦a;

        /* renamed from: b, reason: collision with root package name */
        private String f٧١٩٧b = "";

        /* synthetic */ a(e2 e2Var) {
        }

        public w a() {
            w wVar = new w();
            wVar.f٧١٩٤a = this.f٧١٩٦a;
            wVar.f٧١٩٥b = this.f٧١٩٧b;
            return wVar;
        }

        public a b(String str) {
            this.f٧١٩٧b = str;
            return this;
        }

        public a c(int i10) {
            this.f٧١٩٦a = i10;
            return this;
        }
    }

    public static a c() {
        return new a(null);
    }

    public String a() {
        return this.f٧١٩٥b;
    }

    public int b() {
        return this.f٧١٩٤a;
    }

    public String toString() {
        return "Response Code: " + zzb.zzh(this.f٧١٩٤a) + ", Debug Message: " + this.f٧١٩٥b;
    }
}
