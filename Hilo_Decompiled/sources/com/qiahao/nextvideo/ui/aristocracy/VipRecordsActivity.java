package com.qiahao.nextvideo.ui.aristocracy;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.widget.ViewKtxKt;
import com.oudi.widget.ViewPage2TabLayout;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.HiloBaseBindingActivity;
import com.qiahao.nextvideo.databinding.ActivityVipRecordBinding;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u00132\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u000f\u001a\u00020\nH\u0014J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0002R\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0014"}, d2 = {"Lcom/qiahao/nextvideo/ui/aristocracy/VipRecordsActivity;", "Lcom/qiahao/nextvideo/app/base/HiloBaseBindingActivity;", "Lcom/qiahao/nextvideo/databinding/ActivityVipRecordBinding;", "<init>", "()V", "mFragments", "Ljava/util/ArrayList;", "Landroidx/fragment/app/Fragment;", "Lkotlin/collections/ArrayList;", "selectPosition", "", "getSelectPosition", "()I", "setSelectPosition", "(I)V", "getLayoutResId", "onInitialize", "", "initView", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class VipRecordsActivity extends HiloBaseBindingActivity<ActivityVipRecordBinding> {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String SELECT_POSITION = "position";

    @NotNull
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private int selectPosition;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/qiahao/nextvideo/ui/aristocracy/VipRecordsActivity$Companion;", "", "<init>", "()V", "SELECT_POSITION", "", "start", "", "context", "Landroid/content/Context;", "position", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
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

        public final void start(@NotNull Context context, int position) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent(context, (Class<?>) VipRecordsActivity.class);
            intent.putExtra("position", position);
            context.startActivity(intent);
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initView() {
        this.selectPosition = getIntent().getIntExtra("position", 0);
        View view = ((ActivityVipRecordBinding) getBinding()).titleBar.bar;
        Intrinsics.checkNotNullExpressionValue(view, "bar");
        getStatusBarTopOrBottom(view, new Function2() { // from class: com.qiahao.nextvideo.ui.aristocracy.e1
            public final Object invoke(Object obj, Object obj2) {
                Unit initView$lambda$0;
                initView$lambda$0 = VipRecordsActivity.initView$lambda$0(VipRecordsActivity.this, ((Integer) obj).intValue(), ((Integer) obj2).intValue());
                return initView$lambda$0;
            }
        });
        ((ActivityVipRecordBinding) getBinding()).titleBar.backImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.aristocracy.f1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                VipRecordsActivity.this.finish();
            }
        });
        ((ActivityVipRecordBinding) getBinding()).titleBar.title.setText(ResourcesKtxKt.toStringRes(2131954456));
        if (this.mFragments.isEmpty()) {
            ArrayList<Fragment> arrayList = this.mFragments;
            VipRecordFragment vipRecordFragment = new VipRecordFragment();
            Bundle bundle = new Bundle();
            bundle.putString(VipRecordFragment.FRAGMENT_TYPE, VipRecordFragment.TYPE_VIP_CARD);
            vipRecordFragment.setArguments(bundle);
            arrayList.add(vipRecordFragment);
            ArrayList<Fragment> arrayList2 = this.mFragments;
            VipRecordFragment vipRecordFragment2 = new VipRecordFragment();
            Bundle bundle2 = new Bundle();
            bundle2.putString(VipRecordFragment.FRAGMENT_TYPE, VipRecordFragment.TYPE_VIP);
            vipRecordFragment2.setArguments(bundle2);
            arrayList2.add(vipRecordFragment2);
        }
        ((ActivityVipRecordBinding) getBinding()).viewPage.setOffscreenPageLimit(2);
        ((ActivityVipRecordBinding) getBinding()).viewPage.setAdapter(new androidx.viewpager2.adapter.a() { // from class: com.qiahao.nextvideo.ui.aristocracy.VipRecordsActivity$initView$5
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(VipRecordsActivity.this);
            }

            public Fragment createFragment(int position) {
                ArrayList arrayList3;
                arrayList3 = VipRecordsActivity.this.mFragments;
                Object obj = arrayList3.get(position);
                Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
                return (Fragment) obj;
            }

            public int getItemCount() {
                ArrayList arrayList3;
                arrayList3 = VipRecordsActivity.this.mFragments;
                return arrayList3.size();
            }
        });
        ViewPage2TabLayout viewPage2TabLayout = ((ActivityVipRecordBinding) getBinding()).tabSegment;
        ViewPager2 viewPager2 = ((ActivityVipRecordBinding) getBinding()).viewPage;
        Intrinsics.checkNotNullExpressionValue(viewPager2, "viewPage");
        viewPage2TabLayout.setViewPager2(viewPager2, new AristocracyBagActivityAdapter());
        ViewPage2TabLayout viewPage2TabLayout2 = ((ActivityVipRecordBinding) getBinding()).tabSegment;
        Intrinsics.checkNotNullExpressionValue(viewPage2TabLayout2, "tabSegment");
        ViewKtxKt.disableTooltipText(viewPage2TabLayout2);
        ((ActivityVipRecordBinding) getBinding()).viewPage.post(new Runnable() { // from class: com.qiahao.nextvideo.ui.aristocracy.g1
            @Override // java.lang.Runnable
            public final void run() {
                VipRecordsActivity.initView$lambda$4(VipRecordsActivity.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initView$lambda$0(VipRecordsActivity vipRecordsActivity, int i, int i2) {
        vipRecordsActivity.getBinding().titleBar.bar.setLayoutParams(new LinearLayoutCompat.a(-2, i));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$4(VipRecordsActivity vipRecordsActivity) {
        if (vipRecordsActivity.selectPosition > 1) {
            return;
        }
        vipRecordsActivity.getBinding().viewPage.setCurrentItem(vipRecordsActivity.selectPosition);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public int getLayoutResId() {
        return R.layout.activity_vip_record;
    }

    public final int getSelectPosition() {
        return this.selectPosition;
    }

    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onInitialize() {
        super.onInitialize();
        initView();
    }

    public final void setSelectPosition(int i) {
        this.selectPosition = i;
    }
}
