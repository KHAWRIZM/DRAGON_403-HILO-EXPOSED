package com.qiahao.nextvideo.ui.store;

import com.qiahao.base_common.model.StoreBean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J \u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016¨\u0006\u000b"}, d2 = {"Lcom/qiahao/nextvideo/ui/store/StoreListener;", "", "headWearItemClick", "", "storeBean", "Lcom/qiahao/base_common/model/StoreBean;", "mountsItemClick", "relationCardClick", "curNum", "", "maxNum", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public interface StoreListener {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class DefaultImpls {
        public static void headWearItemClick(@NotNull StoreListener storeListener, @NotNull StoreBean storeBean) {
            Intrinsics.checkNotNullParameter(storeBean, "storeBean");
        }

        public static void mountsItemClick(@NotNull StoreListener storeListener, @NotNull StoreBean storeBean) {
            Intrinsics.checkNotNullParameter(storeBean, "storeBean");
        }

        public static void relationCardClick(@NotNull StoreListener storeListener, @NotNull StoreBean storeBean, int i, int i2) {
            Intrinsics.checkNotNullParameter(storeBean, "storeBean");
        }
    }

    void headWearItemClick(@NotNull StoreBean storeBean);

    void mountsItemClick(@NotNull StoreBean storeBean);

    void relationCardClick(@NotNull StoreBean storeBean, int curNum, int maxNum);
}
