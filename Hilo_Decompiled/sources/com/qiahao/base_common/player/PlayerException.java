package com.qiahao.base_common.player;

import com.facebook.share.internal.ShareConstants;
import com.oudi.core.exceptions.SuperException;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB%\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0004\u0010\u000bB\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0004\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/qiahao/base_common/player/PlayerException;", "Lcom/oudi/core/exceptions/SuperException;", "code", "", "<init>", "(I)V", ShareConstants.WEB_DIALOG_PARAM_MESSAGE, "", "(ILjava/lang/String;)V", "cause", "", "(ILjava/lang/String;Ljava/lang/Throwable;)V", "(ILjava/lang/Throwable;)V", "Companion", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class PlayerException extends SuperException {
    public static final int TYPE_SOURCE = 0;
    public static final int TYPE_UNEXPECTED = 1;

    public PlayerException(int i10) {
        super(i10);
    }

    public PlayerException(int i10, @Nullable String str) {
        super(str, i10);
    }

    public PlayerException(int i10, @Nullable String str, @Nullable Throwable th) {
        super(str, th, i10);
    }

    public PlayerException(int i10, @Nullable Throwable th) {
        super(th, i10);
    }
}
