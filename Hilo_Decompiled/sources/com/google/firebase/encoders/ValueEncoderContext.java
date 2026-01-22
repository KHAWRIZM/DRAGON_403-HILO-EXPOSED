package com.google.firebase.encoders;

import java.io.IOException;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public interface ValueEncoderContext {
    ValueEncoderContext add(double d10) throws IOException;

    ValueEncoderContext add(float f10) throws IOException;

    ValueEncoderContext add(int i10) throws IOException;

    ValueEncoderContext add(long j10) throws IOException;

    ValueEncoderContext add(String str) throws IOException;

    ValueEncoderContext add(boolean z10) throws IOException;

    ValueEncoderContext add(byte[] bArr) throws IOException;
}
