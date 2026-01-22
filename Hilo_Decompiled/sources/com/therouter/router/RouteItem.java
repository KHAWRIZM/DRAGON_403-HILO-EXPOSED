package com.therouter.router;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.taobao.accs.common.Constants;
import com.tencent.qcloud.tuicore.TUIConstants;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\t\b\u0007\u0018\u0000 -2\u00020\u00012\u00020\u0002:\u0001-B\u0007\b\u0016¢\u0006\u0002\u0010\u0003B\u000f\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B'\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0002\u0010\fJ\u001b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0016H\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ\u0016\u0010 \u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\bJ\u0006\u0010#\u001a\u00020\u0000J\b\u0010$\u001a\u00020%H\u0016J\u0006\u0010&\u001a\u00020\u0016J\u000e\u0010'\u001a\u00020\u001c2\u0006\u0010(\u001a\u00020\u0005J\b\u0010)\u001a\u00020\bH\u0016J\u0018\u0010*\u001a\u00020\u001c2\u0006\u0010+\u001a\u00020\u00052\u0006\u0010,\u001a\u00020%H\u0016R\u001a\u0010\n\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\t\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010R\u001a\u0010\u000b\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000e\"\u0004\b\u001a\u0010\u0010¨\u0006."}, d2 = {"Lcom/therouter/router/RouteItem;", "Landroid/os/Parcelable;", "Ljava/io/Serializable;", "()V", "p", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", TUIConstants.TUICalling.PARAM_NAME_AUDIO_PATH, "", "className", "action", "description", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAction", "()Ljava/lang/String;", "setAction", "(Ljava/lang/String;)V", "getClassName", "setClassName", "getDescription", "setDescription", "extras", "Landroid/os/Bundle;", "params", "Ljava/util/HashMap;", "getPath", "setPath", "addAll", "", "bundle", "addAll$router_release", "(Landroid/os/Bundle;)Lkotlin/Unit;", "addParams", "key", "value", "copy", "describeContents", "", "getExtras", "readFromParcel", "source", "toString", "writeToParcel", "dest", Constants.KEY_FLAGS, "CREATOR", "router_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nRouteItem.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RouteItem.kt\ncom/therouter/router/RouteItem\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,160:1\n1#2:161\n215#3,2:162\n*S KotlinDebug\n*F\n+ 1 RouteItem.kt\ncom/therouter/router/RouteItem\n*L\n65#1:162,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class RouteItem implements Parcelable, Serializable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private String action;

    @NotNull
    private String className;

    @NotNull
    private String description;

    @NotNull
    private Bundle extras;

    @NotNull
    private HashMap<String, String> params;

    @NotNull
    private String path;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/therouter/router/RouteItem$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/therouter/router/RouteItem;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/therouter/router/RouteItem;", "router_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* renamed from: com.therouter.router.RouteItem$CREATOR, reason: from kotlin metadata */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public static final class Companion implements Parcelable.Creator<RouteItem> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public RouteItem createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new RouteItem(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public RouteItem[] newArray(int size) {
            return new RouteItem[size];
        }
    }

    public RouteItem() {
        this.path = "";
        this.className = "";
        this.action = "";
        this.description = "";
        this.params = new HashMap<>();
        this.extras = new Bundle();
    }

    @Nullable
    public final Unit addAll$router_release(@Nullable Bundle bundle) {
        if (bundle != null) {
            this.extras.putAll(bundle);
            return Unit.INSTANCE;
        }
        return null;
    }

    public final void addParams(@NotNull String key, @NotNull String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        this.extras.putString(key, value);
    }

    @NotNull
    public final RouteItem copy() {
        RouteItem routeItem = new RouteItem();
        routeItem.extras.putAll(this.extras);
        routeItem.params.putAll(this.params);
        routeItem.description = this.description;
        routeItem.action = this.action;
        routeItem.className = this.className;
        routeItem.path = this.path;
        return routeItem;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    public final String getAction() {
        return this.action;
    }

    @NotNull
    public final String getClassName() {
        return this.className;
    }

    @NotNull
    public final String getDescription() {
        return this.description;
    }

    @NotNull
    public final Bundle getExtras() {
        for (Map.Entry<String, String> entry : this.params.entrySet()) {
            if (!this.extras.keySet().contains(entry.getKey())) {
                this.extras.putString(entry.getKey(), entry.getValue());
            }
        }
        return this.extras;
    }

    @NotNull
    public final String getPath() {
        return this.path;
    }

    public final void readFromParcel(@NotNull Parcel source) {
        HashMap<String, String> hashMap;
        Intrinsics.checkNotNullParameter(source, "source");
        String readString = source.readString();
        Intrinsics.checkNotNull(readString);
        this.path = readString;
        String readString2 = source.readString();
        Intrinsics.checkNotNull(readString2);
        this.className = readString2;
        String readString3 = source.readString();
        Intrinsics.checkNotNull(readString3);
        this.action = readString3;
        String readString4 = source.readString();
        Intrinsics.checkNotNull(readString4);
        this.description = readString4;
        Serializable readSerializable = source.readSerializable();
        if (readSerializable instanceof HashMap) {
            hashMap = (HashMap) readSerializable;
        } else {
            hashMap = new HashMap<>();
        }
        this.params = hashMap;
        Bundle readBundle = source.readBundle(RouteItem.class.getClassLoader());
        if (readBundle == null) {
            readBundle = new Bundle();
        }
        this.extras = readBundle;
    }

    public final void setAction(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.action = str;
    }

    public final void setClassName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.className = str;
    }

    public final void setDescription(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.description = str;
    }

    public final void setPath(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.path = str;
    }

    @NotNull
    public String toString() {
        return "RouteItem(path='" + this.path + "', className='" + this.className + "', action='" + this.action + "', description='" + this.description + "', extras=" + this.extras + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.path);
        dest.writeString(this.className);
        dest.writeString(this.action);
        dest.writeString(this.description);
        dest.writeSerializable(this.params);
        dest.writeBundle(this.extras);
    }

    public RouteItem(@NotNull Parcel parcel) {
        HashMap<String, String> hashMap;
        Intrinsics.checkNotNullParameter(parcel, "p");
        this.path = "";
        this.className = "";
        this.action = "";
        this.description = "";
        this.params = new HashMap<>();
        this.extras = new Bundle();
        String readString = parcel.readString();
        this.path = readString == null ? "" : readString;
        String readString2 = parcel.readString();
        this.className = readString2 == null ? "" : readString2;
        String readString3 = parcel.readString();
        this.action = readString3 == null ? "" : readString3;
        String readString4 = parcel.readString();
        this.description = readString4 != null ? readString4 : "";
        Serializable readSerializable = parcel.readSerializable();
        if (readSerializable instanceof HashMap) {
            hashMap = (HashMap) readSerializable;
        } else {
            hashMap = new HashMap<>();
        }
        this.params = hashMap;
        Bundle readBundle = parcel.readBundle(ClassLoader.getSystemClassLoader());
        this.extras = readBundle == null ? new Bundle() : readBundle;
    }

    public RouteItem(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkNotNullParameter(str, TUIConstants.TUICalling.PARAM_NAME_AUDIO_PATH);
        Intrinsics.checkNotNullParameter(str2, "className");
        Intrinsics.checkNotNullParameter(str3, "action");
        Intrinsics.checkNotNullParameter(str4, "description");
        this.path = "";
        this.className = "";
        this.action = "";
        this.description = "";
        this.params = new HashMap<>();
        this.extras = new Bundle();
        this.path = str;
        this.className = str2;
        this.action = str3;
        this.description = str4;
    }
}
