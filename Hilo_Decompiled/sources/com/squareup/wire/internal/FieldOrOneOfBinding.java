package com.squareup.wire.internal;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.Syntax;
import com.squareup.wire.WireField;
import com.taobao.accs.common.Constants;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010'\u001a\u0004\u0018\u00010\u00032\u0006\u0010(\u001a\u00028\u0000H¦\u0002¢\u0006\u0002\u0010)J\u0017\u0010*\u001a\u0004\u0018\u00010\u00032\u0006\u0010+\u001a\u00028\u0001H&¢\u0006\u0002\u0010)J\u0018\u0010,\u001a\u00020\u00102\u0006\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u00010\u0003J\u0010\u00100\u001a\u00020\u00102\u0006\u0010-\u001a\u00020.H\u0002J\u001f\u00101\u001a\u0002022\u0006\u0010+\u001a\u00028\u00012\b\u0010/\u001a\u0004\u0018\u00010\u0003H&¢\u0006\u0002\u00103J\u001d\u0010/\u001a\u0002022\u0006\u0010+\u001a\u00028\u00012\u0006\u0010/\u001a\u00020\u0003H&¢\u0006\u0002\u00103R!\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u0012\u0010\u000b\u001a\u00020\fX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0012\u0010\u000f\u001a\u00020\u0010X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0011R\u0012\u0010\u0012\u001a\u00020\u0010X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0011R\u0016\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u0006X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\bR\u0012\u0010\u0015\u001a\u00020\u0016X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0012\u0010\u0019\u001a\u00020\fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u000eR\u0012\u0010\u001b\u001a\u00020\u0010X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0011R\u0016\u0010\u001d\u001a\u0006\u0012\u0002\b\u00030\u0006X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\bR\u0012\u0010\u001f\u001a\u00020 X¦\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0012\u0010#\u001a\u00020\fX¦\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\u000eR\u0012\u0010%\u001a\u00020\u0010X¦\u0004¢\u0006\u0006\u001a\u0004\b&\u0010\u0011¨\u00064"}, d2 = {"Lcom/squareup/wire/internal/FieldOrOneOfBinding;", "M", "B", "", "()V", "adapter", "Lcom/squareup/wire/ProtoAdapter;", "getAdapter", "()Lcom/squareup/wire/ProtoAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "declaredName", "", "getDeclaredName", "()Ljava/lang/String;", "isMap", "", "()Z", "isMessage", "keyAdapter", "getKeyAdapter", "label", "Lcom/squareup/wire/WireField$Label;", "getLabel", "()Lcom/squareup/wire/WireField$Label;", "name", "getName", "redacted", "getRedacted", "singleAdapter", "getSingleAdapter", "tag", "", "getTag", "()I", "wireFieldJsonName", "getWireFieldJsonName", "writeIdentityValues", "getWriteIdentityValues", "get", Constants.SHARED_MESSAGE_ID_FILE, "(Ljava/lang/Object;)Ljava/lang/Object;", "getFromBuilder", "builder", "omitFromJson", "syntax", "Lcom/squareup/wire/Syntax;", "value", "omitIdentity", "set", "", "(Ljava/lang/Object;Ljava/lang/Object;)V", "wire-runtime"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public abstract class FieldOrOneOfBinding<M, B> {

    /* renamed from: adapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy adapter = LazyKt.lazy(new Function0<ProtoAdapter<Object>>(this) { // from class: com.squareup.wire.internal.FieldOrOneOfBinding$adapter$2
        final /* synthetic */ FieldOrOneOfBinding<M, B> this$0;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        {
            super(0);
            this.this$0 = this;
        }

        @NotNull
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final ProtoAdapter<Object> m١١٦invoke() {
            if (this.this$0.isMap()) {
                return ProtoAdapter.INSTANCE.newMapAdapter(this.this$0.getKeyAdapter(), this.this$0.getSingleAdapter());
            }
            return this.this$0.getSingleAdapter().withLabel$wire_runtime(this.this$0.getLabel());
        }
    });

    private final boolean omitIdentity(Syntax syntax) {
        if (getWriteIdentityValues()) {
            return false;
        }
        if (getLabel() == WireField.Label.OMIT_IDENTITY) {
            return true;
        }
        if (getLabel().isRepeated() && syntax == Syntax.PROTO_3) {
            return true;
        }
        if (!isMap() || syntax != Syntax.PROTO_3) {
            return false;
        }
        return true;
    }

    @Nullable
    public abstract Object get(M message);

    @NotNull
    public final ProtoAdapter<Object> getAdapter() {
        return (ProtoAdapter) this.adapter.getValue();
    }

    @NotNull
    public abstract String getDeclaredName();

    @Nullable
    public abstract Object getFromBuilder(B builder);

    @NotNull
    public abstract ProtoAdapter<?> getKeyAdapter();

    @NotNull
    public abstract WireField.Label getLabel();

    @NotNull
    public abstract String getName();

    public abstract boolean getRedacted();

    @NotNull
    public abstract ProtoAdapter<?> getSingleAdapter();

    public abstract int getTag();

    @NotNull
    public abstract String getWireFieldJsonName();

    public abstract boolean getWriteIdentityValues();

    public abstract boolean isMap();

    public abstract boolean isMessage();

    public final boolean omitFromJson(@NotNull Syntax syntax, @Nullable Object value) {
        Intrinsics.checkNotNullParameter(syntax, "syntax");
        if (value == null) {
            return true;
        }
        if (omitIdentity(syntax) && Intrinsics.areEqual(value, getAdapter().getIdentity())) {
            return true;
        }
        return false;
    }

    public abstract void set(B builder, @Nullable Object value);

    public abstract void value(B builder, @NotNull Object value);
}
