package d1;

import android.view.View;
import java.nio.ByteBuffer;
import tech.sud.gip.core.GameInfo;
import tech.sud.gip.core.ISudAiAgent;
import tech.sud.gip.core.ISudFSTAPP;
import tech.sud.gip.core.ISudListenerNotifyStateChange;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class d implements ISudFSTAPP {
    public boolean destroyMG() {
        return false;
    }

    public final ISudAiAgent getAiAgent() {
        return null;
    }

    public String getGameState(String str) {
        return null;
    }

    public View getGameView() {
        return null;
    }

    public String getPlayerState(String str, String str2) {
        return null;
    }

    public void pauseMG() {
    }

    public void playMG() {
    }

    public void reloadMG() {
    }

    public void startMG() {
    }

    public void stopMG() {
    }

    public void a(b bVar) {
    }

    public void b(GameInfo gameInfo, String str) {
    }

    public void c(GameInfo gameInfo, String str) {
    }

    public void pushAudio(ByteBuffer byteBuffer, int i10) {
    }

    public void updateCode(String str, ISudListenerNotifyStateChange iSudListenerNotifyStateChange) {
    }

    public void notifyStateChange(String str, String str2, ISudListenerNotifyStateChange iSudListenerNotifyStateChange) {
    }
}
