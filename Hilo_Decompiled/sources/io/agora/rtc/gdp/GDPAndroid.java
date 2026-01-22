package io.agora.rtc.gdp;

import android.app.ActivityManager;
import android.content.Context;
import android.opengl.GLES20;
import android.os.BatteryManager;
import android.os.Build;
import android.util.Log;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class GDPAndroid {
    private static final FileFilter CPU_FILTER = new FileFilter() { // from class: io.agora.rtc.gdp.GDPAndroid.1
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
    private static final List<String> CPU_TEMP_FILE_PATHS = Arrays.asList("/sys/devices/system/cpu/cpu0/cpufreq/cpu_temp", "/sys/devices/system/cpu/cpu0/cpufreq/FakeShmoo_cpu_temp", "/sys/class/thermal/thermal_zone0/temp", "/sys/class/i2c-adapter/i2c-4/4-004c/temperature", "/sys/devices/platform/tegra-i2c.3/i2c-4/4-004c/temperature", "/sys/devices/platform/omap/omap_temp_sensor.0/temperature", "/sys/devices/platform/tegra_tmon/temp1_input", "/sys/kernel/debug/tegra_thermal/temp_tj", "/sys/devices/platform/s5p-tmu/temperature", "/sys/class/thermal/thermal_zone1/temp", "/sys/class/hwmon/hwmon0/device/temp1_input", "/sys/devices/virtual/thermal/thermal_zone1/temp", "/sys/devices/virtual/thermal/thermal_zone0/temp", "/sys/class/thermal/thermal_zone3/temp", "/sys/class/thermal/thermal_zone4/temp", "/sys/class/hwmon/hwmonX/temp1_input", "/sys/devices/platform/s5p-tmu/curr_temp");
    private static final int DEVICEINFO_UNKNOWN = -1;
    private static String TAG = "GDPAndroid";
    private Context mAppContext = null;
    private String mGpuVendor = "unkown";
    private String mGpuRenderer = "unkown";

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

    private void gatherGlInfo() {
        EglCore eglCore = new EglCore(null, 2);
        OffscreenSurface offscreenSurface = new OffscreenSurface(eglCore, 1, 1);
        offscreenSurface.makeCurrent();
        this.mGpuVendor = GLES20.glGetString(7936);
        this.mGpuRenderer = GLES20.glGetString(7937);
        offscreenSurface.release();
        eglCore.release();
    }

    private int getBatteryLevel() {
        return ((BatteryManager) this.mAppContext.getSystemService("batterymanager")).getIntProperty(4);
    }

    private static int getCPUMaxFreqKHz() {
        int i10 = -1;
        int i11 = -1;
        for (int i12 = 0; i12 < getNumberOfCPUCores(); i12++) {
            try {
                File file = new File("/sys/devices/system/cpu/cpu" + i12 + "/cpufreq/cpuinfo_max_freq");
                if (file.exists() && file.canRead()) {
                    byte[] bArr = new byte[128];
                    FileInputStream fileInputStream = new FileInputStream(file);
                    try {
                        fileInputStream.read(bArr);
                        int i13 = 0;
                        while (Character.isDigit(bArr[i13]) && i13 < 128) {
                            i13++;
                        }
                        int parseInt = Integer.parseInt(new String(bArr, 0, i13));
                        if (parseInt > i11) {
                            i11 = parseInt;
                        }
                    } catch (NumberFormatException unused) {
                    } catch (Throwable th) {
                        fileInputStream.close();
                        throw th;
                    }
                    fileInputStream.close();
                }
            } catch (IOException unused2) {
            }
        }
        if (i11 == -1) {
            FileInputStream fileInputStream2 = new FileInputStream("/proc/cpuinfo");
            try {
                int parseFileForValue = parseFileForValue("cpu MHz", fileInputStream2) * 1000;
                if (parseFileForValue > i11) {
                    i11 = parseFileForValue;
                }
            } finally {
                fileInputStream2.close();
            }
        }
        i10 = i11;
        Log.i(TAG, "max freq:" + i10);
        return i10;
    }

    private static int getCoresFromCPUFileList() {
        return new File("/sys/devices/system/cpu/").listFiles(CPU_FILTER).length;
    }

    private static int getCoresFromFileInfo(String str) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(str);
        } catch (IOException unused) {
        } catch (Throwable th) {
            th = th;
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            String readLine = bufferedReader.readLine();
            bufferedReader.close();
            int coresFromFileString = getCoresFromFileString(readLine);
            try {
                fileInputStream.close();
            } catch (IOException unused2) {
            }
            return coresFromFileString;
        } catch (IOException unused3) {
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                    return -1;
                } catch (IOException unused4) {
                    return -1;
                }
            }
            return -1;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (IOException unused5) {
                }
            }
            throw th;
        }
    }

    private static int getCoresFromFileString(String str) {
        if (str != null && str.matches("0-[\\d]+$")) {
            return Integer.valueOf(str.substring(2)).intValue() + 1;
        }
        return -1;
    }

    private static int getNumberOfCPUCores() {
        int i10 = -1;
        try {
            int coresFromFileInfo = getCoresFromFileInfo("/sys/devices/system/cpu/possible");
            if (coresFromFileInfo == -1) {
                coresFromFileInfo = getCoresFromFileInfo("/sys/devices/system/cpu/present");
            }
            if (coresFromFileInfo == -1) {
                i10 = getCoresFromCPUFileList();
            } else {
                i10 = coresFromFileInfo;
            }
        } catch (NullPointerException | SecurityException unused) {
        }
        Log.i(TAG, "cores:" + i10);
        return i10;
    }

    private static long getTotalMemory(Context context) {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
        Log.i(TAG, "total mem:" + memoryInfo.totalMem);
        return memoryInfo.totalMem;
    }

    private boolean isEGL14SupportedHere() {
        return true;
    }

    private boolean isTemperatureValid(double d10) {
        return d10 >= -30.0d && d10 <= 250.0d;
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

    private double readOneLine(File file) {
        String str = "";
        if (!file.exists() || !file.canRead()) {
            return -100000.0d;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            str = bufferedReader.readLine();
            fileInputStream.close();
            inputStreamReader.close();
            bufferedReader.close();
        } catch (IOException e10) {
            e10.printStackTrace();
        }
        try {
            return Double.parseDouble(str);
        } catch (NumberFormatException unused) {
            return -100000.0d;
        }
    }

    public boolean checkBackground() {
        ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
        ActivityManager.getMyMemoryState(runningAppProcessInfo);
        int i10 = runningAppProcessInfo.importance;
        if (i10 != 100 && i10 != 200) {
            return true;
        }
        return false;
    }

    public int getBattery() {
        return getBatteryLevel();
    }

    public int getCpuClock() {
        return getCPUMaxFreqKHz();
    }

    public int getCpuCores() {
        return getNumberOfCPUCores();
    }

    public int getCpuTemperature() {
        double d10;
        int i10 = 0;
        while (true) {
            List<String> list = CPU_TEMP_FILE_PATHS;
            if (i10 < list.size()) {
                String str = list.get(i10);
                d10 = readOneLine(new File(str));
                if (isTemperatureValid(d10)) {
                    Log.i(TAG, "getCpuTemperature valid path:" + str);
                    break;
                }
                d10 /= 1000.0d;
                if (isTemperatureValid(d10)) {
                    Log.i(TAG, "getCpuTemperature valid path:" + str);
                    break;
                }
                i10++;
            } else {
                d10 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                break;
            }
        }
        return (int) (d10 * 1000.0d);
    }

    public String getCpuVendor() {
        return Build.HARDWARE;
    }

    public String getDeviceName() {
        return Build.MODEL;
    }

    public String getGpuRenderer() {
        return this.mGpuRenderer;
    }

    public String getGpuVendor() {
        return this.mGpuVendor;
    }

    public int getOsVersion() {
        return Build.VERSION.SDK_INT;
    }

    public int getRam() {
        return (int) (getTotalMemory(this.mAppContext) / 1024);
    }

    public boolean initGDP(Context context) {
        this.mAppContext = context;
        if (isEGL14SupportedHere()) {
            gatherGlInfo();
            return true;
        }
        return true;
    }
}
