package com.oudi.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.util.Log;
import dalvik.system.DexFile;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class ClassInterfaceUtils {
    private static final String EXTRACTED_NAME_EXT = ".classes";
    private static final String EXTRACTED_SUFFIX = ".zip";
    private static final String KEY_DEX_NUMBER = "dex.number";
    private static final String PREFS_FILE = "multidex.version";
    private static final String SECONDARY_FOLDER_NAME = "code_cache" + File.separator + "secondary-dexes";
    private static final String TAG = "ClassInterfaceUtils";
    private static final int VM_WITH_MULTIDEX_VERSION_MAJOR = 2;
    private static final int VM_WITH_MULTIDEX_VERSION_MINOR = 1;

    /* JADX WARN: Can't wrap try/catch for region: R(6:4|(6:5|6|8|(1:10)(1:28)|11|(4:14|(3:16|17|18)(1:20)|19|12))|21|22|24|25) */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static List<String> getFileNameByPackageName(Context context, String str) {
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = getSourcePaths(context).iterator();
        while (true) {
            if (it.hasNext()) {
                String next = it.next();
                DexFile dexFile = null;
                try {
                    if (next.endsWith(EXTRACTED_SUFFIX)) {
                        dexFile = DexFile.loadDex(next, next + ".tmp", 0);
                    } else {
                        dexFile = new DexFile(next);
                    }
                    Enumeration<String> entries = dexFile.entries();
                    while (entries.hasMoreElements()) {
                        String nextElement = entries.nextElement();
                        if (nextElement.contains(str)) {
                            arrayList.add(nextElement);
                        }
                    }
                } finally {
                    try {
                        dexFile.close();
                    } catch (Throwable th) {
                        if (dexFile != null) {
                            try {
                                dexFile.close();
                            } catch (Throwable unused) {
                            }
                        }
                    }
                }
                dexFile.close();
            } else {
                Log.d(TAG, "Filter " + arrayList.size() + " classes by packageName <" + str + ">");
                return arrayList;
            }
        }
    }

    private static SharedPreferences getMultiDexPreferences(Context context) {
        return context.getSharedPreferences(PREFS_FILE, 4);
    }

    public static <T> List<T> getObjectsWithInterface(Context context, Class<T> cls, String str) {
        ArrayList arrayList = new ArrayList();
        try {
            for (String str2 : getFileNameByPackageName(context, str)) {
                Class<?> cls2 = Class.forName(str2);
                if (cls.isAssignableFrom(cls2) && !cls.equals(cls2) && !cls2.isInterface()) {
                    arrayList.add(Class.forName(str2).getConstructor(null).newInstance(null));
                }
            }
            if (arrayList.size() == 0) {
                Log.e(TAG, "No files were found, check your configuration please!");
            }
        } catch (Exception e10) {
            e10.getStackTrace();
            Log.e(TAG, "getObjectsWithInterface error, " + e10.getMessage());
        }
        return arrayList;
    }

    public static List<String> getSourcePaths(Context context) {
        ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 0);
        File file = new File(applicationInfo.sourceDir);
        ArrayList arrayList = new ArrayList();
        arrayList.add(applicationInfo.sourceDir);
        String str = file.getName() + EXTRACTED_NAME_EXT;
        if (!isVMMultidexCapable()) {
            int i10 = getMultiDexPreferences(context).getInt(KEY_DEX_NUMBER, 1);
            File file2 = new File(applicationInfo.dataDir, SECONDARY_FOLDER_NAME);
            for (int i11 = 2; i11 <= i10; i11++) {
                File file3 = new File(file2, str + i11 + EXTRACTED_SUFFIX);
                if (file3.isFile()) {
                    arrayList.add(file3.getAbsolutePath());
                } else {
                    throw new IOException("Missing extracted secondary dex file '" + file3.getPath() + "'");
                }
            }
        }
        return arrayList;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x004e, code lost:
    
        if (r3 < 1) goto L٢٢;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x001a, code lost:
    
        if (java.lang.Integer.valueOf(java.lang.System.getProperty("ro.build.version.sdk")).intValue() >= 21) goto L٢٠;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0062  */
    /* JADX WARN: Type inference failed for: r1v7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean isVMMultidexCapable() {
        String str;
        String str2;
        boolean isYunOS;
        boolean z10 = false;
        try {
            isYunOS = isYunOS();
            try {
            } catch (NumberFormatException | Exception unused) {
                str = isYunOS;
            }
        } catch (Exception unused2) {
            str = null;
        }
        if (isYunOS != 0) {
            String str3 = "'YunOS'";
            str = str3;
            isYunOS = str3;
        } else {
            String str4 = "'Android'";
            String property = System.getProperty("java.vm.version");
            str = str4;
            if (property != null) {
                Matcher matcher = Pattern.compile("(\\d+)\\.(\\d+)(\\.\\d+)?").matcher(property);
                str = str4;
                if (matcher.matches()) {
                    int parseInt = Integer.parseInt(matcher.group(1));
                    int parseInt2 = Integer.parseInt(matcher.group(2));
                    str = str4;
                    str = str4;
                    isYunOS = str4;
                    isYunOS = str4;
                    if (parseInt <= 2) {
                        if (parseInt == 2) {
                        }
                    }
                }
            }
            StringBuilder sb = new StringBuilder("VM with name ");
            sb.append(str);
            if (!z10) {
                str2 = " has multidex support";
            } else {
                str2 = " does not have multidex support";
            }
            sb.append(str2);
            Log.i(TAG, sb.toString());
            return z10;
        }
        z10 = true;
        str = isYunOS;
        StringBuilder sb2 = new StringBuilder("VM with name ");
        sb2.append(str);
        if (!z10) {
        }
        sb2.append(str2);
        Log.i(TAG, sb2.toString());
        return z10;
    }

    private static boolean isYunOS() {
        try {
            String property = System.getProperty("ro.yunos.version");
            String property2 = System.getProperty("java.vm.name");
            if (property2 == null || !property2.toLowerCase().contains("lemur")) {
                if (property == null) {
                    return false;
                }
                if (property.trim().length() <= 0) {
                    return false;
                }
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private static List<String> tryLoadInstantRunDexFile(ApplicationInfo applicationInfo) {
        ArrayList arrayList = new ArrayList();
        String[] strArr = applicationInfo.splitSourceDirs;
        if (strArr != null) {
            arrayList.addAll(Arrays.asList(strArr));
            Log.d(TAG, "Found InstantRun support");
        } else {
            try {
                File file = new File((String) Class.forName("com.android.tools.fd.runtime.Paths").getMethod("getDexFileDirectory", String.class).invoke(null, applicationInfo.packageName));
                if (file.exists() && file.isDirectory()) {
                    for (File file2 : file.listFiles()) {
                        if (file2 != null && file2.exists() && file2.isFile() && file2.getName().endsWith(".dex")) {
                            arrayList.add(file2.getAbsolutePath());
                        }
                    }
                    Log.d(TAG, "Found InstantRun support");
                }
            } catch (Exception e10) {
                Log.e(TAG, "InstantRun support error, " + e10.getMessage());
            }
        }
        return arrayList;
    }

    public static <T> List<T> getObjectsWithInterface(Context context, Class<T> cls, List<String> list) {
        ArrayList arrayList = new ArrayList();
        try {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                for (String str : getFileNameByPackageName(context, it.next())) {
                    Class<?> cls2 = Class.forName(str);
                    if (cls.isAssignableFrom(cls2) && !cls.equals(cls2) && !cls2.isInterface()) {
                        arrayList.add(Class.forName(str).getConstructor(null).newInstance(null));
                    }
                }
            }
            if (arrayList.size() == 0) {
                Log.e(TAG, "No files were found, check your configuration please!");
            }
        } catch (Exception e10) {
            e10.getStackTrace();
            Log.e(TAG, "getObjectsWithInterface error, " + e10.getMessage());
        }
        return arrayList;
    }
}
