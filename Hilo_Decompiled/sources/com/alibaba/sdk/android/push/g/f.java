package com.alibaba.sdk.android.push.g;

import java.util.concurrent.ConcurrentHashMap;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private final ConcurrentHashMap<Integer, a> f٦٦٩١a = new ConcurrentHashMap<>();

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    static class a {

        /* renamed from: a, reason: collision with root package name */
        private final String f٦٦٩٢a;

        /* renamed from: b, reason: collision with root package name */
        private final String f٦٦٩٣b;

        /* renamed from: c, reason: collision with root package name */
        private final long f٦٦٩٤c;

        public a(String str, String str2, long j10) {
            this.f٦٦٩٢a = str;
            this.f٦٦٩٣b = str2;
            this.f٦٦٩٤c = j10;
        }

        public String a() {
            return this.f٦٦٩٣b;
        }

        public long b() {
            return this.f٦٦٩٤c;
        }
    }

    public a a(int i10) {
        a aVar = this.f٦٦٩١a.get(Integer.valueOf(i10));
        if (aVar == null || a(aVar.b(), System.currentTimeMillis())) {
            return null;
        }
        return aVar;
    }

    public void a(int i10, String str) {
        a aVar;
        long currentTimeMillis = System.currentTimeMillis();
        int i11 = 1;
        if (i10 != 1) {
            i11 = 2;
            if (i10 != 2) {
                i11 = 3;
                if (i10 != 3) {
                    i11 = 4;
                    if (i10 != 4) {
                        return;
                    } else {
                        aVar = new a(String.valueOf(4), str, currentTimeMillis);
                    }
                } else {
                    aVar = new a(String.valueOf(3), str, currentTimeMillis);
                }
            } else {
                aVar = new a(String.valueOf(2), str, currentTimeMillis);
            }
        } else {
            aVar = new a(String.valueOf(1), str, currentTimeMillis);
        }
        this.f٦٦٩١a.put(Integer.valueOf(i11), aVar);
    }

    private boolean a(long j10, long j11) {
        return j11 - j10 >= 5000;
    }
}
