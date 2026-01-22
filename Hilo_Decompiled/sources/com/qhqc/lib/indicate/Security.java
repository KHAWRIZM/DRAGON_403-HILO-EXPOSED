package com.qhqc.lib.indicate;

import android.util.Base64;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferTable;
import com.amazonaws.services.s3.internal.crypto.JceEncryptionConstants;
import java.nio.charset.Charset;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/qhqc/lib/indicate/Security;", "", "<init>", "()V", "PUBLIC_KEY", "", "PUBLIC_KEY_HV", "encryptToken", "content", TransferTable.COLUMN_KEY, "keyHv", "lib_deviceIndicate_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSecurity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Security.kt\ncom/qhqc/lib/indicate/Security\n+ 2 Strings.kt\nkotlin/text/StringsKt__StringsKt\n*L\n1#1,39:1\n108#2:40\n80#2,22:41\n*S KotlinDebug\n*F\n+ 1 Security.kt\ncom/qhqc/lib/indicate/Security\n*L\n33#1:40\n33#1:41,22\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class Security {

    @NotNull
    public static final Security INSTANCE = new Security();

    @NotNull
    private static final String PUBLIC_KEY = "hilo!@#$%^&*()_+";

    @NotNull
    private static final String PUBLIC_KEY_HV = "hilo!@#$%^&*()_+";

    private Security() {
    }

    public static /* synthetic */ String encryptToken$default(Security security, String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = "hilo!@#$%^&*()_+";
        }
        if ((i10 & 4) != 0) {
            str3 = "hilo!@#$%^&*()_+";
        }
        return security.encryptToken(str, str2, str3);
    }

    @Nullable
    public final String encryptToken(@Nullable String content, @NotNull String key, @NotNull String keyHv) {
        int i10;
        boolean z10;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(keyHv, "keyHv");
        if (content != null && content.length() != 0) {
            try {
                Charset charset = Charsets.UTF_8;
                byte[] bytes = key.getBytes(charset);
                Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                SecretKeySpec secretKeySpec = new SecretKeySpec(bytes, JceEncryptionConstants.SYMMETRIC_KEY_ALGORITHM);
                Cipher cipher = Cipher.getInstance(JceEncryptionConstants.SYMMETRIC_CIPHER_METHOD);
                byte[] bytes2 = keyHv.getBytes(charset);
                Intrinsics.checkNotNullExpressionValue(bytes2, "getBytes(...)");
                cipher.init(1, secretKeySpec, new IvParameterSpec(bytes2));
                byte[] bytes3 = content.getBytes(charset);
                Intrinsics.checkNotNullExpressionValue(bytes3, "getBytes(...)");
                String encodeToString = Base64.encodeToString(cipher.doFinal(bytes3), 0);
                Intrinsics.checkNotNullExpressionValue(encodeToString, "encodeToString(...)");
                int length = encodeToString.length() - 1;
                int i11 = 0;
                boolean z11 = false;
                while (i11 <= length) {
                    if (!z11) {
                        i10 = i11;
                    } else {
                        i10 = length;
                    }
                    if (Intrinsics.compare((int) encodeToString.charAt(i10), 32) <= 0) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    if (!z11) {
                        if (!z10) {
                            z11 = true;
                        } else {
                            i11++;
                        }
                    } else {
                        if (!z10) {
                            break;
                        }
                        length--;
                    }
                }
                return encodeToString.subSequence(i11, length + 1).toString();
            } catch (Exception unused) {
            }
        }
        return null;
    }
}
