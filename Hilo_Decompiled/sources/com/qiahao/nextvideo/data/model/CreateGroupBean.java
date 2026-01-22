package com.qiahao.nextvideo.data.model;

import com.taobao.accs.common.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/qiahao/nextvideo/data/model/CreateGroupBean;", "", Constants.KEY_HTTP_CODE, "", "imGroupId", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getCode", "()Ljava/lang/String;", "getImGroupId", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class CreateGroupBean {

    @NotNull
    private final String code;

    @NotNull
    private final String imGroupId;

    public CreateGroupBean(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, Constants.KEY_HTTP_CODE);
        Intrinsics.checkNotNullParameter(str2, "imGroupId");
        this.code = str;
        this.imGroupId = str2;
    }

    public static /* synthetic */ CreateGroupBean copy$default(CreateGroupBean createGroupBean, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = createGroupBean.code;
        }
        if ((i & 2) != 0) {
            str2 = createGroupBean.imGroupId;
        }
        return createGroupBean.copy(str, str2);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getCode() {
        return this.code;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getImGroupId() {
        return this.imGroupId;
    }

    @NotNull
    public final CreateGroupBean copy(@NotNull String code, @NotNull String imGroupId) {
        Intrinsics.checkNotNullParameter(code, Constants.KEY_HTTP_CODE);
        Intrinsics.checkNotNullParameter(imGroupId, "imGroupId");
        return new CreateGroupBean(code, imGroupId);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CreateGroupBean)) {
            return false;
        }
        CreateGroupBean createGroupBean = (CreateGroupBean) other;
        return Intrinsics.areEqual(this.code, createGroupBean.code) && Intrinsics.areEqual(this.imGroupId, createGroupBean.imGroupId);
    }

    @NotNull
    public final String getCode() {
        return this.code;
    }

    @NotNull
    public final String getImGroupId() {
        return this.imGroupId;
    }

    public int hashCode() {
        return (this.code.hashCode() * 31) + this.imGroupId.hashCode();
    }

    @NotNull
    public String toString() {
        return "CreateGroupBean(code=" + this.code + ", imGroupId=" + this.imGroupId + ")";
    }
}
