package e0;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;
import okio.BufferedSource;
import okio.Okio;
import okio.Source;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class d implements Runnable {

    /* renamed from: t, reason: collision with root package name */
    public static final Object f١٣٧٥٨t = new Object();

    /* renamed from: u, reason: collision with root package name */
    public static final y f١٣٧٥٩u = new y();

    /* renamed from: v, reason: collision with root package name */
    public static final AtomicInteger f١٣٧٦٠v = new AtomicInteger();

    /* renamed from: w, reason: collision with root package name */
    public static final c0 f١٣٧٦١w = new c0();

    /* renamed from: a, reason: collision with root package name */
    public final int f١٣٧٦٢a = f١٣٧٦٠v.incrementAndGet();

    /* renamed from: b, reason: collision with root package name */
    public final b f١٣٧٦٣b;

    /* renamed from: c, reason: collision with root package name */
    public final c f١٣٧٦٤c;

    /* renamed from: d, reason: collision with root package name */
    public final e f١٣٧٦٥d;

    /* renamed from: e, reason: collision with root package name */
    public final p0 f١٣٧٦٦e;

    /* renamed from: f, reason: collision with root package name */
    public final String f١٣٧٦٧f;

    /* renamed from: g, reason: collision with root package name */
    public final e0 f١٣٧٦٨g;

    /* renamed from: h, reason: collision with root package name */
    public final int f١٣٧٦٩h;

    /* renamed from: i, reason: collision with root package name */
    public int f١٣٧٧٠i;

    /* renamed from: j, reason: collision with root package name */
    public final j0 f١٣٧٧١j;

    /* renamed from: k, reason: collision with root package name */
    public u f١٣٧٧٢k;

    /* renamed from: l, reason: collision with root package name */
    public ArrayList f١٣٧٧٣l;

    /* renamed from: m, reason: collision with root package name */
    public Bitmap f١٣٧٧٤m;

    /* renamed from: n, reason: collision with root package name */
    public Future f١٣٧٧٥n;

    /* renamed from: o, reason: collision with root package name */
    public int f١٣٧٧٦o;

    /* renamed from: p, reason: collision with root package name */
    public Exception f١٣٧٧٧p;

    /* renamed from: q, reason: collision with root package name */
    public int f١٣٧٧٨q;

    /* renamed from: r, reason: collision with root package name */
    public int f١٣٧٧٩r;

    /* renamed from: s, reason: collision with root package name */
    public int f١٣٧٨٠s;

    public d(b bVar, c cVar, r rVar, p0 p0Var, u uVar, j0 j0Var) {
        this.f١٣٧٦٣b = bVar;
        this.f١٣٧٦٤c = cVar;
        this.f١٣٧٦٥d = rVar;
        this.f١٣٧٦٦e = p0Var;
        this.f١٣٧٧٢k = uVar;
        this.f١٣٧٦٧f = uVar.f١٣٨٣١e;
        e0 e0Var = uVar.f١٣٨٢٨b;
        this.f١٣٧٦٨g = e0Var;
        this.f١٣٧٨٠s = e0Var.f١٣٧٨٥c;
        this.f١٣٧٦٩h = uVar.f١٣٨٣٠d;
        this.f١٣٧٧٠i = 0;
        this.f١٣٧٧١j = j0Var;
        this.f١٣٧٧٩r = j0Var.a();
    }

    public static Bitmap b(Source source, e0 e0Var) {
        boolean z10;
        BufferedSource buffer = Okio.buffer(source);
        if (buffer.rangeEquals(0L, u0.f١٣٨٣٦b) && buffer.rangeEquals(8L, u0.f١٣٨٣٧c)) {
            z10 = true;
        } else {
            z10 = false;
        }
        e0Var.getClass();
        if (!z10) {
            Bitmap decodeStream = BitmapFactory.decodeStream(buffer.inputStream(), null, null);
            if (decodeStream != null) {
                return decodeStream;
            }
            throw new IOException("Failed to decode stream.");
        }
        byte[] readByteArray = buffer.readByteArray();
        return BitmapFactory.decodeByteArray(readByteArray, 0, readByteArray.length, null);
    }

    public static void d(e0 e0Var) {
        String hexString;
        Uri uri = e0Var.f١٣٧٨٣a;
        if (uri != null) {
            hexString = String.valueOf(uri.getPath());
        } else {
            hexString = Integer.toHexString(0);
        }
        StringBuilder sb = (StringBuilder) f١٣٧٥٩u.get();
        sb.ensureCapacity(hexString.length() + 11);
        sb.replace(11, sb.length(), hexString);
        Thread.currentThread().setName(sb.toString());
    }

    public final Bitmap a() {
        Bitmap bitmap;
        int i10;
        int i11;
        int i12;
        Bitmap bitmap2 = null;
        if ((this.f١٣٧٦٩h & 1) == 0) {
            bitmap = ((r) this.f١٣٧٦٥d).b(this.f١٣٧٦٧f);
            if (bitmap != null) {
                this.f١٣٧٦٦e.f١٣٨٠٩b.sendEmptyMessage(0);
                this.f١٣٧٧٦o = 1;
                this.f١٣٧٦٣b.getClass();
                return bitmap;
            }
        } else {
            bitmap = null;
        }
        if (this.f١٣٧٧٩r == 0) {
            i10 = 4;
        } else {
            i10 = this.f١٣٧٧٠i;
        }
        this.f١٣٧٧٠i = i10;
        j b10 = this.f١٣٧٧١j.b(this.f١٣٧٦٨g, i10);
        if (b10 != null) {
            this.f١٣٧٧٦o = b10.f١٣٧٩١a;
            this.f١٣٧٧٨q = b10.f١٣٧٩٤d;
            bitmap = b10.f١٣٧٩٢b;
            if (bitmap == null) {
                Source source = b10.f١٣٧٩٣c;
                try {
                    bitmap = b(source, this.f١٣٧٦٨g);
                } finally {
                    try {
                        source.close();
                    } catch (IOException unused) {
                    }
                }
            }
        }
        if (bitmap != null) {
            this.f١٣٧٦٣b.getClass();
            p0 p0Var = this.f١٣٧٦٦e;
            p0Var.getClass();
            int b11 = u0.b(bitmap);
            f0 f0Var = p0Var.f١٣٨٠٩b;
            f0Var.sendMessage(f0Var.obtainMessage(2, b11, 0));
            e0 e0Var = this.f١٣٧٦٨g;
            e0Var.getClass();
            if (e0Var.f١٣٧٨٤b != null || this.f١٣٧٧٨q != 0) {
                synchronized (f١٣٧٥٨t) {
                    try {
                        this.f١٣٧٦٨g.getClass();
                        int i13 = this.f١٣٧٧٨q;
                        if (i13 != 0) {
                            e0 e0Var2 = this.f١٣٧٦٨g;
                            int width = bitmap.getWidth();
                            int height = bitmap.getHeight();
                            e0Var2.getClass();
                            Matrix matrix = new Matrix();
                            if (i13 != 0 && i13 != 0) {
                                switch (i13) {
                                    case 3:
                                    case 4:
                                        i11 = 180;
                                        break;
                                    case 5:
                                    case 6:
                                        i11 = 90;
                                        break;
                                    case 7:
                                    case 8:
                                        i11 = SubsamplingScaleImageView.ORIENTATION_270;
                                        break;
                                    default:
                                        i11 = 0;
                                        break;
                                }
                                if (i13 != 2 && i13 != 7 && i13 != 4 && i13 != 5) {
                                    i12 = 1;
                                } else {
                                    i12 = -1;
                                }
                                if (i11 != 0) {
                                    matrix.preRotate(i11);
                                }
                                if (i12 != 1) {
                                    matrix.postScale(i12, 1.0f);
                                }
                            }
                            Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
                            if (createBitmap != bitmap) {
                                bitmap.recycle();
                                bitmap = createBitmap;
                            }
                            this.f١٣٧٦٣b.getClass();
                        }
                        List list = this.f١٣٧٦٨g.f١٣٧٨٤b;
                        if (list != null) {
                            if (list.size() <= 0) {
                                bitmap2 = bitmap;
                            } else if (list.get(0) == null) {
                                try {
                                    throw null;
                                } catch (RuntimeException e10) {
                                    b.f١٣٧٣٣i.post(new q0(e10));
                                }
                            } else {
                                throw new ClassCastException();
                            }
                            this.f١٣٧٦٣b.getClass();
                            bitmap = bitmap2;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (bitmap != null) {
                    p0 p0Var2 = this.f١٣٧٦٦e;
                    p0Var2.getClass();
                    int b12 = u0.b(bitmap);
                    f0 f0Var2 = p0Var2.f١٣٨٠٩b;
                    f0Var2.sendMessage(f0Var2.obtainMessage(3, b12, 0));
                }
            }
        }
        return bitmap;
    }

    public final void c(u uVar) {
        boolean z10;
        boolean z11;
        int i10 = 1;
        if (this.f١٣٧٧٢k == uVar) {
            this.f١٣٧٧٢k = null;
            z10 = true;
        } else {
            ArrayList arrayList = this.f١٣٧٧٣l;
            if (arrayList != null) {
                z10 = arrayList.remove(uVar);
            } else {
                z10 = false;
            }
        }
        if (z10 && uVar.f١٣٨٢٨b.f١٣٧٨٥c == this.f١٣٧٨٠s) {
            ArrayList arrayList2 = this.f١٣٧٧٣l;
            if (arrayList2 != null && !arrayList2.isEmpty()) {
                z11 = true;
            } else {
                z11 = false;
            }
            u uVar2 = this.f١٣٧٧٢k;
            if (uVar2 != null || z11) {
                if (uVar2 != null) {
                    i10 = uVar2.f١٣٨٢٨b.f١٣٧٨٥c;
                }
                if (z11) {
                    int size = this.f١٣٧٧٣l.size();
                    for (int i11 = 0; i11 < size; i11++) {
                        int i12 = ((u) this.f١٣٧٧٣l.get(i11)).f١٣٨٢٨b.f١٣٧٨٥c;
                        if (h0.a(i12) > h0.a(i10)) {
                            i10 = i12;
                        }
                    }
                }
            }
            this.f١٣٧٨٠s = i10;
        }
        this.f١٣٧٦٣b.getClass();
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            try {
                try {
                    d(this.f١٣٧٦٨g);
                    this.f١٣٧٦٣b.getClass();
                    Bitmap a10 = a();
                    this.f١٣٧٧٤m = a10;
                    if (a10 == null) {
                        this.f١٣٧٦٤c.c(this);
                    } else {
                        this.f١٣٧٦٤c.d(this);
                    }
                    Thread.currentThread().setName("SudPicasso-Idle");
                } catch (w e10) {
                    this.f١٣٧٧٧p = e10;
                    a0 a0Var = this.f١٣٧٦٤c.f١٣٧٥٢h;
                    a0Var.sendMessage(a0Var.obtainMessage(6, this));
                    Thread.currentThread().setName("SudPicasso-Idle");
                } catch (Exception e11) {
                    this.f١٣٧٧٧p = e11;
                    a0 a0Var2 = this.f١٣٧٦٤c.f١٣٧٥٢h;
                    a0Var2.sendMessage(a0Var2.obtainMessage(6, this));
                    Thread.currentThread().setName("SudPicasso-Idle");
                }
            } catch (IOException e12) {
                this.f١٣٧٧٧p = e12;
                a0 a0Var3 = this.f١٣٧٦٤c.f١٣٧٥٢h;
                a0Var3.sendMessageDelayed(a0Var3.obtainMessage(5, this), 500L);
                Thread.currentThread().setName("SudPicasso-Idle");
            } catch (OutOfMemoryError e13) {
                StringWriter stringWriter = new StringWriter();
                this.f١٣٧٦٦e.a().a(new PrintWriter(stringWriter));
                this.f١٣٧٧٧p = new RuntimeException(stringWriter.toString(), e13);
                a0 a0Var4 = this.f١٣٧٦٤c.f١٣٧٥٢h;
                a0Var4.sendMessage(a0Var4.obtainMessage(6, this));
                Thread.currentThread().setName("SudPicasso-Idle");
            }
        } catch (Throwable th) {
            Thread.currentThread().setName("SudPicasso-Idle");
            throw th;
        }
    }
}
