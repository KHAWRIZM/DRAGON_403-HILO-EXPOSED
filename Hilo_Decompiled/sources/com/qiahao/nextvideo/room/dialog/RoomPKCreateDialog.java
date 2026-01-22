package com.qiahao.nextvideo.room.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.oudi.core.status.IStatusView;
import com.oudi.core.status.Status;
import com.oudi.core.status.StatusKtxKtKt;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.common.BaseBindingDialogFragment;
import com.qiahao.base_common.interfaceing.OnCommonDialogListener;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.network.interceptors.HiloException;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.base_common.utils.ShapeUtil;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.CommonTextDialog;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.model.GroupDetailBean;
import com.qiahao.nextvideo.data.room.RoomCurrentPK;
import com.qiahao.nextvideo.data.room.RoomPK;
import com.qiahao.nextvideo.databinding.DialogRoomPkCreateBinding;
import com.qiahao.nextvideo.room.StartRoomUtils;
import com.qiahao.nextvideo.room.adapter.RoomPKDialogAdapter;
import com.qiahao.nextvideo.room.manager.MeetingRoomManager;
import com.qiahao.nextvideo.room.viewmodel.RoomPKViewModel;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import java.io.File;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0014J\b\u0010\u001a\u001a\u00020\u0019H\u0014J\b\u0010\u001b\u001a\u00020\u0017H\u0016J\b\u0010\u001c\u001a\u00020\u0017H\u0002J\b\u0010\u001d\u001a\u00020\u0017H\u0002J\u0014\u0010\u001e\u001a\u00020\u00172\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010 \u001a\u00020\u0017H\u0016R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001b\u0010\u000b\u001a\u00020\f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0011\u001a\u00020\u00128FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0013\u0010\u0014¨\u0006!"}, d2 = {"Lcom/qiahao/nextvideo/room/dialog/RoomPKCreateDialog;", "Lcom/qiahao/base_common/common/BaseBindingDialogFragment;", "Lcom/qiahao/nextvideo/databinding/DialogRoomPkCreateBinding;", "<init>", "()V", "mData", "Lcom/qiahao/nextvideo/data/room/RoomPK;", "getMData", "()Lcom/qiahao/nextvideo/data/room/RoomPK;", "setMData", "(Lcom/qiahao/nextvideo/data/room/RoomPK;)V", "mAdapter", "Lcom/qiahao/nextvideo/room/adapter/RoomPKDialogAdapter;", "getMAdapter", "()Lcom/qiahao/nextvideo/room/adapter/RoomPKDialogAdapter;", "mAdapter$delegate", "Lkotlin/Lazy;", "viewMode", "Lcom/qiahao/nextvideo/room/viewmodel/RoomPKViewModel;", "getViewMode", "()Lcom/qiahao/nextvideo/room/viewmodel/RoomPKViewModel;", "viewMode$delegate", "onStart", "", "getLayoutResId", "", "getGravity", "onInitialize", "initData", "initView", "refreshMatchPK", "data", "onDestroy", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nRoomPKCreateDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RoomPKCreateDialog.kt\ncom/qiahao/nextvideo/room/dialog/RoomPKCreateDialog\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n*L\n1#1,286:1\n1#2:287\n61#3,9:288\n61#3,9:297\n61#3,9:306\n*S KotlinDebug\n*F\n+ 1 RoomPKCreateDialog.kt\ncom/qiahao/nextvideo/room/dialog/RoomPKCreateDialog\n*L\n185#1:288,9\n209#1:297,9\n231#1:306,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class RoomPKCreateDialog extends BaseBindingDialogFragment<DialogRoomPkCreateBinding> {

    @Nullable
    private RoomPK mData;

    /* renamed from: mAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.room.dialog.o3
        public final Object invoke() {
            RoomPKDialogAdapter mAdapter_delegate$lambda$0;
            mAdapter_delegate$lambda$0 = RoomPKCreateDialog.mAdapter_delegate$lambda$0();
            return mAdapter_delegate$lambda$0;
        }
    });

    /* renamed from: viewMode$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewMode = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.room.dialog.p3
        public final Object invoke() {
            RoomPKViewModel viewMode_delegate$lambda$1;
            viewMode_delegate$lambda$1 = RoomPKCreateDialog.viewMode_delegate$lambda$1(RoomPKCreateDialog.this);
            return viewMode_delegate$lambda$1;
        }
    });

    private final void initData() {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getMain(), (CoroutineStart) null, new RoomPKCreateDialog$initData$1(this, null), 2, (Object) null);
        getViewMode().getPkList().observe(this, new RoomPKCreateDialog$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.room.dialog.l3
            public final Object invoke(Object obj) {
                Unit initData$lambda$4;
                initData$lambda$4 = RoomPKCreateDialog.initData$lambda$4(RoomPKCreateDialog.this, (List) obj);
                return initData$lambda$4;
            }
        }));
        getViewMode().getMSuccess().observe(this, new RoomPKCreateDialog$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.room.dialog.m3
            public final Object invoke(Object obj) {
                Unit initData$lambda$5;
                initData$lambda$5 = RoomPKCreateDialog.initData$lambda$5(RoomPKCreateDialog.this, (Pair) obj);
                return initData$lambda$5;
            }
        }));
        getViewMode().getMException().observe(this, new RoomPKCreateDialog$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.room.dialog.n3
            public final Object invoke(Object obj) {
                Unit initData$lambda$6;
                initData$lambda$6 = RoomPKCreateDialog.initData$lambda$6(RoomPKCreateDialog.this, (Pair) obj);
                return initData$lambda$6;
            }
        }));
        getViewMode().roomCurrentPK();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$4(RoomPKCreateDialog roomPKCreateDialog, List list) {
        if (roomPKCreateDialog.getViewMode().getPkListData().isOnePage()) {
            roomPKCreateDialog.getMAdapter().setList(list);
        } else if (list != null) {
            roomPKCreateDialog.getMAdapter().addData(list);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$5(RoomPKCreateDialog roomPKCreateDialog, Pair pair) {
        String str = (String) pair.getFirst();
        int hashCode = str.hashCode();
        if (hashCode != -1562644133) {
            if (hashCode != -591173696) {
                if (hashCode == 222913762 && str.equals(RoomPKViewModel.PK_EXIT)) {
                    Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, roomPKCreateDialog.getContext(), ResourcesKtxKt.getStringById(roomPKCreateDialog, 2131954177), false, 4, (Object) null);
                    if (normal$default != null) {
                        normal$default.show();
                    }
                    roomPKCreateDialog.mData = null;
                    roomPKCreateDialog.refreshMatchPK(null);
                }
            } else if (str.equals(RoomPKViewModel.PK_CREATE)) {
                Toast normal$default2 = HiloToasty.Companion.normal$default(HiloToasty.Companion, roomPKCreateDialog.getContext(), ResourcesKtxKt.getStringById(roomPKCreateDialog, 2131954177), false, 4, (Object) null);
                if (normal$default2 != null) {
                    normal$default2.show();
                }
                RoomPK roomPK = new RoomPK(null, MeetingRoomManager.INSTANCE.getMGroupDetailBean(), null, 0, null, 21, null);
                roomPKCreateDialog.mData = roomPK;
                roomPKCreateDialog.refreshMatchPK(roomPK);
            }
        } else if (str.equals(RoomPKViewModel.PK_AUTO_MIC)) {
            roomPKCreateDialog.getViewMode().startMatch(MeetingRoomManager.INSTANCE.getMGroupId());
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$6(RoomPKCreateDialog roomPKCreateDialog, Pair pair) {
        String str;
        if (pair.getSecond() instanceof HiloException) {
            HiloToasty.Companion companion = HiloToasty.Companion;
            Context context = roomPKCreateDialog.getContext();
            String message = ((Throwable) pair.getSecond()).getMessage();
            if (message == null) {
                str = ResourcesKtxKt.getStringById(roomPKCreateDialog, 2131952667);
            } else {
                str = message;
            }
            Toast normal$default = HiloToasty.Companion.normal$default(companion, context, str, false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
            }
        }
        return Unit.INSTANCE;
    }

    private final void initView() {
        int i;
        Drawable drawable;
        MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
        RoomPK mpk = meetingRoomManager.getMPK();
        if (mpk != null && mpk.checkIsInvite()) {
            i = 0;
        } else {
            i = -1;
        }
        this.mData = new RoomPK(null, meetingRoomManager.getMGroupDetailBean(), null, i, null, 21, null);
        SmartRefreshLayout smartRefreshLayout = ((DialogRoomPkCreateBinding) getBinding()).refreshLayout;
        Intrinsics.checkNotNullExpressionValue(smartRefreshLayout, "refreshLayout");
        Status.Empty empty = Status.Empty.INSTANCE;
        TextView textView = (TextView) StatusKtxKtKt.getStatusChildView(smartRefreshLayout, empty, 2131362075);
        SmartRefreshLayout smartRefreshLayout2 = ((DialogRoomPkCreateBinding) getBinding()).refreshLayout;
        Intrinsics.checkNotNullExpressionValue(smartRefreshLayout2, "refreshLayout");
        ImageView imageView = (ImageView) StatusKtxKtKt.getStatusChildView(smartRefreshLayout2, empty, 2131363373);
        SmartRefreshLayout smartRefreshLayout3 = ((DialogRoomPkCreateBinding) getBinding()).refreshLayout;
        Intrinsics.checkNotNullExpressionValue(smartRefreshLayout3, "refreshLayout");
        TextView textView2 = (TextView) StatusKtxKtKt.getStatusChildView(smartRefreshLayout3, Status.Error.INSTANCE, 2131362075);
        SmartRefreshLayout smartRefreshLayout4 = ((DialogRoomPkCreateBinding) getBinding()).refreshLayout;
        Intrinsics.checkNotNullExpressionValue(smartRefreshLayout4, "refreshLayout");
        ImageView imageView2 = (ImageView) StatusKtxKtKt.getStatusChildView(smartRefreshLayout4, empty, 2131363373);
        Context context = getContext();
        if (context != null) {
            if (textView != null) {
                textView.setVisibility(8);
            }
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
            if (imageView != null) {
                imageView.setImageDrawable(androidx.core.content.a.getDrawable(context, R.drawable.pk_emtry_icon));
            }
            if (imageView2 != null) {
                imageView2.setImageDrawable(androidx.core.content.a.getDrawable(context, R.drawable.pk_emtry_icon));
            }
        }
        Context context2 = getContext();
        if (context2 != null && textView2 != null) {
            textView2.setTextColor(androidx.core.content.a.getColor(context2, 2131101214));
        }
        final ImageView imageView3 = ((DialogRoomPkCreateBinding) getBinding()).helper;
        final long j = 800;
        imageView3.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.dialog.RoomPKCreateDialog$initView$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(imageView3) > j || (imageView3 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(imageView3, currentTimeMillis);
                    Context context3 = this.getContext();
                    if (context3 != null) {
                        new PKRuleDialog(context3).show();
                    }
                }
            }
        });
        ImageView imageView4 = ((DialogRoomPkCreateBinding) getBinding()).centerBg;
        Intrinsics.checkNotNullExpressionValue(imageView4, "centerBg");
        ImageKtxKt.toHorizontalMirror(imageView4, R.drawable.pk_item_top_bg);
        ConstraintLayout constraintLayout = ((DialogRoomPkCreateBinding) getBinding()).constraint;
        Context context3 = getContext();
        if (context3 != null) {
            if (HiloUtils.INSTANCE.getRightToLeftDirection()) {
                drawable = ShapeUtil.createShape$default(ShapeUtil.INSTANCE, context3, 2131099855, 2131099865, 14, 14, 0, 0, (GradientDrawable.Orientation) null, 128, (Object) null);
            } else {
                drawable = ShapeUtil.createShape$default(ShapeUtil.INSTANCE, context3, 2131099865, 2131099855, 14, 14, 0, 0, (GradientDrawable.Orientation) null, 128, (Object) null);
            }
        } else {
            drawable = null;
        }
        constraintLayout.setBackground(drawable);
        refreshMatchPK(this.mData);
        final TextView textView3 = ((DialogRoomPkCreateBinding) getBinding()).startMatch;
        textView3.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.dialog.RoomPKCreateDialog$initView$$inlined$singleClick$default$2
            /* JADX WARN: Type inference failed for: r0v7, types: [java.lang.Object, android.app.Dialog, com.qiahao.nextvideo.app.base.CommonTextDialog] */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                String str;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView3) > j || (textView3 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(textView3, currentTimeMillis);
                    MeetingRoomManager meetingRoomManager2 = MeetingRoomManager.INSTANCE;
                    User user = UserStore.INSTANCE.getShared().getUser();
                    if (user != null) {
                        str = user.getExternalId();
                    } else {
                        str = null;
                    }
                    if (meetingRoomManager2.checkUserOnMic(str)) {
                        this.getViewMode().startMatch(meetingRoomManager2.getMGroupId());
                        return;
                    }
                    Context context4 = this.getContext();
                    if (context4 != null) {
                        ?? commonTextDialog = new CommonTextDialog(context4, 0.0f, 2, null);
                        String stringById = ResourcesKtxKt.getStringById((Object) commonTextDialog, 2131953654);
                        final RoomPKCreateDialog roomPKCreateDialog = this;
                        commonTextDialog.setContentText(stringById, true, new OnCommonDialogListener() { // from class: com.qiahao.nextvideo.room.dialog.RoomPKCreateDialog$initView$5$1$1$1
                            public void cancel() {
                            }

                            public void confirm() {
                                RoomPKViewModel.upMic$default(RoomPKCreateDialog.this.getViewMode(), null, false, 2, null);
                            }
                        });
                        commonTextDialog.show();
                    }
                }
            }
        });
        final TextView textView4 = ((DialogRoomPkCreateBinding) getBinding()).cancel;
        textView4.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.dialog.RoomPKCreateDialog$initView$$inlined$singleClick$default$3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView4) > j || (textView4 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(textView4, currentTimeMillis);
                    this.getViewMode().exitPK(MeetingRoomManager.INSTANCE.getMGroupId());
                }
            }
        });
        getViewMode().getPkListData().registerStatusLayoutAndRefreshLayout(((DialogRoomPkCreateBinding) getBinding()).refreshLayout, ((DialogRoomPkCreateBinding) getBinding()).statusView);
        ((DialogRoomPkCreateBinding) getBinding()).recyclerView.setAdapter(getMAdapter());
        ((DialogRoomPkCreateBinding) getBinding()).refreshLayout.setOnRefreshListener(new vc.g() { // from class: com.qiahao.nextvideo.room.dialog.q3
            @Override // vc.g
            public final void onRefresh(tc.f fVar) {
                RoomPKCreateDialog.initView$lambda$16(RoomPKCreateDialog.this, fVar);
            }
        });
        ((DialogRoomPkCreateBinding) getBinding()).statusView.setOnRetryClickListener(new IStatusView.OnRetryClickListener() { // from class: com.qiahao.nextvideo.room.dialog.RoomPKCreateDialog$initView$8
            public void onRetry(IStatusView statusView, Status status) {
                Intrinsics.checkNotNullParameter(statusView, "statusView");
                Intrinsics.checkNotNullParameter(status, "status");
                RoomPKCreateDialog.this.getViewMode().getPkListData().resetPage();
                RoomPKCreateDialog.this.getViewMode().roomCurrentPK();
            }
        });
        getMAdapter().addChildClickViewIds(new int[]{R.id.redClick, R.id.blueClick});
        getMAdapter().setOnItemChildClickListener(new OnItemChildClickListener() { // from class: com.qiahao.nextvideo.room.dialog.r3
            public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
                RoomPKCreateDialog.initView$lambda$17(RoomPKCreateDialog.this, baseQuickAdapter, view, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$16(RoomPKCreateDialog roomPKCreateDialog, tc.f fVar) {
        Intrinsics.checkNotNullParameter(fVar, "it");
        roomPKCreateDialog.getViewMode().getPkListData().resetPage();
        roomPKCreateDialog.getViewMode().roomCurrentPK();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$17(RoomPKCreateDialog roomPKCreateDialog, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        String str;
        String groupId;
        String str2;
        String groupId2;
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "view");
        RoomCurrentPK roomCurrentPK = (RoomCurrentPK) roomPKCreateDialog.getMAdapter().getData().get(i);
        int id2 = view.getId();
        if (id2 != 2131362133) {
            if (id2 == 2131364525) {
                StartRoomUtils startRoomUtils = StartRoomUtils.INSTANCE;
                GroupDetailBean inviteGroup = roomCurrentPK.getInviteGroup();
                if (inviteGroup == null || (groupId2 = inviteGroup.getGroupId()) == null) {
                    str2 = "";
                } else {
                    str2 = groupId2;
                }
                StartRoomUtils.startRoom$default(startRoomUtils, str2, null, null, null, null, null, null, null, 0, 0, null, 0, false, 8190, null);
                return;
            }
            return;
        }
        StartRoomUtils startRoomUtils2 = StartRoomUtils.INSTANCE;
        GroupDetailBean receiveGroup = roomCurrentPK.getReceiveGroup();
        if (receiveGroup == null || (groupId = receiveGroup.getGroupId()) == null) {
            str = "";
        } else {
            str = groupId;
        }
        StartRoomUtils.startRoom$default(startRoomUtils2, str, null, null, null, null, null, null, null, 0, 0, null, 0, false, 8190, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RoomPKDialogAdapter mAdapter_delegate$lambda$0() {
        return new RoomPKDialogAdapter();
    }

    private final void refreshMatchPK(RoomPK data) {
        String str;
        String str2;
        QMUIRadiusImageView qMUIRadiusImageView = ((DialogRoomPkCreateBinding) getBinding()).leftAvatar;
        Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView, "leftAvatar");
        MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
        GroupDetailBean mGroupDetailBean = meetingRoomManager.getMGroupDetailBean();
        String str3 = null;
        if (mGroupDetailBean != null) {
            str = mGroupDetailBean.getFaceUrl();
        } else {
            str = null;
        }
        ImageKtxKt.loadImage$default(qMUIRadiusImageView, str, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
        TextView textView = ((DialogRoomPkCreateBinding) getBinding()).leftName;
        GroupDetailBean mGroupDetailBean2 = meetingRoomManager.getMGroupDetailBean();
        if (mGroupDetailBean2 != null) {
            str2 = mGroupDetailBean2.getName();
        } else {
            str2 = null;
        }
        textView.setText(str2);
        TextView textView2 = ((DialogRoomPkCreateBinding) getBinding()).leftId;
        GroupDetailBean mGroupDetailBean3 = meetingRoomManager.getMGroupDetailBean();
        if (mGroupDetailBean3 != null) {
            str3 = mGroupDetailBean3.getCode();
        }
        textView2.setText(str3);
        if (data != null && data.getStatus() == 0) {
            ((DialogRoomPkCreateBinding) getBinding()).startMatch.setVisibility(8);
            ((DialogRoomPkCreateBinding) getBinding()).matchGroup.setVisibility(0);
            ((DialogRoomPkCreateBinding) getBinding()).pkSearch.startAnimation();
        } else {
            ((DialogRoomPkCreateBinding) getBinding()).startMatch.setVisibility(0);
            ((DialogRoomPkCreateBinding) getBinding()).matchGroup.setVisibility(8);
            ((DialogRoomPkCreateBinding) getBinding()).pkSearch.stopAnimation();
        }
    }

    static /* synthetic */ void refreshMatchPK$default(RoomPKCreateDialog roomPKCreateDialog, RoomPK roomPK, int i, Object obj) {
        if ((i & 1) != 0) {
            roomPK = null;
        }
        roomPKCreateDialog.refreshMatchPK(roomPK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RoomPKViewModel viewMode_delegate$lambda$1(RoomPKCreateDialog roomPKCreateDialog) {
        return new ViewModelProvider(roomPKCreateDialog).get(RoomPKViewModel.class);
    }

    protected int getGravity() {
        return 80;
    }

    protected int getLayoutResId() {
        return R.layout.dialog_room_pk_create;
    }

    @NotNull
    public final RoomPKDialogAdapter getMAdapter() {
        return (RoomPKDialogAdapter) this.mAdapter.getValue();
    }

    @Nullable
    public final RoomPK getMData() {
        return this.mData;
    }

    @NotNull
    public final RoomPKViewModel getViewMode() {
        return (RoomPKViewModel) this.viewMode.getValue();
    }

    public void onDestroy() {
        ((DialogRoomPkCreateBinding) getBinding()).pkSearch.stopAnimation();
        super/*com.qiahao.base_common.common.BaseDialogFragment*/.onDestroy();
    }

    public void onInitialize() {
        super/*com.qiahao.base_common.common.BaseDialogFragment*/.onInitialize();
        initView();
        initData();
    }

    public void onStart() {
        Window window;
        super/*androidx.fragment.app.DialogFragment*/.onStart();
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.dimAmount = 0.0f;
            window.setAttributes(attributes);
        }
    }

    public final void setMData(@Nullable RoomPK roomPK) {
        this.mData = roomPK;
    }
}
