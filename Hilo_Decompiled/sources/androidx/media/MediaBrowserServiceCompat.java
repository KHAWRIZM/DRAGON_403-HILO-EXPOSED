package androidx.media;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.session.IMediaSession;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.os.ResultReceiver;
import android.text.TextUtils;
import android.util.Log;
import androidx.media.b;
import androidx.media.c;
import androidx.media.d;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class MediaBrowserServiceCompat extends Service {

    /* renamed from: f, reason: collision with root package name */
    static final boolean f٣٨٧٥f = Log.isLoggable("MBServiceCompat", 3);

    /* renamed from: a, reason: collision with root package name */
    private g f٣٨٧٦a;

    /* renamed from: c, reason: collision with root package name */
    f f٣٨٧٨c;

    /* renamed from: e, reason: collision with root package name */
    MediaSessionCompat.Token f٣٨٨٠e;

    /* renamed from: b, reason: collision with root package name */
    final androidx.collection.a f٣٨٧٧b = new androidx.collection.a();

    /* renamed from: d, reason: collision with root package name */
    final p f٣٨٧٩d = new p();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class a extends l {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ f f٣٨٨١f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f٣٨٨٢g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ Bundle f٣٨٨٣h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ Bundle f٣٨٨٤i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Object obj, f fVar, String str, Bundle bundle, Bundle bundle2) {
            super(obj);
            this.f٣٨٨١f = fVar;
            this.f٣٨٨٢g = str;
            this.f٣٨٨٣h = bundle;
            this.f٣٨٨٤i = bundle2;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.media.MediaBrowserServiceCompat.l
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public void d(List list) {
            if (MediaBrowserServiceCompat.this.f٣٨٧٧b.get(this.f٣٨٨١f.f٣٨٩٧f.asBinder()) != this.f٣٨٨١f) {
                if (MediaBrowserServiceCompat.f٣٨٧٥f) {
                    Log.d("MBServiceCompat", "Not sending onLoadChildren result for connection that has been disconnected. pkg=" + this.f٣٨٨١f.f٣٨٩٢a + " id=" + this.f٣٨٨٢g);
                    return;
                }
                return;
            }
            if ((a() & 1) != 0) {
                list = MediaBrowserServiceCompat.this.b(list, this.f٣٨٨٣h);
            }
            try {
                this.f٣٨٨١f.f٣٨٩٧f.a(this.f٣٨٨٢g, list, this.f٣٨٨٣h, this.f٣٨٨٤i);
            } catch (RemoteException unused) {
                Log.w("MBServiceCompat", "Calling onLoadChildren() failed for id=" + this.f٣٨٨٢g + " package=" + this.f٣٨٨١f.f٣٨٩٢a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class b extends l {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ResultReceiver f٣٨٨٦f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(Object obj, ResultReceiver resultReceiver) {
            super(obj);
            this.f٣٨٨٦f = resultReceiver;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.media.MediaBrowserServiceCompat.l
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public void d(MediaBrowserCompat.MediaItem mediaItem) {
            if ((a() & 2) != 0) {
                this.f٣٨٨٦f.send(-1, null);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putParcelable("media_item", mediaItem);
            this.f٣٨٨٦f.send(0, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class c extends l {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ResultReceiver f٣٨٨٨f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(Object obj, ResultReceiver resultReceiver) {
            super(obj);
            this.f٣٨٨٨f = resultReceiver;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.media.MediaBrowserServiceCompat.l
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public void d(List list) {
            if ((a() & 4) == 0 && list != null) {
                Bundle bundle = new Bundle();
                bundle.putParcelableArray("search_results", (Parcelable[]) list.toArray(new MediaBrowserCompat.MediaItem[0]));
                this.f٣٨٨٨f.send(0, bundle);
                return;
            }
            this.f٣٨٨٨f.send(-1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class d extends l {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ResultReceiver f٣٨٩٠f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(Object obj, ResultReceiver resultReceiver) {
            super(obj);
            this.f٣٨٩٠f = resultReceiver;
        }

        @Override // androidx.media.MediaBrowserServiceCompat.l
        void c(Bundle bundle) {
            this.f٣٨٩٠f.send(-1, bundle);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.media.MediaBrowserServiceCompat.l
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public void d(Bundle bundle) {
            this.f٣٨٩٠f.send(0, bundle);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static final class e {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class f implements IBinder.DeathRecipient {

        /* renamed from: a, reason: collision with root package name */
        public final String f٣٨٩٢a;

        /* renamed from: b, reason: collision with root package name */
        public final int f٣٨٩٣b;

        /* renamed from: c, reason: collision with root package name */
        public final int f٣٨٩٤c;

        /* renamed from: d, reason: collision with root package name */
        public final androidx.media.e f٣٨٩٥d;

        /* renamed from: e, reason: collision with root package name */
        public final Bundle f٣٨٩٦e;

        /* renamed from: f, reason: collision with root package name */
        public final n f٣٨٩٧f;

        /* renamed from: g, reason: collision with root package name */
        public final HashMap f٣٨٩٨g = new HashMap();

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                f fVar = f.this;
                MediaBrowserServiceCompat.this.f٣٨٧٧b.remove(fVar.f٣٨٩٧f.asBinder());
            }
        }

        f(String str, int i10, int i11, Bundle bundle, n nVar) {
            this.f٣٨٩٢a = str;
            this.f٣٨٩٣b = i10;
            this.f٣٨٩٤c = i11;
            this.f٣٨٩٥d = new androidx.media.e(str, i10, i11);
            this.f٣٨٩٦e = bundle;
            this.f٣٨٩٧f = nVar;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            MediaBrowserServiceCompat.this.f٣٨٧٩d.post(new a());
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    interface g {
        IBinder onBind(Intent intent);

        void onCreate();
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class h implements g, b.d {

        /* renamed from: a, reason: collision with root package name */
        final List f٣٩٠١a = new ArrayList();

        /* renamed from: b, reason: collision with root package name */
        Object f٣٩٠٢b;

        /* renamed from: c, reason: collision with root package name */
        Messenger f٣٩٠٣c;

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
        class a extends l {

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ b.c f٣٩٠٥f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(Object obj, b.c cVar) {
                super(obj);
                this.f٣٩٠٥f = cVar;
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.media.MediaBrowserServiceCompat.l
            /* renamed from: h, reason: merged with bridge method [inline-methods] */
            public void d(List list) {
                ArrayList arrayList;
                if (list != null) {
                    arrayList = new ArrayList();
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        MediaBrowserCompat.MediaItem mediaItem = (MediaBrowserCompat.MediaItem) it.next();
                        Parcel obtain = Parcel.obtain();
                        mediaItem.writeToParcel(obtain, 0);
                        arrayList.add(obtain);
                    }
                } else {
                    arrayList = null;
                }
                this.f٣٩٠٥f.b(arrayList);
            }
        }

        h() {
        }

        @Override // androidx.media.b.d
        public b.a c(String str, int i10, Bundle bundle) {
            IBinder asBinder;
            if (bundle != null && bundle.getInt("extra_client_version", 0) != 0) {
                bundle.remove("extra_client_version");
                this.f٣٩٠٣c = new Messenger(MediaBrowserServiceCompat.this.f٣٨٧٩d);
                Bundle bundle2 = new Bundle();
                bundle2.putInt("extra_service_version", 2);
                androidx.core.app.g.b(bundle2, "extra_messenger", this.f٣٩٠٣c.getBinder());
                MediaSessionCompat.Token token = MediaBrowserServiceCompat.this.f٣٨٨٠e;
                if (token != null) {
                    IMediaSession extraBinder = token.getExtraBinder();
                    if (extraBinder == null) {
                        asBinder = null;
                    } else {
                        asBinder = extraBinder.asBinder();
                    }
                    androidx.core.app.g.b(bundle2, "extra_session_binder", asBinder);
                } else {
                    this.f٣٩٠١a.add(bundle2);
                }
            }
            MediaBrowserServiceCompat mediaBrowserServiceCompat = MediaBrowserServiceCompat.this;
            mediaBrowserServiceCompat.f٣٨٧٨c = new f(str, -1, i10, bundle, null);
            MediaBrowserServiceCompat.this.e(str, i10, bundle);
            MediaBrowserServiceCompat.this.f٣٨٧٨c = null;
            return null;
        }

        @Override // androidx.media.b.d
        public void d(String str, b.c cVar) {
            MediaBrowserServiceCompat.this.f(str, new a(str, cVar));
        }

        @Override // androidx.media.MediaBrowserServiceCompat.g
        public IBinder onBind(Intent intent) {
            return androidx.media.b.b(this.f٣٩٠٢b, intent);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.g
        public void onCreate() {
            Object a10 = androidx.media.b.a(MediaBrowserServiceCompat.this, this);
            this.f٣٩٠٢b = a10;
            androidx.media.b.c(a10);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class i extends h implements c.b {

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
        class a extends l {

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ b.c f٣٩٠٨f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(Object obj, b.c cVar) {
                super(obj);
                this.f٣٩٠٨f = cVar;
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.media.MediaBrowserServiceCompat.l
            /* renamed from: h, reason: merged with bridge method [inline-methods] */
            public void d(MediaBrowserCompat.MediaItem mediaItem) {
                if (mediaItem == null) {
                    this.f٣٩٠٨f.b(null);
                    return;
                }
                Parcel obtain = Parcel.obtain();
                mediaItem.writeToParcel(obtain, 0);
                this.f٣٩٠٨f.b(obtain);
            }
        }

        i() {
            super();
        }

        @Override // androidx.media.c.b
        public void a(String str, b.c cVar) {
            MediaBrowserServiceCompat.this.h(str, new a(str, cVar));
        }

        @Override // androidx.media.MediaBrowserServiceCompat.h, androidx.media.MediaBrowserServiceCompat.g
        public void onCreate() {
            Object a10 = androidx.media.c.a(MediaBrowserServiceCompat.this, this);
            this.f٣٩٠٢b = a10;
            androidx.media.b.c(a10);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class j extends i implements d.c {

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
        class a extends l {

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ d.b f٣٩١١f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(Object obj, d.b bVar) {
                super(obj);
                this.f٣٩١١f = bVar;
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.media.MediaBrowserServiceCompat.l
            /* renamed from: h, reason: merged with bridge method [inline-methods] */
            public void d(List list) {
                ArrayList arrayList;
                if (list != null) {
                    arrayList = new ArrayList();
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        MediaBrowserCompat.MediaItem mediaItem = (MediaBrowserCompat.MediaItem) it.next();
                        Parcel obtain = Parcel.obtain();
                        mediaItem.writeToParcel(obtain, 0);
                        arrayList.add(obtain);
                    }
                } else {
                    arrayList = null;
                }
                this.f٣٩١١f.b(arrayList, a());
            }
        }

        j() {
            super();
        }

        @Override // androidx.media.d.c
        public void b(String str, d.b bVar, Bundle bundle) {
            MediaBrowserServiceCompat.this.g(str, new a(str, bVar), bundle);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.i, androidx.media.MediaBrowserServiceCompat.h, androidx.media.MediaBrowserServiceCompat.g
        public void onCreate() {
            Object a10 = androidx.media.d.a(MediaBrowserServiceCompat.this, this);
            this.f٣٩٠٢b = a10;
            androidx.media.b.c(a10);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class k extends j {
        k() {
            super();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class l {

        /* renamed from: a, reason: collision with root package name */
        private final Object f٣٩١٤a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f٣٩١٥b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f٣٩١٦c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f٣٩١٧d;

        /* renamed from: e, reason: collision with root package name */
        private int f٣٩١٨e;

        l(Object obj) {
            this.f٣٩١٤a = obj;
        }

        int a() {
            return this.f٣٩١٨e;
        }

        boolean b() {
            if (!this.f٣٩١٥b && !this.f٣٩١٦c && !this.f٣٩١٧d) {
                return false;
            }
            return true;
        }

        void c(Bundle bundle) {
            throw new UnsupportedOperationException("It is not supported to send an error for " + this.f٣٩١٤a);
        }

        abstract void d(Object obj);

        public void e(Bundle bundle) {
            if (!this.f٣٩١٦c && !this.f٣٩١٧d) {
                this.f٣٩١٧d = true;
                c(bundle);
            } else {
                throw new IllegalStateException("sendError() called when either sendResult() or sendError() had already been called for: " + this.f٣٩١٤a);
            }
        }

        public void f(Object obj) {
            if (!this.f٣٩١٦c && !this.f٣٩١٧d) {
                this.f٣٩١٦c = true;
                d(obj);
            } else {
                throw new IllegalStateException("sendResult() called when either sendResult() or sendError() had already been called for: " + this.f٣٩١٤a);
            }
        }

        void g(int i10) {
            this.f٣٩١٨e = i10;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    private class m {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
        public class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ n f٣٩٢٠a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f٣٩٢١b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ int f٣٩٢٢c;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ int f٣٩٢٣d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ Bundle f٣٩٢٤e;

            a(n nVar, String str, int i10, int i11, Bundle bundle) {
                this.f٣٩٢٠a = nVar;
                this.f٣٩٢١b = str;
                this.f٣٩٢٢c = i10;
                this.f٣٩٢٣d = i11;
                this.f٣٩٢٤e = bundle;
            }

            @Override // java.lang.Runnable
            public void run() {
                MediaBrowserServiceCompat.this.f٣٨٧٧b.remove(this.f٣٩٢٠a.asBinder());
                f fVar = new f(this.f٣٩٢١b, this.f٣٩٢٢c, this.f٣٩٢٣d, this.f٣٩٢٤e, this.f٣٩٢٠a);
                MediaBrowserServiceCompat mediaBrowserServiceCompat = MediaBrowserServiceCompat.this;
                mediaBrowserServiceCompat.f٣٨٧٨c = fVar;
                mediaBrowserServiceCompat.e(this.f٣٩٢١b, this.f٣٩٢٣d, this.f٣٩٢٤e);
                MediaBrowserServiceCompat.this.f٣٨٧٨c = null;
                Log.i("MBServiceCompat", "No root for client " + this.f٣٩٢١b + " from service " + getClass().getName());
                try {
                    this.f٣٩٢٠a.b();
                } catch (RemoteException unused) {
                    Log.w("MBServiceCompat", "Calling onConnectFailed() failed. Ignoring. pkg=" + this.f٣٩٢١b);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
        public class b implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ n f٣٩٢٦a;

            b(n nVar) {
                this.f٣٩٢٦a = nVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                f fVar = (f) MediaBrowserServiceCompat.this.f٣٨٧٧b.remove(this.f٣٩٢٦a.asBinder());
                if (fVar != null) {
                    fVar.f٣٨٩٧f.asBinder().unlinkToDeath(fVar, 0);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
        public class c implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ n f٣٩٢٨a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f٣٩٢٩b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ IBinder f٣٩٣٠c;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ Bundle f٣٩٣١d;

            c(n nVar, String str, IBinder iBinder, Bundle bundle) {
                this.f٣٩٢٨a = nVar;
                this.f٣٩٢٩b = str;
                this.f٣٩٣٠c = iBinder;
                this.f٣٩٣١d = bundle;
            }

            @Override // java.lang.Runnable
            public void run() {
                f fVar = (f) MediaBrowserServiceCompat.this.f٣٨٧٧b.get(this.f٣٩٢٨a.asBinder());
                if (fVar == null) {
                    Log.w("MBServiceCompat", "addSubscription for callback that isn't registered id=" + this.f٣٩٢٩b);
                    return;
                }
                MediaBrowserServiceCompat.this.a(this.f٣٩٢٩b, fVar, this.f٣٩٣٠c, this.f٣٩٣١d);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
        public class d implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ n f٣٩٣٣a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f٣٩٣٤b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ IBinder f٣٩٣٥c;

            d(n nVar, String str, IBinder iBinder) {
                this.f٣٩٣٣a = nVar;
                this.f٣٩٣٤b = str;
                this.f٣٩٣٥c = iBinder;
            }

            @Override // java.lang.Runnable
            public void run() {
                f fVar = (f) MediaBrowserServiceCompat.this.f٣٨٧٧b.get(this.f٣٩٣٣a.asBinder());
                if (fVar == null) {
                    Log.w("MBServiceCompat", "removeSubscription for callback that isn't registered id=" + this.f٣٩٣٤b);
                    return;
                }
                if (!MediaBrowserServiceCompat.this.p(this.f٣٩٣٤b, fVar, this.f٣٩٣٥c)) {
                    Log.w("MBServiceCompat", "removeSubscription called for " + this.f٣٩٣٤b + " which is not subscribed");
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
        public class e implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ n f٣٩٣٧a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f٣٩٣٨b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ ResultReceiver f٣٩٣٩c;

            e(n nVar, String str, ResultReceiver resultReceiver) {
                this.f٣٩٣٧a = nVar;
                this.f٣٩٣٨b = str;
                this.f٣٩٣٩c = resultReceiver;
            }

            @Override // java.lang.Runnable
            public void run() {
                f fVar = (f) MediaBrowserServiceCompat.this.f٣٨٧٧b.get(this.f٣٩٣٧a.asBinder());
                if (fVar == null) {
                    Log.w("MBServiceCompat", "getMediaItem for callback that isn't registered id=" + this.f٣٩٣٨b);
                    return;
                }
                MediaBrowserServiceCompat.this.n(this.f٣٩٣٨b, fVar, this.f٣٩٣٩c);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
        public class f implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ n f٣٩٤١a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f٣٩٤٢b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ int f٣٩٤٣c;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ int f٣٩٤٤d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ Bundle f٣٩٤٥e;

            f(n nVar, String str, int i10, int i11, Bundle bundle) {
                this.f٣٩٤١a = nVar;
                this.f٣٩٤٢b = str;
                this.f٣٩٤٣c = i10;
                this.f٣٩٤٤d = i11;
                this.f٣٩٤٥e = bundle;
            }

            @Override // java.lang.Runnable
            public void run() {
                IBinder asBinder = this.f٣٩٤١a.asBinder();
                MediaBrowserServiceCompat.this.f٣٨٧٧b.remove(asBinder);
                f fVar = new f(this.f٣٩٤٢b, this.f٣٩٤٣c, this.f٣٩٤٤d, this.f٣٩٤٥e, this.f٣٩٤١a);
                MediaBrowserServiceCompat.this.f٣٨٧٧b.put(asBinder, fVar);
                try {
                    asBinder.linkToDeath(fVar, 0);
                } catch (RemoteException unused) {
                    Log.w("MBServiceCompat", "IBinder is already dead.");
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
        public class g implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ n f٣٩٤٧a;

            g(n nVar) {
                this.f٣٩٤٧a = nVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                IBinder asBinder = this.f٣٩٤٧a.asBinder();
                f fVar = (f) MediaBrowserServiceCompat.this.f٣٨٧٧b.remove(asBinder);
                if (fVar != null) {
                    asBinder.unlinkToDeath(fVar, 0);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
        public class h implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ n f٣٩٤٩a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f٣٩٥٠b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ Bundle f٣٩٥١c;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ ResultReceiver f٣٩٥٢d;

            h(n nVar, String str, Bundle bundle, ResultReceiver resultReceiver) {
                this.f٣٩٤٩a = nVar;
                this.f٣٩٥٠b = str;
                this.f٣٩٥١c = bundle;
                this.f٣٩٥٢d = resultReceiver;
            }

            @Override // java.lang.Runnable
            public void run() {
                f fVar = (f) MediaBrowserServiceCompat.this.f٣٨٧٧b.get(this.f٣٩٤٩a.asBinder());
                if (fVar == null) {
                    Log.w("MBServiceCompat", "search for callback that isn't registered query=" + this.f٣٩٥٠b);
                    return;
                }
                MediaBrowserServiceCompat.this.o(this.f٣٩٥٠b, this.f٣٩٥١c, fVar, this.f٣٩٥٢d);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
        public class i implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ n f٣٩٥٤a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f٣٩٥٥b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ Bundle f٣٩٥٦c;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ ResultReceiver f٣٩٥٧d;

            i(n nVar, String str, Bundle bundle, ResultReceiver resultReceiver) {
                this.f٣٩٥٤a = nVar;
                this.f٣٩٥٥b = str;
                this.f٣٩٥٦c = bundle;
                this.f٣٩٥٧d = resultReceiver;
            }

            @Override // java.lang.Runnable
            public void run() {
                f fVar = (f) MediaBrowserServiceCompat.this.f٣٨٧٧b.get(this.f٣٩٥٤a.asBinder());
                if (fVar == null) {
                    Log.w("MBServiceCompat", "sendCustomAction for callback that isn't registered action=" + this.f٣٩٥٥b + ", extras=" + this.f٣٩٥٦c);
                    return;
                }
                MediaBrowserServiceCompat.this.l(this.f٣٩٥٥b, this.f٣٩٥٦c, fVar, this.f٣٩٥٧d);
            }
        }

        m() {
        }

        public void a(String str, IBinder iBinder, Bundle bundle, n nVar) {
            MediaBrowserServiceCompat.this.f٣٨٧٩d.a(new c(nVar, str, iBinder, bundle));
        }

        public void b(String str, int i10, int i11, Bundle bundle, n nVar) {
            if (MediaBrowserServiceCompat.this.c(str, i11)) {
                MediaBrowserServiceCompat.this.f٣٨٧٩d.a(new a(nVar, str, i10, i11, bundle));
                return;
            }
            throw new IllegalArgumentException("Package/uid mismatch: uid=" + i11 + " package=" + str);
        }

        public void c(n nVar) {
            MediaBrowserServiceCompat.this.f٣٨٧٩d.a(new b(nVar));
        }

        public void d(String str, ResultReceiver resultReceiver, n nVar) {
            if (!TextUtils.isEmpty(str) && resultReceiver != null) {
                MediaBrowserServiceCompat.this.f٣٨٧٩d.a(new e(nVar, str, resultReceiver));
            }
        }

        public void e(n nVar, String str, int i10, int i11, Bundle bundle) {
            MediaBrowserServiceCompat.this.f٣٨٧٩d.a(new f(nVar, str, i10, i11, bundle));
        }

        public void f(String str, IBinder iBinder, n nVar) {
            MediaBrowserServiceCompat.this.f٣٨٧٩d.a(new d(nVar, str, iBinder));
        }

        public void g(String str, Bundle bundle, ResultReceiver resultReceiver, n nVar) {
            if (!TextUtils.isEmpty(str) && resultReceiver != null) {
                MediaBrowserServiceCompat.this.f٣٨٧٩d.a(new h(nVar, str, bundle, resultReceiver));
            }
        }

        public void h(String str, Bundle bundle, ResultReceiver resultReceiver, n nVar) {
            if (!TextUtils.isEmpty(str) && resultReceiver != null) {
                MediaBrowserServiceCompat.this.f٣٨٧٩d.a(new i(nVar, str, bundle, resultReceiver));
            }
        }

        public void i(n nVar) {
            MediaBrowserServiceCompat.this.f٣٨٧٩d.a(new g(nVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public interface n {
        void a(String str, List list, Bundle bundle, Bundle bundle2);

        IBinder asBinder();

        void b();
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    private static class o implements n {

        /* renamed from: a, reason: collision with root package name */
        final Messenger f٣٩٥٩a;

        o(Messenger messenger) {
            this.f٣٩٥٩a = messenger;
        }

        private void c(int i10, Bundle bundle) {
            Message obtain = Message.obtain();
            obtain.what = i10;
            obtain.arg1 = 2;
            obtain.setData(bundle);
            this.f٣٩٥٩a.send(obtain);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.n
        public void a(String str, List list, Bundle bundle, Bundle bundle2) {
            ArrayList<? extends Parcelable> arrayList;
            Bundle bundle3 = new Bundle();
            bundle3.putString("data_media_item_id", str);
            bundle3.putBundle("data_options", bundle);
            bundle3.putBundle("data_notify_children_changed_options", bundle2);
            if (list != null) {
                if (list instanceof ArrayList) {
                    arrayList = (ArrayList) list;
                } else {
                    arrayList = new ArrayList<>(list);
                }
                bundle3.putParcelableArrayList("data_media_item_list", arrayList);
            }
            c(3, bundle3);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.n
        public IBinder asBinder() {
            return this.f٣٩٥٩a.getBinder();
        }

        @Override // androidx.media.MediaBrowserServiceCompat.n
        public void b() {
            c(2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public final class p extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private final m f٣٩٦٠a;

        p() {
            this.f٣٩٦٠a = new m();
        }

        public void a(Runnable runnable) {
            if (Thread.currentThread() == getLooper().getThread()) {
                runnable.run();
            } else {
                post(runnable);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Bundle data = message.getData();
            switch (message.what) {
                case 1:
                    Bundle bundle = data.getBundle("data_root_hints");
                    MediaSessionCompat.ensureClassLoader(bundle);
                    this.f٣٩٦٠a.b(data.getString("data_package_name"), data.getInt("data_calling_pid"), data.getInt("data_calling_uid"), bundle, new o(message.replyTo));
                    return;
                case 2:
                    this.f٣٩٦٠a.c(new o(message.replyTo));
                    return;
                case 3:
                    Bundle bundle2 = data.getBundle("data_options");
                    MediaSessionCompat.ensureClassLoader(bundle2);
                    this.f٣٩٦٠a.a(data.getString("data_media_item_id"), androidx.core.app.g.a(data, "data_callback_token"), bundle2, new o(message.replyTo));
                    return;
                case 4:
                    this.f٣٩٦٠a.f(data.getString("data_media_item_id"), androidx.core.app.g.a(data, "data_callback_token"), new o(message.replyTo));
                    return;
                case 5:
                    this.f٣٩٦٠a.d(data.getString("data_media_item_id"), (ResultReceiver) data.getParcelable("data_result_receiver"), new o(message.replyTo));
                    return;
                case 6:
                    Bundle bundle3 = data.getBundle("data_root_hints");
                    MediaSessionCompat.ensureClassLoader(bundle3);
                    this.f٣٩٦٠a.e(new o(message.replyTo), data.getString("data_package_name"), data.getInt("data_calling_pid"), data.getInt("data_calling_uid"), bundle3);
                    return;
                case 7:
                    this.f٣٩٦٠a.i(new o(message.replyTo));
                    return;
                case 8:
                    Bundle bundle4 = data.getBundle("data_search_extras");
                    MediaSessionCompat.ensureClassLoader(bundle4);
                    this.f٣٩٦٠a.g(data.getString("data_search_query"), bundle4, (ResultReceiver) data.getParcelable("data_result_receiver"), new o(message.replyTo));
                    return;
                case 9:
                    Bundle bundle5 = data.getBundle("data_custom_action_extras");
                    MediaSessionCompat.ensureClassLoader(bundle5);
                    this.f٣٩٦٠a.h(data.getString("data_custom_action"), bundle5, (ResultReceiver) data.getParcelable("data_result_receiver"), new o(message.replyTo));
                    return;
                default:
                    Log.w("MBServiceCompat", "Unhandled message: " + message + "\n  Service version: 2\n  Client version: " + message.arg1);
                    return;
            }
        }

        @Override // android.os.Handler
        public boolean sendMessageAtTime(Message message, long j10) {
            Bundle data = message.getData();
            data.setClassLoader(MediaBrowserCompat.class.getClassLoader());
            data.putInt("data_calling_uid", Binder.getCallingUid());
            data.putInt("data_calling_pid", Binder.getCallingPid());
            return super.sendMessageAtTime(message, j10);
        }
    }

    void a(String str, f fVar, IBinder iBinder, Bundle bundle) {
        List<androidx.core.util.g> list = (List) fVar.f٣٨٩٨g.get(str);
        if (list == null) {
            list = new ArrayList();
        }
        for (androidx.core.util.g gVar : list) {
            if (iBinder == gVar.f٢٨٨٨a && androidx.media.a.a(bundle, (Bundle) gVar.f٢٨٨٩b)) {
                return;
            }
        }
        list.add(new androidx.core.util.g(iBinder, bundle));
        fVar.f٣٨٩٨g.put(str, list);
        m(str, fVar, bundle, null);
        this.f٣٨٧٨c = fVar;
        j(str, bundle);
        this.f٣٨٧٨c = null;
    }

    List b(List list, Bundle bundle) {
        if (list == null) {
            return null;
        }
        int i10 = bundle.getInt(MediaBrowserCompat.EXTRA_PAGE, -1);
        int i11 = bundle.getInt(MediaBrowserCompat.EXTRA_PAGE_SIZE, -1);
        if (i10 == -1 && i11 == -1) {
            return list;
        }
        int i12 = i11 * i10;
        int i13 = i12 + i11;
        if (i10 >= 0 && i11 >= 1 && i12 < list.size()) {
            if (i13 > list.size()) {
                i13 = list.size();
            }
            return list.subList(i12, i13);
        }
        return Collections.emptyList();
    }

    boolean c(String str, int i10) {
        if (str == null) {
            return false;
        }
        for (String str2 : getPackageManager().getPackagesForUid(i10)) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public void d(String str, Bundle bundle, l lVar) {
        lVar.e(null);
    }

    @Override // android.app.Service
    public void dump(FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    public abstract e e(String str, int i10, Bundle bundle);

    public abstract void f(String str, l lVar);

    public void g(String str, l lVar, Bundle bundle) {
        lVar.g(1);
        f(str, lVar);
    }

    public void h(String str, l lVar) {
        lVar.g(2);
        lVar.f(null);
    }

    public void i(String str, Bundle bundle, l lVar) {
        lVar.g(4);
        lVar.f(null);
    }

    public void j(String str, Bundle bundle) {
    }

    public void k(String str) {
    }

    void l(String str, Bundle bundle, f fVar, ResultReceiver resultReceiver) {
        d dVar = new d(str, resultReceiver);
        this.f٣٨٧٨c = fVar;
        d(str, bundle, dVar);
        this.f٣٨٧٨c = null;
        if (dVar.b()) {
            return;
        }
        throw new IllegalStateException("onCustomAction must call detach() or sendResult() or sendError() before returning for action=" + str + " extras=" + bundle);
    }

    void m(String str, f fVar, Bundle bundle, Bundle bundle2) {
        a aVar = new a(str, fVar, str, bundle, bundle2);
        this.f٣٨٧٨c = fVar;
        if (bundle == null) {
            f(str, aVar);
        } else {
            g(str, aVar, bundle);
        }
        this.f٣٨٧٨c = null;
        if (aVar.b()) {
            return;
        }
        throw new IllegalStateException("onLoadChildren must call detach() or sendResult() before returning for package=" + fVar.f٣٨٩٢a + " id=" + str);
    }

    void n(String str, f fVar, ResultReceiver resultReceiver) {
        b bVar = new b(str, resultReceiver);
        this.f٣٨٧٨c = fVar;
        h(str, bVar);
        this.f٣٨٧٨c = null;
        if (bVar.b()) {
            return;
        }
        throw new IllegalStateException("onLoadItem must call detach() or sendResult() before returning for id=" + str);
    }

    void o(String str, Bundle bundle, f fVar, ResultReceiver resultReceiver) {
        c cVar = new c(str, resultReceiver);
        this.f٣٨٧٨c = fVar;
        i(str, bundle, cVar);
        this.f٣٨٧٨c = null;
        if (cVar.b()) {
            return;
        }
        throw new IllegalStateException("onSearch must call detach() or sendResult() before returning for query=" + str);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.f٣٨٧٦a.onBind(intent);
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 28) {
            this.f٣٨٧٦a = new k();
        } else if (i10 >= 26) {
            this.f٣٨٧٦a = new j();
        } else if (i10 >= 23) {
            this.f٣٨٧٦a = new i();
        } else {
            this.f٣٨٧٦a = new h();
        }
        this.f٣٨٧٦a.onCreate();
    }

    boolean p(String str, f fVar, IBinder iBinder) {
        boolean z10 = false;
        try {
            if (iBinder == null) {
                if (fVar.f٣٨٩٨g.remove(str) != null) {
                    z10 = true;
                }
            } else {
                List list = (List) fVar.f٣٨٩٨g.get(str);
                if (list != null) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        if (iBinder == ((androidx.core.util.g) it.next()).f٢٨٨٨a) {
                            it.remove();
                            z10 = true;
                        }
                    }
                    if (list.size() == 0) {
                        fVar.f٣٨٩٨g.remove(str);
                    }
                }
            }
            return z10;
        } finally {
            this.f٣٨٧٨c = fVar;
            k(str);
            this.f٣٨٧٨c = null;
        }
    }
}
