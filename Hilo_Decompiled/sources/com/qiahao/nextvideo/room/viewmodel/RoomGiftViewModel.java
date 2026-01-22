package com.qiahao.nextvideo.room.viewmodel;

import android.text.TextUtils;
import com.qiahao.base_common.model.GiftData;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.viewmodel.BaseViewModel;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.model.MicroBean;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010&\u001a\u00020'2\u0016\u0010(\u001a\u0012\u0012\u0004\u0012\u00020)0\u000bj\b\u0012\u0004\u0012\u00020)`\rJ\u000e\u0010*\u001a\u00020'2\u0006\u0010+\u001a\u00020)R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR*\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0007\"\u0004\b\u001a\u0010\tR\u001a\u0010\u001b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u0004\u0018\u00010!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u0006,"}, d2 = {"Lcom/qiahao/nextvideo/room/viewmodel/RoomGiftViewModel;", "Lcom/qiahao/base_common/viewmodel/BaseViewModel;", "<init>", "()V", "giftNumber", "", "getGiftNumber", "()I", "setGiftNumber", "(I)V", "extraIdList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getExtraIdList", "()Ljava/util/ArrayList;", "setExtraIdList", "(Ljava/util/ArrayList;)V", "mIsAllMic", "", "getMIsAllMic", "()Z", "setMIsAllMic", "(Z)V", "mSendType", "getMSendType", "setMSendType", "mUserName", "getMUserName", "()Ljava/lang/String;", "setMUserName", "(Ljava/lang/String;)V", "selectedGift", "Lcom/qiahao/base_common/model/GiftData;", "getSelectedGift", "()Lcom/qiahao/base_common/model/GiftData;", "setSelectedGift", "(Lcom/qiahao/base_common/model/GiftData;)V", "setSendAllMicMember", "", "extraIdlist", "Lcom/qiahao/nextvideo/data/model/MicroBean;", "setSendMicMember", "microBean", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nRoomGiftViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RoomGiftViewModel.kt\ncom/qiahao/nextvideo/room/viewmodel/RoomGiftViewModel\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,43:1\n1869#2,2:44\n*S KotlinDebug\n*F\n+ 1 RoomGiftViewModel.kt\ncom/qiahao/nextvideo/room/viewmodel/RoomGiftViewModel\n*L\n30#1:44,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class RoomGiftViewModel extends BaseViewModel {
    private boolean mIsAllMic;
    private int mSendType;

    @Nullable
    private GiftData selectedGift;
    private int giftNumber = 1;

    @NotNull
    private ArrayList<String> extraIdList = new ArrayList<>();

    @NotNull
    private String mUserName = "";

    @NotNull
    public final ArrayList<String> getExtraIdList() {
        return this.extraIdList;
    }

    public final int getGiftNumber() {
        return this.giftNumber;
    }

    public final boolean getMIsAllMic() {
        return this.mIsAllMic;
    }

    public final int getMSendType() {
        return this.mSendType;
    }

    @NotNull
    public final String getMUserName() {
        return this.mUserName;
    }

    @Nullable
    public final GiftData getSelectedGift() {
        return this.selectedGift;
    }

    public final void setExtraIdList(@NotNull ArrayList<String> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.extraIdList = arrayList;
    }

    public final void setGiftNumber(int i) {
        this.giftNumber = i;
    }

    public final void setMIsAllMic(boolean z) {
        this.mIsAllMic = z;
    }

    public final void setMSendType(int i) {
        this.mSendType = i;
    }

    public final void setMUserName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mUserName = str;
    }

    public final void setSelectedGift(@Nullable GiftData giftData) {
        this.selectedGift = giftData;
    }

    public final void setSendAllMicMember(@NotNull ArrayList<MicroBean> extraIdlist) {
        String str;
        Intrinsics.checkNotNullParameter(extraIdlist, "extraIdlist");
        this.extraIdList.clear();
        for (MicroBean microBean : extraIdlist) {
            if (!TextUtils.isEmpty(microBean.getExternalId())) {
                String externalId = microBean.getExternalId();
                User user = UserStore.INSTANCE.getShared().getUser();
                if (user != null) {
                    str = user.getExternalId();
                } else {
                    str = null;
                }
                if (!Intrinsics.areEqual(externalId, str)) {
                    ArrayList<String> arrayList = this.extraIdList;
                    String externalId2 = microBean.getExternalId();
                    Intrinsics.checkNotNull(externalId2);
                    arrayList.add(externalId2);
                }
            }
        }
    }

    public final void setSendMicMember(@NotNull MicroBean microBean) {
        Intrinsics.checkNotNullParameter(microBean, "microBean");
        this.extraIdList.clear();
        ArrayList<String> arrayList = this.extraIdList;
        String externalId = microBean.getExternalId();
        Intrinsics.checkNotNull(externalId);
        arrayList.add(externalId);
    }
}
