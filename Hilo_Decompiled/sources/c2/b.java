package c2;

import c2.e;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.util.ArrayList;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class b {
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0031, code lost:
    
        if (r7 == 2) goto L١٦;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0033, code lost:
    
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:320:0x0035, code lost:
    
        r5 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:328:0x004b, code lost:
    
        if (r7 == 2) goto L١٦;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0261 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:143:0x04de A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:150:0x04ea  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x04f6  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x04ff  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0506  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0516  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x051a A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:169:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0502  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x04f9  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x02bf A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:198:0x03a7  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x03a9 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:213:0x034e  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x03b2 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:254:0x03c5  */
    /* JADX WARN: Removed duplicated region for block: B:306:0x04a0  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01b4  */
    /* JADX WARN: Type inference failed for: r1v40, types: [c2.e] */
    /* JADX WARN: Type inference failed for: r8v37 */
    /* JADX WARN: Type inference failed for: r8v38 */
    /* JADX WARN: Type inference failed for: r8v43 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6, types: [c2.e] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static void a(f fVar, z1.d dVar, int i10, int i11, c cVar) {
        boolean z10;
        boolean z11;
        boolean z12;
        ArrayList arrayList;
        e eVar;
        d dVar2;
        d dVar3;
        d dVar4;
        e eVar2;
        int i12;
        e eVar3;
        d dVar5;
        z1.i iVar;
        z1.i iVar2;
        e eVar4;
        d dVar6;
        e eVar5;
        z1.i iVar3;
        e eVar6;
        e eVar7;
        z1.i iVar4;
        float f10;
        int size;
        int i13;
        ArrayList arrayList2;
        int i14;
        boolean z13;
        boolean z14;
        e eVar8;
        e eVar9;
        int i15;
        int i16 = i10;
        e eVar10 = cVar.f٥٦٥٨a;
        e eVar11 = cVar.f٥٦٦٠c;
        e eVar12 = cVar.f٥٦٥٩b;
        e eVar13 = cVar.f٥٦٦١d;
        e eVar14 = cVar.f٥٦٦٢e;
        float f11 = cVar.f٥٦٦٨k;
        boolean z15 = fVar.f٥٧٠٤b0[i16] == e.b.WRAP_CONTENT;
        if (i16 == 0) {
            int i17 = eVar14.J0;
            z10 = i17 == 0;
            z11 = i17 == 1;
        } else {
            int i18 = eVar14.K0;
            z10 = i18 == 0;
            z11 = i18 == 1;
        }
        boolean z16 = z11;
        boolean z17 = false;
        boolean z18 = z10;
        ?? r82 = eVar10;
        while (true) {
            if (z17) {
                break;
            }
            d dVar7 = r82.Y[i11];
            int i19 = z12 ? 1 : 4;
            int f12 = dVar7.f();
            e.b bVar = r82.f٥٧٠٤b0[i16];
            float f13 = f11;
            e.b bVar2 = e.b.MATCH_CONSTRAINT;
            if (bVar == bVar2 && r82.f٥٧٤٩y[i16] == 0) {
                z13 = z17;
                z14 = true;
            } else {
                z13 = z17;
                z14 = false;
            }
            d dVar8 = dVar7.f٥٦٨٥f;
            if (dVar8 != null && r82 != eVar10) {
                f12 += dVar8.f();
            }
            int i20 = f12;
            if (!z12 || r82 == eVar10 || r82 == eVar12) {
                eVar8 = eVar14;
            } else {
                eVar8 = eVar14;
                i19 = 8;
            }
            d dVar9 = dVar7.f٥٦٨٥f;
            if (dVar9 != null) {
                if (r82 == eVar12) {
                    eVar9 = eVar10;
                    dVar.h(dVar7.f٥٦٨٨i, dVar9.f٥٦٨٨i, i20, 6);
                } else {
                    eVar9 = eVar10;
                    dVar.h(dVar7.f٥٦٨٨i, dVar9.f٥٦٨٨i, i20, 8);
                }
                if (z14 && !z12) {
                    i19 = 5;
                }
                dVar.e(dVar7.f٥٦٨٨i, dVar7.f٥٦٨٥f.f٥٦٨٨i, i20, (r82 == eVar12 && z12 && r82.j0(i16)) ? 5 : i19);
            } else {
                eVar9 = eVar10;
            }
            if (z15) {
                if (r82.X() == 8 || r82.f٥٧٠٤b0[i16] != bVar2) {
                    i15 = 0;
                } else {
                    d[] dVarArr = r82.Y;
                    i15 = 0;
                    dVar.h(dVarArr[i11 + 1].f٥٦٨٨i, dVarArr[i11].f٥٦٨٨i, 0, 5);
                }
                dVar.h(r82.Y[i11].f٥٦٨٨i, fVar.Y[i11].f٥٦٨٨i, i15, 8);
            }
            d dVar10 = r82.Y[i11 + 1].f٥٦٨٥f;
            if (dVar10 != null) {
                ?? r12 = dVar10.f٥٦٨٣d;
                d dVar11 = r12.Y[i11].f٥٦٨٥f;
                if (dVar11 != null && dVar11.f٥٦٨٣d == r82) {
                    r21 = r12;
                }
            }
            if (r21 != null) {
                r82 = r21;
                z17 = z13;
            } else {
                z17 = true;
            }
            eVar14 = eVar8;
            f11 = f13;
            eVar10 = eVar9;
            r82 = r82;
        }
        e eVar15 = eVar14;
        float f14 = f11;
        e eVar16 = eVar10;
        if (eVar13 != null) {
            int i21 = i11 + 1;
            if (eVar11.Y[i21].f٥٦٨٥f != null) {
                d dVar12 = eVar13.Y[i21];
                if (eVar13.f٥٧٠٤b0[i16] == e.b.MATCH_CONSTRAINT && eVar13.f٥٧٤٩y[i16] == 0 && !z12) {
                    d dVar13 = dVar12.f٥٦٨٥f;
                    if (dVar13.f٥٦٨٣d == fVar) {
                        dVar.e(dVar12.f٥٦٨٨i, dVar13.f٥٦٨٨i, -dVar12.f(), 5);
                        dVar.j(dVar12.f٥٦٨٨i, eVar11.Y[i21].f٥٦٨٥f.f٥٦٨٨i, -dVar12.f(), 6);
                        if (z15) {
                            int i22 = i11 + 1;
                            z1.i iVar5 = fVar.Y[i22].f٥٦٨٨i;
                            d dVar14 = eVar11.Y[i22];
                            dVar.h(iVar5, dVar14.f٥٦٨٨i, dVar14.f(), 8);
                        }
                        arrayList = cVar.f٥٦٦٥h;
                        if (arrayList != null && (size = arrayList.size()) > 1) {
                            float f15 = (cVar.f٥٦٧٥r || cVar.f٥٦٧٧t) ? f14 : cVar.f٥٦٦٧j;
                            float f16 = DownloadProgress.UNKNOWN_PROGRESS;
                            e eVar17 = null;
                            i13 = 0;
                            float f17 = DownloadProgress.UNKNOWN_PROGRESS;
                            while (i13 < size) {
                                e eVar18 = (e) arrayList.get(i13);
                                float f18 = eVar18.N0[i16];
                                if (f18 < f16) {
                                    if (cVar.f٥٦٧٧t) {
                                        d[] dVarArr2 = eVar18.Y;
                                        dVar.e(dVarArr2[i11 + 1].f٥٦٨٨i, dVarArr2[i11].f٥٦٨٨i, 0, 4);
                                        arrayList2 = arrayList;
                                        i14 = size;
                                        i13++;
                                        size = i14;
                                        arrayList = arrayList2;
                                        f16 = DownloadProgress.UNKNOWN_PROGRESS;
                                    } else {
                                        f18 = 1.0f;
                                    }
                                }
                                if (f18 == DownloadProgress.UNKNOWN_PROGRESS) {
                                    d[] dVarArr3 = eVar18.Y;
                                    dVar.e(dVarArr3[i11 + 1].f٥٦٨٨i, dVarArr3[i11].f٥٦٨٨i, 0, 8);
                                    arrayList2 = arrayList;
                                    i14 = size;
                                    i13++;
                                    size = i14;
                                    arrayList = arrayList2;
                                    f16 = DownloadProgress.UNKNOWN_PROGRESS;
                                } else {
                                    if (eVar17 != null) {
                                        d[] dVarArr4 = eVar17.Y;
                                        z1.i iVar6 = dVarArr4[i11].f٥٦٨٨i;
                                        int i23 = i11 + 1;
                                        z1.i iVar7 = dVarArr4[i23].f٥٦٨٨i;
                                        d[] dVarArr5 = eVar18.Y;
                                        arrayList2 = arrayList;
                                        z1.i iVar8 = dVarArr5[i11].f٥٦٨٨i;
                                        z1.i iVar9 = dVarArr5[i23].f٥٦٨٨i;
                                        i14 = size;
                                        z1.b r10 = dVar.r();
                                        r10.l(f17, f15, f18, iVar6, iVar7, iVar8, iVar9);
                                        dVar.d(r10);
                                    } else {
                                        arrayList2 = arrayList;
                                        i14 = size;
                                    }
                                    eVar17 = eVar18;
                                    f17 = f18;
                                    i13++;
                                    size = i14;
                                    arrayList = arrayList2;
                                    f16 = DownloadProgress.UNKNOWN_PROGRESS;
                                }
                            }
                        }
                        if (eVar12 == null && (eVar12 == eVar13 || z12)) {
                            d dVar15 = eVar16.Y[i11];
                            int i24 = i11 + 1;
                            d dVar16 = eVar11.Y[i24];
                            d dVar17 = dVar15.f٥٦٨٥f;
                            z1.i iVar10 = dVar17 != null ? dVar17.f٥٦٨٨i : null;
                            d dVar18 = dVar16.f٥٦٨٥f;
                            z1.i iVar11 = dVar18 != null ? dVar18.f٥٦٨٨i : null;
                            d dVar19 = eVar12.Y[i11];
                            if (eVar13 != null) {
                                dVar16 = eVar13.Y[i24];
                            }
                            if (iVar10 != null && iVar11 != null) {
                                if (i16 == 0) {
                                    f10 = eVar15.f٥٧٣٤q0;
                                } else {
                                    f10 = eVar15.f٥٧٣٦r0;
                                }
                                dVar.c(dVar19.f٥٦٨٨i, iVar10, dVar19.f(), f10, iVar11, dVar16.f٥٦٨٨i, dVar16.f(), 7);
                            }
                        } else if (z18 || eVar12 == null) {
                            int i25 = 8;
                            if (z16 && eVar12 != null) {
                                int i26 = cVar.f٥٦٦٧j;
                                boolean z19 = i26 <= 0 && cVar.f٥٦٦٦i == i26;
                                e eVar19 = eVar12;
                                eVar = eVar19;
                                while (eVar != null) {
                                    e eVar20 = eVar.P0[i16];
                                    while (eVar20 != null && eVar20.X() == i25) {
                                        eVar20 = eVar20.P0[i16];
                                    }
                                    if (eVar == eVar12 || eVar == eVar13 || eVar20 == null) {
                                        eVar2 = eVar19;
                                        i12 = 8;
                                    } else {
                                        e eVar21 = eVar20 == eVar13 ? null : eVar20;
                                        d dVar20 = eVar.Y[i11];
                                        z1.i iVar12 = dVar20.f٥٦٨٨i;
                                        d dVar21 = dVar20.f٥٦٨٥f;
                                        if (dVar21 != null) {
                                            z1.i iVar13 = dVar21.f٥٦٨٨i;
                                        }
                                        int i27 = i11 + 1;
                                        z1.i iVar14 = eVar19.Y[i27].f٥٦٨٨i;
                                        int f19 = dVar20.f();
                                        int f20 = eVar.Y[i27].f();
                                        if (eVar21 != null) {
                                            dVar5 = eVar21.Y[i11];
                                            z1.i iVar15 = dVar5.f٥٦٨٨i;
                                            eVar3 = eVar21;
                                            d dVar22 = dVar5.f٥٦٨٥f;
                                            iVar2 = dVar22 != null ? dVar22.f٥٦٨٨i : null;
                                            iVar = iVar15;
                                        } else {
                                            eVar3 = eVar21;
                                            dVar5 = eVar13.Y[i11];
                                            iVar = dVar5 != null ? dVar5.f٥٦٨٨i : null;
                                            iVar2 = eVar.Y[i27].f٥٦٨٨i;
                                        }
                                        if (dVar5 != null) {
                                            f20 += dVar5.f();
                                        }
                                        int i28 = f20;
                                        int f21 = eVar19.Y[i27].f() + f19;
                                        int i29 = z19 ? 8 : 4;
                                        if (iVar12 == null || iVar14 == null || iVar == null || iVar2 == null) {
                                            eVar4 = eVar3;
                                            eVar2 = eVar19;
                                            i12 = 8;
                                        } else {
                                            eVar4 = eVar3;
                                            eVar2 = eVar19;
                                            i12 = 8;
                                            dVar.c(iVar12, iVar14, f21, 0.5f, iVar, iVar2, i28, i29);
                                        }
                                        eVar20 = eVar4;
                                    }
                                    eVar19 = eVar.X() != i12 ? eVar : eVar2;
                                    i16 = i10;
                                    eVar = eVar20;
                                    i25 = 8;
                                }
                                d dVar23 = eVar12.Y[i11];
                                dVar2 = eVar16.Y[i11].f٥٦٨٥f;
                                int i30 = i11 + 1;
                                dVar3 = eVar13.Y[i30];
                                dVar4 = eVar11.Y[i30].f٥٦٨٥f;
                                if (dVar2 != null) {
                                    if (eVar12 != eVar13) {
                                        dVar.e(dVar23.f٥٦٨٨i, dVar2.f٥٦٨٨i, dVar23.f(), 5);
                                    } else if (dVar4 != null) {
                                        dVar.c(dVar23.f٥٦٨٨i, dVar2.f٥٦٨٨i, dVar23.f(), 0.5f, dVar3.f٥٦٨٨i, dVar4.f٥٦٨٨i, dVar3.f(), 5);
                                    }
                                }
                                if (dVar4 != null && eVar12 != eVar13) {
                                    dVar.e(dVar3.f٥٦٨٨i, dVar4.f٥٦٨٨i, -dVar3.f(), 5);
                                }
                            }
                        } else {
                            int i31 = cVar.f٥٦٦٧j;
                            boolean z20 = i31 > 0 && cVar.f٥٦٦٦i == i31;
                            e eVar22 = eVar12;
                            e eVar23 = eVar22;
                            while (eVar23 != null) {
                                e eVar24 = eVar23.P0[i16];
                                while (eVar24 != null && eVar24.X() == 8) {
                                    eVar24 = eVar24.P0[i16];
                                }
                                if (eVar24 != null || eVar23 == eVar13) {
                                    d dVar24 = eVar23.Y[i11];
                                    z1.i iVar16 = dVar24.f٥٦٨٨i;
                                    d dVar25 = dVar24.f٥٦٨٥f;
                                    z1.i iVar17 = dVar25 != null ? dVar25.f٥٦٨٨i : null;
                                    if (eVar22 != eVar23) {
                                        iVar17 = eVar22.Y[i11 + 1].f٥٦٨٨i;
                                    } else if (eVar23 == eVar12) {
                                        d dVar26 = eVar16.Y[i11].f٥٦٨٥f;
                                        iVar17 = dVar26 != null ? dVar26.f٥٦٨٨i : null;
                                    }
                                    int f22 = dVar24.f();
                                    int i32 = i11 + 1;
                                    int f23 = eVar23.Y[i32].f();
                                    if (eVar24 != null) {
                                        dVar6 = eVar24.Y[i11];
                                        iVar3 = dVar6.f٥٦٨٨i;
                                    } else {
                                        dVar6 = eVar11.Y[i32].f٥٦٨٥f;
                                        if (dVar6 != null) {
                                            iVar3 = dVar6.f٥٦٨٨i;
                                        } else {
                                            eVar5 = eVar24;
                                            iVar3 = null;
                                            z1.i iVar18 = eVar23.Y[i32].f٥٦٨٨i;
                                            if (dVar6 != null) {
                                                f23 += dVar6.f();
                                            }
                                            int f24 = f22 + eVar22.Y[i32].f();
                                            if (iVar16 != null || iVar17 == null || iVar3 == null || iVar18 == null) {
                                                eVar6 = eVar5;
                                            } else {
                                                if (eVar23 == eVar12) {
                                                    f24 = eVar12.Y[i11].f();
                                                }
                                                int i33 = f24;
                                                eVar6 = eVar5;
                                                eVar7 = eVar22;
                                                dVar.c(iVar16, iVar17, i33, 0.5f, iVar3, iVar18, eVar23 == eVar13 ? eVar13.Y[i32].f() : f23, z20 ? 8 : 5);
                                                if (eVar23.X() != 8) {
                                                    eVar23 = eVar7;
                                                }
                                                eVar22 = eVar23;
                                                eVar23 = eVar6;
                                            }
                                        }
                                    }
                                    eVar5 = eVar24;
                                    z1.i iVar182 = eVar23.Y[i32].f٥٦٨٨i;
                                    if (dVar6 != null) {
                                    }
                                    int f242 = f22 + eVar22.Y[i32].f();
                                    if (iVar16 != null) {
                                    }
                                    eVar6 = eVar5;
                                } else {
                                    eVar6 = eVar24;
                                }
                                eVar7 = eVar22;
                                if (eVar23.X() != 8) {
                                }
                                eVar22 = eVar23;
                                eVar23 = eVar6;
                            }
                        }
                        if ((z18 && !z16) || eVar12 == null || eVar12 == eVar13) {
                            return;
                        }
                        d[] dVarArr6 = eVar12.Y;
                        d dVar27 = dVarArr6[i11];
                        if (eVar13 == null) {
                            eVar13 = eVar12;
                        }
                        int i34 = i11 + 1;
                        d dVar28 = eVar13.Y[i34];
                        d dVar29 = dVar27.f٥٦٨٥f;
                        iVar4 = dVar29 != null ? dVar29.f٥٦٨٨i : null;
                        d dVar30 = dVar28.f٥٦٨٥f;
                        z1.i iVar19 = dVar30 != null ? dVar30.f٥٦٨٨i : null;
                        if (eVar11 != eVar13) {
                            d dVar31 = eVar11.Y[i34].f٥٦٨٥f;
                            iVar19 = dVar31 != null ? dVar31.f٥٦٨٨i : null;
                        }
                        if (eVar12 == eVar13) {
                            dVar28 = dVarArr6[i34];
                        }
                        if (iVar4 == null || iVar19 == null) {
                            return;
                        }
                        dVar.c(dVar27.f٥٦٨٨i, iVar4, dVar27.f(), 0.5f, iVar19, dVar28.f٥٦٨٨i, eVar13.Y[i34].f(), 5);
                        return;
                    }
                }
                if (z12) {
                    d dVar32 = dVar12.f٥٦٨٥f;
                    if (dVar32.f٥٦٨٣d == fVar) {
                        dVar.e(dVar12.f٥٦٨٨i, dVar32.f٥٦٨٨i, -dVar12.f(), 4);
                    }
                }
                dVar.j(dVar12.f٥٦٨٨i, eVar11.Y[i21].f٥٦٨٥f.f٥٦٨٨i, -dVar12.f(), 6);
                if (z15) {
                }
                arrayList = cVar.f٥٦٦٥h;
                if (arrayList != null) {
                    if (cVar.f٥٦٧٥r) {
                    }
                    float f162 = DownloadProgress.UNKNOWN_PROGRESS;
                    e eVar172 = null;
                    i13 = 0;
                    float f172 = DownloadProgress.UNKNOWN_PROGRESS;
                    while (i13 < size) {
                    }
                }
                if (eVar12 == null) {
                }
                if (z18) {
                }
                int i252 = 8;
                if (z16) {
                    int i262 = cVar.f٥٦٦٧j;
                    if (i262 <= 0) {
                    }
                    e eVar192 = eVar12;
                    eVar = eVar192;
                    while (eVar != null) {
                    }
                    d dVar232 = eVar12.Y[i11];
                    dVar2 = eVar16.Y[i11].f٥٦٨٥f;
                    int i302 = i11 + 1;
                    dVar3 = eVar13.Y[i302];
                    dVar4 = eVar11.Y[i302].f٥٦٨٥f;
                    if (dVar2 != null) {
                    }
                    if (dVar4 != null) {
                        dVar.e(dVar3.f٥٦٨٨i, dVar4.f٥٦٨٨i, -dVar3.f(), 5);
                    }
                }
                if (z18) {
                }
                d[] dVarArr62 = eVar12.Y;
                d dVar272 = dVarArr62[i11];
                if (eVar13 == null) {
                }
                int i342 = i11 + 1;
                d dVar282 = eVar13.Y[i342];
                d dVar292 = dVar272.f٥٦٨٥f;
                if (dVar292 != null) {
                }
                d dVar302 = dVar282.f٥٦٨٥f;
                if (dVar302 != null) {
                }
                if (eVar11 != eVar13) {
                }
                if (eVar12 == eVar13) {
                }
                if (iVar4 == null) {
                    return;
                } else {
                    return;
                }
            }
        }
        if (z15) {
        }
        arrayList = cVar.f٥٦٦٥h;
        if (arrayList != null) {
        }
        if (eVar12 == null) {
        }
        if (z18) {
        }
        int i2522 = 8;
        if (z16) {
        }
        if (z18) {
        }
        d[] dVarArr622 = eVar12.Y;
        d dVar2722 = dVarArr622[i11];
        if (eVar13 == null) {
        }
        int i3422 = i11 + 1;
        d dVar2822 = eVar13.Y[i3422];
        d dVar2922 = dVar2722.f٥٦٨٥f;
        if (dVar2922 != null) {
        }
        d dVar3022 = dVar2822.f٥٦٨٥f;
        if (dVar3022 != null) {
        }
        if (eVar11 != eVar13) {
        }
        if (eVar12 == eVar13) {
        }
        if (iVar4 == null) {
        }
    }

    public static void b(f fVar, z1.d dVar, ArrayList arrayList, int i10) {
        int i11;
        c[] cVarArr;
        int i12;
        if (i10 == 0) {
            i11 = fVar.f٥٧٦٦g1;
            cVarArr = fVar.f٥٧٦٩j1;
            i12 = 0;
        } else {
            i11 = fVar.f٥٧٦٧h1;
            cVarArr = fVar.f٥٧٦٨i1;
            i12 = 2;
        }
        for (int i13 = 0; i13 < i11; i13++) {
            c cVar = cVarArr[i13];
            cVar.a();
            if (arrayList == null || arrayList.contains(cVar.f٥٦٥٨a)) {
                a(fVar, dVar, i10, i12, cVar);
            }
        }
    }
}
