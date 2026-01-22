package com.oudi.core.loading;

import com.facebook.share.internal.ShareConstants;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\r\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J%\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0002\u0010\bJ\u0019\u0010\t\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/oudi/core/loading/ILoading;", "", "showLoading", "", "id", "", ShareConstants.WEB_DIALOG_PARAM_MESSAGE, "", "(Ljava/lang/Integer;Ljava/lang/CharSequence;)V", "dismissLoading", "(Ljava/lang/Integer;)V", "lib_core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public interface ILoading {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void dismissLoading$default(ILoading iLoading, Integer num, int i10, Object obj) {
            if (obj == null) {
                if ((i10 & 1) != 0) {
                    num = null;
                }
                iLoading.dismissLoading(num);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: dismissLoading");
        }

        public static /* synthetic */ void showLoading$default(ILoading iLoading, Integer num, CharSequence charSequence, int i10, Object obj) {
            if (obj == null) {
                if ((i10 & 1) != 0) {
                    num = null;
                }
                if ((i10 & 2) != 0) {
                    charSequence = null;
                }
                iLoading.showLoading(num, charSequence);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showLoading");
        }
    }

    void dismissLoading(@Nullable Integer id);

    void showLoading(@Nullable Integer id, @Nullable CharSequence message);
}
