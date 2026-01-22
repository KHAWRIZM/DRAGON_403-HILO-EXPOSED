package com.alibaba.sdk.android.tbrest.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import com.facebook.internal.security.CertificateUtil;
import com.ta.utdid2.device.UTDevice;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Locale;
import java.util.Random;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class DeviceUtils {
    private static final String NETWORK_CLASS_2_G = "2G";
    private static final String NETWORK_CLASS_3_G = "3G";
    private static final String NETWORK_CLASS_4_G = "4G";
    private static final String NETWORK_CLASS_5_G = "5G";
    private static final String NETWORK_CLASS_UNKNOWN = "Unknown";
    public static final String NETWORK_CLASS_WIFI = "Wi-Fi";
    private static String carrier;
    private static String cpuName;
    private static final String[] ARRAY_OF_STRING = {"Unknown", "Unknown"};
    private static String imsi = null;
    private static String imei = null;

    public static byte[] IntGetBytes(int i10) {
        return new byte[]{(byte) ((i10 >> 24) % 256), (byte) ((i10 >> 16) % 256), (byte) ((i10 >> 8) % 256), (byte) (i10 % 256)};
    }

    public static String getCarrier(Context context) {
        try {
            String str = carrier;
            if (str != null) {
                return str;
            }
            String networkOperatorName = ((TelephonyManager) context.getSystemService("phone")).getNetworkOperatorName();
            carrier = networkOperatorName;
            return networkOperatorName;
        } catch (Exception unused) {
            return null;
        }
    }

    public static String getCountry() {
        try {
            return Locale.getDefault().getCountry();
        } catch (Exception e10) {
            LogUtil.e("get country error ", e10);
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x005e, code lost:
    
        if (r0 != null) goto L١٩;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String getCpuName() {
        FileReader fileReader;
        Throwable th;
        BufferedReader bufferedReader;
        String readLine;
        String str = cpuName;
        if (str != null) {
            return str;
        }
        try {
            try {
                fileReader = new FileReader("/proc/cpuinfo");
                try {
                    bufferedReader = new BufferedReader(fileReader);
                } catch (IOException unused) {
                    bufferedReader = null;
                } catch (Throwable th2) {
                    th = th2;
                    bufferedReader = null;
                }
            } catch (Exception unused2) {
            }
        } catch (IOException unused3) {
            bufferedReader = null;
            fileReader = null;
        } catch (Throwable th3) {
            fileReader = null;
            th = th3;
            bufferedReader = null;
        }
        do {
            try {
                readLine = bufferedReader.readLine();
            } catch (IOException unused4) {
                if (fileReader != null) {
                    fileReader.close();
                }
            } catch (Throwable th4) {
                th = th4;
                if (fileReader != null) {
                    try {
                        fileReader.close();
                    } catch (Exception unused5) {
                        throw th;
                    }
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                throw th;
            }
            if (readLine == null) {
                fileReader.close();
                bufferedReader.close();
                return null;
            }
        } while (!readLine.contains("Hardware"));
        String str2 = readLine.split(CertificateUtil.DELIMITER)[1];
        cpuName = str2;
        try {
            fileReader.close();
            bufferedReader.close();
        } catch (Exception unused6) {
        }
        return str2;
    }

    public static String getImei(Context context) {
        String str = imei;
        if (str != null) {
            return str;
        }
        String uniqueID = getUniqueID();
        imei = uniqueID;
        return uniqueID;
    }

    public static String getImsi(Context context) {
        String str = imsi;
        if (str != null) {
            return str;
        }
        StringUtils.isEmpty(str);
        String uniqueID = getUniqueID();
        imsi = uniqueID;
        return uniqueID;
    }

    public static String getLanguage() {
        try {
            return Locale.getDefault().getLanguage();
        } catch (Exception e10) {
            LogUtil.e("get country error ", e10);
            return null;
        }
    }

    private static String getNetworkClass(int i10) {
        if (i10 != 20) {
            switch (i10) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                    return NETWORK_CLASS_2_G;
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                    return NETWORK_CLASS_3_G;
                case 13:
                    return NETWORK_CLASS_4_G;
                default:
                    return "Unknown";
            }
        }
        return NETWORK_CLASS_5_G;
    }

    @SuppressLint({"WrongConstant"})
    public static String[] getNetworkType(Context context) {
        if (context == null) {
            return ARRAY_OF_STRING;
        }
        if (context.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", context.getPackageName()) != 0) {
            return ARRAY_OF_STRING;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            return ARRAY_OF_STRING;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return ARRAY_OF_STRING;
        }
        if (activeNetworkInfo.isConnected()) {
            if (activeNetworkInfo.getType() == 1) {
                String[] strArr = ARRAY_OF_STRING;
                strArr[0] = NETWORK_CLASS_WIFI;
                return strArr;
            }
            if (activeNetworkInfo.getType() == 0) {
                if (isNRConnected((TelephonyManager) context.getSystemService("phone"))) {
                    ARRAY_OF_STRING[0] = NETWORK_CLASS_5_G;
                } else {
                    ARRAY_OF_STRING[0] = getNetworkClass(activeNetworkInfo.getSubtype());
                }
                String[] strArr2 = ARRAY_OF_STRING;
                strArr2[1] = activeNetworkInfo.getSubtypeName();
                return strArr2;
            }
        }
        return ARRAY_OF_STRING;
    }

    public static String getResolution(Context context) {
        try {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            int i10 = displayMetrics.widthPixels;
            int i11 = displayMetrics.heightPixels;
            if (i10 > i11) {
                int i12 = i10 ^ i11;
                i11 ^= i12;
                i10 = i12 ^ i11;
            }
            return i11 + "*" + i10;
        } catch (Exception e10) {
            LogUtil.e("DeviceUtils getResolution: error", e10);
            return "Unknown";
        }
    }

    public static String getUniqueID() {
        try {
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            int nanoTime = (int) System.nanoTime();
            int nextInt = new Random().nextInt();
            int nextInt2 = new Random().nextInt();
            byte[] IntGetBytes = IntGetBytes(currentTimeMillis);
            byte[] IntGetBytes2 = IntGetBytes(nanoTime);
            byte[] IntGetBytes3 = IntGetBytes(nextInt);
            byte[] IntGetBytes4 = IntGetBytes(nextInt2);
            byte[] bArr = new byte[16];
            System.arraycopy(IntGetBytes, 0, bArr, 0, 4);
            System.arraycopy(IntGetBytes2, 0, bArr, 4, 4);
            System.arraycopy(IntGetBytes3, 0, bArr, 8, 4);
            System.arraycopy(IntGetBytes4, 0, bArr, 12, 4);
            return Base64.encodeBase64String(bArr);
        } catch (Exception unused) {
            return null;
        }
    }

    public static String getUtdid(Context context) {
        try {
            return UTDevice.getUtdid(context);
        } catch (Exception e10) {
            LogUtil.e("get utdid error ", e10);
            return null;
        }
    }

    private static boolean isNRConnected(TelephonyManager telephonyManager) {
        try {
            Object invoke = Class.forName(telephonyManager.getClass().getName()).getDeclaredMethod("getServiceState", null).invoke(telephonyManager, null);
            for (Method method : Class.forName(invoke.getClass().getName()).getDeclaredMethods()) {
                if (!method.getName().equals("getNrStatus") && !method.getName().equals("getNrState")) {
                }
                method.setAccessible(true);
                if (((Integer) method.invoke(invoke, null)).intValue() != 3) {
                    return false;
                }
                return true;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }
}
