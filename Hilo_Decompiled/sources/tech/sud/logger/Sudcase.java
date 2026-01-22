package tech.sud.logger;

import tech.sud.base.utils.Utils;
import tech.sud.base.utils.UtilsBridge;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public final class Sudcase {
    public final String Suddo;
    public String Sudif;
    public String Sudfor = "util";
    public boolean Sudint = true;
    public boolean Sudnew = true;
    public boolean Sudtry = true;
    public int Sudbyte = -1;
    public final String Sudcase = UtilsBridge.getCurrentProcessName();
    public final UtilsBridge.FileHead Sudchar = new UtilsBridge.FileHead("Log");
    public final boolean Sudelse = true;
    public long Sudgoto = 20971520;
    public int Sudlong = 4;

    public Sudcase() {
        if (UtilsBridge.isSDCardEnableByEnvironment() && Utils.getApp().getExternalFilesDir(null) != null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(Utils.getApp().getExternalFilesDir(null));
            String str = LogUtils.Sudif;
            sb2.append(str);
            sb2.append("log");
            sb2.append(str);
            this.Suddo = sb2.toString();
            return;
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append(Utils.getApp().getFilesDir());
        String str2 = LogUtils.Sudif;
        sb3.append(str2);
        sb3.append("log");
        sb3.append(str2);
        this.Suddo = sb3.toString();
    }

    public final String toString() {
        String replace;
        StringBuilder sb2 = new StringBuilder("process: ");
        String str = this.Sudcase;
        if (str == null) {
            replace = "";
        } else {
            replace = str.replace(":", "_");
        }
        sb2.append(replace);
        String str2 = LogUtils.LINE_SEP;
        sb2.append(str2);
        sb2.append("logSwitch: true");
        sb2.append(str2);
        sb2.append("consoleSwitch: ");
        sb2.append(this.Sudint);
        sb2.append(str2);
        sb2.append("tag: null");
        UtilsBridge.isSpace("");
        sb2.append(str2);
        sb2.append("headSwitch: ");
        sb2.append(this.Sudnew);
        sb2.append(str2);
        sb2.append("fileSwitch: false");
        sb2.append(str2);
        sb2.append("dir: ");
        String str3 = this.Sudif;
        if (str3 == null) {
            str3 = this.Suddo;
        }
        sb2.append(str3);
        sb2.append(str2);
        sb2.append("filePrefix: ");
        sb2.append(this.Sudfor);
        sb2.append(str2);
        sb2.append("borderSwitch: ");
        sb2.append(this.Sudtry);
        sb2.append(str2);
        sb2.append("singleTagSwitch: true");
        sb2.append(str2);
        sb2.append("consoleFilter: ");
        char[] cArr = LogUtils.Suddo;
        sb2.append(cArr[0]);
        sb2.append(str2);
        sb2.append("fileFilter: ");
        sb2.append(cArr[0]);
        sb2.append(str2);
        sb2.append("stackDeep: 1");
        sb2.append(str2);
        sb2.append("stackOffset: 0");
        sb2.append(str2);
        sb2.append("saveDays: ");
        sb2.append(this.Sudbyte);
        sb2.append(str2);
        sb2.append("formatter: ");
        sb2.append(LogUtils.Sudcase);
        sb2.append(str2);
        sb2.append("fileWriter: null");
        sb2.append(str2);
        sb2.append("onConsoleOutputListener: null");
        sb2.append(str2);
        sb2.append("onFileOutputListener: null");
        sb2.append(str2);
        sb2.append("fileExtraHeader: ");
        sb2.append(this.Sudchar.getAppended());
        return sb2.toString();
    }
}
