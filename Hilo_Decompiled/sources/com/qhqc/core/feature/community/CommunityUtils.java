package com.qhqc.core.feature.community;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.widget.TextView;
import com.oudi.utils.ACache;
import com.qhqc.core.basic.ktx.CompatKtxKt;
import com.qhqc.core.basic.uiframe.ui.dialogfragment.menuselector.Menu;
import com.qhqc.core.basic.utils.NumberFormatUtils;
import com.qhqc.core.feature.bean.UserInfoBean;
import com.qhqc.core.feature.bean.community.PostsCommentBean;
import com.qhqc.core.feature.bean.community.PostsCommentFloorBean;
import com.qhqc.core.feature.bean.community.PostsInfoBean;
import com.qhqc.core.feature.bean.community.PostsInfoMediaBean;
import com.qhqc.core.feature.community.CommunityManager;
import com.qhqc.core.feature.community.ui.dialog.TipsDialog;
import com.qiahao.base_common.ui.dialog.ChatMenuDialog;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\n\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u0005J\u000e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001eJ\u000e\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u0005J(\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0010\b\u0002\u0010(\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010)J\u000e\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u001eJ\u000e\u0010-\u001a\u00020+2\u0006\u0010.\u001a\u00020/J\u000e\u00100\u001a\u00020+2\u0006\u00101\u001a\u000202J\u0010\u00103\u001a\u00020+2\b\u00104\u001a\u0004\u0018\u000105J\u0010\u00106\u001a\u00020+2\b\u00104\u001a\u0004\u0018\u000105J\u0019\u00107\u001a\b\u0012\u0004\u0012\u00020'082\u0006\u00109\u001a\u00020\u001e¢\u0006\u0002\u0010:J\u0011\u0010;\u001a\b\u0012\u0004\u0012\u00020'08¢\u0006\u0002\u0010<J\u001d\u0010=\u001a\b\u0012\u0004\u0012\u00020'082\n\b\u0002\u0010>\u001a\u0004\u0018\u000105¢\u0006\u0002\u0010?J\u0018\u0010@\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\b\u0010A\u001a\u0004\u0018\u00010\u0018R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006B"}, d2 = {"Lcom/qhqc/core/feature/community/CommunityUtils;", "", "<init>", "()V", "MENU_REPORT", "", "MENU_BLOCK", "MENU_REPORT_PORN", "MENU_REPORT_HARASSMENT", "MENU_REPORT_SPAM", "MENU_REPORT_VIOLATION", "MENU_ADMIN_FUNCTION", "MENU_ADMIN_RECOMMEND", "MENU_ADMIN_TOP", "MENU_ADMIN_HIDE", "MENU_ADMIN_DELETE", "MENU_ADMIN_BAN_POSTING", "MENU_COMMENT_DELETE", "MENU_COMMENT_REPORT", "MENU_POSTS_DELETE", "MENU_COMMENT_FLOOR_DELETE", "MENU_COMMENT_FLOOR_REPORT", "MENU_POSTS_CONTENT_COPY", "getPostsTime", "", "time", "", "getPostsNumFormat", "num", "setPostInfoData", "Lcom/qhqc/core/feature/bean/community/PostsInfoBean;", "item", "getPostInfoItemType", "mediaSize", "showAdminOperateTipsDialog", "", "context", "Landroid/content/Context;", "menu", "Lcom/qhqc/core/basic/uiframe/ui/dialogfragment/menuselector/Menu;", ChatMenuDialog.CLICK_BLOCK, "Lkotlin/Function0;", "isMyPosts", "", "postsInfoBean", "isMyComment", "commentBean", "Lcom/qhqc/core/feature/bean/community/PostsCommentBean;", "isMyCommentFloor", "commentFloorBean", "Lcom/qhqc/core/feature/bean/community/PostsCommentFloorBean;", "hasCountryAdminAuth", "targetUserInfo", "Lcom/qhqc/core/feature/bean/UserInfoBean;", "hasSuperAdminAuth", "getMoreMenus", "", "postsInfo", "(Lcom/qhqc/core/feature/bean/community/PostsInfoBean;)[Lcom/qhqc/core/basic/uiframe/ui/dialogfragment/menuselector/Menu;", "getReportMenus", "()[Lcom/qhqc/core/basic/uiframe/ui/dialogfragment/menuselector/Menu;", "getSuperAdminMenus", "targetUser", "(Lcom/qhqc/core/feature/bean/UserInfoBean;)[Lcom/qhqc/core/basic/uiframe/ui/dialogfragment/menuselector/Menu;", "copyText", "str", "feature_community_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCommunityUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CommunityUtils.kt\ncom/qhqc/core/feature/community/CommunityUtils\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,233:1\n37#2:234\n36#2,3:235\n*S KotlinDebug\n*F\n+ 1 CommunityUtils.kt\ncom/qhqc/core/feature/community/CommunityUtils\n*L\n173#1:234\n173#1:235,3\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class CommunityUtils {

    @NotNull
    public static final CommunityUtils INSTANCE = new CommunityUtils();
    public static final int MENU_ADMIN_BAN_POSTING = 12;
    public static final int MENU_ADMIN_DELETE = 11;
    public static final int MENU_ADMIN_FUNCTION = 7;
    public static final int MENU_ADMIN_HIDE = 10;
    public static final int MENU_ADMIN_RECOMMEND = 8;
    public static final int MENU_ADMIN_TOP = 9;
    public static final int MENU_BLOCK = 2;
    public static final int MENU_COMMENT_DELETE = 13;
    public static final int MENU_COMMENT_FLOOR_DELETE = 16;
    public static final int MENU_COMMENT_FLOOR_REPORT = 17;
    public static final int MENU_COMMENT_REPORT = 14;
    public static final int MENU_POSTS_CONTENT_COPY = 18;
    public static final int MENU_POSTS_DELETE = 15;
    public static final int MENU_REPORT = 1;
    public static final int MENU_REPORT_HARASSMENT = 4;
    public static final int MENU_REPORT_PORN = 3;
    public static final int MENU_REPORT_SPAM = 5;
    public static final int MENU_REPORT_VIOLATION = 6;

    private CommunityUtils() {
    }

    public static /* synthetic */ Menu[] getSuperAdminMenus$default(CommunityUtils communityUtils, UserInfoBean userInfoBean, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            userInfoBean = null;
        }
        return communityUtils.getSuperAdminMenus(userInfoBean);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void showAdminOperateTipsDialog$default(CommunityUtils communityUtils, Context context, Menu menu, Function0 function0, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            function0 = null;
        }
        communityUtils.showAdminOperateTipsDialog(context, menu, function0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showAdminOperateTipsDialog$lambda$0(Function0 function0, TextView it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (function0 != null) {
            function0.invoke();
        }
        return Unit.INSTANCE;
    }

    public final void copyText(@NotNull Context context, @Nullable String str) {
        ClipboardManager clipboardManager;
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService("clipboard");
        if (systemService instanceof ClipboardManager) {
            clipboardManager = (ClipboardManager) systemService;
        } else {
            clipboardManager = null;
        }
        if (clipboardManager != null) {
            clipboardManager.setPrimaryClip(ClipData.newPlainText(null, str));
        }
    }

    @NotNull
    public final Menu[] getMoreMenus(@NotNull PostsInfoBean postsInfo) {
        Intrinsics.checkNotNullParameter(postsInfo, "postsInfo");
        if (isMyPosts(postsInfo)) {
            ArrayList arrayListOf = CollectionsKt.arrayListOf(new Menu(15, null, R.string.feature_community_delete, 2, null));
            if (hasSuperAdminAuth(postsInfo.getUser())) {
                arrayListOf.add(0, new Menu(7, null, R.string.feature_community_admin_function, 2, null));
            }
            return (Menu[]) arrayListOf.toArray(new Menu[0]);
        }
        if (hasSuperAdminAuth(postsInfo.getUser())) {
            return new Menu[]{new Menu(7, null, R.string.feature_community_admin_function, 2, null), new Menu(1, null, R.string.report, 2, null), new Menu(2, null, R.string.block, 2, null)};
        }
        return new Menu[]{new Menu(1, null, R.string.report, 2, null), new Menu(2, null, R.string.block, 2, null)};
    }

    public final int getPostInfoItemType(int mediaSize) {
        if (mediaSize == 0) {
            return 0;
        }
        if (mediaSize == 1) {
            return 1;
        }
        if (mediaSize != 2) {
            return mediaSize != 4 ? 3 : 4;
        }
        return 2;
    }

    @NotNull
    public final String getPostsNumFormat(int num) {
        if (num <= 0) {
            return "";
        }
        return NumberFormatUtils.valueToScientific$default(NumberFormatUtils.INSTANCE, num, (Locale) null, 2, (Object) null);
    }

    @NotNull
    public final String getPostsTime(long time) {
        long j10 = 1000;
        long currentTimeMillis = (System.currentTimeMillis() / j10) - (time / j10);
        if (currentTimeMillis <= 600) {
            return CompatKtxKt.getString(R.string.feature_community_posts_time_just_now);
        }
        if (currentTimeMillis <= 3600) {
            return CompatKtxKt.toFormat(R.string.feature_community_posts_time_m, Long.valueOf(currentTimeMillis / 60));
        }
        if (currentTimeMillis <= 86400) {
            return CompatKtxKt.toFormat(R.string.feature_community_posts_time_h, Long.valueOf(currentTimeMillis / 3600));
        }
        if (currentTimeMillis <= 2592000) {
            return CompatKtxKt.toFormat(R.string.feature_community_posts_time_d, Long.valueOf(currentTimeMillis / ACache.TIME_DAY));
        }
        return CompatKtxKt.getString(R.string.feature_community_posts_time_over_month);
    }

    @NotNull
    public final Menu[] getReportMenus() {
        return new Menu[]{new Menu(3, null, R.string.feature_community_report_porn, 2, null), new Menu(4, null, R.string.feature_community_report_harassment, 2, null), new Menu(5, null, R.string.feature_community_report_spam, 2, null), new Menu(6, null, R.string.feature_community_report_violation, 2, null)};
    }

    @NotNull
    public final Menu[] getSuperAdminMenus(@Nullable UserInfoBean targetUser) {
        String str;
        Menu menu = new Menu(18, null, R.string.copy, 2, null);
        Menu menu2 = new Menu(8, null, R.string.recommend, 2, null);
        Menu menu3 = new Menu(9, null, R.string.top, 2, null);
        Menu menu4 = new Menu(10, null, R.string.hide, 2, null);
        Menu menu5 = new Menu(11, null, R.string.feature_community_delete, 2, null);
        String string = CompatKtxKt.getString(R.string.feature_community_ban_posting);
        if (targetUser != null) {
            str = targetUser.getCode();
        } else {
            str = null;
        }
        return new Menu[]{menu, menu2, menu3, menu4, menu5, new Menu(12, string + "(ID: " + str + ")", 0, 4, null)};
    }

    public final boolean hasCountryAdminAuth(@Nullable UserInfoBean targetUserInfo) {
        CommunityManager.Companion companion = CommunityManager.INSTANCE;
        if (companion.getInstance().isCountryAdmin() && companion.getInstance().getCountryId() > 0 && ((targetUserInfo == null || targetUserInfo.isAdmin() != 1) && ((targetUserInfo == null || targetUserInfo.isSuper() != 1) && targetUserInfo != null && companion.getInstance().getCountryId() == targetUserInfo.getCountryId()))) {
            return true;
        }
        return false;
    }

    public final boolean hasSuperAdminAuth(@Nullable UserInfoBean targetUserInfo) {
        if (CommunityManager.INSTANCE.getInstance().isSuperAdmin() && (targetUserInfo == null || targetUserInfo.isSuper() != 1)) {
            return true;
        }
        return false;
    }

    public final boolean isMyComment(@NotNull PostsCommentBean commentBean) {
        Long l10;
        Intrinsics.checkNotNullParameter(commentBean, "commentBean");
        UserInfoBean user = commentBean.getUser();
        Long l11 = null;
        if (user != null) {
            l10 = Long.valueOf(user.getId());
        } else {
            l10 = null;
        }
        UserInfoBean myUserInfo = CommunityManager.INSTANCE.getInstance().getMyUserInfo();
        if (myUserInfo != null) {
            l11 = Long.valueOf(myUserInfo.getId());
        }
        return Intrinsics.areEqual(l10, l11);
    }

    public final boolean isMyCommentFloor(@NotNull PostsCommentFloorBean commentFloorBean) {
        Long l10;
        Intrinsics.checkNotNullParameter(commentFloorBean, "commentFloorBean");
        UserInfoBean fromUser = commentFloorBean.getFromUser();
        Long l11 = null;
        if (fromUser != null) {
            l10 = Long.valueOf(fromUser.getId());
        } else {
            l10 = null;
        }
        UserInfoBean myUserInfo = CommunityManager.INSTANCE.getInstance().getMyUserInfo();
        if (myUserInfo != null) {
            l11 = Long.valueOf(myUserInfo.getId());
        }
        return Intrinsics.areEqual(l10, l11);
    }

    public final boolean isMyPosts(@NotNull PostsInfoBean postsInfoBean) {
        Long l10;
        Intrinsics.checkNotNullParameter(postsInfoBean, "postsInfoBean");
        UserInfoBean user = postsInfoBean.getUser();
        Long l11 = null;
        if (user != null) {
            l10 = Long.valueOf(user.getId());
        } else {
            l10 = null;
        }
        UserInfoBean myUserInfo = CommunityManager.INSTANCE.getInstance().getMyUserInfo();
        if (myUserInfo != null) {
            l11 = Long.valueOf(myUserInfo.getId());
        }
        return Intrinsics.areEqual(l10, l11);
    }

    @NotNull
    public final PostsInfoBean setPostInfoData(@NotNull PostsInfoBean item) {
        int i10;
        Intrinsics.checkNotNullParameter(item, "item");
        List<PostsInfoMediaBean> mediaResources = item.getMediaResources();
        if (mediaResources != null) {
            i10 = mediaResources.size();
        } else {
            i10 = 0;
        }
        item.setItemType(getPostInfoItemType(i10));
        return item;
    }

    public final void showAdminOperateTipsDialog(@NotNull Context context, @NotNull Menu menu, @Nullable final Function0<Unit> block) {
        String string;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(menu, "menu");
        switch (menu.getId()) {
            case 8:
                string = CompatKtxKt.getString(R.string.feature_community_posts_recommend_hint);
                break;
            case 9:
                string = CompatKtxKt.getString(R.string.feature_community_posts_top_hint);
                break;
            case 10:
                string = CompatKtxKt.getString(R.string.feature_community_posts_hide_hint);
                break;
            case 11:
                string = CompatKtxKt.getString(R.string.feature_community_posts_moment_delete_hint);
                break;
            case 12:
                string = CompatKtxKt.getString(R.string.feature_community_posts_ban_post_hint);
                break;
            default:
                string = "";
                break;
        }
        TipsDialog.Builder.withDefBtn$default(new TipsDialog.Builder().setTextContent(string), new Function1() { // from class: com.qhqc.core.feature.community.f
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit showAdminOperateTipsDialog$lambda$0;
                showAdminOperateTipsDialog$lambda$0 = CommunityUtils.showAdminOperateTipsDialog$lambda$0(Function0.this, (TextView) obj);
                return showAdminOperateTipsDialog$lambda$0;
            }
        }, null, null, 6, null).build().show(context);
    }
}
