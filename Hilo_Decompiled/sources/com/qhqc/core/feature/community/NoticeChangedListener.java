package com.qhqc.core.feature.community;

import com.qhqc.core.feature.bean.community.PostsNoticeUnReadBean;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/qhqc/core/feature/community/NoticeChangedListener;", "", "onCountChanged", "", "unRead", "Lcom/qhqc/core/feature/bean/community/PostsNoticeUnReadBean;", "feature_community_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public interface NoticeChangedListener {
    void onCountChanged(@NotNull PostsNoticeUnReadBean unRead);
}
