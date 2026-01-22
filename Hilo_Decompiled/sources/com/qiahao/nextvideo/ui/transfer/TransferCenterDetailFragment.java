package com.qiahao.nextvideo.ui.transfer;

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
import androidx.constraintlayout.widget.ConstraintLayout;
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
import com.qiahao.nextvideo.data.transfer.TransferDate;
import com.qiahao.nextvideo.data.transfer.TransferMonth;
import com.qiahao.nextvideo.data.transfer.TransferPeriod;
import com.qiahao.nextvideo.databinding.FragmentTransferCenterDetailBinding;
import com.qiahao.nextvideo.databinding.FragmentTransferCenterHeadBinding;
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
import org.android.agoo.message.MessageService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 62\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00016B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010,\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0013J\b\u0010-\u001a\u00020\u0006H\u0014J\b\u0010.\u001a\u00020\rH\u0016J\b\u0010/\u001a\u00020\rH\u0003J\b\u00100\u001a\u00020\rH\u0002J\b\u00101\u001a\u00020\rH\u0007J\b\u00102\u001a\u00020\rH\u0002J\u0018\u00103\u001a\u0012\u0012\u0004\u0012\u00020\u001704j\b\u0012\u0004\u0012\u00020\u0017`5H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R7\u0010\u0007\u001a\u001f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001b\u0010!\u001a\u00020\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b#\u0010$R\u001b\u0010'\u001a\u00020(8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b+\u0010&\u001a\u0004\b)\u0010*¨\u00067"}, d2 = {"Lcom/qiahao/nextvideo/ui/transfer/TransferCenterDetailFragment;", "Lcom/qiahao/base_common/common/BaseBindingFragment;", "Lcom/qiahao/nextvideo/databinding/FragmentTransferCenterDetailBinding;", "<init>", "()V", "mSelectPosition", "", "mListener", "Lkotlin/Function1;", "Lcom/qiahao/nextvideo/data/model/DealerDiamondConfig;", "Lkotlin/ParameterName;", "name", "data", "", "getMListener", "()Lkotlin/jvm/functions/Function1;", "setMListener", "(Lkotlin/jvm/functions/Function1;)V", "mPeriodData", "Lcom/qiahao/nextvideo/data/transfer/TransferPeriod;", "mHeaderBinding", "Lcom/qiahao/nextvideo/databinding/FragmentTransferCenterHeadBinding;", "mCenterType", "", "getMCenterType", "()Ljava/lang/String;", "setMCenterType", "(Ljava/lang/String;)V", "mType", "getMType", "()I", "setMType", "(I)V", "mViewModel", "Lcom/qiahao/nextvideo/ui/transfer/TransferCenterViewModel;", "getMViewModel", "()Lcom/qiahao/nextvideo/ui/transfer/TransferCenterViewModel;", "mViewModel$delegate", "Lkotlin/Lazy;", "mAdapter", "Lcom/qiahao/nextvideo/ui/transfer/TransferFragmentCenterAdapter;", "getMAdapter", "()Lcom/qiahao/nextvideo/ui/transfer/TransferFragmentCenterAdapter;", "mAdapter$delegate", "refreshPeriodData", "getLayoutResId", "onInitialize", "initData", "initView", "refreshRange", "showPickerDialog", "getPickerData", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nTransferCenterDetailFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TransferCenterDetailFragment.kt\ncom/qiahao/nextvideo/ui/transfer/TransferCenterDetailFragment\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,226:1\n1#2:227\n61#3,9:228\n1869#4,2:237\n1869#4,2:239\n*S KotlinDebug\n*F\n+ 1 TransferCenterDetailFragment.kt\ncom/qiahao/nextvideo/ui/transfer/TransferCenterDetailFragment\n*L\n127#1:228,9\n212#1:237,2\n217#1:239,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class TransferCenterDetailFragment extends BaseBindingFragment<FragmentTransferCenterDetailBinding> {
    public static final int TRANSFER_MONTH = 1;

    @NotNull
    public static final String TRANSFER_TYPE = "transfer_type";
    public static final int TRANSFER_WEEKLY = 0;

    @Nullable
    private FragmentTransferCenterHeadBinding mHeaderBinding;

    @Nullable
    private Function1<? super DealerDiamondConfig, Unit> mListener;

    @Nullable
    private TransferPeriod mPeriodData;
    private int mType;
    private int mSelectPosition = -1;

    @NotNull
    private String mCenterType = TransferCenterFragment.TYPE_DIAMONDS;

    /* renamed from: mViewModel$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mViewModel = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.transfer.u0
        public final Object invoke() {
            TransferCenterViewModel mViewModel_delegate$lambda$0;
            mViewModel_delegate$lambda$0 = TransferCenterDetailFragment.mViewModel_delegate$lambda$0(TransferCenterDetailFragment.this);
            return mViewModel_delegate$lambda$0;
        }
    });

    /* renamed from: mAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.transfer.v0
        public final Object invoke() {
            TransferFragmentCenterAdapter mAdapter_delegate$lambda$1;
            mAdapter_delegate$lambda$1 = TransferCenterDetailFragment.mAdapter_delegate$lambda$1();
            return mAdapter_delegate$lambda$1;
        }
    });

    private final TransferFragmentCenterAdapter getMAdapter() {
        return (TransferFragmentCenterAdapter) this.mAdapter.getValue();
    }

    private final TransferCenterViewModel getMViewModel() {
        return (TransferCenterViewModel) this.mViewModel.getValue();
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
        getMViewModel().getTransferRank().observe(this, new TransferCenterDetailFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.transfer.w0
            public final Object invoke(Object obj) {
                Unit initData$lambda$3;
                initData$lambda$3 = TransferCenterDetailFragment.initData$lambda$3(TransferCenterDetailFragment.this, (ApiList) obj);
                return initData$lambda$3;
            }
        }));
        getMViewModel().getSearch().observe(this, new TransferCenterDetailFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.transfer.x0
            public final Object invoke(Object obj) {
                Unit initData$lambda$4;
                initData$lambda$4 = TransferCenterDetailFragment.initData$lambda$4(TransferCenterDetailFragment.this, (TransferMonth) obj);
                return initData$lambda$4;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$3(TransferCenterDetailFragment transferCenterDetailFragment, ApiList apiList) {
        SuperStatusView superStatusView;
        SmartRefreshLayout smartRefreshLayout;
        SmartRefreshLayout smartRefreshLayout2;
        FragmentTransferCenterDetailBinding fragmentTransferCenterDetailBinding;
        SmartRefreshLayout smartRefreshLayout3;
        if (transferCenterDetailFragment.getMViewModel().getTransferRankData().isOnePage()) {
            transferCenterDetailFragment.getMAdapter().setList(apiList.getData());
        } else {
            List data = apiList.getData();
            if (data != null) {
                transferCenterDetailFragment.getMAdapter().addData(data);
            }
        }
        if (!apiList.getHasNextPage() && (fragmentTransferCenterDetailBinding = (FragmentTransferCenterDetailBinding) transferCenterDetailFragment.getBinding()) != null && (smartRefreshLayout3 = fragmentTransferCenterDetailBinding.refreshLayout) != null) {
            smartRefreshLayout3.setNoMoreData(true);
        }
        FragmentTransferCenterDetailBinding fragmentTransferCenterDetailBinding2 = (FragmentTransferCenterDetailBinding) transferCenterDetailFragment.getBinding();
        if (fragmentTransferCenterDetailBinding2 != null && (smartRefreshLayout2 = fragmentTransferCenterDetailBinding2.refreshLayout) != null) {
            smartRefreshLayout2.finishRefresh();
        }
        FragmentTransferCenterDetailBinding fragmentTransferCenterDetailBinding3 = (FragmentTransferCenterDetailBinding) transferCenterDetailFragment.getBinding();
        if (fragmentTransferCenterDetailBinding3 != null && (smartRefreshLayout = fragmentTransferCenterDetailBinding3.refreshLayout) != null) {
            smartRefreshLayout.finishLoadMore();
        }
        FragmentTransferCenterDetailBinding fragmentTransferCenterDetailBinding4 = (FragmentTransferCenterDetailBinding) transferCenterDetailFragment.getBinding();
        if (fragmentTransferCenterDetailBinding4 != null && (superStatusView = fragmentTransferCenterDetailBinding4.statusView) != null) {
            superStatusView.showContent();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$4(TransferCenterDetailFragment transferCenterDetailFragment, TransferMonth transferMonth) {
        IncludeTransferTextBinding includeTransferTextBinding;
        TextView textView;
        String str;
        Integer clients;
        IncludeTransferTextBinding includeTransferTextBinding2;
        TextView textView2;
        Long totalC;
        IncludeTransferTextBinding includeTransferTextBinding3;
        TextView textView3;
        long j;
        Long dollar;
        FragmentTransferCenterHeadBinding fragmentTransferCenterHeadBinding = transferCenterDetailFragment.mHeaderBinding;
        long j2 = 0;
        if (fragmentTransferCenterHeadBinding != null && (includeTransferTextBinding3 = fragmentTransferCenterHeadBinding.salesLayout) != null && (textView3 = includeTransferTextBinding3.number) != null) {
            if (transferMonth != null && (dollar = transferMonth.getDollar()) != null) {
                j = dollar.longValue();
            } else {
                j = 0;
            }
            textView3.setText("$" + NumberUtilsKt.rankNumberFormat(j / 100));
        }
        FragmentTransferCenterHeadBinding fragmentTransferCenterHeadBinding2 = transferCenterDetailFragment.mHeaderBinding;
        if (fragmentTransferCenterHeadBinding2 != null && (includeTransferTextBinding2 = fragmentTransferCenterHeadBinding2.recharge) != null && (textView2 = includeTransferTextBinding2.number) != null) {
            if (transferMonth != null && (totalC = transferMonth.getTotalC()) != null) {
                j2 = totalC.longValue();
            }
            textView2.setText("$" + NumberUtilsKt.rankNumberFormat(j2 / 100));
        }
        FragmentTransferCenterHeadBinding fragmentTransferCenterHeadBinding3 = transferCenterDetailFragment.mHeaderBinding;
        if (fragmentTransferCenterHeadBinding3 != null && (includeTransferTextBinding = fragmentTransferCenterHeadBinding3.clientLayout) != null && (textView = includeTransferTextBinding.number) != null) {
            if (transferMonth == null || (clients = transferMonth.getClients()) == null || (str = clients.toString()) == null) {
                str = MessageService.MSG_DB_READY_REPORT;
            }
            textView.setText(str);
        }
        return Unit.INSTANCE;
    }

    private final void initView() {
        int i;
        String str;
        RecyclerView recyclerView;
        SmartRefreshLayout smartRefreshLayout;
        RecyclerView recyclerView2;
        SmartRefreshLayout smartRefreshLayout2;
        final View view;
        ConstraintLayout constraintLayout;
        IncludeTransferTextBinding includeTransferTextBinding;
        TextView textView;
        IncludeTransferTextBinding includeTransferTextBinding2;
        TextView textView2;
        IncludeTransferTextBinding includeTransferTextBinding3;
        TextView textView3;
        View view2;
        View view3;
        Drawable drawable;
        View view4;
        Drawable drawable2;
        View root;
        SmartRefreshLayout smartRefreshLayout3;
        Bundle arguments = getArguments();
        if (arguments != null) {
            i = arguments.getInt("transfer_type");
        } else {
            i = 0;
        }
        this.mType = i;
        Bundle arguments2 = getArguments();
        if (arguments2 == null || (str = arguments2.getString(TransferCenterFragment.CENTER_TYPE)) == null) {
            str = TransferCenterFragment.TYPE_DIAMONDS;
        }
        this.mCenterType = str;
        Drawable drawable3 = null;
        this.mHeaderBinding = (FragmentTransferCenterHeadBinding) androidx.databinding.g.h(LayoutInflater.from(getContext()), R.layout.fragment_transfer_center_head, (ViewGroup) null, false);
        Context context = getContext();
        if (context != null) {
            FootLoading footLoading = new FootLoading(context);
            FragmentTransferCenterDetailBinding fragmentTransferCenterDetailBinding = (FragmentTransferCenterDetailBinding) getBinding();
            if (fragmentTransferCenterDetailBinding != null && (smartRefreshLayout3 = fragmentTransferCenterDetailBinding.refreshLayout) != null) {
                smartRefreshLayout3.setRefreshFooter(footLoading);
            }
        }
        FragmentTransferCenterHeadBinding fragmentTransferCenterHeadBinding = this.mHeaderBinding;
        if (fragmentTransferCenterHeadBinding != null && (root = fragmentTransferCenterHeadBinding.getRoot()) != null) {
            BaseQuickAdapter.addHeaderView$default(getMAdapter(), root, 0, 0, 6, (Object) null);
        }
        FragmentTransferCenterHeadBinding fragmentTransferCenterHeadBinding2 = this.mHeaderBinding;
        if (fragmentTransferCenterHeadBinding2 != null && (view4 = fragmentTransferCenterHeadBinding2.selectBg) != null) {
            Context context2 = getContext();
            if (context2 != null) {
                drawable2 = ShapeUtil.createShape$default(ShapeUtil.INSTANCE, context2, 2131101214, 2131101214, 17, (GradientDrawable.Orientation) null, false, 48, (Object) null);
            } else {
                drawable2 = null;
            }
            view4.setBackground(drawable2);
        }
        FragmentTransferCenterHeadBinding fragmentTransferCenterHeadBinding3 = this.mHeaderBinding;
        if (fragmentTransferCenterHeadBinding3 != null && (view3 = fragmentTransferCenterHeadBinding3.numberBg) != null) {
            Context context3 = getContext();
            if (context3 != null) {
                drawable = ShapeUtil.createShape$default(ShapeUtil.INSTANCE, context3, 2131101214, 2131101214, 5, (GradientDrawable.Orientation) null, false, 48, (Object) null);
            } else {
                drawable = null;
            }
            view3.setBackground(drawable);
        }
        FragmentTransferCenterHeadBinding fragmentTransferCenterHeadBinding4 = this.mHeaderBinding;
        if (fragmentTransferCenterHeadBinding4 != null && (view2 = fragmentTransferCenterHeadBinding4.saleDetail) != null) {
            view2.setBackground(ShapeUtil.INSTANCE.createShape("#8850f6", "#b043ff", 4, GradientDrawable.Orientation.TOP_BOTTOM));
        }
        FragmentTransferCenterHeadBinding fragmentTransferCenterHeadBinding5 = this.mHeaderBinding;
        if (fragmentTransferCenterHeadBinding5 != null && (includeTransferTextBinding3 = fragmentTransferCenterHeadBinding5.salesLayout) != null && (textView3 = includeTransferTextBinding3.title) != null) {
            textView3.setText(ResourcesKtxKt.getStringById(this, 2131954300));
        }
        FragmentTransferCenterHeadBinding fragmentTransferCenterHeadBinding6 = this.mHeaderBinding;
        if (fragmentTransferCenterHeadBinding6 != null && (includeTransferTextBinding2 = fragmentTransferCenterHeadBinding6.recharge) != null && (textView2 = includeTransferTextBinding2.title) != null) {
            textView2.setText(ResourcesKtxKt.getStringById(this, 2131953850));
        }
        FragmentTransferCenterHeadBinding fragmentTransferCenterHeadBinding7 = this.mHeaderBinding;
        if (fragmentTransferCenterHeadBinding7 != null && (includeTransferTextBinding = fragmentTransferCenterHeadBinding7.clientLayout) != null && (textView = includeTransferTextBinding.title) != null) {
            textView.setText(ResourcesKtxKt.getStringById(this, 2131952270));
        }
        FragmentTransferCenterHeadBinding fragmentTransferCenterHeadBinding8 = this.mHeaderBinding;
        if (fragmentTransferCenterHeadBinding8 != null && (constraintLayout = fragmentTransferCenterHeadBinding8.titleLayout) != null) {
            Context context4 = getContext();
            if (context4 != null) {
                drawable3 = ShapeUtil.createShape$default(ShapeUtil.INSTANCE, context4, 2131101214, 2131101214, 5, 5, 0, 0, (GradientDrawable.Orientation) null, 128, (Object) null);
            }
            constraintLayout.setBackground(drawable3);
        }
        FragmentTransferCenterHeadBinding fragmentTransferCenterHeadBinding9 = this.mHeaderBinding;
        if (fragmentTransferCenterHeadBinding9 != null && (view = fragmentTransferCenterHeadBinding9.selectBg) != null) {
            final long j = 800;
            view.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.transfer.TransferCenterDetailFragment$initView$$inlined$singleClick$default$1
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
        FragmentTransferCenterDetailBinding fragmentTransferCenterDetailBinding2 = (FragmentTransferCenterDetailBinding) getBinding();
        if (fragmentTransferCenterDetailBinding2 != null && (smartRefreshLayout2 = fragmentTransferCenterDetailBinding2.refreshLayout) != null) {
            smartRefreshLayout2.setOnLoadMoreListener(new vc.e() { // from class: com.qiahao.nextvideo.ui.transfer.z0
                @Override // vc.e
                public final void onLoadMore(tc.f fVar) {
                    TransferCenterDetailFragment.initView$lambda$12(TransferCenterDetailFragment.this, fVar);
                }
            });
        }
        FragmentTransferCenterDetailBinding fragmentTransferCenterDetailBinding3 = (FragmentTransferCenterDetailBinding) getBinding();
        if (fragmentTransferCenterDetailBinding3 != null && (recyclerView2 = fragmentTransferCenterDetailBinding3.recyclerView) != null) {
            recyclerView2.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: com.qiahao.nextvideo.ui.transfer.TransferCenterDetailFragment$initView$9
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
        FragmentTransferCenterDetailBinding fragmentTransferCenterDetailBinding4 = (FragmentTransferCenterDetailBinding) getBinding();
        if (fragmentTransferCenterDetailBinding4 != null && (smartRefreshLayout = fragmentTransferCenterDetailBinding4.refreshLayout) != null) {
            smartRefreshLayout.setOnRefreshListener(new vc.g() { // from class: com.qiahao.nextvideo.ui.transfer.a1
                @Override // vc.g
                public final void onRefresh(tc.f fVar) {
                    TransferCenterDetailFragment.initView$lambda$13(TransferCenterDetailFragment.this, fVar);
                }
            });
        }
        FragmentTransferCenterDetailBinding fragmentTransferCenterDetailBinding5 = (FragmentTransferCenterDetailBinding) getBinding();
        if (fragmentTransferCenterDetailBinding5 != null && (recyclerView = fragmentTransferCenterDetailBinding5.recyclerView) != null) {
            recyclerView.setAdapter(getMAdapter());
        }
        refreshRange();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$12(TransferCenterDetailFragment transferCenterDetailFragment, tc.f fVar) {
        Intrinsics.checkNotNullParameter(fVar, "it");
        transferCenterDetailFragment.refreshRange();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$13(TransferCenterDetailFragment transferCenterDetailFragment, tc.f fVar) {
        Intrinsics.checkNotNullParameter(fVar, "it");
        transferCenterDetailFragment.getMViewModel().getTransferRankData().resetPage();
        transferCenterDetailFragment.refreshRange();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TransferFragmentCenterAdapter mAdapter_delegate$lambda$1() {
        return new TransferFragmentCenterAdapter();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TransferCenterViewModel mViewModel_delegate$lambda$0(TransferCenterDetailFragment transferCenterDetailFragment) {
        return new ViewModelProvider(transferCenterDetailFragment).get(TransferCenterViewModel.class);
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
            optionPicker.setOnOptionPickedListener(new r6.l() { // from class: com.qiahao.nextvideo.ui.transfer.y0
                public final void a(int i, Object obj) {
                    TransferCenterDetailFragment.showPickerDialog$lambda$18$lambda$17(TransferCenterDetailFragment.this, i, obj);
                }
            });
            optionPicker.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showPickerDialog$lambda$18$lambda$17(TransferCenterDetailFragment transferCenterDetailFragment, int i, Object obj) {
        transferCenterDetailFragment.mSelectPosition = i;
        transferCenterDetailFragment.refreshRange();
    }

    protected int getLayoutResId() {
        return R.layout.fragment_transfer_center_detail;
    }

    @NotNull
    public final String getMCenterType() {
        return this.mCenterType;
    }

    @Nullable
    public final Function1<DealerDiamondConfig, Unit> getMListener() {
        return this.mListener;
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
            FragmentTransferCenterHeadBinding fragmentTransferCenterHeadBinding = this.mHeaderBinding;
            if (fragmentTransferCenterHeadBinding != null && (textView2 = fragmentTransferCenterHeadBinding.time) != null) {
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
            FragmentTransferCenterHeadBinding fragmentTransferCenterHeadBinding2 = this.mHeaderBinding;
            if (fragmentTransferCenterHeadBinding2 != null && (textView = fragmentTransferCenterHeadBinding2.time) != null) {
                textView.setText(str);
            }
            transferDate = transferDate2;
        }
        TransferCenterViewModel mViewModel = getMViewModel();
        if (transferDate == null || (str2 = transferDate.getStartDate()) == null) {
            str2 = "";
        }
        if (transferDate == null || (str3 = transferDate.getEndDate()) == null) {
            str3 = "";
        }
        mViewModel.transferRange(str2, str3, !Intrinsics.areEqual(this.mCenterType, TransferCenterFragment.TYPE_DIAMONDS) ? 1 : 0);
        TransferCenterViewModel mViewModel2 = getMViewModel();
        if (transferDate == null || (str4 = transferDate.getStartDate()) == null) {
            str4 = "";
        }
        if (transferDate != null && (endDate = transferDate.getEndDate()) != null) {
            str7 = endDate;
        }
        mViewModel2.transferRank(str4, str7, !Intrinsics.areEqual(this.mCenterType, TransferCenterFragment.TYPE_DIAMONDS) ? 1 : 0);
    }

    public final void setMCenterType(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mCenterType = str;
    }

    public final void setMListener(@Nullable Function1<? super DealerDiamondConfig, Unit> function1) {
        this.mListener = function1;
    }

    public final void setMType(int i) {
        this.mType = i;
    }
}
