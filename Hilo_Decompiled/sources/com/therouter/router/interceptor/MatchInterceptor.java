package com.therouter.router.interceptor;

import com.tencent.qcloud.tuicore.TUIConstants;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH&J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\f"}, d2 = {"Lcom/therouter/router/interceptor/MatchInterceptor;", "", "()V", "priority", "", "getPriority", "()I", "replace", "", TUIConstants.TUICalling.PARAM_NAME_AUDIO_PATH, "watch", "", "router_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public abstract class MatchInterceptor {
    public int getPriority() {
        return 5;
    }

    @Nullable
    public abstract String replace(@Nullable String path);

    public boolean watch(@Nullable String path) {
        return true;
    }
}
