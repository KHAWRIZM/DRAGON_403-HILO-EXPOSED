package com.qiahao.nextvideo.ui.commonlist.interactivetracking.fragment;

import android.content.Context;
import android.widget.Toast;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.nextvideo.ui.matchinghistoric.ProfileDetailUIModel;
import com.qiahao.nextvideo.ui.videocall.VideoCallMessage;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class FriendStatusFragment$clickVideo$2<T> implements pd.g {
    final /* synthetic */ ProfileDetailUIModel $data;
    final /* synthetic */ int $position;
    final /* synthetic */ FriendStatusFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FriendStatusFragment$clickVideo$2(FriendStatusFragment friendStatusFragment, ProfileDetailUIModel profileDetailUIModel, int i) {
        this.this$0 = friendStatusFragment;
        this.$data = profileDetailUIModel;
        this.$position = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit accept$lambda$0(FriendStatusFragment friendStatusFragment, int i, String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "<unused var>");
        friendStatusFragment.likedImageViewPressed(i);
        return Unit.INSTANCE;
    }

    public final void accept(Pair<String[], int[]> pair) {
        Intrinsics.checkNotNullParameter(pair, "it1");
        if (ArraysKt.contains((int[]) pair.getSecond(), -1)) {
            HiloToasty.Companion companion = HiloToasty.Companion;
            Context requireContext = this.this$0.requireContext();
            String string = this.this$0.getString(2131953622);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            Toast normal$default = HiloToasty.Companion.normal$default(companion, requireContext, string, false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
                return;
            }
            return;
        }
        VideoCallMessage videoCallMessage = VideoCallMessage.INSTANCE;
        Context requireContext2 = this.this$0.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext2, "requireContext(...)");
        String uid = this.$data.getUid();
        final FriendStatusFragment friendStatusFragment = this.this$0;
        final int i = this.$position;
        VideoCallMessage.newStartVideo$default(videoCallMessage, requireContext2, uid, new Function2() { // from class: com.qiahao.nextvideo.ui.commonlist.interactivetracking.fragment.p
            public final Object invoke(Object obj, Object obj2) {
                Unit accept$lambda$0;
                accept$lambda$0 = FriendStatusFragment$clickVideo$2.accept$lambda$0(FriendStatusFragment.this, i, (String) obj, ((Boolean) obj2).booleanValue());
                return accept$lambda$0;
            }
        }, null, 8, null);
    }
}
