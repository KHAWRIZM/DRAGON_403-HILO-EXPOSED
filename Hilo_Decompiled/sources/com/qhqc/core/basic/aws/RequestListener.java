package com.qhqc.core.basic.aws;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\b"}, d2 = {"Lcom/qhqc/core/basic/aws/RequestListener;", "", "onComplete", "", "result", "Lcom/qhqc/core/basic/aws/Result;", "onFailed", "onProgress", "basic_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public interface RequestListener {

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class DefaultImpls {
        public static void onComplete(@NotNull RequestListener requestListener, @NotNull Result result) {
            Intrinsics.checkNotNullParameter(result, "result");
        }

        public static void onFailed(@NotNull RequestListener requestListener, @NotNull Result result) {
            Intrinsics.checkNotNullParameter(result, "result");
        }

        public static void onProgress(@NotNull RequestListener requestListener, @NotNull Result result) {
            Intrinsics.checkNotNullParameter(result, "result");
        }
    }

    void onComplete(@NotNull Result result);

    void onFailed(@NotNull Result result);

    void onProgress(@NotNull Result result);
}
