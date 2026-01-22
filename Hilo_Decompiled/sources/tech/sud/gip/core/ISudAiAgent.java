package tech.sud.gip.core;

import java.nio.ByteBuffer;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public interface ISudAiAgent {
    void pauseAudio();

    void pushAudio(ByteBuffer byteBuffer, int i);

    void sendText(String str);

    void setISudListenerAiAgent(ISudListenerAiAgent iSudListenerAiAgent);

    void stopAudio();
}
