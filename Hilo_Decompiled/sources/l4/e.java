package l4;

import android.graphics.Bitmap;
import android.util.Log;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.KotlinVersion;
import kotlin.UByte;
import l4.a;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class e implements a {

    /* renamed from: u, reason: collision with root package name */
    private static final String f١٥٨٠٦u = "e";

    /* renamed from: a, reason: collision with root package name */
    private int[] f١٥٨٠٧a;

    /* renamed from: b, reason: collision with root package name */
    private final int[] f١٥٨٠٨b;

    /* renamed from: c, reason: collision with root package name */
    private final a.InterfaceC٠١٨٦a f١٥٨٠٩c;

    /* renamed from: d, reason: collision with root package name */
    private ByteBuffer f١٥٨١٠d;

    /* renamed from: e, reason: collision with root package name */
    private byte[] f١٥٨١١e;

    /* renamed from: f, reason: collision with root package name */
    private short[] f١٥٨١٢f;

    /* renamed from: g, reason: collision with root package name */
    private byte[] f١٥٨١٣g;

    /* renamed from: h, reason: collision with root package name */
    private byte[] f١٥٨١٤h;

    /* renamed from: i, reason: collision with root package name */
    private byte[] f١٥٨١٥i;

    /* renamed from: j, reason: collision with root package name */
    private int[] f١٥٨١٦j;

    /* renamed from: k, reason: collision with root package name */
    private int f١٥٨١٧k;

    /* renamed from: l, reason: collision with root package name */
    private c f١٥٨١٨l;

    /* renamed from: m, reason: collision with root package name */
    private Bitmap f١٥٨١٩m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f١٥٨٢٠n;

    /* renamed from: o, reason: collision with root package name */
    private int f١٥٨٢١o;

    /* renamed from: p, reason: collision with root package name */
    private int f١٥٨٢٢p;

    /* renamed from: q, reason: collision with root package name */
    private int f١٥٨٢٣q;

    /* renamed from: r, reason: collision with root package name */
    private int f١٥٨٢٤r;

    /* renamed from: s, reason: collision with root package name */
    private Boolean f١٥٨٢٥s;

    /* renamed from: t, reason: collision with root package name */
    private Bitmap.Config f١٥٨٢٦t;

    public e(a.InterfaceC٠١٨٦a r12, c cVar, ByteBuffer byteBuffer, int i10) {
        this(r12);
        q(cVar, byteBuffer, i10);
    }

    private int i(int i10, int i11, int i12) {
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        for (int i18 = i10; i18 < this.f١٥٨٢٢p + i10; i18++) {
            byte[] bArr = this.f١٥٨١٥i;
            if (i18 >= bArr.length || i18 >= i11) {
                break;
            }
            int i19 = this.f١٥٨٠٧a[bArr[i18] & UByte.MAX_VALUE];
            if (i19 != 0) {
                i13 += (i19 >> 24) & KotlinVersion.MAX_COMPONENT_VALUE;
                i14 += (i19 >> 16) & KotlinVersion.MAX_COMPONENT_VALUE;
                i15 += (i19 >> 8) & KotlinVersion.MAX_COMPONENT_VALUE;
                i16 += i19 & KotlinVersion.MAX_COMPONENT_VALUE;
                i17++;
            }
        }
        int i20 = i10 + i12;
        for (int i21 = i20; i21 < this.f١٥٨٢٢p + i20; i21++) {
            byte[] bArr2 = this.f١٥٨١٥i;
            if (i21 >= bArr2.length || i21 >= i11) {
                break;
            }
            int i22 = this.f١٥٨٠٧a[bArr2[i21] & UByte.MAX_VALUE];
            if (i22 != 0) {
                i13 += (i22 >> 24) & KotlinVersion.MAX_COMPONENT_VALUE;
                i14 += (i22 >> 16) & KotlinVersion.MAX_COMPONENT_VALUE;
                i15 += (i22 >> 8) & KotlinVersion.MAX_COMPONENT_VALUE;
                i16 += i22 & KotlinVersion.MAX_COMPONENT_VALUE;
                i17++;
            }
        }
        if (i17 == 0) {
            return 0;
        }
        return ((i13 / i17) << 24) | ((i14 / i17) << 16) | ((i15 / i17) << 8) | (i16 / i17);
    }

    private void j(b bVar) {
        boolean z10;
        boolean booleanValue;
        int i10;
        int i11;
        boolean z11;
        int i12;
        int i13;
        int i14;
        int[] iArr = this.f١٥٨١٦j;
        int i15 = bVar.f١٥٧٨١d;
        int i16 = this.f١٥٨٢٢p;
        int i17 = i15 / i16;
        int i18 = bVar.f١٥٧٧٩b / i16;
        int i19 = bVar.f١٥٧٨٠c / i16;
        int i20 = bVar.f١٥٧٧٨a / i16;
        if (this.f١٥٨١٧k == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        int i21 = this.f١٥٨٢٤r;
        int i22 = this.f١٥٨٢٣q;
        byte[] bArr = this.f١٥٨١٥i;
        int[] iArr2 = this.f١٥٨٠٧a;
        Boolean bool = this.f١٥٨٢٥s;
        int i23 = 8;
        int i24 = 0;
        int i25 = 0;
        int i26 = 1;
        while (i25 < i17) {
            Boolean bool2 = bool;
            if (bVar.f١٥٧٨٢e) {
                if (i24 >= i17) {
                    int i27 = i26 + 1;
                    i10 = i17;
                    if (i27 != 2) {
                        if (i27 != 3) {
                            if (i27 != 4) {
                                i26 = i27;
                            } else {
                                i26 = i27;
                                i24 = 1;
                                i23 = 2;
                            }
                        } else {
                            i26 = i27;
                            i24 = 2;
                            i23 = 4;
                        }
                    } else {
                        i26 = i27;
                        i24 = 4;
                    }
                } else {
                    i10 = i17;
                }
                i11 = i24 + i23;
            } else {
                i10 = i17;
                i11 = i24;
                i24 = i25;
            }
            int i28 = i24 + i18;
            if (i16 == 1) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (i28 < i22) {
                int i29 = i28 * i21;
                int i30 = i29 + i20;
                int i31 = i30 + i19;
                int i32 = i29 + i21;
                if (i32 < i31) {
                    i31 = i32;
                }
                i12 = i11;
                int i33 = i25 * i16 * bVar.f١٥٧٨٠c;
                if (z11) {
                    int i34 = i30;
                    while (i34 < i31) {
                        int i35 = i18;
                        int i36 = iArr2[bArr[i33] & UByte.MAX_VALUE];
                        if (i36 != 0) {
                            iArr[i34] = i36;
                        } else if (z10 && bool2 == null) {
                            bool2 = Boolean.TRUE;
                        }
                        i33 += i16;
                        i34++;
                        i18 = i35;
                    }
                } else {
                    i14 = i18;
                    int i37 = ((i31 - i30) * i16) + i33;
                    int i38 = i30;
                    while (true) {
                        i13 = i19;
                        if (i38 >= i31) {
                            break;
                        }
                        int i39 = i(i33, i37, bVar.f١٥٧٨٠c);
                        if (i39 != 0) {
                            iArr[i38] = i39;
                        } else if (z10 && bool2 == null) {
                            bool2 = Boolean.TRUE;
                        }
                        i33 += i16;
                        i38++;
                        i19 = i13;
                    }
                    bool = bool2;
                    i25++;
                    i18 = i14;
                    i17 = i10;
                    i19 = i13;
                    i24 = i12;
                }
            } else {
                i12 = i11;
            }
            i14 = i18;
            i13 = i19;
            bool = bool2;
            i25++;
            i18 = i14;
            i17 = i10;
            i19 = i13;
            i24 = i12;
        }
        Boolean bool3 = bool;
        if (this.f١٥٨٢٥s == null) {
            if (bool3 == null) {
                booleanValue = false;
            } else {
                booleanValue = bool3.booleanValue();
            }
            this.f١٥٨٢٥s = Boolean.valueOf(booleanValue);
        }
    }

    private void k(b bVar) {
        boolean z10;
        boolean z11;
        b bVar2 = bVar;
        int[] iArr = this.f١٥٨١٦j;
        int i10 = bVar2.f١٥٧٨١d;
        int i11 = bVar2.f١٥٧٧٩b;
        int i12 = bVar2.f١٥٧٨٠c;
        int i13 = bVar2.f١٥٧٧٨a;
        if (this.f١٥٨١٧k == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        int i14 = this.f١٥٨٢٤r;
        byte[] bArr = this.f١٥٨١٥i;
        int[] iArr2 = this.f١٥٨٠٧a;
        int i15 = 0;
        byte b10 = -1;
        while (i15 < i10) {
            int i16 = (i15 + i11) * i14;
            int i17 = i16 + i13;
            int i18 = i17 + i12;
            int i19 = i16 + i14;
            if (i19 < i18) {
                i18 = i19;
            }
            int i20 = bVar2.f١٥٧٨٠c * i15;
            int i21 = i17;
            while (i21 < i18) {
                byte b11 = bArr[i20];
                int i22 = i10;
                int i23 = b11 & UByte.MAX_VALUE;
                if (i23 != b10) {
                    int i24 = iArr2[i23];
                    if (i24 != 0) {
                        iArr[i21] = i24;
                    } else {
                        b10 = b11;
                    }
                }
                i20++;
                i21++;
                i10 = i22;
            }
            i15++;
            bVar2 = bVar;
        }
        Boolean bool = this.f١٥٨٢٥s;
        if ((bool != null && bool.booleanValue()) || (this.f١٥٨٢٥s == null && z10 && b10 != -1)) {
            z11 = true;
        } else {
            z11 = false;
        }
        this.f١٥٨٢٥s = Boolean.valueOf(z11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v15, types: [short] */
    /* JADX WARN: Type inference failed for: r7v17 */
    private void l(b bVar) {
        int i10;
        int i11;
        short s10;
        e eVar = this;
        if (bVar != null) {
            eVar.f١٥٨١٠d.position(bVar.f١٥٧٨٧j);
        }
        if (bVar == null) {
            c cVar = eVar.f١٥٨١٨l;
            i10 = cVar.f١٥٧٩٤f;
            i11 = cVar.f١٥٧٩٥g;
        } else {
            i10 = bVar.f١٥٧٨٠c;
            i11 = bVar.f١٥٧٨١d;
        }
        int i12 = i10 * i11;
        byte[] bArr = eVar.f١٥٨١٥i;
        if (bArr == null || bArr.length < i12) {
            eVar.f١٥٨١٥i = eVar.f١٥٨٠٩c.b(i12);
        }
        byte[] bArr2 = eVar.f١٥٨١٥i;
        if (eVar.f١٥٨١٢f == null) {
            eVar.f١٥٨١٢f = new short[4096];
        }
        short[] sArr = eVar.f١٥٨١٢f;
        if (eVar.f١٥٨١٣g == null) {
            eVar.f١٥٨١٣g = new byte[4096];
        }
        byte[] bArr3 = eVar.f١٥٨١٣g;
        if (eVar.f١٥٨١٤h == null) {
            eVar.f١٥٨١٤h = new byte[4097];
        }
        byte[] bArr4 = eVar.f١٥٨١٤h;
        int p10 = p();
        int i13 = 1 << p10;
        int i14 = i13 + 1;
        int i15 = i13 + 2;
        int i16 = p10 + 1;
        int i17 = (1 << i16) - 1;
        int i18 = 0;
        for (int i19 = 0; i19 < i13; i19++) {
            sArr[i19] = 0;
            bArr3[i19] = (byte) i19;
        }
        byte[] bArr5 = eVar.f١٥٨١١e;
        int i20 = i16;
        int i21 = i15;
        int i22 = i17;
        int i23 = 0;
        int i24 = 0;
        int i25 = 0;
        int i26 = 0;
        int i27 = 0;
        int i28 = -1;
        int i29 = 0;
        int i30 = 0;
        while (true) {
            if (i18 >= i12) {
                break;
            }
            if (i23 == 0) {
                i23 = o();
                if (i23 <= 0) {
                    eVar.f١٥٨٢١o = 3;
                    break;
                }
                i24 = 0;
            }
            i26 += (bArr5[i24] & UByte.MAX_VALUE) << i25;
            i24++;
            i23--;
            int i31 = i25 + 8;
            int i32 = i21;
            int i33 = i20;
            int i34 = i28;
            int i35 = i16;
            int i36 = i29;
            while (true) {
                if (i31 >= i33) {
                    int i37 = i15;
                    int i38 = i26 & i22;
                    i26 >>= i33;
                    i31 -= i33;
                    if (i38 == i13) {
                        i22 = i17;
                        i33 = i35;
                        i32 = i37;
                        i15 = i32;
                        i34 = -1;
                    } else {
                        if (i38 == i14) {
                            i25 = i31;
                            i29 = i36;
                            i21 = i32;
                            i16 = i35;
                            i15 = i37;
                            i28 = i34;
                            i20 = i33;
                            eVar = this;
                            break;
                        }
                        if (i34 == -1) {
                            bArr2[i27] = bArr3[i38];
                            i27++;
                            i18++;
                            i34 = i38;
                            i36 = i34;
                            i15 = i37;
                            i31 = i31;
                        } else {
                            if (i38 >= i32) {
                                bArr4[i30] = (byte) i36;
                                i30++;
                                s10 = i34;
                            } else {
                                s10 = i38;
                            }
                            while (s10 >= i13) {
                                bArr4[i30] = bArr3[s10];
                                i30++;
                                s10 = sArr[s10];
                            }
                            i36 = bArr3[s10] & UByte.MAX_VALUE;
                            byte b10 = (byte) i36;
                            bArr2[i27] = b10;
                            while (true) {
                                i27++;
                                i18++;
                                if (i30 <= 0) {
                                    break;
                                }
                                i30--;
                                bArr2[i27] = bArr4[i30];
                            }
                            byte[] bArr6 = bArr4;
                            if (i32 < 4096) {
                                sArr[i32] = (short) i34;
                                bArr3[i32] = b10;
                                i32++;
                                if ((i32 & i22) == 0 && i32 < 4096) {
                                    i33++;
                                    i22 += i32;
                                }
                            }
                            i34 = i38;
                            i15 = i37;
                            i31 = i31;
                            bArr4 = bArr6;
                        }
                    }
                } else {
                    i28 = i34;
                    i21 = i32;
                    i25 = i31;
                    eVar = this;
                    i29 = i36;
                    i16 = i35;
                    i20 = i33;
                    break;
                }
            }
        }
        Arrays.fill(bArr2, i27, i12, (byte) 0);
    }

    private Bitmap n() {
        Bitmap.Config config;
        Boolean bool = this.f١٥٨٢٥s;
        if (bool != null && !bool.booleanValue()) {
            config = this.f١٥٨٢٦t;
        } else {
            config = Bitmap.Config.ARGB_8888;
        }
        Bitmap c10 = this.f١٥٨٠٩c.c(this.f١٥٨٢٤r, this.f١٥٨٢٣q, config);
        c10.setHasAlpha(true);
        return c10;
    }

    private int o() {
        int p10 = p();
        if (p10 <= 0) {
            return p10;
        }
        ByteBuffer byteBuffer = this.f١٥٨١٠d;
        byteBuffer.get(this.f١٥٨١١e, 0, Math.min(p10, byteBuffer.remaining()));
        return p10;
    }

    private int p() {
        return this.f١٥٨١٠d.get() & UByte.MAX_VALUE;
    }

    private Bitmap r(b bVar, b bVar2) {
        int i10;
        int i11;
        Bitmap bitmap;
        int[] iArr = this.f١٥٨١٦j;
        int i12 = 0;
        if (bVar2 == null) {
            Bitmap bitmap2 = this.f١٥٨١٩m;
            if (bitmap2 != null) {
                this.f١٥٨٠٩c.a(bitmap2);
            }
            this.f١٥٨١٩m = null;
            Arrays.fill(iArr, 0);
        }
        if (bVar2 != null && bVar2.f١٥٧٨٤g == 3 && this.f١٥٨١٩m == null) {
            Arrays.fill(iArr, 0);
        }
        if (bVar2 != null && (i11 = bVar2.f١٥٧٨٤g) > 0) {
            if (i11 == 2) {
                if (!bVar.f١٥٧٨٣f) {
                    c cVar = this.f١٥٨١٨l;
                    int i13 = cVar.f١٥٨٠٠l;
                    if (bVar.f١٥٧٨٨k == null || cVar.f١٥٧٩٨j != bVar.f١٥٧٨٥h) {
                        i12 = i13;
                    }
                }
                int i14 = bVar2.f١٥٧٨١d;
                int i15 = this.f١٥٨٢٢p;
                int i16 = i14 / i15;
                int i17 = bVar2.f١٥٧٧٩b / i15;
                int i18 = bVar2.f١٥٧٨٠c / i15;
                int i19 = bVar2.f١٥٧٧٨a / i15;
                int i20 = this.f١٥٨٢٤r;
                int i21 = (i17 * i20) + i19;
                int i22 = (i16 * i20) + i21;
                while (i21 < i22) {
                    int i23 = i21 + i18;
                    for (int i24 = i21; i24 < i23; i24++) {
                        iArr[i24] = i12;
                    }
                    i21 += this.f١٥٨٢٤r;
                }
            } else if (i11 == 3 && (bitmap = this.f١٥٨١٩m) != null) {
                int i25 = this.f١٥٨٢٤r;
                bitmap.getPixels(iArr, 0, i25, 0, 0, i25, this.f١٥٨٢٣q);
            }
        }
        l(bVar);
        if (!bVar.f١٥٧٨٢e && this.f١٥٨٢٢p == 1) {
            k(bVar);
        } else {
            j(bVar);
        }
        if (this.f١٥٨٢٠n && ((i10 = bVar.f١٥٧٨٤g) == 0 || i10 == 1)) {
            if (this.f١٥٨١٩m == null) {
                this.f١٥٨١٩m = n();
            }
            Bitmap bitmap3 = this.f١٥٨١٩m;
            int i26 = this.f١٥٨٢٤r;
            bitmap3.setPixels(iArr, 0, i26, 0, 0, i26, this.f١٥٨٢٣q);
        }
        Bitmap n10 = n();
        int i27 = this.f١٥٨٢٤r;
        n10.setPixels(iArr, 0, i27, 0, 0, i27, this.f١٥٨٢٣q);
        return n10;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x004e A[Catch: all -> 0x000e, TryCatch #0 {all -> 0x000e, blocks: (B:3:0x0001, B:5:0x0009, B:8:0x003d, B:13:0x0047, B:15:0x004e, B:16:0x0058, B:18:0x0069, B:19:0x0075, B:22:0x007e, B:24:0x0082, B:26:0x008a, B:27:0x00a0, B:31:0x00a4, B:33:0x00a8, B:35:0x00ba, B:37:0x00be, B:38:0x00c2, B:41:0x007a, B:43:0x00c8, B:45:0x00d0, B:48:0x0011, B:50:0x0019, B:51:0x003b), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0069 A[Catch: all -> 0x000e, TryCatch #0 {all -> 0x000e, blocks: (B:3:0x0001, B:5:0x0009, B:8:0x003d, B:13:0x0047, B:15:0x004e, B:16:0x0058, B:18:0x0069, B:19:0x0075, B:22:0x007e, B:24:0x0082, B:26:0x008a, B:27:0x00a0, B:31:0x00a4, B:33:0x00a8, B:35:0x00ba, B:37:0x00be, B:38:0x00c2, B:41:0x007a, B:43:0x00c8, B:45:0x00d0, B:48:0x0011, B:50:0x0019, B:51:0x003b), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0082 A[Catch: all -> 0x000e, TryCatch #0 {all -> 0x000e, blocks: (B:3:0x0001, B:5:0x0009, B:8:0x003d, B:13:0x0047, B:15:0x004e, B:16:0x0058, B:18:0x0069, B:19:0x0075, B:22:0x007e, B:24:0x0082, B:26:0x008a, B:27:0x00a0, B:31:0x00a4, B:33:0x00a8, B:35:0x00ba, B:37:0x00be, B:38:0x00c2, B:41:0x007a, B:43:0x00c8, B:45:0x00d0, B:48:0x0011, B:50:0x0019, B:51:0x003b), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00a4 A[Catch: all -> 0x000e, TRY_ENTER, TryCatch #0 {all -> 0x000e, blocks: (B:3:0x0001, B:5:0x0009, B:8:0x003d, B:13:0x0047, B:15:0x004e, B:16:0x0058, B:18:0x0069, B:19:0x0075, B:22:0x007e, B:24:0x0082, B:26:0x008a, B:27:0x00a0, B:31:0x00a4, B:33:0x00a8, B:35:0x00ba, B:37:0x00be, B:38:0x00c2, B:41:0x007a, B:43:0x00c8, B:45:0x00d0, B:48:0x0011, B:50:0x0019, B:51:0x003b), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x007a A[Catch: all -> 0x000e, TryCatch #0 {all -> 0x000e, blocks: (B:3:0x0001, B:5:0x0009, B:8:0x003d, B:13:0x0047, B:15:0x004e, B:16:0x0058, B:18:0x0069, B:19:0x0075, B:22:0x007e, B:24:0x0082, B:26:0x008a, B:27:0x00a0, B:31:0x00a4, B:33:0x00a8, B:35:0x00ba, B:37:0x00be, B:38:0x00c2, B:41:0x007a, B:43:0x00c8, B:45:0x00d0, B:48:0x0011, B:50:0x0019, B:51:0x003b), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00d0 A[Catch: all -> 0x000e, TRY_LEAVE, TryCatch #0 {all -> 0x000e, blocks: (B:3:0x0001, B:5:0x0009, B:8:0x003d, B:13:0x0047, B:15:0x004e, B:16:0x0058, B:18:0x0069, B:19:0x0075, B:22:0x007e, B:24:0x0082, B:26:0x008a, B:27:0x00a0, B:31:0x00a4, B:33:0x00a8, B:35:0x00ba, B:37:0x00be, B:38:0x00c2, B:41:0x007a, B:43:0x00c8, B:45:0x00d0, B:48:0x0011, B:50:0x0019, B:51:0x003b), top: B:2:0x0001 }] */
    @Override // l4.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized Bitmap a() {
        int i10;
        String str;
        int i11;
        b bVar;
        int[] iArr;
        try {
            if (this.f١٥٨١٨l.f١٥٧٩١c > 0) {
                if (this.f١٥٨١٧k < 0) {
                }
                i10 = this.f١٥٨٢١o;
                if (i10 != 1 && i10 != 2) {
                    this.f١٥٨٢١o = 0;
                    if (this.f١٥٨١١e == null) {
                        this.f١٥٨١١e = this.f١٥٨٠٩c.b(KotlinVersion.MAX_COMPONENT_VALUE);
                    }
                    b bVar2 = (b) this.f١٥٨١٨l.f١٥٧٩٣e.get(this.f١٥٨١٧k);
                    i11 = this.f١٥٨١٧k - 1;
                    if (i11 < 0) {
                        bVar = (b) this.f١٥٨١٨l.f١٥٧٩٣e.get(i11);
                    } else {
                        bVar = null;
                    }
                    iArr = bVar2.f١٥٧٨٨k;
                    if (iArr != null) {
                        iArr = this.f١٥٨١٨l.f١٥٧٨٩a;
                    }
                    this.f١٥٨٠٧a = iArr;
                    if (iArr != null) {
                        String str2 = f١٥٨٠٦u;
                        if (Log.isLoggable(str2, 3)) {
                            Log.d(str2, "No valid color table found for frame #" + this.f١٥٨١٧k);
                        }
                        this.f١٥٨٢١o = 1;
                        return null;
                    }
                    if (bVar2.f١٥٧٨٣f) {
                        System.arraycopy(iArr, 0, this.f١٥٨٠٨b, 0, iArr.length);
                        int[] iArr2 = this.f١٥٨٠٨b;
                        this.f١٥٨٠٧a = iArr2;
                        iArr2[bVar2.f١٥٧٨٥h] = 0;
                        if (bVar2.f١٥٧٨٤g == 2 && this.f١٥٨١٧k == 0) {
                            this.f١٥٨٢٥s = Boolean.TRUE;
                        }
                    }
                    return r(bVar2, bVar);
                }
                str = f١٥٨٠٦u;
                if (Log.isLoggable(str, 3)) {
                    Log.d(str, "Unable to decode frame, status=" + this.f١٥٨٢١o);
                }
                return null;
            }
            String str3 = f١٥٨٠٦u;
            if (Log.isLoggable(str3, 3)) {
                Log.d(str3, "Unable to decode frame, frameCount=" + this.f١٥٨١٨l.f١٥٧٩١c + ", framePointer=" + this.f١٥٨١٧k);
            }
            this.f١٥٨٢١o = 1;
            i10 = this.f١٥٨٢١o;
            if (i10 != 1) {
                this.f١٥٨٢١o = 0;
                if (this.f١٥٨١١e == null) {
                }
                b bVar22 = (b) this.f١٥٨١٨l.f١٥٧٩٣e.get(this.f١٥٨١٧k);
                i11 = this.f١٥٨١٧k - 1;
                if (i11 < 0) {
                }
                iArr = bVar22.f١٥٧٨٨k;
                if (iArr != null) {
                }
                this.f١٥٨٠٧a = iArr;
                if (iArr != null) {
                }
            }
            str = f١٥٨٠٦u;
            if (Log.isLoggable(str, 3)) {
            }
            return null;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // l4.a
    public void b() {
        this.f١٥٨١٧k = (this.f١٥٨١٧k + 1) % this.f١٥٨١٨l.f١٥٧٩١c;
    }

    @Override // l4.a
    public int c() {
        return this.f١٥٨١٨l.f١٥٧٩١c;
    }

    @Override // l4.a
    public void clear() {
        this.f١٥٨١٨l = null;
        byte[] bArr = this.f١٥٨١٥i;
        if (bArr != null) {
            this.f١٥٨٠٩c.e(bArr);
        }
        int[] iArr = this.f١٥٨١٦j;
        if (iArr != null) {
            this.f١٥٨٠٩c.f(iArr);
        }
        Bitmap bitmap = this.f١٥٨١٩m;
        if (bitmap != null) {
            this.f١٥٨٠٩c.a(bitmap);
        }
        this.f١٥٨١٩m = null;
        this.f١٥٨١٠d = null;
        this.f١٥٨٢٥s = null;
        byte[] bArr2 = this.f١٥٨١١e;
        if (bArr2 != null) {
            this.f١٥٨٠٩c.e(bArr2);
        }
    }

    @Override // l4.a
    public void d(Bitmap.Config config) {
        Bitmap.Config config2;
        Bitmap.Config config3 = Bitmap.Config.ARGB_8888;
        if (config != config3 && config != (config2 = Bitmap.Config.RGB_565)) {
            throw new IllegalArgumentException("Unsupported format: " + config + ", must be one of " + config3 + " or " + config2);
        }
        this.f١٥٨٢٦t = config;
    }

    @Override // l4.a
    public int e() {
        int i10;
        if (this.f١٥٨١٨l.f١٥٧٩١c > 0 && (i10 = this.f١٥٨١٧k) >= 0) {
            return m(i10);
        }
        return 0;
    }

    @Override // l4.a
    public void f() {
        this.f١٥٨١٧k = -1;
    }

    @Override // l4.a
    public int g() {
        return this.f١٥٨١٧k;
    }

    @Override // l4.a
    public ByteBuffer getData() {
        return this.f١٥٨١٠d;
    }

    @Override // l4.a
    public int h() {
        return this.f١٥٨١٠d.limit() + this.f١٥٨١٥i.length + (this.f١٥٨١٦j.length * 4);
    }

    public int m(int i10) {
        if (i10 >= 0) {
            c cVar = this.f١٥٨١٨l;
            if (i10 < cVar.f١٥٧٩١c) {
                return ((b) cVar.f١٥٧٩٣e.get(i10)).f١٥٧٨٦i;
            }
        }
        return -1;
    }

    public synchronized void q(c cVar, ByteBuffer byteBuffer, int i10) {
        try {
            if (i10 > 0) {
                int highestOneBit = Integer.highestOneBit(i10);
                this.f١٥٨٢١o = 0;
                this.f١٥٨١٨l = cVar;
                this.f١٥٨١٧k = -1;
                ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
                this.f١٥٨١٠d = asReadOnlyBuffer;
                asReadOnlyBuffer.position(0);
                this.f١٥٨١٠d.order(ByteOrder.LITTLE_ENDIAN);
                this.f١٥٨٢٠n = false;
                Iterator it = cVar.f١٥٧٩٣e.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    } else if (((b) it.next()).f١٥٧٨٤g == 3) {
                        this.f١٥٨٢٠n = true;
                        break;
                    }
                }
                this.f١٥٨٢٢p = highestOneBit;
                int i11 = cVar.f١٥٧٩٤f;
                this.f١٥٨٢٤r = i11 / highestOneBit;
                int i12 = cVar.f١٥٧٩٥g;
                this.f١٥٨٢٣q = i12 / highestOneBit;
                this.f١٥٨١٥i = this.f١٥٨٠٩c.b(i11 * i12);
                this.f١٥٨١٦j = this.f١٥٨٠٩c.d(this.f١٥٨٢٤r * this.f١٥٨٢٣q);
            } else {
                throw new IllegalArgumentException("Sample size must be >=0, not: " + i10);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public e(a.InterfaceC٠١٨٦a r22) {
        this.f١٥٨٠٨b = new int[256];
        this.f١٥٨٢٦t = Bitmap.Config.ARGB_8888;
        this.f١٥٨٠٩c = r22;
        this.f١٥٨١٨l = new c();
    }
}
