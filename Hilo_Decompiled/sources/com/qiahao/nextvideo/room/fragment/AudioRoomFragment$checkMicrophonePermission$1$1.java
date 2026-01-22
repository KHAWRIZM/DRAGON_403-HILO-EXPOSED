package com.qiahao.nextvideo.room.fragment;

import androidx.fragment.app.FragmentActivity;
import com.qiahao.base_common.model.eventBus.ChatRoomStatusEvent;
import com.qiahao.base_common.permission.PermissionInterceptor;
import com.qiahao.nextvideo.data.service.agora.HiloRtcEngine;
import com.qiahao.nextvideo.room.dialog.OnPermissionMicDialogListener;
import com.qiahao.nextvideo.room.manager.MeetingRoomManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/qiahao/nextvideo/room/fragment/AudioRoomFragment$checkMicrophonePermission$1$1", "Lcom/qiahao/nextvideo/room/dialog/OnPermissionMicDialogListener;", "requestPermission", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class AudioRoomFragment$checkMicrophonePermission$1$1 implements OnPermissionMicDialogListener {
    final /* synthetic */ FragmentActivity $it;
    final /* synthetic */ Function0<Unit> $listener;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AudioRoomFragment$checkMicrophonePermission$1$1(FragmentActivity fragmentActivity, Function0<Unit> function0) {
        this.$it = fragmentActivity;
        this.$listener = function0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void requestPermission$lambda$0(Function0 function0, List list, List list2) {
        Intrinsics.checkNotNullParameter(list, "grantedList");
        Intrinsics.checkNotNullParameter(list2, "deniedList");
        if (list2.isEmpty()) {
            MeetingRoomManager.INSTANCE.setMicPermission(true);
            cf.c.c().l(new ChatRoomStatusEvent("start_service", (Object) null, 2, (DefaultConstructorMarker) null));
            if (function0 != null) {
                function0.invoke();
            }
        }
    }

    @Override // com.qiahao.nextvideo.room.dialog.OnPermissionMicDialogListener
    public void requestPermission() {
        HiloRtcEngine.INSTANCE.setClientRole(2);
        w9.h j = w9.h.t(this.$it).p(fa.b.o()).j(new PermissionInterceptor());
        final Function0<Unit> function0 = this.$listener;
        j.r(new w9.c() { // from class: com.qiahao.nextvideo.room.fragment.g
            public final void onResult(List list, List list2) {
                AudioRoomFragment$checkMicrophonePermission$1$1.requestPermission$lambda$0(function0, list, list2);
            }
        });
    }
}
