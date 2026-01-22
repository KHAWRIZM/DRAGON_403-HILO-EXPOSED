package com.qiahao.nextvideo.ui.foodie;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.UiKtxKt;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.foodie.FoodieBetBean;
import com.qiahao.nextvideo.databinding.ViewFoodieItemBinding;
import com.qiahao.nextvideo.utilities.userproxy.NumberUtilsKt;
import java.io.File;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0010\u0010\fJ\u0015\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0015\u001a\u00020\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0007¢\u0006\u0004\b\u0015\u0010\u0014J\u0015\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0006¢\u0006\u0004\b\u0017\u0010\u000fJ\r\u0010\u0018\u001a\u00020\n¢\u0006\u0004\b\u0018\u0010\fJ\u0015\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\u0015\u0010\u001f\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001f\u0010 J\r\u0010!\u001a\u00020\u001d¢\u0006\u0004\b!\u0010\"R\u0016\u0010$\u001a\u00020#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010&\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010)\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*¨\u0006+"}, d2 = {"Lcom/qiahao/nextvideo/ui/foodie/FoodieItemView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "initEvent", "()V", "targetNum", "addFlameOneByOne", "(I)V", "addFlameToContainer", "Lcom/qiahao/nextvideo/data/foodie/FoodieBetBean;", "info", "onlyRefreshRate", "(Lcom/qiahao/nextvideo/data/foodie/FoodieBetBean;)V", "setData", "num", "setFlame", "removeAllHot", "Lcom/qiahao/nextvideo/ui/foodie/FoodieItemState;", "state", "setState", "(Lcom/qiahao/nextvideo/ui/foodie/FoodieItemState;)V", "", "isVisible", "setFingerVisibility", "(Z)V", "isEmpty", "()Z", "Lcom/qiahao/nextvideo/databinding/ViewFoodieItemBinding;", "mBinding", "Lcom/qiahao/nextvideo/databinding/ViewFoodieItemBinding;", "mBean", "Lcom/qiahao/nextvideo/data/foodie/FoodieBetBean;", "Lnd/c;", "mDisposable", "Lnd/c;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class FoodieItemView extends FrameLayout {

    @Nullable
    private FoodieBetBean mBean;

    @NotNull
    private ViewFoodieItemBinding mBinding;

    @Nullable
    private nd.c mDisposable;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FoodieItemState.values().length];
            try {
                iArr[FoodieItemState.NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FoodieItemState.PICKED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[FoodieItemState.DRAWING_HIGHLIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[FoodieItemState.DRAWING_SHADOW.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[FoodieItemState.RESULT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FoodieItemView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(FoodieItemView foodieItemView) {
        if (foodieItemView.mBinding.ivFinger.getLayoutDirection() == 1) {
            foodieItemView.mBinding.ivFinger.setScaleX(-1.0f);
            foodieItemView.mBinding.ivFinger.setScaleX(-1.0f);
        }
    }

    private final void addFlameOneByOne(final int targetNum) {
        long j;
        nd.c cVar = this.mDisposable;
        if (cVar != null) {
            cVar.dispose();
        }
        int childCount = this.mBinding.llHotContainer.getChildCount();
        if (childCount < targetNum) {
            if (childCount == 0) {
                j = 0;
            } else {
                j = 300;
            }
            this.mDisposable = io.reactivex.rxjava3.core.z.interval(j, 300L, TimeUnit.MILLISECONDS).observeOn(md.b.c()).subscribe(new pd.g() { // from class: com.qiahao.nextvideo.ui.foodie.FoodieItemView$addFlameOneByOne$1
                public final void accept(Long l) {
                    ViewFoodieItemBinding viewFoodieItemBinding;
                    nd.c cVar2;
                    Intrinsics.checkNotNullParameter(l, "it");
                    viewFoodieItemBinding = FoodieItemView.this.mBinding;
                    if (viewFoodieItemBinding.llHotContainer.getChildCount() < targetNum) {
                        FoodieItemView.this.addFlameToContainer();
                        return;
                    }
                    cVar2 = FoodieItemView.this.mDisposable;
                    if (cVar2 != null) {
                        cVar2.dispose();
                    }
                }
            });
            return;
        }
        if (childCount > targetNum) {
            this.mBinding.llHotContainer.removeAllViews();
            for (int i = 0; i < targetNum; i++) {
                addFlameToContainer();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void addFlameToContainer() {
        ImageView imageView = new ImageView(getContext());
        imageView.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), R.drawable.ic_foodie_hot));
        imageView.setLayoutParams(new LinearLayout.LayoutParams(UiKtxKt.getDp(12), UiKtxKt.getDp(14)));
        this.mBinding.llHotContainer.addView(imageView);
    }

    private final void initEvent() {
    }

    public final boolean isEmpty() {
        if (this.mBean == null) {
            return true;
        }
        return false;
    }

    public final void onlyRefreshRate(@NotNull FoodieBetBean info) {
        Intrinsics.checkNotNullParameter(info, "info");
        this.mBean = info;
        if (info.getDiamond() == 0) {
            TextView textView = this.mBinding.tvRate;
            String format = String.format(ResourcesKtxKt.getStringById(this, 2131952783), Arrays.copyOf(new Object[]{0}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            textView.setText(format);
            return;
        }
        TextView textView2 = this.mBinding.tvRate;
        String format2 = String.format(ResourcesKtxKt.getStringById(this, 2131952783), Arrays.copyOf(new Object[]{NumberUtilsKt.formatNumberWithSuffix(info.getDiamond(), 3)}, 1));
        Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
        textView2.setText(format2);
    }

    public final void removeAllHot() {
        if (this.mBinding.llHotContainer.getChildCount() != 0) {
            this.mBinding.llHotContainer.removeAllViews();
        }
    }

    @SuppressLint({"SetTextI18n"})
    public final void setData(@Nullable FoodieBetBean info) {
        this.mBean = info;
        setState(FoodieItemState.NORMAL);
        if (info != null) {
            ImageView imageView = this.mBinding.ivPicture;
            Intrinsics.checkNotNullExpressionValue(imageView, "ivPicture");
            ImageKtxKt.loadImage$default(imageView, FoodieUtil.INSTANCE.getFoodieIcon(info.getFoodieId()), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
            this.mBinding.tvMultiplier.setText("x" + info.getRate());
            if (info.getDiamond() == 0) {
                TextView textView = this.mBinding.tvRate;
                String format = String.format(ResourcesKtxKt.getStringById(this, 2131952783), Arrays.copyOf(new Object[]{0}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                textView.setText(format);
            } else {
                TextView textView2 = this.mBinding.tvRate;
                String format2 = String.format(ResourcesKtxKt.getStringById(this, 2131952783), Arrays.copyOf(new Object[]{NumberUtilsKt.formatNumberWithSuffix(info.getDiamond(), 3)}, 1));
                Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
                textView2.setText(format2);
            }
            if (info.getHasBet()) {
                this.mBinding.ivBottomBg.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), R.drawable.ic_foodie_bet_item_select));
                this.mBinding.tvMultiplier.setTextColor(Color.parseColor("#ffffff"));
            } else {
                this.mBinding.ivBottomBg.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), R.drawable.ic_foodie_bet_item_normal));
                this.mBinding.tvMultiplier.setTextColor(Color.parseColor("#422B00"));
            }
        }
    }

    public final void setFingerVisibility(boolean isVisible) {
        if (isVisible) {
            this.mBinding.ivFinger.setVisibility(0);
        } else {
            this.mBinding.ivFinger.setVisibility(8);
        }
    }

    public final void setFlame(int num) {
        int childCount = this.mBinding.llHotContainer.getChildCount();
        if (num == 0) {
            if (childCount != 0) {
                this.mBinding.llHotContainer.removeAllViews();
            }
        } else if (num > 0 && childCount != num) {
            addFlameOneByOne(num);
        }
    }

    public final void setState(@NotNull FoodieItemState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        int i = WhenMappings.$EnumSwitchMapping$0[state.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        if (i == 5) {
                            this.mBinding.ivMask.setVisibility(8);
                            return;
                        }
                        throw new NoWhenBranchMatchedException();
                    }
                    this.mBinding.ivMask.setVisibility(0);
                    return;
                }
                this.mBinding.ivMask.setVisibility(8);
                return;
            }
            this.mBinding.tvMultiplier.setTextColor(Color.parseColor("#ffffff"));
            this.mBinding.ivBottomBg.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), R.drawable.ic_foodie_bet_item_select));
            this.mBinding.ivMask.setVisibility(8);
            return;
        }
        this.mBinding.tvMultiplier.setTextColor(Color.parseColor("#422B00"));
        this.mBinding.ivBottomBg.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), R.drawable.ic_foodie_bet_item_normal));
        this.mBinding.ivMask.setVisibility(8);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FoodieItemView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ FoodieItemView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FoodieItemView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        ViewFoodieItemBinding inflate = ViewFoodieItemBinding.inflate(LayoutInflater.from(getContext()), this, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.mBinding = inflate;
        inflate.ivFinger.post(new Runnable() { // from class: com.qiahao.nextvideo.ui.foodie.s0
            @Override // java.lang.Runnable
            public final void run() {
                FoodieItemView._init_$lambda$0(FoodieItemView.this);
            }
        });
        initEvent();
    }
}
