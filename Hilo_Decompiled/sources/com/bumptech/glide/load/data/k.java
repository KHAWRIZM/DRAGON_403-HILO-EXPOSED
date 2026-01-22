package com.bumptech.glide.load.data;

import com.bumptech.glide.load.data.e;
import java.io.InputStream;
import v4.e0;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class k implements e {

    /* renamed from: a, reason: collision with root package name */
    private final e0 f٧٤٥٢a;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class a implements e.a {

        /* renamed from: a, reason: collision with root package name */
        private final p4.b f٧٤٥٣a;

        public a(p4.b bVar) {
            this.f٧٤٥٣a = bVar;
        }

        @Override // com.bumptech.glide.load.data.e.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public e build(InputStream inputStream) {
            return new k(inputStream, this.f٧٤٥٣a);
        }

        @Override // com.bumptech.glide.load.data.e.a
        public Class getDataClass() {
            return InputStream.class;
        }
    }

    public k(InputStream inputStream, p4.b bVar) {
        e0 e0Var = new e0(inputStream, bVar);
        this.f٧٤٥٢a = e0Var;
        e0Var.mark(5242880);
    }

    public void b() {
        this.f٧٤٥٢a.b();
    }

    @Override // com.bumptech.glide.load.data.e
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public InputStream a() {
        this.f٧٤٥٢a.reset();
        return this.f٧٤٥٢a;
    }

    @Override // com.bumptech.glide.load.data.e
    public void cleanup() {
        this.f٧٤٥٢a.release();
    }
}
