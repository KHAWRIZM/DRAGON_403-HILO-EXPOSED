package com.google.android.datatransport.cct;

import b7.g;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class a implements g {

    /* renamed from: c, reason: collision with root package name */
    static final String f٨٠٩٩c;

    /* renamed from: d, reason: collision with root package name */
    static final String f٨١٠٠d;

    /* renamed from: e, reason: collision with root package name */
    private static final String f٨١٠١e;

    /* renamed from: f, reason: collision with root package name */
    private static final Set f٨١٠٢f;

    /* renamed from: g, reason: collision with root package name */
    public static final a f٨١٠٣g;

    /* renamed from: h, reason: collision with root package name */
    public static final a f٨١٠٤h;

    /* renamed from: a, reason: collision with root package name */
    private final String f٨١٠٥a;

    /* renamed from: b, reason: collision with root package name */
    private final String f٨١٠٦b;

    static {
        String a10 = e.a("hts/frbslgiggolai.o/0clgbthfra=snpoo", "tp:/ieaeogn.ogepscmvc/o/ac?omtjo_rt3");
        f٨٠٩٩c = a10;
        String a11 = e.a("hts/frbslgigp.ogepscmv/ieo/eaybtho", "tp:/ieaeogn-agolai.o/1frlglgc/aclg");
        f٨١٠٠d = a11;
        String a12 = e.a("AzSCki82AwsLzKd5O8zo", "IayckHiZRO1EFl1aGoK");
        f٨١٠١e = a12;
        f٨١٠٢f = Collections.unmodifiableSet(new HashSet(Arrays.asList(z6.c.b("proto"), z6.c.b("json"))));
        f٨١٠٣g = new a(a10, null);
        f٨١٠٤h = new a(a11, a12);
    }

    public a(String str, String str2) {
        this.f٨١٠٥a = str;
        this.f٨١٠٦b = str2;
    }

    public static a c(byte[] bArr) {
        String str = new String(bArr, Charset.forName("UTF-8"));
        if (str.startsWith("1$")) {
            String[] split = str.substring(2).split(Pattern.quote("\\"), 2);
            if (split.length == 2) {
                String str2 = split[0];
                if (!str2.isEmpty()) {
                    String str3 = split[1];
                    if (str3.isEmpty()) {
                        str3 = null;
                    }
                    return new a(str2, str3);
                }
                throw new IllegalArgumentException("Missing endpoint in CCTDestination extras");
            }
            throw new IllegalArgumentException("Extra is not a valid encoded LegacyFlgDestination");
        }
        throw new IllegalArgumentException("Version marker missing from extras");
    }

    @Override // b7.g
    public Set a() {
        return f٨١٠٢f;
    }

    public byte[] b() {
        String str = this.f٨١٠٦b;
        if (str == null && this.f٨١٠٥a == null) {
            return null;
        }
        String str2 = this.f٨١٠٥a;
        if (str == null) {
            str = "";
        }
        return String.format("%s%s%s%s", "1$", str2, "\\", str).getBytes(Charset.forName("UTF-8"));
    }

    public String d() {
        return this.f٨١٠٦b;
    }

    public String e() {
        return this.f٨١٠٥a;
    }

    @Override // b7.f
    public byte[] getExtras() {
        return b();
    }

    @Override // b7.f
    public String getName() {
        return "cct";
    }
}
