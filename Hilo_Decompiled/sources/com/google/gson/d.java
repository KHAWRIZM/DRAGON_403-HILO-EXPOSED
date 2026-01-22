package com.google.gson;

import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.google.gson.stream.MalformedJsonException;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class d {
    static final com.google.gson.c A = com.google.gson.b.f١٠٧٨٥a;

    /* renamed from: B, reason: collision with root package name */
    static final v f١٠٧٩٣B = u.f١٠٨٥٧a;
    static final v C = u.f١٠٨٥٨b;

    /* renamed from: z, reason: collision with root package name */
    static final String f١٠٧٩٤z = null;

    /* renamed from: a, reason: collision with root package name */
    private final ThreadLocal f١٠٧٩٥a;

    /* renamed from: b, reason: collision with root package name */
    private final ConcurrentMap f١٠٧٩٦b;

    /* renamed from: c, reason: collision with root package name */
    private final q8.c f١٠٧٩٧c;

    /* renamed from: d, reason: collision with root package name */
    private final r8.e f١٠٧٩٨d;

    /* renamed from: e, reason: collision with root package name */
    final List f١٠٧٩٩e;

    /* renamed from: f, reason: collision with root package name */
    final q8.d f١٠٨٠٠f;

    /* renamed from: g, reason: collision with root package name */
    final com.google.gson.c f١٠٨٠١g;

    /* renamed from: h, reason: collision with root package name */
    final Map f١٠٨٠٢h;

    /* renamed from: i, reason: collision with root package name */
    final boolean f١٠٨٠٣i;

    /* renamed from: j, reason: collision with root package name */
    final boolean f١٠٨٠٤j;

    /* renamed from: k, reason: collision with root package name */
    final boolean f١٠٨٠٥k;

    /* renamed from: l, reason: collision with root package name */
    final boolean f١٠٨٠٦l;

    /* renamed from: m, reason: collision with root package name */
    final boolean f١٠٨٠٧m;

    /* renamed from: n, reason: collision with root package name */
    final boolean f١٠٨٠٨n;

    /* renamed from: o, reason: collision with root package name */
    final boolean f١٠٨٠٩o;

    /* renamed from: p, reason: collision with root package name */
    final boolean f١٠٨١٠p;

    /* renamed from: q, reason: collision with root package name */
    final String f١٠٨١١q;

    /* renamed from: r, reason: collision with root package name */
    final int f١٠٨١٢r;

    /* renamed from: s, reason: collision with root package name */
    final int f١٠٨١٣s;

    /* renamed from: t, reason: collision with root package name */
    final s f١٠٨١٤t;

    /* renamed from: u, reason: collision with root package name */
    final List f١٠٨١٥u;

    /* renamed from: v, reason: collision with root package name */
    final List f١٠٨١٦v;

    /* renamed from: w, reason: collision with root package name */
    final v f١٠٨١٧w;

    /* renamed from: x, reason: collision with root package name */
    final v f١٠٨١٨x;

    /* renamed from: y, reason: collision with root package name */
    final List f١٠٨١٩y;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class a extends w {
        a() {
        }

        @Override // com.google.gson.w
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Double read(JsonReader jsonReader) {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            return Double.valueOf(jsonReader.nextDouble());
        }

        @Override // com.google.gson.w
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void write(JsonWriter jsonWriter, Number number) {
            if (number == null) {
                jsonWriter.nullValue();
                return;
            }
            double doubleValue = number.doubleValue();
            d.d(doubleValue);
            jsonWriter.value(doubleValue);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class b extends w {
        b() {
        }

        @Override // com.google.gson.w
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float read(JsonReader jsonReader) {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            return Float.valueOf((float) jsonReader.nextDouble());
        }

        @Override // com.google.gson.w
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void write(JsonWriter jsonWriter, Number number) {
            if (number == null) {
                jsonWriter.nullValue();
                return;
            }
            float floatValue = number.floatValue();
            d.d(floatValue);
            if (!(number instanceof Float)) {
                number = Float.valueOf(floatValue);
            }
            jsonWriter.value(number);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class c extends w {
        c() {
        }

        @Override // com.google.gson.w
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Number read(JsonReader jsonReader) {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            return Long.valueOf(jsonReader.nextLong());
        }

        @Override // com.google.gson.w
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void write(JsonWriter jsonWriter, Number number) {
            if (number == null) {
                jsonWriter.nullValue();
            } else {
                jsonWriter.value(number.toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.gson.d$d, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class C٠١٣١d extends w {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ w f١٠٨٢٢a;

        C٠١٣١d(w wVar) {
            this.f١٠٨٢٢a = wVar;
        }

        @Override // com.google.gson.w
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AtomicLong read(JsonReader jsonReader) {
            return new AtomicLong(((Number) this.f١٠٨٢٢a.read(jsonReader)).longValue());
        }

        @Override // com.google.gson.w
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void write(JsonWriter jsonWriter, AtomicLong atomicLong) {
            this.f١٠٨٢٢a.write(jsonWriter, Long.valueOf(atomicLong.get()));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class e extends w {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ w f١٠٨٢٣a;

        e(w wVar) {
            this.f١٠٨٢٣a = wVar;
        }

        @Override // com.google.gson.w
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AtomicLongArray read(JsonReader jsonReader) {
            ArrayList arrayList = new ArrayList();
            jsonReader.beginArray();
            while (jsonReader.hasNext()) {
                arrayList.add(Long.valueOf(((Number) this.f١٠٨٢٣a.read(jsonReader)).longValue()));
            }
            jsonReader.endArray();
            int size = arrayList.size();
            AtomicLongArray atomicLongArray = new AtomicLongArray(size);
            for (int i10 = 0; i10 < size; i10++) {
                atomicLongArray.set(i10, ((Long) arrayList.get(i10)).longValue());
            }
            return atomicLongArray;
        }

        @Override // com.google.gson.w
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void write(JsonWriter jsonWriter, AtomicLongArray atomicLongArray) {
            jsonWriter.beginArray();
            int length = atomicLongArray.length();
            for (int i10 = 0; i10 < length; i10++) {
                this.f١٠٨٢٣a.write(jsonWriter, Long.valueOf(atomicLongArray.get(i10)));
            }
            jsonWriter.endArray();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class f extends r8.l {

        /* renamed from: a, reason: collision with root package name */
        private w f١٠٨٢٤a = null;

        f() {
        }

        private w b() {
            w wVar = this.f١٠٨٢٤a;
            if (wVar != null) {
                return wVar;
            }
            throw new IllegalStateException("Adapter for type with cyclic dependency has been used before dependency has been resolved");
        }

        @Override // r8.l
        public w a() {
            return b();
        }

        public void c(w wVar) {
            if (this.f١٠٨٢٤a == null) {
                this.f١٠٨٢٤a = wVar;
                return;
            }
            throw new AssertionError("Delegate is already set");
        }

        @Override // com.google.gson.w
        public Object read(JsonReader jsonReader) {
            return b().read(jsonReader);
        }

        @Override // com.google.gson.w
        public void write(JsonWriter jsonWriter, Object obj) {
            b().write(jsonWriter, obj);
        }
    }

    public d() {
        this(q8.d.f١٧١٩٧g, A, Collections.emptyMap(), false, false, false, true, false, false, false, true, s.f١٠٨٤٩a, f١٠٧٩٤z, 2, 2, Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), f١٠٧٩٣B, C, Collections.emptyList());
    }

    private static void a(Object obj, JsonReader jsonReader) {
        if (obj != null) {
            try {
                if (jsonReader.peek() != JsonToken.END_DOCUMENT) {
                    throw new r("JSON document was not fully consumed.");
                }
            } catch (MalformedJsonException e10) {
                throw new r(e10);
            } catch (IOException e11) {
                throw new j(e11);
            }
        }
    }

    private static w b(w wVar) {
        return new C٠١٣١d(wVar).nullSafe();
    }

    private static w c(w wVar) {
        return new e(wVar).nullSafe();
    }

    static void d(double d10) {
        if (!Double.isNaN(d10) && !Double.isInfinite(d10)) {
            return;
        }
        throw new IllegalArgumentException(d10 + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
    }

    private w e(boolean z10) {
        if (z10) {
            return r8.o.f١٧٤٦٥v;
        }
        return new a();
    }

    private w f(boolean z10) {
        if (z10) {
            return r8.o.f١٧٤٦٤u;
        }
        return new b();
    }

    private static w o(s sVar) {
        if (sVar == s.f١٠٨٤٩a) {
            return r8.o.f١٧٤٦٣t;
        }
        return new c();
    }

    public Object g(JsonReader jsonReader, TypeToken typeToken) {
        boolean isLenient = jsonReader.isLenient();
        boolean z10 = true;
        jsonReader.setLenient(true);
        try {
            try {
                try {
                    jsonReader.peek();
                    z10 = false;
                    return l(typeToken).read(jsonReader);
                } catch (AssertionError e10) {
                    throw new AssertionError("AssertionError (GSON 2.10.1): " + e10.getMessage(), e10);
                } catch (IllegalStateException e11) {
                    throw new r(e11);
                }
            } catch (EOFException e12) {
                if (z10) {
                    jsonReader.setLenient(isLenient);
                    return null;
                }
                throw new r(e12);
            } catch (IOException e13) {
                throw new r(e13);
            }
        } finally {
            jsonReader.setLenient(isLenient);
        }
    }

    public Object h(Reader reader, TypeToken typeToken) {
        JsonReader p10 = p(reader);
        Object g10 = g(p10, typeToken);
        a(g10, p10);
        return g10;
    }

    public Object i(String str, TypeToken typeToken) {
        if (str == null) {
            return null;
        }
        return h(new StringReader(str), typeToken);
    }

    public Object j(String str, Class cls) {
        return q8.k.b(cls).cast(i(str, TypeToken.get(cls)));
    }

    public Object k(String str, Type type) {
        return i(str, TypeToken.get(type));
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0051, code lost:
    
        r2.c(r4);
        r0.put(r7, r4);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public w l(TypeToken typeToken) {
        boolean z10;
        Objects.requireNonNull(typeToken, "type must not be null");
        w wVar = (w) this.f١٠٧٩٦b.get(typeToken);
        if (wVar != null) {
            return wVar;
        }
        Map map = (Map) this.f١٠٧٩٥a.get();
        if (map == null) {
            map = new HashMap();
            this.f١٠٧٩٥a.set(map);
            z10 = true;
        } else {
            w wVar2 = (w) map.get(typeToken);
            if (wVar2 != null) {
                return wVar2;
            }
            z10 = false;
        }
        try {
            f fVar = new f();
            map.put(typeToken, fVar);
            Iterator it = this.f١٠٧٩٩e.iterator();
            w wVar3 = null;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                wVar3 = ((x) it.next()).create(this, typeToken);
                if (wVar3 != null) {
                    break;
                }
            }
            if (wVar3 != null) {
                if (z10) {
                    this.f١٠٧٩٦b.putAll(map);
                }
                return wVar3;
            }
            throw new IllegalArgumentException("GSON (2.10.1) cannot handle " + typeToken);
        } finally {
            if (z10) {
                this.f١٠٧٩٥a.remove();
            }
        }
    }

    public w m(Class cls) {
        return l(TypeToken.get(cls));
    }

    public w n(x xVar, TypeToken typeToken) {
        if (!this.f١٠٧٩٩e.contains(xVar)) {
            xVar = this.f١٠٧٩٨d;
        }
        boolean z10 = false;
        for (x xVar2 : this.f١٠٧٩٩e) {
            if (!z10) {
                if (xVar2 == xVar) {
                    z10 = true;
                }
            } else {
                w create = xVar2.create(this, typeToken);
                if (create != null) {
                    return create;
                }
            }
        }
        throw new IllegalArgumentException("GSON cannot serialize " + typeToken);
    }

    public JsonReader p(Reader reader) {
        JsonReader jsonReader = new JsonReader(reader);
        jsonReader.setLenient(this.f١٠٨٠٨n);
        return jsonReader;
    }

    public JsonWriter q(Writer writer) {
        if (this.f١٠٨٠٥k) {
            writer.write(")]}'\n");
        }
        JsonWriter jsonWriter = new JsonWriter(writer);
        if (this.f١٠٨٠٧m) {
            jsonWriter.setIndent("  ");
        }
        jsonWriter.setHtmlSafe(this.f١٠٨٠٦l);
        jsonWriter.setLenient(this.f١٠٨٠٨n);
        jsonWriter.setSerializeNulls(this.f١٠٨٠٣i);
        return jsonWriter;
    }

    public String r(i iVar) {
        StringWriter stringWriter = new StringWriter();
        v(iVar, stringWriter);
        return stringWriter.toString();
    }

    public String s(Object obj) {
        if (obj == null) {
            return r(k.f١٠٨٤٦a);
        }
        return t(obj, obj.getClass());
    }

    public String t(Object obj, Type type) {
        StringWriter stringWriter = new StringWriter();
        x(obj, type, stringWriter);
        return stringWriter.toString();
    }

    public String toString() {
        return "{serializeNulls:" + this.f١٠٨٠٣i + ",factories:" + this.f١٠٧٩٩e + ",instanceCreators:" + this.f١٠٧٩٧c + "}";
    }

    public void u(i iVar, JsonWriter jsonWriter) {
        boolean isLenient = jsonWriter.isLenient();
        jsonWriter.setLenient(true);
        boolean isHtmlSafe = jsonWriter.isHtmlSafe();
        jsonWriter.setHtmlSafe(this.f١٠٨٠٦l);
        boolean serializeNulls = jsonWriter.getSerializeNulls();
        jsonWriter.setSerializeNulls(this.f١٠٨٠٣i);
        try {
            try {
                q8.m.b(iVar, jsonWriter);
            } catch (IOException e10) {
                throw new j(e10);
            } catch (AssertionError e11) {
                throw new AssertionError("AssertionError (GSON 2.10.1): " + e11.getMessage(), e11);
            }
        } finally {
            jsonWriter.setLenient(isLenient);
            jsonWriter.setHtmlSafe(isHtmlSafe);
            jsonWriter.setSerializeNulls(serializeNulls);
        }
    }

    public void v(i iVar, Appendable appendable) {
        try {
            u(iVar, q(q8.m.c(appendable)));
        } catch (IOException e10) {
            throw new j(e10);
        }
    }

    public void w(Object obj, Type type, JsonWriter jsonWriter) {
        w l10 = l(TypeToken.get(type));
        boolean isLenient = jsonWriter.isLenient();
        jsonWriter.setLenient(true);
        boolean isHtmlSafe = jsonWriter.isHtmlSafe();
        jsonWriter.setHtmlSafe(this.f١٠٨٠٦l);
        boolean serializeNulls = jsonWriter.getSerializeNulls();
        jsonWriter.setSerializeNulls(this.f١٠٨٠٣i);
        try {
            try {
                l10.write(jsonWriter, obj);
            } catch (IOException e10) {
                throw new j(e10);
            } catch (AssertionError e11) {
                throw new AssertionError("AssertionError (GSON 2.10.1): " + e11.getMessage(), e11);
            }
        } finally {
            jsonWriter.setLenient(isLenient);
            jsonWriter.setHtmlSafe(isHtmlSafe);
            jsonWriter.setSerializeNulls(serializeNulls);
        }
    }

    public void x(Object obj, Type type, Appendable appendable) {
        try {
            w(obj, type, q(q8.m.c(appendable)));
        } catch (IOException e10) {
            throw new j(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(q8.d dVar, com.google.gson.c cVar, Map map, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16, boolean z17, s sVar, String str, int i10, int i11, List list, List list2, List list3, v vVar, v vVar2, List list4) {
        this.f١٠٧٩٥a = new ThreadLocal();
        this.f١٠٧٩٦b = new ConcurrentHashMap();
        this.f١٠٨٠٠f = dVar;
        this.f١٠٨٠١g = cVar;
        this.f١٠٨٠٢h = map;
        q8.c cVar2 = new q8.c(map, z17, list4);
        this.f١٠٧٩٧c = cVar2;
        this.f١٠٨٠٣i = z10;
        this.f١٠٨٠٤j = z11;
        this.f١٠٨٠٥k = z12;
        this.f١٠٨٠٦l = z13;
        this.f١٠٨٠٧m = z14;
        this.f١٠٨٠٨n = z15;
        this.f١٠٨٠٩o = z16;
        this.f١٠٨١٠p = z17;
        this.f١٠٨١٤t = sVar;
        this.f١٠٨١١q = str;
        this.f١٠٨١٢r = i10;
        this.f١٠٨١٣s = i11;
        this.f١٠٨١٥u = list;
        this.f١٠٨١٦v = list2;
        this.f١٠٨١٧w = vVar;
        this.f١٠٨١٨x = vVar2;
        this.f١٠٨١٩y = list4;
        ArrayList arrayList = new ArrayList();
        arrayList.add(r8.o.W);
        arrayList.add(r8.j.a(vVar));
        arrayList.add(dVar);
        arrayList.addAll(list3);
        arrayList.add(r8.o.C);
        arrayList.add(r8.o.f١٧٤٥٦m);
        arrayList.add(r8.o.f١٧٤٥٠g);
        arrayList.add(r8.o.f١٧٤٥٢i);
        arrayList.add(r8.o.f١٧٤٥٤k);
        w o10 = o(sVar);
        arrayList.add(r8.o.b(Long.TYPE, Long.class, o10));
        arrayList.add(r8.o.b(Double.TYPE, Double.class, e(z16)));
        arrayList.add(r8.o.b(Float.TYPE, Float.class, f(z16)));
        arrayList.add(r8.i.a(vVar2));
        arrayList.add(r8.o.f١٧٤٥٨o);
        arrayList.add(r8.o.f١٧٤٦٠q);
        arrayList.add(r8.o.a(AtomicLong.class, b(o10)));
        arrayList.add(r8.o.a(AtomicLongArray.class, c(o10)));
        arrayList.add(r8.o.f١٧٤٦٢s);
        arrayList.add(r8.o.f١٧٤٦٧x);
        arrayList.add(r8.o.E);
        arrayList.add(r8.o.G);
        arrayList.add(r8.o.a(BigDecimal.class, r8.o.f١٧٤٦٩z));
        arrayList.add(r8.o.a(BigInteger.class, r8.o.A));
        arrayList.add(r8.o.a(q8.g.class, r8.o.f١٧٤٤٣B));
        arrayList.add(r8.o.I);
        arrayList.add(r8.o.K);
        arrayList.add(r8.o.O);
        arrayList.add(r8.o.Q);
        arrayList.add(r8.o.U);
        arrayList.add(r8.o.M);
        arrayList.add(r8.o.f١٧٤٤٧d);
        arrayList.add(r8.c.f١٧٣٧٢b);
        arrayList.add(r8.o.S);
        if (u8.d.f١٨٢٧٠a) {
            arrayList.add(u8.d.f١٨٢٧٤e);
            arrayList.add(u8.d.f١٨٢٧٣d);
            arrayList.add(u8.d.f١٨٢٧٥f);
        }
        arrayList.add(r8.a.f١٧٣٦٦c);
        arrayList.add(r8.o.f١٧٤٤٥b);
        arrayList.add(new r8.b(cVar2));
        arrayList.add(new r8.h(cVar2, z11));
        r8.e eVar = new r8.e(cVar2);
        this.f١٠٧٩٨d = eVar;
        arrayList.add(eVar);
        arrayList.add(r8.o.X);
        arrayList.add(new r8.k(cVar2, cVar, dVar, eVar, list4));
        this.f١٠٧٩٩e = Collections.unmodifiableList(arrayList);
    }
}
