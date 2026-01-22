package org.apache.commons.sudcompress.compressors.gzip;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.CRC32;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import k0.m;
import k0.o;
import org.apache.commons.codec.CharEncoding;
import y.a;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public class GzipCompressorInputStream extends a {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int FCOMMENT = 16;
    private static final int FEXTRA = 4;
    private static final int FHCRC = 2;
    private static final int FNAME = 8;
    private static final int FRESERVED = 224;
    private final byte[] buf;
    private int bufUsed;
    private final o countingStream;
    private final CRC32 crc;
    private final boolean decompressConcatenated;
    private boolean endReached;
    private final InputStream in;
    private Inflater inf;
    private final byte[] oneByte;
    private final GzipParameters parameters;

    public GzipCompressorInputStream(InputStream inputStream) {
        this(inputStream, false);
    }

    private boolean init(boolean z) {
        String str;
        int read = this.in.read();
        if (read == -1 && !z) {
            return false;
        }
        if (read == 31 && this.in.read() == 139) {
            DataInputStream dataInputStream = new DataInputStream(this.in);
            int readUnsignedByte = dataInputStream.readUnsignedByte();
            if (readUnsignedByte == 8) {
                int readUnsignedByte2 = dataInputStream.readUnsignedByte();
                if ((readUnsignedByte2 & FRESERVED) == 0) {
                    this.parameters.setModificationTime(m.a(dataInputStream) * 1000);
                    int readUnsignedByte3 = dataInputStream.readUnsignedByte();
                    if (readUnsignedByte3 != 2) {
                        if (readUnsignedByte3 == 4) {
                            this.parameters.setCompressionLevel(1);
                        }
                    } else {
                        this.parameters.setCompressionLevel(9);
                    }
                    this.parameters.setOperatingSystem(dataInputStream.readUnsignedByte());
                    if ((readUnsignedByte2 & 4) != 0) {
                        int readUnsignedByte4 = (dataInputStream.readUnsignedByte() << 8) | dataInputStream.readUnsignedByte();
                        while (true) {
                            int i = readUnsignedByte4 - 1;
                            if (readUnsignedByte4 <= 0) {
                                break;
                            }
                            dataInputStream.readUnsignedByte();
                            readUnsignedByte4 = i;
                        }
                    }
                    if ((readUnsignedByte2 & 8) != 0) {
                        this.parameters.setFilename(new String(readToNull(dataInputStream), CharEncoding.ISO_8859_1));
                    }
                    if ((readUnsignedByte2 & 16) != 0) {
                        this.parameters.setComment(new String(readToNull(dataInputStream), CharEncoding.ISO_8859_1));
                    }
                    if ((readUnsignedByte2 & 2) != 0) {
                        dataInputStream.readShort();
                    }
                    this.inf.reset();
                    this.crc.reset();
                    return true;
                }
                throw new IOException("Reserved flags are set in the .gz header");
            }
            throw new IOException("Unsupported compression method " + readUnsignedByte + " in the .gz header");
        }
        if (z) {
            str = "Input is not in the .gz format";
        } else {
            str = "Garbage after a valid .gz stream";
        }
        throw new IOException(str);
    }

    public static boolean matches(byte[] bArr, int i) {
        if (i < 2 || bArr[0] != 31 || bArr[1] != -117) {
            return false;
        }
        return true;
    }

    private static byte[] readToNull(DataInput dataInput) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            try {
                int readUnsignedByte = dataInput.readUnsignedByte();
                if (readUnsignedByte != 0) {
                    byteArrayOutputStream.write(readUnsignedByte);
                } else {
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                    return byteArray;
                }
            } catch (Throwable th) {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
    }

    public void close() {
        Inflater inflater = this.inf;
        if (inflater != null) {
            inflater.end();
            this.inf = null;
        }
        InputStream inputStream = this.in;
        if (inputStream != System.in) {
            inputStream.close();
        }
    }

    public long getCompressedCount() {
        return this.countingStream.getBytesRead();
    }

    public GzipParameters getMetaData() {
        return this.parameters;
    }

    public int read() {
        if (read(this.oneByte, 0, 1) == -1) {
            return -1;
        }
        return this.oneByte[0] & 255;
    }

    public GzipCompressorInputStream(InputStream inputStream, boolean z) {
        this.buf = new byte[8192];
        this.inf = new Inflater(true);
        this.crc = new CRC32();
        this.endReached = false;
        this.oneByte = new byte[1];
        this.parameters = new GzipParameters();
        o oVar = new o(inputStream);
        this.countingStream = oVar;
        if (oVar.markSupported()) {
            this.in = oVar;
        } else {
            this.in = new BufferedInputStream(oVar);
        }
        this.decompressConcatenated = z;
        init(true);
    }

    public int read(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return 0;
        }
        if (this.endReached) {
            return -1;
        }
        int i3 = 0;
        while (i2 > 0) {
            if (this.inf.needsInput()) {
                this.in.mark(this.buf.length);
                int read = this.in.read(this.buf);
                this.bufUsed = read;
                if (read != -1) {
                    this.inf.setInput(this.buf, 0, read);
                } else {
                    throw new EOFException();
                }
            }
            try {
                int inflate = this.inf.inflate(bArr, i, i2);
                this.crc.update(bArr, i, inflate);
                i += inflate;
                i2 -= inflate;
                i3 += inflate;
                count(inflate);
                if (this.inf.finished()) {
                    this.in.reset();
                    long remaining = this.bufUsed - this.inf.getRemaining();
                    if (k0.a.b(this.in, remaining) == remaining) {
                        this.bufUsed = 0;
                        DataInputStream dataInputStream = new DataInputStream(this.in);
                        if (m.a(dataInputStream) != this.crc.getValue()) {
                            throw new IOException("Gzip-compressed data is corrupt (CRC32 error)");
                        }
                        if (m.a(dataInputStream) == (this.inf.getBytesWritten() & 4294967295L)) {
                            if (!this.decompressConcatenated || !init(false)) {
                                this.inf.end();
                                this.inf = null;
                                this.endReached = true;
                                if (i3 == 0) {
                                    return -1;
                                }
                                return i3;
                            }
                        } else {
                            throw new IOException("Gzip-compressed data is corrupt(uncompressed size mismatch)");
                        }
                    } else {
                        throw new IOException();
                    }
                }
            } catch (DataFormatException unused) {
                throw new IOException("Gzip-compressed data is corrupt");
            }
        }
        return i3;
    }
}
