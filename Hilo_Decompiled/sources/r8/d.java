package r8;

import com.google.gson.r;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.google.gson.w;
import com.google.gson.x;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class d extends w {

    /* renamed from: a, reason: collision with root package name */
    private final b f١٧٣٧٤a;

    /* renamed from: b, reason: collision with root package name */
    private final List f١٧٣٧٥b;

    private Date a(JsonReader jsonReader) {
        String nextString = jsonReader.nextString();
        synchronized (this.f١٧٣٧٥b) {
            try {
                Iterator it = this.f١٧٣٧٥b.iterator();
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
        return this.f١٧٣٧٤a.d(a(jsonReader));
    }

    @Override // com.google.gson.w
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void write(JsonWriter jsonWriter, Date date) {
        String format;
        if (date == null) {
            jsonWriter.nullValue();
            return;
        }
        DateFormat dateFormat = (DateFormat) this.f١٧٣٧٥b.get(0);
        synchronized (this.f١٧٣٧٥b) {
            format = dateFormat.format(date);
        }
        jsonWriter.value(format);
    }

    public String toString() {
        DateFormat dateFormat = (DateFormat) this.f١٧٣٧٥b.get(0);
        if (dateFormat instanceof SimpleDateFormat) {
            return "DefaultDateTypeAdapter(" + ((SimpleDateFormat) dateFormat).toPattern() + ')';
        }
        return "DefaultDateTypeAdapter(" + dateFormat.getClass().getSimpleName() + ')';
    }

    private d(b bVar, String str) {
        ArrayList arrayList = new ArrayList();
        this.f١٧٣٧٥b = arrayList;
        Objects.requireNonNull(bVar);
        this.f١٧٣٧٤a = bVar;
        Locale locale = Locale.US;
        arrayList.add(new SimpleDateFormat(str, locale));
        if (Locale.getDefault().equals(locale)) {
            return;
        }
        arrayList.add(new SimpleDateFormat(str));
    }

    private d(b bVar, int i10, int i11) {
        ArrayList arrayList = new ArrayList();
        this.f١٧٣٧٥b = arrayList;
        Objects.requireNonNull(bVar);
        this.f١٧٣٧٤a = bVar;
        Locale locale = Locale.US;
        arrayList.add(DateFormat.getDateTimeInstance(i10, i11, locale));
        if (!Locale.getDefault().equals(locale)) {
            arrayList.add(DateFormat.getDateTimeInstance(i10, i11));
        }
        if (q8.e.d()) {
            arrayList.add(q8.j.c(i10, i11));
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static abstract class b {

        /* renamed from: b, reason: collision with root package name */
        public static final b f١٧٣٧٦b = new a(Date.class);

        /* renamed from: a, reason: collision with root package name */
        private final Class f١٧٣٧٧a;

        /* JADX INFO: Access modifiers changed from: protected */
        public b(Class cls) {
            this.f١٧٣٧٧a = cls;
        }

        private x c(d dVar) {
            return o.a(this.f١٧٣٧٧a, dVar);
        }

        public final x a(int i10, int i11) {
            return c(new d(this, i10, i11));
        }

        public final x b(String str) {
            return c(new d(this, str));
        }

        protected abstract Date d(Date date);

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        class a extends b {
            a(Class cls) {
                super(cls);
            }

            @Override // r8.d.b
            protected Date d(Date date) {
                return date;
            }
        }
    }
}
