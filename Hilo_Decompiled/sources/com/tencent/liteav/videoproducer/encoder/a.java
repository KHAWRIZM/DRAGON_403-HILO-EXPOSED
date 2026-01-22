package com.tencent.liteav.videoproducer.encoder;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import android.util.Pair;
import android.util.Range;
import com.qiahao.nextvideo.ui.family.FamilyMoreDialog;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videobase.common.CodecType;
import com.tencent.liteav.videoproducer.encoder.VideoEncoderDef;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import org.json.JSONObject;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class a {
    public boolean a = true;
    public boolean b = true;
    private final MediaCodec c;
    private final String d;
    private final VideoEncodeParams e;
    private Boolean f;

    /* renamed from: com.tencent.liteav.videoproducer.encoder.a$1, reason: invalid class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[VideoEncoderDef.EncoderProfile.values().length];
            b = iArr;
            try {
                iArr[VideoEncoderDef.EncoderProfile.PROFILE_MAIN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[VideoEncoderDef.EncoderProfile.PROFILE_HIGH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[VideoEncoderDef.EncoderProfile.PROFILE_BASELINE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[VideoEncoderDef.BitrateMode.values().length];
            a = iArr2;
            try {
                iArr2[VideoEncoderDef.BitrateMode.CBR.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[VideoEncoderDef.BitrateMode.VBR.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[VideoEncoderDef.BitrateMode.CQ.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public a(MediaCodec mediaCodec, String str, VideoEncodeParams videoEncodeParams, Boolean bool) {
        this.c = mediaCodec;
        this.d = str;
        this.e = videoEncodeParams;
        this.f = bool;
    }

    private void c(MediaFormat mediaFormat, int i, int i2) {
        MediaCodecInfo.VideoCapabilities a;
        if (mediaFormat == null || (a = a(i, i2)) == null) {
            return;
        }
        int widthAlignment = a.getWidthAlignment();
        int heightAlignment = a.getHeightAlignment();
        LiteavLog.i("MediaFormatBuilder", "widthAlignment=%d,heightAlignment=%d", Integer.valueOf(widthAlignment), Integer.valueOf(heightAlignment));
        if (widthAlignment < 2 || heightAlignment < 2 || widthAlignment % 2 != 0 || heightAlignment % 2 != 0) {
            return;
        }
        int integer = mediaFormat.getInteger("width");
        int integer2 = mediaFormat.getInteger("height");
        int i3 = (integer / widthAlignment) * widthAlignment;
        int i4 = (integer2 / heightAlignment) * heightAlignment;
        if (integer == i3 && integer2 == i4) {
            return;
        }
        mediaFormat.setInteger("width", i3);
        mediaFormat.setInteger("height", i4);
        LiteavLog.i("MediaFormatBuilder", "updateMediaFormatWithAlignment,srcSize=(%d x %d),fixSize=(%d x %d),widthAlignment=%d,heightAlignment=%d", Integer.valueOf(integer), Integer.valueOf(integer2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(widthAlignment), Integer.valueOf(heightAlignment));
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00fe  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final MediaFormat a() {
        MediaCodecInfo.CodecCapabilities codecCapabilities;
        MediaCodecInfo.CodecCapabilities createFromProfileLevel;
        JSONObject jSONObject;
        Integer valueOf;
        Object[] objArr;
        MediaCodecInfo.VideoCapabilities videoCapabilities;
        int i;
        int i2;
        MediaCodecInfo.EncoderCapabilities encoderCapabilities;
        int i3;
        int i4;
        int i5;
        int i6;
        Range<Integer> complexityRange;
        MediaFormat b = b();
        if (b == null) {
            return null;
        }
        int codecCount = MediaCodecList.getCodecCount();
        int i7 = 0;
        loop0: while (true) {
            if (i7 >= codecCount) {
                codecCapabilities = null;
                break;
            }
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i7);
            if (codecInfoAt.isEncoder()) {
                for (String str : codecInfoAt.getSupportedTypes()) {
                    if (str.equalsIgnoreCase(this.d)) {
                        codecCapabilities = codecInfoAt.getCapabilitiesForType(this.d);
                        break loop0;
                    }
                }
            }
            i7++;
        }
        if (codecCapabilities != null && LiteavSystemInfo.getSystemOSVersionInt() >= 21) {
            MediaCodecInfo.EncoderCapabilities encoderCapabilities2 = codecCapabilities.getEncoderCapabilities();
            if (encoderCapabilities2 != null && (complexityRange = encoderCapabilities2.getComplexityRange()) != null) {
                b.setInteger("complexity", complexityRange.getUpper().intValue());
            }
            if (this.b) {
                VideoEncodeParams videoEncodeParams = this.e;
                VideoEncoderDef.EncoderProfile encoderProfile = videoEncodeParams.encoderProfile;
                if ((videoEncodeParams.codecType != CodecType.H265 || LiteavSystemInfo.getSystemOSVersionInt() < 21) && encoderProfile != null) {
                    int i8 = AnonymousClass1.b[encoderProfile.ordinal()];
                    if (i8 == 1) {
                        i3 = 2;
                    } else if (i8 == 2) {
                        i3 = 8;
                    }
                    if (this.d.equals("video/avc")) {
                        i4 = Integer.MIN_VALUE;
                        i5 = Integer.MAX_VALUE;
                    } else {
                        i4 = 256;
                        i5 = 32768;
                    }
                    int i9 = 0;
                    int i10 = 0;
                    for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : codecCapabilities.profileLevels) {
                        int i11 = codecProfileLevel.level;
                        if (i11 >= i4 && (i6 = codecProfileLevel.profile) <= i3 && (i6 > i9 || (i6 == i9 && i11 > i10))) {
                            i10 = Math.min(i11, i5);
                            i9 = i6;
                        }
                    }
                    b.setInteger(FamilyMoreDialog.CLICK_PROFILE, i9);
                    if (LiteavSystemInfo.getSystemOSVersionInt() >= 23) {
                        b.setInteger("level", i10);
                    }
                }
                i3 = 1;
                if (this.d.equals("video/avc")) {
                }
                int i92 = 0;
                int i102 = 0;
                while (r10 < r15) {
                }
                b.setInteger(FamilyMoreDialog.CLICK_PROFILE, i92);
                if (LiteavSystemInfo.getSystemOSVersionInt() >= 23) {
                }
            }
            if (this.a) {
                VideoEncoderDef.BitrateMode bitrateMode = this.e.bitrateMode;
                if (bitrateMode != null && (i = AnonymousClass1.a[bitrateMode.ordinal()]) != 1) {
                    if (i == 2) {
                        i2 = 1;
                    } else if (i == 3) {
                        i2 = 0;
                    }
                    encoderCapabilities = codecCapabilities.getEncoderCapabilities();
                    if (encoderCapabilities != null) {
                        if (a(i2, encoderCapabilities)) {
                            b.setInteger("bitrate-mode", i2);
                        } else if (this.e.fullIFrame) {
                            if (a(1, encoderCapabilities)) {
                                b.setInteger("bitrate-mode", 1);
                            } else if (a(2, encoderCapabilities)) {
                                b.setInteger("bitrate-mode", 2);
                            }
                        } else if (a(2, encoderCapabilities)) {
                            b.setInteger("bitrate-mode", 2);
                        }
                    }
                }
                i2 = 2;
                encoderCapabilities = codecCapabilities.getEncoderCapabilities();
                if (encoderCapabilities != null) {
                }
            }
        }
        if (LiteavSystemInfo.getSystemOSVersionInt() < 23) {
            createFromProfileLevel = null;
        } else {
            Pair<Integer, Integer> b2 = b(b);
            createFromProfileLevel = MediaCodecInfo.CodecCapabilities.createFromProfileLevel(this.d, ((Integer) b2.first).intValue(), ((Integer) b2.second).intValue());
        }
        if (createFromProfileLevel != null) {
            codecCapabilities = createFromProfileLevel;
        }
        VideoEncodeParams videoEncodeParams2 = this.e;
        GLConstants.ColorRange colorRange = videoEncodeParams2.colorRange;
        GLConstants.ColorSpace colorSpace = videoEncodeParams2.colorSpace;
        if (LiteavSystemInfo.getSystemOSVersionInt() >= 24) {
            if (colorRange == GLConstants.ColorRange.FULL_RANGE) {
                b.setInteger("color-range", 1);
            } else if (colorRange == GLConstants.ColorRange.VIDEO_RANGE) {
                b.setInteger("color-range", 2);
            }
            if (colorSpace == GLConstants.ColorSpace.BT709) {
                b.setInteger("color-standard", 1);
            } else if (colorSpace == GLConstants.ColorSpace.BT601) {
                b.setInteger("color-standard", 4);
            }
        }
        if (codecCapabilities != null && LiteavSystemInfo.getSystemOSVersionInt() >= 21 && (videoCapabilities = codecCapabilities.getVideoCapabilities()) != null) {
            Range<Integer> bitrateRange = videoCapabilities.getBitrateRange();
            int integer = b.getInteger("bitrate");
            Integer clamp = bitrateRange.clamp(Integer.valueOf(integer));
            int intValue = clamp.intValue();
            LiteavLog.i("MediaFormatBuilder", "bitrateRange=(%d, %d),bitrate=%d,clampBitrate=%d", bitrateRange.getLower(), bitrateRange.getUpper(), Integer.valueOf(integer), clamp);
            if (integer != intValue) {
                b.setInteger("bitrate", intValue);
            }
        }
        a(b);
        if (this.e.mediaCodecDeviceRelatedParams != null) {
            for (int i12 = 0; i12 < this.e.mediaCodecDeviceRelatedParams.length(); i12++) {
                try {
                    jSONObject = this.e.mediaCodecDeviceRelatedParams.getJSONObject(i12);
                    Integer valueOf2 = Integer.valueOf(i12);
                    String optString = jSONObject.optString("key");
                    valueOf = Integer.valueOf(jSONObject.optInt("value"));
                    try {
                        objArr = new Object[3];
                        try {
                            objArr[0] = valueOf2;
                            objArr[1] = optString;
                        } catch (Throwable th) {
                            th = th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        LiteavLog.e("MediaFormatBuilder", "set mediaCodec device related params failed,index=".concat(String.valueOf(i12)), th);
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
                try {
                    objArr[2] = valueOf;
                    LiteavLog.i("MediaFormatBuilder", "setDeviceRelatedParams,index=%d,key=%s,value=%d", objArr);
                    b.setInteger(jSONObject.optString("key"), jSONObject.optInt("value"));
                } catch (Throwable th4) {
                    th = th4;
                    LiteavLog.e("MediaFormatBuilder", "set mediaCodec device related params failed,index=".concat(String.valueOf(i12)), th);
                }
            }
        }
        return b;
    }

    public final MediaFormat b() {
        int i;
        MediaFormat createVideoFormat;
        VideoEncodeParams videoEncodeParams = this.e;
        int i2 = videoEncodeParams.width;
        if (i2 == 0 || (i = videoEncodeParams.height) == 0 || videoEncodeParams.bitrate == 0 || videoEncodeParams.fps == 0 || (createVideoFormat = MediaFormat.createVideoFormat(this.d, i2, i)) == null) {
            return null;
        }
        createVideoFormat.setInteger("bitrate", this.e.bitrate * LockFreeTaskQueueCore.MIN_ADD_SPIN_CAPACITY);
        createVideoFormat.setInteger("frame-rate", this.e.fps);
        createVideoFormat.setInteger("color-format", 2130708361);
        VideoEncodeParams videoEncodeParams2 = this.e;
        createVideoFormat.setInteger("i-frame-interval", videoEncodeParams2.fullIFrame ? 0 : videoEncodeParams2.gop);
        return createVideoFormat;
    }

    private static Pair<Integer, Integer> b(MediaFormat mediaFormat) {
        int i;
        int i2 = 0;
        try {
            i = mediaFormat.getInteger(FamilyMoreDialog.CLICK_PROFILE);
        } catch (Throwable th) {
            LiteavLog.i("MediaFormatBuilder", "get profile fail.", th);
            i = 0;
        }
        try {
            i2 = mediaFormat.getInteger("level");
        } catch (Throwable th2) {
            LiteavLog.i("MediaFormatBuilder", "get level fail.", th2);
        }
        return new Pair<>(Integer.valueOf(i), Integer.valueOf(i2));
    }

    private void b(MediaFormat mediaFormat, int i, int i2) {
        MediaCodecInfo.VideoCapabilities a;
        if (mediaFormat == null || (a = a(i, i2)) == null) {
            return;
        }
        Range<Integer> supportedWidths = a.getSupportedWidths();
        Range<Integer> supportedHeights = a.getSupportedHeights();
        if (supportedWidths == null || supportedHeights == null) {
            return;
        }
        Integer lower = supportedWidths.getLower();
        Integer lower2 = supportedHeights.getLower();
        MediaCodecInfo.VideoCapabilities c = c();
        if (c != null) {
            Range<Integer> supportedWidths2 = c.getSupportedWidths();
            Range<Integer> supportedHeights2 = c.getSupportedHeights();
            if (supportedWidths2 != null && supportedHeights2 != null) {
                lower = Integer.valueOf(Math.max(lower.intValue(), supportedWidths2.getLower().intValue()));
                lower2 = Integer.valueOf(Math.max(lower2.intValue(), supportedHeights2.getLower().intValue()));
            }
        }
        if (lower.intValue() < 0 || lower2.intValue() < 0) {
            return;
        }
        int integer = mediaFormat.getInteger("width");
        int integer2 = mediaFormat.getInteger("height");
        if (lower.intValue() > integer || lower2.intValue() > integer2) {
            float f = integer;
            float f2 = integer2;
            float max = Math.max(lower.intValue() / (f * 1.0f), lower2.intValue() / (1.0f * f2));
            mediaFormat.setInteger("width", (int) (f * max));
            mediaFormat.setInteger("height", (int) (max * f2));
            LiteavLog.i("MediaFormatBuilder", "updateMediaFormatToLowerSize:lowerW=%d,lowerH=%d", lower, lower2);
        }
    }

    private MediaCodecInfo.VideoCapabilities c() {
        MediaCodecInfo.CodecCapabilities capabilitiesForType;
        if (this.c == null || LiteavSystemInfo.getSystemOSVersionInt() < 21 || (capabilitiesForType = this.c.getCodecInfo().getCapabilitiesForType(this.d)) == null) {
            return null;
        }
        return capabilitiesForType.getVideoCapabilities();
    }

    private boolean a(int i, MediaCodecInfo.EncoderCapabilities encoderCapabilities) {
        Boolean bool;
        if (i == 2 && (bool = this.f) != null) {
            return bool.booleanValue();
        }
        return encoderCapabilities.isBitrateModeSupported(i);
    }

    public final void a(MediaFormat mediaFormat) {
        if (mediaFormat != null && LiteavSystemInfo.getSystemOSVersionInt() >= 23) {
            Pair<Integer, Integer> b = b(mediaFormat);
            int intValue = ((Integer) b.first).intValue();
            int intValue2 = ((Integer) b.second).intValue();
            a(mediaFormat, intValue, intValue2);
            b(mediaFormat, intValue, intValue2);
            c(mediaFormat, intValue, intValue2);
        }
    }

    private void a(MediaFormat mediaFormat, int i, int i2) {
        Range<Integer> range;
        Range<Integer> range2;
        Range<Integer> range3;
        if (mediaFormat == null) {
            return;
        }
        MediaCodecInfo.VideoCapabilities a = a(i, i2);
        Range<Integer> range4 = null;
        if (a != null) {
            range2 = a.getSupportedWidths();
            range = a.getSupportedHeights();
        } else {
            range = null;
            range2 = null;
        }
        MediaCodecInfo.VideoCapabilities c = c();
        if (c != null) {
            range4 = c.getSupportedWidths();
            range3 = c.getSupportedHeights();
        } else {
            range3 = null;
        }
        Integer num = Integer.MAX_VALUE;
        Integer num2 = Integer.MAX_VALUE;
        if (range2 != null && range != null) {
            num = range2.getUpper();
            num2 = range.getUpper();
        }
        if (range4 != null && range3 != null) {
            num = Integer.valueOf(Math.min(num.intValue(), range4.getUpper().intValue()));
            num2 = Integer.valueOf(Math.min(num2.intValue(), range3.getUpper().intValue()));
        }
        if (num.intValue() != Integer.MAX_VALUE && num2.intValue() != Integer.MAX_VALUE) {
            int integer = mediaFormat.getInteger("width");
            int integer2 = mediaFormat.getInteger("height");
            if ((integer > integer2 && num.intValue() < num2.intValue()) || (integer < integer2 && num.intValue() > num2.intValue())) {
                Integer num3 = num2;
                num2 = num;
                num = num3;
            }
            if (num.intValue() < integer || num2.intValue() < integer2) {
                float f = integer;
                float f2 = integer2;
                float min = Math.min(num.intValue() / (f * 1.0f), num2.intValue() / (1.0f * f2));
                mediaFormat.setInteger("width", (int) (f * min));
                mediaFormat.setInteger("height", (int) (f2 * min));
                LiteavLog.i("MediaFormatBuilder", "updateMediaFormatToUpperSize:srcWidth=" + integer + ", srcHeight=" + integer2 + ", scale: " + min + ", supportedWidthsByProfile= " + range2 + ", supportedHeightsByProfile=" + range + ", supportedWidthsByType=" + range4 + ", supportedHeightsByType=" + range3);
                return;
            }
            return;
        }
        LiteavLog.w("MediaFormatBuilder", "get supported size failed");
    }

    private MediaCodecInfo.VideoCapabilities a(int i, int i2) {
        MediaCodecInfo.CodecCapabilities createFromProfileLevel;
        if (LiteavSystemInfo.getSystemOSVersionInt() >= 21 && (createFromProfileLevel = MediaCodecInfo.CodecCapabilities.createFromProfileLevel(this.d, i, i2)) != null) {
            return createFromProfileLevel.getVideoCapabilities();
        }
        return null;
    }
}
