package com.qiahao.nextvideo.ui.cp;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.ViewPager2;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.common.BaseBindingFragment;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.model.cp.CpLevel;
import com.qiahao.base_common.support.BaseControlUtils;
import com.qiahao.base_common.utils.RelationTypeUtils;
import com.qiahao.base_common.utils.ShapeUtil;
import com.qiahao.base_common.utils.image.HiloImageView;
import com.qiahao.base_common.utils.image.ImageSizeKt;
import com.qiahao.base_common.wedgit.shineText.NickTextView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.cp.CpListData;
import com.qiahao.nextvideo.databinding.FragmentCpBinding;
import com.qiahao.nextvideo.ui.cp.CpSpaceActivity;
import com.qiahao.nextvideo.ui.cp.SearchUserActivity;
import com.qiahao.nextvideo.ui.store.StoreActivity;
import com.qiahao.nextvideo.utilities.DataExternalKt;
import com.qiahao.nextvideo.utilities.userproxy.NumberUtilsKt;
import com.qiahao.nextvideo.view.HiloTabLayout;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u001c2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001cB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0017\u001a\u00020\u0006H\u0014J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0019H\u0002J\b\u0010\u001b\u001a\u00020\u0019H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u000bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\fR\u001e\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001d"}, d2 = {"Lcom/qiahao/nextvideo/ui/cp/CpFragment;", "Lcom/qiahao/base_common/common/BaseBindingFragment;", "Lcom/qiahao/nextvideo/databinding/FragmentCpBinding;", "<init>", "()V", "mFragmentType", "", "mRelationShip", "", "fragmentPeriod", "titles", "", "[Ljava/lang/String;", "mFragments", "Ljava/util/ArrayList;", "Lcom/qiahao/nextvideo/ui/cp/CpChildFragment;", "Lkotlin/collections/ArrayList;", "viewModel", "Lcom/qiahao/nextvideo/ui/cp/CpRankViewModel;", "getViewModel", "()Lcom/qiahao/nextvideo/ui/cp/CpRankViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getLayoutResId", "onInitialize", "", "initView", "initData", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCpFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CpFragment.kt\ncom/qiahao/nextvideo/ui/cp/CpFragment\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n*L\n1#1,278:1\n61#2,9:279\n61#2,9:288\n61#2,9:297\n61#2,9:306\n*S KotlinDebug\n*F\n+ 1 CpFragment.kt\ncom/qiahao/nextvideo/ui/cp/CpFragment\n*L\n158#1:279,9\n167#1:288,9\n184#1:297,9\n187#1:306,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class CpFragment extends BaseBindingFragment<FragmentCpBinding> {

    @NotNull
    public static final String FRAGMENT_CP = "fragment_cp";

    @NotNull
    public static final String FRAGMENT_RELATIONSHIP = "fragment_relationship";

    @NotNull
    public static final String FRAGMENT_TYPE_RELATION = "fragment_type_relation";
    private int mFragmentType;

    @NotNull
    private String mRelationShip = FRAGMENT_CP;

    @NotNull
    private String fragmentPeriod = "";

    @NotNull
    private String[] titles = {ResourcesKtxKt.getStringById(this, 2131952477), ResourcesKtxKt.getStringById(this, 2131954482), ResourcesKtxKt.getStringById(this, 2131953415)};

    @NotNull
    private ArrayList<CpChildFragment> mFragments = new ArrayList<>();

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.cp.m
        public final Object invoke() {
            CpRankViewModel viewModel_delegate$lambda$0;
            viewModel_delegate$lambda$0 = CpFragment.viewModel_delegate$lambda$0(CpFragment.this);
            return viewModel_delegate$lambda$0;
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public final CpRankViewModel getViewModel() {
        return (CpRankViewModel) this.viewModel.getValue();
    }

    private final void initData() {
        getViewModel().getMyCp().observe(this, new CpFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.cp.l
            public final Object invoke(Object obj) {
                Unit initData$lambda$22;
                initData$lambda$22 = CpFragment.initData$lambda$22(CpFragment.this, (CpListData) obj);
                return initData$lambda$22;
            }
        }));
        getViewModel().myCp(this.mFragmentType);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$22(CpFragment cpFragment, CpListData cpListData) {
        User user;
        ImageView imageView;
        Integer num;
        int i;
        Drawable drawable;
        TextView textView;
        TextView textView2;
        ImageView imageView2;
        Drawable drawable2;
        ImageView imageView3;
        Drawable drawable3;
        User user2;
        TextView textView3;
        View view;
        TextView textView4;
        LinearLayout linearLayout;
        TextView textView5;
        TextView textView6;
        long j;
        TextView textView7;
        NickTextView nickTextView;
        String str;
        String nick;
        HiloImageView hiloImageView;
        TextView textView8;
        View view2;
        TextView textView9;
        LinearLayout linearLayout2;
        TextView textView10;
        NickTextView nickTextView2;
        HiloImageView hiloImageView2;
        TextView textView11;
        TextView textView12;
        ImageView imageView4;
        Drawable drawable4;
        ImageView imageView5;
        Integer num2;
        Drawable drawable5;
        CpLevel cpLevel;
        NickTextView nickTextView3;
        String str2;
        User user1;
        HiloImageView hiloImageView3;
        String str3;
        User user12;
        FragmentCpBinding fragmentCpBinding = (FragmentCpBinding) cpFragment.getBinding();
        String str4 = null;
        if (fragmentCpBinding != null && (hiloImageView3 = fragmentCpBinding.avatar1) != null) {
            if (cpListData != null && (user12 = cpListData.getUser1()) != null) {
                str3 = user12.getAvatar();
            } else {
                str3 = null;
            }
            HiloImageView.loadImage$default(hiloImageView3, ImageSizeKt.image100(str3), 2131231655, 0, 4, (Object) null);
        }
        FragmentCpBinding fragmentCpBinding2 = (FragmentCpBinding) cpFragment.getBinding();
        String str5 = "";
        if (fragmentCpBinding2 != null && (nickTextView3 = fragmentCpBinding2.nickName1) != null) {
            if (cpListData == null || (user1 = cpListData.getUser1()) == null || (str2 = user1.getNick()) == null) {
                str2 = "";
            }
            nickTextView3.setText(str2);
        }
        if (Intrinsics.areEqual(cpFragment.mRelationShip, FRAGMENT_CP)) {
            FragmentCpBinding fragmentCpBinding3 = (FragmentCpBinding) cpFragment.getBinding();
            if (fragmentCpBinding3 != null && (imageView5 = fragmentCpBinding3.medal) != null) {
                RelationTypeUtils relationTypeUtils = RelationTypeUtils.INSTANCE;
                if (cpListData != null && (cpLevel = cpListData.getCpLevel()) != null) {
                    num2 = cpLevel.getLevel();
                } else {
                    num2 = null;
                }
                Integer relationMedal$default = RelationTypeUtils.getRelationMedal$default(relationTypeUtils, num2, true, 0, 4, (Object) null);
                if (relationMedal$default != null) {
                    int intValue = relationMedal$default.intValue();
                    Context context = cpFragment.getContext();
                    if (context != null) {
                        drawable5 = androidx.core.content.a.getDrawable(context, intValue);
                        imageView5.setImageDrawable(drawable5);
                    }
                }
                drawable5 = null;
                imageView5.setImageDrawable(drawable5);
            }
            FragmentCpBinding fragmentCpBinding4 = (FragmentCpBinding) cpFragment.getBinding();
            if (fragmentCpBinding4 != null && (imageView4 = fragmentCpBinding4.heart) != null) {
                Context context2 = cpFragment.getContext();
                if (context2 != null) {
                    drawable4 = androidx.core.content.a.getDrawable(context2, R.drawable.icon_rank_pink_heart);
                } else {
                    drawable4 = null;
                }
                imageView4.setImageDrawable(drawable4);
            }
            FragmentCpBinding fragmentCpBinding5 = (FragmentCpBinding) cpFragment.getBinding();
            if (fragmentCpBinding5 != null && (textView12 = fragmentCpBinding5.cpZone) != null) {
                textView12.setText(ResourcesKtxKt.getStringById(cpFragment, 2131952450));
            }
            FragmentCpBinding fragmentCpBinding6 = (FragmentCpBinding) cpFragment.getBinding();
            if (fragmentCpBinding6 != null && (textView11 = fragmentCpBinding6.bindZone) != null) {
                textView11.setText(ResourcesKtxKt.getStringById(cpFragment, 2131952116));
            }
        } else {
            if (cpListData != null) {
                user = cpListData.getUser2();
            } else {
                user = null;
            }
            if (user == null) {
                FragmentCpBinding fragmentCpBinding7 = (FragmentCpBinding) cpFragment.getBinding();
                if (fragmentCpBinding7 != null && (imageView3 = fragmentCpBinding7.medal) != null) {
                    Context context3 = cpFragment.getContext();
                    if (context3 != null) {
                        drawable3 = androidx.core.content.a.getDrawable(context3, R.drawable.relationship_rank_love);
                    } else {
                        drawable3 = null;
                    }
                    imageView3.setImageDrawable(drawable3);
                }
            } else {
                FragmentCpBinding fragmentCpBinding8 = (FragmentCpBinding) cpFragment.getBinding();
                if (fragmentCpBinding8 != null && (imageView = fragmentCpBinding8.medal) != null) {
                    RelationTypeUtils relationTypeUtils2 = RelationTypeUtils.INSTANCE;
                    CpLevel cpLevel2 = cpListData.getCpLevel();
                    if (cpLevel2 != null) {
                        num = cpLevel2.getLevel();
                    } else {
                        num = null;
                    }
                    Integer type = cpListData.getType();
                    if (type != null) {
                        i = type.intValue();
                    } else {
                        i = 1;
                    }
                    Integer relationMedal = relationTypeUtils2.getRelationMedal(num, true, i);
                    if (relationMedal != null) {
                        int intValue2 = relationMedal.intValue();
                        Context context4 = cpFragment.getContext();
                        if (context4 != null) {
                            drawable = androidx.core.content.a.getDrawable(context4, intValue2);
                            imageView.setImageDrawable(drawable);
                        }
                    }
                    drawable = null;
                    imageView.setImageDrawable(drawable);
                }
            }
            FragmentCpBinding fragmentCpBinding9 = (FragmentCpBinding) cpFragment.getBinding();
            if (fragmentCpBinding9 != null && (imageView2 = fragmentCpBinding9.heart) != null) {
                Context context5 = cpFragment.getContext();
                if (context5 != null) {
                    drawable2 = androidx.core.content.a.getDrawable(context5, R.drawable.relationship_lv0);
                } else {
                    drawable2 = null;
                }
                imageView2.setImageDrawable(drawable2);
            }
            FragmentCpBinding fragmentCpBinding10 = (FragmentCpBinding) cpFragment.getBinding();
            if (fragmentCpBinding10 != null && (textView2 = fragmentCpBinding10.cpZone) != null) {
                textView2.setText(ResourcesKtxKt.getStringById(cpFragment, 2131953897));
            }
            FragmentCpBinding fragmentCpBinding11 = (FragmentCpBinding) cpFragment.getBinding();
            if (fragmentCpBinding11 != null && (textView = fragmentCpBinding11.bindZone) != null) {
                textView.setText(ResourcesKtxKt.getStringById(cpFragment, 2131952118));
            }
        }
        if (cpListData != null) {
            user2 = cpListData.getUser2();
        } else {
            user2 = null;
        }
        if (user2 == null) {
            FragmentCpBinding fragmentCpBinding12 = (FragmentCpBinding) cpFragment.getBinding();
            if (fragmentCpBinding12 != null && (hiloImageView2 = fragmentCpBinding12.avatar2) != null) {
                HiloImageView.loadImage$default(hiloImageView2, 2131231569, 0, 0, 6, (Object) null);
            }
            FragmentCpBinding fragmentCpBinding13 = (FragmentCpBinding) cpFragment.getBinding();
            if (fragmentCpBinding13 != null && (nickTextView2 = fragmentCpBinding13.nickName2) != null) {
                nickTextView2.setText("");
            }
            FragmentCpBinding fragmentCpBinding14 = (FragmentCpBinding) cpFragment.getBinding();
            if (fragmentCpBinding14 != null && (textView10 = fragmentCpBinding14.position) != null) {
                textView10.setVisibility(8);
            }
            FragmentCpBinding fragmentCpBinding15 = (FragmentCpBinding) cpFragment.getBinding();
            if (fragmentCpBinding15 != null && (linearLayout2 = fragmentCpBinding15.llDiamond) != null) {
                linearLayout2.setVisibility(8);
            }
            FragmentCpBinding fragmentCpBinding16 = (FragmentCpBinding) cpFragment.getBinding();
            if (fragmentCpBinding16 != null && (textView9 = fragmentCpBinding16.cpZone) != null) {
                textView9.setVisibility(8);
            }
            FragmentCpBinding fragmentCpBinding17 = (FragmentCpBinding) cpFragment.getBinding();
            if (fragmentCpBinding17 != null && (view2 = fragmentCpBinding17.line) != null) {
                view2.setVisibility(0);
            }
            FragmentCpBinding fragmentCpBinding18 = (FragmentCpBinding) cpFragment.getBinding();
            if (fragmentCpBinding18 != null && (textView8 = fragmentCpBinding18.bindZone) != null) {
                textView8.setVisibility(0);
            }
        } else {
            FragmentCpBinding fragmentCpBinding19 = (FragmentCpBinding) cpFragment.getBinding();
            if (fragmentCpBinding19 != null && (hiloImageView = fragmentCpBinding19.avatar2) != null) {
                User user22 = cpListData.getUser2();
                if (user22 != null) {
                    str4 = user22.getAvatar();
                }
                HiloImageView.loadImage$default(hiloImageView, ImageSizeKt.image100(str4), 2131231655, 0, 4, (Object) null);
            }
            FragmentCpBinding fragmentCpBinding20 = (FragmentCpBinding) cpFragment.getBinding();
            if (fragmentCpBinding20 != null && (nickTextView = fragmentCpBinding20.nickName2) != null) {
                User user23 = cpListData.getUser2();
                if (user23 == null || (nick = user23.getNick()) == null || (str = DataExternalKt.maxLengthSuffix(nick, 8, "...")) == null) {
                    str = "";
                }
                nickTextView.setText(str);
            }
            FragmentCpBinding fragmentCpBinding21 = (FragmentCpBinding) cpFragment.getBinding();
            if (fragmentCpBinding21 != null && (textView7 = fragmentCpBinding21.position) != null) {
                String ranking = cpListData.getRanking();
                if (ranking != null) {
                    str5 = ranking;
                }
                textView7.setText(str5);
            }
            FragmentCpBinding fragmentCpBinding22 = (FragmentCpBinding) cpFragment.getBinding();
            if (fragmentCpBinding22 != null && (textView6 = fragmentCpBinding22.cpValue) != null) {
                Long score = cpListData.getScore();
                if (score != null) {
                    j = score.longValue();
                } else {
                    j = 0;
                }
                textView6.setText(NumberUtilsKt.rankNumberFormat(j));
            }
            FragmentCpBinding fragmentCpBinding23 = (FragmentCpBinding) cpFragment.getBinding();
            if (fragmentCpBinding23 != null && (textView5 = fragmentCpBinding23.position) != null) {
                textView5.setVisibility(0);
            }
            FragmentCpBinding fragmentCpBinding24 = (FragmentCpBinding) cpFragment.getBinding();
            if (fragmentCpBinding24 != null && (linearLayout = fragmentCpBinding24.llDiamond) != null) {
                linearLayout.setVisibility(0);
            }
            FragmentCpBinding fragmentCpBinding25 = (FragmentCpBinding) cpFragment.getBinding();
            if (fragmentCpBinding25 != null && (textView4 = fragmentCpBinding25.cpZone) != null) {
                textView4.setVisibility(0);
            }
            FragmentCpBinding fragmentCpBinding26 = (FragmentCpBinding) cpFragment.getBinding();
            if (fragmentCpBinding26 != null && (view = fragmentCpBinding26.line) != null) {
                view.setVisibility(8);
            }
            FragmentCpBinding fragmentCpBinding27 = (FragmentCpBinding) cpFragment.getBinding();
            if (fragmentCpBinding27 != null && (textView3 = fragmentCpBinding27.bindZone) != null) {
                textView3.setVisibility(8);
            }
        }
        return Unit.INSTANCE;
    }

    private final void initView() {
        String str;
        int i;
        String str2;
        final HiloImageView hiloImageView;
        final HiloImageView hiloImageView2;
        final TextView textView;
        final TextView textView2;
        HiloTabLayout hiloTabLayout;
        ViewPager2 viewPager2;
        ViewPager2 viewPager22;
        HiloTabLayout hiloTabLayout2;
        TextView textView3;
        TextView textView4;
        Drawable drawable;
        Bundle arguments = getArguments();
        if (arguments == null || (str = arguments.getString(FRAGMENT_TYPE_RELATION)) == null) {
            str = FRAGMENT_CP;
        }
        this.mRelationShip = str;
        getViewModel().setMRelationShip(this.mRelationShip);
        Bundle arguments2 = getArguments();
        if (arguments2 != null) {
            i = arguments2.getInt("fragment_type");
        } else {
            i = 0;
        }
        this.mFragmentType = i;
        Bundle arguments3 = getArguments();
        if (arguments3 == null || (str2 = arguments3.getString("fragment_period")) == null) {
            str2 = "";
        }
        this.fragmentPeriod = str2;
        FragmentCpBinding fragmentCpBinding = (FragmentCpBinding) getBinding();
        Drawable drawable2 = null;
        if (fragmentCpBinding != null && (textView4 = fragmentCpBinding.bindZone) != null) {
            Context context = getContext();
            if (context != null) {
                drawable = ShapeUtil.createShape$default(ShapeUtil.INSTANCE, context, 2131099985, 2131099985, 13, (GradientDrawable.Orientation) null, false, 48, (Object) null);
            } else {
                drawable = null;
            }
            textView4.setBackground(drawable);
        }
        FragmentCpBinding fragmentCpBinding2 = (FragmentCpBinding) getBinding();
        if (fragmentCpBinding2 != null && (textView3 = fragmentCpBinding2.cpZone) != null) {
            Context context2 = getContext();
            if (context2 != null) {
                drawable2 = ShapeUtil.createShape$default(ShapeUtil.INSTANCE, context2, 2131099985, 2131099985, 13, (GradientDrawable.Orientation) null, false, 48, (Object) null);
            }
            textView3.setBackground(drawable2);
        }
        if (this.mFragments.isEmpty()) {
            ArrayList<CpChildFragment> arrayList = this.mFragments;
            final CpChildFragment cpChildFragment = new CpChildFragment();
            cpChildFragment.setListener(new Function1() { // from class: com.qiahao.nextvideo.ui.cp.i
                public final Object invoke(Object obj) {
                    Unit initView$lambda$4$lambda$3;
                    initView$lambda$4$lambda$3 = CpFragment.initView$lambda$4$lambda$3(CpChildFragment.this, ((Integer) obj).intValue());
                    return initView$lambda$4$lambda$3;
                }
            });
            Bundle bundle = new Bundle();
            bundle.putString(FRAGMENT_TYPE_RELATION, this.mRelationShip);
            bundle.putInt("fragment_type", 0);
            bundle.putString("fragment_period", "day");
            cpChildFragment.setArguments(bundle);
            arrayList.add(cpChildFragment);
            ArrayList<CpChildFragment> arrayList2 = this.mFragments;
            final CpChildFragment cpChildFragment2 = new CpChildFragment();
            cpChildFragment2.setListener(new Function1() { // from class: com.qiahao.nextvideo.ui.cp.j
                public final Object invoke(Object obj) {
                    Unit initView$lambda$6$lambda$5;
                    initView$lambda$6$lambda$5 = CpFragment.initView$lambda$6$lambda$5(CpChildFragment.this, ((Integer) obj).intValue());
                    return initView$lambda$6$lambda$5;
                }
            });
            Bundle bundle2 = new Bundle();
            bundle2.putString(FRAGMENT_TYPE_RELATION, this.mRelationShip);
            bundle2.putInt("fragment_type", 1);
            bundle2.putString("fragment_period", "week");
            cpChildFragment2.setArguments(bundle2);
            arrayList2.add(cpChildFragment2);
            ArrayList<CpChildFragment> arrayList3 = this.mFragments;
            final CpChildFragment cpChildFragment3 = new CpChildFragment();
            cpChildFragment3.setListener(new Function1() { // from class: com.qiahao.nextvideo.ui.cp.k
                public final Object invoke(Object obj) {
                    Unit initView$lambda$8$lambda$7;
                    initView$lambda$8$lambda$7 = CpFragment.initView$lambda$8$lambda$7(CpChildFragment.this, ((Integer) obj).intValue());
                    return initView$lambda$8$lambda$7;
                }
            });
            Bundle bundle3 = new Bundle();
            bundle3.putString(FRAGMENT_TYPE_RELATION, this.mRelationShip);
            bundle3.putInt("fragment_type", 2);
            bundle3.putString("fragment_period", "month");
            cpChildFragment3.setArguments(bundle3);
            arrayList3.add(cpChildFragment3);
        }
        FragmentCpBinding fragmentCpBinding3 = (FragmentCpBinding) getBinding();
        if (fragmentCpBinding3 != null && (hiloTabLayout2 = fragmentCpBinding3.tabLayout) != null) {
            hiloTabLayout2.setOnTabSelectListener(new o6.b() { // from class: com.qiahao.nextvideo.ui.cp.CpFragment$initView$6
                public void onTabReselect(int position) {
                }

                public void onTabSelect(int position) {
                    ViewPager2 viewPager23;
                    FragmentCpBinding fragmentCpBinding4 = (FragmentCpBinding) CpFragment.this.getBinding();
                    if (fragmentCpBinding4 != null && (viewPager23 = fragmentCpBinding4.viewPage) != null) {
                        viewPager23.setCurrentItem(position);
                    }
                }
            });
        }
        FragmentCpBinding fragmentCpBinding4 = (FragmentCpBinding) getBinding();
        if (fragmentCpBinding4 != null && (viewPager22 = fragmentCpBinding4.viewPage) != null) {
            viewPager22.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() { // from class: com.qiahao.nextvideo.ui.cp.CpFragment$initView$7
                public void onPageScrollStateChanged(int state) {
                }

                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                }

                public void onPageSelected(int position) {
                    CpRankViewModel viewModel;
                    HiloTabLayout hiloTabLayout3;
                    try {
                        FragmentCpBinding fragmentCpBinding5 = (FragmentCpBinding) CpFragment.this.getBinding();
                        if (fragmentCpBinding5 != null && (hiloTabLayout3 = fragmentCpBinding5.tabLayout) != null) {
                            hiloTabLayout3.setCurrentTab(position);
                        }
                        viewModel = CpFragment.this.getViewModel();
                        viewModel.myCp(position);
                    } catch (Exception unused) {
                    }
                }
            });
        }
        FragmentCpBinding fragmentCpBinding5 = (FragmentCpBinding) getBinding();
        if (fragmentCpBinding5 != null && (viewPager2 = fragmentCpBinding5.viewPage) != null) {
            viewPager2.setAdapter(new androidx.viewpager2.adapter.a() { // from class: com.qiahao.nextvideo.ui.cp.CpFragment$initView$8
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(CpFragment.this);
                }

                public Fragment createFragment(int position) {
                    ArrayList arrayList4;
                    arrayList4 = CpFragment.this.mFragments;
                    Object obj = arrayList4.get(position);
                    Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
                    return (Fragment) obj;
                }

                public int getItemCount() {
                    ArrayList arrayList4;
                    arrayList4 = CpFragment.this.mFragments;
                    return arrayList4.size();
                }
            });
        }
        FragmentCpBinding fragmentCpBinding6 = (FragmentCpBinding) getBinding();
        if (fragmentCpBinding6 != null && (hiloTabLayout = fragmentCpBinding6.tabLayout) != null) {
            hiloTabLayout.setTabData(this.titles);
        }
        FragmentCpBinding fragmentCpBinding7 = (FragmentCpBinding) getBinding();
        final long j = 800;
        if (fragmentCpBinding7 != null && (textView2 = fragmentCpBinding7.bindZone) != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.cp.CpFragment$initView$$inlined$singleClick$default$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    String str3;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView2) > j || (textView2 instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(textView2, currentTimeMillis);
                        Context context3 = this.getContext();
                        if (context3 != null) {
                            str3 = this.mRelationShip;
                            if (Intrinsics.areEqual(str3, CpFragment.FRAGMENT_CP)) {
                                SearchUserActivity.Companion.startActivity$default(SearchUserActivity.Companion, context3, SearchUserActivity.BIND_CP, null, 4, null);
                            } else {
                                StoreActivity.Companion.start(context3, 2);
                            }
                        }
                    }
                }
            });
        }
        FragmentCpBinding fragmentCpBinding8 = (FragmentCpBinding) getBinding();
        if (fragmentCpBinding8 != null && (textView = fragmentCpBinding8.cpZone) != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.cp.CpFragment$initView$$inlined$singleClick$default$2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    String str3;
                    CpRankViewModel viewModel;
                    String str4;
                    CpRankViewModel viewModel2;
                    CpRankViewModel viewModel3;
                    int i2;
                    Integer type;
                    User user2;
                    String externalId;
                    User user1;
                    CpRankViewModel viewModel4;
                    String str5;
                    User user12;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView) > j || (textView instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(textView, currentTimeMillis);
                        Context context3 = this.getContext();
                        if (context3 != null) {
                            str3 = this.mRelationShip;
                            String str6 = "";
                            if (Intrinsics.areEqual(str3, CpFragment.FRAGMENT_CP)) {
                                CpSpaceActivity.Companion companion = CpSpaceActivity.INSTANCE;
                                viewModel4 = this.getViewModel();
                                CpListData cpListData = (CpListData) viewModel4.getMyCp().getValue();
                                if (cpListData == null || (user12 = cpListData.getUser1()) == null || (str5 = user12.getExternalId()) == null) {
                                    str5 = "";
                                }
                                CpSpaceActivity.Companion.startActivity$default(companion, context3, str5, null, 0, 12, null);
                                return;
                            }
                            CpSpaceActivity.Companion companion2 = CpSpaceActivity.INSTANCE;
                            viewModel = this.getViewModel();
                            CpListData cpListData2 = (CpListData) viewModel.getMyCp().getValue();
                            if (cpListData2 == null || (user1 = cpListData2.getUser1()) == null || (str4 = user1.getExternalId()) == null) {
                                str4 = "";
                            }
                            viewModel2 = this.getViewModel();
                            CpListData cpListData3 = (CpListData) viewModel2.getMyCp().getValue();
                            if (cpListData3 != null && (user2 = cpListData3.getUser2()) != null && (externalId = user2.getExternalId()) != null) {
                                str6 = externalId;
                            }
                            viewModel3 = this.getViewModel();
                            CpListData cpListData4 = (CpListData) viewModel3.getMyCp().getValue();
                            if (cpListData4 != null && (type = cpListData4.getType()) != null) {
                                i2 = type.intValue();
                            } else {
                                i2 = 0;
                            }
                            companion2.startActivity(context3, str4, str6, i2);
                        }
                    }
                }
            });
        }
        FragmentCpBinding fragmentCpBinding9 = (FragmentCpBinding) getBinding();
        if (fragmentCpBinding9 != null && (hiloImageView2 = fragmentCpBinding9.avatar1) != null) {
            hiloImageView2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.cp.CpFragment$initView$$inlined$singleClick$default$3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CpRankViewModel viewModel;
                    String str3;
                    User user1;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(hiloImageView2) > j || (hiloImageView2 instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(hiloImageView2, currentTimeMillis);
                        HiloImageView hiloImageView3 = hiloImageView2;
                        BaseControlUtils baseControlUtils = BaseControlUtils.INSTANCE;
                        viewModel = this.getViewModel();
                        CpListData cpListData = (CpListData) viewModel.getMyCp().getValue();
                        if (cpListData == null || (user1 = cpListData.getUser1()) == null || (str3 = user1.getExternalId()) == null) {
                            str3 = "";
                        }
                        baseControlUtils.openPersonPage(str3);
                    }
                }
            });
        }
        FragmentCpBinding fragmentCpBinding10 = (FragmentCpBinding) getBinding();
        if (fragmentCpBinding10 != null && (hiloImageView = fragmentCpBinding10.avatar2) != null) {
            hiloImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.cp.CpFragment$initView$$inlined$singleClick$default$4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CpRankViewModel viewModel;
                    String str3;
                    User user2;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(hiloImageView) > j || (hiloImageView instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(hiloImageView, currentTimeMillis);
                        HiloImageView hiloImageView3 = hiloImageView;
                        BaseControlUtils baseControlUtils = BaseControlUtils.INSTANCE;
                        viewModel = this.getViewModel();
                        CpListData cpListData = (CpListData) viewModel.getMyCp().getValue();
                        if (cpListData == null || (user2 = cpListData.getUser2()) == null || (str3 = user2.getExternalId()) == null) {
                            str3 = "";
                        }
                        baseControlUtils.openPersonPage(str3);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initView$lambda$4$lambda$3(CpChildFragment cpChildFragment, int i) {
        cpChildFragment.getViewModel().myCp(i);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initView$lambda$6$lambda$5(CpChildFragment cpChildFragment, int i) {
        cpChildFragment.getViewModel().myCp(i);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initView$lambda$8$lambda$7(CpChildFragment cpChildFragment, int i) {
        cpChildFragment.getViewModel().myCp(i);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CpRankViewModel viewModel_delegate$lambda$0(CpFragment cpFragment) {
        return new ViewModelProvider(cpFragment).get(CpRankViewModel.class);
    }

    protected int getLayoutResId() {
        return R.layout.fragment_cp;
    }

    public void onInitialize() {
        super/*com.qiahao.base_common.common.BaseFragment*/.onInitialize();
        initView();
        initData();
    }
}
