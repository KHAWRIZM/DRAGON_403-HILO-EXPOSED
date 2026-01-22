package j0;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import tech.sud.gip.core.PkgDownloadStatus;
import tech.sud.gip.logger.SudLogger;
import tech.sud.logger.LogUtils;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class e {

    /* renamed from: d, reason: collision with root package name */
    public static final String f١٥٠٧٩d = "SudGIP ".concat(e.class.getSimpleName());

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f١٥٠٨٠a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public final u.i f١٥٠٨١b = new u.i();

    /* renamed from: c, reason: collision with root package name */
    public final x f١٥٠٨٢c = new x(this);

    public e() {
        n0.f.a().f١٦١٣٧a.f١٨٦٣٢a = Math.max(1, 3);
    }

    public static boolean d(t.d dVar) {
        String str;
        File[] listFiles;
        String str2 = dVar.f١٧٩٤٢b;
        if (str2 != null && !str2.isEmpty() && (str = dVar.f١٧٩٤٣c) != null && str.equals(dVar.f١٧٩٤٢b)) {
            t.b bVar = dVar.f١٧٩٤١a;
            if (bVar != t.b.LoadMGPackageGamePackage && bVar != t.b.PreloadPackageGamePackage) {
                if (bVar == t.b.LoadMGPackageCore || bVar == t.b.PreloadPackageCore) {
                    int i10 = dVar.f١٧٩٤٧g;
                    if (i10 == 1) {
                        boolean b10 = u.f.b(dVar.f١٧٩٤٦f, dVar.f١٧٩٤٤d, dVar.f١٧٩٤٥e);
                        boolean b11 = u.f.b(0L, dVar.f١٧٩٤٤d, null);
                        LogUtils.file("SudDownloadManager", "isCoreInstalled isOK1=" + b10 + "  isOk2=" + b11);
                        SudLogger.d(f١٥٠٧٩d, "isCoreInstalled isOK1=" + b10 + "  isOk2=" + b11);
                        if (b10 && b11) {
                            File file = new File(dVar.f١٧٩٤٤d);
                            d0.a a10 = d0.a.a("TechSudMGPGlobal.sp");
                            if (!a10.f١٣٥٣٩a.getBoolean("key_fix_android14_read_only_cocos", false)) {
                                a10.e("key_fix_android14_read_only_cocos");
                                nf.b.d(file);
                            }
                            return true;
                        }
                    } else if (i10 == 5) {
                        File file2 = new File(dVar.f١٧٩٤٤d);
                        if (file2.exists() && file2.isDirectory() && (listFiles = file2.listFiles()) != null && listFiles.length > 0 && listFiles[0].isFile() && listFiles[0].length() > 0) {
                            d0.a a11 = d0.a.a("TechSudMGPGlobal.sp");
                            if (!a11.f١٣٥٣٩a.getBoolean("key_fix_android14_read_only_unity", false)) {
                                a11.e("key_fix_android14_read_only_unity");
                                nf.b.d(file2);
                            }
                            return true;
                        }
                    }
                }
            } else {
                boolean b12 = u.f.b(dVar.f١٧٩٤٦f, dVar.f١٧٩٤٤d, dVar.f١٧٩٤٥e);
                LogUtils.file("SudDownloadManager", "isPackageInstalled isOk=" + b12);
                SudLogger.d(f١٥٠٧٩d, "isPackageInstalled isOk=" + b12);
                return b12;
            }
        }
        LogUtils.file("SudDownloadManager", "isPackageInstalled not exists:" + dVar.f١٧٩٤٤d);
        SudLogger.d(f١٥٠٧٩d, "isPackageInstalled not exists:" + dVar.f١٧٩٤٤d);
        return false;
    }

    public final long a(t.c cVar, String str, String str2, c cVar2, x0.c cVar3) {
        d dVar;
        d dVar2;
        boolean z10;
        LogUtils.file("SudDownloadManager", "downloadPackage:" + cVar.f١٧٩٣٦c);
        SudLogger.d(f١٥٠٧٩d, "downloadPackage:" + cVar.f١٧٩٣٦c);
        ArrayList arrayList = this.f١٥٠٨٠a;
        int size = arrayList.size();
        int i10 = 0;
        int i11 = 0;
        while (true) {
            dVar = null;
            if (i11 < size) {
                Object obj = arrayList.get(i11);
                i11++;
                dVar2 = (d) obj;
                long j10 = cVar.f١٧٩٣٦c;
                String str3 = cVar.f١٧٩٣٧d;
                if (dVar2 != null && dVar2.f١٥٠٦٠b == j10 && Objects.equals(dVar2.f١٥٠٥٩a.f١٦١١٤c, str3)) {
                    if (Objects.equals(dVar2.f١٥٠٦٢d, str)) {
                        if (Objects.equals(dVar2.f١٥٠٦٣e, str2)) {
                            break;
                        }
                    }
                }
            } else {
                dVar2 = null;
                break;
            }
        }
        if (dVar2 == null) {
            try {
                u.i iVar = this.f١٥٠٨١b;
                long j11 = iVar.f١٨٢٢٤a + 1;
                iVar.f١٨٢٢٤a = j11;
                d dVar3 = new d(cVar, j11, str, str2, this.f١٥٠٨٢c);
                dVar3.c(cVar2);
                dVar3.f١٥٠٦٧i = cVar3;
                PkgDownloadStatus pkgDownloadStatus = PkgDownloadStatus.PKG_DOWNLOAD_WAITING;
                dVar3.f١٥٠٦٦h = pkgDownloadStatus;
                dVar3.f١٥٠٧٦r = System.currentTimeMillis();
                dVar3.d(pkgDownloadStatus);
                this.f١٥٠٨٠a.add(dVar3);
                dVar2 = dVar3;
            } catch (Exception e10) {
                LogUtils.file("SudDownloadManager", "create download task error:" + LogUtils.getErrorInfo(e10));
                cVar2.e(-1, "create download task error:" + e10, null);
                dVar2 = null;
            }
            if (dVar2 == null) {
                return 0L;
            }
            z10 = true;
        } else {
            dVar2.c(cVar2);
            z10 = false;
        }
        PkgDownloadStatus pkgDownloadStatus2 = dVar2.f١٥٠٦٦h;
        if (pkgDownloadStatus2 == PkgDownloadStatus.PKG_DOWNLOAD_PAUSE || pkgDownloadStatus2 == PkgDownloadStatus.PKG_DOWNLOAD_COMPLETED || pkgDownloadStatus2 == PkgDownloadStatus.PKG_DOWNLOAD_CANCELED) {
            PkgDownloadStatus pkgDownloadStatus3 = PkgDownloadStatus.PKG_DOWNLOAD_WAITING;
            dVar2.f١٥٠٦٦h = pkgDownloadStatus3;
            dVar2.f١٥٠٧٦r = System.currentTimeMillis();
            dVar2.d(pkgDownloadStatus3);
        }
        t.b bVar = cVar.f١٧٩٣٥b;
        if ((bVar == t.b.LoadMGPackageCore || bVar == t.b.LoadMGPackageGamePackage) && this.f١٥٠٨٠a.remove(dVar2)) {
            this.f١٥٠٨٠a.add(0, dVar2);
        }
        c();
        if (z10 && dVar2.g()) {
            ArrayList arrayList2 = dVar2.f١٥٠٦٨j;
            int size2 = arrayList2.size();
            int i12 = 0;
            while (i12 < size2) {
                Object obj2 = arrayList2.get(i12);
                i12++;
                t.b bVar2 = (t.b) obj2;
                if (bVar2 == t.b.LoadMGPackageGamePackage || bVar2 == t.b.PreloadPackageGamePackage) {
                    long j12 = dVar2.f١٥٠٦٠b;
                    ArrayList arrayList3 = this.f١٥٠٨٠a;
                    int size3 = arrayList3.size();
                    int i13 = 0;
                    loop2: while (i13 < size3) {
                        Object obj3 = arrayList3.get(i13);
                        i13++;
                        d dVar4 = (d) obj3;
                        if (dVar4.f١٥٠٦٠b == j12 && !dVar4.g()) {
                            ArrayList arrayList4 = dVar4.f١٥٠٦٨j;
                            int size4 = arrayList4.size();
                            int i14 = 0;
                            while (i14 < size4) {
                                Object obj4 = arrayList4.get(i14);
                                i14++;
                                t.b bVar3 = (t.b) obj4;
                                if (bVar3 == t.b.LoadMGPackageGamePackage || bVar3 == t.b.PreloadPackageGamePackage) {
                                    dVar = dVar4;
                                    break loop2;
                                }
                            }
                        }
                    }
                    if (dVar != null) {
                        LogUtils.file("SudDownloadManager", "replaceTask:" + dVar2.f١٥٠٦١c);
                        if (dVar2 != dVar) {
                            ArrayList arrayList5 = dVar.f١٥٠٧٠l;
                            int size5 = arrayList5.size();
                            while (i10 < size5) {
                                Object obj5 = arrayList5.get(i10);
                                i10++;
                                dVar2.c((c) obj5);
                            }
                            dVar.f١٥٠٧٠l.clear();
                        }
                        dVar.f();
                    }
                }
            }
        }
        return dVar2.f١٥٠٦١c;
    }

    public final d b(long j10) {
        ArrayList arrayList = this.f١٥٠٨٠a;
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList.get(i10);
            i10++;
            d dVar = (d) obj;
            if (dVar.f١٥٠٦٠b == j10) {
                return dVar;
            }
        }
        return null;
    }

    public final void c() {
        d dVar;
        d dVar2;
        ArrayList arrayList = this.f١٥٠٨٠a;
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList.get(i10);
            i10++;
            if (((d) obj).g()) {
                ArrayList arrayList2 = this.f١٥٠٨٠a;
                int size2 = arrayList2.size();
                int i11 = 0;
                while (i11 < size2) {
                    Object obj2 = arrayList2.get(i11);
                    i11++;
                    d dVar3 = (d) obj2;
                    if (!dVar3.g()) {
                        if (dVar3.h()) {
                            LogUtils.file("SudDownloadTask", "hangUp:" + dVar3.f١٥٠٦٦h + "  :mgId:" + dVar3.f١٥٠٦٠b);
                            SudLogger.d(d.f١٥٠٥٨u, "hangUp:" + dVar3.f١٥٠٦٦h + "  :mgId:" + dVar3.f١٥٠٦٠b);
                            y yVar = dVar3.f١٥٠٧٢n;
                            if (yVar != null) {
                                yVar.f١٥١٣٣a.clear();
                                dVar3.f١٥٠٧٢n.cancel();
                                dVar3.f١٥٠٧٢n = null;
                            }
                            if (dVar3.h()) {
                                dVar3.f١٥٠٦٤f = 4;
                                dVar3.f١٥٠٥٩a.j();
                            } else {
                                PkgDownloadStatus pkgDownloadStatus = PkgDownloadStatus.PKG_DOWNLOAD_WAITING;
                                dVar3.f١٥٠٦٦h = pkgDownloadStatus;
                                dVar3.f١٥٠٧٦r = System.currentTimeMillis();
                                dVar3.d(pkgDownloadStatus);
                            }
                        } else {
                            PkgDownloadStatus pkgDownloadStatus2 = PkgDownloadStatus.PKG_DOWNLOAD_WAITING;
                            dVar3.f١٥٠٦٦h = pkgDownloadStatus2;
                            dVar3.f١٥٠٧٦r = System.currentTimeMillis();
                            dVar3.d(pkgDownloadStatus2);
                        }
                    }
                }
                while (true) {
                    ArrayList arrayList3 = this.f١٥٠٨٠a;
                    int size3 = arrayList3.size();
                    int i12 = 0;
                    int i13 = 0;
                    while (i12 < size3) {
                        Object obj3 = arrayList3.get(i12);
                        i12++;
                        if (((d) obj3).h()) {
                            i13++;
                        }
                    }
                    if (i13 < 3) {
                        ArrayList arrayList4 = this.f١٥٠٨٠a;
                        int size4 = arrayList4.size();
                        int i14 = 0;
                        while (true) {
                            if (i14 < size4) {
                                Object obj4 = arrayList4.get(i14);
                                i14++;
                                dVar2 = (d) obj4;
                                if (dVar2.f١٥٠٦٦h == PkgDownloadStatus.PKG_DOWNLOAD_WAITING && dVar2.g()) {
                                    break;
                                }
                            } else {
                                dVar2 = null;
                                break;
                            }
                        }
                        if (dVar2 != null) {
                            dVar2.e();
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
        }
        while (true) {
            ArrayList arrayList5 = this.f١٥٠٨٠a;
            int size5 = arrayList5.size();
            int i15 = 0;
            int i16 = 0;
            while (i15 < size5) {
                Object obj5 = arrayList5.get(i15);
                i15++;
                if (((d) obj5).h()) {
                    i16++;
                }
            }
            if (i16 < 3) {
                ArrayList arrayList6 = this.f١٥٠٨٠a;
                int size6 = arrayList6.size();
                int i17 = 0;
                while (true) {
                    if (i17 < size6) {
                        Object obj6 = arrayList6.get(i17);
                        i17++;
                        dVar = (d) obj6;
                        if (dVar.f١٥٠٦٦h == PkgDownloadStatus.PKG_DOWNLOAD_WAITING) {
                            break;
                        }
                    } else {
                        dVar = null;
                        break;
                    }
                }
                if (dVar != null) {
                    dVar.e();
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    public final void e(long j10) {
        d dVar;
        ArrayList arrayList = this.f١٥٠٨٠a;
        int size = arrayList.size();
        int i10 = 0;
        while (true) {
            if (i10 < size) {
                Object obj = arrayList.get(i10);
                i10++;
                dVar = (d) obj;
                if (dVar.f١٥٠٦١c == j10) {
                    break;
                }
            } else {
                dVar = null;
                break;
            }
        }
        if (dVar != null) {
            Iterator it = dVar.f١٥٠٧٠l.iterator();
            while (it.hasNext()) {
                c cVar = (c) it.next();
                t.b b10 = cVar.b();
                if (b10 == t.b.LoadMGPackageCore || b10 == t.b.LoadMGPackageGamePackage) {
                    cVar.c(dVar.f١٥٠٧٥q, dVar.f١٥٠٧٤p, PkgDownloadStatus.PKG_DOWNLOAD_CANCELED);
                    it.remove();
                }
            }
            Iterator it2 = dVar.f١٥٠٦٨j.iterator();
            while (it2.hasNext()) {
                t.b bVar = (t.b) it2.next();
                if (bVar == t.b.LoadMGPackageCore || bVar == t.b.LoadMGPackageGamePackage) {
                    it2.remove();
                }
            }
            if (dVar.f١٥٠٧٠l.size() == 0) {
                dVar.f();
            }
            c();
        }
    }
}
