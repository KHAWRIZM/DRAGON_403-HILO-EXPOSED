package r8;

import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.google.gson.u;
import com.google.gson.v;
import com.google.gson.w;
import com.google.gson.x;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class j extends w {

    /* renamed from: c, reason: collision with root package name */
    private static final x f١٧٤٠١c = b(u.f١٠٨٥٧a);

    /* renamed from: a, reason: collision with root package name */
    private final com.google.gson.d f١٧٤٠٢a;

    /* renamed from: b, reason: collision with root package name */
    private final v f١٧٤٠٣b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class a implements x {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ v f١٧٤٠٤a;

        a(v vVar) {
            this.f١٧٤٠٤a = vVar;
        }

        @Override // com.google.gson.x
        public w create(com.google.gson.d dVar, TypeToken typeToken) {
            a aVar = null;
            if (typeToken.getRawType() != Object.class) {
                return null;
            }
            return new j(dVar, this.f١٧٤٠٤a, aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f١٧٤٠٥a;

        static {
            int[] iArr = new int[JsonToken.values().length];
            f١٧٤٠٥a = iArr;
            try {
                iArr[JsonToken.BEGIN_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f١٧٤٠٥a[JsonToken.BEGIN_OBJECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f١٧٤٠٥a[JsonToken.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f١٧٤٠٥a[JsonToken.NUMBER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f١٧٤٠٥a[JsonToken.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f١٧٤٠٥a[JsonToken.NULL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* synthetic */ j(com.google.gson.d dVar, v vVar, a aVar) {
        this(dVar, vVar);
    }

    public static x a(v vVar) {
        if (vVar == u.f١٠٨٥٧a) {
            return f١٧٤٠١c;
        }
        return b(vVar);
    }

    private static x b(v vVar) {
        return new a(vVar);
    }

    private Object c(JsonReader jsonReader, JsonToken jsonToken) {
        int i10 = b.f١٧٤٠٥a[jsonToken.ordinal()];
        if (i10 != 3) {
            if (i10 != 4) {
                if (i10 != 5) {
                    if (i10 == 6) {
                        jsonReader.nextNull();
                        return null;
                    }
                    throw new IllegalStateException("Unexpected token: " + jsonToken);
                }
                return Boolean.valueOf(jsonReader.nextBoolean());
            }
            return this.f١٧٤٠٣b.a(jsonReader);
        }
        return jsonReader.nextString();
    }

    private Object d(JsonReader jsonReader, JsonToken jsonToken) {
        int i10 = b.f١٧٤٠٥a[jsonToken.ordinal()];
        if (i10 != 1) {
            if (i10 != 2) {
                return null;
            }
            jsonReader.beginObject();
            return new q8.h();
        }
        jsonReader.beginArray();
        return new ArrayList();
    }

    @Override // com.google.gson.w
    public Object read(JsonReader jsonReader) {
        String str;
        boolean z10;
        JsonToken peek = jsonReader.peek();
        Object d10 = d(jsonReader, peek);
        if (d10 == null) {
            return c(jsonReader, peek);
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        while (true) {
            if (jsonReader.hasNext()) {
                if (d10 instanceof Map) {
                    str = jsonReader.nextName();
                } else {
                    str = null;
                }
                JsonToken peek2 = jsonReader.peek();
                Object d11 = d(jsonReader, peek2);
                if (d11 != null) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (d11 == null) {
                    d11 = c(jsonReader, peek2);
                }
                if (d10 instanceof List) {
                    ((List) d10).add(d11);
                } else {
                    ((Map) d10).put(str, d11);
                }
                if (z10) {
                    arrayDeque.addLast(d10);
                    d10 = d11;
                }
            } else {
                if (d10 instanceof List) {
                    jsonReader.endArray();
                } else {
                    jsonReader.endObject();
                }
                if (arrayDeque.isEmpty()) {
                    return d10;
                }
                d10 = arrayDeque.removeLast();
            }
        }
    }

    @Override // com.google.gson.w
    public void write(JsonWriter jsonWriter, Object obj) {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        w m10 = this.f١٧٤٠٢a.m(obj.getClass());
        if (m10 instanceof j) {
            jsonWriter.beginObject();
            jsonWriter.endObject();
        } else {
            m10.write(jsonWriter, obj);
        }
    }

    private j(com.google.gson.d dVar, v vVar) {
        this.f١٧٤٠٢a = dVar;
        this.f١٧٤٠٣b = vVar;
    }
}
