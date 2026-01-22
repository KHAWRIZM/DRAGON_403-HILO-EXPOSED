package com.bumptech.glide;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private final Map f٧٢٥٣a;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final Map f٧٢٥٤a = new HashMap();

        /* JADX INFO: Access modifiers changed from: package-private */
        public d b() {
            return new d(this);
        }
    }

    d(a aVar) {
        this.f٧٢٥٣a = Collections.unmodifiableMap(new HashMap(aVar.f٧٢٥٤a));
    }

    public boolean a(Class cls) {
        return this.f٧٢٥٣a.containsKey(cls);
    }
}
