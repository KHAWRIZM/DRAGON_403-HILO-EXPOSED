package androidx.profileinstaller;

import android.content.res.AssetManager;
import android.os.Build;
import androidx.profileinstaller.f;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.concurrent.Executor;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private final AssetManager f٣٩٨٠a;

    /* renamed from: b, reason: collision with root package name */
    private final Executor f٣٩٨١b;

    /* renamed from: c, reason: collision with root package name */
    private final f.c f٣٩٨٢c;

    /* renamed from: e, reason: collision with root package name */
    private final File f٣٩٨٤e;

    /* renamed from: f, reason: collision with root package name */
    private final String f٣٩٨٥f;

    /* renamed from: g, reason: collision with root package name */
    private final String f٣٩٨٦g;

    /* renamed from: h, reason: collision with root package name */
    private final String f٣٩٨٧h;

    /* renamed from: j, reason: collision with root package name */
    private c[] f٣٩٨٩j;

    /* renamed from: k, reason: collision with root package name */
    private byte[] f٣٩٩٠k;

    /* renamed from: i, reason: collision with root package name */
    private boolean f٣٩٨٨i = false;

    /* renamed from: d, reason: collision with root package name */
    private final byte[] f٣٩٨٣d = d();

    public b(AssetManager assetManager, Executor executor, f.c cVar, String str, String str2, String str3, File file) {
        this.f٣٩٨٠a = assetManager;
        this.f٣٩٨١b = executor;
        this.f٣٩٨٢c = cVar;
        this.f٣٩٨٥f = str;
        this.f٣٩٨٦g = str2;
        this.f٣٩٨٧h = str3;
        this.f٣٩٨٤e = file;
    }

    private b b(c[] cVarArr, byte[] bArr) {
        InputStream h10;
        try {
            h10 = h(this.f٣٩٨٠a, this.f٣٩٨٧h);
        } catch (FileNotFoundException e10) {
            this.f٣٩٨٢c.a(9, e10);
        } catch (IOException e11) {
            this.f٣٩٨٢c.a(7, e11);
        } catch (IllegalStateException e12) {
            this.f٣٩٨٩j = null;
            this.f٣٩٨٢c.a(8, e12);
        }
        if (h10 != null) {
            try {
                this.f٣٩٨٩j = g.r(h10, g.p(h10, g.f٤٠١٠b), bArr, cVarArr);
                h10.close();
                return this;
            } catch (Throwable th) {
                try {
                    h10.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
        if (h10 != null) {
            h10.close();
        }
        return null;
    }

    private void c() {
        if (this.f٣٩٨٨i) {
        } else {
            throw new IllegalStateException("This device doesn't support aot. Did you call deviceSupportsAotProfile()?");
        }
    }

    private static byte[] d() {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 < 24) {
            return null;
        }
        if (i10 >= 31) {
            return i.f٤٠٢٢a;
        }
        switch (i10) {
            case 24:
            case 25:
                return i.f٤٠٢٦e;
            case 26:
                return i.f٤٠٢٥d;
            case 27:
                return i.f٤٠٢٤c;
            case 28:
            case 29:
            case 30:
                return i.f٤٠٢٣b;
            default:
                return null;
        }
    }

    private InputStream f(AssetManager assetManager) {
        try {
            return h(assetManager, this.f٣٩٨٦g);
        } catch (FileNotFoundException e10) {
            this.f٣٩٨٢c.a(6, e10);
            return null;
        } catch (IOException e11) {
            this.f٣٩٨٢c.a(7, e11);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(int i10, Object obj) {
        this.f٣٩٨٢c.a(i10, obj);
    }

    private InputStream h(AssetManager assetManager, String str) {
        try {
            return assetManager.openFd(str).createInputStream();
        } catch (FileNotFoundException e10) {
            String message = e10.getMessage();
            if (message != null && message.contains("compressed")) {
                this.f٣٩٨٢c.b(5, null);
            }
            return null;
        }
    }

    private c[] j(InputStream inputStream) {
        try {
            try {
                try {
                    try {
                        c[] x10 = g.x(inputStream, g.p(inputStream, g.f٤٠٠٩a), this.f٣٩٨٥f);
                        try {
                            inputStream.close();
                            return x10;
                        } catch (IOException e10) {
                            this.f٣٩٨٢c.a(7, e10);
                            return x10;
                        }
                    } catch (IOException e11) {
                        this.f٣٩٨٢c.a(7, e11);
                        return null;
                    }
                } catch (IllegalStateException e12) {
                    this.f٣٩٨٢c.a(8, e12);
                    inputStream.close();
                    return null;
                }
            } catch (IOException e13) {
                this.f٣٩٨٢c.a(7, e13);
                inputStream.close();
                return null;
            }
        } catch (Throwable th) {
            try {
                inputStream.close();
            } catch (IOException e14) {
                this.f٣٩٨٢c.a(7, e14);
            }
            throw th;
        }
    }

    private static boolean k() {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 < 24) {
            return false;
        }
        if (i10 < 31 && i10 != 24 && i10 != 25) {
            return false;
        }
        return true;
    }

    private void l(final int i10, final Object obj) {
        this.f٣٩٨١b.execute(new Runnable() { // from class: d3.b
            @Override // java.lang.Runnable
            public final void run() {
                androidx.profileinstaller.b.this.g(i10, obj);
            }
        });
    }

    public boolean e() {
        if (this.f٣٩٨٣d == null) {
            l(3, Integer.valueOf(Build.VERSION.SDK_INT));
            return false;
        }
        if (this.f٣٩٨٤e.exists()) {
            if (!this.f٣٩٨٤e.canWrite()) {
                l(4, null);
                return false;
            }
        } else {
            try {
                if (!this.f٣٩٨٤e.createNewFile()) {
                    l(4, null);
                    return false;
                }
            } catch (IOException unused) {
                l(4, null);
                return false;
            }
        }
        this.f٣٩٨٨i = true;
        return true;
    }

    public b i() {
        b b10;
        c();
        if (this.f٣٩٨٣d == null) {
            return this;
        }
        InputStream f10 = f(this.f٣٩٨٠a);
        if (f10 != null) {
            this.f٣٩٨٩j = j(f10);
        }
        c[] cVarArr = this.f٣٩٨٩j;
        if (cVarArr != null && k() && (b10 = b(cVarArr, this.f٣٩٨٣d)) != null) {
            return b10;
        }
        return this;
    }

    public b m() {
        ByteArrayOutputStream byteArrayOutputStream;
        c[] cVarArr = this.f٣٩٨٩j;
        byte[] bArr = this.f٣٩٨٣d;
        if (cVarArr != null && bArr != null) {
            c();
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    g.F(byteArrayOutputStream, bArr);
                } catch (Throwable th) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (IOException e10) {
                this.f٣٩٨٢c.a(7, e10);
            } catch (IllegalStateException e11) {
                this.f٣٩٨٢c.a(8, e11);
            }
            if (!g.C(byteArrayOutputStream, bArr, cVarArr)) {
                this.f٣٩٨٢c.a(5, null);
                this.f٣٩٨٩j = null;
                byteArrayOutputStream.close();
                return this;
            }
            this.f٣٩٩٠k = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            this.f٣٩٨٩j = null;
        }
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean n() {
        byte[] bArr = this.f٣٩٩٠k;
        if (bArr == null) {
            return false;
        }
        c();
        try {
            try {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(this.f٣٩٨٤e);
                    try {
                        FileChannel channel = fileOutputStream.getChannel();
                        try {
                            FileLock tryLock = channel.tryLock();
                            try {
                                d.l(byteArrayInputStream, fileOutputStream, tryLock);
                                l(1, null);
                                if (tryLock != null) {
                                    tryLock.close();
                                }
                                channel.close();
                                fileOutputStream.close();
                                byteArrayInputStream.close();
                                return true;
                            } finally {
                            }
                        } finally {
                        }
                    } catch (Throwable th) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    try {
                        byteArrayInputStream.close();
                    } catch (Throwable th4) {
                        th3.addSuppressed(th4);
                    }
                    throw th3;
                }
            } catch (FileNotFoundException e10) {
                l(6, e10);
                return false;
            } catch (IOException e11) {
                l(7, e11);
                return false;
            }
        } finally {
            this.f٣٩٩٠k = null;
            this.f٣٩٨٩j = null;
        }
    }
}
