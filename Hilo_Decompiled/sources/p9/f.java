package p9;

import android.content.Context;
import android.content.Intent;
import com.heytap.mcssdk.constant.MessageConstant$CommandId;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class f {
    private static boolean a(Context context) {
        String j10 = i9.d.h().j(context);
        if (h.f(context, j10) && h.c(context, j10) >= 1017) {
            return true;
        }
        return false;
    }

    public static boolean b(Context context, List list) {
        LinkedList linkedList = new LinkedList();
        linkedList.addAll(list);
        d.a("isSupportStatisticByMcs:" + a(context) + ",list size:" + linkedList.size());
        if (linkedList.size() > 0 && a(context)) {
            return c(context, linkedList);
        }
        return false;
    }

    private static boolean c(Context context, List list) {
        try {
            Intent intent = new Intent();
            intent.setAction(i9.d.h().q(context));
            intent.setPackage(i9.d.h().j(context));
            intent.putExtra("appPackage", context.getPackageName());
            intent.putExtra("type", MessageConstant$CommandId.COMMAND_STATISTIC);
            intent.putExtra("count", list.size());
            ArrayList<String> arrayList = new ArrayList<>();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((t9.c) it.next()).i());
            }
            intent.putStringArrayListExtra("list", arrayList);
            context.startService(intent);
            return true;
        } catch (Exception e10) {
            d.b("statisticMessage--Exception" + e10.getMessage());
            return false;
        }
    }
}
