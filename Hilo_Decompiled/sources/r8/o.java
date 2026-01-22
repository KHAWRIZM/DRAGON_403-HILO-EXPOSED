package r8;

import com.amazonaws.services.s3.internal.Constants;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Currency;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class o {
    public static final com.google.gson.w A;

    /* renamed from: B, reason: collision with root package name */
    public static final com.google.gson.w f١٧٤٤٣B;
    public static final com.google.gson.x C;
    public static final com.google.gson.w D;
    public static final com.google.gson.x E;
    public static final com.google.gson.w F;
    public static final com.google.gson.x G;
    public static final com.google.gson.w H;
    public static final com.google.gson.x I;
    public static final com.google.gson.w J;
    public static final com.google.gson.x K;
    public static final com.google.gson.w L;
    public static final com.google.gson.x M;
    public static final com.google.gson.w N;
    public static final com.google.gson.x O;
    public static final com.google.gson.w P;
    public static final com.google.gson.x Q;
    public static final com.google.gson.w R;
    public static final com.google.gson.x S;
    public static final com.google.gson.w T;
    public static final com.google.gson.x U;
    public static final com.google.gson.w V;
    public static final com.google.gson.x W;
    public static final com.google.gson.x X;

    /* renamed from: a, reason: collision with root package name */
    public static final com.google.gson.w f١٧٤٤٤a;

    /* renamed from: b, reason: collision with root package name */
    public static final com.google.gson.x f١٧٤٤٥b;

    /* renamed from: c, reason: collision with root package name */
    public static final com.google.gson.w f١٧٤٤٦c;

    /* renamed from: d, reason: collision with root package name */
    public static final com.google.gson.x f١٧٤٤٧d;

    /* renamed from: e, reason: collision with root package name */
    public static final com.google.gson.w f١٧٤٤٨e;

    /* renamed from: f, reason: collision with root package name */
    public static final com.google.gson.w f١٧٤٤٩f;

    /* renamed from: g, reason: collision with root package name */
    public static final com.google.gson.x f١٧٤٥٠g;

    /* renamed from: h, reason: collision with root package name */
    public static final com.google.gson.w f١٧٤٥١h;

    /* renamed from: i, reason: collision with root package name */
    public static final com.google.gson.x f١٧٤٥٢i;

    /* renamed from: j, reason: collision with root package name */
    public static final com.google.gson.w f١٧٤٥٣j;

    /* renamed from: k, reason: collision with root package name */
    public static final com.google.gson.x f١٧٤٥٤k;

    /* renamed from: l, reason: collision with root package name */
    public static final com.google.gson.w f١٧٤٥٥l;

    /* renamed from: m, reason: collision with root package name */
    public static final com.google.gson.x f١٧٤٥٦m;

    /* renamed from: n, reason: collision with root package name */
    public static final com.google.gson.w f١٧٤٥٧n;

    /* renamed from: o, reason: collision with root package name */
    public static final com.google.gson.x f١٧٤٥٨o;

    /* renamed from: p, reason: collision with root package name */
    public static final com.google.gson.w f١٧٤٥٩p;

    /* renamed from: q, reason: collision with root package name */
    public static final com.google.gson.x f١٧٤٦٠q;

    /* renamed from: r, reason: collision with root package name */
    public static final com.google.gson.w f١٧٤٦١r;

    /* renamed from: s, reason: collision with root package name */
    public static final com.google.gson.x f١٧٤٦٢s;

    /* renamed from: t, reason: collision with root package name */
    public static final com.google.gson.w f١٧٤٦٣t;

    /* renamed from: u, reason: collision with root package name */
    public static final com.google.gson.w f١٧٤٦٤u;

    /* renamed from: v, reason: collision with root package name */
    public static final com.google.gson.w f١٧٤٦٥v;

    /* renamed from: w, reason: collision with root package name */
    public static final com.google.gson.w f١٧٤٦٦w;

    /* renamed from: x, reason: collision with root package name */
    public static final com.google.gson.x f١٧٤٦٧x;

    /* renamed from: y, reason: collision with root package name */
    public static final com.google.gson.w f١٧٤٦٨y;

    /* renamed from: z, reason: collision with root package name */
    public static final com.google.gson.w f١٧٤٦٩z;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class a extends com.google.gson.w {
        a() {
        }

        @Override // com.google.gson.w
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AtomicIntegerArray read(JsonReader jsonReader) {
            ArrayList arrayList = new ArrayList();
            jsonReader.beginArray();
            while (jsonReader.hasNext()) {
                try {
                    arrayList.add(Integer.valueOf(jsonReader.nextInt()));
                } catch (NumberFormatException e10) {
                    throw new com.google.gson.r(e10);
                }
            }
            jsonReader.endArray();
            int size = arrayList.size();
            AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(size);
            for (int i10 = 0; i10 < size; i10++) {
                atomicIntegerArray.set(i10, ((Integer) arrayList.get(i10)).intValue());
            }
            return atomicIntegerArray;
        }

        @Override // com.google.gson.w
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void write(JsonWriter jsonWriter, AtomicIntegerArray atomicIntegerArray) {
            jsonWriter.beginArray();
            int length = atomicIntegerArray.length();
            for (int i10 = 0; i10 < length; i10++) {
                jsonWriter.value(atomicIntegerArray.get(i10));
            }
            jsonWriter.endArray();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static /* synthetic */ class a0 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f١٧٤٧٠a;

        static {
            int[] iArr = new int[JsonToken.values().length];
            f١٧٤٧٠a = iArr;
            try {
                iArr[JsonToken.NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f١٧٤٧٠a[JsonToken.STRING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f١٧٤٧٠a[JsonToken.BOOLEAN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f١٧٤٧٠a[JsonToken.BEGIN_ARRAY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f١٧٤٧٠a[JsonToken.BEGIN_OBJECT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f١٧٤٧٠a[JsonToken.NULL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class b extends com.google.gson.w {
        b() {
        }

        @Override // com.google.gson.w
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Number read(JsonReader jsonReader) {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            try {
                return Long.valueOf(jsonReader.nextLong());
            } catch (NumberFormatException e10) {
                throw new com.google.gson.r(e10);
            }
        }

        @Override // com.google.gson.w
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void write(JsonWriter jsonWriter, Number number) {
            if (number == null) {
                jsonWriter.nullValue();
            } else {
                jsonWriter.value(number.longValue());
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class b0 extends com.google.gson.w {
        b0() {
        }

        @Override // com.google.gson.w
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean read(JsonReader jsonReader) {
            JsonToken peek = jsonReader.peek();
            if (peek == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            if (peek == JsonToken.STRING) {
                return Boolean.valueOf(Boolean.parseBoolean(jsonReader.nextString()));
            }
            return Boolean.valueOf(jsonReader.nextBoolean());
        }

        @Override // com.google.gson.w
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void write(JsonWriter jsonWriter, Boolean bool) {
            jsonWriter.value(bool);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class c extends com.google.gson.w {
        c() {
        }

        @Override // com.google.gson.w
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Number read(JsonReader jsonReader) {
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
            if (!(number instanceof Float)) {
                number = Float.valueOf(number.floatValue());
            }
            jsonWriter.value(number);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class c0 extends com.google.gson.w {
        c0() {
        }

        @Override // com.google.gson.w
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean read(JsonReader jsonReader) {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            return Boolean.valueOf(jsonReader.nextString());
        }

        @Override // com.google.gson.w
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void write(JsonWriter jsonWriter, Boolean bool) {
            String bool2;
            if (bool == null) {
                bool2 = Constants.NULL_VERSION_ID;
            } else {
                bool2 = bool.toString();
            }
            jsonWriter.value(bool2);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class d extends com.google.gson.w {
        d() {
        }

        @Override // com.google.gson.w
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Number read(JsonReader jsonReader) {
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
            } else {
                jsonWriter.value(number.doubleValue());
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class d0 extends com.google.gson.w {
        d0() {
        }

        @Override // com.google.gson.w
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Number read(JsonReader jsonReader) {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            try {
                int nextInt = jsonReader.nextInt();
                if (nextInt <= 255 && nextInt >= -128) {
                    return Byte.valueOf((byte) nextInt);
                }
                throw new com.google.gson.r("Lossy conversion from " + nextInt + " to byte; at path " + jsonReader.getPreviousPath());
            } catch (NumberFormatException e10) {
                throw new com.google.gson.r(e10);
            }
        }

        @Override // com.google.gson.w
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void write(JsonWriter jsonWriter, Number number) {
            if (number == null) {
                jsonWriter.nullValue();
            } else {
                jsonWriter.value(number.byteValue());
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class e extends com.google.gson.w {
        e() {
        }

        @Override // com.google.gson.w
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Character read(JsonReader jsonReader) {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            String nextString = jsonReader.nextString();
            if (nextString.length() == 1) {
                return Character.valueOf(nextString.charAt(0));
            }
            throw new com.google.gson.r("Expecting character, got: " + nextString + "; at " + jsonReader.getPreviousPath());
        }

        @Override // com.google.gson.w
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void write(JsonWriter jsonWriter, Character ch) {
            String valueOf;
            if (ch == null) {
                valueOf = null;
            } else {
                valueOf = String.valueOf(ch);
            }
            jsonWriter.value(valueOf);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class e0 extends com.google.gson.w {
        e0() {
        }

        @Override // com.google.gson.w
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Number read(JsonReader jsonReader) {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            try {
                int nextInt = jsonReader.nextInt();
                if (nextInt <= 65535 && nextInt >= -32768) {
                    return Short.valueOf((short) nextInt);
                }
                throw new com.google.gson.r("Lossy conversion from " + nextInt + " to short; at path " + jsonReader.getPreviousPath());
            } catch (NumberFormatException e10) {
                throw new com.google.gson.r(e10);
            }
        }

        @Override // com.google.gson.w
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void write(JsonWriter jsonWriter, Number number) {
            if (number == null) {
                jsonWriter.nullValue();
            } else {
                jsonWriter.value(number.shortValue());
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class f extends com.google.gson.w {
        f() {
        }

        @Override // com.google.gson.w
        public String read(JsonReader jsonReader) {
            JsonToken peek = jsonReader.peek();
            if (peek == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            if (peek == JsonToken.BOOLEAN) {
                return Boolean.toString(jsonReader.nextBoolean());
            }
            return jsonReader.nextString();
        }

        @Override // com.google.gson.w
        public void write(JsonWriter jsonWriter, String str) {
            jsonWriter.value(str);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class f0 extends com.google.gson.w {
        f0() {
        }

        @Override // com.google.gson.w
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Number read(JsonReader jsonReader) {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            try {
                return Integer.valueOf(jsonReader.nextInt());
            } catch (NumberFormatException e10) {
                throw new com.google.gson.r(e10);
            }
        }

        @Override // com.google.gson.w
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void write(JsonWriter jsonWriter, Number number) {
            if (number == null) {
                jsonWriter.nullValue();
            } else {
                jsonWriter.value(number.intValue());
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class g extends com.google.gson.w {
        g() {
        }

        @Override // com.google.gson.w
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public BigDecimal read(JsonReader jsonReader) {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            String nextString = jsonReader.nextString();
            try {
                return new BigDecimal(nextString);
            } catch (NumberFormatException e10) {
                throw new com.google.gson.r("Failed parsing '" + nextString + "' as BigDecimal; at path " + jsonReader.getPreviousPath(), e10);
            }
        }

        @Override // com.google.gson.w
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void write(JsonWriter jsonWriter, BigDecimal bigDecimal) {
            jsonWriter.value(bigDecimal);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class g0 extends com.google.gson.w {
        g0() {
        }

        @Override // com.google.gson.w
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AtomicInteger read(JsonReader jsonReader) {
            try {
                return new AtomicInteger(jsonReader.nextInt());
            } catch (NumberFormatException e10) {
                throw new com.google.gson.r(e10);
            }
        }

        @Override // com.google.gson.w
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void write(JsonWriter jsonWriter, AtomicInteger atomicInteger) {
            jsonWriter.value(atomicInteger.get());
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class h extends com.google.gson.w {
        h() {
        }

        @Override // com.google.gson.w
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public BigInteger read(JsonReader jsonReader) {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            String nextString = jsonReader.nextString();
            try {
                return new BigInteger(nextString);
            } catch (NumberFormatException e10) {
                throw new com.google.gson.r("Failed parsing '" + nextString + "' as BigInteger; at path " + jsonReader.getPreviousPath(), e10);
            }
        }

        @Override // com.google.gson.w
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void write(JsonWriter jsonWriter, BigInteger bigInteger) {
            jsonWriter.value(bigInteger);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class h0 extends com.google.gson.w {
        h0() {
        }

        @Override // com.google.gson.w
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AtomicBoolean read(JsonReader jsonReader) {
            return new AtomicBoolean(jsonReader.nextBoolean());
        }

        @Override // com.google.gson.w
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void write(JsonWriter jsonWriter, AtomicBoolean atomicBoolean) {
            jsonWriter.value(atomicBoolean.get());
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class i extends com.google.gson.w {
        i() {
        }

        @Override // com.google.gson.w
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public q8.g read(JsonReader jsonReader) {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            return new q8.g(jsonReader.nextString());
        }

        @Override // com.google.gson.w
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void write(JsonWriter jsonWriter, q8.g gVar) {
            jsonWriter.value(gVar);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    private static final class i0 extends com.google.gson.w {

        /* renamed from: a, reason: collision with root package name */
        private final Map f١٧٤٧١a = new HashMap();

        /* renamed from: b, reason: collision with root package name */
        private final Map f١٧٤٧٢b = new HashMap();

        /* renamed from: c, reason: collision with root package name */
        private final Map f١٧٤٧٣c = new HashMap();

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        class a implements PrivilegedAction {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Class f١٧٤٧٤a;

            a(Class cls) {
                this.f١٧٤٧٤a = cls;
            }

            @Override // java.security.PrivilegedAction
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Field[] run() {
                Field[] declaredFields = this.f١٧٤٧٤a.getDeclaredFields();
                ArrayList arrayList = new ArrayList(declaredFields.length);
                for (Field field : declaredFields) {
                    if (field.isEnumConstant()) {
                        arrayList.add(field);
                    }
                }
                Field[] fieldArr = (Field[]) arrayList.toArray(new Field[0]);
                AccessibleObject.setAccessible(fieldArr, true);
                return fieldArr;
            }
        }

        public i0(Class cls) {
            try {
                for (Field field : (Field[]) AccessController.doPrivileged(new a(cls))) {
                    Enum r42 = (Enum) field.get(null);
                    String name = r42.name();
                    String str = r42.toString();
                    p8.c cVar = (p8.c) field.getAnnotation(p8.c.class);
                    if (cVar != null) {
                        name = cVar.value();
                        for (String str2 : cVar.alternate()) {
                            this.f١٧٤٧١a.put(str2, r42);
                        }
                    }
                    this.f١٧٤٧١a.put(name, r42);
                    this.f١٧٤٧٢b.put(str, r42);
                    this.f١٧٤٧٣c.put(r42, name);
                }
            } catch (IllegalAccessException e10) {
                throw new AssertionError(e10);
            }
        }

        @Override // com.google.gson.w
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Enum read(JsonReader jsonReader) {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            String nextString = jsonReader.nextString();
            Enum r02 = (Enum) this.f١٧٤٧١a.get(nextString);
            if (r02 == null) {
                return (Enum) this.f١٧٤٧٢b.get(nextString);
            }
            return r02;
        }

        @Override // com.google.gson.w
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void write(JsonWriter jsonWriter, Enum r32) {
            String str;
            if (r32 == null) {
                str = null;
            } else {
                str = (String) this.f١٧٤٧٣c.get(r32);
            }
            jsonWriter.value(str);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class j extends com.google.gson.w {
        j() {
        }

        @Override // com.google.gson.w
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public StringBuilder read(JsonReader jsonReader) {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            return new StringBuilder(jsonReader.nextString());
        }

        @Override // com.google.gson.w
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void write(JsonWriter jsonWriter, StringBuilder sb) {
            String sb2;
            if (sb == null) {
                sb2 = null;
            } else {
                sb2 = sb.toString();
            }
            jsonWriter.value(sb2);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class k extends com.google.gson.w {
        k() {
        }

        @Override // com.google.gson.w
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Class read(JsonReader jsonReader) {
            throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
        }

        @Override // com.google.gson.w
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void write(JsonWriter jsonWriter, Class cls) {
            throw new UnsupportedOperationException("Attempted to serialize java.lang.Class: " + cls.getName() + ". Forgot to register a type adapter?");
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class l extends com.google.gson.w {
        l() {
        }

        @Override // com.google.gson.w
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public StringBuffer read(JsonReader jsonReader) {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            return new StringBuffer(jsonReader.nextString());
        }

        @Override // com.google.gson.w
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void write(JsonWriter jsonWriter, StringBuffer stringBuffer) {
            String stringBuffer2;
            if (stringBuffer == null) {
                stringBuffer2 = null;
            } else {
                stringBuffer2 = stringBuffer.toString();
            }
            jsonWriter.value(stringBuffer2);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class m extends com.google.gson.w {
        m() {
        }

        @Override // com.google.gson.w
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public URL read(JsonReader jsonReader) {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            String nextString = jsonReader.nextString();
            if (Constants.NULL_VERSION_ID.equals(nextString)) {
                return null;
            }
            return new URL(nextString);
        }

        @Override // com.google.gson.w
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void write(JsonWriter jsonWriter, URL url) {
            String externalForm;
            if (url == null) {
                externalForm = null;
            } else {
                externalForm = url.toExternalForm();
            }
            jsonWriter.value(externalForm);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class n extends com.google.gson.w {
        n() {
        }

        @Override // com.google.gson.w
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public URI read(JsonReader jsonReader) {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            try {
                String nextString = jsonReader.nextString();
                if (Constants.NULL_VERSION_ID.equals(nextString)) {
                    return null;
                }
                return new URI(nextString);
            } catch (URISyntaxException e10) {
                throw new com.google.gson.j(e10);
            }
        }

        @Override // com.google.gson.w
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void write(JsonWriter jsonWriter, URI uri) {
            String aSCIIString;
            if (uri == null) {
                aSCIIString = null;
            } else {
                aSCIIString = uri.toASCIIString();
            }
            jsonWriter.value(aSCIIString);
        }
    }

    /* renamed from: r8.o$o, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class C٠٢٢٠o extends com.google.gson.w {
        C٠٢٢٠o() {
        }

        @Override // com.google.gson.w
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public InetAddress read(JsonReader jsonReader) {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            return InetAddress.getByName(jsonReader.nextString());
        }

        @Override // com.google.gson.w
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void write(JsonWriter jsonWriter, InetAddress inetAddress) {
            String hostAddress;
            if (inetAddress == null) {
                hostAddress = null;
            } else {
                hostAddress = inetAddress.getHostAddress();
            }
            jsonWriter.value(hostAddress);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class p extends com.google.gson.w {
        p() {
        }

        @Override // com.google.gson.w
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public UUID read(JsonReader jsonReader) {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            String nextString = jsonReader.nextString();
            try {
                return UUID.fromString(nextString);
            } catch (IllegalArgumentException e10) {
                throw new com.google.gson.r("Failed parsing '" + nextString + "' as UUID; at path " + jsonReader.getPreviousPath(), e10);
            }
        }

        @Override // com.google.gson.w
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void write(JsonWriter jsonWriter, UUID uuid) {
            String uuid2;
            if (uuid == null) {
                uuid2 = null;
            } else {
                uuid2 = uuid.toString();
            }
            jsonWriter.value(uuid2);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class q extends com.google.gson.w {
        q() {
        }

        @Override // com.google.gson.w
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Currency read(JsonReader jsonReader) {
            String nextString = jsonReader.nextString();
            try {
                return Currency.getInstance(nextString);
            } catch (IllegalArgumentException e10) {
                throw new com.google.gson.r("Failed parsing '" + nextString + "' as Currency; at path " + jsonReader.getPreviousPath(), e10);
            }
        }

        @Override // com.google.gson.w
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void write(JsonWriter jsonWriter, Currency currency) {
            jsonWriter.value(currency.getCurrencyCode());
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class r extends com.google.gson.w {
        r() {
        }

        @Override // com.google.gson.w
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Calendar read(JsonReader jsonReader) {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            int i10 = 0;
            int i11 = 0;
            int i12 = 0;
            int i13 = 0;
            int i14 = 0;
            int i15 = 0;
            while (jsonReader.peek() != JsonToken.END_OBJECT) {
                String nextName = jsonReader.nextName();
                int nextInt = jsonReader.nextInt();
                if ("year".equals(nextName)) {
                    i10 = nextInt;
                } else if ("month".equals(nextName)) {
                    i11 = nextInt;
                } else if ("dayOfMonth".equals(nextName)) {
                    i12 = nextInt;
                } else if ("hourOfDay".equals(nextName)) {
                    i13 = nextInt;
                } else if ("minute".equals(nextName)) {
                    i14 = nextInt;
                } else if ("second".equals(nextName)) {
                    i15 = nextInt;
                }
            }
            jsonReader.endObject();
            return new GregorianCalendar(i10, i11, i12, i13, i14, i15);
        }

        @Override // com.google.gson.w
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void write(JsonWriter jsonWriter, Calendar calendar) {
            if (calendar == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("year");
            jsonWriter.value(calendar.get(1));
            jsonWriter.name("month");
            jsonWriter.value(calendar.get(2));
            jsonWriter.name("dayOfMonth");
            jsonWriter.value(calendar.get(5));
            jsonWriter.name("hourOfDay");
            jsonWriter.value(calendar.get(11));
            jsonWriter.name("minute");
            jsonWriter.value(calendar.get(12));
            jsonWriter.name("second");
            jsonWriter.value(calendar.get(13));
            jsonWriter.endObject();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class s extends com.google.gson.w {
        s() {
        }

        @Override // com.google.gson.w
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Locale read(JsonReader jsonReader) {
            String str;
            String str2;
            String str3 = null;
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            StringTokenizer stringTokenizer = new StringTokenizer(jsonReader.nextString(), "_");
            if (stringTokenizer.hasMoreElements()) {
                str = stringTokenizer.nextToken();
            } else {
                str = null;
            }
            if (stringTokenizer.hasMoreElements()) {
                str2 = stringTokenizer.nextToken();
            } else {
                str2 = null;
            }
            if (stringTokenizer.hasMoreElements()) {
                str3 = stringTokenizer.nextToken();
            }
            if (str2 == null && str3 == null) {
                return new Locale(str);
            }
            if (str3 == null) {
                return new Locale(str, str2);
            }
            return new Locale(str, str2, str3);
        }

        @Override // com.google.gson.w
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void write(JsonWriter jsonWriter, Locale locale) {
            String locale2;
            if (locale == null) {
                locale2 = null;
            } else {
                locale2 = locale.toString();
            }
            jsonWriter.value(locale2);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class t extends com.google.gson.w {
        t() {
        }

        private com.google.gson.i b(JsonReader jsonReader, JsonToken jsonToken) {
            int i10 = a0.f١٧٤٧٠a[jsonToken.ordinal()];
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 != 3) {
                        if (i10 == 6) {
                            jsonReader.nextNull();
                            return com.google.gson.k.f١٠٨٤٦a;
                        }
                        throw new IllegalStateException("Unexpected token: " + jsonToken);
                    }
                    return new com.google.gson.o(Boolean.valueOf(jsonReader.nextBoolean()));
                }
                return new com.google.gson.o(jsonReader.nextString());
            }
            return new com.google.gson.o(new q8.g(jsonReader.nextString()));
        }

        private com.google.gson.i c(JsonReader jsonReader, JsonToken jsonToken) {
            int i10 = a0.f١٧٤٧٠a[jsonToken.ordinal()];
            if (i10 != 4) {
                if (i10 != 5) {
                    return null;
                }
                jsonReader.beginObject();
                return new com.google.gson.l();
            }
            jsonReader.beginArray();
            return new com.google.gson.f();
        }

        @Override // com.google.gson.w
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.google.gson.i read(JsonReader jsonReader) {
            String str;
            boolean z10;
            if (jsonReader instanceof r8.f) {
                return ((r8.f) jsonReader).b();
            }
            JsonToken peek = jsonReader.peek();
            com.google.gson.i c10 = c(jsonReader, peek);
            if (c10 == null) {
                return b(jsonReader, peek);
            }
            ArrayDeque arrayDeque = new ArrayDeque();
            while (true) {
                if (jsonReader.hasNext()) {
                    if (c10 instanceof com.google.gson.l) {
                        str = jsonReader.nextName();
                    } else {
                        str = null;
                    }
                    JsonToken peek2 = jsonReader.peek();
                    com.google.gson.i c11 = c(jsonReader, peek2);
                    if (c11 != null) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    if (c11 == null) {
                        c11 = b(jsonReader, peek2);
                    }
                    if (c10 instanceof com.google.gson.f) {
                        ((com.google.gson.f) c10).n(c11);
                    } else {
                        ((com.google.gson.l) c10).n(str, c11);
                    }
                    if (z10) {
                        arrayDeque.addLast(c10);
                        c10 = c11;
                    }
                } else {
                    if (c10 instanceof com.google.gson.f) {
                        jsonReader.endArray();
                    } else {
                        jsonReader.endObject();
                    }
                    if (arrayDeque.isEmpty()) {
                        return c10;
                    }
                    c10 = (com.google.gson.i) arrayDeque.removeLast();
                }
            }
        }

        @Override // com.google.gson.w
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void write(JsonWriter jsonWriter, com.google.gson.i iVar) {
            if (iVar != null && !iVar.k()) {
                if (iVar.m()) {
                    com.google.gson.o f10 = iVar.f();
                    if (f10.u()) {
                        jsonWriter.value(f10.r());
                        return;
                    } else if (f10.s()) {
                        jsonWriter.value(f10.n());
                        return;
                    } else {
                        jsonWriter.value(f10.h());
                        return;
                    }
                }
                if (iVar.i()) {
                    jsonWriter.beginArray();
                    Iterator it = iVar.d().iterator();
                    while (it.hasNext()) {
                        write(jsonWriter, (com.google.gson.i) it.next());
                    }
                    jsonWriter.endArray();
                    return;
                }
                if (iVar.l()) {
                    jsonWriter.beginObject();
                    for (Map.Entry entry : iVar.e().o()) {
                        jsonWriter.name((String) entry.getKey());
                        write(jsonWriter, (com.google.gson.i) entry.getValue());
                    }
                    jsonWriter.endObject();
                    return;
                }
                throw new IllegalArgumentException("Couldn't write " + iVar.getClass());
            }
            jsonWriter.nullValue();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class u implements com.google.gson.x {
        u() {
        }

        @Override // com.google.gson.x
        public com.google.gson.w create(com.google.gson.d dVar, TypeToken typeToken) {
            Class rawType = typeToken.getRawType();
            if (Enum.class.isAssignableFrom(rawType) && rawType != Enum.class) {
                if (!rawType.isEnum()) {
                    rawType = rawType.getSuperclass();
                }
                return new i0(rawType);
            }
            return null;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class v extends com.google.gson.w {
        v() {
        }

        @Override // com.google.gson.w
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public BitSet read(JsonReader jsonReader) {
            BitSet bitSet = new BitSet();
            jsonReader.beginArray();
            JsonToken peek = jsonReader.peek();
            int i10 = 0;
            while (peek != JsonToken.END_ARRAY) {
                int i11 = a0.f١٧٤٧٠a[peek.ordinal()];
                boolean z10 = true;
                if (i11 != 1 && i11 != 2) {
                    if (i11 == 3) {
                        z10 = jsonReader.nextBoolean();
                    } else {
                        throw new com.google.gson.r("Invalid bitset value type: " + peek + "; at path " + jsonReader.getPath());
                    }
                } else {
                    int nextInt = jsonReader.nextInt();
                    if (nextInt == 0) {
                        z10 = false;
                    } else if (nextInt != 1) {
                        throw new com.google.gson.r("Invalid bitset value " + nextInt + ", expected 0 or 1; at path " + jsonReader.getPreviousPath());
                    }
                }
                if (z10) {
                    bitSet.set(i10);
                }
                i10++;
                peek = jsonReader.peek();
            }
            jsonReader.endArray();
            return bitSet;
        }

        @Override // com.google.gson.w
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void write(JsonWriter jsonWriter, BitSet bitSet) {
            jsonWriter.beginArray();
            int length = bitSet.length();
            for (int i10 = 0; i10 < length; i10++) {
                jsonWriter.value(bitSet.get(i10) ? 1L : 0L);
            }
            jsonWriter.endArray();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class w implements com.google.gson.x {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Class f١٧٤٧٦a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.google.gson.w f١٧٤٧٧b;

        w(Class cls, com.google.gson.w wVar) {
            this.f١٧٤٧٦a = cls;
            this.f١٧٤٧٧b = wVar;
        }

        @Override // com.google.gson.x
        public com.google.gson.w create(com.google.gson.d dVar, TypeToken typeToken) {
            if (typeToken.getRawType() == this.f١٧٤٧٦a) {
                return this.f١٧٤٧٧b;
            }
            return null;
        }

        public String toString() {
            return "Factory[type=" + this.f١٧٤٧٦a.getName() + ",adapter=" + this.f١٧٤٧٧b + "]";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class x implements com.google.gson.x {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Class f١٧٤٧٨a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Class f١٧٤٧٩b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.google.gson.w f١٧٤٨٠c;

        x(Class cls, Class cls2, com.google.gson.w wVar) {
            this.f١٧٤٧٨a = cls;
            this.f١٧٤٧٩b = cls2;
            this.f١٧٤٨٠c = wVar;
        }

        @Override // com.google.gson.x
        public com.google.gson.w create(com.google.gson.d dVar, TypeToken typeToken) {
            Class rawType = typeToken.getRawType();
            if (rawType != this.f١٧٤٧٨a && rawType != this.f١٧٤٧٩b) {
                return null;
            }
            return this.f١٧٤٨٠c;
        }

        public String toString() {
            return "Factory[type=" + this.f١٧٤٧٩b.getName() + "+" + this.f١٧٤٧٨a.getName() + ",adapter=" + this.f١٧٤٨٠c + "]";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class y implements com.google.gson.x {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Class f١٧٤٨١a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Class f١٧٤٨٢b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.google.gson.w f١٧٤٨٣c;

        y(Class cls, Class cls2, com.google.gson.w wVar) {
            this.f١٧٤٨١a = cls;
            this.f١٧٤٨٢b = cls2;
            this.f١٧٤٨٣c = wVar;
        }

        @Override // com.google.gson.x
        public com.google.gson.w create(com.google.gson.d dVar, TypeToken typeToken) {
            Class rawType = typeToken.getRawType();
            if (rawType != this.f١٧٤٨١a && rawType != this.f١٧٤٨٢b) {
                return null;
            }
            return this.f١٧٤٨٣c;
        }

        public String toString() {
            return "Factory[type=" + this.f١٧٤٨١a.getName() + "+" + this.f١٧٤٨٢b.getName() + ",adapter=" + this.f١٧٤٨٣c + "]";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class z implements com.google.gson.x {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Class f١٧٤٨٤a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.google.gson.w f١٧٤٨٥b;

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        class a extends com.google.gson.w {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Class f١٧٤٨٦a;

            a(Class cls) {
                this.f١٧٤٨٦a = cls;
            }

            @Override // com.google.gson.w
            public Object read(JsonReader jsonReader) {
                Object read = z.this.f١٧٤٨٥b.read(jsonReader);
                if (read != null && !this.f١٧٤٨٦a.isInstance(read)) {
                    throw new com.google.gson.r("Expected a " + this.f١٧٤٨٦a.getName() + " but was " + read.getClass().getName() + "; at path " + jsonReader.getPreviousPath());
                }
                return read;
            }

            @Override // com.google.gson.w
            public void write(JsonWriter jsonWriter, Object obj) {
                z.this.f١٧٤٨٥b.write(jsonWriter, obj);
            }
        }

        z(Class cls, com.google.gson.w wVar) {
            this.f١٧٤٨٤a = cls;
            this.f١٧٤٨٥b = wVar;
        }

        @Override // com.google.gson.x
        public com.google.gson.w create(com.google.gson.d dVar, TypeToken typeToken) {
            Class<?> rawType = typeToken.getRawType();
            if (!this.f١٧٤٨٤a.isAssignableFrom(rawType)) {
                return null;
            }
            return new a(rawType);
        }

        public String toString() {
            return "Factory[typeHierarchy=" + this.f١٧٤٨٤a.getName() + ",adapter=" + this.f١٧٤٨٥b + "]";
        }
    }

    static {
        com.google.gson.w nullSafe = new k().nullSafe();
        f١٧٤٤٤a = nullSafe;
        f١٧٤٤٥b = a(Class.class, nullSafe);
        com.google.gson.w nullSafe2 = new v().nullSafe();
        f١٧٤٤٦c = nullSafe2;
        f١٧٤٤٧d = a(BitSet.class, nullSafe2);
        b0 b0Var = new b0();
        f١٧٤٤٨e = b0Var;
        f١٧٤٤٩f = new c0();
        f١٧٤٥٠g = b(Boolean.TYPE, Boolean.class, b0Var);
        d0 d0Var = new d0();
        f١٧٤٥١h = d0Var;
        f١٧٤٥٢i = b(Byte.TYPE, Byte.class, d0Var);
        e0 e0Var = new e0();
        f١٧٤٥٣j = e0Var;
        f١٧٤٥٤k = b(Short.TYPE, Short.class, e0Var);
        f0 f0Var = new f0();
        f١٧٤٥٥l = f0Var;
        f١٧٤٥٦m = b(Integer.TYPE, Integer.class, f0Var);
        com.google.gson.w nullSafe3 = new g0().nullSafe();
        f١٧٤٥٧n = nullSafe3;
        f١٧٤٥٨o = a(AtomicInteger.class, nullSafe3);
        com.google.gson.w nullSafe4 = new h0().nullSafe();
        f١٧٤٥٩p = nullSafe4;
        f١٧٤٦٠q = a(AtomicBoolean.class, nullSafe4);
        com.google.gson.w nullSafe5 = new a().nullSafe();
        f١٧٤٦١r = nullSafe5;
        f١٧٤٦٢s = a(AtomicIntegerArray.class, nullSafe5);
        f١٧٤٦٣t = new b();
        f١٧٤٦٤u = new c();
        f١٧٤٦٥v = new d();
        e eVar = new e();
        f١٧٤٦٦w = eVar;
        f١٧٤٦٧x = b(Character.TYPE, Character.class, eVar);
        f fVar = new f();
        f١٧٤٦٨y = fVar;
        f١٧٤٦٩z = new g();
        A = new h();
        f١٧٤٤٣B = new i();
        C = a(String.class, fVar);
        j jVar = new j();
        D = jVar;
        E = a(StringBuilder.class, jVar);
        l lVar = new l();
        F = lVar;
        G = a(StringBuffer.class, lVar);
        m mVar = new m();
        H = mVar;
        I = a(URL.class, mVar);
        n nVar = new n();
        J = nVar;
        K = a(URI.class, nVar);
        C٠٢٢٠o r02 = new C٠٢٢٠o();
        L = r02;
        M = d(InetAddress.class, r02);
        p pVar = new p();
        N = pVar;
        O = a(UUID.class, pVar);
        com.google.gson.w nullSafe6 = new q().nullSafe();
        P = nullSafe6;
        Q = a(Currency.class, nullSafe6);
        r rVar = new r();
        R = rVar;
        S = c(Calendar.class, GregorianCalendar.class, rVar);
        s sVar = new s();
        T = sVar;
        U = a(Locale.class, sVar);
        t tVar = new t();
        V = tVar;
        W = d(com.google.gson.i.class, tVar);
        X = new u();
    }

    public static com.google.gson.x a(Class cls, com.google.gson.w wVar) {
        return new w(cls, wVar);
    }

    public static com.google.gson.x b(Class cls, Class cls2, com.google.gson.w wVar) {
        return new x(cls, cls2, wVar);
    }

    public static com.google.gson.x c(Class cls, Class cls2, com.google.gson.w wVar) {
        return new y(cls, cls2, wVar);
    }

    public static com.google.gson.x d(Class cls, com.google.gson.w wVar) {
        return new z(cls, wVar);
    }
}
