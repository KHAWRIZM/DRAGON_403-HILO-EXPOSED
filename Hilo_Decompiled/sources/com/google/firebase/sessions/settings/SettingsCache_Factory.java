package com.google.firebase.sessions.settings;

import androidx.datastore.core.DataStore;
import androidx.datastore.preferences.core.Preferences;
import com.google.firebase.sessions.dagger.internal.DaggerGenerated;
import com.google.firebase.sessions.dagger.internal.Factory;
import com.google.firebase.sessions.dagger.internal.QualifierMetadata;
import com.google.firebase.sessions.dagger.internal.ScopeMetadata;
import ne.a;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata({"com.google.firebase.sessions.SessionConfigsDataStore"})
@DaggerGenerated
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class SettingsCache_Factory implements Factory<SettingsCache> {
    private final a dataStoreProvider;

    public SettingsCache_Factory(a aVar) {
        this.dataStoreProvider = aVar;
    }

    public static SettingsCache_Factory create(a aVar) {
        return new SettingsCache_Factory(aVar);
    }

    public static SettingsCache newInstance(DataStore<Preferences> dataStore) {
        return new SettingsCache(dataStore);
    }

    @Override // com.google.firebase.sessions.dagger.internal.Factory, ne.a
    public SettingsCache get() {
        return newInstance((DataStore) this.dataStoreProvider.get());
    }
}
