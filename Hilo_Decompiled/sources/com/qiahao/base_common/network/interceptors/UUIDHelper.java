package com.qiahao.base_common.network.interceptors;

import android.text.TextUtils;
import com.alibaba.sdk.android.push.noonesdk.PushServiceFactory;
import com.oudi.utils.store.IStore;
import com.oudi.utils.store.MMKVStore;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/qiahao/base_common/network/interceptors/UUIDHelper;", "", "<init>", "()V", "ID_KEY", "", "uuid", "getUuid", "()Ljava/lang/String;", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class UUIDHelper {

    @NotNull
    public static final String ID_KEY = "uuid1_key";

    @NotNull
    public static final UUIDHelper INSTANCE = new UUIDHelper();

    private UUIDHelper() {
    }

    @NotNull
    public final String getUuid() {
        String deviceId = PushServiceFactory.getCloudPushService().getDeviceId();
        if (!TextUtils.isEmpty(deviceId)) {
            Intrinsics.checkNotNull(deviceId);
            return deviceId;
        }
        MMKVStore mMKVStore = MMKVStore.INSTANCE;
        String str = (String) IStore.DefaultImpls.getValue$default(mMKVStore, ID_KEY, "", null, 4, null);
        if (!TextUtils.isEmpty(str)) {
            String uuid = UUID.fromString(str).toString();
            Intrinsics.checkNotNull(uuid);
            return uuid;
        }
        String uuid2 = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid2, "toString(...)");
        IStore.DefaultImpls.setValue$default(mMKVStore, ID_KEY, uuid2, null, 4, null);
        String uuid3 = UUID.fromString(uuid2).toString();
        Intrinsics.checkNotNull(uuid3);
        return uuid3;
    }
}
