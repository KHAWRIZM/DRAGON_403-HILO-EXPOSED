package retrofit2.converter.gson;

import com.google.gson.d;
import com.google.gson.reflect.TypeToken;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public final class GsonConverterFactory extends Converter.Factory {
    private final d gson;

    private GsonConverterFactory(d dVar) {
        this.gson = dVar;
    }

    public static GsonConverterFactory create() {
        return create(new d());
    }

    @Override // retrofit2.Converter.Factory
    public Converter<?, RequestBody> requestBodyConverter(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, Retrofit retrofit) {
        return new GsonRequestBodyConverter(this.gson, this.gson.l(TypeToken.get(type)));
    }

    @Override // retrofit2.Converter.Factory
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        return new GsonResponseBodyConverter(this.gson, this.gson.l(TypeToken.get(type)));
    }

    public static GsonConverterFactory create(d dVar) {
        if (dVar != null) {
            return new GsonConverterFactory(dVar);
        }
        throw new NullPointerException("gson == null");
    }
}
