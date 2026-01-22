package com.qiahao.nextvideo.ui.home.filter.genderpreference;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\u0003H&¨\u0006\n"}, d2 = {"Lcom/qiahao/nextvideo/ui/home/filter/genderpreference/GenderPreferenceViewControllerDelegate;", "", "genderPreferenceViewControllerDelegateDidConfirm", "", "currentGenderPreferenceCategory", "Lcom/qiahao/nextvideo/ui/home/filter/genderpreference/GenderPreferenceCategory;", "genderPreferenceViewControllerDelegateNeededRecharge", "price", "", "genderPreferenceViewControllerDelegateDidCancel", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public interface GenderPreferenceViewControllerDelegate {
    void genderPreferenceViewControllerDelegateDidCancel();

    void genderPreferenceViewControllerDelegateDidConfirm(@NotNull GenderPreferenceCategory currentGenderPreferenceCategory);

    void genderPreferenceViewControllerDelegateNeededRecharge(int price);
}
