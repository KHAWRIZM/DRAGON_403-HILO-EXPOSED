package anet.channel;

import android.text.TextUtils;
import anet.channel.entity.ENV;
import anet.channel.security.ISecurity;
import anet.channel.util.ALog;
import anet.channel.util.StringUtils;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class Config {

    /* renamed from: b, reason: collision with root package name */
    private String f٤٥٨٩b;

    /* renamed from: c, reason: collision with root package name */
    private String f٤٥٩٠c;

    /* renamed from: d, reason: collision with root package name */
    private ENV f٤٥٩١d = ENV.ONLINE;

    /* renamed from: e, reason: collision with root package name */
    private ISecurity f٤٥٩٢e;

    /* renamed from: a, reason: collision with root package name */
    private static Map<String, Config> f٤٥٨٨a = new HashMap();
    public static final Config DEFAULT_CONFIG = new Builder().setTag("[default]").setAppkey("[default]").setEnv(ENV.ONLINE).build();

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        private String f٤٥٩٣a;

        /* renamed from: b, reason: collision with root package name */
        private String f٤٥٩٤b;

        /* renamed from: c, reason: collision with root package name */
        private ENV f٤٥٩٥c = ENV.ONLINE;

        /* renamed from: d, reason: collision with root package name */
        private String f٤٥٩٦d;

        /* renamed from: e, reason: collision with root package name */
        private String f٤٥٩٧e;

        public Config build() {
            if (!TextUtils.isEmpty(this.f٤٥٩٤b)) {
                synchronized (Config.f٤٥٨٨a) {
                    try {
                        for (Config config : Config.f٤٥٨٨a.values()) {
                            if (config.f٤٥٩١d == this.f٤٥٩٥c && config.f٤٥٩٠c.equals(this.f٤٥٩٤b)) {
                                ALog.w("awcn.Config", "duplicated config exist!", null, "appkey", this.f٤٥٩٤b, "env", this.f٤٥٩٥c);
                                if (!TextUtils.isEmpty(this.f٤٥٩٣a)) {
                                    Config.f٤٥٨٨a.put(this.f٤٥٩٣a, config);
                                }
                                return config;
                            }
                        }
                        Config config2 = new Config();
                        config2.f٤٥٩٠c = this.f٤٥٩٤b;
                        config2.f٤٥٩١d = this.f٤٥٩٥c;
                        if (TextUtils.isEmpty(this.f٤٥٩٣a)) {
                            config2.f٤٥٨٩b = StringUtils.concatString(this.f٤٥٩٤b, "$", this.f٤٥٩٥c.toString());
                        } else {
                            config2.f٤٥٨٩b = this.f٤٥٩٣a;
                        }
                        if (!TextUtils.isEmpty(this.f٤٥٩٧e)) {
                            config2.f٤٥٩٢e = anet.channel.security.c.a().createNonSecurity(this.f٤٥٩٧e);
                        } else {
                            config2.f٤٥٩٢e = anet.channel.security.c.a().createSecurity(this.f٤٥٩٦d);
                        }
                        synchronized (Config.f٤٥٨٨a) {
                            Config.f٤٥٨٨a.put(config2.f٤٥٨٩b, config2);
                        }
                        return config2;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            throw new RuntimeException("appkey can not be null or empty!");
        }

        public Builder setAppSecret(String str) {
            this.f٤٥٩٧e = str;
            return this;
        }

        public Builder setAppkey(String str) {
            this.f٤٥٩٤b = str;
            return this;
        }

        public Builder setAuthCode(String str) {
            this.f٤٥٩٦d = str;
            return this;
        }

        public Builder setEnv(ENV env) {
            this.f٤٥٩٥c = env;
            return this;
        }

        public Builder setTag(String str) {
            this.f٤٥٩٣a = str;
            return this;
        }
    }

    protected Config() {
    }

    public static Config getConfig(String str, ENV env) {
        synchronized (f٤٥٨٨a) {
            try {
                for (Config config : f٤٥٨٨a.values()) {
                    if (config.f٤٥٩١d == env && config.f٤٥٩٠c.equals(str)) {
                        return config;
                    }
                }
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static Config getConfigByTag(String str) {
        Config config;
        synchronized (f٤٥٨٨a) {
            config = f٤٥٨٨a.get(str);
        }
        return config;
    }

    public String getAppkey() {
        return this.f٤٥٩٠c;
    }

    public ENV getEnv() {
        return this.f٤٥٩١d;
    }

    public ISecurity getSecurity() {
        return this.f٤٥٩٢e;
    }

    public String getTag() {
        return this.f٤٥٨٩b;
    }

    public String toString() {
        return this.f٤٥٨٩b;
    }
}
