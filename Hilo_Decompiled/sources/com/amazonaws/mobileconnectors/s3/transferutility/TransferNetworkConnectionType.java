package com.amazonaws.mobileconnectors.s3.transferutility;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import java.util.HashMap;
import java.util.Map;
import p8.c;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'ANY' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class TransferNetworkConnectionType {
    private static final /* synthetic */ TransferNetworkConnectionType[] $VALUES;

    @c("ANY")
    public static final TransferNetworkConnectionType ANY;
    private static final Log LOGGER;
    private static final Map<String, TransferNetworkConnectionType> MAP;

    @c("MOBILE")
    public static final TransferNetworkConnectionType MOBILE;

    @c("WIFI")
    public static final TransferNetworkConnectionType WIFI;

    static {
        int i10 = 0;
        TransferNetworkConnectionType transferNetworkConnectionType = new TransferNetworkConnectionType("ANY", i10) { // from class: com.amazonaws.mobileconnectors.s3.transferutility.TransferNetworkConnectionType.1
            @Override // com.amazonaws.mobileconnectors.s3.transferutility.TransferNetworkConnectionType
            protected boolean verify(NetworkInfo networkInfo) {
                if (networkInfo != null && networkInfo.isConnected()) {
                    return true;
                }
                return false;
            }
        };
        ANY = transferNetworkConnectionType;
        TransferNetworkConnectionType transferNetworkConnectionType2 = new TransferNetworkConnectionType("WIFI", 1) { // from class: com.amazonaws.mobileconnectors.s3.transferutility.TransferNetworkConnectionType.2
            @Override // com.amazonaws.mobileconnectors.s3.transferutility.TransferNetworkConnectionType
            protected boolean verify(NetworkInfo networkInfo) {
                if (networkInfo != null && networkInfo.isConnected() && networkInfo.getType() == 1) {
                    return true;
                }
                return false;
            }
        };
        WIFI = transferNetworkConnectionType2;
        TransferNetworkConnectionType transferNetworkConnectionType3 = new TransferNetworkConnectionType("MOBILE", 2) { // from class: com.amazonaws.mobileconnectors.s3.transferutility.TransferNetworkConnectionType.3
            @Override // com.amazonaws.mobileconnectors.s3.transferutility.TransferNetworkConnectionType
            protected boolean verify(NetworkInfo networkInfo) {
                if (networkInfo != null && networkInfo.isConnected() && networkInfo.getType() == 0) {
                    return true;
                }
                return false;
            }
        };
        MOBILE = transferNetworkConnectionType3;
        $VALUES = new TransferNetworkConnectionType[]{transferNetworkConnectionType, transferNetworkConnectionType2, transferNetworkConnectionType3};
        MAP = new HashMap();
        TransferNetworkConnectionType[] values = values();
        int length = values.length;
        while (i10 < length) {
            TransferNetworkConnectionType transferNetworkConnectionType4 = values[i10];
            MAP.put(transferNetworkConnectionType4.toString(), transferNetworkConnectionType4);
            i10++;
        }
        LOGGER = LogFactory.getLog(TransferNetworkConnectionType.class);
    }

    private TransferNetworkConnectionType(String str, int i10) {
    }

    public static TransferNetworkConnectionType getConnectionType(String str) {
        Map<String, TransferNetworkConnectionType> map = MAP;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        LOGGER.error("Unknown connection type " + str + " transfer will have connection type set to ANY.");
        return ANY;
    }

    public static TransferNetworkConnectionType valueOf(String str) {
        return (TransferNetworkConnectionType) Enum.valueOf(TransferNetworkConnectionType.class, str);
    }

    public static TransferNetworkConnectionType[] values() {
        return (TransferNetworkConnectionType[]) $VALUES.clone();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isConnected(ConnectivityManager connectivityManager) {
        return verify(connectivityManager.getActiveNetworkInfo());
    }

    protected abstract boolean verify(NetworkInfo networkInfo);
}
