package com.qhqc.core.feature.community.ui.activity;

import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.qhqc.core.basic.ktx.CompatKtxKt;
import com.qhqc.core.basic.router.provider.BasicModuleApp;
import com.qhqc.core.basic.router.provider.IToast;
import com.qhqc.core.basic.uiframe.ui.dialogfragment.menuselector.Menu;
import com.qhqc.core.basic.uiframe.ui.dialogfragment.menuselector.MenuSelectDialog;
import com.qhqc.core.feature.bean.community.PostsCommentBean;
import com.qhqc.core.feature.bean.community.PostsCommentFloorBean;
import com.qhqc.core.feature.community.CommunityUtils;
import com.qhqc.core.feature.community.R;
import com.qhqc.core.feature.community.ui.dialog.TipsDialog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/qhqc/core/feature/community/ui/activity/PostsDetailsActivity$showCommentMenusDialog$1", "Lcom/qhqc/core/basic/uiframe/ui/dialogfragment/menuselector/MenuSelectDialog$OnMenuSelectedListener;", "onMenuSelected", "", "menu", "Lcom/qhqc/core/basic/uiframe/ui/dialogfragment/menuselector/Menu;", "feature_community_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class PostsDetailsActivity$showCommentMenusDialog$1 implements MenuSelectDialog.OnMenuSelectedListener {
    final /* synthetic */ PostsCommentBean $itemComment;
    final /* synthetic */ PostsCommentFloorBean $itemCommentFloor;
    final /* synthetic */ int $positionComment;
    final /* synthetic */ int $positionCommentFloor;
    final /* synthetic */ PostsDetailsActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PostsDetailsActivity$showCommentMenusDialog$1(PostsDetailsActivity postsDetailsActivity, PostsCommentBean postsCommentBean, int i10, PostsCommentFloorBean postsCommentFloorBean, int i11) {
        this.this$0 = postsDetailsActivity;
        this.$itemComment = postsCommentBean;
        this.$positionComment = i10;
        this.$itemCommentFloor = postsCommentFloorBean;
        this.$positionCommentFloor = i11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onMenuSelected$lambda$0(PostsDetailsActivity postsDetailsActivity, PostsCommentBean postsCommentBean, int i10, PostsCommentFloorBean postsCommentFloorBean, int i11, TextView it) {
        Intrinsics.checkNotNullParameter(it, "it");
        PostsDetailsActivity.access$getViewModel(postsDetailsActivity).commentDelete(postsCommentBean, i10, postsCommentFloorBean, i11);
        return Unit.INSTANCE;
    }

    @Override // com.qhqc.core.basic.uiframe.ui.dialogfragment.menuselector.MenuSelectDialog.OnMenuSelectedListener
    public void onMenuSelected(Menu menu, Object obj) {
        MenuSelectDialog.OnMenuSelectedListener.DefaultImpls.onMenuSelected(this, menu, obj);
    }

    @Override // com.qhqc.core.basic.uiframe.ui.dialogfragment.menuselector.MenuSelectDialog.OnMenuSelectedListener
    public void onMenuSelected(Menu menu) {
        String content;
        String content2;
        Intrinsics.checkNotNullParameter(menu, "menu");
        int id = menu.getId();
        if (id != 3 && id != 4 && id != 5 && id != 6) {
            if (id != 13) {
                if (id != 14) {
                    switch (id) {
                        case 16:
                            break;
                        case 17:
                            break;
                        case 18:
                            PostsCommentFloorBean postsCommentFloorBean = this.$itemCommentFloor;
                            if (postsCommentFloorBean != null && (content2 = postsCommentFloorBean.getContent()) != null && content2.length() != 0) {
                                CommunityUtils.INSTANCE.copyText(this.this$0, this.$itemCommentFloor.getContent());
                                IToast iToast = BasicModuleApp.INSTANCE.toastImpl();
                                if (iToast != null) {
                                    iToast.showToast(CompatKtxKt.getString(R.string.copied));
                                    return;
                                }
                                return;
                            }
                            PostsCommentBean postsCommentBean = this.$itemComment;
                            if (postsCommentBean == null || (content = postsCommentBean.getContent()) == null || content.length() == 0) {
                                return;
                            }
                            CommunityUtils.INSTANCE.copyText(this.this$0, this.$itemComment.getContent());
                            IToast iToast2 = BasicModuleApp.INSTANCE.toastImpl();
                            if (iToast2 != null) {
                                iToast2.showToast(CompatKtxKt.getString(R.string.copied));
                                return;
                            }
                            return;
                        default:
                            return;
                    }
                }
                this.this$0.showCommentMenusDialog(CommunityUtils.INSTANCE.getReportMenus(), this.$itemComment, this.$positionComment, this.$itemCommentFloor, this.$positionCommentFloor);
                return;
            }
            TipsDialog.Builder textContent = new TipsDialog.Builder().setTextContent(R.string.feature_community_posts_comment_delete_hint);
            final PostsDetailsActivity postsDetailsActivity = this.this$0;
            final PostsCommentBean postsCommentBean2 = this.$itemComment;
            final int i10 = this.$positionComment;
            final PostsCommentFloorBean postsCommentFloorBean2 = this.$itemCommentFloor;
            final int i11 = this.$positionCommentFloor;
            TipsDialog.Builder.withDefBtn$default(textContent, new Function1() { // from class: com.qhqc.core.feature.community.ui.activity.t
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit onMenuSelected$lambda$0;
                    onMenuSelected$lambda$0 = PostsDetailsActivity$showCommentMenusDialog$1.onMenuSelected$lambda$0(PostsDetailsActivity.this, postsCommentBean2, i10, postsCommentFloorBean2, i11, (TextView) obj);
                    return onMenuSelected$lambda$0;
                }
            }, null, null, 6, null).build().show((AppCompatActivity) this.this$0);
            return;
        }
        PostsDetailsActivity.access$getViewModel(this.this$0).commentReport(menu.getId(), this.$itemComment, this.$itemCommentFloor);
    }
}
