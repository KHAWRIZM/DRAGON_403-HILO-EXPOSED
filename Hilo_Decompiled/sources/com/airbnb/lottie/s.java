package com.airbnb.lottie;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.util.Base64;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.luck.picture.lib.config.PictureMimeType;
import io.agora.rtc.Constants;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.zip.GZIPInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import okio.BufferedSource;
import okio.Okio;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class s {

    /* renamed from: a, reason: collision with root package name */
    private static final Map f٦٢٩٣a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private static final Set f٦٢٩٤b = new HashSet();

    /* renamed from: c, reason: collision with root package name */
    private static final byte[] f٦٢٩٥c = {80, 75, 3, 4};

    /* renamed from: d, reason: collision with root package name */
    private static final byte[] f٦٢٩٦d = {31, -117, 8};

    private static o0 A(Context context, ZipInputStream zipInputStream, String str) {
        j a10;
        FileOutputStream fileOutputStream;
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        if (str == null) {
            a10 = null;
        } else {
            try {
                a10 = q3.g.b().a(str);
            } catch (IOException e10) {
                return new o0((Throwable) e10);
            }
        }
        if (a10 != null) {
            return new o0(a10);
        }
        ZipEntry nextEntry = zipInputStream.getNextEntry();
        j jVar = null;
        while (nextEntry != null) {
            String name = nextEntry.getName();
            if (name.contains("__MACOSX")) {
                zipInputStream.closeEntry();
            } else if (nextEntry.getName().equalsIgnoreCase("manifest.json")) {
                zipInputStream.closeEntry();
            } else if (nextEntry.getName().contains(".json")) {
                jVar = (j) r(w3.c.t(Okio.buffer(Okio.source(zipInputStream))), null, false).b();
            } else {
                if (!name.contains(".png") && !name.contains(".webp") && !name.contains(PictureMimeType.JPG) && !name.contains(PictureMimeType.JPEG)) {
                    if (!name.contains(".ttf") && !name.contains(".otf")) {
                        zipInputStream.closeEntry();
                    }
                    String[] split = name.split("/");
                    String str2 = split[split.length - 1];
                    String str3 = str2.split("\\.")[0];
                    File file = new File(context.getCacheDir(), str2);
                    new FileOutputStream(file);
                    try {
                        fileOutputStream = new FileOutputStream(file);
                    } catch (Throwable th) {
                        x3.f.d("Unable to save font " + str3 + " to the temporary file: " + str2 + ". ", th);
                    }
                    try {
                        byte[] bArr = new byte[4096];
                        while (true) {
                            int read = zipInputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            fileOutputStream.write(bArr, 0, read);
                        }
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        Typeface createFromFile = Typeface.createFromFile(file);
                        if (!file.delete()) {
                            x3.f.c("Failed to delete temp font file " + file.getAbsolutePath() + InstructionFileId.DOT);
                        }
                        hashMap2.put(str3, createFromFile);
                    } catch (Throwable th2) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable th3) {
                            th2.addSuppressed(th3);
                        }
                        throw th2;
                        break;
                    }
                }
                String[] split2 = name.split("/");
                hashMap.put(split2[split2.length - 1], BitmapFactory.decodeStream(zipInputStream));
            }
            nextEntry = zipInputStream.getNextEntry();
        }
        if (jVar == null) {
            return new o0((Throwable) new IllegalArgumentException("Unable to parse composition"));
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            k0 i10 = i(jVar, (String) entry.getKey());
            if (i10 != null) {
                i10.g(x3.l.l((Bitmap) entry.getValue(), i10.f(), i10.d()));
            }
        }
        for (Map.Entry entry2 : hashMap2.entrySet()) {
            boolean z10 = false;
            for (q3.c cVar : jVar.g().values()) {
                if (cVar.a().equals(entry2.getKey())) {
                    cVar.e((Typeface) entry2.getValue());
                    z10 = true;
                }
            }
            if (!z10) {
                x3.f.c("Parsed font for " + ((String) entry2.getKey()) + " however it was not found in the animation.");
            }
        }
        if (hashMap.isEmpty()) {
            Iterator it = jVar.j().entrySet().iterator();
            while (it.hasNext()) {
                k0 k0Var = (k0) ((Map.Entry) it.next()).getValue();
                if (k0Var == null) {
                    return null;
                }
                String c10 = k0Var.c();
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inScaled = true;
                options.inDensity = Constants.ERR_ALREADY_IN_RECORDING;
                if (c10.startsWith("data:") && c10.indexOf("base64,") > 0) {
                    try {
                        byte[] decode = Base64.decode(c10.substring(c10.indexOf(44) + 1), 0);
                        k0Var.g(BitmapFactory.decodeByteArray(decode, 0, decode.length, options));
                    } catch (IllegalArgumentException e11) {
                        x3.f.d("data URL did not have correct base64 format.", e11);
                        return null;
                    }
                }
            }
        }
        if (str != null) {
            q3.g.b().c(str, jVar);
        }
        return new o0(jVar);
    }

    private static Boolean B(BufferedSource bufferedSource) {
        return L(bufferedSource, f٦٢٩٦d);
    }

    private static boolean C(Context context) {
        if ((context.getResources().getConfiguration().uiMode & 48) == 32) {
            return true;
        }
        return false;
    }

    private static Boolean D(BufferedSource bufferedSource) {
        return L(bufferedSource, f٦٢٩٥c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void E(String str, AtomicBoolean atomicBoolean, j jVar) {
        Map map = f٦٢٩٣a;
        map.remove(str);
        atomicBoolean.set(true);
        if (map.size() == 0) {
            M(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void F(String str, AtomicBoolean atomicBoolean, Throwable th) {
        Map map = f٦٢٩٣a;
        map.remove(str);
        atomicBoolean.set(true);
        if (map.size() == 0) {
            M(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ o0 J(WeakReference weakReference, Context context, int i10, String str) {
        Context context2 = (Context) weakReference.get();
        if (context2 != null) {
            context = context2;
        }
        return v(context, i10, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ o0 K(Context context, String str, String str2) {
        o0 c10 = e.i(context).c(context, str, str2);
        if (str2 != null && c10.b() != null) {
            q3.g.b().c(str2, (j) c10.b());
        }
        return c10;
    }

    private static Boolean L(BufferedSource bufferedSource, byte[] bArr) {
        try {
            BufferedSource peek = bufferedSource.peek();
            for (byte b10 : bArr) {
                if (peek.readByte() != b10) {
                    return Boolean.FALSE;
                }
            }
            peek.close();
            return Boolean.TRUE;
        } catch (Exception e10) {
            x3.f.b("Failed to check zip file header", e10);
            return Boolean.FALSE;
        } catch (NoSuchMethodError unused) {
            return Boolean.FALSE;
        }
    }

    private static void M(boolean z10) {
        ArrayList arrayList = new ArrayList(f٦٢٩٤b);
        if (arrayList.size() <= 0) {
            return;
        }
        androidx.appcompat.app.a0.a(arrayList.get(0));
        throw null;
    }

    private static String N(Context context, int i10) {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("rawRes");
        if (C(context)) {
            str = "_night_";
        } else {
            str = "_day_";
        }
        sb.append(str);
        sb.append(i10);
        return sb.toString();
    }

    private static q0 h(final String str, Callable callable, Runnable runnable) {
        j a10;
        q0 q0Var = null;
        if (str == null) {
            a10 = null;
        } else {
            a10 = q3.g.b().a(str);
        }
        if (a10 != null) {
            q0Var = new q0(a10);
        }
        if (str != null) {
            Map map = f٦٢٩٣a;
            if (map.containsKey(str)) {
                q0Var = (q0) map.get(str);
            }
        }
        if (q0Var != null) {
            if (runnable != null) {
                runnable.run();
            }
            return q0Var;
        }
        q0 q0Var2 = new q0(callable);
        if (str != null) {
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            q0Var2.d(new l0() { // from class: com.airbnb.lottie.o
                @Override // com.airbnb.lottie.l0
                public final void onResult(Object obj) {
                    s.E(str, atomicBoolean, (j) obj);
                }
            });
            q0Var2.c(new l0() { // from class: com.airbnb.lottie.p
                @Override // com.airbnb.lottie.l0
                public final void onResult(Object obj) {
                    s.F(str, atomicBoolean, (Throwable) obj);
                }
            });
            if (!atomicBoolean.get()) {
                Map map2 = f٦٢٩٣a;
                map2.put(str, q0Var2);
                if (map2.size() == 1) {
                    M(false);
                }
            }
        }
        return q0Var2;
    }

    private static k0 i(j jVar, String str) {
        for (k0 k0Var : jVar.j().values()) {
            if (k0Var.c().equals(str)) {
                return k0Var;
            }
        }
        return null;
    }

    public static q0 j(Context context, String str) {
        return k(context, str, "asset_" + str);
    }

    public static q0 k(Context context, final String str, final String str2) {
        final Context applicationContext = context.getApplicationContext();
        return h(str2, new Callable() { // from class: com.airbnb.lottie.n
            @Override // java.util.concurrent.Callable
            public final Object call() {
                o0 m10;
                m10 = s.m(applicationContext, str, str2);
                return m10;
            }
        }, null);
    }

    public static o0 l(Context context, String str) {
        return m(context, str, "asset_" + str);
    }

    public static o0 m(Context context, String str, String str2) {
        j a10;
        if (str2 == null) {
            a10 = null;
        } else {
            a10 = q3.g.b().a(str2);
        }
        if (a10 != null) {
            return new o0(a10);
        }
        try {
            BufferedSource buffer = Okio.buffer(Okio.source(context.getAssets().open(str)));
            if (D(buffer).booleanValue()) {
                return y(context, new ZipInputStream(buffer.inputStream()), str2);
            }
            if (B(buffer).booleanValue()) {
                return o(new GZIPInputStream(buffer.inputStream()), str2);
            }
            return o(buffer.inputStream(), str2);
        } catch (IOException e10) {
            return new o0((Throwable) e10);
        }
    }

    public static q0 n(final InputStream inputStream, final String str) {
        return h(str, new Callable() { // from class: com.airbnb.lottie.l
            @Override // java.util.concurrent.Callable
            public final Object call() {
                o0 o10;
                o10 = s.o(inputStream, str);
                return o10;
            }
        }, new Runnable() { // from class: com.airbnb.lottie.m
            @Override // java.lang.Runnable
            public final void run() {
                x3.l.c(inputStream);
            }
        });
    }

    public static o0 o(InputStream inputStream, String str) {
        return p(inputStream, str, true);
    }

    public static o0 p(InputStream inputStream, String str, boolean z10) {
        return q(w3.c.t(Okio.buffer(Okio.source(inputStream))), str, z10);
    }

    public static o0 q(w3.c cVar, String str, boolean z10) {
        return r(cVar, str, z10);
    }

    private static o0 r(w3.c cVar, String str, boolean z10) {
        j a10;
        try {
            if (str == null) {
                a10 = null;
            } else {
                try {
                    a10 = q3.g.b().a(str);
                } catch (Exception e10) {
                    o0 o0Var = new o0((Throwable) e10);
                    if (z10) {
                        x3.l.c(cVar);
                    }
                    return o0Var;
                }
            }
            if (a10 != null) {
                o0 o0Var2 = new o0(a10);
                if (z10) {
                    x3.l.c(cVar);
                }
                return o0Var2;
            }
            j a11 = v3.w.a(cVar);
            if (str != null) {
                q3.g.b().c(str, a11);
            }
            o0 o0Var3 = new o0(a11);
            if (z10) {
                x3.l.c(cVar);
            }
            return o0Var3;
        } catch (Throwable th) {
            if (z10) {
                x3.l.c(cVar);
            }
            throw th;
        }
    }

    public static q0 s(Context context, int i10) {
        return t(context, i10, N(context, i10));
    }

    public static q0 t(Context context, final int i10, final String str) {
        final WeakReference weakReference = new WeakReference(context);
        final Context applicationContext = context.getApplicationContext();
        return h(str, new Callable() { // from class: com.airbnb.lottie.q
            @Override // java.util.concurrent.Callable
            public final Object call() {
                o0 J;
                J = s.J(weakReference, applicationContext, i10, str);
                return J;
            }
        }, null);
    }

    public static o0 u(Context context, int i10) {
        return v(context, i10, N(context, i10));
    }

    public static o0 v(Context context, int i10, String str) {
        j a10;
        if (str == null) {
            a10 = null;
        } else {
            a10 = q3.g.b().a(str);
        }
        if (a10 != null) {
            return new o0(a10);
        }
        try {
            BufferedSource buffer = Okio.buffer(Okio.source(context.getResources().openRawResource(i10)));
            if (D(buffer).booleanValue()) {
                return y(context, new ZipInputStream(buffer.inputStream()), str);
            }
            if (B(buffer).booleanValue()) {
                try {
                    return o(new GZIPInputStream(buffer.inputStream()), str);
                } catch (IOException e10) {
                    return new o0((Throwable) e10);
                }
            }
            return o(buffer.inputStream(), str);
        } catch (Resources.NotFoundException e11) {
            return new o0((Throwable) e11);
        }
    }

    public static q0 w(Context context, String str) {
        return x(context, str, "url_" + str);
    }

    public static q0 x(final Context context, final String str, final String str2) {
        return h(str2, new Callable() { // from class: com.airbnb.lottie.k
            @Override // java.util.concurrent.Callable
            public final Object call() {
                o0 K;
                K = s.K(context, str, str2);
                return K;
            }
        }, null);
    }

    public static o0 y(Context context, ZipInputStream zipInputStream, String str) {
        return z(context, zipInputStream, str, true);
    }

    public static o0 z(Context context, ZipInputStream zipInputStream, String str, boolean z10) {
        try {
            return A(context, zipInputStream, str);
        } finally {
            if (z10) {
                x3.l.c(zipInputStream);
            }
        }
    }
}
