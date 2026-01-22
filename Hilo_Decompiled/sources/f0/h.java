package f0;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.CodingErrorAction;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class h extends i {

    /* renamed from: h, reason: collision with root package name */
    public int f١٤٠٣٥h;

    /* renamed from: i, reason: collision with root package name */
    public String f١٤٠٣٦i;

    public h() {
        super(6);
        this.f١٤٠٣٦i = "";
        CodingErrorAction codingErrorAction = z0.b.f١٩٣٣٣a;
        try {
            byte[] bytes = "".getBytes("UTF8");
            ByteBuffer allocate = ByteBuffer.allocate(4);
            allocate.putInt(this.f١٤٠٣٥h);
            allocate.position(2);
            ByteBuffer allocate2 = ByteBuffer.allocate(bytes.length + 2);
            allocate2.put(allocate);
            allocate2.put(bytes);
            allocate2.rewind();
            this.f١٤٠٣٠c = allocate2;
            this.f١٤٠٣٥h = 1000;
            try {
                byte[] bytes2 = this.f١٤٠٣٦i.getBytes("UTF8");
                ByteBuffer allocate3 = ByteBuffer.allocate(4);
                allocate3.putInt(this.f١٤٠٣٥h);
                allocate3.position(2);
                ByteBuffer allocate4 = ByteBuffer.allocate(bytes2.length + 2);
                allocate4.put(allocate3);
                allocate4.put(bytes2);
                allocate4.rewind();
                this.f١٤٠٣٠c = allocate4;
            } catch (UnsupportedEncodingException e10) {
                throw new RuntimeException(e10);
            }
        } catch (UnsupportedEncodingException e11) {
            throw new RuntimeException(e11);
        }
    }

    @Override // f0.i, f0.c
    public final void a() {
        super.a();
        int i10 = this.f١٤٠٣٥h;
        if (i10 == 1007 && this.f١٤٠٣٦i == null) {
            throw new i1.d(1007, "Received text is no valid utf8 string!");
        }
        if (i10 == 1005 && this.f١٤٠٣٦i.length() > 0) {
            throw new i1.d(1002, "A close frame must have a closecode if it has a reason");
        }
        int i11 = this.f١٤٠٣٥h;
        if (i11 > 1015 && i11 < 3000) {
            throw new i1.d(1002, "Trying to send an illegal close code!");
        }
        if (i11 != 1006 && i11 != 1015 && i11 != 1005 && i11 <= 4999 && i11 >= 1000 && i11 != 1004) {
            return;
        }
        throw new i1.f("closecode must not be sent over the wire: " + this.f١٤٠٣٥h);
    }

    @Override // f0.c
    public final void b(ByteBuffer byteBuffer) {
        this.f١٤٠٣٥h = 1005;
        this.f١٤٠٣٦i = "";
        byteBuffer.mark();
        if (byteBuffer.remaining() == 0) {
            this.f١٤٠٣٥h = 1000;
            return;
        }
        if (byteBuffer.remaining() == 1) {
            this.f١٤٠٣٥h = 1002;
            return;
        }
        if (byteBuffer.remaining() >= 2) {
            ByteBuffer allocate = ByteBuffer.allocate(4);
            allocate.position(2);
            allocate.putShort(byteBuffer.getShort());
            allocate.position(0);
            this.f١٤٠٣٥h = allocate.getInt();
        }
        byteBuffer.reset();
        try {
            int position = byteBuffer.position();
            try {
                try {
                    byteBuffer.position(byteBuffer.position() + 2);
                    this.f١٤٠٣٦i = z0.b.a(byteBuffer);
                } catch (IllegalArgumentException unused) {
                    throw new i1.d(1007);
                }
            } finally {
                byteBuffer.position(position);
            }
        } catch (i1.d unused2) {
            this.f١٤٠٣٥h = 1007;
            this.f١٤٠٣٦i = null;
        }
    }

    @Override // f0.c, f0.a
    public final ByteBuffer d() {
        if (this.f١٤٠٣٥h == 1005) {
            return ByteBuffer.allocate(0);
        }
        return this.f١٤٠٣٠c;
    }

    @Override // f0.c
    public final String toString() {
        return super.toString() + "code: " + this.f١٤٠٣٥h;
    }
}
