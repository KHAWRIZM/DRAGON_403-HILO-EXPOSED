package com.oudi.utils.store;

import com.amazonaws.mobileconnectors.s3.transferutility.TransferTable;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u0000 \u0014*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\u0014J\u0019\u0010\u0003\u001a\u0004\u0018\u00018\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0002\u0010\u0006J/\u0010\u0007\u001a\u0002H\u0001\"\u0004\b\u0001\u0010\u00012\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u0002H\u00012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0002\u0010\nJ/\u0010\u000b\u001a\u00020\f\"\u0004\b\u0001\u0010\u00012\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\r\u001a\u0002H\u00012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0002\u0010\u000eJ\u0014\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u0011\u001a\u00020\u0010H&J\u001c\u0010\u0012\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00052\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u001c\u0010\u0013\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00052\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0015"}, d2 = {"Lcom/oudi/utils/store/IStore;", "T", "", "getInstance", "group", "", "(Ljava/lang/String;)Ljava/lang/Object;", "getValue", TransferTable.COLUMN_KEY, "default", "(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;", "setValue", "", "value", "(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;)Z", "clear", "", "clearAll", "removeValue", "containsKey", "Companion", "lib_utils_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public interface IStore<T> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final String DEFAULT_GROUP = "default";

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/oudi/utils/store/IStore$Companion;", "", "<init>", "()V", "DEFAULT_GROUP", "", "lib_utils_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final String DEFAULT_GROUP = "default";

        private Companion() {
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void clear$default(IStore iStore, String str, int i10, Object obj) {
            if (obj == null) {
                if ((i10 & 1) != 0) {
                    str = null;
                }
                iStore.clear(str);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: clear");
        }

        public static /* synthetic */ boolean containsKey$default(IStore iStore, String str, String str2, int i10, Object obj) {
            if (obj == null) {
                if ((i10 & 2) != 0) {
                    str2 = null;
                }
                return iStore.containsKey(str, str2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: containsKey");
        }

        public static /* synthetic */ Object getValue$default(IStore iStore, String str, Object obj, String str2, int i10, Object obj2) {
            if (obj2 == null) {
                if ((i10 & 4) != 0) {
                    str2 = null;
                }
                return iStore.getValue(str, obj, str2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getValue");
        }

        public static /* synthetic */ boolean removeValue$default(IStore iStore, String str, String str2, int i10, Object obj) {
            if (obj == null) {
                if ((i10 & 2) != 0) {
                    str2 = null;
                }
                return iStore.removeValue(str, str2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: removeValue");
        }

        public static /* synthetic */ boolean setValue$default(IStore iStore, String str, Object obj, String str2, int i10, Object obj2) {
            if (obj2 == null) {
                if ((i10 & 4) != 0) {
                    str2 = null;
                }
                return iStore.setValue(str, obj, str2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setValue");
        }
    }

    void clear(String group);

    void clearAll();

    boolean containsKey(String key, String group);

    T getInstance(String group);

    <T> T getValue(String key, T r22, String group);

    boolean removeValue(String key, String group);

    <T> boolean setValue(String key, T value, String group);
}
