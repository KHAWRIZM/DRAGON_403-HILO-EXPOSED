package com.qiahao.base_common.support;

import android.content.Context;
import androidx.annotation.Keep;
import androidx.fragment.app.FragmentManager;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.qiahao.base_common.interfaceing.OnCommonDialogListener;
import com.qiahao.base_common.interfaceing.SendGiftListener;
import com.qiahao.base_common.model.MultiGiftData;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.path.AppController;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0007J\u0006\u0010\u000b\u001a\u00020\u0005J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rJ\u001a\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00072\b\b\u0002\u0010\u0011\u001a\u00020\u0007J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010\u0016\u001a\u00020\u0005J\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0007J\u000e\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\rJ\u001a\u0010\u001c\u001a\u00020\u00052\b\b\u0002\u0010\u001d\u001a\u00020\u00182\b\b\u0002\u0010\u001e\u001a\u00020\u0018Jd\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020!2\u0006\u0010\u0006\u001a\u00020\u00072:\b\u0002\u0010\"\u001a4\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(\u0006\u0012\u0013\u0012\u00110&¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b('\u0012\u0004\u0012\u00020\u0005\u0018\u00010#2\u0010\b\u0002\u0010(\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010)J;\u0010*\u001a\u00020\u00052\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u0002002\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u00101\u001a\u0004\u0018\u00010&¢\u0006\u0002\u00102J\u000e\u00103\u001a\u00020\u00052\u0006\u00104\u001a\u00020\rJ\b\u00105\u001a\u0004\u0018\u00010.J\u000e\u00106\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u00107\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0007J\u000e\u00108\u001a\u00020\u00052\u0006\u00109\u001a\u00020\u0007J\u000e\u0010:\u001a\u00020\u00052\u0006\u0010;\u001a\u00020\u0015J\u0016\u0010<\u001a\u00020\u00052\u0006\u0010=\u001a\u00020\r2\u0006\u0010>\u001a\u00020\rJ\u0016\u0010?\u001a\u00020\u00052\u0006\u0010/\u001a\u00020@2\u0006\u0010A\u001a\u00020\u0007J\u000e\u0010B\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0007J(\u0010C\u001a\u00020\u00052\b\b\u0002\u0010D\u001a\u00020\r2\u0006\u0010>\u001a\u00020\r2\u0006\u0010E\u001a\u00020\r2\u0006\u0010F\u001a\u00020\rJ\u0006\u0010G\u001a\u00020\u0005J\u0010\u0010H\u001a\u0004\u0018\u00010I2\u0006\u0010J\u001a\u00020\u0007J\u0016\u0010K\u001a\u00020\u00052\u0006\u0010/\u001a\u00020@2\u0006\u0010A\u001a\u00020\u0007J\u000e\u0010L\u001a\u00020&2\u0006\u0010\n\u001a\u00020\u0007J\u000e\u0010M\u001a\u00020&2\u0006\u0010\n\u001a\u00020\u0007J\u000e\u0010N\u001a\u00020\u00072\u0006\u0010O\u001a\u00020\u0015J\u000e\u0010P\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0007¨\u0006Q"}, d2 = {"Lcom/qiahao/base_common/support/BaseControlUtils;", "", "<init>", "()V", "openPersonPage", "", "externalId", "", "getExternalId", "openRoom", "groupId", "startMyBag", "getNobleDrawableRes", "", "nobleLevel", "showPicOrSvgaDialog", "url", "svgaUrl", "findGiftByGiftId", "Lcom/qiahao/base_common/model/MultiGiftData;", "giftId", "", "startWallet", "getDiamond", "", "openH5", "refreshLikeCount", "likeCount", "refreshDiamondOrGem", "diamonds", "pinkDiamondNum", "newStartVideo", "context", "Landroid/content/Context;", "likeListener", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "", "isLike", "startVideo", "Lkotlin/Function0;", "showChatGiftDialog", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "user", "Lcom/qiahao/base_common/model/common/User;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/qiahao/base_common/interfaceing/SendGiftListener;", "isStrange", "(Landroidx/fragment/app/FragmentManager;Lcom/qiahao/base_common/model/common/User;Lcom/qiahao/base_common/interfaceing/SendGiftListener;Ljava/lang/String;Ljava/lang/Boolean;)V", "showVipDialog", "position", "getUser", "roomOpenUserInfo", "openLevelActivity", "openActivityDetail", "id", "openFamily", "familyID", "openSheep", "matchId", "gameId", "showCpDialog", "Lcom/qiahao/base_common/interfaceing/OnCommonDialogListener;", "tip", "openCommonLink", "matchGame", "mathId", "mode", "gameType", "exitToMainActivity", "getFile", "Ljava/io/File;", "filePath", "showRelationDialog", "checkStrangerGroupFromSDK", "checkStrangerGroupFromService", "formatNumber", "num", "changeCommunityServer", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class BaseControlUtils {

    @NotNull
    public static final BaseControlUtils INSTANCE = new BaseControlUtils();

    private BaseControlUtils() {
    }

    public static /* synthetic */ void matchGame$default(BaseControlUtils baseControlUtils, int i10, int i11, int i12, int i13, int i14, Object obj) {
        if ((i14 & 1) != 0) {
            i10 = 0;
        }
        baseControlUtils.matchGame(i10, i11, i12, i13);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void newStartVideo$default(BaseControlUtils baseControlUtils, Context context, String str, Function2 function2, Function0 function0, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            function2 = null;
        }
        if ((i10 & 8) != 0) {
            function0 = null;
        }
        baseControlUtils.newStartVideo(context, str, function2, function0);
    }

    public static /* synthetic */ void refreshDiamondOrGem$default(BaseControlUtils baseControlUtils, double d10, double d11, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            d10 = -1.0d;
        }
        if ((i10 & 2) != 0) {
            d11 = -1.0d;
        }
        baseControlUtils.refreshDiamondOrGem(d10, d11);
    }

    public static /* synthetic */ void showChatGiftDialog$default(BaseControlUtils baseControlUtils, FragmentManager fragmentManager, User user, SendGiftListener sendGiftListener, String str, Boolean bool, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            str = null;
        }
        String str2 = str;
        if ((i10 & 16) != 0) {
            bool = Boolean.FALSE;
        }
        baseControlUtils.showChatGiftDialog(fragmentManager, user, sendGiftListener, str2, bool);
    }

    public static /* synthetic */ void showPicOrSvgaDialog$default(BaseControlUtils baseControlUtils, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = "";
        }
        if ((i10 & 2) != 0) {
            str2 = "";
        }
        baseControlUtils.showPicOrSvgaDialog(str, str2);
    }

    public final void changeCommunityServer(@NotNull String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        AppService service = AppController.INSTANCE.getService();
        if (service != null) {
            service.changeCommunityServer(url);
        }
    }

    public final boolean checkStrangerGroupFromSDK(@NotNull String groupId) {
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        AppService service = AppController.INSTANCE.getService();
        if (service != null) {
            return service.checkStrangerGroupFromSDK(groupId);
        }
        return false;
    }

    public final boolean checkStrangerGroupFromService(@NotNull String groupId) {
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        AppService service = AppController.INSTANCE.getService();
        if (service != null) {
            return service.checkStrangerGroupFromService(groupId);
        }
        return false;
    }

    public final void exitToMainActivity() {
        AppService service = AppController.INSTANCE.getService();
        if (service != null) {
            service.exitToMainActivity();
        }
    }

    @Nullable
    public final MultiGiftData findGiftByGiftId(long giftId) {
        AppService service = AppController.INSTANCE.getService();
        if (service != null) {
            return service.findGiftByGiftId(giftId);
        }
        return null;
    }

    @NotNull
    public final String formatNumber(long num) {
        String formatNumber;
        AppService service = AppController.INSTANCE.getService();
        if (service == null || (formatNumber = service.formatNumber(num)) == null) {
            return "";
        }
        return formatNumber;
    }

    public final double getDiamond() {
        AppService service = AppController.INSTANCE.getService();
        if (service != null) {
            return service.getDiamond();
        }
        return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
    }

    @NotNull
    public final String getExternalId() {
        String userExternalId;
        AppService service = AppController.INSTANCE.getService();
        if (service == null || (userExternalId = service.getUserExternalId()) == null) {
            return "";
        }
        return userExternalId;
    }

    @Nullable
    public final File getFile(@NotNull String filePath) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        AppService service = AppController.INSTANCE.getService();
        if (service != null) {
            return service.getFile(filePath);
        }
        return null;
    }

    public final int getNobleDrawableRes(int nobleLevel) {
        AppService service = AppController.INSTANCE.getService();
        if (service != null) {
            return service.getNobleDrawableRes(nobleLevel);
        }
        return 0;
    }

    @Nullable
    public final User getUser() {
        AppService service = AppController.INSTANCE.getService();
        if (service != null) {
            return service.getUser();
        }
        return null;
    }

    public final void matchGame(int mathId, int gameId, int mode, int gameType) {
        AppService service = AppController.INSTANCE.getService();
        if (service != null) {
            service.matchGame(mathId, gameId, mode, gameType);
        }
    }

    public final void newStartVideo(@NotNull Context context, @NotNull String externalId, @Nullable Function2<? super String, ? super Boolean, Unit> likeListener, @Nullable Function0<Unit> startVideo) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(externalId, "externalId");
        AppService service = AppController.INSTANCE.getService();
        if (service != null) {
            service.newStartVideo(context, externalId, likeListener, startVideo);
        }
    }

    public final void openActivityDetail(@NotNull String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        AppService service = AppController.INSTANCE.getService();
        if (service != null) {
            service.openActivityDetail(id);
        }
    }

    public final void openCommonLink(@NotNull String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        AppService service = AppController.INSTANCE.getService();
        if (service != null) {
            service.openCommonLink(url);
        }
    }

    public final void openFamily(long familyID) {
        AppService service = AppController.INSTANCE.getService();
        if (service != null) {
            service.openFamily(familyID);
        }
    }

    public final void openH5(@NotNull String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        AppService service = AppController.INSTANCE.getService();
        if (service != null) {
            service.openH5(url);
        }
    }

    public final void openLevelActivity(@NotNull String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        AppService service = AppController.INSTANCE.getService();
        if (service != null) {
            service.openLevelActivity(url);
        }
    }

    public final void openPersonPage(@NotNull String externalId) {
        Intrinsics.checkNotNullParameter(externalId, "externalId");
        AppService service = AppController.INSTANCE.getService();
        if (service != null) {
            service.openPersonPage(externalId);
        }
    }

    public final void openRoom(@NotNull String groupId) {
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        AppService service = AppController.INSTANCE.getService();
        if (service != null) {
            service.joinLive(groupId);
        }
    }

    public final void openSheep(int matchId, int gameId) {
        AppService service = AppController.INSTANCE.getService();
        if (service != null) {
            service.openSheep(matchId, gameId);
        }
    }

    public final void refreshDiamondOrGem(double diamonds, double pinkDiamondNum) {
        AppService service = AppController.INSTANCE.getService();
        if (service != null) {
            service.refreshDiamondOrGem(diamonds, pinkDiamondNum);
        }
    }

    public final void refreshLikeCount(int likeCount) {
        AppService service = AppController.INSTANCE.getService();
        if (service != null) {
            service.refreshLikeCount(likeCount);
        }
    }

    public final void roomOpenUserInfo(@NotNull String externalId) {
        Intrinsics.checkNotNullParameter(externalId, "externalId");
        AppService service = AppController.INSTANCE.getService();
        if (service != null) {
            service.roomOpenUserInfo(externalId);
        }
    }

    public final void showChatGiftDialog(@NotNull FragmentManager fragmentManager, @NotNull User user, @NotNull SendGiftListener listener, @Nullable String groupId, @Nullable Boolean isStrange) {
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics.checkNotNullParameter(user, "user");
        Intrinsics.checkNotNullParameter(listener, "listener");
        AppService service = AppController.INSTANCE.getService();
        if (service != null) {
            service.showChatGiftDialog(fragmentManager, user, listener, groupId, isStrange);
        }
    }

    public final void showCpDialog(@NotNull OnCommonDialogListener listener, @NotNull String tip) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        Intrinsics.checkNotNullParameter(tip, "tip");
        AppService service = AppController.INSTANCE.getService();
        if (service != null) {
            service.showCpDialog(listener, tip);
        }
    }

    public final void showPicOrSvgaDialog(@NotNull String url, @NotNull String svgaUrl) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(svgaUrl, "svgaUrl");
        AppService service = AppController.INSTANCE.getService();
        if (service != null) {
            service.showImageOrSvga(url, svgaUrl);
        }
    }

    public final void showRelationDialog(@NotNull OnCommonDialogListener listener, @NotNull String tip) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        Intrinsics.checkNotNullParameter(tip, "tip");
        AppService service = AppController.INSTANCE.getService();
        if (service != null) {
            service.showRelationDialog(listener, tip);
        }
    }

    public final void showVipDialog(int position) {
        AppService service = AppController.INSTANCE.getService();
        if (service != null) {
            service.showVipDialog(position);
        }
    }

    public final void startMyBag() {
        AppService service = AppController.INSTANCE.getService();
        if (service != null) {
            service.startMyBag();
        }
    }

    public final void startWallet() {
        AppService service = AppController.INSTANCE.getService();
        if (service != null) {
            service.startWallet();
        }
    }
}
