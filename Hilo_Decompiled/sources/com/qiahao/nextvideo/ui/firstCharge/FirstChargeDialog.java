package com.qiahao.nextvideo.ui.firstCharge;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Checkable;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.widget.ViewPager2;
import com.oudi.utils.SpannableTextBuilder;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.oudi.widget.ViewPage2TabLayout;
import com.qiahao.base_common.common.BaseActivity;
import com.qiahao.base_common.common.BaseBindingDialog;
import com.qiahao.base_common.ui.dialog.TipDialog;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.base_common.utils.ShapeUtil;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.firstCharge.FirstChargeData;
import com.qiahao.nextvideo.data.tab.MainTabData;
import com.qiahao.nextvideo.databinding.DialogFirstChargeBinding;
import com.qiahao.nextvideo.utilities.google.pay.WalletPay;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B5\u0012\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010$\u001a\u00020%H\u0014J\b\u0010&\u001a\u00020\u001aH\u0016J\b\u0010'\u001a\u00020\bH\u0014J\b\u0010(\u001a\u00020\u001aH\u0003J\b\u0010)\u001a\u00020\u001aH\u0016R%\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u000fR\u001e\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0004j\b\u0012\u0004\u0012\u00020\u0011`\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00130\u0004j\b\u0012\u0004\u0012\u00020\u0013`\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R7\u0010\u0014\u001a\u001f\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u0006*"}, d2 = {"Lcom/qiahao/nextvideo/ui/firstCharge/FirstChargeDialog;", "Lcom/qiahao/base_common/common/BaseBindingDialog;", "Lcom/qiahao/nextvideo/databinding/DialogFirstChargeBinding;", "mData", "Ljava/util/ArrayList;", "Lcom/qiahao/nextvideo/data/firstCharge/FirstChargeData;", "Lkotlin/collections/ArrayList;", "isWalletPat", "", "context", "Landroid/content/Context;", "<init>", "(Ljava/util/ArrayList;ZLandroid/content/Context;)V", "getMData", "()Ljava/util/ArrayList;", "()Z", "mFragments", "Lcom/qiahao/nextvideo/ui/firstCharge/FirstChargeFragment;", "tabList", "Lcom/qiahao/nextvideo/data/tab/MainTabData;", "mListener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "productId", "", "getMListener", "()Lkotlin/jvm/functions/Function1;", "setMListener", "(Lkotlin/jvm/functions/Function1;)V", "mPageData", "getMPageData", "()Lcom/qiahao/nextvideo/data/firstCharge/FirstChargeData;", "setMPageData", "(Lcom/qiahao/nextvideo/data/firstCharge/FirstChargeData;)V", "getLayoutResId", "", "onInitialize", "isNeedFullScreen", "initView", "dismiss", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nFirstChargeDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FirstChargeDialog.kt\ncom/qiahao/nextvideo/ui/firstCharge/FirstChargeDialog\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,203:1\n1#2:204\n61#3,9:205\n61#3,9:214\n61#3,9:228\n1878#4,3:223\n1869#4,2:226\n*S KotlinDebug\n*F\n+ 1 FirstChargeDialog.kt\ncom/qiahao/nextvideo/ui/firstCharge/FirstChargeDialog\n*L\n65#1:205,9\n66#1:214,9\n99#1:228,9\n72#1:223,3\n79#1:226,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class FirstChargeDialog extends BaseBindingDialog<DialogFirstChargeBinding> {
    private final boolean isWalletPat;

    @Nullable
    private final ArrayList<FirstChargeData> mData;

    @NotNull
    private ArrayList<FirstChargeFragment> mFragments;

    @Nullable
    private Function1<? super String, Unit> mListener;

    @Nullable
    private FirstChargeData mPageData;

    @NotNull
    private final ArrayList<MainTabData> tabList;

    public /* synthetic */ FirstChargeDialog(ArrayList arrayList, boolean z, Context context, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(arrayList, (i & 2) != 0 ? false : z, context);
    }

    public static final /* synthetic */ DialogFirstChargeBinding access$getBinding(FirstChargeDialog firstChargeDialog) {
        return (DialogFirstChargeBinding) firstChargeDialog.getBinding();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SuppressLint({"DefaultLocale"})
    private final void initView() {
        int i;
        float f;
        float f2;
        float f3;
        char c = 0;
        ImageView imageView = ((DialogFirstChargeBinding) getBinding()).bg;
        Intrinsics.checkNotNullExpressionValue(imageView, "bg");
        ImageKtxKt.toHorizontalMirror(imageView, R.drawable.first_charge_bg);
        final ConstraintLayout constraintLayout = ((DialogFirstChargeBinding) getBinding()).constraint;
        final long j = 800;
        constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.firstCharge.FirstChargeDialog$initView$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(constraintLayout) > j || (constraintLayout instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(constraintLayout, currentTimeMillis);
                    ConstraintLayout constraintLayout2 = constraintLayout;
                }
            }
        });
        final FrameLayout frameLayout = ((DialogFirstChargeBinding) getBinding()).frameLayout;
        frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.firstCharge.FirstChargeDialog$initView$$inlined$singleClick$default$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(frameLayout) > j || (frameLayout instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(frameLayout, currentTimeMillis);
                    this.dismiss();
                }
            }
        });
        ((DialogFirstChargeBinding) getBinding()).tabLayout.setBackground(ShapeUtil.createShape$default(ShapeUtil.INSTANCE, "#33ffffff", "#33ffffff", 30, (GradientDrawable.Orientation) null, 8, (Object) null));
        StringBuilder sb2 = new StringBuilder("");
        ArrayList<FirstChargeData> arrayList = this.mData;
        if (arrayList != null) {
            int i2 = 0;
            i = -1;
            for (Object obj : arrayList) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                FirstChargeData firstChargeData = (FirstChargeData) obj;
                if (i == -1 && Intrinsics.areEqual(firstChargeData.getHasGetReward(), Boolean.FALSE)) {
                    i = i2;
                }
                Float charge = firstChargeData.getCharge();
                if (charge != null) {
                    f3 = charge.floatValue();
                } else {
                    f3 = 0.0f;
                }
                sb2.append(" $" + (f3 / 100.0f) + ",");
                i2 = i3;
            }
        } else {
            i = -1;
        }
        ArrayList<FirstChargeData> arrayList2 = this.mData;
        if (arrayList2 != null) {
            for (FirstChargeData firstChargeData2 : arrayList2) {
                ArrayList<MainTabData> arrayList3 = this.tabList;
                MainTabData.Companion companion = MainTabData.INSTANCE;
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                Float charge2 = firstChargeData2.getCharge();
                if (charge2 != null) {
                    f = charge2.floatValue();
                } else {
                    f = 0.0f;
                }
                Object[] objArr = new Object[1];
                objArr[c] = Float.valueOf(f / 100.0f);
                String format = String.format("%.2f", Arrays.copyOf(objArr, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                arrayList3.add(companion.initFirstCharge("$" + format));
                ArrayList<FirstChargeFragment> arrayList4 = this.mFragments;
                FirstChargeFragment firstChargeFragment = new FirstChargeFragment();
                Bundle bundle = new Bundle();
                Float charge3 = firstChargeData2.getCharge();
                if (charge3 != null) {
                    f2 = charge3.floatValue();
                } else {
                    f2 = 0.0f;
                }
                bundle.putFloat("fragment_type", f2);
                bundle.putString(FirstChargeFragment.FIRST_TEXT, sb2.toString());
                bundle.putParcelable(FirstChargeFragment.FIRST_DATA, firstChargeData2);
                firstChargeFragment.setArguments(bundle);
                arrayList4.add(firstChargeFragment);
                c = 0;
            }
        }
        final TextView textView = ((DialogFirstChargeBinding) getBinding()).button;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.firstCharge.FirstChargeDialog$initView$$inlined$singleClick$default$3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                boolean z;
                String productId;
                String productId2;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView) > j || (textView instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(textView, currentTimeMillis);
                    FirstChargeData mPageData = this.getMPageData();
                    boolean z2 = false;
                    if (mPageData != null) {
                        z = Intrinsics.areEqual(mPageData.getHasGetReward(), Boolean.TRUE);
                    } else {
                        z = false;
                    }
                    if (!z) {
                        FirstChargeData mPageData2 = this.getMPageData();
                        if (mPageData2 != null) {
                            z2 = Intrinsics.areEqual(mPageData2.isCanRecharge(), Boolean.FALSE);
                        }
                        if (z2) {
                            Context context = this.getContext();
                            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                            new TipDialog(context).setTipContent(ResourcesKtxKt.getStringById(this, 2131953314)).hideCancel(true).show();
                            return;
                        }
                        String str = "";
                        if (!this.getIsWalletPat()) {
                            WalletPay walletPay = WalletPay.INSTANCE;
                            FirstChargeData mPageData3 = this.getMPageData();
                            if (mPageData3 != null && (productId2 = mPageData3.getProductId()) != null) {
                                str = productId2;
                            }
                            walletPay.checkWriteList(str);
                            return;
                        }
                        Function1<String, Unit> mListener = this.getMListener();
                        if (mListener != null) {
                            FirstChargeData mPageData4 = this.getMPageData();
                            if (mPageData4 != null && (productId = mPageData4.getProductId()) != null) {
                                str = productId;
                            }
                            mListener.invoke(str);
                        }
                        this.dismiss();
                    }
                }
            }
        });
        ((DialogFirstChargeBinding) getBinding()).viewPage.setOffscreenPageLimit(this.mFragments.size());
        BaseActivity activity = HiloUtils.INSTANCE.getActivity(getContext());
        if (activity != null) {
            ViewPager2 viewPager2 = ((DialogFirstChargeBinding) getBinding()).viewPage;
            final FragmentManager supportFragmentManager = activity.getSupportFragmentManager();
            final Lifecycle lifecycle = activity.getLifecycle();
            viewPager2.setAdapter(new androidx.viewpager2.adapter.a(supportFragmentManager, lifecycle) { // from class: com.qiahao.nextvideo.ui.firstCharge.FirstChargeDialog$initView$6$1
                public Fragment createFragment(int position) {
                    ArrayList arrayList5;
                    arrayList5 = FirstChargeDialog.this.mFragments;
                    Object obj2 = arrayList5.get(position);
                    Intrinsics.checkNotNullExpressionValue(obj2, "get(...)");
                    return (Fragment) obj2;
                }

                public int getItemCount() {
                    ArrayList arrayList5;
                    arrayList5 = FirstChargeDialog.this.mFragments;
                    return arrayList5.size();
                }
            });
        }
        ViewPage2TabLayout viewPage2TabLayout = ((DialogFirstChargeBinding) getBinding()).tabLayout;
        ViewPager2 viewPager22 = ((DialogFirstChargeBinding) getBinding()).viewPage;
        Intrinsics.checkNotNullExpressionValue(viewPager22, "viewPage");
        viewPage2TabLayout.setViewPager2(viewPager22, new TabFirstChargeAdapter(this.tabList));
        ((DialogFirstChargeBinding) getBinding()).viewPage.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() { // from class: com.qiahao.nextvideo.ui.firstCharge.FirstChargeDialog$initView$7
            public void onPageSelected(int position) {
                int i4;
                FirstChargeData firstChargeData3;
                boolean z;
                Number number;
                Long originalPrice;
                super.onPageSelected(position);
                ArrayList<FirstChargeData> mData = FirstChargeDialog.this.getMData();
                if (mData != null) {
                    i4 = mData.size();
                } else {
                    i4 = 0;
                }
                if (i4 > position) {
                    FirstChargeDialog firstChargeDialog = FirstChargeDialog.this;
                    ArrayList<FirstChargeData> mData2 = firstChargeDialog.getMData();
                    if (mData2 != null) {
                        firstChargeData3 = mData2.get(position);
                    } else {
                        firstChargeData3 = null;
                    }
                    firstChargeDialog.setMPageData(firstChargeData3);
                    FirstChargeData mPageData = FirstChargeDialog.this.getMPageData();
                    if (mPageData != null) {
                        z = Intrinsics.areEqual(mPageData.getHasGetReward(), Boolean.TRUE);
                    } else {
                        z = false;
                    }
                    if (z) {
                        FirstChargeDialog.access$getBinding(FirstChargeDialog.this).button.setText(ResourcesKtxKt.getStringById(this, 2131952587));
                        FirstChargeDialog.access$getBinding(FirstChargeDialog.this).button.setTextSize(16.0f);
                        Context context = FirstChargeDialog.this.getContext();
                        if (context != null) {
                            FirstChargeDialog firstChargeDialog2 = FirstChargeDialog.this;
                            FirstChargeDialog.access$getBinding(firstChargeDialog2).button.setBackground(androidx.core.content.a.getDrawable(context, R.drawable.first_charge_button_bg_default));
                            FirstChargeDialog.access$getBinding(firstChargeDialog2).button.setTextColor(androidx.core.content.a.getColor(context, 2131099906));
                            return;
                        }
                        return;
                    }
                    SpannableTextBuilder spannableTextBuilder = new SpannableTextBuilder(FirstChargeDialog.access$getBinding(FirstChargeDialog.this).button);
                    StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                    FirstChargeData mPageData2 = FirstChargeDialog.this.getMPageData();
                    long j2 = 0;
                    if (mPageData2 == null || (number = mPageData2.getCharge()) == null) {
                        number = 0L;
                    }
                    String format2 = String.format("%.2f", Arrays.copyOf(new Object[]{Double.valueOf(number.doubleValue() / 100.0d)}, 1));
                    Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
                    SpannableTextBuilder appendText$default = SpannableTextBuilder.appendText$default(spannableTextBuilder, "$" + format2, Integer.valueOf(Color.parseColor("#ffffff")), (Integer) null, 20, 1, (Boolean) null, (Function1) null, (Boolean) null, 228, (Object) null);
                    FirstChargeData mPageData3 = FirstChargeDialog.this.getMPageData();
                    if (mPageData3 != null && (originalPrice = mPageData3.getOriginalPrice()) != null) {
                        j2 = originalPrice.longValue();
                    }
                    String format3 = String.format("%.2f", Arrays.copyOf(new Object[]{Double.valueOf(j2 / 100.0d)}, 1));
                    Intrinsics.checkNotNullExpressionValue(format3, "format(...)");
                    SpannableTextBuilder.appendText$default(appendText$default, "($" + format3 + ")", Integer.valueOf(Color.parseColor("#66ffffff")), (Integer) null, 16, 1, (Boolean) null, (Function1) null, Boolean.TRUE, 100, (Object) null).apply();
                    Context context2 = FirstChargeDialog.this.getContext();
                    if (context2 != null) {
                        FirstChargeDialog.access$getBinding(FirstChargeDialog.this).button.setBackground(androidx.core.content.a.getDrawable(context2, R.drawable.first_charge_button_bg));
                    }
                }
            }
        });
        ((DialogFirstChargeBinding) getBinding()).viewPage.setOffscreenPageLimit(this.mFragments.size());
        ViewPage2TabLayout viewPage2TabLayout2 = ((DialogFirstChargeBinding) getBinding()).tabLayout;
        Intrinsics.checkNotNullExpressionValue(viewPage2TabLayout2, "tabLayout");
        com.oudi.widget.ViewKtxKt.disableTooltipText(viewPage2TabLayout2);
        if (i != -1 && this.mFragments.size() > 0) {
            ((DialogFirstChargeBinding) getBinding()).viewPage.setCurrentItem(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onInitialize$lambda$1$lambda$0(FirstChargeDialog firstChargeDialog, String str) {
        Intrinsics.checkNotNullParameter(str, "it");
        firstChargeDialog.dismiss();
        return Unit.INSTANCE;
    }

    public void dismiss() {
        super.dismiss();
        if (!this.isWalletPat) {
            WalletPay.INSTANCE.release();
        }
        this.mListener = null;
    }

    protected int getLayoutResId() {
        return R.layout.dialog_first_charge;
    }

    @Nullable
    public final ArrayList<FirstChargeData> getMData() {
        return this.mData;
    }

    @Nullable
    public final Function1<String, Unit> getMListener() {
        return this.mListener;
    }

    @Nullable
    public final FirstChargeData getMPageData() {
        return this.mPageData;
    }

    protected boolean isNeedFullScreen() {
        return true;
    }

    /* renamed from: isWalletPat, reason: from getter */
    public final boolean getIsWalletPat() {
        return this.isWalletPat;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onInitialize() {
        super/*com.oudi.core.component.SuperDialog*/.onInitialize();
        initView();
        if (!this.isWalletPat) {
            Context context = getContext();
            WalletPay walletPay = WalletPay.INSTANCE;
            Intrinsics.checkNotNull(context);
            walletPay.init(context, new Function1() { // from class: com.qiahao.nextvideo.ui.firstCharge.a
                public final Object invoke(Object obj) {
                    Unit onInitialize$lambda$1$lambda$0;
                    onInitialize$lambda$1$lambda$0 = FirstChargeDialog.onInitialize$lambda$1$lambda$0(FirstChargeDialog.this, (String) obj);
                    return onInitialize$lambda$1$lambda$0;
                }
            });
        }
    }

    public final void setMListener(@Nullable Function1<? super String, Unit> function1) {
        this.mListener = function1;
    }

    public final void setMPageData(@Nullable FirstChargeData firstChargeData) {
        this.mPageData = firstChargeData;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FirstChargeDialog(@Nullable ArrayList<FirstChargeData> arrayList, boolean z, @NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mData = arrayList;
        this.isWalletPat = z;
        this.mFragments = new ArrayList<>();
        this.tabList = new ArrayList<>();
    }
}
