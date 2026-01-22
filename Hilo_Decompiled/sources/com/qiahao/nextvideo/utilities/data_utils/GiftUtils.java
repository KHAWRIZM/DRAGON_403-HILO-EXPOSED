package com.qiahao.nextvideo.utilities.data_utils;

import com.google.gson.d;
import com.google.gson.reflect.TypeToken;
import com.oudi.utils.store.IStore;
import com.oudi.utils.store.MMKVStore;
import com.qiahao.base_common.BaseApplication;
import com.qiahao.base_common.model.GiftData;
import com.qiahao.base_common.model.MultiGiftData;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\rJ\"\u0010\u000e\u001a\u0016\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bj\n\u0012\u0004\u0012\u00020\f\u0018\u0001`\r2\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/qiahao/nextvideo/utilities/data_utils/GiftUtils;", "", "<init>", "()V", "GIFT_TYPE", "", "saveGiftList", "", "type", "", "list", "Ljava/util/ArrayList;", "Lcom/qiahao/base_common/model/MultiGiftData;", "Lkotlin/collections/ArrayList;", "getGiftList", "findGiftByGiftId", "giftId", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nGiftUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GiftUtils.kt\ncom/qiahao/nextvideo/utilities/data_utils/GiftUtils\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,54:1\n1869#2,2:55\n*S KotlinDebug\n*F\n+ 1 GiftUtils.kt\ncom/qiahao/nextvideo/utilities/data_utils/GiftUtils\n*L\n45#1:55,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class GiftUtils {

    @NotNull
    public static final String GIFT_TYPE = "gift_multi_type";

    @NotNull
    public static final GiftUtils INSTANCE = new GiftUtils();

    private GiftUtils() {
    }

    @Nullable
    public final MultiGiftData findGiftByGiftId(long giftId) {
        Long giftId2;
        MultiGiftData multiGiftData = null;
        for (int i = 1; i < 5; i++) {
            ArrayList<MultiGiftData> giftList = getGiftList(i);
            if (giftList != null) {
                for (MultiGiftData multiGiftData2 : giftList) {
                    GiftData giftData = multiGiftData2.getGiftData();
                    if (giftData != null && (giftId2 = giftData.getGiftId()) != null && giftId2.longValue() == giftId) {
                        multiGiftData = multiGiftData2;
                    }
                }
            }
        }
        return multiGiftData;
    }

    @Nullable
    public final ArrayList<MultiGiftData> getGiftList(int type) {
        try {
            return (ArrayList) BaseApplication.Companion.getGSON().k((String) IStore.DefaultImpls.getValue$default(MMKVStore.INSTANCE, GIFT_TYPE + type, "", (String) null, 4, (Object) null), new TypeToken<ArrayList<MultiGiftData>>() { // from class: com.qiahao.nextvideo.utilities.data_utils.GiftUtils$getGiftList$typeToken$1
            }.getType());
        } catch (Exception unused) {
            return null;
        }
    }

    public final void saveGiftList(int type, @NotNull ArrayList<MultiGiftData> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        String s = new d().s(list);
        IStore.DefaultImpls.setValue$default(MMKVStore.INSTANCE, GIFT_TYPE + type, s, (String) null, 4, (Object) null);
    }
}
