package com.qiahao.nextvideo.utilities;

import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/qiahao/nextvideo/utilities/HttpUtilities;", "", "<init>", "()V", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class HttpUtilities {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0019\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0003¨\u0006\f"}, d2 = {"Lcom/qiahao/nextvideo/utilities/HttpUtilities$Companion;", "", "<init>", "()V", "trustManagerForCertificates", "Ljavax/net/ssl/X509TrustManager;", "inputStream", "Ljava/io/InputStream;", "newEmptyKeyStore", "Ljava/security/KeyStore;", "password", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final KeyStore newEmptyKeyStore(char[] password) throws GeneralSecurityException {
            try {
                KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
                Intrinsics.checkNotNullExpressionValue(keyStore, "getInstance(...)");
                keyStore.load(null, password);
                return keyStore;
            } catch (IOException e) {
                throw new AssertionError(e);
            }
        }

        @JvmStatic
        @NotNull
        public final X509TrustManager trustManagerForCertificates(@NotNull InputStream inputStream) throws GeneralSecurityException, IllegalArgumentException {
            Intrinsics.checkNotNullParameter(inputStream, "inputStream");
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            Intrinsics.checkNotNullExpressionValue(certificateFactory, "getInstance(...)");
            Collection<? extends Certificate> generateCertificates = certificateFactory.generateCertificates(inputStream);
            if (!generateCertificates.isEmpty()) {
                KeyStore newEmptyKeyStore = newEmptyKeyStore(null);
                Iterator<T> it = generateCertificates.iterator();
                int i = 0;
                while (it.hasNext()) {
                    newEmptyKeyStore.setCertificateEntry(String.valueOf(i), (Certificate) it.next());
                    i++;
                }
                KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
                Intrinsics.checkNotNullExpressionValue(keyManagerFactory, "getInstance(...)");
                keyManagerFactory.init(newEmptyKeyStore, null);
                TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                Intrinsics.checkNotNullExpressionValue(trustManagerFactory, "getInstance(...)");
                trustManagerFactory.init(newEmptyKeyStore);
                TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
                Intrinsics.checkNotNullExpressionValue(trustManagers, "getTrustManagers(...)");
                if (trustManagers.length == 1) {
                    TrustManager trustManager = trustManagers[0];
                    if (trustManager instanceof X509TrustManager) {
                        Intrinsics.checkNotNull(trustManager, "null cannot be cast to non-null type javax.net.ssl.X509TrustManager");
                        return (X509TrustManager) trustManager;
                    }
                }
                String arrays = Arrays.toString(trustManagers);
                Intrinsics.checkNotNullExpressionValue(arrays, "toString(...)");
                throw new IllegalStateException("Unexpected default trust managers:" + arrays);
            }
            throw new IllegalArgumentException("expected non-empty set of trusted certificates");
        }

        private Companion() {
        }
    }

    @JvmStatic
    private static final KeyStore newEmptyKeyStore(char[] cArr) throws GeneralSecurityException {
        return INSTANCE.newEmptyKeyStore(cArr);
    }

    @JvmStatic
    @NotNull
    public static final X509TrustManager trustManagerForCertificates(@NotNull InputStream inputStream) throws GeneralSecurityException, IllegalArgumentException {
        return INSTANCE.trustManagerForCertificates(inputStream);
    }
}
