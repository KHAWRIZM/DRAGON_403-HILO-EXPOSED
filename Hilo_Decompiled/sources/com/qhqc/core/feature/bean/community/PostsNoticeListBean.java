package com.qhqc.core.feature.bean.community;

import com.qhqc.core.feature.bean.PageDataBean;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/qhqc/core/feature/bean/community/PostsNoticeListBean;", "Lcom/qhqc/core/feature/bean/PageDataBean;", "Lcom/qhqc/core/feature/bean/community/PostsNoticeBean;", "<init>", "()V", "unRead", "Lcom/qhqc/core/feature/bean/community/PostsNoticeUnReadBean;", "getUnRead", "()Lcom/qhqc/core/feature/bean/community/PostsNoticeUnReadBean;", "setUnRead", "(Lcom/qhqc/core/feature/bean/community/PostsNoticeUnReadBean;)V", "feature_community_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class PostsNoticeListBean extends PageDataBean<PostsNoticeBean> {

    @Nullable
    private PostsNoticeUnReadBean unRead;

    @Nullable
    public final PostsNoticeUnReadBean getUnRead() {
        return this.unRead;
    }

    public final void setUnRead(@Nullable PostsNoticeUnReadBean postsNoticeUnReadBean) {
        this.unRead = postsNoticeUnReadBean;
    }
}
