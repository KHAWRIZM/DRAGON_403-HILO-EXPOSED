package androidx.appcompat.widget;

import android.R;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.WeakHashMap;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
class k0 extends r2.c implements View.OnClickListener {

    /* renamed from: l, reason: collision with root package name */
    private final SearchView f١٥٧٧l;

    /* renamed from: m, reason: collision with root package name */
    private final SearchableInfo f١٥٧٨m;

    /* renamed from: n, reason: collision with root package name */
    private final Context f١٥٧٩n;

    /* renamed from: o, reason: collision with root package name */
    private final WeakHashMap f١٥٨٠o;

    /* renamed from: p, reason: collision with root package name */
    private final int f١٥٨١p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f١٥٨٢q;

    /* renamed from: r, reason: collision with root package name */
    private int f١٥٨٣r;

    /* renamed from: s, reason: collision with root package name */
    private ColorStateList f١٥٨٤s;

    /* renamed from: t, reason: collision with root package name */
    private int f١٥٨٥t;

    /* renamed from: u, reason: collision with root package name */
    private int f١٥٨٦u;

    /* renamed from: v, reason: collision with root package name */
    private int f١٥٨٧v;

    /* renamed from: w, reason: collision with root package name */
    private int f١٥٨٨w;

    /* renamed from: x, reason: collision with root package name */
    private int f١٥٨٩x;

    /* renamed from: y, reason: collision with root package name */
    private int f١٥٩٠y;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final TextView f١٥٩١a;

        /* renamed from: b, reason: collision with root package name */
        public final TextView f١٥٩٢b;

        /* renamed from: c, reason: collision with root package name */
        public final ImageView f١٥٩٣c;

        /* renamed from: d, reason: collision with root package name */
        public final ImageView f١٥٩٤d;

        /* renamed from: e, reason: collision with root package name */
        public final ImageView f١٥٩٥e;

