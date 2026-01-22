package androidx.room.util;

import com.google.firebase.messaging.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0011\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0000H\u0096\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000e¨\u0006\u0012"}, d2 = {"Landroidx/room/util/ForeignKeyWithSequence;", "", "id", "", "sequence", Constants.MessagePayloadKeys.FROM, "", "to", "<init>", "(IILjava/lang/String;Ljava/lang/String;)V", "getId", "()I", "getSequence", "getFrom", "()Ljava/lang/String;", "getTo", "compareTo", "other", "room-runtime_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
final class ForeignKeyWithSequence implements Comparable<ForeignKeyWithSequence> {

    @NotNull
    private final String from;
    private final int id;
    private final int sequence;

    @NotNull
    private final String to;

    public ForeignKeyWithSequence(int i10, int i11, @NotNull String from, @NotNull String to) {
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(to, "to");
        this.id = i10;
        this.sequence = i11;
        this.from = from;
        this.to = to;
    }

    @NotNull
    public final String getFrom() {
        return this.from;
    }

    public final int getId() {
        return this.id;
    }

    public final int getSequence() {
        return this.sequence;
    }

    @NotNull
    public final String getTo() {
        return this.to;
    }

    @Override // java.lang.Comparable
    public int compareTo(@NotNull ForeignKeyWithSequence other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int i10 = this.id - other.id;
        return i10 == 0 ? this.sequence - other.sequence : i10;
    }
}
