package com.ta.a.b;

import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.X509Certificate;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
class g implements X509TrustManager {
    private static TrustManager[] a;

    g() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized TrustManager[] getTrustManagers() {
        TrustManager[] trustManagerArr;
        synchronized (g.class) {
            try {
                if (a == null) {
                    a = new TrustManager[]{new g()};
                }
                trustManagerArr = a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return trustManagerArr;
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        if (x509CertificateArr != null && x509CertificateArr.length > 0) {
            try {
                TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance("X509");
                trustManagerFactory.init((KeyStore) null);
                if (trustManagerFactory.getTrustManagers() != null) {
                    for (TrustManager trustManager : trustManagerFactory.getTrustManagers()) {
                        try {
                            ((X509TrustManager) trustManager).checkServerTrusted(x509CertificateArr, str);
                        } catch (CertificateException e) {
                            for (Throwable th = e; th != null; th = th.getCause()) {
                                if ((th instanceof CertificateExpiredException) || (th instanceof CertificateNotYetValidException)) {
                                    return;
                                }
                            }
                            throw e;
                        }
                    }
                    return;
                }
                return;
            } catch (KeyStoreException e2) {
                throw new CertificateException(e2);
            } catch (NoSuchAlgorithmException e3) {
                throw new CertificateException(e3);
            }
        }
        throw new IllegalArgumentException("checkServerTrusted: X509Certificate array is null");
    }

    @Override // javax.net.ssl.X509TrustManager
    public X509Certificate[] getAcceptedIssuers() {
        return new X509Certificate[0];
    }
}
