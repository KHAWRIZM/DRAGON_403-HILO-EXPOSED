package com.qiahao.base_common.model.im;

import com.facebook.share.internal.ShareConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0005J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0005¨\u0006\b"}, d2 = {"Lcom/qiahao/base_common/model/im/CheckMessageType;", "", "<init>", "()V", "checkC2CMessageType", "", ShareConstants.WEB_DIALOG_PARAM_MESSAGE, "checkRoomMessageType", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCheckMessageType.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CheckMessageType.kt\ncom/qiahao/base_common/model/im/CheckMessageType\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,43:1\n1869#2,2:44\n1869#2,2:46\n1869#2,2:48\n*S KotlinDebug\n*F\n+ 1 CheckMessageType.kt\ncom/qiahao/base_common/model/im/CheckMessageType\n*L\n14#1:44,2\n27#1:46,2\n33#1:48,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class CheckMessageType {

    @NotNull
    public static final CheckMessageType INSTANCE = new CheckMessageType();

    private CheckMessageType() {
    }

    @Nullable
    public final String checkC2CMessageType(@NotNull String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        for (Identifier identifier : Identifier.getEntries()) {
            if (StringsKt.contains$default((CharSequence) message, (CharSequence) ("\"identifier\":\"" + identifier.name() + "\""), false, 2, (Object) null)) {
                return identifier.name();
            }
        }
        return null;
    }

    @Nullable
    public final String checkRoomMessageType(@NotNull String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        for (String str : RoomMessageType.INSTANCE.getRoomMessageType()) {
            if (!StringsKt.contains$default((CharSequence) message, (CharSequence) ("\"type\":" + str + ","), false, 2, (Object) null)) {
                if (StringsKt.contains$default((CharSequence) message, (CharSequence) ("\"type\":\"" + str + "\""), false, 2, (Object) null)) {
                }
            }
            return str;
        }
        for (String str2 : RoomMessageType.INSTANCE.getRoomMessageType()) {
            if (StringsKt.contains$default((CharSequence) message, (CharSequence) ("\"identifier\":\"" + str2 + "\""), false, 2, (Object) null)) {
                return str2;
            }
        }
        return null;
    }
}
