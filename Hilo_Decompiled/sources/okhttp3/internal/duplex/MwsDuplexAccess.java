package okhttp3.internal.duplex;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.internal.duplex.DuplexResponseBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\n"}, d2 = {"Lokhttp3/internal/duplex/MwsDuplexAccess;", "", "()V", "setBody", "", "mockResponse", "Lokhttp3/mockwebserver/MockResponse;", "duplexResponseBody", "Lokhttp3/mockwebserver/internal/duplex/DuplexResponseBody;", "Companion", "mockwebserver"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public abstract class MwsDuplexAccess {

    @JvmField
    @Nullable
    public static MwsDuplexAccess instance;

    public abstract void setBody(@NotNull MockResponse mockResponse, @NotNull DuplexResponseBody duplexResponseBody);
}
