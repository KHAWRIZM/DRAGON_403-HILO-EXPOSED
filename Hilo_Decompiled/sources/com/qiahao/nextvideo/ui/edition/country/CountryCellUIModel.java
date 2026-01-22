package com.qiahao.nextvideo.ui.edition.country;

import androidx.annotation.Keep;
import androidx.collection.c;
import com.qiahao.base_common.model.common.Country;
import com.qiahao.nextvideo.ui.home.discover.CountryActivity;
import com.qiahao.nextvideo.ui.reusable.uimodels.ImageUIModel;
import com.taobao.accs.common.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\b\u0087\b\u0018\u0000 %2\u00020\u0001:\u0001%B)\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\fJ\u0010\u0010\u000e\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J8\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0007HÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0014\u0010\fJ\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001c\u001a\u0004\b\u001d\u0010\fR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001c\u001a\u0004\b\u001e\u0010\fR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001f\u001a\u0004\b \u0010\u000fR\"\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010!\u001a\u0004\b\"\u0010\u0011\"\u0004\b#\u0010$¨\u0006&"}, d2 = {"Lcom/qiahao/nextvideo/ui/edition/country/CountryCellUIModel;", "", "", CountryActivity.COUNTRY_SHORT, "name", "Lcom/qiahao/nextvideo/ui/reusable/uimodels/ImageUIModel;", "pictureImageUIModel", "", Constants.KEY_HTTP_CODE, "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/qiahao/nextvideo/ui/reusable/uimodels/ImageUIModel;J)V", "component1", "()Ljava/lang/String;", "component2", "component3", "()Lcom/qiahao/nextvideo/ui/reusable/uimodels/ImageUIModel;", "component4", "()J", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/qiahao/nextvideo/ui/reusable/uimodels/ImageUIModel;J)Lcom/qiahao/nextvideo/ui/edition/country/CountryCellUIModel;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getShortName", "getName", "Lcom/qiahao/nextvideo/ui/reusable/uimodels/ImageUIModel;", "getPictureImageUIModel", "J", "getCode", "setCode", "(J)V", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class CountryCellUIModel {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private long code;

    @NotNull
    private final String name;

    @NotNull
    private final ImageUIModel pictureImageUIModel;

    @NotNull
    private final String shortName;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/qiahao/nextvideo/ui/edition/country/CountryCellUIModel$Companion;", "", "<init>", "()V", "init", "Lcom/qiahao/nextvideo/ui/edition/country/CountryCellUIModel;", "country", "Lcom/qiahao/base_common/model/common/Country;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final CountryCellUIModel init(@NotNull Country country) {
            Intrinsics.checkNotNullParameter(country, "country");
            return new CountryCellUIModel(country.getShortName(), country.getName(), new ImageUIModel(country.getIcon(), null, null, null, 0, 0, null, 126, null), country.getCode());
        }

        private Companion() {
        }
    }

    public CountryCellUIModel(@NotNull String str, @NotNull String str2, @NotNull ImageUIModel imageUIModel, long j) {
        Intrinsics.checkNotNullParameter(str, CountryActivity.COUNTRY_SHORT);
        Intrinsics.checkNotNullParameter(str2, "name");
        Intrinsics.checkNotNullParameter(imageUIModel, "pictureImageUIModel");
        this.shortName = str;
        this.name = str2;
        this.pictureImageUIModel = imageUIModel;
        this.code = j;
    }

    public static /* synthetic */ CountryCellUIModel copy$default(CountryCellUIModel countryCellUIModel, String str, String str2, ImageUIModel imageUIModel, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            str = countryCellUIModel.shortName;
        }
        if ((i & 2) != 0) {
            str2 = countryCellUIModel.name;
        }
        String str3 = str2;
        if ((i & 4) != 0) {
            imageUIModel = countryCellUIModel.pictureImageUIModel;
        }
        ImageUIModel imageUIModel2 = imageUIModel;
        if ((i & 8) != 0) {
            j = countryCellUIModel.code;
        }
        return countryCellUIModel.copy(str, str3, imageUIModel2, j);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getShortName() {
        return this.shortName;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final ImageUIModel getPictureImageUIModel() {
        return this.pictureImageUIModel;
    }

    /* renamed from: component4, reason: from getter */
    public final long getCode() {
        return this.code;
    }

    @NotNull
    public final CountryCellUIModel copy(@NotNull String shortName, @NotNull String name, @NotNull ImageUIModel pictureImageUIModel, long code) {
        Intrinsics.checkNotNullParameter(shortName, CountryActivity.COUNTRY_SHORT);
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(pictureImageUIModel, "pictureImageUIModel");
        return new CountryCellUIModel(shortName, name, pictureImageUIModel, code);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CountryCellUIModel)) {
            return false;
        }
        CountryCellUIModel countryCellUIModel = (CountryCellUIModel) other;
        return Intrinsics.areEqual(this.shortName, countryCellUIModel.shortName) && Intrinsics.areEqual(this.name, countryCellUIModel.name) && Intrinsics.areEqual(this.pictureImageUIModel, countryCellUIModel.pictureImageUIModel) && this.code == countryCellUIModel.code;
    }

    public final long getCode() {
        return this.code;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final ImageUIModel getPictureImageUIModel() {
        return this.pictureImageUIModel;
    }

    @NotNull
    public final String getShortName() {
        return this.shortName;
    }

    public int hashCode() {
        return (((((this.shortName.hashCode() * 31) + this.name.hashCode()) * 31) + this.pictureImageUIModel.hashCode()) * 31) + c.a(this.code);
    }

    public final void setCode(long j) {
        this.code = j;
    }

    @NotNull
    public String toString() {
        return "CountryCellUIModel(shortName=" + this.shortName + ", name=" + this.name + ", pictureImageUIModel=" + this.pictureImageUIModel + ", code=" + this.code + ")";
    }

    public /* synthetic */ CountryCellUIModel(String str, String str2, ImageUIModel imageUIModel, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, imageUIModel, (i & 8) != 0 ? 0L : j);
    }
}
