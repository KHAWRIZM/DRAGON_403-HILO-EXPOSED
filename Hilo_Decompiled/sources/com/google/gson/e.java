package com.google.gson;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import r8.d;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private q8.d f١٠٨٢٥a = q8.d.f١٧١٩٧g;

    /* renamed from: b, reason: collision with root package name */
    private s f١٠٨٢٦b = s.f١٠٨٤٩a;

    /* renamed from: c, reason: collision with root package name */
    private c f١٠٨٢٧c = b.f١٠٧٨٥a;

    /* renamed from: d, reason: collision with root package name */
    private final Map f١٠٨٢٨d = new HashMap();

    /* renamed from: e, reason: collision with root package name */
    private final List f١٠٨٢٩e = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    private final List f١٠٨٣٠f = new ArrayList();

    /* renamed from: g, reason: collision with root package name */
    private boolean f١٠٨٣١g = false;

    /* renamed from: h, reason: collision with root package name */
    private String f١٠٨٣٢h = d.f١٠٧٩٤z;

    /* renamed from: i, reason: collision with root package name */
    private int f١٠٨٣٣i = 2;

    /* renamed from: j, reason: collision with root package name */
    private int f١٠٨٣٤j = 2;

    /* renamed from: k, reason: collision with root package name */
    private boolean f١٠٨٣٥k = false;

    /* renamed from: l, reason: collision with root package name */
    private boolean f١٠٨٣٦l = false;

    /* renamed from: m, reason: collision with root package name */
    private boolean f١٠٨٣٧m = true;

    /* renamed from: n, reason: collision with root package name */
    private boolean f١٠٨٣٨n = false;

    /* renamed from: o, reason: collision with root package name */
    private boolean f١٠٨٣٩o = false;

    /* renamed from: p, reason: collision with root package name */
    private boolean f١٠٨٤٠p = false;

    /* renamed from: q, reason: collision with root package name */
    private boolean f١٠٨٤١q = true;

    /* renamed from: r, reason: collision with root package name */
    private v f١٠٨٤٢r = d.f١٠٧٩٣B;

    /* renamed from: s, reason: collision with root package name */
    private v f١٠٨٤٣s = d.C;

    /* renamed from: t, reason: collision with root package name */
    private final LinkedList f١٠٨٤٤t = new LinkedList();

    private void a(String str, int i10, int i11, List list) {
        x xVar;
        x xVar2;
        boolean z10 = u8.d.f١٨٢٧٠a;
        x xVar3 = null;
        if (str != null && !str.trim().isEmpty()) {
            xVar = d.b.f١٧٣٧٦b.b(str);
            if (z10) {
                xVar3 = u8.d.f١٨٢٧٢c.b(str);
                xVar2 = u8.d.f١٨٢٧١b.b(str);
            }
            xVar2 = null;
        } else if (i10 != 2 && i11 != 2) {
            x a10 = d.b.f١٧٣٧٦b.a(i10, i11);
            if (z10) {
                xVar3 = u8.d.f١٨٢٧٢c.a(i10, i11);
                x a11 = u8.d.f١٨٢٧١b.a(i10, i11);
                xVar = a10;
                xVar2 = a11;
            } else {
                xVar = a10;
                xVar2 = null;
            }
        } else {
            return;
        }
        list.add(xVar);
        if (z10) {
            list.add(xVar3);
            list.add(xVar2);
        }
    }

    public d b() {
        ArrayList arrayList = new ArrayList(this.f١٠٨٢٩e.size() + this.f١٠٨٣٠f.size() + 3);
        arrayList.addAll(this.f١٠٨٢٩e);
        Collections.reverse(arrayList);
        ArrayList arrayList2 = new ArrayList(this.f١٠٨٣٠f);
        Collections.reverse(arrayList2);
        arrayList.addAll(arrayList2);
        a(this.f١٠٨٣٢h, this.f١٠٨٣٣i, this.f١٠٨٣٤j, arrayList);
        return new d(this.f١٠٨٢٥a, this.f١٠٨٢٧c, new HashMap(this.f١٠٨٢٨d), this.f١٠٨٣١g, this.f١٠٨٣٥k, this.f١٠٨٣٩o, this.f١٠٨٣٧m, this.f١٠٨٣٨n, this.f١٠٨٤٠p, this.f١٠٨٣٦l, this.f١٠٨٤١q, this.f١٠٨٢٦b, this.f١٠٨٣٢h, this.f١٠٨٣٣i, this.f١٠٨٣٤j, new ArrayList(this.f١٠٨٢٩e), new ArrayList(this.f١٠٨٣٠f), arrayList, this.f١٠٨٤٢r, this.f١٠٨٤٣s, new ArrayList(this.f١٠٨٤٤t));
    }

    public e c() {
        this.f١٠٨٣٧m = false;
        return this;
    }

    public e d(x xVar) {
        Objects.requireNonNull(xVar);
        this.f١٠٨٢٩e.add(xVar);
        return this;
    }
}
