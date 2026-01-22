package com.qiahao.nextvideo.ui.firstCharge;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.oudi.utils.SpannableTextBuilder;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.common.BaseBindingFragment;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.firstCharge.FirstChargeAward;
import com.qiahao.nextvideo.data.firstCharge.FirstChargeData;
import com.qiahao.nextvideo.databinding.FragmentFirstChargeBinding;
import java.util.Arrays;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 *2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001*B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010%\u001a\u00020&H\u0014J\b\u0010'\u001a\u00020\u0007H\u0016J\b\u0010(\u001a\u00020\u0007H\u0003J\b\u0010)\u001a\u00020\u0007H\u0016R\"\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001b\u0010\u001f\u001a\u00020 8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b!\u0010\"¨\u0006+"}, d2 = {"Lcom/qiahao/nextvideo/ui/firstCharge/FirstChargeFragment;", "Lcom/qiahao/base_common/common/BaseBindingFragment;", "Lcom/qiahao/nextvideo/databinding/FragmentFirstChargeBinding;", "<init>", "()V", "mListener", "Lkotlin/Function0;", "", "getMListener", "()Lkotlin/jvm/functions/Function0;", "setMListener", "(Lkotlin/jvm/functions/Function0;)V", "mCharge", "", "getMCharge", "()Ljava/lang/Float;", "setMCharge", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "mText", "", "getMText", "()Ljava/lang/String;", "setMText", "(Ljava/lang/String;)V", "mPageData", "Lcom/qiahao/nextvideo/data/firstCharge/FirstChargeData;", "getMPageData", "()Lcom/qiahao/nextvideo/data/firstCharge/FirstChargeData;", "setMPageData", "(Lcom/qiahao/nextvideo/data/firstCharge/FirstChargeData;)V", "mAdapter", "Lcom/qiahao/nextvideo/ui/firstCharge/FirstChargeAdapter;", "getMAdapter", "()Lcom/qiahao/nextvideo/ui/firstCharge/FirstChargeAdapter;", "mAdapter$delegate", "Lkotlin/Lazy;", "getLayoutResId", "", "onInitialize", "initView", "onDestroy", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class FirstChargeFragment extends BaseBindingFragment<FragmentFirstChargeBinding> {

    @NotNull
    public static final String FIRST_DATA = "first_data";

    @NotNull
    public static final String FIRST_TEXT = "first_text";

    @NotNull
    public static final String FRAGMENT_TYPE = "fragment_type";

    /* renamed from: mAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.firstCharge.b
        public final Object invoke() {
            FirstChargeAdapter mAdapter_delegate$lambda$0;
            mAdapter_delegate$lambda$0 = FirstChargeFragment.mAdapter_delegate$lambda$0();
            return mAdapter_delegate$lambda$0;
        }
    });

    @Nullable
    private Float mCharge;

    @Nullable
    private Function0<Unit> mListener;

    @Nullable
    private FirstChargeData mPageData;

    @Nullable
    private String mText;

    @SuppressLint({"SetTextI18n"})
    private final void initView() {
        Float f;
        FirstChargeData firstChargeData;
        String str;
        TextView textView;
        TextView textView2;
        Long l;
        List<FirstChargeAward> awards;
        RecyclerView recyclerView;
        Bundle arguments = getArguments();
        TextView textView3 = null;
        if (arguments != null) {
            f = Float.valueOf(arguments.getFloat("fragment_type", 0.0f));
        } else {
            f = null;
        }
        this.mCharge = f;
        Bundle arguments2 = getArguments();
        if (arguments2 != null) {
            firstChargeData = (FirstChargeData) arguments2.getParcelable(FIRST_DATA);
        } else {
            firstChargeData = null;
        }
        this.mPageData = firstChargeData;
        Bundle arguments3 = getArguments();
        if (arguments3 != null) {
            str = arguments3.getString(FIRST_TEXT);
        } else {
            str = null;
        }
        this.mText = str;
        FragmentFirstChargeBinding fragmentFirstChargeBinding = (FragmentFirstChargeBinding) getBinding();
        if (fragmentFirstChargeBinding != null && (recyclerView = fragmentFirstChargeBinding.recyclerView) != null) {
            recyclerView.setAdapter(getMAdapter());
        }
        FirstChargeData firstChargeData2 = this.mPageData;
        if (firstChargeData2 != null && (awards = firstChargeData2.getAwards()) != null) {
            getMAdapter().setList(awards);
        }
        FragmentFirstChargeBinding fragmentFirstChargeBinding2 = (FragmentFirstChargeBinding) getBinding();
        if (fragmentFirstChargeBinding2 != null && (textView2 = fragmentFirstChargeBinding2.allDiamond) != null) {
            FirstChargeData firstChargeData3 = this.mPageData;
            if (firstChargeData3 != null) {
                l = firstChargeData3.getDiamondValue();
            } else {
                l = null;
            }
            textView2.setText(String.valueOf(l));
        }
        String format = String.format(ResourcesKtxKt.getStringById(this, 2131952757), Arrays.copyOf(new Object[]{String.valueOf(this.mText)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        FragmentFirstChargeBinding fragmentFirstChargeBinding3 = (FragmentFirstChargeBinding) getBinding();
        if (fragmentFirstChargeBinding3 != null && (textView = fragmentFirstChargeBinding3.content) != null) {
            textView.setText(format);
        }
        FragmentFirstChargeBinding fragmentFirstChargeBinding4 = (FragmentFirstChargeBinding) getBinding();
        if (fragmentFirstChargeBinding4 != null) {
            textView3 = fragmentFirstChargeBinding4.content;
        }
        new SpannableTextBuilder(textView3).changeTextColor(format, String.valueOf(this.mText), Integer.valueOf(Color.parseColor("#FFEC0F")), 16).apply();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FirstChargeAdapter mAdapter_delegate$lambda$0() {
        return new FirstChargeAdapter();
    }

    protected int getLayoutResId() {
        return R.layout.fragment_first_charge;
    }

    @NotNull
    public final FirstChargeAdapter getMAdapter() {
        return (FirstChargeAdapter) this.mAdapter.getValue();
    }

    @Nullable
    public final Float getMCharge() {
        return this.mCharge;
    }

    @Nullable
    public final Function0<Unit> getMListener() {
        return this.mListener;
    }

    @Nullable
    public final FirstChargeData getMPageData() {
        return this.mPageData;
    }

    @Nullable
    public final String getMText() {
        return this.mText;
    }

    public void onDestroy() {
        super/*com.qiahao.base_common.common.BaseFragment*/.onDestroy();
        this.mListener = null;
    }

    public void onInitialize() {
        super/*com.qiahao.base_common.common.BaseFragment*/.onInitialize();
        initView();
    }

    public final void setMCharge(@Nullable Float f) {
        this.mCharge = f;
    }

    public final void setMListener(@Nullable Function0<Unit> function0) {
        this.mListener = function0;
    }

    public final void setMPageData(@Nullable FirstChargeData firstChargeData) {
        this.mPageData = firstChargeData;
    }

    public final void setMText(@Nullable String str) {
        this.mText = str;
    }
}
