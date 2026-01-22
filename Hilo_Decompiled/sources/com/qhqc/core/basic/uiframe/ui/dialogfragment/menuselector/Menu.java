package com.qhqc.core.basic.uiframe.ui.dialogfragment.menuselector;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0003\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J)\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/qhqc/core/basic/uiframe/ui/dialogfragment/menuselector/Menu;", "", "id", "", "content", "", "contentRes", "(ILjava/lang/String;I)V", "getContent", "()Ljava/lang/String;", "getContentRes", "()I", "getId", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "basic_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final /* data */ class Menu {

    @Nullable
    private final String content;
    private final int contentRes;
    private final int id;

    public Menu(int i10, @Nullable String str, int i11) {
        this.id = i10;
        this.content = str;
        this.contentRes = i11;
    }

    public static /* synthetic */ Menu copy$default(Menu menu, int i10, String str, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = menu.id;
        }
        if ((i12 & 2) != 0) {
            str = menu.content;
        }
        if ((i12 & 4) != 0) {
            i11 = menu.contentRes;
        }
        return menu.copy(i10, str, i11);
    }

    /* renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    /* renamed from: component3, reason: from getter */
    public final int getContentRes() {
        return this.contentRes;
    }

    @NotNull
    public final Menu copy(int id, @Nullable String content, int contentRes) {
        return new Menu(id, content, contentRes);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Menu)) {
            return false;
        }
        Menu menu = (Menu) other;
        return this.id == menu.id && Intrinsics.areEqual(this.content, menu.content) && this.contentRes == menu.contentRes;
    }

    @Nullable
    public final String getContent() {
        return this.content;
    }

    public final int getContentRes() {
        return this.contentRes;
    }

    public final int getId() {
        return this.id;
    }

    public int hashCode() {
        int i10 = this.id * 31;
        String str = this.content;
        return ((i10 + (str == null ? 0 : str.hashCode())) * 31) + this.contentRes;
    }

    @NotNull
    public String toString() {
        return "Menu(id=" + this.id + ", content=" + this.content + ", contentRes=" + this.contentRes + ")";
    }

    public /* synthetic */ Menu(int i10, String str, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(i10, (i12 & 2) != 0 ? null : str, (i12 & 4) != 0 ? 0 : i11);
    }
}
