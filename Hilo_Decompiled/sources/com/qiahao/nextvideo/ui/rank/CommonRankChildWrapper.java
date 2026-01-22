package com.qiahao.nextvideo.ui.rank;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.model.common.NobleInfo;
import com.qiahao.base_common.model.svip.SvipData;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.path.AppController;
import com.qiahao.base_common.support.AppService;
import com.qiahao.base_common.ui.dialog.TipDialog;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.base_common.utils.SvipTypeUtils;
import com.qiahao.base_common.utils.image.HiloImageView;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.base_common.utils.image.ImageSizeKt;
import com.qiahao.base_common.wedgit.shineText.CountryIDView;
import com.qiahao.base_common.wedgit.shineText.NickTextView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.cache.MMKVToLocalCache;
import com.qiahao.nextvideo.data.model.CelebrityOrCharmBean;
import com.qiahao.nextvideo.data.model.RankGroupBean;
import com.qiahao.nextvideo.data.service.UserService;
import com.qiahao.nextvideo.databinding.ViewChildCharmRankDetailBinding;
import com.qiahao.nextvideo.room.StartRoomUtils;
import com.qiahao.nextvideo.utilities.FastClickOneUtils;
import com.qiahao.nextvideo.utilities.userproxy.NumberUtilsKt;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.tencent.qcloud.tuicore.component.CustomLinearLayoutManager;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 N2\u00020\u00012\u00020\u0002:\u0001NB'\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0010\u0010\u000fJ\u001d\u0010\u0014\u001a\u00020\r2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u0017\u001a\u00020\r2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00160\u0011H\u0002¢\u0006\u0004\b\u0017\u0010\u0015Jc\u0010!\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\t2\b\u0010\u0019\u001a\u0004\u0018\u00010\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\t2\b\u0010\u001b\u001a\u0004\u0018\u00010\t2\b\u0010\u001c\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001fH\u0002¢\u0006\u0004\b!\u0010\"J\r\u0010#\u001a\u00020\r¢\u0006\u0004\b#\u0010\u000fJ\u0017\u0010&\u001a\u00020\r2\u0006\u0010%\u001a\u00020$H\u0016¢\u0006\u0004\b&\u0010'J\r\u0010(\u001a\u00020\r¢\u0006\u0004\b(\u0010\u000fJ\u0015\u0010*\u001a\u00020\r2\u0006\u0010)\u001a\u00020\t¢\u0006\u0004\b*\u0010+J\u000f\u0010,\u001a\u00020\rH\u0014¢\u0006\u0004\b,\u0010\u000fR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010-\u001a\u0004\b.\u0010/R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u00100\u001a\u0004\b1\u00102R\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u00103\u001a\u0004\b4\u00105R\"\u00107\u001a\u0002068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u0017\u0010>\u001a\u00020=8\u0006¢\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010AR\u001b\u0010G\u001a\u00020B8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bC\u0010D\u001a\u0004\bE\u0010FR\"\u0010H\u001a\u00020\u001f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010M¨\u0006O"}, d2 = {"Lcom/qiahao/nextvideo/ui/rank/CommonRankChildWrapper;", "Landroid/widget/FrameLayout;", "Lvc/g;", "Landroid/content/Context;", "context", "Lcom/qiahao/nextvideo/ui/rank/AllRankViewController;", "viewController", "", "mLevelType", "", "mDateType", "<init>", "(Landroid/content/Context;Lcom/qiahao/nextvideo/ui/rank/AllRankViewController;ILjava/lang/String;)V", "", "initRecyclerView", "()V", "getDataFromCache", "", "Lcom/qiahao/nextvideo/data/model/CelebrityOrCharmBean;", "list", "saveDataAndFullView", "(Ljava/util/List;)V", "Lcom/qiahao/nextvideo/data/model/RankGroupBean;", "saveGroupDataAndFullView", "groupId", "groupCode", TUIConstants.TUIGroup.GROUP_FACE_URL, "groupName", "groupCountry", TUIConstants.TUIGroup.GROUP_INTRODUCTION, "groupAnnouncement", "", "hasPassWord", "openMeetingRoom", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "getFirstData", "Ltc/f;", "refreshLayout", "onRefresh", "(Ltc/f;)V", "refreshDate", SupportGiftRankActivity.EXTERNAL_ID, "onOpenUserProfile", "(Ljava/lang/String;)V", "onDetachedFromWindow", "Lcom/qiahao/nextvideo/ui/rank/AllRankViewController;", "getViewController", "()Lcom/qiahao/nextvideo/ui/rank/AllRankViewController;", "I", "getMLevelType", "()I", "Ljava/lang/String;", "getMDateType", "()Ljava/lang/String;", "Lcom/qiahao/nextvideo/databinding/ViewChildCharmRankDetailBinding;", "mDataBinding", "Lcom/qiahao/nextvideo/databinding/ViewChildCharmRankDetailBinding;", "getMDataBinding", "()Lcom/qiahao/nextvideo/databinding/ViewChildCharmRankDetailBinding;", "setMDataBinding", "(Lcom/qiahao/nextvideo/databinding/ViewChildCharmRankDetailBinding;)V", "Lnd/a;", "compose", "Lnd/a;", "getCompose", "()Lnd/a;", "Lcom/qiahao/nextvideo/ui/rank/CommonRankAdapter;", "mCommonRankAdapter$delegate", "Lkotlin/Lazy;", "getMCommonRankAdapter", "()Lcom/qiahao/nextvideo/ui/rank/CommonRankAdapter;", "mCommonRankAdapter", "unRequestData", "Z", "getUnRequestData", "()Z", "setUnRequestData", "(Z)V", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class CommonRankChildWrapper extends FrameLayout implements vc.g {

    @NotNull
    public static final String DAY = "day";

    @NotNull
    public static final String MONTH = "month";

    @NotNull
    private static final String TAG = "CommonRankChildWrapper";

    @NotNull
    public static final String WEEK = "week";

    @NotNull
    private final nd.a compose;

    /* renamed from: mCommonRankAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mCommonRankAdapter;

    @NotNull
    private ViewChildCharmRankDetailBinding mDataBinding;

    @NotNull
    private final String mDateType;
    private final int mLevelType;
    private boolean unRequestData;

    @NotNull
    private final AllRankViewController viewController;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommonRankChildWrapper(@NotNull Context context, @NotNull AllRankViewController allRankViewController, int i, @NotNull String str) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(allRankViewController, "viewController");
        Intrinsics.checkNotNullParameter(str, "mDateType");
        this.viewController = allRankViewController;
        this.mLevelType = i;
        this.mDateType = str;
        this.compose = new nd.a();
        this.mCommonRankAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.rank.f
            public final Object invoke() {
                CommonRankAdapter mCommonRankAdapter_delegate$lambda$0;
                mCommonRankAdapter_delegate$lambda$0 = CommonRankChildWrapper.mCommonRankAdapter_delegate$lambda$0(CommonRankChildWrapper.this);
                return mCommonRankAdapter_delegate$lambda$0;
            }
        });
        this.unRequestData = true;
        this.mDataBinding = (ViewChildCharmRankDetailBinding) androidx.databinding.g.h(LayoutInflater.from(context), R.layout.view_child_charm_rank_detail, this, true);
        initRecyclerView();
        if (i != 0) {
            if (i != 1) {
                if (i == 2) {
                    this.mDataBinding.llDiamond1.setBackgroundResource(R.drawable.shape_6f29f9_9dp);
                    this.mDataBinding.llDiamond2.setBackgroundResource(R.drawable.shape_6f29f9_9dp);
                    this.mDataBinding.llDiamond3.setBackgroundResource(R.drawable.shape_6f29f9_9dp);
                    ImageView imageView = this.mDataBinding.top3Platform;
                    Intrinsics.checkNotNullExpressionValue(imageView, "top3Platform");
                    ImageKtxKt.loadImage$default(imageView, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.ic_rank_room_top), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
                    return;
                }
                return;
            }
            this.mDataBinding.llDiamond1.setBackgroundResource(R.drawable.shape_ff8a00_9dp);
            this.mDataBinding.llDiamond2.setBackgroundResource(R.drawable.shape_ff8a00_9dp);
            this.mDataBinding.llDiamond3.setBackgroundResource(R.drawable.shape_ff8a00_9dp);
            ImageView imageView2 = this.mDataBinding.top3Platform;
            Intrinsics.checkNotNullExpressionValue(imageView2, "top3Platform");
            ImageKtxKt.loadImage$default(imageView2, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.ic_rank_famous_top), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
            return;
        }
        this.mDataBinding.llDiamond1.setBackgroundResource(R.drawable.shape_fc4f6d_9dp);
        this.mDataBinding.llDiamond2.setBackgroundResource(R.drawable.shape_fc4f6d_9dp);
        this.mDataBinding.llDiamond3.setBackgroundResource(R.drawable.shape_fc4f6d_9dp);
        ImageView imageView3 = this.mDataBinding.top3Platform;
        Intrinsics.checkNotNullExpressionValue(imageView3, "top3Platform");
        ImageKtxKt.loadImage$default(imageView3, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.ic_rank_charm_top), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
    }

    private final void getDataFromCache() {
        List<RankGroupBean> roomRankCache;
        int i = this.mLevelType;
        if (i != 0) {
            if (i != 1) {
                if (i == 2 && (roomRankCache = MMKVToLocalCache.INSTANCE.getRoomRankCache(this.mDateType)) != null) {
                    saveGroupDataAndFullView(roomRankCache);
                    return;
                }
                return;
            }
            List<CelebrityOrCharmBean> famousRankCache = MMKVToLocalCache.INSTANCE.getFamousRankCache(this.mDateType);
            if (famousRankCache != null) {
                saveDataAndFullView(famousRankCache);
                return;
            }
            return;
        }
        List<CelebrityOrCharmBean> charmRankCache = MMKVToLocalCache.INSTANCE.getCharmRankCache(this.mDateType);
        if (charmRankCache != null) {
            saveDataAndFullView(charmRankCache);
        }
    }

    private final void initRecyclerView() {
        this.mDataBinding.smartRefreshLayout.setOnRefreshListener(this);
        this.mDataBinding.smartRefreshLayout.setEnableLoadMore(false);
        RecyclerView recyclerView = this.mDataBinding.recyclerRank;
        recyclerView.setLayoutManager(new CustomLinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(getMCommonRankAdapter());
        getMCommonRankAdapter().setOnItemClickListener(new OnItemClickListener() { // from class: com.qiahao.nextvideo.ui.rank.b
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                CommonRankChildWrapper.initRecyclerView$lambda$2(CommonRankChildWrapper.this, baseQuickAdapter, view, i);
            }
        });
        if (Intrinsics.areEqual(this.mDateType, "month")) {
            this.mDataBinding.llDiamond1.setVisibility(8);
            this.mDataBinding.llDiamond2.setVisibility(8);
            this.mDataBinding.llDiamond3.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initRecyclerView$lambda$2(CommonRankChildWrapper commonRankChildWrapper, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        Object item = baseQuickAdapter.getItem(i);
        Intrinsics.checkNotNull(item, "null cannot be cast to non-null type com.qiahao.nextvideo.ui.rank.CommonRankViewModel");
        CommonRankViewModel commonRankViewModel = (CommonRankViewModel) item;
        if (commonRankChildWrapper.mLevelType == 2) {
            if (UserStore.INSTANCE.getShared().checkSvipAndWealth()) {
                StartRoomUtils.startRoom$default(StartRoomUtils.INSTANCE, commonRankViewModel.getExternalId(), null, null, null, null, null, null, null, 0, 0, null, 0, false, 8190, null);
                return;
            }
            return;
        }
        SvipData svip = commonRankViewModel.getSvip();
        if (svip != null && svip.isRankStealth() && commonRankViewModel.checkNotOfficialStaff()) {
            Context context = commonRankChildWrapper.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            new TipDialog(context).setTipContent(ResourcesKtxKt.getStringById(commonRankChildWrapper, 2131954198)).show();
            return;
        }
        commonRankChildWrapper.onOpenUserProfile(commonRankViewModel.getExternalId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CommonRankAdapter mCommonRankAdapter_delegate$lambda$0(CommonRankChildWrapper commonRankChildWrapper) {
        return new CommonRankAdapter(R.layout.item_rank1, commonRankChildWrapper.mLevelType, commonRankChildWrapper.mDateType);
    }

    private final void openMeetingRoom(String groupId, String groupCode, String groupFaceUrl, String groupName, String groupCountry, String groupIntroduction, String groupAnnouncement, Boolean hasPassWord) {
        if (FastClickOneUtils.INSTANCE.isFastClick()) {
            StartRoomUtils.startRoom$default(StartRoomUtils.INSTANCE, groupId, groupCode, groupFaceUrl, groupName, hasPassWord, groupCountry, groupIntroduction, groupAnnouncement, 0, 0, null, 0, false, 7936, null);
        }
    }

    static /* synthetic */ void openMeetingRoom$default(CommonRankChildWrapper commonRankChildWrapper, String str, String str2, String str3, String str4, String str5, String str6, String str7, Boolean bool, int i, Object obj) {
        String str8;
        String str9;
        Boolean bool2;
        if ((i & 32) != 0) {
            str8 = "";
        } else {
            str8 = str6;
        }
        if ((i & 64) != 0) {
            str9 = "";
        } else {
            str9 = str7;
        }
        if ((i & 128) != 0) {
            bool2 = null;
        } else {
            bool2 = bool;
        }
        commonRankChildWrapper.openMeetingRoom(str, str2, str3, str4, str5, str8, str9, bool2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit refreshDate$lambda$10(CommonRankChildWrapper commonRankChildWrapper, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        commonRankChildWrapper.mDataBinding.smartRefreshLayout.finishRefresh();
        List<CelebrityOrCharmBean> list = (List) apiResponse.getData();
        if (list != null) {
            if (!list.isEmpty()) {
                if (list.size() > 10) {
                    MMKVToLocalCache.INSTANCE.saveFamousRankCache(list.subList(0, 10), commonRankChildWrapper.mDateType);
                } else {
                    MMKVToLocalCache.INSTANCE.saveFamousRankCache(list, commonRankChildWrapper.mDateType);
                }
            }
            commonRankChildWrapper.saveDataAndFullView(list);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit refreshDate$lambda$11(CommonRankChildWrapper commonRankChildWrapper, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        commonRankChildWrapper.mDataBinding.smartRefreshLayout.finishRefresh();
        Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, commonRankChildWrapper.getContext(), ResourcesKtxKt.getStringById(commonRankChildWrapper, 2131952667), false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        Log.d(TAG, "onRefresh: " + th.getLocalizedMessage());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit refreshDate$lambda$13(CommonRankChildWrapper commonRankChildWrapper, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        commonRankChildWrapper.mDataBinding.smartRefreshLayout.finishRefresh();
        List<RankGroupBean> list = (List) apiResponse.getData();
        if (list != null) {
            if (!list.isEmpty()) {
                if (list.size() > 10) {
                    MMKVToLocalCache.INSTANCE.saveRoomRankCache(list.subList(0, 10), commonRankChildWrapper.mDateType);
                } else {
                    MMKVToLocalCache.INSTANCE.saveRoomRankCache(list, commonRankChildWrapper.mDateType);
                }
            }
            commonRankChildWrapper.saveGroupDataAndFullView(list);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit refreshDate$lambda$14(CommonRankChildWrapper commonRankChildWrapper, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        commonRankChildWrapper.mDataBinding.smartRefreshLayout.finishRefresh();
        Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, commonRankChildWrapper.getContext(), ResourcesKtxKt.getStringById(commonRankChildWrapper, 2131952667), false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        Log.d(TAG, "onRefresh: " + th.getLocalizedMessage());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit refreshDate$lambda$7(CommonRankChildWrapper commonRankChildWrapper, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        commonRankChildWrapper.mDataBinding.smartRefreshLayout.finishRefresh();
        List<CelebrityOrCharmBean> list = (List) apiResponse.getData();
        if (list != null) {
            if (!list.isEmpty()) {
                if (list.size() > 10) {
                    MMKVToLocalCache.INSTANCE.saveCharmRankCache(list.subList(0, 10), commonRankChildWrapper.mDateType);
                } else {
                    MMKVToLocalCache.INSTANCE.saveCharmRankCache(list, commonRankChildWrapper.mDateType);
                }
            }
            commonRankChildWrapper.saveDataAndFullView(list);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit refreshDate$lambda$8(CommonRankChildWrapper commonRankChildWrapper, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        commonRankChildWrapper.mDataBinding.smartRefreshLayout.finishRefresh();
        Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, commonRankChildWrapper.getContext(), ResourcesKtxKt.getStringById(commonRankChildWrapper, 2131952667), false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        Log.d(TAG, "onRefresh: " + th.getLocalizedMessage());
        return Unit.INSTANCE;
    }

    private final void saveDataAndFullView(List<CelebrityOrCharmBean> list) {
        int i;
        int i2;
        boolean z;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        boolean z2;
        int i9;
        String str;
        String str2;
        int i10;
        int i11;
        boolean z3;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        boolean z4;
        Integer num;
        int i18;
        Integer level;
        Integer level2;
        Integer level3;
        Integer level4;
        int i19;
        int i20;
        boolean z5;
        int i21;
        int i22;
        int i23;
        int i24;
        int i25;
        int i26;
        boolean z6;
        int i27;
        Integer num2;
        int i28;
        Integer level5;
        Integer level6;
        Integer level7;
        Integer level8;
        Integer num3;
        int i29;
        Integer level9;
        Integer level10;
        Integer level11;
        Integer level12;
        if (!list.isEmpty()) {
            final CelebrityOrCharmBean celebrityOrCharmBean = list.get(0);
            this.mDataBinding.llTop1.setVisibility(0);
            LinearLayout linearLayout = this.mDataBinding.llDiamond1;
            int i30 = 8;
            if (Intrinsics.areEqual(this.mDateType, "day")) {
                i = 0;
            } else {
                i = 8;
            }
            linearLayout.setVisibility(i);
            this.mDataBinding.top1Diamond.setText(NumberUtilsKt.rankNumberFormat(celebrityOrCharmBean.getNum()));
            CountryIDView countryIDView = this.mDataBinding.top1Id;
            String format = String.format(ResourcesKtxKt.getStringById(this, 2131953102), Arrays.copyOf(new Object[]{celebrityOrCharmBean.getUserBase().getCode()}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            Integer idFrameType = celebrityOrCharmBean.getUserBase().getIdFrameType();
            if (idFrameType != null) {
                i2 = idFrameType.intValue();
            } else {
                i2 = 0;
            }
            int color = androidx.core.content.a.getColor(getContext(), 2131099909);
            Boolean isPrettyCode = celebrityOrCharmBean.getUserBase().isPrettyCode();
            if (isPrettyCode != null) {
                z = isPrettyCode.booleanValue();
            } else {
                z = false;
            }
            countryIDView.refreshText(format, i2, color, z);
            NickTextView nickTextView = this.mDataBinding.top1Name;
            UserService.Companion companion = UserService.INSTANCE;
            NobleInfo noble = celebrityOrCharmBean.getUserBase().getNoble();
            if (noble != null && (level12 = noble.getLevel()) != null) {
                i3 = level12.intValue();
            } else {
                i3 = 0;
            }
            nickTextView.setTextColor(UserService.Companion.getNobleColor$default(companion, i3, 0, 2, null));
            NickTextView nickTextView2 = this.mDataBinding.top1Name;
            String nick = celebrityOrCharmBean.getUserBase().getNick();
            SvipData svip = celebrityOrCharmBean.getUserBase().getSvip();
            if (svip != null) {
                i4 = svip.getSvipLevel();
            } else {
                i4 = 0;
            }
            NobleInfo noble2 = celebrityOrCharmBean.getUserBase().getNoble();
            if (noble2 != null && (level11 = noble2.getLevel()) != null) {
                i5 = level11.intValue();
            } else {
                i5 = 0;
            }
            nickTextView2.setSVipAndNoble(nick, i4, i5);
            ImageView imageView = this.mDataBinding.iconVip1;
            if (celebrityOrCharmBean.getUserBase().isVip()) {
                i6 = 0;
            } else {
                i6 = 8;
            }
            imageView.setVisibility(i6);
            NobleInfo noble3 = celebrityOrCharmBean.getUserBase().getNoble();
            if (noble3 != null && (level10 = noble3.getLevel()) != null) {
                i7 = level10.intValue();
            } else {
                i7 = 0;
            }
            if (i7 > 0) {
                ImageView imageView2 = this.mDataBinding.iconNoble1;
                Context context = getContext();
                NobleInfo noble4 = celebrityOrCharmBean.getUserBase().getNoble();
                if (noble4 != null && (level9 = noble4.getLevel()) != null) {
                    i29 = level9.intValue();
                } else {
                    i29 = 0;
                }
                imageView2.setImageDrawable(androidx.core.content.a.getDrawable(context, companion.getNobleDrawableRes(i29)));
                this.mDataBinding.iconVip1.setVisibility(8);
                this.mDataBinding.iconNoble1.setVisibility(0);
            } else {
                this.mDataBinding.iconNoble1.setVisibility(8);
            }
            SvipData svip2 = celebrityOrCharmBean.getUserBase().getSvip();
            if (svip2 != null) {
                i8 = svip2.getSvipLevel();
            } else {
                i8 = 0;
            }
            if (i8 > 0) {
                this.mDataBinding.iconVip1.setVisibility(8);
                this.mDataBinding.iconNoble1.setVisibility(8);
                this.mDataBinding.svip1.setVisibility(0);
                SvipTypeUtils svipTypeUtils = SvipTypeUtils.INSTANCE;
                SvipData svip3 = celebrityOrCharmBean.getUserBase().getSvip();
                if (svip3 != null) {
                    num3 = Integer.valueOf(svip3.getSvipLevel());
                } else {
                    num3 = null;
                }
                Integer svipMedal = svipTypeUtils.getSvipMedal(num3);
                if (svipMedal != null) {
                    this.mDataBinding.svip1.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), svipMedal.intValue()));
                    Unit unit = Unit.INSTANCE;
                }
            } else {
                this.mDataBinding.svip1.setVisibility(8);
                Unit unit2 = Unit.INSTANCE;
            }
            HiloImageView.loadImage$default(this.mDataBinding.top1Avatar, ImageSizeKt.image100(celebrityOrCharmBean.getUserBase().getAvatar()), 0, 0, 6, (Object) null);
            this.mDataBinding.top1Avatar.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.rank.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CommonRankChildWrapper.saveDataAndFullView$lambda$16(CelebrityOrCharmBean.this, this, view);
                }
            });
            MedalGridLayout.setDataAndLayoutView$default(this.mDataBinding.top1Medal, celebrityOrCharmBean.getUserBase().getMedalInfo(), 0, 2, null);
            SvipData svip4 = celebrityOrCharmBean.getUserBase().getSvip();
            if (svip4 != null && svip4.isRankStealth()) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                HiloImageView.loadImage$default(this.mDataBinding.top1Avatar, Integer.valueOf(R.drawable.svip_hide_heard), 0, 0, 6, (Object) null);
                this.mDataBinding.top1Id.setVisibility(8);
                NickTextView nickTextView3 = this.mDataBinding.top1Name;
                nickTextView3.setDefault(androidx.core.content.a.getColor(nickTextView3.getContext(), 2131101214));
                this.mDataBinding.top1Name.setText(ResourcesKtxKt.getStringById(this, 2131954197));
                this.mDataBinding.iconVip1.setVisibility(8);
                this.mDataBinding.iconNoble1.setVisibility(8);
                this.mDataBinding.svip1.setVisibility(8);
                this.mDataBinding.top1Medal.setVisibility(8);
            } else {
                CountryIDView countryIDView2 = this.mDataBinding.top1Id;
                if (UserStore.INSTANCE.getShared().checkSvipAndWealth()) {
                    i9 = 0;
                } else {
                    i9 = 8;
                }
                countryIDView2.setVisibility(i9);
            }
            if (list.size() > 1) {
                final CelebrityOrCharmBean celebrityOrCharmBean2 = list.get(1);
                this.mDataBinding.llTop2.setVisibility(0);
                LinearLayout linearLayout2 = this.mDataBinding.llDiamond2;
                if (Intrinsics.areEqual(this.mDateType, "day")) {
                    i19 = 0;
                } else {
                    i19 = 8;
                }
                linearLayout2.setVisibility(i19);
                this.mDataBinding.top2Diamond.setText(NumberUtilsKt.rankNumberFormat(celebrityOrCharmBean2.getNum()));
                CountryIDView countryIDView3 = this.mDataBinding.top2Id;
                String format2 = String.format(ResourcesKtxKt.getStringById(this, 2131953102), Arrays.copyOf(new Object[]{celebrityOrCharmBean2.getUserBase().getCode()}, 1));
                Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
                Integer idFrameType2 = celebrityOrCharmBean2.getUserBase().getIdFrameType();
                if (idFrameType2 != null) {
                    i20 = idFrameType2.intValue();
                } else {
                    i20 = 0;
                }
                int color2 = androidx.core.content.a.getColor(getContext(), 2131099909);
                Boolean isPrettyCode2 = celebrityOrCharmBean2.getUserBase().isPrettyCode();
                if (isPrettyCode2 != null) {
                    z5 = isPrettyCode2.booleanValue();
                } else {
                    z5 = false;
                }
                countryIDView3.refreshText(format2, i20, color2, z5);
                NickTextView nickTextView4 = this.mDataBinding.top2Name;
                NobleInfo noble5 = celebrityOrCharmBean2.getUserBase().getNoble();
                if (noble5 != null && (level8 = noble5.getLevel()) != null) {
                    i21 = level8.intValue();
                } else {
                    i21 = 0;
                }
                nickTextView4.setTextColor(UserService.Companion.getNobleColor$default(companion, i21, 0, 2, null));
                NickTextView nickTextView5 = this.mDataBinding.top2Name;
                String nick2 = celebrityOrCharmBean2.getUserBase().getNick();
                SvipData svip5 = celebrityOrCharmBean2.getUserBase().getSvip();
                if (svip5 != null) {
                    i22 = svip5.getSvipLevel();
                } else {
                    i22 = 0;
                }
                NobleInfo noble6 = celebrityOrCharmBean2.getUserBase().getNoble();
                if (noble6 != null && (level7 = noble6.getLevel()) != null) {
                    i23 = level7.intValue();
                } else {
                    i23 = 0;
                }
                nickTextView5.setSVipAndNoble(nick2, i22, i23);
                ImageView imageView3 = this.mDataBinding.iconVip2;
                if (celebrityOrCharmBean2.getUserBase().isVip()) {
                    i24 = 0;
                } else {
                    i24 = 8;
                }
                imageView3.setVisibility(i24);
                NobleInfo noble7 = celebrityOrCharmBean2.getUserBase().getNoble();
                if (noble7 != null && (level6 = noble7.getLevel()) != null) {
                    i25 = level6.intValue();
                } else {
                    i25 = 0;
                }
                if (i25 > 0) {
                    ImageView imageView4 = this.mDataBinding.iconNoble2;
                    Context context2 = getContext();
                    NobleInfo noble8 = celebrityOrCharmBean2.getUserBase().getNoble();
                    if (noble8 != null && (level5 = noble8.getLevel()) != null) {
                        i28 = level5.intValue();
                    } else {
                        i28 = 0;
                    }
                    imageView4.setImageDrawable(androidx.core.content.a.getDrawable(context2, companion.getNobleDrawableRes(i28)));
                    this.mDataBinding.iconVip2.setVisibility(8);
                    this.mDataBinding.iconNoble2.setVisibility(0);
                } else {
                    this.mDataBinding.iconNoble2.setVisibility(8);
                }
                SvipData svip6 = celebrityOrCharmBean2.getUserBase().getSvip();
                if (svip6 != null) {
                    i26 = svip6.getSvipLevel();
                } else {
                    i26 = 0;
                }
                if (i26 > 0) {
                    this.mDataBinding.iconVip2.setVisibility(8);
                    this.mDataBinding.iconNoble2.setVisibility(8);
                    this.mDataBinding.svip2.setVisibility(0);
                    SvipTypeUtils svipTypeUtils2 = SvipTypeUtils.INSTANCE;
                    SvipData svip7 = celebrityOrCharmBean2.getUserBase().getSvip();
                    if (svip7 != null) {
                        num2 = Integer.valueOf(svip7.getSvipLevel());
                    } else {
                        num2 = null;
                    }
                    Integer svipMedal2 = svipTypeUtils2.getSvipMedal(num2);
                    if (svipMedal2 != null) {
                        int intValue = svipMedal2.intValue();
                        ViewChildCharmRankDetailBinding viewChildCharmRankDetailBinding = this.mDataBinding;
                        viewChildCharmRankDetailBinding.svip2.setImageDrawable(androidx.core.content.a.getDrawable(viewChildCharmRankDetailBinding.getRoot().getContext(), intValue));
                        Unit unit3 = Unit.INSTANCE;
                    }
                } else {
                    this.mDataBinding.svip2.setVisibility(8);
                    Unit unit4 = Unit.INSTANCE;
                }
                HiloImageView.loadImage$default(this.mDataBinding.top2Avatar, ImageSizeKt.image100(celebrityOrCharmBean2.getUserBase().getAvatar()), 0, 0, 6, (Object) null);
                this.mDataBinding.top2Avatar.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.rank.d
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        CommonRankChildWrapper.saveDataAndFullView$lambda$18(CelebrityOrCharmBean.this, this, view);
                    }
                });
                MedalGridLayout.setDataAndLayoutView$default(this.mDataBinding.top2Medal, celebrityOrCharmBean2.getUserBase().getMedalInfo(), 0, 2, null);
                SvipData svip8 = celebrityOrCharmBean2.getUserBase().getSvip();
                if (svip8 != null && svip8.isRankStealth()) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                if (z6) {
                    HiloImageView.loadImage$default(this.mDataBinding.top2Avatar, Integer.valueOf(R.drawable.svip_hide_heard), 0, 0, 6, (Object) null);
                    this.mDataBinding.top2Id.setVisibility(8);
                    NickTextView nickTextView6 = this.mDataBinding.top2Name;
                    nickTextView6.setDefault(androidx.core.content.a.getColor(nickTextView6.getContext(), 2131101214));
                    this.mDataBinding.top2Name.setText(ResourcesKtxKt.getStringById(this, 2131954197));
                    this.mDataBinding.iconVip2.setVisibility(8);
                    this.mDataBinding.iconNoble2.setVisibility(8);
                    this.mDataBinding.svip2.setVisibility(8);
                    this.mDataBinding.top2Medal.setVisibility(8);
                } else {
                    CountryIDView countryIDView4 = this.mDataBinding.top2Id;
                    if (UserStore.INSTANCE.getShared().checkSvipAndWealth()) {
                        i27 = 0;
                    } else {
                        i27 = 8;
                    }
                    countryIDView4.setVisibility(i27);
                }
            }
            if (list.size() > 2) {
                final CelebrityOrCharmBean celebrityOrCharmBean3 = list.get(2);
                this.mDataBinding.llTop3.setVisibility(0);
                LinearLayout linearLayout3 = this.mDataBinding.llDiamond3;
                if (Intrinsics.areEqual(this.mDateType, "day")) {
                    i10 = 0;
                } else {
                    i10 = 8;
                }
                linearLayout3.setVisibility(i10);
                this.mDataBinding.top3Diamond.setText(NumberUtilsKt.rankNumberFormat(celebrityOrCharmBean3.getNum()));
                CountryIDView countryIDView5 = this.mDataBinding.top3Id;
                String format3 = String.format(ResourcesKtxKt.getStringById(this, 2131953102), Arrays.copyOf(new Object[]{celebrityOrCharmBean3.getUserBase().getCode()}, 1));
                Intrinsics.checkNotNullExpressionValue(format3, "format(...)");
                Integer idFrameType3 = celebrityOrCharmBean3.getUserBase().getIdFrameType();
                if (idFrameType3 != null) {
                    i11 = idFrameType3.intValue();
                } else {
                    i11 = 0;
                }
                int color3 = androidx.core.content.a.getColor(getContext(), 2131099909);
                Boolean isPrettyCode3 = celebrityOrCharmBean3.getUserBase().isPrettyCode();
                if (isPrettyCode3 != null) {
                    z3 = isPrettyCode3.booleanValue();
                } else {
                    z3 = false;
                }
                countryIDView5.refreshText(format3, i11, color3, z3);
                NickTextView nickTextView7 = this.mDataBinding.top3Name;
                NobleInfo noble9 = celebrityOrCharmBean3.getUserBase().getNoble();
                if (noble9 != null && (level4 = noble9.getLevel()) != null) {
                    i12 = level4.intValue();
                } else {
                    i12 = 0;
                }
                nickTextView7.setTextColor(UserService.Companion.getNobleColor$default(companion, i12, 0, 2, null));
                NickTextView nickTextView8 = this.mDataBinding.top3Name;
                String nick3 = celebrityOrCharmBean3.getUserBase().getNick();
                SvipData svip9 = celebrityOrCharmBean3.getUserBase().getSvip();
                if (svip9 != null) {
                    i13 = svip9.getSvipLevel();
                } else {
                    i13 = 0;
                }
                NobleInfo noble10 = celebrityOrCharmBean3.getUserBase().getNoble();
                if (noble10 != null && (level3 = noble10.getLevel()) != null) {
                    i14 = level3.intValue();
                } else {
                    i14 = 0;
                }
                nickTextView8.setSVipAndNoble(nick3, i13, i14);
                ImageView imageView5 = this.mDataBinding.iconVip3;
                if (celebrityOrCharmBean3.getUserBase().isVip()) {
                    i15 = 0;
                } else {
                    i15 = 8;
                }
                imageView5.setVisibility(i15);
                NobleInfo noble11 = celebrityOrCharmBean3.getUserBase().getNoble();
                if (noble11 != null && (level2 = noble11.getLevel()) != null) {
                    i16 = level2.intValue();
                } else {
                    i16 = 0;
                }
                if (i16 > 0) {
                    ViewChildCharmRankDetailBinding viewChildCharmRankDetailBinding2 = this.mDataBinding;
                    ImageView imageView6 = viewChildCharmRankDetailBinding2.iconNoble3;
                    Context context3 = viewChildCharmRankDetailBinding2.getRoot().getContext();
                    NobleInfo noble12 = celebrityOrCharmBean3.getUserBase().getNoble();
                    if (noble12 != null && (level = noble12.getLevel()) != null) {
                        i18 = level.intValue();
                    } else {
                        i18 = 0;
                    }
                    imageView6.setImageDrawable(androidx.core.content.a.getDrawable(context3, companion.getNobleDrawableRes(i18)));
                    this.mDataBinding.iconVip3.setVisibility(8);
                    this.mDataBinding.iconNoble3.setVisibility(0);
                } else {
                    this.mDataBinding.iconNoble3.setVisibility(8);
                }
                SvipData svip10 = celebrityOrCharmBean3.getUserBase().getSvip();
                if (svip10 != null) {
                    i17 = svip10.getSvipLevel();
                } else {
                    i17 = 0;
                }
                if (i17 > 0) {
                    this.mDataBinding.iconVip3.setVisibility(8);
                    this.mDataBinding.iconNoble3.setVisibility(8);
                    this.mDataBinding.svip3.setVisibility(0);
                    SvipTypeUtils svipTypeUtils3 = SvipTypeUtils.INSTANCE;
                    SvipData svip11 = celebrityOrCharmBean3.getUserBase().getSvip();
                    if (svip11 != null) {
                        num = Integer.valueOf(svip11.getSvipLevel());
                    } else {
                        num = null;
                    }
                    Integer svipMedal3 = svipTypeUtils3.getSvipMedal(num);
                    if (svipMedal3 != null) {
                        int intValue2 = svipMedal3.intValue();
                        ViewChildCharmRankDetailBinding viewChildCharmRankDetailBinding3 = this.mDataBinding;
                        viewChildCharmRankDetailBinding3.svip3.setImageDrawable(androidx.core.content.a.getDrawable(viewChildCharmRankDetailBinding3.getRoot().getContext(), intValue2));
                        Unit unit5 = Unit.INSTANCE;
                    }
                } else {
                    this.mDataBinding.svip3.setVisibility(8);
                    Unit unit6 = Unit.INSTANCE;
                }
                HiloImageView.loadImage$default(this.mDataBinding.top3Avatar, ImageSizeKt.image100(celebrityOrCharmBean3.getUserBase().getAvatar()), 0, 0, 6, (Object) null);
                this.mDataBinding.top3Avatar.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.rank.e
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        CommonRankChildWrapper.saveDataAndFullView$lambda$20(CelebrityOrCharmBean.this, this, view);
                    }
                });
                MedalGridLayout.setDataAndLayoutView$default(this.mDataBinding.top3Medal, celebrityOrCharmBean3.getUserBase().getMedalInfo(), 0, 2, null);
                SvipData svip12 = celebrityOrCharmBean3.getUserBase().getSvip();
                if (svip12 != null && svip12.isRankStealth()) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (z4) {
                    HiloImageView.loadImage$default(this.mDataBinding.top3Avatar, Integer.valueOf(R.drawable.svip_hide_heard), 0, 0, 6, (Object) null);
                    this.mDataBinding.top3Id.setVisibility(8);
                    NickTextView nickTextView9 = this.mDataBinding.top3Name;
                    nickTextView9.setDefault(androidx.core.content.a.getColor(nickTextView9.getContext(), 2131101214));
                    this.mDataBinding.top3Name.setText(ResourcesKtxKt.getStringById(this, 2131954197));
                    this.mDataBinding.iconVip3.setVisibility(8);
                    this.mDataBinding.iconNoble3.setVisibility(8);
                    this.mDataBinding.svip3.setVisibility(8);
                    this.mDataBinding.top3Medal.setVisibility(8);
                } else {
                    CountryIDView countryIDView6 = this.mDataBinding.top3Id;
                    if (UserStore.INSTANCE.getShared().checkSvipAndWealth()) {
                        i30 = 0;
                    }
                    countryIDView6.setVisibility(i30);
                }
            }
            if (list.size() > 3) {
                List<CelebrityOrCharmBean> subList = list.subList(3, list.size());
                ArrayList arrayList = new ArrayList();
                int size = subList.size();
                for (int i31 = 0; i31 < size; i31++) {
                    String externalId = subList.get(i31).getUserBase().getExternalId();
                    String avatar = subList.get(i31).getUserBase().getAvatar();
                    if (avatar == null) {
                        str = "";
                    } else {
                        str = avatar;
                    }
                    String nick4 = subList.get(i31).getUserBase().getNick();
                    if (nick4 == null) {
                        str2 = "";
                    } else {
                        str2 = nick4;
                    }
                    arrayList.add(new CommonRankViewModel(externalId, str, str2, subList.get(i31).getUserBase().getSex(), subList.get(i31).getUserBase().getCode(), subList.get(i31).getNum(), subList.get(i31).getUserBase().isVip(), subList.get(i31).getUserBase().getBirthday(), subList.get(i31).getUserBase().isShowAge(), subList.get(i31).getUserBase().getCountryIcon(), subList.get(i31).getUserBase().getMedalInfo(), subList.get(i31).getUserBase().isPrettyCode(), subList.get(i31).getUserBase().getWealthUserGrade(), subList.get(i31).getUserBase().getCharmUserGrade(), subList.get(i31).getUserBase().getActivityUserGrade(), subList.get(i31).getUserBase().getNoble(), null, subList.get(i31).getUserBase().getSvip(), subList.get(i31).getUserBase().isCountryId(), subList.get(i31).getUserBase().getIdFrameType(), 65536, null));
                }
                getMCommonRankAdapter().setList(arrayList);
                return;
            }
            return;
        }
        this.mDataBinding.llTop1.setVisibility(4);
        this.mDataBinding.llTop2.setVisibility(4);
        this.mDataBinding.llTop3.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void saveDataAndFullView$lambda$16(CelebrityOrCharmBean celebrityOrCharmBean, CommonRankChildWrapper commonRankChildWrapper, View view) {
        SvipData svip = celebrityOrCharmBean.getUserBase().getSvip();
        if (svip != null && svip.isRankStealth()) {
            Context context = commonRankChildWrapper.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            new TipDialog(context).setTipContent(ResourcesKtxKt.getStringById(commonRankChildWrapper, 2131954198)).show();
        } else {
            String externalId = celebrityOrCharmBean.getUserBase().getExternalId();
            if (externalId == null) {
                externalId = "";
            }
            commonRankChildWrapper.onOpenUserProfile(externalId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void saveDataAndFullView$lambda$18(CelebrityOrCharmBean celebrityOrCharmBean, CommonRankChildWrapper commonRankChildWrapper, View view) {
        SvipData svip = celebrityOrCharmBean.getUserBase().getSvip();
        if (svip != null && svip.isRankStealth() && celebrityOrCharmBean.getUserBase().checkNotOfficialStaffAndMy()) {
            Context context = commonRankChildWrapper.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            new TipDialog(context).setTipContent(ResourcesKtxKt.getStringById(commonRankChildWrapper, 2131954198)).show();
            return;
        }
        commonRankChildWrapper.onOpenUserProfile(celebrityOrCharmBean.getUserBase().getExternalId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void saveDataAndFullView$lambda$20(CelebrityOrCharmBean celebrityOrCharmBean, CommonRankChildWrapper commonRankChildWrapper, View view) {
        SvipData svip = celebrityOrCharmBean.getUserBase().getSvip();
        if (svip != null && svip.isRankStealth() && celebrityOrCharmBean.getUserBase().checkNotOfficialStaffAndMy()) {
            Context context = commonRankChildWrapper.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            new TipDialog(context).setTipContent(ResourcesKtxKt.getStringById(commonRankChildWrapper, 2131954198)).show();
            return;
        }
        commonRankChildWrapper.onOpenUserProfile(celebrityOrCharmBean.getUserBase().getExternalId());
    }

    private final void saveGroupDataAndFullView(final List<RankGroupBean> list) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        if (!list.isEmpty()) {
            this.mDataBinding.llTop1.setVisibility(0);
            LinearLayout linearLayout = this.mDataBinding.llDiamond1;
            int i6 = 8;
            if (Intrinsics.areEqual(this.mDateType, "day")) {
                i = 0;
            } else {
                i = 8;
            }
            linearLayout.setVisibility(i);
            this.mDataBinding.top1Diamond.setText(NumberUtilsKt.rankNumberFormat(list.get(0).getScore()));
            CountryIDView countryIDView = this.mDataBinding.top1Id;
            String format = String.format(ResourcesKtxKt.getStringById(this, 2131953102), Arrays.copyOf(new Object[]{list.get(0).getGroupBase().getCode()}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            countryIDView.refreshText(format, 0, androidx.core.content.a.getColor(getContext(), 2131099909), false);
            CountryIDView countryIDView2 = this.mDataBinding.top1Id;
            UserStore.Companion companion = UserStore.INSTANCE;
            if (companion.getShared().checkSvipAndWealth()) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            countryIDView2.setVisibility(i2);
            this.mDataBinding.top1Name.setText(list.get(0).getGroupBase().getName());
            HiloImageView.loadImage$default(this.mDataBinding.top1Avatar, ImageSizeKt.image100(list.get(0).getGroupBase().getFaceUrl()), 0, 0, 6, (Object) null);
            this.mDataBinding.top1Avatar.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.rank.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CommonRankChildWrapper.saveGroupDataAndFullView$lambda$21(list, view);
                }
            });
            MedalGridLayout.setDataAndLayoutView$default(this.mDataBinding.top1Medal, list.get(0).getGroupBase().getGroupMedals(), 0, 2, null);
            if (list.size() > 1) {
                this.mDataBinding.llTop2.setVisibility(0);
                LinearLayout linearLayout2 = this.mDataBinding.llDiamond2;
                if (Intrinsics.areEqual(this.mDateType, "day")) {
                    i4 = 0;
                } else {
                    i4 = 8;
                }
                linearLayout2.setVisibility(i4);
                this.mDataBinding.top2Diamond.setText(NumberUtilsKt.rankNumberFormat(list.get(1).getScore()));
                CountryIDView countryIDView3 = this.mDataBinding.top2Id;
                String format2 = String.format(ResourcesKtxKt.getStringById(this, 2131953102), Arrays.copyOf(new Object[]{list.get(1).getGroupBase().getCode()}, 1));
                Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
                countryIDView3.refreshText(format2, 0, androidx.core.content.a.getColor(getContext(), 2131099909), false);
                CountryIDView countryIDView4 = this.mDataBinding.top2Id;
                if (companion.getShared().checkSvipAndWealth()) {
                    i5 = 0;
                } else {
                    i5 = 8;
                }
                countryIDView4.setVisibility(i5);
                this.mDataBinding.top2Name.setText(list.get(1).getGroupBase().getName());
                HiloImageView.loadImage$default(this.mDataBinding.top2Avatar, ImageSizeKt.image100(list.get(1).getGroupBase().getFaceUrl()), 0, 0, 6, (Object) null);
                this.mDataBinding.top2Avatar.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.rank.h
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        CommonRankChildWrapper.saveGroupDataAndFullView$lambda$22(list, view);
                    }
                });
                MedalGridLayout.setDataAndLayoutView$default(this.mDataBinding.top2Medal, list.get(1).getGroupBase().getGroupMedals(), 0, 2, null);
            }
            if (list.size() > 2) {
                this.mDataBinding.llTop3.setVisibility(0);
                this.mDataBinding.top3Diamond.setText(NumberUtilsKt.rankNumberFormat(list.get(2).getScore()));
                LinearLayout linearLayout3 = this.mDataBinding.llDiamond3;
                if (Intrinsics.areEqual(this.mDateType, "day")) {
                    i3 = 0;
                } else {
                    i3 = 8;
                }
                linearLayout3.setVisibility(i3);
                CountryIDView countryIDView5 = this.mDataBinding.top3Id;
                String format3 = String.format(ResourcesKtxKt.getStringById(this, 2131953102), Arrays.copyOf(new Object[]{list.get(2).getGroupBase().getCode()}, 1));
                Intrinsics.checkNotNullExpressionValue(format3, "format(...)");
                countryIDView5.refreshText(format3, 0, androidx.core.content.a.getColor(getContext(), 2131099909), false);
                CountryIDView countryIDView6 = this.mDataBinding.top3Id;
                if (companion.getShared().checkSvipAndWealth()) {
                    i6 = 0;
                }
                countryIDView6.setVisibility(i6);
                this.mDataBinding.top3Name.setText(list.get(2).getGroupBase().getName());
                HiloImageView.loadImage$default(this.mDataBinding.top3Avatar, ImageSizeKt.image100(list.get(2).getGroupBase().getFaceUrl()), 0, 0, 6, (Object) null);
                this.mDataBinding.top3Avatar.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.rank.i
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        CommonRankChildWrapper.saveGroupDataAndFullView$lambda$23(list, view);
                    }
                });
                MedalGridLayout.setDataAndLayoutView$default(this.mDataBinding.top3Medal, list.get(2).getGroupBase().getGroupMedals(), 0, 2, null);
            }
            if (list.size() > 3) {
                List<RankGroupBean> subList = list.subList(3, list.size());
                ArrayList arrayList = new ArrayList();
                int size = subList.size();
                for (int i7 = 0; i7 < size; i7++) {
                    arrayList.add(new CommonRankViewModel(subList.get(i7).getGroupBase().getGroupId(), subList.get(i7).getGroupBase().getFaceUrl(), subList.get(i7).getGroupBase().getName(), 0, subList.get(i7).getGroupBase().getCode(), subList.get(i7).getScore(), false, 0L, null, subList.get(i7).getGroupBase().getCountryIcon(), subList.get(i7).getGroupBase().getGroupMedals(), null, 0L, 0L, 0L, null, null, null, null, null, 1046976, null));
                }
                getMCommonRankAdapter().setList(arrayList);
                return;
            }
            return;
        }
        this.mDataBinding.llTop1.setVisibility(4);
        this.mDataBinding.llTop2.setVisibility(4);
        this.mDataBinding.llTop3.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void saveGroupDataAndFullView$lambda$21(List list, View view) {
        if (!UserStore.INSTANCE.getShared().checkSvipAndWealth()) {
            return;
        }
        StartRoomUtils.startRoom$default(StartRoomUtils.INSTANCE, ((RankGroupBean) list.get(0)).getGroupBase().getGroupId(), null, null, null, null, null, null, null, 0, 0, null, 0, false, 8190, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void saveGroupDataAndFullView$lambda$22(List list, View view) {
        if (!UserStore.INSTANCE.getShared().checkSvipAndWealth()) {
            return;
        }
        StartRoomUtils.startRoom$default(StartRoomUtils.INSTANCE, ((RankGroupBean) list.get(1)).getGroupBase().getGroupId(), null, null, null, null, null, null, null, 0, 0, null, 0, false, 8190, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void saveGroupDataAndFullView$lambda$23(List list, View view) {
        if (!UserStore.INSTANCE.getShared().checkSvipAndWealth()) {
            return;
        }
        StartRoomUtils.startRoom$default(StartRoomUtils.INSTANCE, ((RankGroupBean) list.get(2)).getGroupBase().getGroupId(), null, null, null, null, null, null, null, 0, 0, null, 0, false, 8190, null);
    }

    @NotNull
    public final nd.a getCompose() {
        return this.compose;
    }

    public final void getFirstData() {
        if (this.unRequestData) {
            this.unRequestData = false;
            Log.d(TAG, "getFirstData: 一次获取数据 " + this.mLevelType + " " + this.mDateType);
            getDataFromCache();
            refreshDate();
            return;
        }
        Log.d(TAG, "getFirstData: 非一次获取数据 " + this.mLevelType + " " + this.mDateType);
    }

    @NotNull
    public final CommonRankAdapter getMCommonRankAdapter() {
        return (CommonRankAdapter) this.mCommonRankAdapter.getValue();
    }

    @NotNull
    public final ViewChildCharmRankDetailBinding getMDataBinding() {
        return this.mDataBinding;
    }

    @NotNull
    public final String getMDateType() {
        return this.mDateType;
    }

    public final int getMLevelType() {
        return this.mLevelType;
    }

    public final boolean getUnRequestData() {
        return this.unRequestData;
    }

    @NotNull
    public final AllRankViewController getViewController() {
        return this.viewController;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.compose.d();
    }

    public final void onOpenUserProfile(@NotNull String externalId) {
        AppService service;
        Intrinsics.checkNotNullParameter(externalId, SupportGiftRankActivity.EXTERNAL_ID);
        if (UserStore.INSTANCE.getShared().checkSvipAndWealth() && (service = AppController.INSTANCE.getService()) != null) {
            service.openPersonPage(externalId);
        }
    }

    @Override // vc.g
    public void onRefresh(@NotNull tc.f refreshLayout) {
        Intrinsics.checkNotNullParameter(refreshLayout, "refreshLayout");
        refreshDate();
    }

    public final void refreshDate() {
        int i = this.mLevelType;
        if (i != 0) {
            if (i != 1) {
                if (i == 2) {
                    RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(UserService.INSTANCE.getShared().getRankGroup(this.mDateType), new Function1() { // from class: com.qiahao.nextvideo.ui.rank.n
                        public final Object invoke(Object obj) {
                            Unit refreshDate$lambda$13;
                            refreshDate$lambda$13 = CommonRankChildWrapper.refreshDate$lambda$13(CommonRankChildWrapper.this, (ApiResponse) obj);
                            return refreshDate$lambda$13;
                        }
                    }, new Function1() { // from class: com.qiahao.nextvideo.ui.rank.o
                        public final Object invoke(Object obj) {
                            Unit refreshDate$lambda$14;
                            refreshDate$lambda$14 = CommonRankChildWrapper.refreshDate$lambda$14(CommonRankChildWrapper.this, (Throwable) obj);
                            return refreshDate$lambda$14;
                        }
                    }, (Function0) null, false, 12, (Object) null), this.compose);
                    return;
                }
                return;
            }
            RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(UserService.INSTANCE.getShared().getRankCelebrity(this.mDateType), new Function1() { // from class: com.qiahao.nextvideo.ui.rank.l
                public final Object invoke(Object obj) {
                    Unit refreshDate$lambda$10;
                    refreshDate$lambda$10 = CommonRankChildWrapper.refreshDate$lambda$10(CommonRankChildWrapper.this, (ApiResponse) obj);
                    return refreshDate$lambda$10;
                }
            }, new Function1() { // from class: com.qiahao.nextvideo.ui.rank.m
                public final Object invoke(Object obj) {
                    Unit refreshDate$lambda$11;
                    refreshDate$lambda$11 = CommonRankChildWrapper.refreshDate$lambda$11(CommonRankChildWrapper.this, (Throwable) obj);
                    return refreshDate$lambda$11;
                }
            }, (Function0) null, false, 12, (Object) null), this.compose);
            return;
        }
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(UserService.INSTANCE.getShared().getRankCharm(this.mDateType), new Function1() { // from class: com.qiahao.nextvideo.ui.rank.j
            public final Object invoke(Object obj) {
                Unit refreshDate$lambda$7;
                refreshDate$lambda$7 = CommonRankChildWrapper.refreshDate$lambda$7(CommonRankChildWrapper.this, (ApiResponse) obj);
                return refreshDate$lambda$7;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.rank.k
            public final Object invoke(Object obj) {
                Unit refreshDate$lambda$8;
                refreshDate$lambda$8 = CommonRankChildWrapper.refreshDate$lambda$8(CommonRankChildWrapper.this, (Throwable) obj);
                return refreshDate$lambda$8;
            }
        }, (Function0) null, false, 12, (Object) null), this.compose);
    }

    public final void setMDataBinding(@NotNull ViewChildCharmRankDetailBinding viewChildCharmRankDetailBinding) {
        Intrinsics.checkNotNullParameter(viewChildCharmRankDetailBinding, "<set-?>");
        this.mDataBinding = viewChildCharmRankDetailBinding;
    }

    public final void setUnRequestData(boolean z) {
        this.unRequestData = z;
    }
}
