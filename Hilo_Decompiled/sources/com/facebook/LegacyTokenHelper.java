package com.facebook;

import a.ServiceProvider__TheRouter__851042640;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferTable;
import com.facebook.internal.Logger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\t\u001a\u00020\nJ\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eJ\u000e\u0010\u0010\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eJ \u0010\u0011\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/facebook/LegacyTokenHelper;", "", "context", "Landroid/content/Context;", "cacheKey", "", "(Landroid/content/Context;Ljava/lang/String;)V", "cache", "Landroid/content/SharedPreferences;", "clear", "", "deserializeKey", TransferTable.COLUMN_KEY, "bundle", "Landroid/os/Bundle;", "load", "save", "serializeKey", "editor", "Landroid/content/SharedPreferences$Editor;", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class LegacyTokenHelper {

    @NotNull
    public static final String APPLICATION_ID_KEY = "com.facebook.TokenCachingStrategy.ApplicationId";

    @NotNull
    public static final String DECLINED_PERMISSIONS_KEY = "com.facebook.TokenCachingStrategy.DeclinedPermissions";

    @NotNull
    public static final String DEFAULT_CACHE_KEY = "com.facebook.SharedPreferencesTokenCachingStrategy.DEFAULT_KEY";

    @NotNull
    public static final String EXPIRATION_DATE_KEY = "com.facebook.TokenCachingStrategy.ExpirationDate";

    @NotNull
    public static final String EXPIRED_PERMISSIONS_KEY = "com.facebook.TokenCachingStrategy.ExpiredPermissions";
    private static final long INVALID_BUNDLE_MILLISECONDS = Long.MIN_VALUE;

    @NotNull
    private static final String IS_SSO_KEY = "com.facebook.TokenCachingStrategy.IsSSO";

    @NotNull
    private static final String JSON_VALUE = "value";

    @NotNull
    private static final String JSON_VALUE_ENUM_TYPE = "enumType";

    @NotNull
    private static final String JSON_VALUE_TYPE = "valueType";

    @NotNull
    public static final String LAST_REFRESH_DATE_KEY = "com.facebook.TokenCachingStrategy.LastRefreshDate";

    @NotNull
    public static final String PERMISSIONS_KEY = "com.facebook.TokenCachingStrategy.Permissions";

    @NotNull
    public static final String TOKEN_KEY = "com.facebook.TokenCachingStrategy.Token";

    @NotNull
    public static final String TOKEN_SOURCE_KEY = "com.facebook.TokenCachingStrategy.AccessTokenSource";

    @NotNull
    private static final String TYPE_BOOLEAN = "bool";

    @NotNull
    private static final String TYPE_BOOLEAN_ARRAY = "bool[]";

    @NotNull
    private static final String TYPE_BYTE = "byte";

    @NotNull
    private static final String TYPE_BYTE_ARRAY = "byte[]";

    @NotNull
    private static final String TYPE_CHAR = "char";

    @NotNull
    private static final String TYPE_CHAR_ARRAY = "char[]";

    @NotNull
    private static final String TYPE_DOUBLE = "double";

    @NotNull
    private static final String TYPE_DOUBLE_ARRAY = "double[]";

    @NotNull
    private static final String TYPE_ENUM = "enum";

    @NotNull
    private static final String TYPE_FLOAT = "float";

    @NotNull
    private static final String TYPE_FLOAT_ARRAY = "float[]";

    @NotNull
    private static final String TYPE_INTEGER = "int";

    @NotNull
    private static final String TYPE_INTEGER_ARRAY = "int[]";

    @NotNull
    private static final String TYPE_LONG = "long";

    @NotNull
    private static final String TYPE_LONG_ARRAY = "long[]";

    @NotNull
    private static final String TYPE_SHORT = "short";

    @NotNull
    private static final String TYPE_SHORT_ARRAY = "short[]";

    @NotNull
    private static final String TYPE_STRING = "string";

    @NotNull
    private static final String TYPE_STRING_LIST = "stringList";

    @NotNull
    private final SharedPreferences cache;

    @NotNull
    private final String cacheKey;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = LegacyTokenHelper.class.getSimpleName();

    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010(\u001a\u0004\u0018\u00010\u00042\u0006\u0010)\u001a\u00020*H\u0007J\u001e\u0010+\u001a\u0004\u0018\u00010,2\b\u0010)\u001a\u0004\u0018\u00010*2\b\u0010-\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010.\u001a\u0004\u0018\u00010,2\u0006\u0010)\u001a\u00020*H\u0007J\u0010\u0010/\u001a\u00020\n2\u0006\u0010)\u001a\u00020*H\u0007J\u0012\u00100\u001a\u0004\u0018\u00010,2\u0006\u0010)\u001a\u00020*H\u0007J\u0010\u00101\u001a\u00020\n2\u0006\u0010)\u001a\u00020*H\u0007J\u0018\u00102\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001032\u0006\u0010)\u001a\u00020*H\u0007J\u0012\u00104\u001a\u0004\u0018\u0001052\u0006\u0010)\u001a\u00020*H\u0007J\u0012\u00106\u001a\u0004\u0018\u00010\u00042\u0006\u0010)\u001a\u00020*H\u0007J\u0012\u00107\u001a\u0002082\b\u0010)\u001a\u0004\u0018\u00010*H\u0007J\u001a\u00109\u001a\u00020:2\u0006\u0010)\u001a\u00020*2\b\u0010;\u001a\u0004\u0018\u00010\u0004H\u0007J\"\u0010<\u001a\u00020:2\u0006\u0010)\u001a\u00020*2\b\u0010-\u001a\u0004\u0018\u00010\u00042\u0006\u0010=\u001a\u00020,H\u0002J\u001e\u0010>\u001a\u00020:2\u0006\u0010)\u001a\u00020*2\f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00040?H\u0007J\u0018\u0010@\u001a\u00020:2\u0006\u0010)\u001a\u00020*2\u0006\u0010;\u001a\u00020,H\u0007J\u0018\u0010A\u001a\u00020:2\u0006\u0010)\u001a\u00020*2\u0006\u0010;\u001a\u00020\nH\u0007J\u001e\u0010B\u001a\u00020:2\u0006\u0010)\u001a\u00020*2\f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00040?H\u0007J\u0018\u0010C\u001a\u00020:2\u0006\u0010)\u001a\u00020*2\u0006\u0010;\u001a\u00020,H\u0007J\u0018\u0010D\u001a\u00020:2\u0006\u0010)\u001a\u00020*2\u0006\u0010;\u001a\u00020\nH\u0007J\u001e\u0010E\u001a\u00020:2\u0006\u0010)\u001a\u00020*2\f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00040?H\u0007J\u0018\u0010F\u001a\u00020:2\u0006\u0010)\u001a\u00020*2\u0006\u0010;\u001a\u000205H\u0007J\u0018\u0010G\u001a\u00020:2\u0006\u0010)\u001a\u00020*2\u0006\u0010;\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n \u0012*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006H"}, d2 = {"Lcom/facebook/LegacyTokenHelper$Companion;", "", "()V", "APPLICATION_ID_KEY", "", "DECLINED_PERMISSIONS_KEY", "DEFAULT_CACHE_KEY", "EXPIRATION_DATE_KEY", "EXPIRED_PERMISSIONS_KEY", "INVALID_BUNDLE_MILLISECONDS", "", "IS_SSO_KEY", "JSON_VALUE", "JSON_VALUE_ENUM_TYPE", "JSON_VALUE_TYPE", "LAST_REFRESH_DATE_KEY", "PERMISSIONS_KEY", "TAG", "kotlin.jvm.PlatformType", "TOKEN_KEY", "TOKEN_SOURCE_KEY", "TYPE_BOOLEAN", "TYPE_BOOLEAN_ARRAY", "TYPE_BYTE", "TYPE_BYTE_ARRAY", "TYPE_CHAR", "TYPE_CHAR_ARRAY", "TYPE_DOUBLE", "TYPE_DOUBLE_ARRAY", "TYPE_ENUM", "TYPE_FLOAT", "TYPE_FLOAT_ARRAY", "TYPE_INTEGER", "TYPE_INTEGER_ARRAY", "TYPE_LONG", "TYPE_LONG_ARRAY", "TYPE_SHORT", "TYPE_SHORT_ARRAY", "TYPE_STRING", "TYPE_STRING_LIST", "getApplicationId", "bundle", "Landroid/os/Bundle;", "getDate", "Ljava/util/Date;", TransferTable.COLUMN_KEY, "getExpirationDate", "getExpirationMilliseconds", "getLastRefreshDate", "getLastRefreshMilliseconds", "getPermissions", "", "getSource", "Lcom/facebook/AccessTokenSource;", "getToken", "hasTokenInformation", "", "putApplicationId", "", "value", "putDate", "date", "putDeclinedPermissions", "", "putExpirationDate", "putExpirationMilliseconds", "putExpiredPermissions", "putLastRefreshDate", "putLastRefreshMilliseconds", "putPermissions", "putSource", "putToken", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final Date getDate(Bundle bundle, String key) {
            if (bundle == null) {
                return null;
            }
            long j10 = bundle.getLong(key, Long.MIN_VALUE);
            if (j10 == Long.MIN_VALUE) {
                return null;
            }
            return new Date(j10);
        }

        private final void putDate(Bundle bundle, String key, Date date) {
            bundle.putLong(key, date.getTime());
        }

        @JvmStatic
        @Nullable
        public final String getApplicationId(@NotNull Bundle bundle) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            return bundle.getString(LegacyTokenHelper.APPLICATION_ID_KEY);
        }

        @JvmStatic
        @Nullable
        public final Date getExpirationDate(@NotNull Bundle bundle) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            return getDate(bundle, LegacyTokenHelper.EXPIRATION_DATE_KEY);
        }

        @JvmStatic
        public final long getExpirationMilliseconds(@NotNull Bundle bundle) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            return bundle.getLong(LegacyTokenHelper.EXPIRATION_DATE_KEY);
        }

        @JvmStatic
        @Nullable
        public final Date getLastRefreshDate(@NotNull Bundle bundle) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            return getDate(bundle, LegacyTokenHelper.LAST_REFRESH_DATE_KEY);
        }

        @JvmStatic
        public final long getLastRefreshMilliseconds(@NotNull Bundle bundle) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            return bundle.getLong(LegacyTokenHelper.LAST_REFRESH_DATE_KEY);
        }

        @JvmStatic
        @Nullable
        public final Set<String> getPermissions(@NotNull Bundle bundle) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            ArrayList<String> stringArrayList = bundle.getStringArrayList(LegacyTokenHelper.PERMISSIONS_KEY);
            if (stringArrayList == null) {
                return null;
            }
            return new HashSet(stringArrayList);
        }

        @JvmStatic
        @Nullable
        public final AccessTokenSource getSource(@NotNull Bundle bundle) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            if (bundle.containsKey(LegacyTokenHelper.TOKEN_SOURCE_KEY)) {
                return (AccessTokenSource) bundle.getSerializable(LegacyTokenHelper.TOKEN_SOURCE_KEY);
            }
            if (bundle.getBoolean(LegacyTokenHelper.IS_SSO_KEY)) {
                return AccessTokenSource.FACEBOOK_APPLICATION_WEB;
            }
            return AccessTokenSource.WEB_VIEW;
        }

        @JvmStatic
        @Nullable
        public final String getToken(@NotNull Bundle bundle) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            return bundle.getString(LegacyTokenHelper.TOKEN_KEY);
        }

        @JvmStatic
        public final boolean hasTokenInformation(@Nullable Bundle bundle) {
            String string;
            if (bundle == null || (string = bundle.getString(LegacyTokenHelper.TOKEN_KEY)) == null || string.length() == 0 || bundle.getLong(LegacyTokenHelper.EXPIRATION_DATE_KEY, 0L) == 0) {
                return false;
            }
            return true;
        }

        @JvmStatic
        public final void putApplicationId(@NotNull Bundle bundle, @Nullable String value) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            bundle.putString(LegacyTokenHelper.APPLICATION_ID_KEY, value);
        }

        @JvmStatic
        public final void putDeclinedPermissions(@NotNull Bundle bundle, @NotNull Collection<String> value) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(value, "value");
            bundle.putStringArrayList(LegacyTokenHelper.DECLINED_PERMISSIONS_KEY, new ArrayList<>(value));
        }

        @JvmStatic
        public final void putExpirationDate(@NotNull Bundle bundle, @NotNull Date value) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(value, "value");
            putDate(bundle, LegacyTokenHelper.EXPIRATION_DATE_KEY, value);
        }

        @JvmStatic
        public final void putExpirationMilliseconds(@NotNull Bundle bundle, long value) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            bundle.putLong(LegacyTokenHelper.EXPIRATION_DATE_KEY, value);
        }

        @JvmStatic
        public final void putExpiredPermissions(@NotNull Bundle bundle, @NotNull Collection<String> value) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(value, "value");
            bundle.putStringArrayList(LegacyTokenHelper.EXPIRED_PERMISSIONS_KEY, new ArrayList<>(value));
        }

        @JvmStatic
        public final void putLastRefreshDate(@NotNull Bundle bundle, @NotNull Date value) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(value, "value");
            putDate(bundle, LegacyTokenHelper.LAST_REFRESH_DATE_KEY, value);
        }

        @JvmStatic
        public final void putLastRefreshMilliseconds(@NotNull Bundle bundle, long value) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            bundle.putLong(LegacyTokenHelper.LAST_REFRESH_DATE_KEY, value);
        }

        @JvmStatic
        public final void putPermissions(@NotNull Bundle bundle, @NotNull Collection<String> value) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(value, "value");
            bundle.putStringArrayList(LegacyTokenHelper.PERMISSIONS_KEY, new ArrayList<>(value));
        }

        @JvmStatic
        public final void putSource(@NotNull Bundle bundle, @NotNull AccessTokenSource value) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(value, "value");
            bundle.putSerializable(LegacyTokenHelper.TOKEN_SOURCE_KEY, value);
        }

        @JvmStatic
        public final void putToken(@NotNull Bundle bundle, @NotNull String value) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(value, "value");
            bundle.putString(LegacyTokenHelper.TOKEN_KEY, value);
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public LegacyTokenHelper(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void deserializeKey(String key, Bundle bundle) throws JSONException {
        String str;
        String string;
        String string2 = this.cache.getString(key, ServiceProvider__TheRouter__851042640.FLOW_TASK_JSON);
        if (string2 != null) {
            JSONObject jSONObject = new JSONObject(string2);
            String string3 = jSONObject.getString(JSON_VALUE_TYPE);
            if (string3 != null) {
                int i10 = 0;
                switch (string3.hashCode()) {
                    case -1573317553:
                        if (string3.equals(TYPE_STRING_LIST)) {
                            JSONArray jSONArray = jSONObject.getJSONArray("value");
                            int length = jSONArray.length();
                            ArrayList<String> arrayList = new ArrayList<>(length);
                            if (length > 0) {
                                while (true) {
                                    int i11 = i10 + 1;
                                    Object obj = jSONArray.get(i10);
                                    if (obj == JSONObject.NULL) {
                                        str = null;
                                    } else if (obj != null) {
                                        str = (String) obj;
                                    } else {
                                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                    }
                                    arrayList.add(i10, str);
                                    if (i11 < length) {
                                        i10 = i11;
                                    }
                                }
                            }
                            bundle.putStringArrayList(key, arrayList);
                            return;
                        }
                        return;
                    case -1383386164:
                        if (string3.equals(TYPE_BOOLEAN_ARRAY)) {
                            JSONArray jSONArray2 = jSONObject.getJSONArray("value");
                            int length2 = jSONArray2.length();
                            boolean[] zArr = new boolean[length2];
                            int i12 = length2 - 1;
                            if (i12 >= 0) {
                                while (true) {
                                    int i13 = i10 + 1;
                                    zArr[i10] = jSONArray2.getBoolean(i10);
                                    if (i13 <= i12) {
                                        i10 = i13;
                                    }
                                }
                            }
                            bundle.putBooleanArray(key, zArr);
                            return;
                        }
                        return;
                    case -1374008726:
                        if (string3.equals(TYPE_BYTE_ARRAY)) {
                            JSONArray jSONArray3 = jSONObject.getJSONArray("value");
                            int length3 = jSONArray3.length();
                            byte[] bArr = new byte[length3];
                            int i14 = length3 - 1;
                            if (i14 >= 0) {
                                while (true) {
                                    int i15 = i10 + 1;
                                    bArr[i10] = (byte) jSONArray3.getInt(i10);
                                    if (i15 <= i14) {
                                        i10 = i15;
                                    }
                                }
                            }
                            bundle.putByteArray(key, bArr);
                            return;
                        }
                        return;
                    case -1361632968:
                        if (string3.equals(TYPE_CHAR_ARRAY)) {
                            JSONArray jSONArray4 = jSONObject.getJSONArray("value");
                            int length4 = jSONArray4.length();
                            char[] cArr = new char[length4];
                            int i16 = length4 - 1;
                            if (i16 >= 0) {
                                int i17 = 0;
                                while (true) {
                                    int i18 = i17 + 1;
                                    String string4 = jSONArray4.getString(i17);
                                    if (string4 != null && string4.length() == 1) {
                                        cArr[i17] = string4.charAt(0);
                                    }
                                    if (i18 <= i16) {
                                        i17 = i18;
                                    }
                                }
                            }
                            bundle.putCharArray(key, cArr);
                            return;
                        }
                        return;
                    case -1325958191:
                        if (string3.equals(TYPE_DOUBLE)) {
                            bundle.putDouble(key, jSONObject.getDouble("value"));
                            return;
                        }
                        return;
                    case -1097129250:
                        if (string3.equals(TYPE_LONG_ARRAY)) {
                            JSONArray jSONArray5 = jSONObject.getJSONArray("value");
                            int length5 = jSONArray5.length();
                            long[] jArr = new long[length5];
                            int i19 = length5 - 1;
                            if (i19 >= 0) {
                                while (true) {
                                    int i20 = i10 + 1;
                                    jArr[i10] = jSONArray5.getLong(i10);
                                    if (i20 <= i19) {
                                        i10 = i20;
                                    }
                                }
                            }
                            bundle.putLongArray(key, jArr);
                            return;
                        }
                        return;
                    case -891985903:
                        if (string3.equals(TYPE_STRING)) {
                            bundle.putString(key, jSONObject.getString("value"));
                            return;
                        }
                        return;
                    case -766441794:
                        if (string3.equals(TYPE_FLOAT_ARRAY)) {
                            JSONArray jSONArray6 = jSONObject.getJSONArray("value");
                            int length6 = jSONArray6.length();
                            float[] fArr = new float[length6];
                            int i21 = length6 - 1;
                            if (i21 >= 0) {
                                while (true) {
                                    int i22 = i10 + 1;
                                    fArr[i10] = (float) jSONArray6.getDouble(i10);
                                    if (i22 <= i21) {
                                        i10 = i22;
                                    }
                                }
                            }
                            bundle.putFloatArray(key, fArr);
                            return;
                        }
                        return;
                    case 104431:
                        if (string3.equals(TYPE_INTEGER)) {
                            bundle.putInt(key, jSONObject.getInt("value"));
                            return;
                        }
                        return;
                    case 3029738:
                        if (string3.equals(TYPE_BOOLEAN)) {
                            bundle.putBoolean(key, jSONObject.getBoolean("value"));
                            return;
                        }
                        return;
                    case 3039496:
                        if (string3.equals(TYPE_BYTE)) {
                            bundle.putByte(key, (byte) jSONObject.getInt("value"));
                            return;
                        }
                        return;
                    case 3052374:
                        if (string3.equals(TYPE_CHAR) && (string = jSONObject.getString("value")) != null && string.length() == 1) {
                            bundle.putChar(key, string.charAt(0));
                            return;
                        }
                        return;
                    case 3118337:
                        if (string3.equals(TYPE_ENUM)) {
                            try {
                                bundle.putSerializable(key, Enum.valueOf(Class.forName(jSONObject.getString(JSON_VALUE_ENUM_TYPE)), jSONObject.getString("value")));
                                return;
                            } catch (ClassNotFoundException | IllegalArgumentException unused) {
                                return;
                            }
                        }
                        return;
                    case 3327612:
                        if (string3.equals(TYPE_LONG)) {
                            bundle.putLong(key, jSONObject.getLong("value"));
                            return;
                        }
                        return;
                    case 97526364:
                        if (string3.equals(TYPE_FLOAT)) {
                            bundle.putFloat(key, (float) jSONObject.getDouble("value"));
                            return;
                        }
                        return;
                    case 100361105:
                        if (string3.equals(TYPE_INTEGER_ARRAY)) {
                            JSONArray jSONArray7 = jSONObject.getJSONArray("value");
                            int length7 = jSONArray7.length();
                            int[] iArr = new int[length7];
                            int i23 = length7 - 1;
                            if (i23 >= 0) {
                                while (true) {
                                    int i24 = i10 + 1;
                                    iArr[i10] = jSONArray7.getInt(i10);
                                    if (i24 <= i23) {
                                        i10 = i24;
                                    }
                                }
                            }
                            bundle.putIntArray(key, iArr);
                            return;
                        }
                        return;
                    case 109413500:
                        if (string3.equals(TYPE_SHORT)) {
                            bundle.putShort(key, (short) jSONObject.getInt("value"));
                            return;
                        }
                        return;
                    case 1359468275:
                        if (string3.equals(TYPE_DOUBLE_ARRAY)) {
                            JSONArray jSONArray8 = jSONObject.getJSONArray("value");
                            int length8 = jSONArray8.length();
                            double[] dArr = new double[length8];
                            int i25 = length8 - 1;
                            if (i25 >= 0) {
                                while (true) {
                                    int i26 = i10 + 1;
                                    dArr[i10] = jSONArray8.getDouble(i10);
                                    if (i26 <= i25) {
                                        i10 = i26;
                                    }
                                }
                            }
                            bundle.putDoubleArray(key, dArr);
                            return;
                        }
                        return;
                    case 2067161310:
                        if (string3.equals(TYPE_SHORT_ARRAY)) {
                            JSONArray jSONArray9 = jSONObject.getJSONArray("value");
                            int length9 = jSONArray9.length();
                            short[] sArr = new short[length9];
                            int i27 = length9 - 1;
                            if (i27 >= 0) {
                                while (true) {
                                    int i28 = i10 + 1;
                                    sArr[i10] = (short) jSONArray9.getInt(i10);
                                    if (i28 <= i27) {
                                        i10 = i28;
                                    }
                                }
                            }
                            bundle.putShortArray(key, sArr);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
            return;
        }
        throw new IllegalStateException("Required value was null.");
    }

    @JvmStatic
    @Nullable
    public static final String getApplicationId(@NotNull Bundle bundle) {
        return INSTANCE.getApplicationId(bundle);
    }

    @JvmStatic
    @Nullable
    public static final Date getExpirationDate(@NotNull Bundle bundle) {
        return INSTANCE.getExpirationDate(bundle);
    }

    @JvmStatic
    public static final long getExpirationMilliseconds(@NotNull Bundle bundle) {
        return INSTANCE.getExpirationMilliseconds(bundle);
    }

    @JvmStatic
    @Nullable
    public static final Date getLastRefreshDate(@NotNull Bundle bundle) {
        return INSTANCE.getLastRefreshDate(bundle);
    }

    @JvmStatic
    public static final long getLastRefreshMilliseconds(@NotNull Bundle bundle) {
        return INSTANCE.getLastRefreshMilliseconds(bundle);
    }

    @JvmStatic
    @Nullable
    public static final Set<String> getPermissions(@NotNull Bundle bundle) {
        return INSTANCE.getPermissions(bundle);
    }

    @JvmStatic
    @Nullable
    public static final AccessTokenSource getSource(@NotNull Bundle bundle) {
        return INSTANCE.getSource(bundle);
    }

    @JvmStatic
    @Nullable
    public static final String getToken(@NotNull Bundle bundle) {
        return INSTANCE.getToken(bundle);
    }

    @JvmStatic
    public static final boolean hasTokenInformation(@Nullable Bundle bundle) {
        return INSTANCE.hasTokenInformation(bundle);
    }

    @JvmStatic
    public static final void putApplicationId(@NotNull Bundle bundle, @Nullable String str) {
        INSTANCE.putApplicationId(bundle, str);
    }

    @JvmStatic
    public static final void putDeclinedPermissions(@NotNull Bundle bundle, @NotNull Collection<String> collection) {
        INSTANCE.putDeclinedPermissions(bundle, collection);
    }

    @JvmStatic
    public static final void putExpirationDate(@NotNull Bundle bundle, @NotNull Date date) {
        INSTANCE.putExpirationDate(bundle, date);
    }

    @JvmStatic
    public static final void putExpirationMilliseconds(@NotNull Bundle bundle, long j10) {
        INSTANCE.putExpirationMilliseconds(bundle, j10);
    }

    @JvmStatic
    public static final void putExpiredPermissions(@NotNull Bundle bundle, @NotNull Collection<String> collection) {
        INSTANCE.putExpiredPermissions(bundle, collection);
    }

    @JvmStatic
    public static final void putLastRefreshDate(@NotNull Bundle bundle, @NotNull Date date) {
        INSTANCE.putLastRefreshDate(bundle, date);
    }

    @JvmStatic
    public static final void putLastRefreshMilliseconds(@NotNull Bundle bundle, long j10) {
        INSTANCE.putLastRefreshMilliseconds(bundle, j10);
    }

    @JvmStatic
    public static final void putPermissions(@NotNull Bundle bundle, @NotNull Collection<String> collection) {
        INSTANCE.putPermissions(bundle, collection);
    }

    @JvmStatic
    public static final void putSource(@NotNull Bundle bundle, @NotNull AccessTokenSource accessTokenSource) {
        INSTANCE.putSource(bundle, accessTokenSource);
    }

    @JvmStatic
    public static final void putToken(@NotNull Bundle bundle, @NotNull String str) {
        INSTANCE.putToken(bundle, str);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void serializeKey(String key, Bundle bundle, SharedPreferences.Editor editor) throws JSONException {
        JSONArray jSONArray;
        String str;
        Object obj = bundle.get(key);
        if (obj == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        String str2 = null;
        if (obj instanceof Byte) {
            jSONObject.put("value", (int) ((Number) obj).byteValue());
            str = TYPE_BYTE;
        } else if (obj instanceof Short) {
            jSONObject.put("value", (int) ((Number) obj).shortValue());
            str = TYPE_SHORT;
        } else if (obj instanceof Integer) {
            jSONObject.put("value", ((Number) obj).intValue());
            str = TYPE_INTEGER;
        } else if (obj instanceof Long) {
            jSONObject.put("value", ((Number) obj).longValue());
            str = TYPE_LONG;
        } else if (obj instanceof Float) {
            jSONObject.put("value", ((Number) obj).floatValue());
            str = TYPE_FLOAT;
        } else if (obj instanceof Double) {
            jSONObject.put("value", ((Number) obj).doubleValue());
            str = TYPE_DOUBLE;
        } else if (obj instanceof Boolean) {
            jSONObject.put("value", ((Boolean) obj).booleanValue());
            str = TYPE_BOOLEAN;
        } else if (obj instanceof Character) {
            jSONObject.put("value", obj.toString());
            str = TYPE_CHAR;
        } else if (obj instanceof String) {
            jSONObject.put("value", obj);
            str = TYPE_STRING;
        } else if (obj instanceof Enum) {
            jSONObject.put("value", obj.toString());
            jSONObject.put(JSON_VALUE_ENUM_TYPE, obj.getClass().getName());
            str = TYPE_ENUM;
        } else {
            jSONArray = new JSONArray();
            int i10 = 0;
            if (obj instanceof byte[]) {
                byte[] bArr = (byte[]) obj;
                int length = bArr.length;
                while (i10 < length) {
                    byte b10 = bArr[i10];
                    i10++;
                    jSONArray.put((int) b10);
                }
                str2 = TYPE_BYTE_ARRAY;
            } else if (obj instanceof short[]) {
                short[] sArr = (short[]) obj;
                int length2 = sArr.length;
                while (i10 < length2) {
                    short s10 = sArr[i10];
                    i10++;
                    jSONArray.put((int) s10);
                }
                str2 = TYPE_SHORT_ARRAY;
            } else if (obj instanceof int[]) {
                int[] iArr = (int[]) obj;
                int length3 = iArr.length;
                while (i10 < length3) {
                    int i11 = iArr[i10];
                    i10++;
                    jSONArray.put(i11);
                }
                str2 = TYPE_INTEGER_ARRAY;
            } else if (obj instanceof long[]) {
                long[] jArr = (long[]) obj;
                int length4 = jArr.length;
                while (i10 < length4) {
                    long j10 = jArr[i10];
                    i10++;
                    jSONArray.put(j10);
                }
                str2 = TYPE_LONG_ARRAY;
            } else if (obj instanceof float[]) {
                float[] fArr = (float[]) obj;
                int length5 = fArr.length;
                while (i10 < length5) {
                    float f10 = fArr[i10];
                    i10++;
                    jSONArray.put(f10);
                }
                str2 = TYPE_FLOAT_ARRAY;
            } else if (obj instanceof double[]) {
                double[] dArr = (double[]) obj;
                int length6 = dArr.length;
                while (i10 < length6) {
                    double d10 = dArr[i10];
                    i10++;
                    jSONArray.put(d10);
                }
                str2 = TYPE_DOUBLE_ARRAY;
            } else if (obj instanceof boolean[]) {
                boolean[] zArr = (boolean[]) obj;
                int length7 = zArr.length;
                while (i10 < length7) {
                    boolean z10 = zArr[i10];
                    i10++;
                    jSONArray.put(z10);
                }
                str2 = TYPE_BOOLEAN_ARRAY;
            } else if (obj instanceof char[]) {
                char[] cArr = (char[]) obj;
                int length8 = cArr.length;
                while (i10 < length8) {
                    char c10 = cArr[i10];
                    i10++;
                    jSONArray.put(String.valueOf(c10));
                }
                str2 = TYPE_CHAR_ARRAY;
            } else if (obj instanceof List) {
                for (Object obj2 : (List) obj) {
                    if (obj2 == null) {
                        obj2 = JSONObject.NULL;
                    }
                    jSONArray.put(obj2);
                }
                str2 = TYPE_STRING_LIST;
            } else {
                jSONArray = null;
            }
            if (str2 == null) {
                jSONObject.put(JSON_VALUE_TYPE, str2);
                if (jSONArray != null) {
                    jSONObject.putOpt("value", jSONArray);
                }
                String jSONObject2 = jSONObject.toString();
                Intrinsics.checkNotNullExpressionValue(jSONObject2, "json.toString()");
                editor.putString(key, jSONObject2);
                return;
            }
            return;
        }
        jSONArray = null;
        str2 = str;
        if (str2 == null) {
        }
    }

    public final void clear() {
        this.cache.edit().clear().apply();
    }

    @Nullable
    public final Bundle load() {
        Bundle bundle = new Bundle();
        for (String key : this.cache.getAll().keySet()) {
            try {
                Intrinsics.checkNotNullExpressionValue(key, "key");
                deserializeKey(key, bundle);
            } catch (JSONException e10) {
                Logger.Companion companion = Logger.INSTANCE;
                LoggingBehavior loggingBehavior = LoggingBehavior.CACHE;
                String TAG2 = TAG;
                Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                companion.log(loggingBehavior, 5, TAG2, "Error reading cached value for key: '" + ((Object) key) + "' -- " + e10);
                return null;
            }
        }
        return bundle;
    }

    public final void save(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        SharedPreferences.Editor editor = this.cache.edit();
        for (String key : bundle.keySet()) {
            try {
                Intrinsics.checkNotNullExpressionValue(key, "key");
                Intrinsics.checkNotNullExpressionValue(editor, "editor");
                serializeKey(key, bundle, editor);
            } catch (JSONException e10) {
                Logger.Companion companion = Logger.INSTANCE;
                LoggingBehavior loggingBehavior = LoggingBehavior.CACHE;
                String TAG2 = TAG;
                Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                companion.log(loggingBehavior, 5, TAG2, "Error processing value for key: '" + ((Object) key) + "' -- " + e10);
                return;
            }
        }
        editor.apply();
    }

    @JvmOverloads
    public LegacyTokenHelper(@NotNull Context context, @Nullable String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        str = (str == null || str.length() == 0) ? DEFAULT_CACHE_KEY : str;
        this.cacheKey = str;
        Context applicationContext = context.getApplicationContext();
        SharedPreferences sharedPreferences = (applicationContext != null ? applicationContext : context).getSharedPreferences(str, 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "context.getSharedPreferences(this.cacheKey, Context.MODE_PRIVATE)");
        this.cache = sharedPreferences;
    }

    public /* synthetic */ LegacyTokenHelper(Context context, String str, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i10 & 2) != 0 ? null : str);
    }
}
