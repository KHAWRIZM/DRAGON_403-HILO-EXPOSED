package com.qiahao.nextvideo.data.service;

import android.content.Context;
import com.opensource.svgaplayer.SVGAParser;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/qiahao/nextvideo/data/service/SvgaService;", "", "<init>", "()V", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class SvgaService {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    public static SvgaService shared;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000e"}, d2 = {"Lcom/qiahao/nextvideo/data/service/SvgaService$Companion;", "", "<init>", "()V", "shared", "Lcom/qiahao/nextvideo/data/service/SvgaService;", "getShared", "()Lcom/qiahao/nextvideo/data/service/SvgaService;", "setShared", "(Lcom/qiahao/nextvideo/data/service/SvgaService;)V", "init", "", "context", "Landroid/content/Context;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final SvgaService getShared() {
            SvgaService svgaService = SvgaService.shared;
            if (svgaService != null) {
                return svgaService;
            }
            Intrinsics.throwUninitializedPropertyAccessException("shared");
            return null;
        }

        public final void init(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            setShared(new SvgaService());
            SVGAParser.Companion.shareParser().init(context);
        }

        public final void setShared(@NotNull SvgaService svgaService) {
            Intrinsics.checkNotNullParameter(svgaService, "<set-?>");
            SvgaService.shared = svgaService;
        }

        private Companion() {
        }
    }
}
