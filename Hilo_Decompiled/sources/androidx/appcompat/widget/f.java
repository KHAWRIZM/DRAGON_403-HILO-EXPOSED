package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import androidx.appcompat.R;
import androidx.appcompat.widget.h0;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class f {

    /* renamed from: b, reason: collision with root package name */
    private static final PorterDuff.Mode f١٥٠٤b = PorterDuff.Mode.SRC_IN;

    /* renamed from: c, reason: collision with root package name */
    private static f f١٥٠٥c;

    /* renamed from: a, reason: collision with root package name */
    private h0 f١٥٠٦a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class a implements h0.f {

        /* renamed from: a, reason: collision with root package name */
        private final int[] f١٥٠٧a = {R.drawable.abc_textfield_search_default_mtrl_alpha, R.drawable.abc_textfield_default_mtrl_alpha, R.drawable.abc_ab_share_pack_mtrl_alpha};

        /* renamed from: b, reason: collision with root package name */
        private final int[] f١٥٠٨b = {R.drawable.abc_ic_commit_search_api_mtrl_alpha, R.drawable.abc_seekbar_tick_mark_material, R.drawable.abc_ic_menu_share_mtrl_alpha, R.drawable.abc_ic_menu_copy_mtrl_am_alpha, R.drawable.abc_ic_menu_cut_mtrl_alpha, R.drawable.abc_ic_menu_selectall_mtrl_alpha, R.drawable.abc_ic_menu_paste_mtrl_am_alpha};

        /* renamed from: c, reason: collision with root package name */
        private final int[] f١٥٠٩c = {R.drawable.abc_textfield_activated_mtrl_alpha, R.drawable.abc_textfield_search_activated_mtrl_alpha, R.drawable.abc_cab_background_top_mtrl_alpha, R.drawable.abc_text_cursor_material, R.drawable.abc_text_select_handle_left_mtrl, R.drawable.abc_text_select_handle_middle_mtrl, R.drawable.abc_text_select_handle_right_mtrl};

        /* renamed from: d, reason: collision with root package name */
        private final int[] f١٥١٠d = {R.drawable.abc_popup_background_mtrl_mult, R.drawable.abc_cab_background_internal_bg, R.drawable.abc_menu_hardkey_panel_mtrl_mult};

        /* renamed from: e, reason: collision with root package name */
        private final int[] f١٥١١e = {R.drawable.abc_tab_indicator_material, R.drawable.abc_textfield_search_material};

        /* renamed from: f, reason: collision with root package name */
        private final int[] f١٥١٢f = {R.drawable.abc_btn_check_material, R.drawable.abc_btn_radio_material, R.drawable.abc_btn_check_material_anim, R.drawable.abc_btn_radio_material_anim};

        a() {
        }

        private boolean f(int[] iArr, int i10) {
            for (int i11 : iArr) {
                if (i11 == i10) {
                    return true;
                }
            }
            return false;
        }

        private ColorStateList g(Context context) {
            return h(context, 0);
        }

        private ColorStateList h(Context context, int i10) {
            int c10 = l0.c(context, R.attr.colorControlHighlight);
            return new ColorStateList(new int[][]{l0.f١٦٠٠b, l0.f١٦٠٣e, l0.f١٦٠١c, l0.f١٦٠٧i}, new int[]{l0.b(context, R.attr.colorButtonNormal), androidx.core.graphics.x.g(c10, i10), androidx.core.graphics.x.g(c10, i10), i10});
        }

        private ColorStateList i(Context context) {
            return h(context, l0.c(context, R.attr.colorAccent));
        }

        private ColorStateList j(Context context) {
            return h(context, l0.c(context, R.attr.colorButtonNormal));
        }

        private ColorStateList k(Context context) {
            int[][] iArr = new int[3];
            int[] iArr2 = new int[3];
            int i10 = R.attr.colorSwitchThumbNormal;
            ColorStateList e10 = l0.e(context, i10);
            if (e10 != null && e10.isStateful()) {
                int[] iArr3 = l0.f١٦٠٠b;
                iArr[0] = iArr3;
                iArr2[0] = e10.getColorForState(iArr3, 0);
                iArr[1] = l0.f١٦٠٤f;
                iArr2[1] = l0.c(context, R.attr.colorControlActivated);
                iArr[2] = l0.f١٦٠٧i;
                iArr2[2] = e10.getDefaultColor();
            } else {
                iArr[0] = l0.f١٦٠٠b;
                iArr2[0] = l0.b(context, i10);
                iArr[1] = l0.f١٦٠٤f;
                iArr2[1] = l0.c(context, R.attr.colorControlActivated);
                iArr[2] = l0.f١٦٠٧i;
                iArr2[2] = l0.c(context, i10);
            }
            return new ColorStateList(iArr, iArr2);
        }

        private LayerDrawable l(h0 h0Var, Context context, int i10) {
            BitmapDrawable bitmapDrawable;
            BitmapDrawable bitmapDrawable2;
            BitmapDrawable bitmapDrawable3;
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(i10);
            Drawable j10 = h0Var.j(context, R.drawable.abc_star_black_48dp);
            Drawable j11 = h0Var.j(context, R.drawable.abc_star_half_black_48dp);
            if ((j10 instanceof BitmapDrawable) && j10.getIntrinsicWidth() == dimensionPixelSize && j10.getIntrinsicHeight() == dimensionPixelSize) {
                bitmapDrawable = (BitmapDrawable) j10;
                bitmapDrawable2 = new BitmapDrawable(bitmapDrawable.getBitmap());
            } else {
                Bitmap createBitmap = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(createBitmap);
                j10.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                j10.draw(canvas);
                bitmapDrawable = new BitmapDrawable(createBitmap);
                bitmapDrawable2 = new BitmapDrawable(createBitmap);
            }
            bitmapDrawable2.setTileModeX(Shader.TileMode.REPEAT);
            if ((j11 instanceof BitmapDrawable) && j11.getIntrinsicWidth() == dimensionPixelSize && j11.getIntrinsicHeight() == dimensionPixelSize) {
                bitmapDrawable3 = (BitmapDrawable) j11;
            } else {
                Bitmap createBitmap2 = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
                Canvas canvas2 = new Canvas(createBitmap2);
                j11.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                j11.draw(canvas2);
                bitmapDrawable3 = new BitmapDrawable(createBitmap2);
            }
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{bitmapDrawable, bitmapDrawable3, bitmapDrawable2});
            layerDrawable.setId(0, android.R.id.background);
            layerDrawable.setId(1, android.R.id.secondaryProgress);
            layerDrawable.setId(2, android.R.id.progress);
            return layerDrawable;
        }

        private void m(Drawable drawable, int i10, PorterDuff.Mode mode) {
            Drawable mutate = drawable.mutate();
            if (mode == null) {
                mode = f.f١٥٠٤b;
            }
            mutate.setColorFilter(f.e(i10, mode));
        }

        @Override // androidx.appcompat.widget.h0.f
        public Drawable a(h0 h0Var, Context context, int i10) {
            if (i10 == R.drawable.abc_cab_background_top_material) {
                return new LayerDrawable(new Drawable[]{h0Var.j(context, R.drawable.abc_cab_background_internal_bg), h0Var.j(context, R.drawable.abc_cab_background_top_mtrl_alpha)});
            }
            if (i10 == R.drawable.abc_ratingbar_material) {
                return l(h0Var, context, R.dimen.abc_star_big);
            }
            if (i10 == R.drawable.abc_ratingbar_indicator_material) {
                return l(h0Var, context, R.dimen.abc_star_medium);
            }
            if (i10 == R.drawable.abc_ratingbar_small_material) {
                return l(h0Var, context, R.dimen.abc_star_small);
            }
            return null;
        }

        @Override // androidx.appcompat.widget.h0.f
        public ColorStateList b(Context context, int i10) {
            if (i10 == R.drawable.abc_edit_text_material) {
                return r1.a.a(context, R.color.abc_tint_edittext);
            }
            if (i10 == R.drawable.abc_switch_track_mtrl_alpha) {
                return r1.a.a(context, R.color.abc_tint_switch_track);
            }
            if (i10 == R.drawable.abc_switch_thumb_material) {
                return k(context);
            }
            if (i10 == R.drawable.abc_btn_default_mtrl_shape) {
                return j(context);
            }
            if (i10 == R.drawable.abc_btn_borderless_material) {
                return g(context);
            }
            if (i10 == R.drawable.abc_btn_colored_material) {
                return i(context);
            }
            if (i10 != R.drawable.abc_spinner_mtrl_am_alpha && i10 != R.drawable.abc_spinner_textfield_background_material) {
                if (f(this.f١٥٠٨b, i10)) {
                    return l0.e(context, R.attr.colorControlNormal);
                }
                if (f(this.f١٥١١e, i10)) {
                    return r1.a.a(context, R.color.abc_tint_default);
                }
                if (f(this.f١٥١٢f, i10)) {
                    return r1.a.a(context, R.color.abc_tint_btn_checkable);
                }
                if (i10 == R.drawable.abc_seekbar_thumb_material) {
                    return r1.a.a(context, R.color.abc_tint_seek_thumb);
                }
                return null;
            }
            return r1.a.a(context, R.color.abc_tint_spinner);
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0067 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0052  */
        @Override // androidx.appcompat.widget.h0.f
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean c(Context context, int i10, Drawable drawable) {
            PorterDuff.Mode mode;
            int i11;
            int i12;
            boolean z10;
            PorterDuff.Mode mode2 = f.f١٥٠٤b;
            if (f(this.f١٥٠٧a, i10)) {
                i11 = R.attr.colorControlNormal;
            } else if (f(this.f١٥٠٩c, i10)) {
                i11 = R.attr.colorControlActivated;
            } else {
                if (f(this.f١٥١٠d, i10)) {
                    mode2 = PorterDuff.Mode.MULTIPLY;
                } else {
                    if (i10 == R.drawable.abc_list_divider_mtrl_alpha) {
                        mode = mode2;
                        z10 = true;
                        i12 = Math.round(40.8f);
                        i11 = android.R.attr.colorForeground;
                    } else if (i10 != R.drawable.abc_dialog_material_background) {
                        mode = mode2;
                        i11 = 0;
                        i12 = -1;
                        z10 = false;
                    }
                    if (!z10) {
                        return false;
                    }
                    Drawable mutate = drawable.mutate();
                    mutate.setColorFilter(f.e(l0.c(context, i11), mode));
                    if (i12 != -1) {
                        mutate.setAlpha(i12);
                    }
                    return true;
                }
                mode = mode2;
                i11 = android.R.attr.colorBackground;
                i12 = -1;
                z10 = true;
                if (!z10) {
                }
            }
            mode = mode2;
            i12 = -1;
            z10 = true;
            if (!z10) {
            }
        }

        @Override // androidx.appcompat.widget.h0.f
        public PorterDuff.Mode d(int i10) {
            if (i10 == R.drawable.abc_switch_thumb_material) {
                return PorterDuff.Mode.MULTIPLY;
            }
            return null;
        }

        @Override // androidx.appcompat.widget.h0.f
        public boolean e(Context context, int i10, Drawable drawable) {
            if (i10 == R.drawable.abc_seekbar_track_material) {
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                Drawable findDrawableByLayerId = layerDrawable.findDrawableByLayerId(android.R.id.background);
                int i11 = R.attr.colorControlNormal;
                m(findDrawableByLayerId, l0.c(context, i11), f.f١٥٠٤b);
                m(layerDrawable.findDrawableByLayerId(android.R.id.secondaryProgress), l0.c(context, i11), f.f١٥٠٤b);
                m(layerDrawable.findDrawableByLayerId(android.R.id.progress), l0.c(context, R.attr.colorControlActivated), f.f١٥٠٤b);
                return true;
            }
            if (i10 != R.drawable.abc_ratingbar_material && i10 != R.drawable.abc_ratingbar_indicator_material && i10 != R.drawable.abc_ratingbar_small_material) {
                return false;
            }
            LayerDrawable layerDrawable2 = (LayerDrawable) drawable;
            m(layerDrawable2.findDrawableByLayerId(android.R.id.background), l0.b(context, R.attr.colorControlNormal), f.f١٥٠٤b);
            Drawable findDrawableByLayerId2 = layerDrawable2.findDrawableByLayerId(android.R.id.secondaryProgress);
            int i12 = R.attr.colorControlActivated;
            m(findDrawableByLayerId2, l0.c(context, i12), f.f١٥٠٤b);
            m(layerDrawable2.findDrawableByLayerId(android.R.id.progress), l0.c(context, i12), f.f١٥٠٤b);
            return true;
        }
    }

    public static synchronized f b() {
        f fVar;
        synchronized (f.class) {
            try {
                if (f١٥٠٥c == null) {
                    h();
                }
                fVar = f١٥٠٥c;
            } catch (Throwable th) {
                throw th;
            }
        }
        return fVar;
    }

    public static synchronized PorterDuffColorFilter e(int i10, PorterDuff.Mode mode) {
        PorterDuffColorFilter l10;
        synchronized (f.class) {
            l10 = h0.l(i10, mode);
        }
        return l10;
    }

    public static synchronized void h() {
        synchronized (f.class) {
            if (f١٥٠٥c == null) {
                f fVar = new f();
                f١٥٠٥c = fVar;
                fVar.f١٥٠٦a = h0.h();
                f١٥٠٥c.f١٥٠٦a.u(new a());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void i(Drawable drawable, n0 n0Var, int[] iArr) {
        h0.w(drawable, n0Var, iArr);
    }

    public synchronized Drawable c(Context context, int i10) {
        return this.f١٥٠٦a.j(context, i10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Drawable d(Context context, int i10, boolean z10) {
        return this.f١٥٠٦a.k(context, i10, z10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized ColorStateList f(Context context, int i10) {
        return this.f١٥٠٦a.m(context, i10);
    }

    public synchronized void g(Context context) {
        this.f١٥٠٦a.s(context);
    }
}
