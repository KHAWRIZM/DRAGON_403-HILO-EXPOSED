package com.qiahao.nextvideo.data.model;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 #2\u00020\u0001:\u0001#B;\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u001c\b\u0002\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001d\u0010\u001a\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\tHÆ\u0003J=\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u001c\b\u0002\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\tHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020\u0003HÖ\u0001J\t\u0010!\u001a\u00020\"HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R.\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006$"}, d2 = {"Lcom/qiahao/nextvideo/data/model/MessageTopData;", "Lcom/chad/library/adapter/base/entity/MultiItemEntity;", "itemType", "", "item", "Lcom/qiahao/nextvideo/data/model/PrivateRecordBean;", "banner", "Ljava/util/ArrayList;", "Lcom/qiahao/nextvideo/data/model/VideoBaseData;", "Lkotlin/collections/ArrayList;", "<init>", "(ILcom/qiahao/nextvideo/data/model/PrivateRecordBean;Ljava/util/ArrayList;)V", "getItemType", "()I", "setItemType", "(I)V", "getItem", "()Lcom/qiahao/nextvideo/data/model/PrivateRecordBean;", "setItem", "(Lcom/qiahao/nextvideo/data/model/PrivateRecordBean;)V", "getBanner", "()Ljava/util/ArrayList;", "setBanner", "(Ljava/util/ArrayList;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class MessageTopData implements MultiItemEntity {
    public static final int TYPE_BANNER = 1;
    public static final int TYPE_ITEM = 2;

    @Nullable
    private ArrayList<VideoBaseData> banner;

    @Nullable
    private PrivateRecordBean item;
    private int itemType;

    public MessageTopData() {
        this(0, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MessageTopData copy$default(MessageTopData messageTopData, int i, PrivateRecordBean privateRecordBean, ArrayList arrayList, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = messageTopData.itemType;
        }
        if ((i2 & 2) != 0) {
            privateRecordBean = messageTopData.item;
        }
        if ((i2 & 4) != 0) {
            arrayList = messageTopData.banner;
        }
        return messageTopData.copy(i, privateRecordBean, arrayList);
    }

    /* renamed from: component1, reason: from getter */
    public final int getItemType() {
        return this.itemType;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final PrivateRecordBean getItem() {
        return this.item;
    }

    @Nullable
    public final ArrayList<VideoBaseData> component3() {
        return this.banner;
    }

    @NotNull
    public final MessageTopData copy(int itemType, @Nullable PrivateRecordBean item, @Nullable ArrayList<VideoBaseData> banner) {
        return new MessageTopData(itemType, item, banner);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MessageTopData)) {
            return false;
        }
        MessageTopData messageTopData = (MessageTopData) other;
        return this.itemType == messageTopData.itemType && Intrinsics.areEqual(this.item, messageTopData.item) && Intrinsics.areEqual(this.banner, messageTopData.banner);
    }

    @Nullable
    public final ArrayList<VideoBaseData> getBanner() {
        return this.banner;
    }

    @Nullable
    public final PrivateRecordBean getItem() {
        return this.item;
    }

    public int getItemType() {
        return this.itemType;
    }

    public int hashCode() {
        int i = this.itemType * 31;
        PrivateRecordBean privateRecordBean = this.item;
        int hashCode = (i + (privateRecordBean == null ? 0 : privateRecordBean.hashCode())) * 31;
        ArrayList<VideoBaseData> arrayList = this.banner;
        return hashCode + (arrayList != null ? arrayList.hashCode() : 0);
    }

    public final void setBanner(@Nullable ArrayList<VideoBaseData> arrayList) {
        this.banner = arrayList;
    }

    public final void setItem(@Nullable PrivateRecordBean privateRecordBean) {
        this.item = privateRecordBean;
    }

    public void setItemType(int i) {
        this.itemType = i;
    }

    @NotNull
    public String toString() {
        return "MessageTopData(itemType=" + this.itemType + ", item=" + this.item + ", banner=" + this.banner + ")";
    }

    public MessageTopData(int i, @Nullable PrivateRecordBean privateRecordBean, @Nullable ArrayList<VideoBaseData> arrayList) {
        this.itemType = i;
        this.item = privateRecordBean;
        this.banner = arrayList;
    }

    public /* synthetic */ MessageTopData(int i, PrivateRecordBean privateRecordBean, ArrayList arrayList, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 2 : i, (i2 & 2) != 0 ? null : privateRecordBean, (i2 & 4) != 0 ? null : arrayList);
    }
}
