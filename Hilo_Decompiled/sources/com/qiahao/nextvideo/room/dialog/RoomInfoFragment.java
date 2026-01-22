package com.qiahao.nextvideo.room.dialog;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;
import com.makeramen.roundedimageview.RoundedImageView;
import com.opensource.svgaplayer.SVGADrawable;
import com.opensource.svgaplayer.SVGAParser;
import com.opensource.svgaplayer.SVGAVideoEntity;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.StringKtxKt;
import com.oudi.widget.ViewPage2TabLayout;
import com.qiahao.base_common.common.BaseBindingDialogFragment;
import com.qiahao.base_common.interfaceing.OnCommonDialogListener;
import com.qiahao.base_common.interfaceing.SelectInterface;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.model.eventBus.LiveEvent;
import com.qiahao.base_common.model.svip.SvipData;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.ui.dialog.ReportDialog;
import com.qiahao.base_common.ui.dialog.TipBlackDialog;
import com.qiahao.base_common.ui.loading.HiloLoadingDialog;
import com.qiahao.base_common.utils.Dimens;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.base_common.utils.SvipTypeUtils;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.base_common.wedgit.shineText.NickTextView;
import com.qiahao.base_common.wedgit.shineText.ShineTextView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.model.DialogItemData;
import com.qiahao.nextvideo.data.model.GroupDetailBean;
import com.qiahao.nextvideo.data.model.IsBroadCastMangerBean;
import com.qiahao.nextvideo.data.service.GroupService;
import com.qiahao.nextvideo.data.service.UserService;
import com.qiahao.nextvideo.databinding.DialogRoomInfo2Binding;
import com.qiahao.nextvideo.network.AppServer;
import com.qiahao.nextvideo.network.ServerApi;
import com.qiahao.nextvideo.room.adapter.RoomInfoDialogTabLayoutAdapter;
import com.qiahao.nextvideo.room.fragment.RoomActivityFragment;
import com.qiahao.nextvideo.room.fragment.RoomProfileFragment;
import com.qiahao.nextvideo.room.interfaces.RoomInfoDialogInterface;
import com.qiahao.nextvideo.room.manager.GroupEvent;
import com.qiahao.nextvideo.room.manager.MeetingRoomManager;
import com.qiahao.nextvideo.room.manager.RoomEvent;
import com.qiahao.nextvideo.ui.base.BlockOrReportDialog;
import com.qiahao.nextvideo.ui.reusable.uimodels.ImageUIModel;
import com.qiahao.nextvideo.utilities.DataExternalKt;
import com.qiahao.nextvideo.utilities.FastClickUtils;
import com.qiahao.nextvideo.utilities.ViewUtilitiesKt;
import com.qiahao.nextvideo.utilities.alicloud.oss.ResizeMode;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 F2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001FB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\u0005J\u000f\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\u0005J\u000f\u0010\n\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\n\u0010\u0005J\u000f\u0010\u000b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\u0005J\u000f\u0010\f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\f\u0010\u0005J\u000f\u0010\r\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\r\u0010\u0005J\u000f\u0010\u000f\u001a\u00020\u000eH\u0014¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u000eH\u0014¢\u0006\u0004\b\u0011\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0012\u0010\u0005J\r\u0010\u0013\u001a\u00020\u0006¢\u0006\u0004\b\u0013\u0010\u0005J\u0017\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\r\u0010\u001c\u001a\u00020\u0006¢\u0006\u0004\b\u001c\u0010\u0005J\r\u0010\u001d\u001a\u00020\u0006¢\u0006\u0004\b\u001d\u0010\u0005J\u0015\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u0018¢\u0006\u0004\b\u001f\u0010\u001bJ\u000f\u0010 \u001a\u00020\u0006H\u0016¢\u0006\u0004\b \u0010\u0005J\u000f\u0010!\u001a\u00020\u0006H\u0016¢\u0006\u0004\b!\u0010\u0005J\u000f\u0010\"\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\"\u0010\u0005R$\u0010$\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R&\u0010,\u001a\u0012\u0012\u0004\u0012\u00020#0*j\b\u0012\u0004\u0012\u00020#`+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-R&\u0010/\u001a\u0012\u0012\u0004\u0012\u00020.0*j\b\u0012\u0004\u0012\u00020.`+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u0010-R\u0016\u00101\u001a\u0002008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u0018\u00104\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0018\u00107\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00108R\u0018\u0010:\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R$\u0010=\u001a\u0004\u0018\u00010<8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u0014\u0010D\u001a\u00020C8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bD\u0010E¨\u0006G"}, d2 = {"Lcom/qiahao/nextvideo/room/dialog/RoomInfoFragment;", "Lcom/qiahao/base_common/common/BaseBindingDialogFragment;", "Lcom/qiahao/nextvideo/databinding/DialogRoomInfo2Binding;", "Landroid/view/View$OnClickListener;", "<init>", "()V", "", "initObserve", "checkManage", "resetUserInfo", "resetGroupInfo", "reportGroup", "showLoadingDialog", "dismissLoadingDialog", "", "getLayoutResId", "()I", "getGravity", "onInitialize", "refreshData", "Landroid/view/View;", "v", "onClick", "(Landroid/view/View;)V", "", "isChangeGroupInfo", "requestGroupDetail", "(Z)V", "recommend", "showBlockTipDialog", "isBlack", "blackOrReport", "onDestroy", "dismiss", "onDestroyView", "", "groupId", "Ljava/lang/String;", "getGroupId", "()Ljava/lang/String;", "setGroupId", "(Ljava/lang/String;)V", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "mTypeList", "Ljava/util/ArrayList;", "Landroidx/fragment/app/Fragment;", "mFragments", "Lnd/a;", "mCompositeDisposable", "Lnd/a;", "Lcom/qiahao/nextvideo/room/fragment/RoomProfileFragment;", "mRoomProfileFragment", "Lcom/qiahao/nextvideo/room/fragment/RoomProfileFragment;", "Lcom/qiahao/nextvideo/room/fragment/RoomActivityFragment;", "mRoomActivityFragment", "Lcom/qiahao/nextvideo/room/fragment/RoomActivityFragment;", "Lcom/qiahao/nextvideo/data/model/GroupDetailBean;", "mGroupDetail", "Lcom/qiahao/nextvideo/data/model/GroupDetailBean;", "Lcom/qiahao/base_common/ui/loading/HiloLoadingDialog;", "dialog", "Lcom/qiahao/base_common/ui/loading/HiloLoadingDialog;", "getDialog", "()Lcom/qiahao/base_common/ui/loading/HiloLoadingDialog;", "setDialog", "(Lcom/qiahao/base_common/ui/loading/HiloLoadingDialog;)V", "Lkotlinx/coroutines/CoroutineScope;", "fragmentScope", "Lkotlinx/coroutines/CoroutineScope;", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nRoomInfoFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RoomInfoFragment.kt\ncom/qiahao/nextvideo/room/dialog/RoomInfoFragment\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,527:1\n1#2:528\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class RoomInfoFragment extends BaseBindingDialogFragment<DialogRoomInfo2Binding> implements View.OnClickListener {

    @NotNull
    public static final String GROUP_ID = "groupId";

    @Nullable
    private HiloLoadingDialog dialog;

    @Nullable
    private String groupId;

    @Nullable
    private GroupDetailBean mGroupDetail;

    @Nullable
    private RoomActivityFragment mRoomActivityFragment;

    @Nullable
    private RoomProfileFragment mRoomProfileFragment;

    @NotNull
    private ArrayList<String> mTypeList = new ArrayList<>();

    @NotNull
    private ArrayList<Fragment> mFragments = new ArrayList<>();

    @NotNull
    private nd.a mCompositeDisposable = new nd.a();

    @NotNull
    private final CoroutineScope fragmentScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getMain().getImmediate()));

    public static final /* synthetic */ DialogRoomInfo2Binding access$getBinding(RoomInfoFragment roomInfoFragment) {
        return (DialogRoomInfo2Binding) roomInfoFragment.getBinding();
    }

    private final void checkManage() {
        String str;
        User owner;
        UserService shared = UserService.INSTANCE.getShared();
        GroupDetailBean groupDetailBean = this.mGroupDetail;
        if (groupDetailBean == null || (owner = groupDetailBean.getOwner()) == null || (str = owner.getExternalId()) == null) {
            str = "";
        }
        RxUtilsKt.observeOnMainThread$default(UserService.checkIsBroadcastManager$default(shared, null, str, false, 5, null), new Function1() { // from class: com.qiahao.nextvideo.room.dialog.d3
            public final Object invoke(Object obj) {
                Unit checkManage$lambda$12;
                checkManage$lambda$12 = RoomInfoFragment.checkManage$lambda$12(RoomInfoFragment.this, (ApiResponse) obj);
                return checkManage$lambda$12;
            }
        }, (Function1) null, (Function0) null, false, 14, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit checkManage$lambda$12(final RoomInfoFragment roomInfoFragment, ApiResponse apiResponse) {
        String str;
        int i;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        Context context = roomInfoFragment.getContext();
        if (context != null) {
            BlockOrReportDialog.Companion companion = BlockOrReportDialog.INSTANCE;
            IsBroadCastMangerBean isBroadCastMangerBean = (IsBroadCastMangerBean) apiResponse.getData();
            if (isBroadCastMangerBean != null && isBroadCastMangerBean.isManager()) {
                str = BlockOrReportDialog.REPORT_ROOM_MANAGE;
            } else {
                str = BlockOrReportDialog.REPORT_AND_BLOCK;
            }
            ArrayList textList$default = BlockOrReportDialog.Companion.getTextList$default(companion, str, false, false, false, 14, null);
            User user = UserStore.INSTANCE.getShared().getUser();
            if (user != null && user.isOfficialStaff()) {
                GroupDetailBean groupDetailBean = roomInfoFragment.mGroupDetail;
                if (groupDetailBean != null && groupDetailBean.getNotRecommend() == 0) {
                    i = 2131953554;
                } else {
                    i = 2131953861;
                }
                textList$default.add(new DialogItemData(ResourcesKtxKt.getStringById(textList$default, i), 100));
            }
            BlockOrReportDialog blockOrReportDialog = new BlockOrReportDialog(context, textList$default);
            blockOrReportDialog.setMListener(new SelectInterface() { // from class: com.qiahao.nextvideo.room.dialog.RoomInfoFragment$checkManage$1$1$2$1
                public void onSelect(int index) {
                    if (index == 0) {
                        RoomInfoFragment.this.reportGroup();
                        return;
                    }
                    if (index != 1) {
                        if (index == 2) {
                            RoomInfoFragment.this.resetUserInfo();
                            return;
                        } else if (index == 3) {
                            RoomInfoFragment.this.resetGroupInfo();
                            return;
                        } else {
                            if (index == 100) {
                                RoomInfoFragment.this.recommend();
                                return;
                            }
                            return;
                        }
                    }
                    RoomInfoFragment.this.showBlockTipDialog();
                }
            });
            blockOrReportDialog.show();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dismissLoadingDialog() {
        HiloLoadingDialog hiloLoadingDialog = this.dialog;
        if (hiloLoadingDialog != null) {
            hiloLoadingDialog.dismiss();
        }
    }

    private final void initObserve() {
        BuildersKt.launch$default(this.fragmentScope, Dispatchers.getMain(), (CoroutineStart) null, new RoomInfoFragment$initObserve$1(this, null), 2, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void refreshData$lambda$5(RoomInfoFragment roomInfoFragment) {
        RoomProfileFragment roomProfileFragment = roomInfoFragment.mRoomProfileFragment;
        if (roomProfileFragment != null) {
            roomProfileFragment.setData(roomInfoFragment.mGroupDetail);
        }
        RoomActivityFragment roomActivityFragment = roomInfoFragment.mRoomActivityFragment;
        if (roomActivityFragment != null) {
            roomActivityFragment.setData(roomInfoFragment.mGroupDetail);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reportGroup() {
        Context context = getContext();
        if (context != null) {
            new ReportDialog(context).setListener(new RoomInfoFragment$reportGroup$1$1(this, context)).show();
        }
    }

    public static /* synthetic */ void requestGroupDetail$default(RoomInfoFragment roomInfoFragment, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        roomInfoFragment.requestGroupDetail(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit requestGroupDetail$lambda$7(RoomInfoFragment roomInfoFragment, boolean z, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        GroupDetailBean groupDetailBean = (GroupDetailBean) apiResponse.getData();
        if (groupDetailBean != null) {
            roomInfoFragment.mGroupDetail = groupDetailBean;
            if (z) {
                MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
                meetingRoomManager.setGroupDetailBean(groupDetailBean);
                meetingRoomManager.getWsFlow().tryEmit(new RoomEvent().updateGroupDetail(groupDetailBean));
            }
            roomInfoFragment.refreshData();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit requestGroupDetail$lambda$8(RoomInfoFragment roomInfoFragment, Throwable th) {
        String str;
        Intrinsics.checkNotNullParameter(th, "it");
        HiloToasty.Companion companion = HiloToasty.Companion;
        Context context = roomInfoFragment.getContext();
        String localizedMessage = th.getLocalizedMessage();
        if (localizedMessage == null) {
            str = ResourcesKtxKt.getStringById(roomInfoFragment, 2131952667);
        } else {
            str = localizedMessage;
        }
        Toast normal$default = HiloToasty.Companion.normal$default(companion, context, str, false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void resetGroupInfo() {
        String str;
        User owner;
        UserService shared = UserService.INSTANCE.getShared();
        GroupDetailBean groupDetailBean = this.mGroupDetail;
        if (groupDetailBean == null || (owner = groupDetailBean.getOwner()) == null || (str = owner.getExternalId()) == null) {
            str = "";
        }
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(shared.resetRoomInfo(str), new Function1() { // from class: com.qiahao.nextvideo.room.dialog.w2
            public final Object invoke(Object obj) {
                Unit resetGroupInfo$lambda$16;
                resetGroupInfo$lambda$16 = RoomInfoFragment.resetGroupInfo$lambda$16(RoomInfoFragment.this, (ApiResponse) obj);
                return resetGroupInfo$lambda$16;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.dialog.x2
            public final Object invoke(Object obj) {
                Unit resetGroupInfo$lambda$17;
                resetGroupInfo$lambda$17 = RoomInfoFragment.resetGroupInfo$lambda$17(RoomInfoFragment.this, (Throwable) obj);
                return resetGroupInfo$lambda$17;
            }
        }, (Function0) null, false, 12, (Object) null), this.mCompositeDisposable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit resetGroupInfo$lambda$16(RoomInfoFragment roomInfoFragment, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, roomInfoFragment.getContext(), ResourcesKtxKt.getStringById(roomInfoFragment, 2131954177), false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        roomInfoFragment.requestGroupDetail(true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit resetGroupInfo$lambda$17(RoomInfoFragment roomInfoFragment, Throwable th) {
        String str;
        Intrinsics.checkNotNullParameter(th, "it");
        HiloToasty.Companion companion = HiloToasty.Companion;
        Context context = roomInfoFragment.getContext();
        String localizedMessage = th.getLocalizedMessage();
        if (localizedMessage == null) {
            str = ResourcesKtxKt.getStringById(roomInfoFragment, 2131952667);
        } else {
            str = localizedMessage;
        }
        Toast normal$default = HiloToasty.Companion.normal$default(companion, context, str, false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void resetUserInfo() {
        String str;
        User owner;
        UserService shared = UserService.INSTANCE.getShared();
        GroupDetailBean groupDetailBean = this.mGroupDetail;
        if (groupDetailBean == null || (owner = groupDetailBean.getOwner()) == null || (str = owner.getExternalId()) == null) {
            str = "";
        }
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(shared.resetUserInfo(str), new Function1() { // from class: com.qiahao.nextvideo.room.dialog.b3
            public final Object invoke(Object obj) {
                Unit resetUserInfo$lambda$14;
                resetUserInfo$lambda$14 = RoomInfoFragment.resetUserInfo$lambda$14(RoomInfoFragment.this, (ApiResponse) obj);
                return resetUserInfo$lambda$14;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.dialog.c3
            public final Object invoke(Object obj) {
                Unit resetUserInfo$lambda$15;
                resetUserInfo$lambda$15 = RoomInfoFragment.resetUserInfo$lambda$15(RoomInfoFragment.this, (Throwable) obj);
                return resetUserInfo$lambda$15;
            }
        }, (Function0) null, false, 12, (Object) null), this.mCompositeDisposable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit resetUserInfo$lambda$14(RoomInfoFragment roomInfoFragment, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, roomInfoFragment.getContext(), ResourcesKtxKt.getStringById(roomInfoFragment, 2131954177), false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        roomInfoFragment.requestGroupDetail(true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit resetUserInfo$lambda$15(RoomInfoFragment roomInfoFragment, Throwable th) {
        String str;
        Intrinsics.checkNotNullParameter(th, "it");
        HiloToasty.Companion companion = HiloToasty.Companion;
        Context context = roomInfoFragment.getContext();
        String localizedMessage = th.getLocalizedMessage();
        if (localizedMessage == null) {
            str = ResourcesKtxKt.getStringById(roomInfoFragment, 2131952667);
        } else {
            str = localizedMessage;
        }
        Toast normal$default = HiloToasty.Companion.normal$default(companion, context, str, false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showLoadingDialog() {
        HiloLoadingDialog hiloLoadingDialog;
        if (this.dialog == null) {
            Context context = getContext();
            if (context != null) {
                hiloLoadingDialog = new HiloLoadingDialog(context, false);
            } else {
                hiloLoadingDialog = null;
            }
            this.dialog = hiloLoadingDialog;
        }
        HiloLoadingDialog hiloLoadingDialog2 = this.dialog;
        if (hiloLoadingDialog2 != null) {
            hiloLoadingDialog2.show();
        }
    }

    public final void blackOrReport(boolean isBlack) {
        String str;
        String str2;
        String groupId;
        Context context = getContext();
        if (context != null) {
            String str3 = null;
            if (isBlack) {
                dismiss();
                GroupService.Companion companion = GroupService.INSTANCE;
                je.b mGroupEventProcessorObservable = companion.getMGroupEventProcessorObservable();
                GroupEvent groupEvent = new GroupEvent();
                GroupDetailBean groupDetailBean = this.mGroupDetail;
                String str4 = "";
                if (groupDetailBean == null || (str = groupDetailBean.getGroupId()) == null) {
                    str = "";
                }
                mGroupEventProcessorObservable.onNext(groupEvent.leaveGroup(str));
                cf.c c = cf.c.c();
                GroupDetailBean groupDetailBean2 = this.mGroupDetail;
                if (groupDetailBean2 != null) {
                    str3 = groupDetailBean2.getGroupId();
                }
                c.l(new LiveEvent("EXIT_ROOM", DataExternalKt.createExitRoom(str3, 1)));
                GroupService companion2 = companion.getInstance();
                GroupDetailBean groupDetailBean3 = this.mGroupDetail;
                if (groupDetailBean3 == null || (str2 = groupDetailBean3.getGroupId()) == null) {
                    str2 = "";
                }
                companion2.setBlockRoomIdList(str2);
                je.b mGroupEventProcessorObservable2 = companion.getMGroupEventProcessorObservable();
                GroupEvent groupEvent2 = new GroupEvent();
                GroupDetailBean groupDetailBean4 = this.mGroupDetail;
                if (groupDetailBean4 != null && (groupId = groupDetailBean4.getGroupId()) != null) {
                    str4 = groupId;
                }
                mGroupEventProcessorObservable2.onNext(groupEvent2.blockRoomToLocal(str4));
                return;
            }
            new TipBlackDialog(context, (Integer) null, 2, (DefaultConstructorMarker) null).setTipContent(ResourcesKtxKt.getStringById(this, 2131954490)).hideCancel(true).touchOutsideHide(false).setDialogListener(new OnCommonDialogListener() { // from class: com.qiahao.nextvideo.room.dialog.RoomInfoFragment$blackOrReport$1$1
                public void cancel() {
                    OnCommonDialogListener.DefaultImpls.cancel(this);
                }

                public void confirm() {
                    GroupDetailBean groupDetailBean5;
                    String str5;
                    GroupDetailBean groupDetailBean6;
                    String str6;
                    GroupDetailBean groupDetailBean7;
                    String str7;
                    GroupDetailBean groupDetailBean8;
                    String groupId2;
                    RoomInfoFragment.this.dismiss();
                    GroupService.Companion companion3 = GroupService.INSTANCE;
                    je.b mGroupEventProcessorObservable3 = companion3.getMGroupEventProcessorObservable();
                    GroupEvent groupEvent3 = new GroupEvent();
                    groupDetailBean5 = RoomInfoFragment.this.mGroupDetail;
                    String str8 = "";
                    if (groupDetailBean5 == null || (str5 = groupDetailBean5.getGroupId()) == null) {
                        str5 = "";
                    }
                    mGroupEventProcessorObservable3.onNext(groupEvent3.leaveGroup(str5));
                    cf.c c2 = cf.c.c();
                    groupDetailBean6 = RoomInfoFragment.this.mGroupDetail;
                    if (groupDetailBean6 != null) {
                        str6 = groupDetailBean6.getGroupId();
                    } else {
                        str6 = null;
                    }
                    c2.l(new LiveEvent("EXIT_ROOM", DataExternalKt.createExitRoom(str6, 1)));
                    GroupService companion4 = companion3.getInstance();
                    groupDetailBean7 = RoomInfoFragment.this.mGroupDetail;
                    if (groupDetailBean7 == null || (str7 = groupDetailBean7.getGroupId()) == null) {
                        str7 = "";
                    }
                    companion4.setBlockRoomIdList(str7);
                    je.b mGroupEventProcessorObservable4 = companion3.getMGroupEventProcessorObservable();
                    GroupEvent groupEvent4 = new GroupEvent();
                    groupDetailBean8 = RoomInfoFragment.this.mGroupDetail;
                    if (groupDetailBean8 != null && (groupId2 = groupDetailBean8.getGroupId()) != null) {
                        str8 = groupId2;
                    }
                    mGroupEventProcessorObservable4.onNext(groupEvent4.blockRoomToLocal(str8));
                }
            }).show();
        }
    }

    public void dismiss() {
        CoroutineScopeKt.cancel$default(this.fragmentScope, (CancellationException) null, 1, (Object) null);
        super/*androidx.fragment.app.DialogFragment*/.dismiss();
    }

    @Nullable
    public final HiloLoadingDialog getDialog() {
        return this.dialog;
    }

    protected int getGravity() {
        return 80;
    }

    @Nullable
    public final String getGroupId() {
        return this.groupId;
    }

    protected int getLayoutResId() {
        return R.layout.dialog_room_info2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        int id2 = v.getId();
        if (id2 != 2131362369) {
            if (id2 != 2131364588 || !FastClickUtils.INSTANCE.isFastClick() || this.mGroupDetail == null) {
                return;
            }
            checkManage();
            return;
        }
        dismiss();
    }

    public void onDestroy() {
        super/*com.qiahao.base_common.common.BaseDialogFragment*/.onDestroy();
        this.mRoomProfileFragment = null;
        this.mRoomActivityFragment = null;
        this.mCompositeDisposable.d();
    }

    public void onDestroyView() {
        CoroutineScopeKt.cancel$default(this.fragmentScope, (CancellationException) null, 1, (Object) null);
        super.onDestroyView();
    }

    public void onInitialize() {
        String str;
        super/*com.qiahao.base_common.common.BaseDialogFragment*/.onInitialize();
        Bundle arguments = getArguments();
        if (arguments != null) {
            str = arguments.getString("groupId", "");
        } else {
            str = null;
        }
        this.groupId = str;
        if (this.mFragments.isEmpty()) {
            this.mTypeList.add(ResourcesKtxKt.getStringById(this, 2131953721));
            RoomProfileFragment roomProfileFragment = new RoomProfileFragment();
            this.mRoomProfileFragment = roomProfileFragment;
            roomProfileFragment.setListeners(new RoomInfoDialogInterface() { // from class: com.qiahao.nextvideo.room.dialog.RoomInfoFragment$onInitialize$1
                @Override // com.qiahao.nextvideo.room.interfaces.RoomInfoDialogInterface
                public void hideLoading() {
                    RoomInfoFragment.this.dismissLoadingDialog();
                }

                @Override // com.qiahao.nextvideo.room.interfaces.RoomInfoDialogInterface
                public void onDismiss() {
                    RoomInfoFragment.this.dismiss();
                }

                @Override // com.qiahao.nextvideo.room.interfaces.RoomInfoDialogInterface
                public void onRefreshGroupDetail() {
                    RoomInfoFragment.requestGroupDetail$default(RoomInfoFragment.this, false, 1, null);
                }

                @Override // com.qiahao.nextvideo.room.interfaces.RoomInfoDialogInterface
                public void showLoading() {
                    RoomInfoFragment.this.showLoadingDialog();
                }
            });
            Fragment fragment = this.mRoomProfileFragment;
            if (fragment != null) {
                this.mFragments.add(fragment);
            }
            this.mTypeList.add(ResourcesKtxKt.getStringById(this, 2131951947));
            Fragment roomActivityFragment = new RoomActivityFragment();
            this.mRoomActivityFragment = roomActivityFragment;
            this.mFragments.add(roomActivityFragment);
        }
        ((DialogRoomInfo2Binding) getBinding()).viewPage.setAdapter(new androidx.viewpager2.adapter.a() { // from class: com.qiahao.nextvideo.room.dialog.RoomInfoFragment$onInitialize$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(RoomInfoFragment.this);
            }

            public Fragment createFragment(int position) {
                ArrayList arrayList;
                arrayList = RoomInfoFragment.this.mFragments;
                Object obj = arrayList.get(position);
                Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
                return (Fragment) obj;
            }

            public int getItemCount() {
                ArrayList arrayList;
                arrayList = RoomInfoFragment.this.mFragments;
                return arrayList.size();
            }
        });
        ((DialogRoomInfo2Binding) getBinding()).viewPage.setOffscreenPageLimit(this.mFragments.size());
        ViewPage2TabLayout viewPage2TabLayout = ((DialogRoomInfo2Binding) getBinding()).tabLayout;
        ViewPager2 viewPager2 = ((DialogRoomInfo2Binding) getBinding()).viewPage;
        Intrinsics.checkNotNullExpressionValue(viewPager2, "viewPage");
        viewPage2TabLayout.setViewPager2(viewPager2, new RoomInfoDialogTabLayoutAdapter(this.mTypeList));
        ((DialogRoomInfo2Binding) getBinding()).setClick(this);
        requestGroupDetail$default(this, false, 1, null);
        initObserve();
    }

    public final void recommend() {
        int i;
        Context context = getContext();
        if (context != null) {
            TipBlackDialog tipBlackDialog = new TipBlackDialog(context, (Integer) null, 2, (DefaultConstructorMarker) null);
            GroupDetailBean groupDetailBean = this.mGroupDetail;
            if (groupDetailBean != null && groupDetailBean.getNotRecommend() == 0) {
                i = 2131952339;
            } else {
                i = 2131952342;
            }
            tipBlackDialog.setTipContent(ResourcesKtxKt.getStringById(this, i)).setDialogListener(new RoomInfoFragment$recommend$1$1(this)).show();
        }
    }

    public final void refreshData() {
        String str;
        String str2;
        String groupHeadwear;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        int i;
        String str8;
        int i2;
        int i3;
        Integer num;
        User owner;
        SvipData svip;
        User owner2;
        SvipData svip2;
        User owner3;
        SvipData svip3;
        User owner4;
        String groupHeadwear2;
        String str9;
        AppCompatImageView appCompatImageView = ((DialogRoomInfo2Binding) getBinding()).bgGroupPic;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "bgGroupPic");
        GroupDetailBean groupDetailBean = this.mGroupDetail;
        Drawable drawable = null;
        if (groupDetailBean != null) {
            str = groupDetailBean.getFaceUrl();
        } else {
            str = null;
        }
        ImageKtxKt.loadImage$default(appCompatImageView, str, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
        RoundedImageView roundedImageView = ((DialogRoomInfo2Binding) getBinding()).groupPic;
        Intrinsics.checkNotNullExpressionValue(roundedImageView, "groupPic");
        ImageUIModel.Companion companion = ImageUIModel.INSTANCE;
        GroupDetailBean groupDetailBean2 = this.mGroupDetail;
        if (groupDetailBean2 != null) {
            str2 = groupDetailBean2.getFaceUrl();
        } else {
            str2 = null;
        }
        ResizeMode.FILL fill = ResizeMode.FILL.INSTANCE;
        Dimens dimens = Dimens.INSTANCE;
        fill.setWidth(dimens.dpToPx(97));
        fill.setHeight(dimens.dpToPx(97));
        Unit unit = Unit.INSTANCE;
        ViewUtilitiesKt.bind(roundedImageView, companion.displayImage(str2, fill));
        GroupDetailBean groupDetailBean3 = this.mGroupDetail;
        if (groupDetailBean3 != null && (groupHeadwear2 = groupDetailBean3.getGroupHeadwear()) != null && StringKtxKt.checkEndSVGA(groupHeadwear2)) {
            SVGAParser shareParser = SVGAParser.Companion.shareParser();
            GroupDetailBean groupDetailBean4 = this.mGroupDetail;
            if (groupDetailBean4 != null) {
                str9 = groupDetailBean4.getGroupHeadwear();
            } else {
                str9 = null;
            }
            shareParser.decodeFromURL(new URL(str9), new SVGAParser.ParseCompletion() { // from class: com.qiahao.nextvideo.room.dialog.RoomInfoFragment$refreshData$2
                public void onComplete(SVGAVideoEntity videoItem) {
                    Intrinsics.checkNotNullParameter(videoItem, "videoItem");
                    RoomInfoFragment.access$getBinding(RoomInfoFragment.this).roomSvga.stopAnimation(true);
                    RoomInfoFragment.access$getBinding(RoomInfoFragment.this).roomSvga.setImageDrawable(new SVGADrawable(videoItem));
                    RoomInfoFragment.access$getBinding(RoomInfoFragment.this).roomSvga.startAnimation();
                }

                public void onError() {
                }
            });
        } else {
            GroupDetailBean groupDetailBean5 = this.mGroupDetail;
            if (groupDetailBean5 != null && (groupHeadwear = groupDetailBean5.getGroupHeadwear()) != null && groupHeadwear.length() > 0) {
                ImageView imageView = ((DialogRoomInfo2Binding) getBinding()).roomImageHead;
                Intrinsics.checkNotNullExpressionValue(imageView, "roomImageHead");
                GroupDetailBean groupDetailBean6 = this.mGroupDetail;
                if (groupDetailBean6 == null || (str3 = groupDetailBean6.getGroupHeadwear()) == null) {
                    str3 = "";
                }
                ImageKtxKt.loadImage$default(imageView, str3, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
                ((DialogRoomInfo2Binding) getBinding()).roomImageHead.setVisibility(0);
            }
        }
        ImageView imageView2 = ((DialogRoomInfo2Binding) getBinding()).countPic;
        Intrinsics.checkNotNullExpressionValue(imageView2, "countPic");
        GroupDetailBean groupDetailBean7 = this.mGroupDetail;
        if (groupDetailBean7 != null) {
            str4 = groupDetailBean7.getCountryIcon();
        } else {
            str4 = null;
        }
        ViewUtilitiesKt.bind(imageView2, companion.countryTag(str4));
        ShineTextView shineTextView = ((DialogRoomInfo2Binding) getBinding()).groupId;
        String stringById = ResourcesKtxKt.getStringById(this, 2131953102);
        GroupDetailBean groupDetailBean8 = this.mGroupDetail;
        if (groupDetailBean8 != null) {
            str5 = groupDetailBean8.getCode();
        } else {
            str5 = null;
        }
        String format = String.format(stringById, Arrays.copyOf(new Object[]{str5}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        shineTextView.setText(format);
        AppCompatImageView appCompatImageView2 = ((DialogRoomInfo2Binding) getBinding()).reportImageView;
        GroupDetailBean groupDetailBean9 = this.mGroupDetail;
        if (groupDetailBean9 != null && (owner4 = groupDetailBean9.getOwner()) != null) {
            str6 = owner4.getExternalId();
        } else {
            str6 = null;
        }
        User user = UserStore.INSTANCE.getShared().getUser();
        if (user != null) {
            str7 = user.getExternalId();
        } else {
            str7 = null;
        }
        if (Intrinsics.areEqual(str6, str7)) {
            i = 8;
        } else {
            i = 0;
        }
        appCompatImageView2.setVisibility(i);
        NickTextView nickTextView = ((DialogRoomInfo2Binding) getBinding()).groupName;
        GroupDetailBean groupDetailBean10 = this.mGroupDetail;
        if (groupDetailBean10 != null) {
            str8 = groupDetailBean10.getName();
        } else {
            str8 = null;
        }
        GroupDetailBean groupDetailBean11 = this.mGroupDetail;
        if (groupDetailBean11 != null && (owner3 = groupDetailBean11.getOwner()) != null && (svip3 = owner3.getSvip()) != null) {
            i2 = svip3.getSvipLevel();
        } else {
            i2 = 0;
        }
        nickTextView.setTextAndVipLevel(str8, i2);
        GroupDetailBean groupDetailBean12 = this.mGroupDetail;
        if (groupDetailBean12 != null && (owner2 = groupDetailBean12.getOwner()) != null && (svip2 = owner2.getSvip()) != null) {
            i3 = svip2.getSvipLevel();
        } else {
            i3 = 0;
        }
        if (i3 > 0) {
            SvipTypeUtils svipTypeUtils = SvipTypeUtils.INSTANCE;
            GroupDetailBean groupDetailBean13 = this.mGroupDetail;
            if (groupDetailBean13 != null && (owner = groupDetailBean13.getOwner()) != null && (svip = owner.getSvip()) != null) {
                num = Integer.valueOf(svip.getSvipLevel());
            } else {
                num = null;
            }
            Integer svipType = svipTypeUtils.getSvipType(num);
            if (svipType != null) {
                int intValue = svipType.intValue();
                ImageView imageView3 = ((DialogRoomInfo2Binding) getBinding()).svip;
                Context context = getContext();
                if (context != null) {
                    drawable = androidx.core.content.a.getDrawable(context, intValue);
                }
                imageView3.setImageDrawable(drawable);
                ((DialogRoomInfo2Binding) getBinding()).svip.setVisibility(0);
            }
        } else {
            ((DialogRoomInfo2Binding) getBinding()).svip.setVisibility(8);
        }
        ((DialogRoomInfo2Binding) getBinding()).viewPage.postDelayed(new Runnable() { // from class: com.qiahao.nextvideo.room.dialog.a3
            @Override // java.lang.Runnable
            public final void run() {
                RoomInfoFragment.refreshData$lambda$5(RoomInfoFragment.this);
            }
        }, 500L);
    }

    public final void requestGroupDetail(final boolean isChangeGroupInfo) {
        ServerApi apis = AppServer.INSTANCE.getApis();
        String str = this.groupId;
        if (str == null) {
            str = "";
        }
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(apis.getGroupDetail(str), new Function1() { // from class: com.qiahao.nextvideo.room.dialog.y2
            public final Object invoke(Object obj) {
                Unit requestGroupDetail$lambda$7;
                requestGroupDetail$lambda$7 = RoomInfoFragment.requestGroupDetail$lambda$7(RoomInfoFragment.this, isChangeGroupInfo, (ApiResponse) obj);
                return requestGroupDetail$lambda$7;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.dialog.z2
            public final Object invoke(Object obj) {
                Unit requestGroupDetail$lambda$8;
                requestGroupDetail$lambda$8 = RoomInfoFragment.requestGroupDetail$lambda$8(RoomInfoFragment.this, (Throwable) obj);
                return requestGroupDetail$lambda$8;
            }
        }, (Function0) null, false, 12, (Object) null), this.mCompositeDisposable);
    }

    public final void setDialog(@Nullable HiloLoadingDialog hiloLoadingDialog) {
        this.dialog = hiloLoadingDialog;
    }

    public final void setGroupId(@Nullable String str) {
        this.groupId = str;
    }

    public final void showBlockTipDialog() {
        Context context = getContext();
        if (context != null) {
            new TipBlackDialog(context, (Integer) null, 2, (DefaultConstructorMarker) null).setTipContent(ResourcesKtxKt.getStringById(this, 2131952131)).setConfirmContent(ResourcesKtxKt.getStringById(this, 2131952331)).setDialogListener(new RoomInfoFragment$showBlockTipDialog$1$1(this, context)).show();
        }
    }
}
