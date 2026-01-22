package org.apache.commons.sudcompress.archivers.zip;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteOrder;
import k0.l;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
class BitStream extends l {
    public BitStream(InputStream inputStream) {
        super(inputStream, ByteOrder.LITTLE_ENDIAN);
    }

    public int nextBit() {
        return (int) readBits(1);
    }

    public long nextBits(int i) {
        if (i >= 0 && i <= 8) {
            return readBits(i);
        }
        throw new IOException("Trying to read " + i + " bits, at most 8 are allowed");
    }

    public int nextByte() {
        return (int) readBits(8);
    }
}
