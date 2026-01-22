package u8;

import com.google.gson.r;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.google.gson.w;
import com.google.gson.x;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
final class a extends w {

    /* renamed from: b, reason: collision with root package name */
    static final x f١٨٢٦٤b = new C٠٢٣٦a();

    /* renamed from: a, reason: collision with root package name */
    private final DateFormat f١٨٢٦٥a;

    /* renamed from: u8.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class C٠٢٣٦a implements x {
        C٠٢٣٦a() {
        }

        @Override // com.google.gson.x
        public w create(com.google.gson.d dVar, TypeToken typeToken) {
            C٠٢٣٦a r02 = null;
            if (typeToken.getRawType() != Date.class) {
                return null;
            }
            return new a(r02);
        }
    }

    /* synthetic */ a(C٠٢٣٦a r12) {
        this();
    }

    @Override // com.google.gson.w
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Date read(JsonReader jsonReader) {
        java.util.Date parse;
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        String nextString = jsonReader.nextString();
        try {
            synchronized (this) {
                parse = this.f١٨٢٦٥a.parse(nextString);
            }
            return new Date(parse.getTime());
        } catch (ParseException e10) {
            throw new r("Failed parsing '" + nextString + "' as SQL Date; at path " + jsonReader.getPreviousPath(), e10);
        }
    }

    @Override // com.google.gson.w
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void write(JsonWriter jsonWriter, Date date) {
        String format;
        if (date == null) {
            jsonWriter.nullValue();
            return;
        }
        synchronized (this) {
            format = this.f١٨٢٦٥a.format((java.util.Date) date);
        }
        jsonWriter.value(format);
    }

    private a() {
        this.f١٨٢٦٥a = new SimpleDateFormat("MMM d, yyyy");
    }
}
