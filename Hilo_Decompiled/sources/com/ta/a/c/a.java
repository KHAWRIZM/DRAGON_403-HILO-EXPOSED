package com.ta.a.c;

import android.text.TextUtils;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class a {
    public static void b(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                File file = new File(str);
                if (!file.exists()) {
                    f.b("FileUtils", "mkdirs path", str, "created", Boolean.valueOf(file.mkdirs()));
                } else {
                    f.b("FileUtils", "path exists", str);
                }
            }
        } catch (Exception e) {
            f.b("FileUtils", e, new Object[0]);
        }
    }

    public static String c(String str) {
        InputStreamReader inputStreamReader;
        InputStreamReader inputStreamReader2 = null;
        try {
            try {
                inputStreamReader = new InputStreamReader(new FileInputStream(str));
            } catch (Exception e) {
                e = e;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            char[] cArr = new char[100];
            StringBuilder sb2 = new StringBuilder("");
            while (true) {
                int read = inputStreamReader.read(cArr);
                if (read == -1) {
                    break;
                }
                sb2.append(cArr, 0, read);
            }
            String sb3 = sb2.toString();
            try {
                inputStreamReader.close();
            } catch (Exception e2) {
                f.b("FileUtils", e2, new Object[0]);
            }
            return sb3;
        } catch (Exception e3) {
            e = e3;
            inputStreamReader2 = inputStreamReader;
            f.b("FileUtils", e, new Object[0]);
            if (inputStreamReader2 != null) {
                try {
                    inputStreamReader2.close();
                } catch (Exception e4) {
                    f.b("FileUtils", e4, new Object[0]);
                }
            }
            return "";
        } catch (Throwable th2) {
            th = th2;
            inputStreamReader2 = inputStreamReader;
            if (inputStreamReader2 != null) {
                try {
                    inputStreamReader2.close();
                } catch (Exception e5) {
                    f.b("FileUtils", e5, new Object[0]);
                }
            }
            throw th;
        }
    }

    public static boolean b(String str, String str2) {
        FileWriter fileWriter;
        BufferedWriter bufferedWriter;
        BufferedWriter bufferedWriter2 = null;
        try {
            try {
                fileWriter = new FileWriter(new File(str));
                try {
                    bufferedWriter = new BufferedWriter(fileWriter);
                } catch (Exception e) {
                    e = e;
                }
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e2) {
            e = e2;
            fileWriter = null;
        } catch (Throwable th2) {
            th = th2;
            fileWriter = null;
        }
        try {
            bufferedWriter.write(str2);
            bufferedWriter.flush();
            try {
                bufferedWriter.close();
            } catch (Exception e3) {
                f.b("FileUtils", e3, new Object[0]);
            }
            try {
                fileWriter.close();
                return true;
            } catch (Exception e4) {
                f.b("FileUtils", e4, new Object[0]);
                return true;
            }
        } catch (Exception e5) {
            e = e5;
            bufferedWriter2 = bufferedWriter;
            f.b("FileUtils", e, new Object[0]);
            if (bufferedWriter2 != null) {
                try {
                    bufferedWriter2.close();
                } catch (Exception e6) {
                    f.b("FileUtils", e6, new Object[0]);
                }
            }
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (Exception e7) {
                    f.b("FileUtils", e7, new Object[0]);
                }
            }
            return false;
        } catch (Throwable th3) {
            th = th3;
            bufferedWriter2 = bufferedWriter;
            if (bufferedWriter2 != null) {
                try {
                    bufferedWriter2.close();
                } catch (Exception e8) {
                    f.b("FileUtils", e8, new Object[0]);
                }
            }
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                    throw th;
                } catch (Exception e9) {
                    f.b("FileUtils", e9, new Object[0]);
                    throw th;
                }
            }
            throw th;
        }
    }
}
