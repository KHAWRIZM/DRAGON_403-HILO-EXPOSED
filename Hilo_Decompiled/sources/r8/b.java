package r8;

import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.google.gson.w;
import com.google.gson.x;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class b implements x {

    /* renamed from: a, reason: collision with root package name */
    private final q8.c f١٧٣٦٩a;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    private static final class a extends w {

        /* renamed from: a, reason: collision with root package name */
        private final w f١٧٣٧٠a;

        /* renamed from: b, reason: collision with root package name */
        private final q8.i f١٧٣٧١b;

        public a(com.google.gson.d dVar, Type type, w wVar, q8.i iVar) {
            this.f١٧٣٧٠a = new n(dVar, wVar, type);
            this.f١٧٣٧١b = iVar;
        }

        @Override // com.google.gson.w
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Collection read(JsonReader jsonReader) {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            Collection collection = (Collection) this.f١٧٣٧١b.a();
            jsonReader.beginArray();
            while (jsonReader.hasNext()) {
                collection.add(this.f١٧٣٧٠a.read(jsonReader));
            }
            jsonReader.endArray();
            return collection;
        }

        @Override // com.google.gson.w
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void write(JsonWriter jsonWriter, Collection collection) {
            if (collection == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginArray();
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                this.f١٧٣٧٠a.write(jsonWriter, it.next());
            }
            jsonWriter.endArray();
        }
    }

    public b(q8.c cVar) {
        this.f١٧٣٦٩a = cVar;
    }

    @Override // com.google.gson.x
    public w create(com.google.gson.d dVar, TypeToken typeToken) {
        Type type = typeToken.getType();
        Class rawType = typeToken.getRawType();
        if (!Collection.class.isAssignableFrom(rawType)) {
            return null;
        }
        Type h10 = q8.b.h(type, rawType);
        return new a(dVar, h10, dVar.l(TypeToken.get(h10)), this.f١٧٣٦٩a.b(typeToken));
    }
}
