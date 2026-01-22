package com.qiahao.base_common.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.Toast;
import com.oudi.core.support.ActivityLifecycleManager;
import com.qiahao.base_common.R;
import es.dmoral.toasty.a;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/qiahao/base_common/utils/HiloToasty;", "", "<init>", "()V", "Companion", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class HiloToasty {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bJ$\u0010\f\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bJ$\u0010\r\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b¨\u0006\u000e"}, d2 = {"Lcom/qiahao/base_common/utils/HiloToasty$Companion;", "", "<init>", "()V", "normal", "Landroid/widget/Toast;", "context", "Landroid/content/Context;", "content", "", "showIcon", "", "success", "error", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ Toast error$default(Companion companion, Context context, String str, boolean z10, int i10, Object obj) {
            if ((i10 & 4) != 0) {
                z10 = false;
            }
            return companion.error(context, str, z10);
        }

        public static /* synthetic */ Toast normal$default(Companion companion, Context context, String str, boolean z10, int i10, Object obj) {
            if ((i10 & 4) != 0) {
                z10 = false;
            }
            return companion.normal(context, str, z10);
        }

        public static /* synthetic */ Toast success$default(Companion companion, Context context, String str, boolean z10, int i10, Object obj) {
            if ((i10 & 4) != 0) {
                z10 = false;
            }
            return companion.success(context, str, z10);
        }

        @Nullable
        public final Toast error(@Nullable Context context, @NotNull String content, boolean showIcon) {
            Toast h10;
            Intrinsics.checkNotNullParameter(content, "content");
            if (ActivityLifecycleManager.INSTANCE.isAppOnBackground() || context == null || (h10 = es.dmoral.toasty.a.h(context, content, (Drawable) null, androidx.core.content.a.getColor(context, R.color.colorMaskAccent), -1, 0, showIcon, false)) == null) {
                return null;
            }
            return h10;
        }

        @Nullable
        public final Toast normal(@Nullable Context context, @NotNull String content, boolean showIcon) {
            Toast h10;
            Intrinsics.checkNotNullParameter(content, "content");
            if (ActivityLifecycleManager.INSTANCE.isAppOnBackground() || context == null || (h10 = es.dmoral.toasty.a.h(context, content, (Drawable) null, androidx.core.content.a.getColor(context, R.color.colorMaskAccent), -1, 0, showIcon, false)) == null) {
                return null;
            }
            return h10;
        }

        @Nullable
        public final Toast success(@Nullable Context context, @NotNull String content, boolean showIcon) {
            Toast h10;
            Intrinsics.checkNotNullParameter(content, "content");
            if (ActivityLifecycleManager.INSTANCE.isAppOnBackground() || context == null || (h10 = es.dmoral.toasty.a.h(context, content, (Drawable) null, androidx.core.content.a.getColor(context, R.color.colorMaskAccent), -1, 0, showIcon, false)) == null) {
                return null;
            }
            return h10;
        }

        private Companion() {
        }
    }

    public HiloToasty() {
        a.a.c().e(true).d(14).a(true).b();
    }
}
