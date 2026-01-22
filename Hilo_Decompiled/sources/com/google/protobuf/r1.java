package com.google.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public interface r1 {
    Object parseDelimitedFrom(InputStream inputStream);

    Object parseDelimitedFrom(InputStream inputStream, v vVar);

    Object parseFrom(h hVar);

    Object parseFrom(h hVar, v vVar);

    Object parseFrom(i iVar);

    Object parseFrom(i iVar, v vVar);

    Object parseFrom(InputStream inputStream);

    Object parseFrom(InputStream inputStream, v vVar);

    Object parseFrom(ByteBuffer byteBuffer);

    Object parseFrom(ByteBuffer byteBuffer, v vVar);

    Object parseFrom(byte[] bArr);

    Object parseFrom(byte[] bArr, v vVar);

    Object parsePartialFrom(i iVar, v vVar);
}
