package com.android.installreferrer.api;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import java.util.List;
import n7.a;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class a extends InstallReferrerClient {

    /* renamed from: a, reason: collision with root package name */
    private int f٧٢١٨a = 0;

    /* renamed from: b, reason: collision with root package name */
    private final Context f٧٢١٩b;

    /* renamed from: c, reason: collision with root package name */
    private n7.a f٧٢٢٠c;

    /* renamed from: d, reason: collision with root package name */
    private ServiceConnection f٧٢٢١d;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    private final class b implements ServiceConnection {

        /* renamed from: a, reason: collision with root package name */
        private final InstallReferrerStateListener f٧٢٢٢a;

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            d4.a.a("InstallReferrerClient", "Install Referrer service connected.");
            a.this.f٧٢٢٠c = a.AbstractBinderC٠١٩٤a.c(iBinder);
            a.this.f٧٢١٨a = 2;
            this.f٧٢٢٢a.onInstallReferrerSetupFinished(0);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            d4.a.b("InstallReferrerClient", "Install Referrer service disconnected.");
            a.this.f٧٢٢٠c = null;
            a.this.f٧٢١٨a = 0;
            this.f٧٢٢٢a.onInstallReferrerServiceDisconnected();
        }

        private b(InstallReferrerStateListener installReferrerStateListener) {
            if (installReferrerStateListener != null) {
                this.f٧٢٢٢a = installReferrerStateListener;
                return;
            }
            throw new RuntimeException("Please specify a listener to know when setup is done.");
        }
    }

    public a(Context context) {
        this.f٧٢١٩b = context.getApplicationContext();
    }

    private boolean f() {
        try {
            if (this.f٧٢١٩b.getPackageManager().getPackageInfo("com.android.vending", 128).versionCode < 80837300) {
                return false;
            }
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    @Override // com.android.installreferrer.api.InstallReferrerClient
    public ReferrerDetails a() {
        if (g()) {
            Bundle bundle = new Bundle();
            bundle.putString("package_name", this.f٧٢١٩b.getPackageName());
            try {
                return new ReferrerDetails(this.f٧٢٢٠c.a(bundle));
            } catch (RemoteException e10) {
                d4.a.b("InstallReferrerClient", "RemoteException getting install referrer information");
                this.f٧٢١٨a = 0;
                throw e10;
            }
        }
        throw new IllegalStateException("Service not connected. Please start a connection before using the service.");
    }

    @Override // com.android.installreferrer.api.InstallReferrerClient
    public void c(InstallReferrerStateListener installReferrerStateListener) {
        ServiceInfo serviceInfo;
        if (g()) {
            d4.a.a("InstallReferrerClient", "Service connection is valid. No need to re-initialize.");
            installReferrerStateListener.onInstallReferrerSetupFinished(0);
            return;
        }
        int i10 = this.f٧٢١٨a;
        if (i10 == 1) {
            d4.a.b("InstallReferrerClient", "Client is already in the process of connecting to the service.");
            installReferrerStateListener.onInstallReferrerSetupFinished(3);
            return;
        }
        if (i10 == 3) {
            d4.a.b("InstallReferrerClient", "Client was already closed and can't be reused. Please create another instance.");
            installReferrerStateListener.onInstallReferrerSetupFinished(3);
            return;
        }
        d4.a.a("InstallReferrerClient", "Starting install referrer service setup.");
        this.f٧٢٢١d = new b(installReferrerStateListener);
        Intent intent = new Intent("com.google.android.finsky.BIND_GET_INSTALL_REFERRER_SERVICE");
        intent.setComponent(new ComponentName("com.android.vending", "com.google.android.finsky.externalreferrer.GetInstallReferrerService"));
        List<ResolveInfo> queryIntentServices = this.f٧٢١٩b.getPackageManager().queryIntentServices(intent, 0);
        if (queryIntentServices != null && !queryIntentServices.isEmpty() && (serviceInfo = queryIntentServices.get(0).serviceInfo) != null) {
            String str = serviceInfo.packageName;
            String str2 = serviceInfo.name;
            if ("com.android.vending".equals(str) && str2 != null && f()) {
                if (this.f٧٢١٩b.bindService(new Intent(intent), this.f٧٢٢١d, 1)) {
                    d4.a.a("InstallReferrerClient", "Service was bonded successfully.");
                    return;
                }
                d4.a.b("InstallReferrerClient", "Connection to service is blocked.");
                this.f٧٢١٨a = 0;
                installReferrerStateListener.onInstallReferrerSetupFinished(1);
                return;
            }
            d4.a.b("InstallReferrerClient", "Play Store missing or incompatible. Version 8.3.73 or later required.");
            this.f٧٢١٨a = 0;
            installReferrerStateListener.onInstallReferrerSetupFinished(2);
            return;
        }
        this.f٧٢١٨a = 0;
        d4.a.a("InstallReferrerClient", "Install Referrer service unavailable on device.");
        installReferrerStateListener.onInstallReferrerSetupFinished(2);
    }

    public boolean g() {
        if (this.f٧٢١٨a == 2 && this.f٧٢٢٠c != null && this.f٧٢٢١d != null) {
            return true;
        }
        return false;
    }
}
