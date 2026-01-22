package anet.channel.util;

import android.content.Context;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.appmonitor.AppMonitor;
import anet.channel.statist.StrategyStatObject;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.UUID;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class SerializeHelper {
    private static final String TAG = "awcn.SerializeHelper";
    private static File cacheDir;

    public static File getCacheFiles(String str) {
        Context context;
        if (cacheDir == null && (context = GlobalAppRuntimeInfo.getContext()) != null) {
            cacheDir = context.getCacheDir();
        }
        return new File(cacheDir, str);
    }

    public static synchronized void persist(Serializable serializable, File file) {
        synchronized (SerializeHelper.class) {
            persist(serializable, file, null);
        }
    }

    public static synchronized <T> T restore(File file) {
        T t10;
        synchronized (SerializeHelper.class) {
            t10 = (T) restore(file, null);
        }
        return t10;
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x00b7, code lost:
    
        if (r9 != null) goto L٥٢;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized <T> T restore(File file, StrategyStatObject strategyStatObject) {
        FileInputStream fileInputStream;
        T t10;
        synchronized (SerializeHelper.class) {
            if (strategyStatObject != null) {
                strategyStatObject.readStrategyFilePath = String.valueOf(file);
            }
            try {
            } catch (Throwable th) {
                th = th;
                fileInputStream = null;
                t10 = null;
            }
            if (!file.exists()) {
                if (ALog.isPrintLog(3)) {
                    ALog.w(TAG, "file not exist.", null, "file", file.getName());
                }
                return null;
            }
            if (strategyStatObject != null) {
                strategyStatObject.isFileExists = 1;
            }
            long currentTimeMillis = System.currentTimeMillis();
            fileInputStream = new FileInputStream(file);
            try {
                ObjectInputStream objectInputStream = new ObjectInputStream(new BufferedInputStream(fileInputStream));
                t10 = (T) objectInputStream.readObject();
                try {
                    objectInputStream.close();
                    long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                    if (strategyStatObject != null) {
                        strategyStatObject.isReadObjectSucceed = 1;
                        strategyStatObject.readCostTime = currentTimeMillis2;
                    }
                    ALog.i(TAG, "restore end.", null, "file", file.getAbsoluteFile(), "size", Long.valueOf(file.length()), "cost", Long.valueOf(currentTimeMillis2));
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        if (ALog.isPrintLog(3)) {
                            ALog.w(TAG, "restore file fail.", null, th, new Object[0]);
                        }
                        if (strategyStatObject != null) {
                            strategyStatObject.appendErrorTrace("SerializeHelper.restore()", th);
                        }
                    } catch (Throwable th3) {
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException unused) {
                            }
                        }
                        throw th3;
                    }
                }
            } catch (Throwable th4) {
                th = th4;
                t10 = null;
            }
            try {
                fileInputStream.close();
            } catch (IOException unused2) {
                return t10;
            }
        }
    }

    /* JADX WARN: Not initialized variable reg: 11, insn: 0x0053: MOVE (r7 I:??[OBJECT, ARRAY]) = (r11 I:??[OBJECT, ARRAY]), block:B:65:0x0053 */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0088 A[Catch: all -> 0x004d, TryCatch #9 {, blocks: (B:8:0x0013, B:19:0x0049, B:21:0x0081, B:23:0x0088, B:25:0x009a, B:27:0x00a0, B:29:0x00db, B:36:0x00ec, B:38:0x00f0, B:39:0x00d0, B:61:0x00fd, B:59:0x0100, B:50:0x007d, B:66:0x0101), top: B:4:0x000d, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x009a A[Catch: all -> 0x004d, TryCatch #9 {, blocks: (B:8:0x0013, B:19:0x0049, B:21:0x0081, B:23:0x0088, B:25:0x009a, B:27:0x00a0, B:29:0x00db, B:36:0x00ec, B:38:0x00f0, B:39:0x00d0, B:61:0x00fd, B:59:0x0100, B:50:0x007d, B:66:0x0101), top: B:4:0x000d, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00e7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized void persist(Serializable serializable, File file, StrategyStatObject strategyStatObject) {
        FileOutputStream fileOutputStream;
        long currentTimeMillis;
        File file2;
        FileOutputStream fileOutputStream2;
        int i10;
        boolean z10;
        synchronized (SerializeHelper.class) {
            FileOutputStream fileOutputStream3 = null;
            if (serializable != null && file != null) {
                try {
                    currentTimeMillis = System.currentTimeMillis();
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream3 = fileOutputStream;
                }
                try {
                    try {
                        file2 = getCacheFiles(UUID.randomUUID().toString().replace("-", ""));
                        try {
                            file2.createNewFile();
                            file2.setReadable(true);
                            fileOutputStream2 = new FileOutputStream(file2);
                        } catch (Exception e10) {
                            e = e10;
                            fileOutputStream2 = null;
                        }
                    } catch (Exception e11) {
                        e = e11;
                        file2 = null;
                        fileOutputStream2 = null;
                    }
                    try {
                        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(fileOutputStream2));
                        objectOutputStream.writeObject(serializable);
                        objectOutputStream.flush();
                        objectOutputStream.close();
                        try {
                            fileOutputStream2.close();
                        } catch (IOException unused) {
                        }
                        i10 = 1;
                    } catch (Exception e12) {
                        e = e12;
                        ALog.e(TAG, "persist fail. ", null, e, "file", file.getName());
                        if (strategyStatObject != null) {
                            strategyStatObject.appendErrorTrace("SerializeHelper.persist()", e);
                        }
                        if (fileOutputStream2 != null) {
                            try {
                                fileOutputStream2.close();
                            } catch (IOException unused2) {
                            }
                        }
                        i10 = 0;
                        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                        if (strategyStatObject != null) {
                        }
                        if (i10 == 0) {
                        }
                        if (i10 != 0) {
                        }
                        try {
                            file2.delete();
                        } catch (Exception unused3) {
                            ALog.e(TAG, "delete failed.", null, new Object[0]);
                        }
                        return;
                    }
                    long currentTimeMillis22 = System.currentTimeMillis() - currentTimeMillis;
                    if (strategyStatObject != null) {
                        strategyStatObject.writeTempFilePath = String.valueOf(file2);
                        strategyStatObject.writeStrategyFilePath = String.valueOf(file);
                        strategyStatObject.isTempWriteSucceed = i10;
                        strategyStatObject.writeCostTime = currentTimeMillis22;
                    }
                    if (i10 == 0) {
                        z10 = file2.renameTo(file);
                        if (z10) {
                            ALog.i(TAG, "persist end.", null, "file", file.getAbsoluteFile(), "size", Long.valueOf(file.length()), "cost", Long.valueOf(currentTimeMillis22));
                        } else {
                            ALog.e(TAG, "rename failed.", null, new Object[0]);
                        }
                        if (strategyStatObject != null) {
                            strategyStatObject.isRenameSucceed = z10 ? 1 : 0;
                            strategyStatObject.isSucceed = z10 ? 1 : 0;
                            AppMonitor.getInstance().commitStat(strategyStatObject);
                        }
                    } else {
                        z10 = false;
                    }
                    if (i10 != 0 || !z10) {
                        file2.delete();
                    }
                    return;
                } catch (Throwable th2) {
                    th = th2;
                    if (fileOutputStream3 != null) {
                        try {
                            fileOutputStream3.close();
                        } catch (IOException unused4) {
                        }
                    }
                    throw th;
                }
            }
            ALog.e(TAG, "persist fail. Invalid parameter", null, new Object[0]);
        }
    }
}
