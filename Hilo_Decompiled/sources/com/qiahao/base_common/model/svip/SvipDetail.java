package com.qiahao.base_common.model.svip;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.collection.c;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Parcelize
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\u001c\b\u0002\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\u0012\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\u001c\b\u0002\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0006\u0010\u0015\u001a\u00020\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0016HÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\u0016\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0016R.\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006#"}, d2 = {"Lcom/qiahao/base_common/model/svip/SvipDetail;", "Landroid/os/Parcelable;", "details", "Ljava/util/ArrayList;", "Lcom/qiahao/base_common/model/svip/Details;", "Lkotlin/collections/ArrayList;", "points", "", "<init>", "(Ljava/util/ArrayList;J)V", "getDetails", "()Ljava/util/ArrayList;", "setDetails", "(Ljava/util/ArrayList;)V", "getPoints", "()J", "setPoints", "(J)V", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final /* data */ class SvipDetail implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<SvipDetail> CREATOR = new Creator();

    @Nullable
    private ArrayList<Details> details;
    private long points;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class Creator implements Parcelable.Creator<SvipDetail> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SvipDetail createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int readInt = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(readInt);
                for (int i10 = 0; i10 != readInt; i10++) {
                    arrayList2.add(Details.CREATOR.createFromParcel(parcel));
                }
                arrayList = arrayList2;
            }
            return new SvipDetail(arrayList, parcel.readLong());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SvipDetail[] newArray(int i10) {
            return new SvipDetail[i10];
        }
    }

    public SvipDetail() {
        this(null, 0L, 3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SvipDetail copy$default(SvipDetail svipDetail, ArrayList arrayList, long j10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            arrayList = svipDetail.details;
        }
        if ((i10 & 2) != 0) {
            j10 = svipDetail.points;
        }
        return svipDetail.copy(arrayList, j10);
    }

    @Nullable
    public final ArrayList<Details> component1() {
        return this.details;
    }

    /* renamed from: component2, reason: from getter */
    public final long getPoints() {
        return this.points;
    }

    @NotNull
    public final SvipDetail copy(@Nullable ArrayList<Details> details, long points) {
        return new SvipDetail(details, points);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SvipDetail)) {
            return false;
        }
        SvipDetail svipDetail = (SvipDetail) other;
        return Intrinsics.areEqual(this.details, svipDetail.details) && this.points == svipDetail.points;
    }

    @Nullable
    public final ArrayList<Details> getDetails() {
        return this.details;
    }

    public final long getPoints() {
        return this.points;
    }

    public int hashCode() {
        ArrayList<Details> arrayList = this.details;
        return ((arrayList == null ? 0 : arrayList.hashCode()) * 31) + c.a(this.points);
    }

    public final void setDetails(@Nullable ArrayList<Details> arrayList) {
        this.details = arrayList;
    }

    public final void setPoints(long j10) {
        this.points = j10;
    }

    @NotNull
    public String toString() {
        return "SvipDetail(details=" + this.details + ", points=" + this.points + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NotNull Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        ArrayList<Details> arrayList = this.details;
        if (arrayList == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(arrayList.size());
            Iterator<Details> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().writeToParcel(dest, flags);
            }
        }
        dest.writeLong(this.points);
    }

    public SvipDetail(@Nullable ArrayList<Details> arrayList, long j10) {
        this.details = arrayList;
        this.points = j10;
    }

    public /* synthetic */ SvipDetail(ArrayList arrayList, long j10, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? null : arrayList, (i10 & 2) != 0 ? 0L : j10);
    }
}
