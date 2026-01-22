package com.google.firebase.sessions.settings;

import com.google.firebase.sessions.ApplicationInfo;
import com.google.firebase.sessions.dagger.internal.DaggerGenerated;
import com.google.firebase.sessions.dagger.internal.Factory;
import com.google.firebase.sessions.dagger.internal.QualifierMetadata;
import com.google.firebase.sessions.dagger.internal.ScopeMetadata;
import kotlin.coroutines.CoroutineContext;
import ne.a;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata({"com.google.firebase.annotations.concurrent.Background"})
@DaggerGenerated
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class RemoteSettingsFetcher_Factory implements Factory<RemoteSettingsFetcher> {
    private final a appInfoProvider;
    private final a blockingDispatcherProvider;

    public RemoteSettingsFetcher_Factory(a aVar, a aVar2) {
        this.appInfoProvider = aVar;
        this.blockingDispatcherProvider = aVar2;
    }

    public static RemoteSettingsFetcher_Factory create(a aVar, a aVar2) {
        return new RemoteSettingsFetcher_Factory(aVar, aVar2);
    }

    public static RemoteSettingsFetcher newInstance(ApplicationInfo applicationInfo, CoroutineContext coroutineContext) {
        return new RemoteSettingsFetcher(applicationInfo, coroutineContext);
    }

    @Override // com.google.firebase.sessions.dagger.internal.Factory, ne.a
    public RemoteSettingsFetcher get() {
        return newInstance((ApplicationInfo) this.appInfoProvider.get(), (CoroutineContext) this.blockingDispatcherProvider.get());
    }
}
