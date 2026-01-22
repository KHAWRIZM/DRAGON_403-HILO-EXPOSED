package fd;

import android.os.Process;
import android.text.TextUtils;
import d.h;
import d.k;
import d.p;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.UUID;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import org.json.JSONObject;
import tech.sud.base.utils.Utils;
import tech.sud.logger.LogUtils;
import u.j;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class c implements Runnable {
    public final k1.d a;
    public File b;
    public File c;

    public c(k1.d dVar) {
        this.a = dVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x0321  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x038b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0230  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a() {
        long j;
        BufferedReader bufferedReader;
        k1.b bVar;
        k kVar;
        d.e eVar;
        BufferedWriter bufferedWriter;
        ZipOutputStream zipOutputStream;
        FileInputStream fileInputStream;
        Throwable th;
        String str;
        k kVar2;
        h hVar;
        File filesDir = Utils.getApp().getFilesDir();
        this.b = new File(filesDir, "sud/mgp/clog");
        this.c = new File(filesDir, "sud/mgp/clogtemp");
        ArrayList arrayList = new ArrayList();
        p pVar = e.d.e;
        long j2 = 2097152;
        if (pVar != null && (kVar2 = pVar.c) != null && (hVar = kVar2.l) != null) {
            j = hVar.b;
        } else {
            j = 2097152;
        }
        if (j > 0) {
            j2 = 20971520;
            if (j <= 20971520) {
                j2 = j;
            }
        }
        BufferedReader bufferedReader2 = null;
        ZipOutputStream zipOutputStream2 = null;
        FileInputStream fileInputStream2 = null;
        BufferedWriter bufferedWriter2 = null;
        r9 = null;
        r9 = null;
        String str2 = null;
        try {
            if (this.a.d) {
                str = "logcat -d";
            } else {
                str = "logcat -d --pid=" + (Process.myPid() + "");
            }
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(str).getInputStream()));
            long j3 = 0;
            long j4 = 0;
            while (j3 < 500000) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    arrayList.add(readLine);
                    j4 += readLine.length();
                    j3++;
                    while (j4 > j2 && arrayList.size() > 0) {
                        j4 -= ((String) arrayList.remove(0)).length();
                    }
                } catch (IOException e) {
                    e = e;
                    try {
                        e.printStackTrace();
                        LogUtils.file("ReportCLogTask", "getCLog error:" + LogUtils.getErrorInfo(e));
                        k0.a.c(bufferedReader);
                        if (arrayList.size() != 0) {
                        }
                        bVar = null;
                        if (bVar != null) {
                        }
                        e.b(this.b);
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedReader2 = bufferedReader;
                        bufferedReader = bufferedReader2;
                        k0.a.c(bufferedReader);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    k0.a.c(bufferedReader);
                    throw th;
                }
            }
            k0.a.c(bufferedReader);
        } catch (IOException e2) {
            e = e2;
            bufferedReader = null;
        } catch (Throwable th4) {
            th = th4;
            bufferedReader = bufferedReader2;
            k0.a.c(bufferedReader);
            throw th;
        }
        if (arrayList.size() != 0) {
            String absolutePath = this.c.getAbsolutePath();
            if (this.c.exists()) {
                u.a.c(absolutePath);
            } else {
                u.a.a(absolutePath);
            }
            File file = new File(absolutePath, j.b(UUID.randomUUID().toString()));
            try {
                bufferedWriter = new BufferedWriter(new FileWriter(file));
                for (int i = 0; i < arrayList.size(); i++) {
                    try {
                        String str3 = (String) arrayList.get(i);
                        if (i > 0) {
                            bufferedWriter.newLine();
                        }
                        bufferedWriter.write(str3);
                    } catch (Exception e3) {
                        e = e3;
                        try {
                            e.printStackTrace();
                            LogUtils.file("ReportCLogTask", "writeLogToTempPath error:" + LogUtils.getErrorInfo(e));
                            k0.a.c(bufferedWriter);
                            file = null;
                            if (file != null) {
                            }
                            bVar = null;
                            if (bVar != null) {
                            }
                            e.b(this.b);
                        } catch (Throwable th5) {
                            th = th5;
                            bufferedWriter2 = bufferedWriter;
                            bufferedWriter = bufferedWriter2;
                            k0.a.c(bufferedWriter);
                            throw th;
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        k0.a.c(bufferedWriter);
                        throw th;
                    }
                }
                k0.a.c(bufferedWriter);
            } catch (Exception e4) {
                e = e4;
                bufferedWriter = null;
            } catch (Throwable th7) {
                th = th7;
                bufferedWriter = bufferedWriter2;
                k0.a.c(bufferedWriter);
                throw th;
            }
            if (file != null) {
                File file2 = new File(this.c, j.b(UUID.randomUUID().toString()));
                try {
                    fileInputStream = new FileInputStream(file);
                } catch (IOException e5) {
                    e = e5;
                    fileInputStream = null;
                    zipOutputStream = null;
                } catch (Throwable th8) {
                    th = th8;
                    zipOutputStream = null;
                    th = th;
                    fileInputStream = fileInputStream2;
                    zipOutputStream2 = zipOutputStream;
                    if (zipOutputStream2 != null) {
                    }
                    k0.a.c(zipOutputStream2);
                    k0.a.c(fileInputStream);
                    throw th;
                }
                try {
                    zipOutputStream = new ZipOutputStream(new FileOutputStream(file2));
                    try {
                        zipOutputStream.putNextEntry(new ZipEntry(this.a.c));
                        byte[] bArr = new byte[LockFreeTaskQueueCore.MIN_ADD_SPIN_CAPACITY];
                        while (true) {
                            int read = fileInputStream.read(bArr);
                            if (read > 0) {
                                zipOutputStream.write(bArr, 0, read);
                            } else {
                                try {
                                    break;
                                } catch (Exception e6) {
                                    e6.printStackTrace();
                                    LogUtils.file("ReportCLogTask", "zipFile2 error:" + LogUtils.getErrorInfo(e6));
                                }
                            }
                        }
                        zipOutputStream.closeEntry();
                        k0.a.c(zipOutputStream);
                        k0.a.c(fileInputStream);
                    } catch (IOException e7) {
                        e = e7;
                        try {
                            e.printStackTrace();
                            LogUtils.file("ReportCLogTask", "zipFile1 error:" + LogUtils.getErrorInfo(e));
                            if (zipOutputStream != null) {
                                try {
                                    zipOutputStream.closeEntry();
                                } catch (Exception e8) {
                                    e8.printStackTrace();
                                    LogUtils.file("ReportCLogTask", "zipFile2 error:" + LogUtils.getErrorInfo(e8));
                                }
                            }
                            k0.a.c(zipOutputStream);
                            k0.a.c(fileInputStream);
                            file2 = null;
                            file.delete();
                            if (file2 != null) {
                            }
                            bVar = null;
                            if (bVar != null) {
                            }
                            e.b(this.b);
                        } catch (Throwable th9) {
                            th = th9;
                            fileInputStream2 = fileInputStream;
                            th = th;
                            fileInputStream = fileInputStream2;
                            zipOutputStream2 = zipOutputStream;
                            if (zipOutputStream2 != null) {
                                try {
                                    zipOutputStream2.closeEntry();
                                } catch (Exception e9) {
                                    e9.printStackTrace();
                                    LogUtils.file("ReportCLogTask", "zipFile2 error:" + LogUtils.getErrorInfo(e9));
                                }
                            }
                            k0.a.c(zipOutputStream2);
                            k0.a.c(fileInputStream);
                            throw th;
                        }
                    } catch (Throwable th10) {
                        th = th10;
                        zipOutputStream2 = zipOutputStream;
                        if (zipOutputStream2 != null) {
                        }
                        k0.a.c(zipOutputStream2);
                        k0.a.c(fileInputStream);
                        throw th;
                    }
                } catch (IOException e10) {
                    e = e10;
                    zipOutputStream = null;
                } catch (Throwable th11) {
                    th = th11;
                    if (zipOutputStream2 != null) {
                    }
                    k0.a.c(zipOutputStream2);
                    k0.a.c(fileInputStream);
                    throw th;
                }
                file.delete();
                if (file2 != null) {
                    File a = e.a(file2, new File(this.c, j.b(UUID.randomUUID().toString())));
                    file2.delete();
                    if (a != null) {
                        long length = a.length();
                        File[] listFiles = this.b.listFiles();
                        if (listFiles != null && listFiles.length != 0) {
                            for (File file3 : listFiles) {
                                length += file3.length();
                            }
                            if (length >= 10485760) {
                                ArrayList arrayList2 = new ArrayList(Arrays.asList(listFiles));
                                Collections.sort(arrayList2, new a());
                                while (length >= 10485760 && arrayList2.size() > 0) {
                                    File file4 = (File) arrayList2.get(0);
                                    String name = file4.getName();
                                    long length2 = file4.length();
                                    if (!file4.delete()) {
                                        break;
                                    }
                                    d0.a.a("TechSudMGPCLog.sp").d(name);
                                    arrayList2.remove(0);
                                    length -= length2;
                                }
                            }
                        }
                        File file5 = new File(this.b, this.a.c);
                        u.a.a(this.b.getAbsolutePath());
                        if (!a.renameTo(file5)) {
                            file5.delete();
                            a.delete();
                        } else {
                            bVar = new k1.b();
                            k1.d dVar = this.a;
                            bVar.c = dVar.c;
                            bVar.b = dVar.b;
                            bVar.a = dVar.a;
                            bVar.d = file5.getAbsolutePath();
                            d0.a a2 = d0.a.a("TechSudMGPCLog.sp");
                            String str4 = bVar.c;
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("appId", bVar.a);
                                jSONObject.put("mgId", bVar.b);
                                jSONObject.put("requestId", bVar.c);
                                jSONObject.put("filePath", bVar.d);
                            } catch (Exception e11) {
                                e11.printStackTrace();
                            }
                            a2.c(str4, jSONObject.toString(), false);
                            if (bVar != null) {
                                String str5 = bVar.d;
                                if (!TextUtils.isEmpty(str5)) {
                                    File file6 = new File(str5);
                                    if (file6.exists() && file6.length() > 0) {
                                        p pVar2 = e.d.e;
                                        if (pVar2 != null && (kVar = pVar2.c) != null && (eVar = kVar.d) != null) {
                                            str2 = eVar.e;
                                        }
                                        if (!TextUtils.isEmpty(str2)) {
                                            String str6 = bVar.c;
                                            if (e.c(str2, str6, file6, bVar.a, bVar.b + "")) {
                                                file6.delete();
                                                d0.a.a("TechSudMGPCLog.sp").d(str6);
                                            } else {
                                                e.a = true;
                                            }
                                        }
                                    }
                                }
                            }
                            e.b(this.b);
                        }
                    }
                }
            }
        }
        bVar = null;
        if (bVar != null) {
        }
        e.b(this.b);
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            k1.d dVar = this.a;
            if (TextUtils.isEmpty(dVar.a) || TextUtils.isEmpty(dVar.c)) {
                return;
            }
            a();
        } catch (Exception e) {
            e.printStackTrace();
            LogUtils.file("ReportCLogTask", "ReportConsoleLogTask error:" + LogUtils.getErrorInfo(e));
        }
    }
}
