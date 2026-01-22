package com.qiahao.nextvideo.ui.transfer;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Parcelable;
import android.view.View;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.oudi.utils.SpannableTextBuilder;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.UiKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.oudi.utils.store.IStore;
import com.oudi.utils.store.MMKVStore;
import com.qiahao.base_common.common.BaseActivity;
import com.qiahao.base_common.interfaceing.OnCommonDialogListener;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.network.interceptors.HiloException;
import com.qiahao.base_common.ui.dialog.TipDialog;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.ShapeUtil;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.base_common.wedgit.shineText.NickTextView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.HiloBaseBindingActivity;
import com.qiahao.nextvideo.data.model.DealerDetailBean;
import com.qiahao.nextvideo.data.model.DealerDiamondConfig;
import com.qiahao.nextvideo.databinding.ActivitySecondTransferBinding;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 32\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00013B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010-\u001a\u00020\u0017H\u0014J\b\u0010.\u001a\u00020\u000bH\u0016J\b\u0010/\u001a\u00020\u000bH\u0002J\b\u00100\u001a\u00020\u000bH\u0002J \u00101\u001a\u00020\u000b2\u0016\u00102\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u001cj\b\u0012\u0004\u0012\u00020\u0007`\u001dH\u0002R7\u0010\u0005\u001a\u001f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR*\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u001cj\b\u0012\u0004\u0012\u00020\u0007`\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001b\u0010\"\u001a\u00020#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b$\u0010%R\u001b\u0010(\u001a\u00020)8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010'\u001a\u0004\b*\u0010+¨\u00064"}, d2 = {"Lcom/qiahao/nextvideo/ui/transfer/SecondTransferActivity;", "Lcom/qiahao/nextvideo/app/base/HiloBaseBindingActivity;", "Lcom/qiahao/nextvideo/databinding/ActivitySecondTransferBinding;", "<init>", "()V", "mListener", "Lkotlin/Function1;", "Lcom/qiahao/nextvideo/data/model/DealerDiamondConfig;", "Lkotlin/ParameterName;", "name", "data", "", "getMListener", "()Lkotlin/jvm/functions/Function1;", "setMListener", "(Lkotlin/jvm/functions/Function1;)V", "mUser", "Lcom/qiahao/base_common/model/common/User;", "getMUser", "()Lcom/qiahao/base_common/model/common/User;", "setMUser", "(Lcom/qiahao/base_common/model/common/User;)V", "mType", "", "getMType", "()I", "setMType", "(I)V", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getData", "()Ljava/util/ArrayList;", "setData", "(Ljava/util/ArrayList;)V", "mAdapter", "Lcom/qiahao/nextvideo/ui/transfer/TransferFragmentAdapter;", "getMAdapter", "()Lcom/qiahao/nextvideo/ui/transfer/TransferFragmentAdapter;", "mAdapter$delegate", "Lkotlin/Lazy;", "mViewModel", "Lcom/qiahao/nextvideo/ui/transfer/SecondViewModel;", "getMViewModel", "()Lcom/qiahao/nextvideo/ui/transfer/SecondViewModel;", "mViewModel$delegate", "getLayoutResId", "onInitialize", "initData", "initView", "setListData", "list", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSecondTransferActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SecondTransferActivity.kt\ncom/qiahao/nextvideo/ui/transfer/SecondTransferActivity\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,167:1\n61#2,9:168\n61#2,9:177\n1#3:186\n*S KotlinDebug\n*F\n+ 1 SecondTransferActivity.kt\ncom/qiahao/nextvideo/ui/transfer/SecondTransferActivity\n*L\n102#1:168,9\n130#1:177,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class SecondTransferActivity extends HiloBaseBindingActivity<ActivitySecondTransferBinding> {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String USER_INFO = "USER_INFO";

    @Nullable
    private Function1<? super DealerDiamondConfig, Unit> mListener;
    private int mType;

    @Nullable
    private User mUser;

    @NotNull
    private ArrayList<DealerDiamondConfig> data = new ArrayList<>();

    /* renamed from: mAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.transfer.x
        public final Object invoke() {
            TransferFragmentAdapter mAdapter_delegate$lambda$0;
            mAdapter_delegate$lambda$0 = SecondTransferActivity.mAdapter_delegate$lambda$0();
            return mAdapter_delegate$lambda$0;
        }
    });

    /* renamed from: mViewModel$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mViewModel = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.transfer.y
        public final Object invoke() {
            SecondViewModel mViewModel_delegate$lambda$1;
            mViewModel_delegate$lambda$1 = SecondTransferActivity.mViewModel_delegate$lambda$1(SecondTransferActivity.this);
            return mViewModel_delegate$lambda$1;
        }
    });

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/qiahao/nextvideo/ui/transfer/SecondTransferActivity$Companion;", "", "<init>", "()V", "USER_INFO", "", "startActivity", "", "context", "Landroid/content/Context;", "user", "Lcom/qiahao/base_common/model/common/User;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void startActivity(@NotNull Context context, @NotNull User user) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(user, "user");
            Intent intent = new Intent(context, (Class<?>) SecondTransferActivity.class);
            intent.putExtra("USER_INFO", (Parcelable) user);
            context.startActivity(intent);
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TransferFragmentAdapter getMAdapter() {
        return (TransferFragmentAdapter) this.mAdapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SecondViewModel getMViewModel() {
        return (SecondViewModel) this.mViewModel.getValue();
    }

    private final void initData() {
        getMViewModel().getPromote().observe(this, new SecondTransferActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.transfer.s
            public final Object invoke(Object obj) {
                Unit initData$lambda$3;
                initData$lambda$3 = SecondTransferActivity.initData$lambda$3(SecondTransferActivity.this, (DealerDetailBean) obj);
                return initData$lambda$3;
            }
        }));
        getMViewModel().getMSuccess().observe(this, new SecondTransferActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.transfer.t
            public final Object invoke(Object obj) {
                Unit initData$lambda$4;
                initData$lambda$4 = SecondTransferActivity.initData$lambda$4(SecondTransferActivity.this, (Pair) obj);
                return initData$lambda$4;
            }
        }));
        getMViewModel().getMException().observe(this, new SecondTransferActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.transfer.u
            public final Object invoke(Object obj) {
                Unit initData$lambda$5;
                initData$lambda$5 = SecondTransferActivity.initData$lambda$5(SecondTransferActivity.this, (Pair) obj);
                return initData$lambda$5;
            }
        }));
        getMViewModel().m٩٢getSecondDetail();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$3(SecondTransferActivity secondTransferActivity, DealerDetailBean dealerDetailBean) {
        ArrayList<DealerDiamondConfig> config;
        if (dealerDetailBean != null && (config = dealerDetailBean.getConfig()) != null) {
            secondTransferActivity.setListData(config);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit initData$lambda$4(SecondTransferActivity secondTransferActivity, Pair pair) {
        Toast normal$default;
        if (Intrinsics.areEqual((String) pair.getFirst(), SecondViewModel.SECOND_SHIFT) && (normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, secondTransferActivity, ResourcesKtxKt.getStringById(secondTransferActivity, 2131954177), false, 4, (Object) null)) != null) {
            normal$default.show();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit initData$lambda$5(SecondTransferActivity secondTransferActivity, Pair pair) {
        if (Intrinsics.areEqual((String) pair.getFirst(), SecondViewModel.SECOND_SHIFT) && (pair.getSecond() instanceof HiloException)) {
            Object second = pair.getSecond();
            Intrinsics.checkNotNull(second, "null cannot be cast to non-null type com.qiahao.base_common.network.interceptors.HiloException");
            HiloToasty.Companion companion = HiloToasty.Companion;
            String errorMessage = ((HiloException) second).getErrorMessage();
            if (errorMessage == null) {
                errorMessage = ResourcesKtxKt.getStringById(secondTransferActivity, 2131952667);
            }
            Toast normal$default = HiloToasty.Companion.normal$default(companion, secondTransferActivity, errorMessage, false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initView() {
        String str;
        String str2;
        String code;
        this.mUser = getIntent().getParcelableExtra("USER_INFO");
        View view = ((ActivitySecondTransferBinding) getBinding()).bar;
        Intrinsics.checkNotNullExpressionValue(view, "bar");
        getStatusBarTopOrBottom(view, new Function2() { // from class: com.qiahao.nextvideo.ui.transfer.v
            public final Object invoke(Object obj, Object obj2) {
                Unit initView$lambda$6;
                initView$lambda$6 = SecondTransferActivity.initView$lambda$6(SecondTransferActivity.this, ((Integer) obj).intValue(), ((Integer) obj2).intValue());
                return initView$lambda$6;
            }
        });
        setStatusBarIconColor(false);
        final AppCompatImageView appCompatImageView = ((ActivitySecondTransferBinding) getBinding()).backImageView;
        final long j = 800;
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.transfer.SecondTransferActivity$initView$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(appCompatImageView) > j || (appCompatImageView instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(appCompatImageView, currentTimeMillis);
                    AppCompatImageView appCompatImageView2 = appCompatImageView;
                    this.finish();
                }
            }
        });
        NickTextView nickTextView = ((ActivitySecondTransferBinding) getBinding()).nickName;
        User user = this.mUser;
        String str3 = "";
        if (user == null || (str = user.getNick()) == null) {
            str = "";
        }
        nickTextView.setText(str);
        TextView textView = ((ActivitySecondTransferBinding) getBinding()).userId;
        String stringById = ResourcesKtxKt.getStringById(this, 2131953102);
        User user2 = this.mUser;
        if (user2 != null && (code = user2.getCode()) != null) {
            str3 = code;
        }
        String format = String.format(stringById, Arrays.copyOf(new Object[]{str3}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        textView.setText(format);
        QMUIRadiusImageView qMUIRadiusImageView = ((ActivitySecondTransferBinding) getBinding()).avatar;
        Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView, "avatar");
        User user3 = this.mUser;
        if (user3 != null) {
            str2 = user3.getAvatar();
        } else {
            str2 = null;
        }
        ImageKtxKt.loadImage$default(qMUIRadiusImageView, str2, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131231655, (c5.g) null, 49150, (Object) null);
        getMAdapter().setMTransferType(this.mType);
        ((ActivitySecondTransferBinding) getBinding()).recyclerView.setAdapter(getMAdapter());
        ((ActivitySecondTransferBinding) getBinding()).userBg.setBackground(ShapeUtil.createShape$default(ShapeUtil.INSTANCE, "#ffffff", "#ffffff", 5, (GradientDrawable.Orientation) null, 8, (Object) null));
        ((ActivitySecondTransferBinding) getBinding()).recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: com.qiahao.nextvideo.ui.transfer.SecondTransferActivity$initView$3
            public void getItemOffsets(Rect outRect, View view2, RecyclerView parent, RecyclerView.State state) {
                Intrinsics.checkNotNullParameter(outRect, "outRect");
                Intrinsics.checkNotNullParameter(view2, "view");
                Intrinsics.checkNotNullParameter(parent, "parent");
                Intrinsics.checkNotNullParameter(state, "state");
                super.getItemOffsets(outRect, view2, parent, state);
                outRect.top = UiKtxKt.toPX(11);
                outRect.left = UiKtxKt.toPX(7);
                outRect.right = UiKtxKt.toPX(7);
            }
        });
        getMAdapter().setOnItemClickListener(new OnItemClickListener() { // from class: com.qiahao.nextvideo.ui.transfer.w
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view2, int i) {
                SecondTransferActivity.initView$lambda$8(SecondTransferActivity.this, baseQuickAdapter, view2, i);
            }
        });
        final TextView textView2 = ((ActivitySecondTransferBinding) getBinding()).transferSendButton;
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.transfer.SecondTransferActivity$initView$$inlined$singleClick$default$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                TransferFragmentAdapter mAdapter;
                TransferFragmentAdapter mAdapter2;
                String str4;
                String code2;
                String l;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView2) > j || (textView2 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(textView2, currentTimeMillis);
                    long j2 = 0;
                    long longValue = ((Number) IStore.DefaultImpls.getValue$default(MMKVStore.INSTANCE, "availDiamond", 0L, (String) null, 4, (Object) null)).longValue();
                    mAdapter = this.getMAdapter();
                    DealerDiamondConfig mSelect = mAdapter.getMSelect();
                    if (mSelect != null) {
                        j2 = mSelect.getDiamond();
                    }
                    if (j2 > longValue) {
                        HiloToasty.Companion companion = HiloToasty.Companion;
                        BaseActivity baseActivity = this;
                        Toast normal$default = HiloToasty.Companion.normal$default(companion, baseActivity, ResourcesKtxKt.getStringById(baseActivity, 2131954009), false, 4, (Object) null);
                        if (normal$default != null) {
                            normal$default.show();
                            return;
                        }
                        return;
                    }
                    TipDialog tipDialog = new TipDialog(this);
                    mAdapter2 = this.getMAdapter();
                    DealerDiamondConfig mSelect2 = mAdapter2.getMSelect();
                    String str5 = "";
                    if (mSelect2 == null || (l = Long.valueOf(mSelect2.getDiamond()).toString()) == null) {
                        str4 = "";
                    } else {
                        str4 = l;
                    }
                    String stringById2 = ResourcesKtxKt.getStringById(tipDialog, 2131954013);
                    User mUser = this.getMUser();
                    if (mUser != null && (code2 = mUser.getCode()) != null) {
                        str5 = code2;
                    }
                    String format2 = String.format(stringById2, Arrays.copyOf(new Object[]{str4, str5}, 2));
                    Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
                    SpannableTextBuilder.changeTextColor$default(new SpannableTextBuilder(tipDialog.getTipText()), format2, str4, Integer.valueOf(Color.parseColor("#FFA800")), (Integer) null, 8, (Object) null).apply();
                    final SecondTransferActivity secondTransferActivity = this;
                    tipDialog.setDialogListener(new OnCommonDialogListener() { // from class: com.qiahao.nextvideo.ui.transfer.SecondTransferActivity$initView$5$2
                        public void cancel() {
                            OnCommonDialogListener.DefaultImpls.cancel(this);
                        }

                        public void confirm() {
                            SecondViewModel mViewModel;
                            String str6;
                            TransferFragmentAdapter mAdapter3;
                            int i;
                            mViewModel = SecondTransferActivity.this.getMViewModel();
                            User mUser2 = SecondTransferActivity.this.getMUser();
                            if (mUser2 == null || (str6 = mUser2.getExternalId()) == null) {
                                str6 = "";
                            }
                            mAdapter3 = SecondTransferActivity.this.getMAdapter();
                            DealerDiamondConfig mSelect3 = mAdapter3.getMSelect();
                            if (mSelect3 != null) {
                                i = mSelect3.getId();
                            } else {
                                i = 0;
                            }
                            mViewModel.secondShift(str6, i);
                        }
                    }).show();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initView$lambda$6(SecondTransferActivity secondTransferActivity, int i, int i2) {
        secondTransferActivity.getBinding().bar.setLayoutParams(new LinearLayoutCompat.a(-2, i));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$8(SecondTransferActivity secondTransferActivity, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        DealerDiamondConfig dealerDiamondConfig = (DealerDiamondConfig) secondTransferActivity.getMAdapter().getData().get(i);
        secondTransferActivity.getMAdapter().setMSelect(dealerDiamondConfig);
        Function1<? super DealerDiamondConfig, Unit> function1 = secondTransferActivity.mListener;
        if (function1 != null) {
            function1.invoke(dealerDiamondConfig);
        }
        secondTransferActivity.getMAdapter().notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TransferFragmentAdapter mAdapter_delegate$lambda$0() {
        return new TransferFragmentAdapter();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SecondViewModel mViewModel_delegate$lambda$1(SecondTransferActivity secondTransferActivity) {
        return new ViewModelProvider(secondTransferActivity).get(SecondViewModel.class);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void setListData(ArrayList<DealerDiamondConfig> list) {
        if (list.size() > 0 && getMAdapter().getMSelect() == null) {
            getMAdapter().setMSelect(list.get(0));
            Function1<? super DealerDiamondConfig, Unit> function1 = this.mListener;
            if (function1 != null) {
                DealerDiamondConfig dealerDiamondConfig = list.get(0);
                Intrinsics.checkNotNullExpressionValue(dealerDiamondConfig, "get(...)");
                function1.invoke(dealerDiamondConfig);
            }
        }
        this.data = list;
        getMAdapter().setList(this.data);
        ((ActivitySecondTransferBinding) getBinding()).recyclerView.postDelayed(new Runnable() { // from class: com.qiahao.nextvideo.ui.transfer.r
            @Override // java.lang.Runnable
            public final void run() {
                SecondTransferActivity.setListData$lambda$11(SecondTransferActivity.this);
            }
        }, 500L);
        ((ActivitySecondTransferBinding) getBinding()).transferSendButton.setBackground(androidx.core.content.a.getDrawable(this, R.drawable.bg_btn_theme_radius22));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setListData$lambda$11(SecondTransferActivity secondTransferActivity) {
        secondTransferActivity.getMAdapter().notifyDataSetChanged();
    }

    @NotNull
    public final ArrayList<DealerDiamondConfig> getData() {
        return this.data;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public int getLayoutResId() {
        return R.layout.activity_second_transfer;
    }

    @Nullable
    public final Function1<DealerDiamondConfig, Unit> getMListener() {
        return this.mListener;
    }

    public final int getMType() {
        return this.mType;
    }

    @Nullable
    public final User getMUser() {
        return this.mUser;
    }

    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onInitialize() {
        super.onInitialize();
        initView();
        initData();
    }

    public final void setData(@NotNull ArrayList<DealerDiamondConfig> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.data = arrayList;
    }

    public final void setMListener(@Nullable Function1<? super DealerDiamondConfig, Unit> function1) {
        this.mListener = function1;
    }

    public final void setMType(int i) {
        this.mType = i;
    }

    public final void setMUser(@Nullable User user) {
        this.mUser = user;
    }
}
