package af;

import android.content.Context;
import android.content.res.AssetManager;
import android.text.TextUtils;
import com.tencent.imsdk.BaseConstants;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import org.apache.commons.sudcompress.archivers.ArchiveEntry;
import org.apache.commons.sudcompress.archivers.zip.ZipArchiveInputStream;
import tech.sud.gip.base.ThreadUtils;
import tech.sud.gip.logger.SudLogger;
import tech.sud.logger.LogUtils;
import u.f;
import u.j;
import wf.e;
import ye.g;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class d extends g {
    public static final String h = "SudGIP ".concat(d.class.getSimpleName());
    public final String e;
    public final String f;
    public final AssetManager g;

    public d(Context context, lf.b bVar) {
        super(bVar);
        this.e = new File(context.getFilesDir(), "sud/mgp/utapp").getAbsolutePath();
        this.f = new File(context.getFilesDir(), "sud/mgp/utapp/embed").getAbsolutePath();
        this.g = context.getAssets();
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x020f A[Catch: IOException -> 0x020b, TryCatch #11 {IOException -> 0x020b, blocks: (B:96:0x0207, B:87:0x020f, B:89:0x0214), top: B:95:0x0207 }] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0214 A[Catch: IOException -> 0x020b, TRY_LEAVE, TryCatch #11 {IOException -> 0x020b, blocks: (B:96:0x0207, B:87:0x020f, B:89:0x0214), top: B:95:0x0207 }] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0207 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static d.d l(String str, String str2) {
        ZipArchiveInputStream zipArchiveInputStream;
        FileOutputStream fileOutputStream;
        IOException e;
        ZipArchiveInputStream zipArchiveInputStream2;
        FileInputStream fileInputStream;
        Throwable th;
        File[] listFiles;
        String str3 = h;
        StringBuilder sb2 = new StringBuilder("unzip path = ");
        sb2.append(str);
        sb2.append(" filesize = ");
        File file = new File(str);
        String str4 = f.a;
        sb2.append(file.length());
        SudLogger.d(str3, sb2.toString());
        String str5 = str2 + "/StreamingAssets";
        u.a.b(str5);
        String str6 = str2 + "/StreamingAssetsCache";
        u.a.b(str6);
        d.d dVar = new d.d();
        LogUtils.file("FileUtils", "unzipFileAtPath zipFilePath:" + str + "  location:" + str6);
        File file2 = new File(str6);
        FileInputStream fileInputStream2 = null;
        FileOutputStream fileOutputStream2 = null;
        r7 = null;
        r7 = null;
        String str7 = null;
        try {
            if (!file2.exists()) {
                file2.mkdirs();
            }
            fileInputStream = new FileInputStream(str);
            try {
                zipArchiveInputStream2 = new ZipArchiveInputStream(fileInputStream, "UTF-8");
                fileOutputStream = null;
                while (true) {
                    try {
                        ArchiveEntry nextEntry = zipArchiveInputStream2.getNextEntry();
                        if (nextEntry == null) {
                            break;
                        }
                        String name = nextEntry.getName();
                        if (!name.contains("__MACOSX")) {
                            if (nextEntry.isDirectory()) {
                                new File(str6, name).mkdirs();
                            } else {
                                int indexOf = name.indexOf(47);
                                int lastIndexOf = name.lastIndexOf(47);
                                if (indexOf > 0 && indexOf == lastIndexOf) {
                                    File file3 = new File(str6, name.substring(0, indexOf + 1));
                                    if (!file3.exists()) {
                                        file3.mkdirs();
                                    }
                                }
                                File file4 = new File(str6, name);
                                byte[] bArr = new byte[5120];
                                FileOutputStream fileOutputStream3 = new FileOutputStream(file4);
                                while (true) {
                                    try {
                                        int read = zipArchiveInputStream2.read(bArr);
                                        if (read == -1) {
                                            break;
                                        }
                                        fileOutputStream3.write(bArr, 0, read);
                                    } catch (IOException e2) {
                                        e = e2;
                                        fileOutputStream = fileOutputStream3;
                                        try {
                                            LogUtils.file("FileUtils", "unzipFileAtPath :" + LogUtils.getErrorInfo(e));
                                            e.printStackTrace();
                                            dVar.a = -1;
                                            dVar.b = e.toString();
                                            if (fileOutputStream != null) {
                                                try {
                                                    fileOutputStream.close();
                                                } catch (IOException e3) {
                                                    e3.printStackTrace();
                                                }
                                            }
                                            if (zipArchiveInputStream2 != null) {
                                                zipArchiveInputStream2.close();
                                            }
                                            if (fileInputStream != null) {
                                                fileInputStream.close();
                                            }
                                            if (dVar.a == 0) {
                                            }
                                            u.a.b(str6);
                                            return dVar;
                                        } catch (Throwable th2) {
                                            fileInputStream2 = fileInputStream;
                                            zipArchiveInputStream = zipArchiveInputStream2;
                                            th = th2;
                                            fileInputStream = fileInputStream2;
                                            fileOutputStream2 = fileOutputStream;
                                            ZipArchiveInputStream zipArchiveInputStream3 = zipArchiveInputStream;
                                            th = th;
                                            zipArchiveInputStream2 = zipArchiveInputStream3;
                                            if (fileOutputStream2 != null) {
                                                try {
                                                    fileOutputStream2.close();
                                                } catch (IOException e4) {
                                                    e4.printStackTrace();
                                                    throw th;
                                                }
                                            }
                                            if (zipArchiveInputStream2 != null) {
                                                zipArchiveInputStream2.close();
                                            }
                                            if (fileInputStream != null) {
                                                fileInputStream.close();
                                            }
                                            throw th;
                                        }
                                    } catch (Throwable th3) {
                                        th = th3;
                                        fileOutputStream2 = fileOutputStream3;
                                        if (fileOutputStream2 != null) {
                                        }
                                        if (zipArchiveInputStream2 != null) {
                                        }
                                        if (fileInputStream != null) {
                                        }
                                        throw th;
                                    }
                                }
                                fileOutputStream3.flush();
                                fileOutputStream = fileOutputStream3;
                            }
                        }
                    } catch (IOException e5) {
                        e = e5;
                    } catch (Throwable th4) {
                        th = th4;
                        fileOutputStream2 = fileOutputStream;
                    }
                }
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e6) {
                        e6.printStackTrace();
                    }
                }
                zipArchiveInputStream2.close();
                fileInputStream.close();
            } catch (IOException e7) {
                zipArchiveInputStream2 = null;
                e = e7;
                fileOutputStream = null;
            } catch (Throwable th5) {
                th = th5;
                zipArchiveInputStream2 = null;
            }
        } catch (IOException e8) {
            e = e8;
            zipArchiveInputStream2 = null;
            fileInputStream = null;
            fileOutputStream = null;
        } catch (Throwable th6) {
            th = th6;
            zipArchiveInputStream = null;
            fileOutputStream = null;
            fileInputStream = fileInputStream2;
            fileOutputStream2 = fileOutputStream;
            ZipArchiveInputStream zipArchiveInputStream32 = zipArchiveInputStream;
            th = th;
            zipArchiveInputStream2 = zipArchiveInputStream32;
            if (fileOutputStream2 != null) {
            }
            if (zipArchiveInputStream2 != null) {
            }
            if (fileInputStream != null) {
            }
            throw th;
        }
        if (dVar.a == 0) {
            File file5 = new File(str6);
            if (file5.exists() && (listFiles = file5.listFiles()) != null) {
                String str8 = null;
                for (File file6 : listFiles) {
                    String path = file6.getPath();
                    if (!path.contains("__MACOSX")) {
                        if (str8 != null) {
                            break;
                        }
                        if (!file6.isDirectory()) {
                            break;
                        }
                        str8 = path;
                    }
                }
                str7 = str8;
            }
            if (str7 != null) {
                File file7 = new File(str7);
                File file8 = new File(str5);
                LogUtils.file("FileUtils", "unpackZip rootDirectory != null  renameResult:" + file7.renameTo(file8) + "  oldDir:" + file7 + "  newDir:" + file8);
            } else {
                File file9 = new File(str6);
                File file10 = new File(str5);
                LogUtils.file("FileUtils", "unpackZip renameResult:" + file9.renameTo(file10) + "  oldDir:" + file9 + "  newDir:" + file10);
            }
        }
        u.a.b(str6);
        return dVar;
    }

    public static /* synthetic */ void m(boolean z, re.b bVar, String str) {
        if (z) {
            bVar.a(true, str + "/StreamingAssets", false);
            return;
        }
        bVar.a(false, "", false);
    }

    @Override // ye.g
    public final Object b(re.d dVar, File file) {
        LogUtils.file("UTRealSudGamePackageManager", "processDownloadPackage");
        a aVar = new a();
        String absolutePath = file.getAbsolutePath();
        aVar.a = l(absolutePath, absolutePath.substring(0, absolutePath.lastIndexOf(47)));
        LogUtils.file("UTRealSudGamePackageManager", "processDownloadPackage unzipResult:" + aVar.a + "  path:" + absolutePath);
        if (aVar.a.a == 0) {
            dVar.f = System.currentTimeMillis();
            this.b.f(dVar);
            e(dVar.a);
        }
        aVar.b = c(absolutePath);
        return aVar;
    }

    @Override // ye.g
    public final String c(String str) {
        return str.substring(0, str.lastIndexOf(47)) + "/StreamingAssets";
    }

    @Override // ye.g
    public final void g(final long j, final String str, final re.b bVar) {
        w0.a.a.execute(new Runnable() { // from class: af.b
            @Override // java.lang.Runnable
            public final void run() {
                d.this.n(j, str, bVar);
            }
        });
    }

    @Override // ye.g
    public final void h(String str, Object obj, e eVar, re.a aVar) {
        if (obj instanceof a) {
            a aVar2 = (a) obj;
            d.d dVar = aVar2.a;
            String str2 = aVar2.b;
            if (dVar.a == 0) {
                LogUtils.file("UTRealSudGamePackageManager", "onDownloadSuccess path=" + str);
                SudLogger.d(h, "onDownloadSuccess path=" + str);
                aVar.b(str2, eVar);
                return;
            }
            LogUtils.file("UTRealSudGamePackageManager", "unzip error");
            SudLogger.d(h, "unzip error");
            aVar.e(BaseConstants.ERR_SVR_SSO_DISCONNECT, "unzip error:" + dVar.b, eVar);
            return;
        }
        LogUtils.file("UTRealSudGamePackageManager", "extendInfo empty");
        SudLogger.d(h, "extendInfo empty");
        aVar.e(-1, "extendInfo empty", eVar);
    }

    @Override // ye.g
    public final String j(String str) {
        return k(j.b(str));
    }

    @Override // ye.g
    public final String k(String str) {
        return this.e + "/" + str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:112:0x01e6, code lost:
    
        if (r4 != false) goto L١١٩;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0057, code lost:
    
        if (r3 == false) goto L١٦;
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0201  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0156 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:78:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x014c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:89:0x0142 -> B:46:0x0145). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void n(long j, String str, final re.b bVar) {
        boolean z;
        mf.a aVar;
        mf.c b;
        String str2;
        boolean exists;
        String str3;
        FileOutputStream fileOutputStream;
        Exception e;
        InputStream inputStream;
        String substring;
        String substring2;
        boolean exists2;
        final boolean z2 = true;
        final String absolutePath = new File(this.f, String.valueOf(j)).getAbsolutePath();
        File file = new File(absolutePath);
        if (!file.exists()) {
            file.mkdirs();
        }
        mf.a aVar2 = (mf.a) mf.b.a.a.get(Long.valueOf(j));
        String str4 = absolutePath + "/StreamingAssets";
        if (aVar2 != null && !aVar2.a) {
            String str5 = f.a;
            if (str4 == null) {
                exists2 = false;
            } else {
                exists2 = new File(str4).exists();
            }
        }
        try {
            int lastIndexOf = str.lastIndexOf("/");
            if (-1 == lastIndexOf) {
                substring2 = str;
                substring = "";
            } else {
                int i = lastIndexOf + 1;
                substring = str.substring(0, i);
                substring2 = str.substring(i);
            }
            for (String str6 : this.g.list(substring)) {
                if (str6 != null && str6.equals(substring2)) {
                    z = true;
                    break;
                }
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        z = false;
        if (z) {
            int lastIndexOf2 = str.lastIndexOf(".");
            if (-1 == lastIndexOf2) {
                str3 = absolutePath + File.separator + String.valueOf(j);
            } else {
                str3 = absolutePath + File.separator + String.valueOf(j) + str.substring(lastIndexOf2);
            }
            String str7 = f.a;
            LogUtils.file("FileUtils", "deleteFile result:" + new File(str3).delete());
            InputStream inputStream2 = null;
            try {
                try {
                    inputStream = this.g.open(str);
                    try {
                        byte[] bArr = new byte[LockFreeTaskQueueCore.MIN_ADD_SPIN_CAPACITY];
                        File file2 = new File(str3);
                        file2.createNewFile();
                        fileOutputStream = new FileOutputStream(file2);
                        while (true) {
                            try {
                                int read = inputStream.read(bArr);
                                if (read > 0) {
                                    fileOutputStream.write(bArr, 0, read);
                                } else {
                                    try {
                                        break;
                                    } catch (Exception e3) {
                                        e3.printStackTrace();
                                    }
                                }
                            } catch (Exception e4) {
                                e = e4;
                                try {
                                    e.printStackTrace();
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (Exception e5) {
                                            e5.printStackTrace();
                                        }
                                    }
                                    if (fileOutputStream != null) {
                                        fileOutputStream.close();
                                    }
                                    str = str3;
                                    String a = j.a(new File(str));
                                    mf.d dVar = mf.b.a;
                                    aVar = (mf.a) dVar.a.get(Long.valueOf(j));
                                    if (aVar != null) {
                                    }
                                    b = nf.a.b(this.b.a.getString("ut_embbed_" + String.valueOf(j), ""));
                                    str2 = absolutePath + "/StreamingAssets";
                                    if (b != null) {
                                        String str8 = f.a;
                                        if (str2 != null) {
                                        }
                                    }
                                    if (l(str, absolutePath).a != 0) {
                                    }
                                    ThreadUtils.postUITask(new Runnable() { // from class: af.c
                                        @Override // java.lang.Runnable
                                        public final void run() {
                                            d.m(z2, bVar, absolutePath);
                                        }
                                    });
                                } catch (Throwable th) {
                                    th = th;
                                    inputStream2 = inputStream;
                                    inputStream = inputStream2;
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (Exception e6) {
                                            e6.printStackTrace();
                                        }
                                    }
                                    if (fileOutputStream == null) {
                                        try {
                                            fileOutputStream.close();
                                            throw th;
                                        } catch (Exception e7) {
                                            e7.printStackTrace();
                                            throw th;
                                        }
                                    }
                                    throw th;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                if (inputStream != null) {
                                }
                                if (fileOutputStream == null) {
                                }
                            }
                        }
                        inputStream.close();
                        fileOutputStream.close();
                    } catch (Exception e8) {
                        fileOutputStream = null;
                        e = e8;
                    } catch (Throwable th3) {
                        th = th3;
                        fileOutputStream = null;
                        inputStream2 = inputStream;
                        inputStream = inputStream2;
                        if (inputStream != null) {
                        }
                        if (fileOutputStream == null) {
                        }
                    }
                } catch (Exception e9) {
                    e9.printStackTrace();
                }
            } catch (Exception e10) {
                fileOutputStream = null;
                e = e10;
                inputStream = null;
            } catch (Throwable th4) {
                th = th4;
                fileOutputStream = null;
                inputStream = inputStream2;
                if (inputStream != null) {
                }
                if (fileOutputStream == null) {
                }
            }
            str = str3;
        }
        String a2 = j.a(new File(str));
        mf.d dVar2 = mf.b.a;
        aVar = (mf.a) dVar2.a.get(Long.valueOf(j));
        if (aVar != null) {
            mf.a aVar3 = new mf.a();
            aVar3.a = false;
            aVar3.b = z;
            dVar2.a.put(Long.valueOf(j), aVar3);
        } else {
            aVar.a = false;
            aVar.b = z;
        }
        b = nf.a.b(this.b.a.getString("ut_embbed_" + String.valueOf(j), ""));
        str2 = absolutePath + "/StreamingAssets";
        if (b != null && !TextUtils.isEmpty(b.b) && !TextUtils.isEmpty(a2) && a2.equals(b.b)) {
            String str82 = f.a;
            if (str2 != null) {
                exists = false;
            } else {
                exists = new File(str2).exists();
            }
        }
        if (l(str, absolutePath).a != 0) {
            if (b == null) {
                b = new mf.c();
            }
            b.a = j;
            b.b = a2;
            this.b.e(b);
        } else {
            z2 = false;
        }
        ThreadUtils.postUITask(new Runnable() { // from class: af.c
            @Override // java.lang.Runnable
            public final void run() {
                d.m(z2, bVar, absolutePath);
            }
        });
    }
}
