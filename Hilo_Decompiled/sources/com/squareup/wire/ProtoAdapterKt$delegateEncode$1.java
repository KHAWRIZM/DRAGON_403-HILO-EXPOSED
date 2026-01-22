package com.squareup.wire;

import com.qiahao.nextvideo.utilities.userproxy.UserProxyUtility;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "E", "forwardWriter", "Lcom/squareup/wire/ProtoWriter;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = UserProxyUtility.foodieHot)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class ProtoAdapterKt$delegateEncode$1 extends Lambda implements Function1<ProtoWriter, Unit> {
    final /* synthetic */ ProtoAdapter<E> $this_delegateEncode;
    final /* synthetic */ E $value;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProtoAdapterKt$delegateEncode$1(ProtoAdapter<E> protoAdapter, E e) {
        super(1);
        this.$this_delegateEncode = protoAdapter;
        this.$value = e;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ProtoWriter) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull ProtoWriter protoWriter) {
        Intrinsics.checkNotNullParameter(protoWriter, "forwardWriter");
        this.$this_delegateEncode.encode(protoWriter, (ProtoWriter) this.$value);
    }
}
