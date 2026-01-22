package androidx.profileinstaller;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetFileDescriptor;
import android.os.Build;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class h {

    /* renamed from: a, reason: collision with root package name */
    private static final androidx.concurrent.futures.e f٤٠١١a = androidx.concurrent.futures.e.j();

    /* renamed from: b, reason: collision with root package name */
    private static final Object f٤٠١٢b = new Object();

    /* renamed from: c, reason: collision with root package name */
    private static c f٤٠١٣c = null;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class a {
        static PackageInfo a(PackageManager packageManager, Context context) {
            return packageManager.getPackageInfo(context.getPackageName(), PackageManager.PackageInfoFlags.of(0L));
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    static class b {

        /* renamed from: a, reason: collision with root package name */
        final int f٤٠١٤a;

        /* renamed from: b, reason: collision with root package name */
        final int f٤٠١٥b;

        /* renamed from: c, reason: collision with root package name */
        final long f٤٠١٦c;

        /* renamed from: d, reason: collision with root package name */
        final long f٤٠١٧d;

        b(int i10, int i11, long j10, long j11) {
            this.f٤٠١٤a = i10;
            this.f٤٠١٥b = i11;
            this.f٤٠١٦c = j10;
            this.f٤٠١٧d = j11;
        }

        static b a(File file) {
            DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file));
            try {
                b bVar = new b(dataInputStream.readInt(), dataInputStream.readInt(), dataInputStream.readLong(), dataInputStream.readLong());
                dataInputStream.close();
                return bVar;
            } catch (Throwable th) {
                try {
                    dataInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }

        void b(File file) {
            file.delete();
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file));
            try {
                dataOutputStream.writeInt(this.f٤٠١٤a);
                dataOutputStream.writeInt(this.f٤٠١٥b);
                dataOutputStream.writeLong(this.f٤٠١٦c);
                dataOutputStream.writeLong(this.f٤٠١٧d);
                dataOutputStream.close();
            } catch (Throwable th) {
                try {
                    dataOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            if (this.f٤٠١٥b == bVar.f٤٠١٥b && this.f٤٠١٦c == bVar.f٤٠١٦c && this.f٤٠١٤a == bVar.f٤٠١٤a && this.f٤٠١٧d == bVar.f٤٠١٧d) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return Objects.hash(Integer.valueOf(this.f٤٠١٥b), Long.valueOf(this.f٤٠١٦c), Integer.valueOf(this.f٤٠١٤a), Long.valueOf(this.f٤٠١٧d));
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        final int f٤٠١٨a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean f٤٠١٩b;

        /* renamed from: c, reason: collision with root package name */
        private final boolean f٤٠٢٠c;

        /* renamed from: d, reason: collision with root package name */
        private final boolean f٤٠٢١d;

        c(int i10, boolean z10, boolean z11, boolean z12) {
            this.f٤٠١٨a = i10;
            this.f٤٠٢٠c = z11;
            this.f٤٠١٩b = z10;
            this.f٤٠٢١d = z12;
        }
    }

    private static long a(Context context) {
        PackageManager packageManager = context.getApplicationContext().getPackageManager();
        if (Build.VERSION.SDK_INT >= 33) {
            return a.a(packageManager, context).lastUpdateTime;
        }
        return packageManager.getPackageInfo(context.getPackageName(), 0).lastUpdateTime;
    }

    private static c b(int i10, boolean z10, boolean z11, boolean z12) {
        c cVar = new c(i10, z10, z11, z12);
        f٤٠١٣c = cVar;
        f٤٠١١a.set(cVar);
        return f٤٠١٣c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't wrap try/catch for region: R(20:23|(1:89)(1:27)|28|(1:88)(1:32)|33|34|35|(2:74|75)(1:37)|38|(8:45|(1:49)|(1:56)|57|(2:64|65)|61|62|63)|(1:71)(1:(1:73))|(1:49)|(3:51|54|56)|57|(1:59)|64|65|61|62|63) */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00fc, code lost:
    
        r5 = 196608;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00c8, code lost:
    
        r5 = 327680;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static c c(Context context, boolean z10) {
        boolean z11;
        boolean z12;
        boolean z13;
        b a10;
        b bVar;
        int i10;
        c cVar;
        if (!z10 && (cVar = f٤٠١٣c) != null) {
            return cVar;
        }
        synchronized (f٤٠١٢b) {
            if (!z10) {
                c cVar2 = f٤٠١٣c;
                if (cVar2 != null) {
                    return cVar2;
                }
            }
            int i11 = 0;
            try {
                AssetFileDescriptor openFd = context.getAssets().openFd("dexopt/baseline.prof");
                try {
                    if (openFd.getLength() > 0) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    openFd.close();
                } finally {
                }
            } catch (IOException unused) {
                z11 = false;
            }
            int i12 = Build.VERSION.SDK_INT;
            if (i12 >= 28 && i12 != 30) {
                File file = new File(new File("/data/misc/profiles/ref/", context.getPackageName()), "primary.prof");
                long length = file.length();
                if (file.exists() && length > 0) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                File file2 = new File(new File("/data/misc/profiles/cur/0/", context.getPackageName()), "primary.prof");
                long length2 = file2.length();
                if (file2.exists() && length2 > 0) {
                    z13 = true;
                } else {
                    z13 = false;
                }
                try {
                    long a11 = a(context);
                    File file3 = new File(context.getFilesDir(), "profileInstalled");
                    if (file3.exists()) {
                        try {
                            a10 = b.a(file3);
                        } catch (IOException unused2) {
                            return b(anetwork.channel.unified.e.MAX_RSP_BUFFER_LENGTH, z12, z13, z11);
                        }
                    } else {
                        a10 = null;
                    }
                    if (a10 != null && a10.f٤٠١٦c == a11 && (i10 = a10.f٤٠١٥b) != 2) {
                        i11 = i10;
                        if (z10 && z13 && i11 != 1) {
                            i11 = 2;
                        }
                        if (a10 != null && a10.f٤٠١٥b == 2 && i11 == 1 && length < a10.f٤٠١٧d) {
                            i11 = 3;
                        }
                        bVar = new b(1, i11, a11, length2);
                        if (a10 != null || !a10.equals(bVar)) {
                            bVar.b(file3);
                        }
                        return b(i11, z12, z13, z11);
                    }
                    if (z12) {
                        i11 = 1;
                    } else if (z13) {
                        i11 = 2;
                    }
                    if (z10) {
                        i11 = 2;
                    }
                    if (a10 != null) {
                        i11 = 3;
                    }
                    bVar = new b(1, i11, a11, length2);
                    if (a10 != null) {
                    }
                    bVar.b(file3);
                    return b(i11, z12, z13, z11);
                } catch (PackageManager.NameNotFoundException unused3) {
                    return b(65536, z12, z13, z11);
                }
            }
            return b(262144, false, false, z11);
        }
    }
}
