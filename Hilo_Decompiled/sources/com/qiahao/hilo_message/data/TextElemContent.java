package com.qiahao.hilo_message.data;

import androidx.annotation.Keep;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, d2 = {"Lcom/qiahao/hilo_message/data/TextElemContent;", "", ViewHierarchyConstants.TEXT_KEY, "", "atAccount", "", "Lcom/qiahao/hilo_message/data/TextElemContentAt;", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "getAtAccount", "()Ljava/util/List;", "setAtAccount", "(Ljava/util/List;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "hilo_message_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final /* data */ class TextElemContent {

    @Nullable
    private List<TextElemContentAt> atAccount;

    @Nullable
    private String text;

    /* JADX WARN: Multi-variable type inference failed */
    public TextElemContent() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TextElemContent copy$default(TextElemContent textElemContent, String str, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = textElemContent.text;
        }
        if ((i10 & 2) != 0) {
            list = textElemContent.atAccount;
        }
        return textElemContent.copy(str, list);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getText() {
        return this.text;
    }

    @Nullable
    public final List<TextElemContentAt> component2() {
        return this.atAccount;
    }

    @NotNull
    public final TextElemContent copy(@Nullable String text, @Nullable List<TextElemContentAt> atAccount) {
        return new TextElemContent(text, atAccount);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TextElemContent)) {
            return false;
        }
        TextElemContent textElemContent = (TextElemContent) other;
        return Intrinsics.areEqual(this.text, textElemContent.text) && Intrinsics.areEqual(this.atAccount, textElemContent.atAccount);
    }

    @Nullable
    public final List<TextElemContentAt> getAtAccount() {
        return this.atAccount;
    }

    @Nullable
    public final String getText() {
        return this.text;
    }

    public int hashCode() {
        String str = this.text;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        List<TextElemContentAt> list = this.atAccount;
        return hashCode + (list != null ? list.hashCode() : 0);
    }

    public final void setAtAccount(@Nullable List<TextElemContentAt> list) {
        this.atAccount = list;
    }

    public final void setText(@Nullable String str) {
        this.text = str;
    }

    @NotNull
    public String toString() {
        return "TextElemContent(text=" + this.text + ", atAccount=" + this.atAccount + ")";
    }

    public TextElemContent(@Nullable String str, @Nullable List<TextElemContentAt> list) {
        this.text = str;
        this.atAccount = list;
    }

    public /* synthetic */ TextElemContent(String str, List list, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : list);
    }
}
