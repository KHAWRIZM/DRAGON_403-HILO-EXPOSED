package com.google.common.collect;

import com.google.common.collect.c;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
abstract class f extends c implements z {
    private static final long serialVersionUID = 7431625294878419160L;

    /* JADX INFO: Access modifiers changed from: protected */
    public f(Map map) {
        super(map);
    }

    @Override // com.google.common.collect.e, com.google.common.collect.z
    public Map a() {
        return super.a();
    }

    @Override // com.google.common.collect.e
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.common.collect.c
    public boolean p(Object obj, Object obj2) {
        return super.p(obj, obj2);
    }

    @Override // com.google.common.collect.c
    Collection s(Object obj, Collection collection) {
        return new c.d(obj, (Set) collection);
    }

    @Override // com.google.common.collect.c, com.google.common.collect.z
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public Set get(Object obj) {
        return (Set) super.get(obj);
    }
}
