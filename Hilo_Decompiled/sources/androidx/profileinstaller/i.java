package androidx.profileinstaller;

import com.facebook.internal.security.CertificateUtil;
import java.util.Arrays;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class i {

    /* renamed from: a, reason: collision with root package name */
    static final byte[] f٤٠٢٢a = {48, 49, 53, 0};

    /* renamed from: b, reason: collision with root package name */
    static final byte[] f٤٠٢٣b = {48, 49, 48, 0};

    /* renamed from: c, reason: collision with root package name */
    static final byte[] f٤٠٢٤c = {48, 48, 57, 0};

    /* renamed from: d, reason: collision with root package name */
    static final byte[] f٤٠٢٥d = {48, 48, 53, 0};

    /* renamed from: e, reason: collision with root package name */
    static final byte[] f٤٠٢٦e = {48, 48, 49, 0};

    /* renamed from: f, reason: collision with root package name */
    static final byte[] f٤٠٢٧f = {48, 48, 49, 0};

    /* renamed from: g, reason: collision with root package name */
    static final byte[] f٤٠٢٨g = {48, 48, 50, 0};

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(byte[] bArr) {
        if (Arrays.equals(bArr, f٤٠٢٦e) || Arrays.equals(bArr, f٤٠٢٥d)) {
            return CertificateUtil.DELIMITER;
        }
        return "!";
    }
}
