package com.qiahao.nextvideo.ui.family;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.oudi.utils.store.IStore;
import com.oudi.utils.store.MMKVStore;
import com.qiahao.base_common.common.BaseActivity;
import com.qiahao.base_common.databinding.IncludeFamilyNamePlateBinding;
import com.qiahao.base_common.model.common.FamilyInfo;
import com.qiahao.base_common.utils.AppUtilitiesKt;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.base_common.wedgit.polygon.PolygonImageView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.HiloBaseBindingActivity;
import com.qiahao.nextvideo.databinding.ActivityFamilyRankBinding;
import com.qiahao.nextvideo.ui.aristocracy.VipRecordFragment;
import com.qiahao.nextvideo.ui.family.FamilyCenterActivity;
import com.qiahao.nextvideo.ui.videocall.HelperDialog;
import com.qiahao.nextvideo.ui.webview.DefaultWebActivity;
import com.qiahao.nextvideo.utilities.userproxy.NumberUtilsKt;
import java.io.File;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u0019\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000e\u0010\u0004R\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R&\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0013j\b\u0012\u0004\u0012\u00020\u0014`\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0019\u001a\u00020\u00188\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001c"}, d2 = {"Lcom/qiahao/nextvideo/ui/family/FamilyRankActivity;", "Lcom/qiahao/nextvideo/app/base/HiloBaseBindingActivity;", "Lcom/qiahao/nextvideo/databinding/ActivityFamilyRankBinding;", "<init>", "()V", "", "initView", "Lcom/qiahao/base_common/model/common/FamilyInfo;", "myFamily", "refreshMy", "(Lcom/qiahao/base_common/model/common/FamilyInfo;)V", "", "getLayoutResId", "()I", "onInitialize", "", "", "titles", "[Ljava/lang/String;", "Ljava/util/ArrayList;", "Lcom/qiahao/nextvideo/ui/family/FamilyRankFragment;", "Lkotlin/collections/ArrayList;", "mFragments", "Ljava/util/ArrayList;", "Landroidx/viewpager2/adapter/a;", "mPagerAdapter", "Landroidx/viewpager2/adapter/a;", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nFamilyRankActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FamilyRankActivity.kt\ncom/qiahao/nextvideo/ui/family/FamilyRankActivity\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n*L\n1#1,163:1\n61#2,9:164\n61#2,9:173\n61#2,9:182\n*S KotlinDebug\n*F\n+ 1 FamilyRankActivity.kt\ncom/qiahao/nextvideo/ui/family/FamilyRankActivity\n*L\n77#1:164,9\n134#1:173,9\n159#1:182,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class FamilyRankActivity extends HiloBaseBindingActivity<ActivityFamilyRankBinding> {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String FRAGMENT_TYPE = "fragment_type";
    private androidx.viewpager2.adapter.a mPagerAdapter;

    @NotNull
    private String[] titles = {ResourcesKtxKt.getStringById(this, 2131952477), ResourcesKtxKt.getStringById(this, 2131954482), ResourcesKtxKt.getStringById(this, 2131953415)};

    @NotNull
    private ArrayList<FamilyRankFragment> mFragments = new ArrayList<>();

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/qiahao/nextvideo/ui/family/FamilyRankActivity$Companion;", "", "<init>", "()V", VipRecordFragment.FRAGMENT_TYPE, "", "startActivity", "", "context", "Landroid/content/Context;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void startActivity(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            context.startActivity(new Intent(context, (Class<?>) FamilyRankActivity.class));
        }

        private Companion() {
        }
    }

    private final void initView() {
        int i;
        View view = getBinding().bar;
        Intrinsics.checkNotNullExpressionValue(view, "bar");
        getStatusBarTopOrBottom(view, new Function2() { // from class: com.qiahao.nextvideo.ui.family.m2
            public final Object invoke(Object obj, Object obj2) {
                Unit initView$lambda$0;
                initView$lambda$0 = FamilyRankActivity.initView$lambda$0(FamilyRankActivity.this, ((Integer) obj).intValue(), ((Integer) obj2).intValue());
                return initView$lambda$0;
            }
        });
        setStatusBarIconColor(false);
        getBinding().backImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.family.n2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FamilyRankActivity.this.onBackPressed();
            }
        });
        final String str = (String) IStore.DefaultImpls.getValue$default(MMKVStore.INSTANCE, "family_activity_url", "", (String) null, 4, (Object) null);
        AppCompatImageView appCompatImageView = getBinding().activityImage;
        if (TextUtils.isEmpty(str)) {
            i = 8;
        } else {
            i = 0;
        }
        appCompatImageView.setVisibility(i);
        final AppCompatImageView appCompatImageView2 = getBinding().activityImage;
        final long j = 800;
        appCompatImageView2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.family.FamilyRankActivity$initView$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(appCompatImageView2) > j || (appCompatImageView2 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(appCompatImageView2, currentTimeMillis);
                    AppCompatImageView appCompatImageView3 = appCompatImageView2;
                    DefaultWebActivity.Companion.start$default(DefaultWebActivity.INSTANCE, this, str, null, 4, null);
                }
            }
        });
        if (this.mFragments.isEmpty()) {
            ArrayList<FamilyRankFragment> arrayList = this.mFragments;
            FamilyRankFragment familyRankFragment = new FamilyRankFragment();
            familyRankFragment.setMListener(new Function1() { // from class: com.qiahao.nextvideo.ui.family.o2
                public final Object invoke(Object obj) {
                    Unit initView$lambda$4$lambda$3;
                    initView$lambda$4$lambda$3 = FamilyRankActivity.initView$lambda$4$lambda$3(FamilyRankActivity.this, (FamilyInfo) obj);
                    return initView$lambda$4$lambda$3;
                }
            });
            Bundle bundle = new Bundle();
            bundle.putString("fragment_type", "day");
            familyRankFragment.setArguments(bundle);
            arrayList.add(familyRankFragment);
            ArrayList<FamilyRankFragment> arrayList2 = this.mFragments;
            FamilyRankFragment familyRankFragment2 = new FamilyRankFragment();
            familyRankFragment2.setMListener(new Function1() { // from class: com.qiahao.nextvideo.ui.family.p2
                public final Object invoke(Object obj) {
                    Unit initView$lambda$6$lambda$5;
                    initView$lambda$6$lambda$5 = FamilyRankActivity.initView$lambda$6$lambda$5(FamilyRankActivity.this, (FamilyInfo) obj);
                    return initView$lambda$6$lambda$5;
                }
            });
            Bundle bundle2 = new Bundle();
            bundle2.putString("fragment_type", "week");
            familyRankFragment2.setArguments(bundle2);
            arrayList2.add(familyRankFragment2);
            ArrayList<FamilyRankFragment> arrayList3 = this.mFragments;
            FamilyRankFragment familyRankFragment3 = new FamilyRankFragment();
            familyRankFragment3.setMListener(new Function1() { // from class: com.qiahao.nextvideo.ui.family.q2
                public final Object invoke(Object obj) {
                    Unit initView$lambda$8$lambda$7;
                    initView$lambda$8$lambda$7 = FamilyRankActivity.initView$lambda$8$lambda$7(FamilyRankActivity.this, (FamilyInfo) obj);
                    return initView$lambda$8$lambda$7;
                }
            });
            Bundle bundle3 = new Bundle();
            bundle3.putString("fragment_type", "month");
            familyRankFragment3.setArguments(bundle3);
            arrayList3.add(familyRankFragment3);
        }
        this.mPagerAdapter = new androidx.viewpager2.adapter.a() { // from class: com.qiahao.nextvideo.ui.family.FamilyRankActivity$initView$7
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(FamilyRankActivity.this);
            }

            public Fragment createFragment(int position) {
                ArrayList arrayList4;
                arrayList4 = FamilyRankActivity.this.mFragments;
                Object obj = arrayList4.get(position);
                Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
                return (Fragment) obj;
            }

            public int getItemCount() {
                ArrayList arrayList4;
                arrayList4 = FamilyRankActivity.this.mFragments;
                return arrayList4.size();
            }
        };
        getBinding().tabLayout.setOnTabSelectListener(new o6.b() { // from class: com.qiahao.nextvideo.ui.family.FamilyRankActivity$initView$8
            public void onTabReselect(int position) {
            }

            public void onTabSelect(int position) {
                ActivityFamilyRankBinding binding;
                binding = FamilyRankActivity.this.getBinding();
                binding.viewPage.setCurrentItem(position);
            }
        });
        getBinding().viewPage.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() { // from class: com.qiahao.nextvideo.ui.family.FamilyRankActivity$initView$9
            public void onPageSelected(int position) {
                ActivityFamilyRankBinding binding;
                super.onPageSelected(position);
                binding = FamilyRankActivity.this.getBinding();
                binding.tabLayout.setCurrentTab(position);
            }
        });
        final AppCompatImageView appCompatImageView3 = getBinding().helperImage;
        final long j2 = 800;
        appCompatImageView3.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.family.FamilyRankActivity$initView$$inlined$singleClick$default$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(appCompatImageView3) > j2 || (appCompatImageView3 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(appCompatImageView3, currentTimeMillis);
                    AppCompatImageView appCompatImageView4 = appCompatImageView3;
                    new HelperDialog(this).hideCancel(true).setTipContent(ResourcesKtxKt.getStringById(this, 2131952686)).show();
                }
            }
        });
        getBinding().tabLayout.i(2.0f, 2.0f, 2.0f, 2.0f);
        ViewPager2 viewPager2 = getBinding().viewPage;
        RecyclerView.Adapter adapter = this.mPagerAdapter;
        if (adapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPagerAdapter");
            adapter = null;
        }
        viewPager2.setAdapter(adapter);
        getBinding().tabLayout.setTabData(this.titles);
        getBinding().tabLayout.setCurrentTab(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initView$lambda$0(FamilyRankActivity familyRankActivity, int i, int i2) {
        familyRankActivity.getBinding().bar.setLayoutParams(new LinearLayoutCompat.a(-2, i));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initView$lambda$4$lambda$3(FamilyRankActivity familyRankActivity, FamilyInfo familyInfo) {
        familyRankActivity.refreshMy(familyInfo);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initView$lambda$6$lambda$5(FamilyRankActivity familyRankActivity, FamilyInfo familyInfo) {
        familyRankActivity.refreshMy(familyInfo);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initView$lambda$8$lambda$7(FamilyRankActivity familyRankActivity, FamilyInfo familyInfo) {
        familyRankActivity.refreshMy(familyInfo);
        return Unit.INSTANCE;
    }

    private final void refreshMy(final FamilyInfo myFamily) {
        long j;
        int i;
        String str;
        String str2;
        if (myFamily == null) {
            getBinding().myFamily.setVisibility(8);
        } else {
            int i2 = 0;
            getBinding().myFamily.setVisibility(0);
            TextView textView = getBinding().userName;
            String name = myFamily.getName();
            if (name == null) {
                name = "";
            }
            textView.setText(name);
            TextView textView2 = getBinding().diamond;
            Long exp = myFamily.getExp();
            if (exp != null) {
                j = exp.longValue();
            } else {
                j = 0;
            }
            textView2.setText(NumberUtilsKt.rankNumberFormat(j));
            IncludeFamilyNamePlateBinding includeFamilyNamePlateBinding = getBinding().namePlate;
            Intrinsics.checkNotNullExpressionValue(includeFamilyNamePlateBinding, "namePlate");
            Integer grade = myFamily.getGrade();
            if (grade != null) {
                i = grade.intValue();
            } else {
                i = -1;
            }
            String nameplate = myFamily.getNameplate();
            if (nameplate == null) {
                str = "";
            } else {
                str = nameplate;
            }
            AppUtilitiesKt.familyNamePlate$default(includeFamilyNamePlateBinding, i, str, 0, 4, (Object) null);
            PolygonImageView polygonImageView = getBinding().avatar;
            Intrinsics.checkNotNullExpressionValue(polygonImageView, "avatar");
            ImageKtxKt.loadImage$default(polygonImageView, myFamily.getIcon(), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131232432, (c5.g) null, 49150, (Object) null);
            TextView textView3 = getBinding().position;
            Integer rank = myFamily.getRank();
            if (rank != null) {
                i2 = rank.intValue();
            }
            if (i2 > 30) {
                str2 = "30+";
            } else {
                Integer rank2 = myFamily.getRank();
                if (rank2 != null) {
                    str2 = rank2.toString();
                } else {
                    str2 = null;
                }
            }
            textView3.setText(str2);
        }
        final ConstraintLayout constraintLayout = getBinding().myFamily;
        final long j2 = 800;
        constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.family.FamilyRankActivity$refreshMy$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long j3;
                Long id2;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(constraintLayout) > j2 || (constraintLayout instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(constraintLayout, currentTimeMillis);
                    ConstraintLayout constraintLayout2 = constraintLayout;
                    FamilyCenterActivity.Companion companion = FamilyCenterActivity.INSTANCE;
                    BaseActivity baseActivity = this;
                    FamilyInfo familyInfo = myFamily;
                    if (familyInfo != null && (id2 = familyInfo.getId()) != null) {
                        j3 = id2.longValue();
                    } else {
                        j3 = 0;
                    }
                    companion.startActivity(baseActivity, j3);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public int getLayoutResId() {
        return R.layout.activity_family_rank;
    }

    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onInitialize() {
        super.onInitialize();
        initView();
    }
}
