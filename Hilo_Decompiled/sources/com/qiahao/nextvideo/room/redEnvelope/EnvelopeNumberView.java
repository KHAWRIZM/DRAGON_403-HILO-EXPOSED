package com.qiahao.nextvideo.room.redEnvelope;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Checkable;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.utils.ShapeUtil;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.databinding.ViewEnvelopeNumberBinding;
import com.qiahao.nextvideo.ui.family.FamilySettingFragment;
import com.qiahao.nextvideo.utilities.userproxy.NumberUtilsKt;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\b\u0010)\u001a\u00020$H\u0002J\u000e\u0010*\u001a\u00020$2\u0006\u0010+\u001a\u00020\u000eJ\u001e\u0010,\u001a\u00020$2\u0016\u0010-\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000fJ\b\u0010.\u001a\u00020$H\u0002J\u001a\u0010/\u001a\u00020$2\u0006\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u000103H\u0002R*\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR7\u0010\u001f\u001a\u001f\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020$\u0018\u00010 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u00064"}, d2 = {"Lcom/qiahao/nextvideo/room/redEnvelope/EnvelopeNumberView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "list", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getList", "()Ljava/util/ArrayList;", "setList", "(Ljava/util/ArrayList;)V", "binding", "Lcom/qiahao/nextvideo/databinding/ViewEnvelopeNumberBinding;", "getBinding", "()Lcom/qiahao/nextvideo/databinding/ViewEnvelopeNumberBinding;", "setBinding", "(Lcom/qiahao/nextvideo/databinding/ViewEnvelopeNumberBinding;)V", "selectPosition", "getSelectPosition", "()I", "setSelectPosition", "(I)V", "listener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", FamilySettingFragment.FAMILY_NUMBER, "", "getListener", "()Lkotlin/jvm/functions/Function1;", "setListener", "(Lkotlin/jvm/functions/Function1;)V", "initView", "refreshPosition", "numberData", "refreshList", "numberList", "refreshView", "refreshTextView", "isSelect", "", "textView", "Landroid/widget/TextView;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nEnvelopeNumberView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EnvelopeNumberView.kt\ncom/qiahao/nextvideo/room/redEnvelope/EnvelopeNumberView\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,127:1\n61#2,9:128\n61#2,9:137\n61#2,9:146\n61#2,9:155\n1878#3,3:164\n1878#3,3:167\n*S KotlinDebug\n*F\n+ 1 EnvelopeNumberView.kt\ncom/qiahao/nextvideo/room/redEnvelope/EnvelopeNumberView\n*L\n44#1:128,9\n51#1:137,9\n58#1:146,9\n65#1:155,9\n75#1:164,3\n94#1:167,3\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class EnvelopeNumberView extends FrameLayout {

    @Nullable
    private ViewEnvelopeNumberBinding binding;

    @NotNull
    private ArrayList<Long> list;

    @Nullable
    private Function1<? super Long, Unit> listener;
    private int selectPosition;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EnvelopeNumberView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.list = new ArrayList<>();
        initView();
    }

    private final void initView() {
        final TextView textView;
        final TextView textView2;
        final TextView textView3;
        final TextView textView4;
        ConstraintLayout constraintLayout;
        ViewEnvelopeNumberBinding viewEnvelopeNumberBinding = (ViewEnvelopeNumberBinding) androidx.databinding.g.h(LayoutInflater.from(getContext()), R.layout.view_envelope_number, this, true);
        this.binding = viewEnvelopeNumberBinding;
        if (viewEnvelopeNumberBinding != null && (constraintLayout = viewEnvelopeNumberBinding.constraint) != null) {
            constraintLayout.setBackground(ShapeUtil.createShapeStroke$default(ShapeUtil.INSTANCE, "#7fffffff", 20, 1.0f, false, "#19414141", (String) null, (GradientDrawable.Orientation) null, 104, (Object) null));
        }
        ViewEnvelopeNumberBinding viewEnvelopeNumberBinding2 = this.binding;
        final long j = 800;
        if (viewEnvelopeNumberBinding2 != null && (textView4 = viewEnvelopeNumberBinding2.oneText) != null) {
            textView4.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.redEnvelope.EnvelopeNumberView$initView$$inlined$singleClick$default$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Function1<Long, Unit> listener;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView4) > j || (textView4 instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(textView4, currentTimeMillis);
                        this.setSelectPosition(0);
                        this.refreshView();
                        if (this.getList().size() > 0 && (listener = this.getListener()) != null) {
                            Long l = this.getList().get(0);
                            Intrinsics.checkNotNullExpressionValue(l, "get(...)");
                            listener.invoke(l);
                        }
                    }
                }
            });
        }
        ViewEnvelopeNumberBinding viewEnvelopeNumberBinding3 = this.binding;
        if (viewEnvelopeNumberBinding3 != null && (textView3 = viewEnvelopeNumberBinding3.twoText) != null) {
            textView3.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.redEnvelope.EnvelopeNumberView$initView$$inlined$singleClick$default$2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Function1<Long, Unit> listener;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView3) > j || (textView3 instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(textView3, currentTimeMillis);
                        this.setSelectPosition(1);
                        this.refreshView();
                        if (this.getList().size() > 1 && (listener = this.getListener()) != null) {
                            Long l = this.getList().get(1);
                            Intrinsics.checkNotNullExpressionValue(l, "get(...)");
                            listener.invoke(l);
                        }
                    }
                }
            });
        }
        ViewEnvelopeNumberBinding viewEnvelopeNumberBinding4 = this.binding;
        if (viewEnvelopeNumberBinding4 != null && (textView2 = viewEnvelopeNumberBinding4.threeText) != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.redEnvelope.EnvelopeNumberView$initView$$inlined$singleClick$default$3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Function1<Long, Unit> listener;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView2) > j || (textView2 instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(textView2, currentTimeMillis);
                        this.setSelectPosition(2);
                        this.refreshView();
                        if (this.getList().size() > 2 && (listener = this.getListener()) != null) {
                            Long l = this.getList().get(2);
                            Intrinsics.checkNotNullExpressionValue(l, "get(...)");
                            listener.invoke(l);
                        }
                    }
                }
            });
        }
        ViewEnvelopeNumberBinding viewEnvelopeNumberBinding5 = this.binding;
        if (viewEnvelopeNumberBinding5 != null && (textView = viewEnvelopeNumberBinding5.fourText) != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.redEnvelope.EnvelopeNumberView$initView$$inlined$singleClick$default$4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Function1<Long, Unit> listener;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView) > j || (textView instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(textView, currentTimeMillis);
                        this.setSelectPosition(3);
                        this.refreshView();
                        if (this.getList().size() > 3 && (listener = this.getListener()) != null) {
                            Long l = this.getList().get(3);
                            Intrinsics.checkNotNullExpressionValue(l, "get(...)");
                            listener.invoke(l);
                        }
                    }
                }
            });
        }
    }

    private final void refreshTextView(boolean isSelect, TextView textView) {
        if (isSelect) {
            if (textView != null) {
                textView.setTextColor(Color.parseColor("#EF003E"));
            }
            if (textView != null) {
                textView.setBackground(ShapeUtil.createShape$default(ShapeUtil.INSTANCE, "#ffffff", "#ffffff", 20, (GradientDrawable.Orientation) null, 8, (Object) null));
                return;
            }
            return;
        }
        if (textView != null) {
            textView.setTextColor(Color.parseColor("#ffffff"));
        }
        if (textView != null) {
            textView.setBackground(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void refreshView() {
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        int i = 0;
        for (Object obj : this.list) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            long longValue = ((Number) obj).longValue();
            TextView textView5 = null;
            boolean z = true;
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i == 3) {
                            ViewEnvelopeNumberBinding viewEnvelopeNumberBinding = this.binding;
                            if (viewEnvelopeNumberBinding != null && (textView4 = viewEnvelopeNumberBinding.fourText) != null) {
                                textView4.setText(NumberUtilsKt.rankNumberFormat(longValue));
                            }
                            if (i != this.selectPosition) {
                                z = false;
                            }
                            ViewEnvelopeNumberBinding viewEnvelopeNumberBinding2 = this.binding;
                            if (viewEnvelopeNumberBinding2 != null) {
                                textView5 = viewEnvelopeNumberBinding2.fourText;
                            }
                            refreshTextView(z, textView5);
                        }
                    } else {
                        ViewEnvelopeNumberBinding viewEnvelopeNumberBinding3 = this.binding;
                        if (viewEnvelopeNumberBinding3 != null && (textView3 = viewEnvelopeNumberBinding3.threeText) != null) {
                            textView3.setText(NumberUtilsKt.rankNumberFormat(longValue));
                        }
                        if (i != this.selectPosition) {
                            z = false;
                        }
                        ViewEnvelopeNumberBinding viewEnvelopeNumberBinding4 = this.binding;
                        if (viewEnvelopeNumberBinding4 != null) {
                            textView5 = viewEnvelopeNumberBinding4.threeText;
                        }
                        refreshTextView(z, textView5);
                    }
                } else {
                    ViewEnvelopeNumberBinding viewEnvelopeNumberBinding5 = this.binding;
                    if (viewEnvelopeNumberBinding5 != null && (textView2 = viewEnvelopeNumberBinding5.twoText) != null) {
                        textView2.setText(NumberUtilsKt.rankNumberFormat(longValue));
                    }
                    if (i != this.selectPosition) {
                        z = false;
                    }
                    ViewEnvelopeNumberBinding viewEnvelopeNumberBinding6 = this.binding;
                    if (viewEnvelopeNumberBinding6 != null) {
                        textView5 = viewEnvelopeNumberBinding6.twoText;
                    }
                    refreshTextView(z, textView5);
                }
            } else {
                ViewEnvelopeNumberBinding viewEnvelopeNumberBinding7 = this.binding;
                if (viewEnvelopeNumberBinding7 != null && (textView = viewEnvelopeNumberBinding7.oneText) != null) {
                    textView.setText(NumberUtilsKt.rankNumberFormat(longValue));
                }
                if (i != this.selectPosition) {
                    z = false;
                }
                ViewEnvelopeNumberBinding viewEnvelopeNumberBinding8 = this.binding;
                if (viewEnvelopeNumberBinding8 != null) {
                    textView5 = viewEnvelopeNumberBinding8.oneText;
                }
                refreshTextView(z, textView5);
            }
            i = i2;
        }
    }

    @Nullable
    public final ViewEnvelopeNumberBinding getBinding() {
        return this.binding;
    }

    @NotNull
    public final ArrayList<Long> getList() {
        return this.list;
    }

    @Nullable
    public final Function1<Long, Unit> getListener() {
        return this.listener;
    }

    public final int getSelectPosition() {
        return this.selectPosition;
    }

    public final void refreshList(@NotNull ArrayList<Long> numberList) {
        Intrinsics.checkNotNullParameter(numberList, "numberList");
        this.selectPosition = 0;
        this.list.clear();
        this.list.addAll(numberList);
        refreshView();
    }

    public final void refreshPosition(long numberData) {
        Function1<? super Long, Unit> function1;
        int i = 0;
        for (Object obj : this.list) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            if (numberData == ((Number) obj).longValue()) {
                this.selectPosition = i;
            }
            i = i2;
        }
        if (this.selectPosition == 0 && this.list.size() > 0 && (function1 = this.listener) != null) {
            Long l = this.list.get(0);
            Intrinsics.checkNotNullExpressionValue(l, "get(...)");
            function1.invoke(l);
        }
        refreshView();
    }

    public final void setBinding(@Nullable ViewEnvelopeNumberBinding viewEnvelopeNumberBinding) {
        this.binding = viewEnvelopeNumberBinding;
    }

    public final void setList(@NotNull ArrayList<Long> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.list = arrayList;
    }

    public final void setListener(@Nullable Function1<? super Long, Unit> function1) {
        this.listener = function1;
    }

    public final void setSelectPosition(int i) {
        this.selectPosition = i;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EnvelopeNumberView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.list = new ArrayList<>();
        initView();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EnvelopeNumberView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.list = new ArrayList<>();
        initView();
    }
}
