package com.tencent.liteav.videoproducer.encoder;

import android.media.MediaFormat;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.videobase.common.CodecType;
import com.tencent.liteav.videobase.common.EncodedVideoFrame;
import com.tencent.liteav.videobase.videobase.e;
import okhttp3.internal.http2.Settings;

@JNINamespace("liteav::video")
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public interface VideoEncoderDef {

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public enum BitrateMode {
        UNKNOWN(-1),
        CBR(0),
        VBR(1),
        CQ(2);

        private static final BitrateMode[] e = values();
        public int mValue;

        BitrateMode(int i) {
            this.mValue = i;
        }

        public static BitrateMode a(int i) {
            for (BitrateMode bitrateMode : e) {
                if (i == bitrateMode.mValue) {
                    return bitrateMode;
                }
            }
            return VBR;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public static class EncodeAbility {
        public boolean a;
        public boolean b;
        public boolean c;
        public boolean d;

        public boolean isSupportHwHEVC() {
            return this.d;
        }

        public boolean isSupportRPS() {
            return this.a;
        }

        public boolean isSupportSVC() {
            return this.b;
        }

        public boolean isSupportSwHEVC() {
            return this.c;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public enum EncodeScene {
        kCameraRealTime(0),
        kScreenRealTime(1);

        int mValue;

        EncodeScene(int i) {
            this.mValue = i;
        }

        public static EncodeScene a(int i) {
            for (EncodeScene encodeScene : values()) {
                if (encodeScene.mValue == i) {
                    return encodeScene;
                }
            }
            return kCameraRealTime;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public enum EncoderComplexity {
        UNKNOWN(Settings.DEFAULT_INITIAL_WINDOW_SIZE),
        HYPER_FAST(0),
        ULTRA_FAST(1),
        SUPER_FAST(2),
        VERY_FAST(3),
        FAST(4);

        final int mValue;

        EncoderComplexity(int i) {
            this.mValue = i;
        }

        public static EncoderComplexity a(int i) {
            for (EncoderComplexity encoderComplexity : values()) {
                if (encoderComplexity.mValue == i) {
                    return encoderComplexity;
                }
            }
            return UNKNOWN;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public enum EncoderProfile {
        PROFILE_BASELINE(1),
        PROFILE_MAIN(2),
        PROFILE_HIGH(3),
        PROFILE_BASELINERPS(11),
        PROFILE_MAINRPS(12),
        PROFILE_HIGHRPS(13);

        private static final EncoderProfile[] g = values();
        int mValue;

        EncoderProfile(int i) {
            this.mValue = i;
        }

        public static EncoderProfile a(int i) {
            for (EncoderProfile encoderProfile : g) {
                if (i == encoderProfile.mValue) {
                    return encoderProfile;
                }
            }
            return PROFILE_BASELINE;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public static class EncoderProperty {
        public a a;
        public ReferenceStrategy b;
        public CodecType c;

        public int getCodecType() {
            return this.c.mValue;
        }

        public int getEncoderType() {
            return this.a.value;
        }

        public int getReferenceStrategy() {
            return this.b.mValue;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public enum ReferenceStrategy {
        FIX_GOP(0),
        RPS(1),
        SVC(2),
        UNLIMITED_GOP(3);

        private static final ReferenceStrategy[] e = values();
        int mValue;

        ReferenceStrategy(int i) {
            this.mValue = i;
        }

        public static ReferenceStrategy a(int i) {
            for (ReferenceStrategy referenceStrategy : e) {
                if (i == referenceStrategy.mValue) {
                    return referenceStrategy;
                }
            }
            return FIX_GOP;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public enum a {
        HARDWARE(1),
        SOFTWARE(2);

        int value;

        a(int i) {
            this.value = i;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public static abstract class b {
        public void onBitrateModeUpdated(BitrateMode bitrateMode) {
        }

        public void onEncodedFail(e.a aVar) {
        }

        public void onEncodedNAL(EncodedVideoFrame encodedVideoFrame, boolean z) {
        }

        public void onOutputFormatChanged(MediaFormat mediaFormat) {
        }
    }
}
