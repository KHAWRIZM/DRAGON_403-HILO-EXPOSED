package j0;

import android.content.Context;
import android.os.Looper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tech.sud.gip.base.ThreadUtils;
import tech.sud.gip.core.GameInfo;
import tech.sud.gip.core.ISudGamePkgPreload;
import tech.sud.gip.core.ISudListenerPreloadMGPkg;
import tech.sud.gip.core.PkgDownloadStatus;
import tech.sud.gip.logger.SudLogger;
import tech.sud.logger.LogUtils;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class v implements ISudGamePkgPreload {

    /* renamed from: c, reason: collision with root package name */
    public static volatile v f١٥١٢٨c;

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f١٥١٢٩a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public final u f١٥١٣٠b = new u(this);

    public v(Context context) {
        Context applicationContext = context.getApplicationContext();
        if (gd.a.c == null) {
            gd.a.c = new gd.a(applicationContext);
        }
    }

    public final void cancelPreloadMGPkgList(List list) {
        Iterator it;
        if (list != null && list.size() != 0) {
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                Long l10 = (Long) it2.next();
                if (l10 != null) {
                    long longValue = l10.longValue();
                    l lVar = (l) this.f١٥١٢٩a.get(l10);
                    if (lVar != null) {
                        long j10 = lVar.f١٥٠٩٩f;
                        long j11 = lVar.f١٥١٠٠g;
                        PkgDownloadStatus pkgDownloadStatus = PkgDownloadStatus.PKG_DOWNLOAD_CANCELED;
                        lVar.f١٥٠٩٩f = j10;
                        lVar.f١٥١٠٠g = j11;
                        ArrayList arrayList = lVar.f١٥٠٩٥b;
                        int size = arrayList.size();
                        int i10 = 0;
                        while (i10 < size) {
                            ((ISudListenerPreloadMGPkg) arrayList.get(i10)).onPreloadStatus(lVar.f١٥٠٩٤a, j10, j11, pkgDownloadStatus);
                            it2 = it2;
                            i10++;
                            size = size;
                            arrayList = arrayList;
                        }
                        it = it2;
                        lVar.f١٥٠٩٦c = false;
                        lVar.f١٥٠٩٥b.clear();
                        u uVar = lVar.f١٥١٠١h;
                        if (uVar != null) {
                            uVar.f١٥١٢٧a.f١٥١٢٩a.remove(Long.valueOf(lVar.f١٥٠٩٤a));
                        }
                    } else {
                        it = it2;
                    }
                    String str = e.f١٥٠٧٩d;
                    e eVar = b.f١٥٠٥٧a;
                    d b10 = eVar.b(longValue);
                    if (b10 != null) {
                        Iterator it3 = b10.f١٥٠٧٠l.iterator();
                        while (it3.hasNext()) {
                            c cVar = (c) it3.next();
                            t.b b11 = cVar.b();
                            if (b11 == t.b.PreloadPackageCore || b11 == t.b.PreloadPackageGamePackage) {
                                cVar.c(b10.f١٥٠٧٥q, b10.f١٥٠٧٤p, PkgDownloadStatus.PKG_DOWNLOAD_CANCELED);
                                it3.remove();
                            }
                        }
                        Iterator it4 = b10.f١٥٠٦٨j.iterator();
                        while (it4.hasNext()) {
                            t.b bVar = (t.b) it4.next();
                            if (bVar == t.b.PreloadPackageCore || bVar == t.b.PreloadPackageGamePackage) {
                                it4.remove();
                            }
                        }
                        if (b10.f١٥٠٧٠l.size() == 0) {
                            b10.f();
                        }
                        eVar.c();
                    }
                    it2 = it;
                }
            }
        }
    }

    public final void pausePreloadMGPkgList(List list) {
        if (list != null && list.size() != 0) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Long l10 = (Long) it.next();
                if (l10 != null) {
                    long longValue = l10.longValue();
                    String str = e.f١٥٠٧٩d;
                    e eVar = b.f١٥٠٥٧a;
                    d b10 = eVar.b(longValue);
                    if (b10 != null && !b10.g()) {
                        LogUtils.file("SudDownloadTask", "pauseDownload mgId:" + b10.f١٥٠٦٠b + "  status:" + b10.f١٥٠٦٦h);
                        SudLogger.d(d.f١٥٠٥٨u, "pauseDownload mgId:" + b10.f١٥٠٦٠b + "  status:" + b10.f١٥٠٦٦h);
                        y yVar = b10.f١٥٠٧٢n;
                        if (yVar != null) {
                            yVar.f١٥١٣٣a.clear();
                            b10.f١٥٠٧٢n.cancel();
                            b10.f١٥٠٧٢n = null;
                        }
                        if (b10.h()) {
                            b10.f١٥٠٦٤f = 3;
                            b10.f١٥٠٥٩a.j();
                        } else {
                            PkgDownloadStatus pkgDownloadStatus = PkgDownloadStatus.PKG_DOWNLOAD_PAUSE;
                            b10.f١٥٠٦٦h = pkgDownloadStatus;
                            b10.f١٥٠٧٦r = System.currentTimeMillis();
                            b10.d(pkgDownloadStatus);
                        }
                        eVar.c();
                    }
                }
            }
        }
    }

    public final void preloadMGPkgList(Context context, List list, ISudListenerPreloadMGPkg iSudListenerPreloadMGPkg) {
        long j10;
        d dVar;
        if (list != null && list.size() != 0) {
            String str = e.f١٥٠٧٩d;
            e eVar = b.f١٥٠٥٧a;
            eVar.getClass();
            if (ThreadUtils.checkUIThread() && list.size() != 0) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    Long l10 = (Long) list.get(size);
                    if (l10 != null) {
                        long longValue = l10.longValue();
                        ArrayList arrayList = eVar.f١٥٠٨٠a;
                        int size2 = arrayList.size();
                        int i10 = 0;
                        while (true) {
                            if (i10 < size2) {
                                Object obj = arrayList.get(i10);
                                i10++;
                                dVar = (d) obj;
                                if (dVar.f١٥٠٦٠b == longValue && !dVar.g()) {
                                    break;
                                }
                            } else {
                                dVar = null;
                                break;
                            }
                        }
                        if (dVar != null && eVar.f١٥٠٨٠a.remove(dVar)) {
                            eVar.f١٥٠٨٠a.add(0, dVar);
                        }
                    }
                }
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Long l11 = (Long) it.next();
                if (l11 != null) {
                    long longValue2 = l11.longValue();
                    l lVar = (l) this.f١٥١٢٩a.get(l11);
                    if (lVar == null) {
                        lVar = new l(longValue2);
                        if (iSudListenerPreloadMGPkg != null && !lVar.f١٥٠٩٥b.contains(iSudListenerPreloadMGPkg)) {
                            lVar.f١٥٠٩٥b.add(iSudListenerPreloadMGPkg);
                        }
                        lVar.f١٥١٠١h = this.f١٥١٣٠b;
                        this.f١٥١٢٩a.put(l11, lVar);
                    } else if (iSudListenerPreloadMGPkg != null && !lVar.f١٥٠٩٥b.contains(iSudListenerPreloadMGPkg)) {
                        lVar.f١٥٠٩٥b.add(iSudListenerPreloadMGPkg);
                    }
                    if (!lVar.f١٥٠٩٦c) {
                        lVar.f١٥٠٩٦c = true;
                        long j11 = lVar.f١٥٠٩٤a;
                        f fVar = new f(lVar);
                        String str2 = e.d.f١٣٧١٨a;
                        if (Looper.myLooper() == Looper.getMainLooper()) {
                            qf.x xVar = e.d.f١٣٧١٩b;
                            if (!xVar.a) {
                                fVar.onFailure(-10103, "Please call initSDK first successfully");
                            } else {
                                GameInfo gameInfo = (GameInfo) xVar.o.get(Long.valueOf(j11));
                                if (gameInfo != null) {
                                    fVar.onSuccess(gameInfo);
                                } else if (!xVar.a) {
                                    fVar.onFailure(-10103, "Please call initSDK first successfully");
                                } else {
                                    GameInfo gameInfo2 = (GameInfo) xVar.o.get(Long.valueOf(j11));
                                    if (gameInfo2 != null) {
                                        j10 = gameInfo2.clientVersion;
                                    } else {
                                        j10 = 0;
                                    }
                                    qf.i.c.execute(new qf.d(xVar, j11, xVar.i, j10, (String) null, fVar));
                                }
                            }
                        } else {
                            fVar.onFailure(-1, "Please call on UI or Main thread");
                        }
                    }
                }
            }
        }
    }

    public final void resumePreloadMGPkgList(List list) {
        if (list != null && list.size() != 0) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Long l10 = (Long) it.next();
                if (l10 != null) {
                    long longValue = l10.longValue();
                    String str = e.f١٥٠٧٩d;
                    e eVar = b.f١٥٠٥٧a;
                    d b10 = eVar.b(longValue);
                    if (b10 != null && b10.f١٥٠٦٦h == PkgDownloadStatus.PKG_DOWNLOAD_PAUSE) {
                        PkgDownloadStatus pkgDownloadStatus = PkgDownloadStatus.PKG_DOWNLOAD_WAITING;
                        b10.f١٥٠٦٦h = pkgDownloadStatus;
                        b10.f١٥٠٧٦r = System.currentTimeMillis();
                        b10.d(pkgDownloadStatus);
                        eVar.c();
                    }
                }
            }
        }
    }
}
