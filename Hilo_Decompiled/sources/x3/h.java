package x3;

import androidx.core.os.y;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.qiahao.base_common.download.okDownload.DownloadProgress;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    private final String[] f١٨٩٠٥a = new String[5];

    /* renamed from: b, reason: collision with root package name */
    private final long[] f١٨٩٠٦b = new long[5];

    /* renamed from: c, reason: collision with root package name */
    private int f١٨٩٠٧c = 0;

    /* renamed from: d, reason: collision with root package name */
    private int f١٨٩٠٨d = 0;

    public void a(String str) {
        int i10 = this.f١٨٩٠٧c;
        if (i10 == 5) {
            this.f١٨٩٠٨d++;
            return;
        }
        this.f١٨٩٠٥a[i10] = str;
        this.f١٨٩٠٦b[i10] = System.nanoTime();
        y.a(str);
        this.f١٨٩٠٧c++;
    }

    public float b(String str) {
        int i10 = this.f١٨٩٠٨d;
        if (i10 > 0) {
            this.f١٨٩٠٨d = i10 - 1;
            return DownloadProgress.UNKNOWN_PROGRESS;
        }
        int i11 = this.f١٨٩٠٧c - 1;
        this.f١٨٩٠٧c = i11;
        if (i11 != -1) {
            if (str.equals(this.f١٨٩٠٥a[i11])) {
                y.b();
                return ((float) (System.nanoTime() - this.f١٨٩٠٦b[this.f١٨٩٠٧c])) / 1000000.0f;
            }
            throw new IllegalStateException("Unbalanced trace call " + str + ". Expected " + this.f١٨٩٠٥a[this.f١٨٩٠٧c] + InstructionFileId.DOT);
        }
        throw new IllegalStateException("Can't end trace section. There are none.");
    }
}
