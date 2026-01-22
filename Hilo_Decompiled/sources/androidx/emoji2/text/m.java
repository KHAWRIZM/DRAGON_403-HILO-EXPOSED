package androidx.emoji2.text;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.UShort;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
abstract class m {

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    private static class a implements c {

        /* renamed from: a, reason: collision with root package name */
        private final ByteBuffer f٣٦٦٦a;

        a(ByteBuffer byteBuffer) {
            this.f٣٦٦٦a = byteBuffer;
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
        }

        @Override // androidx.emoji2.text.m.c
        public int a() {
            return this.f٣٦٦٦a.getInt();
        }

        @Override // androidx.emoji2.text.m.c
        public long b() {
            return m.c(this.f٣٦٦٦a.getInt());
        }

        @Override // androidx.emoji2.text.m.c
        public long getPosition() {
            return this.f٣٦٦٦a.position();
        }

        @Override // androidx.emoji2.text.m.c
        public int readUnsignedShort() {
            return m.d(this.f٣٦٦٦a.getShort());
        }

        @Override // androidx.emoji2.text.m.c
        public void skip(int i10) {
            ByteBuffer byteBuffer = this.f٣٦٦٦a;
            byteBuffer.position(byteBuffer.position() + i10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private final long f٣٦٦٧a;

        /* renamed from: b, reason: collision with root package name */
        private final long f٣٦٦٨b;

        b(long j10, long j11) {
            this.f٣٦٦٧a = j10;
            this.f٣٦٦٨b = j11;
        }

        long a() {
            return this.f٣٦٦٧a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public interface c {
        int a();

        long b();

        long getPosition();

        int readUnsignedShort();

        void skip(int i10);
    }

    private static b a(c cVar) {
        long j10;
        cVar.skip(4);
        int readUnsignedShort = cVar.readUnsignedShort();
        if (readUnsignedShort <= 100) {
            cVar.skip(6);
            int i10 = 0;
            while (true) {
                if (i10 < readUnsignedShort) {
                    int a10 = cVar.a();
                    cVar.skip(4);
                    j10 = cVar.b();
                    cVar.skip(4);
                    if (1835365473 == a10) {
                        break;
                    }
                    i10++;
                } else {
                    j10 = -1;
                    break;
                }
            }
            if (j10 != -1) {
                cVar.skip((int) (j10 - cVar.getPosition()));
                cVar.skip(12);
                long b10 = cVar.b();
                for (int i11 = 0; i11 < b10; i11++) {
                    int a11 = cVar.a();
                    long b11 = cVar.b();
                    long b12 = cVar.b();
                    if (1164798569 == a11 || 1701669481 == a11) {
                        return new b(b11 + j10, b12);
                    }
                }
            }
            throw new IOException("Cannot read metadata.");
        }
        throw new IOException("Cannot read metadata.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static w2.b b(ByteBuffer byteBuffer) {
        ByteBuffer duplicate = byteBuffer.duplicate();
        duplicate.position((int) a(new a(duplicate)).a());
        return w2.b.h(duplicate);
    }

    static long c(int i10) {
        return i10 & 4294967295L;
    }

    static int d(short s10) {
        return s10 & UShort.MAX_VALUE;
    }
}
