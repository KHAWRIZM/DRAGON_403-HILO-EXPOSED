package com.tencent.liteav.videoconsumer.decoder;

import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.util.h;
import java.nio.ByteBuffer;

@JNINamespace("liteav::video")
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class SpsInfo {
    public int width = 0;
    public int height = 0;
    public Integer videoFormat = null;
    public Integer videoFullRangeFlag = null;
    public Integer colourPrimaries = null;
    public Integer transferCharacteristics = null;
    public Integer matrixCoefficients = null;
    public Integer maxNumRefFrames = null;

    public static native SpsInfo nativeDecodeSps(boolean z, ByteBuffer byteBuffer);

    public static native byte[] nativeGetSpsPps(byte[] bArr, boolean z, boolean z2);

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SpsInfo)) {
            return false;
        }
        SpsInfo spsInfo = (SpsInfo) obj;
        if (spsInfo.width == this.width && spsInfo.height == this.height && h.a(this.videoFormat, spsInfo.videoFormat) && h.a(this.videoFullRangeFlag, spsInfo.videoFullRangeFlag) && h.a(this.colourPrimaries, spsInfo.colourPrimaries) && h.a(this.transferCharacteristics, spsInfo.transferCharacteristics) && h.a(this.matrixCoefficients, spsInfo.matrixCoefficients) && h.a(this.maxNumRefFrames, spsInfo.maxNumRefFrames)) {
            return true;
        }
        return false;
    }

    public void set(SpsInfo spsInfo) {
        if (spsInfo == null) {
            spsInfo = new SpsInfo();
        }
        this.width = spsInfo.width;
        this.height = spsInfo.height;
        this.videoFormat = spsInfo.videoFormat;
        this.videoFullRangeFlag = spsInfo.videoFullRangeFlag;
        this.colourPrimaries = spsInfo.colourPrimaries;
        this.transferCharacteristics = spsInfo.transferCharacteristics;
        this.matrixCoefficients = spsInfo.matrixCoefficients;
        this.maxNumRefFrames = spsInfo.maxNumRefFrames;
    }

    public void setColourPrimaries(int i) {
        this.colourPrimaries = Integer.valueOf(i);
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public void setMatrixCoefficients(int i) {
        this.matrixCoefficients = Integer.valueOf(i);
    }

    public void setMaxNumRefFrames(int i) {
        this.maxNumRefFrames = Integer.valueOf(i);
    }

    public void setTransferCharacteristics(int i) {
        this.transferCharacteristics = Integer.valueOf(i);
    }

    public void setVideoFormat(int i) {
        this.videoFormat = Integer.valueOf(i);
    }

    public void setVideoFullRangeFlag(int i) {
        this.videoFullRangeFlag = Integer.valueOf(i);
    }

    public void setWidth(int i) {
        this.width = i;
    }

    public String toString() {
        return "SpsInfo(" + ("width=" + this.width + ",height=" + this.height + ",videoFormat=" + this.videoFormat + ",videoFullRangeFlag=" + this.videoFullRangeFlag + ",colourPrimaries=" + this.colourPrimaries + ",transferCharacteristics=" + this.transferCharacteristics + ",matrixCoefficients=" + this.matrixCoefficients + ",maxNumRefFrames=" + this.maxNumRefFrames) + ")";
    }
}
