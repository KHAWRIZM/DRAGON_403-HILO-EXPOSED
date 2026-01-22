package com.qiahao.nextvideo.ui.home.discover;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.oudi.widget.ViewPage2TabLayout;
import com.qiahao.base_common.common.BaseActivity;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.HiloBaseBindingActivity;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.databinding.ActivityActivitiesBinding;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u000b\u001a\u00020\fH\u0014J\b\u0010\r\u001a\u00020\u000eH\u0016R\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\n0\u0006j\b\u0012\u0004\u0012\u00020\n`\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/qiahao/nextvideo/ui/home/discover/ActivitiesActivity;", "Lcom/qiahao/nextvideo/app/base/HiloBaseBindingActivity;", "Lcom/qiahao/nextvideo/databinding/ActivityActivitiesBinding;", "<init>", "()V", "mTypeList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "mFragments", "Lcom/qiahao/nextvideo/ui/home/discover/ActivitiesFragment;", "getLayoutResId", "", "onInitialize", "", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nActivitiesActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ActivitiesActivity.kt\ncom/qiahao/nextvideo/ui/home/discover/ActivitiesActivity\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n*L\n1#1,93:1\n61#2,9:94\n61#2,9:103\n*S KotlinDebug\n*F\n+ 1 ActivitiesActivity.kt\ncom/qiahao/nextvideo/ui/home/discover/ActivitiesActivity\n*L\n44#1:94,9\n48#1:103,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class ActivitiesActivity extends HiloBaseBindingActivity<ActivityActivitiesBinding> {

    @NotNull
    public static final String FRAGMENT_TYPE = "fragment_type";

    @NotNull
    public static final String TYPE_SQUARE = "Square";

    @NotNull
    public static final String TYPE_SUBSCRIBED = "Subscribed";

    @NotNull
    private ArrayList<String> mTypeList = new ArrayList<>();

    @NotNull
    private ArrayList<ActivitiesFragment> mFragments = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onInitialize$lambda$0(ActivitiesActivity activitiesActivity, int i, int i2) {
        activitiesActivity.getBinding().bar.setLayoutParams(new LinearLayoutCompat.a(-2, i));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public int getLayoutResId() {
        return R.layout.activity_activities;
    }

    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onInitialize() {
        super.onInitialize();
        View view = getBinding().bar;
        Intrinsics.checkNotNullExpressionValue(view, "bar");
        getStatusBarTopOrBottom(view, new Function2() { // from class: com.qiahao.nextvideo.ui.home.discover.a
            public final Object invoke(Object obj, Object obj2) {
                Unit onInitialize$lambda$0;
                onInitialize$lambda$0 = ActivitiesActivity.onInitialize$lambda$0(ActivitiesActivity.this, ((Integer) obj).intValue(), ((Integer) obj2).intValue());
                return onInitialize$lambda$0;
            }
        });
        final AppCompatImageView appCompatImageView = getBinding().backImageView;
        final long j = 800;
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.home.discover.ActivitiesActivity$onInitialize$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(appCompatImageView) > j || (appCompatImageView instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(appCompatImageView, currentTimeMillis);
                    AppCompatImageView appCompatImageView2 = appCompatImageView;
                    this.onBackPressed();
                }
            }
        });
        final ImageView imageView = getBinding().createActivity;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.home.discover.ActivitiesActivity$onInitialize$$inlined$singleClick$default$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                String str;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(imageView) > j || (imageView instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(imageView, currentTimeMillis);
                    UserStore.Companion companion = UserStore.INSTANCE;
                    User user = companion.getShared().getUser();
                    String str2 = null;
                    if (user != null) {
                        str = user.getGroupId();
                    } else {
                        str = null;
                    }
                    if (!TextUtils.isEmpty(str)) {
                        Intent intent = new Intent((Context) this, (Class<?>) CreateActivitiesActivity.class);
                        User user2 = companion.getShared().getUser();
                        if (user2 != null) {
                            str2 = user2.getGroupId();
                        }
                        intent.putExtra("groupId", str2);
                        this.startActivity(intent);
                        return;
                    }
                    HiloToasty.Companion companion2 = HiloToasty.Companion;
                    BaseActivity baseActivity = this;
                    Toast normal$default = HiloToasty.Companion.normal$default(companion2, baseActivity, ResourcesKtxKt.getStringById(baseActivity, 2131952453), false, 4, (Object) null);
                    if (normal$default != null) {
                        normal$default.show();
                    }
                }
            }
        });
        ArrayList<ActivitiesFragment> arrayList = this.mFragments;
        if (arrayList == null || arrayList.isEmpty()) {
            this.mTypeList.add(ResourcesKtxKt.getStringById(this, 2131954125));
            ArrayList<ActivitiesFragment> arrayList2 = this.mFragments;
            ActivitiesFragment activitiesFragment = new ActivitiesFragment();
            Bundle bundle = new Bundle();
            bundle.putString("fragment_type", TYPE_SQUARE);
            activitiesFragment.setArguments(bundle);
            arrayList2.add(activitiesFragment);
            this.mTypeList.add(ResourcesKtxKt.getStringById(this, 2131954175));
            ArrayList<ActivitiesFragment> arrayList3 = this.mFragments;
            ActivitiesFragment activitiesFragment2 = new ActivitiesFragment();
            Bundle bundle2 = new Bundle();
            bundle2.putString("fragment_type", TYPE_SUBSCRIBED);
            activitiesFragment2.setArguments(bundle2);
            arrayList3.add(activitiesFragment2);
        }
        getBinding().viewPage.setAdapter(new androidx.viewpager2.adapter.a() { // from class: com.qiahao.nextvideo.ui.home.discover.ActivitiesActivity$onInitialize$6
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(ActivitiesActivity.this);
            }

            public Fragment createFragment(int position) {
                ArrayList arrayList4;
                arrayList4 = ActivitiesActivity.this.mFragments;
                Object obj = arrayList4.get(position);
                Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
                return (Fragment) obj;
            }

            public int getItemCount() {
                ArrayList arrayList4;
                arrayList4 = ActivitiesActivity.this.mFragments;
                return arrayList4.size();
            }
        });
        ViewPage2TabLayout viewPage2TabLayout = getBinding().tabLayout;
        ViewPager2 viewPager2 = getBinding().viewPage;
        Intrinsics.checkNotNullExpressionValue(viewPager2, "viewPage");
        viewPage2TabLayout.setViewPager2(viewPager2, new ActivitiesTabLayoutAdapter(this.mTypeList));
    }
}
