package retrofit2.adapter.rxjava3;

import io.reactivex.rxjava3.core.b;
import io.reactivex.rxjava3.core.h;
import io.reactivex.rxjava3.core.h0;
import io.reactivex.rxjava3.core.i0;
import io.reactivex.rxjava3.core.j;
import io.reactivex.rxjava3.core.z;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import retrofit2.CallAdapter;
import retrofit2.Response;
import retrofit2.Retrofit;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public final class RxJava3CallAdapterFactory extends CallAdapter.Factory {
    private final boolean isAsync;
    private final h0 scheduler;

    private RxJava3CallAdapterFactory(h0 h0Var, boolean z) {
        this.scheduler = h0Var;
        this.isAsync = z;
    }

    public static RxJava3CallAdapterFactory create() {
        return new RxJava3CallAdapterFactory(null, true);
    }

    public static RxJava3CallAdapterFactory createSynchronous() {
        return new RxJava3CallAdapterFactory(null, false);
    }

    public static RxJava3CallAdapterFactory createWithScheduler(h0 h0Var) {
        if (h0Var != null) {
            return new RxJava3CallAdapterFactory(h0Var, false);
        }
        throw new NullPointerException("scheduler == null");
    }

    @Override // retrofit2.CallAdapter.Factory
    public CallAdapter<?, ?> get(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        boolean z;
        boolean z2;
        boolean z3;
        Type type2;
        boolean z4;
        boolean z5;
        String str;
        Class<?> rawType = CallAdapter.Factory.getRawType(type);
        if (rawType == b.class) {
            return new RxJava3CallAdapter(Void.class, this.scheduler, this.isAsync, false, true, false, false, false, true);
        }
        if (rawType == h.class) {
            z = true;
        } else {
            z = false;
        }
        if (rawType == i0.class) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (rawType == j.class) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (rawType != z.class && !z && !z2 && !z3) {
            return null;
        }
        if (!(type instanceof ParameterizedType)) {
            if (!z) {
                if (!z2) {
                    if (z3) {
                        str = "Maybe";
                    } else {
                        str = "Observable";
                    }
                } else {
                    str = "Single";
                }
            } else {
                str = "Flowable";
            }
            throw new IllegalStateException(str + " return type must be parameterized as " + str + "<Foo> or " + str + "<? extends Foo>");
        }
        Type parameterUpperBound = CallAdapter.Factory.getParameterUpperBound(0, (ParameterizedType) type);
        Class<?> rawType2 = CallAdapter.Factory.getRawType(parameterUpperBound);
        if (rawType2 == Response.class) {
            if (parameterUpperBound instanceof ParameterizedType) {
                type2 = CallAdapter.Factory.getParameterUpperBound(0, (ParameterizedType) parameterUpperBound);
                z4 = false;
            } else {
                throw new IllegalStateException("Response must be parameterized as Response<Foo> or Response<? extends Foo>");
            }
        } else if (rawType2 == Result.class) {
            if (parameterUpperBound instanceof ParameterizedType) {
                type2 = CallAdapter.Factory.getParameterUpperBound(0, (ParameterizedType) parameterUpperBound);
                z4 = true;
            } else {
                throw new IllegalStateException("Result must be parameterized as Result<Foo> or Result<? extends Foo>");
            }
        } else {
            type2 = parameterUpperBound;
            z4 = false;
            z5 = true;
            return new RxJava3CallAdapter(type2, this.scheduler, this.isAsync, z4, z5, z, z2, z3, false);
        }
        z5 = false;
        return new RxJava3CallAdapter(type2, this.scheduler, this.isAsync, z4, z5, z, z2, z3, false);
    }
}
