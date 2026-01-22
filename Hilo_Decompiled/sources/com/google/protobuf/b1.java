package com.google.protobuf;

import com.google.protobuf.e1;
import com.google.protobuf.n;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public interface b1 extends e1, g1 {

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public interface a extends e1.a, g1 {
        a addRepeatedField(n.g gVar, Object obj);

        @Override // com.google.protobuf.e1.a
        b1 build();

        @Override // com.google.protobuf.e1.a
        b1 buildPartial();

        @Override // com.google.protobuf.g1
        n.b getDescriptorForType();

        a getFieldBuilder(n.g gVar);

        a mergeFrom(b1 b1Var);

        /* renamed from: mergeFrom */
        a m٤٥٠mergeFrom(h hVar);

        a newBuilderForField(n.g gVar);

        a setField(n.g gVar, Object obj);

        a setUnknownFields(k2 k2Var);
    }

    @Override // com.google.protobuf.e1
    a newBuilderForType();

    @Override // com.google.protobuf.e1
    a toBuilder();
}
