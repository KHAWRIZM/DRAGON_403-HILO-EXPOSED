package e1;

import b1.e;
import com.amazonaws.services.s3.Headers;
import e0.h0;
import f0.c;
import f0.j;
import i1.h;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import kotlin.jvm.internal.ByteCompanionObject;
import p0.d;
import p0.f;
import p0.g;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class b extends a {

    /* renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ boolean f١٣٨٥٤j = true;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f١٣٨٥٦c;

    /* renamed from: d, reason: collision with root package name */
    public u0.a f١٣٨٥٧d;

    /* renamed from: e, reason: collision with root package name */
    public final ArrayList f١٣٨٥٨e;

    /* renamed from: f, reason: collision with root package name */
    public f0.a f١٣٨٥٩f;

    /* renamed from: g, reason: collision with root package name */
    public final ArrayList f١٣٨٦٠g;

    /* renamed from: h, reason: collision with root package name */
    public ByteBuffer f١٣٨٦١h;

    /* renamed from: b, reason: collision with root package name */
    public o1.a f١٣٨٥٥b = new o1.a();

    /* renamed from: i, reason: collision with root package name */
    public final Random f١٣٨٦٢i = new Random();

    public b(List list, List list2) {
        if (list != null && list2 != null) {
            this.f١٣٨٥٦c = new ArrayList(list.size());
            this.f١٣٨٥٨e = new ArrayList(list2.size());
            this.f١٣٨٦٠g = new ArrayList();
            Iterator it = list.iterator();
            boolean z10 = false;
            while (it.hasNext()) {
                if (((o1.a) it.next()).getClass().equals(o1.a.class)) {
                    z10 = true;
                }
            }
            this.f١٣٨٥٦c.addAll(list);
            if (!z10) {
                ArrayList arrayList = this.f١٣٨٥٦c;
                arrayList.add(arrayList.size(), this.f١٣٨٥٥b);
            }
            this.f١٣٨٥٨e.addAll(list2);
            return;
        }
        throw new IllegalArgumentException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0022 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int c(p0.b bVar) {
        int intValue;
        char c10;
        char c11;
        boolean z10;
        f fVar = (f) bVar;
        String a10 = fVar.a("Sec-WebSocket-Version");
        if (a10.length() > 0) {
            try {
                intValue = new Integer(a10.trim()).intValue();
            } catch (NumberFormatException unused) {
            }
            if (intValue == 13) {
                return 2;
            }
            fVar.a("Sec-WebSocket-Extensions");
            Iterator it = this.f١٣٨٥٦c.iterator();
            if (it.hasNext()) {
                o1.a aVar = (o1.a) it.next();
                aVar.getClass();
                this.f١٣٨٥٥b = aVar;
                c10 = 1;
            } else {
                c10 = 2;
            }
            String a11 = fVar.a("Sec-WebSocket-Protocol");
            ArrayList arrayList = this.f١٣٨٥٨e;
            int size = arrayList.size();
            int i10 = 0;
            while (true) {
                if (i10 < size) {
                    Object obj = arrayList.get(i10);
                    i10++;
                    u0.a aVar2 = (u0.a) obj;
                    aVar2.getClass();
                    String[] split = a11.replaceAll(" ", "").split(",");
                    int length = split.length;
                    int i11 = 0;
                    while (true) {
                        if (i11 < length) {
                            if ("".equals(split[i11])) {
                                z10 = true;
                                break;
                            }
                            i11++;
                        } else {
                            z10 = false;
                            break;
                        }
                    }
                    if (z10) {
                        this.f١٣٨٥٧d = aVar2;
                        c11 = 1;
                        break;
                    }
                } else {
                    c11 = 2;
                    break;
                }
            }
            if (c11 != 1 || c10 != 1) {
                return 2;
            }
            return 1;
        }
        intValue = -1;
        if (intValue == 13) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int d(d dVar, g gVar) {
        char c10;
        char c11;
        f fVar = (f) gVar;
        if (!fVar.a("Upgrade").equalsIgnoreCase("websocket") || !fVar.a(Headers.CONNECTION).toLowerCase(Locale.ENGLISH).contains("upgrade") || !dVar.f١٦٨٤١a.containsKey("Sec-WebSocket-Key") || !fVar.f١٦٨٤١a.containsKey("Sec-WebSocket-Accept")) {
            return 2;
        }
        try {
            if (!z0.a.a(MessageDigest.getInstance("SHA1").digest((dVar.a("Sec-WebSocket-Key").trim() + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11").getBytes())).equals(fVar.a("Sec-WebSocket-Accept"))) {
                return 2;
            }
            fVar.a("Sec-WebSocket-Extensions");
            Iterator it = this.f١٣٨٥٦c.iterator();
            if (it.hasNext()) {
                o1.a aVar = (o1.a) it.next();
                aVar.getClass();
                this.f١٣٨٥٥b = aVar;
                c10 = 1;
            } else {
                c10 = 2;
            }
            String a10 = fVar.a("Sec-WebSocket-Protocol");
            ArrayList arrayList = this.f١٣٨٥٨e;
            int size = arrayList.size();
            int i10 = 0;
            loop0: while (true) {
                if (i10 < size) {
                    Object obj = arrayList.get(i10);
                    i10++;
                    u0.a aVar2 = (u0.a) obj;
                    aVar2.getClass();
                    for (String str : a10.replaceAll(" ", "").split(",")) {
                        if ("".equals(str)) {
                            this.f١٣٨٥٧d = aVar2;
                            c11 = 1;
                            break loop0;
                        }
                    }
                } else {
                    c11 = 2;
                    break;
                }
            }
            if (c11 != 1 || c10 != 1) {
                return 2;
            }
            return 1;
        } catch (NoSuchAlgorithmException e10) {
            throw new IllegalStateException(e10);
        }
    }

    public final ByteBuffer e() {
        ArrayList arrayList = this.f١٣٨٦٠g;
        int size = arrayList.size();
        long j10 = 0;
        int i10 = 0;
        int i11 = 0;
        while (i11 < size) {
            Object obj = arrayList.get(i11);
            i11++;
            j10 += ((ByteBuffer) obj).limit();
        }
        if (j10 <= 2147483647L) {
            ByteBuffer allocate = ByteBuffer.allocate((int) j10);
            ArrayList arrayList2 = this.f١٣٨٦٠g;
            int size2 = arrayList2.size();
            while (i10 < size2) {
                Object obj2 = arrayList2.get(i10);
                i10++;
                allocate.put((ByteBuffer) obj2);
            }
            allocate.flip();
            return allocate;
        }
        throw new h();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && b.class == obj.getClass()) {
            b bVar = (b) obj;
            o1.a aVar = this.f١٣٨٥٥b;
            if (aVar == null ? bVar.f١٣٨٥٥b != null : !aVar.equals(bVar.f١٣٨٥٥b)) {
                return false;
            }
            u0.a aVar2 = this.f١٣٨٥٧d;
            u0.a aVar3 = bVar.f١٣٨٥٧d;
            if (aVar2 != null) {
                return aVar2.equals(aVar3);
            }
            if (aVar3 == null) {
                return true;
            }
        }
        return false;
    }

    public final void f(e eVar, f0.a aVar) {
        int i10;
        String str;
        c cVar = (c) aVar;
        int i11 = cVar.f١٤٠٢٩b;
        if (i11 == 6) {
            if (aVar instanceof f0.h) {
                f0.h hVar = (f0.h) aVar;
                i10 = hVar.f١٤٠٣٥h;
                str = hVar.f١٤٠٣٦i;
            } else {
                i10 = 1005;
                str = "";
            }
            if (eVar.f٥٣٤١d == 4) {
                eVar.e(i10, str, true);
                return;
            } else {
                eVar.a(i10, str, true);
                return;
            }
        }
        if (i11 == 4) {
            eVar.f٥٣٣٩b.a(eVar, aVar);
            return;
        }
        if (i11 == 5) {
            eVar.f٥٣٤٩l = System.currentTimeMillis();
            eVar.f٥٣٣٩b.b(eVar, aVar);
            return;
        }
        boolean z10 = cVar.f١٤٠٢٨a;
        if (z10 && i11 != 1) {
            if (this.f١٣٨٥٩f == null) {
                if (i11 == 2) {
                    try {
                        eVar.f٥٣٣٩b.a(eVar, z0.b.a(aVar.d()));
                        return;
                    } catch (RuntimeException e10) {
                        eVar.f٥٣٣٩b.a(eVar, e10);
                        return;
                    }
                }
                if (i11 == 3) {
                    try {
                        eVar.f٥٣٣٩b.a(eVar, aVar.d());
                        return;
                    } catch (RuntimeException e11) {
                        eVar.f٥٣٣٩b.a(eVar, e11);
                        return;
                    }
                }
                throw new i1.d(1002, "non control or continious frame expected");
            }
            throw new i1.d(1002, "Continuous frame sequence not completed.");
        }
        if (i11 != 1) {
            if (this.f١٣٨٥٩f == null) {
                this.f١٣٨٥٩f = aVar;
                this.f١٣٨٦٠g.add(aVar.d());
            } else {
                throw new i1.d(1002, "Previous continuous frame sequence not completed.");
            }
        } else if (z10) {
            if (this.f١٣٨٥٩f != null) {
                this.f١٣٨٦٠g.add(aVar.d());
                c cVar2 = (c) this.f١٣٨٥٩f;
                int i12 = cVar2.f١٤٠٢٩b;
                if (i12 == 2) {
                    cVar2.b(e());
                    ((c) this.f١٣٨٥٩f).a();
                    try {
                        eVar.f٥٣٣٩b.a(eVar, z0.b.a(this.f١٣٨٥٩f.d()));
                    } catch (RuntimeException e12) {
                        eVar.f٥٣٣٩b.a(eVar, e12);
                    }
                } else if (i12 == 3) {
                    cVar2.b(e());
                    ((c) this.f١٣٨٥٩f).a();
                    try {
                        eVar.f٥٣٣٩b.a(eVar, this.f١٣٨٥٩f.d());
                    } catch (RuntimeException e13) {
                        eVar.f٥٣٣٩b.a(eVar, e13);
                    }
                }
                this.f١٣٨٥٩f = null;
                this.f١٣٨٦٠g.clear();
            } else {
                throw new i1.d(1002, "Continuous frame sequence was not started.");
            }
        } else if (this.f١٣٨٥٩f == null) {
            throw new i1.d(1002, "Continuous frame sequence was not started.");
        }
        if (i11 == 2 && !z0.b.b(aVar.d())) {
            throw new i1.d(1007);
        }
        if (i11 == 1 && this.f١٣٨٥٩f != null) {
            this.f١٣٨٦٠g.add(aVar.d());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x009a, code lost:
    
        if (r8.hasRemaining() == false) goto L٤٤;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x009c, code lost:
    
        r8.mark();
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x009f, code lost:
    
        r0.add(h(r8));
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x00a7, code lost:
    
        r1 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x00a8, code lost:
    
        r8.reset();
        r1 = r1.f١٤٥٩٤a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x00ad, code lost:
    
        if (r1 >= 0) goto L٣٢;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00af, code lost:
    
        r1 = java.nio.ByteBuffer.allocate(r1);
        r7.f١٣٨٦١h = r1;
        r1.put(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00bf, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00be, code lost:
    
        throw new i1.d(1002, "Negative count");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List g(ByteBuffer byteBuffer) {
        while (true) {
            LinkedList linkedList = new LinkedList();
            if (this.f١٣٨٦١h == null) {
                break;
            }
            try {
                byteBuffer.mark();
                int remaining = byteBuffer.remaining();
                int remaining2 = this.f١٣٨٦١h.remaining();
                if (remaining2 > remaining) {
                    this.f١٣٨٦١h.put(byteBuffer.array(), byteBuffer.position(), remaining);
                    byteBuffer.position(byteBuffer.position() + remaining);
                    return Collections.EMPTY_LIST;
                }
                this.f١٣٨٦١h.put(byteBuffer.array(), byteBuffer.position(), remaining2);
                byteBuffer.position(byteBuffer.position() + remaining2);
                linkedList.add(h((ByteBuffer) this.f١٣٨٦١h.duplicate().position(0)));
                this.f١٣٨٦١h = null;
            } catch (i1.c e10) {
                int i10 = e10.f١٤٥٩٤a;
                if (i10 >= 0) {
                    ByteBuffer allocate = ByteBuffer.allocate(i10);
                    if (!f١٣٨٥٤j && allocate.limit() <= this.f١٣٨٦١h.limit()) {
                        throw new AssertionError();
                    }
                    this.f١٣٨٦١h.rewind();
                    allocate.put(this.f١٣٨٦١h);
                    this.f١٣٨٦١h = allocate;
                } else {
                    throw new i1.d(1002, "Negative count");
                }
            }
        }
    }

    public final c h(ByteBuffer byteBuffer) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        int i10;
        int i11;
        c eVar;
        int remaining = byteBuffer.remaining();
        int i12 = 2;
        if (remaining >= 2) {
            byte b10 = byteBuffer.get();
            if ((b10 >> 8) != 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            if ((b10 & 64) != 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if ((b10 & 32) != 0) {
                z12 = true;
            } else {
                z12 = false;
            }
            if ((b10 & 16) != 0) {
                z13 = true;
            } else {
                z13 = false;
            }
            byte b11 = byteBuffer.get();
            if ((b11 & ByteCompanionObject.MIN_VALUE) != 0) {
                z14 = true;
            } else {
                z14 = false;
            }
            int i13 = (byte) (b11 & ByteCompanionObject.MAX_VALUE);
            byte b12 = (byte) (b10 & 15);
            if (b12 != 0) {
                if (b12 != 1) {
                    if (b12 != 2) {
                        switch (b12) {
                            case 8:
                                i10 = 6;
                                break;
                            case 9:
                                i10 = 4;
                                break;
                            case 10:
                                i10 = 5;
                                break;
                            default:
                                throw new i1.f("Unknown opcode " + ((int) b12));
                        }
                    } else {
                        i10 = 3;
                    }
                } else {
                    i10 = 2;
                }
            } else {
                i10 = 1;
            }
            if (i13 < 0 || i13 > 125) {
                if (i10 != 4 && i10 != 5 && i10 != 6) {
                    if (i13 == 126) {
                        if (remaining >= 4) {
                            i13 = new BigInteger(new byte[]{0, byteBuffer.get(), byteBuffer.get()}).intValue();
                            i12 = 4;
                        } else {
                            throw new i1.c(4);
                        }
                    } else {
                        i12 = 10;
                        if (remaining >= 10) {
                            byte[] bArr = new byte[8];
                            for (int i14 = 0; i14 < 8; i14++) {
                                bArr[i14] = byteBuffer.get();
                            }
                            long longValue = new BigInteger(bArr).longValue();
                            if (longValue <= 2147483647L) {
                                i13 = (int) longValue;
                            } else {
                                throw new h();
                            }
                        } else {
                            throw new i1.c(10);
                        }
                    }
                } else {
                    throw new i1.f("more than 125 octets");
                }
            }
            if (z14) {
                i11 = 4;
            } else {
                i11 = 0;
            }
            int i15 = i12 + i11 + i13;
            if (remaining >= i15) {
                if (i13 >= 0) {
                    ByteBuffer allocate = ByteBuffer.allocate(i13);
                    if (z14) {
                        byte[] bArr2 = new byte[4];
                        byteBuffer.get(bArr2);
                        for (int i16 = 0; i16 < i13; i16++) {
                            allocate.put((byte) (byteBuffer.get() ^ bArr2[i16 % 4]));
                        }
                    } else {
                        allocate.put(byteBuffer.array(), byteBuffer.position(), allocate.limit());
                        byteBuffer.position(allocate.limit() + byteBuffer.position());
                    }
                    switch (f0.b.f١٤٠٢٧a[h0.a(i10)]) {
                        case 1:
                            eVar = new f0.e();
                            break;
                        case 2:
                            eVar = new f0.g();
                            break;
                        case 3:
                            eVar = new j();
                            break;
                        case 4:
                            eVar = new f0.d();
                            break;
                        case 5:
                            eVar = new f0.h();
                            break;
                        case 6:
                            eVar = new f0.f();
                            break;
                        default:
                            throw new IllegalArgumentException("Supplied opcode is invalid");
                    }
                    eVar.f١٤٠٢٨a = z10;
                    eVar.f١٤٠٣٢e = z11;
                    eVar.f١٤٠٣٣f = z12;
                    eVar.f١٤٠٣٤g = z13;
                    allocate.flip();
                    eVar.b(allocate);
                    if (!eVar.f١٤٠٣٢e && !eVar.f١٤٠٣٣f && !eVar.f١٤٠٣٤g) {
                        eVar.a();
                        return eVar;
                    }
                    throw new i1.f("bad rsv RSV1: " + eVar.f١٤٠٣٢e + " RSV2: " + eVar.f١٤٠٣٣f + " RSV3: " + eVar.f١٤٠٣٤g);
                }
                throw new i1.d(1002, "Negative count");
            }
            throw new i1.c(i15);
        }
        throw new i1.c(2);
    }

    public final int hashCode() {
        return o1.a.class.hashCode() * 31;
    }

    public final String toString() {
        String str = b.class.getSimpleName() + " extension: " + o1.a.class.getSimpleName();
        if (this.f١٣٨٥٧d != null) {
            this.f١٣٨٥٧d.getClass();
            return str + " protocol: ";
        }
        return str;
    }
}
