package roomMessage;

import com.google.protobuf.i2;
import com.google.protobuf.k0;
import com.google.protobuf.v;
import java.io.IOException;
import roomMessage.RoomMessage;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public final class k extends com.google.protobuf.c {
    public final Object parsePartialFrom(com.google.protobuf.i iVar, v vVar) {
        RoomMessage.TextElemContentAt.Builder newBuilder = RoomMessage.TextElemContentAt.newBuilder();
        try {
            newBuilder.m٩٣٣mergeFrom(iVar, vVar);
            return newBuilder.m٩١٢buildPartial();
        } catch (IOException e) {
            throw new k0(e).j(newBuilder.m٩١٢buildPartial());
        } catch (i2 e2) {
            throw e2.a().j(newBuilder.m٩١٢buildPartial());
        } catch (k0 e3) {
            throw e3.j(newBuilder.m٩١٢buildPartial());
        }
    }
}
