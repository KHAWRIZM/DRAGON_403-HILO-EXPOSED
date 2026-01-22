package x8;

import io.agora.rtc.Constants;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.UByte;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class d {

    /* renamed from: b, reason: collision with root package name */
    static final String[] f١٨٩٨٣b = {"UPPER", "LOWER", "DIGIT", "MIXED", "PUNCT"};

    /* renamed from: c, reason: collision with root package name */
    static final int[][] f١٨٩٨٤c = {new int[]{0, 327708, 327710, 327709, 656318}, new int[]{590318, 0, 327710, 327709, 656318}, new int[]{262158, 590300, 0, 590301, 932798}, new int[]{327709, 327708, 656318, 0, 327710}, new int[]{327711, 656380, 656382, 656381, 0}};

    /* renamed from: d, reason: collision with root package name */
    private static final int[][] f١٨٩٨٥d;

    /* renamed from: e, reason: collision with root package name */
    static final int[][] f١٨٩٨٦e;

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f١٨٩٨٧a;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class a implements Comparator {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(f fVar, f fVar2) {
            return fVar.d() - fVar2.d();
        }
    }

    static {
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, 5, 256);
        f١٨٩٨٥d = iArr;
        iArr[0][32] = 1;
        for (int i10 = 65; i10 <= 90; i10++) {
            f١٨٩٨٥d[0][i10] = i10 - 63;
        }
        f١٨٩٨٥d[1][32] = 1;
        for (int i11 = 97; i11 <= 122; i11++) {
            f١٨٩٨٥d[1][i11] = i11 - 95;
        }
        f١٨٩٨٥d[2][32] = 1;
        for (int i12 = 48; i12 <= 57; i12++) {
            f١٨٩٨٥d[2][i12] = i12 - 46;
        }
        int[] iArr2 = f١٨٩٨٥d[2];
        iArr2[44] = 12;
        iArr2[46] = 13;
        int[] iArr3 = {0, 32, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 27, 28, 29, 30, 31, 64, 92, 94, 95, 96, 124, 126, Constants.ERR_WATERMARKR_INFO};
        int i13 = 0;
        for (int i14 = 28; i13 < i14; i14 = 28) {
            f١٨٩٨٥d[3][iArr3[i13]] = i13;
            i13++;
        }
        int[] iArr4 = {0, 13, 0, 0, 0, 0, 33, 39, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 58, 59, 60, 61, 62, 63, 91, 93, 123, 125};
        for (int i15 = 0; i15 < 31; i15++) {
            int i16 = iArr4[i15];
            if (i16 > 0) {
                f١٨٩٨٥d[4][i16] = i15;
            }
        }
        int[][] iArr5 = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, 6, 6);
        f١٨٩٨٦e = iArr5;
        for (int[] iArr6 : iArr5) {
            Arrays.fill(iArr6, -1);
        }
        int[][] iArr7 = f١٨٩٨٦e;
        iArr7[0][4] = 0;
        int[] iArr8 = iArr7[1];
        iArr8[4] = 0;
        iArr8[0] = 28;
        iArr7[3][4] = 0;
        int[] iArr9 = iArr7[2];
        iArr9[4] = 0;
        iArr9[0] = 15;
    }

    public d(byte[] bArr) {
        this.f١٨٩٨٧a = bArr;
    }

    private static Collection b(Iterable iterable) {
        LinkedList linkedList = new LinkedList();
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            f fVar = (f) it.next();
            Iterator it2 = linkedList.iterator();
            while (true) {
                if (it2.hasNext()) {
                    f fVar2 = (f) it2.next();
                    if (fVar2.f(fVar)) {
                        break;
                    }
                    if (fVar.f(fVar2)) {
                        it2.remove();
                    }
                } else {
                    linkedList.add(fVar);
                    break;
                }
            }
        }
        return linkedList;
    }

    private void c(f fVar, int i10, Collection collection) {
        boolean z10;
        char c10 = (char) (this.f١٨٩٨٧a[i10] & UByte.MAX_VALUE);
        if (f١٨٩٨٥d[fVar.e()][c10] > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        f fVar2 = null;
        for (int i11 = 0; i11 <= 4; i11++) {
            int i12 = f١٨٩٨٥d[i11][c10];
            if (i12 > 0) {
                if (fVar2 == null) {
                    fVar2 = fVar.b(i10);
                }
                if (!z10 || i11 == fVar.e() || i11 == 2) {
                    collection.add(fVar2.g(i11, i12));
                }
                if (!z10 && f١٨٩٨٦e[fVar.e()][i11] >= 0) {
                    collection.add(fVar2.h(i11, i12));
                }
            }
        }
        if (fVar.c() > 0 || f١٨٩٨٥d[fVar.e()][c10] == 0) {
            collection.add(fVar.a(i10));
        }
    }

    private static void d(f fVar, int i10, int i11, Collection collection) {
        f b10 = fVar.b(i10);
        collection.add(b10.g(4, i11));
        if (fVar.e() != 4) {
            collection.add(b10.h(4, i11));
        }
        if (i11 == 3 || i11 == 4) {
            collection.add(b10.g(2, 16 - i11).g(2, 1));
        }
        if (fVar.c() > 0) {
            collection.add(fVar.a(i10).a(i10 + 1));
        }
    }

    private Collection e(Iterable iterable, int i10) {
        LinkedList linkedList = new LinkedList();
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            c((f) it.next(), i10, linkedList);
        }
        return b(linkedList);
    }

    private static Collection f(Iterable iterable, int i10, int i11) {
        LinkedList linkedList = new LinkedList();
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            d((f) it.next(), i10, i11, linkedList);
        }
        return b(linkedList);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0045  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public y8.a a() {
        byte b10;
        int i10;
        Collection singletonList = Collections.singletonList(f.f١٨٩٩١e);
        int i11 = 0;
        while (true) {
            byte[] bArr = this.f١٨٩٨٧a;
            if (i11 < bArr.length) {
                int i12 = i11 + 1;
                if (i12 < bArr.length) {
                    b10 = bArr[i12];
                } else {
                    b10 = 0;
                }
                byte b11 = bArr[i11];
                if (b11 != 13) {
                    if (b11 != 44) {
                        if (b11 != 46) {
                            if (b11 == 58 && b10 == 32) {
                                i10 = 5;
                                if (i10 <= 0) {
                                    singletonList = f(singletonList, i11, i10);
                                    i11 = i12;
                                } else {
                                    singletonList = e(singletonList, i11);
                                }
                                i11++;
                            }
                            i10 = 0;
                            if (i10 <= 0) {
                            }
                            i11++;
                        } else {
                            if (b10 == 32) {
                                i10 = 3;
                                if (i10 <= 0) {
                                }
                                i11++;
                            }
                            i10 = 0;
                            if (i10 <= 0) {
                            }
                            i11++;
                        }
                    } else {
                        if (b10 == 32) {
                            i10 = 4;
                            if (i10 <= 0) {
                            }
                            i11++;
                        }
                        i10 = 0;
                        if (i10 <= 0) {
                        }
                        i11++;
                    }
                } else {
                    if (b10 == 10) {
                        i10 = 2;
                        if (i10 <= 0) {
                        }
                        i11++;
                    }
                    i10 = 0;
                    if (i10 <= 0) {
                    }
                    i11++;
                }
            } else {
                return ((f) Collections.min(singletonList, new a())).i(this.f١٨٩٨٧a);
            }
        }
    }
}
