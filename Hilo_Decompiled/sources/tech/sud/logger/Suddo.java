package tech.sud.logger;

import android.util.Log;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import org.android.agoo.message.MessageService;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public final class Suddo implements Runnable {
    public final /* synthetic */ int Suddo;
    public final /* synthetic */ String Sudfor;
    public final /* synthetic */ Sudelse Sudif;
    public final /* synthetic */ long Sudint;
    public final /* synthetic */ String Sudnew;

    public Suddo(int i, Sudelse sudelse, String str, long j, String str2) {
        this.Suddo = i;
        this.Sudif = sudelse;
        this.Sudfor = str;
        this.Sudint = j;
        this.Sudnew = str2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x00dc, code lost:
    
        if (r2 > r1.Sudgoto) goto L٣٣;
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() {
        String replace;
        String str;
        int i;
        String str2;
        String str3;
        String str4;
        int i2 = this.Suddo;
        String str5 = this.Sudif.Suddo;
        String str6 = this.Sudif.Sudfor + this.Sudfor;
        long j = this.Sudint;
        String str7 = this.Sudnew;
        int i3 = LogUtils.V;
        Date date = new Date();
        if (LogUtils.Sudnew == null) {
            LogUtils.Sudnew = new SimpleDateFormat("yyyy_MM_dd HH:mm:ss.SSS ", Locale.US);
        }
        String format = LogUtils.Sudnew.format(date);
        String substring = format.substring(0, 10);
        if (LogUtils.Sudnew == null) {
            LogUtils.Sudnew = new SimpleDateFormat("yyyy_MM_dd HH:mm:ss.SSS ", Locale.US);
        }
        String substring2 = LogUtils.Sudnew.format(date).substring(0, 10);
        StringBuilder sb2 = new StringBuilder();
        Sudcase sudcase = LogUtils.Sudfor;
        String str8 = sudcase.Sudif;
        if (str8 == null) {
            str8 = sudcase.Suddo;
        }
        sb2.append(str8);
        sb2.append(sudcase.Sudfor);
        sb2.append("_");
        sb2.append(substring2);
        sb2.append("_");
        String str9 = sudcase.Sudcase;
        String str10 = "";
        if (str9 == null) {
            replace = "";
        } else {
            replace = str9.replace(":", "_");
        }
        sb2.append(replace);
        String sb3 = sb2.toString();
        String str11 = sb3 + ".txt";
        int i4 = 0;
        while (true) {
            str = null;
            if (str11 != null && !"".equals(str11)) {
                File file = new File(str11);
                if (file.exists()) {
                    if (file.isFile()) {
                        Sudcase sudcase2 = LogUtils.Sudfor;
                        str2 = str5;
                        str3 = str6;
                        if (sudcase2.Sudgoto > 1024) {
                            long length = file.length();
                            i = i2;
                        } else {
                            i = i2;
                            break;
                        }
                    }
                } else {
                    i = i2;
                    str2 = str5;
                    str3 = str6;
                    break;
                }
            }
            i = i2;
            str2 = str5;
            str3 = str6;
            int i5 = i4 + 1;
            StringBuilder sb4 = new StringBuilder();
            sb4.append(sb3);
            sb4.append("_");
            sb4.append(i5);
            LogUtils.Sudfor.getClass();
            sb4.append(".txt");
            str11 = sb4.toString();
            if (i5 > 100) {
                str11 = null;
                break;
            }
            i4 = i5;
            i2 = i;
            str5 = str2;
            str6 = str3;
        }
        try {
            if (!LogUtils.Suddo(str11, substring)) {
                Log.e("LogUtils", "create " + str11 + " failed!");
                return;
            }
            TimeZone timeZone = TimeZone.getDefault();
            if (timeZone != null) {
                int rawOffset = timeZone.getRawOffset();
                int i6 = rawOffset / 3600000;
                int abs = Math.abs((rawOffset / 60000) % 60);
                if (i6 >= 0) {
                    str4 = "+";
                } else {
                    str4 = "-";
                }
                StringBuilder sb5 = new StringBuilder("UTC");
                sb5.append(str4);
                sb5.append(Math.abs(i6));
                sb5.append(":");
                if (abs < 10) {
                    str10 = MessageService.MSG_DB_READY_REPORT;
                }
                sb5.append(str10);
                sb5.append(abs);
                sb5.append(" ");
                str = sb5.toString();
            }
            String str12 = str;
            String str13 = "(" + LogUtils.Sudtry + ":" + j + ":" + str7 + ")";
            try {
                LogUtils.Suddo(str11, format.substring(11) + str12 + LogUtils.Suddo[i - 2] + "/" + str2 + str13 + str3 + LogUtils.LINE_SEP, false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
