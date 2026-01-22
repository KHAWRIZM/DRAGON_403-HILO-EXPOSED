package androidx.emoji2.text;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.MetaKeyKeyListener;
import android.view.KeyEvent;
import android.view.inputmethod.InputConnection;
import androidx.emoji2.text.f;
import androidx.emoji2.text.n;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    private final f.j f٣٦٣٣a;

    /* renamed from: b, reason: collision with root package name */
    private final n f٣٦٣٤b;

    /* renamed from: c, reason: collision with root package name */
    private f.e f٣٦٣٥c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f٣٦٣٦d;

    /* renamed from: e, reason: collision with root package name */
    private final int[] f٣٦٣٧e;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static final class a {
        static int a(CharSequence charSequence, int i10, int i11) {
            int length = charSequence.length();
            if (i10 < 0 || length < i10 || i11 < 0) {
                return -1;
            }
            while (true) {
                boolean z10 = false;
                while (i11 != 0) {
                    i10--;
                    if (i10 < 0) {
                        if (z10) {
                            return -1;
                        }
                        return 0;
                    }
                    char charAt = charSequence.charAt(i10);
                    if (z10) {
                        if (!Character.isHighSurrogate(charAt)) {
                            return -1;
                        }
                        i11--;
                    } else if (!Character.isSurrogate(charAt)) {
                        i11--;
                    } else {
                        if (Character.isHighSurrogate(charAt)) {
                            return -1;
                        }
                        z10 = true;
                    }
                }
                return i10;
            }
        }

        static int b(CharSequence charSequence, int i10, int i11) {
            int length = charSequence.length();
            if (i10 < 0 || length < i10 || i11 < 0) {
                return -1;
            }
            while (true) {
                boolean z10 = false;
                while (i11 != 0) {
                    if (i10 >= length) {
                        if (z10) {
                            return -1;
                        }
                        return length;
                    }
                    char charAt = charSequence.charAt(i10);
                    if (z10) {
                        if (!Character.isLowSurrogate(charAt)) {
                            return -1;
                        }
                        i11--;
                        i10++;
                    } else if (!Character.isSurrogate(charAt)) {
                        i11--;
                        i10++;
                    } else {
                        if (Character.isLowSurrogate(charAt)) {
                            return -1;
                        }
                        i10++;
                        z10 = true;
                    }
                }
                return i10;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class b implements c {

        /* renamed from: a, reason: collision with root package name */
        public t f٣٦٣٨a;

        /* renamed from: b, reason: collision with root package name */
        private final f.j f٣٦٣٩b;

        b(t tVar, f.j jVar) {
            this.f٣٦٣٨a = tVar;
            this.f٣٦٣٩b = jVar;
        }

        @Override // androidx.emoji2.text.i.c
        public boolean b(CharSequence charSequence, int i10, int i11, p pVar) {
            Spannable spannableString;
            if (pVar.k()) {
                return true;
            }
            if (this.f٣٦٣٨a == null) {
                if (charSequence instanceof Spannable) {
                    spannableString = (Spannable) charSequence;
                } else {
                    spannableString = new SpannableString(charSequence);
                }
                this.f٣٦٣٨a = new t(spannableString);
            }
            this.f٣٦٣٨a.setSpan(this.f٣٦٣٩b.a(pVar), i10, i11, 33);
            return true;
        }

        @Override // androidx.emoji2.text.i.c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public t a() {
            return this.f٣٦٣٨a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public interface c {
        Object a();

        boolean b(CharSequence charSequence, int i10, int i11, p pVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class d implements c {

        /* renamed from: a, reason: collision with root package name */
        private final String f٣٦٤٠a;

        d(String str) {
            this.f٣٦٤٠a = str;
        }

        @Override // androidx.emoji2.text.i.c
        public boolean b(CharSequence charSequence, int i10, int i11, p pVar) {
            if (!TextUtils.equals(charSequence.subSequence(i10, i11), this.f٣٦٤٠a)) {
                return true;
            }
            pVar.l(true);
            return false;
        }

        @Override // androidx.emoji2.text.i.c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public d a() {
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static final class e {

        /* renamed from: a, reason: collision with root package name */
        private int f٣٦٤١a = 1;

        /* renamed from: b, reason: collision with root package name */
        private final n.a f٣٦٤٢b;

        /* renamed from: c, reason: collision with root package name */
        private n.a f٣٦٤٣c;

        /* renamed from: d, reason: collision with root package name */
        private n.a f٣٦٤٤d;

        /* renamed from: e, reason: collision with root package name */
        private int f٣٦٤٥e;

        /* renamed from: f, reason: collision with root package name */
        private int f٣٦٤٦f;

        /* renamed from: g, reason: collision with root package name */
        private final boolean f٣٦٤٧g;

        /* renamed from: h, reason: collision with root package name */
        private final int[] f٣٦٤٨h;

        e(n.a aVar, boolean z10, int[] iArr) {
            this.f٣٦٤٢b = aVar;
            this.f٣٦٤٣c = aVar;
            this.f٣٦٤٧g = z10;
            this.f٣٦٤٨h = iArr;
        }

        private static boolean d(int i10) {
            return i10 == 65039;
        }

        private static boolean f(int i10) {
            return i10 == 65038;
        }

        private int g() {
            this.f٣٦٤١a = 1;
            this.f٣٦٤٣c = this.f٣٦٤٢b;
            this.f٣٦٤٦f = 0;
            return 1;
        }

        private boolean h() {
            if (this.f٣٦٤٣c.b().j() || d(this.f٣٦٤٥e)) {
                return true;
            }
            if (this.f٣٦٤٧g) {
                if (this.f٣٦٤٨h == null) {
                    return true;
                }
                if (Arrays.binarySearch(this.f٣٦٤٨h, this.f٣٦٤٣c.b().b(0)) < 0) {
                    return true;
                }
            }
            return false;
        }

        int a(int i10) {
            n.a a10 = this.f٣٦٤٣c.a(i10);
            int i11 = 2;
            if (this.f٣٦٤١a != 2) {
                if (a10 == null) {
                    i11 = g();
                } else {
                    this.f٣٦٤١a = 2;
                    this.f٣٦٤٣c = a10;
                    this.f٣٦٤٦f = 1;
                }
            } else if (a10 != null) {
                this.f٣٦٤٣c = a10;
                this.f٣٦٤٦f++;
            } else if (f(i10)) {
                i11 = g();
            } else if (!d(i10)) {
                if (this.f٣٦٤٣c.b() != null) {
                    i11 = 3;
                    if (this.f٣٦٤٦f == 1) {
                        if (h()) {
                            this.f٣٦٤٤d = this.f٣٦٤٣c;
                            g();
                        } else {
                            i11 = g();
                        }
                    } else {
                        this.f٣٦٤٤d = this.f٣٦٤٣c;
                        g();
                    }
                } else {
                    i11 = g();
                }
            }
            this.f٣٦٤٥e = i10;
            return i11;
        }

        p b() {
            return this.f٣٦٤٣c.b();
        }

        p c() {
            return this.f٣٦٤٤d.b();
        }

        boolean e() {
            if (this.f٣٦٤١a == 2 && this.f٣٦٤٣c.b() != null && (this.f٣٦٤٦f > 1 || h())) {
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(n nVar, f.j jVar, f.e eVar, boolean z10, int[] iArr, Set set) {
        this.f٣٦٣٣a = jVar;
        this.f٣٦٣٤b = nVar;
        this.f٣٦٣٥c = eVar;
        this.f٣٦٣٦d = z10;
        this.f٣٦٣٧e = iArr;
        g(set);
    }

    private static boolean a(Editable editable, KeyEvent keyEvent, boolean z10) {
        j[] jVarArr;
        if (f(keyEvent)) {
            return false;
        }
        int selectionStart = Selection.getSelectionStart(editable);
        int selectionEnd = Selection.getSelectionEnd(editable);
        if (!e(selectionStart, selectionEnd) && (jVarArr = (j[]) editable.getSpans(selectionStart, selectionEnd, j.class)) != null && jVarArr.length > 0) {
            for (j jVar : jVarArr) {
                int spanStart = editable.getSpanStart(jVar);
                int spanEnd = editable.getSpanEnd(jVar);
                if ((z10 && spanStart == selectionStart) || ((!z10 && spanEnd == selectionStart) || (selectionStart > spanStart && selectionStart < spanEnd))) {
                    editable.delete(spanStart, spanEnd);
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean b(InputConnection inputConnection, Editable editable, int i10, int i11, boolean z10) {
        int max;
        int min;
        if (editable != null && inputConnection != null && i10 >= 0 && i11 >= 0) {
            int selectionStart = Selection.getSelectionStart(editable);
            int selectionEnd = Selection.getSelectionEnd(editable);
            if (e(selectionStart, selectionEnd)) {
                return false;
            }
            if (z10) {
                max = a.a(editable, selectionStart, Math.max(i10, 0));
                min = a.b(editable, selectionEnd, Math.max(i11, 0));
                if (max == -1 || min == -1) {
                    return false;
                }
            } else {
                max = Math.max(selectionStart - i10, 0);
                min = Math.min(selectionEnd + i11, editable.length());
            }
            j[] jVarArr = (j[]) editable.getSpans(max, min, j.class);
            if (jVarArr != null && jVarArr.length > 0) {
                for (j jVar : jVarArr) {
                    int spanStart = editable.getSpanStart(jVar);
                    int spanEnd = editable.getSpanEnd(jVar);
                    max = Math.min(spanStart, max);
                    min = Math.max(spanEnd, min);
                }
                int max2 = Math.max(max, 0);
                int min2 = Math.min(min, editable.length());
                inputConnection.beginBatchEdit();
                editable.delete(max2, min2);
                inputConnection.endBatchEdit();
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean c(Editable editable, int i10, KeyEvent keyEvent) {
        boolean a10;
        if (i10 != 67) {
            if (i10 != 112) {
                a10 = false;
            } else {
                a10 = a(editable, keyEvent, true);
            }
        } else {
            a10 = a(editable, keyEvent, false);
        }
        if (!a10) {
            return false;
        }
        MetaKeyKeyListener.adjustMetaAfterKeypress(editable);
        return true;
    }

    private boolean d(CharSequence charSequence, int i10, int i11, p pVar) {
        if (pVar.d() == 0) {
            pVar.m(this.f٣٦٣٥c.a(charSequence, i10, i11, pVar.h()));
        }
        if (pVar.d() == 2) {
            return true;
        }
        return false;
    }

    private static boolean e(int i10, int i11) {
        return i10 == -1 || i11 == -1 || i10 != i11;
    }

    private static boolean f(KeyEvent keyEvent) {
        return !KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState());
    }

    private void g(Set set) {
        if (set.isEmpty()) {
            return;
        }
        Iterator it = set.iterator();
        while (it.hasNext()) {
            int[] iArr = (int[]) it.next();
            String str = new String(iArr, 0, iArr.length);
            i(str, 0, str.length(), 1, true, new d(str));
        }
    }

    private Object i(CharSequence charSequence, int i10, int i11, int i12, boolean z10, c cVar) {
        int i13;
        e eVar = new e(this.f٣٦٣٤b.f(), this.f٣٦٣٦d, this.f٣٦٣٧e);
        int codePointAt = Character.codePointAt(charSequence, i10);
        int i14 = 0;
        boolean z11 = true;
        loop0: while (true) {
            i13 = i10;
            while (i10 < i11 && i14 < i12 && z11) {
                int a10 = eVar.a(codePointAt);
                if (a10 != 1) {
                    if (a10 != 2) {
                        if (a10 == 3) {
                            if (z10 || !d(charSequence, i13, i10, eVar.c())) {
                                z11 = cVar.b(charSequence, i13, i10, eVar.c());
                                i14++;
                            }
                        }
                    } else {
                        i10 += Character.charCount(codePointAt);
                        if (i10 < i11) {
                            codePointAt = Character.codePointAt(charSequence, i10);
                        }
                    }
                } else {
                    i13 += Character.charCount(Character.codePointAt(charSequence, i13));
                    if (i13 < i11) {
                        codePointAt = Character.codePointAt(charSequence, i13);
                    }
                    i10 = i13;
                }
            }
        }
        if (eVar.e() && i14 < i12 && z11 && (z10 || !d(charSequence, i13, i10, eVar.b()))) {
            cVar.b(charSequence, i13, i10, eVar.b());
        }
        return cVar.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0049 A[Catch: all -> 0x002a, TryCatch #0 {all -> 0x002a, blocks: (B:51:0x000e, B:54:0x0013, B:56:0x0017, B:58:0x0024, B:9:0x003a, B:11:0x0042, B:13:0x0045, B:15:0x0049, B:17:0x0055, B:19:0x0058, B:24:0x0066, B:30:0x0074, B:31:0x0080, B:33:0x0094, B:6:0x002f), top: B:50:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0094 A[Catch: all -> 0x002a, TRY_LEAVE, TryCatch #0 {all -> 0x002a, blocks: (B:51:0x000e, B:54:0x0013, B:56:0x0017, B:58:0x0024, B:9:0x003a, B:11:0x0042, B:13:0x0045, B:15:0x0049, B:17:0x0055, B:19:0x0058, B:24:0x0066, B:30:0x0074, B:31:0x0080, B:33:0x0094, B:6:0x002f), top: B:50:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public CharSequence h(CharSequence charSequence, int i10, int i11, int i12, boolean z10) {
        t tVar;
        int i13;
        t tVar2;
        j[] jVarArr;
        boolean z11 = charSequence instanceof o;
        if (z11) {
            ((o) charSequence).a();
        }
        if (!z11) {
            try {
                if (!(charSequence instanceof Spannable)) {
                    if ((charSequence instanceof Spanned) && ((Spanned) charSequence).nextSpanTransition(i10 - 1, i11 + 1, j.class) <= i11) {
                        tVar = new t(charSequence);
                    } else {
                        tVar = null;
                    }
                    if (tVar != null && (jVarArr = (j[]) tVar.getSpans(i10, i11, j.class)) != null && jVarArr.length > 0) {
                        for (j jVar : jVarArr) {
                            int spanStart = tVar.getSpanStart(jVar);
                            int spanEnd = tVar.getSpanEnd(jVar);
                            if (spanStart != i11) {
                                tVar.removeSpan(jVar);
                            }
                            i10 = Math.min(spanStart, i10);
                            i11 = Math.max(spanEnd, i11);
                        }
                    }
                    i13 = i11;
                    if (i10 != i13 && i10 < charSequence.length()) {
                        if (i12 != Integer.MAX_VALUE && tVar != null) {
                            i12 -= ((j[]) tVar.getSpans(0, tVar.length(), j.class)).length;
                        }
                        tVar2 = (t) i(charSequence, i10, i13, i12, z10, new b(tVar, this.f٣٦٣٣a));
                        if (tVar2 == null) {
                            Spannable b10 = tVar2.b();
                            if (z11) {
                                ((o) charSequence).d();
                            }
                            return b10;
                        }
                        if (z11) {
                            ((o) charSequence).d();
                        }
                        return charSequence;
                    }
                    return charSequence;
                }
            } finally {
                if (z11) {
                    ((o) charSequence).d();
                }
            }
        }
        tVar = new t((Spannable) charSequence);
        if (tVar != null) {
            while (r6 < r5) {
            }
        }
        i13 = i11;
        if (i10 != i13) {
            if (i12 != Integer.MAX_VALUE) {
                i12 -= ((j[]) tVar.getSpans(0, tVar.length(), j.class)).length;
            }
            tVar2 = (t) i(charSequence, i10, i13, i12, z10, new b(tVar, this.f٣٦٣٣a));
            if (tVar2 == null) {
            }
        }
        return charSequence;
    }
}
