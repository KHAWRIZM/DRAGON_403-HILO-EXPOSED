package com.qiahao.nextvideo.ui.commonlist.interactivetracking;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import o6.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\fJ\u0010\u0010\u000e\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000e\u0010\nJ\u0010\u0010\u000f\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u000f\u0010\fJ\u0010\u0010\u0010\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0010\u0010\fJ.\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004HÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0013\u0010\nJ\u0010\u0010\u0014\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0014\u0010\fJ\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u001a\u001a\u0004\b\u001b\u0010\n\"\u0004\b\u001c\u0010\u001dR\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u001e\u001a\u0004\b\u001f\u0010\f\"\u0004\b \u0010!R\"\u0010\u0006\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u001e\u001a\u0004\b\"\u0010\f\"\u0004\b#\u0010!¨\u0006$"}, d2 = {"Lcom/qiahao/nextvideo/ui/commonlist/interactivetracking/TabEntity;", "Lo6/a;", "", "title", "", "selectedIcon", "unSelectedIcon", "<init>", "(Ljava/lang/String;II)V", "getTabTitle", "()Ljava/lang/String;", "getTabSelectedIcon", "()I", "getTabUnselectedIcon", "component1", "component2", "component3", "copy", "(Ljava/lang/String;II)Lcom/qiahao/nextvideo/ui/commonlist/interactivetracking/TabEntity;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getTitle", "setTitle", "(Ljava/lang/String;)V", "I", "getSelectedIcon", "setSelectedIcon", "(I)V", "getUnSelectedIcon", "setUnSelectedIcon", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nTabEntity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TabEntity.kt\ncom/qiahao/nextvideo/ui/commonlist/interactivetracking/TabEntity\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,17:1\n1#2:18\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class TabEntity implements a {
    private int selectedIcon;

    @NotNull
    private String title;
    private int unSelectedIcon;

    public TabEntity(@NotNull String str, int i, int i2) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.title = str;
        this.selectedIcon = i;
        this.unSelectedIcon = i2;
    }

    public static /* synthetic */ TabEntity copy$default(TabEntity tabEntity, String str, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = tabEntity.title;
        }
        if ((i3 & 2) != 0) {
            i = tabEntity.selectedIcon;
        }
        if ((i3 & 4) != 0) {
            i2 = tabEntity.unSelectedIcon;
        }
        return tabEntity.copy(str, i, i2);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component2, reason: from getter */
    public final int getSelectedIcon() {
        return this.selectedIcon;
    }

    /* renamed from: component3, reason: from getter */
    public final int getUnSelectedIcon() {
        return this.unSelectedIcon;
    }

    @NotNull
    public final TabEntity copy(@NotNull String title, int selectedIcon, int unSelectedIcon) {
        Intrinsics.checkNotNullParameter(title, "title");
        return new TabEntity(title, selectedIcon, unSelectedIcon);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TabEntity)) {
            return false;
        }
        TabEntity tabEntity = (TabEntity) other;
        return Intrinsics.areEqual(this.title, tabEntity.title) && this.selectedIcon == tabEntity.selectedIcon && this.unSelectedIcon == tabEntity.unSelectedIcon;
    }

    public final int getSelectedIcon() {
        return this.selectedIcon;
    }

    public int getTabSelectedIcon() {
        return this.selectedIcon;
    }

    @NotNull
    public String getTabTitle() {
        return this.title;
    }

    public int getTabUnselectedIcon() {
        return this.unSelectedIcon;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    public final int getUnSelectedIcon() {
        return this.unSelectedIcon;
    }

    public int hashCode() {
        return (((this.title.hashCode() * 31) + this.selectedIcon) * 31) + this.unSelectedIcon;
    }

    public final void setSelectedIcon(int i) {
        this.selectedIcon = i;
    }

    public final void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title = str;
    }

    public final void setUnSelectedIcon(int i) {
        this.unSelectedIcon = i;
    }

    @NotNull
    public String toString() {
        return "TabEntity(title=" + this.title + ", selectedIcon=" + this.selectedIcon + ", unSelectedIcon=" + this.unSelectedIcon + ")";
    }
}
