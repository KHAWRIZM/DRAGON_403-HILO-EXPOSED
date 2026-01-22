package fd;

import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import d.h;
import d.k;
import d.p;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import tech.sud.base.utils.SudZipUtils;
import tech.sud.base.utils.Utils;
import tech.sud.logger.LogUtils;
import u.j;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class f implements Runnable {
    public final k1.e a;
    public File b;
    public File c;

    public f(k1.e eVar) {
        this.a = eVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x025e  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x029a  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0320  */
    /* JADX WARN: Removed duplicated region for block: B:139:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0262  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0222  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a() {
        String string;
        long j;
        BufferedReader bufferedReader;
        String str;
        List<File> logFiles;
        File file;
        File a;
        boolean z;
        String str2;
        k kVar;
        d.e eVar;
        BufferedWriter bufferedWriter;
        BufferedWriter bufferedWriter2;
        String str3;
        k kVar2;
        h hVar;
        LogUtils.file("ReportSdkLogTask", "startReport logId：" + this.a.c + " uploadType:" + this.a.e);
        int i = this.a.e;
        String str4 = "";
        if (i == 0) {
            string = d0.a.a("TechSudMGPGlobal.sp").a.getString("key_uploaded_log_id", "");
        } else if (i == 1) {
            string = d0.a.a("TechSudMGPGlobal.sp").a.getString("key_upload_anr_log_id_completed", "");
        } else {
            return;
        }
        if (this.a.c.equals(string)) {
            LogUtils.file("ReportSdkLogTask", "当前logId已上报完成，不再重复上报：" + this.a.c);
            return;
        }
        if (this.a.e == 1) {
            SystemClock.sleep(10000L);
        }
        File filesDir = Utils.getApp().getFilesDir();
        this.b = new File(filesDir, "sud/mgp/rplogtemp");
        this.c = new File(filesDir, "sud/mgp/rplogtempzip");
        File file2 = this.b;
        String absolutePath = file2.getAbsolutePath();
        if (file2.exists()) {
            u.a.c(absolutePath);
        } else {
            u.a.a(absolutePath);
        }
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
        try {
            if (this.a.d) {
                str3 = "logcat -d";
            } else {
                str3 = "logcat -d --pid=" + (Process.myPid() + "");
            }
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(str3).getInputStream()));
            long j3 = 0;
            long j4 = 0;
            while (j3 < 500000) {
                try {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        arrayList.add(readLine);
                        str = str4;
                        j4 += readLine.length();
                        j3++;
                        while (j4 > j2) {
                            try {
                                if (arrayList.size() > 0) {
                                    j4 -= ((String) arrayList.remove(0)).length();
                                }
                            } catch (IOException e) {
                                e = e;
                                e.printStackTrace();
                                LogUtils.file("ReportSdkLogTask", "getCLog error:" + LogUtils.getErrorInfo(e));
                                k0.a.c(bufferedReader);
                                if (arrayList.size() != 0) {
                                }
                                logFiles = LogUtils.getLogFiles();
                                if (logFiles != null) {
                                }
                                file = this.c;
                                String absolutePath2 = file.getAbsolutePath();
                                if (file.exists()) {
                                }
                                File file3 = new File(absolutePath2, j.b(UUID.randomUUID().toString()));
                                SudZipUtils.zipDirectory(this.b, file3);
                                u.a.b(this.b.getAbsolutePath());
                                a = e.a(file3, new File(this.c, this.a.c));
                                file3.delete();
                                if (a != null) {
                                }
                            }
                        }
                        str4 = str;
                    } catch (IOException e2) {
                        e = e2;
                        str = str4;
                    }
                } catch (Throwable th) {
                    th = th;
                    k0.a.c(bufferedReader);
                    throw th;
                }
            }
            str = str4;
            k0.a.c(bufferedReader);
        } catch (IOException e3) {
            e = e3;
            str = "";
            bufferedReader = null;
        } catch (Throwable th2) {
            th = th2;
            bufferedReader = null;
            k0.a.c(bufferedReader);
            throw th;
        }
        if (arrayList.size() != 0) {
            String absolutePath3 = this.b.getAbsolutePath();
            String format = new SimpleDateFormat("yyyy_MM_dd", Locale.US).format(Long.valueOf(System.currentTimeMillis()));
            try {
                bufferedWriter2 = new BufferedWriter(new FileWriter(new File(absolutePath3, "Sud_" + Utils.getApp().getPackageName() + "_" + format + "_console.log")));
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    try {
                        String str5 = (String) arrayList.get(i2);
                        if (i2 > 0) {
                            bufferedWriter2.newLine();
                        }
                        bufferedWriter2.write(str5);
                    } catch (Exception e4) {
                        e = e4;
                        try {
                            e.printStackTrace();
                            LogUtils.file("ReportSdkLogTask", "writeLogToTempPath error:" + LogUtils.getErrorInfo(e));
                            k0.a.c(bufferedWriter2);
                            logFiles = LogUtils.getLogFiles();
                            if (logFiles != null) {
                            }
                            file = this.c;
                            String absolutePath22 = file.getAbsolutePath();
                            if (file.exists()) {
                            }
                            File file32 = new File(absolutePath22, j.b(UUID.randomUUID().toString()));
                            SudZipUtils.zipDirectory(this.b, file32);
                            u.a.b(this.b.getAbsolutePath());
                            a = e.a(file32, new File(this.c, this.a.c));
                            file32.delete();
                            if (a != null) {
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            bufferedWriter = bufferedWriter2;
                            bufferedWriter2 = bufferedWriter;
                            k0.a.c(bufferedWriter2);
                            throw th;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        k0.a.c(bufferedWriter2);
                        throw th;
                    }
                }
                k0.a.c(bufferedWriter2);
            } catch (Exception e5) {
                e = e5;
                bufferedWriter2 = null;
            } catch (Throwable th5) {
                th = th5;
                bufferedWriter = null;
                bufferedWriter2 = bufferedWriter;
                k0.a.c(bufferedWriter2);
                throw th;
            }
        }
        logFiles = LogUtils.getLogFiles();
        if (logFiles != null) {
            for (File file4 : logFiles) {
                if (file4 != null && file4.exists()) {
                    nf.b.a(file4.getAbsolutePath(), new File(this.b, file4.getName()).getAbsolutePath());
                }
            }
        }
        file = this.c;
        String absolutePath222 = file.getAbsolutePath();
        if (file.exists()) {
            u.a.c(absolutePath222);
        } else {
            u.a.a(absolutePath222);
        }
        File file322 = new File(absolutePath222, j.b(UUID.randomUUID().toString()));
        SudZipUtils.zipDirectory(this.b, file322);
        u.a.b(this.b.getAbsolutePath());
        a = e.a(file322, new File(this.c, this.a.c));
        file322.delete();
        if (a != null) {
            k1.e eVar2 = this.a;
            String str6 = eVar2.a;
            long j5 = eVar2.b;
            String str7 = eVar2.c;
            String absolutePath4 = a.getAbsolutePath();
            if (!TextUtils.isEmpty(absolutePath4)) {
                File file5 = new File(absolutePath4);
                if (file5.exists() && file5.length() > 0) {
                    p pVar2 = e.d.e;
                    if (pVar2 != null && (kVar = pVar2.c) != null && (eVar = kVar.d) != null) {
                        str2 = eVar.e;
                    } else {
                        str2 = null;
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        z = e.c(str2, str7, file5, str6, j5 + str);
                        a.delete();
                        LogUtils.file("ReportSdkLogTask", "上传文件 requestId:" + str7 + " 结果：" + z + " 大小：" + a.length() + " 路径：" + absolutePath4);
                        if (z) {
                            int i3 = this.a.e;
                            if (i3 == 0) {
                                d0.a.a("TechSudMGPGlobal.sp").c("key_uploaded_log_id", this.a.c, false);
                            } else if (i3 == 1) {
                                d0.a.a("TechSudMGPGlobal.sp").c("key_upload_anr_log_id_completed", this.a.c, false);
                                d0.a.a("TechSudMGPGlobal.sp").d("key_upload_anr_log_info");
                            }
                        }
                        u.a.b(this.c.getAbsolutePath());
                    }
                }
            }
            z = false;
            a.delete();
            LogUtils.file("ReportSdkLogTask", "上传文件 requestId:" + str7 + " 结果：" + z + " 大小：" + a.length() + " 路径：" + absolutePath4);
            if (z) {
            }
            u.a.b(this.c.getAbsolutePath());
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            k1.e eVar = this.a;
            if (TextUtils.isEmpty(eVar.a) || TextUtils.isEmpty(eVar.c)) {
                return;
            }
            a();
        } catch (Exception e) {
            e.printStackTrace();
            LogUtils.file("ReportSdkLogTask", "ReportConsoleLogTask error:" + LogUtils.getErrorInfo(e));
        }
    }
}
