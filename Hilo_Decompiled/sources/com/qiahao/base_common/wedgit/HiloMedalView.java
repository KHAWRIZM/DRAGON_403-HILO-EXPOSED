package com.qiahao.base_common.wedgit;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import com.qiahao.base_common.R;
import com.qiahao.base_common.databinding.HiloMedalViewBinding;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u001a\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\u000e\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\nJ\u0014\u0010\u001c\u001a\u00020\u00192\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eJ\u000e\u0010 \u001a\u00020\u00192\u0006\u0010!\u001a\u00020\u001fJ\u0006\u0010\"\u001a\u00020\u0019R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/qiahao/base_common/wedgit/HiloMedalView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mHeight", "", "mMaxSize", "medalAdapter", "Lcom/qiahao/base_common/wedgit/MedalAdapter;", "getMedalAdapter", "()Lcom/qiahao/base_common/wedgit/MedalAdapter;", "medalAdapter$delegate", "Lkotlin/Lazy;", "binding", "Lcom/qiahao/base_common/databinding/HiloMedalViewBinding;", "initBinding", "getDefaultConfig", "", "setMaxSize", "maxSize", "setMedal", "medalList", "", "", "addMedal", "medal", "cleanAllMedal", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nHiloMedalView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HiloMedalView.kt\ncom/qiahao/base_common/wedgit/HiloMedalView\n+ 2 Context.kt\nandroidx/core/content/ContextKt\n*L\n1#1,72:1\n51#2,9:73\n*S KotlinDebug\n*F\n+ 1 HiloMedalView.kt\ncom/qiahao/base_common/wedgit/HiloMedalView\n*L\n48#1:73,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class HiloMedalView extends FrameLayout {

    @NotNull
    private HiloMedalViewBinding binding;
    private float mHeight;
    private int mMaxSize;

    /* renamed from: medalAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy medalAdapter;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HiloMedalView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mMaxSize = 8;
        this.medalAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.base_common.wedgit.b
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                MedalAdapter medalAdapter_delegate$lambda$0;
                medalAdapter_delegate$lambda$0 = HiloMedalView.medalAdapter_delegate$lambda$0();
                return medalAdapter_delegate$lambda$0;
            }
        });
        this.binding = initBinding(context);
        getDefaultConfig(context, null);
    }

    private final void getDefaultConfig(Context context, AttributeSet attrs) {
        if (attrs != null) {
            int[] HiloMedalView = R.styleable.HiloMedalView;
            Intrinsics.checkNotNullExpressionValue(HiloMedalView, "HiloMedalView");
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attrs, HiloMedalView, 0, 0);
            this.mHeight = obtainStyledAttributes.getDimension(R.styleable.HiloMedalView_android_height, 10.0f);
            obtainStyledAttributes.recycle();
        }
    }

    private final MedalAdapter getMedalAdapter() {
        return (MedalAdapter) this.medalAdapter.getValue();
    }

    private final HiloMedalViewBinding initBinding(Context context) {
        HiloMedalViewBinding inflate = HiloMedalViewBinding.inflate(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        inflate.recyclerView.setAdapter(getMedalAdapter());
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MedalAdapter medalAdapter_delegate$lambda$0() {
        return new MedalAdapter();
    }

    public final void addMedal(@NotNull String medal) {
        Intrinsics.checkNotNullParameter(medal, "medal");
        if (getMedalAdapter().getData().size() < this.mMaxSize) {
            getMedalAdapter().addData((MedalAdapter) medal);
        }
    }

    public final void cleanAllMedal() {
        getMedalAdapter().setList(CollectionsKt.emptyList());
    }

    public final void setMaxSize(int maxSize) {
        this.mMaxSize = maxSize;
    }

    public final void setMedal(@NotNull List<String> medalList) {
        Intrinsics.checkNotNullParameter(medalList, "medalList");
        getMedalAdapter().setList(CollectionsKt.take(medalList, this.mMaxSize));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HiloMedalView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mMaxSize = 8;
        this.medalAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.base_common.wedgit.b
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                MedalAdapter medalAdapter_delegate$lambda$0;
                medalAdapter_delegate$lambda$0 = HiloMedalView.medalAdapter_delegate$lambda$0();
                return medalAdapter_delegate$lambda$0;
            }
        });
        this.binding = initBinding(context);
        getDefaultConfig(context, attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HiloMedalView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mMaxSize = 8;
        this.medalAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.base_common.wedgit.b
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                MedalAdapter medalAdapter_delegate$lambda$0;
                medalAdapter_delegate$lambda$0 = HiloMedalView.medalAdapter_delegate$lambda$0();
                return medalAdapter_delegate$lambda$0;
            }
        });
        this.binding = initBinding(context);
        getDefaultConfig(context, attributeSet);
    }
}
