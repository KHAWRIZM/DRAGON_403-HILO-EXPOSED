package com.qiahao.nextvideo.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.taobao.accs.common.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Parcelize
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 '2\u00020\u0001:\u0001'B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003J1\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0006\u0010\u001b\u001a\u00020\u0006J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020\u0006HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0006R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0007\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013¨\u0006("}, d2 = {"Lcom/qiahao/nextvideo/data/model/EditUserTextDataUIModel;", "Landroid/os/Parcelable;", "title", "", "editInputBoxText", "editInputBoxTextLimit", "", "editType", "<init>", "(Ljava/lang/String;Ljava/lang/String;II)V", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "getEditInputBoxText", "setEditInputBoxText", "getEditInputBoxTextLimit", "()I", "setEditInputBoxTextLimit", "(I)V", "getEditType", "setEditType", "component1", "component2", "component3", "component4", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", Constants.KEY_FLAGS, "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class EditUserTextDataUIModel implements Parcelable {
    public static final int NICKNAME = 1;
    public static final int SIGNATURE = 2;

    @NotNull
    private String editInputBoxText;
    private int editInputBoxTextLimit;
    private int editType;

    @NotNull
    private String title;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final Parcelable.Creator<EditUserTextDataUIModel> CREATOR = new Creator();

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/qiahao/nextvideo/data/model/EditUserTextDataUIModel$Companion;", "", "<init>", "()V", "NICKNAME", "", "SIGNATURE", "init", "Lcom/qiahao/nextvideo/data/model/EditUserTextDataUIModel;", "title", "", "editInputBoxText", "editInputBoxTextLimit", "editType", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final EditUserTextDataUIModel init(@NotNull String title, @NotNull String editInputBoxText, int editInputBoxTextLimit, int editType) {
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(editInputBoxText, "editInputBoxText");
            return new EditUserTextDataUIModel(title, editInputBoxText, editInputBoxTextLimit, editType);
        }

        private Companion() {
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Creator implements Parcelable.Creator<EditUserTextDataUIModel> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final EditUserTextDataUIModel createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new EditUserTextDataUIModel(parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final EditUserTextDataUIModel[] newArray(int i) {
            return new EditUserTextDataUIModel[i];
        }
    }

    public EditUserTextDataUIModel(@NotNull String str, @NotNull String str2, int i, int i2) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "editInputBoxText");
        this.title = str;
        this.editInputBoxText = str2;
        this.editInputBoxTextLimit = i;
        this.editType = i2;
    }

    public static /* synthetic */ EditUserTextDataUIModel copy$default(EditUserTextDataUIModel editUserTextDataUIModel, String str, String str2, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = editUserTextDataUIModel.title;
        }
        if ((i3 & 2) != 0) {
            str2 = editUserTextDataUIModel.editInputBoxText;
        }
        if ((i3 & 4) != 0) {
            i = editUserTextDataUIModel.editInputBoxTextLimit;
        }
        if ((i3 & 8) != 0) {
            i2 = editUserTextDataUIModel.editType;
        }
        return editUserTextDataUIModel.copy(str, str2, i, i2);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getEditInputBoxText() {
        return this.editInputBoxText;
    }

    /* renamed from: component3, reason: from getter */
    public final int getEditInputBoxTextLimit() {
        return this.editInputBoxTextLimit;
    }

    /* renamed from: component4, reason: from getter */
    public final int getEditType() {
        return this.editType;
    }

    @NotNull
    public final EditUserTextDataUIModel copy(@NotNull String title, @NotNull String editInputBoxText, int editInputBoxTextLimit, int editType) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(editInputBoxText, "editInputBoxText");
        return new EditUserTextDataUIModel(title, editInputBoxText, editInputBoxTextLimit, editType);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EditUserTextDataUIModel)) {
            return false;
        }
        EditUserTextDataUIModel editUserTextDataUIModel = (EditUserTextDataUIModel) other;
        return Intrinsics.areEqual(this.title, editUserTextDataUIModel.title) && Intrinsics.areEqual(this.editInputBoxText, editUserTextDataUIModel.editInputBoxText) && this.editInputBoxTextLimit == editUserTextDataUIModel.editInputBoxTextLimit && this.editType == editUserTextDataUIModel.editType;
    }

    @NotNull
    public final String getEditInputBoxText() {
        return this.editInputBoxText;
    }

    public final int getEditInputBoxTextLimit() {
        return this.editInputBoxTextLimit;
    }

    public final int getEditType() {
        return this.editType;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        return (((((this.title.hashCode() * 31) + this.editInputBoxText.hashCode()) * 31) + this.editInputBoxTextLimit) * 31) + this.editType;
    }

    public final void setEditInputBoxText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.editInputBoxText = str;
    }

    public final void setEditInputBoxTextLimit(int i) {
        this.editInputBoxTextLimit = i;
    }

    public final void setEditType(int i) {
        this.editType = i;
    }

    public final void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title = str;
    }

    @NotNull
    public String toString() {
        return "EditUserTextDataUIModel(title=" + this.title + ", editInputBoxText=" + this.editInputBoxText + ", editInputBoxTextLimit=" + this.editInputBoxTextLimit + ", editType=" + this.editType + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NotNull Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.title);
        dest.writeString(this.editInputBoxText);
        dest.writeInt(this.editInputBoxTextLimit);
        dest.writeInt(this.editType);
    }
}
