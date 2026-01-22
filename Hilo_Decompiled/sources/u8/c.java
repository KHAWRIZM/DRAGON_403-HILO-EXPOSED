package u8;

import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.google.gson.w;
import com.google.gson.x;
import java.sql.Timestamp;
import java.util.Date;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
class c extends w {

    /* renamed from: b, reason: collision with root package name */
    static final x f١٨٢٦٨b = new a();

    /* renamed from: a, reason: collision with root package name */
    private final w f١٨٢٦٩a;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class a implements x {
        a() {
        }

        @Override // com.google.gson.x
        public w create(com.google.gson.d dVar, TypeToken typeToken) {
            a aVar = null;
            if (typeToken.getRawType() != Timestamp.class) {
                return null;
            }
            return new c(dVar.m(Date.class), aVar);
        }
    }

    /* synthetic */ c(w wVar, a aVar) {
        this(wVar);
    }

    @Override // com.google.gson.w
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Timestamp read(JsonReader jsonReader) {
        Date date = (Date) this.f١٨٢٦٩a.read(jsonReader);
        if (date != null) {
            return new Timestamp(date.getTime());
        }
        return null;
    }

    @Override // com.google.gson.w
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void write(JsonWriter jsonWriter, Timestamp timestamp) {
        this.f١٨٢٦٩a.write(jsonWriter, timestamp);
    }

    private c(w wVar) {
        this.f١٨٢٦٩a = wVar;
    }
}
