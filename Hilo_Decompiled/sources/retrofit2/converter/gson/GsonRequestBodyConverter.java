package retrofit2.converter.gson;

import com.google.gson.d;
import com.google.gson.stream.JsonWriter;
import com.google.gson.w;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.Buffer;
import retrofit2.Converter;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
final class GsonRequestBodyConverter<T> implements Converter<T, RequestBody> {
    private static final MediaType MEDIA_TYPE = MediaType.get("application/json; charset=UTF-8");
    private static final Charset UTF_8 = Charset.forName("UTF-8");
    private final w adapter;
    private final d gson;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GsonRequestBodyConverter(d dVar, w wVar) {
        this.gson = dVar;
        this.adapter = wVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // retrofit2.Converter
    public /* bridge */ /* synthetic */ RequestBody convert(Object obj) throws IOException {
        return convert2((GsonRequestBodyConverter<T>) obj);
    }

    @Override // retrofit2.Converter
    /* renamed from: convert, reason: avoid collision after fix types in other method */
    public RequestBody convert2(T t) throws IOException {
        Buffer buffer = new Buffer();
        JsonWriter q = this.gson.q(new OutputStreamWriter(buffer.outputStream(), UTF_8));
        this.adapter.write(q, t);
        q.close();
        return RequestBody.create(MEDIA_TYPE, buffer.readByteString());
    }
}
