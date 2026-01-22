package x6;

import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
class a {

    /* renamed from: c, reason: collision with root package name */
    private static final String f١٨٩٣١c = i.f١٨٩٥٣n;

    /* renamed from: a, reason: collision with root package name */
    private final InputStream f١٨٩٣٢a;

    /* renamed from: b, reason: collision with root package name */
    private ByteArrayOutputStream f١٨٩٣٣b;

    public a(InputStream inputStream) {
        this.f١٨٩٣٢a = inputStream;
        try {
            a();
        } catch (IOException e10) {
            Log.w(f١٨٩٣١c, "IOException in CopyInputStream " + e10.toString());
        }
    }

    private void a() {
        this.f١٨٩٣٣b = new ByteArrayOutputStream();
        byte[] bArr = new byte[256];
        while (true) {
            int read = this.f١٨٩٣٢a.read(bArr);
            if (-1 != read) {
                this.f١٨٩٣٣b.write(bArr, 0, read);
            } else {
                this.f١٨٩٣٣b.flush();
                return;
            }
        }
    }

    public ByteArrayInputStream b() {
        return new ByteArrayInputStream(this.f١٨٩٣٣b.toByteArray());
    }
}
