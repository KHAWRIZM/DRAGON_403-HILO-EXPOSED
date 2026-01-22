package com.opensource.svgaplayer.glideplugin;

import java.io.InputStream;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000eJ\f\u0010\u000f\u001a\u00020\b*\u00020\u0004H\u0002J\f\u0010\u0010\u001a\u00020\u0004*\u00020\bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/opensource/svgaplayer/glideplugin/SVGACacheFileHandler;", "", "()V", "SVGAMark", "", "isSVGAMark", "", "byteArray", "", "readHeadAsSVGA", "stream", "Ljava/io/InputStream;", "writeHead", "", "Ljava/io/OutputStream;", "toByteArray", "toInt", "glideplugin_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class SVGACacheFileHandler {

    @NotNull
    public static final SVGACacheFileHandler INSTANCE = new SVGACacheFileHandler();
    private static final int SVGAMark = 262917615;

    private SVGACacheFileHandler() {
    }

    private final byte[] toByteArray(int i10) {
        int i11;
        byte b10;
        byte[] bArr = new byte[4];
        for (int i12 = 0; i12 < 4; i12++) {
            if (i12 != 0) {
                if (i12 != 1) {
                    if (i12 != 2) {
                        b10 = (byte) i10;
                        bArr[i12] = b10;
                    } else {
                        i11 = i10 >> 8;
                    }
                } else {
                    i11 = i10 >> 16;
                }
            } else {
                i11 = i10 >> 24;
            }
            b10 = (byte) i11;
            bArr[i12] = b10;
        }
        return bArr;
    }

    private final int toInt(byte[] bArr) {
        if (bArr.length >= 4) {
            int i10 = 0;
            for (int i11 = 0; i11 < 4; i11++) {
                i10 += (bArr[i11] & UByte.MAX_VALUE) << ((3 - i11) * 8);
            }
            return i10;
        }
        throw new RuntimeException("this byteArray should be at least 4 bytes");
    }

    public final boolean isSVGAMark(@NotNull byte[] byteArray) {
        Intrinsics.checkNotNullParameter(byteArray, "byteArray");
        if (toInt(byteArray) == SVGAMark) {
            return true;
        }
        return false;
    }

    public final boolean readHeadAsSVGA(@NotNull InputStream stream) {
        Intrinsics.checkNotNullParameter(stream, "stream");
        byte[] bArr = new byte[4];
        stream.read(bArr);
        if (toInt(bArr) == SVGAMark) {
            return true;
        }
        return false;
    }

    public final void writeHead(@NotNull OutputStream stream) {
        Intrinsics.checkNotNullParameter(stream, "stream");
        stream.write(toByteArray(SVGAMark));
    }
}
