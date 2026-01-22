package com.qmuiteam.qmui.qqface;

import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.util.LruCache;
import androidx.appcompat.app.a0;
import ic.g;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class a {

    /* renamed from: c, reason: collision with root package name */
    private static final Map f١٢٨٨٣c = new HashMap(4);

    /* renamed from: d, reason: collision with root package name */
    private static cc.a f١٢٨٨٤d = new cc.b();

    /* renamed from: a, reason: collision with root package name */
    private LruCache f١٢٨٨٥a = new LruCache(30);

    /* renamed from: b, reason: collision with root package name */
    private cc.a f١٢٨٨٦b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.qmuiteam.qmui.qqface.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public class C٠١٤٦a implements Comparator {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Spannable f١٢٨٨٧a;

        C٠١٤٦a(Spannable spannable) {
            this.f١٢٨٨٧a = spannable;
        }

        public int a(hc.b bVar, hc.b bVar2) {
            int spanStart = this.f١٢٨٨٧a.getSpanStart(bVar);
            int spanStart2 = this.f١٢٨٨٧a.getSpanStart(bVar2);
            if (spanStart > spanStart2) {
                return 1;
            }
            if (spanStart == spanStart2) {
                return 0;
            }
            return -1;
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            a0.a(obj);
            a0.a(obj2);
            return a(null, null);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private d f١٢٨٨٩a;

        /* renamed from: b, reason: collision with root package name */
        private CharSequence f١٢٨٩٠b;

        /* renamed from: c, reason: collision with root package name */
        private int f١٢٨٩١c;

        /* renamed from: d, reason: collision with root package name */
        private Drawable f١٢٨٩٢d;

        /* renamed from: e, reason: collision with root package name */
        private c f١٢٨٩٣e;

        public static b a(int i10) {
            b bVar = new b();
            bVar.f١٢٨٨٩a = d.DRAWABLE;
            bVar.f١٢٨٩١c = i10;
            return bVar;
        }

        public static b b() {
            b bVar = new b();
            bVar.f١٢٨٨٩a = d.NEXTLINE;
            return bVar;
        }

        public static b c(Drawable drawable) {
            b bVar = new b();
            bVar.f١٢٨٨٩a = d.SPECIAL_BOUNDS_DRAWABLE;
            bVar.f١٢٨٩٢d = drawable;
            return bVar;
        }

        public static b d(CharSequence charSequence) {
            b bVar = new b();
            bVar.f١٢٨٨٩a = d.TEXT;
            bVar.f١٢٨٩٠b = charSequence;
            return bVar;
        }

        public static b e(CharSequence charSequence, hc.b bVar, a aVar) {
            b bVar2 = new b();
            bVar2.f١٢٨٨٩a = d.SPAN;
            bVar2.f١٢٨٩٣e = aVar.d(charSequence, 0, charSequence.length(), true);
            return bVar2;
        }

        public c f() {
            return this.f١٢٨٩٣e;
        }

        public int g() {
            return this.f١٢٨٩١c;
        }

        public Drawable h() {
            return this.f١٢٨٩٢d;
        }

        public CharSequence i() {
            return this.f١٢٨٩٠b;
        }

        public hc.b j() {
            return null;
        }

        public d k() {
            return this.f١٢٨٨٩a;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        private int f١٢٨٩٤a;

        /* renamed from: b, reason: collision with root package name */
        private int f١٢٨٩٥b;

        /* renamed from: c, reason: collision with root package name */
        private int f١٢٨٩٦c = 0;

        /* renamed from: d, reason: collision with root package name */
        private int f١٢٨٩٧d = 0;

        /* renamed from: e, reason: collision with root package name */
        private List f١٢٨٩٨e = new ArrayList();

        public c(int i10, int i11) {
            this.f١٢٨٩٤a = i10;
            this.f١٢٨٩٥b = i11;
        }

        public void a(b bVar) {
            if (bVar.k() == d.DRAWABLE) {
                this.f١٢٨٩٦c++;
            } else if (bVar.k() == d.NEXTLINE) {
                this.f١٢٨٩٧d++;
            } else if (bVar.k() == d.SPAN && bVar.f() != null) {
                this.f١٢٨٩٦c += bVar.f().e();
                this.f١٢٨٩٧d += bVar.f().d();
            }
            this.f١٢٨٩٨e.add(bVar);
        }

        public List b() {
            return this.f١٢٨٩٨e;
        }

        public int c() {
            return this.f١٢٨٩٥b;
        }

        public int d() {
            return this.f١٢٨٩٧d;
        }

        public int e() {
            return this.f١٢٨٩٦c;
        }

        public int f() {
            return this.f١٢٨٩٤a;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public enum d {
        TEXT,
        DRAWABLE,
        SPECIAL_BOUNDS_DRAWABLE,
        SPAN,
        NEXTLINE
    }

    private a(cc.a aVar) {
        this.f١٢٨٨٦b = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c d(CharSequence charSequence, int i10, int i11, boolean z10) {
        int i12;
        hc.b[] bVarArr;
        int[] iArr;
        int i13;
        if (g.f(charSequence)) {
            return null;
        }
        if (i10 >= 0 && i10 < charSequence.length()) {
            if (i11 > i10) {
                int length = charSequence.length();
                if (i11 > length) {
                    i12 = length;
                } else {
                    i12 = i11;
                }
                int i14 = 0;
                if (!z10 && (charSequence instanceof Spannable)) {
                    Spannable spannable = (Spannable) charSequence;
                    hc.b[] bVarArr2 = (hc.b[]) spannable.getSpans(0, charSequence.length() - 1, hc.b.class);
                    Arrays.sort(bVarArr2, new C٠١٤٦a(spannable));
                    if (bVarArr2.length > 0) {
                        i13 = 1;
                    } else {
                        i13 = 0;
                    }
                    if (i13 != 0) {
                        int[] iArr2 = new int[bVarArr2.length * 2];
                        while (i14 < bVarArr2.length) {
                            int i15 = i14 * 2;
                            hc.b bVar = bVarArr2[i14];
                            iArr2[i15] = spannable.getSpanStart(null);
                            hc.b bVar2 = bVarArr2[i14];
                            iArr2[i15 + 1] = spannable.getSpanEnd(null);
                            i14++;
                        }
                        i14 = i13;
                        iArr = iArr2;
                        bVarArr = bVarArr2;
                    } else {
                        iArr = null;
                        bVarArr = bVarArr2;
                        i14 = i13;
                    }
                } else {
                    bVarArr = null;
                    iArr = null;
                }
                c cVar = (c) this.f١٢٨٨٥a.get(charSequence);
                if (i14 == 0 && cVar != null && i10 == cVar.f() && i12 == cVar.c()) {
                    return cVar;
                }
                c h10 = h(charSequence, i10, i12, bVarArr, iArr);
                if (i14 == 0 && !z10) {
                    this.f١٢٨٨٥a.put(charSequence, h10);
                }
                return h10;
            }
            throw new IllegalArgumentException("end must > start");
        }
        throw new IllegalArgumentException("start must >= 0 and < text.length");
    }

    public static a e() {
        return f(f١٢٨٨٤d);
    }

    public static a f(cc.a aVar) {
        Map map = f١٢٨٨٣c;
        a aVar2 = (a) map.get(aVar);
        if (aVar2 != null) {
            return aVar2;
        }
        a aVar3 = new a(aVar);
        map.put(aVar, aVar3);
        return aVar3;
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0161  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private c h(CharSequence charSequence, int i10, int i11, hc.b[] bVarArr, int[] iArr) {
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int codePointAt;
        hc.b[] bVarArr2 = bVarArr;
        int length = charSequence.length();
        int i18 = 1;
        if (bVarArr2 != null && bVarArr2.length > 0) {
            int i19 = iArr[0];
            i14 = iArr[1];
            i13 = i19;
            i12 = 0;
        } else {
            i12 = -1;
            i13 = Integer.MAX_VALUE;
            i14 = Integer.MAX_VALUE;
        }
        c cVar = new c(i10, i11);
        if (i10 > 0) {
            cVar.a(b.d(charSequence.subSequence(0, i10)));
        }
        int i20 = i10;
        int i21 = i20;
        loop0: while (true) {
            boolean z10 = false;
            while (i20 < i11) {
                if (i20 == i13) {
                    if (i20 - i21 > 0) {
                        if (z10) {
                            i21--;
                            z10 = false;
                        }
                        cVar.a(b.d(charSequence.subSequence(i21, i20)));
                    }
                    CharSequence subSequence = charSequence.subSequence(i13, i14);
                    hc.b bVar = bVarArr2[i12];
                    cVar.a(b.e(subSequence, null, this));
                    i12++;
                    if (i12 >= bVarArr2.length) {
                        i20 = i14;
                        i21 = i20;
                        i13 = Integer.MAX_VALUE;
                        i14 = Integer.MAX_VALUE;
                    } else {
                        int i22 = i12 * 2;
                        int i23 = iArr[i22];
                        i21 = i14;
                        i14 = iArr[i22 + i18];
                        i13 = i23;
                        i20 = i21;
                    }
                } else {
                    char charAt = charSequence.charAt(i20);
                    if (charAt == '[') {
                        if (i20 - i21 > 0) {
                            cVar.a(b.d(charSequence.subSequence(i21, i20)));
                        }
                        i21 = i20;
                        z10 = true;
                        i20++;
                        i18 = 1;
                    } else if (charAt == ']' && z10) {
                        i20++;
                        if (i20 - i21 > 0) {
                            String charSequence2 = charSequence.subSequence(i21, i20).toString();
                            Drawable e10 = this.f١٢٨٨٦b.e(charSequence2);
                            if (e10 != null) {
                                cVar.a(b.c(e10));
                            } else {
                                int a10 = this.f١٢٨٨٦b.a(charSequence2);
                                if (a10 != 0) {
                                    cVar.a(b.a(a10));
                                }
                            }
                            i21 = i20;
                        }
                        i18 = 1;
                    } else {
                        if (charAt == '\n') {
                            if (z10) {
                                z10 = false;
                            }
                            if (i20 - i21 > 0) {
                                cVar.a(b.d(charSequence.subSequence(i21, i20)));
                            }
                            cVar.a(b.b());
                            i21 = i20 + 1;
                            i20 = i21;
                        } else {
                            if (z10) {
                                if (i20 - i21 > 8) {
                                    z10 = false;
                                } else {
                                    i20++;
                                }
                            }
                            if (this.f١٢٨٨٦b.h(charAt)) {
                                i15 = this.f١٢٨٨٦b.f(charAt);
                                if (i15 != 0) {
                                    i16 = 1;
                                    if (i15 == 0) {
                                        int codePointAt2 = Character.codePointAt(charSequence, i20);
                                        int charCount = Character.charCount(codePointAt2);
                                        if (this.f١٢٨٨٦b.b(codePointAt2)) {
                                            i15 = this.f١٢٨٨٦b.c(codePointAt2);
                                        }
                                        if (i15 == 0 && (i17 = i10 + charCount) < i11 && (i15 = this.f١٢٨٨٦b.d(codePointAt2, (codePointAt = Character.codePointAt(charSequence, i17)))) != 0) {
                                            i16 = charCount + Character.charCount(codePointAt);
                                        } else {
                                            i16 = charCount;
                                        }
                                    }
                                    if (i15 == 0) {
                                        if (i21 != i20) {
                                            cVar.a(b.d(charSequence.subSequence(i21, i20)));
                                        }
                                        cVar.a(b.a(i15));
                                        i20 += i16;
                                        i21 = i20;
                                    } else {
                                        i20++;
                                    }
                                    bVarArr2 = bVarArr;
                                }
                            } else {
                                i15 = 0;
                            }
                            i16 = 0;
                            if (i15 == 0) {
                            }
                            if (i15 == 0) {
                            }
                            bVarArr2 = bVarArr;
                        }
                        i18 = 1;
                    }
                }
            }
            break loop0;
        }
        if (i21 < i11) {
            cVar.a(b.d(charSequence.subSequence(i21, length)));
        }
        return cVar;
    }

    public c b(CharSequence charSequence) {
        if (g.f(charSequence)) {
            return null;
        }
        return c(charSequence, 0, charSequence.length());
    }

    public c c(CharSequence charSequence, int i10, int i11) {
        return d(charSequence, i10, i11, false);
    }

    public int g() {
        return this.f١٢٨٨٦b.g();
    }
}
