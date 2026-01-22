package com.qiahao.nextvideo.ui.family;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Checkable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.oudi.widget.ViewPage2TabLayout;
import com.qiahao.base_common.ui.dialog.TipDialog;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.HiloBaseBindingActivity;
import com.qiahao.nextvideo.databinding.ActivityFamilyStarBinding;
import com.qiahao.nextvideo.ui.aristocracy.VipRecordFragment;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00142\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u000f\u001a\u00020\u000eH\u0014J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0002J\u000e\u0010\u0013\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\u000eR\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\n0\u0006j\b\u0012\u0004\u0012\u00020\n`\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/qiahao/nextvideo/ui/family/FamilyStarActivity;", "Lcom/qiahao/nextvideo/app/base/HiloBaseBindingActivity;", "Lcom/qiahao/nextvideo/databinding/ActivityFamilyStarBinding;", "<init>", "()V", "titles", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "mFragments", "Lcom/qiahao/nextvideo/ui/family/FamilyStarFragment;", "familyID", "", "position", "", "getLayoutResId", "onInitialize", "", "initView", "selectPosition", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nFamilyStarActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FamilyStarActivity.kt\ncom/qiahao/nextvideo/ui/family/FamilyStarActivity\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n*L\n1#1,161:1\n61#2,9:162\n*S KotlinDebug\n*F\n+ 1 FamilyStarActivity.kt\ncom/qiahao/nextvideo/ui/family/FamilyStarActivity\n*L\n78#1:162,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class FamilyStarActivity extends HiloBaseBindingActivity<ActivityFamilyStarBinding> {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String FAMILY_ID = "familyID";

    @NotNull
    public static final String FAMILY_POSITION = "position";

    @NotNull
    public static final String FRAGMENT_PERIOD = "fragment_period";

    @NotNull
    public static final String FRAGMENT_TYPE = "fragment_type";
    private long familyID;

    @NotNull
    private ArrayList<FamilyStarFragment> mFragments;
    private int position;

    @NotNull
    private ArrayList<String> titles;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/qiahao/nextvideo/ui/family/FamilyStarActivity$Companion;", "", "<init>", "()V", VipRecordFragment.FRAGMENT_TYPE, "", "FRAGMENT_PERIOD", "FAMILY_ID", "FAMILY_POSITION", "startActivity", "", "context", "Landroid/content/Context;", "familyID", "", "position", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void startActivity$default(Companion companion, Context context, long j, int i, int i2, Object obj) {
            if ((i2 & 4) != 0) {
                i = 0;
            }
            companion.startActivity(context, j, i);
        }

        public final void startActivity(@NotNull Context context, long familyID, int position) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent(context, (Class<?>) FamilyStarActivity.class);
            intent.putExtra("familyID", familyID);
            intent.putExtra("position", position);
            context.startActivity(intent);
        }

        private Companion() {
        }
    }

    public FamilyStarActivity() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(ResourcesKtxKt.getStringById(arrayList, 2131952697));
        arrayList.add(ResourcesKtxKt.getStringById(arrayList, 2131951944));
        arrayList.add(ResourcesKtxKt.getStringById(arrayList, 2131952207));
        this.titles = arrayList;
        this.mFragments = new ArrayList<>();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initView() {
        this.familyID = getIntent().getLongExtra("familyID", 0L);
        this.position = getIntent().getIntExtra("position", 0);
        if (this.familyID == 0) {
            finish();
        }
        View view = ((ActivityFamilyStarBinding) getBinding()).bar;
        Intrinsics.checkNotNullExpressionValue(view, "bar");
        getStatusBarTopOrBottom(view, new Function2() { // from class: com.qiahao.nextvideo.ui.family.c4
            public final Object invoke(Object obj, Object obj2) {
                Unit initView$lambda$1;
                initView$lambda$1 = FamilyStarActivity.initView$lambda$1(FamilyStarActivity.this, ((Integer) obj).intValue(), ((Integer) obj2).intValue());
                return initView$lambda$1;
            }
        });
        ((ActivityFamilyStarBinding) getBinding()).backImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.family.d4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FamilyStarActivity.this.onBackPressed();
            }
        });
        final AppCompatImageView appCompatImageView = ((ActivityFamilyStarBinding) getBinding()).helperImage;
        final long j = 800;
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.family.FamilyStarActivity$initView$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ActivityFamilyStarBinding binding;
                String stringById;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(appCompatImageView) > j || (appCompatImageView instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(appCompatImageView, currentTimeMillis);
                    AppCompatImageView appCompatImageView2 = appCompatImageView;
                    TipDialog hideCancel = new TipDialog(this).hideCancel(true);
                    binding = this.getBinding();
                    int currentItem = binding.viewPage.getCurrentItem();
                    if (currentItem != 0) {
                        if (currentItem != 1) {
                            if (currentItem != 2) {
                                stringById = "";
                            } else {
                                stringById = ResourcesKtxKt.getStringById(this, 2131952694);
                            }
                        } else {
                            stringById = ResourcesKtxKt.getStringById(this, 2131952693);
                        }
                    } else {
                        stringById = ResourcesKtxKt.getStringById(this, 2131952695);
                    }
                    hideCancel.setTipContent(stringById).show();
                }
            }
        });
        if (this.mFragments.isEmpty()) {
            ArrayList<FamilyStarFragment> arrayList = this.mFragments;
            FamilyStarFragment familyStarFragment = new FamilyStarFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("fragment_type", 1);
            bundle.putString("fragment_period", "day");
            bundle.putLong("familyID", this.familyID);
            familyStarFragment.setArguments(bundle);
            arrayList.add(familyStarFragment);
            ArrayList<FamilyStarFragment> arrayList2 = this.mFragments;
            FamilyStarFragment familyStarFragment2 = new FamilyStarFragment();
            Bundle bundle2 = new Bundle();
            bundle2.putInt("fragment_type", 2);
            bundle2.putString("fragment_period", "day");
            bundle2.putLong("familyID", this.familyID);
            familyStarFragment2.setArguments(bundle2);
            arrayList2.add(familyStarFragment2);
            ArrayList<FamilyStarFragment> arrayList3 = this.mFragments;
            FamilyStarFragment familyStarFragment3 = new FamilyStarFragment();
            Bundle bundle3 = new Bundle();
            bundle3.putInt("fragment_type", 3);
            bundle3.putString("fragment_period", "day");
            bundle3.putLong("familyID", this.familyID);
            familyStarFragment3.setArguments(bundle3);
            arrayList3.add(familyStarFragment3);
        }
        ((ActivityFamilyStarBinding) getBinding()).viewPage.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() { // from class: com.qiahao.nextvideo.ui.family.FamilyStarActivity$initView$7
            public void onPageScrollStateChanged(int state) {
            }

            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            public void onPageSelected(int position) {
                FamilyStarActivity.this.selectPosition(position);
            }
        });
        ((ActivityFamilyStarBinding) getBinding()).viewPage.setOffscreenPageLimit(3);
        ((ActivityFamilyStarBinding) getBinding()).viewPage.setAdapter(new androidx.viewpager2.adapter.a() { // from class: com.qiahao.nextvideo.ui.family.FamilyStarActivity$initView$8
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(FamilyStarActivity.this);
            }

            public Fragment createFragment(int position) {
                ArrayList arrayList4;
                arrayList4 = FamilyStarActivity.this.mFragments;
                Object obj = arrayList4.get(position);
                Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
                return (Fragment) obj;
            }

            public int getItemCount() {
                ArrayList arrayList4;
                arrayList4 = FamilyStarActivity.this.mFragments;
                return arrayList4.size();
            }
        });
        ViewPage2TabLayout viewPage2TabLayout = ((ActivityFamilyStarBinding) getBinding()).tabLayout;
        ViewPager2 viewPager2 = ((ActivityFamilyStarBinding) getBinding()).viewPage;
        Intrinsics.checkNotNullExpressionValue(viewPager2, "viewPage");
        viewPage2TabLayout.setViewPager2(viewPager2, new ViewPage2TabLayout.StandardTextTabAdapter(this.titles, "#ffffff", "#66FFFFFF", 15, 15));
        selectPosition(0);
        if (this.position < this.titles.size()) {
            ((ActivityFamilyStarBinding) getBinding()).viewPage.postDelayed(new Runnable() { // from class: com.qiahao.nextvideo.ui.family.e4
                @Override // java.lang.Runnable
                public final void run() {
                    FamilyStarActivity.initView$lambda$7(FamilyStarActivity.this);
                }
            }, 500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initView$lambda$1(FamilyStarActivity familyStarActivity, int i, int i2) {
        familyStarActivity.getBinding().bar.setLayoutParams(new LinearLayoutCompat.a(-2, i));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$7(FamilyStarActivity familyStarActivity) {
        familyStarActivity.getBinding().viewPage.setCurrentItem(familyStarActivity.position);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public int getLayoutResId() {
        return R.layout.activity_family_star;
    }

    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onInitialize() {
        super.onInitialize();
        initView();
    }

    public final void selectPosition(int position) {
        if (position != 0) {
            if (position != 1) {
                if (position == 2) {
                    getBinding().constraintLayout.setBackgroundColor(Color.parseColor("#f67579"));
                    return;
                }
                return;
            }
            getBinding().constraintLayout.setBackgroundColor(Color.parseColor("#497dfd"));
            return;
        }
        getBinding().constraintLayout.setBackgroundColor(Color.parseColor("#ffa106"));
    }
}
