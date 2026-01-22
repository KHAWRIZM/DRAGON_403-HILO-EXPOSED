package com.google.protobuf;

import com.google.protobuf.n;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public interface g1 extends f1 {
    Map getAllFields();

    @Override // com.google.protobuf.f1
    b1 getDefaultInstanceForType();

    n.b getDescriptorForType();

    Object getField(n.g gVar);

    k2 getUnknownFields();

    boolean hasField(n.g gVar);
}
