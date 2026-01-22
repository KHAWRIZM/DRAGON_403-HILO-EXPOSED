package com.qiahao.nextvideo.ui.power;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.model.WeekMedal;
import com.qiahao.nextvideo.databinding.ViewPowerMedalBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0015"}, d2 = {"Lcom/qiahao/nextvideo/ui/power/PowerMedalWrapper;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "viewController", "Lcom/qiahao/nextvideo/ui/power/PowerTeamViewController;", "<init>", "(Landroid/content/Context;Lcom/qiahao/nextvideo/ui/power/PowerTeamViewController;)V", "getViewController", "()Lcom/qiahao/nextvideo/ui/power/PowerTeamViewController;", "binding", "Lcom/qiahao/nextvideo/databinding/ViewPowerMedalBinding;", "getBinding", "()Lcom/qiahao/nextvideo/databinding/ViewPowerMedalBinding;", "setBinding", "(Lcom/qiahao/nextvideo/databinding/ViewPowerMedalBinding;)V", "initDataAndView", "", "week", "Lcom/qiahao/nextvideo/data/model/WeekMedal;", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class PowerMedalWrapper extends FrameLayout {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = "PowerMedalWrapper";

    @NotNull
    private ViewPowerMedalBinding binding;

    @NotNull
    private final PowerTeamViewController viewController;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/qiahao/nextvideo/ui/power/PowerMedalWrapper$Companion;", "", "<init>", "()V", "TAG", "", "init", "Lcom/qiahao/nextvideo/ui/power/PowerMedalWrapper;", "viewController", "Lcom/qiahao/nextvideo/ui/power/PowerTeamViewController;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final PowerMedalWrapper init(@NotNull PowerTeamViewController viewController) {
            Intrinsics.checkNotNullParameter(viewController, "viewController");
            return new PowerMedalWrapper(viewController.getRequireContext(), viewController);
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PowerMedalWrapper(@NotNull Context context, @NotNull PowerTeamViewController powerTeamViewController) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(powerTeamViewController, "viewController");
        this.viewController = powerTeamViewController;
        this.binding = (ViewPowerMedalBinding) androidx.databinding.g.h(LayoutInflater.from(context), R.layout.view_power_medal, this, true);
    }

    @NotNull
    public final ViewPowerMedalBinding getBinding() {
        return this.binding;
    }

    @NotNull
    public final PowerTeamViewController getViewController() {
        return this.viewController;
    }

    public final void initDataAndView(@NotNull WeekMedal week) {
        Intrinsics.checkNotNullParameter(week, "week");
        this.binding.textMedalA.setText(String.valueOf(week.getA()));
        this.binding.textMedalB.setText(String.valueOf(week.getB()));
        this.binding.textMedalC.setText(String.valueOf(week.getC()));
        this.binding.textMedalD.setText(String.valueOf(week.getD()));
        this.binding.textMedalE.setText(String.valueOf(week.getE()));
        this.binding.textMedalF.setText(String.valueOf(week.getF()));
        this.binding.textMedalG.setText(String.valueOf(week.getG()));
        this.binding.textMedalH.setText(String.valueOf(week.getH()));
        this.binding.textMedalI.setText(String.valueOf(week.getI()));
        this.binding.textMedalJ.setText(String.valueOf(week.getJ()));
        this.binding.textMedalK.setText(String.valueOf(week.getK()));
        this.binding.textMedalL.setText(String.valueOf(week.getL()));
        this.binding.textMedalM.setText(String.valueOf(week.getM()));
        this.binding.textMedalN.setText(String.valueOf(week.getN()));
        this.binding.textMedalO.setText(String.valueOf(week.getO()));
    }

    public final void setBinding(@NotNull ViewPowerMedalBinding viewPowerMedalBinding) {
        Intrinsics.checkNotNullParameter(viewPowerMedalBinding, "<set-?>");
        this.binding = viewPowerMedalBinding;
    }
}
