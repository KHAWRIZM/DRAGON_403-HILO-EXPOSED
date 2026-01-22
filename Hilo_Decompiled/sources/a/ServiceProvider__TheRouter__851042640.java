package a;

import android.content.Context;
import androidx.annotation.Keep;
import com.qiahao.base_common.support.AppService;
import com.qiahao.nextvideo.support.AppServiceImpl;
import com.therouter.flow.Digraph;
import com.therouter.inject.Interceptor;

@Keep
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class ServiceProvider__TheRouter__851042640 implements Interceptor {
    public static final String FLOW_TASK_JSON = "{}";
    public static final String TAG = "Created by kymjs, and APT Version is 1.3.0-rc8.";
    public static final String THEROUTER_APT_VERSION = "1.3.0-rc8";

    public static void addFlowTask(Context context, Digraph digraph) {
    }

    public void initFlowTask(Context context, Digraph digraph) {
        addFlowTask(context, digraph);
    }

    public <T> T interception(Class<T> cls, Object... objArr) {
        if (AppService.class.equals(cls) && objArr.length == 0) {
            return (T) new AppServiceImpl();
        }
        return null;
    }
}