        public a(View view) {
            this.f١٥٩١a = (TextView) view.findViewById(R.id.text1);
            this.f١٥٩٢b = (TextView) view.findViewById(R.id.text2);
            this.f١٥٩٣c = (ImageView) view.findViewById(R.id.icon1);
            this.f١٥٩٤d = (ImageView) view.findViewById(R.id.icon2);
            this.f١٥٩٥e = (ImageView) view.findViewById(androidx.appcompat.R.id.edit_query);
        }
    }

    public k0(Context context, SearchView searchView, SearchableInfo searchableInfo, WeakHashMap weakHashMap) {
        super(context, searchView.getSuggestionRowLayout(), null, true);
        this.f١٥٨٢q = false;
        this.f١٥٨٣r = 1;
        this.f١٥٨٥t = -1;
        this.f١٥٨٦u = -1;
        this.f١٥٨٧v = -1;
        this.f١٥٨٨w = -1;
        this.f١٥٨٩x = -1;
        this.f١٥٩٠y = -1;
        this.f١٥٧٧l = searchView;
        this.f١٥٧٨m = searchableInfo;
        this.f١٥٨١p = searchView.getSuggestionCommitIconResId();
        this.f١٥٧٩n = context;
        this.f١٥٨٠o = weakHashMap;
    }

    private void A(String str, Drawable drawable) {
        if (drawable != null) {
            this.f١٥٨٠o.put(str, drawable.getConstantState());
        }
    }

    private void B(Cursor cursor) {
        Bundle bundle;
        if (cursor != null) {
            bundle = cursor.getExtras();
        } else {
            bundle = null;
        }
        if (bundle != null) {
            bundle.getBoolean("in_progress");
        }
    }

    private Drawable k(String str) {
        Drawable.ConstantState constantState = (Drawable.ConstantState) this.f١٥٨٠o.get(str);
        if (constantState == null) {
            return null;
        }
        return constantState.newDrawable();
    }

    private CharSequence l(CharSequence charSequence) {
        if (this.f١٥٨٤s == null) {
            TypedValue typedValue = new TypedValue();
            this.f١٥٧٩n.getTheme().resolveAttribute(androidx.appcompat.R.attr.textColorSearchUrl, typedValue, true);
            this.f١٥٨٤s = this.f١٥٧٩n.getResources().getColorStateList(typedValue.resourceId);
        }
        SpannableString spannableString = new SpannableString(charSequence);
        spannableString.setSpan(new TextAppearanceSpan(null, 0, 0, this.f١٥٨٤s, null), 0, charSequence.length(), 33);
        return spannableString;
    }

    private Drawable m(ComponentName componentName) {
        PackageManager packageManager = this.f١٥٧٩n.getPackageManager();
        try {
            ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, 128);
            int iconResource = activityInfo.getIconResource();
            if (iconResource == 0) {
                return null;
            }
            Drawable drawable = packageManager.getDrawable(componentName.getPackageName(), iconResource, activityInfo.applicationInfo);
            if (drawable == null) {
                Log.w("SuggestionsAdapter", "Invalid icon resource " + iconResource + " for " + componentName.flattenToShortString());
                return null;
            }
            return drawable;
        } catch (PackageManager.NameNotFoundException e10) {
            Log.w("SuggestionsAdapter", e10.toString());
            return null;
        }
    }

    private Drawable n(ComponentName componentName) {
        String flattenToShortString = componentName.flattenToShortString();
        Drawable.ConstantState constantState = null;
        if (this.f١٥٨٠o.containsKey(flattenToShortString)) {
            Drawable.ConstantState constantState2 = (Drawable.ConstantState) this.f١٥٨٠o.get(flattenToShortString);
            if (constantState2 == null) {
                return null;
            }
            return constantState2.newDrawable(this.f١٥٧٩n.getResources());
        }
        Drawable m10 = m(componentName);
        if (m10 != null) {
            constantState = m10.getConstantState();
        }
        this.f١٥٨٠o.put(flattenToShortString, constantState);
        return m10;
    }

    public static String o(Cursor cursor, String str) {
        return w(cursor, cursor.getColumnIndex(str));
    }

    private Drawable p() {
        Drawable n10 = n(this.f١٥٧٨m.getSearchActivity());
        if (n10 != null) {
            return n10;
        }
        return this.f١٥٧٩n.getPackageManager().getDefaultActivityIcon();
    }

    private Drawable q(Uri uri) {
        try {
            if ("android.resource".equals(uri.getScheme())) {
                try {
                    return r(uri);
                } catch (Resources.NotFoundException unused) {
                    throw new FileNotFoundException("Resource does not exist: " + uri);
                }
            }
            InputStream openInputStream = this.f١٥٧٩n.getContentResolver().openInputStream(uri);
            if (openInputStream != null) {
                try {
                    return Drawable.createFromStream(openInputStream, null);
                } finally {
                    try {
                        openInputStream.close();
                    } catch (IOException e10) {
                        Log.e("SuggestionsAdapter", "Error closing icon stream for " + uri, e10);
                    }
                }
            }
            throw new FileNotFoundException("Failed to open " + uri);
        } catch (FileNotFoundException e11) {
            Log.w("SuggestionsAdapter", "Icon not found: " + uri + ", " + e11.getMessage());
            return null;
        }
        Log.w("SuggestionsAdapter", "Icon not found: " + uri + ", " + e11.getMessage());
        return null;
    }

    private Drawable s(String str) {
        if (str == null || str.isEmpty() || "0".equals(str)) {
            return null;
        }
        try {
            int parseInt = Integer.parseInt(str);
            String str2 = "android.resource://" + this.f١٥٧٩n.getPackageName() + "/" + parseInt;
            Drawable k10 = k(str2);
            if (k10 != null) {
                return k10;
            }
            Drawable drawable = androidx.core.content.a.getDrawable(this.f١٥٧٩n, parseInt);
            A(str2, drawable);
            return drawable;
        } catch (Resources.NotFoundException unused) {
            Log.w("SuggestionsAdapter", "Icon resource not found: " + str);
            return null;
        } catch (NumberFormatException unused2) {
            Drawable k11 = k(str);
            if (k11 != null) {
                return k11;
            }
            Drawable q10 = q(Uri.parse(str));
            A(str, q10);
            return q10;
        }
    }

    private Drawable t(Cursor cursor) {
        int i10 = this.f١٥٨٨w;
        if (i10 == -1) {
            return null;
        }
        Drawable s10 = s(cursor.getString(i10));
        if (s10 != null) {
            return s10;
        }
        return p();
    }

    private Drawable u(Cursor cursor) {
        int i10 = this.f١٥٨٩x;
        if (i10 == -1) {
            return null;
        }
        return s(cursor.getString(i10));
    }

    private static String w(Cursor cursor, int i10) {
        if (i10 == -1) {
            return null;
        }
        try {
            return cursor.getString(i10);
        } catch (Exception e10) {
            Log.e("SuggestionsAdapter", "unexpected error retrieving valid column from cursor, did the remote process die?", e10);
            return null;
        }
    }

    private void y(ImageView imageView, Drawable drawable, int i10) {
        imageView.setImageDrawable(drawable);
        if (drawable == null) {
            imageView.setVisibility(i10);
            return;
        }
        imageView.setVisibility(0);
        drawable.setVisible(false, false);
        drawable.setVisible(true, false);
    }

    private void z(TextView textView, CharSequence charSequence) {
        textView.setText(charSequence);
        if (TextUtils.isEmpty(charSequence)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
        }
    }

    @Override // r2.a, r2.b.a
    public void a(Cursor cursor) {
        if (this.f١٥٨٢q) {
            Log.w("SuggestionsAdapter", "Tried to change cursor after adapter was closed.");
            if (cursor != null) {
                cursor.close();
                return;
            }
            return;
        }
        try {
            super.a(cursor);
            if (cursor != null) {
                this.f١٥٨٥t = cursor.getColumnIndex("suggest_text_1");
                this.f١٥٨٦u = cursor.getColumnIndex("suggest_text_2");
                this.f١٥٨٧v = cursor.getColumnIndex("suggest_text_2_url");
                this.f١٥٨٨w = cursor.getColumnIndex("suggest_icon_1");
                this.f١٥٨٩x = cursor.getColumnIndex("suggest_icon_2");
                this.f١٥٩٠y = cursor.getColumnIndex("suggest_flags");
            }
        } catch (Exception e10) {
            Log.e("SuggestionsAdapter", "error changing cursor and caching columns", e10);
        }
    }

    @Override // r2.a, r2.b.a
    public CharSequence b(Cursor cursor) {
        String o10;
        String o11;
        if (cursor == null) {
            return null;
        }
        String o12 = o(cursor, "suggest_intent_query");
        if (o12 != null) {
            return o12;
        }
        if (this.f١٥٧٨m.shouldRewriteQueryFromData() && (o11 = o(cursor, "suggest_intent_data")) != null) {
            return o11;
        }
        if (!this.f١٥٧٨m.shouldRewriteQueryFromText() || (o10 = o(cursor, "suggest_text_1")) == null) {
            return null;
        }
        return o10;
    }

    @Override // r2.b.a
    public Cursor c(CharSequence charSequence) {
        String charSequence2;
        if (charSequence == null) {
            charSequence2 = "";
        } else {
            charSequence2 = charSequence.toString();
        }
        if (this.f١٥٧٧l.getVisibility() == 0 && this.f١٥٧٧l.getWindowVisibility() == 0) {
            try {
                Cursor v10 = v(this.f١٥٧٨m, charSequence2, 50);
                if (v10 != null) {
                    v10.getCount();
                    return v10;
                }
            } catch (RuntimeException e10) {
                Log.w("SuggestionsAdapter", "Search suggestions query threw an exception.", e10);
            }
        }
        return null;
    }

    @Override // r2.a
    public void e(View view, Context context, Cursor cursor) {
        int i10;
        CharSequence w10;
        a aVar = (a) view.getTag();
        int i11 = this.f١٥٩٠y;
        if (i11 != -1) {
            i10 = cursor.getInt(i11);
        } else {
            i10 = 0;
        }
        if (aVar.f١٥٩١a != null) {
            z(aVar.f١٥٩١a, w(cursor, this.f١٥٨٥t));
        }
        if (aVar.f١٥٩٢b != null) {
            String w11 = w(cursor, this.f١٥٨٧v);
            if (w11 != null) {
                w10 = l(w11);
            } else {
                w10 = w(cursor, this.f١٥٨٦u);
            }
            if (TextUtils.isEmpty(w10)) {
                TextView textView = aVar.f١٥٩١a;
                if (textView != null) {
                    textView.setSingleLine(false);
                    aVar.f١٥٩١a.setMaxLines(2);
                }
            } else {
                TextView textView2 = aVar.f١٥٩١a;
                if (textView2 != null) {
                    textView2.setSingleLine(true);
                    aVar.f١٥٩١a.setMaxLines(1);
                }
            }
            z(aVar.f١٥٩٢b, w10);
        }
        ImageView imageView = aVar.f١٥٩٣c;
        if (imageView != null) {
            y(imageView, t(cursor), 4);
        }
        ImageView imageView2 = aVar.f١٥٩٤d;
        if (imageView2 != null) {
            y(imageView2, u(cursor), 8);
        }
        int i12 = this.f١٥٨٣r;
        if (i12 != 2 && (i12 != 1 || (i10 & 1) == 0)) {
            aVar.f١٥٩٥e.setVisibility(8);
            return;
        }
        aVar.f١٥٩٥e.setVisibility(0);
        aVar.f١٥٩٥e.setTag(aVar.f١٥٩١a.getText());
        aVar.f١٥٩٥e.setOnClickListener(this);
    }

    @Override // r2.a, android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i10, View view, ViewGroup viewGroup) {
        try {
            return super.getDropDownView(i10, view, viewGroup);
        } catch (RuntimeException e10) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e10);
            View g10 = g(this.f١٥٧٩n, d(), viewGroup);
            if (g10 != null) {
                ((a) g10.getTag()).f١٥٩١a.setText(e10.toString());
            }
            return g10;
        }
    }

    @Override // r2.a, android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) {
        try {
            return super.getView(i10, view, viewGroup);
        } catch (RuntimeException e10) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e10);
            View h10 = h(this.f١٥٧٩n, d(), viewGroup);
            if (h10 != null) {
                ((a) h10.getTag()).f١٥٩١a.setText(e10.toString());
            }
            return h10;
        }
    }

    @Override // r2.c, r2.a
    public View h(Context context, Cursor cursor, ViewGroup viewGroup) {
        View h10 = super.h(context, cursor, viewGroup);
        h10.setTag(new a(h10));
        ((ImageView) h10.findViewById(androidx.appcompat.R.id.edit_query)).setImageResource(this.f١٥٨١p);
        return h10;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return false;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        B(d());
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        B(d());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof CharSequence) {
            this.f١٥٧٧l.C((CharSequence) tag);
        }
    }

    Drawable r(Uri uri) {
        int parseInt;
        String authority = uri.getAuthority();
        if (!TextUtils.isEmpty(authority)) {
            try {
                Resources resourcesForApplication = this.f١٥٧٩n.getPackageManager().getResourcesForApplication(authority);
                List<String> pathSegments = uri.getPathSegments();
                if (pathSegments != null) {
                    int size = pathSegments.size();
                    if (size == 1) {
                        try {
                            parseInt = Integer.parseInt(pathSegments.get(0));
                        } catch (NumberFormatException unused) {
                            throw new FileNotFoundException("Single path segment is not a resource ID: " + uri);
                        }
                    } else if (size == 2) {
                        parseInt = resourcesForApplication.getIdentifier(pathSegments.get(1), pathSegments.get(0), authority);
                    } else {
                        throw new FileNotFoundException("More than two path segments: " + uri);
                    }
                    if (parseInt != 0) {
                        return resourcesForApplication.getDrawable(parseInt);
                    }
                    throw new FileNotFoundException("No resource found for: " + uri);
                }
                throw new FileNotFoundException("No path: " + uri);
            } catch (PackageManager.NameNotFoundException unused2) {
                throw new FileNotFoundException("No package found for authority: " + uri);
            }
        }
        throw new FileNotFoundException("No authority: " + uri);
    }

    Cursor v(SearchableInfo searchableInfo, String str, int i10) {
        String suggestAuthority;
        String[] strArr = null;
        if (searchableInfo == null || (suggestAuthority = searchableInfo.getSuggestAuthority()) == null) {
            return null;
        }
        Uri.Builder fragment = new Uri.Builder().scheme("content").authority(suggestAuthority).query("").fragment("");
        String suggestPath = searchableInfo.getSuggestPath();
        if (suggestPath != null) {
            fragment.appendEncodedPath(suggestPath);
        }
        fragment.appendPath("search_suggest_query");
        String suggestSelection = searchableInfo.getSuggestSelection();
        if (suggestSelection != null) {
            strArr = new String[]{str};
        } else {
            fragment.appendPath(str);
        }
        String[] strArr2 = strArr;
        if (i10 > 0) {
            fragment.appendQueryParameter("limit", String.valueOf(i10));
        }
        return this.f١٥٧٩n.getContentResolver().query(fragment.build(), null, suggestSelection, strArr2, null);
    }

    public void x(int i10) {
        this.f١٥٨٣r = i10;
    }
}
