package com.google.protobuf;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public interface e1 extends f1 {

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public interface a extends f1, Cloneable {
        e1 build();

        e1 buildPartial();

        a mergeFrom(i iVar, v vVar);

        a mergeFrom(byte[] bArr);
    }

    int getSerializedSize();

    a newBuilderForType();

    a toBuilder();

    byte[] toByteArray();

    void writeTo(k kVar);
}
