package com.therouter.router.autowired;

import android.app.Activity;
import android.app.Fragment;
import android.view.View;
import com.taobao.accs.common.Constants;
import com.therouter.router.AutowiredItem;
import com.therouter.router.interceptor.AutowiredParser;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J3\u0010\u0003\u001a\u0004\u0018\u0001H\u0004\"\u0004\b\u0000\u0010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/therouter/router/autowired/DefaultIdParser;", "Lcom/therouter/router/interceptor/AutowiredParser;", "()V", "parse", "T", "type", "", Constants.KEY_TARGET, "", "item", "Lcom/therouter/router/AutowiredItem;", "(Ljava/lang/String;Ljava/lang/Object;Lcom/therouter/router/AutowiredItem;)Ljava/lang/Object;", "router_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class DefaultIdParser implements AutowiredParser {
    @Override // com.therouter.router.interceptor.AutowiredParser
    @Nullable
    public <T> T parse(@Nullable String type, @Nullable Object target, @Nullable AutowiredItem item) {
        View view;
        if (item == null || item.getId() == 0) {
            return null;
        }
        if (target instanceof View) {
            return (T) ((View) target).findViewById(item.getId());
        }
        if (target instanceof Activity) {
            return (T) ((Activity) target).findViewById(item.getId());
        }
        if (target instanceof Fragment) {
            View view2 = ((Fragment) target).getView();
            Intrinsics.checkNotNull(view2);
            return (T) view2.findViewById(item.getId());
        }
        if (!(target instanceof androidx.fragment.app.Fragment) || (view = ((androidx.fragment.app.Fragment) target).getView()) == null) {
            return null;
        }
        return (T) view.findViewById(item.getId());
    }
}
