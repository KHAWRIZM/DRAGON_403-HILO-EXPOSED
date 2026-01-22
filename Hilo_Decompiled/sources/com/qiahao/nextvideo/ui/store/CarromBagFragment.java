package com.qiahao.nextvideo.ui.store;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Checkable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.common.BaseBindingFragment;
import com.qiahao.base_common.utils.ShapeUtil;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.databinding.FragmentCarromBagBinding;
import com.qiahao.nextvideo.databinding.IncludeCarromTitleBinding;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\n\u0010\u0004J\u0015\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rR&\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0014\u001a\u00020\u00138\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/qiahao/nextvideo/ui/store/CarromBagFragment;", "Lcom/qiahao/base_common/common/BaseBindingFragment;", "Lcom/qiahao/nextvideo/databinding/FragmentCarromBagBinding;", "<init>", "()V", "", "initView", "", "getLayoutResId", "()I", "onInitialize", "position", "selectFragmentRefresh", "(I)V", "Ljava/util/ArrayList;", "Lcom/qiahao/nextvideo/ui/store/CarromBagChildFragment;", "Lkotlin/collections/ArrayList;", "mFragments", "Ljava/util/ArrayList;", "Landroidx/viewpager2/adapter/a;", "mPagerAdapter", "Landroidx/viewpager2/adapter/a;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCarromBagFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CarromBagFragment.kt\ncom/qiahao/nextvideo/ui/store/CarromBagFragment\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n*L\n1#1,103:1\n61#2,9:104\n61#2,9:113\n61#2,9:122\n*S KotlinDebug\n*F\n+ 1 CarromBagFragment.kt\ncom/qiahao/nextvideo/ui/store/CarromBagFragment\n*L\n37#1:104,9\n40#1:113,9\n43#1:122,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class CarromBagFragment extends BaseBindingFragment<FragmentCarromBagBinding> {

    @NotNull
    private ArrayList<CarromBagChildFragment> mFragments = new ArrayList<>();
    private androidx.viewpager2.adapter.a mPagerAdapter;

    private final void initView() {
        ViewPager2 viewPager2;
        ViewPager2 viewPager22;
        ViewPager2 viewPager23;
        IncludeCarromTitleBinding includeCarromTitleBinding;
        final View root;
        IncludeCarromTitleBinding includeCarromTitleBinding2;
        final View root2;
        IncludeCarromTitleBinding includeCarromTitleBinding3;
        final View root3;
        FragmentCarromBagBinding fragmentCarromBagBinding = (FragmentCarromBagBinding) getBinding();
        final long j = 800;
        if (fragmentCarromBagBinding != null && (includeCarromTitleBinding3 = fragmentCarromBagBinding.striker) != null && (root3 = includeCarromTitleBinding3.getRoot()) != null) {
            root3.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.store.CarromBagFragment$initView$$inlined$singleClick$default$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ViewPager2 viewPager24;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(root3) > j || (root3 instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(root3, currentTimeMillis);
                        FragmentCarromBagBinding fragmentCarromBagBinding2 = (FragmentCarromBagBinding) this.getBinding();
                        if (fragmentCarromBagBinding2 != null && (viewPager24 = fragmentCarromBagBinding2.viewPage) != null) {
                            viewPager24.setCurrentItem(0);
                        }
                    }
                }
            });
        }
        FragmentCarromBagBinding fragmentCarromBagBinding2 = (FragmentCarromBagBinding) getBinding();
        if (fragmentCarromBagBinding2 != null && (includeCarromTitleBinding2 = fragmentCarromBagBinding2.power) != null && (root2 = includeCarromTitleBinding2.getRoot()) != null) {
            root2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.store.CarromBagFragment$initView$$inlined$singleClick$default$2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ViewPager2 viewPager24;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(root2) > j || (root2 instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(root2, currentTimeMillis);
                        FragmentCarromBagBinding fragmentCarromBagBinding3 = (FragmentCarromBagBinding) this.getBinding();
                        if (fragmentCarromBagBinding3 != null && (viewPager24 = fragmentCarromBagBinding3.viewPage) != null) {
                            viewPager24.setCurrentItem(1);
                        }
                    }
                }
            });
        }
        FragmentCarromBagBinding fragmentCarromBagBinding3 = (FragmentCarromBagBinding) getBinding();
        if (fragmentCarromBagBinding3 != null && (includeCarromTitleBinding = fragmentCarromBagBinding3.pucks) != null && (root = includeCarromTitleBinding.getRoot()) != null) {
            root.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.store.CarromBagFragment$initView$$inlined$singleClick$default$3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ViewPager2 viewPager24;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(root) > j || (root instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(root, currentTimeMillis);
                        FragmentCarromBagBinding fragmentCarromBagBinding4 = (FragmentCarromBagBinding) this.getBinding();
                        if (fragmentCarromBagBinding4 != null && (viewPager24 = fragmentCarromBagBinding4.viewPage) != null) {
                            viewPager24.setCurrentItem(2);
                        }
                    }
                }
            });
        }
        if (this.mFragments.isEmpty()) {
            ArrayList<CarromBagChildFragment> arrayList = this.mFragments;
            CarromBagChildFragment carromBagChildFragment = new CarromBagChildFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("CARROM_TYPE", 1);
            carromBagChildFragment.setArguments(bundle);
            arrayList.add(carromBagChildFragment);
            ArrayList<CarromBagChildFragment> arrayList2 = this.mFragments;
            CarromBagChildFragment carromBagChildFragment2 = new CarromBagChildFragment();
            Bundle bundle2 = new Bundle();
            bundle2.putInt("CARROM_TYPE", 2);
            carromBagChildFragment2.setArguments(bundle2);
            arrayList2.add(carromBagChildFragment2);
            ArrayList<CarromBagChildFragment> arrayList3 = this.mFragments;
            CarromBagChildFragment carromBagChildFragment3 = new CarromBagChildFragment();
            Bundle bundle3 = new Bundle();
            bundle3.putInt("CARROM_TYPE", 3);
            carromBagChildFragment3.setArguments(bundle3);
            arrayList3.add(carromBagChildFragment3);
        }
        this.mPagerAdapter = new androidx.viewpager2.adapter.a() { // from class: com.qiahao.nextvideo.ui.store.CarromBagFragment$initView$7
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(CarromBagFragment.this);
            }

            public Fragment createFragment(int position) {
                ArrayList arrayList4;
                arrayList4 = CarromBagFragment.this.mFragments;
                Object obj = arrayList4.get(position);
                Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
                return (Fragment) obj;
            }

            public int getItemCount() {
                ArrayList arrayList4;
                arrayList4 = CarromBagFragment.this.mFragments;
                return arrayList4.size();
            }
        };
        FragmentCarromBagBinding fragmentCarromBagBinding4 = (FragmentCarromBagBinding) getBinding();
        if (fragmentCarromBagBinding4 != null && (viewPager23 = fragmentCarromBagBinding4.viewPage) != null) {
            viewPager23.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() { // from class: com.qiahao.nextvideo.ui.store.CarromBagFragment$initView$8
                public void onPageScrollStateChanged(int state) {
                }

                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                }

                public void onPageSelected(int position) {
                    CarromBagFragment.this.selectFragmentRefresh(position);
                }
            });
        }
        FragmentCarromBagBinding fragmentCarromBagBinding5 = (FragmentCarromBagBinding) getBinding();
        if (fragmentCarromBagBinding5 != null && (viewPager22 = fragmentCarromBagBinding5.viewPage) != null) {
            viewPager22.setOffscreenPageLimit(3);
        }
        FragmentCarromBagBinding fragmentCarromBagBinding6 = (FragmentCarromBagBinding) getBinding();
        if (fragmentCarromBagBinding6 != null && (viewPager2 = fragmentCarromBagBinding6.viewPage) != null) {
            RecyclerView.Adapter adapter = this.mPagerAdapter;
            if (adapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPagerAdapter");
                adapter = null;
            }
            viewPager2.setAdapter(adapter);
        }
        selectFragmentRefresh(0);
    }

    protected int getLayoutResId() {
        return R.layout.fragment_carrom_bag;
    }

    public void onInitialize() {
        super/*com.qiahao.base_common.common.BaseFragment*/.onInitialize();
        initView();
    }

    public final void selectFragmentRefresh(int position) {
        IncludeCarromTitleBinding includeCarromTitleBinding;
        View root;
        Drawable createShapeStroke$default;
        IncludeCarromTitleBinding includeCarromTitleBinding2;
        View root2;
        Drawable createShapeStroke$default2;
        IncludeCarromTitleBinding includeCarromTitleBinding3;
        View root3;
        Drawable createShapeStroke$default3;
        FragmentCarromBagBinding fragmentCarromBagBinding = (FragmentCarromBagBinding) getBinding();
        if (fragmentCarromBagBinding != null && (includeCarromTitleBinding3 = fragmentCarromBagBinding.striker) != null && (root3 = includeCarromTitleBinding3.getRoot()) != null) {
            if (position != 0) {
                createShapeStroke$default3 = ShapeUtil.createShape$default(ShapeUtil.INSTANCE, "#ffffff", "#ffffff", 6, (GradientDrawable.Orientation) null, 8, (Object) null);
            } else {
                createShapeStroke$default3 = ShapeUtil.createShapeStroke$default(ShapeUtil.INSTANCE, "#8829FE", 6, 1.0f, false, "#ffffff", (String) null, (GradientDrawable.Orientation) null, 96, (Object) null);
            }
            root3.setBackground(createShapeStroke$default3);
        }
        FragmentCarromBagBinding fragmentCarromBagBinding2 = (FragmentCarromBagBinding) getBinding();
        if (fragmentCarromBagBinding2 != null && (includeCarromTitleBinding2 = fragmentCarromBagBinding2.power) != null && (root2 = includeCarromTitleBinding2.getRoot()) != null) {
            ShapeUtil shapeUtil = ShapeUtil.INSTANCE;
            if (position != 1) {
                createShapeStroke$default2 = ShapeUtil.createShape$default(shapeUtil, "#ffffff", "#ffffff", 6, (GradientDrawable.Orientation) null, 8, (Object) null);
            } else {
                createShapeStroke$default2 = ShapeUtil.createShapeStroke$default(shapeUtil, "#8829FE", 6, 1.0f, false, "#ffffff", (String) null, (GradientDrawable.Orientation) null, 96, (Object) null);
            }
            root2.setBackground(createShapeStroke$default2);
        }
        FragmentCarromBagBinding fragmentCarromBagBinding3 = (FragmentCarromBagBinding) getBinding();
        if (fragmentCarromBagBinding3 != null && (includeCarromTitleBinding = fragmentCarromBagBinding3.pucks) != null && (root = includeCarromTitleBinding.getRoot()) != null) {
            if (position != 2) {
                createShapeStroke$default = ShapeUtil.createShape$default(ShapeUtil.INSTANCE, "#ffffff", "#ffffff", 6, (GradientDrawable.Orientation) null, 8, (Object) null);
            } else {
                createShapeStroke$default = ShapeUtil.createShapeStroke$default(ShapeUtil.INSTANCE, "#8829FE", 6, 1.0f, false, "#ffffff", (String) null, (GradientDrawable.Orientation) null, 96, (Object) null);
            }
            root.setBackground(createShapeStroke$default);
        }
    }
}
