package tech.sud.logger;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Process;
import android.util.ArrayMap;
import android.util.Log;
import com.taobao.accs.common.Constants;
import i.a;
import i.b;
import i.d;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Formatter;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import tech.sud.base.utils.Utils;
import tech.sud.base.utils.UtilsBridge;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public final class LogUtils {
    public static final int A = 7;
    public static final int D = 3;
    public static final int E = 6;
    public static final int I = 4;
    public static boolean Sudint = false;
    public static SimpleDateFormat Sudnew = null;
    public static final int V = 2;
    public static final int W = 5;
    public static final char[] Suddo = {'V', 'D', 'I', 'W', 'E', 'A'};
    public static final String Sudif = System.getProperty("file.separator");
    public static final String LINE_SEP = System.getProperty("line.separator");
    public static final Sudcase Sudfor = new Sudcase();
    public static final int Sudtry = Process.myPid();
    public static final ExecutorService Sudbyte = Executors.newSingleThreadExecutor();
    public static final ArrayMap Sudcase = new ArrayMap();

    static {
        Suddo();
    }

    public static String Suddo(StackTraceElement stackTraceElement) {
        String fileName = stackTraceElement.getFileName();
        if (fileName != null) {
            return fileName;
        }
        String className = stackTraceElement.getClassName();
        String[] split = className.split("\\.");
        if (split.length > 0) {
            className = split[split.length - 1];
        }
        int indexOf = className.indexOf(36);
        if (indexOf != -1) {
            className = className.substring(0, indexOf);
        }
        return className + ".java";
    }

    public static void Sudif(String str, String str2) {
        File[] listFiles;
        String str3;
        if (Sudfor.Sudbyte > 0 && (listFiles = new File(str).getParentFile().listFiles(new Sudtry())) != null && listFiles.length > 0) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy_MM_dd", Locale.US);
            try {
                long time = simpleDateFormat.parse(str2).getTime() - (r0.Sudbyte * Constants.CLIENT_FLUSH_INTERVAL);
                for (File file : listFiles) {
                    String name = file.getName();
                    name.getClass();
                    Matcher matcher = Pattern.compile("[0-9]{4}_[0-9]{2}_[0-9]{2}").matcher(name);
                    if (matcher.find()) {
                        str3 = matcher.group();
                    } else {
                        str3 = "";
                    }
                    if (simpleDateFormat.parse(str3).getTime() <= time) {
                        Sudbyte.execute(new Sudbyte(file));
                    }
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    public static void a(Object... objArr) {
        Sudfor.getClass();
        UtilsBridge.isSpace("");
        log(7, "", objArr);
    }

    public static void aTag(String str, Object... objArr) {
        log(7, str, objArr);
    }

    public static String buildField(String str, Object obj) {
        return "  " + str + "：" + obj;
    }

    public static void d(Object... objArr) {
        Sudfor.getClass();
        UtilsBridge.isSpace("");
        log(3, "", objArr);
    }

    public static void dTag(String str, Object... objArr) {
        log(3, str, objArr);
    }

    public static void e(Object... objArr) {
        Sudfor.getClass();
        UtilsBridge.isSpace("");
        log(6, "", objArr);
    }

    public static void eTag(String str, Object... objArr) {
        log(6, str, objArr);
    }

    public static void file(Object obj) {
        Sudfor.getClass();
        UtilsBridge.isSpace("");
        log(19, "", obj);
    }

    public static Sudcase getConfig() {
        return Sudfor;
    }

    public static String getErrorInfo(Throwable th) {
        if (th == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        for (Throwable cause = th.getCause(); cause != null; cause = cause.getCause()) {
            cause.printStackTrace(printWriter);
        }
        printWriter.close();
        stringBuffer.append(stringWriter.toString());
        stringBuffer.append("\n" + Log.getStackTraceString(th));
        return stringBuffer.toString();
    }

    public static String getLogDirPath(Context context) {
        File filesDir;
        if (context == null) {
            return null;
        }
        if (UtilsBridge.isSDCardEnableByEnvironment() && context.getExternalFilesDir(null) != null) {
            filesDir = context.getExternalFilesDir(null);
        } else {
            filesDir = context.getFilesDir();
        }
        if (filesDir == null) {
            return null;
        }
        return filesDir.getAbsolutePath() + File.separator + "SudMGPLogs";
    }

    public static List<File> getLogFiles() {
        Sudcase sudcase = Sudfor;
        String str = sudcase.Sudif;
        if (str == null) {
            str = sudcase.Suddo;
        }
        File file = new File(str);
        if (!file.exists()) {
            return new ArrayList();
        }
        File[] listFiles = file.listFiles(new Sudif());
        ArrayList arrayList = new ArrayList();
        Collections.addAll(arrayList, listFiles);
        return arrayList;
    }

    public static void i(Object... objArr) {
        Sudfor.getClass();
        UtilsBridge.isSpace("");
        log(4, "", objArr);
    }

    public static void iTag(String str, Object... objArr) {
        log(4, str, objArr);
    }

    public static void json(Object obj) {
        Sudfor.getClass();
        UtilsBridge.isSpace("");
        log(35, "", obj);
    }

    public static void log(int i, String str, Object... objArr) {
        Sudelse sudelse;
        Sudelse sudelse2;
        String str2;
        int i2;
        int i3;
        String str3;
        Sudelse sudelse3;
        if (!Sudint) {
            Suddo();
        }
        Sudcase sudcase = Sudfor;
        sudcase.getClass();
        int i4 = i & 15;
        int i5 = i & 240;
        if (sudcase.Sudint || i5 == 16) {
            if (i4 >= 2 || i4 >= 2) {
                StackTraceElement[] stackTrace = new Throwable().getStackTrace();
                if (stackTrace != null && stackTrace.length != 0) {
                    if (3 >= stackTrace.length) {
                        String Suddo2 = Suddo(stackTrace[stackTrace.length - 1]);
                        if (UtilsBridge.isSpace(str)) {
                            int indexOf = Suddo2.indexOf(46);
                            if (indexOf != -1) {
                                Suddo2 = Suddo2.substring(0, indexOf);
                            }
                        } else {
                            Suddo2 = str;
                        }
                        sudelse3 = new Sudelse(Suddo2, ": ", null);
                    } else {
                        StackTraceElement stackTraceElement = stackTrace[3];
                        String Suddo3 = Suddo(stackTraceElement);
                        if (UtilsBridge.isSpace(str)) {
                            int indexOf2 = Suddo3.indexOf(46);
                            str3 = indexOf2 == -1 ? Suddo3 : Suddo3.substring(0, indexOf2);
                        } else {
                            str3 = str;
                        }
                        if (sudcase.Sudnew) {
                            String formatter = new Formatter().format("%s, %s.%s(%s:%d)", Thread.currentThread().getName(), stackTraceElement.getClassName(), stackTraceElement.getMethodName(), Suddo3, Integer.valueOf(stackTraceElement.getLineNumber())).toString();
                            sudelse3 = new Sudelse(str3, " [" + formatter + "]: ", new String[]{formatter});
                        } else {
                            sudelse = new Sudelse(str3, ": ", null);
                        }
                    }
                    sudelse = sudelse3;
                } else {
                    sudelse = new Sudelse(str, ": ", null);
                }
                String str4 = "null";
                if (objArr != null) {
                    if (objArr.length == 1) {
                        Object obj = objArr[0];
                        if (obj != null) {
                            str4 = i5 == 32 ? Sudchar.Suddo(32, obj) : i5 == 48 ? Sudchar.Suddo(48, obj) : Suddo(obj);
                        }
                    } else {
                        StringBuilder sb2 = new StringBuilder();
                        int length = objArr.length;
                        for (int i6 = 0; i6 < length; i6++) {
                            Object obj2 = objArr[i6];
                            sb2.append("args[");
                            sb2.append(i6);
                            sb2.append("] = ");
                            sb2.append(Suddo(obj2));
                            sb2.append(LINE_SEP);
                        }
                        str4 = sb2.toString();
                    }
                }
                String str5 = str4.length() == 0 ? "log nothing" : str4;
                Sudcase sudcase2 = Sudfor;
                if (!sudcase2.Sudint || i5 == 16 || i4 < 2) {
                    sudelse2 = sudelse;
                    str2 = str5;
                } else {
                    String str6 = sudelse.Suddo;
                    String[] strArr = sudelse.Sudif;
                    StringBuilder sb3 = new StringBuilder();
                    if (sudcase2.Sudtry) {
                        sb3.append(" ");
                        String str7 = LINE_SEP;
                        sb3.append(str7);
                        sb3.append("┌────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
                        sb3.append(str7);
                        if (strArr != null) {
                            for (String str8 : strArr) {
                                sb3.append("│ ");
                                sb3.append(str8);
                                sb3.append(LINE_SEP);
                            }
                            sb3.append("├┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄");
                            sb3.append(LINE_SEP);
                        }
                        for (String str9 : str5.split(LINE_SEP)) {
                            sb3.append("│ ");
                            sb3.append(str9);
                            sb3.append(LINE_SEP);
                        }
                        sb3.append("└────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
                    } else {
                        if (strArr != null) {
                            sb3.append(" ");
                            sb3.append(LINE_SEP);
                            for (String str10 : strArr) {
                                sb3.append(str10);
                                sb3.append(LINE_SEP);
                            }
                        }
                        sb3.append(str5);
                    }
                    String sb4 = sb3.toString();
                    int length2 = sb4.length();
                    boolean z = Sudfor.Sudtry;
                    if (z) {
                        i2 = 1100;
                        i3 = (length2 - 113) / 1100;
                    } else {
                        i2 = 1100;
                        i3 = length2 / 1100;
                    }
                    if (i3 <= 0) {
                        sudelse2 = sudelse;
                        str2 = str5;
                        Log.println(i4, str6, sb4);
                    } else if (z) {
                        Log.println(i4, str6, sb4.substring(0, i2) + LINE_SEP + "└────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
                        int i7 = 1;
                        int i8 = 1100;
                        while (i7 < i3) {
                            StringBuilder sb5 = new StringBuilder(" ");
                            String str11 = LINE_SEP;
                            sb5.append(str11);
                            sb5.append("┌────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
                            sb5.append(str11);
                            sb5.append("│ ");
                            Sudelse sudelse4 = sudelse;
                            int i9 = i8 + 1100;
                            sb5.append(sb4.substring(i8, i9));
                            sb5.append(str11);
                            sb5.append("└────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
                            Log.println(i4, str6, sb5.toString());
                            Sudfor.getClass();
                            i7++;
                            str5 = str5;
                            i8 = i9;
                            sudelse = sudelse4;
                        }
                        sudelse2 = sudelse;
                        str2 = str5;
                        if (i8 != length2 - 113) {
                            StringBuilder sb6 = new StringBuilder(" ");
                            String str12 = LINE_SEP;
                            sb6.append(str12);
                            sb6.append("┌────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
                            sb6.append(str12);
                            sb6.append("│ ");
                            sb6.append(sb4.substring(i8, length2));
                            Log.println(i4, str6, sb6.toString());
                            Sudfor.getClass();
                        }
                    } else {
                        sudelse2 = sudelse;
                        str2 = str5;
                        Log.println(i4, str6, sb4.substring(0, i2));
                        int i10 = 1100;
                        int i11 = 1;
                        while (i11 < i3) {
                            StringBuilder sb7 = new StringBuilder(" ");
                            sb7.append(LINE_SEP);
                            int i12 = i10 + 1100;
                            sb7.append(sb4.substring(i10, i12));
                            Log.println(i4, str6, sb7.toString());
                            Sudfor.getClass();
                            i11++;
                            i10 = i12;
                        }
                        if (i10 != length2) {
                            Log.println(i4, str6, " " + LINE_SEP + sb4.substring(i10, length2));
                            Sudfor.getClass();
                        }
                    }
                }
                Sudfor.getClass();
                if (i5 != 16 || i4 < 2) {
                    return;
                }
                Thread currentThread = Thread.currentThread();
                Sudbyte.execute(new Suddo(i4, sudelse2, str2, currentThread.getId(), currentThread.getName()));
            }
        }
    }

    public static void v(Object... objArr) {
        Sudfor.getClass();
        UtilsBridge.isSpace("");
        log(2, "", objArr);
    }

    public static void vTag(String str, Object... objArr) {
        log(2, str, objArr);
    }

    public static void w(Object... objArr) {
        Sudfor.getClass();
        UtilsBridge.isSpace("");
        log(5, "", objArr);
    }

    public static void wTag(String str, Object... objArr) {
        log(5, str, objArr);
    }

    public static void xml(String str) {
        Sudfor.getClass();
        UtilsBridge.isSpace("");
        log(51, "", str);
    }

    public static void file(int i, Object obj) {
        Sudfor.getClass();
        UtilsBridge.isSpace("");
        log(i | 16, "", obj);
    }

    public static void json(int i, Object obj) {
        Sudfor.getClass();
        UtilsBridge.isSpace("");
        log(i | 32, "", obj);
    }

    public static void xml(int i, String str) {
        Sudfor.getClass();
        UtilsBridge.isSpace("");
        log(i | 48, "", str);
    }

    public static void file(String str, Object obj) {
        log(19, str, obj);
    }

    public static void json(String str, Object obj) {
        log(35, str, obj);
    }

    public static void xml(String str, String str2) {
        log(51, str, str2);
    }

    public static void file(int i, String str, Object obj) {
        log(i | 16, str, obj);
    }

    public static void json(int i, String str, Object obj) {
        log(i | 32, str, obj);
    }

    public static void xml(int i, String str, String str2) {
        log(i | 48, str, str2);
    }

    public static String Suddo(Object obj) {
        String obj2;
        if (obj == null) {
            return "null";
        }
        ArrayMap arrayMap = Sudcase;
        if (!arrayMap.isEmpty()) {
            Class<?> cls = obj.getClass();
            if (cls.isAnonymousClass() || cls.isSynthetic()) {
                Type[] genericInterfaces = cls.getGenericInterfaces();
                if (genericInterfaces.length == 1) {
                    Type type = genericInterfaces[0];
                    while (type instanceof ParameterizedType) {
                        type = ((ParameterizedType) type).getRawType();
                    }
                    obj2 = type.toString();
                } else {
                    Type genericSuperclass = cls.getGenericSuperclass();
                    while (genericSuperclass instanceof ParameterizedType) {
                        genericSuperclass = ((ParameterizedType) genericSuperclass).getRawType();
                    }
                    obj2 = genericSuperclass.toString();
                }
                if (obj2.startsWith("class ")) {
                    obj2 = obj2.substring(6);
                } else if (obj2.startsWith("interface ")) {
                    obj2 = obj2.substring(10);
                }
                try {
                    cls = Class.forName(obj2);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
            if (arrayMap.get(cls) != null) {
                throw new ClassCastException();
            }
        }
        return Sudchar.Suddo(-1, obj);
    }

    public static boolean Suddo(String str, String str2) {
        File file = new File(str);
        if (file.exists()) {
            return file.isFile();
        }
        boolean z = false;
        if (!UtilsBridge.createOrExistsDir(file.getParentFile())) {
            return false;
        }
        try {
            Suddo(str);
            Sudif(str, str2);
            z = file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (z) {
            Sudcase sudcase = Sudfor;
            sudcase.Sudchar.addFirst("Date of Log", str2);
            Suddo(str, sudcase.Sudchar.toString(), true);
        }
        return z;
    }

    public static void Suddo(String str) {
        File[] listFiles;
        int i = Sudfor.Sudlong;
        if (i >= 1 && (listFiles = new File(str).getParentFile().listFiles(new Sudfor())) != null && listFiles.length > 0 && listFiles.length >= i) {
            ArrayList arrayList = new ArrayList();
            for (File file : listFiles) {
                arrayList.add(file);
            }
            Collections.sort(arrayList, new Sudint());
            int size = arrayList.size() - i;
            for (int i2 = 0; i2 < size; i2++) {
                Sudbyte.execute(new Sudnew((File) arrayList.get(i2)));
            }
        }
    }

    public static void Suddo(String str, String str2, boolean z) {
        byte[] doFinal;
        if (Sudfor.Sudelse) {
            if (z) {
                HashMap hashMap = d.a;
                KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
                keyGenerator.init(256);
                byte[] encoded = keyGenerator.generateKey().getEncoded();
                b bVar = new b();
                bVar.a = encoded;
                d.a.put(str, bVar);
                int length = encoded.length;
                byte[] bArr = new byte[length];
                for (int i = 0; i < length; i++) {
                    byte b = encoded[i];
                    bArr[i] = b;
                    bArr[i] = (byte) (b ^ 2);
                }
                String a = a.a(bArr);
                SharedPreferences.Editor edit = h.a.a().a.edit();
                edit.putString("key_aes_key_prefix_" + str, a);
                edit.commit();
                PublicKey generatePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(a.b("MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA84624QluMte2OQf27WRmq4q3nVjVCQX0o+2lZm3ktKHG2PZf5AjxjZiCuNjqfWSo1gJDsyJZC4FSubhhjDSXrPcJRKS6lXt5DKuhABWWqgkUhcJX3/loigHG4Abyi/+b0NkKPaqTbJ64j9jylyXvO6fj1TMmOw+5zJ/6rV0FMVHosyTUX0zTCt6T5OooGiSt+wCvxlj1IT6vqJ4k8EyM6zYhPzQMK7xZniUyYfdl4OeS9NMT1wW62scuEQ5y2VVeHxFSeauGw9CaQLMIjZl2yj87N8gEtsRj5+hQWmG2kEQOZMv9jRwLGpsH0JoBdJwiThf0fYdB3T1jtgL5eyUnewIDAQAB")));
                if (encoded.length == 0) {
                    doFinal = null;
                } else {
                    Cipher cipher = Cipher.getInstance("RSA/None/PKCS1Padding");
                    cipher.init(1, generatePublic);
                    doFinal = cipher.doFinal(encoded);
                }
                String str3 = a.a(doFinal) + LINE_SEP;
                Sudfor.getClass();
                UtilsBridge.writeFileFromString(str, str3, true);
            }
            str2 = d.a(str, str2) + LINE_SEP;
        }
        Sudfor.getClass();
        UtilsBridge.writeFileFromString(str, str2, true);
    }

    public static void Suddo() {
        Sudcase config;
        Application app = Utils.getApp();
        if (app == null || (config = getConfig()) == null) {
            return;
        }
        config.Sudint = false;
        config.Sudbyte = 5;
        config.Sudnew = false;
        config.Sudtry = false;
        String logDirPath = getLogDirPath(app);
        if (UtilsBridge.isSpace(logDirPath)) {
            config.Sudif = null;
        } else {
            String str = Sudif;
            if (!logDirPath.endsWith(str)) {
                logDirPath = logDirPath + str;
            }
            config.Sudif = logDirPath;
        }
        if (UtilsBridge.isSpace("SudMGP")) {
            config.Sudfor = "util";
        } else {
            config.Sudfor = "SudMGP";
        }
        config.Sudgoto = 20971520L;
        config.Sudlong = 4;
        Sudint = true;
    }
}
