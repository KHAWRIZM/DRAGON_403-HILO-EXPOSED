package com.qiahao.base_common.model;

import android.os.Parcel;
import android.os.Parcelable;
import anetwork.channel.unified.e;
import com.amazonaws.services.s3.internal.Constants;
import com.liulishuo.okdownload.DownloadTask;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import com.qiahao.base_common.model.cp.TextStyles;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Parcelize
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\bh\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0097\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000b\u0012\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u001f\u0010 J\u0006\u0010e\u001a\u00020\tJ\u0006\u0010f\u001a\u00020\tJ\u0006\u0010g\u001a\u00020\tJ\u0006\u0010h\u001a\u00020\tJ\u0010\u0010i\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\"J\t\u0010j\u001a\u00020\u0005HÆ\u0003J\u0010\u0010k\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010+J\u0010\u0010l\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u00100J\u000b\u0010m\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010n\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010o\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010p\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\t\u0010q\u001a\u00020\u0003HÆ\u0003J\u000b\u0010r\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u0010\u0010s\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u00100J\u000b\u0010t\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u0011\u0010u\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0014HÆ\u0003J\u0010\u0010v\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010+J\u0010\u0010w\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\"J\u0010\u0010x\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\"J\u0010\u0010y\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\"J\u0010\u0010z\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\"J\u0011\u0010{\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u0014HÆ\u0003J\u000b\u0010|\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u0010\u0010}\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u00100J\u0010\u0010~\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\"J\u009f\u0002\u0010\u007f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000b2\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u00142\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0003\u0010\u0080\u0001J\u0007\u0010\u0081\u0001\u001a\u00020\u0003J\u0016\u0010\u0082\u0001\u001a\u00020\t2\n\u0010\u0083\u0001\u001a\u0005\u0018\u00010\u0084\u0001HÖ\u0003J\n\u0010\u0085\u0001\u001a\u00020\u0003HÖ\u0001J\n\u0010\u0086\u0001\u001a\u00020\u000bHÖ\u0001J\u001b\u0010\u0087\u0001\u001a\u00030\u0088\u00012\b\u0010\u0089\u0001\u001a\u00030\u008a\u00012\u0007\u0010\u008b\u0001\u001a\u00020\u0003R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010%\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010.\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001e\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0010\n\u0002\u00103\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001c\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00105\"\u0004\b9\u00107R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u00105\"\u0004\b;\u00107R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u00105\"\u0004\b=\u00107R\u001a\u0010\u000f\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u00105\"\u0004\bC\u00107R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0010\n\u0002\u00103\u001a\u0004\bD\u00100\"\u0004\bE\u00102R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u00105\"\u0004\bG\u00107R\"\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010.\u001a\u0004\bL\u0010+\"\u0004\bM\u0010-R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010%\u001a\u0004\bN\u0010\"\"\u0004\bO\u0010$R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010%\u001a\u0004\bP\u0010\"\"\u0004\bQ\u0010$R\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010%\u001a\u0004\bR\u0010\"\"\u0004\bS\u0010$R\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010%\u001a\u0004\bT\u0010\"\"\u0004\bU\u0010$R\"\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010I\"\u0004\bW\u0010KR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u00105\"\u0004\bY\u00107R\u001e\u0010\u001d\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0010\n\u0002\u00103\u001a\u0004\bZ\u00100\"\u0004\b[\u00102R\u001e\u0010\u001e\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010%\u001a\u0004\b\\\u0010\"\"\u0004\b]\u0010$R\u001a\u0010^\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR\u001a\u0010b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bc\u0010?\"\u0004\bd\u0010A¨\u0006\u008c\u0001"}, d2 = {"Lcom/qiahao/base_common/model/GiftData;", "Landroid/os/Parcelable;", "column", "", "diamondNum", "", "giftId", "", "group_broadcast", "", "iconUrl", "", "musicUrl", "name", "receiverAvatar", "second", "senderAvatar", "showEntry", "svgaUrl", "tags", "", "bagId", "count", "remainDays", "resType", "giftType", "textStyleList", "Lcom/qiahao/base_common/model/cp/TextStyles;", "giftText", "hasGiftText", "type", "<init>", "(Ljava/lang/Integer;FLjava/lang/Long;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/util/List;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;)V", "getColumn", "()Ljava/lang/Integer;", "setColumn", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getDiamondNum", "()F", "setDiamondNum", "(F)V", "getGiftId", "()Ljava/lang/Long;", "setGiftId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getGroup_broadcast", "()Ljava/lang/Boolean;", "setGroup_broadcast", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getIconUrl", "()Ljava/lang/String;", "setIconUrl", "(Ljava/lang/String;)V", "getMusicUrl", "setMusicUrl", "getName", "setName", "getReceiverAvatar", "setReceiverAvatar", "getSecond", "()I", "setSecond", "(I)V", "getSenderAvatar", "setSenderAvatar", "getShowEntry", "setShowEntry", "getSvgaUrl", "setSvgaUrl", "getTags", "()Ljava/util/List;", "setTags", "(Ljava/util/List;)V", "getBagId", "setBagId", "getCount", "setCount", "getRemainDays", "setRemainDays", "getResType", "setResType", "getGiftType", "setGiftType", "getTextStyleList", "setTextStyleList", "getGiftText", "setGiftText", "getHasGiftText", "setHasGiftText", "getType", "setType", "isSelected", "()Z", "setSelected", "(Z)V", "num", "getNum", "setNum", "isMedal", "isWeek", "is3D", "isActivity", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "copy", "(Ljava/lang/Integer;FLjava/lang/Long;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/util/List;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;)Lcom/qiahao/base_common/model/GiftData;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nGiftData.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GiftData.kt\ncom/qiahao/base_common/model/GiftData\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,87:1\n1869#2,2:88\n1869#2,2:90\n1869#2,2:92\n1869#2,2:94\n*S KotlinDebug\n*F\n+ 1 GiftData.kt\ncom/qiahao/base_common/model/GiftData\n*L\n40#1:88,2\n53#1:90,2\n66#1:92,2\n79#1:94,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final /* data */ class GiftData implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<GiftData> CREATOR = new Creator();

    @Nullable
    private Long bagId;

    @Nullable
    private Integer column;

    @Nullable
    private Integer count;
    private float diamondNum;

    @Nullable
    private Long giftId;

    @Nullable
    private String giftText;

    @Nullable
    private Integer giftType;

    @Nullable
    private Boolean group_broadcast;

    @Nullable
    private Boolean hasGiftText;

    @Nullable
    private String iconUrl;
    private boolean isSelected;

    @Nullable
    private String musicUrl;

    @Nullable
    private String name;
    private int num;

    @Nullable
    private String receiverAvatar;

    @Nullable
    private Integer remainDays;

    @Nullable
    private Integer resType;
    private int second;

    @Nullable
    private String senderAvatar;

    @Nullable
    private Boolean showEntry;

    @Nullable
    private String svgaUrl;

    @Nullable
    private List<Integer> tags;

    @Nullable
    private List<TextStyles> textStyleList;

    @Nullable
    private Integer type;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class Creator implements Parcelable.Creator<GiftData> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final GiftData createFromParcel(Parcel parcel) {
            Boolean valueOf;
            Boolean valueOf2;
            ArrayList arrayList;
            ArrayList arrayList2;
            ArrayList arrayList3;
            Boolean valueOf3;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            Integer valueOf4 = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            float readFloat = parcel.readFloat();
            Long valueOf5 = parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong());
            if (parcel.readInt() == 0) {
                valueOf = null;
            } else {
                valueOf = Boolean.valueOf(parcel.readInt() != 0);
            }
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            int readInt = parcel.readInt();
            String readString5 = parcel.readString();
            if (parcel.readInt() == 0) {
                valueOf2 = null;
            } else {
                valueOf2 = Boolean.valueOf(parcel.readInt() != 0);
            }
            String readString6 = parcel.readString();
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int readInt2 = parcel.readInt();
                ArrayList arrayList4 = new ArrayList(readInt2);
                int i10 = 0;
                while (i10 != readInt2) {
                    arrayList4.add(Integer.valueOf(parcel.readInt()));
                    i10++;
                    readInt2 = readInt2;
                }
                arrayList = arrayList4;
            }
            Long valueOf6 = parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong());
            Integer valueOf7 = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            Integer valueOf8 = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            Integer valueOf9 = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            Integer valueOf10 = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            if (parcel.readInt() == 0) {
                arrayList2 = arrayList;
                arrayList3 = null;
            } else {
                int readInt3 = parcel.readInt();
                ArrayList arrayList5 = new ArrayList(readInt3);
                arrayList2 = arrayList;
                int i11 = 0;
                while (i11 != readInt3) {
                    arrayList5.add(TextStyles.CREATOR.createFromParcel(parcel));
                    i11++;
                    readInt3 = readInt3;
                }
                arrayList3 = arrayList5;
            }
            String readString7 = parcel.readString();
            if (parcel.readInt() == 0) {
                valueOf3 = null;
            } else {
                valueOf3 = Boolean.valueOf(parcel.readInt() != 0);
            }
            return new GiftData(valueOf4, readFloat, valueOf5, valueOf, readString, readString2, readString3, readString4, readInt, readString5, valueOf2, readString6, arrayList2, valueOf6, valueOf7, valueOf8, valueOf9, valueOf10, arrayList3, readString7, valueOf3, parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final GiftData[] newArray(int i10) {
            return new GiftData[i10];
        }
    }

    public GiftData() {
        this(null, DownloadProgress.UNKNOWN_PROGRESS, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, 4194303, null);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final Integer getColumn() {
        return this.column;
    }

    @Nullable
    /* renamed from: component10, reason: from getter */
    public final String getSenderAvatar() {
        return this.senderAvatar;
    }

    @Nullable
    /* renamed from: component11, reason: from getter */
    public final Boolean getShowEntry() {
        return this.showEntry;
    }

    @Nullable
    /* renamed from: component12, reason: from getter */
    public final String getSvgaUrl() {
        return this.svgaUrl;
    }

    @Nullable
    public final List<Integer> component13() {
        return this.tags;
    }

    @Nullable
    /* renamed from: component14, reason: from getter */
    public final Long getBagId() {
        return this.bagId;
    }

    @Nullable
    /* renamed from: component15, reason: from getter */
    public final Integer getCount() {
        return this.count;
    }

    @Nullable
    /* renamed from: component16, reason: from getter */
    public final Integer getRemainDays() {
        return this.remainDays;
    }

    @Nullable
    /* renamed from: component17, reason: from getter */
    public final Integer getResType() {
        return this.resType;
    }

    @Nullable
    /* renamed from: component18, reason: from getter */
    public final Integer getGiftType() {
        return this.giftType;
    }

    @Nullable
    public final List<TextStyles> component19() {
        return this.textStyleList;
    }

    /* renamed from: component2, reason: from getter */
    public final float getDiamondNum() {
        return this.diamondNum;
    }

    @Nullable
    /* renamed from: component20, reason: from getter */
    public final String getGiftText() {
        return this.giftText;
    }

    @Nullable
    /* renamed from: component21, reason: from getter */
    public final Boolean getHasGiftText() {
        return this.hasGiftText;
    }

    @Nullable
    /* renamed from: component22, reason: from getter */
    public final Integer getType() {
        return this.type;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final Long getGiftId() {
        return this.giftId;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final Boolean getGroup_broadcast() {
        return this.group_broadcast;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final String getIconUrl() {
        return this.iconUrl;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final String getMusicUrl() {
        return this.musicUrl;
    }

    @Nullable
    /* renamed from: component7, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @Nullable
    /* renamed from: component8, reason: from getter */
    public final String getReceiverAvatar() {
        return this.receiverAvatar;
    }

    /* renamed from: component9, reason: from getter */
    public final int getSecond() {
        return this.second;
    }

    @NotNull
    public final GiftData copy(@Nullable Integer column, float diamondNum, @Nullable Long giftId, @Nullable Boolean group_broadcast, @Nullable String iconUrl, @Nullable String musicUrl, @Nullable String name, @Nullable String receiverAvatar, int second, @Nullable String senderAvatar, @Nullable Boolean showEntry, @Nullable String svgaUrl, @Nullable List<Integer> tags, @Nullable Long bagId, @Nullable Integer count, @Nullable Integer remainDays, @Nullable Integer resType, @Nullable Integer giftType, @Nullable List<TextStyles> textStyleList, @Nullable String giftText, @Nullable Boolean hasGiftText, @Nullable Integer type) {
        return new GiftData(column, diamondNum, giftId, group_broadcast, iconUrl, musicUrl, name, receiverAvatar, second, senderAvatar, showEntry, svgaUrl, tags, bagId, count, remainDays, resType, giftType, textStyleList, giftText, hasGiftText, type);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GiftData)) {
            return false;
        }
        GiftData giftData = (GiftData) other;
        return Intrinsics.areEqual(this.column, giftData.column) && Float.compare(this.diamondNum, giftData.diamondNum) == 0 && Intrinsics.areEqual(this.giftId, giftData.giftId) && Intrinsics.areEqual(this.group_broadcast, giftData.group_broadcast) && Intrinsics.areEqual(this.iconUrl, giftData.iconUrl) && Intrinsics.areEqual(this.musicUrl, giftData.musicUrl) && Intrinsics.areEqual(this.name, giftData.name) && Intrinsics.areEqual(this.receiverAvatar, giftData.receiverAvatar) && this.second == giftData.second && Intrinsics.areEqual(this.senderAvatar, giftData.senderAvatar) && Intrinsics.areEqual(this.showEntry, giftData.showEntry) && Intrinsics.areEqual(this.svgaUrl, giftData.svgaUrl) && Intrinsics.areEqual(this.tags, giftData.tags) && Intrinsics.areEqual(this.bagId, giftData.bagId) && Intrinsics.areEqual(this.count, giftData.count) && Intrinsics.areEqual(this.remainDays, giftData.remainDays) && Intrinsics.areEqual(this.resType, giftData.resType) && Intrinsics.areEqual(this.giftType, giftData.giftType) && Intrinsics.areEqual(this.textStyleList, giftData.textStyleList) && Intrinsics.areEqual(this.giftText, giftData.giftText) && Intrinsics.areEqual(this.hasGiftText, giftData.hasGiftText) && Intrinsics.areEqual(this.type, giftData.type);
    }

    @Nullable
    public final Long getBagId() {
        return this.bagId;
    }

    @Nullable
    public final Integer getColumn() {
        return this.column;
    }

    @Nullable
    public final Integer getCount() {
        return this.count;
    }

    public final float getDiamondNum() {
        return this.diamondNum;
    }

    @Nullable
    public final Long getGiftId() {
        return this.giftId;
    }

    @Nullable
    public final String getGiftText() {
        return this.giftText;
    }

    @Nullable
    public final Integer getGiftType() {
        return this.giftType;
    }

    @Nullable
    public final Boolean getGroup_broadcast() {
        return this.group_broadcast;
    }

    @Nullable
    public final Boolean getHasGiftText() {
        return this.hasGiftText;
    }

    @Nullable
    public final String getIconUrl() {
        return this.iconUrl;
    }

    @Nullable
    public final String getMusicUrl() {
        return this.musicUrl;
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    public final int getNum() {
        return this.num;
    }

    @Nullable
    public final String getReceiverAvatar() {
        return this.receiverAvatar;
    }

    @Nullable
    public final Integer getRemainDays() {
        return this.remainDays;
    }

    @Nullable
    public final Integer getResType() {
        return this.resType;
    }

    public final int getSecond() {
        return this.second;
    }

    @Nullable
    public final String getSenderAvatar() {
        return this.senderAvatar;
    }

    @Nullable
    public final Boolean getShowEntry() {
        return this.showEntry;
    }

    @Nullable
    public final String getSvgaUrl() {
        return this.svgaUrl;
    }

    @Nullable
    public final List<Integer> getTags() {
        return this.tags;
    }

    @Nullable
    public final List<TextStyles> getTextStyleList() {
        return this.textStyleList;
    }

    @Nullable
    public final Integer getType() {
        return this.type;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int hashCode5;
        int hashCode6;
        int hashCode7;
        int hashCode8;
        int hashCode9;
        int hashCode10;
        int hashCode11;
        int hashCode12;
        int hashCode13;
        int hashCode14;
        int hashCode15;
        int hashCode16;
        int hashCode17;
        int hashCode18;
        int hashCode19;
        Integer num = this.column;
        int i10 = 0;
        if (num == null) {
            hashCode = 0;
        } else {
            hashCode = num.hashCode();
        }
        int floatToIntBits = ((hashCode * 31) + Float.floatToIntBits(this.diamondNum)) * 31;
        Long l10 = this.giftId;
        if (l10 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = l10.hashCode();
        }
        int i11 = (floatToIntBits + hashCode2) * 31;
        Boolean bool = this.group_broadcast;
        if (bool == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = bool.hashCode();
        }
        int i12 = (i11 + hashCode3) * 31;
        String str = this.iconUrl;
        if (str == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = str.hashCode();
        }
        int i13 = (i12 + hashCode4) * 31;
        String str2 = this.musicUrl;
        if (str2 == null) {
            hashCode5 = 0;
        } else {
            hashCode5 = str2.hashCode();
        }
        int i14 = (i13 + hashCode5) * 31;
        String str3 = this.name;
        if (str3 == null) {
            hashCode6 = 0;
        } else {
            hashCode6 = str3.hashCode();
        }
        int i15 = (i14 + hashCode6) * 31;
        String str4 = this.receiverAvatar;
        if (str4 == null) {
            hashCode7 = 0;
        } else {
            hashCode7 = str4.hashCode();
        }
        int i16 = (((i15 + hashCode7) * 31) + this.second) * 31;
        String str5 = this.senderAvatar;
        if (str5 == null) {
            hashCode8 = 0;
        } else {
            hashCode8 = str5.hashCode();
        }
        int i17 = (i16 + hashCode8) * 31;
        Boolean bool2 = this.showEntry;
        if (bool2 == null) {
            hashCode9 = 0;
        } else {
            hashCode9 = bool2.hashCode();
        }
        int i18 = (i17 + hashCode9) * 31;
        String str6 = this.svgaUrl;
        if (str6 == null) {
            hashCode10 = 0;
        } else {
            hashCode10 = str6.hashCode();
        }
        int i19 = (i18 + hashCode10) * 31;
        List<Integer> list = this.tags;
        if (list == null) {
            hashCode11 = 0;
        } else {
            hashCode11 = list.hashCode();
        }
        int i20 = (i19 + hashCode11) * 31;
        Long l11 = this.bagId;
        if (l11 == null) {
            hashCode12 = 0;
        } else {
            hashCode12 = l11.hashCode();
        }
        int i21 = (i20 + hashCode12) * 31;
        Integer num2 = this.count;
        if (num2 == null) {
            hashCode13 = 0;
        } else {
            hashCode13 = num2.hashCode();
        }
        int i22 = (i21 + hashCode13) * 31;
        Integer num3 = this.remainDays;
        if (num3 == null) {
            hashCode14 = 0;
        } else {
            hashCode14 = num3.hashCode();
        }
        int i23 = (i22 + hashCode14) * 31;
        Integer num4 = this.resType;
        if (num4 == null) {
            hashCode15 = 0;
        } else {
            hashCode15 = num4.hashCode();
        }
        int i24 = (i23 + hashCode15) * 31;
        Integer num5 = this.giftType;
        if (num5 == null) {
            hashCode16 = 0;
        } else {
            hashCode16 = num5.hashCode();
        }
        int i25 = (i24 + hashCode16) * 31;
        List<TextStyles> list2 = this.textStyleList;
        if (list2 == null) {
            hashCode17 = 0;
        } else {
            hashCode17 = list2.hashCode();
        }
        int i26 = (i25 + hashCode17) * 31;
        String str7 = this.giftText;
        if (str7 == null) {
            hashCode18 = 0;
        } else {
            hashCode18 = str7.hashCode();
        }
        int i27 = (i26 + hashCode18) * 31;
        Boolean bool3 = this.hasGiftText;
        if (bool3 == null) {
            hashCode19 = 0;
        } else {
            hashCode19 = bool3.hashCode();
        }
        int i28 = (i27 + hashCode19) * 31;
        Integer num6 = this.type;
        if (num6 != null) {
            i10 = num6.hashCode();
        }
        return i28 + i10;
    }

    public final boolean is3D() {
        List<Integer> list = this.tags;
        boolean z10 = false;
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (((Number) it.next()).intValue() == 3) {
                    z10 = true;
                }
            }
        }
        return z10;
    }

    public final boolean isActivity() {
        List<Integer> list = this.tags;
        boolean z10 = false;
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (((Number) it.next()).intValue() == 4) {
                    z10 = true;
                }
            }
        }
        return z10;
    }

    public final boolean isMedal() {
        List<Integer> list = this.tags;
        boolean z10 = false;
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (((Number) it.next()).intValue() == 1) {
                    z10 = true;
                }
            }
        }
        return z10;
    }

    /* renamed from: isSelected, reason: from getter */
    public final boolean getIsSelected() {
        return this.isSelected;
    }

    public final boolean isWeek() {
        List<Integer> list = this.tags;
        boolean z10 = false;
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (((Number) it.next()).intValue() == 2) {
                    z10 = true;
                }
            }
        }
        return z10;
    }

    public final void setBagId(@Nullable Long l10) {
        this.bagId = l10;
    }

    public final void setColumn(@Nullable Integer num) {
        this.column = num;
    }

    public final void setCount(@Nullable Integer num) {
        this.count = num;
    }

    public final void setDiamondNum(float f10) {
        this.diamondNum = f10;
    }

    public final void setGiftId(@Nullable Long l10) {
        this.giftId = l10;
    }

    public final void setGiftText(@Nullable String str) {
        this.giftText = str;
    }

    public final void setGiftType(@Nullable Integer num) {
        this.giftType = num;
    }

    public final void setGroup_broadcast(@Nullable Boolean bool) {
        this.group_broadcast = bool;
    }

    public final void setHasGiftText(@Nullable Boolean bool) {
        this.hasGiftText = bool;
    }

    public final void setIconUrl(@Nullable String str) {
        this.iconUrl = str;
    }

    public final void setMusicUrl(@Nullable String str) {
        this.musicUrl = str;
    }

    public final void setName(@Nullable String str) {
        this.name = str;
    }

    public final void setNum(int i10) {
        this.num = i10;
    }

    public final void setReceiverAvatar(@Nullable String str) {
        this.receiverAvatar = str;
    }

    public final void setRemainDays(@Nullable Integer num) {
        this.remainDays = num;
    }

    public final void setResType(@Nullable Integer num) {
        this.resType = num;
    }

    public final void setSecond(int i10) {
        this.second = i10;
    }

    public final void setSelected(boolean z10) {
        this.isSelected = z10;
    }

    public final void setSenderAvatar(@Nullable String str) {
        this.senderAvatar = str;
    }

    public final void setShowEntry(@Nullable Boolean bool) {
        this.showEntry = bool;
    }

    public final void setSvgaUrl(@Nullable String str) {
        this.svgaUrl = str;
    }

    public final void setTags(@Nullable List<Integer> list) {
        this.tags = list;
    }

    public final void setTextStyleList(@Nullable List<TextStyles> list) {
        this.textStyleList = list;
    }

    public final void setType(@Nullable Integer num) {
        this.type = num;
    }

    @NotNull
    public String toString() {
        return "GiftData(column=" + this.column + ", diamondNum=" + this.diamondNum + ", giftId=" + this.giftId + ", group_broadcast=" + this.group_broadcast + ", iconUrl=" + this.iconUrl + ", musicUrl=" + this.musicUrl + ", name=" + this.name + ", receiverAvatar=" + this.receiverAvatar + ", second=" + this.second + ", senderAvatar=" + this.senderAvatar + ", showEntry=" + this.showEntry + ", svgaUrl=" + this.svgaUrl + ", tags=" + this.tags + ", bagId=" + this.bagId + ", count=" + this.count + ", remainDays=" + this.remainDays + ", resType=" + this.resType + ", giftType=" + this.giftType + ", textStyleList=" + this.textStyleList + ", giftText=" + this.giftText + ", hasGiftText=" + this.hasGiftText + ", type=" + this.type + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NotNull Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        Integer num = this.column;
        if (num == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num.intValue());
        }
        dest.writeFloat(this.diamondNum);
        Long l10 = this.giftId;
        if (l10 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeLong(l10.longValue());
        }
        Boolean bool = this.group_broadcast;
        if (bool == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(bool.booleanValue() ? 1 : 0);
        }
        dest.writeString(this.iconUrl);
        dest.writeString(this.musicUrl);
        dest.writeString(this.name);
        dest.writeString(this.receiverAvatar);
        dest.writeInt(this.second);
        dest.writeString(this.senderAvatar);
        Boolean bool2 = this.showEntry;
        if (bool2 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(bool2.booleanValue() ? 1 : 0);
        }
        dest.writeString(this.svgaUrl);
        List<Integer> list = this.tags;
        if (list == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(list.size());
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                dest.writeInt(it.next().intValue());
            }
        }
        Long l11 = this.bagId;
        if (l11 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeLong(l11.longValue());
        }
        Integer num2 = this.count;
        if (num2 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num2.intValue());
        }
        Integer num3 = this.remainDays;
        if (num3 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num3.intValue());
        }
        Integer num4 = this.resType;
        if (num4 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num4.intValue());
        }
        Integer num5 = this.giftType;
        if (num5 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num5.intValue());
        }
        List<TextStyles> list2 = this.textStyleList;
        if (list2 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(list2.size());
            Iterator<TextStyles> it2 = list2.iterator();
            while (it2.hasNext()) {
                it2.next().writeToParcel(dest, flags);
            }
        }
        dest.writeString(this.giftText);
        Boolean bool3 = this.hasGiftText;
        if (bool3 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(bool3.booleanValue() ? 1 : 0);
        }
        Integer num6 = this.type;
        if (num6 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num6.intValue());
        }
    }

    public GiftData(@Nullable Integer num, float f10, @Nullable Long l10, @Nullable Boolean bool, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, int i10, @Nullable String str5, @Nullable Boolean bool2, @Nullable String str6, @Nullable List<Integer> list, @Nullable Long l11, @Nullable Integer num2, @Nullable Integer num3, @Nullable Integer num4, @Nullable Integer num5, @Nullable List<TextStyles> list2, @Nullable String str7, @Nullable Boolean bool3, @Nullable Integer num6) {
        this.column = num;
        this.diamondNum = f10;
        this.giftId = l10;
        this.group_broadcast = bool;
        this.iconUrl = str;
        this.musicUrl = str2;
        this.name = str3;
        this.receiverAvatar = str4;
        this.second = i10;
        this.senderAvatar = str5;
        this.showEntry = bool2;
        this.svgaUrl = str6;
        this.tags = list;
        this.bagId = l11;
        this.count = num2;
        this.remainDays = num3;
        this.resType = num4;
        this.giftType = num5;
        this.textStyleList = list2;
        this.giftText = str7;
        this.hasGiftText = bool3;
        this.type = num6;
    }

    public /* synthetic */ GiftData(Integer num, float f10, Long l10, Boolean bool, String str, String str2, String str3, String str4, int i10, String str5, Boolean bool2, String str6, List list, Long l11, Integer num2, Integer num3, Integer num4, Integer num5, List list2, String str7, Boolean bool3, Integer num6, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : num, (i11 & 2) != 0 ? DownloadProgress.UNKNOWN_PROGRESS : f10, (i11 & 4) != 0 ? 0L : l10, (i11 & 8) != 0 ? null : bool, (i11 & 16) != 0 ? null : str, (i11 & 32) != 0 ? null : str2, (i11 & 64) != 0 ? null : str3, (i11 & 128) != 0 ? null : str4, (i11 & 256) != 0 ? 0 : i10, (i11 & 512) != 0 ? null : str5, (i11 & 1024) != 0 ? null : bool2, (i11 & 2048) != 0 ? null : str6, (i11 & 4096) != 0 ? null : list, (i11 & 8192) != 0 ? null : l11, (i11 & DownloadTask.Builder.DEFAULT_FLUSH_BUFFER_SIZE) != 0 ? null : num2, (i11 & 32768) != 0 ? null : num3, (i11 & 65536) != 0 ? null : num4, (i11 & e.MAX_RSP_BUFFER_LENGTH) != 0 ? 0 : num5, (i11 & 262144) != 0 ? null : list2, (i11 & anet.channel.bytes.a.MAX_POOL_SIZE) != 0 ? null : str7, (i11 & Constants.MB) != 0 ? Boolean.FALSE : bool3, (i11 & 2097152) != 0 ? 0 : num6);
    }
}
