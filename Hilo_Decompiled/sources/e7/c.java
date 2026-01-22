package e7;

import com.google.firebase.encoders.proto.ProtoEnum;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class c {

    /* renamed from: c, reason: collision with root package name */
    private static final c f١٣٩٠١c = new a().a();

    /* renamed from: a, reason: collision with root package name */
    private final long f١٣٩٠٢a;

    /* renamed from: b, reason: collision with root package name */
    private final b f١٣٩٠٣b;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private long f١٣٩٠٤a = 0;

        /* renamed from: b, reason: collision with root package name */
        private b f١٣٩٠٥b = b.REASON_UNKNOWN;

        a() {
        }

        public c a() {
            return new c(this.f١٣٩٠٤a, this.f١٣٩٠٥b);
        }

        public a b(long j10) {
            this.f١٣٩٠٤a = j10;
            return this;
        }

        public a c(b bVar) {
            this.f١٣٩٠٥b = bVar;
            return this;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public enum b implements ProtoEnum {
        REASON_UNKNOWN(0),
        MESSAGE_TOO_OLD(1),
        CACHE_FULL(2),
        PAYLOAD_TOO_BIG(3),
        MAX_RETRIES_REACHED(4),
        INVALID_PAYLOD(5),
        SERVER_ERROR(6);


        /* renamed from: a, reason: collision with root package name */
        private final int f١٣٩١٤a;

        b(int i10) {
            this.f١٣٩١٤a = i10;
        }

        @Override // com.google.firebase.encoders.proto.ProtoEnum
        public int getNumber() {
            return this.f١٣٩١٤a;
        }
    }

    c(long j10, b bVar) {
        this.f١٣٩٠٢a = j10;
        this.f١٣٩٠٣b = bVar;
    }

    public static a c() {
        return new a();
    }

    public long a() {
        return this.f١٣٩٠٢a;
    }

    public b b() {
        return this.f١٣٩٠٣b;
    }
}
