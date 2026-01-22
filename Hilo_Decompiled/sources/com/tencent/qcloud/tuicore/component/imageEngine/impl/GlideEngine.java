package com.tencent.qcloud.tuicore.component.imageEngine.impl;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.widget.ImageView;
import c5.g;
import c5.h;
import com.bumptech.glide.Glide;
import com.bumptech.glide.f;
import com.bumptech.glide.i;
import com.tencent.qcloud.tuicore.R;
import com.tencent.qcloud.tuicore.TUILogin;
import com.tencent.qcloud.tuicore.TUIThemeManager;
import java.io.File;
import java.util.concurrent.ExecutionException;
import v4.g0;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class GlideEngine {
    public static void clear(ImageView imageView) {
        Glide.with(TUILogin.getAppContext()).e(imageView);
    }

    public static Bitmap loadBitmap(Object obj, int i) throws InterruptedException, ExecutionException {
        if (obj == null) {
            return null;
        }
        return (Bitmap) Glide.with(TUILogin.getAppContext()).b().J0(obj).q0(new h().j(TUIThemeManager.getAttrResId(TUILogin.getAppContext(), R.attr.core_default_user_icon))).z0(i, i).get();
    }

    public static void loadCornerImageWithoutPlaceHolder(ImageView imageView, String str, g gVar, float f) {
        g0 g0Var;
        int i = (int) f;
        if (i > 0) {
            g0Var = new g0(i);
        } else {
            g0Var = null;
        }
        h c = new h().c();
        if (g0Var != null) {
            c = c.k0(g0Var);
        }
        Glide.with(TUILogin.getAppContext()).q(str).q0(c).F0(gVar).D0(imageView);
    }

    public static void loadImage(ImageView imageView, String str, g gVar) {
        Glide.with(TUILogin.getAppContext()).q(str).F0(gVar).q0(new h().j(TUIThemeManager.getAttrResId(TUILogin.getAppContext(), R.attr.core_default_user_icon))).D0(imageView);
    }

    public static void loadImageSetDefault(ImageView imageView, Object obj, int i) {
        Glide.with(TUILogin.getAppContext()).p(obj).X(i).q0(new h().c().j(i)).D0(imageView);
    }

    public static void loadUserIcon(ImageView imageView, Object obj) {
        loadUserIcon(imageView, obj, 0);
    }

    public static void loadUserIcon(ImageView imageView, Object obj, int i) {
        i p = Glide.with(imageView.getContext()).p(obj);
        Context appContext = TUILogin.getAppContext();
        int i2 = R.attr.core_default_user_icon;
        p.X(TUIThemeManager.getAttrResId(appContext, i2)).q0(new h().c().j(TUIThemeManager.getAttrResId(TUILogin.getAppContext(), i2))).D0(imageView);
    }

    public static Bitmap loadBitmap(Object obj, int i, int i2) throws InterruptedException, ExecutionException {
        if (obj == null) {
            return null;
        }
        return (Bitmap) Glide.with(TUILogin.getAppContext()).b().J0(obj).q0(new h().j(TUIThemeManager.getAttrResId(TUILogin.getAppContext(), R.attr.core_default_user_icon))).z0(i, i2).get();
    }

    public static void loadImage(ImageView imageView, String str) {
        Glide.with(TUILogin.getAppContext()).q(str).q0(new h().j(TUIThemeManager.getAttrResId(TUILogin.getAppContext(), R.attr.core_default_user_icon))).D0(imageView);
    }

    public static void loadUserIcon(ImageView imageView, Object obj, int i, int i2) {
        Glide.with(TUILogin.getAppContext()).p(obj).X(i).q0(new h().c().j(i)).D0(imageView);
    }

    public static void loadImage(ImageView imageView, Uri uri) {
        if (uri == null) {
            return;
        }
        Glide.with(TUILogin.getAppContext()).n(uri).q0(new h().j(TUIThemeManager.getAttrResId(TUILogin.getAppContext(), R.attr.core_default_user_icon))).D0(imageView);
    }

    public static void loadImage(String str, String str2) {
        try {
            ((File) Glide.with(TUILogin.getAppContext()).d().K0(str2).Q0().get()).renameTo(new File(str));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e2) {
            e2.printStackTrace();
        }
    }

    public static void loadImage(ImageView imageView, Object obj) {
        if (obj == null) {
            return;
        }
        Glide.with(TUILogin.getAppContext()).p(obj).q0(new h().j(TUIThemeManager.getAttrResId(TUILogin.getAppContext(), R.attr.core_default_user_icon))).D0(imageView);
    }

    public void loadImage(Context context, int i, int i2, ImageView imageView, Uri uri) {
        Glide.with(context).n(uri).q0(new h().W(i, i2).Y(f.b).k()).D0(imageView);
    }
}
