package com.qiahao.base_common.utils;

import android.media.MediaDrm;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0003\u001a\b\u0010\u0000\u001a\u0004\u0018\u00010\u0001\u001a\n\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0002\u001a\u0010\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0010\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0001H\u0002¨\u0006\b"}, d2 = {"generateImmutableDeviceId", "", "getHardwareUniqueId", "bytesToHex", "bytes", "", "hashSha256", "input", "base_common_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class GenerateImmutableDeviceIdKt {
    private static final String bytesToHex(byte[] bArr) {
        return ArraysKt.joinToString$default(bArr, (CharSequence) "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.qiahao.base_common.utils.j
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                CharSequence bytesToHex$lambda$1;
                bytesToHex$lambda$1 = GenerateImmutableDeviceIdKt.bytesToHex$lambda$1(((Byte) obj).byteValue());
                return bytesToHex$lambda$1;
            }
        }, 30, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence bytesToHex$lambda$1(byte b10) {
        String format = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b10)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }

    @Nullable
    public static final String generateImmutableDeviceId() {
        return getHardwareUniqueId();
    }

    private static final String getHardwareUniqueId() {
        try {
            MediaDrm mediaDrm = new MediaDrm(UUID.fromString("edef8ba9-79d6-4ace-a3c8-27dcd51d21ed"));
            try {
                byte[] propertyByteArray = mediaDrm.getPropertyByteArray("deviceUniqueId");
                Intrinsics.checkNotNullExpressionValue(propertyByteArray, "getPropertyByteArray(...)");
                String bytesToHex = bytesToHex(propertyByteArray);
                AutoCloseableKt.closeFinally(mediaDrm, null);
                return bytesToHex;
            } finally {
            }
        } catch (Exception unused) {
            return null;
        }
    }

    private static final String hashSha256(String str) {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        byte[] bytes = str.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        byte[] digest = messageDigest.digest(bytes);
        Intrinsics.checkNotNullExpressionValue(digest, "digest(...)");
        return bytesToHex(digest);
    }
}
