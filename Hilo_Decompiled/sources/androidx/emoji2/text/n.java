package androidx.emoji2.text;

import android.graphics.Typeface;
import android.util.SparseArray;
import androidx.core.os.y;
import java.nio.ByteBuffer;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    private final w2.b f٣٦٦٩a;

    /* renamed from: b, reason: collision with root package name */
    private final char[] f٣٦٧٠b;

    /* renamed from: c, reason: collision with root package name */
    private final a f٣٦٧١c = new a(1024);

    /* renamed from: d, reason: collision with root package name */
    private final Typeface f٣٦٧٢d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private final SparseArray f٣٦٧٣a;

        /* renamed from: b, reason: collision with root package name */
        private p f٣٦٧٤b;

        private a() {
            this(1);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public a a(int i10) {
            SparseArray sparseArray = this.f٣٦٧٣a;
            if (sparseArray == null) {
                return null;
            }
            return (a) sparseArray.get(i10);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final p b() {
            return this.f٣٦٧٤b;
        }

        void c(p pVar, int i10, int i11) {
            a a10 = a(pVar.b(i10));
            if (a10 == null) {
                a10 = new a();
                this.f٣٦٧٣a.put(pVar.b(i10), a10);
            }
            if (i11 > i10) {
                a10.c(pVar, i10 + 1, i11);
            } else {
                a10.f٣٦٧٤b = pVar;
            }
        }

        a(int i10) {
            this.f٣٦٧٣a = new SparseArray(i10);
        }
    }

    private n(Typeface typeface, w2.b bVar) {
        this.f٣٦٧٢d = typeface;
        this.f٣٦٦٩a = bVar;
        this.f٣٦٧٠b = new char[bVar.k() * 2];
        a(bVar);
    }

    private void a(w2.b bVar) {
        int k10 = bVar.k();
        for (int i10 = 0; i10 < k10; i10++) {
            p pVar = new p(this, i10);
            Character.toChars(pVar.f(), this.f٣٦٧٠b, i10 * 2);
            h(pVar);
        }
    }

    public static n b(Typeface typeface, ByteBuffer byteBuffer) {
        try {
            y.a("EmojiCompat.MetadataRepo.create");
            return new n(typeface, m.b(byteBuffer));
        } finally {
            y.b();
        }
    }

    public char[] c() {
        return this.f٣٦٧٠b;
    }

    public w2.b d() {
        return this.f٣٦٦٩a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int e() {
        return this.f٣٦٦٩a.l();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a f() {
        return this.f٣٦٧١c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Typeface g() {
        return this.f٣٦٧٢d;
    }

    void h(p pVar) {
        boolean z10;
        androidx.core.util.h.h(pVar, "emoji metadata cannot be null");
        if (pVar.c() > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        androidx.core.util.h.b(z10, "invalid metadata codepoint length");
        this.f٣٦٧١c.c(pVar, 0, pVar.c() - 1);
    }
}
