package com.google.firebase.sessions;

import androidx.datastore.core.DataStore;
import androidx.datastore.preferences.core.Preferences;
import com.google.firebase.sessions.dagger.internal.DaggerGenerated;
import com.google.firebase.sessions.dagger.internal.Factory;
import com.google.firebase.sessions.dagger.internal.QualifierMetadata;
import com.google.firebase.sessions.dagger.internal.ScopeMetadata;
import kotlin.coroutines.CoroutineContext;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata({"com.google.firebase.annotations.concurrent.Background", "com.google.firebase.sessions.SessionDetailsDataStore"})
@DaggerGenerated
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class SessionDatastoreImpl_Factory implements Factory<SessionDatastoreImpl> {
    private final ne.a backgroundDispatcherProvider;
    private final ne.a dataStoreProvider;

    public SessionDatastoreImpl_Factory(ne.a aVar, ne.a aVar2) {
        this.backgroundDispatcherProvider = aVar;
        this.dataStoreProvider = aVar2;
    }

    public static SessionDatastoreImpl_Factory create(ne.a aVar, ne.a aVar2) {
        return new SessionDatastoreImpl_Factory(aVar, aVar2);
    }

    public static SessionDatastoreImpl newInstance(CoroutineContext coroutineContext, DataStore<Preferences> dataStore) {
        return new SessionDatastoreImpl(coroutineContext, dataStore);
    }

    @Override // com.google.firebase.sessions.dagger.internal.Factory, ne.a
    public SessionDatastoreImpl get() {
        return newInstance((CoroutineContext) this.backgroundDispatcherProvider.get(), (DataStore) this.dataStoreProvider.get());
    }
}
