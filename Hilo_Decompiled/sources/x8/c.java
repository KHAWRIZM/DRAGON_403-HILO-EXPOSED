package x8;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    private static final int[] f١٨٩٨٢a = {4, 6, 6, 8, 8, 8, 8, 8, 8, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12};

    private static int[] a(y8.a aVar, int i10, int i11) {
        int i12;
        int[] iArr = new int[i11];
        int g10 = aVar.g() / i10;
        for (int i13 = 0; i13 < g10; i13++) {
            int i14 = 0;
            for (int i15 = 0; i15 < i10; i15++) {
                if (aVar.f((i13 * i10) + i15)) {
                    i12 = 1 << ((i10 - i15) - 1);
                } else {
                    i12 = 0;
                }
                i14 |= i12;
            }
            iArr[i13] = i14;
        }
        return iArr;
    }

    private static void b(y8.b bVar, int i10, int i11) {
        for (int i12 = 0; i12 < i11; i12 += 2) {
            int i13 = i10 - i12;
            int i14 = i13;
            while (true) {
                int i15 = i10 + i12;
                if (i14 <= i15) {
                    bVar.g(i14, i13);
                    bVar.g(i14, i15);
                    bVar.g(i13, i14);
                    bVar.g(i15, i14);
                    i14++;
                }
            }
        }
        int i16 = i10 - i11;
        bVar.g(i16, i16);
        int i17 = i16 + 1;
        bVar.g(i17, i16);
        bVar.g(i16, i17);
        int i18 = i10 + i11;
        bVar.g(i18, i16);
        bVar.g(i18, i17);
        bVar.g(i18, i18 - 1);
    }

    private static void c(y8.b bVar, boolean z10, int i10, y8.a aVar) {
        int i11 = i10 / 2;
        int i12 = 0;
        if (z10) {
            while (i12 < 7) {
                int i13 = (i11 - 3) + i12;
                if (aVar.f(i12)) {
                    bVar.g(i13, i11 - 5);
                }
                if (aVar.f(i12 + 7)) {
                    bVar.g(i11 + 5, i13);
                }
                if (aVar.f(20 - i12)) {
                    bVar.g(i13, i11 + 5);
                }
                if (aVar.f(27 - i12)) {
                    bVar.g(i11 - 5, i13);
                }
                i12++;
            }
            return;
        }
        while (i12 < 10) {
            int i14 = (i11 - 5) + i12 + (i12 / 5);
            if (aVar.f(i12)) {
                bVar.g(i14, i11 - 7);
            }
            if (aVar.f(i12 + 10)) {
                bVar.g(i11 + 7, i14);
            }
            if (aVar.f(29 - i12)) {
                bVar.g(i14, i11 + 7);
            }
            if (aVar.f(39 - i12)) {
                bVar.g(i11 - 7, i14);
            }
            i12++;
        }
    }

    public static a d(byte[] bArr, int i10, int i11) {
        boolean z10;
        int i12;
        int i13;
        y8.a aVar;
        int i14;
        boolean z11;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22 = 2;
        y8.a a10 = new d(bArr).a();
        int g10 = ((a10.g() * i10) / 100) + 11;
        int g11 = a10.g() + g10;
        int i23 = 32;
        int i24 = 0;
        int i25 = 1;
        if (i11 != 0) {
            if (i11 < 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            i15 = Math.abs(i11);
            if (z11) {
                i23 = 4;
            }
            if (i15 <= i23) {
                i16 = i(i15, z11);
                i14 = f١٨٩٨٢a[i15];
                int i26 = i16 - (i16 % i14);
                aVar = h(a10, i14);
                if (aVar.g() + g10 <= i26) {
                    if (z11 && aVar.g() > (i14 << 6)) {
                        throw new IllegalArgumentException("Data to large for user specified layer");
                    }
                } else {
                    throw new IllegalArgumentException("Data to large for user specified layer");
                }
            } else {
                throw new IllegalArgumentException(String.format("Illegal value %s for layers", Integer.valueOf(i11)));
            }
        } else {
            y8.a aVar2 = null;
            int i27 = 0;
            int i28 = 0;
            while (i27 <= i23) {
                if (i27 <= 3) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (z10) {
                    i12 = i27 + 1;
                } else {
                    i12 = i27;
                }
                int i29 = i(i12, z10);
                if (g11 <= i29) {
                    if (aVar2 == null || i28 != f١٨٩٨٢a[i12]) {
                        int i30 = f١٨٩٨٢a[i12];
                        i28 = i30;
                        aVar2 = h(a10, i30);
                    }
                    int i31 = i29 - (i29 % i28);
                    if ((z10 && aVar2.g() > (i28 << 6)) || aVar2.g() + g10 > i31) {
                        i13 = 1;
                    } else {
                        aVar = aVar2;
                        i14 = i28;
                        z11 = z10;
                        i15 = i12;
                        i16 = i29;
                    }
                } else {
                    i13 = 1;
                }
                i27 += i13;
                i22 = 2;
                i23 = 32;
                i24 = 0;
                i25 = 1;
            }
            throw new IllegalArgumentException("Data too large for an Aztec code");
        }
        y8.a e10 = e(aVar, i16, i14);
        int g12 = aVar.g() / i14;
        y8.a f10 = f(z11, i15, g12);
        if (z11) {
            i17 = 11;
        } else {
            i17 = 14;
        }
        int i32 = i17 + (i15 << 2);
        int[] iArr = new int[i32];
        if (z11) {
            for (int i33 = 0; i33 < i32; i33 += i25) {
                iArr[i33] = i33;
            }
            i18 = i32;
        } else {
            int i34 = i32 / 2;
            i18 = i32 + 1 + (((i34 - 1) / 15) * 2);
            int i35 = i18 / 2;
            for (int i36 = 0; i36 < i34; i36 += i25) {
                iArr[(i34 - i36) - 1] = (i35 - r15) - 1;
                iArr[i34 + i36] = (i36 / 15) + i36 + i35 + i25;
            }
        }
        y8.b bVar = new y8.b(i18);
        int i37 = 0;
        int i38 = 0;
        while (i37 < i15) {
            int i39 = (i15 - i37) << i22;
            if (z11) {
                i19 = 9;
            } else {
                i19 = 12;
            }
            int i40 = i39 + i19;
            while (i24 < i40) {
                int i41 = i24 << 1;
                int i42 = 0;
                while (i42 < i22) {
                    if (e10.f(i38 + i41 + i42)) {
                        int i43 = i37 << 1;
                        bVar.g(iArr[i43 + i42], iArr[i43 + i24]);
                    }
                    if (e10.f((i40 << 1) + i38 + i41 + i42)) {
                        int i44 = i37 << 1;
                        i20 = g12;
                        bVar.g(iArr[i44 + i24], iArr[((i32 - 1) - i44) - i42]);
                    } else {
                        i20 = g12;
                    }
                    if (e10.f((i40 << 2) + i38 + i41 + i42)) {
                        int i45 = (i32 - 1) - (i37 << 1);
                        bVar.g(iArr[i45 - i42], iArr[i45 - i24]);
                    }
                    if (e10.f((i40 * 6) + i38 + i41 + i42)) {
                        i21 = 1;
                        int i46 = i37 << 1;
                        bVar.g(iArr[((i32 - 1) - i46) - i24], iArr[i46 + i42]);
                    } else {
                        i21 = 1;
                    }
                    i42 += i21;
                    g12 = i20;
                    i22 = 2;
                }
                i24++;
                i22 = 2;
            }
            i38 += i40 << 3;
            i37++;
            g12 = g12;
            i22 = 2;
            i24 = 0;
        }
        int i47 = g12;
        c(bVar, z11, i18, f10);
        if (z11) {
            b(bVar, i18 / 2, 5);
        } else {
            int i48 = i18 / 2;
            b(bVar, i48, 7);
            int i49 = 0;
            int i50 = 0;
            while (i49 < (i32 / 2) - 1) {
                for (int i51 = i48 & 1; i51 < i18; i51 += 2) {
                    int i52 = i48 - i50;
                    bVar.g(i52, i51);
                    int i53 = i48 + i50;
                    bVar.g(i53, i51);
                    bVar.g(i51, i52);
                    bVar.g(i51, i53);
                }
                i49 += 15;
                i50 += 16;
            }
        }
        a aVar3 = new a();
        aVar3.c(z11);
        aVar3.f(i18);
        aVar3.d(i15);
        aVar3.b(i47);
        aVar3.e(bVar);
        return aVar3;
    }

    private static y8.a e(y8.a aVar, int i10, int i11) {
        int g10 = aVar.g() / i11;
        z8.c cVar = new z8.c(g(i11));
        int i12 = i10 / i11;
        int[] a10 = a(aVar, i11, i12);
        cVar.b(a10, i12 - g10);
        y8.a aVar2 = new y8.a();
        aVar2.c(0, i10 % i11);
        for (int i13 : a10) {
            aVar2.c(i13, i11);
        }
        return aVar2;
    }

    static y8.a f(boolean z10, int i10, int i11) {
        y8.a aVar = new y8.a();
        if (z10) {
            aVar.c(i10 - 1, 2);
            aVar.c(i11 - 1, 6);
            return e(aVar, 28, 4);
        }
        aVar.c(i10 - 1, 5);
        aVar.c(i11 - 1, 11);
        return e(aVar, 40, 4);
    }

    private static z8.a g(int i10) {
        if (i10 != 4) {
            if (i10 != 6) {
                if (i10 != 8) {
                    if (i10 != 10) {
                        if (i10 == 12) {
                            return z8.a.f١٩٥٠٢h;
                        }
                        throw new IllegalArgumentException("Unsupported word size ".concat(String.valueOf(i10)));
                    }
                    return z8.a.f١٩٥٠٣i;
                }
                return z8.a.f١٩٥٠٨n;
            }
            return z8.a.f١٩٥٠٤j;
        }
        return z8.a.f١٩٥٠٥k;
    }

    static y8.a h(y8.a aVar, int i10) {
        y8.a aVar2 = new y8.a();
        int g10 = aVar.g();
        int i11 = (1 << i10) - 2;
        int i12 = 0;
        while (i12 < g10) {
            int i13 = 0;
            for (int i14 = 0; i14 < i10; i14++) {
                int i15 = i12 + i14;
                if (i15 >= g10 || aVar.f(i15)) {
                    i13 |= 1 << ((i10 - 1) - i14);
                }
            }
            int i16 = i13 & i11;
            if (i16 == i11) {
                aVar2.c(i16, i10);
            } else if (i16 == 0) {
                aVar2.c(i13 | 1, i10);
            } else {
                aVar2.c(i13, i10);
                i12 += i10;
            }
            i12--;
            i12 += i10;
        }
        return aVar2;
    }

    private static int i(int i10, boolean z10) {
        int i11;
        if (z10) {
            i11 = 88;
        } else {
            i11 = 112;
        }
        return (i11 + (i10 << 4)) * i10;
    }
}
