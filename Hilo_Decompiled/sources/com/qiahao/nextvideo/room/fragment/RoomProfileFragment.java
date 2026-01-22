package com.qiahao.nextvideo.room.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import android.widget.Checkable;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.oudi.core.callback.SuperCallBack;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.common.BaseBindingFragment;
import com.qiahao.base_common.databinding.IncludeFamilyNamePlateBinding;
import com.qiahao.base_common.interfaceing.OnCommonDialogListener;
import com.qiahao.base_common.model.common.FamilyInfo;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.navigation.NavigationHelper;
import com.qiahao.base_common.network.interceptors.HiloException;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.AppUtilitiesKt;
import com.qiahao.base_common.utils.Dimens;
import com.qiahao.base_common.utils.HiloResUtilsKt;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.base_common.utils.image.ImageSizeKt;
import com.qiahao.base_common.wedgit.polygon.PolygonImageView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.CommonTextDialog;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.model.GroupDetailBean;
import com.qiahao.nextvideo.data.model.GroupMedalBean;
import com.qiahao.nextvideo.data.model.RoleMember;
import com.qiahao.nextvideo.data.model.TopConsumersBean;
import com.qiahao.nextvideo.data.service.GroupService;
import com.qiahao.nextvideo.databinding.FragmentRoomProfileBinding;
import com.qiahao.nextvideo.network.AppServer;
import com.qiahao.nextvideo.network.ServerApi;
import com.qiahao.nextvideo.room.activity.GroupSettingActivity;
import com.qiahao.nextvideo.room.activity.RoomMemberOnlineActivity;
import com.qiahao.nextvideo.room.adapter.GroupMedalAdapter;
import com.qiahao.nextvideo.room.adapter.GroupMemberAdapter;
import com.qiahao.nextvideo.room.dialog.PicOrSvgaShowDialog;
import com.qiahao.nextvideo.room.dialog.RoomPowerJoinDialog;
import com.qiahao.nextvideo.room.interfaces.RoomInfoDialogInterface;
import com.qiahao.nextvideo.room.rank.GroupAllRankActivity;
import com.qiahao.nextvideo.ui.family.FamilyCenterActivity;
import com.qiahao.nextvideo.ui.home.discover.CreateActivitiesActivity;
import com.qiahao.nextvideo.ui.reusable.CircleImageView;
import com.qiahao.nextvideo.ui.reusable.uimodels.ImageUIModel;
import com.qiahao.nextvideo.ui.vip.VipViewDialog;
import com.qiahao.nextvideo.ui.wallet.WalletActivity;
import com.qiahao.nextvideo.utilities.AppRequestUtils;
import com.qiahao.nextvideo.utilities.FastClickUtils;
import com.qiahao.nextvideo.utilities.ViewUtilitiesKt;
import com.qiahao.nextvideo.utilities.alicloud.oss.ResizeMode;
import com.qiahao.nextvideo.utilities.userproxy.NumberUtilsKt;
import com.tencent.qcloud.tuicore.component.CustomLinearLayoutManager;
import java.io.File;
import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0003¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\b\u001a\u00020\u0006H\u0003¢\u0006\u0004\b\b\u0010\u0005J\u000f\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\u0005J\u000f\u0010\n\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\n\u0010\u0005J\u000f\u0010\u000b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\u0005J\u000f\u0010\f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\f\u0010\u0005J\u000f\u0010\r\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\r\u0010\u0005J'\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0014\u0010\u0005J\u000f\u0010\u0016\u001a\u00020\u0015H\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0018\u0010\u0005J\u0015\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001d\u0010\u0005J\u0017\u0010 \u001a\u00020\u00062\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e¢\u0006\u0004\b \u0010!J\u0017\u0010$\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\"H\u0016¢\u0006\u0004\b$\u0010%R$\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010!R$\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010\u001cR\u0016\u0010/\u001a\u00020.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u001b\u00106\u001a\u0002018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R\u001b\u0010;\u001a\u0002078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b8\u00103\u001a\u0004\b9\u0010:¨\u0006<"}, d2 = {"Lcom/qiahao/nextvideo/room/fragment/RoomProfileFragment;", "Lcom/qiahao/base_common/common/BaseBindingFragment;", "Lcom/qiahao/nextvideo/databinding/FragmentRoomProfileBinding;", "Landroid/view/View$OnClickListener;", "<init>", "()V", "", "refreshData", "requestGroupMedal", "joinGroup", "initFamily", "confirmLeave", "initMedalRecyclerView", "showDiamondRank", "", "settingVisible", "llLeaveVisible", "joinVisible", "changeSettingViewShow", "(ZZZ)V", "initGroupMemberRecyclerView", "", "getLayoutResId", "()I", "onInitialize", "Lcom/qiahao/nextvideo/room/interfaces/RoomInfoDialogInterface;", "listener", "setListeners", "(Lcom/qiahao/nextvideo/room/interfaces/RoomInfoDialogInterface;)V", "onDestroy", "Lcom/qiahao/nextvideo/data/model/GroupDetailBean;", "mGroupDetail", "setData", "(Lcom/qiahao/nextvideo/data/model/GroupDetailBean;)V", "Landroid/view/View;", "v", "onClick", "(Landroid/view/View;)V", "Lcom/qiahao/nextvideo/data/model/GroupDetailBean;", "getMGroupDetail", "()Lcom/qiahao/nextvideo/data/model/GroupDetailBean;", "setMGroupDetail", "Lcom/qiahao/nextvideo/room/interfaces/RoomInfoDialogInterface;", "getListener", "()Lcom/qiahao/nextvideo/room/interfaces/RoomInfoDialogInterface;", "setListener", "Lnd/a;", "mCompositeDisposable", "Lnd/a;", "Lcom/qiahao/nextvideo/room/adapter/GroupMemberAdapter;", "groupMemberAdapter$delegate", "Lkotlin/Lazy;", "getGroupMemberAdapter", "()Lcom/qiahao/nextvideo/room/adapter/GroupMemberAdapter;", "groupMemberAdapter", "Lcom/qiahao/nextvideo/room/adapter/GroupMedalAdapter;", "groupMedalAdapter$delegate", "getGroupMedalAdapter", "()Lcom/qiahao/nextvideo/room/adapter/GroupMedalAdapter;", "groupMedalAdapter", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nRoomProfileFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RoomProfileFragment.kt\ncom/qiahao/nextvideo/room/fragment/RoomProfileFragment\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n*L\n1#1,550:1\n1#2:551\n61#3,9:552\n*S KotlinDebug\n*F\n+ 1 RoomProfileFragment.kt\ncom/qiahao/nextvideo/room/fragment/RoomProfileFragment\n*L\n289#1:552,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class RoomProfileFragment extends BaseBindingFragment<FragmentRoomProfileBinding> implements View.OnClickListener {

    @Nullable
    private RoomInfoDialogInterface listener;

    @Nullable
    private GroupDetailBean mGroupDetail;

    @NotNull
    private nd.a mCompositeDisposable = new nd.a();

    /* renamed from: groupMemberAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy groupMemberAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.room.fragment.a1
        public final Object invoke() {
            GroupMemberAdapter groupMemberAdapter_delegate$lambda$2;
            groupMemberAdapter_delegate$lambda$2 = RoomProfileFragment.groupMemberAdapter_delegate$lambda$2();
            return groupMemberAdapter_delegate$lambda$2;
        }
    });

    /* renamed from: groupMedalAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy groupMedalAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.room.fragment.b1
        public final Object invoke() {
            GroupMedalAdapter groupMedalAdapter_delegate$lambda$6;
            groupMedalAdapter_delegate$lambda$6 = RoomProfileFragment.groupMedalAdapter_delegate$lambda$6(RoomProfileFragment.this);
            return groupMedalAdapter_delegate$lambda$6;
        }
    });

    private final void changeSettingViewShow(boolean settingVisible, boolean llLeaveVisible, boolean joinVisible) {
        TextView textView;
        TextView textView2;
        int i;
        TextView textView3;
        int i2;
        FragmentRoomProfileBinding fragmentRoomProfileBinding = (FragmentRoomProfileBinding) getBinding();
        int i3 = 8;
        if (fragmentRoomProfileBinding != null && (textView3 = fragmentRoomProfileBinding.setting) != null) {
            if (settingVisible) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            textView3.setVisibility(i2);
        }
        FragmentRoomProfileBinding fragmentRoomProfileBinding2 = (FragmentRoomProfileBinding) getBinding();
        if (fragmentRoomProfileBinding2 != null && (textView2 = fragmentRoomProfileBinding2.llLeave) != null) {
            if (llLeaveVisible) {
                i = 0;
            } else {
                i = 8;
            }
            textView2.setVisibility(i);
        }
        FragmentRoomProfileBinding fragmentRoomProfileBinding3 = (FragmentRoomProfileBinding) getBinding();
        if (fragmentRoomProfileBinding3 != null && (textView = fragmentRoomProfileBinding3.joinButton) != null) {
            if (joinVisible) {
                i3 = 0;
            }
            textView.setVisibility(i3);
        }
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Object, android.app.Dialog, com.qiahao.nextvideo.app.base.CommonTextDialog] */
    private final void confirmLeave() {
        Context context = getContext();
        if (context != null) {
            ?? commonTextDialog = new CommonTextDialog(context, 0.5f);
            commonTextDialog.setContentText(ResourcesKtxKt.getStringById((Object) commonTextDialog, 2131952955), true, new RoomProfileFragment$confirmLeave$1$1$1(this, commonTextDialog));
            commonTextDialog.show();
        }
    }

    private final GroupMedalAdapter getGroupMedalAdapter() {
        return (GroupMedalAdapter) this.groupMedalAdapter.getValue();
    }

    private final GroupMemberAdapter getGroupMemberAdapter() {
        return (GroupMemberAdapter) this.groupMemberAdapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GroupMedalAdapter groupMedalAdapter_delegate$lambda$6(final RoomProfileFragment roomProfileFragment) {
        GroupMedalAdapter groupMedalAdapter = new GroupMedalAdapter(R.layout.item_medal);
        groupMedalAdapter.setOnItemClickListener(new OnItemClickListener() { // from class: com.qiahao.nextvideo.room.fragment.u0
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                RoomProfileFragment.groupMedalAdapter_delegate$lambda$6$lambda$5$lambda$4(RoomProfileFragment.this, baseQuickAdapter, view, i);
            }
        });
        return groupMedalAdapter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void groupMedalAdapter_delegate$lambda$6$lambda$5$lambda$4(RoomProfileFragment roomProfileFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        Object item = baseQuickAdapter.getItem(i);
        Intrinsics.checkNotNull(item, "null cannot be cast to non-null type com.qiahao.nextvideo.data.model.GroupMedalBean");
        GroupMedalBean groupMedalBean = (GroupMedalBean) item;
        Context context = roomProfileFragment.getContext();
        if (context != null) {
            new PicOrSvgaShowDialog(groupMedalBean.getPicUrl(), groupMedalBean.getSvgaUrl(), context).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GroupMemberAdapter groupMemberAdapter_delegate$lambda$2() {
        GroupMemberAdapter groupMemberAdapter = new GroupMemberAdapter(R.layout.item_group_member_avatar);
        groupMemberAdapter.setOnItemClickListener(new OnItemClickListener() { // from class: com.qiahao.nextvideo.room.fragment.v0
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                RoomProfileFragment.groupMemberAdapter_delegate$lambda$2$lambda$1$lambda$0(baseQuickAdapter, view, i);
            }
        });
        return groupMemberAdapter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void groupMemberAdapter_delegate$lambda$2$lambda$1$lambda$0(BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        Object item = baseQuickAdapter.getItem(i);
        Intrinsics.checkNotNull(item, "null cannot be cast to non-null type com.qiahao.nextvideo.data.model.RoleMember");
        AppRequestUtils.openPersonPage$default(AppRequestUtils.INSTANCE, ((RoleMember) item).getExternalId(), false, 2, null);
    }

    private final void initFamily() {
        FamilyInfo familyInfo;
        ConstraintLayout constraintLayout;
        Long l;
        GroupDetailBean groupDetailBean;
        final ConstraintLayout constraintLayout2;
        User owner;
        FamilyInfo groupPower;
        IncludeFamilyNamePlateBinding includeFamilyNamePlateBinding;
        int i;
        ImageView imageView;
        ImageView imageView2;
        Context context;
        TextView textView;
        int i2;
        TextView textView2;
        PolygonImageView polygonImageView;
        ConstraintLayout constraintLayout3;
        User owner2;
        FamilyInfo groupPower2;
        Long id2;
        User owner3;
        FamilyInfo groupPower3;
        User owner4;
        GroupDetailBean groupDetailBean2 = this.mGroupDetail;
        Drawable drawable = null;
        if (groupDetailBean2 != null && (owner4 = groupDetailBean2.getOwner()) != null) {
            familyInfo = owner4.getGroupPower();
        } else {
            familyInfo = null;
        }
        if (familyInfo != null) {
            GroupDetailBean groupDetailBean3 = this.mGroupDetail;
            if (groupDetailBean3 != null && (owner3 = groupDetailBean3.getOwner()) != null && (groupPower3 = owner3.getGroupPower()) != null) {
                l = groupPower3.getId();
            } else {
                l = null;
            }
            if (l != null && ((groupDetailBean = this.mGroupDetail) == null || (owner2 = groupDetailBean.getOwner()) == null || (groupPower2 = owner2.getGroupPower()) == null || (id2 = groupPower2.getId()) == null || id2.longValue() != 0)) {
                FragmentRoomProfileBinding fragmentRoomProfileBinding = (FragmentRoomProfileBinding) getBinding();
                int i3 = 0;
                if (fragmentRoomProfileBinding != null && (constraintLayout3 = fragmentRoomProfileBinding.myFamilyLayout) != null) {
                    constraintLayout3.setVisibility(0);
                }
                GroupDetailBean groupDetailBean4 = this.mGroupDetail;
                if (groupDetailBean4 != null && (owner = groupDetailBean4.getOwner()) != null && (groupPower = owner.getGroupPower()) != null) {
                    FragmentRoomProfileBinding fragmentRoomProfileBinding2 = (FragmentRoomProfileBinding) getBinding();
                    if (fragmentRoomProfileBinding2 != null && (polygonImageView = fragmentRoomProfileBinding2.familyAvatar) != null) {
                        ImageKtxKt.loadImage$default(polygonImageView, ImageSizeKt.image100(groupPower.getIcon()), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131232548, (c5.g) null, 49150, (Object) null);
                    }
                    FragmentRoomProfileBinding fragmentRoomProfileBinding3 = (FragmentRoomProfileBinding) getBinding();
                    if (fragmentRoomProfileBinding3 != null && (textView2 = fragmentRoomProfileBinding3.familyName) != null) {
                        textView2.setText(groupPower.getName());
                    }
                    FragmentRoomProfileBinding fragmentRoomProfileBinding4 = (FragmentRoomProfileBinding) getBinding();
                    if (fragmentRoomProfileBinding4 != null && (textView = fragmentRoomProfileBinding4.familyNumber) != null) {
                        Integer memberNum = groupPower.getMemberNum();
                        if (memberNum != null) {
                            i2 = memberNum.intValue();
                        } else {
                            i2 = 0;
                        }
                        Integer memberMax = groupPower.getMemberMax();
                        if (memberMax != null) {
                            i3 = memberMax.intValue();
                        }
                        textView.setText(i2 + "/" + i3);
                    }
                    FragmentRoomProfileBinding fragmentRoomProfileBinding5 = (FragmentRoomProfileBinding) getBinding();
                    if (fragmentRoomProfileBinding5 != null && (imageView = fragmentRoomProfileBinding5.heardBg) != null) {
                        Integer grade = groupPower.getGrade();
                        if (grade != null) {
                            int familyHeader = HiloResUtilsKt.familyHeader(grade.intValue());
                            FragmentRoomProfileBinding fragmentRoomProfileBinding6 = (FragmentRoomProfileBinding) getBinding();
                            if (fragmentRoomProfileBinding6 != null && (imageView2 = fragmentRoomProfileBinding6.heardBg) != null && (context = imageView2.getContext()) != null) {
                                drawable = androidx.core.content.a.getDrawable(context, familyHeader);
                            }
                        }
                        imageView.setImageDrawable(drawable);
                    }
                    FragmentRoomProfileBinding fragmentRoomProfileBinding7 = (FragmentRoomProfileBinding) getBinding();
                    if (fragmentRoomProfileBinding7 != null && (includeFamilyNamePlateBinding = fragmentRoomProfileBinding7.familyNamePlate) != null) {
                        Integer grade2 = groupPower.getGrade();
                        if (grade2 != null) {
                            i = grade2.intValue();
                        } else {
                            i = -1;
                        }
                        String nameplate = groupPower.getNameplate();
                        if (nameplate == null) {
                            nameplate = "";
                        }
                        AppUtilitiesKt.familyNamePlate$default(includeFamilyNamePlateBinding, i, nameplate, 0, 4, (Object) null);
                    }
                }
                FragmentRoomProfileBinding fragmentRoomProfileBinding8 = (FragmentRoomProfileBinding) getBinding();
                if (fragmentRoomProfileBinding8 != null && (constraintLayout2 = fragmentRoomProfileBinding8.myFamilyLayout) != null) {
                    final long j = 800;
                    constraintLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.fragment.RoomProfileFragment$initFamily$$inlined$singleClick$default$1
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            long j2;
                            User owner5;
                            FamilyInfo groupPower4;
                            Long id3;
                            long currentTimeMillis = System.currentTimeMillis();
                            if (currentTimeMillis - ViewKtxKt.getLastClickTime(constraintLayout2) > j || (constraintLayout2 instanceof Checkable)) {
                                ViewKtxKt.setLastClickTime(constraintLayout2, currentTimeMillis);
                                ConstraintLayout constraintLayout4 = constraintLayout2;
                                Context context2 = this.getContext();
                                if (context2 != null) {
                                    FamilyCenterActivity.Companion companion = FamilyCenterActivity.INSTANCE;
                                    GroupDetailBean mGroupDetail = this.getMGroupDetail();
                                    if (mGroupDetail != null && (owner5 = mGroupDetail.getOwner()) != null && (groupPower4 = owner5.getGroupPower()) != null && (id3 = groupPower4.getId()) != null) {
                                        j2 = id3.longValue();
                                    } else {
                                        j2 = 0;
                                    }
                                    companion.startActivity(context2, j2);
                                }
                            }
                        }
                    });
                    return;
                }
                return;
            }
        }
        FragmentRoomProfileBinding fragmentRoomProfileBinding9 = (FragmentRoomProfileBinding) getBinding();
        if (fragmentRoomProfileBinding9 != null && (constraintLayout = fragmentRoomProfileBinding9.myFamilyLayout) != null) {
            constraintLayout.setVisibility(8);
        }
    }

    private final void initGroupMemberRecyclerView() {
        RecyclerView recyclerView;
        FragmentRoomProfileBinding fragmentRoomProfileBinding = (FragmentRoomProfileBinding) getBinding();
        if (fragmentRoomProfileBinding != null && (recyclerView = fragmentRoomProfileBinding.groupMemberRecycler) != null) {
            recyclerView.setLayoutManager(new CustomLinearLayoutManager(getContext(), 0, false));
            recyclerView.setAdapter(getGroupMemberAdapter());
        }
    }

    private final void initMedalRecyclerView() {
        RecyclerView recyclerView;
        FragmentRoomProfileBinding fragmentRoomProfileBinding = (FragmentRoomProfileBinding) getBinding();
        if (fragmentRoomProfileBinding != null && (recyclerView = fragmentRoomProfileBinding.medalRecyclerView) != null) {
            recyclerView.setLayoutManager(new GridLayoutManager(recyclerView.getContext(), 4, 1, false));
            recyclerView.setHasFixedSize(true);
            recyclerView.setNestedScrollingEnabled(false);
            recyclerView.setAdapter(getGroupMedalAdapter());
        }
    }

    private final void joinGroup() {
        String str;
        RoomInfoDialogInterface roomInfoDialogInterface = this.listener;
        if (roomInfoDialogInterface != null) {
            roomInfoDialogInterface.showLoading();
        }
        GroupService companion = GroupService.INSTANCE.getInstance();
        GroupDetailBean groupDetailBean = this.mGroupDetail;
        if (groupDetailBean == null || (str = groupDetailBean.getGroupId()) == null) {
            str = "";
        }
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(companion.joinGroup(str), new Function1() { // from class: com.qiahao.nextvideo.room.fragment.w0
            public final Object invoke(Object obj) {
                Unit joinGroup$lambda$9;
                joinGroup$lambda$9 = RoomProfileFragment.joinGroup$lambda$9(RoomProfileFragment.this, (ApiResponse) obj);
                return joinGroup$lambda$9;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.fragment.x0
            public final Object invoke(Object obj) {
                Unit joinGroup$lambda$13;
                joinGroup$lambda$13 = RoomProfileFragment.joinGroup$lambda$13(RoomProfileFragment.this, (Throwable) obj);
                return joinGroup$lambda$13;
            }
        }, (Function0) null, false, 12, (Object) null), this.mCompositeDisposable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r4v6, types: [android.app.Dialog, com.qiahao.nextvideo.app.base.CommonTextDialog] */
    public static final Unit joinGroup$lambda$13(RoomProfileFragment roomProfileFragment, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        RoomInfoDialogInterface roomInfoDialogInterface = roomProfileFragment.listener;
        if (roomInfoDialogInterface != null) {
            roomInfoDialogInterface.hideLoading();
        }
        if (th instanceof HiloException) {
            int code = ((HiloException) th).getCode();
            if (code != 14003) {
                if (code != 14005) {
                    if (code != 14012) {
                        if (code != 14015) {
                            HiloToasty.Companion companion = HiloToasty.Companion;
                            Context context = roomProfileFragment.getContext();
                            String message = th.getMessage();
                            if (message == null) {
                                message = ResourcesKtxKt.getStringById(roomProfileFragment, 2131952667);
                            }
                            Toast normal = companion.normal(context, message, false);
                            if (normal != null) {
                                normal.show();
                            }
                        } else {
                            Context context2 = roomProfileFragment.getContext();
                            if (context2 != null) {
                                new VipViewDialog(4, context2).show();
                            }
                        }
                    } else {
                        Context context3 = roomProfileFragment.getContext();
                        if (context3 != null) {
                            ?? commonTextDialog = new CommonTextDialog(context3, 0.0f, 2, null);
                            String string = commonTextDialog.getMContext().getString(2131953025);
                            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                            commonTextDialog.setContentText(string, true, new OnCommonDialogListener() { // from class: com.qiahao.nextvideo.room.fragment.RoomProfileFragment$joinGroup$2$1$1$1
                                public void cancel() {
                                }

                                public void confirm() {
                                }
                            });
                            commonTextDialog.show();
                        }
                    }
                } else {
                    Toast normal2 = HiloToasty.Companion.normal(roomProfileFragment.getContext(), ResourcesKtxKt.getStringById(roomProfileFragment, 2131952092), false);
                    if (normal2 != null) {
                        normal2.show();
                    }
                }
            } else {
                HiloToasty.Companion companion2 = HiloToasty.Companion;
                Context context4 = roomProfileFragment.getContext();
                String message2 = th.getMessage();
                if (message2 == null) {
                    message2 = ResourcesKtxKt.getStringById(roomProfileFragment, 2131953606);
                }
                Toast normal3 = companion2.normal(context4, message2, false);
                if (normal3 != null) {
                    normal3.show();
                }
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit joinGroup$lambda$9(RoomProfileFragment roomProfileFragment, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        Integer num = (Integer) apiResponse.getData();
        if (num != null && num.intValue() == 1) {
            RoomInfoDialogInterface roomInfoDialogInterface = roomProfileFragment.listener;
            if (roomInfoDialogInterface != null) {
                roomInfoDialogInterface.onRefreshGroupDetail();
            }
            Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, roomProfileFragment.getContext(), ResourcesKtxKt.getStringById(roomProfileFragment, 2131954177), false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
            }
        } else {
            Toast normal$default2 = HiloToasty.Companion.normal$default(HiloToasty.Companion, roomProfileFragment.getContext(), ResourcesKtxKt.getStringById(roomProfileFragment, 2131952667), false, 4, (Object) null);
            if (normal$default2 != null) {
                normal$default2.show();
            }
        }
        RoomInfoDialogInterface roomInfoDialogInterface2 = roomProfileFragment.listener;
        if (roomInfoDialogInterface2 != null) {
            roomInfoDialogInterface2.hideLoading();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onClick$lambda$28$lambda$27$lambda$26(RoomProfileFragment roomProfileFragment, Context context, int i) {
        int i2;
        User user = UserStore.INSTANCE.getShared().getUser();
        if (user != null) {
            i2 = (int) user.getDiamondNum();
        } else {
            i2 = 0;
        }
        if (i2 >= i) {
            roomProfileFragment.joinGroup();
        } else {
            WalletActivity.INSTANCE.start(context);
        }
        return Unit.INSTANCE;
    }

    @SuppressLint({"StringFormatInvalid", "SetTextI18n"})
    private final void refreshData() {
        ConstraintLayout constraintLayout;
        ConstraintLayout constraintLayout2;
        Integer num;
        TextView textView;
        String str;
        TextView textView2;
        String str2;
        TextView textView3;
        Integer num2;
        Integer role;
        ConstraintLayout constraintLayout3;
        ConstraintLayout constraintLayout4;
        GroupDetailBean groupDetailBean = this.mGroupDetail;
        if (groupDetailBean != null && (role = groupDetailBean.getRole()) != null && role.intValue() == 100) {
            FragmentRoomProfileBinding fragmentRoomProfileBinding = (FragmentRoomProfileBinding) getBinding();
            if (fragmentRoomProfileBinding != null && (constraintLayout4 = fragmentRoomProfileBinding.lcGroupSupport) != null) {
                constraintLayout4.setVisibility(0);
            }
            FragmentRoomProfileBinding fragmentRoomProfileBinding2 = (FragmentRoomProfileBinding) getBinding();
            if (fragmentRoomProfileBinding2 != null && (constraintLayout3 = fragmentRoomProfileBinding2.groupActivity) != null) {
                constraintLayout3.setVisibility(0);
            }
        } else {
            FragmentRoomProfileBinding fragmentRoomProfileBinding3 = (FragmentRoomProfileBinding) getBinding();
            if (fragmentRoomProfileBinding3 != null && (constraintLayout2 = fragmentRoomProfileBinding3.lcGroupSupport) != null) {
                constraintLayout2.setVisibility(8);
            }
            FragmentRoomProfileBinding fragmentRoomProfileBinding4 = (FragmentRoomProfileBinding) getBinding();
            if (fragmentRoomProfileBinding4 != null && (constraintLayout = fragmentRoomProfileBinding4.groupActivity) != null) {
                constraintLayout.setVisibility(8);
            }
        }
        FragmentRoomProfileBinding fragmentRoomProfileBinding5 = (FragmentRoomProfileBinding) getBinding();
        List<RoleMember> list = null;
        if (fragmentRoomProfileBinding5 != null && (textView3 = fragmentRoomProfileBinding5.groupMember) != null) {
            String stringById = ResourcesKtxKt.getStringById(this, 2131952992);
            GroupDetailBean groupDetailBean2 = this.mGroupDetail;
            if (groupDetailBean2 != null) {
                num2 = groupDetailBean2.getMemberNum();
            } else {
                num2 = null;
            }
            textView3.setText(stringById + "(" + num2 + ")");
        }
        FragmentRoomProfileBinding fragmentRoomProfileBinding6 = (FragmentRoomProfileBinding) getBinding();
        if (fragmentRoomProfileBinding6 != null && (textView2 = fragmentRoomProfileBinding6.introductionContent) != null) {
            GroupDetailBean groupDetailBean3 = this.mGroupDetail;
            if (groupDetailBean3 != null) {
                str2 = groupDetailBean3.getIntroduction();
            } else {
                str2 = null;
            }
            textView2.setText(str2);
        }
        FragmentRoomProfileBinding fragmentRoomProfileBinding7 = (FragmentRoomProfileBinding) getBinding();
        if (fragmentRoomProfileBinding7 != null && (textView = fragmentRoomProfileBinding7.announcementContent) != null) {
            GroupDetailBean groupDetailBean4 = this.mGroupDetail;
            if (groupDetailBean4 != null) {
                str = groupDetailBean4.getNotification();
            } else {
                str = null;
            }
            textView.setText(str);
        }
        GroupDetailBean groupDetailBean5 = this.mGroupDetail;
        if (groupDetailBean5 != null) {
            num = groupDetailBean5.getRole();
        } else {
            num = null;
        }
        if (num != null && num.intValue() == 100) {
            changeSettingViewShow(true, false, false);
        } else if (num != null && num.intValue() == 50) {
            changeSettingViewShow(true, true, false);
        } else if (num != null && num.intValue() == 10) {
            changeSettingViewShow(false, true, false);
        } else if (num != null && num.intValue() == 1) {
            changeSettingViewShow(false, true, false);
        } else if (num != null && num.intValue() == 0) {
            changeSettingViewShow(false, false, true);
        } else if (num != null && num.intValue() == 1000) {
            changeSettingViewShow(true, false, false);
        }
        GroupMemberAdapter groupMemberAdapter = getGroupMemberAdapter();
        GroupDetailBean groupDetailBean6 = this.mGroupDetail;
        if (groupDetailBean6 != null) {
            list = groupDetailBean6.getRole_members();
        }
        groupMemberAdapter.setList(list);
        showDiamondRank();
        initFamily();
    }

    @SuppressLint({"SetTextI18n"})
    private final void requestGroupMedal() {
        String str;
        ServerApi apis = AppServer.INSTANCE.getApis();
        GroupDetailBean groupDetailBean = this.mGroupDetail;
        if (groupDetailBean == null || (str = groupDetailBean.getGroupId()) == null) {
            str = "";
        }
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(apis.getGroupMedalAll(str), new Function1() { // from class: com.qiahao.nextvideo.room.fragment.y0
            public final Object invoke(Object obj) {
                Unit requestGroupMedal$lambda$7;
                requestGroupMedal$lambda$7 = RoomProfileFragment.requestGroupMedal$lambda$7(RoomProfileFragment.this, (ApiResponse) obj);
                return requestGroupMedal$lambda$7;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.fragment.z0
            public final Object invoke(Object obj) {
                Unit requestGroupMedal$lambda$8;
                requestGroupMedal$lambda$8 = RoomProfileFragment.requestGroupMedal$lambda$8(RoomProfileFragment.this, (Throwable) obj);
                return requestGroupMedal$lambda$8;
            }
        }, (Function0) null, false, 12, (Object) null), this.mCompositeDisposable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit requestGroupMedal$lambda$7(RoomProfileFragment roomProfileFragment, ApiResponse apiResponse) {
        LinearLayout linearLayout;
        AppCompatTextView appCompatTextView;
        Integer num;
        LinearLayout linearLayout2;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        List list = (List) apiResponse.getData();
        if (list != null && list.isEmpty()) {
            FragmentRoomProfileBinding fragmentRoomProfileBinding = (FragmentRoomProfileBinding) roomProfileFragment.getBinding();
            if (fragmentRoomProfileBinding != null && (linearLayout2 = fragmentRoomProfileBinding.llMedal) != null) {
                linearLayout2.setVisibility(8);
            }
        } else {
            FragmentRoomProfileBinding fragmentRoomProfileBinding2 = (FragmentRoomProfileBinding) roomProfileFragment.getBinding();
            if (fragmentRoomProfileBinding2 != null && (appCompatTextView = fragmentRoomProfileBinding2.medal) != null) {
                String stringById = ResourcesKtxKt.getStringById(roomProfileFragment, 2131953353);
                List list2 = (List) apiResponse.getData();
                if (list2 != null) {
                    num = Integer.valueOf(list2.size());
                } else {
                    num = null;
                }
                appCompatTextView.setText(stringById + "(" + num + ")");
            }
            FragmentRoomProfileBinding fragmentRoomProfileBinding3 = (FragmentRoomProfileBinding) roomProfileFragment.getBinding();
            if (fragmentRoomProfileBinding3 != null && (linearLayout = fragmentRoomProfileBinding3.llMedal) != null) {
                linearLayout.setVisibility(0);
            }
            roomProfileFragment.getGroupMedalAdapter().setList((Collection) apiResponse.getData());
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit requestGroupMedal$lambda$8(RoomProfileFragment roomProfileFragment, Throwable th) {
        String str;
        Intrinsics.checkNotNullParameter(th, "it");
        HiloToasty.Companion companion = HiloToasty.Companion;
        Context context = roomProfileFragment.getContext();
        String localizedMessage = th.getLocalizedMessage();
        if (localizedMessage == null) {
            str = ResourcesKtxKt.getStringById(roomProfileFragment, 2131952667);
        } else {
            str = localizedMessage;
        }
        Toast normal$default = HiloToasty.Companion.normal$default(companion, context, str, false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        return Unit.INSTANCE;
    }

    private final void showDiamondRank() {
        List<TopConsumersBean> topConsumers;
        int i;
        CircleImageView circleImageView;
        List<TopConsumersBean> topConsumers2;
        TopConsumersBean topConsumersBean;
        RoleMember userBase;
        String avatar;
        FrameLayout frameLayout;
        CircleImageView circleImageView2;
        String str;
        List<TopConsumersBean> topConsumers3;
        TopConsumersBean topConsumersBean2;
        RoleMember userBase2;
        FrameLayout frameLayout2;
        CircleImageView circleImageView3;
        String str2;
        List<TopConsumersBean> topConsumers4;
        TopConsumersBean topConsumersBean3;
        RoleMember userBase3;
        FrameLayout frameLayout3;
        List<TopConsumersBean> topConsumers5;
        TextView textView;
        long j;
        Long totalConsume;
        FragmentRoomProfileBinding fragmentRoomProfileBinding = (FragmentRoomProfileBinding) getBinding();
        if (fragmentRoomProfileBinding != null && (textView = fragmentRoomProfileBinding.allDiamond) != null) {
            GroupDetailBean groupDetailBean = this.mGroupDetail;
            if (groupDetailBean != null && (totalConsume = groupDetailBean.getTotalConsume()) != null) {
                j = totalConsume.longValue();
            } else {
                j = 0;
            }
            textView.setText(NumberUtilsKt.rankNumberFormat(j));
        }
        GroupDetailBean groupDetailBean2 = this.mGroupDetail;
        if (groupDetailBean2 != null && (topConsumers = groupDetailBean2.getTopConsumers()) != null && !topConsumers.isEmpty()) {
            GroupDetailBean groupDetailBean3 = this.mGroupDetail;
            if (groupDetailBean3 != null && (topConsumers5 = groupDetailBean3.getTopConsumers()) != null) {
                i = topConsumers5.size();
            } else {
                i = 0;
            }
            String str3 = "";
            if (i > 0) {
                FragmentRoomProfileBinding fragmentRoomProfileBinding2 = (FragmentRoomProfileBinding) getBinding();
                if (fragmentRoomProfileBinding2 != null && (frameLayout3 = fragmentRoomProfileBinding2.flTop1) != null) {
                    frameLayout3.setVisibility(0);
                }
                FragmentRoomProfileBinding fragmentRoomProfileBinding3 = (FragmentRoomProfileBinding) getBinding();
                if (fragmentRoomProfileBinding3 != null && (circleImageView3 = fragmentRoomProfileBinding3.top1Avatar) != null) {
                    ImageUIModel.Companion companion = ImageUIModel.INSTANCE;
                    GroupDetailBean groupDetailBean4 = this.mGroupDetail;
                    if (groupDetailBean4 == null || (topConsumers4 = groupDetailBean4.getTopConsumers()) == null || (topConsumersBean3 = topConsumers4.get(0)) == null || (userBase3 = topConsumersBean3.getUserBase()) == null || (str2 = userBase3.getAvatar()) == null) {
                        str2 = "";
                    }
                    ResizeMode.FILL fill = ResizeMode.FILL.INSTANCE;
                    Dimens dimens = Dimens.INSTANCE;
                    fill.setWidth(dimens.getMediumAvatarSize());
                    fill.setHeight(dimens.getMediumAvatarSize());
                    Unit unit = Unit.INSTANCE;
                    ViewUtilitiesKt.bind$default(circleImageView3, companion.displayUserAvatarImage(str2, fill), null, 2, null);
                }
            }
            if (i > 1) {
                FragmentRoomProfileBinding fragmentRoomProfileBinding4 = (FragmentRoomProfileBinding) getBinding();
                if (fragmentRoomProfileBinding4 != null && (frameLayout2 = fragmentRoomProfileBinding4.flTop2) != null) {
                    frameLayout2.setVisibility(0);
                }
                FragmentRoomProfileBinding fragmentRoomProfileBinding5 = (FragmentRoomProfileBinding) getBinding();
                if (fragmentRoomProfileBinding5 != null && (circleImageView2 = fragmentRoomProfileBinding5.top2Avatar) != null) {
                    ImageUIModel.Companion companion2 = ImageUIModel.INSTANCE;
                    GroupDetailBean groupDetailBean5 = this.mGroupDetail;
                    if (groupDetailBean5 == null || (topConsumers3 = groupDetailBean5.getTopConsumers()) == null || (topConsumersBean2 = topConsumers3.get(1)) == null || (userBase2 = topConsumersBean2.getUserBase()) == null || (str = userBase2.getAvatar()) == null) {
                        str = "";
                    }
                    ResizeMode.FILL fill2 = ResizeMode.FILL.INSTANCE;
                    Dimens dimens2 = Dimens.INSTANCE;
                    fill2.setWidth(dimens2.getMediumAvatarSize());
                    fill2.setHeight(dimens2.getMediumAvatarSize());
                    Unit unit2 = Unit.INSTANCE;
                    ViewUtilitiesKt.bind$default(circleImageView2, companion2.displayUserAvatarImage(str, fill2), null, 2, null);
                }
            }
            if (i > 2) {
                FragmentRoomProfileBinding fragmentRoomProfileBinding6 = (FragmentRoomProfileBinding) getBinding();
                if (fragmentRoomProfileBinding6 != null && (frameLayout = fragmentRoomProfileBinding6.flTop3) != null) {
                    frameLayout.setVisibility(0);
                }
                FragmentRoomProfileBinding fragmentRoomProfileBinding7 = (FragmentRoomProfileBinding) getBinding();
                if (fragmentRoomProfileBinding7 != null && (circleImageView = fragmentRoomProfileBinding7.top3Avatar) != null) {
                    ImageUIModel.Companion companion3 = ImageUIModel.INSTANCE;
                    GroupDetailBean groupDetailBean6 = this.mGroupDetail;
                    if (groupDetailBean6 != null && (topConsumers2 = groupDetailBean6.getTopConsumers()) != null && (topConsumersBean = topConsumers2.get(2)) != null && (userBase = topConsumersBean.getUserBase()) != null && (avatar = userBase.getAvatar()) != null) {
                        str3 = avatar;
                    }
                    ResizeMode.FILL fill3 = ResizeMode.FILL.INSTANCE;
                    Dimens dimens3 = Dimens.INSTANCE;
                    fill3.setWidth(dimens3.getMediumAvatarSize());
                    fill3.setHeight(dimens3.getMediumAvatarSize());
                    Unit unit3 = Unit.INSTANCE;
                    ViewUtilitiesKt.bind$default(circleImageView, companion3.displayUserAvatarImage(str3, fill3), null, 2, null);
                }
            }
        }
    }

    protected int getLayoutResId() {
        return R.layout.fragment_room_profile;
    }

    @Nullable
    public final RoomInfoDialogInterface getListener() {
        return this.listener;
    }

    @Nullable
    public final GroupDetailBean getMGroupDetail() {
        return this.mGroupDetail;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v) {
        String groupId;
        String groupId2;
        final Context context;
        Integer memberFee;
        String groupId3;
        String groupId4;
        Context context2;
        String groupId5;
        Intrinsics.checkNotNullParameter(v, "v");
        int i = 0;
        String str = "";
        switch (v.getId()) {
            case R.id.groupActivity /* 2131363074 */:
                Context context3 = getContext();
                if (context3 != null) {
                    Intent intent = new Intent(context3, (Class<?>) CreateActivitiesActivity.class);
                    GroupDetailBean groupDetailBean = this.mGroupDetail;
                    if (groupDetailBean != null && (groupId = groupDetailBean.getGroupId()) != null) {
                        str = groupId;
                    }
                    intent.putExtra("groupId", str);
                    context3.startActivity(intent);
                    return;
                }
                return;
            case R.id.groupMemberLayout /* 2131363076 */:
            case R.id.group_member /* 2131363094 */:
                Context context4 = getContext();
                if (context4 != null) {
                    RoomMemberOnlineActivity.Companion companion = RoomMemberOnlineActivity.INSTANCE;
                    GroupDetailBean groupDetailBean2 = this.mGroupDetail;
                    if (groupDetailBean2 != null && (groupId2 = groupDetailBean2.getGroupId()) != null) {
                        str = groupId2;
                    }
                    companion.start(context4, str, false);
                    return;
                }
                return;
            case R.id.join_button /* 2131363388 */:
                if (this.mGroupDetail != null && (context = getContext()) != null) {
                    GroupDetailBean groupDetailBean3 = this.mGroupDetail;
                    if (groupDetailBean3 != null && (memberFee = groupDetailBean3.getMemberFee()) != null) {
                        i = memberFee.intValue();
                    }
                    RoomPowerJoinDialog roomPowerJoinDialog = new RoomPowerJoinDialog(context, i);
                    roomPowerJoinDialog.setListener(new Function1() { // from class: com.qiahao.nextvideo.room.fragment.t0
                        public final Object invoke(Object obj) {
                            Unit onClick$lambda$28$lambda$27$lambda$26;
                            onClick$lambda$28$lambda$27$lambda$26 = RoomProfileFragment.onClick$lambda$28$lambda$27$lambda$26(RoomProfileFragment.this, context, ((Integer) obj).intValue());
                            return onClick$lambda$28$lambda$27$lambda$26;
                        }
                    });
                    roomPowerJoinDialog.show();
                    return;
                }
                return;
            case R.id.lc_group_support /* 2131363425 */:
                if (getContext() != null) {
                    NavigationHelper navigationHelper = NavigationHelper.INSTANCE;
                    String groupSupportH5 = GroupService.INSTANCE.getInstance().getGroupSupportH5();
                    GroupDetailBean groupDetailBean4 = this.mGroupDetail;
                    if (groupDetailBean4 != null && (groupId3 = groupDetailBean4.getGroupId()) != null) {
                        str = groupId3;
                    }
                    NavigationHelper.jump$default(navigationHelper, navigationHelper.addGroupStatus(groupSupportH5, str), (SuperCallBack) null, 2, (Object) null);
                    return;
                }
                return;
            case R.id.ll_group_contribution /* 2131363554 */:
                Context context5 = getContext();
                if (context5 != null) {
                    GroupAllRankActivity.Companion companion2 = GroupAllRankActivity.INSTANCE;
                    GroupDetailBean groupDetailBean5 = this.mGroupDetail;
                    if (groupDetailBean5 != null && (groupId4 = groupDetailBean5.getGroupId()) != null) {
                        str = groupId4;
                    }
                    companion2.start(context5, str);
                    return;
                }
                return;
            case R.id.ll_leave /* 2131363561 */:
                if (!FastClickUtils.INSTANCE.isFastClick() || this.mGroupDetail == null) {
                    return;
                }
                confirmLeave();
                return;
            case R.id.setting /* 2131364803 */:
                if (FastClickUtils.INSTANCE.isFastClick() && this.mGroupDetail != null && (context2 = getContext()) != null) {
                    GroupSettingActivity.Companion companion3 = GroupSettingActivity.INSTANCE;
                    GroupDetailBean groupDetailBean6 = this.mGroupDetail;
                    if (groupDetailBean6 != null && (groupId5 = groupDetailBean6.getGroupId()) != null) {
                        str = groupId5;
                    }
                    companion3.start(context2, str);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void onDestroy() {
        super/*com.qiahao.base_common.common.BaseFragment*/.onDestroy();
        this.listener = null;
    }

    public void onInitialize() {
        super/*com.qiahao.base_common.common.BaseFragment*/.onInitialize();
        initGroupMemberRecyclerView();
        initMedalRecyclerView();
        FragmentRoomProfileBinding fragmentRoomProfileBinding = (FragmentRoomProfileBinding) getBinding();
        if (fragmentRoomProfileBinding != null) {
            fragmentRoomProfileBinding.setClick(this);
        }
    }

    public final void setData(@Nullable GroupDetailBean mGroupDetail) {
        if (getBinding() == null) {
            return;
        }
        try {
            FragmentRoomProfileBinding fragmentRoomProfileBinding = (FragmentRoomProfileBinding) getBinding();
            if (fragmentRoomProfileBinding != null) {
                fragmentRoomProfileBinding.getRoot();
            }
            this.mGroupDetail = mGroupDetail;
            requestGroupMedal();
            refreshData();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }

    public final void setListener(@Nullable RoomInfoDialogInterface roomInfoDialogInterface) {
        this.listener = roomInfoDialogInterface;
    }

    public final void setListeners(@NotNull RoomInfoDialogInterface listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listener = listener;
    }

    public final void setMGroupDetail(@Nullable GroupDetailBean groupDetailBean) {
        this.mGroupDetail = groupDetailBean;
    }
}
