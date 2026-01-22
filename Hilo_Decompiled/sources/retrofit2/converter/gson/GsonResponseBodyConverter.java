package retrofit2.converter.gson;

import com.google.gson.d;
import com.google.gson.j;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.w;
import java.io.IOException;
import okhttp3.ResponseBody;
import retrofit2.Converter;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
final class GsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    private final w adapter;
    private final d gson;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GsonResponseBodyConverter(d dVar, w wVar) {
        this.gson = dVar;
        this.adapter = wVar;
    }

    @Override // retrofit2.Converter
    public T convert(ResponseBody responseBody) throws IOException {
        JsonReader p = this.gson.p(responseBody.charStream());
        try {
            T t = (T) this.adapter.read(p);
            if (p.peek() == JsonToken.END_DOCUMENT) {
                return t;
            }
            throw new j("JSON document was not fully consumed.");
        } finally {
            responseBody.close();
        }
    }
}
