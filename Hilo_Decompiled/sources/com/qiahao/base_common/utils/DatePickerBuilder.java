package com.qiahao.base_common.utils;

import android.content.Context;
import android.view.View;
import android.widget.Checkable;
import android.widget.TextView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.R;
import java.util.Calendar;
import java.util.Date;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0018\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\f\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ!\u0010\u0012\u001a\u00020\u00002\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u001b\u0010\u001a\u001a\u00020\u00002\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00100\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ!\u0010\u001e\u001a\u00020\u00002\b\u0010\u001c\u001a\u0004\u0018\u00010\n2\b\u0010\u001d\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u001e\u0010\u001fJ\u0015\u0010\"\u001a\u00020\u00002\u0006\u0010!\u001a\u00020 ¢\u0006\u0004\b\"\u0010#J\r\u0010%\u001a\u00020$¢\u0006\u0004\b%\u0010&R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010'\u001a\u0004\b(\u0010)R\u0016\u0010*\u001a\u00020$8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b*\u0010+R\u0018\u0010-\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0018\u0010/\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R$\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u00101R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u00102R\u0016\u0010!\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u00103R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u00100R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u00100R\u0016\u00104\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u001e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u00106¨\u00067"}, d2 = {"Lcom/qiahao/base_common/utils/DatePickerBuilder;", "", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "", "title", "setTitle", "(Ljava/lang/String;)Lcom/qiahao/base_common/utils/DatePickerBuilder;", "Ljava/util/Calendar;", "calendar", "setDate", "(Ljava/util/Calendar;)Lcom/qiahao/base_common/utils/DatePickerBuilder;", "Lkotlin/Function1;", "", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnDateConfirmListener", "(Lkotlin/jvm/functions/Function1;)Lcom/qiahao/base_common/utils/DatePickerBuilder;", "", "isIntercept", "setInterceptToasty", "(Z)Lcom/qiahao/base_common/utils/DatePickerBuilder;", "Lkotlin/Function0;", "toastyListener", "setToastyListener", "(Lkotlin/jvm/functions/Function0;)Lcom/qiahao/base_common/utils/DatePickerBuilder;", "startDate", "endDate", "setRangDate", "(Ljava/util/Calendar;Ljava/util/Calendar;)Lcom/qiahao/base_common/utils/DatePickerBuilder;", "", "type", "setType", "([Z)Lcom/qiahao/base_common/utils/DatePickerBuilder;", "Lj4/b;", "create", "()Lj4/b;", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "pickView", "Lj4/b;", "Ljava/util/Date;", "selectDate", "Ljava/util/Date;", "defaultDate", "Ljava/util/Calendar;", "Lkotlin/jvm/functions/Function1;", "Ljava/lang/String;", "[Z", "interceptEnd", "Z", "Lkotlin/jvm/functions/Function0;", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nDatePickerBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DatePickerBuilder.kt\ncom/qiahao/base_common/utils/DatePickerBuilder\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n*L\n1#1,155:1\n61#2,9:156\n61#2,9:165\n*S KotlinDebug\n*F\n+ 1 DatePickerBuilder.kt\ncom/qiahao/base_common/utils/DatePickerBuilder\n*L\n129#1:156,9\n133#1:165,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class DatePickerBuilder {

    @NotNull
    private final Context context;

    @Nullable
    private Calendar defaultDate;

    @Nullable
    private Calendar endDate;
    private boolean interceptEnd;

    @Nullable
    private Function1<? super Long, Unit> listener;
    private j4.b pickView;

    @Nullable
    private Date selectDate;

    @Nullable
    private Calendar startDate;

    @Nullable
    private String title;

    @Nullable
    private Function0<Unit> toastyListener;

    @NotNull
    private boolean[] type;

    public DatePickerBuilder(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.type = new boolean[]{true, true, true, false, false, false};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void create$lambda$5(final DatePickerBuilder datePickerBuilder, View view) {
        final TextView textView = (TextView) view.findViewById(R.id.cancel);
        final long j10 = 800;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.base_common.utils.DatePickerBuilder$create$lambda$5$$inlined$singleClick$default$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    j4.b bVar;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView) > j10 || (textView instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(textView, currentTimeMillis);
                        bVar = datePickerBuilder.pickView;
                        if (bVar == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("pickView");
                            bVar = null;
                        }
                        bVar.f();
                    }
                }
            });
        }
        final TextView textView2 = (TextView) view.findViewById(R.id.confirm);
        if (textView2 != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.base_common.utils.DatePickerBuilder$create$lambda$5$$inlined$singleClick$default$2
                /* JADX WARN: Code restructure failed: missing block: B:26:0x0063, code lost:
                
                    r0 = r4.selectDate;
                 */
                @Override // android.view.View.OnClickListener
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final void onClick(View view2) {
                    Date date;
                    long j11;
                    Calendar calendar;
                    Function1 function1;
                    j4.b bVar;
                    Date date2;
                    boolean z10;
                    Function0 function0;
                    Date time;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView2) > j10 || (textView2 instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(textView2, currentTimeMillis);
                        date = datePickerBuilder.selectDate;
                        long j12 = 0;
                        if (date != null) {
                            j11 = date.getTime();
                        } else {
                            j11 = 0;
                        }
                        calendar = datePickerBuilder.endDate;
                        if (calendar != null && (time = calendar.getTime()) != null) {
                            j12 = time.getTime();
                        }
                        if (j11 > j12) {
                            z10 = datePickerBuilder.interceptEnd;
                            if (z10) {
                                function0 = datePickerBuilder.toastyListener;
                                if (function0 != null) {
                                    function0.invoke();
                                    return;
                                }
                                return;
                            }
                        }
                        function1 = datePickerBuilder.listener;
                        if (function1 != null && date2 != null) {
                            function1.invoke(Long.valueOf(date2.getTime()));
                        }
                        bVar = datePickerBuilder.pickView;
                        if (bVar == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("pickView");
                            bVar = null;
                        }
                        bVar.f();
                    }
                }
            });
        }
    }

    @NotNull
    public final j4.b create() {
        Date date;
        if (this.defaultDate == null) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            this.defaultDate = calendar;
            Unit unit = Unit.INSTANCE;
        }
        Calendar calendar2 = this.defaultDate;
        if (calendar2 != null) {
            date = calendar2.getTime();
        } else {
            date = null;
        }
        this.selectDate = date;
        j4.b a10 = new f4.a(this.context, null).k(this.startDate, this.endDate).f(this.defaultDate).b(true).j(2.5f).o(this.type).i(R.layout.base_dialog_bottom_sheet_date_picker, new h4.a() { // from class: com.qiahao.base_common.utils.c
            @Override // h4.a
            public final void a(View view) {
                DatePickerBuilder.create$lambda$5(DatePickerBuilder.this, view);
            }
        }).n(new h4.d() { // from class: com.qiahao.base_common.utils.d
            @Override // h4.d
            public final void a(Date date2) {
                DatePickerBuilder.this.selectDate = date2;
            }
        }).a();
        this.pickView = a10;
        if (a10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pickView");
            return null;
        }
        return a10;
    }

    @NotNull
    public final Context getContext() {
        return this.context;
    }

    @NotNull
    public final DatePickerBuilder setDate(@NotNull Calendar calendar) {
        Intrinsics.checkNotNullParameter(calendar, "calendar");
        this.defaultDate = calendar;
        return this;
    }

    @NotNull
    public final DatePickerBuilder setInterceptToasty(boolean isIntercept) {
        this.interceptEnd = isIntercept;
        return this;
    }

    @NotNull
    public final DatePickerBuilder setOnDateConfirmListener(@NotNull Function1<? super Long, Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listener = listener;
        return this;
    }

    @NotNull
    public final DatePickerBuilder setRangDate(@Nullable Calendar startDate, @Nullable Calendar endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
        return this;
    }

    @NotNull
    public final DatePickerBuilder setTitle(@NotNull String title) {
        Intrinsics.checkNotNullParameter(title, "title");
        this.title = title;
        return this;
    }

    @NotNull
    public final DatePickerBuilder setToastyListener(@NotNull Function0<Unit> toastyListener) {
        Intrinsics.checkNotNullParameter(toastyListener, "toastyListener");
        this.toastyListener = toastyListener;
        return this;
    }

    @NotNull
    public final DatePickerBuilder setType(@NotNull boolean[] type) {
        Intrinsics.checkNotNullParameter(type, "type");
        if (type.length == 6) {
            this.type = type;
        }
        return this;
    }
}
