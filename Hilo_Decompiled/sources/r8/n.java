package r8;

import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.google.gson.w;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import r8.k;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class n extends w {

    /* renamed from: a, reason: collision with root package name */
    private final com.google.gson.d f١٧٤٤٠a;

    /* renamed from: b, reason: collision with root package name */
    private final w f١٧٤٤١b;

    /* renamed from: c, reason: collision with root package name */
    private final Type f١٧٤٤٢c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(com.google.gson.d dVar, w wVar, Type type) {
        this.f١٧٤٤٠a = dVar;
        this.f١٧٤٤١b = wVar;
        this.f١٧٤٤٢c = type;
    }

    private static Type a(Type type, Object obj) {
        if (obj != null) {
            if ((type instanceof Class) || (type instanceof TypeVariable)) {
                return obj.getClass();
            }
            return type;
        }
        return type;
    }

    private static boolean b(w wVar) {
        w a10;
        while ((wVar instanceof l) && (a10 = ((l) wVar).a()) != wVar) {
            wVar = a10;
        }
        return wVar instanceof k.b;
    }

    @Override // com.google.gson.w
    public Object read(JsonReader jsonReader) {
        return this.f١٧٤٤١b.read(jsonReader);
    }

    @Override // com.google.gson.w
    public void write(JsonWriter jsonWriter, Object obj) {
        w wVar = this.f١٧٤٤١b;
        Type a10 = a(this.f١٧٤٤٢c, obj);
        if (a10 != this.f١٧٤٤٢c) {
            wVar = this.f١٧٤٤٠a.l(TypeToken.get(a10));
            if ((wVar instanceof k.b) && !b(this.f١٧٤٤١b)) {
                wVar = this.f١٧٤٤١b;
            }
        }
        wVar.write(jsonWriter, obj);
    }
}
