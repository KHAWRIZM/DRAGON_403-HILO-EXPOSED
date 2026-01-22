package com.qiahao.nextvideo.ui.family;

import android.graphics.Color;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.common.BaseBindingFragment;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.databinding.FragmentFamilyStarBinding;
import com.qiahao.nextvideo.view.HiloTabLayout;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0012\u001a\u00020\u0006H\u0014J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0002J\b\u0010\u0016\u001a\u00020\u0014H\u0002J\u000e\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0006R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\rR\u001e\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u000fj\b\u0012\u0004\u0012\u00020\u0010`\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/qiahao/nextvideo/ui/family/FamilyStarFragment;", "Lcom/qiahao/base_common/common/BaseBindingFragment;", "Lcom/qiahao/nextvideo/databinding/FragmentFamilyStarBinding;", "<init>", "()V", "fragmentType", "", "fragmentPeriod", "", "familyID", "", "titles", "", "[Ljava/lang/String;", "mFragments", "Ljava/util/ArrayList;", "Lcom/qiahao/nextvideo/ui/family/FamilyStarChildFragment;", "Lkotlin/collections/ArrayList;", "getLayoutResId", "onInitialize", "", "initView", "initAdapter", "selectPosition", "position", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class FamilyStarFragment extends BaseBindingFragment<FragmentFamilyStarBinding> {
    private long familyID;
    private int fragmentType;

    @NotNull
    private String fragmentPeriod = "";

    @NotNull
    private String[] titles = {ResourcesKtxKt.getStringById(this, 2131952477), ResourcesKtxKt.getStringById(this, 2131954482), ResourcesKtxKt.getStringById(this, 2131953415)};

    @NotNull
    private ArrayList<FamilyStarChildFragment> mFragments = new ArrayList<>();

    private final void initAdapter() {
    }

    private final void initView() {
        int i;
        String str;
        long j;
        HiloTabLayout hiloTabLayout;
        ViewPager2 viewPager2;
        ViewPager2 viewPager22;
        ViewPager2 viewPager23;
        HiloTabLayout hiloTabLayout2;
        Bundle arguments = getArguments();
        if (arguments != null) {
            i = arguments.getInt("fragment_type");
        } else {
            i = 0;
        }
        this.fragmentType = i;
        Bundle arguments2 = getArguments();
        if (arguments2 == null || (str = arguments2.getString("fragment_period")) == null) {
            str = "";
        }
        this.fragmentPeriod = str;
        Bundle arguments3 = getArguments();
        if (arguments3 != null) {
            j = arguments3.getLong("familyID");
        } else {
            j = 0;
        }
        this.familyID = j;
        if (this.mFragments.isEmpty()) {
            ArrayList<FamilyStarChildFragment> arrayList = this.mFragments;
            FamilyStarChildFragment familyStarChildFragment = new FamilyStarChildFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("fragment_type", this.fragmentType);
            bundle.putString("fragment_period", "day");
            bundle.putLong("familyID", this.familyID);
            familyStarChildFragment.setArguments(bundle);
            arrayList.add(familyStarChildFragment);
            ArrayList<FamilyStarChildFragment> arrayList2 = this.mFragments;
            FamilyStarChildFragment familyStarChildFragment2 = new FamilyStarChildFragment();
            Bundle bundle2 = new Bundle();
            bundle2.putInt("fragment_type", this.fragmentType);
            bundle2.putString("fragment_period", "week");
            bundle2.putLong("familyID", this.familyID);
            familyStarChildFragment2.setArguments(bundle2);
            arrayList2.add(familyStarChildFragment2);
            ArrayList<FamilyStarChildFragment> arrayList3 = this.mFragments;
            FamilyStarChildFragment familyStarChildFragment3 = new FamilyStarChildFragment();
            Bundle bundle3 = new Bundle();
            bundle3.putInt("fragment_type", this.fragmentType);
            bundle3.putString("fragment_period", "month");
            bundle3.putLong("familyID", this.familyID);
            familyStarChildFragment3.setArguments(bundle3);
            arrayList3.add(familyStarChildFragment3);
        }
        selectPosition(this.fragmentType);
        FragmentFamilyStarBinding fragmentFamilyStarBinding = (FragmentFamilyStarBinding) getBinding();
        if (fragmentFamilyStarBinding != null && (hiloTabLayout2 = fragmentFamilyStarBinding.tabLayout) != null) {
            hiloTabLayout2.setOnTabSelectListener(new o6.b() { // from class: com.qiahao.nextvideo.ui.family.FamilyStarFragment$initView$4
                public void onTabReselect(int position) {
                }

                public void onTabSelect(int position) {
                    ViewPager2 viewPager24;
                    FragmentFamilyStarBinding fragmentFamilyStarBinding2 = (FragmentFamilyStarBinding) FamilyStarFragment.this.getBinding();
                    if (fragmentFamilyStarBinding2 != null && (viewPager24 = fragmentFamilyStarBinding2.viewPage) != null) {
                        viewPager24.setCurrentItem(position);
                    }
                }
            });
        }
        FragmentFamilyStarBinding fragmentFamilyStarBinding2 = (FragmentFamilyStarBinding) getBinding();
        if (fragmentFamilyStarBinding2 != null && (viewPager23 = fragmentFamilyStarBinding2.viewPage) != null) {
            viewPager23.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() { // from class: com.qiahao.nextvideo.ui.family.FamilyStarFragment$initView$5
                public void onPageScrollStateChanged(int state) {
                }

                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                }

                public void onPageSelected(int position) {
                    HiloTabLayout hiloTabLayout3;
                    try {
                        FragmentFamilyStarBinding fragmentFamilyStarBinding3 = (FragmentFamilyStarBinding) FamilyStarFragment.this.getBinding();
                        if (fragmentFamilyStarBinding3 != null && (hiloTabLayout3 = fragmentFamilyStarBinding3.tabLayout) != null) {
                            hiloTabLayout3.setCurrentTab(position);
                        }
                    } catch (Exception unused) {
                    }
                }
            });
        }
        FragmentFamilyStarBinding fragmentFamilyStarBinding3 = (FragmentFamilyStarBinding) getBinding();
        if (fragmentFamilyStarBinding3 != null && (viewPager22 = fragmentFamilyStarBinding3.viewPage) != null) {
            viewPager22.setOffscreenPageLimit(3);
        }
        FragmentFamilyStarBinding fragmentFamilyStarBinding4 = (FragmentFamilyStarBinding) getBinding();
        if (fragmentFamilyStarBinding4 != null && (viewPager2 = fragmentFamilyStarBinding4.viewPage) != null) {
            viewPager2.setAdapter(new androidx.viewpager2.adapter.a() { // from class: com.qiahao.nextvideo.ui.family.FamilyStarFragment$initView$6
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(FamilyStarFragment.this);
                }

                public Fragment createFragment(int position) {
                    ArrayList arrayList4;
                    arrayList4 = FamilyStarFragment.this.mFragments;
                    Object obj = arrayList4.get(position);
                    Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
                    return (Fragment) obj;
                }

                public int getItemCount() {
                    ArrayList arrayList4;
                    arrayList4 = FamilyStarFragment.this.mFragments;
                    return arrayList4.size();
                }
            });
        }
        FragmentFamilyStarBinding fragmentFamilyStarBinding5 = (FragmentFamilyStarBinding) getBinding();
        if (fragmentFamilyStarBinding5 != null && (hiloTabLayout = fragmentFamilyStarBinding5.tabLayout) != null) {
            hiloTabLayout.setTabData(this.titles);
        }
    }

    protected int getLayoutResId() {
        return R.layout.fragment_family_star;
    }

    public void onInitialize() {
        super/*com.qiahao.base_common.common.BaseFragment*/.onInitialize();
        initView();
        initAdapter();
    }

    public final void selectPosition(int position) {
        HiloTabLayout hiloTabLayout;
        HiloTabLayout hiloTabLayout2;
        FragmentFamilyStarBinding fragmentFamilyStarBinding;
        HiloTabLayout hiloTabLayout3;
        if (position != 1) {
            if (position != 2) {
                if (position == 3 && (fragmentFamilyStarBinding = (FragmentFamilyStarBinding) getBinding()) != null && (hiloTabLayout3 = fragmentFamilyStarBinding.tabLayout) != null) {
                    hiloTabLayout3.setTextSelectColor(Color.parseColor("#f67579"));
                    return;
                }
                return;
            }
            FragmentFamilyStarBinding fragmentFamilyStarBinding2 = (FragmentFamilyStarBinding) getBinding();
            if (fragmentFamilyStarBinding2 != null && (hiloTabLayout2 = fragmentFamilyStarBinding2.tabLayout) != null) {
                hiloTabLayout2.setTextSelectColor(Color.parseColor("#497dfd"));
                return;
            }
            return;
        }
        FragmentFamilyStarBinding fragmentFamilyStarBinding3 = (FragmentFamilyStarBinding) getBinding();
        if (fragmentFamilyStarBinding3 != null && (hiloTabLayout = fragmentFamilyStarBinding3.tabLayout) != null) {
            hiloTabLayout.setTextSelectColor(Color.parseColor("#ffa106"));
        }
    }
}
