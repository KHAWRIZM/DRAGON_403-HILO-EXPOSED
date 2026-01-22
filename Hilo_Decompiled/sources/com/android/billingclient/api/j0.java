package com.android.billingclient.api;

import com.google.android.gms.internal.play_billing.zzai;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class j0 {

    /* renamed from: a, reason: collision with root package name */
    private final zzai f٧٠٩٤a;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private zzai f٧٠٩٥a;

        /* synthetic */ a(z2 z2Var) {
        }

        public j0 a() {
            return new j0(this, null);
        }

        public a b(List list) {
            if (list != null && !list.isEmpty()) {
                HashSet hashSet = new HashSet();
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    b bVar = (b) it.next();
                    if (!"play_pass_subs".equals(bVar.c())) {
                        hashSet.add(bVar.c());
                    }
                }
                if (hashSet.size() <= 1) {
                    this.f٧٠٩٥a = zzai.zzj(list);
                    return this;
                }
                throw new IllegalArgumentException("All products should be of the same product type.");
            }
            throw new IllegalArgumentException("Product list cannot be empty.");
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private final String f٧٠٩٦a;

        /* renamed from: b, reason: collision with root package name */
        private final String f٧٠٩٧b;

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
        public static class a {

            /* renamed from: a, reason: collision with root package name */
            private String f٧٠٩٨a;

            /* renamed from: b, reason: collision with root package name */
            private String f٧٠٩٩b;

            /* synthetic */ a(a3 a3Var) {
            }

            public b a() {
                if (!"first_party".equals(this.f٧٠٩٩b)) {
                    if (this.f٧٠٩٨a != null) {
                        if (this.f٧٠٩٩b != null) {
                            return new b(this, null);
                        }
                        throw new IllegalArgumentException("Product type must be provided.");
                    }
                    throw new IllegalArgumentException("Product id must be provided.");
                }
                throw new IllegalArgumentException("Serialized doc id must be provided for first party products.");
            }

            public a b(String str) {
                this.f٧٠٩٨a = str;
                return this;
            }

            public a c(String str) {
                this.f٧٠٩٩b = str;
                return this;
            }
        }

        /* synthetic */ b(a aVar, b3 b3Var) {
            this.f٧٠٩٦a = aVar.f٧٠٩٨a;
            this.f٧٠٩٧b = aVar.f٧٠٩٩b;
        }

        public static a a() {
            return new a(null);
        }

        public final String b() {
            return this.f٧٠٩٦a;
        }

        public final String c() {
            return this.f٧٠٩٧b;
        }
    }

    /* synthetic */ j0(a aVar, c3 c3Var) {
        this.f٧٠٩٤a = aVar.f٧٠٩٥a;
    }

    public static a a() {
        return new a(null);
    }

    public final zzai b() {
        return this.f٧٠٩٤a;
    }

    public final String c() {
        return ((b) this.f٧٠٩٤a.get(0)).c();
    }
}
