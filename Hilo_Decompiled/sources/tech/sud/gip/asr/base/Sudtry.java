package tech.sud.gip.asr.base;

import java.nio.ByteBuffer;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public interface Sudtry {
    void handleGameASR(String str);

    void pushAudio(ByteBuffer byteBuffer, int i);

    void stopASR(boolean z);
}
