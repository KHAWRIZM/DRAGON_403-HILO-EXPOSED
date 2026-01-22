package com.qiahao.nextvideo.ui.promoter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.TextView;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.github.gzuliyujiang.wheelpicker.OptionPicker;
import com.oudi.core.status.SuperStatusView;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.UiKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.common.BaseActivity;
import com.qiahao.base_common.common.BaseBindingFragment;
import com.qiahao.base_common.model.ApiList;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.base_common.utils.ShapeUtil;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.FootLoading;
import com.qiahao.nextvideo.data.model.DealerDiamondConfig;
import com.qiahao.nextvideo.data.promote.PromoteRankData;
import com.qiahao.nextvideo.data.transfer.TransferDate;
import com.qiahao.nextvideo.data.transfer.TransferPeriod;
import com.qiahao.nextvideo.databinding.FragmentPromoterCenterBinding;
import com.qiahao.nextvideo.databinding.FragmentPromoterCenterHeadBinding;
import com.qiahao.nextvideo.databinding.IncludeTransferTextBinding;
import com.qiahao.nextvideo.utilities.userproxy.NumberUtilsKt;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 52\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00015B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010*\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0013J\b\u0010+\u001a\u00020\u0006H\u0014J\b\u0010,\u001a\u00020\rH\u0016J\b\u0010-\u001a\u00020\rH\u0003J\b\u0010.\u001a\u00020\rH\u0002J\b\u0010/\u001a\u00020\rH\u0007J\b\u00100\u001a\u00020\rH\u0002J\u0018\u00101\u001a\u0012\u0012\u0004\u0012\u00020302j\b\u0012\u0004\u0012\u000203`4H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R7\u0010\u0007\u001a\u001f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001b\u0010\u001f\u001a\u00020 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b!\u0010\"R\u001b\u0010%\u001a\u00020&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010$\u001a\u0004\b'\u0010(¨\u00066"}, d2 = {"Lcom/qiahao/nextvideo/ui/promoter/PromoterCenterFragment;", "Lcom/qiahao/base_common/common/BaseBindingFragment;", "Lcom/qiahao/nextvideo/databinding/FragmentPromoterCenterBinding;", "<init>", "()V", "mSelectPosition", "", "mListener", "Lkotlin/Function1;", "Lcom/qiahao/nextvideo/data/model/DealerDiamondConfig;", "Lkotlin/ParameterName;", "name", "data", "", "getMListener", "()Lkotlin/jvm/functions/Function1;", "setMListener", "(Lkotlin/jvm/functions/Function1;)V", "mPeriodData", "Lcom/qiahao/nextvideo/data/transfer/TransferPeriod;", "getMPeriodData", "()Lcom/qiahao/nextvideo/data/transfer/TransferPeriod;", "setMPeriodData", "(Lcom/qiahao/nextvideo/data/transfer/TransferPeriod;)V", "mHeaderBinding", "Lcom/qiahao/nextvideo/databinding/FragmentPromoterCenterHeadBinding;", "mType", "getMType", "()I", "setMType", "(I)V", "mViewModel", "Lcom/qiahao/nextvideo/ui/promoter/PromoterCenterViewModel;", "getMViewModel", "()Lcom/qiahao/nextvideo/ui/promoter/PromoterCenterViewModel;", "mViewModel$delegate", "Lkotlin/Lazy;", "mAdapter", "Lcom/qiahao/nextvideo/ui/promoter/PromoterFragmentCenterAdapter;", "getMAdapter", "()Lcom/qiahao/nextvideo/ui/promoter/PromoterFragmentCenterAdapter;", "mAdapter$delegate", "refreshPeriodData", "getLayoutResId", "onInitialize", "initData", "initView", "refreshRange", "showPickerDialog", "getPickerData", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nPromoterCenterFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PromoterCenterFragment.kt\ncom/qiahao/nextvideo/ui/promoter/PromoterCenterFragment\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,216:1\n1#2:217\n61#3,9:218\n1869#4,2:227\n1869#4,2:229\n*S KotlinDebug\n*F\n+ 1 PromoterCenterFragment.kt\ncom/qiahao/nextvideo/ui/promoter/PromoterCenterFragment\n*L\n117#1:218,9\n202#1:227,2\n207#1:229,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class PromoterCenterFragment extends BaseBindingFragment<FragmentPromoterCenterBinding> {
    public static final int PROMOTER_MONTH = 1;

    @NotNull
    public static final String PROMOTER_TYPE = "promoter_type";
    public static final int PROMOTER_WEEKLY = 0;

    @Nullable
    private FragmentPromoterCenterHeadBinding mHeaderBinding;

    @Nullable
    private Function1<? super DealerDiamondConfig, Unit> mListener;

    @Nullable
    private TransferPeriod mPeriodData;
    private int mType;
    private int mSelectPosition = -1;

    /* renamed from: mViewModel$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mViewModel = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.promoter.q
        public final Object invoke() {
            PromoterCenterViewModel mViewModel_delegate$lambda$0;
            mViewModel_delegate$lambda$0 = PromoterCenterFragment.mViewModel_delegate$lambda$0(PromoterCenterFragment.this);
            return mViewModel_delegate$lambda$0;
        }
    });

    /* renamed from: mAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.promoter.r
        public final Object invoke() {
            PromoterFragmentCenterAdapter mAdapter_delegate$lambda$1;
            mAdapter_delegate$lambda$1 = PromoterCenterFragment.mAdapter_delegate$lambda$1();
            return mAdapter_delegate$lambda$1;
        }
    });

    private final PromoterFragmentCenterAdapter getMAdapter() {
        return (PromoterFragmentCenterAdapter) this.mAdapter.getValue();
    }

    private final PromoterCenterViewModel getMViewModel() {
        return (PromoterCenterViewModel) this.mViewModel.getValue();
    }

    private final ArrayList<String> getPickerData() {
        ArrayList<TransferDate> month;
        int i;
        String str;
        ArrayList<TransferDate> week;
        ArrayList<String> arrayList = new ArrayList<>();
        if (this.mType == 0) {
            TransferPeriod transferPeriod = this.mPeriodData;
            if (transferPeriod != null && (week = transferPeriod.getWeek()) != null) {
                for (TransferDate transferDate : week) {
                    arrayList.add(transferDate.getStartDate() + "~" + transferDate.getEndDate());
                }
            }
        } else {
            TransferPeriod transferPeriod2 = this.mPeriodData;
            if (transferPeriod2 != null && (month = transferPeriod2.getMonth()) != null) {
                for (TransferDate transferDate2 : month) {
                    String startDate = transferDate2.getStartDate();
                    if (startDate != null) {
                        i = StringsKt.lastIndexOf$default(startDate, "-", 0, false, 6, (Object) null);
                    } else {
                        i = 0;
                    }
                    String startDate2 = transferDate2.getStartDate();
                    if (startDate2 != null) {
                        str = startDate2.substring(0, i);
                        Intrinsics.checkNotNullExpressionValue(str, "substring(...)");
                        if (str != null) {
                            arrayList.add(str);
                        }
                    }
                    str = "";
                    arrayList.add(str);
                }
            }
        }
        return arrayList;
    }

    @SuppressLint({"SetTextI18n"})
    private final void initData() {
        getMViewModel().getTransferRank().observe(this, new PromoterCenterFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.promoter.n
            public final Object invoke(Object obj) {
                Unit initData$lambda$3;
                initData$lambda$3 = PromoterCenterFragment.initData$lambda$3(PromoterCenterFragment.this, (ApiList) obj);
                return initData$lambda$3;
            }
        }));
        getMViewModel().getSearch().observe(this, new PromoterCenterFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.promoter.o
            public final Object invoke(Object obj) {
                Unit initData$lambda$4;
                initData$lambda$4 = PromoterCenterFragment.initData$lambda$4(PromoterCenterFragment.this, (PromoteRankData) obj);
                return initData$lambda$4;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$3(PromoterCenterFragment promoterCenterFragment, ApiList apiList) {
        SuperStatusView superStatusView;
        SmartRefreshLayout smartRefreshLayout;
        SmartRefreshLayout smartRefreshLayout2;
        FragmentPromoterCenterBinding fragmentPromoterCenterBinding;
        SmartRefreshLayout smartRefreshLayout3;
        if (promoterCenterFragment.getMViewModel().getTransferRankData().isOnePage()) {
            promoterCenterFragment.getMAdapter().setList(apiList.getData());
        } else {
            List data = apiList.getData();
            if (data != null) {
                promoterCenterFragment.getMAdapter().addData(data);
            }
        }
        if (!apiList.getHasNextPage() && (fragmentPromoterCenterBinding = (FragmentPromoterCenterBinding) promoterCenterFragment.getBinding()) != null && (smartRefreshLayout3 = fragmentPromoterCenterBinding.refreshLayout) != null) {
            smartRefreshLayout3.setNoMoreData(true);
        }
        FragmentPromoterCenterBinding fragmentPromoterCenterBinding2 = (FragmentPromoterCenterBinding) promoterCenterFragment.getBinding();
        if (fragmentPromoterCenterBinding2 != null && (smartRefreshLayout2 = fragmentPromoterCenterBinding2.refreshLayout) != null) {
            smartRefreshLayout2.finishRefresh();
        }
        FragmentPromoterCenterBinding fragmentPromoterCenterBinding3 = (FragmentPromoterCenterBinding) promoterCenterFragment.getBinding();
        if (fragmentPromoterCenterBinding3 != null && (smartRefreshLayout = fragmentPromoterCenterBinding3.refreshLayout) != null) {
            smartRefreshLayout.finishLoadMore();
        }
        FragmentPromoterCenterBinding fragmentPromoterCenterBinding4 = (FragmentPromoterCenterBinding) promoterCenterFragment.getBinding();
        if (fragmentPromoterCenterBinding4 != null && (superStatusView = fragmentPromoterCenterBinding4.statusView) != null) {
            superStatusView.showContent();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$4(PromoterCenterFragment promoterCenterFragment, PromoteRankData promoteRankData) {
        IncludeTransferTextBinding includeTransferTextBinding;
        TextView textView;
        IncludeTransferTextBinding includeTransferTextBinding2;
        TextView textView2;
        Integer num;
        IncludeTransferTextBinding includeTransferTextBinding3;
        TextView textView3;
        long j;
        Long totalC;
        FragmentPromoterCenterHeadBinding fragmentPromoterCenterHeadBinding = promoterCenterFragment.mHeaderBinding;
        if (fragmentPromoterCenterHeadBinding != null && (includeTransferTextBinding3 = fragmentPromoterCenterHeadBinding.rechargeAmount) != null && (textView3 = includeTransferTextBinding3.number) != null) {
            if (promoteRankData != null && (totalC = promoteRankData.getTotalC()) != null) {
                j = totalC.longValue();
            } else {
                j = 0;
            }
            textView3.setText("$" + NumberUtilsKt.rankNumberFormat(j / 100));
        }
        FragmentPromoterCenterHeadBinding fragmentPromoterCenterHeadBinding2 = promoterCenterFragment.mHeaderBinding;
        Integer num2 = null;
        if (fragmentPromoterCenterHeadBinding2 != null && (includeTransferTextBinding2 = fragmentPromoterCenterHeadBinding2.team) != null && (textView2 = includeTransferTextBinding2.number) != null) {
            if (promoteRankData != null) {
                num = promoteRankData.getPtNum();
            } else {
                num = null;
            }
            textView2.setText(String.valueOf(num));
        }
        FragmentPromoterCenterHeadBinding fragmentPromoterCenterHeadBinding3 = promoterCenterFragment.mHeaderBinding;
        if (fragmentPromoterCenterHeadBinding3 != null && (includeTransferTextBinding = fragmentPromoterCenterHeadBinding3.number) != null && (textView = includeTransferTextBinding.number) != null) {
            if (promoteRankData != null) {
                num2 = promoteRankData.getClients();
            }
            textView.setText(String.valueOf(num2));
        }
        return Unit.INSTANCE;
    }

    private final void initView() {
        int i;
        RecyclerView recyclerView;
        SmartRefreshLayout smartRefreshLayout;
        RecyclerView recyclerView2;
        SmartRefreshLayout smartRefreshLayout2;
        final View view;
        IncludeTransferTextBinding includeTransferTextBinding;
        TextView textView;
        IncludeTransferTextBinding includeTransferTextBinding2;
        TextView textView2;
        IncludeTransferTextBinding includeTransferTextBinding3;
        TextView textView3;
        View view2;
        View view3;
        View view4;
        Drawable drawable;
        View root;
        SmartRefreshLayout smartRefreshLayout3;
        Bundle arguments = getArguments();
        if (arguments != null) {
            i = arguments.getInt(PROMOTER_TYPE);
        } else {
            i = 0;
        }
        this.mType = i;
        Drawable drawable2 = null;
        this.mHeaderBinding = (FragmentPromoterCenterHeadBinding) androidx.databinding.g.h(LayoutInflater.from(getContext()), R.layout.fragment_promoter_center_head, (ViewGroup) null, false);
        Context context = getContext();
        if (context != null) {
            FootLoading footLoading = new FootLoading(context);
            FragmentPromoterCenterBinding fragmentPromoterCenterBinding = (FragmentPromoterCenterBinding) getBinding();
            if (fragmentPromoterCenterBinding != null && (smartRefreshLayout3 = fragmentPromoterCenterBinding.refreshLayout) != null) {
                smartRefreshLayout3.setRefreshFooter(footLoading);
            }
        }
        FragmentPromoterCenterHeadBinding fragmentPromoterCenterHeadBinding = this.mHeaderBinding;
        if (fragmentPromoterCenterHeadBinding != null && (root = fragmentPromoterCenterHeadBinding.getRoot()) != null) {
            BaseQuickAdapter.addHeaderView$default(getMAdapter(), root, 0, 0, 6, (Object) null);
        }
        FragmentPromoterCenterHeadBinding fragmentPromoterCenterHeadBinding2 = this.mHeaderBinding;
        if (fragmentPromoterCenterHeadBinding2 != null && (view4 = fragmentPromoterCenterHeadBinding2.selectBg) != null) {
            Context context2 = getContext();
            if (context2 != null) {
                drawable = ShapeUtil.createShape$default(ShapeUtil.INSTANCE, context2, 2131101214, 2131101214, 17, (GradientDrawable.Orientation) null, false, 48, (Object) null);
            } else {
                drawable = null;
            }
            view4.setBackground(drawable);
        }
        FragmentPromoterCenterHeadBinding fragmentPromoterCenterHeadBinding3 = this.mHeaderBinding;
        if (fragmentPromoterCenterHeadBinding3 != null && (view3 = fragmentPromoterCenterHeadBinding3.monthBg) != null) {
            Context context3 = getContext();
            if (context3 != null) {
                drawable2 = ShapeUtil.createShape$default(ShapeUtil.INSTANCE, context3, 2131101214, 2131101214, 5, (GradientDrawable.Orientation) null, false, 48, (Object) null);
            }
            view3.setBackground(drawable2);
        }
        FragmentPromoterCenterHeadBinding fragmentPromoterCenterHeadBinding4 = this.mHeaderBinding;
        if (fragmentPromoterCenterHeadBinding4 != null && (view2 = fragmentPromoterCenterHeadBinding4.saleDetail) != null) {
            view2.setBackground(ShapeUtil.INSTANCE.createShape("#8850f6", "#b043ff", 4, GradientDrawable.Orientation.TOP_BOTTOM));
        }
        FragmentPromoterCenterHeadBinding fragmentPromoterCenterHeadBinding5 = this.mHeaderBinding;
        if (fragmentPromoterCenterHeadBinding5 != null && (includeTransferTextBinding3 = fragmentPromoterCenterHeadBinding5.team) != null && (textView3 = includeTransferTextBinding3.title) != null) {
            textView3.setText(ResourcesKtxKt.getStringById(this, 2131954237));
        }
        FragmentPromoterCenterHeadBinding fragmentPromoterCenterHeadBinding6 = this.mHeaderBinding;
        if (fragmentPromoterCenterHeadBinding6 != null && (includeTransferTextBinding2 = fragmentPromoterCenterHeadBinding6.number) != null && (textView2 = includeTransferTextBinding2.title) != null) {
            textView2.setText(ResourcesKtxKt.getStringById(this, 2131953562));
        }
        FragmentPromoterCenterHeadBinding fragmentPromoterCenterHeadBinding7 = this.mHeaderBinding;
        if (fragmentPromoterCenterHeadBinding7 != null && (includeTransferTextBinding = fragmentPromoterCenterHeadBinding7.rechargeAmount) != null && (textView = includeTransferTextBinding.title) != null) {
            textView.setText(ResourcesKtxKt.getStringById(this, 2131953856));
        }
        FragmentPromoterCenterHeadBinding fragmentPromoterCenterHeadBinding8 = this.mHeaderBinding;
        if (fragmentPromoterCenterHeadBinding8 != null && (view = fragmentPromoterCenterHeadBinding8.selectBg) != null) {
            final long j = 800;
            view.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.promoter.PromoterCenterFragment$initView$$inlined$singleClick$default$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view5) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(view) > j || (view instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(view, currentTimeMillis);
                        this.showPickerDialog();
                    }
                }
            });
        }
        FragmentPromoterCenterBinding fragmentPromoterCenterBinding2 = (FragmentPromoterCenterBinding) getBinding();
        if (fragmentPromoterCenterBinding2 != null && (smartRefreshLayout2 = fragmentPromoterCenterBinding2.refreshLayout) != null) {
            smartRefreshLayout2.setOnLoadMoreListener(new vc.e() { // from class: com.qiahao.nextvideo.ui.promoter.s
                @Override // vc.e
                public final void onLoadMore(tc.f fVar) {
                    PromoterCenterFragment.initView$lambda$11(PromoterCenterFragment.this, fVar);
                }
            });
        }
        FragmentPromoterCenterBinding fragmentPromoterCenterBinding3 = (FragmentPromoterCenterBinding) getBinding();
        if (fragmentPromoterCenterBinding3 != null && (recyclerView2 = fragmentPromoterCenterBinding3.recyclerView) != null) {
            recyclerView2.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: com.qiahao.nextvideo.ui.promoter.PromoterCenterFragment$initView$8
                public void getItemOffsets(Rect outRect, View view5, RecyclerView parent, RecyclerView.State state) {
                    Intrinsics.checkNotNullParameter(outRect, "outRect");
                    Intrinsics.checkNotNullParameter(view5, "view");
                    Intrinsics.checkNotNullParameter(parent, "parent");
                    Intrinsics.checkNotNullParameter(state, "state");
                    super.getItemOffsets(outRect, view5, parent, state);
                    if (parent.getChildLayoutPosition(view5) == state.getItemCount() - 1) {
                        outRect.bottom = UiKtxKt.toPX(20);
                    }
                }
            });
        }
        FragmentPromoterCenterBinding fragmentPromoterCenterBinding4 = (FragmentPromoterCenterBinding) getBinding();
        if (fragmentPromoterCenterBinding4 != null && (smartRefreshLayout = fragmentPromoterCenterBinding4.refreshLayout) != null) {
            smartRefreshLayout.setOnRefreshListener(new vc.g() { // from class: com.qiahao.nextvideo.ui.promoter.t
                @Override // vc.g
                public final void onRefresh(tc.f fVar) {
                    PromoterCenterFragment.initView$lambda$12(PromoterCenterFragment.this, fVar);
                }
            });
        }
        FragmentPromoterCenterBinding fragmentPromoterCenterBinding5 = (FragmentPromoterCenterBinding) getBinding();
        if (fragmentPromoterCenterBinding5 != null && (recyclerView = fragmentPromoterCenterBinding5.recyclerView) != null) {
            recyclerView.setAdapter(getMAdapter());
        }
        refreshRange();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$11(PromoterCenterFragment promoterCenterFragment, tc.f fVar) {
        Intrinsics.checkNotNullParameter(fVar, "it");
        promoterCenterFragment.refreshRange();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$12(PromoterCenterFragment promoterCenterFragment, tc.f fVar) {
        Intrinsics.checkNotNullParameter(fVar, "it");
        promoterCenterFragment.getMViewModel().getTransferRankData().resetPage();
        promoterCenterFragment.refreshRange();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PromoterFragmentCenterAdapter mAdapter_delegate$lambda$1() {
        return new PromoterFragmentCenterAdapter();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PromoterCenterViewModel mViewModel_delegate$lambda$0(PromoterCenterFragment promoterCenterFragment) {
        return new ViewModelProvider(promoterCenterFragment).get(PromoterCenterViewModel.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showPickerDialog() {
        BaseActivity activity = HiloUtils.INSTANCE.getActivity(getContext());
        if (activity != null) {
            OptionPicker optionPicker = new OptionPicker(activity);
            optionPicker.F().setVisibility(8);
            TextView C = optionPicker.C();
            C.setTextColor(androidx.core.content.a.getColor(activity, 2131099914));
            Intrinsics.checkNotNull(C);
            C.setText(ResourcesKtxKt.getStringById(C, 2131952171));
            optionPicker.D().setBackgroundColor(androidx.core.content.a.getColor(activity, 2131099808));
            optionPicker.B().setBackgroundColor(androidx.core.content.a.getColor(activity, 2131101214));
            optionPicker.G().setVisibility(8);
            TextView E = optionPicker.E();
            E.setTextColor(androidx.core.content.a.getColor(activity, 2131099914));
            Intrinsics.checkNotNull(E);
            E.setText(ResourcesKtxKt.getStringById(E, 2131952331));
            optionPicker.K().setStyle(R.style.WheelStyleDemo);
            optionPicker.setCanceledOnTouchOutside(false);
            optionPicker.M(getPickerData());
            optionPicker.setOnOptionPickedListener(new r6.l() { // from class: com.qiahao.nextvideo.ui.promoter.p
                public final void a(int i, Object obj) {
                    PromoterCenterFragment.showPickerDialog$lambda$17$lambda$16(PromoterCenterFragment.this, i, obj);
                }
            });
            optionPicker.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showPickerDialog$lambda$17$lambda$16(PromoterCenterFragment promoterCenterFragment, int i, Object obj) {
        promoterCenterFragment.mSelectPosition = i;
        promoterCenterFragment.refreshRange();
    }

    protected int getLayoutResId() {
        return R.layout.fragment_promoter_center;
    }

    @Nullable
    public final Function1<DealerDiamondConfig, Unit> getMListener() {
        return this.mListener;
    }

    @Nullable
    public final TransferPeriod getMPeriodData() {
        return this.mPeriodData;
    }

    public final int getMType() {
        return this.mType;
    }

    public void onInitialize() {
        super/*com.qiahao.base_common.common.BaseFragment*/.onInitialize();
        initView();
        initData();
    }

    public final void refreshPeriodData(@Nullable TransferPeriod data) {
        ArrayList<TransferDate> month;
        ArrayList<TransferDate> week;
        if (this.mType == 0 && data != null && (week = data.getWeek()) != null && week.isEmpty()) {
            return;
        }
        if (this.mType == 1 && data != null && (month = data.getMonth()) != null && month.isEmpty()) {
            return;
        }
        this.mSelectPosition = 0;
        this.mPeriodData = data;
        refreshRange();
    }

    /* JADX WARN: Code restructure failed: missing block: B:57:0x0089, code lost:
    
        if (r0 == null) goto L٣٩;
     */
    @SuppressLint({"SetTextI18n"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void refreshRange() {
        int i;
        String str;
        TransferDate transferDate;
        TextView textView;
        String startDate;
        String startDate2;
        ArrayList<TransferDate> month;
        String str2;
        String str3;
        String str4;
        String endDate;
        TextView textView2;
        String str5;
        ArrayList<TransferDate> week;
        if (this.mSelectPosition == -1) {
            return;
        }
        TransferDate transferDate2 = null;
        String str6 = null;
        transferDate2 = null;
        String str7 = "";
        if (this.mType == 0) {
            TransferPeriod transferPeriod = this.mPeriodData;
            if (transferPeriod != null && (week = transferPeriod.getWeek()) != null) {
                transferDate = week.get(this.mSelectPosition);
            } else {
                transferDate = null;
            }
            FragmentPromoterCenterHeadBinding fragmentPromoterCenterHeadBinding = this.mHeaderBinding;
            if (fragmentPromoterCenterHeadBinding != null && (textView2 = fragmentPromoterCenterHeadBinding.time) != null) {
                if (transferDate != null) {
                    str5 = transferDate.getStartDate();
                } else {
                    str5 = null;
                }
                if (transferDate != null) {
                    str6 = transferDate.getEndDate();
                }
                textView2.setText(str5 + "~" + str6);
            }
        } else {
            TransferPeriod transferPeriod2 = this.mPeriodData;
            if (transferPeriod2 != null && (month = transferPeriod2.getMonth()) != null) {
                transferDate2 = month.get(this.mSelectPosition);
            }
            if (transferDate2 != null && (startDate2 = transferDate2.getStartDate()) != null) {
                i = StringsKt.lastIndexOf$default(startDate2, "-", 0, false, 6, (Object) null);
            } else {
                i = 0;
            }
            if (transferDate2 != null && (startDate = transferDate2.getStartDate()) != null) {
                str = startDate.substring(0, i);
                Intrinsics.checkNotNullExpressionValue(str, "substring(...)");
            }
            str = "";
            FragmentPromoterCenterHeadBinding fragmentPromoterCenterHeadBinding2 = this.mHeaderBinding;
            if (fragmentPromoterCenterHeadBinding2 != null && (textView = fragmentPromoterCenterHeadBinding2.time) != null) {
                textView.setText(str);
            }
            transferDate = transferDate2;
        }
        PromoterCenterViewModel mViewModel = getMViewModel();
        if (transferDate == null || (str2 = transferDate.getStartDate()) == null) {
            str2 = "";
        }
        if (transferDate == null || (str3 = transferDate.getEndDate()) == null) {
            str3 = "";
        }
        mViewModel.transferRange(str2, str3);
        PromoterCenterViewModel mViewModel2 = getMViewModel();
        if (transferDate == null || (str4 = transferDate.getStartDate()) == null) {
            str4 = "";
        }
        if (transferDate != null && (endDate = transferDate.getEndDate()) != null) {
            str7 = endDate;
        }
        mViewModel2.transferRank(str4, str7);
    }

    public final void setMListener(@Nullable Function1<? super DealerDiamondConfig, Unit> function1) {
        this.mListener = function1;
    }

    public final void setMPeriodData(@Nullable TransferPeriod transferPeriod) {
        this.mPeriodData = transferPeriod;
    }

    public final void setMType(int i) {
        this.mType = i;
    }
}
