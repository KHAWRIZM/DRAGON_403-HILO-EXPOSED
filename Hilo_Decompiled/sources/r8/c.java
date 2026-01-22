package r8;

import com.google.gson.r;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.google.gson.w;
import com.google.gson.x;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class c extends w {

    /* renamed from: b, reason: collision with root package name */
    public static final x f١٧٣٧٢b = new a();

    /* renamed from: a, reason: collision with root package name */
    private final List f١٧٣٧٣a;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class a implements x {
        a() {
        }

        @Override // com.google.gson.x
        public w create(com.google.gson.d dVar, TypeToken typeToken) {
            if (typeToken.getRawType() == Date.class) {
                return new c();
            }
            return null;
        }
    }

    public c() {
        ArrayList arrayList = new ArrayList();
        this.f١٧٣٧٣a = arrayList;
        Locale locale = Locale.US;
        arrayList.add(DateFormat.getDateTimeInstance(2, 2, locale));
        if (!Locale.getDefault().equals(locale)) {
            arrayList.add(DateFormat.getDateTimeInstance(2, 2));
        }
        if (q8.e.d()) {
            arrayList.add(q8.j.c(2, 2));
        }
    }

    private Date a(JsonReader jsonReader) {
        String nextString = jsonReader.nextString();
        synchronized (this.f١٧٣٧٣a) {
            try {
                Iterator it = this.f١٧٣٧٣a.iterator();
                while (it.hasNext()) {
                    try {
                        return ((DateFormat) it.next()).parse(nextString);
                    } catch (ParseException unused) {
                    }
                }
                try {
                    return s8.a.c(nextString, new ParsePosition(0));
                } catch (ParseException e10) {
                    throw new r("Failed parsing '" + nextString + "' as Date; at path " + jsonReader.getPreviousPath(), e10);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.gson.w
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Date read(JsonReader jsonReader) {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        return a(jsonReader);
    }

    @Override // com.google.gson.w
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void write(JsonWriter jsonWriter, Date date) {
        String format;
        if (date == null) {
            jsonWriter.nullValue();
            return;
        }
        DateFormat dateFormat = (DateFormat) this.f١٧٣٧٣a.get(0);
        synchronized (this.f١٧٣٧٣a) {
            format = dateFormat.format(date);
        }
        jsonWriter.value(format);
    }
}
