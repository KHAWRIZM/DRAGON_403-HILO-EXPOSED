package l2;

import android.text.SpannableStringBuilder;
import java.util.Locale;
import kotlin.text.Typography;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class a {

    /* renamed from: d, reason: collision with root package name */
    static final o f١٥٦٩٢d;

    /* renamed from: e, reason: collision with root package name */
    private static final String f١٥٦٩٣e;

    /* renamed from: f, reason: collision with root package name */
    private static final String f١٥٦٩٤f;

    /* renamed from: g, reason: collision with root package name */
    static final a f١٥٦٩٥g;

    /* renamed from: h, reason: collision with root package name */
    static final a f١٥٦٩٦h;

    /* renamed from: a, reason: collision with root package name */
    private final boolean f١٥٦٩٧a;

    /* renamed from: b, reason: collision with root package name */
    private final int f١٥٦٩٨b;

    /* renamed from: c, reason: collision with root package name */
    private final o f١٥٦٩٩c;

    /* renamed from: l2.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static final class C٠١٨٤a {

        /* renamed from: a, reason: collision with root package name */
        private boolean f١٥٧٠٠a;

        /* renamed from: b, reason: collision with root package name */
        private int f١٥٧٠١b;

        /* renamed from: c, reason: collision with root package name */
        private o f١٥٧٠٢c;

        public C٠١٨٤a() {
            c(a.e(Locale.getDefault()));
        }

        private static a b(boolean z10) {
            if (z10) {
                return a.f١٥٦٩٦h;
            }
            return a.f١٥٦٩٥g;
        }

        private void c(boolean z10) {
            this.f١٥٧٠٠a = z10;
            this.f١٥٧٠٢c = a.f١٥٦٩٢d;
            this.f١٥٧٠١b = 2;
        }

        public a a() {
            if (this.f١٥٧٠١b == 2 && this.f١٥٧٠٢c == a.f١٥٦٩٢d) {
                return b(this.f١٥٧٠٠a);
            }
            return new a(this.f١٥٧٠٠a, this.f١٥٧٠١b, this.f١٥٧٠٢c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class b {

        /* renamed from: f, reason: collision with root package name */
        private static final byte[] f١٥٧٠٣f = new byte[1792];

        /* renamed from: a, reason: collision with root package name */
        private final CharSequence f١٥٧٠٤a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean f١٥٧٠٥b;

        /* renamed from: c, reason: collision with root package name */
        private final int f١٥٧٠٦c;

        /* renamed from: d, reason: collision with root package name */
        private int f١٥٧٠٧d;

        /* renamed from: e, reason: collision with root package name */
        private char f١٥٧٠٨e;

        static {
            for (int i10 = 0; i10 < 1792; i10++) {
                f١٥٧٠٣f[i10] = Character.getDirectionality(i10);
            }
        }

        b(CharSequence charSequence, boolean z10) {
            this.f١٥٧٠٤a = charSequence;
            this.f١٥٧٠٥b = z10;
            this.f١٥٧٠٦c = charSequence.length();
        }

        private static byte c(char c10) {
            if (c10 < 1792) {
                return f١٥٧٠٣f[c10];
            }
            return Character.getDirectionality(c10);
        }

        private byte f() {
            char charAt;
            int i10 = this.f١٥٧٠٧d;
            do {
                int i11 = this.f١٥٧٠٧d;
                if (i11 <= 0) {
                    break;
                }
                CharSequence charSequence = this.f١٥٧٠٤a;
                int i12 = i11 - 1;
                this.f١٥٧٠٧d = i12;
                charAt = charSequence.charAt(i12);
                this.f١٥٧٠٨e = charAt;
                if (charAt == '&') {
                    return (byte) 12;
                }
            } while (charAt != ';');
            this.f١٥٧٠٧d = i10;
            this.f١٥٧٠٨e = ';';
            return (byte) 13;
        }

        private byte g() {
            char charAt;
            do {
                int i10 = this.f١٥٧٠٧d;
                if (i10 < this.f١٥٧٠٦c) {
                    CharSequence charSequence = this.f١٥٧٠٤a;
                    this.f١٥٧٠٧d = i10 + 1;
                    charAt = charSequence.charAt(i10);
                    this.f١٥٧٠٨e = charAt;
                } else {
                    return (byte) 12;
                }
            } while (charAt != ';');
            return (byte) 12;
        }

        private byte h() {
            char charAt;
            int i10 = this.f١٥٧٠٧d;
            while (true) {
                int i11 = this.f١٥٧٠٧d;
                if (i11 <= 0) {
                    break;
                }
                CharSequence charSequence = this.f١٥٧٠٤a;
                int i12 = i11 - 1;
                this.f١٥٧٠٧d = i12;
                char charAt2 = charSequence.charAt(i12);
                this.f١٥٧٠٨e = charAt2;
                if (charAt2 == '<') {
                    return (byte) 12;
                }
                if (charAt2 == '>') {
                    break;
                }
                if (charAt2 == '\"' || charAt2 == '\'') {
                    do {
                        int i13 = this.f١٥٧٠٧d;
                        if (i13 > 0) {
                            CharSequence charSequence2 = this.f١٥٧٠٤a;
                            int i14 = i13 - 1;
                            this.f١٥٧٠٧d = i14;
                            charAt = charSequence2.charAt(i14);
                            this.f١٥٧٠٨e = charAt;
                        }
                    } while (charAt != charAt2);
                }
            }
            this.f١٥٧٠٧d = i10;
            this.f١٥٧٠٨e = Typography.greater;
            return (byte) 13;
        }

        private byte i() {
            char charAt;
            int i10 = this.f١٥٧٠٧d;
            while (true) {
                int i11 = this.f١٥٧٠٧d;
                if (i11 < this.f١٥٧٠٦c) {
                    CharSequence charSequence = this.f١٥٧٠٤a;
                    this.f١٥٧٠٧d = i11 + 1;
                    char charAt2 = charSequence.charAt(i11);
                    this.f١٥٧٠٨e = charAt2;
                    if (charAt2 == '>') {
                        return (byte) 12;
                    }
                    if (charAt2 == '\"' || charAt2 == '\'') {
                        do {
                            int i12 = this.f١٥٧٠٧d;
                            if (i12 < this.f١٥٧٠٦c) {
                                CharSequence charSequence2 = this.f١٥٧٠٤a;
                                this.f١٥٧٠٧d = i12 + 1;
                                charAt = charSequence2.charAt(i12);
                                this.f١٥٧٠٨e = charAt;
                            }
                        } while (charAt != charAt2);
                    }
                } else {
                    this.f١٥٧٠٧d = i10;
                    this.f١٥٧٠٨e = Typography.less;
                    return (byte) 13;
                }
            }
        }

        byte a() {
            char charAt = this.f١٥٧٠٤a.charAt(this.f١٥٧٠٧d - 1);
            this.f١٥٧٠٨e = charAt;
            if (Character.isLowSurrogate(charAt)) {
                int codePointBefore = Character.codePointBefore(this.f١٥٧٠٤a, this.f١٥٧٠٧d);
                this.f١٥٧٠٧d -= Character.charCount(codePointBefore);
                return Character.getDirectionality(codePointBefore);
            }
            this.f١٥٧٠٧d--;
            byte c10 = c(this.f١٥٧٠٨e);
            if (this.f١٥٧٠٥b) {
                char c11 = this.f١٥٧٠٨e;
                if (c11 == '>') {
                    return h();
                }
                if (c11 == ';') {
                    return f();
                }
                return c10;
            }
            return c10;
        }

        byte b() {
            char charAt = this.f١٥٧٠٤a.charAt(this.f١٥٧٠٧d);
            this.f١٥٧٠٨e = charAt;
            if (Character.isHighSurrogate(charAt)) {
                int codePointAt = Character.codePointAt(this.f١٥٧٠٤a, this.f١٥٧٠٧d);
                this.f١٥٧٠٧d += Character.charCount(codePointAt);
                return Character.getDirectionality(codePointAt);
            }
            this.f١٥٧٠٧d++;
            byte c10 = c(this.f١٥٧٠٨e);
            if (this.f١٥٧٠٥b) {
                char c11 = this.f١٥٧٠٨e;
                if (c11 == '<') {
                    return i();
                }
                if (c11 == '&') {
                    return g();
                }
                return c10;
            }
            return c10;
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:46:0x0045. Please report as an issue. */
        int d() {
            this.f١٥٧٠٧d = 0;
            int i10 = 0;
            int i11 = 0;
            int i12 = 0;
            while (this.f١٥٧٠٧d < this.f١٥٧٠٦c && i10 == 0) {
                byte b10 = b();
                if (b10 != 0) {
                    if (b10 != 1 && b10 != 2) {
                        if (b10 != 9) {
                            switch (b10) {
                                case 14:
                                case 15:
                                    i12++;
                                    i11 = -1;
                                    continue;
                                case 16:
                                case 17:
                                    i12++;
                                    i11 = 1;
                                    continue;
                                case 18:
                                    i12--;
                                    i11 = 0;
                                    continue;
                            }
                        }
                    } else if (i12 == 0) {
                        return 1;
                    }
                } else if (i12 == 0) {
                    return -1;
                }
                i10 = i12;
            }
            if (i10 == 0) {
                return 0;
            }
            if (i11 != 0) {
                return i11;
            }
            while (this.f١٥٧٠٧d > 0) {
                switch (a()) {
                    case 14:
                    case 15:
                        if (i10 == i12) {
                            return -1;
                        }
                        i12--;
                    case 16:
                    case 17:
                        if (i10 == i12) {
                            return 1;
                        }
                        i12--;
                    case 18:
                        i12++;
                }
            }
            return 0;
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:33:0x001c. Please report as an issue. */
        int e() {
            this.f١٥٧٠٧d = this.f١٥٧٠٦c;
            int i10 = 0;
            int i11 = 0;
            while (this.f١٥٧٠٧d > 0) {
                byte a10 = a();
                if (a10 != 0) {
                    if (a10 != 1 && a10 != 2) {
                        if (a10 != 9) {
                            switch (a10) {
                                case 14:
                                case 15:
                                    if (i11 == i10) {
                                        return -1;
                                    }
                                    i10--;
                                    break;
                                case 16:
                                case 17:
                                    if (i11 == i10) {
                                        return 1;
                                    }
                                    i10--;
                                    break;
                                case 18:
                                    i10++;
                                    break;
                                default:
                                    if (i11 != 0) {
                                        break;
                                    } else {
                                        i11 = i10;
                                        break;
                                    }
                            }
                        } else {
                            continue;
                        }
                    } else {
                        if (i10 == 0) {
                            return 1;
                        }
                        if (i11 == 0) {
                            i11 = i10;
                        }
                    }
                } else {
                    if (i10 == 0) {
                        return -1;
                    }
                    if (i11 == 0) {
                        i11 = i10;
                    }
                }
            }
            return 0;
        }
    }

    static {
        o oVar = p.f١٥٧٢٠c;
        f١٥٦٩٢d = oVar;
        f١٥٦٩٣e = Character.toString((char) 8206);
        f١٥٦٩٤f = Character.toString((char) 8207);
        f١٥٦٩٥g = new a(false, 2, oVar);
        f١٥٦٩٦h = new a(true, 2, oVar);
    }

    a(boolean z10, int i10, o oVar) {
        this.f١٥٦٩٧a = z10;
        this.f١٥٦٩٨b = i10;
        this.f١٥٦٩٩c = oVar;
    }

    private static int a(CharSequence charSequence) {
        return new b(charSequence, false).d();
    }

    private static int b(CharSequence charSequence) {
        return new b(charSequence, false).e();
    }

    public static a c() {
        return new C٠١٨٤a().a();
    }

    static boolean e(Locale locale) {
        if (q.a(locale) == 1) {
            return true;
        }
        return false;
    }

    private String f(CharSequence charSequence, o oVar) {
        boolean a10 = oVar.a(charSequence, 0, charSequence.length());
        if (!this.f١٥٦٩٧a && (a10 || b(charSequence) == 1)) {
            return f١٥٦٩٣e;
        }
        if (this.f١٥٦٩٧a) {
            if (!a10 || b(charSequence) == -1) {
                return f١٥٦٩٤f;
            }
            return "";
        }
        return "";
    }

    private String g(CharSequence charSequence, o oVar) {
        boolean a10 = oVar.a(charSequence, 0, charSequence.length());
        if (!this.f١٥٦٩٧a && (a10 || a(charSequence) == 1)) {
            return f١٥٦٩٣e;
        }
        if (this.f١٥٦٩٧a) {
            if (!a10 || a(charSequence) == -1) {
                return f١٥٦٩٤f;
            }
            return "";
        }
        return "";
    }

    public boolean d() {
        if ((this.f١٥٦٩٨b & 2) != 0) {
            return true;
        }
        return false;
    }

    public CharSequence h(CharSequence charSequence) {
        return i(charSequence, this.f١٥٦٩٩c, true);
    }

    public CharSequence i(CharSequence charSequence, o oVar, boolean z10) {
        o oVar2;
        char c10;
        o oVar3;
        if (charSequence == null) {
            return null;
        }
        boolean a10 = oVar.a(charSequence, 0, charSequence.length());
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (d() && z10) {
            if (a10) {
                oVar3 = p.f١٥٧١٩b;
            } else {
                oVar3 = p.f١٥٧١٨a;
            }
            spannableStringBuilder.append((CharSequence) g(charSequence, oVar3));
        }
        if (a10 != this.f١٥٦٩٧a) {
            if (a10) {
                c10 = 8235;
            } else {
                c10 = 8234;
            }
            spannableStringBuilder.append(c10);
            spannableStringBuilder.append(charSequence);
            spannableStringBuilder.append((char) 8236);
        } else {
            spannableStringBuilder.append(charSequence);
        }
        if (z10) {
            if (a10) {
                oVar2 = p.f١٥٧١٩b;
            } else {
                oVar2 = p.f١٥٧١٨a;
            }
            spannableStringBuilder.append((CharSequence) f(charSequence, oVar2));
        }
        return spannableStringBuilder;
    }

    public String j(String str) {
        return k(str, this.f١٥٦٩٩c, true);
    }

    public String k(String str, o oVar, boolean z10) {
        if (str == null) {
            return null;
        }
        return i(str, oVar, z10).toString();
    }
}
