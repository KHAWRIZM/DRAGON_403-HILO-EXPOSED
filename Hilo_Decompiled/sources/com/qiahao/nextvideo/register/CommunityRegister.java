package com.qiahao.nextvideo.register;

import android.graphics.drawable.Drawable;
import android.view.View;
import cf.c;
import com.qhqc.core.basic.ktx.CompatKtxKt;
import com.qhqc.core.feature.bean.UserInfoBean;
import com.qhqc.core.feature.bean.community.PostsNoticeUnReadBean;
import com.qhqc.core.feature.community.CommunityManager;
import com.qhqc.core.feature.community.IUserEvents;
import com.qhqc.core.feature.community.IUserInfoProvider;
import com.qhqc.core.feature.community.NoticeChangedListener;
import com.qhqc.core.feature.community.events.UserOperateEvent;
import com.qiahao.base_common.model.common.HeadWearBean;
import com.qiahao.base_common.model.common.NobleInfo;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.model.svip.SvipData;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.path.AppController;
import com.qiahao.base_common.support.AppService;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.base_common.utils.SvipTypeUtils;
import com.qiahao.nextvideo.data.service.UserService;
import com.qiahao.nextvideo.register.CommunityRegister;
import com.qiahao.nextvideo.ui.home.community.CommunityFollowUnReadEvent;
import com.qiahao.nextvideo.ui.im.MessageProvide;
import com.taobao.accs.common.Constants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import nd.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u000f\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000f\u0010\u000eJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ'\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010!\u001a\u00020\u00182\u0006\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b!\u0010\"R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010#\u001a\u0004\b$\u0010%R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010&\u001a\u0004\b'\u0010(¨\u0006)"}, d2 = {"Lcom/qiahao/nextvideo/register/CommunityRegister;", "Lcom/qhqc/core/feature/community/IUserInfoProvider;", "Lcom/qhqc/core/feature/community/IUserEvents;", "Lcom/qhqc/core/feature/community/NoticeChangedListener;", "Lcom/qiahao/base_common/model/common/User;", "user", "Lnd/a;", "compositeDisposable", "<init>", "(Lcom/qiahao/base_common/model/common/User;Lnd/a;)V", "", "level", "Landroid/graphics/drawable/Drawable;", "getSVipIcon", "(I)Landroid/graphics/drawable/Drawable;", "getVipIcon", "", "isSuperAdmin", "()Z", "Lcom/qhqc/core/feature/bean/UserInfoBean;", Constants.KEY_USER_ID, "()Lcom/qhqc/core/feature/bean/UserInfoBean;", "Landroid/view/View;", "view", "", "onUserClick", "(Lcom/qhqc/core/feature/bean/UserInfoBean;Landroid/view/View;)V", "Lkotlinx/coroutines/CoroutineScope;", "scope", "onFollowUserClick", "(Lcom/qhqc/core/feature/bean/UserInfoBean;Landroid/view/View;Lkotlinx/coroutines/CoroutineScope;)V", "Lcom/qhqc/core/feature/bean/community/PostsNoticeUnReadBean;", "unRead", "onCountChanged", "(Lcom/qhqc/core/feature/bean/community/PostsNoticeUnReadBean;)V", "Lcom/qiahao/base_common/model/common/User;", "getUser", "()Lcom/qiahao/base_common/model/common/User;", "Lnd/a;", "getCompositeDisposable", "()Lnd/a;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class CommunityRegister implements IUserInfoProvider, IUserEvents, NoticeChangedListener {

    @NotNull
    private final a compositeDisposable;

    @NotNull
    private final User user;

    public CommunityRegister(@NotNull User user, @NotNull a aVar) {
        Intrinsics.checkNotNullParameter(user, "user");
        Intrinsics.checkNotNullParameter(aVar, "compositeDisposable");
        this.user = user;
        this.compositeDisposable = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onFollowUserClick$lambda$0(UserInfoBean userInfoBean, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        CommunityManager.Companion.getInstance().dispatchEvent(new UserOperateEvent(12289, userInfoBean));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onFollowUserClick$lambda$1(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        return Unit.INSTANCE;
    }

    @NotNull
    public final a getCompositeDisposable() {
        return this.compositeDisposable;
    }

    @Nullable
    public Drawable getSVipIcon(int level) {
        Integer svipType;
        if (level <= 0 || (svipType = SvipTypeUtils.INSTANCE.getSvipType(Integer.valueOf(level))) == null) {
            return null;
        }
        return CompatKtxKt.getDrawable(svipType.intValue());
    }

    @NotNull
    public final User getUser() {
        return this.user;
    }

    @Nullable
    public Drawable getVipIcon(int level) {
        if (level > 0) {
            return CompatKtxKt.getDrawable(UserService.INSTANCE.getNobleDrawableRes(level));
        }
        return null;
    }

    public boolean isCountryAdmin() {
        return IUserInfoProvider.DefaultImpls.isCountryAdmin(this);
    }

    public boolean isSuperAdmin() {
        return this.user.isOfficialStaff();
    }

    public void onCountChanged(@NotNull PostsNoticeUnReadBean unRead) {
        Intrinsics.checkNotNullParameter(unRead, "unRead");
        c.c().l(new CommunityFollowUnReadEvent(unRead));
        if (unRead.getTotalCnt() > 0) {
            MessageProvide messageProvide = MessageProvide.INSTANCE;
            messageProvide.setHasNewSystemMessage(true);
            messageProvide.displayData(MessageProvide.MESSAGE_DEFAULT);
        }
    }

    public void onFollowUserClick(@NotNull final UserInfoBean user, @NotNull View view, @NotNull CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(user, "user");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(scope, "scope");
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(UserService.like$default(UserService.INSTANCE.getShared(), String.valueOf(user.getExternalId()), false, false, 4, null), new Function1() { // from class: lb.a
            public final Object invoke(Object obj) {
                Unit onFollowUserClick$lambda$0;
                onFollowUserClick$lambda$0 = CommunityRegister.onFollowUserClick$lambda$0(user, (ApiResponse) obj);
                return onFollowUserClick$lambda$0;
            }
        }, new Function1() { // from class: lb.b
            public final Object invoke(Object obj) {
                Unit onFollowUserClick$lambda$1;
                onFollowUserClick$lambda$1 = CommunityRegister.onFollowUserClick$lambda$1((Throwable) obj);
                return onFollowUserClick$lambda$1;
            }
        }, (Function0) null, false, 12, (Object) null), this.compositeDisposable);
    }

    public void onUserClick(@NotNull UserInfoBean user, @NotNull View view) {
        Intrinsics.checkNotNullParameter(user, "user");
        Intrinsics.checkNotNullParameter(view, "view");
        if (user.getOnline() == 1) {
            AppService service = AppController.INSTANCE.getService();
            if (service != null) {
                service.joinLive(String.valueOf(user.getRoomId()));
                return;
            }
            return;
        }
        AppService service2 = AppController.INSTANCE.getService();
        if (service2 != null) {
            String externalId = user.getExternalId();
            if (externalId == null) {
                externalId = "";
            }
            service2.openPersonPage(externalId);
        }
    }

    @NotNull
    public UserInfoBean userInfo() {
        int i;
        int i2;
        int i3;
        String str;
        String str2;
        int i4;
        Integer level;
        long id2 = this.user.getId();
        String avatar = this.user.getAvatar();
        String nick = this.user.getNick();
        int sex = this.user.getSex();
        Integer intOrNull = StringsKt.toIntOrNull(this.user.getAge());
        if (intOrNull != null) {
            i = intOrNull.intValue();
        } else {
            i = 0;
        }
        NobleInfo noble = this.user.getNoble();
        if (noble != null && (level = noble.getLevel()) != null) {
            i2 = level.intValue();
        } else {
            i2 = 0;
        }
        SvipData svip = this.user.getSvip();
        if (svip != null) {
            i3 = svip.getSvipLevel();
        } else {
            i3 = 0;
        }
        HeadWearBean headwear = this.user.getHeadwear();
        if (headwear != null) {
            str = headwear.getEffectUrl();
        } else {
            str = null;
        }
        HeadWearBean headwear2 = this.user.getHeadwear();
        if (headwear2 != null) {
            str2 = headwear2.getPicUrl();
        } else {
            str2 = null;
        }
        Integer isShowAge = this.user.isShowAge();
        if (isShowAge != null) {
            i4 = isShowAge.intValue();
        } else {
            i4 = 1;
        }
        return new UserInfoBean(id2, (String) null, nick, avatar, (String) null, sex, 0, i, i4, i2, i3, (String) null, str, str2, (String) null, (String) null, 0, 0, 0, 510034, (DefaultConstructorMarker) null);
    }
}
