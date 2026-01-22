package com.qiahao.nextvideo.ui.videocall.matchinguser.balloon;

import android.content.Context;
import com.qiahao.nextvideo.ui.home.chat.dialog.MessageMenuDialog;
import com.qiahao.nextvideo.ui.videocall.matchinguser.balloon.KeepCallTipsBalloon;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a/\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0019\b\u0004\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\b\bH\u0087\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\t"}, d2 = {"createKeepCallTipsBalloon", "Lcom/qiahao/nextvideo/ui/videocall/matchinguser/balloon/KeepCallTipsBalloon;", "context", "Landroid/content/Context;", MessageMenuDialog.BLOCK, "Lkotlin/Function1;", "Lcom/qiahao/nextvideo/ui/videocall/matchinguser/balloon/KeepCallTipsBalloon$Builder;", "", "Lkotlin/ExtensionFunctionType;", "app_googleRelease"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class KeepCallTipsBalloonKt {
    public static final /* synthetic */ KeepCallTipsBalloon createKeepCallTipsBalloon(Context context, Function1<? super KeepCallTipsBalloon.Builder, Unit> function1) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(function1, MessageMenuDialog.BLOCK);
        KeepCallTipsBalloon.Builder builder = new KeepCallTipsBalloon.Builder(context);
        function1.invoke(builder);
        return builder.build();
    }
}
