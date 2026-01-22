package c0;

import j0.o;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;
import tech.sud.base.utils.Utils;
import tech.sud.gip.core.PkgDownloadStatus;
import tech.sud.logger.LogUtils;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final j f٥٦٤١a;

    /* renamed from: b, reason: collision with root package name */
    public String f٥٦٤٢b;

    /* renamed from: c, reason: collision with root package name */
    public String f٥٦٤٣c;

    /* renamed from: d, reason: collision with root package name */
    public String f٥٦٤٤d;

    /* renamed from: e, reason: collision with root package name */
    public j0.m f٥٦٤٥e;

    public f(String str, j jVar) {
        this.f٥٦٤١a = jVar;
    }

    public final void a() {
        File file = new File(Utils.getApp().getFilesDir(), "sud/mgp/ai/modelcache");
        String absolutePath = file.getAbsolutePath();
        if (!file.exists()) {
            u.a.a(absolutePath);
        }
        try {
            j0.m mVar = new j0.m(this.f٥٦٤٢b, absolutePath, new File(absolutePath, u.j.b(this.f٥٦٤٢b)).getName());
            this.f٥٦٤٥e = mVar;
            h hVar = new h(this);
            if (!mVar.f١٥١٠٧e.contains(hVar)) {
                mVar.f١٥١٠٧e.add(hVar);
                PkgDownloadStatus pkgDownloadStatus = PkgDownloadStatus.PKG_DOWNLOAD_WAITING;
            }
            j0.m mVar2 = this.f٥٦٤٥e;
            PkgDownloadStatus pkgDownloadStatus2 = mVar2.f١٥١٠٦d;
            PkgDownloadStatus pkgDownloadStatus3 = PkgDownloadStatus.PKG_DOWNLOAD_STARTED;
            if (pkgDownloadStatus2 != pkgDownloadStatus3 && pkgDownloadStatus2 != PkgDownloadStatus.PKG_DOWNLOAD_DOWNLOADING && pkgDownloadStatus2 != PkgDownloadStatus.PKG_DOWNLOAD_CHECK_FILE) {
                LogUtils.file("DownloadFileTask", "download:" + mVar2.f١٥١٠٦d + "  url:" + mVar2.f١٥١١٤l + "  parentPath:" + mVar2.f١٥١٠٤b + "  fileName:" + mVar2.f١٥١٠٥c);
                mVar2.b(pkgDownloadStatus3);
                j0.h hVar2 = mVar2.f١٥١٠٨f;
                if (hVar2 != null) {
                    hVar2.f١٥٠٨٦b.clear();
                }
                j0.h hVar3 = new j0.h(mVar2);
                mVar2.f١٥١٠٨f = hVar3;
                mVar2.f١٥١٠٣a.i(hVar3);
                o oVar = mVar2.f١٥١٠٩g;
                if (oVar != null) {
                    oVar.f١٥١١٧a.clear();
                    mVar2.f١٥١٠٩g.cancel();
                    mVar2.f١٥١٠٩g = null;
                }
                o oVar2 = new o(mVar2);
                mVar2.f١٥١٠٩g = oVar2;
                oVar2.start();
            }
        } catch (Exception e10) {
            LogUtils.file("AiLoadModelTask", "create download task error:" + LogUtils.getErrorInfo(e10));
            this.f٥٦٤١a.onFailure(-1, "create download task error:" + e10);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 4, insn: 0x0045: MOVE (r3 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]) (LINE:70), block:B:48:0x0045 */
    /* JADX WARN: Type inference failed for: r8v10, types: [java.io.BufferedInputStream, java.io.Closeable, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r8v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r8v4, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r8v6 */
    public final void b(String str) {
        Closeable closeable;
        Exception e10;
        Closeable closeable2;
        ByteArrayOutputStream byteArrayOutputStream;
        if ("XOR".equals(this.f٥٦٤٣c)) {
            File file = new File(str);
            String str2 = u.f.f١٨٢٢٢a;
            ?? exists = file.exists();
            byte[] bArr = null;
            bArr = null;
            r3 = null;
            Closeable closeable3 = null;
            try {
                if (exists != 0) {
                    try {
                        exists = new BufferedInputStream(new FileInputStream(file), anet.channel.bytes.a.MAX_POOL_SIZE);
                    } catch (Exception e11) {
                        e10 = e11;
                        closeable2 = null;
                        byteArrayOutputStream = null;
                    } catch (Throwable th) {
                        th = th;
                        exists = 0;
                    }
                    try {
                        byteArrayOutputStream = new ByteArrayOutputStream();
                        try {
                            byte[] bArr2 = new byte[anet.channel.bytes.a.MAX_POOL_SIZE];
                            while (true) {
                                int read = exists.read(bArr2, 0, anet.channel.bytes.a.MAX_POOL_SIZE);
                                if (read == -1) {
                                    break;
                                } else {
                                    byteArrayOutputStream.write(bArr2, 0, read);
                                }
                            }
                            bArr = byteArrayOutputStream.toByteArray();
                            k0.a.c(exists);
                            k0.a.c(byteArrayOutputStream);
                        } catch (Exception e12) {
                            e10 = e12;
                            closeable2 = exists;
                            LogUtils.file("FileUtils", LogUtils.getErrorInfo(e10));
                            k0.a.c(closeable2);
                            k0.a.c(byteArrayOutputStream);
                            if (bArr == null) {
                            }
                            this.f٥٦٤١a.onFailure(-1, "the file is empty");
                        }
                    } catch (Exception e13) {
                        e10 = e13;
                        byteArrayOutputStream = null;
                        closeable2 = exists;
                    } catch (Throwable th2) {
                        th = th2;
                        k0.a.c(exists);
                        k0.a.c(closeable3);
                        throw th;
                    }
                }
                if (bArr == null && bArr.length != 0) {
                    byte[] bArr3 = new byte[bArr.length];
                    byte[] bytes = this.f٥٦٤٤d.getBytes(StandardCharsets.UTF_8);
                    int i10 = 0;
                    for (int i11 = 0; i11 < bArr.length; i11++) {
                        bArr3[i11] = (byte) (bArr[i11] ^ bytes[i10]);
                        i10 = (i10 + 1) % bytes.length;
                    }
                    this.f٥٦٤١a.onCompleted(bArr3);
                    return;
                }
                this.f٥٦٤١a.onFailure(-1, "the file is empty");
            } catch (Throwable th3) {
                th = th3;
                closeable3 = closeable;
            }
        } else {
            this.f٥٦٤١a.onFailure(-1, "Unsupported algorithm:" + this.f٥٦٤٣c);
        }
    }
}
