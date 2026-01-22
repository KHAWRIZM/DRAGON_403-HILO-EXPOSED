package com.ta.a.c;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class c {
    private static File a;

    /* renamed from: a, reason: collision with other field name */
    private static FileChannel f٣a;

    /* renamed from: a, reason: collision with other field name */
    private static FileLock f٤a;
    private static File b;

    public static synchronized void c() {
        synchronized (c.class) {
            try {
                f.e();
                if (a == null) {
                    a = new File(com.ta.a.b.e.c());
                }
                if (!a.exists()) {
                    try {
                        a.createNewFile();
                    } catch (Exception unused) {
                        return;
                    }
                }
                if (f٣a == null) {
                    try {
                        f٣a = new RandomAccessFile(a, "rw").getChannel();
                    } catch (Exception unused2) {
                        return;
                    }
                }
                try {
                    f٤a = f٣a.lock();
                } catch (Throwable unused3) {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static synchronized void d() {
        synchronized (c.class) {
            try {
                f.e();
                FileLock fileLock = f٤a;
                if (fileLock != null) {
                    try {
                        fileLock.release();
                    } catch (Exception unused) {
                    } catch (Throwable th) {
                        f٤a = null;
                        throw th;
                    }
                    f٤a = null;
                }
                FileChannel fileChannel = f٣a;
                if (fileChannel != null) {
                    try {
                        fileChannel.close();
                    } catch (Exception unused2) {
                    } catch (Throwable th2) {
                        f٣a = null;
                        throw th2;
                    }
                    f٣a = null;
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }
}
