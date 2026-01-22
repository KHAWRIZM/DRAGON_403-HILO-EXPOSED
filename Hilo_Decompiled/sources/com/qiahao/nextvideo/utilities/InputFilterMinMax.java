package com.qiahao.nextvideo.utilities;

import android.text.InputFilter;
import android.text.Spanned;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.therouter.inject.DebugOnlyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J:\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0003H\u0016J \u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0003H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/qiahao/nextvideo/utilities/InputFilterMinMax;", "Landroid/text/InputFilter;", "min", "", "max", "<init>", "(II)V", TUIConstants.TUIGroup.FILTER, "", "source", "start", "end", "dest", "Landroid/text/Spanned;", "dstart", "dend", "isInRange", "", DebugOnlyKt.PACKAGE, "b", "c", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class InputFilterMinMax implements InputFilter {
    private int max;
    private int min;

    public InputFilterMinMax(int i, int i2) {
        this.min = i;
        this.max = i2;
    }

    private final boolean isInRange(int a, int b, int c) {
        if (b > a) {
            if (a <= c && c <= b) {
                return true;
            }
        } else if (b <= c && c <= a) {
            return true;
        }
        return false;
    }

    @Override // android.text.InputFilter
    @Nullable
    public CharSequence filter(@NotNull CharSequence source, int start, int end, @NotNull Spanned dest, int dstart, int dend) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(dest, "dest");
        try {
            CharSequence subSequence = dest.subSequence(0, dstart);
            CharSequence subSequence2 = dest.subSequence(dend, dest.length());
            StringBuilder sb2 = new StringBuilder();
            sb2.append((Object) subSequence);
            sb2.append((Object) source);
            sb2.append((Object) subSequence2);
            if (isInRange(this.min, this.max, Integer.parseInt(sb2.toString()))) {
                return null;
            }
            return "";
        } catch (NumberFormatException unused) {
            return "";
        }
    }
}
