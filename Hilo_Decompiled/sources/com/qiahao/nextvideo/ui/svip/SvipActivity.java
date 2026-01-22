package com.qiahao.nextvideo.ui.svip;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.ViewPager2;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.google.android.material.appbar.AppBarLayout;
import com.opensource.svgaplayer.SVGADrawable;
import com.opensource.svgaplayer.SVGAImageView;
import com.opensource.svgaplayer.SVGAParser;
import com.opensource.svgaplayer.SVGAVideoEntity;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.StringKtxKt;
import com.oudi.utils.ktx.UiKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.BaseApplication;
import com.qiahao.base_common.model.svip.Privilege;
import com.qiahao.base_common.model.svip.SvipCard;
import com.qiahao.base_common.model.svip.SvipInfo;
import com.qiahao.base_common.model.svip.SvipPrivilege;
import com.qiahao.base_common.model.svip.TaskPrivilegeBean;
import com.qiahao.base_common.model.svip.UserSvip;
import com.qiahao.base_common.network.interceptors.HiloException;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.DeepCopy;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.base_common.utils.ShapeUtil;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.base_common.utils.image.ImageSizeKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.HiloBaseBindingActivity;
import com.qiahao.nextvideo.databinding.ActivitySvipBinding;
import com.qiahao.nextvideo.databinding.SvipFootBinding;
import com.qiahao.nextvideo.utilities.userproxy.NumberUtilsKt;
import com.zhpan.bannerview.BannerViewPager;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 92\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u00019B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\u0005J'\u0010\r\u001a\u00020\u00062\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\tj\b\u0012\u0004\u0012\u00020\u000f`\u000bH\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0012\u0010\u0005J\u0017\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0017\u0010\u0005J\u000f\u0010\u0018\u001a\u00020\u0013H\u0014¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001a\u0010\u0005J!\u0010\u001e\u001a\u00020\u00062\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001d\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0006H\u0014¢\u0006\u0004\b \u0010\u0005R\u0014\u0010!\u001a\u00020\u00138\u0002X\u0082D¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010#\u001a\u00020\u00138\u0002X\u0082D¢\u0006\u0006\n\u0004\b#\u0010\"R\u0016\u0010$\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010\"R\u0016\u0010%\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010\"R\u0018\u0010'\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u001b\u0010.\u001a\u00020)8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u001b\u00103\u001a\u00020/8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b0\u0010+\u001a\u0004\b1\u00102R\u001b\u00108\u001a\u0002048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b5\u0010+\u001a\u0004\b6\u00107¨\u0006:"}, d2 = {"Lcom/qiahao/nextvideo/ui/svip/SvipActivity;", "Lcom/qiahao/nextvideo/app/base/HiloBaseBindingActivity;", "Lcom/qiahao/nextvideo/databinding/ActivitySvipBinding;", "Lcom/google/android/material/appbar/AppBarLayout$h;", "<init>", "()V", "", "initData", "initView", "Ljava/util/ArrayList;", "Lcom/qiahao/base_common/model/svip/SvipCard;", "Lkotlin/collections/ArrayList;", "list", "initCard", "(Ljava/util/ArrayList;)V", "Lcom/qiahao/base_common/model/svip/SvipPrivilege;", "renderGrid", "()Ljava/util/ArrayList;", "initPrivilege", "", "position", "startPrivilegeActivity", "(I)V", "initTaskPrivileges", "getLayoutResId", "()I", "onInitialize", "Lcom/google/android/material/appbar/AppBarLayout;", "appBarLayout", "verticalOffset", "onOffsetChanged", "(Lcom/google/android/material/appbar/AppBarLayout;I)V", "onResume", "STATE_COLLAPSED", "I", "STATE_EXPANDED", "mCollapsingState", "mSvipLevel", "", "receiveTaskId", "Ljava/lang/Long;", "Lcom/qiahao/nextvideo/ui/svip/SvipViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getViewModel", "()Lcom/qiahao/nextvideo/ui/svip/SvipViewModel;", "viewModel", "Lcom/qiahao/nextvideo/ui/svip/SvipPrivilegesAdapter;", "mPrivilegesAdapter$delegate", "getMPrivilegesAdapter", "()Lcom/qiahao/nextvideo/ui/svip/SvipPrivilegesAdapter;", "mPrivilegesAdapter", "Lcom/qiahao/nextvideo/ui/svip/SvipCardAdapter;", "mCardAdapter$delegate", "getMCardAdapter", "()Lcom/qiahao/nextvideo/ui/svip/SvipCardAdapter;", "mCardAdapter", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSvipActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SvipActivity.kt\ncom/qiahao/nextvideo/ui/svip/SvipActivity\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 Color.kt\nandroidx/core/graphics/ColorKt\n+ 5 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,356:1\n61#2,9:357\n61#2,9:366\n61#2,9:375\n1869#3:384\n1869#3,2:385\n1870#3:387\n1869#3:390\n1870#3:392\n439#4:388\n439#4:389\n439#4:393\n1#5:391\n*S KotlinDebug\n*F\n+ 1 SvipActivity.kt\ncom/qiahao/nextvideo/ui/svip/SvipActivity\n*L\n148#1:357,9\n151#1:366,9\n154#1:375,9\n209#1:384\n211#1:385,2\n209#1:387\n100#1:390\n100#1:392\n325#1:388\n328#1:389\n118#1:393\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class SvipActivity extends HiloBaseBindingActivity<ActivitySvipBinding> implements AppBarLayout.h {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String SVIP_LEVEL = "svip_level";
    private final int STATE_COLLAPSED;
    private final int STATE_EXPANDED = 1;
    private int mCollapsingState = 1;
    private int mSvipLevel = -1;

    @Nullable
    private Long receiveTaskId = 0L;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.svip.c
        public final Object invoke() {
            SvipViewModel viewModel_delegate$lambda$0;
            viewModel_delegate$lambda$0 = SvipActivity.viewModel_delegate$lambda$0(SvipActivity.this);
            return viewModel_delegate$lambda$0;
        }
    });

    /* renamed from: mPrivilegesAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mPrivilegesAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.svip.d
        public final Object invoke() {
            SvipPrivilegesAdapter mPrivilegesAdapter_delegate$lambda$1;
            mPrivilegesAdapter_delegate$lambda$1 = SvipActivity.mPrivilegesAdapter_delegate$lambda$1();
            return mPrivilegesAdapter_delegate$lambda$1;
        }
    });

    /* renamed from: mCardAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mCardAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.svip.e
        public final Object invoke() {
            SvipCardAdapter mCardAdapter_delegate$lambda$2;
            mCardAdapter_delegate$lambda$2 = SvipActivity.mCardAdapter_delegate$lambda$2();
            return mCardAdapter_delegate$lambda$2;
        }
    });

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/qiahao/nextvideo/ui/svip/SvipActivity$Companion;", "", "<init>", "()V", "SVIP_LEVEL", "", "start", "", "context", "Landroid/content/Context;", "level", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void start(@NotNull Context context, int level) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent(context, (Class<?>) SvipActivity.class);
            intent.putExtra(SvipActivity.SVIP_LEVEL, level);
            context.startActivity(intent);
        }

        private Companion() {
        }
    }

    private final SvipCardAdapter getMCardAdapter() {
        return (SvipCardAdapter) this.mCardAdapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SvipPrivilegesAdapter getMPrivilegesAdapter() {
        return (SvipPrivilegesAdapter) this.mPrivilegesAdapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SvipViewModel getViewModel() {
        return (SvipViewModel) this.viewModel.getValue();
    }

    private final void initCard(ArrayList<SvipCard> list) {
        getBinding().bannerView.X(2).a0(UiKtxKt.toPX(10)).W(UiKtxKt.toPX(15)).G(getMCardAdapter()).I(false).H(false).Z(HiloUtils.INSTANCE.getRightToLeftDirection()).R(8).E(new ViewPager2.OnPageChangeCallback() { // from class: com.qiahao.nextvideo.ui.svip.SvipActivity$initCard$1
            public void onPageSelected(int position) {
                SvipPrivilegesAdapter mPrivilegesAdapter;
                SvipPrivilegesAdapter mPrivilegesAdapter2;
                ArrayList renderGrid;
                super.onPageSelected(position);
                mPrivilegesAdapter = SvipActivity.this.getMPrivilegesAdapter();
                mPrivilegesAdapter.setMSelectPosition(position);
                mPrivilegesAdapter2 = SvipActivity.this.getMPrivilegesAdapter();
                renderGrid = SvipActivity.this.renderGrid();
                mPrivilegesAdapter2.setList(renderGrid);
                SvipActivity.this.initTaskPrivileges();
            }
        }).T(new BannerViewPager.b() { // from class: com.qiahao.nextvideo.ui.svip.b
            @Override // com.zhpan.bannerview.BannerViewPager.b
            public final void a(View view, int i) {
                SvipActivity.initCard$lambda$15(SvipActivity.this, view, i);
            }
        }).h(list);
        if (this.mSvipLevel >= 0 && list.size() > this.mSvipLevel) {
            getBinding().bannerView.J(this.mSvipLevel, false);
        } else {
            getBinding().bannerView.J(getMPrivilegesAdapter().getMSelectPosition(), false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void initCard$lambda$15(SvipActivity svipActivity, View view, int i) {
        svipActivity.startActivity(new Intent((Context) svipActivity, (Class<?>) SvipPointActivity.class));
    }

    private final void initData() {
        getViewModel().getSvipInfo().observe(this, new SvipActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.svip.f
            public final Object invoke(Object obj) {
                Unit initData$lambda$5;
                initData$lambda$5 = SvipActivity.initData$lambda$5(SvipActivity.this, (SvipInfo) obj);
                return initData$lambda$5;
            }
        }));
        getViewModel().getReceiveSvipTaskAward().observe(this, new SvipActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.svip.g
            public final Object invoke(Object obj) {
                Unit initData$lambda$8;
                initData$lambda$8 = SvipActivity.initData$lambda$8(SvipActivity.this, (ApiResponse) obj);
                return initData$lambda$8;
            }
        }));
        getViewModel().getError().observe(this, new SvipActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.svip.h
            public final Object invoke(Object obj) {
                Unit initData$lambda$9;
                initData$lambda$9 = SvipActivity.initData$lambda$9(SvipActivity.this, (Throwable) obj);
                return initData$lambda$9;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$5(SvipActivity svipActivity, SvipInfo svipInfo) {
        int i;
        Integer level;
        SvipCard svipCard;
        Integer num;
        ArrayList<SvipCard> arrayList = new ArrayList<>();
        List<SvipCard> svipCards = svipInfo.getSvipCards();
        if (svipCards != null) {
            for (SvipCard svipCard2 : svipCards) {
                Integer num2 = null;
                if (svipCard2 != null) {
                    svipCard = (SvipCard) DeepCopy.INSTANCE.deepCopy(svipCard2);
                } else {
                    svipCard = null;
                }
                if (svipCard != null) {
                    num = svipCard.getLevel();
                } else {
                    num = null;
                }
                UserSvip userSvip = svipInfo.getUserSvip();
                if (userSvip != null) {
                    num2 = userSvip.getLevel();
                }
                if (Intrinsics.areEqual(num, num2) && svipCard != null) {
                    svipCard.setUserSvip(svipInfo.getUserSvip());
                }
                if (svipCard != null) {
                    arrayList.add(svipCard);
                }
            }
        }
        SvipPrivilegesAdapter mPrivilegesAdapter = svipActivity.getMPrivilegesAdapter();
        UserSvip userSvip2 = svipInfo.getUserSvip();
        if (userSvip2 != null && (level = userSvip2.getLevel()) != null) {
            i = level.intValue();
        } else {
            i = 1;
        }
        mPrivilegesAdapter.setMSelectPosition(i - 1);
        svipActivity.initCard(arrayList);
        svipActivity.getMPrivilegesAdapter().setList(svipActivity.renderGrid());
        svipActivity.initTaskPrivileges();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit initData$lambda$8(SvipActivity svipActivity, ApiResponse apiResponse) {
        int i;
        SvipInfo svipInfo;
        List svipCards;
        SvipCard svipCard;
        List taskPrivileges;
        List svipCards2;
        if (apiResponse.getCode() == 200) {
            Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, svipActivity.getApplicationContext(), ResourcesKtxKt.getStringById(svipActivity, 2131953844), false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
            }
            ActivitySvipBinding activitySvipBinding = (ActivitySvipBinding) svipActivity.getBinding();
            activitySvipBinding.gift3ReceiveBtn.setBackground(ShapeUtil.createShape$default(ShapeUtil.INSTANCE, "#AAA386", "#845F29", 16, (GradientDrawable.Orientation) null, 8, (Object) null));
            activitySvipBinding.gift3ReceiveBtn.setTextColor(Color.parseColor("#80FFFFFF"));
            try {
                SvipInfo svipInfo2 = (SvipInfo) svipActivity.getViewModel().getSvipInfo().getValue();
                if (svipInfo2 != null && (svipCards2 = svipInfo2.getSvipCards()) != null) {
                    i = svipCards2.size();
                } else {
                    i = 0;
                }
                if (i > svipActivity.getMPrivilegesAdapter().getMSelectPosition() && (svipInfo = (SvipInfo) svipActivity.getViewModel().getSvipInfo().getValue()) != null && (svipCards = svipInfo.getSvipCards()) != null && (svipCard = (SvipCard) svipCards.get(svipActivity.getMPrivilegesAdapter().getMSelectPosition())) != null && (taskPrivileges = svipCard.getTaskPrivileges()) != null && !taskPrivileges.isEmpty() && taskPrivileges.size() >= 3) {
                    ((TaskPrivilegeBean) taskPrivileges.get(2)).getReceiveStatus();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit initData$lambda$9(SvipActivity svipActivity, Throwable th) {
        String str;
        if (th instanceof HiloException) {
            HiloToasty.Companion companion = HiloToasty.Companion;
            Context applicationContext = svipActivity.getApplicationContext();
            String errorMessage = ((HiloException) th).getErrorMessage();
            if (errorMessage == null) {
                str = ResourcesKtxKt.getStringById(svipActivity, 2131952667);
            } else {
                str = errorMessage;
            }
            Toast normal$default = HiloToasty.Companion.normal$default(companion, applicationContext, str, false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initPrivilege() {
        SvipFootBinding svipFootBinding = (SvipFootBinding) androidx.databinding.g.h(LayoutInflater.from(this), R.layout.svip_foot, (ViewGroup) null, false);
        SvipPrivilegesAdapter mPrivilegesAdapter = getMPrivilegesAdapter();
        View root = svipFootBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        BaseQuickAdapter.addFooterView$default(mPrivilegesAdapter, root, 0, 0, 6, (Object) null);
        ((ActivitySvipBinding) getBinding()).recyclerView.setAdapter(getMPrivilegesAdapter());
        getMPrivilegesAdapter().setOnItemClickListener(new OnItemClickListener() { // from class: com.qiahao.nextvideo.ui.svip.a
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                SvipActivity.initPrivilege$lambda$18(SvipActivity.this, baseQuickAdapter, view, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initPrivilege$lambda$18(SvipActivity svipActivity, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        svipActivity.startPrivilegeActivity(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initTaskPrivileges() {
        int i;
        SvipInfo svipInfo;
        List svipCards;
        SvipCard svipCard;
        List taskPrivileges;
        List svipCards2;
        ArrayList arrayList = new ArrayList();
        SvipInfo svipInfo2 = (SvipInfo) getViewModel().getSvipInfo().getValue();
        if (svipInfo2 != null && (svipCards2 = svipInfo2.getSvipCards()) != null) {
            i = svipCards2.size();
        } else {
            i = 0;
        }
        if (i > getMPrivilegesAdapter().getMSelectPosition() && (svipInfo = (SvipInfo) getViewModel().getSvipInfo().getValue()) != null && (svipCards = svipInfo.getSvipCards()) != null && (svipCard = (SvipCard) svipCards.get(getMPrivilegesAdapter().getMSelectPosition())) != null && (taskPrivileges = svipCard.getTaskPrivileges()) != null) {
            arrayList.addAll(taskPrivileges);
        }
        if (!arrayList.isEmpty() && arrayList.size() >= 3) {
            final ActivitySvipBinding binding = getBinding();
            binding.tvGiftTitle1.setText(((TaskPrivilegeBean) arrayList.get(0)).getTitle());
            binding.tvGiftNumber1.setText(NumberUtilsKt.rankNumberFormat(((TaskPrivilegeBean) arrayList.get(0)).getNum()));
            binding.tvGiftSubTitle1.setText(((TaskPrivilegeBean) arrayList.get(0)).getCollectionTime());
            String icon = ((TaskPrivilegeBean) arrayList.get(0)).getIcon();
            if (icon != null && StringKtxKt.checkEndSVGA(icon)) {
                SVGAParser.Companion.shareParser().decodeFromURL(new URL(icon), new SVGAParser.ParseCompletion() { // from class: com.qiahao.nextvideo.ui.svip.SvipActivity$initTaskPrivileges$2$1
                    public void onComplete(SVGAVideoEntity videoItem) {
                        Intrinsics.checkNotNullParameter(videoItem, "videoItem");
                        ActivitySvipBinding.this.ivGift1.stopAnimation();
                        ActivitySvipBinding.this.ivGift1.setImageDrawable(new SVGADrawable(videoItem));
                        ActivitySvipBinding.this.ivGift1.startAnimation();
                    }

                    public void onError() {
                    }
                });
            } else {
                SVGAImageView sVGAImageView = binding.ivGift1;
                Intrinsics.checkNotNullExpressionValue(sVGAImageView, "ivGift1");
                ImageKtxKt.loadImage$default(sVGAImageView, ImageSizeKt.image200(icon), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
            }
            binding.tvGiftTitle2.setText(((TaskPrivilegeBean) arrayList.get(1)).getTitle());
            binding.tvGiftNumber2.setText(NumberUtilsKt.rankNumberFormat(((TaskPrivilegeBean) arrayList.get(1)).getNum()));
            binding.tvGiftSubTitle2.setText(((TaskPrivilegeBean) arrayList.get(1)).getCollectionTime());
            String icon2 = ((TaskPrivilegeBean) arrayList.get(1)).getIcon();
            if (icon2 != null && StringKtxKt.checkEndSVGA(icon2)) {
                SVGAParser.Companion.shareParser().decodeFromURL(new URL(icon2), new SVGAParser.ParseCompletion() { // from class: com.qiahao.nextvideo.ui.svip.SvipActivity$initTaskPrivileges$2$2
                    public void onComplete(SVGAVideoEntity videoItem) {
                        Intrinsics.checkNotNullParameter(videoItem, "videoItem");
                        ActivitySvipBinding.this.ivGift2.stopAnimation();
                        ActivitySvipBinding.this.ivGift2.setImageDrawable(new SVGADrawable(videoItem));
                        ActivitySvipBinding.this.ivGift2.startAnimation();
                    }

                    public void onError() {
                    }
                });
            } else {
                SVGAImageView sVGAImageView2 = binding.ivGift2;
                Intrinsics.checkNotNullExpressionValue(sVGAImageView2, "ivGift2");
                ImageKtxKt.loadImage$default(sVGAImageView2, ImageSizeKt.image200(icon2), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
            }
            binding.tvGiftTitle3.setText(((TaskPrivilegeBean) arrayList.get(2)).getTitle());
            binding.tvGiftNumber3.setText(NumberUtilsKt.rankNumberFormat(((TaskPrivilegeBean) arrayList.get(2)).getNum()));
            binding.tvGiftSubTitle3.setText(((TaskPrivilegeBean) arrayList.get(2)).getCollectionTime());
            String icon3 = ((TaskPrivilegeBean) arrayList.get(2)).getIcon();
            if (icon3 != null && StringKtxKt.checkEndSVGA(icon3)) {
                SVGAParser.Companion.shareParser().decodeFromURL(new URL(icon3), new SVGAParser.ParseCompletion() { // from class: com.qiahao.nextvideo.ui.svip.SvipActivity$initTaskPrivileges$2$3
                    public void onComplete(SVGAVideoEntity videoItem) {
                        Intrinsics.checkNotNullParameter(videoItem, "videoItem");
                        ActivitySvipBinding.this.ivGift3.stopAnimation();
                        ActivitySvipBinding.this.ivGift3.setImageDrawable(new SVGADrawable(videoItem));
                        ActivitySvipBinding.this.ivGift3.startAnimation();
                    }

                    public void onError() {
                    }
                });
            } else {
                SVGAImageView sVGAImageView3 = binding.ivGift3;
                Intrinsics.checkNotNullExpressionValue(sVGAImageView3, "ivGift3");
                ImageKtxKt.loadImage$default(sVGAImageView3, ImageSizeKt.image200(icon3), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
            }
            this.receiveTaskId = ((TaskPrivilegeBean) arrayList.get(2)).getTaskId();
            if (((TaskPrivilegeBean) arrayList.get(2)).getReceiveStatus() == 1) {
                binding.gift3ReceiveBtn.setBackground(ShapeUtil.createShape$default(ShapeUtil.INSTANCE, "#FFF9DC", "#F0D786", 16, (GradientDrawable.Orientation) null, 8, (Object) null));
                binding.gift3ReceiveBtn.setTextColor(Color.parseColor("#3D2104"));
            } else {
                binding.gift3ReceiveBtn.setBackground(ShapeUtil.createShape$default(ShapeUtil.INSTANCE, "#A09B86", "#8C7C46", 16, (GradientDrawable.Orientation) null, 8, (Object) null));
                binding.gift3ReceiveBtn.setTextColor(Color.parseColor("#3D2104"));
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initView() {
        this.mSvipLevel = getIntent().getIntExtra(SVIP_LEVEL, -1);
        FrameLayout frameLayout = ((ActivitySvipBinding) getBinding()).activityMainContainer;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "activityMainContainer");
        getStatusBarTopOrBottom(frameLayout, new Function2() { // from class: com.qiahao.nextvideo.ui.svip.i
            public final Object invoke(Object obj, Object obj2) {
                Unit initView$lambda$10;
                initView$lambda$10 = SvipActivity.initView$lambda$10(SvipActivity.this, ((Integer) obj).intValue(), ((Integer) obj2).intValue());
                return initView$lambda$10;
            }
        });
        setStatusBarIconColor(false);
        final AppCompatImageView appCompatImageView = ((ActivitySvipBinding) getBinding()).backImageView;
        final long j = 800;
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.svip.SvipActivity$initView$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(appCompatImageView) > j || (appCompatImageView instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(appCompatImageView, currentTimeMillis);
                    AppCompatImageView appCompatImageView2 = appCompatImageView;
                    this.finish();
                }
            }
        });
        final AppCompatImageView appCompatImageView2 = ((ActivitySvipBinding) getBinding()).help;
        appCompatImageView2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.svip.SvipActivity$initView$$inlined$singleClick$default$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(appCompatImageView2) > j || (appCompatImageView2 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(appCompatImageView2, currentTimeMillis);
                    AppCompatImageView appCompatImageView3 = appCompatImageView2;
                    this.startActivity(new Intent((Context) this, (Class<?>) SvipRulesActivity.class));
                }
            }
        });
        final TextView textView = ((ActivitySvipBinding) getBinding()).gift3ReceiveBtn;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.svip.SvipActivity$initView$$inlined$singleClick$default$3
            /* JADX WARN: Code restructure failed: missing block: B:16:0x0053, code lost:
            
                r7 = r4.receiveTaskId;
             */
            @Override // android.view.View.OnClickListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void onClick(View view) {
                SvipViewModel viewModel;
                int i;
                SvipPrivilegesAdapter mPrivilegesAdapter;
                Long l;
                SvipViewModel viewModel2;
                UserSvip userSvip;
                Integer level;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView) > j || (textView instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(textView, currentTimeMillis);
                    viewModel = this.getViewModel();
                    SvipInfo svipInfo = (SvipInfo) viewModel.getSvipInfo().getValue();
                    if (svipInfo != null && (userSvip = svipInfo.getUserSvip()) != null && (level = userSvip.getLevel()) != null) {
                        i = level.intValue();
                    } else {
                        i = 0;
                    }
                    mPrivilegesAdapter = this.getMPrivilegesAdapter();
                    if (i == mPrivilegesAdapter.getMSelectPosition() + 1 && l != null) {
                        long longValue = l.longValue();
                        if (longValue > 0) {
                            viewModel2 = this.getViewModel();
                            viewModel2.receiveSvipTaskAward(longValue);
                        }
                    }
                }
            }
        });
        initPrivilege();
        ((ActivitySvipBinding) getBinding()).appbar.addOnOffsetChangedListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initView$lambda$10(SvipActivity svipActivity, int i, int i2) {
        svipActivity.getBinding().collapseToolbar.setPadding(0, i, 0, 0);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SvipCardAdapter mCardAdapter_delegate$lambda$2() {
        return new SvipCardAdapter();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SvipPrivilegesAdapter mPrivilegesAdapter_delegate$lambda$1() {
        return new SvipPrivilegesAdapter();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"SetTextI18n"})
    public final ArrayList<SvipPrivilege> renderGrid() {
        List list;
        int i;
        int i2;
        List svipPrivilege;
        SvipInfo svipInfo;
        List svipPrivilege2;
        SvipCard svipCard;
        ArrayList<Privilege> privileges;
        SvipInfo svipInfo2 = (SvipInfo) getViewModel().getSvipInfo().getValue();
        if (svipInfo2 != null) {
            list = svipInfo2.getSvipCards();
        } else {
            list = null;
        }
        ArrayList<SvipPrivilege> arrayList = new ArrayList<>();
        int i3 = 0;
        if (list != null) {
            i = list.size();
        } else {
            i = 0;
        }
        if (i > getMPrivilegesAdapter().getMSelectPosition() && (svipInfo = (SvipInfo) getViewModel().getSvipInfo().getValue()) != null && (svipPrivilege2 = svipInfo.getSvipPrivilege()) != null) {
            Iterator it = svipPrivilege2.iterator();
            i2 = 0;
            while (it.hasNext()) {
                SvipPrivilege svipPrivilege3 = (SvipPrivilege) DeepCopy.INSTANCE.deepCopy((SvipPrivilege) it.next());
                if (list != null && (svipCard = (SvipCard) list.get(getMPrivilegesAdapter().getMSelectPosition())) != null && (privileges = svipCard.getPrivileges()) != null) {
                    for (Privilege privilege : privileges) {
                        if (svipPrivilege3.getType() == privilege.getType()) {
                            svipPrivilege3.setCanSwitch(privilege.getCanSwitch());
                            svipPrivilege3.setUserSwitch(privilege.getUserSwitch());
                            svipPrivilege3.setHasPrivilege(true);
                            i2++;
                        }
                    }
                }
                arrayList.add(svipPrivilege3);
            }
        } else {
            i2 = 0;
        }
        AppCompatTextView appCompatTextView = getBinding().svipNumber;
        SvipInfo svipInfo3 = (SvipInfo) getViewModel().getSvipInfo().getValue();
        if (svipInfo3 != null && (svipPrivilege = svipInfo3.getSvipPrivilege()) != null) {
            i3 = svipPrivilege.size();
        }
        appCompatTextView.setText("(" + i2 + "/" + i3 + ")");
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void startPrivilegeActivity(int position) {
        Intent intent = new Intent((Context) this, (Class<?>) SvipPrivilegesActivity.class);
        intent.putExtra("data", BaseApplication.Companion.getGSON().s(getViewModel().getSvipInfo().getValue()));
        intent.putExtra("position", position);
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SvipViewModel viewModel_delegate$lambda$0(SvipActivity svipActivity) {
        return new ViewModelProvider(svipActivity).get(SvipViewModel.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public int getLayoutResId() {
        return R.layout.activity_svip;
    }

    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onInitialize() {
        super.onInitialize();
        initView();
        initData();
    }

    public void onOffsetChanged(@Nullable AppBarLayout appBarLayout, int verticalOffset) {
        if (appBarLayout != null) {
            if (Math.abs(verticalOffset) >= 100) {
                int i = this.mCollapsingState;
                int i2 = this.STATE_COLLAPSED;
                if (i != i2) {
                    this.mCollapsingState = i2;
                    getBinding().collapseToolbar.setBackgroundResource(2131099931);
                    return;
                }
                return;
            }
            int i3 = this.mCollapsingState;
            int i4 = this.STATE_EXPANDED;
            if (i3 != i4) {
                this.mCollapsingState = i4;
                getBinding().collapseToolbar.setBackgroundResource(2131101182);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onResume() {
        super.onResume();
        getViewModel().m٨٨getSvipInfo();
    }
}
