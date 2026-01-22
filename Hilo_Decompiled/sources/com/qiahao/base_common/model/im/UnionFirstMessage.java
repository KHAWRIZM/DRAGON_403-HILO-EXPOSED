package com.qiahao.base_common.model.im;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u0011\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\bHÆ\u0003J3\u0010\u001a\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0006HÖ\u0001R\"\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006!"}, d2 = {"Lcom/qiahao/base_common/model/im/UnionFirstMessage;", "", "gifts", "", "Lcom/qiahao/base_common/model/im/TIMUnionFirstMessageForGift;", ViewHierarchyConstants.TEXT_KEY, "", "pic", "Lcom/qiahao/base_common/model/im/PicBean;", "<init>", "(Ljava/util/List;Ljava/lang/String;Lcom/qiahao/base_common/model/im/PicBean;)V", "getGifts", "()Ljava/util/List;", "setGifts", "(Ljava/util/List;)V", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "getPic", "()Lcom/qiahao/base_common/model/im/PicBean;", "setPic", "(Lcom/qiahao/base_common/model/im/PicBean;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final /* data */ class UnionFirstMessage {

    @Nullable
    private List<TIMUnionFirstMessageForGift> gifts;

    @Nullable
    private PicBean pic;

    @Nullable
    private String text;

    public UnionFirstMessage() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ UnionFirstMessage copy$default(UnionFirstMessage unionFirstMessage, List list, String str, PicBean picBean, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = unionFirstMessage.gifts;
        }
        if ((i10 & 2) != 0) {
            str = unionFirstMessage.text;
        }
        if ((i10 & 4) != 0) {
            picBean = unionFirstMessage.pic;
        }
        return unionFirstMessage.copy(list, str, picBean);
    }

    @Nullable
    public final List<TIMUnionFirstMessageForGift> component1() {
        return this.gifts;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getText() {
        return this.text;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final PicBean getPic() {
        return this.pic;
    }

    @NotNull
    public final UnionFirstMessage copy(@Nullable List<TIMUnionFirstMessageForGift> gifts, @Nullable String text, @Nullable PicBean pic) {
        return new UnionFirstMessage(gifts, text, pic);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UnionFirstMessage)) {
            return false;
        }
        UnionFirstMessage unionFirstMessage = (UnionFirstMessage) other;
        return Intrinsics.areEqual(this.gifts, unionFirstMessage.gifts) && Intrinsics.areEqual(this.text, unionFirstMessage.text) && Intrinsics.areEqual(this.pic, unionFirstMessage.pic);
    }

    @Nullable
    public final List<TIMUnionFirstMessageForGift> getGifts() {
        return this.gifts;
    }

    @Nullable
    public final PicBean getPic() {
        return this.pic;
    }

    @Nullable
    public final String getText() {
        return this.text;
    }

    public int hashCode() {
        List<TIMUnionFirstMessageForGift> list = this.gifts;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        String str = this.text;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        PicBean picBean = this.pic;
        return hashCode2 + (picBean != null ? picBean.hashCode() : 0);
    }

    public final void setGifts(@Nullable List<TIMUnionFirstMessageForGift> list) {
        this.gifts = list;
    }

    public final void setPic(@Nullable PicBean picBean) {
        this.pic = picBean;
    }

    public final void setText(@Nullable String str) {
        this.text = str;
    }

    @NotNull
    public String toString() {
        return "UnionFirstMessage(gifts=" + this.gifts + ", text=" + this.text + ", pic=" + this.pic + ")";
    }

    public UnionFirstMessage(@Nullable List<TIMUnionFirstMessageForGift> list, @Nullable String str, @Nullable PicBean picBean) {
        this.gifts = list;
        this.text = str;
        this.pic = picBean;
    }

    public /* synthetic */ UnionFirstMessage(List list, String str, PicBean picBean, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? null : list, (i10 & 2) != 0 ? null : str, (i10 & 4) != 0 ? null : picBean);
    }
}
