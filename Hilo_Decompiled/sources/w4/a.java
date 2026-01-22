package w4;

import com.bumptech.glide.load.data.e;
import java.nio.ByteBuffer;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class a implements e {

    /* renamed from: a, reason: collision with root package name */
    private final ByteBuffer f١٨٧١٧a;

    /* renamed from: w4.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class C٠٢٤١a implements e.a {
        @Override // com.bumptech.glide.load.data.e.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public e build(ByteBuffer byteBuffer) {
            return new a(byteBuffer);
        }

        @Override // com.bumptech.glide.load.data.e.a
        public Class getDataClass() {
            return ByteBuffer.class;
        }
    }

    public a(ByteBuffer byteBuffer) {
        this.f١٨٧١٧a = byteBuffer;
    }

    @Override // com.bumptech.glide.load.data.e
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ByteBuffer a() {
        this.f١٨٧١٧a.position(0);
        return this.f١٨٧١٧a;
    }

    @Override // com.bumptech.glide.load.data.e
    public void cleanup() {
    }
}
