package r8;

import com.amazonaws.services.s3.internal.Constants;
import com.google.gson.r;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.google.gson.w;
import com.google.gson.x;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class h implements x {

    /* renamed from: a, reason: collision with root package name */
    private final q8.c f١٧٣٩١a;

    /* renamed from: b, reason: collision with root package name */
    final boolean f١٧٣٩٢b;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    private final class a extends w {

        /* renamed from: a, reason: collision with root package name */
        private final w f١٧٣٩٣a;

        /* renamed from: b, reason: collision with root package name */
        private final w f١٧٣٩٤b;

        /* renamed from: c, reason: collision with root package name */
        private final q8.i f١٧٣٩٥c;

        public a(com.google.gson.d dVar, Type type, w wVar, Type type2, w wVar2, q8.i iVar) {
            this.f١٧٣٩٣a = new n(dVar, wVar, type);
            this.f١٧٣٩٤b = new n(dVar, wVar2, type2);
            this.f١٧٣٩٥c = iVar;
        }

        private String a(com.google.gson.i iVar) {
            if (iVar.m()) {
                com.google.gson.o f10 = iVar.f();
                if (f10.u()) {
                    return String.valueOf(f10.r());
                }
                if (f10.s()) {
                    return Boolean.toString(f10.n());
                }
                if (f10.v()) {
                    return f10.h();
                }
                throw new AssertionError();
            }
            if (iVar.k()) {
                return Constants.NULL_VERSION_ID;
            }
            throw new AssertionError();
        }

        @Override // com.google.gson.w
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map read(JsonReader jsonReader) {
            JsonToken peek = jsonReader.peek();
            if (peek == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            Map map = (Map) this.f١٧٣٩٥c.a();
            if (peek == JsonToken.BEGIN_ARRAY) {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    jsonReader.beginArray();
                    Object read = this.f١٧٣٩٣a.read(jsonReader);
                    if (map.put(read, this.f١٧٣٩٤b.read(jsonReader)) == null) {
                        jsonReader.endArray();
                    } else {
                        throw new r("duplicate key: " + read);
                    }
                }
                jsonReader.endArray();
            } else {
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    q8.f.INSTANCE.promoteNameToValue(jsonReader);
                    Object read2 = this.f١٧٣٩٣a.read(jsonReader);
                    if (map.put(read2, this.f١٧٣٩٤b.read(jsonReader)) != null) {
                        throw new r("duplicate key: " + read2);
                    }
                }
                jsonReader.endObject();
            }
            return map;
        }

        @Override // com.google.gson.w
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void write(JsonWriter jsonWriter, Map map) {
            boolean z10;
            if (map == null) {
                jsonWriter.nullValue();
                return;
            }
            if (!h.this.f١٧٣٩٢b) {
                jsonWriter.beginObject();
                for (Map.Entry entry : map.entrySet()) {
                    jsonWriter.name(String.valueOf(entry.getKey()));
                    this.f١٧٣٩٤b.write(jsonWriter, entry.getValue());
                }
                jsonWriter.endObject();
                return;
            }
            ArrayList arrayList = new ArrayList(map.size());
            ArrayList arrayList2 = new ArrayList(map.size());
            int i10 = 0;
            boolean z11 = false;
            for (Map.Entry entry2 : map.entrySet()) {
                com.google.gson.i jsonTree = this.f١٧٣٩٣a.toJsonTree(entry2.getKey());
                arrayList.add(jsonTree);
                arrayList2.add(entry2.getValue());
                if (!jsonTree.i() && !jsonTree.l()) {
                    z10 = false;
                } else {
                    z10 = true;
                }
                z11 |= z10;
            }
            if (z11) {
                jsonWriter.beginArray();
                int size = arrayList.size();
                while (i10 < size) {
                    jsonWriter.beginArray();
                    q8.m.b((com.google.gson.i) arrayList.get(i10), jsonWriter);
                    this.f١٧٣٩٤b.write(jsonWriter, arrayList2.get(i10));
                    jsonWriter.endArray();
                    i10++;
                }
                jsonWriter.endArray();
                return;
            }
            jsonWriter.beginObject();
            int size2 = arrayList.size();
            while (i10 < size2) {
                jsonWriter.name(a((com.google.gson.i) arrayList.get(i10)));
                this.f١٧٣٩٤b.write(jsonWriter, arrayList2.get(i10));
                i10++;
            }
            jsonWriter.endObject();
        }
    }

    public h(q8.c cVar, boolean z10) {
        this.f١٧٣٩١a = cVar;
        this.f١٧٣٩٢b = z10;
    }

    private w a(com.google.gson.d dVar, Type type) {
        if (type != Boolean.TYPE && type != Boolean.class) {
            return dVar.l(TypeToken.get(type));
        }
        return o.f١٧٤٤٩f;
    }

    @Override // com.google.gson.x
    public w create(com.google.gson.d dVar, TypeToken typeToken) {
        Type type = typeToken.getType();
        Class rawType = typeToken.getRawType();
        if (!Map.class.isAssignableFrom(rawType)) {
            return null;
        }
        Type[] j10 = q8.b.j(type, rawType);
        return new a(dVar, j10[0], a(dVar, j10[0]), j10[1], dVar.l(TypeToken.get(j10[1])), this.f١٧٣٩١a.b(typeToken));
    }
}
