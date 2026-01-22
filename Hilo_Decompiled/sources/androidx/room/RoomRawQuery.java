package androidx.room;

import androidx.sqlite.SQLiteStatement;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Landroidx/room/RoomRawQuery;", "", "sql", "", "onBindStatement", "Lkotlin/Function1;", "Landroidx/sqlite/SQLiteStatement;", "", "<init>", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "getSql", "()Ljava/lang/String;", "bindingFunction", "getBindingFunction", "room-runtime_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class RoomRawQuery {

    @NotNull
    private final Function1<SQLiteStatement, Unit> bindingFunction;

    @NotNull
    private final String sql;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public RoomRawQuery(@NotNull String sql) {
        this(sql, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(sql, "sql");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$0(SQLiteStatement it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bindingFunction$lambda$1(Function1 function1, SQLiteStatement it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(new BindOnlySQLiteStatement(it));
        return Unit.INSTANCE;
    }

    @NotNull
    public final Function1<SQLiteStatement, Unit> getBindingFunction() {
        return this.bindingFunction;
    }

    @NotNull
    public final String getSql() {
        return this.sql;
    }

    @JvmOverloads
    public RoomRawQuery(@NotNull String sql, @NotNull final Function1<? super SQLiteStatement, Unit> onBindStatement) {
        Intrinsics.checkNotNullParameter(sql, "sql");
        Intrinsics.checkNotNullParameter(onBindStatement, "onBindStatement");
        this.sql = sql;
        this.bindingFunction = new Function1() { // from class: androidx.room.p
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit bindingFunction$lambda$1;
                bindingFunction$lambda$1 = RoomRawQuery.bindingFunction$lambda$1(Function1.this, (SQLiteStatement) obj);
                return bindingFunction$lambda$1;
            }
        };
    }

    public /* synthetic */ RoomRawQuery(String str, Function1 function1, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i10 & 2) != 0 ? new Function1() { // from class: androidx.room.q
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit _init_$lambda$0;
                _init_$lambda$0 = RoomRawQuery._init_$lambda$0((SQLiteStatement) obj);
                return _init_$lambda$0;
            }
        } : function1);
    }
}
