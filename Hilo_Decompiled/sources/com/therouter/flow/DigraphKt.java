package com.therouter.flow;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\"\n\u0000\u001a\"\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002\u001a\u0018\u0010\u0006\u001a\u00020\u00072\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\tH\u0002¨\u0006\n"}, d2 = {"getLog", "", "list", "", "Lcom/therouter/flow/Task;", "root", "isNotEmpty", "", "set", "", "router_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class DigraphKt {
    public static final /* synthetic */ String access$getLog(List list, Task task) {
        return getLog(list, task);
    }

    public static final /* synthetic */ boolean access$isNotEmpty(Set set) {
        return isNotEmpty(set);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String getLog(List<? extends Task> list, Task task) {
        if (list != null && !list.isEmpty()) {
            StringBuilder sb2 = new StringBuilder();
            Iterator<? extends Task> it = list.iterator();
            while (it.hasNext()) {
                sb2.append(it.next().getTaskName());
                sb2.append("-->");
            }
            if (task != null) {
                sb2.append(task.getTaskName());
            }
            String sb3 = sb2.toString();
            Intrinsics.checkNotNullExpressionValue(sb3, "toString(...)");
            return sb3;
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isNotEmpty(Set<? extends Task> set) {
        if (set != null && !set.isEmpty()) {
            return true;
        }
        return false;
    }
}
