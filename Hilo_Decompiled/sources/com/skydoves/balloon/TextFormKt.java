package com.skydoves.balloon;

import android.content.Context;
import com.qiahao.nextvideo.ui.home.chat.dialog.MessageMenuDialog;
import com.skydoves.balloon.TextForm;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a/\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0019\b\u0004\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\b\bH\u0087\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\t"}, d2 = {"textForm", "Lcom/skydoves/balloon/TextForm;", "context", "Landroid/content/Context;", MessageMenuDialog.BLOCK, "Lkotlin/Function1;", "Lcom/skydoves/balloon/TextForm$Builder;", "", "Lkotlin/ExtensionFunctionType;", "balloon_release"}, k = 2, mv = {1, 4, 1})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class TextFormKt {
    public static final /* synthetic */ TextForm textForm(Context context, Function1<? super TextForm.Builder, Unit> function1) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(function1, MessageMenuDialog.BLOCK);
        TextForm.Builder builder = new TextForm.Builder(context);
        function1.invoke(builder);
        return builder.build();
    }
}
