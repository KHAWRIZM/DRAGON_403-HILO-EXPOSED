package io.agora.rtc;

import io.agora.rtc.audio.AgoraRhythmPlayerConfig;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public interface IAudioEffectManager {
    int configRhythmPlayer(AgoraRhythmPlayerConfig agoraRhythmPlayerConfig);

    int getEffectCurrentPosition(int i10);

    int getEffectDuration(String str);

    double getEffectsVolume();

    int pauseAllEffects();

    int pauseEffect(int i10);

    @Deprecated
    int playEffect(int i10, String str, int i11, double d10, double d11, double d12);

    @Deprecated
    int playEffect(int i10, String str, int i11, double d10, double d11, double d12, boolean z10);

    int playEffect(int i10, String str, int i11, double d10, double d11, double d12, boolean z10, int i12);

    int preloadEffect(int i10, String str);

    int resumeAllEffects();

    int resumeEffect(int i10);

    int setEffectPosition(int i10, int i11);

    int setEffectsVolume(double d10);

    int setVolumeOfEffect(int i10, double d10);

    int startRhythmPlayer(String str, String str2, AgoraRhythmPlayerConfig agoraRhythmPlayerConfig);

    int stopAllEffects();

    int stopEffect(int i10);

    int stopRhythmPlayer();

    int unloadEffect(int i10);
}
