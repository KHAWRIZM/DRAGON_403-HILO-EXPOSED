package r8;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.gson.r;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.google.gson.t;
import com.google.gson.w;
import com.google.gson.x;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class k implements x {

    /* renamed from: a, reason: collision with root package name */
    private final q8.c f١٧٤٠٦a;

    /* renamed from: b, reason: collision with root package name */
    private final com.google.gson.c f١٧٤٠٧b;

    /* renamed from: c, reason: collision with root package name */
    private final q8.d f١٧٤٠٨c;

    /* renamed from: d, reason: collision with root package name */
    private final r8.e f١٧٤٠٩d;

    /* renamed from: e, reason: collision with root package name */
    private final List f١٧٤١٠e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class a extends c {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f١٧٤١١f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ Method f١٧٤١٢g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ boolean f١٧٤١٣h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ w f١٧٤١٤i;

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ com.google.gson.d f١٧٤١٥j;

        /* renamed from: k, reason: collision with root package name */
        final /* synthetic */ TypeToken f١٧٤١٦k;

        /* renamed from: l, reason: collision with root package name */
        final /* synthetic */ boolean f١٧٤١٧l;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ boolean f١٧٤١٨m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, Field field, boolean z10, boolean z11, boolean z12, Method method, boolean z13, w wVar, com.google.gson.d dVar, TypeToken typeToken, boolean z14, boolean z15) {
            super(str, field, z10, z11);
            this.f١٧٤١١f = z12;
            this.f١٧٤١٢g = method;
            this.f١٧٤١٣h = z13;
            this.f١٧٤١٤i = wVar;
            this.f١٧٤١٥j = dVar;
            this.f١٧٤١٦k = typeToken;
            this.f١٧٤١٧l = z14;
            this.f١٧٤١٨m = z15;
        }

        @Override // r8.k.c
        void a(JsonReader jsonReader, int i10, Object[] objArr) {
            Object read = this.f١٧٤١٤i.read(jsonReader);
            if (read == null && this.f١٧٤١٧l) {
                throw new com.google.gson.m("null is not allowed as value for record component '" + this.f١٧٤٢٣c + "' of primitive type; at path " + jsonReader.getPath());
            }
            objArr[i10] = read;
        }

        @Override // r8.k.c
        void b(JsonReader jsonReader, Object obj) {
            Object read = this.f١٧٤١٤i.read(jsonReader);
            if (read != null || !this.f١٧٤١٧l) {
                if (this.f١٧٤١١f) {
                    k.b(obj, this.f١٧٤٢٢b);
                } else if (this.f١٧٤١٨m) {
                    throw new com.google.gson.j("Cannot set value of 'static final' " + t8.a.g(this.f١٧٤٢٢b, false));
                }
                this.f١٧٤٢٢b.set(obj, read);
            }
        }

        @Override // r8.k.c
        void c(JsonWriter jsonWriter, Object obj) {
            Object obj2;
            w nVar;
            if (!this.f١٧٤٢٤d) {
                return;
            }
            if (this.f١٧٤١١f) {
                Method method = this.f١٧٤١٢g;
                if (method == null) {
                    k.b(obj, this.f١٧٤٢٢b);
                } else {
                    k.b(obj, method);
                }
            }
            Method method2 = this.f١٧٤١٢g;
            if (method2 != null) {
                try {
                    obj2 = method2.invoke(obj, null);
                } catch (InvocationTargetException e10) {
                    throw new com.google.gson.j("Accessor " + t8.a.g(this.f١٧٤١٢g, false) + " threw exception", e10.getCause());
                }
            } else {
                obj2 = this.f١٧٤٢٢b.get(obj);
            }
            if (obj2 == obj) {
                return;
            }
            jsonWriter.name(this.f١٧٤٢١a);
            if (this.f١٧٤١٣h) {
                nVar = this.f١٧٤١٤i;
            } else {
                nVar = new n(this.f١٧٤١٥j, this.f١٧٤١٤i, this.f١٧٤١٦k.getType());
            }
            nVar.write(jsonWriter, obj2);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static abstract class b extends w {

        /* renamed from: a, reason: collision with root package name */
        final Map f١٧٤٢٠a;

        b(Map map) {
            this.f١٧٤٢٠a = map;
        }

        abstract Object a();

        abstract Object b(Object obj);

        abstract void c(Object obj, JsonReader jsonReader, c cVar);

        @Override // com.google.gson.w
        public Object read(JsonReader jsonReader) {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            Object a10 = a();
            try {
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    c cVar = (c) this.f١٧٤٢٠a.get(jsonReader.nextName());
                    if (cVar != null && cVar.f١٧٤٢٥e) {
                        c(a10, jsonReader, cVar);
                    }
                    jsonReader.skipValue();
                }
                jsonReader.endObject();
                return b(a10);
            } catch (IllegalAccessException e10) {
                throw t8.a.e(e10);
            } catch (IllegalStateException e11) {
                throw new r(e11);
            }
        }

        @Override // com.google.gson.w
        public void write(JsonWriter jsonWriter, Object obj) {
            if (obj == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            try {
                Iterator it = this.f١٧٤٢٠a.values().iterator();
                while (it.hasNext()) {
                    ((c) it.next()).c(jsonWriter, obj);
                }
                jsonWriter.endObject();
            } catch (IllegalAccessException e10) {
                throw t8.a.e(e10);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static abstract class c {

        /* renamed from: a, reason: collision with root package name */
        final String f١٧٤٢١a;

        /* renamed from: b, reason: collision with root package name */
        final Field f١٧٤٢٢b;

        /* renamed from: c, reason: collision with root package name */
        final String f١٧٤٢٣c;

        /* renamed from: d, reason: collision with root package name */
        final boolean f١٧٤٢٤d;

        /* renamed from: e, reason: collision with root package name */
        final boolean f١٧٤٢٥e;

        protected c(String str, Field field, boolean z10, boolean z11) {
            this.f١٧٤٢١a = str;
            this.f١٧٤٢٢b = field;
            this.f١٧٤٢٣c = field.getName();
            this.f١٧٤٢٤d = z10;
            this.f١٧٤٢٥e = z11;
        }

        abstract void a(JsonReader jsonReader, int i10, Object[] objArr);

        abstract void b(JsonReader jsonReader, Object obj);

        abstract void c(JsonWriter jsonWriter, Object obj);
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    private static final class e extends b {

        /* renamed from: e, reason: collision with root package name */
        static final Map f١٧٤٢٧e = f();

        /* renamed from: b, reason: collision with root package name */
        private final Constructor f١٧٤٢٨b;

        /* renamed from: c, reason: collision with root package name */
        private final Object[] f١٧٤٢٩c;

        /* renamed from: d, reason: collision with root package name */
        private final Map f١٧٤٣٠d;

        e(Class cls, Map map, boolean z10) {
            super(map);
            this.f١٧٤٣٠d = new HashMap();
            Constructor i10 = t8.a.i(cls);
            this.f١٧٤٢٨b = i10;
            if (z10) {
                k.b(null, i10);
            } else {
                t8.a.l(i10);
            }
            String[] j10 = t8.a.j(cls);
            for (int i11 = 0; i11 < j10.length; i11++) {
                this.f١٧٤٣٠d.put(j10[i11], Integer.valueOf(i11));
            }
            Class<?>[] parameterTypes = this.f١٧٤٢٨b.getParameterTypes();
            this.f١٧٤٢٩c = new Object[parameterTypes.length];
            for (int i12 = 0; i12 < parameterTypes.length; i12++) {
                this.f١٧٤٢٩c[i12] = f١٧٤٢٧e.get(parameterTypes[i12]);
            }
        }

        private static Map f() {
            HashMap hashMap = new HashMap();
            hashMap.put(Byte.TYPE, (byte) 0);
            hashMap.put(Short.TYPE, (short) 0);
            hashMap.put(Integer.TYPE, 0);
            hashMap.put(Long.TYPE, 0L);
            hashMap.put(Float.TYPE, Float.valueOf(DownloadProgress.UNKNOWN_PROGRESS));
            hashMap.put(Double.TYPE, Double.valueOf(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE));
            hashMap.put(Character.TYPE, (char) 0);
            hashMap.put(Boolean.TYPE, Boolean.FALSE);
            return hashMap;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // r8.k.b
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public Object[] a() {
            return (Object[]) this.f١٧٤٢٩c.clone();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // r8.k.b
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Object b(Object[] objArr) {
            try {
                return this.f١٧٤٢٨b.newInstance(objArr);
            } catch (IllegalAccessException e10) {
                throw t8.a.e(e10);
            } catch (IllegalArgumentException e11) {
                e = e11;
                throw new RuntimeException("Failed to invoke constructor '" + t8.a.c(this.f١٧٤٢٨b) + "' with args " + Arrays.toString(objArr), e);
            } catch (InstantiationException e12) {
                e = e12;
                throw new RuntimeException("Failed to invoke constructor '" + t8.a.c(this.f١٧٤٢٨b) + "' with args " + Arrays.toString(objArr), e);
            } catch (InvocationTargetException e13) {
                throw new RuntimeException("Failed to invoke constructor '" + t8.a.c(this.f١٧٤٢٨b) + "' with args " + Arrays.toString(objArr), e13.getCause());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // r8.k.b
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public void c(Object[] objArr, JsonReader jsonReader, c cVar) {
            Integer num = (Integer) this.f١٧٤٣٠d.get(cVar.f١٧٤٢٣c);
            if (num != null) {
                cVar.a(jsonReader, num.intValue(), objArr);
                return;
            }
            throw new IllegalStateException("Could not find the index in the constructor '" + t8.a.c(this.f١٧٤٢٨b) + "' for field with name '" + cVar.f١٧٤٢٣c + "', unable to determine which argument in the constructor the field corresponds to. This is unexpected behavior, as we expect the RecordComponents to have the same names as the fields in the Java class, and that the order of the RecordComponents is the same as the order of the canonical constructor parameters.");
        }
    }

    public k(q8.c cVar, com.google.gson.c cVar2, q8.d dVar, r8.e eVar, List list) {
        this.f١٧٤٠٦a = cVar;
        this.f١٧٤٠٧b = cVar2;
        this.f١٧٤٠٨c = dVar;
        this.f١٧٤٠٩d = eVar;
        this.f١٧٤١٠e = list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static void b(Object obj, AccessibleObject accessibleObject) {
        if (Modifier.isStatic(((Member) accessibleObject).getModifiers())) {
            obj = null;
        }
        if (q8.l.a(accessibleObject, obj)) {
            return;
        }
        throw new com.google.gson.j(t8.a.g(accessibleObject, true) + " is not accessible and ReflectionAccessFilter does not permit making it accessible. Register a TypeAdapter for the declaring type, adjust the access filter or increase the visibility of the element and its declaring type.");
    }

    private c c(com.google.gson.d dVar, Field field, Method method, String str, TypeToken typeToken, boolean z10, boolean z11, boolean z12) {
        boolean z13;
        w wVar;
        boolean z14;
        boolean a10 = q8.k.a(typeToken.getRawType());
        int modifiers = field.getModifiers();
        if (Modifier.isStatic(modifiers) && Modifier.isFinal(modifiers)) {
            z13 = true;
        } else {
            z13 = false;
        }
        p8.b bVar = (p8.b) field.getAnnotation(p8.b.class);
        if (bVar != null) {
            wVar = this.f١٧٤٠٩d.a(this.f١٧٤٠٦a, dVar, typeToken, bVar);
        } else {
            wVar = null;
        }
        if (wVar != null) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (wVar == null) {
            wVar = dVar.l(typeToken);
        }
        return new a(str, field, z10, z11, z12, method, z14, wVar, dVar, typeToken, a10, z13);
    }

    private Map d(com.google.gson.d dVar, TypeToken typeToken, Class cls, boolean z10, boolean z11) {
        boolean z12;
        Method method;
        int i10;
        int i11;
        boolean z13;
        k kVar = this;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (cls.isInterface()) {
            return linkedHashMap;
        }
        TypeToken typeToken2 = typeToken;
        boolean z14 = z10;
        Class cls2 = cls;
        while (cls2 != Object.class) {
            Field[] declaredFields = cls2.getDeclaredFields();
            boolean z15 = true;
            boolean z16 = false;
            if (cls2 != cls && declaredFields.length > 0) {
                t b10 = q8.l.b(kVar.f١٧٤١٠e, cls2);
                if (b10 != t.BLOCK_ALL) {
                    if (b10 == t.BLOCK_INACCESSIBLE) {
                        z14 = true;
                    } else {
                        z14 = false;
                    }
                } else {
                    throw new com.google.gson.j("ReflectionAccessFilter does not permit using reflection for " + cls2 + " (supertype of " + cls + "). Register a TypeAdapter for this type or adjust the access filter.");
                }
            }
            boolean z17 = z14;
            int length = declaredFields.length;
            int i12 = 0;
            while (i12 < length) {
                Field field = declaredFields[i12];
                boolean f10 = kVar.f(field, z15);
                boolean f11 = kVar.f(field, z16);
                if (!f10 && !f11) {
                    i10 = i12;
                    i11 = length;
                } else {
                    c cVar = null;
                    if (z11) {
                        if (Modifier.isStatic(field.getModifiers())) {
                            method = null;
                            z12 = false;
                        } else {
                            Method h10 = t8.a.h(cls2, field);
                            if (!z17) {
                                t8.a.l(h10);
                            }
                            if (h10.getAnnotation(p8.c.class) != null && field.getAnnotation(p8.c.class) == null) {
                                throw new com.google.gson.j("@SerializedName on " + t8.a.g(h10, z16) + " is not supported");
                            }
                            z12 = f11;
                            method = h10;
                        }
                    } else {
                        z12 = f11;
                        method = null;
                    }
                    if (!z17 && method == null) {
                        t8.a.l(field);
                    }
                    Type o10 = q8.b.o(typeToken2.getType(), cls2, field.getGenericType());
                    List e10 = kVar.e(field);
                    int size = e10.size();
                    int i13 = 0;
                    while (i13 < size) {
                        String str = (String) e10.get(i13);
                        if (i13 != 0) {
                            z13 = false;
                        } else {
                            z13 = f10;
                        }
                        int i14 = i13;
                        c cVar2 = cVar;
                        int i15 = size;
                        List list = e10;
                        Field field2 = field;
                        int i16 = i12;
                        int i17 = length;
                        c cVar3 = (c) linkedHashMap.put(str, c(dVar, field, method, str, TypeToken.get(o10), z13, z12, z17));
                        if (cVar2 == null) {
                            cVar = cVar3;
                        } else {
                            cVar = cVar2;
                        }
                        i13 = i14 + 1;
                        f10 = z13;
                        i12 = i16;
                        size = i15;
                        e10 = list;
                        field = field2;
                        length = i17;
                    }
                    c cVar4 = cVar;
                    Field field3 = field;
                    i10 = i12;
                    i11 = length;
                    if (cVar4 != null) {
                        throw new IllegalArgumentException("Class " + cls.getName() + " declares multiple JSON fields named '" + cVar4.f١٧٤٢١a + "'; conflict is caused by fields " + t8.a.f(cVar4.f١٧٤٢٢b) + " and " + t8.a.f(field3));
                    }
                }
                i12 = i10 + 1;
                length = i11;
                z16 = false;
                z15 = true;
                kVar = this;
            }
            typeToken2 = TypeToken.get(q8.b.o(typeToken2.getType(), cls2, cls2.getGenericSuperclass()));
            cls2 = typeToken2.getRawType();
            kVar = this;
            z14 = z17;
        }
        return linkedHashMap;
    }

    private List e(Field field) {
        p8.c cVar = (p8.c) field.getAnnotation(p8.c.class);
        if (cVar == null) {
            return Collections.singletonList(this.f١٧٤٠٧b.a(field));
        }
        String value = cVar.value();
        String[] alternate = cVar.alternate();
        if (alternate.length == 0) {
            return Collections.singletonList(value);
        }
        ArrayList arrayList = new ArrayList(alternate.length + 1);
        arrayList.add(value);
        Collections.addAll(arrayList, alternate);
        return arrayList;
    }

    private boolean f(Field field, boolean z10) {
        if (!this.f١٧٤٠٨c.b(field.getType(), z10) && !this.f١٧٤٠٨c.e(field, z10)) {
            return true;
        }
        return false;
    }

    @Override // com.google.gson.x
    public w create(com.google.gson.d dVar, TypeToken typeToken) {
        boolean z10;
        Class rawType = typeToken.getRawType();
        if (!Object.class.isAssignableFrom(rawType)) {
            return null;
        }
        t b10 = q8.l.b(this.f١٧٤١٠e, rawType);
        if (b10 != t.BLOCK_ALL) {
            if (b10 == t.BLOCK_INACCESSIBLE) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (t8.a.k(rawType)) {
                return new e(rawType, d(dVar, typeToken, rawType, z10, true), z10);
            }
            return new d(this.f١٧٤٠٦a.b(typeToken), d(dVar, typeToken, rawType, z10, false));
        }
        throw new com.google.gson.j("ReflectionAccessFilter does not permit using reflection for " + rawType + ". Register a TypeAdapter for this type or adjust the access filter.");
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    private static final class d extends b {

        /* renamed from: b, reason: collision with root package name */
        private final q8.i f١٧٤٢٦b;

        d(q8.i iVar, Map map) {
            super(map);
            this.f١٧٤٢٦b = iVar;
        }

        @Override // r8.k.b
        Object a() {
            return this.f١٧٤٢٦b.a();
        }

        @Override // r8.k.b
        void c(Object obj, JsonReader jsonReader, c cVar) {
            cVar.b(jsonReader, obj);
        }

        @Override // r8.k.b
        Object b(Object obj) {
            return obj;
        }
    }
}
