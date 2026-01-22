package com.qiahao.nextvideo.data.model;

import com.qiahao.nextvideo.ui.transfer.TransferCenterFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.android.agoo.common.AgooConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.c;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB?\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001d"}, d2 = {"Lcom/qiahao/nextvideo/data/model/PurchaseItem;", "", AgooConstants.MESSAGE_ID, "", TransferCenterFragment.TYPE_DIAMONDS, "", "createdAt", "", "addReduce", "", "operateType", "isCoin", "", "<init>", "(Ljava/lang/String;Ljava/lang/Float;JIIZ)V", "getId", "()Ljava/lang/String;", "getDiamonds", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getCreatedAt", "()J", "getAddReduce", "()I", "getOperateType", "()Z", "setCoin", "(Z)V", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class PurchaseItem {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @c("addReduce")
    private final int addReduce;

    @c("createdTime")
    private final long createdAt;

    @Nullable
    @c("diamondNum")
    private final Float diamonds;

    @NotNull
    @c(AgooConstants.MESSAGE_ID)
    private final String id;
    private boolean isCoin;

    @c("operateType")
    private final int operateType;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"Lcom/qiahao/nextvideo/data/model/PurchaseItem$Companion;", "", "<init>", "()V", "fake", "Lcom/qiahao/nextvideo/data/model/PurchaseItem;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final PurchaseItem fake() {
            String valueOf = String.valueOf(System.currentTimeMillis());
            float currentTimeMillis = (float) System.currentTimeMillis();
            long currentTimeMillis2 = System.currentTimeMillis();
            int currentTimeMillis3 = (int) System.currentTimeMillis();
            return new PurchaseItem(valueOf, Float.valueOf(currentTimeMillis), currentTimeMillis2, (int) System.currentTimeMillis(), currentTimeMillis3, false, 32, null);
        }

        private Companion() {
        }
    }

    public PurchaseItem(@NotNull String str, @Nullable Float f, long j, int i, int i2, boolean z) {
        Intrinsics.checkNotNullParameter(str, AgooConstants.MESSAGE_ID);
        this.id = str;
        this.diamonds = f;
        this.createdAt = j;
        this.addReduce = i;
        this.operateType = i2;
        this.isCoin = z;
    }

    public final int getAddReduce() {
        return this.addReduce;
    }

    public final long getCreatedAt() {
        return this.createdAt;
    }

    @Nullable
    public final Float getDiamonds() {
        return this.diamonds;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    public final int getOperateType() {
        return this.operateType;
    }

    /* renamed from: isCoin, reason: from getter */
    public final boolean getIsCoin() {
        return this.isCoin;
    }

    public final void setCoin(boolean z) {
        this.isCoin = z;
    }

    public /* synthetic */ PurchaseItem(String str, Float f, long j, int i, int i2, boolean z, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "-1" : str, (i3 & 2) != 0 ? Float.valueOf(0.0f) : f, j, i, i2, (i3 & 32) != 0 ? false : z);
    }
}
