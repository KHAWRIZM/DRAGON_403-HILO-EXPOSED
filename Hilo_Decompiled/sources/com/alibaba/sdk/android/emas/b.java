package com.alibaba.sdk.android.emas;

import android.os.Build;
import android.security.keystore.KeyGenParameterSpec;
import android.util.Log;
import com.alibaba.sdk.android.tbrest.utils.LogUtil;
import com.amazonaws.services.s3.internal.crypto.JceEncryptionConstants;
import com.google.android.gms.stats.CodePackage;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.GCMParameterSpec;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
class b {

    /* renamed from: a, reason: collision with root package name */
    private static final b f٦٣٩٩a = new b();

    /* renamed from: a, reason: collision with other field name */
    private KeyStore f٨a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f٦٤٠٠b;

    private b() {
        this.f٦٤٠٠b = true;
        try {
            m٢٥٠a();
            if (Build.VERSION.SDK_INT >= 23) {
                a(m٢٤٩a());
            }
        } catch (Throwable unused) {
            this.f٦٤٠٠b = false;
        }
    }

    public static b a() {
        return f٦٣٩٩a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] b(byte[] bArr) {
        if (!this.f٦٤٠٠b) {
            return null;
        }
        try {
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            cipher.init(2, this.f٨a.getKey("emas_rest_key", null), new GCMParameterSpec(128, bArr, 0, 12));
            byte[] bArr2 = new byte[cipher.getOutputSize(bArr.length - 12)];
            cipher.doFinal(bArr, 12, bArr.length - 12, bArr2, 0);
            return bArr2;
        } catch (InvalidAlgorithmParameterException | InvalidKeyException | KeyStoreException | NoSuchAlgorithmException | UnrecoverableKeyException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException | ShortBufferException e10) {
            LogUtil.e(Log.getStackTraceString(e10));
            return null;
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    private void m٢٥٠a() {
        try {
            KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
            this.f٨a = keyStore;
            keyStore.load(null);
        } catch (IOException | KeyStoreException | NoSuchAlgorithmException | CertificateException e10) {
            LogUtil.e(Log.getStackTraceString(e10));
            this.f٦٤٠٠b = false;
        }
    }

    private void a(Key key) {
        try {
            if (this.f٨a.containsAlias("emas_rest_key")) {
                return;
            }
            this.f٨a.setKeyEntry("emas_rest_key", key, null, null);
        } catch (KeyStoreException e10) {
            LogUtil.e(Log.getStackTraceString(e10));
            this.f٦٤٠٠b = false;
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    private Key m٢٤٩a() {
        KeyGenParameterSpec build;
        try {
            int i10 = Build.VERSION.SDK_INT;
            if (i10 < 23) {
                return null;
            }
            q.a();
            KeyGenParameterSpec.Builder a10 = p.a("emas_rest_key", 3);
            a10.setKeySize(256);
            a10.setBlockModes(CodePackage.GCM);
            a10.setEncryptionPaddings("NoPadding");
            if (i10 >= 28) {
                a10.setUnlockedDeviceRequired(true);
            }
            KeyGenerator keyGenerator = KeyGenerator.getInstance(JceEncryptionConstants.SYMMETRIC_KEY_ALGORITHM);
            build = a10.build();
            keyGenerator.init(build);
            return keyGenerator.generateKey();
        } catch (InvalidAlgorithmParameterException e10) {
            e = e10;
            LogUtil.e(Log.getStackTraceString(e));
            this.f٦٤٠٠b = false;
            return null;
        } catch (NoSuchAlgorithmException e11) {
            e = e11;
            LogUtil.e(Log.getStackTraceString(e));
            this.f٦٤٠٠b = false;
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] a(byte[] bArr) {
        if (!this.f٦٤٠٠b) {
            return null;
        }
        try {
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            cipher.init(1, this.f٨a.getKey("emas_rest_key", null));
            byte[] iv = cipher.getIV();
            byte[] bArr2 = new byte[cipher.getOutputSize(bArr.length) + 12];
            System.arraycopy(iv, 0, bArr2, 0, 12);
            cipher.doFinal(bArr, 0, bArr.length, bArr2, 12);
            return bArr2;
        } catch (InvalidKeyException | KeyStoreException | NoSuchAlgorithmException | UnrecoverableKeyException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException | ShortBufferException e10) {
            LogUtil.e(Log.getStackTraceString(e10));
            return null;
        }
    }
}
