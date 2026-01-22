package k4;

import android.os.Build;
import android.os.StrictMode;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class b implements Closeable {

    /* renamed from: a, reason: collision with root package name */
    private final File f١٥٤٩٩a;

    /* renamed from: b, reason: collision with root package name */
    private final File f١٥٥٠٠b;

    /* renamed from: c, reason: collision with root package name */
    private final File f١٥٥٠١c;

    /* renamed from: d, reason: collision with root package name */
    private final File f١٥٥٠٢d;

    /* renamed from: e, reason: collision with root package name */
    private final int f١٥٥٠٣e;

    /* renamed from: f, reason: collision with root package name */
    private long f١٥٥٠٤f;

    /* renamed from: g, reason: collision with root package name */
    private final int f١٥٥٠٥g;

    /* renamed from: i, reason: collision with root package name */
    private Writer f١٥٥٠٧i;

    /* renamed from: k, reason: collision with root package name */
    private int f١٥٥٠٩k;

    /* renamed from: h, reason: collision with root package name */
    private long f١٥٥٠٦h = 0;

    /* renamed from: j, reason: collision with root package name */
    private final LinkedHashMap f١٥٥٠٨j = new LinkedHashMap(0, 0.75f, true);

    /* renamed from: l, reason: collision with root package name */
    private long f١٥٥١٠l = 0;

    /* renamed from: m, reason: collision with root package name */
    final ThreadPoolExecutor f١٥٥١١m = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactoryC٠١٧٩b(null));

    /* renamed from: n, reason: collision with root package name */
    private final Callable f١٥٥١٢n = new a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class a implements Callable {
        a() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call() {
            synchronized (b.this) {
                try {
                    if (b.this.f١٥٥٠٧i != null) {
                        b.this.L();
                        if (b.this.C()) {
                            b.this.H();
                            b.this.f١٥٥٠٩k = 0;
                        }
                        return null;
                    }
                    return null;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    /* renamed from: k4.b$b, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    private static final class ThreadFactoryC٠١٧٩b implements ThreadFactory {
        private ThreadFactoryC٠١٧٩b() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public synchronized Thread newThread(Runnable runnable) {
            Thread thread;
            thread = new Thread(runnable, "glide-disk-lru-cache-thread");
            thread.setPriority(1);
            return thread;
        }

        /* synthetic */ ThreadFactoryC٠١٧٩b(a aVar) {
            this();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public final class c {

        /* renamed from: a, reason: collision with root package name */
        private final d f١٥٥١٤a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean[] f١٥٥١٥b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f١٥٥١٦c;

        /* synthetic */ c(b bVar, d dVar, a aVar) {
            this(dVar);
        }

        public void a() {
            b.this.s(this, false);
        }

        public void b() {
            if (!this.f١٥٥١٦c) {
                try {
                    a();
                } catch (IOException unused) {
                }
            }
        }

        public void e() {
            b.this.s(this, true);
            this.f١٥٥١٦c = true;
        }

        public File f(int i10) {
            File k10;
            synchronized (b.this) {
                try {
                    if (this.f١٥٥١٤a.f١٥٥٢٣f == this) {
                        if (!this.f١٥٥١٤a.f١٥٥٢٢e) {
                            this.f١٥٥١٥b[i10] = true;
                        }
                        k10 = this.f١٥٥١٤a.k(i10);
                        b.this.f١٥٤٩٩a.mkdirs();
                    } else {
                        throw new IllegalStateException();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return k10;
        }

        private c(d dVar) {
            this.f١٥٥١٤a = dVar;
            this.f١٥٥١٥b = dVar.f١٥٥٢٢e ? null : new boolean[b.this.f١٥٥٠٥g];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public final class d {

        /* renamed from: a, reason: collision with root package name */
        private final String f١٥٥١٨a;

        /* renamed from: b, reason: collision with root package name */
        private final long[] f١٥٥١٩b;

        /* renamed from: c, reason: collision with root package name */
        File[] f١٥٥٢٠c;

        /* renamed from: d, reason: collision with root package name */
        File[] f١٥٥٢١d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f١٥٥٢٢e;

        /* renamed from: f, reason: collision with root package name */
        private c f١٥٥٢٣f;

        /* renamed from: g, reason: collision with root package name */
        private long f١٥٥٢٤g;

        /* synthetic */ d(b bVar, String str, a aVar) {
            this(str);
        }

        private IOException m(String[] strArr) {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void n(String[] strArr) {
            if (strArr.length == b.this.f١٥٥٠٥g) {
                for (int i10 = 0; i10 < strArr.length; i10++) {
                    try {
                        this.f١٥٥١٩b[i10] = Long.parseLong(strArr[i10]);
                    } catch (NumberFormatException unused) {
                        throw m(strArr);
                    }
                }
                return;
            }
            throw m(strArr);
        }

        public File j(int i10) {
            return this.f١٥٥٢٠c[i10];
        }

        public File k(int i10) {
            return this.f١٥٥٢١d[i10];
        }

        public String l() {
            StringBuilder sb = new StringBuilder();
            for (long j10 : this.f١٥٥١٩b) {
                sb.append(' ');
                sb.append(j10);
            }
            return sb.toString();
        }

        private d(String str) {
            this.f١٥٥١٨a = str;
            this.f١٥٥١٩b = new long[b.this.f١٥٥٠٥g];
            this.f١٥٥٢٠c = new File[b.this.f١٥٥٠٥g];
            this.f١٥٥٢١d = new File[b.this.f١٥٥٠٥g];
            StringBuilder sb = new StringBuilder(str);
            sb.append('.');
            int length = sb.length();
            for (int i10 = 0; i10 < b.this.f١٥٥٠٥g; i10++) {
                sb.append(i10);
                this.f١٥٥٢٠c[i10] = new File(b.this.f١٥٤٩٩a, sb.toString());
                sb.append(".tmp");
                this.f١٥٥٢١d[i10] = new File(b.this.f١٥٤٩٩a, sb.toString());
                sb.setLength(length);
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public final class e {

        /* renamed from: a, reason: collision with root package name */
        private final String f١٥٥٢٦a;

        /* renamed from: b, reason: collision with root package name */
        private final long f١٥٥٢٧b;

        /* renamed from: c, reason: collision with root package name */
        private final long[] f١٥٥٢٨c;

        /* renamed from: d, reason: collision with root package name */
        private final File[] f١٥٥٢٩d;

        /* synthetic */ e(b bVar, String str, long j10, File[] fileArr, long[] jArr, a aVar) {
            this(str, j10, fileArr, jArr);
        }

        public File a(int i10) {
            return this.f١٥٥٢٩d[i10];
        }

        private e(String str, long j10, File[] fileArr, long[] jArr) {
            this.f١٥٥٢٦a = str;
            this.f١٥٥٢٧b = j10;
            this.f١٥٥٢٩d = fileArr;
            this.f١٥٥٢٨c = jArr;
        }
    }

    private b(File file, int i10, int i11, long j10) {
        this.f١٥٤٩٩a = file;
        this.f١٥٥٠٣e = i10;
        this.f١٥٥٠٠b = new File(file, "journal");
        this.f١٥٥٠١c = new File(file, "journal.tmp");
        this.f١٥٥٠٢d = new File(file, "journal.bkp");
        this.f١٥٥٠٥g = i11;
        this.f١٥٥٠٤f = j10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean C() {
        int i10 = this.f١٥٥٠٩k;
        if (i10 >= 2000 && i10 >= this.f١٥٥٠٨j.size()) {
            return true;
        }
        return false;
    }

    public static b D(File file, int i10, int i11, long j10) {
        if (j10 > 0) {
            if (i11 > 0) {
                File file2 = new File(file, "journal.bkp");
                if (file2.exists()) {
                    File file3 = new File(file, "journal");
                    if (file3.exists()) {
                        file2.delete();
                    } else {
                        K(file2, file3, false);
                    }
                }
                b bVar = new b(file, i10, i11, j10);
                if (bVar.f١٥٥٠٠b.exists()) {
                    try {
                        bVar.F();
                        bVar.E();
                        return bVar;
                    } catch (IOException e10) {
                        System.out.println("DiskLruCache " + file + " is corrupt: " + e10.getMessage() + ", removing");
                        bVar.t();
                    }
                }
                file.mkdirs();
                b bVar2 = new b(file, i10, i11, j10);
                bVar2.H();
                return bVar2;
            }
            throw new IllegalArgumentException("valueCount <= 0");
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    private void E() {
        u(this.f١٥٥٠١c);
        Iterator it = this.f١٥٥٠٨j.values().iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            int i10 = 0;
            if (dVar.f١٥٥٢٣f != null) {
                dVar.f١٥٥٢٣f = null;
                while (i10 < this.f١٥٥٠٥g) {
                    u(dVar.j(i10));
                    u(dVar.k(i10));
                    i10++;
                }
                it.remove();
            } else {
                while (i10 < this.f١٥٥٠٥g) {
                    this.f١٥٥٠٦h += dVar.f١٥٥١٩b[i10];
                    i10++;
                }
            }
        }
    }

    private void F() {
        k4.c cVar = new k4.c(new FileInputStream(this.f١٥٥٠٠b), k4.d.f١٥٥٣٧a);
        try {
            String g10 = cVar.g();
            String g11 = cVar.g();
            String g12 = cVar.g();
            String g13 = cVar.g();
            String g14 = cVar.g();
            if ("libcore.io.DiskLruCache".equals(g10) && "1".equals(g11) && Integer.toString(this.f١٥٥٠٣e).equals(g12) && Integer.toString(this.f١٥٥٠٥g).equals(g13) && "".equals(g14)) {
                int i10 = 0;
                while (true) {
                    try {
                        G(cVar.g());
                        i10++;
                    } catch (EOFException unused) {
                        this.f١٥٥٠٩k = i10 - this.f١٥٥٠٨j.size();
                        if (cVar.c()) {
                            H();
                        } else {
                            this.f١٥٥٠٧i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f١٥٥٠٠b, true), k4.d.f١٥٥٣٧a));
                        }
                        k4.d.a(cVar);
                        return;
                    }
                }
            } else {
                throw new IOException("unexpected journal header: [" + g10 + ", " + g11 + ", " + g13 + ", " + g14 + "]");
            }
        } catch (Throwable th) {
            k4.d.a(cVar);
            throw th;
        }
    }

    private void G(String str) {
        String substring;
        int indexOf = str.indexOf(32);
        if (indexOf != -1) {
            int i10 = indexOf + 1;
            int indexOf2 = str.indexOf(32, i10);
            if (indexOf2 == -1) {
                substring = str.substring(i10);
                if (indexOf == 6 && str.startsWith("REMOVE")) {
                    this.f١٥٥٠٨j.remove(substring);
                    return;
                }
            } else {
                substring = str.substring(i10, indexOf2);
            }
            d dVar = (d) this.f١٥٥٠٨j.get(substring);
            a aVar = null;
            if (dVar == null) {
                dVar = new d(this, substring, aVar);
                this.f١٥٥٠٨j.put(substring, dVar);
            }
            if (indexOf2 != -1 && indexOf == 5 && str.startsWith("CLEAN")) {
                String[] split = str.substring(indexOf2 + 1).split(" ");
                dVar.f١٥٥٢٢e = true;
                dVar.f١٥٥٢٣f = null;
                dVar.n(split);
                return;
            }
            if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
                dVar.f١٥٥٢٣f = new c(this, dVar, aVar);
                return;
            }
            if (indexOf2 == -1 && indexOf == 4 && str.startsWith("READ")) {
                return;
            }
            throw new IOException("unexpected journal line: " + str);
        }
        throw new IOException("unexpected journal line: " + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void H() {
        try {
            Writer writer = this.f١٥٥٠٧i;
            if (writer != null) {
                q(writer);
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f١٥٥٠١c), k4.d.f١٥٥٣٧a));
            try {
                bufferedWriter.write("libcore.io.DiskLruCache");
                bufferedWriter.write("\n");
                bufferedWriter.write("1");
                bufferedWriter.write("\n");
                bufferedWriter.write(Integer.toString(this.f١٥٥٠٣e));
                bufferedWriter.write("\n");
                bufferedWriter.write(Integer.toString(this.f١٥٥٠٥g));
                bufferedWriter.write("\n");
                bufferedWriter.write("\n");
                for (d dVar : this.f١٥٥٠٨j.values()) {
                    if (dVar.f١٥٥٢٣f != null) {
                        bufferedWriter.write("DIRTY " + dVar.f١٥٥١٨a + '\n');
                    } else {
                        bufferedWriter.write("CLEAN " + dVar.f١٥٥١٨a + dVar.l() + '\n');
                    }
                }
                q(bufferedWriter);
                if (this.f١٥٥٠٠b.exists()) {
                    K(this.f١٥٥٠٠b, this.f١٥٥٠٢d, true);
                }
                K(this.f١٥٥٠١c, this.f١٥٥٠٠b, false);
                this.f١٥٥٠٢d.delete();
                this.f١٥٥٠٧i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f١٥٥٠٠b, true), k4.d.f١٥٥٣٧a));
            } catch (Throwable th) {
                q(bufferedWriter);
                throw th;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    private static void K(File file, File file2, boolean z10) {
        if (z10) {
            u(file2);
        }
        if (file.renameTo(file2)) {
        } else {
            throw new IOException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L() {
        while (this.f١٥٥٠٦h > this.f١٥٥٠٤f) {
            I((String) ((Map.Entry) this.f١٥٥٠٨j.entrySet().iterator().next()).getKey());
        }
    }

    private void o() {
        if (this.f١٥٥٠٧i != null) {
        } else {
            throw new IllegalStateException("cache is closed");
        }
    }

    private static void q(Writer writer) {
        StrictMode.ThreadPolicy.Builder permitUnbufferedIo;
        if (Build.VERSION.SDK_INT < 26) {
            writer.close();
            return;
        }
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        permitUnbufferedIo = new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo();
        StrictMode.setThreadPolicy(permitUnbufferedIo.build());
        try {
            writer.close();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void s(c cVar, boolean z10) {
        d dVar = cVar.f١٥٥١٤a;
        if (dVar.f١٥٥٢٣f == cVar) {
            if (z10 && !dVar.f١٥٥٢٢e) {
                for (int i10 = 0; i10 < this.f١٥٥٠٥g; i10++) {
                    if (cVar.f١٥٥١٥b[i10]) {
                        if (!dVar.k(i10).exists()) {
                            cVar.a();
                            return;
                        }
                    } else {
                        cVar.a();
                        throw new IllegalStateException("Newly created entry didn't create value for index " + i10);
                    }
                }
            }
            for (int i11 = 0; i11 < this.f١٥٥٠٥g; i11++) {
                File k10 = dVar.k(i11);
                if (z10) {
                    if (k10.exists()) {
                        File j10 = dVar.j(i11);
                        k10.renameTo(j10);
                        long j11 = dVar.f١٥٥١٩b[i11];
                        long length = j10.length();
                        dVar.f١٥٥١٩b[i11] = length;
                        this.f١٥٥٠٦h = (this.f١٥٥٠٦h - j11) + length;
                    }
                } else {
                    u(k10);
                }
            }
            this.f١٥٥٠٩k++;
            dVar.f١٥٥٢٣f = null;
            if (dVar.f١٥٥٢٢e | z10) {
                dVar.f١٥٥٢٢e = true;
                this.f١٥٥٠٧i.append((CharSequence) "CLEAN");
                this.f١٥٥٠٧i.append(' ');
                this.f١٥٥٠٧i.append((CharSequence) dVar.f١٥٥١٨a);
                this.f١٥٥٠٧i.append((CharSequence) dVar.l());
                this.f١٥٥٠٧i.append('\n');
                if (z10) {
                    long j12 = this.f١٥٥١٠l;
                    this.f١٥٥١٠l = 1 + j12;
                    dVar.f١٥٥٢٤g = j12;
                }
            } else {
                this.f١٥٥٠٨j.remove(dVar.f١٥٥١٨a);
                this.f١٥٥٠٧i.append((CharSequence) "REMOVE");
                this.f١٥٥٠٧i.append(' ');
                this.f١٥٥٠٧i.append((CharSequence) dVar.f١٥٥١٨a);
                this.f١٥٥٠٧i.append('\n');
            }
            z(this.f١٥٥٠٧i);
            if (this.f١٥٥٠٦h > this.f١٥٥٠٤f || C()) {
                this.f١٥٥١١m.submit(this.f١٥٥١٢n);
            }
            return;
        }
        throw new IllegalStateException();
    }

    private static void u(File file) {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    private synchronized c x(String str, long j10) {
        o();
        d dVar = (d) this.f١٥٥٠٨j.get(str);
        a aVar = null;
        if (j10 != -1 && (dVar == null || dVar.f١٥٥٢٤g != j10)) {
            return null;
        }
        if (dVar == null) {
            dVar = new d(this, str, aVar);
            this.f١٥٥٠٨j.put(str, dVar);
        } else if (dVar.f١٥٥٢٣f != null) {
            return null;
        }
        c cVar = new c(this, dVar, aVar);
        dVar.f١٥٥٢٣f = cVar;
        this.f١٥٥٠٧i.append((CharSequence) "DIRTY");
        this.f١٥٥٠٧i.append(' ');
        this.f١٥٥٠٧i.append((CharSequence) str);
        this.f١٥٥٠٧i.append('\n');
        z(this.f١٥٥٠٧i);
        return cVar;
    }

    private static void z(Writer writer) {
        StrictMode.ThreadPolicy.Builder permitUnbufferedIo;
        if (Build.VERSION.SDK_INT < 26) {
            writer.flush();
            return;
        }
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        permitUnbufferedIo = new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo();
        StrictMode.setThreadPolicy(permitUnbufferedIo.build());
        try {
            writer.flush();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    public synchronized e A(String str) {
        o();
        d dVar = (d) this.f١٥٥٠٨j.get(str);
        if (dVar == null) {
            return null;
        }
        if (!dVar.f١٥٥٢٢e) {
            return null;
        }
        for (File file : dVar.f١٥٥٢٠c) {
            if (!file.exists()) {
                return null;
            }
        }
        this.f١٥٥٠٩k++;
        this.f١٥٥٠٧i.append((CharSequence) "READ");
        this.f١٥٥٠٧i.append(' ');
        this.f١٥٥٠٧i.append((CharSequence) str);
        this.f١٥٥٠٧i.append('\n');
        if (C()) {
            this.f١٥٥١١m.submit(this.f١٥٥١٢n);
        }
        return new e(this, str, dVar.f١٥٥٢٤g, dVar.f١٥٥٢٠c, dVar.f١٥٥١٩b, null);
    }

    public synchronized boolean I(String str) {
        try {
            o();
            d dVar = (d) this.f١٥٥٠٨j.get(str);
            if (dVar != null && dVar.f١٥٥٢٣f == null) {
                for (int i10 = 0; i10 < this.f١٥٥٠٥g; i10++) {
                    File j10 = dVar.j(i10);
                    if (j10.exists() && !j10.delete()) {
                        throw new IOException("failed to delete " + j10);
                    }
                    this.f١٥٥٠٦h -= dVar.f١٥٥١٩b[i10];
                    dVar.f١٥٥١٩b[i10] = 0;
                }
                this.f١٥٥٠٩k++;
                this.f١٥٥٠٧i.append((CharSequence) "REMOVE");
                this.f١٥٥٠٧i.append(' ');
                this.f١٥٥٠٧i.append((CharSequence) str);
                this.f١٥٥٠٧i.append('\n');
                this.f١٥٥٠٨j.remove(str);
                if (C()) {
                    this.f١٥٥١١m.submit(this.f١٥٥١٢n);
                }
                return true;
            }
            return false;
        } finally {
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        try {
            if (this.f١٥٥٠٧i == null) {
                return;
            }
            Iterator it = new ArrayList(this.f١٥٥٠٨j.values()).iterator();
            while (it.hasNext()) {
                d dVar = (d) it.next();
                if (dVar.f١٥٥٢٣f != null) {
                    dVar.f١٥٥٢٣f.a();
                }
            }
            L();
            q(this.f١٥٥٠٧i);
            this.f١٥٥٠٧i = null;
        } catch (Throwable th) {
            throw th;
        }
    }

    public void t() {
        close();
        k4.d.b(this.f١٥٤٩٩a);
    }

    public c w(String str) {
        return x(str, -1L);
    }
}
