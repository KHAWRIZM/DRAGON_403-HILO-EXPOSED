package r8;

import com.google.gson.q;
import com.google.gson.reflect.TypeToken;
import com.google.gson.w;
import com.google.gson.x;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class e implements x {

    /* renamed from: a, reason: collision with root package name */
    private final q8.c f١٧٣٧٨a;

    public e(q8.c cVar) {
        this.f١٧٣٧٨a = cVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public w a(q8.c cVar, com.google.gson.d dVar, TypeToken typeToken, p8.b bVar) {
        q qVar;
        com.google.gson.h hVar;
        w mVar;
        Object a10 = cVar.b(TypeToken.get(bVar.value())).a();
        boolean nullSafe = bVar.nullSafe();
        if (a10 instanceof w) {
            mVar = (w) a10;
        } else if (a10 instanceof x) {
            mVar = ((x) a10).create(dVar, typeToken);
        } else {
            boolean z10 = a10 instanceof q;
            if (!z10 && !(a10 instanceof com.google.gson.h)) {
                throw new IllegalArgumentException("Invalid attempt to bind an instance of " + a10.getClass().getName() + " as a @JsonAdapter for " + typeToken.toString() + ". @JsonAdapter value must be a TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer.");
            }
            if (z10) {
                qVar = (q) a10;
            } else {
                qVar = null;
            }
            if (a10 instanceof com.google.gson.h) {
                hVar = (com.google.gson.h) a10;
            } else {
                hVar = null;
            }
            mVar = new m(qVar, hVar, dVar, typeToken, null, nullSafe);
            nullSafe = false;
        }
        if (mVar != null && nullSafe) {
            return mVar.nullSafe();
        }
        return mVar;
    }

    @Override // com.google.gson.x
    public w create(com.google.gson.d dVar, TypeToken typeToken) {
        p8.b bVar = (p8.b) typeToken.getRawType().getAnnotation(p8.b.class);
        if (bVar == null) {
            return null;
        }
        return a(this.f١٧٣٧٨a, dVar, typeToken, bVar);
    }
}
