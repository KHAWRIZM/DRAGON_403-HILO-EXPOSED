package a;

import android.content.Context;
import androidx.annotation.Keep;
import com.therouter.TheRouter;
import com.therouter.flow.Digraph;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u001a\u0018\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007\u001a\u0010\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\n\u001a\u0006\u0010\u000b\u001a\u00020\u0003\u001a\u0006\u0010\f\u001a\u00020\u0003\"\u0012\u0010\u0000\u001a\u00020\u00018\u0000@\u0000X\u0081\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"asm", "", "addFlowTask", "", "context", "Landroid/content/Context;", "digraph", "Lcom/therouter/flow/Digraph;", "autowiredInject", "obj", "", "initDefaultRouteMap", "trojan", "router_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
@JvmName(name = "TheRouterServiceProvideInjecter")
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class TheRouterServiceProvideInjecter {

    @Keep
    @JvmField
    public static boolean asm = true;

    public static final void addFlowTask(@Nullable Context context, @NotNull Digraph digraph) {
        try {
            ServiceProvider__TheRouter__851042640.addFlowTask(context, digraph);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static final void autowiredInject(@Nullable Object obj) {
    }

    public static final void initDefaultRouteMap() {
    }

    public static final void trojan() {
        try {
            TheRouter.getRouterInject().privateAddInterceptor(new ServiceProvider__TheRouter__851042640());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
