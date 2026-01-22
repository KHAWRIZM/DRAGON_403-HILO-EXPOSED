package com.oudi.utils.json;

import com.google.gson.d;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.google.gson.w;
import com.google.gson.x;
import java.lang.reflect.Type;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import q8.h;
import r8.j;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0012B\u0011\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ!\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0004\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/oudi/utils/json/GsonAnyTypeAdapter;", "Lcom/google/gson/w;", "", "Lcom/google/gson/d;", "gson", "<init>", "(Lcom/google/gson/d;)V", "Lcom/google/gson/stream/JsonReader;", "reader", "read", "(Lcom/google/gson/stream/JsonReader;)Ljava/lang/Object;", "Lcom/google/gson/stream/JsonWriter;", "out", "value", "", "write", "(Lcom/google/gson/stream/JsonWriter;Ljava/lang/Object;)V", "Lcom/google/gson/d;", "Companion", "lib_utils_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class GsonAnyTypeAdapter extends w {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private d gson;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/oudi/utils/json/GsonAnyTypeAdapter$Companion;", "", "<init>", "()V", "Ljava/lang/reflect/Type;", "targetType", "Lcom/google/gson/x;", "newFactory", "(Ljava/lang/reflect/Type;)Lcom/google/gson/x;", "lib_utils_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final x newFactory(final Type targetType) {
            Intrinsics.checkNotNullParameter(targetType, "targetType");
            return new x() { // from class: com.oudi.utils.json.GsonAnyTypeAdapter$Companion$newFactory$1
                @Override // com.google.gson.x
                public <T> w create(d gson, TypeToken<T> type) {
                    Intrinsics.checkNotNullParameter(gson, "gson");
                    Intrinsics.checkNotNullParameter(type, "type");
                    if (Intrinsics.areEqual(type.getType(), targetType)) {
                        return new GsonAnyTypeAdapter(gson);
                    }
                    return null;
                }
            };
        }

        private Companion() {
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[JsonToken.values().length];
            try {
                iArr[JsonToken.BEGIN_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[JsonToken.BEGIN_OBJECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[JsonToken.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[JsonToken.NUMBER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[JsonToken.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[JsonToken.NULL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public GsonAnyTypeAdapter(d dVar) {
        this.gson = dVar == null ? new d() : dVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v7, types: [q8.h, java.util.Map] */
    @Override // com.google.gson.w
    public Object read(JsonReader reader) {
        int i10;
        ArrayList arrayList;
        Intrinsics.checkNotNullParameter(reader, "reader");
        JsonToken peek = reader.peek();
        if (peek == null) {
            i10 = -1;
        } else {
            i10 = WhenMappings.$EnumSwitchMapping$0[peek.ordinal()];
        }
        switch (i10) {
            case 1:
                ArrayList arrayList2 = new ArrayList();
                reader.beginArray();
                while (reader.hasNext()) {
                    Object read = read(reader);
                    Intrinsics.checkNotNull(read);
                    arrayList2.add(read);
                }
                reader.endArray();
                arrayList = arrayList2;
                break;
            case 2:
                ?? hVar = new h();
                reader.beginObject();
                while (reader.hasNext()) {
                    String nextName = reader.nextName();
                    Object read2 = read(reader);
                    Intrinsics.checkNotNull(read2);
                    hVar.put(nextName, read2);
                }
                reader.endObject();
                arrayList = hVar;
                break;
            case 3:
                return reader.nextString();
            case 4:
                double nextDouble = reader.nextDouble();
                if (nextDouble > 9.223372036854776E18d) {
                    return Double.valueOf(nextDouble);
                }
                long j10 = (long) nextDouble;
                if (nextDouble == j10) {
                    try {
                        return Integer.valueOf((int) j10);
                    } catch (Exception unused) {
                        return Long.valueOf(j10);
                    }
                }
                return Double.valueOf(nextDouble);
            case 5:
                return Boolean.valueOf(reader.nextBoolean());
            case 6:
                reader.nextNull();
                return null;
            default:
                throw new IllegalStateException();
        }
        return arrayList;
    }

    @Override // com.google.gson.w
    public void write(JsonWriter out, Object value) {
        Intrinsics.checkNotNullParameter(out, "out");
        if (value == null) {
            out.nullValue();
            return;
        }
        w m10 = this.gson.m(value.getClass());
        Intrinsics.checkNotNull(m10, "null cannot be cast to non-null type com.google.gson.TypeAdapter<kotlin.Any>");
        if (m10 instanceof j) {
            out.beginObject();
            out.endObject();
        } else {
            m10.write(out, value);
        }
    }
}
