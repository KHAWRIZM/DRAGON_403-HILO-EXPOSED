package com.tencent.qcloud.tuikit.tuichat.util;

import androidx.datastore.preferences.core.MutablePreferences;
import androidx.datastore.preferences.core.Preferences;
import androidx.datastore.preferences.core.PreferencesKeys;
import androidx.datastore.rxjava3.RxDataStore;
import io.reactivex.rxjava3.core.h;
import io.reactivex.rxjava3.core.i0;
import pd.g;
import pd.o;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class DataStoreUtil {
    private static final String TAG = "DataStoreUtil";
    private static DataStoreUtil instance;
    private RxDataStore<Preferences> dataStore = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public class DisponseHandler {
        nd.c disposable;

        DisponseHandler() {
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public interface GetResult<T> {
        void onFail();

        void onSuccess(T t);
    }

    private DataStoreUtil() {
    }

    public static DataStoreUtil getInstance() {
        if (instance == null) {
            instance = new DataStoreUtil();
        }
        return instance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$getValue$0(Preferences.Key key, Preferences preferences) throws Throwable {
        return (String) preferences.get(key);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$getValueAsync$1(Preferences.Key key, Preferences preferences) throws Throwable {
        return (String) preferences.get(key);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ i0 lambda$putValue$2(Object obj, Preferences.Key key, Preferences preferences) throws Throwable {
        MutablePreferences mutablePreferences = preferences.toMutablePreferences();
        mutablePreferences.set(key, new com.google.gson.d().s(obj));
        return i0.i(mutablePreferences);
    }

    public <T> T getValue(String str, Class<T> cls) {
        if (this.dataStore == null) {
            TUIChatLog.e(TAG, "dataStore is null");
            return null;
        }
        final Preferences.Key stringKey = PreferencesKeys.stringKey(str);
        return (T) new com.google.gson.d().j((String) this.dataStore.data().e(new o() { // from class: com.tencent.qcloud.tuikit.tuichat.util.b
            public final Object apply(Object obj) {
                String lambda$getValue$0;
                lambda$getValue$0 = DataStoreUtil.lambda$getValue$0(stringKey, (Preferences) obj);
                return lambda$getValue$0;
            }
        }).a(), cls);
    }

    public <T> void getValueAsync(String str, final GetResult<T> getResult, final Class<T> cls) {
        if (this.dataStore == null) {
            TUIChatLog.e(TAG, "dataStore is null");
            getResult.onFail();
        } else {
            final Preferences.Key stringKey = PreferencesKeys.stringKey(str);
            final h e = this.dataStore.data().e(new o() { // from class: com.tencent.qcloud.tuikit.tuichat.util.c
                public final Object apply(Object obj) {
                    String lambda$getValueAsync$1;
                    lambda$getValueAsync$1 = DataStoreUtil.lambda$getValueAsync$1(stringKey, (Preferences) obj);
                    return lambda$getValueAsync$1;
                }
            });
            final DisponseHandler disponseHandler = new DisponseHandler();
            disponseHandler.disposable = e.q(ke.a.b()).f(md.b.c()).m(new g() { // from class: com.tencent.qcloud.tuikit.tuichat.util.DataStoreUtil.1
                public void accept(String str2) throws Throwable {
                    getResult.onSuccess(new com.google.gson.d().j((String) e.a(), cls));
                    nd.c cVar = disponseHandler.disposable;
                    if (cVar == null || cVar.isDisposed()) {
                        return;
                    }
                    disponseHandler.disposable.dispose();
                }
            }, new g() { // from class: com.tencent.qcloud.tuikit.tuichat.util.DataStoreUtil.2
                public void accept(Throwable th) throws Throwable {
                    TUIChatLog.e(DataStoreUtil.TAG, "dataStore throwable = " + th);
                    getResult.onFail();
                    nd.c cVar = disponseHandler.disposable;
                    if (cVar == null || cVar.isDisposed()) {
                        return;
                    }
                    disponseHandler.disposable.dispose();
                }
            });
        }
    }

    public <T> void putValue(String str, final T t) {
        if (this.dataStore == null) {
            TUIChatLog.e(TAG, "dataStore is null");
        } else {
            final Preferences.Key stringKey = PreferencesKeys.stringKey(str);
            this.dataStore.updateDataAsync(new o() { // from class: com.tencent.qcloud.tuikit.tuichat.util.d
                public final Object apply(Object obj) {
                    i0 lambda$putValue$2;
                    lambda$putValue$2 = DataStoreUtil.lambda$putValue$2(t, stringKey, (Preferences) obj);
                    return lambda$putValue$2;
                }
            }).m();
        }
    }

    public void setDataStore(RxDataStore<Preferences> rxDataStore) {
        this.dataStore = rxDataStore;
    }
}
