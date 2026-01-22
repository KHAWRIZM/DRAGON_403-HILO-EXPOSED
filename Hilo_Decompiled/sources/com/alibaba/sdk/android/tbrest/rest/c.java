package com.alibaba.sdk.android.tbrest.rest;

import com.alibaba.sdk.android.tbrest.utils.StringUtils;
import java.util.Arrays;
import java.util.Comparator;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static c f٦٨٤٤a;

    /* renamed from: a, reason: collision with other field name */
    private final a f٢١a;

    /* renamed from: a, reason: collision with other field name */
    private final b f٢٢a;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    private static class a implements Comparator<String> {
        private a() {
        }

        @Override // java.util.Comparator
        public int compare(String str, String str2) {
            if (StringUtils.isEmpty(str) || StringUtils.isEmpty(str2)) {
                return 0;
            }
            return str.compareTo(str2);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    private static class b implements Comparator<String> {
        private b() {
        }

        @Override // java.util.Comparator
        public int compare(String str, String str2) {
            if (StringUtils.isEmpty(str) || StringUtils.isEmpty(str2)) {
                return 0;
            }
            return str.compareTo(str2) * (-1);
        }
    }

    private c() {
        this.f٢٢a = new b();
        this.f٢١a = new a();
    }

    public static synchronized c a() {
        c cVar;
        synchronized (c.class) {
            try {
                if (f٦٨٤٤a == null) {
                    f٦٨٤٤a = new c();
                }
                cVar = f٦٨٤٤a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return cVar;
    }

    public String[] a(String[] strArr, boolean z10) {
        Comparator comparator;
        if (z10) {
            comparator = this.f٢١a;
        } else {
            comparator = this.f٢٢a;
        }
        if (strArr == null || strArr.length <= 0) {
            return null;
        }
        Arrays.sort(strArr, comparator);
        return strArr;
    }
}
