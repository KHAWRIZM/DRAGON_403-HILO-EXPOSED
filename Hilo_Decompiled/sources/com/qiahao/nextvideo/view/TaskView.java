package com.qiahao.nextvideo.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.g;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.task.TaskProcess;
import com.qiahao.nextvideo.databinding.ViewTaskBinding;
import com.qiahao.nextvideo.databinding.ViewTaskItemBinding;
import com.qiahao.nextvideo.utilities.userproxy.NumberUtilsKt;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\b\u0010\u0018\u001a\u00020\u0013H\u0002J\u0012\u0010\u0019\u001a\u00020\u00132\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001bJA\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u001b2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\nH\u0003¢\u0006\u0002\u0010\"J0\u0010\u001c\u001a\u00020\u00132\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010#\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\nH\u0002R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R7\u0010\u000e\u001a\u001f\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006$"}, d2 = {"Lcom/qiahao/nextvideo/view/TaskView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/qiahao/nextvideo/databinding/ViewTaskBinding;", "listener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "position", "", "getListener", "()Lkotlin/jvm/functions/Function1;", "setListener", "(Lkotlin/jvm/functions/Function1;)V", "init", "refreshData", "data", "Lcom/qiahao/nextvideo/data/task/TaskProcess;", "refreshItem", "itemView", "Lcom/qiahao/nextvideo/databinding/ViewTaskItemBinding;", "process", "Landroid/view/View;", "money", "(ILcom/qiahao/nextvideo/data/task/TaskProcess;Lcom/qiahao/nextvideo/databinding/ViewTaskItemBinding;Landroid/view/View;Ljava/lang/Integer;)V", "type", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nTaskView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TaskView.kt\ncom/qiahao/nextvideo/view/TaskView\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,205:1\n1878#2,3:206\n*S KotlinDebug\n*F\n+ 1 TaskView.kt\ncom/qiahao/nextvideo/view/TaskView\n*L\n55#1:206,3\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class TaskView extends FrameLayout {

    @Nullable
    private ViewTaskBinding binding;

    @Nullable
    private Function1<? super Integer, Unit> listener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        init();
    }

    private final void init() {
        this.binding = (ViewTaskBinding) g.h(LayoutInflater.from(getContext()), R.layout.view_task, this, true);
    }

    public static /* synthetic */ void refreshData$default(TaskView taskView, TaskProcess taskProcess, int i, Object obj) {
        if ((i & 1) != 0) {
            taskProcess = null;
        }
        taskView.refreshData(taskProcess);
    }

    @SuppressLint({"SetTextI18n"})
    private final void refreshItem(int position, TaskProcess data, ViewTaskItemBinding itemView, View process, Integer money) {
        TextView textView;
        TextView textView2;
        if (itemView != null && (textView2 = itemView.topText) != null) {
            textView2.setText("+" + NumberUtilsKt.rankNumberFormat(money != null ? money.intValue() : 0L));
        }
        if (itemView != null && (textView = itemView.buttonText) != null) {
            String format = String.format(ResourcesKtxKt.getStringById(this, 2131952498), Arrays.copyOf(new Object[]{Integer.valueOf(position)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            textView.setText(format);
        }
        if (Intrinsics.areEqual(data.getUnlock(), Boolean.FALSE)) {
            refreshItem(itemView, process, 1, position);
            return;
        }
        if (Intrinsics.areEqual(data.getSign(), Boolean.TRUE)) {
            Integer days = data.getDays();
            if (position <= (days != null ? days.intValue() : 0)) {
                refreshItem(itemView, process, 2, position);
                return;
            } else {
                refreshItem(itemView, process, 1, position);
                return;
            }
        }
        Integer days2 = data.getDays();
        if (position <= (days2 != null ? days2.intValue() : 0)) {
            refreshItem(itemView, process, 2, position);
            return;
        }
        Integer days3 = data.getDays();
        if (position == (days3 != null ? days3.intValue() : 0) + 1) {
            refreshItem(itemView, process, 3, position);
        } else {
            refreshItem(itemView, process, 1, position);
        }
    }

    static /* synthetic */ void refreshItem$default(TaskView taskView, int i, TaskProcess taskProcess, ViewTaskItemBinding viewTaskItemBinding, View view, Integer num, int i2, Object obj) {
        ViewTaskItemBinding viewTaskItemBinding2 = (i2 & 4) != 0 ? null : viewTaskItemBinding;
        View view2 = (i2 & 8) != 0 ? null : view;
        if ((i2 & 16) != 0) {
            num = 0;
        }
        taskView.refreshItem(i, taskProcess, viewTaskItemBinding2, view2, num);
    }

    @Nullable
    public final Function1<Integer, Unit> getListener() {
        return this.listener;
    }

    public final void refreshData(@Nullable TaskProcess data) {
        List<Integer> awards;
        ViewTaskItemBinding viewTaskItemBinding;
        ViewTaskItemBinding viewTaskItemBinding2;
        ViewTaskItemBinding viewTaskItemBinding3;
        ViewTaskItemBinding viewTaskItemBinding4;
        ViewTaskItemBinding viewTaskItemBinding5;
        ViewTaskItemBinding viewTaskItemBinding6;
        if (data != null && (awards = data.getAwards()) != null) {
            int i = 0;
            for (Object obj : awards) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                Integer num = (Integer) obj;
                ViewTaskItemBinding viewTaskItemBinding7 = null;
                View view = null;
                View view2 = null;
                View view3 = null;
                View view4 = null;
                View view5 = null;
                View view6 = null;
                switch (i2) {
                    case 1:
                        ViewTaskBinding viewTaskBinding = this.binding;
                        if (viewTaskBinding != null) {
                            viewTaskItemBinding7 = viewTaskBinding.dayLayout1;
                        }
                        refreshItem(1, data, viewTaskItemBinding7, null, num);
                        break;
                    case 2:
                        ViewTaskBinding viewTaskBinding2 = this.binding;
                        if (viewTaskBinding2 != null) {
                            viewTaskItemBinding = viewTaskBinding2.dayLayout2;
                        } else {
                            viewTaskItemBinding = null;
                        }
                        if (viewTaskBinding2 != null) {
                            view6 = viewTaskBinding2.line1;
                        }
                        refreshItem(2, data, viewTaskItemBinding, view6, num);
                        break;
                    case 3:
                        ViewTaskBinding viewTaskBinding3 = this.binding;
                        if (viewTaskBinding3 != null) {
                            viewTaskItemBinding2 = viewTaskBinding3.dayLayout3;
                        } else {
                            viewTaskItemBinding2 = null;
                        }
                        if (viewTaskBinding3 != null) {
                            view5 = viewTaskBinding3.line2;
                        }
                        refreshItem(3, data, viewTaskItemBinding2, view5, num);
                        break;
                    case 4:
                        ViewTaskBinding viewTaskBinding4 = this.binding;
                        if (viewTaskBinding4 != null) {
                            viewTaskItemBinding3 = viewTaskBinding4.dayLayout4;
                        } else {
                            viewTaskItemBinding3 = null;
                        }
                        if (viewTaskBinding4 != null) {
                            view4 = viewTaskBinding4.line3;
                        }
                        refreshItem(4, data, viewTaskItemBinding3, view4, num);
                        break;
                    case 5:
                        ViewTaskBinding viewTaskBinding5 = this.binding;
                        if (viewTaskBinding5 != null) {
                            viewTaskItemBinding4 = viewTaskBinding5.dayLayout5;
                        } else {
                            viewTaskItemBinding4 = null;
                        }
                        if (viewTaskBinding5 != null) {
                            view3 = viewTaskBinding5.line4;
                        }
                        refreshItem(5, data, viewTaskItemBinding4, view3, num);
                        break;
                    case 6:
                        ViewTaskBinding viewTaskBinding6 = this.binding;
                        if (viewTaskBinding6 != null) {
                            viewTaskItemBinding5 = viewTaskBinding6.dayLayout6;
                        } else {
                            viewTaskItemBinding5 = null;
                        }
                        if (viewTaskBinding6 != null) {
                            view2 = viewTaskBinding6.line5;
                        }
                        refreshItem(6, data, viewTaskItemBinding5, view2, num);
                        break;
                    case 7:
                        ViewTaskBinding viewTaskBinding7 = this.binding;
                        if (viewTaskBinding7 != null) {
                            viewTaskItemBinding6 = viewTaskBinding7.dayLayout7;
                        } else {
                            viewTaskItemBinding6 = null;
                        }
                        if (viewTaskBinding7 != null) {
                            view = viewTaskBinding7.line6;
                        }
                        refreshItem(7, data, viewTaskItemBinding6, view, num);
                        break;
                }
                i = i2;
            }
        }
    }

    public final void setListener(@Nullable Function1<? super Integer, Unit> function1) {
        this.listener = function1;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        init();
    }

    static /* synthetic */ void refreshItem$default(TaskView taskView, ViewTaskItemBinding viewTaskItemBinding, View view, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            viewTaskItemBinding = null;
        }
        if ((i3 & 2) != 0) {
            view = null;
        }
        taskView.refreshItem(viewTaskItemBinding, view, i, i2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        init();
    }

    private final void refreshItem(ViewTaskItemBinding itemView, View process, int type, int position) {
        TextView textView;
        TextView textView2;
        ImageView imageView;
        ImageView imageView2;
        ImageView imageView3;
        TextView textView3;
        TextView textView4;
        ImageView imageView4;
        ImageView imageView5;
        TextView textView5;
        TextView textView6;
        ImageView imageView6;
        ImageView imageView7;
        ImageView imageView8;
        if (type == 1) {
            if (itemView != null && (imageView3 = itemView.completeImg) != null) {
                imageView3.setVisibility(8);
            }
            if (itemView != null && (imageView2 = itemView.moneyImg) != null) {
                imageView2.setVisibility(0);
            }
            if (itemView != null && (imageView = itemView.moneyImg) != null) {
                imageView.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), position == 7 ? R.drawable.task_diamond_default : R.drawable.task_diamond1));
            }
            if (itemView != null && (textView2 = itemView.buttonText) != null) {
                textView2.setTextColor(androidx.core.content.a.getColor(getContext(), 2131099918));
            }
            if (itemView != null && (textView = itemView.topText) != null) {
                textView.setTextColor(androidx.core.content.a.getColor(getContext(), 2131099918));
            }
            if (process != null) {
                process.setBackground(androidx.core.content.a.getDrawable(getContext(), R.drawable.task_process_default));
                return;
            }
            return;
        }
        if (type == 2) {
            if (itemView != null && (imageView5 = itemView.completeImg) != null) {
                imageView5.setVisibility(0);
            }
            if (itemView != null && (imageView4 = itemView.moneyImg) != null) {
                imageView4.setVisibility(4);
            }
            if (itemView != null && (textView4 = itemView.buttonText) != null) {
                textView4.setTextColor(androidx.core.content.a.getColor(getContext(), 2131099914));
            }
            if (itemView != null && (textView3 = itemView.topText) != null) {
                textView3.setTextColor(androidx.core.content.a.getColor(getContext(), 2131099914));
            }
            if (process != null) {
                process.setBackground(androidx.core.content.a.getDrawable(getContext(), R.drawable.task_process_select));
                return;
            }
            return;
        }
        if (type != 3) {
            return;
        }
        if (itemView != null && (imageView8 = itemView.completeImg) != null) {
            imageView8.setVisibility(8);
        }
        if (itemView != null && (imageView7 = itemView.moneyImg) != null) {
            imageView7.setVisibility(0);
        }
        if (itemView != null && (imageView6 = itemView.moneyImg) != null) {
            imageView6.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), position == 7 ? R.drawable.task_diamond_select : R.drawable.task_diamond));
        }
        if (itemView != null && (textView6 = itemView.buttonText) != null) {
            textView6.setTextColor(androidx.core.content.a.getColor(getContext(), 2131099918));
        }
        if (itemView != null && (textView5 = itemView.topText) != null) {
            textView5.setTextColor(androidx.core.content.a.getColor(getContext(), 2131099918));
        }
        if (process != null) {
            process.setBackground(androidx.core.content.a.getDrawable(getContext(), R.drawable.task_process_select));
        }
    }
}
