package com.google.firebase.sessions.settings;

import android.content.Context;
import com.google.firebase.sessions.dagger.internal.DaggerGenerated;
import com.google.firebase.sessions.dagger.internal.Factory;
import com.google.firebase.sessions.dagger.internal.QualifierMetadata;
import com.google.firebase.sessions.dagger.internal.ScopeMetadata;
import ne.a;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class LocalOverrideSettings_Factory implements Factory<LocalOverrideSettings> {
    private final a appContextProvider;

    public LocalOverrideSettings_Factory(a aVar) {
        this.appContextProvider = aVar;
    }

    public static LocalOverrideSettings_Factory create(a aVar) {
        return new LocalOverrideSettings_Factory(aVar);
    }

    public static LocalOverrideSettings newInstance(Context context) {
        return new LocalOverrideSettings(context);
    }

    @Override // com.google.firebase.sessions.dagger.internal.Factory, ne.a
    public LocalOverrideSettings get() {
        return newInstance((Context) this.appContextProvider.get());
    }
}
