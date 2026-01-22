package t4;

import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class c implements m4.d {
    @Override // m4.d
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public boolean encode(ByteBuffer byteBuffer, File file, m4.i iVar) {
        try {
            f5.a.f(byteBuffer, file);
            return true;
        } catch (IOException e10) {
            if (Log.isLoggable("ByteBufferEncoder", 3)) {
                Log.d("ByteBufferEncoder", "Failed to write data", e10);
            }
            return false;
        }
    }
}
