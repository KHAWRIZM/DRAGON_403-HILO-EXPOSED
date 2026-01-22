package b1;

import f0.h;
import io.agora.rtc.Constants;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.CodingErrorAction;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import kotlin.jvm.internal.ByteCompanionObject;
import p0.g;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class e implements b {

    /* renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ boolean f٥٣٣٧o = true;

    /* renamed from: b, reason: collision with root package name */
    public final d f٥٣٣٩b;

    /* renamed from: e, reason: collision with root package name */
    public final e1.b f٥٣٤٢e;

    /* renamed from: f, reason: collision with root package name */
    public final int f٥٣٤٣f;

    /* renamed from: n, reason: collision with root package name */
    public f0.e f٥٣٥١n;

    /* renamed from: c, reason: collision with root package name */
    public volatile boolean f٥٣٤٠c = false;

    /* renamed from: d, reason: collision with root package name */
    public int f٥٣٤١d = 1;

    /* renamed from: g, reason: collision with root package name */
    public ByteBuffer f٥٣٤٤g = ByteBuffer.allocate(0);

    /* renamed from: h, reason: collision with root package name */
    public p0.d f٥٣٤٥h = null;

    /* renamed from: i, reason: collision with root package name */
    public String f٥٣٤٦i = null;

    /* renamed from: j, reason: collision with root package name */
    public Integer f٥٣٤٧j = null;

    /* renamed from: k, reason: collision with root package name */
    public Boolean f٥٣٤٨k = null;

    /* renamed from: l, reason: collision with root package name */
    public long f٥٣٤٩l = System.currentTimeMillis();

    /* renamed from: m, reason: collision with root package name */
    public final Object f٥٣٥٠m = new Object();

    /* renamed from: a, reason: collision with root package name */
    public final LinkedBlockingQueue f٥٣٣٨a = new LinkedBlockingQueue();

    public e(d dVar, e1.b bVar) {
        int i10 = 0;
        this.f٥٣٤٢e = null;
        new LinkedBlockingQueue();
        this.f٥٣٣٩b = dVar;
        this.f٥٣٤٣f = 1;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = bVar.f١٣٨٥٦c;
        int size = arrayList2.size();
        int i11 = 0;
        while (i11 < size) {
            Object obj = arrayList2.get(i11);
            i11++;
            ((o1.a) obj).getClass();
            arrayList.add(new o1.a());
        }
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = bVar.f١٣٨٥٨e;
        int size2 = arrayList4.size();
        while (i10 < size2) {
            Object obj2 = arrayList4.get(i10);
            i10++;
            ((u0.a) obj2).getClass();
            arrayList3.add(new u0.a());
        }
        this.f٥٣٤٢e = new e1.b(arrayList, arrayList3);
    }

    @Override // b1.b
    public final void a(f0.a aVar) {
        c(Collections.singletonList(aVar));
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0108  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void b(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2;
        int i10;
        boolean z10 = f٥٣٣٧o;
        if (!z10 && !byteBuffer.hasRemaining()) {
            throw new AssertionError();
        }
        int i11 = this.f٥٣٤١d;
        if (i11 != 1) {
            if (i11 == 3) {
                f(byteBuffer);
            }
        } else {
            if (this.f٥٣٤٤g.capacity() == 0) {
                byteBuffer2 = byteBuffer;
            } else {
                if (this.f٥٣٤٤g.remaining() < byteBuffer.remaining()) {
                    ByteBuffer allocate = ByteBuffer.allocate(byteBuffer.remaining() + this.f٥٣٤٤g.capacity());
                    this.f٥٣٤٤g.flip();
                    allocate.put(this.f٥٣٤٤g);
                    this.f٥٣٤٤g = allocate;
                }
                this.f٥٣٤٤g.put(byteBuffer);
                this.f٥٣٤٤g.flip();
                byteBuffer2 = this.f٥٣٤٤g;
            }
            byteBuffer2.mark();
            try {
                try {
                    int i12 = this.f٥٣٤٣f;
                    if (i12 == 2) {
                        e1.b bVar = this.f٥٣٤٢e;
                        bVar.getClass();
                        p0.e b10 = bVar.b(byteBuffer2);
                        if (!(b10 instanceof p0.b)) {
                            d(1002, "wrong http function", false);
                        } else {
                            p0.b bVar2 = (p0.b) b10;
                            if (this.f٥٣٤٢e.c(bVar2) == 1) {
                                this.f٥٣٤١d = 3;
                                try {
                                    this.f٥٣٣٩b.a((b) this, (p0.e) bVar2);
                                } catch (RuntimeException e10) {
                                    this.f٥٣٣٩b.a(this, e10);
                                }
                                i10 = this.f٥٣٤١d;
                                if (i10 != 4 && i10 != 5) {
                                    if (z10 && this.f٥٣٤٤g.hasRemaining() == byteBuffer.hasRemaining() && byteBuffer.hasRemaining()) {
                                        throw new AssertionError();
                                    }
                                    if (!byteBuffer.hasRemaining()) {
                                        f(byteBuffer);
                                    } else if (this.f٥٣٤٤g.hasRemaining()) {
                                        f(this.f٥٣٤٤g);
                                    }
                                }
                            } else {
                                a(1002, "the handshake did finaly not match", false);
                            }
                        }
                    } else if (i12 == 1) {
                        e1.b bVar3 = this.f٥٣٤٢e;
                        bVar3.f١٣٨٥٣a = i12;
                        p0.e b11 = bVar3.b(byteBuffer2);
                        if (!(b11 instanceof g)) {
                            d(1002, "wrong http function", false);
                        } else {
                            g gVar = (g) b11;
                            if (this.f٥٣٤٢e.d(this.f٥٣٤٥h, gVar) == 1) {
                                try {
                                    this.f٥٣٣٩b.a(this, this.f٥٣٤٥h, gVar);
                                    this.f٥٣٤١d = 3;
                                    try {
                                        this.f٥٣٣٩b.a(this, gVar);
                                    } catch (RuntimeException e11) {
                                        this.f٥٣٣٩b.a(this, e11);
                                    }
                                    i10 = this.f٥٣٤١d;
                                    if (i10 != 4) {
                                        if (z10) {
                                        }
                                        if (!byteBuffer.hasRemaining()) {
                                        }
                                    }
                                } catch (i1.d e12) {
                                    d(e12.f١٤٥٩٥a, e12.getMessage(), false);
                                } catch (RuntimeException e13) {
                                    this.f٥٣٣٩b.a(this, e13);
                                    d(-1, e13.getMessage(), false);
                                }
                            } else {
                                a(1002, "draft " + this.f٥٣٤٢e + " refuses handshake", false);
                            }
                        }
                    }
                } catch (i1.g e14) {
                    a(e14.f١٤٥٩٥a, e14.getMessage(), false);
                }
            } catch (i1.e e15) {
                if (this.f٥٣٤٤g.capacity() == 0) {
                    byteBuffer2.reset();
                    int i13 = e15.f١٤٥٩٦a;
                    if (i13 == 0) {
                        i13 = byteBuffer2.capacity() + 16;
                    } else if (!f٥٣٣٧o && i13 < byteBuffer2.remaining()) {
                        throw new AssertionError();
                    }
                    ByteBuffer allocate2 = ByteBuffer.allocate(i13);
                    this.f٥٣٤٤g = allocate2;
                    allocate2.put(byteBuffer);
                } else {
                    ByteBuffer byteBuffer3 = this.f٥٣٤٤g;
                    byteBuffer3.position(byteBuffer3.limit());
                    ByteBuffer byteBuffer4 = this.f٥٣٤٤g;
                    byteBuffer4.limit(byteBuffer4.capacity());
                }
            }
        }
        if (!f٥٣٣٧o && this.f٥٣٤١d != 4 && !this.f٥٣٤٠c && byteBuffer.hasRemaining()) {
            throw new AssertionError();
        }
    }

    public final void c(List list) {
        boolean z10;
        int i10;
        int i11;
        int i12;
        String str;
        byte b10;
        int i13;
        int i14;
        int i15;
        byte b11;
        int i16 = 3;
        if (this.f٥٣٤١d == 3) {
            if (list != null) {
                ArrayList arrayList = new ArrayList();
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    f0.a aVar = (f0.a) it.next();
                    e1.b bVar = this.f٥٣٤٢e;
                    o1.a aVar2 = bVar.f١٣٨٥٥b;
                    ByteBuffer d10 = aVar.d();
                    int i17 = 0;
                    if (bVar.f١٣٨٥٣a == 1) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    if (d10.remaining() <= 125) {
                        i10 = 1;
                    } else if (d10.remaining() <= 65535) {
                        i10 = 2;
                    } else {
                        i10 = 8;
                    }
                    if (i10 > 1) {
                        i11 = i10 + 1;
                    } else {
                        i11 = i10;
                    }
                    int i18 = i11 + 1;
                    if (z10) {
                        i12 = 4;
                    } else {
                        i12 = 0;
                    }
                    ByteBuffer allocate = ByteBuffer.allocate(d10.remaining() + i18 + i12);
                    f0.c cVar = (f0.c) aVar;
                    int i19 = cVar.f١٤٠٢٩b;
                    if (i19 == 1) {
                        b10 = 0;
                    } else if (i19 == 2) {
                        b10 = 1;
                    } else if (i19 == i16) {
                        b10 = 2;
                    } else if (i19 == 6) {
                        b10 = 8;
                    } else if (i19 == 4) {
                        b10 = 9;
                    } else if (i19 == 5) {
                        b10 = 10;
                    } else {
                        switch (i19) {
                            case 1:
                                str = "CONTINUOUS";
                                break;
                            case 2:
                                str = "TEXT";
                                break;
                            case 3:
                                str = "BINARY";
                                break;
                            case 4:
                                str = "PING";
                                break;
                            case 5:
                                str = "PONG";
                                break;
                            case 6:
                                str = "CLOSING";
                                break;
                            default:
                                throw null;
                        }
                        throw new IllegalArgumentException("Don't know how to handle ".concat(str));
                    }
                    if (cVar.f١٤٠٢٨a) {
                        i13 = -128;
                    } else {
                        i13 = 0;
                    }
                    allocate.put((byte) (b10 | ((byte) i13)));
                    long remaining = d10.remaining();
                    byte[] bArr = new byte[i10];
                    int i20 = (i10 * 8) - 8;
                    for (int i21 = 0; i21 < i10; i21++) {
                        bArr[i21] = (byte) (remaining >>> (i20 - (i21 * 8)));
                    }
                    if (i10 == 1) {
                        byte b12 = bArr[0];
                        if (z10) {
                            b11 = ByteCompanionObject.MIN_VALUE;
                        } else {
                            b11 = 0;
                        }
                        allocate.put((byte) (b12 | b11));
                    } else if (i10 == 2) {
                        if (z10) {
                            i15 = -128;
                        } else {
                            i15 = 0;
                        }
                        allocate.put((byte) (i15 | 126));
                        allocate.put(bArr);
                    } else if (i10 == 8) {
                        if (z10) {
                            i14 = -128;
                        } else {
                            i14 = 0;
                        }
                        allocate.put((byte) (i14 | Constants.ERR_WATERMARKR_INFO));
                        allocate.put(bArr);
                    } else {
                        throw new RuntimeException("Size representation not supported/specified");
                    }
                    if (z10) {
                        ByteBuffer allocate2 = ByteBuffer.allocate(4);
                        allocate2.putInt(bVar.f١٣٨٦٢i.nextInt());
                        allocate.put(allocate2.array());
                        while (d10.hasRemaining()) {
                            allocate.put((byte) (d10.get() ^ allocate2.get(i17 % 4)));
                            i17++;
                        }
                    } else {
                        allocate.put(d10);
                        d10.flip();
                    }
                    if (!e1.b.f١٣٨٥٤j && allocate.remaining() != 0) {
                        throw new AssertionError(allocate.remaining());
                    }
                    allocate.flip();
                    arrayList.add(allocate);
                    i16 = 3;
                }
                g(arrayList);
                return;
            }
            throw new IllegalArgumentException();
        }
        throw new i1.b();
    }

    public final synchronized void d(int i10, String str, boolean z10) {
        if (this.f٥٣٤٠c) {
            return;
        }
        this.f٥٣٤٧j = Integer.valueOf(i10);
        this.f٥٣٤٦i = str;
        this.f٥٣٤٨k = Boolean.valueOf(z10);
        this.f٥٣٤٠c = true;
        this.f٥٣٣٩b.a(this);
        try {
            this.f٥٣٣٩b.b(this, i10, str, z10);
        } catch (RuntimeException e10) {
            this.f٥٣٣٩b.a(this, e10);
        }
        e1.b bVar = this.f٥٣٤٢e;
        if (bVar != null) {
            bVar.f١٣٨٦١h = null;
            bVar.f١٣٨٥٥b = new o1.a();
            bVar.f١٣٨٥٧d = null;
        }
        this.f٥٣٤٥h = null;
    }

    public final synchronized void e(int i10, String str, boolean z10) {
        int i11 = this.f٥٣٤١d;
        if (i11 == 5) {
            return;
        }
        if (i11 == 3 && i10 == 1006) {
            this.f٥٣٤١d = 4;
        }
        try {
            this.f٥٣٣٩b.a(this, i10, str, z10);
        } catch (RuntimeException e10) {
            this.f٥٣٣٩b.a(this, e10);
        }
        e1.b bVar = this.f٥٣٤٢e;
        if (bVar != null) {
            bVar.f١٣٨٦١h = null;
            bVar.f١٣٨٥٥b = new o1.a();
            bVar.f١٣٨٥٧d = null;
        }
        this.f٥٣٤٥h = null;
        this.f٥٣٤١d = 5;
    }

    public final void f(ByteBuffer byteBuffer) {
        try {
            Iterator it = this.f٥٣٤٢e.g(byteBuffer).iterator();
            while (it.hasNext()) {
                this.f٥٣٤٢e.f(this, (f0.a) it.next());
            }
        } catch (i1.d e10) {
            this.f٥٣٣٩b.a(this, e10);
            a(e10.f١٤٥٩٥a, e10.getMessage(), false);
        }
    }

    public final void g(List list) {
        synchronized (this.f٥٣٥٠m) {
            try {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    this.f٥٣٣٨a.add((ByteBuffer) it.next());
                    this.f٥٣٣٩b.a(this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final synchronized void a(int i10, String str, boolean z10) {
        try {
            int i11 = this.f٥٣٤١d;
            if (i11 == 4 || i11 == 5) {
                return;
            }
            if (i11 == 3) {
                if (i10 == 1006) {
                    if (!f٥٣٣٧o && z10) {
                        throw new AssertionError();
                    }
                    this.f٥٣٤١d = 4;
                    d(i10, str, false);
                    return;
                }
                this.f٥٣٤٢e.getClass();
                if (!z10) {
                    try {
                        try {
                            this.f٥٣٣٩b.a(this, i10, str);
                        } catch (RuntimeException e10) {
                            this.f٥٣٣٩b.a(this, e10);
                        }
                    } catch (i1.d e11) {
                        this.f٥٣٣٩b.a(this, e11);
                        d(1006, "generated frame is invalid", false);
                    }
                }
                if (this.f٥٣٤١d == 3) {
                    h hVar = new h();
                    String str2 = str == null ? "" : str;
                    hVar.f١٤٠٣٦i = str2;
                    CodingErrorAction codingErrorAction = z0.b.f١٩٣٣٣a;
                    try {
                        byte[] bytes = str2.getBytes("UTF8");
                        ByteBuffer allocate = ByteBuffer.allocate(4);
                        allocate.putInt(hVar.f١٤٠٣٥h);
                        allocate.position(2);
                        ByteBuffer allocate2 = ByteBuffer.allocate(bytes.length + 2);
                        allocate2.put(allocate);
                        allocate2.put(bytes);
                        allocate2.rewind();
                        hVar.f١٤٠٣٠c = allocate2;
                        hVar.f١٤٠٣٥h = i10;
                        if (i10 == 1015) {
                            hVar.f١٤٠٣٥h = 1005;
                            hVar.f١٤٠٣٦i = "";
                        }
                        try {
                            byte[] bytes2 = hVar.f١٤٠٣٦i.getBytes("UTF8");
                            ByteBuffer allocate3 = ByteBuffer.allocate(4);
                            allocate3.putInt(hVar.f١٤٠٣٥h);
                            allocate3.position(2);
                            ByteBuffer allocate4 = ByteBuffer.allocate(bytes2.length + 2);
                            allocate4.put(allocate3);
                            allocate4.put(bytes2);
                            allocate4.rewind();
                            hVar.f١٤٠٣٠c = allocate4;
                            hVar.a();
                            c(Collections.singletonList(hVar));
                        } catch (UnsupportedEncodingException e12) {
                            throw new RuntimeException(e12);
                        }
                    } catch (UnsupportedEncodingException e13) {
                        throw new RuntimeException(e13);
                    }
                }
                d(i10, str, z10);
            } else if (i10 == -3) {
                if (!f٥٣٣٧o && !z10) {
                    throw new AssertionError();
                }
                d(-3, str, true);
            } else if (i10 == 1002) {
                d(i10, str, z10);
            } else {
                d(-1, str, false);
            }
            this.f٥٣٤١d = 4;
            this.f٥٣٤٤g = null;
        } catch (Throwable th) {
            throw th;
        }
    }
}
