package com.qiahao.nextvideo.room.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatDialog;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.qiahao.base_common.network.interceptors.HiloException;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.DateTimeUtilityKt;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.base_common.viewmodel.BaseViewModel;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.CommonTextDialog;
import com.qiahao.nextvideo.app.base.HiloBaseBindingActivity;
import com.qiahao.nextvideo.data.model.GroupSupportDetailResponseBean;
import com.qiahao.nextvideo.data.model.MemberBean;
import com.qiahao.nextvideo.data.model.ProfitAllocator;
import com.qiahao.nextvideo.databinding.ActivityGroupSupportBinding;
import com.qiahao.nextvideo.network.AppServer;
import com.qiahao.nextvideo.room.adapter.GroupSupportAddAdapter;
import com.qiahao.nextvideo.utilities.userproxy.NumberUtilsKt;
import com.tencent.qcloud.tuicore.component.CustomLinearLayoutManager;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;
import org.android.agoo.message.MessageService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 H2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004:\u0001HB\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010,\u001a\u00020\u001cH\u0014J\u0012\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u000102H\u0014J\u000e\u00103\u001a\u0002002\u0006\u00104\u001a\u000205J\b\u00106\u001a\u000200H\u0002J\b\u00107\u001a\u000200H\u0002J\b\u00108\u001a\u000200H\u0002J\b\u00109\u001a\u000200H\u0002J\u0010\u0010<\u001a\u0002002\u0006\u0010=\u001a\u00020>H\u0016J\b\u0010?\u001a\u000200H\u0002J\"\u0010@\u001a\u0002002\u0006\u0010A\u001a\u00020\u001c2\u0006\u0010B\u001a\u00020\u001c2\b\u0010C\u001a\u0004\u0018\u00010DH\u0014J\b\u0010E\u001a\u000200H\u0016J\u0010\u0010F\u001a\u0002002\u0006\u0010G\u001a\u000205H\u0016R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R*\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00150\u0014j\b\u0012\u0004\u0012\u00020\u0015`\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010!\u001a\u0004\u0018\u00010\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001b\u0010'\u001a\u00020(8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b+\u0010\u0012\u001a\u0004\b)\u0010*R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010:\u001a\u0004\u0018\u00010;X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006I"}, d2 = {"Lcom/qiahao/nextvideo/room/activity/GroupSupportActivity;", "Lcom/qiahao/nextvideo/app/base/HiloBaseBindingActivity;", "Lcom/qiahao/nextvideo/databinding/ActivityGroupSupportBinding;", "Landroid/view/View$OnClickListener;", "Lcom/qiahao/nextvideo/room/activity/GroupSupportUpdateCountDownTimerDelegate;", "<init>", "()V", "mGroupId", "", "getMGroupId", "()Ljava/lang/String;", "setMGroupId", "(Ljava/lang/String;)V", "groupSupportAddAdapter", "Lcom/qiahao/nextvideo/room/adapter/GroupSupportAddAdapter;", "getGroupSupportAddAdapter", "()Lcom/qiahao/nextvideo/room/adapter/GroupSupportAddAdapter;", "groupSupportAddAdapter$delegate", "Lkotlin/Lazy;", "mSupporters", "Ljava/util/ArrayList;", "Lcom/qiahao/nextvideo/data/model/MemberBean;", "Lkotlin/collections/ArrayList;", "getMSupporters", "()Ljava/util/ArrayList;", "setMSupporters", "(Ljava/util/ArrayList;)V", "maxSupport", "", "getMaxSupport", "()I", "setMaxSupport", "(I)V", "mGroupSupportDetailResponseBean", "Lcom/qiahao/nextvideo/data/model/GroupSupportDetailResponseBean;", "getMGroupSupportDetailResponseBean", "()Lcom/qiahao/nextvideo/data/model/GroupSupportDetailResponseBean;", "setMGroupSupportDetailResponseBean", "(Lcom/qiahao/nextvideo/data/model/GroupSupportDetailResponseBean;)V", "mViewModel", "Lcom/qiahao/base_common/viewmodel/BaseViewModel;", "getMViewModel", "()Lcom/qiahao/base_common/viewmodel/BaseViewModel;", "mViewModel$delegate", "getLayoutResId", "mCountDownTimer", "Lcom/qiahao/nextvideo/room/activity/GroupSupportUpdateCountDownTimer;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "countDown", "remainSecond", "", "initData", "judgeSupportersLimitAndAddBean", "initView", "initRecyclerView", "commonTextDialog", "Lcom/qiahao/nextvideo/app/base/CommonTextDialog;", "onClick", "v", "Landroid/view/View;", "receiveRewardPress", "onActivityResult", "requestCode", com.taobao.agoo.a.a.b.JSON_ERRORCODE, "data", "Landroid/content/Intent;", "groupSupportUpdateCountDownTimerTimeout", "groupSupportUpdateCountDownTimerOnTick", "millisUntilFinished", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nGroupSupportActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GroupSupportActivity.kt\ncom/qiahao/nextvideo/room/activity/GroupSupportActivity\n+ 2 View.kt\nandroidx/core/view/ViewKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,400:1\n255#2:401\n1869#3,2:402\n1869#3,2:404\n1869#3,2:406\n*S KotlinDebug\n*F\n+ 1 GroupSupportActivity.kt\ncom/qiahao/nextvideo/room/activity/GroupSupportActivity\n*L\n192#1:401\n285#1:402,2\n239#1:404,2\n252#1:406,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class GroupSupportActivity extends HiloBaseBindingActivity<ActivityGroupSupportBinding> implements View.OnClickListener, GroupSupportUpdateCountDownTimerDelegate {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    public static final int INTENT_RESULT_TAP = 1;

    @Nullable
    private CommonTextDialog commonTextDialog;

    @Nullable
    private GroupSupportUpdateCountDownTimer mCountDownTimer;

    @Nullable
    private GroupSupportDetailResponseBean mGroupSupportDetailResponseBean;
    private int maxSupport;

    @NotNull
    private String mGroupId = "";

    /* renamed from: groupSupportAddAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy groupSupportAddAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.room.activity.j0
        public final Object invoke() {
            GroupSupportAddAdapter groupSupportAddAdapter_delegate$lambda$0;
            groupSupportAddAdapter_delegate$lambda$0 = GroupSupportActivity.groupSupportAddAdapter_delegate$lambda$0();
            return groupSupportAddAdapter_delegate$lambda$0;
        }
    });

    @NotNull
    private ArrayList<MemberBean> mSupporters = new ArrayList<>();

    /* renamed from: mViewModel$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mViewModel = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.room.activity.k0
        public final Object invoke() {
            BaseViewModel mViewModel_delegate$lambda$1;
            mViewModel_delegate$lambda$1 = GroupSupportActivity.mViewModel_delegate$lambda$1(GroupSupportActivity.this);
            return mViewModel_delegate$lambda$1;
        }
    });

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/qiahao/nextvideo/room/activity/GroupSupportActivity$Companion;", "", "<init>", "()V", "start", "", "context", "Landroid/content/Context;", "groupId", "", "INTENT_RESULT_TAP", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void start(@NotNull Context context, @NotNull String groupId) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(groupId, "groupId");
            Intent intent = new Intent(context, (Class<?>) GroupSupportActivity.class);
            intent.putExtra("group_id", groupId);
            context.startActivity(intent);
        }

        private Companion() {
        }
    }

    private final GroupSupportAddAdapter getGroupSupportAddAdapter() {
        return (GroupSupportAddAdapter) this.groupSupportAddAdapter.getValue();
    }

    private final BaseViewModel getMViewModel() {
        return (BaseViewModel) this.mViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GroupSupportAddAdapter groupSupportAddAdapter_delegate$lambda$0() {
        return new GroupSupportAddAdapter(R.layout.item_group_support);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initData() {
        RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().getGroupSupportDetail(this.mGroupId), new Function1() { // from class: com.qiahao.nextvideo.room.activity.h0
            public final Object invoke(Object obj) {
                Unit initData$lambda$5;
                initData$lambda$5 = GroupSupportActivity.initData$lambda$5(GroupSupportActivity.this, (ApiResponse) obj);
                return initData$lambda$5;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.activity.i0
            public final Object invoke(Object obj) {
                Unit initData$lambda$6;
                initData$lambda$6 = GroupSupportActivity.initData$lambda$6(GroupSupportActivity.this, (Throwable) obj);
                return initData$lambda$6;
            }
        }, (Function0) null, false, 12, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit initData$lambda$5(GroupSupportActivity groupSupportActivity, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        GroupSupportDetailResponseBean groupSupportDetailResponseBean = (GroupSupportDetailResponseBean) apiResponse.getData();
        if (groupSupportDetailResponseBean != null) {
            String groupId = groupSupportDetailResponseBean.getGroupId();
            if (groupId != null && groupId.length() != 0) {
                groupSupportActivity.mGroupSupportDetailResponseBean = groupSupportDetailResponseBean;
                groupSupportActivity.maxSupport = groupSupportDetailResponseBean.getSupporterLimit();
                groupSupportActivity.mGroupId = groupSupportDetailResponseBean.getGroupId();
                if (groupSupportDetailResponseBean.getSupportLevel().length() > 0) {
                    groupSupportActivity.mSupporters.clear();
                    List<MemberBean> supporters = groupSupportDetailResponseBean.getSupporters();
                    if (supporters != null && !supporters.isEmpty()) {
                        ArrayList<MemberBean> arrayList = groupSupportActivity.mSupporters;
                        List<MemberBean> supporters2 = groupSupportDetailResponseBean.getSupporters();
                        Intrinsics.checkNotNull(supporters2);
                        arrayList.addAll(supporters2);
                    }
                    groupSupportActivity.judgeSupportersLimitAndAddBean();
                }
                groupSupportActivity.initView();
            } else {
                groupSupportActivity.finish();
                HiloToasty.Companion companion = HiloToasty.Companion;
                String string = groupSupportActivity.getString(2131952609);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                Toast normal$default = HiloToasty.Companion.normal$default(companion, groupSupportActivity, string, false, 4, (Object) null);
                if (normal$default != null) {
                    normal$default.show();
                }
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit initData$lambda$6(GroupSupportActivity groupSupportActivity, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        if (th instanceof HiloException) {
            HiloException hiloException = (HiloException) th;
            if (hiloException.getCode() == 14001) {
                groupSupportActivity.finish();
                HiloToasty.Companion companion = HiloToasty.Companion;
                String string = groupSupportActivity.getString(2131952609);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                Toast normal$default = HiloToasty.Companion.normal$default(companion, groupSupportActivity, string, false, 4, (Object) null);
                if (normal$default != null) {
                    normal$default.show();
                }
            } else {
                HiloToasty.Companion companion2 = HiloToasty.Companion;
                String errorMessage = hiloException.getErrorMessage();
                if (errorMessage == null) {
                    errorMessage = groupSupportActivity.getString(2131952667);
                    Intrinsics.checkNotNullExpressionValue(errorMessage, "getString(...)");
                }
                Toast normal$default2 = HiloToasty.Companion.normal$default(companion2, groupSupportActivity, errorMessage, false, 4, (Object) null);
                if (normal$default2 != null) {
                    normal$default2.show();
                }
            }
        } else {
            HiloToasty.Companion companion3 = HiloToasty.Companion;
            String string2 = groupSupportActivity.getString(2131952667);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            Toast normal$default3 = HiloToasty.Companion.normal$default(companion3, groupSupportActivity, string2, false, 4, (Object) null);
            if (normal$default3 != null) {
                normal$default3.show();
            }
        }
        return Unit.INSTANCE;
    }

    private final void initRecyclerView() {
        RecyclerView recyclerView = getBinding().recyclerGroupAdmin;
        recyclerView.setLayoutManager(new CustomLinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(getGroupSupportAddAdapter());
        getGroupSupportAddAdapter().addChildClickViewIds(new int[]{R.id.support_add_user, 2131362629});
        getGroupSupportAddAdapter().setOnItemChildClickListener(new OnItemChildClickListener() { // from class: com.qiahao.nextvideo.room.activity.f0
            public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                GroupSupportActivity.initRecyclerView$lambda$10(GroupSupportActivity.this, baseQuickAdapter, view, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void initRecyclerView$lambda$10(GroupSupportActivity groupSupportActivity, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "view");
        MemberBean memberBean = (MemberBean) groupSupportActivity.getGroupSupportAddAdapter().getItem(i);
        int id2 = view.getId();
        if (id2 != 2131362629) {
            if (id2 == 2131364954) {
                ArrayList arrayList = new ArrayList();
                for (MemberBean memberBean2 : groupSupportActivity.mSupporters) {
                    if (memberBean2.getExternalId().length() > 0) {
                        arrayList.add(memberBean2.getExternalId());
                    }
                }
                Intent intent = new Intent((Context) groupSupportActivity, (Class<?>) RoomMemberAdminActivity.class);
                intent.putExtra("group_id", groupSupportActivity.mGroupId);
                intent.putExtra(RoomMemberAdminActivity.Group_HAS_SELECT_USER, arrayList);
                groupSupportActivity.startActivityForResult(intent, 1);
                return;
            }
            return;
        }
        if (groupSupportActivity.mSupporters.contains(memberBean)) {
            groupSupportActivity.mSupporters.remove(memberBean);
        }
        MemberBean memberBean3 = null;
        for (MemberBean memberBean4 : groupSupportActivity.mSupporters) {
            if (memberBean4.getExternalId().length() == 0) {
                memberBean3 = memberBean4;
            }
        }
        TypeIntrinsics.asMutableCollection(groupSupportActivity.mSupporters).remove(memberBean3);
        groupSupportActivity.judgeSupportersLimitAndAddBean();
        groupSupportActivity.getGroupSupportAddAdapter().setList(groupSupportActivity.mSupporters);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0269  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0290  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0295  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0292  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0299  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x026b  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x015c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void initView() {
        boolean z;
        String str;
        String str2;
        String str3;
        boolean z2;
        String supportLevel;
        boolean z3;
        ProfitAllocator profitAllocator;
        ProfitAllocator profitAllocator2;
        ProfitAllocator profitAllocator3;
        boolean z4;
        long j;
        Integer num;
        Integer num2;
        boolean z5;
        String str4;
        GroupSupportDetailResponseBean groupSupportDetailResponseBean;
        String currentSupportLevel;
        boolean z6;
        String supportLevel2;
        boolean z7;
        long j2;
        boolean z8 = false;
        GroupSupportDetailResponseBean groupSupportDetailResponseBean2 = this.mGroupSupportDetailResponseBean;
        if (groupSupportDetailResponseBean2 != null) {
            z = groupSupportDetailResponseBean2.isDispatched();
        } else {
            z = true;
        }
        String str5 = null;
        if (z) {
            ((ActivityGroupSupportBinding) getBinding()).llCanReward.setVisibility(8);
            ((ActivityGroupSupportBinding) getBinding()).llOwnerGroup.setVisibility(8);
            ((ActivityGroupSupportBinding) getBinding()).llOwner.setVisibility(8);
            ((ActivityGroupSupportBinding) getBinding()).groupAdmin.setVisibility(8);
            ((ActivityGroupSupportBinding) getBinding()).recyclerGroupAdmin.setVisibility(8);
            ((ActivityGroupSupportBinding) getBinding()).unreceiveAwardBtn1.setVisibility(0);
            ((ActivityGroupSupportBinding) getBinding()).text1.setText(getString(2131953195));
        } else {
            ((ActivityGroupSupportBinding) getBinding()).llCanReward.setVisibility(0);
            ((ActivityGroupSupportBinding) getBinding()).llOwnerGroup.setVisibility(0);
            ((ActivityGroupSupportBinding) getBinding()).llOwner.setVisibility(0);
            ((ActivityGroupSupportBinding) getBinding()).groupAdmin.setVisibility(0);
            ((ActivityGroupSupportBinding) getBinding()).recyclerGroupAdmin.setVisibility(0);
            TextView textView = ((ActivityGroupSupportBinding) getBinding()).ownerName;
            GroupSupportDetailResponseBean groupSupportDetailResponseBean3 = this.mGroupSupportDetailResponseBean;
            if (groupSupportDetailResponseBean3 != null && (profitAllocator3 = groupSupportDetailResponseBean3.getProfitAllocator()) != null) {
                str = profitAllocator3.getNick();
            } else {
                str = null;
            }
            textView.setText(str);
            TextView textView2 = ((ActivityGroupSupportBinding) getBinding()).ownerId;
            GroupSupportDetailResponseBean groupSupportDetailResponseBean4 = this.mGroupSupportDetailResponseBean;
            if (groupSupportDetailResponseBean4 != null && (profitAllocator2 = groupSupportDetailResponseBean4.getProfitAllocator()) != null) {
                str2 = profitAllocator2.getCode();
            } else {
                str2 = null;
            }
            textView2.setText(getString(2131953102, str2));
            AppCompatImageView appCompatImageView = ((ActivityGroupSupportBinding) getBinding()).ownerAvatar;
            Intrinsics.checkNotNullExpressionValue(appCompatImageView, "ownerAvatar");
            GroupSupportDetailResponseBean groupSupportDetailResponseBean5 = this.mGroupSupportDetailResponseBean;
            if (groupSupportDetailResponseBean5 != null && (profitAllocator = groupSupportDetailResponseBean5.getProfitAllocator()) != null) {
                str3 = profitAllocator.getAvatar();
            } else {
                str3 = null;
            }
            ImageKtxKt.loadImage$default(appCompatImageView, str3, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131231930, (c5.g) null, 49150, (Object) null);
            GroupSupportDetailResponseBean groupSupportDetailResponseBean6 = this.mGroupSupportDetailResponseBean;
            if (groupSupportDetailResponseBean6 != null && (supportLevel = groupSupportDetailResponseBean6.getSupportLevel()) != null) {
                if (supportLevel.length() > 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z3) {
                    z2 = true;
                    if (!z2) {
                        ((ActivityGroupSupportBinding) getBinding()).recyclerGroupAdmin.setVisibility(0);
                        ((ActivityGroupSupportBinding) getBinding()).groupAdmin.setVisibility(0);
                        getGroupSupportAddAdapter().setList(this.mSupporters);
                    } else {
                        ((ActivityGroupSupportBinding) getBinding()).recyclerGroupAdmin.setVisibility(8);
                        ((ActivityGroupSupportBinding) getBinding()).groupAdmin.setVisibility(8);
                        ((ActivityGroupSupportBinding) getBinding()).llOwnerGroup.setVisibility(8);
                        ((ActivityGroupSupportBinding) getBinding()).llOwner.setVisibility(8);
                        ((ActivityGroupSupportBinding) getBinding()).llCanReward.setVisibility(8);
                        ((ActivityGroupSupportBinding) getBinding()).unreceiveAwardBtn1.setVisibility(0);
                        ((ActivityGroupSupportBinding) getBinding()).text1.setText(getString(2131953199));
                    }
                    initRecyclerView();
                }
            }
            z2 = false;
            if (!z2) {
            }
            initRecyclerView();
        }
        LinearLayout linearLayout = ((ActivityGroupSupportBinding) getBinding()).unreceiveAwardBtn1;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "unreceiveAwardBtn1");
        if (linearLayout.getVisibility() == 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        long j3 = 0;
        if (z4) {
            GroupSupportDetailResponseBean groupSupportDetailResponseBean7 = this.mGroupSupportDetailResponseBean;
            if (groupSupportDetailResponseBean7 != null) {
                j2 = groupSupportDetailResponseBean7.getRemainSecond();
            } else {
                j2 = 0;
            }
            countDown(j2);
        }
        TextView textView3 = ((ActivityGroupSupportBinding) getBinding()).lastWeekTrophy;
        GroupSupportDetailResponseBean groupSupportDetailResponseBean8 = this.mGroupSupportDetailResponseBean;
        if (groupSupportDetailResponseBean8 != null) {
            j = groupSupportDetailResponseBean8.getLastConsume();
        } else {
            j = 0;
        }
        textView3.setText(NumberUtilsKt.rankNumberFormat(j));
        TextView textView4 = ((ActivityGroupSupportBinding) getBinding()).thisWeekTrophy;
        GroupSupportDetailResponseBean groupSupportDetailResponseBean9 = this.mGroupSupportDetailResponseBean;
        if (groupSupportDetailResponseBean9 != null) {
            j3 = groupSupportDetailResponseBean9.getCurrentConsume();
        }
        textView4.setText(NumberUtilsKt.rankNumberFormat(j3));
        TextView textView5 = ((ActivityGroupSupportBinding) getBinding()).lastWeekSupport;
        GroupSupportDetailResponseBean groupSupportDetailResponseBean10 = this.mGroupSupportDetailResponseBean;
        if (groupSupportDetailResponseBean10 != null) {
            num = Integer.valueOf(groupSupportDetailResponseBean10.getLastCount());
        } else {
            num = null;
        }
        textView5.setText(String.valueOf(num));
        TextView textView6 = ((ActivityGroupSupportBinding) getBinding()).thisWeekSupport;
        GroupSupportDetailResponseBean groupSupportDetailResponseBean11 = this.mGroupSupportDetailResponseBean;
        if (groupSupportDetailResponseBean11 != null) {
            num2 = Integer.valueOf(groupSupportDetailResponseBean11.getCurrentCount());
        } else {
            num2 = null;
        }
        textView6.setText(String.valueOf(num2));
        TextView textView7 = ((ActivityGroupSupportBinding) getBinding()).lastWeekLevel;
        GroupSupportDetailResponseBean groupSupportDetailResponseBean12 = this.mGroupSupportDetailResponseBean;
        if (groupSupportDetailResponseBean12 != null && (supportLevel2 = groupSupportDetailResponseBean12.getSupportLevel()) != null) {
            if (supportLevel2.length() == 0) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (z7) {
                z5 = true;
                String str6 = MessageService.MSG_DB_READY_REPORT;
                if (!z5) {
                    str4 = MessageService.MSG_DB_READY_REPORT;
                } else {
                    GroupSupportDetailResponseBean groupSupportDetailResponseBean13 = this.mGroupSupportDetailResponseBean;
                    if (groupSupportDetailResponseBean13 != null) {
                        str4 = groupSupportDetailResponseBean13.getSupportLevel();
                    } else {
                        str4 = null;
                    }
                }
                textView7.setText(str4);
                TextView textView8 = ((ActivityGroupSupportBinding) getBinding()).thisWeekLevel;
                groupSupportDetailResponseBean = this.mGroupSupportDetailResponseBean;
                if (groupSupportDetailResponseBean != null && (currentSupportLevel = groupSupportDetailResponseBean.getCurrentSupportLevel()) != null) {
                    if (currentSupportLevel.length() != 0) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    if (z6) {
                        z8 = true;
                    }
                }
                if (!z8) {
                    GroupSupportDetailResponseBean groupSupportDetailResponseBean14 = this.mGroupSupportDetailResponseBean;
                    if (groupSupportDetailResponseBean14 != null) {
                        str5 = groupSupportDetailResponseBean14.getCurrentSupportLevel();
                    }
                    str6 = str5;
                }
                textView8.setText(str6);
            }
        }
        z5 = false;
        String str62 = MessageService.MSG_DB_READY_REPORT;
        if (!z5) {
        }
        textView7.setText(str4);
        TextView textView82 = ((ActivityGroupSupportBinding) getBinding()).thisWeekLevel;
        groupSupportDetailResponseBean = this.mGroupSupportDetailResponseBean;
        if (groupSupportDetailResponseBean != null) {
            if (currentSupportLevel.length() != 0) {
            }
            if (z6) {
            }
        }
        if (!z8) {
        }
        textView82.setText(str62);
    }

    private final void judgeSupportersLimitAndAddBean() {
        int size = this.mSupporters.size();
        int i = this.maxSupport;
        if (size < i) {
            int size2 = i - this.mSupporters.size();
            for (int i2 = 0; i2 < size2; i2++) {
                this.mSupporters.add(MemberBean.INSTANCE.empty());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BaseViewModel mViewModel_delegate$lambda$1(GroupSupportActivity groupSupportActivity) {
        return new ViewModelProvider(groupSupportActivity).get(BaseViewModel.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$2(GroupSupportActivity groupSupportActivity, int i, int i2) {
        ViewGroup.LayoutParams layoutParams = groupSupportActivity.getBinding().titleBar.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        ((LinearLayout.LayoutParams) layoutParams).setMargins(0, i, 0, 0);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [android.app.Dialog, com.qiahao.nextvideo.app.base.CommonTextDialog] */
    private final void receiveRewardPress() {
        CommonTextDialog commonTextDialog;
        AppCompatDialog appCompatDialog = this.commonTextDialog;
        if (appCompatDialog != null && appCompatDialog != null && appCompatDialog.isShowing() && (commonTextDialog = this.commonTextDialog) != null) {
            commonTextDialog.dismiss();
        }
        ?? commonTextDialog2 = new CommonTextDialog(this, 0.0f, 2, null);
        String string = getString(2131952028);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        commonTextDialog2.setContentText(string, true, new GroupSupportActivity$receiveRewardPress$1$1(this, commonTextDialog2));
        this.commonTextDialog = commonTextDialog2;
        commonTextDialog2.show();
    }

    @JvmStatic
    public static final void start(@NotNull Context context, @NotNull String str) {
        INSTANCE.start(context, str);
    }

    public final void countDown(long remainSecond) {
        GroupSupportUpdateCountDownTimer groupSupportUpdateCountDownTimer = new GroupSupportUpdateCountDownTimer(remainSecond * 1000);
        groupSupportUpdateCountDownTimer.setDelegate(this);
        this.mCountDownTimer = groupSupportUpdateCountDownTimer;
        groupSupportUpdateCountDownTimer.start();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public int getLayoutResId() {
        return R.layout.activity_group_support;
    }

    @NotNull
    public final String getMGroupId() {
        return this.mGroupId;
    }

    @Nullable
    public final GroupSupportDetailResponseBean getMGroupSupportDetailResponseBean() {
        return this.mGroupSupportDetailResponseBean;
    }

    @NotNull
    public final ArrayList<MemberBean> getMSupporters() {
        return this.mSupporters;
    }

    public final int getMaxSupport() {
        return this.maxSupport;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.qiahao.nextvideo.room.activity.GroupSupportUpdateCountDownTimerDelegate
    public void groupSupportUpdateCountDownTimerOnTick(long millisUntilFinished) {
        ((ActivityGroupSupportBinding) getBinding()).text2.setText(getString(2131954481, DateTimeUtilityKt.changeLuckRankingTime(millisUntilFinished / 1000)));
    }

    @Override // com.qiahao.nextvideo.room.activity.GroupSupportUpdateCountDownTimerDelegate
    public void groupSupportUpdateCountDownTimerTimeout() {
    }

    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        MemberBean memberBean;
        Serializable serializableExtra;
        super/*com.oudi.core.component.SuperActivity*/.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == -1) {
            if (data != null && (serializableExtra = data.getSerializableExtra("member_bean")) != null) {
                memberBean = (MemberBean) serializableExtra;
            } else {
                memberBean = null;
            }
            if (memberBean != null) {
                Iterator<MemberBean> it = this.mSupporters.iterator();
                Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
                while (it.hasNext()) {
                    if (it.next().getExternalId().length() == 0) {
                        it.remove();
                    }
                }
                this.mSupporters.add(memberBean);
                judgeSupportersLimitAndAddBean();
                getGroupSupportAddAdapter().setList(this.mSupporters);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        int id2 = v.getId();
        if (id2 != 2131362039) {
            if (id2 == 2131364479) {
                if (this.mSupporters.isEmpty()) {
                    HiloToasty.Companion companion = HiloToasty.Companion;
                    String string = getString(2131953688);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    Toast normal$default = HiloToasty.Companion.normal$default(companion, this, string, false, 4, (Object) null);
                    if (normal$default != null) {
                        normal$default.show();
                        return;
                    }
                    return;
                }
                Iterator<T> it = this.mSupporters.iterator();
                boolean z = false;
                while (it.hasNext()) {
                    if (((MemberBean) it.next()).getExternalId().length() > 0) {
                        z = true;
                    }
                }
                if (!z) {
                    HiloToasty.Companion companion2 = HiloToasty.Companion;
                    String string2 = getString(2131953688);
                    Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                    Toast normal$default2 = HiloToasty.Companion.normal$default(companion2, this, string2, false, 4, (Object) null);
                    if (normal$default2 != null) {
                        normal$default2.show();
                        return;
                    }
                    return;
                }
                receiveRewardPress();
                return;
            }
            return;
        }
        finish();
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((ActivityGroupSupportBinding) getBinding()).setClick(this);
        String stringExtra = getIntent().getStringExtra("group_id");
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.mGroupId = stringExtra;
        initData();
        Toolbar toolbar = ((ActivityGroupSupportBinding) getBinding()).titleBar;
        Intrinsics.checkNotNullExpressionValue(toolbar, "titleBar");
        getStatusBarTopOrBottom(toolbar, new Function2() { // from class: com.qiahao.nextvideo.room.activity.g0
            public final Object invoke(Object obj, Object obj2) {
                Unit onCreate$lambda$2;
                onCreate$lambda$2 = GroupSupportActivity.onCreate$lambda$2(GroupSupportActivity.this, ((Integer) obj).intValue(), ((Integer) obj2).intValue());
                return onCreate$lambda$2;
            }
        });
        setStatusBarIconColor(false);
    }

    public final void setMGroupId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mGroupId = str;
    }

    public final void setMGroupSupportDetailResponseBean(@Nullable GroupSupportDetailResponseBean groupSupportDetailResponseBean) {
        this.mGroupSupportDetailResponseBean = groupSupportDetailResponseBean;
    }

    public final void setMSupporters(@NotNull ArrayList<MemberBean> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.mSupporters = arrayList;
    }

    public final void setMaxSupport(int i) {
        this.maxSupport = i;
    }
}
