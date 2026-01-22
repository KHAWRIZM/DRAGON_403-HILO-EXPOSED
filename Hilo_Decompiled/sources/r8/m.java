package r8;

import com.google.gson.p;
import com.google.gson.q;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.google.gson.w;
import com.google.gson.x;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class m extends l {

    /* renamed from: a, reason: collision with root package name */
    private final q f١٧٤٣١a;

    /* renamed from: b, reason: collision with root package name */
    private final com.google.gson.h f١٧٤٣٢b;

    /* renamed from: c, reason: collision with root package name */
    final com.google.gson.d f١٧٤٣٣c;

    /* renamed from: d, reason: collision with root package name */
    private final TypeToken f١٧٤٣٤d;

    /* renamed from: e, reason: collision with root package name */
    private final x f١٧٤٣٥e;

    /* renamed from: f, reason: collision with root package name */
    private final b f١٧٤٣٦f = new b();

    /* renamed from: g, reason: collision with root package name */
    private final boolean f١٧٤٣٧g;

    /* renamed from: h, reason: collision with root package name */
    private volatile w f١٧٤٣٨h;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    private final class b implements p, com.google.gson.g {
        private b() {
        }
    }

    public m(q qVar, com.google.gson.h hVar, com.google.gson.d dVar, TypeToken typeToken, x xVar, boolean z10) {
        this.f١٧٤٣١a = qVar;
        this.f١٧٤٣٢b = hVar;
        this.f١٧٤٣٣c = dVar;
        this.f١٧٤٣٤d = typeToken;
        this.f١٧٤٣٥e = xVar;
        this.f١٧٤٣٧g = z10;
    }

    private w b() {
        w wVar = this.f١٧٤٣٨h;
        if (wVar == null) {
            w n10 = this.f١٧٤٣٣c.n(this.f١٧٤٣٥e, this.f١٧٤٣٤d);
            this.f١٧٤٣٨h = n10;
            return n10;
        }
        return wVar;
    }

    @Override // r8.l
    public w a() {
        if (this.f١٧٤٣١a != null) {
            return this;
        }
        return b();
    }

    @Override // com.google.gson.w
    public Object read(JsonReader jsonReader) {
        if (this.f١٧٤٣٢b == null) {
            return b().read(jsonReader);
        }
        com.google.gson.i a10 = q8.m.a(jsonReader);
        if (this.f١٧٤٣٧g && a10.k()) {
            return null;
        }
        return this.f١٧٤٣٢b.deserialize(a10, this.f١٧٤٣٤d.getType(), this.f١٧٤٣٦f);
    }

    @Override // com.google.gson.w
    public void write(JsonWriter jsonWriter, Object obj) {
        q qVar = this.f١٧٤٣١a;
        if (qVar == null) {
            b().write(jsonWriter, obj);
        } else if (this.f١٧٤٣٧g && obj == null) {
            jsonWriter.nullValue();
        } else {
            q8.m.b(qVar.serialize(obj, this.f١٧٤٣٤d.getType(), this.f١٧٤٣٦f), jsonWriter);
        }
    }
}
