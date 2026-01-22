package e0;

import java.io.PrintWriter;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class v {

    /* renamed from: a, reason: collision with root package name */
    public final int f١٣٨٣٨a;

    /* renamed from: b, reason: collision with root package name */
    public final int f١٣٨٣٩b;

    /* renamed from: c, reason: collision with root package name */
    public final long f١٣٨٤٠c;

    /* renamed from: d, reason: collision with root package name */
    public final long f١٣٨٤١d;

    /* renamed from: e, reason: collision with root package name */
    public final long f١٣٨٤٢e;

    /* renamed from: f, reason: collision with root package name */
    public final long f١٣٨٤٣f;

    /* renamed from: g, reason: collision with root package name */
    public final long f١٣٨٤٤g;

    /* renamed from: h, reason: collision with root package name */
    public final long f١٣٨٤٥h;

    /* renamed from: i, reason: collision with root package name */
    public final long f١٣٨٤٦i;

    /* renamed from: j, reason: collision with root package name */
    public final long f١٣٨٤٧j;

    /* renamed from: k, reason: collision with root package name */
    public final int f١٣٨٤٨k;

    /* renamed from: l, reason: collision with root package name */
    public final int f١٣٨٤٩l;

    /* renamed from: m, reason: collision with root package name */
    public final int f١٣٨٥٠m;

    /* renamed from: n, reason: collision with root package name */
    public final long f١٣٨٥١n;

    public v(int i10, int i11, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, int i12, int i13, int i14, long j18) {
        this.f١٣٨٣٨a = i10;
        this.f١٣٨٣٩b = i11;
        this.f١٣٨٤٠c = j10;
        this.f١٣٨٤١d = j11;
        this.f١٣٨٤٢e = j12;
        this.f١٣٨٤٣f = j13;
        this.f١٣٨٤٤g = j14;
        this.f١٣٨٤٥h = j15;
        this.f١٣٨٤٦i = j16;
        this.f١٣٨٤٧j = j17;
        this.f١٣٨٤٨k = i12;
        this.f١٣٨٤٩l = i13;
        this.f١٣٨٥٠m = i14;
        this.f١٣٨٥١n = j18;
    }

    public final void a(PrintWriter printWriter) {
        printWriter.println("===============BEGIN PICASSO STATS ===============");
        printWriter.println("Memory Cache Stats");
        printWriter.print("  Max Cache Size: ");
        printWriter.println(this.f١٣٨٣٨a);
        printWriter.print("  Cache Size: ");
        printWriter.println(this.f١٣٨٣٩b);
        printWriter.print("  Cache % Full: ");
        printWriter.println((int) Math.ceil((this.f١٣٨٣٩b / this.f١٣٨٣٨a) * 100.0f));
        printWriter.print("  Cache Hits: ");
        printWriter.println(this.f١٣٨٤٠c);
        printWriter.print("  Cache Misses: ");
        printWriter.println(this.f١٣٨٤١d);
        printWriter.println("Network Stats");
        printWriter.print("  Download Count: ");
        printWriter.println(this.f١٣٨٤٨k);
        printWriter.print("  Total Download Size: ");
        printWriter.println(this.f١٣٨٤٢e);
        printWriter.print("  Average Download Size: ");
        printWriter.println(this.f١٣٨٤٥h);
        printWriter.println("Bitmap Stats");
        printWriter.print("  Total Bitmaps Decoded: ");
        printWriter.println(this.f١٣٨٤٩l);
        printWriter.print("  Total Bitmap Size: ");
        printWriter.println(this.f١٣٨٤٣f);
        printWriter.print("  Total Transformed Bitmaps: ");
        printWriter.println(this.f١٣٨٥٠m);
        printWriter.print("  Total Transformed Bitmap Size: ");
        printWriter.println(this.f١٣٨٤٤g);
        printWriter.print("  Average Bitmap Size: ");
        printWriter.println(this.f١٣٨٤٦i);
        printWriter.print("  Average Transformed Bitmap Size: ");
        printWriter.println(this.f١٣٨٤٧j);
        printWriter.println("===============END PICASSO STATS ===============");
        printWriter.flush();
    }

    public final String toString() {
        return "StatsSnapshot{maxSize=" + this.f١٣٨٣٨a + ", size=" + this.f١٣٨٣٩b + ", cacheHits=" + this.f١٣٨٤٠c + ", cacheMisses=" + this.f١٣٨٤١d + ", downloadCount=" + this.f١٣٨٤٨k + ", totalDownloadSize=" + this.f١٣٨٤٢e + ", averageDownloadSize=" + this.f١٣٨٤٥h + ", totalOriginalBitmapSize=" + this.f١٣٨٤٣f + ", totalTransformedBitmapSize=" + this.f١٣٨٤٤g + ", averageOriginalBitmapSize=" + this.f١٣٨٤٦i + ", averageTransformedBitmapSize=" + this.f١٣٨٤٧j + ", originalBitmapCount=" + this.f١٣٨٤٩l + ", transformedBitmapCount=" + this.f١٣٨٥٠m + ", timeStamp=" + this.f١٣٨٥١n + '}';
    }
}
