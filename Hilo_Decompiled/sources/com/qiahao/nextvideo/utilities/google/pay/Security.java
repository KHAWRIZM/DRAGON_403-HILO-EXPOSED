package com.qiahao.nextvideo.utilities.google.pay;

import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.tencent.qcloud.tuicore.TUIConstants;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0005H\u0002J \u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/qiahao/nextvideo/utilities/google/pay/Security;", "", "<init>", "()V", "TAG", "", "KEY_FACTORY_ALGORITHM", "SIGNATURE_ALGORITHM", "BASE_64_ENCODED_PUBLIC_KEY", "getBASE_64_ENCODED_PUBLIC_KEY", "()Ljava/lang/String;", "verifyPurchase", "", "base64PublicKey", "signedData", TUIConstants.TUICalling.PARAM_NAME_AUDIO_SIGNATURE, "generatePublicKey", "Ljava/security/PublicKey;", "encodedPublicKey", "verify", "publicKey", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class Security {

    @NotNull
    private static final String KEY_FACTORY_ALGORITHM = "RSA";

    @NotNull
    private static final String SIGNATURE_ALGORITHM = "SHA1withRSA";

    @NotNull
    private static final String TAG = "IABUtil/Security";

    @NotNull
    public static final Security INSTANCE = new Security();

    @NotNull
    private static final String BASE_64_ENCODED_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAiLAWRdtycfetnZw9ai6VkpLkjPGQKjR+0zggodOGOb0wYKyfhQFRpXv3gobrtuj+JJ6JAld7uce0F+6FnIw/WG3UsQsXb1N0X50ppw9W/gVfKpD7H6/JLkrLa+GE4tVU3KpobHjEMqY8uHTOVW0Vmy3xEobILlf8Hf9bey3EmJMaR5vjZ75fbhCLz1rFJYzlyHgXWOej9hL5lshrrOnz8dbV0F+xsz5KsTgvOASala1isaWAMxuGEBzmD95cBYLOBK8FB4H1a7u7WS2HjpR3WJsK9y4BmCQjw7cH0ticQ2O+9HrwGvmY15WLg4/5pRyUIgNd1/XSRYF0VmDS/Z4a8wIDAQAB";

    private Security() {
    }

    private final PublicKey generatePublicKey(String encodedPublicKey) throws IOException {
        try {
            PublicKey generatePublic = KeyFactory.getInstance(KEY_FACTORY_ALGORITHM).generatePublic(new X509EncodedKeySpec(Base64.decode(encodedPublicKey, 0)));
            Intrinsics.checkNotNullExpressionValue(generatePublic, "generatePublic(...)");
            return generatePublic;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (InvalidKeySpecException e2) {
            String str = "Invalid key specification: " + e2;
            Log.w(TAG, str);
            throw new IOException(str);
        }
    }

    private final boolean verify(PublicKey publicKey, String signedData, String signature) {
        try {
            byte[] decode = Base64.decode(signature, 0);
            try {
                Signature signature2 = Signature.getInstance(SIGNATURE_ALGORITHM);
                signature2.initVerify(publicKey);
                byte[] bytes = signedData.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                signature2.update(bytes);
                if (!signature2.verify(decode)) {
                    Log.w(TAG, "Signature verification failed...");
                    return false;
                }
                return true;
            } catch (InvalidKeyException unused) {
                Log.w(TAG, "Invalid key specification.");
                return false;
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            } catch (SignatureException unused2) {
                Log.w(TAG, "Signature exception.");
                return false;
            }
        } catch (IllegalArgumentException unused3) {
            Log.w(TAG, "Base64 decoding failed.");
            return false;
        }
    }

    @NotNull
    public final String getBASE_64_ENCODED_PUBLIC_KEY() {
        return BASE_64_ENCODED_PUBLIC_KEY;
    }

    public final boolean verifyPurchase(@NotNull String base64PublicKey, @NotNull String signedData, @NotNull String signature) throws IOException {
        Intrinsics.checkNotNullParameter(base64PublicKey, "base64PublicKey");
        Intrinsics.checkNotNullParameter(signedData, "signedData");
        Intrinsics.checkNotNullParameter(signature, TUIConstants.TUICalling.PARAM_NAME_AUDIO_SIGNATURE);
        if (!TextUtils.isEmpty(signedData) && !TextUtils.isEmpty(base64PublicKey) && !TextUtils.isEmpty(signature)) {
            return verify(generatePublicKey(base64PublicKey), signedData, signature);
        }
        Log.w(TAG, "Purchase verification failed: missing data.");
        return false;
    }
}
