package androidx.emoji2.text;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.collection.ArraySet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class f {

    /* renamed from: o, reason: collision with root package name */
    private static final Object f٣٥٩٦o = new Object();

    /* renamed from: p, reason: collision with root package name */
    private static final Object f٣٥٩٧p = new Object();

    /* renamed from: q, reason: collision with root package name */
    private static volatile f f٣٥٩٨q;

    /* renamed from: b, reason: collision with root package name */
    private final Set f٣٦٠٠b;

    /* renamed from: e, reason: collision with root package name */
    private final b f٣٦٠٣e;

    /* renamed from: f, reason: collision with root package name */
    final h f٣٦٠٤f;

    /* renamed from: g, reason: collision with root package name */
    private final j f٣٦٠٥g;

    /* renamed from: h, reason: collision with root package name */
    final boolean f٣٦٠٦h;

    /* renamed from: i, reason: collision with root package name */
    final boolean f٣٦٠٧i;

    /* renamed from: j, reason: collision with root package name */
    final int[] f٣٦٠٨j;

    /* renamed from: k, reason: collision with root package name */
    private final boolean f٣٦٠٩k;

    /* renamed from: l, reason: collision with root package name */
    private final int f٣٦١٠l;

    /* renamed from: m, reason: collision with root package name */
    private final int f٣٦١١m;

    /* renamed from: n, reason: collision with root package name */
    private final e f٣٦١٢n;

    /* renamed from: a, reason: collision with root package name */
    private final ReadWriteLock f٣٥٩٩a = new ReentrantReadWriteLock();

    /* renamed from: c, reason: collision with root package name */
    private volatile int f٣٦٠١c = 3;

    /* renamed from: d, reason: collision with root package name */
    private final Handler f٣٦٠٢d = new Handler(Looper.getMainLooper());

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    private static final class a extends b {

        /* renamed from: b, reason: collision with root package name */
        private volatile androidx.emoji2.text.i f٣٦١٣b;

        /* renamed from: c, reason: collision with root package name */
        private volatile n f٣٦١٤c;

        /* renamed from: androidx.emoji2.text.f$a$a, reason: collision with other inner class name */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
        class C٠٠٣٨a extends i {
            C٠٠٣٨a() {
            }

            @Override // androidx.emoji2.text.f.i
            public void a(Throwable th) {
                a.this.f٣٦١٦a.n(th);
            }

            @Override // androidx.emoji2.text.f.i
            public void b(n nVar) {
                a.this.d(nVar);
            }
        }

        a(f fVar) {
            super(fVar);
        }

        @Override // androidx.emoji2.text.f.b
        void a() {
            try {
                this.f٣٦١٦a.f٣٦٠٤f.a(new C٠٠٣٨a());
            } catch (Throwable th) {
                this.f٣٦١٦a.n(th);
            }
        }

        @Override // androidx.emoji2.text.f.b
        CharSequence b(CharSequence charSequence, int i10, int i11, int i12, boolean z10) {
            return this.f٣٦١٣b.h(charSequence, i10, i11, i12, z10);
        }

        @Override // androidx.emoji2.text.f.b
        void c(EditorInfo editorInfo) {
            editorInfo.extras.putInt("android.support.text.emoji.emojiCompat_metadataVersion", this.f٣٦١٤c.e());
            editorInfo.extras.putBoolean("android.support.text.emoji.emojiCompat_replaceAll", this.f٣٦١٦a.f٣٦٠٦h);
        }

        void d(n nVar) {
            if (nVar == null) {
                this.f٣٦١٦a.n(new IllegalArgumentException("metadataRepo cannot be null"));
                return;
            }
            this.f٣٦١٤c = nVar;
            n nVar2 = this.f٣٦١٤c;
            j jVar = this.f٣٦١٦a.f٣٦٠٥g;
            e eVar = this.f٣٦١٦a.f٣٦١٢n;
            f fVar = this.f٣٦١٦a;
            this.f٣٦١٣b = new androidx.emoji2.text.i(nVar2, jVar, eVar, fVar.f٣٦٠٧i, fVar.f٣٦٠٨j, androidx.emoji2.text.h.a());
            this.f٣٦١٦a.o();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        final f f٣٦١٦a;

        b(f fVar) {
            this.f٣٦١٦a = fVar;
        }

        abstract void a();

        abstract CharSequence b(CharSequence charSequence, int i10, int i11, int i12, boolean z10);

        abstract void c(EditorInfo editorInfo);
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static abstract class c {

        /* renamed from: a, reason: collision with root package name */
        final h f٣٦١٧a;

        /* renamed from: b, reason: collision with root package name */
        j f٣٦١٨b;

        /* renamed from: c, reason: collision with root package name */
        boolean f٣٦١٩c;

        /* renamed from: d, reason: collision with root package name */
        boolean f٣٦٢٠d;

        /* renamed from: e, reason: collision with root package name */
        int[] f٣٦٢١e;

        /* renamed from: f, reason: collision with root package name */
        Set f٣٦٢٢f;

        /* renamed from: g, reason: collision with root package name */
        boolean f٣٦٢٣g;

        /* renamed from: h, reason: collision with root package name */
        int f٣٦٢٤h = -16711936;

        /* renamed from: i, reason: collision with root package name */
        int f٣٦٢٥i = 0;

        /* renamed from: j, reason: collision with root package name */
        e f٣٦٢٦j = new androidx.emoji2.text.e();

        /* JADX INFO: Access modifiers changed from: protected */
        public c(h hVar) {
            androidx.core.util.h.h(hVar, "metadataLoader cannot be null.");
            this.f٣٦١٧a = hVar;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public final h a() {
            return this.f٣٦١٧a;
        }

        public c b(int i10) {
            this.f٣٦٢٥i = i10;
            return this;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class d implements j {
        @Override // androidx.emoji2.text.f.j
        public androidx.emoji2.text.j a(p pVar) {
            return new q(pVar);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public interface e {
        boolean a(CharSequence charSequence, int i10, int i11, int i12);
    }

    /* renamed from: androidx.emoji2.text.f$f, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static abstract class AbstractC٠٠٣٩f {
        public void a(Throwable th) {
        }

        public void b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class g implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final List f٣٦٢٧a;

        /* renamed from: b, reason: collision with root package name */
        private final Throwable f٣٦٢٨b;

        /* renamed from: c, reason: collision with root package name */
        private final int f٣٦٢٩c;

        g(AbstractC٠٠٣٩f r32, int i10) {
            this(Arrays.asList((AbstractC٠٠٣٩f) androidx.core.util.h.h(r32, "initCallback cannot be null")), i10, null);
        }

        @Override // java.lang.Runnable
        public void run() {
            int size = this.f٣٦٢٧a.size();
            int i10 = 0;
            if (this.f٣٦٢٩c != 1) {
                while (i10 < size) {
                    ((AbstractC٠٠٣٩f) this.f٣٦٢٧a.get(i10)).a(this.f٣٦٢٨b);
                    i10++;
                }
            } else {
                while (i10 < size) {
                    ((AbstractC٠٠٣٩f) this.f٣٦٢٧a.get(i10)).b();
                    i10++;
                }
            }
        }

        g(Collection collection, int i10) {
            this(collection, i10, null);
        }

        g(Collection collection, int i10, Throwable th) {
            androidx.core.util.h.h(collection, "initCallbacks cannot be null");
            this.f٣٦٢٧a = new ArrayList(collection);
            this.f٣٦٢٩c = i10;
            this.f٣٦٢٨b = th;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public interface h {
        void a(i iVar);
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static abstract class i {
        public abstract void a(Throwable th);

        public abstract void b(n nVar);
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public interface j {
        androidx.emoji2.text.j a(p pVar);
    }

    private f(c cVar) {
        this.f٣٦٠٦h = cVar.f٣٦١٩c;
        this.f٣٦٠٧i = cVar.f٣٦٢٠d;
        this.f٣٦٠٨j = cVar.f٣٦٢١e;
        this.f٣٦٠٩k = cVar.f٣٦٢٣g;
        this.f٣٦١٠l = cVar.f٣٦٢٤h;
        this.f٣٦٠٤f = cVar.f٣٦١٧a;
        this.f٣٦١١m = cVar.f٣٦٢٥i;
        this.f٣٦١٢n = cVar.f٣٦٢٦j;
        ArraySet arraySet = new ArraySet();
        this.f٣٦٠٠b = arraySet;
        j jVar = cVar.f٣٦١٨b;
        this.f٣٦٠٥g = jVar == null ? new d() : jVar;
        Set set = cVar.f٣٦٢٢f;
        if (set != null && !set.isEmpty()) {
            arraySet.addAll(cVar.f٣٦٢٢f);
        }
        this.f٣٦٠٣e = new a(this);
        m();
    }

    public static f c() {
        f fVar;
        boolean z10;
        synchronized (f٣٥٩٦o) {
            fVar = f٣٥٩٨q;
            if (fVar != null) {
                z10 = true;
            } else {
                z10 = false;
            }
            androidx.core.util.h.i(z10, "EmojiCompat is not initialized.\n\nYou must initialize EmojiCompat prior to referencing the EmojiCompat instance.\n\nThe most likely cause of this error is disabling the EmojiCompatInitializer\neither explicitly in AndroidManifest.xml, or by including\nandroidx.emoji2:emoji2-bundled.\n\nAutomatic initialization is typically performed by EmojiCompatInitializer. If\nyou are not expecting to initialize EmojiCompat manually in your application,\nplease check to ensure it has not been removed from your APK's manifest. You can\ndo this in Android Studio using Build > Analyze APK.\n\nIn the APK Analyzer, ensure that the startup entry for\nEmojiCompatInitializer and InitializationProvider is present in\n AndroidManifest.xml. If it is missing or contains tools:node=\"remove\", and you\nintend to use automatic configuration, verify:\n\n  1. Your application does not include emoji2-bundled\n  2. All modules do not contain an exclusion manifest rule for\n     EmojiCompatInitializer or InitializationProvider. For more information\n     about manifest exclusions see the documentation for the androidx startup\n     library.\n\nIf you intend to use emoji2-bundled, please call EmojiCompat.init. You can\nlearn more in the documentation for BundledEmojiCompatConfig.\n\nIf you intended to perform manual configuration, it is recommended that you call\nEmojiCompat.init immediately on application startup.\n\nIf you still cannot resolve this issue, please open a bug with your specific\nconfiguration to help improve error message.");
        }
        return fVar;
    }

    public static boolean f(InputConnection inputConnection, Editable editable, int i10, int i11, boolean z10) {
        return androidx.emoji2.text.i.b(inputConnection, editable, i10, i11, z10);
    }

    public static boolean g(Editable editable, int i10, KeyEvent keyEvent) {
        return androidx.emoji2.text.i.c(editable, i10, keyEvent);
    }

    public static f h(c cVar) {
        f fVar = f٣٥٩٨q;
        if (fVar == null) {
            synchronized (f٣٥٩٦o) {
                try {
                    fVar = f٣٥٩٨q;
                    if (fVar == null) {
                        fVar = new f(cVar);
                        f٣٥٩٨q = fVar;
                    }
                } finally {
                }
            }
        }
        return fVar;
    }

    public static boolean i() {
        if (f٣٥٩٨q != null) {
            return true;
        }
        return false;
    }

    private boolean k() {
        if (e() == 1) {
            return true;
        }
        return false;
    }

    private void m() {
        this.f٣٥٩٩a.writeLock().lock();
        try {
            if (this.f٣٦١١m == 0) {
                this.f٣٦٠١c = 0;
            }
            this.f٣٥٩٩a.writeLock().unlock();
            if (e() == 0) {
                this.f٣٦٠٣e.a();
            }
        } catch (Throwable th) {
            this.f٣٥٩٩a.writeLock().unlock();
            throw th;
        }
    }

    public int d() {
        return this.f٣٦١٠l;
    }

    public int e() {
        this.f٣٥٩٩a.readLock().lock();
        try {
            return this.f٣٦٠١c;
        } finally {
            this.f٣٥٩٩a.readLock().unlock();
        }
    }

    public boolean j() {
        return this.f٣٦٠٩k;
    }

    public void l() {
        boolean z10 = true;
        if (this.f٣٦١١m != 1) {
            z10 = false;
        }
        androidx.core.util.h.i(z10, "Set metadataLoadStrategy to LOAD_STRATEGY_MANUAL to execute manual loading");
        if (k()) {
            return;
        }
        this.f٣٥٩٩a.writeLock().lock();
        try {
            if (this.f٣٦٠١c == 0) {
                return;
            }
            this.f٣٦٠١c = 0;
            this.f٣٥٩٩a.writeLock().unlock();
            this.f٣٦٠٣e.a();
        } finally {
            this.f٣٥٩٩a.writeLock().unlock();
        }
    }

    void n(Throwable th) {
        ArrayList arrayList = new ArrayList();
        this.f٣٥٩٩a.writeLock().lock();
        try {
            this.f٣٦٠١c = 2;
            arrayList.addAll(this.f٣٦٠٠b);
            this.f٣٦٠٠b.clear();
            this.f٣٥٩٩a.writeLock().unlock();
            this.f٣٦٠٢d.post(new g(arrayList, this.f٣٦٠١c, th));
        } catch (Throwable th2) {
            this.f٣٥٩٩a.writeLock().unlock();
            throw th2;
        }
    }

    void o() {
        ArrayList arrayList = new ArrayList();
        this.f٣٥٩٩a.writeLock().lock();
        try {
            this.f٣٦٠١c = 1;
            arrayList.addAll(this.f٣٦٠٠b);
            this.f٣٦٠٠b.clear();
            this.f٣٥٩٩a.writeLock().unlock();
            this.f٣٦٠٢d.post(new g(arrayList, this.f٣٦٠١c));
        } catch (Throwable th) {
            this.f٣٥٩٩a.writeLock().unlock();
            throw th;
        }
    }

    public CharSequence p(CharSequence charSequence) {
        int length;
        if (charSequence == null) {
            length = 0;
        } else {
            length = charSequence.length();
        }
        return q(charSequence, 0, length);
    }

    public CharSequence q(CharSequence charSequence, int i10, int i11) {
        return r(charSequence, i10, i11, Integer.MAX_VALUE);
    }

    public CharSequence r(CharSequence charSequence, int i10, int i11, int i12) {
        return s(charSequence, i10, i11, i12, 0);
    }

    public CharSequence s(CharSequence charSequence, int i10, int i11, int i12, int i13) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        androidx.core.util.h.i(k(), "Not initialized yet");
        androidx.core.util.h.e(i10, "start cannot be negative");
        androidx.core.util.h.e(i11, "end cannot be negative");
        androidx.core.util.h.e(i12, "maxEmojiCount cannot be negative");
        if (i10 <= i11) {
            z10 = true;
        } else {
            z10 = false;
        }
        androidx.core.util.h.b(z10, "start should be <= than end");
        if (charSequence == null) {
            return null;
        }
        if (i10 <= charSequence.length()) {
            z11 = true;
        } else {
            z11 = false;
        }
        androidx.core.util.h.b(z11, "start should be < than charSequence length");
        if (i11 <= charSequence.length()) {
            z12 = true;
        } else {
            z12 = false;
        }
        androidx.core.util.h.b(z12, "end should be < than charSequence length");
        if (charSequence.length() != 0 && i10 != i11) {
            if (i13 != 1) {
                if (i13 != 2) {
                    z13 = this.f٣٦٠٦h;
                } else {
                    z13 = false;
                }
            } else {
                z13 = true;
            }
            return this.f٣٦٠٣e.b(charSequence, i10, i11, i12, z13);
        }
        return charSequence;
    }

    public void t(AbstractC٠٠٣٩f r42) {
        androidx.core.util.h.h(r42, "initCallback cannot be null");
        this.f٣٥٩٩a.writeLock().lock();
        try {
            if (this.f٣٦٠١c != 1 && this.f٣٦٠١c != 2) {
                this.f٣٦٠٠b.add(r42);
                this.f٣٥٩٩a.writeLock().unlock();
            }
            this.f٣٦٠٢d.post(new g(r42, this.f٣٦٠١c));
            this.f٣٥٩٩a.writeLock().unlock();
        } catch (Throwable th) {
            this.f٣٥٩٩a.writeLock().unlock();
            throw th;
        }
    }

    public void u(AbstractC٠٠٣٩f r22) {
        androidx.core.util.h.h(r22, "initCallback cannot be null");
        this.f٣٥٩٩a.writeLock().lock();
        try {
            this.f٣٦٠٠b.remove(r22);
        } finally {
            this.f٣٥٩٩a.writeLock().unlock();
        }
    }

    public void v(EditorInfo editorInfo) {
        if (k() && editorInfo != null) {
            if (editorInfo.extras == null) {
                editorInfo.extras = new Bundle();
            }
            this.f٣٦٠٣e.c(editorInfo);
        }
    }
}
