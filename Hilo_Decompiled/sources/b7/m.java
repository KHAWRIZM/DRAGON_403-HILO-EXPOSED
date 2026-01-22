package b7;

import com.google.firebase.encoders.proto.ProtobufEncoder;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class m {

    /* renamed from: a, reason: collision with root package name */
    private static final ProtobufEncoder f٥٥٢٤a = ProtobufEncoder.builder().configureWith(a.f٥٤٤٨a).build();

    public static byte[] a(Object obj) {
        return f٥٥٢٤a.encode(obj);
    }
}
