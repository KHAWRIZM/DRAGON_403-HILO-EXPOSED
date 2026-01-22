package anet.channel.bytes;

import android.support.v4.media.session.PlaybackStateCompat;
import java.util.Arrays;
import java.util.Random;
import java.util.TreeSet;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class a {
    public static final int MAX_POOL_SIZE = 524288;
    public static final String TAG = "awcn.ByteArrayPool";

    /* renamed from: a, reason: collision with root package name */
    private final TreeSet<ByteArray> f٤٦٨٩a = new TreeSet<>();

    /* renamed from: b, reason: collision with root package name */
    private final ByteArray f٤٦٩٠b = ByteArray.create(0);

    /* renamed from: c, reason: collision with root package name */
    private final Random f٤٦٩١c = new Random();

    /* renamed from: d, reason: collision with root package name */
    private long f٤٦٩٢d = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: anet.channel.bytes.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class C٠٠٦٠a {

        /* renamed from: a, reason: collision with root package name */
        public static a f٤٦٩٣a = new a();

        C٠٠٦٠a() {
        }
    }

    public synchronized void a(ByteArray byteArray) {
        ByteArray pollLast;
        if (byteArray != null) {
            try {
                int i10 = byteArray.bufferLength;
                if (i10 < 524288) {
                    this.f٤٦٩٢d += i10;
                    this.f٤٦٨٩a.add(byteArray);
                    while (this.f٤٦٩٢d > PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED) {
                        if (this.f٤٦٩١c.nextBoolean()) {
                            pollLast = this.f٤٦٨٩a.pollFirst();
                        } else {
                            pollLast = this.f٤٦٨٩a.pollLast();
                        }
                        this.f٤٦٩٢d -= pollLast.bufferLength;
                    }
                }
            } finally {
            }
        }
    }

    public synchronized ByteArray a(int i10) {
        if (i10 >= 524288) {
            return ByteArray.create(i10);
        }
        ByteArray byteArray = this.f٤٦٩٠b;
        byteArray.bufferLength = i10;
        ByteArray ceiling = this.f٤٦٨٩a.ceiling(byteArray);
        if (ceiling == null) {
            ceiling = ByteArray.create(i10);
        } else {
            Arrays.fill(ceiling.buffer, (byte) 0);
            ceiling.dataLength = 0;
            this.f٤٦٨٩a.remove(ceiling);
            this.f٤٦٩٢d -= ceiling.bufferLength;
        }
        return ceiling;
    }

    public ByteArray a(byte[] bArr, int i10) {
        ByteArray a10 = a(i10);
        System.arraycopy(bArr, 0, a10.buffer, 0, i10);
        a10.dataLength = i10;
        return a10;
    }
}
