package u8;

import com.google.gson.r;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.google.gson.w;
import com.google.gson.x;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
final class b extends w {

    /* renamed from: b, reason: collision with root package name */
    static final x f١٨٢٦٦b = new a();

    /* renamed from: a, reason: collision with root package name */
    private final DateFormat f١٨٢٦٧a;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class a implements x {
        a() {
        }

        @Override // com.google.gson.x
        public w create(com.google.gson.d dVar, TypeToken typeToken) {
            a aVar = null;
            if (typeToken.getRawType() != Time.class) {
                return null;
            }
            return new b(aVar);
        }
    }

    /* synthetic */ b(a aVar) {
        this();
    }

    @Override // com.google.gson.w
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Time read(JsonReader jsonReader) {
        Time time;
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        String nextString = jsonReader.nextString();
        try {
            synchronized (this) {
                time = new Time(this.f١٨٢٦٧a.parse(nextString).getTime());
            }
            return time;
        } catch (ParseException e10) {
            throw new r("Failed parsing '" + nextString + "' as SQL Time; at path " + jsonReader.getPreviousPath(), e10);
        }
    }

    @Override // com.google.gson.w
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void write(JsonWriter jsonWriter, Time time) {
        String format;
        if (time == null) {
            jsonWriter.nullValue();
            return;
        }
        synchronized (this) {
            format = this.f١٨٢٦٧a.format((Date) time);
        }
        jsonWriter.value(format);
    }

    private b() {
        this.f١٨٢٦٧a = new SimpleDateFormat("hh:mm:ss a");
    }
}
