package com.qhqc.core.basic.uiframe.ui;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b`\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016¨\u0006\t"}, d2 = {"Lcom/qhqc/core/basic/uiframe/ui/IFragmentVisibility;", "", "isVisibleToUser", "", "onFirstVisible", "", "onInvisible", "onVisible", "onWithoutFirstVisible", "basic_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public interface IFragmentVisibility {

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class DefaultImpls {
        public static void onFirstVisible(@NotNull IFragmentVisibility iFragmentVisibility) {
        }

        public static void onInvisible(@NotNull IFragmentVisibility iFragmentVisibility) {
        }

        public static void onVisible(@NotNull IFragmentVisibility iFragmentVisibility) {
        }

        public static void onWithoutFirstVisible(@NotNull IFragmentVisibility iFragmentVisibility) {
        }
    }

    boolean isVisibleToUser();

    void onFirstVisible();

    void onInvisible();

    void onVisible();

    void onWithoutFirstVisible();
}
