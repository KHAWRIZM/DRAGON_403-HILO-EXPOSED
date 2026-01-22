package com.google.firebase.sessions;

import com.google.firebase.FirebaseApp;
import com.google.firebase.sessions.dagger.internal.DaggerGenerated;
import com.google.firebase.sessions.dagger.internal.Factory;
import com.google.firebase.sessions.dagger.internal.QualifierMetadata;
import com.google.firebase.sessions.dagger.internal.ScopeMetadata;
import com.google.firebase.sessions.settings.SessionsSettings;
import kotlin.coroutines.CoroutineContext;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata({"com.google.firebase.annotations.concurrent.Background"})
@DaggerGenerated
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class FirebaseSessions_Factory implements Factory<FirebaseSessions> {
    private final ne.a backgroundDispatcherProvider;
    private final ne.a firebaseAppProvider;
    private final ne.a lifecycleServiceBinderProvider;
    private final ne.a settingsProvider;

    public FirebaseSessions_Factory(ne.a aVar, ne.a aVar2, ne.a aVar3, ne.a aVar4) {
        this.firebaseAppProvider = aVar;
        this.settingsProvider = aVar2;
        this.backgroundDispatcherProvider = aVar3;
        this.lifecycleServiceBinderProvider = aVar4;
    }

    public static FirebaseSessions_Factory create(ne.a aVar, ne.a aVar2, ne.a aVar3, ne.a aVar4) {
        return new FirebaseSessions_Factory(aVar, aVar2, aVar3, aVar4);
    }

    public static FirebaseSessions newInstance(FirebaseApp firebaseApp, SessionsSettings sessionsSettings, CoroutineContext coroutineContext, SessionLifecycleServiceBinder sessionLifecycleServiceBinder) {
        return new FirebaseSessions(firebaseApp, sessionsSettings, coroutineContext, sessionLifecycleServiceBinder);
    }

    @Override // com.google.firebase.sessions.dagger.internal.Factory, ne.a
    public FirebaseSessions get() {
        return newInstance((FirebaseApp) this.firebaseAppProvider.get(), (SessionsSettings) this.settingsProvider.get(), (CoroutineContext) this.backgroundDispatcherProvider.get(), (SessionLifecycleServiceBinder) this.lifecycleServiceBinderProvider.get());
    }
}
