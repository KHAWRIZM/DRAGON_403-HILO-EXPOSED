package com.qiahao.nextvideo.ui.rank;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.qiahao.base_common.interfaceing.ControllerListener;
import com.qiahao.nextvideo.app.base.HiloBaseActivity;
import com.qiahao.nextvideo.ui.reusable.viewcontroller.Window;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \n2\u00020\u00012\u00020\u0002:\u0001\nB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0014J\b\u0010\t\u001a\u00020\u0006H\u0016¨\u0006\u000b"}, d2 = {"Lcom/qiahao/nextvideo/ui/rank/AllRankActivity;", "Lcom/qiahao/nextvideo/app/base/HiloBaseActivity;", "Lcom/qiahao/base_common/interfaceing/ControllerListener;", "<init>", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onBackPress", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class AllRankActivity extends HiloBaseActivity implements ControllerListener {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String POSITION = "position";

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/qiahao/nextvideo/ui/rank/AllRankActivity$Companion;", "", "<init>", "()V", "POSITION", "", "start", "", "context", "Landroid/content/Context;", "position", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void start$default(Companion companion, Context context, int i, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                i = 0;
            }
            companion.start(context, i);
        }

        @JvmStatic
        public final void start(@NotNull Context context, int position) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent(context, (Class<?>) AllRankActivity.class);
            intent.putExtra("position", position);
            context.startActivity(intent);
        }

        private Companion() {
        }
    }

    @JvmStatic
    public static final void start(@NotNull Context context, int i) {
        INSTANCE.start(context, i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onBackPress() {
        finish();
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int intExtra = getIntent().getIntExtra("position", 0);
        Window controllerWindowNotNull = getControllerWindowNotNull();
        AllRankViewController allRankViewController = new AllRankViewController(intExtra);
        allRankViewController.setMListener(this);
        controllerWindowNotNull.setRootViewController(allRankViewController);
    }
}
