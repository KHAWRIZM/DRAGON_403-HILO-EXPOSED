package g0;

import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class e implements d {

    /* renamed from: a, reason: collision with root package name */
    public final FileChannel f١٤٣٦٦a;

    /* renamed from: b, reason: collision with root package name */
    public final ParcelFileDescriptor f١٤٣٦٧b;

    /* renamed from: c, reason: collision with root package name */
    public final BufferedOutputStream f١٤٣٦٨c;

    /* renamed from: d, reason: collision with root package name */
    public final FileOutputStream f١٤٣٦٩d;

    public e(Context context, Uri uri, int i10) {
        ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(uri, "rw");
        if (openFileDescriptor != null) {
            this.f١٤٣٦٧b = openFileDescriptor;
            FileOutputStream fileOutputStream = new FileOutputStream(openFileDescriptor.getFileDescriptor());
            this.f١٤٣٦٩d = fileOutputStream;
            this.f١٤٣٦٦a = fileOutputStream.getChannel();
            this.f١٤٣٦٨c = new BufferedOutputStream(fileOutputStream, i10);
            return;
        }
        throw new FileNotFoundException("result of " + uri + " is null!");
    }

    public final void a(long j10) {
        try {
            Os.posix_fallocate(this.f١٤٣٦٧b.getFileDescriptor(), 0L, j10);
        } catch (Throwable th) {
            if (th instanceof ErrnoException) {
                int i10 = th.errno;
                if (i10 == OsConstants.ENOSYS || i10 == OsConstants.ENOTSUP) {
                    try {
                        Os.ftruncate(this.f١٤٣٦٧b.getFileDescriptor(), j10);
                        return;
                    } catch (Throwable th2) {
                        th2.toString();
                        return;
                    }
                }
                return;
            }
            th.toString();
        }
    }
}
