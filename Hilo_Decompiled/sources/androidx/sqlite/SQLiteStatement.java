package androidx.sqlite;

import androidx.annotation.IntRange;
import com.google.android.gms.appinvite.PreviewActivity;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010 \n\u0002\b\u0006\bf\u0018\u00002\u00060\u0001j\u0002`\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&J\u001a\u0010\t\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\nH&J\u001a\u0010\u000b\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\fH\u0016J\u001a\u0010\r\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u000eH&J\u001a\u0010\u000f\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u001a\u0010\u0010\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0011H\u0016J\u001a\u0010\u0012\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0013H&J\u0012\u0010\u0014\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u0006H&J\u0012\u0010\u0015\u001a\u00020\b2\b\b\u0001\u0010\u0005\u001a\u00020\u0006H&J\u0012\u0010\u0016\u001a\u00020\n2\b\b\u0001\u0010\u0005\u001a\u00020\u0006H&J\u0012\u0010\u0017\u001a\u00020\f2\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u0016J\u0012\u0010\u0018\u001a\u00020\u000e2\b\b\u0001\u0010\u0005\u001a\u00020\u0006H&J\u0012\u0010\u0019\u001a\u00020\u00062\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u0016J\u0012\u0010\u001a\u001a\u00020\u00112\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u0016J\u0012\u0010\u001b\u001a\u00020\u00132\b\b\u0001\u0010\u0005\u001a\u00020\u0006H&J\u0012\u0010\u001c\u001a\u00020\u00112\b\b\u0001\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u001d\u001a\u00020\u0006H&J\u0012\u0010\u001e\u001a\u00020\u00132\b\b\u0001\u0010\u0005\u001a\u00020\u0006H&J\u000e\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00130 H\u0016J\u0012\u0010!\u001a\u00020\u00062\b\b\u0001\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\"\u001a\u00020\u0011H&J\b\u0010#\u001a\u00020\u0004H&J\b\u0010$\u001a\u00020\u0004H&J\b\u0010%\u001a\u00020\u0004H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006&À\u0006\u0001"}, d2 = {"Landroidx/sqlite/SQLiteStatement;", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "bindBlob", "", FirebaseAnalytics.Param.INDEX, "", "value", "", "bindDouble", "", "bindFloat", "", "bindLong", "", "bindInt", "bindBoolean", "", "bindText", "", "bindNull", "getBlob", "getDouble", "getFloat", "getLong", "getInt", "getBoolean", "getText", "isNull", "getColumnCount", "getColumnName", "getColumnNames", "", "getColumnType", "step", "reset", "clearBindings", PreviewActivity.ON_CLICK_LISTENER_CLOSE, "sqlite_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSQLiteStatement.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SQLiteStatement.kt\nandroidx/sqlite/SQLiteStatement\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,233:1\n1#2:234\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public interface SQLiteStatement extends AutoCloseable {
    /* renamed from: bindBlob, reason: contains not printable characters */
    void mo٢٤٢bindBlob(@IntRange(from = 1) int index, @NotNull byte[] value);

    void bindBoolean(@IntRange(from = 1) int index, boolean value);

    /* renamed from: bindDouble, reason: contains not printable characters */
    void mo٢٤٣bindDouble(@IntRange(from = 1) int index, double value);

    void bindFloat(@IntRange(from = 1) int index, float value);

    void bindInt(@IntRange(from = 1) int index, int value);

    /* renamed from: bindLong, reason: contains not printable characters */
    void mo٢٤٤bindLong(@IntRange(from = 1) int index, long value);

    /* renamed from: bindNull, reason: contains not printable characters */
    void mo٢٤٥bindNull(@IntRange(from = 1) int index);

    /* renamed from: bindText, reason: contains not printable characters */
    void mo٢٤٦bindText(@IntRange(from = 1) int index, @NotNull String value);

    /* renamed from: clearBindings, reason: contains not printable characters */
    void mo٢٤٧clearBindings();

    @Override // java.lang.AutoCloseable
    void close();

    @NotNull
    byte[] getBlob(@IntRange(from = 0) int index);

    boolean getBoolean(@IntRange(from = 0) int index);

    int getColumnCount();

    @NotNull
    String getColumnName(@IntRange(from = 0) int index);

    @NotNull
    List<String> getColumnNames();

    int getColumnType(@IntRange(from = 0) int index);

    double getDouble(@IntRange(from = 0) int index);

    float getFloat(@IntRange(from = 0) int index);

    int getInt(@IntRange(from = 0) int index);

    long getLong(@IntRange(from = 0) int index);

    @NotNull
    String getText(@IntRange(from = 0) int index);

    boolean isNull(@IntRange(from = 0) int index);

    void reset();

    boolean step();
}
