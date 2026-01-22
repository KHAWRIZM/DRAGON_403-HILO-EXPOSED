package com.qhqc.core.feature.community;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.luck.picture.lib.style.BottomNavBarStyle;
import com.luck.picture.lib.style.PictureSelectorStyle;
import com.luck.picture.lib.style.TitleBarStyle;
import com.opensource.svgaplayer.SVGAParser;
import com.qhqc.core.basic.ktx.CompatKtxKt;
import com.qhqc.core.basic.net.HttpUtils;
import com.qhqc.core.basic.net.ResponseUtilsKt;
import com.qhqc.core.basic.net.config.NetWorkConfiguration;
import com.qhqc.core.basic.net.exception.ApiErrorException;
import com.qhqc.core.basic.picture.selector.PictureSelectorUIStyle;
import com.qhqc.core.basic.router.provider.BasicModuleApp;
import com.qhqc.core.basic.rvadapter.BasicAdapterConfigs;
import com.qhqc.core.basic.utils.EncryptUtils;
import com.qhqc.core.feature.api.community.impl.ApiCommunityPostsImpl;
import com.qhqc.core.feature.bean.UserInfoBean;
import com.qhqc.core.feature.bean.community.PostsNoticeUnReadBean;
import com.qhqc.core.feature.community.events.BaseEvent;
import com.qhqc.core.feature.community.events.CommentEvent;
import com.qhqc.core.feature.community.events.IEventsCallback;
import com.qhqc.core.feature.community.events.PostsEvent;
import com.qhqc.core.feature.community.events.UserOperateEvent;
import com.qhqc.core.feature.community.ui.adapter.stateview.CommunityAdapterLoadingView;
import com.scwang.smart.refresh.header.MaterialHeader;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000b\u0018\u0000 U2\u00020\u0001:\u0002TUB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u0007H\u0000¢\u0006\u0002\b\u001aJ\u0015\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u0001H\u0000¢\u0006\u0002\b\u001dJ\r\u0010\u001e\u001a\u00020\u0013H\u0000¢\u0006\u0002\b\u001fJ\u0015\u0010 \u001a\u00020\u00132\u0006\u0010!\u001a\u00020\"H\u0001¢\u0006\u0002\b#J\u0015\u0010$\u001a\u00020\u00132\u0006\u0010!\u001a\u00020%H\u0001¢\u0006\u0002\b&J\u0010\u0010'\u001a\u00020\u00132\u0006\u0010!\u001a\u00020(H\u0007J\u0006\u0010)\u001a\u00020\u000eJ\u000e\u0010*\u001a\u00020\u00132\u0006\u0010+\u001a\u00020,J\u0012\u0010-\u001a\u00020\u00132\n\b\u0002\u0010.\u001a\u0004\u0018\u00010/J\u0006\u00100\u001a\u00020\u0013J(\u00101\u001a\u00020\u00132\u0006\u00102\u001a\u00020,2\u0006\u00103\u001a\u00020,2\u0006\u00104\u001a\u00020,2\b\u00105\u001a\u0004\u0018\u00010\u0006J*\u00106\u001a\u00020\u00132\u0006\u00102\u001a\u00020,2\u0006\u00103\u001a\u00020,2\u0006\u00104\u001a\u00020,2\b\u00105\u001a\u0004\u0018\u00010\u0006H\u0002J\u000e\u00107\u001a\u00020\u00132\u0006\u0010.\u001a\u00020\u0010J\b\u00108\u001a\u0004\u0018\u00010\u0010J\u0006\u00109\u001a\u00020\u0013J\b\u0010:\u001a\u00020\u0013H\u0002J\b\u0010;\u001a\u00020\u0013H\u0002J\u0016\u0010<\u001a\u00020\u00132\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020\u0006J\u0010\u0010@\u001a\u0004\u0018\u00010A2\u0006\u0010B\u001a\u00020,J\u0010\u0010C\u001a\u0004\u0018\u00010A2\u0006\u0010B\u001a\u00020,J\u0006\u0010D\u001a\u00020EJ\u0006\u0010F\u001a\u00020EJ\b\u0010G\u001a\u0004\u0018\u00010HJ\u0006\u0010I\u001a\u00020,J\u0006\u0010J\u001a\u00020KJ\u000e\u0010L\u001a\u00020\u00132\u0006\u0010M\u001a\u00020\nJ\u000f\u0010N\u001a\u0004\u0018\u00010\fH\u0000¢\u0006\u0002\bOJ\u000e\u0010P\u001a\u00020\u00132\u0006\u0010Q\u001a\u00020\fJ\u0006\u0010R\u001a\u00020\u0013J\u0006\u0010S\u001a\u00020\u0013R*\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006V"}, d2 = {"Lcom/qhqc/core/feature/community/CommunityManager;", "", "<init>", "()V", "mMapEventCallback", "Ljava/util/HashMap;", "", "Lcom/qhqc/core/feature/community/events/IEventsCallback;", "Lkotlin/collections/HashMap;", "mUserInfoProvider", "Lcom/qhqc/core/feature/community/IUserInfoProvider;", "mUserEventsImpl", "Lcom/qhqc/core/feature/community/IUserEvents;", "unRead", "Lcom/qhqc/core/feature/bean/community/PostsNoticeUnReadBean;", "onNoticeUnReadListener", "Lcom/qhqc/core/feature/community/NoticeChangedListener;", "noticeGoToPlazaClick", "Lkotlin/Function0;", "", "getNoticeGoToPlazaClick", "()Lkotlin/jvm/functions/Function0;", "setNoticeGoToPlazaClick", "(Lkotlin/jvm/functions/Function0;)V", "addEventHandler", "iEvent", "addEventHandler$feature_community_release", "removeHandler", "any", "removeHandler$feature_community_release", "clearHandler", "clearHandler$feature_community_release", "dispatchCommentEvent", "event", "Lcom/qhqc/core/feature/community/events/CommentEvent;", "dispatchCommentEvent$feature_community_release", "dispatchPostsEvent", "Lcom/qhqc/core/feature/community/events/PostsEvent;", "dispatchPostsEvent$feature_community_release", "dispatchEvent", "Lcom/qhqc/core/feature/community/events/BaseEvent;", "getNoticeUnRead", "noticeRead", "count", "", "noticeReadAll", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/qhqc/core/feature/community/CommunityManager$NoticeReadAllListener;", "followListRead", "onNoticeSocketMessage", "type", "targetType", "userId", "dataId", "onNoticeCountChanged", "setNoticeCountListener", "getNoticeCountListener", "removeUnReadListener", "initRefresh", "initAdapterStateView", "initApiConfigs", "context", "Landroid/content/Context;", "apiUrl", "getSVipIcon", "Landroid/graphics/drawable/Drawable;", FirebaseAnalytics.Param.LEVEL, "getVipIcon", "isSuperAdmin", "", "isCountryAdmin", "getMyUserInfo", "Lcom/qhqc/core/feature/bean/UserInfoBean;", "getCountryId", "getUid", "", "registerUserInfoProvider", "provider", "userEventsImpl", "userEventsImpl$feature_community_release", "registerUserEventsImpl", "impl", "clearUserInfoProvider", "clearUserEventsImpl", "NoticeReadAllListener", "Companion", "feature_community_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCommunityManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CommunityManager.kt\ncom/qhqc/core/feature/community/CommunityManager\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,313:1\n1863#2,2:314\n1863#2,2:316\n1863#2,2:318\n*S KotlinDebug\n*F\n+ 1 CommunityManager.kt\ncom/qhqc/core/feature/community/CommunityManager\n*L\n102#1:314,2\n108#1:316,2\n114#1:318,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class CommunityManager {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final Lazy<CommunityManager> instance$delegate = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new Function0() { // from class: com.qhqc.core.feature.community.c
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            CommunityManager instance_delegate$lambda$10;
            instance_delegate$lambda$10 = CommunityManager.instance_delegate$lambda$10();
            return instance_delegate$lambda$10;
        }
    });

    @Nullable
    private IUserEvents mUserEventsImpl;

    @Nullable
    private IUserInfoProvider mUserInfoProvider;

    @Nullable
    private Function0<Unit> noticeGoToPlazaClick;

    @Nullable
    private NoticeChangedListener onNoticeUnReadListener;

    @NotNull
    private final HashMap<String, IEventsCallback> mMapEventCallback = new HashMap<>();

    @NotNull
    private PostsNoticeUnReadBean unRead = new PostsNoticeUnReadBean(0, 0, 0, 0, 15, null);

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R!\u0010\u0004\u001a\u00020\u00058FX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b\t\u0010\n\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/qhqc/core/feature/community/CommunityManager$Companion;", "", "<init>", "()V", "instance", "Lcom/qhqc/core/feature/community/CommunityManager;", "getInstance$annotations", "getInstance", "()Lcom/qhqc/core/feature/community/CommunityManager;", "instance$delegate", "Lkotlin/Lazy;", "feature_community_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void getInstance$annotations() {
        }

        @NotNull
        public final CommunityManager getInstance() {
            return (CommunityManager) CommunityManager.instance$delegate.getValue();
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/qhqc/core/feature/community/CommunityManager$NoticeReadAllListener;", "", "noticeReadAll", "", "feature_community_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public interface NoticeReadAllListener {
        void noticeReadAll();
    }

    public CommunityManager() {
        SVGAParser.INSTANCE.shareParser().init(BasicModuleApp.application());
        initRefresh();
        initAdapterStateView();
        PictureSelectorUIStyle.Companion companion = PictureSelectorUIStyle.INSTANCE;
        PictureSelectorStyle pictureSelectorStyle = new PictureSelectorStyle();
        TitleBarStyle titleBarStyle = new TitleBarStyle();
        titleBarStyle.setTitleBackgroundColor(CompatKtxKt.getColor(R.color.color_9036ff));
        pictureSelectorStyle.setTitleBarStyle(titleBarStyle);
        BottomNavBarStyle bottomNavBarStyle = new BottomNavBarStyle();
        bottomNavBarStyle.setBottomPreviewSelectTextColor(CompatKtxKt.getColor(R.color.white));
        pictureSelectorStyle.setBottomBarStyle(bottomNavBarStyle);
        companion.setDefStyle(pictureSelectorStyle);
    }

    @NotNull
    public static final CommunityManager getInstance() {
        return INSTANCE.getInstance();
    }

    private final void initAdapterStateView() {
        BasicAdapterConfigs.INSTANCE.registerStateView(CommunityAdapterLoadingView.class);
    }

    private final void initRefresh() {
        SmartRefreshLayout.setDefaultRefreshHeaderCreator(new vc.c() { // from class: com.qhqc.core.feature.community.e
            public final tc.d a(Context context, tc.f fVar) {
                tc.d initRefresh$lambda$9;
                initRefresh$lambda$9 = CommunityManager.initRefresh$lambda$9(context, fVar);
                return initRefresh$lambda$9;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final tc.d initRefresh$lambda$9(Context context, tc.f layout) {
        Intrinsics.checkNotNullParameter(layout, "layout");
        layout.setDisableContentWhenRefresh(true);
        MaterialHeader materialHeader = new MaterialHeader(context);
        materialHeader.b(new int[]{R.color.color_9036ff});
        return materialHeader;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CommunityManager instance_delegate$lambda$10() {
        return new CommunityManager();
    }

    public static /* synthetic */ void noticeReadAll$default(CommunityManager communityManager, NoticeReadAllListener noticeReadAllListener, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            noticeReadAllListener = null;
        }
        communityManager.noticeReadAll(noticeReadAllListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit noticeReadAll$lambda$3(ApiErrorException it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Log.e("clearMsgCount", String.valueOf(it.getCode()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onNoticeCountChanged(int type, int targetType, int userId, String dataId) {
        if (type != 1) {
            if (type != 2) {
                if (type == 4) {
                    PostsNoticeUnReadBean postsNoticeUnReadBean = this.unRead;
                    postsNoticeUnReadBean.setFollowPostCnt(postsNoticeUnReadBean.getFollowPostCnt() + 1);
                }
            } else {
                PostsNoticeUnReadBean postsNoticeUnReadBean2 = this.unRead;
                postsNoticeUnReadBean2.setLikeCnt(postsNoticeUnReadBean2.getLikeCnt() + 1);
                PostsNoticeUnReadBean postsNoticeUnReadBean3 = this.unRead;
                postsNoticeUnReadBean3.setTotalCnt(postsNoticeUnReadBean3.getTotalCnt() + 1);
            }
        } else {
            PostsNoticeUnReadBean postsNoticeUnReadBean4 = this.unRead;
            postsNoticeUnReadBean4.setCommentCnt(postsNoticeUnReadBean4.getCommentCnt() + 1);
            PostsNoticeUnReadBean postsNoticeUnReadBean5 = this.unRead;
            postsNoticeUnReadBean5.setTotalCnt(postsNoticeUnReadBean5.getTotalCnt() + 1);
        }
        NoticeChangedListener noticeChangedListener = this.onNoticeUnReadListener;
        if (noticeChangedListener != null) {
            noticeChangedListener.onCountChanged(this.unRead);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setNoticeCountListener$lambda$5(ApiErrorException it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    public final void addEventHandler$feature_community_release(@NotNull IEventsCallback iEvent) {
        Intrinsics.checkNotNullParameter(iEvent, "iEvent");
        this.mMapEventCallback.put(iEvent.toString(), iEvent);
    }

    public final void clearHandler$feature_community_release() {
        this.mMapEventCallback.clear();
    }

    public final void clearUserEventsImpl() {
        this.mUserEventsImpl = null;
    }

    public final void clearUserInfoProvider() {
        this.mUserInfoProvider = null;
    }

    public final void dispatchCommentEvent$feature_community_release(@NotNull CommentEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        dispatchEvent(event);
    }

    public final void dispatchEvent(@NotNull BaseEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof PostsEvent) {
            Collection<IEventsCallback> values = this.mMapEventCallback.values();
            Intrinsics.checkNotNullExpressionValue(values, "<get-values>(...)");
            Iterator<T> it = values.iterator();
            while (it.hasNext()) {
                ((IEventsCallback) it.next()).onPostsEvent((PostsEvent) event);
            }
            return;
        }
        if (event instanceof CommentEvent) {
            Collection<IEventsCallback> values2 = this.mMapEventCallback.values();
            Intrinsics.checkNotNullExpressionValue(values2, "<get-values>(...)");
            Iterator<T> it2 = values2.iterator();
            while (it2.hasNext()) {
                ((IEventsCallback) it2.next()).onCommentEvent((CommentEvent) event);
            }
            return;
        }
        if (event instanceof UserOperateEvent) {
            Collection<IEventsCallback> values3 = this.mMapEventCallback.values();
            Intrinsics.checkNotNullExpressionValue(values3, "<get-values>(...)");
            Iterator<T> it3 = values3.iterator();
            while (it3.hasNext()) {
                ((IEventsCallback) it3.next()).onUserEvent((UserOperateEvent) event);
            }
        }
    }

    public final void dispatchPostsEvent$feature_community_release(@NotNull PostsEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        dispatchEvent(event);
    }

    public final void followListRead() {
        this.unRead.setFollowPostCnt(0);
        NoticeChangedListener noticeChangedListener = this.onNoticeUnReadListener;
        if (noticeChangedListener != null) {
            noticeChangedListener.onCountChanged(this.unRead);
        }
    }

    public final int getCountryId() {
        UserInfoBean userInfo;
        IUserInfoProvider iUserInfoProvider = this.mUserInfoProvider;
        if (iUserInfoProvider != null && (userInfo = iUserInfoProvider.userInfo()) != null) {
            return userInfo.getCountryId();
        }
        return 0;
    }

    @Nullable
    public final UserInfoBean getMyUserInfo() {
        IUserInfoProvider iUserInfoProvider = this.mUserInfoProvider;
        if (iUserInfoProvider != null) {
            return iUserInfoProvider.userInfo();
        }
        return null;
    }

    @Nullable
    /* renamed from: getNoticeCountListener, reason: from getter */
    public final NoticeChangedListener getOnNoticeUnReadListener() {
        return this.onNoticeUnReadListener;
    }

    @Nullable
    public final Function0<Unit> getNoticeGoToPlazaClick() {
        return this.noticeGoToPlazaClick;
    }

    @NotNull
    /* renamed from: getNoticeUnRead, reason: from getter */
    public final PostsNoticeUnReadBean getUnRead() {
        return this.unRead;
    }

    @Nullable
    public final Drawable getSVipIcon(int level) {
        IUserInfoProvider iUserInfoProvider = this.mUserInfoProvider;
        if (iUserInfoProvider != null) {
            return iUserInfoProvider.getSVipIcon(level);
        }
        return null;
    }

    public final long getUid() {
        UserInfoBean userInfo;
        IUserInfoProvider iUserInfoProvider = this.mUserInfoProvider;
        if (iUserInfoProvider != null && (userInfo = iUserInfoProvider.userInfo()) != null) {
            return userInfo.getId();
        }
        return 0L;
    }

    @Nullable
    public final Drawable getVipIcon(int level) {
        IUserInfoProvider iUserInfoProvider = this.mUserInfoProvider;
        if (iUserInfoProvider != null) {
            return iUserInfoProvider.getVipIcon(level);
        }
        return null;
    }

    public final void initApiConfigs(@NotNull Context context, @NotNull String apiUrl) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(apiUrl, "apiUrl");
        HttpUtils.INSTANCE.setConfiguration(new NetWorkConfiguration(context).baseUrls(new String[]{apiUrl}).isCache(false));
        Log.e("configApiUrl", apiUrl);
        EncryptUtils.INSTANCE.setKEY_MAC("H8jK3lM6nO1pQ4rS7tU2vW5xY8zA0bCy");
    }

    public final boolean isCountryAdmin() {
        IUserInfoProvider iUserInfoProvider = this.mUserInfoProvider;
        if (iUserInfoProvider == null || !iUserInfoProvider.isCountryAdmin()) {
            return false;
        }
        return true;
    }

    public final boolean isSuperAdmin() {
        IUserInfoProvider iUserInfoProvider = this.mUserInfoProvider;
        if (iUserInfoProvider == null || !iUserInfoProvider.isSuperAdmin()) {
            return false;
        }
        return true;
    }

    public final void noticeRead(int count) {
        PostsNoticeUnReadBean postsNoticeUnReadBean = this.unRead;
        postsNoticeUnReadBean.setTotalCnt(postsNoticeUnReadBean.getTotalCnt() - count);
        NoticeChangedListener noticeChangedListener = this.onNoticeUnReadListener;
        if (noticeChangedListener != null) {
            noticeChangedListener.onCountChanged(this.unRead);
        }
    }

    public final void noticeReadAll(@Nullable NoticeReadAllListener listener) {
        this.unRead.setTotalCnt(0);
        NoticeChangedListener noticeChangedListener = this.onNoticeUnReadListener;
        if (noticeChangedListener != null) {
            noticeChangedListener.onCountChanged(this.unRead);
        }
        ResponseUtilsKt.startIn$default(FlowKt.onEach(ResponseUtilsKt.flowRequest$default(ApiCommunityPostsImpl.INSTANCE.clearUnreadCount(), false, null, new Function1() { // from class: com.qhqc.core.feature.community.a
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit noticeReadAll$lambda$3;
                noticeReadAll$lambda$3 = CommunityManager.noticeReadAll$lambda$3((ApiErrorException) obj);
                return noticeReadAll$lambda$3;
            }
        }, 3, null), new CommunityManager$noticeReadAll$2(listener, null)), CoroutineScopeKt.MainScope(), false, 2, null);
    }

    public final void onNoticeSocketMessage(final int type, final int targetType, final int userId, @Nullable final String dataId) {
        if (!Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.qhqc.core.feature.community.d
                @Override // java.lang.Runnable
                public final void run() {
                    CommunityManager.this.onNoticeCountChanged(type, targetType, userId, dataId);
                }
            });
        } else {
            onNoticeCountChanged(type, targetType, userId, dataId);
        }
    }

    public final void registerUserEventsImpl(@NotNull IUserEvents impl) {
        Intrinsics.checkNotNullParameter(impl, "impl");
        this.mUserEventsImpl = impl;
    }

    public final void registerUserInfoProvider(@NotNull IUserInfoProvider provider) {
        Intrinsics.checkNotNullParameter(provider, "provider");
        this.mUserInfoProvider = provider;
    }

    public final void removeHandler$feature_community_release(@NotNull Object any) {
        Intrinsics.checkNotNullParameter(any, "any");
        if (this.mMapEventCallback.containsKey(any.toString())) {
            this.mMapEventCallback.remove(any.toString());
        }
    }

    public final void removeUnReadListener() {
        this.onNoticeUnReadListener = null;
    }

    public final void setNoticeCountListener(@NotNull NoticeChangedListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.onNoticeUnReadListener = listener;
        ResponseUtilsKt.startIn$default(FlowKt.onEach(ResponseUtilsKt.flowRequest$default(ApiCommunityPostsImpl.INSTANCE.getUnReadNotice(), false, null, new Function1() { // from class: com.qhqc.core.feature.community.b
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit noticeCountListener$lambda$5;
                noticeCountListener$lambda$5 = CommunityManager.setNoticeCountListener$lambda$5((ApiErrorException) obj);
                return noticeCountListener$lambda$5;
            }
        }, 3, null), new CommunityManager$setNoticeCountListener$2(this, null)), CoroutineScopeKt.MainScope(), false, 2, null);
    }

    public final void setNoticeGoToPlazaClick(@Nullable Function0<Unit> function0) {
        this.noticeGoToPlazaClick = function0;
    }

    @Nullable
    /* renamed from: userEventsImpl$feature_community_release, reason: from getter */
    public final IUserEvents getMUserEventsImpl() {
        return this.mUserEventsImpl;
    }
}
