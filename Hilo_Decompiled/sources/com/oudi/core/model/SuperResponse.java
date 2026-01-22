package com.oudi.core.model;

import androidx.annotation.Keep;
import com.qiahao.base_common.ui.dialog.ChatMenuDialog;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\u000f\u0010\u0005\u001a\u0004\u0018\u00018\u0000H&¢\u0006\u0002\u0010\u0006J\u000f\u0010\u0007\u001a\u0004\u0018\u00010\bH&¢\u0006\u0002\u0010\tJ\n\u0010\n\u001a\u0004\u0018\u00010\u000bH&J\u001e\u0010\f\u001a\u00020\r2\u0014\u0010\u000e\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0004\u0012\u00020\r0\u000fH\u0016J\u001c\u0010\u0010\u001a\u00020\r2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\r0\u000fH\u0016J\"\u0010\u0011\u001a\u00020\r2\u0018\u0010\u000e\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0000\u0012\u0004\u0012\u00020\r0\u000fH\u0016¨\u0006\u0012"}, d2 = {"Lcom/oudi/core/model/SuperResponse;", "T", "Ljava/io/Serializable;", "isSuccess", "", "getBody", "()Ljava/lang/Object;", "getCode", "", "()Ljava/lang/Integer;", "getMessage", "", "doSuccess", "", ChatMenuDialog.CLICK_BLOCK, "Lkotlin/Function1;", "doSuccessNotEmpty", "doFailure", "lib_core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public interface SuperResponse<T> extends Serializable {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class DefaultImpls {
        public static <T> void doFailure(@NotNull SuperResponse<? extends T> superResponse, @NotNull Function1<? super SuperResponse<? extends T>, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            if (!superResponse.isSuccess()) {
                block.invoke(superResponse);
            }
        }

        public static <T> void doSuccess(@NotNull SuperResponse<? extends T> superResponse, @NotNull Function1<? super T, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            if (superResponse.isSuccess()) {
                block.invoke(superResponse.getBody());
            }
        }

        public static <T> void doSuccessNotEmpty(@NotNull SuperResponse<? extends T> superResponse, @NotNull Function1<? super T, Unit> block) {
            T body;
            Intrinsics.checkNotNullParameter(block, "block");
            if (superResponse.isSuccess() && (body = superResponse.getBody()) != null) {
                block.invoke(body);
            }
        }
    }

    void doFailure(@NotNull Function1<? super SuperResponse<? extends T>, Unit> block);

    void doSuccess(@NotNull Function1<? super T, Unit> block);

    void doSuccessNotEmpty(@NotNull Function1<? super T, Unit> block);

    @Nullable
    T getBody();

    @Nullable
    Integer getCode();

    @Nullable
    String getMessage();

    boolean isSuccess();
}
