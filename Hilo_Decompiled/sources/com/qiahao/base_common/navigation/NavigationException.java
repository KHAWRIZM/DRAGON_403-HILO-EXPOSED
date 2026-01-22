package com.qiahao.base_common.navigation;

import com.facebook.share.internal.ShareConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u00142\u00060\u0001j\u0002`\u0002:\u0001\u0014B\u0013\b\u0016\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u001d\b\u0016\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\tB'\b\u0016\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\fB\u001d\b\u0016\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\rJ\b\u0010\u0011\u001a\u00020\bH\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0006¨\u0006\u0015"}, d2 = {"Lcom/qiahao/base_common/navigation/NavigationException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "code", "", "<init>", "(I)V", ShareConstants.WEB_DIALOG_PARAM_MESSAGE, "", "(Ljava/lang/String;I)V", "cause", "", "(Ljava/lang/String;Ljava/lang/Throwable;I)V", "(Ljava/lang/Throwable;I)V", "getCode", "()I", "setCode", "toString", "canToast", "", "Companion", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class NavigationException extends Exception {
    public static final int CODE_INSTANCE_CONFLICT = 1;
    public static final int CODE_INVALID_PARAMETER = 3;
    public static final int CODE_INVALID_PATH = 4;
    public static final int CODE_NOT_LOGIN = 2;
    private int code;

    public NavigationException(int i10) {
        this.code = i10;
    }

    public boolean canToast() {
        return true;
    }

    public final int getCode() {
        return this.code;
    }

    public final void setCode(int i10) {
        this.code = i10;
    }

    @Override // java.lang.Throwable
    @NotNull
    public String toString() {
        return "[" + super.toString() + "]\n[code=" + this.code + ",message=" + getMessage() + "]\n[cause=" + getCause() + "]";
    }

    public /* synthetic */ NavigationException(int i10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? 0 : i10);
    }

    public NavigationException(@Nullable String str, int i10) {
        super(str);
        this.code = i10;
    }

    public /* synthetic */ NavigationException(String str, int i10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i11 & 2) != 0 ? 0 : i10);
    }

    public NavigationException(@Nullable String str, @Nullable Throwable th, int i10) {
        super(str, th);
        this.code = i10;
    }

    public /* synthetic */ NavigationException(String str, Throwable th, int i10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, th, (i11 & 4) != 0 ? 0 : i10);
    }

    public NavigationException(@Nullable Throwable th, int i10) {
        super(th);
        this.code = i10;
    }

    public /* synthetic */ NavigationException(Throwable th, int i10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(th, (i11 & 2) != 0 ? 0 : i10);
    }
}
