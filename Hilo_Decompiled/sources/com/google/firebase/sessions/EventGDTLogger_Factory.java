package com.google.firebase.sessions;

import com.google.firebase.inject.Provider;
import com.google.firebase.sessions.dagger.internal.DaggerGenerated;
import com.google.firebase.sessions.dagger.internal.Factory;
import com.google.firebase.sessions.dagger.internal.QualifierMetadata;
import com.google.firebase.sessions.dagger.internal.ScopeMetadata;
import z6.j;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class EventGDTLogger_Factory implements Factory<EventGDTLogger> {
    private final ne.a transportFactoryProvider;

    public EventGDTLogger_Factory(ne.a aVar) {
        this.transportFactoryProvider = aVar;
    }

    public static EventGDTLogger_Factory create(ne.a aVar) {
        return new EventGDTLogger_Factory(aVar);
    }

    public static EventGDTLogger newInstance(Provider<j> provider) {
        return new EventGDTLogger(provider);
    }

    @Override // com.google.firebase.sessions.dagger.internal.Factory, ne.a
    public EventGDTLogger get() {
        return newInstance((Provider) this.transportFactoryProvider.get());
    }
}
