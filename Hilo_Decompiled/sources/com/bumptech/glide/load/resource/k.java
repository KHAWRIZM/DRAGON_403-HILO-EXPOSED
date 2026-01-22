package com.bumptech.glide.load.resource;

import o4.v;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class k implements v {

    /* renamed from: a, reason: collision with root package name */
    protected final Object f٧٥٢٦a;

    public k(Object obj) {
        this.f٧٥٢٦a = f5.k.d(obj);
    }

    @Override // o4.v
    public final Object get() {
        return this.f٧٥٢٦a;
    }

    @Override // o4.v
    public Class getResourceClass() {
        return this.f٧٥٢٦a.getClass();
    }

    @Override // o4.v
    public final int getSize() {
        return 1;
    }

    @Override // o4.v
    public void recycle() {
    }
}
