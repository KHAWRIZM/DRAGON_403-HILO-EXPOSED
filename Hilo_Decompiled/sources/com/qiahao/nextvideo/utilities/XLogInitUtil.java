package com.qiahao.nextvideo.utilities;

import b6.a;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import n5.a;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/qiahao/nextvideo/utilities/XLogInitUtil;", "", "<init>", "()V", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class XLogInitUtil {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ\r\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\u0003¨\u0006\f"}, d2 = {"Lcom/qiahao/nextvideo/utilities/XLogInitUtil$Companion;", "", "<init>", "()V", "Ln5/a;", "setXLogConfig", "()Ln5/a;", "Lb6/a;", "setXLogPrinterFileConfig", "()Lb6/a;", "", "initXLogInit", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final n5.a setXLogConfig() {
            n5.a p = new a.a().r(Integer.MIN_VALUE).s("Hilo").p();
            Intrinsics.checkNotNullExpressionValue(p, "build(...)");
            return p;
        }

        private final b6.a setXLogPrinterFileConfig() {
            b6.a b = new a.b(FileManager.INSTANCE.getCacheFilePrinter()).c(new e6.a("log")).a(new c6.d(4194304L, 1)).e(new o5.c("{d MM-dd HH:mm:ss.SSS}{l}/{t}:{m}")).b();
            Intrinsics.checkNotNullExpressionValue(b, "build(...)");
            return b;
        }

        public final void initXLogInit() {
            n5.e.d(setXLogConfig(), new a6.b[]{new a6.a(true), setXLogPrinterFileConfig()});
        }

        private Companion() {
        }
    }
}
