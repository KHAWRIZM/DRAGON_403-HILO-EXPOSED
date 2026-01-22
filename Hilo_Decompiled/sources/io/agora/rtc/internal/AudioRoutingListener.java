package io.agora.rtc.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public interface AudioRoutingListener {
    void onAudioBtProfileChanged(int i10);

    void onAudioRoutingChanged(int i10);

    void onAudioRoutingDestroyed();

    void onAudioRoutingError(int i10);
}
