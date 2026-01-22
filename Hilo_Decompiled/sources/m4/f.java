package m4;

import java.nio.charset.Charset;
import java.security.MessageDigest;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public interface f {

    /* renamed from: a, reason: collision with root package name */
    public static final Charset f١٥٩٧٢a = Charset.forName("UTF-8");

    boolean equals(Object obj);

    int hashCode();

    void updateDiskCacheKey(MessageDigest messageDigest);
}
