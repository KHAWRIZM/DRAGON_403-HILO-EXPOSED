package com.google.protobuf;

import com.google.protobuf.k2;
import com.google.protobuf.n;
import com.google.protobuf.q;
import java.io.IOException;
import java.lang.Character;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import kotlin.jvm.internal.LongCompanionObject;
import okio.Utf8;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class e2 {

    /* renamed from: a, reason: collision with root package name */
    private static final Logger f١٠٩٧٥a = Logger.getLogger(e2.class.getName());

    /* renamed from: b, reason: collision with root package name */
    private static final c f١٠٩٧٦b = c.a().a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f١٠٩٧٧a;

        /* renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f١٠٩٧٨b;

        static {
            int[] iArr = new int[n.g.c.values().length];
            f١٠٩٧٨b = iArr;
            try {
                iArr[n.g.c.f١١٨٠١f.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f١٠٩٧٨b[n.g.c.f١١٨١٣r.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f١٠٩٧٨b[n.g.c.f١١٨١١p.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f١٠٩٧٨b[n.g.c.f١١٧٩٩d.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f١٠٩٧٨b[n.g.c.f١١٨١٤s.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f١٠٩٧٨b[n.g.c.f١١٨١٢q.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f١٠٩٧٨b[n.g.c.f١١٨٠٤i.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f١٠٩٧٨b[n.g.c.f١١٧٩٨c.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f١٠٩٧٨b[n.g.c.f١١٧٩٧b.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f١٠٩٧٨b[n.g.c.f١١٨٠٩n.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f١٠٩٧٨b[n.g.c.f١١٨٠٣h.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f١٠٩٧٨b[n.g.c.f١١٨٠٠e.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f١٠٩٧٨b[n.g.c.f١١٨٠٢g.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f١٠٩٧٨b[n.g.c.f١١٨٠٥j.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f١٠٩٧٨b[n.g.c.f١١٨٠٨m.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f١٠٩٧٨b[n.g.c.f١١٨١٠o.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f١٠٩٧٨b[n.g.c.f١١٨٠٧l.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f١٠٩٧٨b[n.g.c.f١١٨٠٦k.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            int[] iArr2 = new int[n.g.b.values().length];
            f١٠٩٧٧a = iArr2;
            try {
                iArr2[n.g.b.BOOLEAN.ordinal()] = 1;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                f١٠٩٧٧a[n.g.b.LONG.ordinal()] = 2;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                f١٠٩٧٧a[n.g.b.INT.ordinal()] = 3;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                f١٠٩٧٧a[n.g.b.STRING.ordinal()] = 4;
            } catch (NoSuchFieldError unused22) {
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class b extends IOException {
        private static final long serialVersionUID = -8164033650142593304L;

        b(String str) {
            super(str);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        private final h2 f١٠٩٧٩a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean f١٠٩٨٠b;

        /* renamed from: c, reason: collision with root package name */
        private final boolean f١٠٩٨١c;

        /* renamed from: d, reason: collision with root package name */
        private final boolean f١٠٩٨٢d;

        /* renamed from: e, reason: collision with root package name */
        private final b f١٠٩٨٣e;

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        public static class a {

            /* renamed from: a, reason: collision with root package name */
            private boolean f١٠٩٨٤a = false;

            /* renamed from: b, reason: collision with root package name */
            private boolean f١٠٩٨٥b = false;

            /* renamed from: c, reason: collision with root package name */
            private boolean f١٠٩٨٦c = false;

            /* renamed from: d, reason: collision with root package name */
            private b f١٠٩٨٧d = b.ALLOW_SINGULAR_OVERWRITES;

            /* renamed from: e, reason: collision with root package name */
            private h2 f١٠٩٨٨e = h2.c();

            public c a() {
                return new c(this.f١٠٩٨٨e, this.f١٠٩٨٤a, this.f١٠٩٨٥b, this.f١٠٩٨٦c, this.f١٠٩٨٧d, null, null);
            }
        }

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        public enum b {
            ALLOW_SINGULAR_OVERWRITES,
            FORBID_SINGULAR_OVERWRITES
        }

        /* synthetic */ c(h2 h2Var, boolean z10, boolean z11, boolean z12, b bVar, g2 g2Var, a aVar) {
            this(h2Var, z10, z11, z12, bVar, g2Var);
        }

        public static a a() {
            return new a();
        }

        private c(h2 h2Var, boolean z10, boolean z11, boolean z12, b bVar, g2 g2Var) {
            this.f١٠٩٧٩a = h2Var;
            this.f١٠٩٨٠b = z10;
            this.f١٠٩٨١c = z11;
            this.f١٠٩٨٢d = z12;
            this.f١٠٩٨٣e = bVar;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class d {

        /* renamed from: c, reason: collision with root package name */
        private static final d f١٠٩٩٢c = new d(true, h2.c());

        /* renamed from: a, reason: collision with root package name */
        private final boolean f١٠٩٩٣a;

        /* renamed from: b, reason: collision with root package name */
        private final h2 f١٠٩٩٤b;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        public static class a implements Comparable {

            /* renamed from: a, reason: collision with root package name */
            private Object f١٠٩٩٥a;

            /* renamed from: b, reason: collision with root package name */
            private final n.g.b f١٠٩٩٦b;

            a(Object obj, n.g gVar) {
                this.f١٠٩٩٥a = obj;
                this.f١٠٩٩٦b = c(gVar);
            }

            private static n.g.b c(n.g gVar) {
                return ((n.g) gVar.r().j().get(0)).q();
            }

            @Override // java.lang.Comparable
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public int compareTo(a aVar) {
                if (e() != null && aVar.e() != null) {
                    int i10 = a.f١٠٩٧٧a[this.f١٠٩٩٦b.ordinal()];
                    if (i10 != 1) {
                        if (i10 != 2) {
                            if (i10 != 3) {
                                if (i10 != 4) {
                                    return 0;
                                }
                                String str = (String) e();
                                String str2 = (String) aVar.e();
                                if (str == null && str2 == null) {
                                    return 0;
                                }
                                if (str == null && str2 != null) {
                                    return -1;
                                }
                                if (str != null && str2 == null) {
                                    return 1;
                                }
                                return str.compareTo(str2);
                            }
                            Integer num = (Integer) e();
                            num.intValue();
                            Integer num2 = (Integer) aVar.e();
                            num2.intValue();
                            return num.compareTo(num2);
                        }
                        Long l10 = (Long) e();
                        l10.longValue();
                        Long l11 = (Long) aVar.e();
                        l11.longValue();
                        return l10.compareTo(l11);
                    }
                    Boolean bool = (Boolean) e();
                    bool.booleanValue();
                    Boolean bool2 = (Boolean) aVar.e();
                    bool2.booleanValue();
                    return bool.compareTo(bool2);
                }
                e2.f١٠٩٧٥a.info("Invalid key for map field.");
                return -1;
            }

            Object d() {
                return this.f١٠٩٩٥a;
            }

            Object e() {
                return null;
            }
        }

        private d(boolean z10, h2 h2Var) {
            this.f١٠٩٩٣a = z10;
            this.f١٠٩٩٤b = h2Var;
        }

        private void b(g1 g1Var, e eVar) {
            if (g1Var.getDescriptorForType().c().equals("google.protobuf.Any") && e(g1Var, eVar)) {
                return;
            }
            h(g1Var, eVar);
        }

        private boolean e(g1 g1Var, e eVar) {
            n.b descriptorForType = g1Var.getDescriptorForType();
            n.g i10 = descriptorForType.i(1);
            n.g i11 = descriptorForType.i(2);
            if (i10 != null && i10.t() == n.g.c.f١١٨٠٥j && i11 != null && i11.t() == n.g.c.f١١٨٠٨m) {
                String str = (String) g1Var.getField(i10);
                if (str.isEmpty()) {
                    return false;
                }
                Object field = g1Var.getField(i11);
                try {
                    n.b b10 = this.f١٠٩٩٤b.b(str);
                    if (b10 == null) {
                        return false;
                    }
                    q.b newBuilderForType = q.k(b10).newBuilderForType();
                    newBuilderForType.m٤٥٠mergeFrom((h) field);
                    eVar.d("[");
                    eVar.d(str);
                    eVar.d("] {");
                    eVar.a();
                    eVar.b();
                    b(newBuilderForType, eVar);
                    eVar.c();
                    eVar.d("}");
                    eVar.a();
                    return true;
                } catch (k0 unused) {
                }
            }
            return false;
        }

        private void f(n.g gVar, Object obj, e eVar) {
            if (gVar.w()) {
                ArrayList arrayList = new ArrayList();
                Iterator it = ((List) obj).iterator();
                while (it.hasNext()) {
                    arrayList.add(new a(it.next(), gVar));
                }
                Collections.sort(arrayList);
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    i(gVar, ((a) it2.next()).d(), eVar);
                }
                return;
            }
            if (gVar.isRepeated()) {
                Iterator it3 = ((List) obj).iterator();
                while (it3.hasNext()) {
                    i(gVar, it3.next(), eVar);
                }
                return;
            }
            i(gVar, obj, eVar);
        }

        private void g(n.g gVar, Object obj, e eVar) {
            String replace;
            switch (a.f١٠٩٧٨b[gVar.t().ordinal()]) {
                case 1:
                case 2:
                case 3:
                    eVar.d(((Integer) obj).toString());
                    return;
                case 4:
                case 5:
                case 6:
                    eVar.d(((Long) obj).toString());
                    return;
                case 7:
                    eVar.d(((Boolean) obj).toString());
                    return;
                case 8:
                    eVar.d(((Float) obj).toString());
                    return;
                case 9:
                    eVar.d(((Double) obj).toString());
                    return;
                case 10:
                case 11:
                    eVar.d(e2.q(((Integer) obj).intValue()));
                    return;
                case 12:
                case 13:
                    eVar.d(e2.r(((Long) obj).longValue()));
                    return;
                case 14:
                    eVar.d("\"");
                    if (this.f١٠٩٩٣a) {
                        replace = f2.e((String) obj);
                    } else {
                        replace = e2.f((String) obj).replace("\n", "\\n");
                    }
                    eVar.d(replace);
                    eVar.d("\"");
                    return;
                case 15:
                    eVar.d("\"");
                    if (obj instanceof h) {
                        eVar.d(e2.d((h) obj));
                    } else {
                        eVar.d(e2.e((byte[]) obj));
                    }
                    eVar.d("\"");
                    return;
                case 16:
                    eVar.d(((n.f) obj).d());
                    return;
                case 17:
                case 18:
                    b((g1) obj, eVar);
                    return;
                default:
                    return;
            }
        }

        private void h(g1 g1Var, e eVar) {
            for (Map.Entry entry : g1Var.getAllFields().entrySet()) {
                f((n.g) entry.getKey(), entry.getValue(), eVar);
            }
            n(g1Var.getUnknownFields(), eVar);
        }

        private void i(n.g gVar, Object obj, e eVar) {
            if (gVar.v()) {
                eVar.d("[");
                if (gVar.l().m().D() && gVar.t() == n.g.c.f١١٨٠٧l && gVar.x() && gVar.o() == gVar.r()) {
                    eVar.d(gVar.r().c());
                } else {
                    eVar.d(gVar.c());
                }
                eVar.d("]");
            } else if (gVar.t() == n.g.c.f١١٨٠٦k) {
                eVar.d(gVar.r().d());
            } else {
                eVar.d(gVar.d());
            }
            n.g.b q10 = gVar.q();
            n.g.b bVar = n.g.b.MESSAGE;
            if (q10 == bVar) {
                eVar.d(" {");
                eVar.a();
                eVar.b();
            } else {
                eVar.d(": ");
            }
            g(gVar, obj, eVar);
            if (gVar.q() == bVar) {
                eVar.c();
                eVar.d("}");
            }
            eVar.a();
        }

        private static void l(int i10, int i11, List list, e eVar) {
            for (Object obj : list) {
                eVar.d(String.valueOf(i10));
                eVar.d(": ");
                m(i11, obj, eVar);
                eVar.a();
            }
        }

        private static void m(int i10, Object obj, e eVar) {
            int b10 = r2.b(i10);
            if (b10 != 0) {
                if (b10 != 1) {
                    if (b10 != 2) {
                        if (b10 != 3) {
                            if (b10 == 5) {
                                eVar.d(String.format(null, "0x%08x", (Integer) obj));
                                return;
                            }
                            throw new IllegalArgumentException("Bad tag: " + i10);
                        }
                        n((k2) obj, eVar);
                        return;
                    }
                    try {
                        k2 h10 = k2.h((h) obj);
                        eVar.d("{");
                        eVar.a();
                        eVar.b();
                        n(h10, eVar);
                        eVar.c();
                        eVar.d("}");
                        return;
                    } catch (k0 unused) {
                        eVar.d("\"");
                        eVar.d(e2.d((h) obj));
                        eVar.d("\"");
                        return;
                    }
                }
                eVar.d(String.format(null, "0x%016x", (Long) obj));
                return;
            }
            eVar.d(e2.r(((Long) obj).longValue()));
        }

        private static void n(k2 k2Var, e eVar) {
            for (Map.Entry entry : k2Var.b().entrySet()) {
                int intValue = ((Integer) entry.getKey()).intValue();
                k2.c cVar = (k2.c) entry.getValue();
                l(intValue, 0, cVar.r(), eVar);
                l(intValue, 5, cVar.k(), eVar);
                l(intValue, 1, cVar.l(), eVar);
                l(intValue, 2, cVar.o(), eVar);
                for (k2 k2Var2 : cVar.m()) {
                    eVar.d(((Integer) entry.getKey()).toString());
                    eVar.d(" {");
                    eVar.a();
                    eVar.b();
                    n(k2Var2, eVar);
                    eVar.c();
                    eVar.d("}");
                    eVar.a();
                }
            }
        }

        public void c(g1 g1Var, Appendable appendable) {
            b(g1Var, e2.i(appendable));
        }

        public void d(k2 k2Var, Appendable appendable) {
            n(k2Var, e2.i(appendable));
        }

        public String j(g1 g1Var) {
            try {
                StringBuilder sb = new StringBuilder();
                c(g1Var, sb);
                return sb.toString();
            } catch (IOException e10) {
                throw new IllegalStateException(e10);
            }
        }

        public String k(k2 k2Var) {
            try {
                StringBuilder sb = new StringBuilder();
                d(k2Var, sb);
                return sb.toString();
            } catch (IOException e10) {
                throw new IllegalStateException(e10);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class e {

        /* renamed from: a, reason: collision with root package name */
        private final Appendable f١٠٩٩٧a;

        /* renamed from: b, reason: collision with root package name */
        private final StringBuilder f١٠٩٩٨b;

        /* renamed from: c, reason: collision with root package name */
        private final boolean f١٠٩٩٩c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f١١٠٠٠d;

        /* synthetic */ e(Appendable appendable, boolean z10, a aVar) {
            this(appendable, z10);
        }

        public void a() {
            if (!this.f١٠٩٩٩c) {
                this.f١٠٩٩٧a.append("\n");
            }
            this.f١١٠٠٠d = true;
        }

        public void b() {
            this.f١٠٩٩٨b.append("  ");
        }

        public void c() {
            int length = this.f١٠٩٩٨b.length();
            if (length != 0) {
                this.f١٠٩٩٨b.setLength(length - 2);
                return;
            }
            throw new IllegalArgumentException(" Outdent() without matching Indent().");
        }

        public void d(CharSequence charSequence) {
            CharSequence charSequence2;
            if (this.f١١٠٠٠d) {
                this.f١١٠٠٠d = false;
                Appendable appendable = this.f١٠٩٩٧a;
                if (this.f١٠٩٩٩c) {
                    charSequence2 = " ";
                } else {
                    charSequence2 = this.f١٠٩٩٨b;
                }
                appendable.append(charSequence2);
            }
            this.f١٠٩٩٧a.append(charSequence);
        }

        private e(Appendable appendable, boolean z10) {
            this.f١٠٩٩٨b = new StringBuilder();
            this.f١١٠٠٠d = false;
            this.f١٠٩٩٧a = appendable;
            this.f١٠٩٩٩c = z10;
        }
    }

    private static int c(byte b10) {
        if (48 > b10 || b10 > 57) {
            return (97 > b10 || b10 > 122) ? b10 - 55 : b10 - 87;
        }
        return b10 - 48;
    }

    public static String d(h hVar) {
        return f2.a(hVar);
    }

    public static String e(byte[] bArr) {
        return f2.c(bArr);
    }

    public static String f(String str) {
        return f2.d(str);
    }

    private static boolean g(byte b10) {
        return (48 <= b10 && b10 <= 57) || (97 <= b10 && b10 <= 102) || (65 <= b10 && b10 <= 70);
    }

    private static boolean h(byte b10) {
        return 48 <= b10 && b10 <= 55;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static e i(Appendable appendable) {
        return new e(appendable, false, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int j(String str) {
        return (int) l(str, true, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long k(String str) {
        return l(str, true, true);
    }

    private static long l(String str, boolean z10, boolean z11) {
        boolean z12;
        int i10;
        int i11 = 0;
        if (str.startsWith("-", 0)) {
            if (z10) {
                i11 = 1;
                z12 = true;
            } else {
                throw new NumberFormatException("Number must be positive: " + str);
            }
        } else {
            z12 = false;
        }
        if (str.startsWith("0x", i11)) {
            i11 += 2;
            i10 = 16;
        } else if (str.startsWith("0", i11)) {
            i10 = 8;
        } else {
            i10 = 10;
        }
        String substring = str.substring(i11);
        if (substring.length() < 16) {
            long parseLong = Long.parseLong(substring, i10);
            if (z12) {
                parseLong = -parseLong;
            }
            if (!z11) {
                if (z10) {
                    if (parseLong > 2147483647L || parseLong < -2147483648L) {
                        throw new NumberFormatException("Number out of range for 32-bit signed integer: " + str);
                    }
                    return parseLong;
                }
                if (parseLong >= 4294967296L || parseLong < 0) {
                    throw new NumberFormatException("Number out of range for 32-bit unsigned integer: " + str);
                }
                return parseLong;
            }
            return parseLong;
        }
        BigInteger bigInteger = new BigInteger(substring, i10);
        if (z12) {
            bigInteger = bigInteger.negate();
        }
        if (!z11) {
            if (z10) {
                if (bigInteger.bitLength() > 31) {
                    throw new NumberFormatException("Number out of range for 32-bit signed integer: " + str);
                }
            } else if (bigInteger.bitLength() > 32) {
                throw new NumberFormatException("Number out of range for 32-bit unsigned integer: " + str);
            }
        } else if (z10) {
            if (bigInteger.bitLength() > 63) {
                throw new NumberFormatException("Number out of range for 64-bit signed integer: " + str);
            }
        } else if (bigInteger.bitLength() > 64) {
            throw new NumberFormatException("Number out of range for 64-bit unsigned integer: " + str);
        }
        return bigInteger.longValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int m(String str) {
        return (int) l(str, false, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long n(String str) {
        return l(str, false, true);
    }

    public static d o() {
        return d.f١٠٩٩٢c;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:46:0x00a9. Please report as an issue. */
    public static h p(CharSequence charSequence) {
        int i10;
        int i11;
        int length;
        int i12;
        h o10 = h.o(charSequence.toString());
        int size = o10.size();
        byte[] bArr = new byte[size];
        int i13 = 0;
        int i14 = 0;
        while (i13 < o10.size()) {
            byte f10 = o10.f(i13);
            if (f10 == 92) {
                int i15 = i13 + 1;
                if (i15 < o10.size()) {
                    byte f11 = o10.f(i15);
                    if (h(f11)) {
                        int c10 = c(f11);
                        int i16 = i13 + 2;
                        if (i16 < o10.size() && h(o10.f(i16))) {
                            c10 = (c10 * 8) + c(o10.f(i16));
                            i15 = i16;
                        }
                        i13 = i15 + 1;
                        if (i13 < o10.size() && h(o10.f(i13))) {
                            c10 = (c10 * 8) + c(o10.f(i13));
                        } else {
                            i13 = i15;
                        }
                        i12 = i14 + 1;
                        bArr[i14] = (byte) c10;
                    } else {
                        if (f11 != 34) {
                            if (f11 != 39) {
                                if (f11 != 63) {
                                    if (f11 != 85) {
                                        if (f11 != 92) {
                                            if (f11 != 102) {
                                                if (f11 != 110) {
                                                    if (f11 != 114) {
                                                        if (f11 != 120) {
                                                            if (f11 != 97) {
                                                                if (f11 != 98) {
                                                                    switch (f11) {
                                                                        case 116:
                                                                            i10 = i14 + 1;
                                                                            bArr[i14] = 9;
                                                                            break;
                                                                        case 117:
                                                                            int i17 = i13 + 2;
                                                                            i11 = i13 + 5;
                                                                            if (i11 < o10.size() && g(o10.f(i17))) {
                                                                                int i18 = i13 + 3;
                                                                                if (g(o10.f(i18))) {
                                                                                    int i19 = i13 + 4;
                                                                                    if (g(o10.f(i19)) && g(o10.f(i11))) {
                                                                                        char c11 = (char) ((c(o10.f(i19)) << 4) | (c(o10.f(i17)) << 12) | (c(o10.f(i18)) << 8) | c(o10.f(i11)));
                                                                                        if (c11 >= 55296 && c11 <= 57343) {
                                                                                            throw new b("Invalid escape sequence: '\\u' refers to a surrogate");
                                                                                        }
                                                                                        byte[] bytes = Character.toString(c11).getBytes(j0.f١١١٦٢b);
                                                                                        System.arraycopy(bytes, 0, bArr, i14, bytes.length);
                                                                                        length = bytes.length;
                                                                                        break;
                                                                                    }
                                                                                }
                                                                            }
                                                                            throw new b("Invalid escape sequence: '\\u' with too few hex chars");
                                                                        case 118:
                                                                            i10 = i14 + 1;
                                                                            bArr[i14] = 11;
                                                                            break;
                                                                        default:
                                                                            throw new b("Invalid escape sequence: '\\" + ((char) f11) + '\'');
                                                                    }
                                                                } else {
                                                                    i10 = i14 + 1;
                                                                    bArr[i14] = 8;
                                                                }
                                                            } else {
                                                                i10 = i14 + 1;
                                                                bArr[i14] = 7;
                                                            }
                                                        } else {
                                                            int i20 = i13 + 2;
                                                            if (i20 < o10.size() && g(o10.f(i20))) {
                                                                int c12 = c(o10.f(i20));
                                                                i13 += 3;
                                                                if (i13 < o10.size() && g(o10.f(i13))) {
                                                                    c12 = (c12 * 16) + c(o10.f(i13));
                                                                } else {
                                                                    i13 = i20;
                                                                }
                                                                i12 = i14 + 1;
                                                                bArr[i14] = (byte) c12;
                                                            } else {
                                                                throw new b("Invalid escape sequence: '\\x' with no digits");
                                                            }
                                                        }
                                                    } else {
                                                        i10 = i14 + 1;
                                                        bArr[i14] = 13;
                                                    }
                                                } else {
                                                    i10 = i14 + 1;
                                                    bArr[i14] = 10;
                                                }
                                            } else {
                                                i10 = i14 + 1;
                                                bArr[i14] = 12;
                                            }
                                        } else {
                                            i10 = i14 + 1;
                                            bArr[i14] = 92;
                                        }
                                    } else {
                                        int i21 = i13 + 2;
                                        i11 = i13 + 9;
                                        if (i11 < o10.size()) {
                                            int i22 = i21;
                                            int i23 = 0;
                                            while (true) {
                                                int i24 = i13 + 10;
                                                if (i22 < i24) {
                                                    byte f12 = o10.f(i22);
                                                    if (g(f12)) {
                                                        i23 = (i23 << 4) | c(f12);
                                                        i22++;
                                                    } else {
                                                        throw new b("Invalid escape sequence: '\\U' with too few hex chars");
                                                    }
                                                } else if (Character.isValidCodePoint(i23)) {
                                                    Character.UnicodeBlock of = Character.UnicodeBlock.of(i23);
                                                    if (of != null && (of.equals(Character.UnicodeBlock.LOW_SURROGATES) || of.equals(Character.UnicodeBlock.HIGH_SURROGATES) || of.equals(Character.UnicodeBlock.HIGH_PRIVATE_USE_SURROGATES))) {
                                                        throw new b("Invalid escape sequence: '\\U" + o10.x(i21, i24).C() + "' refers to a surrogate code unit");
                                                    }
                                                    byte[] bytes2 = new String(new int[]{i23}, 0, 1).getBytes(j0.f١١١٦٢b);
                                                    System.arraycopy(bytes2, 0, bArr, i14, bytes2.length);
                                                    length = bytes2.length;
                                                } else {
                                                    throw new b("Invalid escape sequence: '\\U" + o10.x(i21, i24).C() + "' is not a valid code point value");
                                                }
                                            }
                                        } else {
                                            throw new b("Invalid escape sequence: '\\U' with too few hex chars");
                                        }
                                    }
                                    i14 += length;
                                    i13 = i11;
                                } else {
                                    i10 = i14 + 1;
                                    bArr[i14] = Utf8.REPLACEMENT_BYTE;
                                }
                            } else {
                                i10 = i14 + 1;
                                bArr[i14] = 39;
                            }
                        } else {
                            i10 = i14 + 1;
                            bArr[i14] = 34;
                        }
                        i14 = i10;
                        i13 = i15;
                    }
                    i14 = i12;
                } else {
                    throw new b("Invalid escape sequence: '\\' at end of string.");
                }
            } else {
                bArr[i14] = f10;
                i14++;
            }
            i13++;
        }
        if (size == i14) {
            return h.G(bArr);
        }
        return h.n(bArr, 0, i14);
    }

    public static String q(int i10) {
        if (i10 >= 0) {
            return Integer.toString(i10);
        }
        return Long.toString(i10 & 4294967295L);
    }

    public static String r(long j10) {
        if (j10 >= 0) {
            return Long.toString(j10);
        }
        return BigInteger.valueOf(j10 & LongCompanionObject.MAX_VALUE).setBit(63).toString();
    }
}
