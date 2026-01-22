package f0;

import com.amazonaws.services.s3.internal.Constants;
import e0.h0;
import java.nio.ByteBuffer;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class c implements a {

    /* renamed from: b, reason: collision with root package name */
    public final int f١٤٠٢٩b;

    /* renamed from: c, reason: collision with root package name */
    public ByteBuffer f١٤٠٣٠c = ByteBuffer.allocate(0);

    /* renamed from: a, reason: collision with root package name */
    public boolean f١٤٠٢٨a = true;

    /* renamed from: d, reason: collision with root package name */
    public boolean f١٤٠٣١d = false;

    /* renamed from: e, reason: collision with root package name */
    public boolean f١٤٠٣٢e = false;

    /* renamed from: f, reason: collision with root package name */
    public boolean f١٤٠٣٣f = false;

    /* renamed from: g, reason: collision with root package name */
    public boolean f١٤٠٣٤g = false;

    public c(int i10) {
        this.f١٤٠٢٩b = i10;
    }

    public abstract void a();

    public void b(ByteBuffer byteBuffer) {
        this.f١٤٠٣٠c = byteBuffer;
    }

    @Override // f0.a
    public ByteBuffer d() {
        return this.f١٤٠٣٠c;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            c cVar = (c) obj;
            if (this.f١٤٠٢٨a != cVar.f١٤٠٢٨a || this.f١٤٠٣١d != cVar.f١٤٠٣١d || this.f١٤٠٣٢e != cVar.f١٤٠٣٢e || this.f١٤٠٣٣f != cVar.f١٤٠٣٣f || this.f١٤٠٣٤g != cVar.f١٤٠٣٤g || this.f١٤٠٢٩b != cVar.f١٤٠٢٩b) {
                return false;
            }
            ByteBuffer byteBuffer = this.f١٤٠٣٠c;
            ByteBuffer byteBuffer2 = cVar.f١٤٠٣٠c;
            if (byteBuffer != null) {
                return byteBuffer.equals(byteBuffer2);
            }
            if (byteBuffer2 == null) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i10;
        int a10 = (h0.a(this.f١٤٠٢٩b) + ((this.f١٤٠٢٨a ? 1 : 0) * 31)) * 31;
        ByteBuffer byteBuffer = this.f١٤٠٣٠c;
        if (byteBuffer != null) {
            i10 = byteBuffer.hashCode();
        } else {
            i10 = 0;
        }
        return ((((((((a10 + i10) * 31) + (this.f١٤٠٣١d ? 1 : 0)) * 31) + (this.f١٤٠٣٢e ? 1 : 0)) * 31) + (this.f١٤٠٣٣f ? 1 : 0)) * 31) + (this.f١٤٠٣٤g ? 1 : 0);
    }

    public String toString() {
        String str;
        String str2;
        StringBuilder sb = new StringBuilder("Framedata{ optcode:");
        switch (this.f١٤٠٢٩b) {
            case 1:
                str = "CONTINUOUS";
                break;
            case 2:
                str = "TEXT";
                break;
            case 3:
                str = "BINARY";
                break;
            case 4:
                str = "PING";
                break;
            case 5:
                str = "PONG";
                break;
            case 6:
                str = "CLOSING";
                break;
            default:
                str = Constants.NULL_VERSION_ID;
                break;
        }
        sb.append(str);
        sb.append(", fin:");
        sb.append(this.f١٤٠٢٨a);
        sb.append(", rsv1:");
        sb.append(this.f١٤٠٣٢e);
        sb.append(", rsv2:");
        sb.append(this.f١٤٠٣٣f);
        sb.append(", rsv3:");
        sb.append(this.f١٤٠٣٤g);
        sb.append(", payloadlength:[pos:");
        sb.append(this.f١٤٠٣٠c.position());
        sb.append(", len:");
        sb.append(this.f١٤٠٣٠c.remaining());
        sb.append("], payload:");
        if (this.f١٤٠٣٠c.remaining() > 1000) {
            str2 = "(too big to display)";
        } else {
            str2 = new String(this.f١٤٠٣٠c.array());
        }
        sb.append(str2);
        sb.append('}');
        return sb.toString();
    }
}
