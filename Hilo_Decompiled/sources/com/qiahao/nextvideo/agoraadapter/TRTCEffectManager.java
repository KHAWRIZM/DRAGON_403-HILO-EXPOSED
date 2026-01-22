package com.qiahao.nextvideo.agoraadapter;

import com.tencent.liteav.audio.TXAudioEffectManager;
import com.tencent.trtc.TRTCCloud;
import io.agora.rtc.IAudioEffectManager;
import io.agora.rtc.audio.AgoraRhythmPlayerConfig;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class TRTCEffectManager implements IAudioEffectManager {
    private Set<Integer> mEffectIdSet = new HashSet();
    private double mEffectsVolume;
    private TXAudioEffectManager.TXMusicPlayObserver mMusicPlayObserver;
    private TRTCCloud mTRTCCloud;

    public TRTCEffectManager(TRTCCloud tRTCCloud) {
        this.mTRTCCloud = tRTCCloud;
    }

    private void playAudioEffect(int i, String str, int i2, boolean z, double d, int i3) {
        if (this.mTRTCCloud != null) {
            TXAudioEffectManager.AudioMusicParam audioMusicParam = new TXAudioEffectManager.AudioMusicParam(i, str);
            audioMusicParam.loopCount = i2;
            audioMusicParam.publish = z;
            audioMusicParam.isShortFile = true;
            audioMusicParam.startTimeMS = i3;
            if (this.mMusicPlayObserver != null) {
                this.mTRTCCloud.getAudioEffectManager().setMusicObserver(i, this.mMusicPlayObserver);
            }
            this.mTRTCCloud.getAudioEffectManager().startPlayMusic(audioMusicParam);
            this.mEffectIdSet.add(Integer.valueOf(i));
        }
    }

    private void setAllAudioEffectsVolume(int i) {
        this.mEffectsVolume = i;
        TRTCCloud tRTCCloud = this.mTRTCCloud;
        if (tRTCCloud != null) {
            tRTCCloud.getAudioEffectManager().setAllMusicVolume(i);
        }
    }

    private void setAudioEffectVolume(int i, int i2) {
        TRTCCloud tRTCCloud = this.mTRTCCloud;
        if (tRTCCloud != null) {
            tRTCCloud.getAudioEffectManager().setMusicPublishVolume(i, i2);
            this.mTRTCCloud.getAudioEffectManager().setMusicPlayoutVolume(i, i2);
        }
    }

    private void stopAllAudioEffects() {
        if (this.mTRTCCloud != null) {
            Iterator<Integer> it = this.mEffectIdSet.iterator();
            while (it.hasNext()) {
                this.mTRTCCloud.getAudioEffectManager().stopPlayMusic(it.next().intValue());
            }
            this.mEffectIdSet.clear();
        }
    }

    private void stopAudioEffect(int i) {
        TRTCCloud tRTCCloud = this.mTRTCCloud;
        if (tRTCCloud != null) {
            tRTCCloud.getAudioEffectManager().stopPlayMusic(i);
            this.mEffectIdSet.remove(Integer.valueOf(i));
        }
    }

    public int configRhythmPlayer(AgoraRhythmPlayerConfig agoraRhythmPlayerConfig) {
        return 0;
    }

    public void destroy() {
        stopAllAudioEffects();
    }

    public int getEffectCurrentPosition(int i) {
        TRTCCloud tRTCCloud = this.mTRTCCloud;
        if (tRTCCloud != null) {
            return (int) tRTCCloud.getAudioEffectManager().getMusicCurrentPosInMS(i);
        }
        return 0;
    }

    public int getEffectDuration(String str) {
        TRTCCloud tRTCCloud = this.mTRTCCloud;
        if (tRTCCloud != null) {
            return (int) tRTCCloud.getAudioEffectManager().getMusicDurationInMS(str);
        }
        return 0;
    }

    public double getEffectsVolume() {
        return this.mEffectsVolume;
    }

    public int pauseAllEffects() {
        if (this.mTRTCCloud != null) {
            Iterator<Integer> it = this.mEffectIdSet.iterator();
            while (it.hasNext()) {
                this.mTRTCCloud.getAudioEffectManager().pausePlayMusic(it.next().intValue());
            }
            return 0;
        }
        return 0;
    }

    public int pauseEffect(int i) {
        TRTCCloud tRTCCloud = this.mTRTCCloud;
        if (tRTCCloud != null) {
            tRTCCloud.getAudioEffectManager().pausePlayMusic(i);
            return 0;
        }
        return 0;
    }

    public int playEffect(int i, String str, int i2, double d, double d2, double d3) {
        playAudioEffect(i, str, i2, true, d3, 0);
        return 0;
    }

    public int preloadEffect(int i, String str) {
        return 0;
    }

    public int resumeAllEffects() {
        if (this.mTRTCCloud != null) {
            Iterator<Integer> it = this.mEffectIdSet.iterator();
            while (it.hasNext()) {
                this.mTRTCCloud.getAudioEffectManager().resumePlayMusic(it.next().intValue());
            }
            return 0;
        }
        return 0;
    }

    public int resumeEffect(int i) {
        TRTCCloud tRTCCloud = this.mTRTCCloud;
        if (tRTCCloud != null) {
            tRTCCloud.getAudioEffectManager().resumePlayMusic(i);
            return 0;
        }
        return 0;
    }

    public int setEffectPosition(int i, int i2) {
        TRTCCloud tRTCCloud = this.mTRTCCloud;
        if (tRTCCloud != null) {
            tRTCCloud.getAudioEffectManager().seekMusicToPosInMS(i, i2);
            return 0;
        }
        return 0;
    }

    public int setEffectsVolume(double d) {
        setAllAudioEffectsVolume((int) d);
        return 0;
    }

    public void setMusicObserver(TXAudioEffectManager.TXMusicPlayObserver tXMusicPlayObserver) {
        this.mMusicPlayObserver = tXMusicPlayObserver;
    }

    public int setVolumeOfEffect(int i, double d) {
        setAudioEffectVolume(i, (int) d);
        return 0;
    }

    public int startRhythmPlayer(String str, String str2, AgoraRhythmPlayerConfig agoraRhythmPlayerConfig) {
        return 0;
    }

    public int stopAllEffects() {
        stopAllAudioEffects();
        return 0;
    }

    public int stopEffect(int i) {
        stopAudioEffect(i);
        return 0;
    }

    public int stopRhythmPlayer() {
        return 0;
    }

    public int unloadEffect(int i) {
        return 0;
    }

    public int playEffect(int i, String str, int i2, double d, double d2, double d3, boolean z) {
        playAudioEffect(i, str, i2, z, d3, 0);
        return 0;
    }

    public int playEffect(int i, String str, int i2, double d, double d2, double d3, boolean z, int i3) {
        playAudioEffect(i, str, i2, z, d3, i3);
        return 0;
    }
}
