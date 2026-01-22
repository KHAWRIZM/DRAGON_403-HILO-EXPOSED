package io.agora.rtc.internal;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import io.agora.rtc.utils.CameraUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class DeviceUtils {
    public static final int DEVICE_INFO_UNKNOWN = -1;
    private static final String TAG = "DeviceUtils";
    private static final String[] H264_HW_BLACKLIST = {"SAMSUNG-SGH-I337", "Nexus 7", "Nexus 4", "P6-C00", "HM 2A", "XT105", "XT109", "XT1060"};
    private static final FileFilter CPU_FILTER = new FileFilter() { // from class: io.agora.rtc.internal.DeviceUtils.1
        @Override // java.io.FileFilter
        public boolean accept(File file) {
            String name = file.getName();
            if (!name.startsWith("cpu")) {
                return false;
            }
            for (int i10 = 3; i10 < name.length(); i10++) {
                if (!Character.isDigit(name.charAt(i10))) {
                    return false;
                }
            }
            return true;
        }
    };

    public static String buildDeviceId() {
        String str;
        String str2 = Build.MANUFACTURER;
        if (!TextUtils.isEmpty(str2)) {
            str2 = str2.replace('/', '_');
        }
        String str3 = Build.MODEL;
        if (!TextUtils.isEmpty(str3)) {
            str3 = str3.replace('/', '_');
        }
        String str4 = Build.PRODUCT;
        if (!TextUtils.isEmpty(str4)) {
            str4 = str4.replace('/', '_');
        }
        String str5 = Build.DEVICE;
        if (!TextUtils.isEmpty(str5)) {
            str = str5.replace('/', '_');
        } else {
            str = str5;
        }
        String str6 = str2 + "/" + str3 + "/" + str4 + "/" + str + "/" + Build.VERSION.SDK_INT + "/" + System.getProperty("os.version");
        if (str6 != null) {
            str6 = str6.toLowerCase();
        }
        Matcher matcher = Pattern.compile(".*[A-Z][A-M][0-9]$").matcher(Build.ID);
        if (Build.BRAND.toLowerCase().equals("samsung") && str5.toLowerCase().startsWith("cs02")) {
            matcher.find();
        }
        return str6;
    }

    private static int extractValue(byte[] bArr, int i10) {
        byte b10;
        while (i10 < bArr.length && (b10 = bArr[i10]) != 10) {
            if (Character.isDigit(b10)) {
                int i11 = i10 + 1;
                while (i11 < bArr.length && Character.isDigit(bArr[i11])) {
                    i11++;
                }
                return Integer.parseInt(new String(bArr, 0, i10, i11 - i10));
            }
            i10++;
        }
        return -1;
    }

    public static int getCPUMaxFreqKHz() {
        int i10 = -1;
        for (int i11 = 0; i11 < getNumberOfCPUCores(); i11++) {
            try {
                File file = new File("/sys/devices/system/cpu/cpu" + i11 + "/cpufreq/cpuinfo_max_freq");
                if (file.exists()) {
                    byte[] bArr = new byte[128];
                    FileInputStream fileInputStream = new FileInputStream(file);
                    try {
                        fileInputStream.read(bArr);
                        int i12 = 0;
                        while (Character.isDigit(bArr[i12]) && i12 < 128) {
                            i12++;
                        }
                        int parseInt = Integer.parseInt(new String(bArr, 0, i12));
                        if (parseInt > i10) {
                            i10 = parseInt;
                        }
                    } catch (NumberFormatException unused) {
                    } catch (Throwable th) {
                        fileInputStream.close();
                        throw th;
                    }
                    fileInputStream.close();
                }
            } catch (IOException unused2) {
                return -1;
            }
        }
        if (i10 == -1) {
            FileInputStream fileInputStream2 = new FileInputStream("/proc/cpuinfo");
            try {
                int parseFileForValue = parseFileForValue("cpu MHz", fileInputStream2) * 1000;
                if (parseFileForValue > i10) {
                    i10 = parseFileForValue;
                }
            } finally {
                fileInputStream2.close();
            }
        }
        return i10;
    }

    private static int getCoresFromCPUFileList() {
        return new File("/sys/devices/system/cpu").listFiles(CPU_FILTER).length;
    }

    private static int getCoresFromFileInfo(String str) {
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(str);
            try {
                String readLine = new BufferedReader(new InputStreamReader(fileInputStream2)).readLine();
                fileInputStream2.close();
                int coresFromFileString = getCoresFromFileString(readLine);
                try {
                    fileInputStream2.close();
                } catch (IOException e10) {
                    Logging.e(TAG, "close file stream", e10);
                }
                return coresFromFileString;
            } catch (IOException unused) {
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                        return -1;
                    } catch (IOException e11) {
                        Logging.e(TAG, "close file stream", e11);
                        return -1;
                    }
                }
                return -1;
            } catch (Throwable th) {
                th = th;
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e12) {
                        Logging.e(TAG, "close file stream", e12);
                    }
                }
                throw th;
            }
        } catch (IOException unused2) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static int getCoresFromFileString(String str) {
        if (str != null && str.matches("0-[\\d]+$")) {
            return Integer.valueOf(str.substring(2)).intValue() + 1;
        }
        return -1;
    }

    public static String getCpuABI() {
        return Build.CPU_ABI;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0060 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String getCpuName() {
        Throwable th;
        FileReader fileReader;
        Reader reader = null;
        try {
            try {
                try {
                    fileReader = new FileReader("/proc/cpuinfo");
                    try {
                        String[] split = new BufferedReader(fileReader).readLine().split(":\\s+", 2);
                        for (int i10 = 0; i10 < split.length; i10++) {
                        }
                        fileReader.close();
                        String str = split[1];
                        try {
                            fileReader.close();
                        } catch (IOException e10) {
                            Logging.e(TAG, "failed to close proc file", e10);
                        }
                        return str;
                    } catch (FileNotFoundException e11) {
                        e = e11;
                        Logging.e(TAG, "getCpuName failed, no /proc/cpuinfo found in system", e);
                        if (fileReader != null) {
                            fileReader.close();
                        }
                        return null;
                    } catch (IOException e12) {
                        e = e12;
                        Logging.e(TAG, "getCpuName failed,", e);
                        if (fileReader != null) {
                            fileReader.close();
                        }
                        return null;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (0 != 0) {
                        try {
                            reader.close();
                        } catch (IOException e13) {
                            Logging.e(TAG, "failed to close proc file", e13);
                        }
                    }
                    throw th;
                }
            } catch (FileNotFoundException e14) {
                e = e14;
                fileReader = null;
            } catch (IOException e15) {
                e = e15;
                fileReader = null;
            } catch (Throwable th3) {
                th = th3;
                if (0 != 0) {
                }
                throw th;
            }
        } catch (IOException e16) {
            Logging.e(TAG, "failed to close proc file", e16);
        }
    }

    public static String getDeviceInfo() {
        String str = Build.MANUFACTURER;
        if (!TextUtils.isEmpty(str)) {
            str = str.replace('/', '_');
        }
        String str2 = Build.MODEL;
        if (!TextUtils.isEmpty(str2)) {
            str2 = str2.replace('/', '_');
        }
        String str3 = Build.HARDWARE;
        if (!TextUtils.isEmpty(str3)) {
            str3 = str3.replace('/', '_');
        }
        String str4 = str + "/" + str2 + "/" + str3;
        if (str4 != null) {
            return str4.toLowerCase();
        }
        return str4;
    }

    public static int getNumberOfCPUCores() {
        try {
            int coresFromFileInfo = getCoresFromFileInfo("/sys/devices/system/cpu/possible");
            if (coresFromFileInfo == -1) {
                coresFromFileInfo = getCoresFromFileInfo("/sys/devices/system/cpu/present");
            }
            if (coresFromFileInfo == -1) {
                return getCoresFromCPUFileList();
            }
            return coresFromFileInfo;
        } catch (NullPointerException | SecurityException unused) {
            return -1;
        }
    }

    public static int getNumberOfCameras(Context context) {
        return CameraUtils.getNumberOfCameras(context);
    }

    public static int getRecommendedEncoderType() {
        List asList = Arrays.asList(H264_HW_BLACKLIST);
        String str = Build.MODEL;
        if (asList.contains(str)) {
            Logging.w(TAG, "Model: " + str + " has black listed H.264 encoder.");
            return 1;
        }
        return 0;
    }

    public static String getSystemInfo() {
        return "Android/" + Build.VERSION.RELEASE;
    }

    private static int parseFileForValue(String str, FileInputStream fileInputStream) {
        byte[] bArr = new byte[1024];
        try {
            int read = fileInputStream.read(bArr);
            int i10 = 0;
            while (i10 < read) {
                byte b10 = bArr[i10];
                if (b10 == 10 || i10 == 0) {
                    if (b10 == 10) {
                        i10++;
                    }
                    for (int i11 = i10; i11 < read; i11++) {
                        int i12 = i11 - i10;
                        if (bArr[i11] != str.charAt(i12)) {
                            break;
                        }
                        if (i12 == str.length() - 1) {
                            return extractValue(bArr, i11);
                        }
                    }
                }
                i10++;
            }
            return -1;
        } catch (IOException | NumberFormatException unused) {
            return -1;
        }
    }

    public static int selectFrontCamera(Context context) {
        return CameraUtils.selectFrontCamera(context);
    }
}
