package r8;

import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.google.gson.w;
import com.google.gson.x;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.ArrayList;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class a extends w {

    /* renamed from: c, reason: collision with root package name */
    public static final x f١٧٣٦٦c = new C٠٢١٩a();

    /* renamed from: a, reason: collision with root package name */
    private final Class f١٧٣٦٧a;

    /* renamed from: b, reason: collision with root package name */
    private final w f١٧٣٦٨b;

    /* renamed from: r8.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class C٠٢١٩a implements x {
        C٠٢١٩a() {
        }

        @Override // com.google.gson.x
        public w create(com.google.gson.d dVar, TypeToken typeToken) {
            Type type = typeToken.getType();
            if (!(type instanceof GenericArrayType) && (!(type instanceof Class) || !((Class) type).isArray())) {
                return null;
            }
            Type g10 = q8.b.g(type);
            return new a(dVar, dVar.l(TypeToken.get(g10)), q8.b.k(g10));
        }
    }

    public a(com.google.gson.d dVar, w wVar, Class cls) {
        this.f١٧٣٦٨b = new n(dVar, wVar, cls);
        this.f١٧٣٦٧a = cls;
    }

    @Override // com.google.gson.w
    public Object read(JsonReader jsonReader) {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        ArrayList arrayList = new ArrayList();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            arrayList.add(this.f١٧٣٦٨b.read(jsonReader));
        }
        jsonReader.endArray();
        int size = arrayList.size();
        if (this.f١٧٣٦٧a.isPrimitive()) {
            Object newInstance = Array.newInstance((Class<?>) this.f١٧٣٦٧a, size);
            for (int i10 = 0; i10 < size; i10++) {
                Array.set(newInstance, i10, arrayList.get(i10));
            }
            return newInstance;
        }
        return arrayList.toArray((Object[]) Array.newInstance((Class<?>) this.f١٧٣٦٧a, size));
    }

    @Override // com.google.gson.w
    public void write(JsonWriter jsonWriter, Object obj) {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        jsonWriter.beginArray();
        int length = Array.getLength(obj);
        for (int i10 = 0; i10 < length; i10++) {
            this.f١٧٣٦٨b.write(jsonWriter, Array.get(obj, i10));
        }
        jsonWriter.endArray();
    }
}
