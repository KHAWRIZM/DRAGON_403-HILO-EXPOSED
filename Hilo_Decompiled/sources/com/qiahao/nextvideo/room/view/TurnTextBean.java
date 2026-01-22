package com.qiahao.nextvideo.room.view;

import com.qiahao.nextvideo.room.view.TurntableMainCommonView2;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0010\u001a\u00020\u0003H\u0016J\b\u0010\u0011\u001a\u00020\u0003H\u0016R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/qiahao/nextvideo/room/view/TurnTextBean;", "Lcom/qiahao/nextvideo/room/view/TurntableMainCommonView2$BaseBean;", "text", "", "id1", "image1", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "getId1", "setId1", "getImage1", "setImage1", "getId", "getImage", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class TurnTextBean implements TurntableMainCommonView2.BaseBean {

    @NotNull
    private String id1;

    @NotNull
    private String image1;

    @Nullable
    private String text;

    public TurnTextBean(@Nullable String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str2, "id1");
        Intrinsics.checkNotNullParameter(str3, "image1");
        this.text = str;
        this.id1 = str2;
        this.image1 = str3;
    }

    @Override // com.qiahao.nextvideo.room.view.TurntableMainCommonView2.BaseBean
    @NotNull
    /* renamed from: getId, reason: from getter */
    public String getId1() {
        return this.id1;
    }

    @NotNull
    public final String getId1() {
        return this.id1;
    }

    @Override // com.qiahao.nextvideo.room.view.TurntableMainCommonView2.BaseBean
    @NotNull
    /* renamed from: getImage, reason: from getter */
    public String getImage1() {
        return this.image1;
    }

    @NotNull
    public final String getImage1() {
        return this.image1;
    }

    @Nullable
    public final String getText() {
        return this.text;
    }

    public final void setId1(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.id1 = str;
    }

    public final void setImage1(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.image1 = str;
    }

    public final void setText(@Nullable String str) {
        this.text = str;
    }
}
