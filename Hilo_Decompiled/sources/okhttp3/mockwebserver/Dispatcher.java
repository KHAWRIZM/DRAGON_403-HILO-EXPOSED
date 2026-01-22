package okhttp3.mockwebserver;

import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lokhttp3/mockwebserver/Dispatcher;", "", "()V", "dispatch", "Lokhttp3/mockwebserver/MockResponse;", "request", "Lokhttp3/mockwebserver/RecordedRequest;", "peek", "shutdown", "", "mockwebserver"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nDispatcher.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Dispatcher.kt\nokhttp3/mockwebserver/Dispatcher\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,44:1\n1#2:45\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public abstract class Dispatcher {
    @NotNull
    public abstract MockResponse dispatch(@NotNull RecordedRequest request) throws InterruptedException;

    @NotNull
    public MockResponse peek() {
        MockResponse mockResponse = new MockResponse();
        mockResponse.socketPolicy(SocketPolicy.KEEP_OPEN);
        return mockResponse;
    }

    public void shutdown() {
    }
}
