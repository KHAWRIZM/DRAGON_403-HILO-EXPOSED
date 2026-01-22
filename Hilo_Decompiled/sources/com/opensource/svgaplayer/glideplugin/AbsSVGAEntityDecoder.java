package com.opensource.svgaplayer.glideplugin;

import android.util.Log;
import com.facebook.internal.NativeProtocol;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b \u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J-\u0010\b\u001a\u0004\u0018\u0001H\t\"\b\b\u0000\u0010\t*\u00020\u00012\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\t0\u000bH\u0084\bø\u0001\u0000¢\u0006\u0002\u0010\fJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0004J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0012\u001a\u00020\u0013H\u0004R\u0018\u0010\u0003\u001a\u00020\u0004*\u00020\u00058DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0006R\u0018\u0010\u0007\u001a\u00020\u0004*\u00020\u00058DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0006\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0014"}, d2 = {"Lcom/opensource/svgaplayer/glideplugin/AbsSVGAEntityDecoder;", "", "()V", "isZLibFormat", "", "", "([B)Z", "isZipFormat", "attempt", "T", NativeProtocol.WEB_DIALOG_ACTION, "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "handleError", "", "e", "", "readHeadAsBytes", "inputStream", "Ljava/io/InputStream;", "glideplugin_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class AbsSVGAEntityDecoder {
    @Nullable
    protected final <T> T attempt(@NotNull Function0<? extends T> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        try {
            return action.invoke();
        } catch (Throwable th) {
            handleError(th);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int handleError(@NotNull Throwable e10) {
        Intrinsics.checkNotNullParameter(e10, "e");
        return Log.e("SVGAPlayer", e10.getMessage(), e10);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean isZLibFormat(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        if (bArr.length < 2 || bArr[0] != 120 || bArr[1] != -100) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean isZipFormat(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        if (bArr.length < 4 || bArr[0] != 80 || bArr[1] != 75 || bArr[2] != 3 || bArr[3] != 4) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final byte[] readHeadAsBytes(@NotNull InputStream inputStream) {
        Intrinsics.checkNotNullParameter(inputStream, "inputStream");
        try {
            byte[] bArr = new byte[4];
            if (inputStream.read(bArr, 0, 4) <= 0) {
                return null;
            }
            return bArr;
        } catch (Throwable th) {
            handleError(th);
            return null;
        }
    }
}
