package com.google.firebase.sessions;

import com.google.firebase.sessions.dagger.internal.DaggerGenerated;
import com.google.firebase.sessions.dagger.internal.Factory;
import com.google.firebase.sessions.dagger.internal.QualifierMetadata;
import com.google.firebase.sessions.dagger.internal.ScopeMetadata;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class SessionGenerator_Factory implements Factory<SessionGenerator> {
    private final ne.a timeProvider;
    private final ne.a uuidGeneratorProvider;

    public SessionGenerator_Factory(ne.a aVar, ne.a aVar2) {
        this.timeProvider = aVar;
        this.uuidGeneratorProvider = aVar2;
    }

    public static SessionGenerator_Factory create(ne.a aVar, ne.a aVar2) {
        return new SessionGenerator_Factory(aVar, aVar2);
    }

    public static SessionGenerator newInstance(TimeProvider timeProvider, UuidGenerator uuidGenerator) {
        return new SessionGenerator(timeProvider, uuidGenerator);
    }

    @Override // com.google.firebase.sessions.dagger.internal.Factory, ne.a
    public SessionGenerator get() {
        return newInstance((TimeProvider) this.timeProvider.get(), (UuidGenerator) this.uuidGeneratorProvider.get());
    }
}
