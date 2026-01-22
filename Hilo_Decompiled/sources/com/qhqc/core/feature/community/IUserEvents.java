package com.qhqc.core.feature.community;

import android.view.View;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.qhqc.core.feature.bean.UserInfoBean;
import kotlin.Metadata;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J \u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH&¨\u0006\u000b"}, d2 = {"Lcom/qhqc/core/feature/community/IUserEvents;", "", "onUserClick", "", "user", "Lcom/qhqc/core/feature/bean/UserInfoBean;", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "onFollowUserClick", "scope", "Lkotlinx/coroutines/CoroutineScope;", "feature_community_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public interface IUserEvents {
    void onFollowUserClick(@NotNull UserInfoBean user, @NotNull View view, @NotNull CoroutineScope scope);

    void onUserClick(@NotNull UserInfoBean user, @NotNull View view);
}
