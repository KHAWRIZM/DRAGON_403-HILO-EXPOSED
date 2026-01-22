package com.qiahao.nextvideo.data.game;

import android.os.Parcel;
import android.os.Parcelable;
import com.qiahao.nextvideo.data.service.agora.AgoraRtcService;
import com.taobao.accs.common.Constants;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import kotlinx.parcelize.Parcelize;
import okhttp3.internal.http2.Http2Connection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Parcelize
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\bO\n\u0002\u0010\u0002\n\u0002\b\u001d\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B³\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0016\u0010R\u001a\u00020S2\u0006\u0010T\u001a\u00020\u00032\u0006\u0010U\u001a\u00020\u0003J\u000b\u0010V\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010W\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010X\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010Y\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010Z\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010[\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\\\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010]\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010^\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010_\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010`\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010g\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010h\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010i\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010j\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010k\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010l\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010m\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010n\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jµ\u0002\u0010o\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0006\u0010p\u001a\u00020qJ\u0013\u0010r\u001a\u00020s2\b\u0010t\u001a\u0004\u0018\u00010uHÖ\u0003J\t\u0010v\u001a\u00020qHÖ\u0001J\t\u0010w\u001a\u00020\u0003HÖ\u0001J\u0016\u0010x\u001a\u00020S2\u0006\u0010y\u001a\u00020z2\u0006\u0010{\u001a\u00020qR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001f\"\u0004\b#\u0010!R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001f\"\u0004\b%\u0010!R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u001f\"\u0004\b'\u0010!R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u001f\"\u0004\b)\u0010!R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u001f\"\u0004\b+\u0010!R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u001f\"\u0004\b-\u0010!R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u001f\"\u0004\b/\u0010!R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u001f\"\u0004\b1\u0010!R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u001f\"\u0004\b3\u0010!R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u001f\"\u0004\b5\u0010!R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u001f\"\u0004\b7\u0010!R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u001f\"\u0004\b9\u0010!R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u001f\"\u0004\b;\u0010!R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\u001f\"\u0004\b=\u0010!R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\u001f\"\u0004\b?\u0010!R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u001f\"\u0004\bA\u0010!R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\u001f\"\u0004\bC\u0010!R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010\u001f\"\u0004\bE\u0010!R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010\u001f\"\u0004\bG\u0010!R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010\u001f\"\u0004\bI\u0010!R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010\u001f\"\u0004\bK\u0010!R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010\u001f\"\u0004\bM\u0010!R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010\u001f\"\u0004\bO\u0010!R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010\u001f\"\u0004\bQ\u0010!¨\u0006|"}, d2 = {"Lcom/qiahao/nextvideo/data/game/SkinData;", "Landroid/os/Parcelable;", "homeSvga", "", "tabButtonBg", "selectColor", "defaultColor", "selectIcon0", "defaultIcon0", "svga0", "topBg0", "selectIcon1", "defaultIcon1", "svga1", "topBg1", "selectIcon2", "defaultIcon2", "svga2", "topBg2", "selectIcon3", "defaultIcon3", "svga3", "topBg3", "selectIcon4", "defaultIcon4", "svga4", "topBg4", "sidebar", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getHomeSvga", "()Ljava/lang/String;", "setHomeSvga", "(Ljava/lang/String;)V", "getTabButtonBg", "setTabButtonBg", "getSelectColor", "setSelectColor", "getDefaultColor", "setDefaultColor", "getSelectIcon0", "setSelectIcon0", "getDefaultIcon0", "setDefaultIcon0", "getSvga0", "setSvga0", "getTopBg0", "setTopBg0", "getSelectIcon1", "setSelectIcon1", "getDefaultIcon1", "setDefaultIcon1", "getSvga1", "setSvga1", "getTopBg1", "setTopBg1", "getSelectIcon2", "setSelectIcon2", "getDefaultIcon2", "setDefaultIcon2", "getSvga2", "setSvga2", "getTopBg2", "setTopBg2", "getSelectIcon3", "setSelectIcon3", "getDefaultIcon3", "setDefaultIcon3", "getSvga3", "setSvga3", "getTopBg3", "setTopBg3", "getSelectIcon4", "setSelectIcon4", "getDefaultIcon4", "setDefaultIcon4", "getSvga4", "setSvga4", "getTopBg4", "setTopBg4", "getSidebar", "setSidebar", "resetValue", "", "parentPath", "fileName", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "dest", "Landroid/os/Parcel;", Constants.KEY_FLAGS, "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class SkinData implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<SkinData> CREATOR = new Creator();

    @Nullable
    private String defaultColor;

    @Nullable
    private String defaultIcon0;

    @Nullable
    private String defaultIcon1;

    @Nullable
    private String defaultIcon2;

    @Nullable
    private String defaultIcon3;

    @Nullable
    private String defaultIcon4;

    @Nullable
    private String homeSvga;

    @Nullable
    private String selectColor;

    @Nullable
    private String selectIcon0;

    @Nullable
    private String selectIcon1;

    @Nullable
    private String selectIcon2;

    @Nullable
    private String selectIcon3;

    @Nullable
    private String selectIcon4;

    @Nullable
    private String sidebar;

    @Nullable
    private String svga0;

    @Nullable
    private String svga1;

    @Nullable
    private String svga2;

    @Nullable
    private String svga3;

    @Nullable
    private String svga4;

    @Nullable
    private String tabButtonBg;

    @Nullable
    private String topBg0;

    @Nullable
    private String topBg1;

    @Nullable
    private String topBg2;

    @Nullable
    private String topBg3;

    @Nullable
    private String topBg4;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Creator implements Parcelable.Creator<SkinData> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SkinData createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new SkinData(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SkinData[] newArray(int i) {
            return new SkinData[i];
        }
    }

    public SkinData() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 33554431, null);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getHomeSvga() {
        return this.homeSvga;
    }

    @Nullable
    /* renamed from: component10, reason: from getter */
    public final String getDefaultIcon1() {
        return this.defaultIcon1;
    }

    @Nullable
    /* renamed from: component11, reason: from getter */
    public final String getSvga1() {
        return this.svga1;
    }

    @Nullable
    /* renamed from: component12, reason: from getter */
    public final String getTopBg1() {
        return this.topBg1;
    }

    @Nullable
    /* renamed from: component13, reason: from getter */
    public final String getSelectIcon2() {
        return this.selectIcon2;
    }

    @Nullable
    /* renamed from: component14, reason: from getter */
    public final String getDefaultIcon2() {
        return this.defaultIcon2;
    }

    @Nullable
    /* renamed from: component15, reason: from getter */
    public final String getSvga2() {
        return this.svga2;
    }

    @Nullable
    /* renamed from: component16, reason: from getter */
    public final String getTopBg2() {
        return this.topBg2;
    }

    @Nullable
    /* renamed from: component17, reason: from getter */
    public final String getSelectIcon3() {
        return this.selectIcon3;
    }

    @Nullable
    /* renamed from: component18, reason: from getter */
    public final String getDefaultIcon3() {
        return this.defaultIcon3;
    }

    @Nullable
    /* renamed from: component19, reason: from getter */
    public final String getSvga3() {
        return this.svga3;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getTabButtonBg() {
        return this.tabButtonBg;
    }

    @Nullable
    /* renamed from: component20, reason: from getter */
    public final String getTopBg3() {
        return this.topBg3;
    }

    @Nullable
    /* renamed from: component21, reason: from getter */
    public final String getSelectIcon4() {
        return this.selectIcon4;
    }

    @Nullable
    /* renamed from: component22, reason: from getter */
    public final String getDefaultIcon4() {
        return this.defaultIcon4;
    }

    @Nullable
    /* renamed from: component23, reason: from getter */
    public final String getSvga4() {
        return this.svga4;
    }

    @Nullable
    /* renamed from: component24, reason: from getter */
    public final String getTopBg4() {
        return this.topBg4;
    }

    @Nullable
    /* renamed from: component25, reason: from getter */
    public final String getSidebar() {
        return this.sidebar;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getSelectColor() {
        return this.selectColor;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final String getDefaultColor() {
        return this.defaultColor;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final String getSelectIcon0() {
        return this.selectIcon0;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final String getDefaultIcon0() {
        return this.defaultIcon0;
    }

    @Nullable
    /* renamed from: component7, reason: from getter */
    public final String getSvga0() {
        return this.svga0;
    }

    @Nullable
    /* renamed from: component8, reason: from getter */
    public final String getTopBg0() {
        return this.topBg0;
    }

    @Nullable
    /* renamed from: component9, reason: from getter */
    public final String getSelectIcon1() {
        return this.selectIcon1;
    }

    @NotNull
    public final SkinData copy(@Nullable String homeSvga, @Nullable String tabButtonBg, @Nullable String selectColor, @Nullable String defaultColor, @Nullable String selectIcon0, @Nullable String defaultIcon0, @Nullable String svga0, @Nullable String topBg0, @Nullable String selectIcon1, @Nullable String defaultIcon1, @Nullable String svga1, @Nullable String topBg1, @Nullable String selectIcon2, @Nullable String defaultIcon2, @Nullable String svga2, @Nullable String topBg2, @Nullable String selectIcon3, @Nullable String defaultIcon3, @Nullable String svga3, @Nullable String topBg3, @Nullable String selectIcon4, @Nullable String defaultIcon4, @Nullable String svga4, @Nullable String topBg4, @Nullable String sidebar) {
        return new SkinData(homeSvga, tabButtonBg, selectColor, defaultColor, selectIcon0, defaultIcon0, svga0, topBg0, selectIcon1, defaultIcon1, svga1, topBg1, selectIcon2, defaultIcon2, svga2, topBg2, selectIcon3, defaultIcon3, svga3, topBg3, selectIcon4, defaultIcon4, svga4, topBg4, sidebar);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SkinData)) {
            return false;
        }
        SkinData skinData = (SkinData) other;
        return Intrinsics.areEqual(this.homeSvga, skinData.homeSvga) && Intrinsics.areEqual(this.tabButtonBg, skinData.tabButtonBg) && Intrinsics.areEqual(this.selectColor, skinData.selectColor) && Intrinsics.areEqual(this.defaultColor, skinData.defaultColor) && Intrinsics.areEqual(this.selectIcon0, skinData.selectIcon0) && Intrinsics.areEqual(this.defaultIcon0, skinData.defaultIcon0) && Intrinsics.areEqual(this.svga0, skinData.svga0) && Intrinsics.areEqual(this.topBg0, skinData.topBg0) && Intrinsics.areEqual(this.selectIcon1, skinData.selectIcon1) && Intrinsics.areEqual(this.defaultIcon1, skinData.defaultIcon1) && Intrinsics.areEqual(this.svga1, skinData.svga1) && Intrinsics.areEqual(this.topBg1, skinData.topBg1) && Intrinsics.areEqual(this.selectIcon2, skinData.selectIcon2) && Intrinsics.areEqual(this.defaultIcon2, skinData.defaultIcon2) && Intrinsics.areEqual(this.svga2, skinData.svga2) && Intrinsics.areEqual(this.topBg2, skinData.topBg2) && Intrinsics.areEqual(this.selectIcon3, skinData.selectIcon3) && Intrinsics.areEqual(this.defaultIcon3, skinData.defaultIcon3) && Intrinsics.areEqual(this.svga3, skinData.svga3) && Intrinsics.areEqual(this.topBg3, skinData.topBg3) && Intrinsics.areEqual(this.selectIcon4, skinData.selectIcon4) && Intrinsics.areEqual(this.defaultIcon4, skinData.defaultIcon4) && Intrinsics.areEqual(this.svga4, skinData.svga4) && Intrinsics.areEqual(this.topBg4, skinData.topBg4) && Intrinsics.areEqual(this.sidebar, skinData.sidebar);
    }

    @Nullable
    public final String getDefaultColor() {
        return this.defaultColor;
    }

    @Nullable
    public final String getDefaultIcon0() {
        return this.defaultIcon0;
    }

    @Nullable
    public final String getDefaultIcon1() {
        return this.defaultIcon1;
    }

    @Nullable
    public final String getDefaultIcon2() {
        return this.defaultIcon2;
    }

    @Nullable
    public final String getDefaultIcon3() {
        return this.defaultIcon3;
    }

    @Nullable
    public final String getDefaultIcon4() {
        return this.defaultIcon4;
    }

    @Nullable
    public final String getHomeSvga() {
        return this.homeSvga;
    }

    @Nullable
    public final String getSelectColor() {
        return this.selectColor;
    }

    @Nullable
    public final String getSelectIcon0() {
        return this.selectIcon0;
    }

    @Nullable
    public final String getSelectIcon1() {
        return this.selectIcon1;
    }

    @Nullable
    public final String getSelectIcon2() {
        return this.selectIcon2;
    }

    @Nullable
    public final String getSelectIcon3() {
        return this.selectIcon3;
    }

    @Nullable
    public final String getSelectIcon4() {
        return this.selectIcon4;
    }

    @Nullable
    public final String getSidebar() {
        return this.sidebar;
    }

    @Nullable
    public final String getSvga0() {
        return this.svga0;
    }

    @Nullable
    public final String getSvga1() {
        return this.svga1;
    }

    @Nullable
    public final String getSvga2() {
        return this.svga2;
    }

    @Nullable
    public final String getSvga3() {
        return this.svga3;
    }

    @Nullable
    public final String getSvga4() {
        return this.svga4;
    }

    @Nullable
    public final String getTabButtonBg() {
        return this.tabButtonBg;
    }

    @Nullable
    public final String getTopBg0() {
        return this.topBg0;
    }

    @Nullable
    public final String getTopBg1() {
        return this.topBg1;
    }

    @Nullable
    public final String getTopBg2() {
        return this.topBg2;
    }

    @Nullable
    public final String getTopBg3() {
        return this.topBg3;
    }

    @Nullable
    public final String getTopBg4() {
        return this.topBg4;
    }

    public int hashCode() {
        String str = this.homeSvga;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.tabButtonBg;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.selectColor;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.defaultColor;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.selectIcon0;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.defaultIcon0;
        int hashCode6 = (hashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.svga0;
        int hashCode7 = (hashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.topBg0;
        int hashCode8 = (hashCode7 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.selectIcon1;
        int hashCode9 = (hashCode8 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.defaultIcon1;
        int hashCode10 = (hashCode9 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.svga1;
        int hashCode11 = (hashCode10 + (str11 == null ? 0 : str11.hashCode())) * 31;
        String str12 = this.topBg1;
        int hashCode12 = (hashCode11 + (str12 == null ? 0 : str12.hashCode())) * 31;
        String str13 = this.selectIcon2;
        int hashCode13 = (hashCode12 + (str13 == null ? 0 : str13.hashCode())) * 31;
        String str14 = this.defaultIcon2;
        int hashCode14 = (hashCode13 + (str14 == null ? 0 : str14.hashCode())) * 31;
        String str15 = this.svga2;
        int hashCode15 = (hashCode14 + (str15 == null ? 0 : str15.hashCode())) * 31;
        String str16 = this.topBg2;
        int hashCode16 = (hashCode15 + (str16 == null ? 0 : str16.hashCode())) * 31;
        String str17 = this.selectIcon3;
        int hashCode17 = (hashCode16 + (str17 == null ? 0 : str17.hashCode())) * 31;
        String str18 = this.defaultIcon3;
        int hashCode18 = (hashCode17 + (str18 == null ? 0 : str18.hashCode())) * 31;
        String str19 = this.svga3;
        int hashCode19 = (hashCode18 + (str19 == null ? 0 : str19.hashCode())) * 31;
        String str20 = this.topBg3;
        int hashCode20 = (hashCode19 + (str20 == null ? 0 : str20.hashCode())) * 31;
        String str21 = this.selectIcon4;
        int hashCode21 = (hashCode20 + (str21 == null ? 0 : str21.hashCode())) * 31;
        String str22 = this.defaultIcon4;
        int hashCode22 = (hashCode21 + (str22 == null ? 0 : str22.hashCode())) * 31;
        String str23 = this.svga4;
        int hashCode23 = (hashCode22 + (str23 == null ? 0 : str23.hashCode())) * 31;
        String str24 = this.topBg4;
        int hashCode24 = (hashCode23 + (str24 == null ? 0 : str24.hashCode())) * 31;
        String str25 = this.sidebar;
        return hashCode24 + (str25 != null ? str25.hashCode() : 0);
    }

    public final void resetValue(@NotNull String parentPath, @NotNull String fileName) {
        Intrinsics.checkNotNullParameter(parentPath, "parentPath");
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        String str = File.separator;
        this.homeSvga = parentPath + fileName + str + this.homeSvga;
        this.tabButtonBg = parentPath + fileName + str + this.tabButtonBg;
        this.sidebar = parentPath + fileName + str + this.sidebar;
        this.selectIcon0 = parentPath + fileName + str + this.selectIcon0;
        this.defaultIcon0 = parentPath + fileName + str + this.defaultIcon0;
        this.svga0 = parentPath + fileName + str + this.svga0;
        this.topBg0 = parentPath + fileName + str + this.topBg0;
        this.selectIcon1 = parentPath + fileName + str + this.selectIcon1;
        this.defaultIcon1 = parentPath + fileName + str + this.defaultIcon1;
        this.svga1 = parentPath + fileName + str + this.svga1;
        this.topBg1 = parentPath + fileName + str + this.topBg1;
        this.selectIcon2 = parentPath + fileName + str + this.selectIcon2;
        this.defaultIcon2 = parentPath + fileName + str + this.defaultIcon2;
        this.svga2 = parentPath + fileName + str + this.svga2;
        this.topBg2 = parentPath + fileName + str + this.topBg2;
        this.selectIcon3 = parentPath + fileName + str + this.selectIcon3;
        this.defaultIcon3 = parentPath + fileName + str + this.defaultIcon3;
        this.svga3 = parentPath + fileName + str + this.svga3;
        this.topBg3 = parentPath + fileName + str + this.topBg3;
        this.selectIcon4 = parentPath + fileName + str + this.selectIcon4;
        this.defaultIcon4 = parentPath + fileName + str + this.defaultIcon4;
        this.svga4 = parentPath + fileName + str + this.svga4;
        this.topBg4 = parentPath + fileName + str + this.topBg4;
    }

    public final void setDefaultColor(@Nullable String str) {
        this.defaultColor = str;
    }

    public final void setDefaultIcon0(@Nullable String str) {
        this.defaultIcon0 = str;
    }

    public final void setDefaultIcon1(@Nullable String str) {
        this.defaultIcon1 = str;
    }

    public final void setDefaultIcon2(@Nullable String str) {
        this.defaultIcon2 = str;
    }

    public final void setDefaultIcon3(@Nullable String str) {
        this.defaultIcon3 = str;
    }

    public final void setDefaultIcon4(@Nullable String str) {
        this.defaultIcon4 = str;
    }

    public final void setHomeSvga(@Nullable String str) {
        this.homeSvga = str;
    }

    public final void setSelectColor(@Nullable String str) {
        this.selectColor = str;
    }

    public final void setSelectIcon0(@Nullable String str) {
        this.selectIcon0 = str;
    }

    public final void setSelectIcon1(@Nullable String str) {
        this.selectIcon1 = str;
    }

    public final void setSelectIcon2(@Nullable String str) {
        this.selectIcon2 = str;
    }

    public final void setSelectIcon3(@Nullable String str) {
        this.selectIcon3 = str;
    }

    public final void setSelectIcon4(@Nullable String str) {
        this.selectIcon4 = str;
    }

    public final void setSidebar(@Nullable String str) {
        this.sidebar = str;
    }

    public final void setSvga0(@Nullable String str) {
        this.svga0 = str;
    }

    public final void setSvga1(@Nullable String str) {
        this.svga1 = str;
    }

    public final void setSvga2(@Nullable String str) {
        this.svga2 = str;
    }

    public final void setSvga3(@Nullable String str) {
        this.svga3 = str;
    }

    public final void setSvga4(@Nullable String str) {
        this.svga4 = str;
    }

    public final void setTabButtonBg(@Nullable String str) {
        this.tabButtonBg = str;
    }

    public final void setTopBg0(@Nullable String str) {
        this.topBg0 = str;
    }

    public final void setTopBg1(@Nullable String str) {
        this.topBg1 = str;
    }

    public final void setTopBg2(@Nullable String str) {
        this.topBg2 = str;
    }

    public final void setTopBg3(@Nullable String str) {
        this.topBg3 = str;
    }

    public final void setTopBg4(@Nullable String str) {
        this.topBg4 = str;
    }

    @NotNull
    public String toString() {
        return "SkinData(homeSvga=" + this.homeSvga + ", tabButtonBg=" + this.tabButtonBg + ", selectColor=" + this.selectColor + ", defaultColor=" + this.defaultColor + ", selectIcon0=" + this.selectIcon0 + ", defaultIcon0=" + this.defaultIcon0 + ", svga0=" + this.svga0 + ", topBg0=" + this.topBg0 + ", selectIcon1=" + this.selectIcon1 + ", defaultIcon1=" + this.defaultIcon1 + ", svga1=" + this.svga1 + ", topBg1=" + this.topBg1 + ", selectIcon2=" + this.selectIcon2 + ", defaultIcon2=" + this.defaultIcon2 + ", svga2=" + this.svga2 + ", topBg2=" + this.topBg2 + ", selectIcon3=" + this.selectIcon3 + ", defaultIcon3=" + this.defaultIcon3 + ", svga3=" + this.svga3 + ", topBg3=" + this.topBg3 + ", selectIcon4=" + this.selectIcon4 + ", defaultIcon4=" + this.defaultIcon4 + ", svga4=" + this.svga4 + ", topBg4=" + this.topBg4 + ", sidebar=" + this.sidebar + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NotNull Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.homeSvga);
        dest.writeString(this.tabButtonBg);
        dest.writeString(this.selectColor);
        dest.writeString(this.defaultColor);
        dest.writeString(this.selectIcon0);
        dest.writeString(this.defaultIcon0);
        dest.writeString(this.svga0);
        dest.writeString(this.topBg0);
        dest.writeString(this.selectIcon1);
        dest.writeString(this.defaultIcon1);
        dest.writeString(this.svga1);
        dest.writeString(this.topBg1);
        dest.writeString(this.selectIcon2);
        dest.writeString(this.defaultIcon2);
        dest.writeString(this.svga2);
        dest.writeString(this.topBg2);
        dest.writeString(this.selectIcon3);
        dest.writeString(this.defaultIcon3);
        dest.writeString(this.svga3);
        dest.writeString(this.topBg3);
        dest.writeString(this.selectIcon4);
        dest.writeString(this.defaultIcon4);
        dest.writeString(this.svga4);
        dest.writeString(this.topBg4);
        dest.writeString(this.sidebar);
    }

    public SkinData(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8, @Nullable String str9, @Nullable String str10, @Nullable String str11, @Nullable String str12, @Nullable String str13, @Nullable String str14, @Nullable String str15, @Nullable String str16, @Nullable String str17, @Nullable String str18, @Nullable String str19, @Nullable String str20, @Nullable String str21, @Nullable String str22, @Nullable String str23, @Nullable String str24, @Nullable String str25) {
        this.homeSvga = str;
        this.tabButtonBg = str2;
        this.selectColor = str3;
        this.defaultColor = str4;
        this.selectIcon0 = str5;
        this.defaultIcon0 = str6;
        this.svga0 = str7;
        this.topBg0 = str8;
        this.selectIcon1 = str9;
        this.defaultIcon1 = str10;
        this.svga1 = str11;
        this.topBg1 = str12;
        this.selectIcon2 = str13;
        this.defaultIcon2 = str14;
        this.svga2 = str15;
        this.topBg2 = str16;
        this.selectIcon3 = str17;
        this.defaultIcon3 = str18;
        this.svga3 = str19;
        this.topBg3 = str20;
        this.selectIcon4 = str21;
        this.defaultIcon4 = str22;
        this.svga4 = str23;
        this.topBg4 = str24;
        this.sidebar = str25;
    }

    public /* synthetic */ SkinData(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, String str21, String str22, String str23, String str24, String str25, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6, (i & 64) != 0 ? null : str7, (i & 128) != 0 ? null : str8, (i & 256) != 0 ? null : str9, (i & 512) != 0 ? null : str10, (i & LockFreeTaskQueueCore.MIN_ADD_SPIN_CAPACITY) != 0 ? null : str11, (i & 2048) != 0 ? null : str12, (i & 4096) != 0 ? null : str13, (i & 8192) != 0 ? null : str14, (i & 16384) != 0 ? null : str15, (i & 32768) != 0 ? null : str16, (i & 65536) != 0 ? null : str17, (i & 131072) != 0 ? null : str18, (i & 262144) != 0 ? null : str19, (i & 524288) != 0 ? null : str20, (i & AgoraRtcService.CUSTOM_REMOTE_VIDEO_IDLE) != 0 ? null : str21, (i & 2097152) != 0 ? null : str22, (i & 4194304) != 0 ? null : str23, (i & 8388608) != 0 ? null : str24, (i & Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE) != 0 ? null : str25);
    }
}
