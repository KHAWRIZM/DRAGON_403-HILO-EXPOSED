package q8;

import androidx.appcompat.app.a0;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.google.gson.w;
import com.google.gson.x;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class d implements x, Cloneable {

    /* renamed from: g, reason: collision with root package name */
    public static final d f١٧١٩٧g = new d();

    /* renamed from: d, reason: collision with root package name */
    private boolean f١٧٢٠١d;

    /* renamed from: a, reason: collision with root package name */
    private double f١٧١٩٨a = -1.0d;

    /* renamed from: b, reason: collision with root package name */
    private int f١٧١٩٩b = 136;

    /* renamed from: c, reason: collision with root package name */
    private boolean f١٧٢٠٠c = true;

    /* renamed from: e, reason: collision with root package name */
    private List f١٧٢٠٢e = Collections.emptyList();

    /* renamed from: f, reason: collision with root package name */
    private List f١٧٢٠٣f = Collections.emptyList();

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class a extends w {

        /* renamed from: a, reason: collision with root package name */
        private w f١٧٢٠٤a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f١٧٢٠٥b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f١٧٢٠٦c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.google.gson.d f١٧٢٠٧d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ TypeToken f١٧٢٠٨e;

        a(boolean z10, boolean z11, com.google.gson.d dVar, TypeToken typeToken) {
            this.f١٧٢٠٥b = z10;
            this.f١٧٢٠٦c = z11;
            this.f١٧٢٠٧d = dVar;
            this.f١٧٢٠٨e = typeToken;
        }

        private w a() {
            w wVar = this.f١٧٢٠٤a;
            if (wVar == null) {
                w n10 = this.f١٧٢٠٧d.n(d.this, this.f١٧٢٠٨e);
                this.f١٧٢٠٤a = n10;
                return n10;
            }
            return wVar;
        }

        @Override // com.google.gson.w
        public Object read(JsonReader jsonReader) {
            if (this.f١٧٢٠٥b) {
                jsonReader.skipValue();
                return null;
            }
            return a().read(jsonReader);
        }

        @Override // com.google.gson.w
        public void write(JsonWriter jsonWriter, Object obj) {
            if (this.f١٧٢٠٦c) {
                jsonWriter.nullValue();
            } else {
                a().write(jsonWriter, obj);
            }
        }
    }

    private boolean c(Class cls) {
        if (this.f١٧١٩٨a != -1.0d && !k((p8.d) cls.getAnnotation(p8.d.class), (p8.e) cls.getAnnotation(p8.e.class))) {
            return true;
        }
        if (!this.f١٧٢٠٠c && g(cls)) {
            return true;
        }
        return f(cls);
    }

    private boolean d(Class cls, boolean z10) {
        List list;
        if (z10) {
            list = this.f١٧٢٠٢e;
        } else {
            list = this.f١٧٢٠٣f;
        }
        Iterator it = list.iterator();
        if (!it.hasNext()) {
            return false;
        }
        a0.a(it.next());
        throw null;
    }

    private boolean f(Class cls) {
        if (!Enum.class.isAssignableFrom(cls) && !h(cls) && (cls.isAnonymousClass() || cls.isLocalClass())) {
            return true;
        }
        return false;
    }

    private boolean g(Class cls) {
        if (cls.isMemberClass() && !h(cls)) {
            return true;
        }
        return false;
    }

    private boolean h(Class cls) {
        if ((cls.getModifiers() & 8) != 0) {
            return true;
        }
        return false;
    }

    private boolean i(p8.d dVar) {
        if (dVar == null) {
            return true;
        }
        if (this.f١٧١٩٨a >= dVar.value()) {
            return true;
        }
        return false;
    }

    private boolean j(p8.e eVar) {
        if (eVar == null) {
            return true;
        }
        if (this.f١٧١٩٨a < eVar.value()) {
            return true;
        }
        return false;
    }

    private boolean k(p8.d dVar, p8.e eVar) {
        if (i(dVar) && j(eVar)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public d clone() {
        try {
            return (d) super.clone();
        } catch (CloneNotSupportedException e10) {
            throw new AssertionError(e10);
        }
    }

    public boolean b(Class cls, boolean z10) {
        if (!c(cls) && !d(cls, z10)) {
            return false;
        }
        return true;
    }

    @Override // com.google.gson.x
    public w create(com.google.gson.d dVar, TypeToken typeToken) {
        boolean z10;
        boolean z11;
        Class rawType = typeToken.getRawType();
        boolean c10 = c(rawType);
        if (!c10 && !d(rawType, true)) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (!c10 && !d(rawType, false)) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (!z10 && !z11) {
            return null;
        }
        return new a(z11, z10, dVar, typeToken);
    }

    public boolean e(Field field, boolean z10) {
        List list;
        p8.a aVar;
        if ((this.f١٧١٩٩b & field.getModifiers()) != 0) {
            return true;
        }
        if ((this.f١٧١٩٨a != -1.0d && !k((p8.d) field.getAnnotation(p8.d.class), (p8.e) field.getAnnotation(p8.e.class))) || field.isSynthetic()) {
            return true;
        }
        if (this.f١٧٢٠١d && ((aVar = (p8.a) field.getAnnotation(p8.a.class)) == null || (!z10 ? !aVar.deserialize() : !aVar.serialize()))) {
            return true;
        }
        if ((!this.f١٧٢٠٠c && g(field.getType())) || f(field.getType())) {
            return true;
        }
        if (z10) {
            list = this.f١٧٢٠٢e;
        } else {
            list = this.f١٧٢٠٣f;
        }
        if (!list.isEmpty()) {
            new com.google.gson.a(field);
            Iterator it = list.iterator();
            if (it.hasNext()) {
                a0.a(it.next());
                throw null;
            }
            return false;
        }
        return false;
    }
}
