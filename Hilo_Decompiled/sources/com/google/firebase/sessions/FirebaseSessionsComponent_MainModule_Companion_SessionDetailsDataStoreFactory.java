package com.google.firebase.sessions;

import android.content.Context;
import androidx.datastore.core.DataStore;
import androidx.datastore.preferences.core.Preferences;
import com.google.firebase.sessions.FirebaseSessionsComponent;
import com.google.firebase.sessions.dagger.internal.DaggerGenerated;
import com.google.firebase.sessions.dagger.internal.Factory;
import com.google.firebase.sessions.dagger.internal.Preconditions;
import com.google.firebase.sessions.dagger.internal.QualifierMetadata;
import com.google.firebase.sessions.dagger.internal.ScopeMetadata;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata({"com.google.firebase.sessions.SessionDetailsDataStore"})
@DaggerGenerated
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class FirebaseSessionsComponent_MainModule_Companion_SessionDetailsDataStoreFactory implements Factory<DataStore<Preferences>> {
    private final ne.a appContextProvider;

    public FirebaseSessionsComponent_MainModule_Companion_SessionDetailsDataStoreFactory(ne.a aVar) {
        this.appContextProvider = aVar;
    }

    public static FirebaseSessionsComponent_MainModule_Companion_SessionDetailsDataStoreFactory create(ne.a aVar) {
        return new FirebaseSessionsComponent_MainModule_Companion_SessionDetailsDataStoreFactory(aVar);
    }

    public static DataStore<Preferences> sessionDetailsDataStore(Context context) {
        return (DataStore) Preconditions.checkNotNullFromProvides(FirebaseSessionsComponent.MainModule.INSTANCE.sessionDetailsDataStore(context));
    }

    @Override // com.google.firebase.sessions.dagger.internal.Factory, ne.a
    public DataStore<Preferences> get() {
        return sessionDetailsDataStore((Context) this.appContextProvider.get());
    }
}
