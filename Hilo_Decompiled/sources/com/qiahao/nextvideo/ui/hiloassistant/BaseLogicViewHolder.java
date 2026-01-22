package com.qiahao.nextvideo.ui.hiloassistant;

import android.view.View;
import com.qiahao.nextvideo.ui.reusable.views.list.ViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b¨\u0006\f"}, d2 = {"Lcom/qiahao/nextvideo/ui/hiloassistant/BaseLogicViewHolder;", "Lcom/qiahao/nextvideo/ui/reusable/views/list/ViewHolder;", "v", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "onItemClick", "", "item", "Lcom/qiahao/nextvideo/ui/hiloassistant/HiloAssistantCellUIModel;", "clickListener", "Lcom/qiahao/nextvideo/ui/hiloassistant/ClickListener;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class BaseLogicViewHolder extends ViewHolder {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseLogicViewHolder(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "v");
    }

    public final void onItemClick(@NotNull HiloAssistantCellUIModel item, @NotNull ClickListener clickListener) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(clickListener, "clickListener");
        Integer actionType = item.getActionType();
        if (actionType == null || actionType.intValue() != 0) {
            if (actionType == null || actionType.intValue() != 2) {
                if (actionType == null || actionType.intValue() != 3) {
                    if (actionType != null && actionType.intValue() == 1) {
                        String actionUrl = item.getActionUrl();
                        if (actionUrl != null && actionUrl.length() != 0) {
                            String actionUrl2 = item.getActionUrl();
                            Intrinsics.checkNotNull(actionUrl2);
                            clickListener.urlActionClick(actionUrl2);
                            return;
                        }
                        return;
                    }
                    if (actionType != null && actionType.intValue() == 4) {
                        clickListener.openMyBag();
                        return;
                    }
                    String str = "";
                    if (actionType != null && actionType.intValue() == 5) {
                        String actionUrl3 = item.getActionUrl();
                        if (actionUrl3 != null) {
                            str = actionUrl3;
                        }
                        clickListener.openFamilyCenter(str);
                        return;
                    }
                    if (actionType != null && actionType.intValue() == 6) {
                        String actionUrl4 = item.getActionUrl();
                        if (actionUrl4 != null) {
                            str = actionUrl4;
                        }
                        clickListener.openFamilyApplication(str);
                        return;
                    }
                    if (actionType != null && actionType.intValue() == 7) {
                        String actionUrl5 = item.getActionUrl();
                        if (actionUrl5 != null) {
                            str = actionUrl5;
                        }
                        clickListener.openNavigation(str);
                    }
                }
            }
        }
    }
}
