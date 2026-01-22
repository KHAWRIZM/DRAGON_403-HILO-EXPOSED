package com.bumptech.glide;

import android.app.Activity;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.util.Log;
import android.view.View;
import androidx.annotation.GuardedBy;
import androidx.annotation.VisibleForTesting;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import f5.l;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import s4.d;
import v4.u;
import v4.z;
import z4.o;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class Glide implements ComponentCallbacks2 {
    private static final String DEFAULT_DISK_CACHE_DIR = "image_manager_disk_cache";
    private static final String DESTROYED_ACTIVITY_WARNING = "You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).";
    private static final String TAG = "Glide";

    @GuardedBy("Glide.class")
    private static volatile Glide glide;
    private static volatile boolean isInitializing;
    private final p4.b arrayPool;
    private final p4.d bitmapPool;

    @GuardedBy("this")
    private s4.b bitmapPreFiller;
    private final z4.c connectivityMonitorFactory;
    private final a defaultRequestOptionsFactory;
    private final o4.k engine;
    private final c glideContext;
    private final q4.h memoryCache;
    private final o requestManagerRetriever;

    @GuardedBy("managers")
    private final List<j> managers = new ArrayList();
    private e memoryCategory = e.NORMAL;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public interface a {
        c5.h build();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Glide(Context context, o4.k kVar, q4.h hVar, p4.d dVar, p4.b bVar, o oVar, z4.c cVar, int i10, a aVar, Map<Class<?>, k> map, List<c5.g> list, List<a5.b> list2, a5.a aVar2, d dVar2) {
        this.engine = kVar;
        this.bitmapPool = dVar;
        this.arrayPool = bVar;
        this.memoryCache = hVar;
        this.requestManagerRetriever = oVar;
        this.connectivityMonitorFactory = cVar;
        this.defaultRequestOptionsFactory = aVar;
        this.glideContext = new c(context, bVar, h.d(this, list2, aVar2), new com.bumptech.glide.request.target.g(), aVar, map, list, kVar, dVar2, i10);
    }

    @GuardedBy("Glide.class")
    @VisibleForTesting
    static void checkAndInitializeGlide(Context context, GeneratedAppGlideModule generatedAppGlideModule) {
        if (!isInitializing) {
            isInitializing = true;
            try {
                initializeGlide(context, generatedAppGlideModule);
                return;
            } finally {
                isInitializing = false;
            }
        }
        throw new IllegalStateException("Glide has been called recursively, this is probably an internal library error!");
    }

    @VisibleForTesting
    public static void enableHardwareBitmaps() {
        z.b().h();
    }

    public static Glide get(Context context) {
        if (glide == null) {
            GeneratedAppGlideModule annotationGeneratedGlideModules = getAnnotationGeneratedGlideModules(context.getApplicationContext());
            synchronized (Glide.class) {
                try {
                    if (glide == null) {
                        checkAndInitializeGlide(context, annotationGeneratedGlideModules);
                    }
                } finally {
                }
            }
        }
        return glide;
    }

    private static GeneratedAppGlideModule getAnnotationGeneratedGlideModules(Context context) {
        try {
            return (GeneratedAppGlideModule) Class.forName("com.bumptech.glide.GeneratedAppGlideModuleImpl").getDeclaredConstructor(Context.class).newInstance(context.getApplicationContext());
        } catch (ClassNotFoundException unused) {
            if (Log.isLoggable(TAG, 5)) {
                Log.w(TAG, "Failed to find GeneratedAppGlideModule. You should include an annotationProcessor compile dependency on com.github.bumptech.glide:compiler in your application and a @GlideModule annotated AppGlideModule implementation or LibraryGlideModules will be silently ignored");
            }
            return null;
        } catch (IllegalAccessException e10) {
            throwIncorrectGlideModule(e10);
            return null;
        } catch (InstantiationException e11) {
            throwIncorrectGlideModule(e11);
            return null;
        } catch (NoSuchMethodException e12) {
            throwIncorrectGlideModule(e12);
            return null;
        } catch (InvocationTargetException e13) {
            throwIncorrectGlideModule(e13);
            return null;
        }
    }

    public static File getPhotoCacheDir(Context context) {
        return getPhotoCacheDir(context, DEFAULT_DISK_CACHE_DIR);
    }

    private static o getRetriever(Context context) {
        f5.k.e(context, DESTROYED_ACTIVITY_WARNING);
        return get(context).getRequestManagerRetriever();
    }

    @VisibleForTesting
    @Deprecated
    public static synchronized void init(Glide glide2) {
        synchronized (Glide.class) {
            try {
                if (glide != null) {
                    tearDown();
                }
                glide = glide2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @GuardedBy("Glide.class")
    private static void initializeGlide(Context context, GeneratedAppGlideModule generatedAppGlideModule) {
        initializeGlide(context, new b(), generatedAppGlideModule);
    }

    @VisibleForTesting
    public static synchronized boolean isInitialized() {
        boolean z10;
        synchronized (Glide.class) {
            if (glide != null) {
                z10 = true;
            } else {
                z10 = false;
            }
        }
        return z10;
    }

    @VisibleForTesting
    public static void tearDown() {
        synchronized (Glide.class) {
            try {
                if (glide != null) {
                    glide.getContext().getApplicationContext().unregisterComponentCallbacks(glide);
                    glide.engine.m();
                }
                glide = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static void throwIncorrectGlideModule(Exception exc) {
        throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", exc);
    }

    public static j with(Context context) {
        return getRetriever(context).f(context);
    }

    public void clearDiskCache() {
        l.a();
        this.engine.e();
    }

    public void clearMemory() {
        l.b();
        this.memoryCache.b();
        this.bitmapPool.b();
        this.arrayPool.b();
    }

    public p4.b getArrayPool() {
        return this.arrayPool;
    }

    public p4.d getBitmapPool() {
        return this.bitmapPool;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public z4.c getConnectivityMonitorFactory() {
        return this.connectivityMonitorFactory;
    }

    public Context getContext() {
        return this.glideContext.getBaseContext();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c getGlideContext() {
        return this.glideContext;
    }

    public g getRegistry() {
        return this.glideContext.i();
    }

    public o getRequestManagerRetriever() {
        return this.requestManagerRetriever;
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        clearMemory();
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i10) {
        trimMemory(i10);
    }

    public synchronized void preFillBitmapPool(d.a... aVarArr) {
        try {
            if (this.bitmapPreFiller == null) {
                this.bitmapPreFiller = new s4.b(this.memoryCache, this.bitmapPool, (m4.b) this.defaultRequestOptionsFactory.build().r().a(u.f١٨٥٤٦f));
            }
            this.bitmapPreFiller.b(aVarArr);
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void registerRequestManager(j jVar) {
        synchronized (this.managers) {
            try {
                if (!this.managers.contains(jVar)) {
                    this.managers.add(jVar);
                } else {
                    throw new IllegalStateException("Cannot register already registered manager");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean removeFromManagers(com.bumptech.glide.request.target.j jVar) {
        synchronized (this.managers) {
            try {
                Iterator<j> it = this.managers.iterator();
                while (it.hasNext()) {
                    if (it.next().x(jVar)) {
                        return true;
                    }
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public e setMemoryCategory(e eVar) {
        l.b();
        this.memoryCache.c(eVar.c());
        this.bitmapPool.c(eVar.c());
        e eVar2 = this.memoryCategory;
        this.memoryCategory = eVar;
        return eVar2;
    }

    public void trimMemory(int i10) {
        l.b();
        synchronized (this.managers) {
            try {
                Iterator<j> it = this.managers.iterator();
                while (it.hasNext()) {
                    it.next().onTrimMemory(i10);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.memoryCache.a(i10);
        this.bitmapPool.a(i10);
        this.arrayPool.a(i10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void unregisterRequestManager(j jVar) {
        synchronized (this.managers) {
            try {
                if (this.managers.contains(jVar)) {
                    this.managers.remove(jVar);
                } else {
                    throw new IllegalStateException("Cannot unregister not yet registered manager");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static File getPhotoCacheDir(Context context, String str) {
        File cacheDir = context.getCacheDir();
        if (cacheDir != null) {
            File file = new File(cacheDir, str);
            if (file.isDirectory() || file.mkdirs()) {
                return file;
            }
            return null;
        }
        if (Log.isLoggable(TAG, 6)) {
            Log.e(TAG, "default disk cache dir is null");
        }
        return null;
    }

    @GuardedBy("Glide.class")
    private static void initializeGlide(Context context, b bVar, GeneratedAppGlideModule generatedAppGlideModule) {
        Context applicationContext = context.getApplicationContext();
        List emptyList = Collections.emptyList();
        if (generatedAppGlideModule == null || generatedAppGlideModule.b()) {
            emptyList = new a5.d(applicationContext).b();
        }
        if (generatedAppGlideModule != null && !generatedAppGlideModule.c().isEmpty()) {
            Set c10 = generatedAppGlideModule.c();
            Iterator it = emptyList.iterator();
            while (it.hasNext()) {
                a5.b bVar2 = (a5.b) it.next();
                if (c10.contains(bVar2.getClass())) {
                    if (Log.isLoggable(TAG, 3)) {
                        Log.d(TAG, "AppGlideModule excludes manifest GlideModule: " + bVar2);
                    }
                    it.remove();
                }
            }
        }
        if (Log.isLoggable(TAG, 3)) {
            Iterator it2 = emptyList.iterator();
            while (it2.hasNext()) {
                Log.d(TAG, "Discovered GlideModule from manifest: " + ((a5.b) it2.next()).getClass());
            }
        }
        bVar.b(generatedAppGlideModule != null ? generatedAppGlideModule.d() : null);
        Iterator it3 = emptyList.iterator();
        while (it3.hasNext()) {
            ((a5.b) it3.next()).applyOptions(applicationContext, bVar);
        }
        if (generatedAppGlideModule != null) {
            generatedAppGlideModule.a(applicationContext, bVar);
        }
        Glide a10 = bVar.a(applicationContext, emptyList, generatedAppGlideModule);
        applicationContext.registerComponentCallbacks(a10);
        glide = a10;
    }

    @Deprecated
    public static j with(Activity activity) {
        return with(activity.getApplicationContext());
    }

    public static j with(FragmentActivity fragmentActivity) {
        return getRetriever(fragmentActivity).i(fragmentActivity);
    }

    public static j with(Fragment fragment) {
        return getRetriever(fragment.getContext()).h(fragment);
    }

    @VisibleForTesting
    public static void init(Context context, b bVar) {
        GeneratedAppGlideModule annotationGeneratedGlideModules = getAnnotationGeneratedGlideModules(context);
        synchronized (Glide.class) {
            try {
                if (glide != null) {
                    tearDown();
                }
                initializeGlide(context, bVar, annotationGeneratedGlideModules);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Deprecated
    public static j with(android.app.Fragment fragment) {
        Activity activity = fragment.getActivity();
        f5.k.e(activity, DESTROYED_ACTIVITY_WARNING);
        return with(activity.getApplicationContext());
    }

    public static j with(View view) {
        return getRetriever(view.getContext()).g(view);
    }
}
