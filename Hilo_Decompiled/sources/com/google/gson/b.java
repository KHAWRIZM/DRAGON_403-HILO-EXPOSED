package com.google.gson;

import java.lang.reflect.Field;
import java.util.Locale;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class b implements com.google.gson.c {

    /* renamed from: a, reason: collision with root package name */
    public static final b f١٠٧٨٥a;

    /* renamed from: b, reason: collision with root package name */
    public static final b f١٠٧٨٦b;

    /* renamed from: c, reason: collision with root package name */
    public static final b f١٠٧٨٧c;

    /* renamed from: d, reason: collision with root package name */
    public static final b f١٠٧٨٨d;

    /* renamed from: e, reason: collision with root package name */
    public static final b f١٠٧٨٩e;

    /* renamed from: f, reason: collision with root package name */
    public static final b f١٠٧٩٠f;

    /* renamed from: g, reason: collision with root package name */
    public static final b f١٠٧٩١g;

    /* renamed from: h, reason: collision with root package name */
    private static final /* synthetic */ b[] f١٠٧٩٢h;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    enum a extends b {
        a(String str, int i10) {
            super(str, i10, null);
        }

        @Override // com.google.gson.c
        public String a(Field field) {
            return field.getName();
        }
    }

    static {
        a aVar = new a("IDENTITY", 0);
        f١٠٧٨٥a = aVar;
        b bVar = new b("UPPER_CAMEL_CASE", 1) { // from class: com.google.gson.b.b
            {
                a aVar2 = null;
            }

            @Override // com.google.gson.c
            public String a(Field field) {
                return b.d(field.getName());
            }
        };
        f١٠٧٨٦b = bVar;
        b bVar2 = new b("UPPER_CAMEL_CASE_WITH_SPACES", 2) { // from class: com.google.gson.b.c
            {
                a aVar2 = null;
            }

            @Override // com.google.gson.c
            public String a(Field field) {
                return b.d(b.c(field.getName(), ' '));
            }
        };
        f١٠٧٨٧c = bVar2;
        b bVar3 = new b("UPPER_CASE_WITH_UNDERSCORES", 3) { // from class: com.google.gson.b.d
            {
                a aVar2 = null;
            }

            @Override // com.google.gson.c
            public String a(Field field) {
                return b.c(field.getName(), '_').toUpperCase(Locale.ENGLISH);
            }
        };
        f١٠٧٨٨d = bVar3;
        b bVar4 = new b("LOWER_CASE_WITH_UNDERSCORES", 4) { // from class: com.google.gson.b.e
            {
                a aVar2 = null;
            }

            @Override // com.google.gson.c
            public String a(Field field) {
                return b.c(field.getName(), '_').toLowerCase(Locale.ENGLISH);
            }
        };
        f١٠٧٨٩e = bVar4;
        b bVar5 = new b("LOWER_CASE_WITH_DASHES", 5) { // from class: com.google.gson.b.f
            {
                a aVar2 = null;
            }

            @Override // com.google.gson.c
            public String a(Field field) {
                return b.c(field.getName(), '-').toLowerCase(Locale.ENGLISH);
            }
        };
        f١٠٧٩٠f = bVar5;
        b bVar6 = new b("LOWER_CASE_WITH_DOTS", 6) { // from class: com.google.gson.b.g
            {
                a aVar2 = null;
            }

            @Override // com.google.gson.c
            public String a(Field field) {
                return b.c(field.getName(), '.').toLowerCase(Locale.ENGLISH);
            }
        };
        f١٠٧٩١g = bVar6;
        f١٠٧٩٢h = new b[]{aVar, bVar, bVar2, bVar3, bVar4, bVar5, bVar6};
    }

    private b(String str, int i10) {
    }

    static String c(String str, char c10) {
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i10 = 0; i10 < length; i10++) {
            char charAt = str.charAt(i10);
            if (Character.isUpperCase(charAt) && sb.length() != 0) {
                sb.append(c10);
            }
            sb.append(charAt);
        }
        return sb.toString();
    }

    static String d(String str) {
        int length = str.length();
        for (int i10 = 0; i10 < length; i10++) {
            char charAt = str.charAt(i10);
            if (Character.isLetter(charAt)) {
                if (Character.isUpperCase(charAt)) {
                    return str;
                }
                char upperCase = Character.toUpperCase(charAt);
                if (i10 == 0) {
                    return upperCase + str.substring(1);
                }
                return str.substring(0, i10) + upperCase + str.substring(i10 + 1);
            }
        }
        return str;
    }

    public static b valueOf(String str) {
        return (b) Enum.valueOf(b.class, str);
    }

    public static b[] values() {
        return (b[]) f١٠٧٩٢h.clone();
    }

    /* synthetic */ b(String str, int i10, a aVar) {
        this(str, i10);
    }
}
