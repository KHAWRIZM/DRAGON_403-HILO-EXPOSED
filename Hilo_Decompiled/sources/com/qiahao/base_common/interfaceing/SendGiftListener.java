package com.qiahao.base_common.interfaceing;

import com.qiahao.base_common.model.GiftData;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J:\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u0003H&J:\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b2\u0006\u0010\u0010\u001a\u00020\u0007H\u0016J\u001a\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\u0013"}, d2 = {"Lcom/qiahao/base_common/interfaceing/SendGiftListener;", "", "giftsChoose", "", "selectedGiftItem", "Lcom/qiahao/base_common/model/GiftData;", "number", "", "extraIdList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "isAllMic", "", "showRechargeView", "roomGiftsChoose", "sendType", "begGift", "data", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public interface SendGiftListener {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class DefaultImpls {
        public static void begGift(@NotNull SendGiftListener sendGiftListener, @NotNull GiftData data, int i10) {
            Intrinsics.checkNotNullParameter(data, "data");
        }

        public static /* synthetic */ void begGift$default(SendGiftListener sendGiftListener, GiftData giftData, int i10, int i11, Object obj) {
            if (obj == null) {
                if ((i11 & 2) != 0) {
                    i10 = 1;
                }
                sendGiftListener.begGift(giftData, i10);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: begGift");
        }

        public static void giftsChoose(@NotNull SendGiftListener sendGiftListener, @NotNull GiftData selectedGiftItem, int i10, @NotNull ArrayList<String> extraIdList, boolean z10) {
            Intrinsics.checkNotNullParameter(selectedGiftItem, "selectedGiftItem");
            Intrinsics.checkNotNullParameter(extraIdList, "extraIdList");
        }

        public static /* synthetic */ void giftsChoose$default(SendGiftListener sendGiftListener, GiftData giftData, int i10, ArrayList arrayList, boolean z10, int i11, Object obj) {
            if (obj == null) {
                if ((i11 & 2) != 0) {
                    i10 = 1;
                }
                sendGiftListener.giftsChoose(giftData, i10, arrayList, z10);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: giftsChoose");
        }

        public static void roomGiftsChoose(@NotNull SendGiftListener sendGiftListener, @NotNull GiftData selectedGiftItem, int i10, @NotNull ArrayList<String> extraIdList, int i11) {
            Intrinsics.checkNotNullParameter(selectedGiftItem, "selectedGiftItem");
            Intrinsics.checkNotNullParameter(extraIdList, "extraIdList");
        }

        public static /* synthetic */ void roomGiftsChoose$default(SendGiftListener sendGiftListener, GiftData giftData, int i10, ArrayList arrayList, int i11, int i12, Object obj) {
            if (obj == null) {
                if ((i12 & 2) != 0) {
                    i10 = 1;
                }
                sendGiftListener.roomGiftsChoose(giftData, i10, arrayList, i11);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: roomGiftsChoose");
        }
    }

    void begGift(@NotNull GiftData data, int number);

    void giftsChoose(@NotNull GiftData selectedGiftItem, int number, @NotNull ArrayList<String> extraIdList, boolean isAllMic);

    void roomGiftsChoose(@NotNull GiftData selectedGiftItem, int number, @NotNull ArrayList<String> extraIdList, int sendType);

    void showRechargeView();
}
