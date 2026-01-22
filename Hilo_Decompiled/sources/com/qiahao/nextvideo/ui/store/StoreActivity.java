package com.qiahao.nextvideo.ui.store;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;
import com.opensource.svgaplayer.SVGADrawable;
import com.opensource.svgaplayer.SVGAParser;
import com.opensource.svgaplayer.SVGAVideoEntity;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.adapter.CommonFragmentStatePagerAdapter;
import com.qiahao.base_common.common.BaseActivity;
import com.qiahao.base_common.interfaceing.OnCommonDialogListener;
import com.qiahao.base_common.model.StoreBean;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.model.eventBus.StoreEvent;
import com.qiahao.base_common.network.interceptors.HiloException;
import com.qiahao.base_common.ui.dialog.TipDialog;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.ShapeUtil;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.HiloBaseBindingActivity;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.store.StoreCarromData;
import com.qiahao.nextvideo.databinding.ActivityStoreBinding;
import com.qiahao.nextvideo.ui.cp.SearchUserActivity;
import com.qiahao.nextvideo.ui.reusable.uimodels.ImageUIModel;
import com.qiahao.nextvideo.ui.store.StoreListener;
import com.qiahao.nextvideo.ui.svip.SvipActivity;
import com.qiahao.nextvideo.ui.wallet.WalletActivity;
import com.qiahao.nextvideo.utilities.ViewUtilitiesKt;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u001b\u0018\u0000 /2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001/B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010#\u001a\u00020\u000eH\u0014J\b\u0010$\u001a\u00020%H\u0016J\b\u0010&\u001a\u00020%H\u0002J\b\u0010'\u001a\u00020%H\u0002J\u0010\u0010(\u001a\u00020%2\u0006\u0010)\u001a\u00020\u000eH\u0003J\b\u0010*\u001a\u00020+H\u0002J\u0010\u0010,\u001a\u00020%2\u0006\u0010-\u001a\u00020.H\u0007R\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0010\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001cR\u001b\u0010\u001d\u001a\u00020\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b\u001f\u0010 ¨\u00060"}, d2 = {"Lcom/qiahao/nextvideo/ui/store/StoreActivity;", "Lcom/qiahao/nextvideo/app/base/HiloBaseBindingActivity;", "Lcom/qiahao/nextvideo/databinding/ActivityStoreBinding;", "<init>", "()V", "mFragmentList", "Ljava/util/ArrayList;", "Landroidx/fragment/app/Fragment;", "Lkotlin/collections/ArrayList;", "currentStoreBean", "Lcom/qiahao/base_common/model/StoreBean;", "curretCarromData", "Lcom/qiahao/nextvideo/data/store/StoreCarromData;", "currentStoreType", "", "mPosition", "mCurNum", "mMaxNum", "mTypeList", "", "", "getMTypeList", "()[Ljava/lang/String;", "setMTypeList", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "mListener", "com/qiahao/nextvideo/ui/store/StoreActivity$mListener$1", "Lcom/qiahao/nextvideo/ui/store/StoreActivity$mListener$1;", "viewModel", "Lcom/qiahao/nextvideo/ui/store/StoreViewModel;", "getViewModel", "()Lcom/qiahao/nextvideo/ui/store/StoreViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getLayoutResId", "onInitialize", "", "initData", "initView", "selectPage", "position", "checkMoney", "", "onStoreEvent", "event", "Lcom/qiahao/base_common/model/eventBus/StoreEvent;", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nStoreActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StoreActivity.kt\ncom/qiahao/nextvideo/ui/store/StoreActivity\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n*L\n1#1,410:1\n61#2,9:411\n61#2,9:420\n61#2,9:429\n61#2,9:438\n61#2,9:447\n*S KotlinDebug\n*F\n+ 1 StoreActivity.kt\ncom/qiahao/nextvideo/ui/store/StoreActivity\n*L\n189#1:411,9\n192#1:420,9\n195#1:429,9\n213#1:438,9\n223#1:447,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class StoreActivity extends HiloBaseBindingActivity<ActivityStoreBinding> {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String STORE_POSITION = "position";

    @Nullable
    private StoreBean currentStoreBean;
    private int currentStoreType;

    @Nullable
    private StoreCarromData curretCarromData;
    private int mCurNum;
    private int mMaxNum;
    private int mPosition;

    @NotNull
    private ArrayList<Fragment> mFragmentList = new ArrayList<>();

    @NotNull
    private String[] mTypeList = {ResourcesKtxKt.getStringById(this, 2131953047), ResourcesKtxKt.getStringById(this, 2131953421), ResourcesKtxKt.getStringById(this, 2131952188), ResourcesKtxKt.getStringById(this, 2131953896)};

    @NotNull
    private final StoreActivity$mListener$1 mListener = new StoreListener() { // from class: com.qiahao.nextvideo.ui.store.StoreActivity$mListener$1
        @Override // com.qiahao.nextvideo.ui.store.StoreListener
        @SuppressLint({"SetTextI18n"})
        public void headWearItemClick(StoreBean storeBean) {
            ActivityStoreBinding binding;
            ActivityStoreBinding binding2;
            ActivityStoreBinding binding3;
            ActivityStoreBinding binding4;
            ActivityStoreBinding binding5;
            ActivityStoreBinding binding6;
            ActivityStoreBinding binding7;
            ActivityStoreBinding binding8;
            Intrinsics.checkNotNullParameter(storeBean, "storeBean");
            StoreListener.DefaultImpls.headWearItemClick(this, storeBean);
            if (!StoreActivity.this.isFinishing() && !StoreActivity.this.isDestroyed()) {
                binding = StoreActivity.this.getBinding();
                if (binding.viewPager.getCurrentItem() == 0) {
                    StoreActivity.this.currentStoreBean = storeBean;
                    String effectUrl = storeBean.getEffectUrl();
                    if (effectUrl != null && effectUrl.length() > 0) {
                        binding7 = StoreActivity.this.getBinding();
                        binding7.imgAvatarHead.setVisibility(4);
                        binding8 = StoreActivity.this.getBinding();
                        binding8.svgaAvatarHead.setVisibility(0);
                        SVGAParser shareParser = SVGAParser.Companion.shareParser();
                        URL url = new URL(storeBean.getEffectUrl() + "?raw=true");
                        final StoreActivity storeActivity = StoreActivity.this;
                        shareParser.decodeFromURL(url, new SVGAParser.ParseCompletion() { // from class: com.qiahao.nextvideo.ui.store.StoreActivity$mListener$1$headWearItemClick$1
                            public void onComplete(SVGAVideoEntity videoItem) {
                                ActivityStoreBinding binding9;
                                ActivityStoreBinding binding10;
                                ActivityStoreBinding binding11;
                                Intrinsics.checkNotNullParameter(videoItem, "videoItem");
                                binding9 = StoreActivity.this.getBinding();
                                binding9.svgaAvatarHead.stopAnimation(true);
                                binding10 = StoreActivity.this.getBinding();
                                binding10.svgaAvatarHead.setImageDrawable(new SVGADrawable(videoItem));
                                binding11 = StoreActivity.this.getBinding();
                                binding11.svgaAvatarHead.startAnimation();
                            }

                            public void onError() {
                            }
                        });
                    } else {
                        String picUrl = storeBean.getPicUrl();
                        if (picUrl != null && picUrl.length() > 0) {
                            binding2 = StoreActivity.this.getBinding();
                            binding2.svgaAvatarHead.setVisibility(4);
                            binding3 = StoreActivity.this.getBinding();
                            binding3.imgAvatarHead.setVisibility(0);
                            binding4 = StoreActivity.this.getBinding();
                            ImageView imageView = binding4.imgAvatarHead;
                            Intrinsics.checkNotNullExpressionValue(imageView, "imgAvatarHead");
                            ImageUIModel displayImage$default = ImageUIModel.Companion.displayImage$default(ImageUIModel.INSTANCE, storeBean.getPicUrl(), null, 2, null);
                            displayImage$default.setPlaceholder(null);
                            ViewUtilitiesKt.bind(imageView, displayImage$default);
                        }
                    }
                    binding5 = StoreActivity.this.getBinding();
                    binding5.diamondIcon.setVisibility(0);
                    binding6 = StoreActivity.this.getBinding();
                    binding6.diamondDay.setText(storeBean.getDiamondNum() + "/" + storeBean.getDays() + StoreActivity.this.getString(2131952500));
                }
            }
        }

        @Override // com.qiahao.nextvideo.ui.store.StoreListener
        @SuppressLint({"SetTextI18n"})
        public void mountsItemClick(StoreBean storeBean) {
            ActivityStoreBinding binding;
            ActivityStoreBinding binding2;
            ActivityStoreBinding binding3;
            Intrinsics.checkNotNullParameter(storeBean, "storeBean");
            StoreListener.DefaultImpls.mountsItemClick(this, storeBean);
            binding = StoreActivity.this.getBinding();
            if (binding.viewPager.getCurrentItem() == 1) {
                StoreActivity.this.currentStoreBean = storeBean;
                binding2 = StoreActivity.this.getBinding();
                binding2.diamondIcon.setVisibility(0);
                binding3 = StoreActivity.this.getBinding();
                binding3.diamondDay.setText(storeBean.getDiamondNum() + "/" + storeBean.getDays() + StoreActivity.this.getString(2131952500));
            }
        }

        @Override // com.qiahao.nextvideo.ui.store.StoreListener
        @SuppressLint({"SetTextI18n"})
        public void relationCardClick(StoreBean storeBean, int curNum, int maxNum) {
            ActivityStoreBinding binding;
            ActivityStoreBinding binding2;
            ActivityStoreBinding binding3;
            int i;
            int i2;
            ActivityStoreBinding binding4;
            int i3;
            int i4;
            ActivityStoreBinding binding5;
            int i5;
            int i6;
            ActivityStoreBinding binding6;
            int i7;
            int i8;
            Intrinsics.checkNotNullParameter(storeBean, "storeBean");
            StoreListener.DefaultImpls.relationCardClick(this, storeBean, curNum, maxNum);
            binding = StoreActivity.this.getBinding();
            if (binding.viewPager.getCurrentItem() == 3) {
                StoreActivity.this.mCurNum = curNum;
                StoreActivity.this.mMaxNum = maxNum;
                StoreActivity.this.currentStoreBean = storeBean;
                binding2 = StoreActivity.this.getBinding();
                binding2.diamondIcon.setVisibility(8);
                Integer relationType = storeBean.getRelationType();
                if (relationType != null && relationType.intValue() == 1) {
                    binding6 = StoreActivity.this.getBinding();
                    TextView textView = binding6.diamondDay;
                    String stringById = ResourcesKtxKt.getStringById(this, 2131953132);
                    i7 = StoreActivity.this.mCurNum;
                    i8 = StoreActivity.this.mMaxNum;
                    textView.setText(stringById + "(" + i7 + "/" + i8 + ")");
                    return;
                }
                if (relationType != null && relationType.intValue() == 2) {
                    binding5 = StoreActivity.this.getBinding();
                    TextView textView2 = binding5.diamondDay;
                    String stringById2 = ResourcesKtxKt.getStringById(this, 2131953134);
                    i5 = StoreActivity.this.mCurNum;
                    i6 = StoreActivity.this.mMaxNum;
                    textView2.setText(stringById2 + "(" + i5 + "/" + i6 + ")");
                    return;
                }
                if (relationType != null && relationType.intValue() == 3) {
                    binding4 = StoreActivity.this.getBinding();
                    TextView textView3 = binding4.diamondDay;
                    String stringById3 = ResourcesKtxKt.getStringById(this, 2131953131);
                    i3 = StoreActivity.this.mCurNum;
                    i4 = StoreActivity.this.mMaxNum;
                    textView3.setText(stringById3 + "(" + i3 + "/" + i4 + ")");
                    return;
                }
                if (relationType != null && relationType.intValue() == 4) {
                    binding3 = StoreActivity.this.getBinding();
                    TextView textView4 = binding3.diamondDay;
                    String stringById4 = ResourcesKtxKt.getStringById(this, 2131953133);
                    i = StoreActivity.this.mCurNum;
                    i2 = StoreActivity.this.mMaxNum;
                    textView4.setText(stringById4 + "(" + i + "/" + i2 + ")");
                }
            }
        }
    };

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.store.a2
        public final Object invoke() {
            StoreViewModel viewModel_delegate$lambda$0;
            viewModel_delegate$lambda$0 = StoreActivity.viewModel_delegate$lambda$0(StoreActivity.this);
            return viewModel_delegate$lambda$0;
        }
    });

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/qiahao/nextvideo/ui/store/StoreActivity$Companion;", "", "<init>", "()V", "STORE_POSITION", "", "start", "", "context", "Landroid/content/Context;", "position", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void start$default(Companion companion, Context context, int i, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                i = 0;
            }
            companion.start(context, i);
        }

        @JvmStatic
        public final void start(@NotNull Context context, int position) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent(context, (Class<?>) StoreActivity.class);
            intent.putExtra("position", position);
            context.startActivity(intent);
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final boolean checkMoney() {
        double d;
        long j;
        Long diamondNum;
        User user = UserStore.INSTANCE.getShared().getUser();
        if (user != null) {
            d = user.getDiamondNum();
        } else {
            d = 0.0d;
        }
        StoreBean storeBean = this.currentStoreBean;
        if (storeBean != null && (diamondNum = storeBean.getDiamondNum()) != null) {
            j = diamondNum.longValue();
        } else {
            j = 0;
        }
        if (d >= j) {
            return true;
        }
        new TipDialog(this).setTipContent(ResourcesKtxKt.getStringById(this, 2131953126)).setConfirmContent(ResourcesKtxKt.getStringById(this, 2131953850)).setDialogListener(new OnCommonDialogListener() { // from class: com.qiahao.nextvideo.ui.store.StoreActivity$checkMoney$1
            public void cancel() {
                OnCommonDialogListener.DefaultImpls.cancel(this);
            }

            public void confirm() {
                WalletActivity.INSTANCE.start(StoreActivity.this);
            }
        }).show();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StoreViewModel getViewModel() {
        return (StoreViewModel) this.viewModel.getValue();
    }

    private final void initData() {
        getViewModel().getMSuccess().observe(this, new StoreActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.store.y1
            public final Object invoke(Object obj) {
                Unit initData$lambda$1;
                initData$lambda$1 = StoreActivity.initData$lambda$1(StoreActivity.this, (Pair) obj);
                return initData$lambda$1;
            }
        }));
        getViewModel().getMException().observe(this, new StoreActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.store.z1
            public final Object invoke(Object obj) {
                Unit initData$lambda$2;
                initData$lambda$2 = StoreActivity.initData$lambda$2(StoreActivity.this, (Pair) obj);
                return initData$lambda$2;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit initData$lambda$1(StoreActivity storeActivity, Pair pair) {
        Toast normal$default;
        if (Intrinsics.areEqual((String) pair.getFirst(), StoreViewModel.BUY_STORE) && (normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, storeActivity, ResourcesKtxKt.getStringById(storeActivity, 2131954177), false, 4, (Object) null)) != null) {
            normal$default.show();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit initData$lambda$2(StoreActivity storeActivity, Pair pair) {
        if (Intrinsics.areEqual((String) pair.getFirst(), StoreViewModel.BUY_STORE) && (pair.getSecond() instanceof HiloException)) {
            Object second = pair.getSecond();
            Intrinsics.checkNotNull(second, "null cannot be cast to non-null type com.qiahao.base_common.network.interceptors.HiloException");
            HiloToasty.Companion companion = HiloToasty.Companion;
            String errorMessage = ((HiloException) second).getErrorMessage();
            if (errorMessage == null) {
                errorMessage = ResourcesKtxKt.getStringById(storeActivity, 2131952667);
            }
            Toast normal$default = HiloToasty.Companion.normal$default(companion, storeActivity, errorMessage, false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initView() {
        String str;
        ConstraintLayout constraintLayout = ((ActivityStoreBinding) getBinding()).baseRoot;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "baseRoot");
        getStatusBarTopOrBottom(constraintLayout, new Function2() { // from class: com.qiahao.nextvideo.ui.store.x1
            public final Object invoke(Object obj, Object obj2) {
                Unit initView$lambda$3;
                initView$lambda$3 = StoreActivity.initView$lambda$3(StoreActivity.this, ((Integer) obj).intValue(), ((Integer) obj2).intValue());
                return initView$lambda$3;
            }
        });
        setStatusBarIconColor(false);
        this.mPosition = getIntent().getIntExtra("position", 0);
        AppCompatImageView appCompatImageView = ((ActivityStoreBinding) getBinding()).userAvatar;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "userAvatar");
        User user = UserStore.INSTANCE.getShared().getUser();
        if (user == null || (str = user.getAvatar()) == null) {
            str = "";
        }
        ImageKtxKt.loadImage$default(appCompatImageView, str, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131231655, (c5.g) null, 49150, (Object) null);
        ((ActivityStoreBinding) getBinding()).relationSend.setBackground(ShapeUtil.INSTANCE.createShape("#ED74F7", "#8430FF", 32, GradientDrawable.Orientation.LEFT_RIGHT));
        final AppCompatImageView appCompatImageView2 = ((ActivityStoreBinding) getBinding()).backImageView;
        final long j = 800;
        appCompatImageView2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.store.StoreActivity$initView$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(appCompatImageView2) > j || (appCompatImageView2 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(appCompatImageView2, currentTimeMillis);
                    AppCompatImageView appCompatImageView3 = appCompatImageView2;
                    this.finish();
                }
            }
        });
        final AppCompatTextView appCompatTextView = ((ActivityStoreBinding) getBinding()).myBag;
        appCompatTextView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.store.StoreActivity$initView$$inlined$singleClick$default$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(appCompatTextView) > j || (appCompatTextView instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(appCompatTextView, currentTimeMillis);
                    AppCompatTextView appCompatTextView2 = appCompatTextView;
                    MyBagActivity.INSTANCE.start(this);
                }
            }
        });
        final TextView textView = ((ActivityStoreBinding) getBinding()).relationSend;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.store.StoreActivity$initView$$inlined$singleClick$default$3
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v7, types: [android.content.Context, com.qiahao.nextvideo.ui.store.StoreActivity] */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ActivityStoreBinding binding;
                int i;
                int i2;
                boolean checkMoney;
                StoreBean storeBean;
                StoreBean storeBean2;
                StoreBean storeBean3;
                Integer relationType;
                int i3;
                StoreCarromData storeCarromData;
                long j2;
                Long svipLevel;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView) > j || (textView instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(textView, currentTimeMillis);
                    binding = this.getBinding();
                    if (binding.viewPager.getCurrentItem() != 2) {
                        i = this.mCurNum;
                        i2 = this.mMaxNum;
                        if (i < i2) {
                            checkMoney = this.checkMoney();
                            if (checkMoney) {
                                storeBean = this.currentStoreBean;
                                if (storeBean != null) {
                                    i3 = this.currentStoreType;
                                    storeBean.setType(i3);
                                }
                                storeBean2 = this.currentStoreBean;
                                if (storeBean2 != null && (relationType = storeBean2.getRelationType()) != null && relationType.intValue() == 1) {
                                    SearchUserActivity.Companion.startActivity$default(SearchUserActivity.Companion, this, SearchUserActivity.BIND_CP, null, 4, null);
                                    return;
                                }
                                SearchUserActivity.Companion companion = SearchUserActivity.Companion;
                                BaseActivity baseActivity = this;
                                com.google.gson.d dVar = new com.google.gson.d();
                                storeBean3 = this.currentStoreBean;
                                companion.startActivity(baseActivity, SearchUserActivity.BIND_RELATION, dVar.s(storeBean3));
                                return;
                            }
                            return;
                        }
                        HiloToasty.Companion companion2 = HiloToasty.Companion;
                        BaseActivity baseActivity2 = this;
                        Toast normal$default = HiloToasty.Companion.normal$default(companion2, baseActivity2, ResourcesKtxKt.getStringById(baseActivity2, 2131954372), false, 4, (Object) null);
                        if (normal$default != null) {
                            normal$default.show();
                            return;
                        }
                        return;
                    }
                    SvipActivity.Companion companion3 = SvipActivity.Companion;
                    ?? r0 = this;
                    storeCarromData = ((StoreActivity) r0).curretCarromData;
                    if (storeCarromData != null && (svipLevel = storeCarromData.getSvipLevel()) != null) {
                        j2 = svipLevel.longValue();
                    } else {
                        j2 = -1;
                    }
                    companion3.start(r0, ((int) j2) - 1);
                }
            }
        });
        final TextView textView2 = ((ActivityStoreBinding) getBinding()).textSend;
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.store.StoreActivity$initView$$inlined$singleClick$default$4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                boolean checkMoney;
                StoreBean storeBean;
                StoreBean storeBean2;
                int i;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView2) > j || (textView2 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(textView2, currentTimeMillis);
                    checkMoney = this.checkMoney();
                    if (checkMoney) {
                        storeBean = this.currentStoreBean;
                        if (storeBean != null) {
                            i = this.currentStoreType;
                            storeBean.setType(i);
                        }
                        SearchUserActivity.Companion companion = SearchUserActivity.Companion;
                        BaseActivity baseActivity = this;
                        com.google.gson.d dVar = new com.google.gson.d();
                        storeBean2 = this.currentStoreBean;
                        companion.startActivity(baseActivity, "SEND_STORE", dVar.s(storeBean2));
                    }
                }
            }
        });
        final TextView textView3 = ((ActivityStoreBinding) getBinding()).textBay;
        textView3.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.store.StoreActivity$initView$$inlined$singleClick$default$5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                boolean checkMoney;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView3) > j || (textView3 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(textView3, currentTimeMillis);
                    checkMoney = this.checkMoney();
                    if (checkMoney) {
                        TipDialog tipContent = new TipDialog(this).setTipContent(ResourcesKtxKt.getStringById(this, 2131952341));
                        final StoreActivity storeActivity = this;
                        tipContent.setDialogListener(new OnCommonDialogListener() { // from class: com.qiahao.nextvideo.ui.store.StoreActivity$initView$6$1
                            public void cancel() {
                                OnCommonDialogListener.DefaultImpls.cancel(this);
                            }

                            public void confirm() {
                                StoreViewModel viewModel;
                                int i;
                                StoreBean storeBean;
                                long j2;
                                String str2;
                                Long id2;
                                viewModel = StoreActivity.this.getViewModel();
                                i = StoreActivity.this.currentStoreType;
                                storeBean = StoreActivity.this.currentStoreBean;
                                if (storeBean != null && (id2 = storeBean.getId()) != null) {
                                    j2 = id2.longValue();
                                } else {
                                    j2 = 0;
                                }
                                User user2 = UserStore.INSTANCE.getShared().getUser();
                                if (user2 == null || (str2 = user2.getExternalId()) == null) {
                                    str2 = "";
                                }
                                viewModel.sendHeadOrMounts(i, j2, str2);
                            }
                        }).show();
                    }
                }
            }
        });
        if (this.mFragmentList.isEmpty()) {
            Bundle bundle = new Bundle();
            bundle.putInt(StoreFragment.STORE_TYPE, 0);
            Fragment storeFragment = new StoreFragment();
            storeFragment.setArguments(bundle);
            storeFragment.setMListener(this.mListener);
            this.mFragmentList.add(storeFragment);
            Bundle bundle2 = new Bundle();
            bundle2.putInt(StoreFragment.STORE_TYPE, 1);
            Fragment storeFragment2 = new StoreFragment();
            storeFragment2.setArguments(bundle2);
            storeFragment2.setMListener(this.mListener);
            this.mFragmentList.add(storeFragment2);
            this.mFragmentList.add(new CarromStoreFragment());
            Bundle bundle3 = new Bundle();
            bundle3.putInt(StoreFragment.STORE_TYPE, 3);
            Fragment storeFragment3 = new StoreFragment();
            storeFragment3.setArguments(bundle3);
            storeFragment3.setMListener(this.mListener);
            this.mFragmentList.add(storeFragment3);
        }
        ViewPager viewPager = ((ActivityStoreBinding) getBinding()).viewPager;
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        viewPager.setAdapter(new CommonFragmentStatePagerAdapter(supportFragmentManager, this.mFragmentList, (List) null, 4, (DefaultConstructorMarker) null));
        ((ActivityStoreBinding) getBinding()).viewPager.setOffscreenPageLimit(this.mFragmentList.size());
        ((ActivityStoreBinding) getBinding()).tabLayout.l(((ActivityStoreBinding) getBinding()).viewPager, this.mTypeList);
        if (this.mPosition < this.mFragmentList.size()) {
            ((ActivityStoreBinding) getBinding()).tabLayout.setCurrentTab(this.mPosition);
            selectPage(this.mPosition);
        }
        ((ActivityStoreBinding) getBinding()).tabLayout.setOnTabSelectListener(new o6.b() { // from class: com.qiahao.nextvideo.ui.store.StoreActivity$initView$7
            public void onTabReselect(int position) {
            }

            public void onTabSelect(int position) {
                ActivityStoreBinding binding;
                binding = StoreActivity.this.getBinding();
                binding.viewPager.setCurrentItem(position);
                StoreActivity.this.selectPage(position);
            }
        });
        ((ActivityStoreBinding) getBinding()).viewPager.addOnPageChangeListener(new ViewPager.j() { // from class: com.qiahao.nextvideo.ui.store.StoreActivity$initView$8
            public void onPageScrollStateChanged(int state) {
            }

            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            public void onPageSelected(int position) {
                ActivityStoreBinding binding;
                binding = StoreActivity.this.getBinding();
                binding.tabLayout.setCurrentTab(position);
                StoreActivity.this.selectPage(position);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initView$lambda$3(StoreActivity storeActivity, int i, int i2) {
        ViewKtxKt.setMargin(storeActivity.getBinding().toolbar, 0, Integer.valueOf(i), 0, 0);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    @SuppressLint({"SetTextI18n"})
    public final void selectPage(int position) {
        if (position != 0) {
            if (position != 1) {
                if (position != 2) {
                    if (position == 3 && this.mFragmentList.size() >= 3) {
                        this.currentStoreType = 3;
                        StoreFragment storeFragment = this.mFragmentList.get(3);
                        Intrinsics.checkNotNull(storeFragment, "null cannot be cast to non-null type com.qiahao.nextvideo.ui.store.StoreFragment");
                        StoreBean mSelectBean = storeFragment.getMSelectBean();
                        if (mSelectBean != null) {
                            Integer relationType = mSelectBean.getRelationType();
                            if (relationType != null && relationType.intValue() == 1) {
                                ((ActivityStoreBinding) getBinding()).diamondDay.setText(ResourcesKtxKt.getStringById(this, 2131953132) + "(" + this.mCurNum + "/" + this.mMaxNum + ")");
                            } else if (relationType != null && relationType.intValue() == 2) {
                                ((ActivityStoreBinding) getBinding()).diamondDay.setText(ResourcesKtxKt.getStringById(this, 2131953134) + "(" + this.mCurNum + "/" + this.mMaxNum + ")");
                            } else if (relationType != null && relationType.intValue() == 3) {
                                ((ActivityStoreBinding) getBinding()).diamondDay.setText(ResourcesKtxKt.getStringById(this, 2131953131) + "(" + this.mCurNum + "/" + this.mMaxNum + ")");
                            } else if (relationType != null && relationType.intValue() == 4) {
                                ((ActivityStoreBinding) getBinding()).diamondDay.setText(ResourcesKtxKt.getStringById(this, 2131953133) + "(" + this.mCurNum + "/" + this.mMaxNum + ")");
                            }
                            this.currentStoreBean = mSelectBean;
                        }
                        ((ActivityStoreBinding) getBinding()).textBay.setVisibility(8);
                        ((ActivityStoreBinding) getBinding()).textSend.setVisibility(8);
                        ((ActivityStoreBinding) getBinding()).relationSend.setVisibility(0);
                        ((ActivityStoreBinding) getBinding()).relationSend.setText(ResourcesKtxKt.getStringById(this, 2131954022));
                        ((ActivityStoreBinding) getBinding()).diamondIcon.setVisibility(8);
                        return;
                    }
                    return;
                }
                if (this.mFragmentList.size() > 2) {
                    this.currentStoreType = 2;
                    ((ActivityStoreBinding) getBinding()).textBay.setVisibility(8);
                    ((ActivityStoreBinding) getBinding()).textSend.setVisibility(8);
                    ((ActivityStoreBinding) getBinding()).relationSend.setVisibility(0);
                    ((ActivityStoreBinding) getBinding()).relationSend.setText(ResourcesKtxKt.getStringById(this, 2131952243));
                    ((ActivityStoreBinding) getBinding()).diamondIcon.setVisibility(8);
                    return;
                }
                return;
            }
            if (this.mFragmentList.size() > 1) {
                this.currentStoreType = 1;
                StoreFragment storeFragment2 = this.mFragmentList.get(1);
                Intrinsics.checkNotNull(storeFragment2, "null cannot be cast to non-null type com.qiahao.nextvideo.ui.store.StoreFragment");
                StoreBean mSelectBean2 = storeFragment2.getMSelectBean();
                if (mSelectBean2 != null) {
                    ((ActivityStoreBinding) getBinding()).diamondDay.setText(mSelectBean2.getDiamondNum() + "/" + mSelectBean2.getDays() + getString(2131952500));
                    this.currentStoreBean = mSelectBean2;
                }
                ((ActivityStoreBinding) getBinding()).textBay.setVisibility(0);
                ((ActivityStoreBinding) getBinding()).textSend.setVisibility(0);
                ((ActivityStoreBinding) getBinding()).relationSend.setVisibility(8);
                ((ActivityStoreBinding) getBinding()).diamondIcon.setVisibility(0);
                return;
            }
            return;
        }
        if (!this.mFragmentList.isEmpty()) {
            this.currentStoreType = 0;
            StoreFragment storeFragment3 = this.mFragmentList.get(0);
            Intrinsics.checkNotNull(storeFragment3, "null cannot be cast to non-null type com.qiahao.nextvideo.ui.store.StoreFragment");
            StoreBean mSelectBean3 = storeFragment3.getMSelectBean();
            if (mSelectBean3 != null) {
                ((ActivityStoreBinding) getBinding()).diamondDay.setText(mSelectBean3.getDiamondNum() + "/" + mSelectBean3.getDays() + getString(2131952500));
                this.currentStoreBean = mSelectBean3;
            }
            ((ActivityStoreBinding) getBinding()).textBay.setVisibility(0);
            ((ActivityStoreBinding) getBinding()).textSend.setVisibility(0);
            ((ActivityStoreBinding) getBinding()).relationSend.setVisibility(8);
            ((ActivityStoreBinding) getBinding()).diamondIcon.setVisibility(0);
        }
    }

    @JvmStatic
    public static final void start(@NotNull Context context, int i) {
        INSTANCE.start(context, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StoreViewModel viewModel_delegate$lambda$0(StoreActivity storeActivity) {
        return new ViewModelProvider(storeActivity).get(StoreViewModel.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public int getLayoutResId() {
        return R.layout.activity_store;
    }

    @NotNull
    public final String[] getMTypeList() {
        return this.mTypeList;
    }

    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onInitialize() {
        super.onInitialize();
        initView();
        initData();
    }

    @cf.m(threadMode = ThreadMode.MAIN)
    public final void onStoreEvent(@NotNull StoreEvent event) {
        Long l;
        Intrinsics.checkNotNullParameter(event, "event");
        if (Intrinsics.areEqual(event.getType(), "CARROM_SELECT") && (event.getData() instanceof StoreCarromData)) {
            Object data = event.getData();
            Intrinsics.checkNotNull(data, "null cannot be cast to non-null type com.qiahao.nextvideo.data.store.StoreCarromData");
            this.curretCarromData = (StoreCarromData) data;
            TextView textView = getBinding().diamondDay;
            String stringById = ResourcesKtxKt.getStringById(this, 2131952797);
            StoreCarromData storeCarromData = this.curretCarromData;
            if (storeCarromData != null) {
                l = storeCarromData.getSvipLevel();
            } else {
                l = null;
            }
            String format = String.format(stringById, Arrays.copyOf(new Object[]{String.valueOf(l)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            textView.setText(format);
        }
    }

    public final void setMTypeList(@NotNull String[] strArr) {
        Intrinsics.checkNotNullParameter(strArr, "<set-?>");
        this.mTypeList = strArr;
    }
}
