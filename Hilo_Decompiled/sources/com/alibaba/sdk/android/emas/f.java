package com.alibaba.sdk.android.emas;

import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class f {

    /* renamed from: b, reason: collision with root package name */
    private final List<g> f٦٤١٠b;

    /* renamed from: c, reason: collision with root package name */
    private final d f٦٤١١c;

    /* renamed from: c, reason: collision with other field name */
    private final String f١٣c;

    public f(List<g> list) {
        this(list, d.MEM_CACHE, null);
    }

    public d a() {
        return this.f٦٤١١c;
    }

    public String getLocation() {
        if (this.f٦٤١١c == d.DISK_CACHE) {
            return this.f١٣c;
        }
        return null;
    }

    public f(List<g> list, d dVar, String str) {
        this.f٦٤١٠b = list;
        this.f٦٤١١c = dVar;
        this.f١٣c = str;
    }

    /* renamed from: a, reason: collision with other method in class */
    public List<g> m٢٥٣a() {
        return this.f٦٤١٠b;
    }
}
