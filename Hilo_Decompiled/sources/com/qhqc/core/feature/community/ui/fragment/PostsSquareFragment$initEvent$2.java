package com.qhqc.core.feature.community.ui.fragment;

import android.content.Context;
import android.widget.TextView;
import com.qhqc.core.basic.ktx.CompatKtxKt;
import com.qhqc.core.basic.router.provider.BasicModuleApp;
import com.qhqc.core.basic.router.provider.IToast;
import com.qhqc.core.basic.uiframe.ui.dialogfragment.menuselector.Menu;
import com.qhqc.core.basic.uiframe.ui.dialogfragment.menuselector.MenuSelectDialog;
import com.qhqc.core.feature.bean.community.PostsInfoBean;
import com.qhqc.core.feature.community.CommunityUtils;
import com.qhqc.core.feature.community.R;
import com.qhqc.core.feature.community.data.viewmodel.PostsOperateViewModel;
import com.qhqc.core.feature.community.ui.dialog.TipsDialog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"com/qhqc/core/feature/community/ui/fragment/PostsSquareFragment$initEvent$2", "Lcom/qhqc/core/basic/uiframe/ui/dialogfragment/menuselector/MenuSelectDialog$OnMenuSelectedListener;", "onMenuSelected", "", "menu", "Lcom/qhqc/core/basic/uiframe/ui/dialogfragment/menuselector/Menu;", "payload", "", "feature_community_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class PostsSquareFragment$initEvent$2 implements MenuSelectDialog.OnMenuSelectedListener {
    final /* synthetic */ PostsSquareFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PostsSquareFragment$initEvent$2(PostsSquareFragment postsSquareFragment) {
        this.this$0 = postsSquareFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onMenuSelected$lambda$0(PostsSquareFragment postsSquareFragment, PostsInfoBean postsInfoBean, TextView it) {
        Intrinsics.checkNotNullParameter(it, "it");
        PostsSquareFragment.access$getViewModel(postsSquareFragment).delete(postsInfoBean);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onMenuSelected$lambda$1(PostsSquareFragment postsSquareFragment, PostsInfoBean postsInfoBean, Menu menu) {
        PostsSquareFragment.access$getViewModel(postsSquareFragment).superAdminOperate(postsInfoBean, menu.getId());
        return Unit.INSTANCE;
    }

    @Override // com.qhqc.core.basic.uiframe.ui.dialogfragment.menuselector.MenuSelectDialog.OnMenuSelectedListener
    public void onMenuSelected(Menu menu) {
        MenuSelectDialog.OnMenuSelectedListener.DefaultImpls.onMenuSelected(this, menu);
    }

    @Override // com.qhqc.core.basic.uiframe.ui.dialogfragment.menuselector.MenuSelectDialog.OnMenuSelectedListener
    public void onMenuSelected(final Menu menu, Object payload) {
        MenuSelectDialog.OnMenuSelectedListener onMenuSelectedListener;
        MenuSelectDialog.OnMenuSelectedListener onMenuSelectedListener2;
        Intrinsics.checkNotNullParameter(menu, "menu");
        final PostsInfoBean postsInfoBean = payload instanceof PostsInfoBean ? (PostsInfoBean) payload : null;
        if (postsInfoBean == null) {
            return;
        }
        int id = menu.getId();
        if (id == 15) {
            TipsDialog.Builder textContent = new TipsDialog.Builder().setTextContent(R.string.feature_community_posts_moment_delete_hint);
            final PostsSquareFragment postsSquareFragment = this.this$0;
            TipsDialog.Builder.withDefBtn$default(textContent, new Function1() { // from class: com.qhqc.core.feature.community.ui.fragment.g
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit onMenuSelected$lambda$0;
                    onMenuSelected$lambda$0 = PostsSquareFragment$initEvent$2.onMenuSelected$lambda$0(PostsSquareFragment.this, postsInfoBean, (TextView) obj);
                    return onMenuSelected$lambda$0;
                }
            }, null, null, 6, null).build().show(this.this$0.requireContext());
            return;
        }
        if (id != 18) {
            switch (id) {
                case 1:
                    PostsSquareFragment postsSquareFragment2 = this.this$0;
                    Menu[] reportMenus = CommunityUtils.INSTANCE.getReportMenus();
                    onMenuSelectedListener = this.this$0.mOnMenuListener;
                    postsSquareFragment2.showMenusDialog(reportMenus, onMenuSelectedListener, postsInfoBean);
                    return;
                case 2:
                    PostsOperateViewModel.localBlock$default(PostsSquareFragment.access$getViewModel(this.this$0), postsInfoBean, false, 2, null);
                    return;
                case 3:
                case 4:
                case 5:
                case 6:
                    PostsSquareFragment.access$getViewModel(this.this$0).report(postsInfoBean, menu.getId());
                    return;
                case 7:
                    PostsSquareFragment postsSquareFragment3 = this.this$0;
                    Menu[] superAdminMenus = CommunityUtils.INSTANCE.getSuperAdminMenus(postsInfoBean.getUser());
                    onMenuSelectedListener2 = this.this$0.mOnMenuListener;
                    postsSquareFragment3.showMenusDialog(superAdminMenus, onMenuSelectedListener2, postsInfoBean);
                    return;
                case 8:
                case 9:
                case 10:
                case 11:
                case 12:
                    CommunityUtils communityUtils = CommunityUtils.INSTANCE;
                    Context requireContext = this.this$0.requireContext();
                    Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
                    final PostsSquareFragment postsSquareFragment4 = this.this$0;
                    communityUtils.showAdminOperateTipsDialog(requireContext, menu, new Function0() { // from class: com.qhqc.core.feature.community.ui.fragment.h
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit onMenuSelected$lambda$1;
                            onMenuSelected$lambda$1 = PostsSquareFragment$initEvent$2.onMenuSelected$lambda$1(PostsSquareFragment.this, postsInfoBean, menu);
                            return onMenuSelected$lambda$1;
                        }
                    });
                    return;
                default:
                    return;
            }
        }
        String content = postsInfoBean.getContent();
        if (content == null || content.length() == 0) {
            return;
        }
        CommunityUtils communityUtils2 = CommunityUtils.INSTANCE;
        Context requireContext2 = this.this$0.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext2, "requireContext(...)");
        communityUtils2.copyText(requireContext2, postsInfoBean.getContent());
        IToast iToast = BasicModuleApp.INSTANCE.toastImpl();
        if (iToast != null) {
            iToast.showToast(CompatKtxKt.getString(R.string.copied));
        }
    }
}
