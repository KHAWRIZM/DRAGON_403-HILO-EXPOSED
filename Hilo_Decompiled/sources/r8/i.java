package r8;

import com.google.gson.r;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.google.gson.u;
import com.google.gson.v;
import com.google.gson.w;
import com.google.gson.x;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class i extends w {

    /* renamed from: b, reason: collision with root package name */
    private static final x f١٧٣٩٧b = b(u.f١٠٨٥٨b);

    /* renamed from: a, reason: collision with root package name */
    private final v f١٧٣٩٨a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class a implements x {
        a() {
        }

        @Override // com.google.gson.x
        public w create(com.google.gson.d dVar, TypeToken typeToken) {
            if (typeToken.getRawType() == Number.class) {
                return i.this;
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f١٧٤٠٠a;

        static {
            int[] iArr = new int[JsonToken.values().length];
            f١٧٤٠٠a = iArr;
            try {
                iArr[JsonToken.NULL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f١٧٤٠٠a[JsonToken.NUMBER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f١٧٤٠٠a[JsonToken.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private i(v vVar) {
        this.f١٧٣٩٨a = vVar;
    }

    public static x a(v vVar) {
        if (vVar == u.f١٠٨٥٨b) {
            return f١٧٣٩٧b;
        }
        return b(vVar);
    }

    private static x b(v vVar) {
        return new a();
    }

    @Override // com.google.gson.w
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public Number read(JsonReader jsonReader) {
        JsonToken peek = jsonReader.peek();
        int i10 = b.f١٧٤٠٠a[peek.ordinal()];
        if (i10 != 1) {
            if (i10 != 2 && i10 != 3) {
                throw new r("Expecting number, got: " + peek + "; at path " + jsonReader.getPath());
            }
            return this.f١٧٣٩٨a.a(jsonReader);
        }
        jsonReader.nextNull();
        return null;
    }

    @Override // com.google.gson.w
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void write(JsonWriter jsonWriter, Number number) {
        jsonWriter.value(number);
    }
}
