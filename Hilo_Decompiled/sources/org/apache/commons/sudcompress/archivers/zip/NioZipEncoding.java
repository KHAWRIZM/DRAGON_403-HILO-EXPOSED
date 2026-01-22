package org.apache.commons.sudcompress.archivers.zip;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
class NioZipEncoding implements ZipEncoding, CharsetAccessor {
    private final Charset charset;
    private final boolean useReplacement;
    private static final byte[] REPLACEMENT_BYTES = {63};
    private static final char REPLACEMENT = '?';
    private static final String REPLACEMENT_STRING = String.valueOf(REPLACEMENT);
    private static final char[] HEX_CHARS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public NioZipEncoding(Charset charset, boolean z) {
        this.charset = charset;
        this.useReplacement = z;
    }

    private static ByteBuffer encodeFully(CharsetEncoder charsetEncoder, CharBuffer charBuffer, ByteBuffer byteBuffer) {
        while (charBuffer.hasRemaining()) {
            if (charsetEncoder.encode(charBuffer, byteBuffer, false).isOverflow()) {
                byteBuffer = ZipEncodingHelper.growBufferBy(byteBuffer, estimateIncrementalEncodingSize(charsetEncoder, charBuffer.remaining()));
            }
        }
        return byteBuffer;
    }

    private static CharBuffer encodeSurrogate(CharBuffer charBuffer, char c) {
        charBuffer.position(0).limit(6);
        charBuffer.put('%');
        charBuffer.put('U');
        char[] cArr = HEX_CHARS;
        charBuffer.put(cArr[(c >> '\f') & 15]);
        charBuffer.put(cArr[(c >> '\b') & 15]);
        charBuffer.put(cArr[(c >> 4) & 15]);
        charBuffer.put(cArr[c & 15]);
        charBuffer.flip();
        return charBuffer;
    }

    private static int estimateIncrementalEncodingSize(CharsetEncoder charsetEncoder, int i) {
        return (int) Math.ceil(charsetEncoder.averageBytesPerChar() * i);
    }

    private static int estimateInitialBufferSize(CharsetEncoder charsetEncoder, int i) {
        return (int) Math.ceil((charsetEncoder.averageBytesPerChar() * (i - 1)) + charsetEncoder.maxBytesPerChar());
    }

    private CharsetDecoder newDecoder() {
        if (!this.useReplacement) {
            CharsetDecoder newDecoder = this.charset.newDecoder();
            CodingErrorAction codingErrorAction = CodingErrorAction.REPORT;
            return newDecoder.onMalformedInput(codingErrorAction).onUnmappableCharacter(codingErrorAction);
        }
        CharsetDecoder newDecoder2 = this.charset.newDecoder();
        CodingErrorAction codingErrorAction2 = CodingErrorAction.REPLACE;
        return newDecoder2.onMalformedInput(codingErrorAction2).onUnmappableCharacter(codingErrorAction2).replaceWith(REPLACEMENT_STRING);
    }

    private CharsetEncoder newEncoder() {
        if (this.useReplacement) {
            CharsetEncoder newEncoder = this.charset.newEncoder();
            CodingErrorAction codingErrorAction = CodingErrorAction.REPLACE;
            return newEncoder.onMalformedInput(codingErrorAction).onUnmappableCharacter(codingErrorAction).replaceWith(REPLACEMENT_BYTES);
        }
        CharsetEncoder newEncoder2 = this.charset.newEncoder();
        CodingErrorAction codingErrorAction2 = CodingErrorAction.REPORT;
        return newEncoder2.onMalformedInput(codingErrorAction2).onUnmappableCharacter(codingErrorAction2);
    }

    @Override // org.apache.commons.sudcompress.archivers.zip.ZipEncoding
    public boolean canEncode(String str) {
        return newEncoder().canEncode(str);
    }

    @Override // org.apache.commons.sudcompress.archivers.zip.ZipEncoding
    public String decode(byte[] bArr) {
        return newDecoder().decode(ByteBuffer.wrap(bArr)).toString();
    }

    @Override // org.apache.commons.sudcompress.archivers.zip.ZipEncoding
    public ByteBuffer encode(String str) {
        int i;
        CharsetEncoder newEncoder = newEncoder();
        CharBuffer wrap = CharBuffer.wrap(str);
        ByteBuffer allocate = ByteBuffer.allocate(estimateInitialBufferSize(newEncoder, wrap.remaining()));
        CharBuffer charBuffer = null;
        while (wrap.hasRemaining()) {
            CoderResult encode = newEncoder.encode(wrap, allocate, false);
            if (!encode.isUnmappable() && !encode.isMalformed()) {
                if (encode.isOverflow()) {
                    allocate = ZipEncodingHelper.growBufferBy(allocate, estimateIncrementalEncodingSize(newEncoder, wrap.remaining()));
                } else if (encode.isUnderflow() || encode.isError()) {
                    break;
                }
            } else {
                if (estimateIncrementalEncodingSize(newEncoder, encode.length() * 6) > allocate.remaining()) {
                    int i2 = 0;
                    for (int position = wrap.position(); position < wrap.limit(); position++) {
                        if (!newEncoder.canEncode(wrap.get(position))) {
                            i = 6;
                        } else {
                            i = 1;
                        }
                        i2 += i;
                    }
                    allocate = ZipEncodingHelper.growBufferBy(allocate, estimateIncrementalEncodingSize(newEncoder, i2) - allocate.remaining());
                }
                if (charBuffer == null) {
                    charBuffer = CharBuffer.allocate(6);
                }
                for (int i3 = 0; i3 < encode.length(); i3++) {
                    allocate = encodeFully(newEncoder, encodeSurrogate(charBuffer, wrap.get()), allocate);
                }
            }
        }
        newEncoder.encode(wrap, allocate, true);
        allocate.limit(allocate.position());
        allocate.rewind();
        return allocate;
    }

    @Override // org.apache.commons.sudcompress.archivers.zip.CharsetAccessor
    public Charset getCharset() {
        return this.charset;
    }
}
