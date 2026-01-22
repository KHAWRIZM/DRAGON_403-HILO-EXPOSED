package e1;

import anet.channel.request.Request;
import com.facebook.internal.security.CertificateUtil;
import i1.e;
import i1.g;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.CodingErrorAction;
import p0.c;
import p0.d;
import p0.f;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public int f١٣٨٥٣a = 0;

    public static String a(ByteBuffer byteBuffer) {
        ByteBuffer allocate = ByteBuffer.allocate(byteBuffer.remaining());
        byte b10 = 48;
        while (true) {
            if (byteBuffer.hasRemaining()) {
                byte b11 = byteBuffer.get();
                allocate.put(b11);
                if (b10 == 13 && b11 == 10) {
                    allocate.limit(allocate.position() - 2);
                    allocate.position(0);
                    break;
                }
                b10 = b11;
            } else {
                byteBuffer.position(byteBuffer.position() - allocate.position());
                allocate = null;
                break;
            }
        }
        if (allocate == null) {
            return null;
        }
        byte[] array = allocate.array();
        int limit = allocate.limit();
        CodingErrorAction codingErrorAction = z0.b.f١٩٣٣٣a;
        try {
            return new String(array, 0, limit, "ASCII");
        } catch (UnsupportedEncodingException e10) {
            throw new RuntimeException(e10);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final f b(ByteBuffer byteBuffer) {
        d dVar;
        int i10 = this.f١٣٨٥٣a;
        String a10 = a(byteBuffer);
        if (a10 != null) {
            String[] split = a10.split(" ", 3);
            if (split.length == 3) {
                if (i10 == 1) {
                    if ("101".equals(split[1])) {
                        if ("HTTP/1.1".equalsIgnoreCase(split[0])) {
                            c cVar = new c();
                            Short.parseShort(split[1]);
                            cVar.f١٦٨٣٩b = split[2];
                            dVar = cVar;
                        } else {
                            throw new g("Invalid status line received: " + split[0] + " Status line: " + a10);
                        }
                    } else {
                        throw new g("Invalid status code received: " + split[1] + " Status line: " + a10);
                    }
                } else if (Request.Method.GET.equalsIgnoreCase(split[0])) {
                    if ("HTTP/1.1".equalsIgnoreCase(split[2])) {
                        d dVar2 = new d();
                        String str = split[1];
                        if (str != null) {
                            dVar2.f١٦٨٤٠b = str;
                            dVar = dVar2;
                        } else {
                            throw new IllegalArgumentException("http resource descriptor must not be null");
                        }
                    } else {
                        throw new g("Invalid status line received: " + split[2] + " Status line: " + a10);
                    }
                } else {
                    throw new g("Invalid request method received: " + split[0] + " Status line: " + a10);
                }
                String a11 = a(byteBuffer);
                while (a11 != null && a11.length() > 0) {
                    String[] split2 = a11.split(CertificateUtil.DELIMITER, 2);
                    if (split2.length == 2) {
                        if (dVar.f١٦٨٤١a.containsKey(split2[0])) {
                            dVar.f١٦٨٤١a.put(split2[0], dVar.a(split2[0]) + "; " + split2[1].replaceFirst("^ +", ""));
                        } else {
                            dVar.f١٦٨٤١a.put(split2[0], split2[1].replaceFirst("^ +", ""));
                        }
                        a11 = a(byteBuffer);
                    } else {
                        throw new g("not an http header");
                    }
                }
                if (a11 != null) {
                    return dVar;
                }
                throw new e();
            }
            throw new g();
        }
        throw new e(byteBuffer.capacity() + 128);
    }
}
