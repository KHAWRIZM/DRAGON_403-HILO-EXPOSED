package com.amazonaws.http.conn;

import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.metrics.AwsSdkMetrics;
import com.amazonaws.metrics.ServiceLatencyProvider;
import com.amazonaws.util.AWSServiceMetrics;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import org.apache.http.conn.ClientConnectionRequest;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
class ClientConnectionRequestFactory {
    private static final Log log = LogFactory.getLog(ClientConnectionRequestFactory.class);
    private static final Class<?>[] INTERFACES = {ClientConnectionRequest.class, Wrapped.class};

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    private static class Handler implements InvocationHandler {
        private final ClientConnectionRequest orig;

        Handler(ClientConnectionRequest clientConnectionRequest) {
            this.orig = clientConnectionRequest;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            try {
                if ("getConnection".equals(method.getName())) {
                    ServiceLatencyProvider serviceLatencyProvider = new ServiceLatencyProvider(AWSServiceMetrics.HttpClientGetConnectionTime);
                    try {
                        return method.invoke(this.orig, objArr);
                    } finally {
                        AwsSdkMetrics.getServiceMetricCollector().collectLatency(serviceLatencyProvider.endTiming());
                    }
                }
                return method.invoke(this.orig, objArr);
            } catch (InvocationTargetException e10) {
                ClientConnectionRequestFactory.log.debug("", e10);
                throw e10.getCause();
            }
        }
    }

    ClientConnectionRequestFactory() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ClientConnectionRequest wrap(ClientConnectionRequest clientConnectionRequest) {
        if (!(clientConnectionRequest instanceof Wrapped)) {
            return (ClientConnectionRequest) Proxy.newProxyInstance(ClientConnectionRequestFactory.class.getClassLoader(), INTERFACES, new Handler(clientConnectionRequest));
        }
        throw new IllegalArgumentException();
    }
}
