package com.google.firebase.sessions;

import com.google.firebase.FirebaseApp;
import com.google.firebase.installations.FirebaseInstallationsApi;
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
public final class SessionFirelogPublisherImpl_Factory implements Factory<SessionFirelogPublisherImpl> {
    private final ne.a backgroundDispatcherProvider;
    private final ne.a eventGDTLoggerProvider;
    private final ne.a firebaseAppProvider;
    private final ne.a firebaseInstallationsProvider;
    private final ne.a sessionSettingsProvider;

    public SessionFirelogPublisherImpl_Factory(ne.a aVar, ne.a aVar2, ne.a aVar3, ne.a aVar4, ne.a aVar5) {
        this.firebaseAppProvider = aVar;
        this.firebaseInstallationsProvider = aVar2;
        this.sessionSettingsProvider = aVar3;
        this.eventGDTLoggerProvider = aVar4;
        this.backgroundDispatcherProvider = aVar5;
    }

    public static SessionFirelogPublisherImpl_Factory create(ne.a aVar, ne.a aVar2, ne.a aVar3, ne.a aVar4, ne.a aVar5) {
        return new SessionFirelogPublisherImpl_Factory(aVar, aVar2, aVar3, aVar4, aVar5);
    }

    public static SessionFirelogPublisherImpl newInstance(FirebaseApp firebaseApp, FirebaseInstallationsApi firebaseInstallationsApi, SessionsSettings sessionsSettings, EventGDTLoggerInterface eventGDTLoggerInterface, CoroutineContext coroutineContext) {
        return new SessionFirelogPublisherImpl(firebaseApp, firebaseInstallationsApi, sessionsSettings, eventGDTLoggerInterface, coroutineContext);
    }

    @Override // com.google.firebase.sessions.dagger.internal.Factory, ne.a
    public SessionFirelogPublisherImpl get() {
        return newInstance((FirebaseApp) this.firebaseAppProvider.get(), (FirebaseInstallationsApi) this.firebaseInstallationsProvider.get(), (SessionsSettings) this.sessionSettingsProvider.get(), (EventGDTLoggerInterface) this.eventGDTLoggerProvider.get(), (CoroutineContext) this.backgroundDispatcherProvider.get());
    }
}
