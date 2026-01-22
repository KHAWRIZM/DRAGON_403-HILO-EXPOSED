package com.qiahao.base_common.model.svip;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import q2.a;

@Parcelize
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b+\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0089\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u000b\u0012\u001c\b\u0002\u0010\u000e\u001a\u0016\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fj\n\u0012\u0004\u0012\u00020\u0010\u0018\u0001`\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00104\u001a\u00020\tHÆ\u0003J\t\u00105\u001a\u00020\u000bHÆ\u0003J\t\u00106\u001a\u00020\u000bHÆ\u0003J\t\u00107\u001a\u00020\u000bHÆ\u0003J\u001d\u00108\u001a\u0016\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fj\n\u0012\u0004\u0012\u00020\u0010\u0018\u0001`\u0011HÆ\u0003J\u008b\u0001\u00109\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000b2\u001c\b\u0002\u0010\u000e\u001a\u0016\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fj\n\u0012\u0004\u0012\u00020\u0010\u0018\u0001`\u0011HÆ\u0001J\u0006\u0010:\u001a\u00020\tJ\u0013\u0010;\u001a\u00020\u000b2\b\u0010<\u001a\u0004\u0018\u00010=HÖ\u0003J\t\u0010>\u001a\u00020\tHÖ\u0001J\t\u0010?\u001a\u00020\u0003HÖ\u0001J\u0016\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020\tR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u0017R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0015\"\u0004\b\u001b\u0010\u0017R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0015\"\u0004\b\u001d\u0010\u0017R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0015\"\u0004\b\u001f\u0010\u0017R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010\f\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010%\"\u0004\b)\u0010'R\u001a\u0010\r\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010%\"\u0004\b*\u0010'R.\u0010\u000e\u001a\u0016\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fj\n\u0012\u0004\u0012\u00020\u0010\u0018\u0001`\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.¨\u0006E"}, d2 = {"Lcom/qiahao/base_common/model/svip/SvipPrivilege;", "Landroid/os/Parcelable;", "activeUrl", "", "activeUrl2", "title", "inActiveUrl", "inActiveUrl2", "type", "", "canSwitch", "", "userSwitch", "isHasPrivilege", "details", "Ljava/util/ArrayList;", "Lcom/qiahao/base_common/model/svip/SvipCardDetails;", "Lkotlin/collections/ArrayList;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZZZLjava/util/ArrayList;)V", "getActiveUrl", "()Ljava/lang/String;", "setActiveUrl", "(Ljava/lang/String;)V", "getActiveUrl2", "setActiveUrl2", "getTitle", "setTitle", "getInActiveUrl", "setInActiveUrl", "getInActiveUrl2", "setInActiveUrl2", "getType", "()I", "setType", "(I)V", "getCanSwitch", "()Z", "setCanSwitch", "(Z)V", "getUserSwitch", "setUserSwitch", "setHasPrivilege", "getDetails", "()Ljava/util/ArrayList;", "setDetails", "(Ljava/util/ArrayList;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final /* data */ class SvipPrivilege implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<SvipPrivilege> CREATOR = new Creator();

    @Nullable
    private String activeUrl;

    @Nullable
    private String activeUrl2;
    private boolean canSwitch;

    @Nullable
    private ArrayList<SvipCardDetails> details;

    @Nullable
    private String inActiveUrl;

    @Nullable
    private String inActiveUrl2;
    private boolean isHasPrivilege;

    @Nullable
    private String title;
    private int type;
    private boolean userSwitch;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class Creator implements Parcelable.Creator<SvipPrivilege> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SvipPrivilege createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            String readString5 = parcel.readString();
            int readInt = parcel.readInt();
            boolean z10 = parcel.readInt() != 0;
            boolean z11 = parcel.readInt() != 0;
            boolean z12 = parcel.readInt() != 0;
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int readInt2 = parcel.readInt();
                arrayList = new ArrayList(readInt2);
                for (int i10 = 0; i10 != readInt2; i10++) {
                    arrayList.add(SvipCardDetails.CREATOR.createFromParcel(parcel));
                }
            }
            return new SvipPrivilege(readString, readString2, readString3, readString4, readString5, readInt, z10, z11, z12, arrayList);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SvipPrivilege[] newArray(int i10) {
            return new SvipPrivilege[i10];
        }
    }

    public SvipPrivilege() {
        this(null, null, null, null, null, 0, false, false, false, null, 1023, null);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getActiveUrl() {
        return this.activeUrl;
    }

    @Nullable
    public final ArrayList<SvipCardDetails> component10() {
        return this.details;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getActiveUrl2() {
        return this.activeUrl2;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final String getInActiveUrl() {
        return this.inActiveUrl;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final String getInActiveUrl2() {
        return this.inActiveUrl2;
    }

    /* renamed from: component6, reason: from getter */
    public final int getType() {
        return this.type;
    }

    /* renamed from: component7, reason: from getter */
    public final boolean getCanSwitch() {
        return this.canSwitch;
    }

    /* renamed from: component8, reason: from getter */
    public final boolean getUserSwitch() {
        return this.userSwitch;
    }

    /* renamed from: component9, reason: from getter */
    public final boolean getIsHasPrivilege() {
        return this.isHasPrivilege;
    }

    @NotNull
    public final SvipPrivilege copy(@Nullable String activeUrl, @Nullable String activeUrl2, @Nullable String title, @Nullable String inActiveUrl, @Nullable String inActiveUrl2, int type, boolean canSwitch, boolean userSwitch, boolean isHasPrivilege, @Nullable ArrayList<SvipCardDetails> details) {
        return new SvipPrivilege(activeUrl, activeUrl2, title, inActiveUrl, inActiveUrl2, type, canSwitch, userSwitch, isHasPrivilege, details);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SvipPrivilege)) {
            return false;
        }
        SvipPrivilege svipPrivilege = (SvipPrivilege) other;
        return Intrinsics.areEqual(this.activeUrl, svipPrivilege.activeUrl) && Intrinsics.areEqual(this.activeUrl2, svipPrivilege.activeUrl2) && Intrinsics.areEqual(this.title, svipPrivilege.title) && Intrinsics.areEqual(this.inActiveUrl, svipPrivilege.inActiveUrl) && Intrinsics.areEqual(this.inActiveUrl2, svipPrivilege.inActiveUrl2) && this.type == svipPrivilege.type && this.canSwitch == svipPrivilege.canSwitch && this.userSwitch == svipPrivilege.userSwitch && this.isHasPrivilege == svipPrivilege.isHasPrivilege && Intrinsics.areEqual(this.details, svipPrivilege.details);
    }

    @Nullable
    public final String getActiveUrl() {
        return this.activeUrl;
    }

    @Nullable
    public final String getActiveUrl2() {
        return this.activeUrl2;
    }

    public final boolean getCanSwitch() {
        return this.canSwitch;
    }

    @Nullable
    public final ArrayList<SvipCardDetails> getDetails() {
        return this.details;
    }

    @Nullable
    public final String getInActiveUrl() {
        return this.inActiveUrl;
    }

    @Nullable
    public final String getInActiveUrl2() {
        return this.inActiveUrl2;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    public final int getType() {
        return this.type;
    }

    public final boolean getUserSwitch() {
        return this.userSwitch;
    }

    public int hashCode() {
        String str = this.activeUrl;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.activeUrl2;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.title;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.inActiveUrl;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.inActiveUrl2;
        int hashCode5 = (((((((((hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31) + this.type) * 31) + a.a(this.canSwitch)) * 31) + a.a(this.userSwitch)) * 31) + a.a(this.isHasPrivilege)) * 31;
        ArrayList<SvipCardDetails> arrayList = this.details;
        return hashCode5 + (arrayList != null ? arrayList.hashCode() : 0);
    }

    public final boolean isHasPrivilege() {
        return this.isHasPrivilege;
    }

    public final void setActiveUrl(@Nullable String str) {
        this.activeUrl = str;
    }

    public final void setActiveUrl2(@Nullable String str) {
        this.activeUrl2 = str;
    }

    public final void setCanSwitch(boolean z10) {
        this.canSwitch = z10;
    }

    public final void setDetails(@Nullable ArrayList<SvipCardDetails> arrayList) {
        this.details = arrayList;
    }

    public final void setHasPrivilege(boolean z10) {
        this.isHasPrivilege = z10;
    }

    public final void setInActiveUrl(@Nullable String str) {
        this.inActiveUrl = str;
    }

    public final void setInActiveUrl2(@Nullable String str) {
        this.inActiveUrl2 = str;
    }

    public final void setTitle(@Nullable String str) {
        this.title = str;
    }

    public final void setType(int i10) {
        this.type = i10;
    }

    public final void setUserSwitch(boolean z10) {
        this.userSwitch = z10;
    }

    @NotNull
    public String toString() {
        return "SvipPrivilege(activeUrl=" + this.activeUrl + ", activeUrl2=" + this.activeUrl2 + ", title=" + this.title + ", inActiveUrl=" + this.inActiveUrl + ", inActiveUrl2=" + this.inActiveUrl2 + ", type=" + this.type + ", canSwitch=" + this.canSwitch + ", userSwitch=" + this.userSwitch + ", isHasPrivilege=" + this.isHasPrivilege + ", details=" + this.details + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NotNull Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.activeUrl);
        dest.writeString(this.activeUrl2);
        dest.writeString(this.title);
        dest.writeString(this.inActiveUrl);
        dest.writeString(this.inActiveUrl2);
        dest.writeInt(this.type);
        dest.writeInt(this.canSwitch ? 1 : 0);
        dest.writeInt(this.userSwitch ? 1 : 0);
        dest.writeInt(this.isHasPrivilege ? 1 : 0);
        ArrayList<SvipCardDetails> arrayList = this.details;
        if (arrayList == null) {
            dest.writeInt(0);
            return;
        }
        dest.writeInt(1);
        dest.writeInt(arrayList.size());
        Iterator<SvipCardDetails> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(dest, flags);
        }
    }

    public SvipPrivilege(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, int i10, boolean z10, boolean z11, boolean z12, @Nullable ArrayList<SvipCardDetails> arrayList) {
        this.activeUrl = str;
        this.activeUrl2 = str2;
        this.title = str3;
        this.inActiveUrl = str4;
        this.inActiveUrl2 = str5;
        this.type = i10;
        this.canSwitch = z10;
        this.userSwitch = z11;
        this.isHasPrivilege = z12;
        this.details = arrayList;
    }

    public /* synthetic */ SvipPrivilege(String str, String str2, String str3, String str4, String str5, int i10, boolean z10, boolean z11, boolean z12, ArrayList arrayList, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : str2, (i11 & 4) != 0 ? null : str3, (i11 & 8) != 0 ? null : str4, (i11 & 16) != 0 ? null : str5, (i11 & 32) != 0 ? 0 : i10, (i11 & 64) != 0 ? false : z10, (i11 & 128) != 0 ? false : z11, (i11 & 256) == 0 ? z12 : false, (i11 & 512) == 0 ? arrayList : null);
    }
}
