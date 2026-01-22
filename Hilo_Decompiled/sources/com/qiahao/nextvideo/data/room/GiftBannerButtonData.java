package com.qiahao.nextvideo.data.room;

import com.qiahao.base_common.model.svip.Privilege;
import com.qiahao.base_common.model.svip.SvipData;
import com.qiahao.nextvideo.data.model.GiftBannerData;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import userProxy.UserProxy;
import userProxy.UserProxy1;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0016J\u000e\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0019J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u00062\b\u0010\u0004\u001a\u0004\u0018\u00010\u001bJ\u0006\u0010\u001c\u001a\u00020\u001dR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001f"}, d2 = {"Lcom/qiahao/nextvideo/data/room/GiftBannerButtonData;", "", "type", "", "data", "svip", "Lcom/qiahao/base_common/model/svip/SvipData;", "<init>", "(Ljava/lang/String;Ljava/lang/Object;Lcom/qiahao/base_common/model/svip/SvipData;)V", "getType", "()Ljava/lang/String;", "setType", "(Ljava/lang/String;)V", "getData", "()Ljava/lang/Object;", "setData", "(Ljava/lang/Object;)V", "getSvip", "()Lcom/qiahao/base_common/model/svip/SvipData;", "setSvip", "(Lcom/qiahao/base_common/model/svip/SvipData;)V", "initEnvelope", "LuserProxy/UserProxy1$GroupLuckyBagBanner;", "initRocketBeanData", "globalRocketNotice", "LuserProxy/UserProxy$GlobalRocketNotice;", "changeSvip", "LuserProxy/UserProxy$Svip;", "checkSupportType", "", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nGiftBannerButtonData.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GiftBannerButtonData.kt\ncom/qiahao/nextvideo/data/room/GiftBannerButtonData\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,77:1\n1869#2,2:78\n*S KotlinDebug\n*F\n+ 1 GiftBannerButtonData.kt\ncom/qiahao/nextvideo/data/room/GiftBannerButtonData\n*L\n56#1:78,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class GiftBannerButtonData {

    @NotNull
    public static final String BANNER_ENVELOPE = "envelope";

    @NotNull
    public static final String BANNER_ROCKET = "rocket";

    @Nullable
    private Object data;

    @Nullable
    private SvipData svip;

    @Nullable
    private String type;

    public GiftBannerButtonData() {
        this(null, null, null, 7, null);
    }

    @Nullable
    public final SvipData changeSvip(@Nullable UserProxy.Svip data) {
        if (data == null) {
            return null;
        }
        SvipData svipData = new SvipData((int) data.getSvipLevel(), new ArrayList(), (String) null, 4, (DefaultConstructorMarker) null);
        List<UserProxy.SvipPrivilege> privilegesList = data.getPrivilegesList();
        Intrinsics.checkNotNullExpressionValue(privilegesList, "getPrivilegesList(...)");
        for (UserProxy.SvipPrivilege svipPrivilege : privilegesList) {
            ArrayList privileges = svipData.getPrivileges();
            if (privileges != null) {
                privileges.add(new Privilege(svipPrivilege.getType(), svipPrivilege.getCanSwitch(), svipPrivilege.getUserSwitch(), svipPrivilege.getMysteryCode()));
            }
        }
        return svipData;
    }

    public final boolean checkSupportType() {
        if (!Intrinsics.areEqual(this.type, BANNER_ENVELOPE) && !Intrinsics.areEqual(this.type, BANNER_ROCKET)) {
            return false;
        }
        return true;
    }

    @Nullable
    public final Object getData() {
        return this.data;
    }

    @Nullable
    public final SvipData getSvip() {
        return this.svip;
    }

    @Nullable
    public final String getType() {
        return this.type;
    }

    @NotNull
    public final GiftBannerButtonData initEnvelope(@NotNull UserProxy1.GroupLuckyBagBanner data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return new GiftBannerButtonData(BANNER_ENVELOPE, data, changeSvip(data.getSvip()));
    }

    @NotNull
    public final GiftBannerButtonData initRocketBeanData(@NotNull UserProxy.GlobalRocketNotice globalRocketNotice) {
        Intrinsics.checkNotNullParameter(globalRocketNotice, "globalRocketNotice");
        int stage = globalRocketNotice.getStage() + 1;
        String topUserIcon = globalRocketNotice.getTopUserIcon();
        String groupId = globalRocketNotice.getGroupId();
        Intrinsics.checkNotNullExpressionValue(groupId, "getGroupId(...)");
        String avatar = globalRocketNotice.getAvatar();
        String nick = globalRocketNotice.getNick();
        String code = globalRocketNotice.getCode();
        return new GiftBannerButtonData(BANNER_ROCKET, new GiftBannerData(Integer.valueOf(stage), 0L, 0, null, "", groupId, 0, topUserIcon, avatar, nick, null, code, 3, null, null, null, 0, null, null, null, 0, null, 4121676, null), null, 4, null);
    }

    public final void setData(@Nullable Object obj) {
        this.data = obj;
    }

    public final void setSvip(@Nullable SvipData svipData) {
        this.svip = svipData;
    }

    public final void setType(@Nullable String str) {
        this.type = str;
    }

    public GiftBannerButtonData(@Nullable String str, @Nullable Object obj, @Nullable SvipData svipData) {
        this.type = str;
        this.data = obj;
        this.svip = svipData;
    }

    public /* synthetic */ GiftBannerButtonData(String str, Object obj, SvipData svipData, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : obj, (i & 4) != 0 ? null : svipData);
    }
}
