package com.qiahao.nextvideo.ui.webview;

import com.qiahao.nextvideo.data.baishun.GetConfigData;
import com.tencent.qcloud.tuicore.TUIConstants;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016¨\u0006\b"}, d2 = {"Lcom/qiahao/nextvideo/ui/webview/JsNativeBridgeListener;", "", "getConfig", "Lcom/qiahao/nextvideo/data/baishun/GetConfigData;", TUIConstants.TUIBeauty.METHOD_DESTROY_XMAGIC, "", "gameRecharge", "gameLoaded", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public interface JsNativeBridgeListener {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class DefaultImpls {
        public static void destroy(@NotNull JsNativeBridgeListener jsNativeBridgeListener) {
        }

        public static void gameLoaded(@NotNull JsNativeBridgeListener jsNativeBridgeListener) {
        }

        public static void gameRecharge(@NotNull JsNativeBridgeListener jsNativeBridgeListener) {
        }

        @Nullable
        public static GetConfigData getConfig(@NotNull JsNativeBridgeListener jsNativeBridgeListener) {
            return null;
        }
    }

    void destroy();

    void gameLoaded();

    void gameRecharge();

    @Nullable
    GetConfigData getConfig();
}
