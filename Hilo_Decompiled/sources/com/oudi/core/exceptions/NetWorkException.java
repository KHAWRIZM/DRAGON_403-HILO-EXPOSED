package com.oudi.core.exceptions;

import com.facebook.share.internal.ShareConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B%\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/oudi/core/exceptions/NetWorkException;", "Lcom/oudi/core/exceptions/SuperException;", ShareConstants.WEB_DIALOG_PARAM_MESSAGE, "", "code", "", "<init>", "(Ljava/lang/String;I)V", "cause", "", "(Ljava/lang/String;Ljava/lang/Throwable;I)V", "lib_core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class NetWorkException extends SuperException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NetWorkException(@NotNull String message, int i10) {
        super(message, i10);
        Intrinsics.checkNotNullParameter(message, "message");
    }

    public /* synthetic */ NetWorkException(String str, int i10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i11 & 2) != 0 ? 0 : i10);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NetWorkException(@NotNull String message, @Nullable Throwable th, int i10) {
        super(message, th, i10);
        Intrinsics.checkNotNullParameter(message, "message");
    }

    public /* synthetic */ NetWorkException(String str, Throwable th, int i10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, th, (i11 & 4) != 0 ? 0 : i10);
    }
}
