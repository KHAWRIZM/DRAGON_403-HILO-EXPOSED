package org.apache.commons.sudcompress.archivers.zip;

import java.nio.ByteBuffer;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public interface ZipEncoding {
    boolean canEncode(String str);

    String decode(byte[] bArr);

    ByteBuffer encode(String str);
}
