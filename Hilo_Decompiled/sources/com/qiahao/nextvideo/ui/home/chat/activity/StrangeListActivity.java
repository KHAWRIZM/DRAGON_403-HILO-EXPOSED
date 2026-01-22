package com.qiahao.nextvideo.ui.home.chat.activity;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.utils.Dimens;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.FootLoading;
import com.qiahao.nextvideo.app.base.HiloBaseBindingActivity;
import com.qiahao.nextvideo.data.strange.StrangeItemData;
import com.qiahao.nextvideo.data.strange.StrangeUserData;
import com.qiahao.nextvideo.databinding.ActivityStrangeListBinding;
import com.qiahao.nextvideo.ui.home.chat.StrangeListAdapter;
import com.qiahao.nextvideo.ui.home.chat.activity.StrangeMatchActivity;
import com.qiahao.nextvideo.ui.im.StrangeDataListener;
import com.qiahao.nextvideo.ui.im.StrangerProvide;
import com.qiahao.nextvideo.utilities.AppRequestUtils;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.random.Random;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u00192\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0012\u001a\u00020\u000bH\u0014J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0002J\b\u0010\u0016\u001a\u00020\u0014H\u0002J\b\u0010\u0017\u001a\u00020\u0014H\u0014J\b\u0010\u0018\u001a\u00020\u0014H\u0014R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/qiahao/nextvideo/ui/home/chat/activity/StrangeListActivity;", "Lcom/qiahao/nextvideo/app/base/HiloBaseBindingActivity;", "Lcom/qiahao/nextvideo/databinding/ActivityStrangeListBinding;", "<init>", "()V", "isDialog", "", "()Z", "setDialog", "(Z)V", "mCount", "", "mAdapter", "Lcom/qiahao/nextvideo/ui/home/chat/StrangeListAdapter;", "getMAdapter", "()Lcom/qiahao/nextvideo/ui/home/chat/StrangeListAdapter;", "mAdapter$delegate", "Lkotlin/Lazy;", "getLayoutResId", "onInitialize", "", "initChatDialog", "initView", "onResume", "onPause", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nStrangeListActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StrangeListActivity.kt\ncom/qiahao/nextvideo/ui/home/chat/activity/StrangeListActivity\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n*L\n1#1,163:1\n61#2,9:164\n*S KotlinDebug\n*F\n+ 1 StrangeListActivity.kt\ncom/qiahao/nextvideo/ui/home/chat/activity/StrangeListActivity\n*L\n89#1:164,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class StrangeListActivity extends HiloBaseBindingActivity<ActivityStrangeListBinding> {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String IS_DIALOG = "isDialog";
    private boolean isDialog;

    /* renamed from: mAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.home.chat.activity.f2
        public final Object invoke() {
            StrangeListAdapter mAdapter_delegate$lambda$0;
            mAdapter_delegate$lambda$0 = StrangeListActivity.mAdapter_delegate$lambda$0();
            return mAdapter_delegate$lambda$0;
        }
    });
    private int mCount;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/qiahao/nextvideo/ui/home/chat/activity/StrangeListActivity$Companion;", "", "<init>", "()V", StrangeMatchActivity.IS_DIALOG, "", "start", "", "context", "Landroid/content/Context;", "isDialog", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void start$default(Companion companion, Context context, boolean z, int i, Object obj) {
            if ((i & 2) != 0) {
                z = false;
            }
            companion.start(context, z);
        }

        public final void start(@NotNull Context context, boolean isDialog) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent(context, (Class<?>) StrangeListActivity.class);
            intent.putExtra("isDialog", isDialog);
            context.startActivity(intent);
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StrangeListAdapter getMAdapter() {
        return (StrangeListAdapter) this.mAdapter.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initChatDialog() {
        boolean booleanExtra = getIntent().getBooleanExtra("isDialog", false);
        this.isDialog = booleanExtra;
        if (booleanExtra) {
            getWindow().addFlags(128);
            getWindow().setLayout(-1, -1);
            getWindow().setGravity(80);
            getWindow().setSoftInputMode(32);
            ViewGroup.LayoutParams layoutParams = ((ActivityStrangeListBinding) getBinding()).activityMainContainer.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            Dimens dimens = Dimens.INSTANCE;
            layoutParams2.height = ((dimens.getScreenHeight() / 5) * 4) - dimens.dpToPx(44);
            layoutParams2.width = dimens.getScreenWidth();
            layoutParams2.gravity = 80;
            ((ActivityStrangeListBinding) getBinding()).activityMainContainer.setLayoutParams(layoutParams2);
            ((ActivityStrangeListBinding) getBinding()).constraint.setBackground(androidx.core.content.a.getDrawable(this, R.drawable.shape_commom_frame_view));
            return;
        }
        View view = ((ActivityStrangeListBinding) getBinding()).bar;
        Intrinsics.checkNotNullExpressionValue(view, "bar");
        getStatusBarTopOrBottom(view, new Function2() { // from class: com.qiahao.nextvideo.ui.home.chat.activity.g2
            public final Object invoke(Object obj, Object obj2) {
                Unit initChatDialog$lambda$1;
                initChatDialog$lambda$1 = StrangeListActivity.initChatDialog$lambda$1(StrangeListActivity.this, ((Integer) obj).intValue(), ((Integer) obj2).intValue());
                return initChatDialog$lambda$1;
            }
        });
        getTheme().applyStyle(0, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initChatDialog$lambda$1(StrangeListActivity strangeListActivity, int i, int i2) {
        strangeListActivity.getBinding().bar.setLayoutParams(new LinearLayoutCompat.a(-2, i));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initView() {
        ((ActivityStrangeListBinding) getBinding()).backImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.home.chat.activity.c2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StrangeListActivity.this.finish();
            }
        });
        final ConstraintLayout constraintLayout = ((ActivityStrangeListBinding) getBinding()).matchLayout;
        final long j = 800;
        constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.home.chat.activity.StrangeListActivity$initView$$inlined$singleClick$default$1
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v1, types: [android.content.Context, com.qiahao.nextvideo.ui.home.chat.activity.StrangeListActivity] */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(constraintLayout) > j || (constraintLayout instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(constraintLayout, currentTimeMillis);
                    ConstraintLayout constraintLayout2 = constraintLayout;
                    StrangeMatchActivity.Companion companion = StrangeMatchActivity.INSTANCE;
                    ?? r0 = this;
                    companion.startActivity(r0, r0.getIsDialog());
                }
            }
        });
        ((ActivityStrangeListBinding) getBinding()).title.setText(ResourcesKtxKt.getStringById(this, 2131954151));
        AppCompatTextView appCompatTextView = ((ActivityStrangeListBinding) getBinding()).subTitle;
        String format = String.format(ResourcesKtxKt.getStringById(this, 2131954153), Arrays.copyOf(new Object[]{Integer.valueOf(Random.Default.nextInt(170000, 190000))}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        appCompatTextView.setText(format);
        SmartRefreshLayout smartRefreshLayout = ((ActivityStrangeListBinding) getBinding()).refreshLayout;
        FootLoading footLoading = new FootLoading((Context) this);
        footLoading.setBackground(androidx.core.content.a.getDrawable(footLoading.getContext(), 2131101214));
        smartRefreshLayout.setRefreshFooter(footLoading);
        ((ActivityStrangeListBinding) getBinding()).refreshLayout.setOnRefreshListener(new vc.g() { // from class: com.qiahao.nextvideo.ui.home.chat.activity.d2
            @Override // vc.g
            public final void onRefresh(tc.f fVar) {
                StrangeListActivity.initView$lambda$5(fVar);
            }
        });
        ((ActivityStrangeListBinding) getBinding()).recyclerView.setAdapter(getMAdapter());
        getMAdapter().setOnItemClickListener(new OnItemClickListener() { // from class: com.qiahao.nextvideo.ui.home.chat.activity.e2
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                StrangeListActivity.initView$lambda$8(StrangeListActivity.this, baseQuickAdapter, view, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$5(tc.f fVar) {
        Intrinsics.checkNotNullParameter(fVar, "it");
        StrangerProvide.INSTANCE.displayData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$8(final StrangeListActivity strangeListActivity, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        StrangeUserData strangeData;
        User otherUser;
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        StrangeItemData strangeItemData = (StrangeItemData) strangeListActivity.getMAdapter().getData().get(i);
        if (strangeListActivity.mCount == 0 && (strangeData = strangeItemData.getStrangeData()) != null && (otherUser = strangeData.getOtherUser()) != null) {
            strangeListActivity.mCount++;
            AppRequestUtils appRequestUtils = AppRequestUtils.INSTANCE;
            boolean z = strangeListActivity.isDialog;
            String groupId = strangeItemData.getGroupId();
            if (groupId == null) {
                groupId = "";
            }
            appRequestUtils.openStrangeChatActivity(otherUser, z, groupId, new Function1() { // from class: com.qiahao.nextvideo.ui.home.chat.activity.b2
                public final Object invoke(Object obj) {
                    Unit initView$lambda$8$lambda$7$lambda$6;
                    initView$lambda$8$lambda$7$lambda$6 = StrangeListActivity.initView$lambda$8$lambda$7$lambda$6(StrangeListActivity.this, ((Boolean) obj).booleanValue());
                    return initView$lambda$8$lambda$7$lambda$6;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initView$lambda$8$lambda$7$lambda$6(StrangeListActivity strangeListActivity, boolean z) {
        strangeListActivity.mCount = 0;
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StrangeListAdapter mAdapter_delegate$lambda$0() {
        return new StrangeListAdapter();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public int getLayoutResId() {
        return R.layout.activity_strange_list;
    }

    /* renamed from: isDialog, reason: from getter */
    public final boolean getIsDialog() {
        return this.isDialog;
    }

    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onInitialize() {
        super.onInitialize();
        initChatDialog();
        initView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onPause() {
        super.onPause();
        StrangerProvide strangerProvide = StrangerProvide.INSTANCE;
        String name = StrangeListActivity.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        strangerProvide.removeListener(name);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onResume() {
        super.onResume();
        StrangerProvide strangerProvide = StrangerProvide.INSTANCE;
        String name = StrangeListActivity.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        strangerProvide.registerListener(name, new StrangeDataListener() { // from class: com.qiahao.nextvideo.ui.home.chat.activity.StrangeListActivity$onResume$1
            @Override // com.qiahao.nextvideo.ui.im.StrangeDataListener
            public void messageDataListener(ArrayList<StrangeItemData> listMessageDate, int unReadMessage) {
                ActivityStrangeListBinding binding;
                ActivityStrangeListBinding binding2;
                ActivityStrangeListBinding binding3;
                StrangeListAdapter mAdapter;
                Intrinsics.checkNotNullParameter(listMessageDate, "listMessageDate");
                binding = StrangeListActivity.this.getBinding();
                binding.refreshLayout.finishRefresh();
                binding2 = StrangeListActivity.this.getBinding();
                binding2.refreshLayout.finishLoadMore();
                binding3 = StrangeListActivity.this.getBinding();
                binding3.refreshLayout.setEnableLoadMore(false);
                mAdapter = StrangeListActivity.this.getMAdapter();
                mAdapter.setList(listMessageDate);
            }
        });
        strangerProvide.displayData();
    }

    public final void setDialog(boolean z) {
        this.isDialog = z;
    }
}
