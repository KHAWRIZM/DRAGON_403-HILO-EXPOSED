package com.google.gson;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.MalformedJsonException;
import java.math.BigDecimal;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class u implements v {

    /* renamed from: a, reason: collision with root package name */
    public static final u f١٠٨٥٧a;

    /* renamed from: b, reason: collision with root package name */
    public static final u f١٠٨٥٨b;

    /* renamed from: c, reason: collision with root package name */
    public static final u f١٠٨٥٩c;

    /* renamed from: d, reason: collision with root package name */
    public static final u f١٠٨٦٠d;

    /* renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ u[] f١٠٨٦١e;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    enum a extends u {
        a(String str, int i10) {
            super(str, i10, null);
        }

        @Override // com.google.gson.v
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Double a(JsonReader jsonReader) {
            return Double.valueOf(jsonReader.nextDouble());
        }
    }

    static {
        a aVar = new a("DOUBLE", 0);
        f١٠٨٥٧a = aVar;
        u uVar = new u("LAZILY_PARSED_NUMBER", 1) { // from class: com.google.gson.u.b
            {
                a aVar2 = null;
            }

            @Override // com.google.gson.v
            public Number a(JsonReader jsonReader) {
                return new q8.g(jsonReader.nextString());
            }
        };
        f١٠٨٥٨b = uVar;
        u uVar2 = new u("LONG_OR_DOUBLE", 2) { // from class: com.google.gson.u.c
            {
                a aVar2 = null;
            }

            @Override // com.google.gson.v
            public Number a(JsonReader jsonReader) {
                String nextString = jsonReader.nextString();
                try {
                    try {
                        return Long.valueOf(Long.parseLong(nextString));
                    } catch (NumberFormatException unused) {
                        Double valueOf = Double.valueOf(nextString);
                        if (!valueOf.isInfinite()) {
                            if (valueOf.isNaN()) {
                            }
                            return valueOf;
                        }
                        if (!jsonReader.isLenient()) {
                            throw new MalformedJsonException("JSON forbids NaN and infinities: " + valueOf + "; at path " + jsonReader.getPreviousPath());
                        }
                        return valueOf;
                    }
                } catch (NumberFormatException e10) {
                    throw new m("Cannot parse " + nextString + "; at path " + jsonReader.getPreviousPath(), e10);
                }
            }
        };
        f١٠٨٥٩c = uVar2;
        u uVar3 = new u("BIG_DECIMAL", 3) { // from class: com.google.gson.u.d
            {
                a aVar2 = null;
            }

            @Override // com.google.gson.v
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public BigDecimal a(JsonReader jsonReader) {
                String nextString = jsonReader.nextString();
                try {
                    return new BigDecimal(nextString);
                } catch (NumberFormatException e10) {
                    throw new m("Cannot parse " + nextString + "; at path " + jsonReader.getPreviousPath(), e10);
                }
            }
        };
        f١٠٨٦٠d = uVar3;
        f١٠٨٦١e = new u[]{aVar, uVar, uVar2, uVar3};
    }

    private u(String str, int i10) {
    }

    public static u valueOf(String str) {
        return (u) Enum.valueOf(u.class, str);
    }

    public static u[] values() {
        return (u[]) f١٠٨٦١e.clone();
    }

    /* synthetic */ u(String str, int i10, a aVar) {
        this(str, i10);
    }
}
