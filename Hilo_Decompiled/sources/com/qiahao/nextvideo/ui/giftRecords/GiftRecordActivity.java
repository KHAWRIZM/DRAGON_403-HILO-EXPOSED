package com.qiahao.nextvideo.ui.giftRecords;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Checkable;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.UiKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.oudi.widget.ViewPage2TabLayout;
import com.qiahao.base_common.ui.dialog.TipDialog;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.HiloBaseBindingActivity;
import com.qiahao.nextvideo.databinding.ActivityGiftRecordBinding;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u00132\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u000f\u001a\u00020\nH\u0014J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0002R\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0014"}, d2 = {"Lcom/qiahao/nextvideo/ui/giftRecords/GiftRecordActivity;", "Lcom/qiahao/nextvideo/app/base/HiloBaseBindingActivity;", "Lcom/qiahao/nextvideo/databinding/ActivityGiftRecordBinding;", "<init>", "()V", "mFragments", "Ljava/util/ArrayList;", "Landroidx/fragment/app/Fragment;", "Lkotlin/collections/ArrayList;", "selectPosition", "", "getSelectPosition", "()I", "setSelectPosition", "(I)V", "getLayoutResId", "onInitialize", "", "initView", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nGiftRecordActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GiftRecordActivity.kt\ncom/qiahao/nextvideo/ui/giftRecords/GiftRecordActivity\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n*L\n1#1,109:1\n61#2,9:110\n*S KotlinDebug\n*F\n+ 1 GiftRecordActivity.kt\ncom/qiahao/nextvideo/ui/giftRecords/GiftRecordActivity\n*L\n72#1:110,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class GiftRecordActivity extends HiloBaseBindingActivity<ActivityGiftRecordBinding> {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String SELECT_POSITION = "position";

    @NotNull
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private int selectPosition;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/qiahao/nextvideo/ui/giftRecords/GiftRecordActivity$Companion;", "", "<init>", "()V", "SELECT_POSITION", "", "start", "", "context", "Landroid/content/Context;", "position", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
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
            Intent intent = new Intent(context, (Class<?>) GiftRecordActivity.class);
            intent.putExtra("position", position);
            context.startActivity(intent);
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initView() {
        this.selectPosition = getIntent().getIntExtra("position", 0);
        View view = ((ActivityGiftRecordBinding) getBinding()).titleBar.bar;
        Intrinsics.checkNotNullExpressionValue(view, "bar");
        getStatusBarTopOrBottom(view, new Function2() { // from class: com.qiahao.nextvideo.ui.giftRecords.a
            public final Object invoke(Object obj, Object obj2) {
                Unit initView$lambda$0;
                initView$lambda$0 = GiftRecordActivity.initView$lambda$0(GiftRecordActivity.this, ((Integer) obj).intValue(), ((Integer) obj2).intValue());
                return initView$lambda$0;
            }
        });
        ((ActivityGiftRecordBinding) getBinding()).titleBar.backImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.giftRecords.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                GiftRecordActivity.this.finish();
            }
        });
        AppCompatImageView appCompatImageView = ((ActivityGiftRecordBinding) getBinding()).titleBar.endImage;
        appCompatImageView.setVisibility(0);
        appCompatImageView.setImageDrawable(androidx.core.content.a.getDrawable(this, R.drawable.gift_record_helper));
        int px = UiKtxKt.toPX(11);
        appCompatImageView.setPadding(px, px, px, px);
        appCompatImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        final AppCompatImageView appCompatImageView2 = ((ActivityGiftRecordBinding) getBinding()).titleBar.endImage;
        final long j = 800;
        appCompatImageView2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.giftRecords.GiftRecordActivity$initView$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(appCompatImageView2) > j || (appCompatImageView2 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(appCompatImageView2, currentTimeMillis);
                    AppCompatImageView appCompatImageView3 = appCompatImageView2;
                    new TipDialog(this).setTipContent(ResourcesKtxKt.getStringById(this, 2131952892)).setConfirmContent(ResourcesKtxKt.getStringById(this, 2131953100)).hideCancel(true).show();
                }
            }
        });
        ((ActivityGiftRecordBinding) getBinding()).titleBar.title.setText(ResourcesKtxKt.toStringRes(2131952891));
        if (this.mFragments.isEmpty()) {
            ArrayList<Fragment> arrayList = this.mFragments;
            GiftRecordFragment giftRecordFragment = new GiftRecordFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("gift_type", 1);
            giftRecordFragment.setArguments(bundle);
            arrayList.add(giftRecordFragment);
            ArrayList<Fragment> arrayList2 = this.mFragments;
            GiftRecordFragment giftRecordFragment2 = new GiftRecordFragment();
            Bundle bundle2 = new Bundle();
            bundle2.putInt("gift_type", 2);
            giftRecordFragment2.setArguments(bundle2);
            arrayList2.add(giftRecordFragment2);
        }
        ((ActivityGiftRecordBinding) getBinding()).viewPage.setOffscreenPageLimit(2);
        ((ActivityGiftRecordBinding) getBinding()).viewPage.setAdapter(new androidx.viewpager2.adapter.a() { // from class: com.qiahao.nextvideo.ui.giftRecords.GiftRecordActivity$initView$7
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(GiftRecordActivity.this);
            }

            public Fragment createFragment(int position) {
                ArrayList arrayList3;
                arrayList3 = GiftRecordActivity.this.mFragments;
                Object obj = arrayList3.get(position);
                Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
                return (Fragment) obj;
            }

            public int getItemCount() {
                ArrayList arrayList3;
                arrayList3 = GiftRecordActivity.this.mFragments;
                return arrayList3.size();
            }
        });
        ViewPage2TabLayout viewPage2TabLayout = ((ActivityGiftRecordBinding) getBinding()).tabSegment;
        ViewPager2 viewPager2 = ((ActivityGiftRecordBinding) getBinding()).viewPage;
        Intrinsics.checkNotNullExpressionValue(viewPager2, "viewPage");
        viewPage2TabLayout.setViewPager2(viewPager2, new TabGiftActivityAdapter());
        ViewPage2TabLayout viewPage2TabLayout2 = ((ActivityGiftRecordBinding) getBinding()).tabSegment;
        Intrinsics.checkNotNullExpressionValue(viewPage2TabLayout2, "tabSegment");
        com.oudi.widget.ViewKtxKt.disableTooltipText(viewPage2TabLayout2);
        ((ActivityGiftRecordBinding) getBinding()).viewPage.post(new Runnable() { // from class: com.qiahao.nextvideo.ui.giftRecords.c
            @Override // java.lang.Runnable
            public final void run() {
                GiftRecordActivity.initView$lambda$6(GiftRecordActivity.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initView$lambda$0(GiftRecordActivity giftRecordActivity, int i, int i2) {
        giftRecordActivity.getBinding().titleBar.bar.setLayoutParams(new LinearLayoutCompat.a(-2, i));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$6(GiftRecordActivity giftRecordActivity) {
        if (giftRecordActivity.selectPosition > 1) {
            return;
        }
        giftRecordActivity.getBinding().viewPage.setCurrentItem(giftRecordActivity.selectPosition);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public int getLayoutResId() {
        return R.layout.activity_gift_record;
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
