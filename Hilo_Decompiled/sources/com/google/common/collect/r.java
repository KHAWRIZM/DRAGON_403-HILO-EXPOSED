package com.google.common.collect;

import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
class r extends d implements Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: a, reason: collision with root package name */
    final Object f١٠٤٧٧a;

    /* renamed from: b, reason: collision with root package name */
    final Object f١٠٤٧٨b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(Object obj, Object obj2) {
        this.f١٠٤٧٧a = obj;
        this.f١٠٤٧٨b = obj2;
    }

    @Override // com.google.common.collect.d, java.util.Map.Entry
    public final Object getKey() {
        return this.f١٠٤٧٧a;
    }

    @Override // com.google.common.collect.d, java.util.Map.Entry
    public final Object getValue() {
        return this.f١٠٤٧٨b;
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        throw new UnsupportedOperationException();
    }
}
