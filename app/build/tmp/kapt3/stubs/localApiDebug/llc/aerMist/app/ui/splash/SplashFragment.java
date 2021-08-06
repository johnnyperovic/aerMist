package llc.aerMist.app.ui.splash;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u00ad\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\be\n\u0002\u0018\u0002\n\u0002\bG\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0003\b\u00c8\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0012\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u00da\u0003\u001a\u00030\u00db\u0003J\u0011\u0010\u00dc\u0003\u001a\u00030\u00db\u00032\u0007\u0010\u00dd\u0003\u001a\u00020OJ\n\u0010\u00de\u0003\u001a\u00030\u00db\u0003H\u0007J\u0010\u0010\u00df\u0003\u001a\u00020\u00042\u0007\u0010\u00e0\u0003\u001a\u00020\nJ\u0012\u0010\u00e1\u0003\u001a\u00020\n2\u0007\u0010\u00e2\u0003\u001a\u00020\nH\u0002J\b\u0010\u00e3\u0003\u001a\u00030\u00db\u0003J\n\u0010\u00e4\u0003\u001a\u00030\u00db\u0003H\u0002J\n\u0010\u00e5\u0003\u001a\u00030\u00db\u0003H\u0002J\u0016\u0010\u00e6\u0003\u001a\u00030\u00db\u00032\n\u0010\u00e7\u0003\u001a\u0005\u0018\u00010\u00e8\u0003H\u0016J(\u0010\u00e9\u0003\u001a\u00030\u00db\u00032\u0007\u0010\u00ea\u0003\u001a\u00020\u00042\u0007\u0010\u00eb\u0003\u001a\u00020\u00042\n\u0010\u00ec\u0003\u001a\u0005\u0018\u00010\u00ed\u0003H\u0016J.\u0010\u00ee\u0003\u001a\u0005\u0018\u00010\u00ef\u00032\b\u0010\u00f0\u0003\u001a\u00030\u00f1\u00032\n\u0010\u00f2\u0003\u001a\u0005\u0018\u00010\u00f3\u00032\n\u0010\u00e7\u0003\u001a\u0005\u0018\u00010\u00e8\u0003H\u0016J\n\u0010\u00f4\u0003\u001a\u00030\u00db\u0003H\u0016J\u0013\u0010\u00f5\u0003\u001a\u00030\u00db\u00032\u0007\u0010\u00f6\u0003\u001a\u00020\nH\u0002J\b\u0010\u00f7\u0003\u001a\u00030\u00db\u0003J\b\u0010\u00f8\u0003\u001a\u00030\u00db\u0003J\b\u0010\u00f9\u0003\u001a\u00030\u00db\u0003J\b\u0010\u00fa\u0003\u001a\u00030\u00db\u0003J\u0011\u0010\u00fb\u0003\u001a\u00030\u00db\u00032\u0007\u0010\u00e2\u0003\u001a\u00020\nJ\u0011\u0010\u00fc\u0003\u001a\u00030\u00db\u00032\u0007\u0010\u00e2\u0003\u001a\u00020\nJ\u0011\u0010\u00fd\u0003\u001a\u00030\u00db\u00032\u0007\u0010\u00e2\u0003\u001a\u00020\nJ\u0011\u0010\u00fe\u0003\u001a\u00030\u00db\u00032\u0007\u0010\u00e2\u0003\u001a\u00020\nJ$\u0010\u00ff\u0003\u001a\u00030\u00db\u00032\b\u0010\u0080\u0004\u001a\u00030\u0081\u00042\u0007\u0010\u00dd\u0003\u001a\u00020O2\u0007\u0010\u0082\u0004\u001a\u00020]J\u001a\u0010\u0083\u0004\u001a\u00030\u00db\u00032\u0007\u0010\u0082\u0004\u001a\u00020]2\u0007\u0010\u00dd\u0003\u001a\u00020OJ\u0007\u0010X\u001a\u00030\u00db\u0003J\n\u0010\u00a3\u0001\u001a\u00030\u00db\u0003H\u0007J\n\u0010\u00a6\u0002\u001a\u00030\u00db\u0003H\u0007J\n\u0010\u00fa\u0002\u001a\u00030\u00db\u0003H\u0007J\b\u0010\u0084\u0004\u001a\u00030\u00db\u0003R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001b\u001a\u00020\u001c\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u001f\u001a\u00020 \u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0006\"\u0004\b%\u0010&R\u001a\u0010\'\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\f\"\u0004\b)\u0010\u000eR\u001a\u0010*\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\f\"\u0004\b,\u0010\u000eR\u001c\u0010-\u001a\u0004\u0018\u00010.X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001a\u00103\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\f\"\u0004\b5\u0010\u000eR\u001a\u00106\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\f\"\u0004\b8\u0010\u000eR\u001c\u00109\u001a\u0004\u0018\u00010.X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b:\u00100\"\u0004\b;\u00102R\u001a\u0010<\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\f\"\u0004\b>\u0010\u000eR\u001c\u0010?\u001a\u0004\u0018\u00010.X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b@\u00100\"\u0004\bA\u00102R\u001a\u0010B\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\f\"\u0004\bD\u0010\u000eR\u001c\u0010E\u001a\u0004\u0018\u00010.X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bF\u00100\"\u0004\bG\u00102R\u001c\u0010H\u001a\u0004\u0018\u00010IX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\u001c\u0010N\u001a\u0004\u0018\u00010OX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\u0014\u0010T\u001a\u00020\nX\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\bU\u0010\fR\u001a\u0010V\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bW\u0010\f\"\u0004\bX\u0010\u000eR\u001a\u0010Y\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010\f\"\u0004\b[\u0010\u000eR\u001c\u0010\\\u001a\u0004\u0018\u00010]X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR\u001a\u0010b\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bc\u0010\f\"\u0004\bd\u0010\u000eR\u001a\u0010e\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bf\u0010\f\"\u0004\bg\u0010\u000eR\u001a\u0010h\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bi\u0010\f\"\u0004\bj\u0010\u000eR\u001a\u0010k\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bl\u0010\f\"\u0004\bm\u0010\u000eR\u001a\u0010n\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bo\u0010\f\"\u0004\bp\u0010\u000eR\u001a\u0010q\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\br\u0010\f\"\u0004\bs\u0010\u000eR\u001a\u0010t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bu\u0010\f\"\u0004\bv\u0010\u000eR\u001a\u0010w\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bx\u0010\f\"\u0004\by\u0010\u000eR\u001a\u0010z\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b{\u0010\u0018\"\u0004\b|\u0010\u001aR\u001a\u0010}\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b~\u0010\u0018\"\u0004\b\u007f\u0010\u001aR\u001d\u0010\u0080\u0001\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0081\u0001\u0010\u0018\"\u0005\b\u0082\u0001\u0010\u001aR\u001d\u0010\u0083\u0001\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0084\u0001\u0010\u0018\"\u0005\b\u0085\u0001\u0010\u001aR\u001d\u0010\u0086\u0001\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0087\u0001\u0010\f\"\u0005\b\u0088\u0001\u0010\u000eR\u001d\u0010\u0089\u0001\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u008a\u0001\u0010\f\"\u0005\b\u008b\u0001\u0010\u000eR\u001d\u0010\u008c\u0001\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u008d\u0001\u0010\f\"\u0005\b\u008e\u0001\u0010\u000eR\u001d\u0010\u008f\u0001\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0090\u0001\u0010\f\"\u0005\b\u0091\u0001\u0010\u000eR\u001d\u0010\u0092\u0001\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0093\u0001\u0010\f\"\u0005\b\u0094\u0001\u0010\u000eR\u001d\u0010\u0095\u0001\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0096\u0001\u0010\f\"\u0005\b\u0097\u0001\u0010\u000eR\u001d\u0010\u0098\u0001\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0099\u0001\u0010\f\"\u0005\b\u009a\u0001\u0010\u000eR\u001d\u0010\u009b\u0001\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u009c\u0001\u0010\f\"\u0005\b\u009d\u0001\u0010\u000eR\u001f\u0010\u009e\u0001\u001a\u0004\u0018\u00010OX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u009f\u0001\u0010Q\"\u0005\b\u00a0\u0001\u0010SR\u001d\u0010\u00a1\u0001\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00a2\u0001\u0010\f\"\u0005\b\u00a3\u0001\u0010\u000eR\u001d\u0010\u00a4\u0001\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00a5\u0001\u0010\f\"\u0005\b\u00a6\u0001\u0010\u000eR\u001f\u0010\u00a7\u0001\u001a\u0004\u0018\u00010]X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00a8\u0001\u0010_\"\u0005\b\u00a9\u0001\u0010aR\u001d\u0010\u00aa\u0001\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00ab\u0001\u0010\u0018\"\u0005\b\u00ac\u0001\u0010\u001aR\u001d\u0010\u00ad\u0001\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00ae\u0001\u0010\u0018\"\u0005\b\u00af\u0001\u0010\u001aR\u001d\u0010\u00b0\u0001\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00b1\u0001\u0010\u0018\"\u0005\b\u00b2\u0001\u0010\u001aR\u001d\u0010\u00b3\u0001\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00b4\u0001\u0010\u0018\"\u0005\b\u00b5\u0001\u0010\u001aR\u001d\u0010\u00b6\u0001\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00b7\u0001\u0010\u0018\"\u0005\b\u00b8\u0001\u0010\u001aR\u001d\u0010\u00b9\u0001\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00ba\u0001\u0010\u0018\"\u0005\b\u00bb\u0001\u0010\u001aR\u001d\u0010\u00bc\u0001\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00bd\u0001\u0010\u0018\"\u0005\b\u00be\u0001\u0010\u001aR\u001d\u0010\u00bf\u0001\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00c0\u0001\u0010\u0018\"\u0005\b\u00c1\u0001\u0010\u001aR\u0015\u0010\u00c2\u0001\u001a\u00030\u00c3\u0001\u00a2\u0006\n\n\u0000\u001a\u0006\b\u00c4\u0001\u0010\u00c5\u0001R\u001d\u0010\u00c6\u0001\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00c6\u0001\u0010\u0018\"\u0005\b\u00c7\u0001\u0010\u001aR\u001d\u0010\u00c8\u0001\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00c8\u0001\u0010\u0018\"\u0005\b\u00c9\u0001\u0010\u001aR\u001d\u0010\u00ca\u0001\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00ca\u0001\u0010\u0018\"\u0005\b\u00cb\u0001\u0010\u001aR\u001d\u0010\u00cc\u0001\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00cc\u0001\u0010\u0018\"\u0005\b\u00cd\u0001\u0010\u001aR\u001d\u0010\u00ce\u0001\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00ce\u0001\u0010\u0018\"\u0005\b\u00cf\u0001\u0010\u001aR\u001d\u0010\u00d0\u0001\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00d0\u0001\u0010\u0018\"\u0005\b\u00d1\u0001\u0010\u001aR\u001d\u0010\u00d2\u0001\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00d2\u0001\u0010\u0018\"\u0005\b\u00d3\u0001\u0010\u001aR\u001d\u0010\u00d4\u0001\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00d4\u0001\u0010\u0018\"\u0005\b\u00d5\u0001\u0010\u001aR\u001d\u0010\u00d6\u0001\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00d6\u0001\u0010\u0018\"\u0005\b\u00d7\u0001\u0010\u001aR\u001d\u0010\u00d8\u0001\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00d8\u0001\u0010\u0018\"\u0005\b\u00d9\u0001\u0010\u001aR\u001d\u0010\u00da\u0001\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00da\u0001\u0010\u0018\"\u0005\b\u00db\u0001\u0010\u001aR\u001d\u0010\u00dc\u0001\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00dc\u0001\u0010\u0018\"\u0005\b\u00dd\u0001\u0010\u001aR\u001d\u0010\u00de\u0001\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00de\u0001\u0010\u0018\"\u0005\b\u00df\u0001\u0010\u001aR\u001d\u0010\u00e0\u0001\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00e0\u0001\u0010\u0018\"\u0005\b\u00e1\u0001\u0010\u001aR\u001d\u0010\u00e2\u0001\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00e2\u0001\u0010\u0018\"\u0005\b\u00e3\u0001\u0010\u001aR\u001d\u0010\u00e4\u0001\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00e4\u0001\u0010\u0018\"\u0005\b\u00e5\u0001\u0010\u001aR\u001d\u0010\u00e6\u0001\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00e6\u0001\u0010\u0018\"\u0005\b\u00e7\u0001\u0010\u001aR\u001d\u0010\u00e8\u0001\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00e8\u0001\u0010\u0018\"\u0005\b\u00e9\u0001\u0010\u001aR\u001d\u0010\u00ea\u0001\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00ea\u0001\u0010\u0018\"\u0005\b\u00eb\u0001\u0010\u001aR\u001d\u0010\u00ec\u0001\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00ec\u0001\u0010\u0018\"\u0005\b\u00ed\u0001\u0010\u001aR\u001d\u0010\u00ee\u0001\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00ef\u0001\u0010\u0018\"\u0005\b\u00f0\u0001\u0010\u001aR\u000f\u0010\u00f1\u0001\u001a\u00020\nX\u0082D\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u00f2\u0001\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00f3\u0001\u0010\f\"\u0005\b\u00f4\u0001\u0010\u000eR\u001d\u0010\u00f5\u0001\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00f6\u0001\u0010\f\"\u0005\b\u00f7\u0001\u0010\u000eR\u001d\u0010\u00f8\u0001\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00f9\u0001\u0010\f\"\u0005\b\u00fa\u0001\u0010\u000eR\u001d\u0010\u00fb\u0001\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00fc\u0001\u0010\f\"\u0005\b\u00fd\u0001\u0010\u000eR\u001d\u0010\u00fe\u0001\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00ff\u0001\u0010\u0018\"\u0005\b\u0080\u0002\u0010\u001aR\u001d\u0010\u0081\u0002\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0082\u0002\u0010\u0018\"\u0005\b\u0083\u0002\u0010\u001aR\u001d\u0010\u0084\u0002\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0085\u0002\u0010\u0018\"\u0005\b\u0086\u0002\u0010\u001aR\u001d\u0010\u0087\u0002\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0088\u0002\u0010\u0018\"\u0005\b\u0089\u0002\u0010\u001aR\u0010\u0010\u008a\u0002\u001a\u00030\u008b\u0002X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u008c\u0002\u001a\u00030\u008b\u0002X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u008d\u0002\u001a\u00030\u008b\u0002X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u008e\u0002\u001a\u00030\u008b\u0002X\u0082\u0004\u00a2\u0006\u0002\n\u0000R!\u0010\u008f\u0002\u001a\u00030\u0090\u00028BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u0093\u0002\u0010\u0094\u0002\u001a\u0006\b\u0091\u0002\u0010\u0092\u0002R\u001d\u0010\u0095\u0002\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0096\u0002\u0010\u0018\"\u0005\b\u0097\u0002\u0010\u001aR\u001d\u0010\u0098\u0002\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0099\u0002\u0010\u0018\"\u0005\b\u009a\u0002\u0010\u001aR\u001d\u0010\u009b\u0002\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u009c\u0002\u0010\u0018\"\u0005\b\u009d\u0002\u0010\u001aR\u001d\u0010\u009e\u0002\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u009f\u0002\u0010\u0018\"\u0005\b\u00a0\u0002\u0010\u001aR\u001f\u0010\u00a1\u0002\u001a\u0004\u0018\u00010OX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00a2\u0002\u0010Q\"\u0005\b\u00a3\u0002\u0010SR\u001d\u0010\u00a4\u0002\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00a5\u0002\u0010\f\"\u0005\b\u00a6\u0002\u0010\u000eR\u001d\u0010\u00a7\u0002\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00a8\u0002\u0010\f\"\u0005\b\u00a9\u0002\u0010\u000eR\u001f\u0010\u00aa\u0002\u001a\u0004\u0018\u00010]X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00ab\u0002\u0010_\"\u0005\b\u00ac\u0002\u0010aR\u001d\u0010\u00ad\u0002\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00ae\u0002\u0010\f\"\u0005\b\u00af\u0002\u0010\u000eR\u001d\u0010\u00b0\u0002\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00b1\u0002\u0010\f\"\u0005\b\u00b2\u0002\u0010\u000eR\u001d\u0010\u00b3\u0002\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00b4\u0002\u0010\f\"\u0005\b\u00b5\u0002\u0010\u000eR\u001d\u0010\u00b6\u0002\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00b7\u0002\u0010\f\"\u0005\b\u00b8\u0002\u0010\u000eR\u001d\u0010\u00b9\u0002\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00ba\u0002\u0010\f\"\u0005\b\u00bb\u0002\u0010\u000eR\u001d\u0010\u00bc\u0002\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00bd\u0002\u0010\f\"\u0005\b\u00be\u0002\u0010\u000eR\u001d\u0010\u00bf\u0002\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00c0\u0002\u0010\f\"\u0005\b\u00c1\u0002\u0010\u000eR\u001d\u0010\u00c2\u0002\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00c3\u0002\u0010\f\"\u0005\b\u00c4\u0002\u0010\u000eR\u001d\u0010\u00c5\u0002\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00c6\u0002\u0010\u0018\"\u0005\b\u00c7\u0002\u0010\u001aR\u001d\u0010\u00c8\u0002\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00c9\u0002\u0010\u0018\"\u0005\b\u00ca\u0002\u0010\u001aR\u001d\u0010\u00cb\u0002\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00cc\u0002\u0010\u0018\"\u0005\b\u00cd\u0002\u0010\u001aR\u001d\u0010\u00ce\u0002\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00cf\u0002\u0010\u0018\"\u0005\b\u00d0\u0002\u0010\u001aR\u001d\u0010\u00d1\u0002\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00d2\u0002\u0010\f\"\u0005\b\u00d3\u0002\u0010\u000eR\u001d\u0010\u00d4\u0002\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00d5\u0002\u0010\f\"\u0005\b\u00d6\u0002\u0010\u000eR\u001d\u0010\u00d7\u0002\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00d8\u0002\u0010\f\"\u0005\b\u00d9\u0002\u0010\u000eR\u001d\u0010\u00da\u0002\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00db\u0002\u0010\f\"\u0005\b\u00dc\u0002\u0010\u000eR\u001d\u0010\u00dd\u0002\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00de\u0002\u0010\u0018\"\u0005\b\u00df\u0002\u0010\u001aR\u001d\u0010\u00e0\u0002\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00e1\u0002\u0010\u0018\"\u0005\b\u00e2\u0002\u0010\u001aR\u001d\u0010\u00e3\u0002\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00e4\u0002\u0010\u0018\"\u0005\b\u00e5\u0002\u0010\u001aR\u001d\u0010\u00e6\u0002\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00e7\u0002\u0010\u0018\"\u0005\b\u00e8\u0002\u0010\u001aR\u001d\u0010\u00e9\u0002\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00ea\u0002\u0010\f\"\u0005\b\u00eb\u0002\u0010\u000eR\u001d\u0010\u00ec\u0002\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00ed\u0002\u0010\f\"\u0005\b\u00ee\u0002\u0010\u000eR\u001d\u0010\u00ef\u0002\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00f0\u0002\u0010\f\"\u0005\b\u00f1\u0002\u0010\u000eR\u001d\u0010\u00f2\u0002\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00f3\u0002\u0010\f\"\u0005\b\u00f4\u0002\u0010\u000eR\u001f\u0010\u00f5\u0002\u001a\u0004\u0018\u00010OX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00f6\u0002\u0010Q\"\u0005\b\u00f7\u0002\u0010SR\u001d\u0010\u00f8\u0002\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00f9\u0002\u0010\f\"\u0005\b\u00fa\u0002\u0010\u000eR\u001d\u0010\u00fb\u0002\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00fc\u0002\u0010\f\"\u0005\b\u00fd\u0002\u0010\u000eR\u001f\u0010\u00fe\u0002\u001a\u0004\u0018\u00010]X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00ff\u0002\u0010_\"\u0005\b\u0080\u0003\u0010aR\u001d\u0010\u0081\u0003\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0082\u0003\u0010\f\"\u0005\b\u0083\u0003\u0010\u000eR\u001d\u0010\u0084\u0003\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0085\u0003\u0010\f\"\u0005\b\u0086\u0003\u0010\u000eR\u001d\u0010\u0087\u0003\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0088\u0003\u0010\f\"\u0005\b\u0089\u0003\u0010\u000eR\u001d\u0010\u008a\u0003\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u008b\u0003\u0010\f\"\u0005\b\u008c\u0003\u0010\u000eR\u001d\u0010\u008d\u0003\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u008e\u0003\u0010\f\"\u0005\b\u008f\u0003\u0010\u000eR\u001d\u0010\u0090\u0003\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0091\u0003\u0010\f\"\u0005\b\u0092\u0003\u0010\u000eR\u001d\u0010\u0093\u0003\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0094\u0003\u0010\f\"\u0005\b\u0095\u0003\u0010\u000eR\u001d\u0010\u0096\u0003\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0097\u0003\u0010\f\"\u0005\b\u0098\u0003\u0010\u000eR\u001d\u0010\u0099\u0003\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u009a\u0003\u0010\u0018\"\u0005\b\u009b\u0003\u0010\u001aR\u001d\u0010\u009c\u0003\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u009d\u0003\u0010\u0018\"\u0005\b\u009e\u0003\u0010\u001aR\u001d\u0010\u009f\u0003\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00a0\u0003\u0010\u0018\"\u0005\b\u00a1\u0003\u0010\u001aR\u001d\u0010\u00a2\u0003\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00a3\u0003\u0010\u0018\"\u0005\b\u00a4\u0003\u0010\u001aR\u001d\u0010\u00a5\u0003\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00a6\u0003\u0010\u0018\"\u0005\b\u00a7\u0003\u0010\u001aR\u001d\u0010\u00a8\u0003\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00a9\u0003\u0010\u0018\"\u0005\b\u00aa\u0003\u0010\u001aR\u001d\u0010\u00ab\u0003\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00ac\u0003\u0010\u0018\"\u0005\b\u00ad\u0003\u0010\u001aR\u001d\u0010\u00ae\u0003\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00af\u0003\u0010\u0018\"\u0005\b\u00b0\u0003\u0010\u001aR\u001d\u0010\u00b1\u0003\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00b2\u0003\u0010\f\"\u0005\b\u00b3\u0003\u0010\u000eR\u001d\u0010\u00b4\u0003\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00b5\u0003\u0010\u0018\"\u0005\b\u00b6\u0003\u0010\u001aR\u001d\u0010\u00b7\u0003\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00b8\u0003\u0010\u0018\"\u0005\b\u00b9\u0003\u0010\u001aR\u001d\u0010\u00ba\u0003\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00bb\u0003\u0010\u0018\"\u0005\b\u00bc\u0003\u0010\u001aR\u001d\u0010\u00bd\u0003\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00be\u0003\u0010\u0018\"\u0005\b\u00bf\u0003\u0010\u001aR\u001d\u0010\u00c0\u0003\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00c1\u0003\u0010\u0018\"\u0005\b\u00c2\u0003\u0010\u001aR\u001d\u0010\u00c3\u0003\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00c4\u0003\u0010\u0018\"\u0005\b\u00c5\u0003\u0010\u001aR\u001d\u0010\u00c6\u0003\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00c7\u0003\u0010\u0018\"\u0005\b\u00c8\u0003\u0010\u001aR\u001d\u0010\u00c9\u0003\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00ca\u0003\u0010\u0018\"\u0005\b\u00cb\u0003\u0010\u001aR\u001d\u0010\u00cc\u0003\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00cd\u0003\u0010\f\"\u0005\b\u00ce\u0003\u0010\u000eR\u001d\u0010\u00cf\u0003\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00d0\u0003\u0010\f\"\u0005\b\u00d1\u0003\u0010\u000eR\u001d\u0010\u00d2\u0003\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00d3\u0003\u0010\f\"\u0005\b\u00d4\u0003\u0010\u000eR\u001d\u0010\u00d5\u0003\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00d6\u0003\u0010\f\"\u0005\b\u00d7\u0003\u0010\u000eR\u0010\u0010\u00d8\u0003\u001a\u00030\u00d9\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0085\u0004"}, d2 = {"Lllc/aerMist/app/ui/splash/SplashFragment;", "Landroidx/fragment/app/Fragment;", "()V", "REQUEST_CODE_PERMISSION_LOCATION", "", "getREQUEST_CODE_PERMISSION_LOCATION", "()I", "REQUEST_LOCATION_PERMISSION", "REQUEST_PERMISSIONS_REQUEST_CODE", "bleDeviceToPass", "", "getBleDeviceToPass", "()Ljava/lang/String;", "setBleDeviceToPass", "(Ljava/lang/String;)V", "bluetoothController", "Lllc/aerMist/app/helpers/BluetoothController;", "getBluetoothController", "()Lllc/aerMist/app/helpers/BluetoothController;", "setBluetoothController", "(Lllc/aerMist/app/helpers/BluetoothController;)V", "bluetoothEnabled", "", "getBluetoothEnabled", "()Z", "setBluetoothEnabled", "(Z)V", "charset", "Ljava/nio/charset/Charset;", "getCharset", "()Ljava/nio/charset/Charset;", "connectionStateCoordinator", "Lllc/aerMist/app/observers/NewObservableCoordinator;", "getConnectionStateCoordinator", "()Lllc/aerMist/app/observers/NewObservableCoordinator;", "counter", "getCounter", "setCounter", "(I)V", "dateAndTimeSynch", "getDateAndTimeSynch", "setDateAndTimeSynch", "deviceFour", "getDeviceFour", "setDeviceFour", "deviceFourObj", "Lllc/aerMist/app/models/MyDevice;", "getDeviceFourObj", "()Lllc/aerMist/app/models/MyDevice;", "setDeviceFourObj", "(Lllc/aerMist/app/models/MyDevice;)V", "deviceNameValue", "getDeviceNameValue", "setDeviceNameValue", "deviceOne", "getDeviceOne", "setDeviceOne", "deviceOneObj", "getDeviceOneObj", "setDeviceOneObj", "deviceThree", "getDeviceThree", "setDeviceThree", "deviceThreeObj", "getDeviceThreeObj", "setDeviceThreeObj", "deviceTwo", "getDeviceTwo", "setDeviceTwo", "deviceTwoObj", "getDeviceTwoObj", "setDeviceTwoObj", "dialogInterface", "Landroid/content/DialogInterface;", "getDialogInterface", "()Landroid/content/DialogInterface;", "setDialogInterface", "(Landroid/content/DialogInterface;)V", "firstBleDevice", "Lcom/clj/fastble/data/BleDevice;", "getFirstBleDevice", "()Lcom/clj/fastble/data/BleDevice;", "setFirstBleDevice", "(Lcom/clj/fastble/data/BleDevice;)V", "firstCommand", "getFirstCommand", "firstDevice", "getFirstDevice", "setFirstDevice", "firstDeviceNewName", "getFirstDeviceNewName", "setFirstDeviceNewName", "firstGate", "Landroid/bluetooth/BluetoothGatt;", "getFirstGate", "()Landroid/bluetooth/BluetoothGatt;", "setFirstGate", "(Landroid/bluetooth/BluetoothGatt;)V", "firstStartTime", "getFirstStartTime", "setFirstStartTime", "firstStartTime2", "getFirstStartTime2", "setFirstStartTime2", "firstStartTime3", "getFirstStartTime3", "setFirstStartTime3", "firstStartTime4", "getFirstStartTime4", "setFirstStartTime4", "firstStopTime", "getFirstStopTime", "setFirstStopTime", "firstStopTime2", "getFirstStopTime2", "setFirstStopTime2", "firstStopTime3", "getFirstStopTime3", "setFirstStopTime3", "firstStopTime4", "getFirstStopTime4", "setFirstStopTime4", "firstTimerActiv", "getFirstTimerActiv", "setFirstTimerActiv", "firstTimerActiv2", "getFirstTimerActiv2", "setFirstTimerActiv2", "firstTimerActiv3", "getFirstTimerActiv3", "setFirstTimerActiv3", "firstTimerActiv4", "getFirstTimerActiv4", "setFirstTimerActiv4", "fourtStartTime", "getFourtStartTime", "setFourtStartTime", "fourtStartTime2", "getFourtStartTime2", "setFourtStartTime2", "fourtStartTime3", "getFourtStartTime3", "setFourtStartTime3", "fourtStartTime4", "getFourtStartTime4", "setFourtStartTime4", "fourtStopTime", "getFourtStopTime", "setFourtStopTime", "fourtStopTime2", "getFourtStopTime2", "setFourtStopTime2", "fourtStopTime3", "getFourtStopTime3", "setFourtStopTime3", "fourtStopTime4", "getFourtStopTime4", "setFourtStopTime4", "fourthBleDevice", "getFourthBleDevice", "setFourthBleDevice", "fourthDevice", "getFourthDevice", "setFourthDevice", "fourthDeviceNewName", "getFourthDeviceNewName", "setFourthDeviceNewName", "fourthGate", "getFourthGate", "setFourthGate", "fourthTimerActiv", "getFourthTimerActiv", "setFourthTimerActiv", "fourthTimerActiv2", "getFourthTimerActiv2", "setFourthTimerActiv2", "fourthTimerActiv3", "getFourthTimerActiv3", "setFourthTimerActiv3", "fourthTimerActiv4", "getFourthTimerActiv4", "setFourthTimerActiv4", "fridayActive", "getFridayActive", "setFridayActive", "fridayActive2", "getFridayActive2", "setFridayActive2", "fridayActive3", "getFridayActive3", "setFridayActive3", "fridayActive4", "getFridayActive4", "setFridayActive4", "gattCallback", "Lcom/clj/fastble/callback/BleGattCallback;", "getGattCallback", "()Lcom/clj/fastble/callback/BleGattCallback;", "isNonStop", "setNonStop", "isNonStop2", "setNonStop2", "isNonStop3", "setNonStop3", "isNonStop4", "setNonStop4", "isOn", "setOn", "isOn2", "setOn2", "isOn3", "setOn3", "isOn4", "setOn4", "isSprayFriquencu", "setSprayFriquencu", "isSprayFriquencu2", "setSprayFriquencu2", "isSprayFriquencu3", "setSprayFriquencu3", "isSprayFriquencu4", "setSprayFriquencu4", "isSprayPerDay", "setSprayPerDay", "isSprayPerDay2", "setSprayPerDay2", "isSprayPerDay3", "setSprayPerDay3", "isSprayPerDay4", "setSprayPerDay4", "isSprayingMode", "setSprayingMode", "isSprayingMode2", "setSprayingMode2", "isSprayingMode3", "setSprayingMode3", "isSprayingMode4", "setSprayingMode4", "locationEnabled", "getLocationEnabled", "setLocationEnabled", "locationPermission", "mistTime", "getMistTime", "setMistTime", "mistTime2", "getMistTime2", "setMistTime2", "mistTime3", "getMistTime3", "setMistTime3", "mistTime4", "getMistTime4", "setMistTime4", "mondayActive", "getMondayActive", "setMondayActive", "mondayActive2", "getMondayActive2", "setMondayActive2", "mondayActive3", "getMondayActive3", "setMondayActive3", "mondayActive4", "getMondayActive4", "setMondayActive4", "notifyCallback", "Lcom/clj/fastble/callback/BleNotifyCallback;", "notifyCallback2", "notifyCallback3", "notifyCallback4", "prefs", "Lllc/aerMist/app/shared/util/PreferenceCache;", "getPrefs", "()Lllc/aerMist/app/shared/util/PreferenceCache;", "prefs$delegate", "Lkotlin/Lazy;", "saturdayActive", "getSaturdayActive", "setSaturdayActive", "saturdayActive2", "getSaturdayActive2", "setSaturdayActive2", "saturdayActive3", "getSaturdayActive3", "setSaturdayActive3", "saturdayActive4", "getSaturdayActive4", "setSaturdayActive4", "secondBleDevice", "getSecondBleDevice", "setSecondBleDevice", "secondDevice", "getSecondDevice", "setSecondDevice", "secondDeviceNewName", "getSecondDeviceNewName", "setSecondDeviceNewName", "secondGate", "getSecondGate", "setSecondGate", "secondStartTime", "getSecondStartTime", "setSecondStartTime", "secondStartTime2", "getSecondStartTime2", "setSecondStartTime2", "secondStartTime3", "getSecondStartTime3", "setSecondStartTime3", "secondStartTime4", "getSecondStartTime4", "setSecondStartTime4", "secondStopTime", "getSecondStopTime", "setSecondStopTime", "secondStopTime2", "getSecondStopTime2", "setSecondStopTime2", "secondStopTime3", "getSecondStopTime3", "setSecondStopTime3", "secondStopTime4", "getSecondStopTime4", "setSecondStopTime4", "secondTimerActiv", "getSecondTimerActiv", "setSecondTimerActiv", "secondTimerActiv2", "getSecondTimerActiv2", "setSecondTimerActiv2", "secondTimerActiv3", "getSecondTimerActiv3", "setSecondTimerActiv3", "secondTimerActiv4", "getSecondTimerActiv4", "setSecondTimerActiv4", "shortString", "getShortString", "setShortString", "shortString2", "getShortString2", "setShortString2", "shortString3", "getShortString3", "setShortString3", "shortString4", "getShortString4", "setShortString4", "sundayActive", "getSundayActive", "setSundayActive", "sundayActive2", "getSundayActive2", "setSundayActive2", "sundayActive3", "getSundayActive3", "setSundayActive3", "sundayActive4", "getSundayActive4", "setSundayActive4", "suspendTime", "getSuspendTime", "setSuspendTime", "suspendTime2", "getSuspendTime2", "setSuspendTime2", "suspendTime3", "getSuspendTime3", "setSuspendTime3", "suspendTime4", "getSuspendTime4", "setSuspendTime4", "thirdBleDevice", "getThirdBleDevice", "setThirdBleDevice", "thirdDevice", "getThirdDevice", "setThirdDevice", "thirdDeviceNewName", "getThirdDeviceNewName", "setThirdDeviceNewName", "thirdGate", "getThirdGate", "setThirdGate", "thirdStartTime", "getThirdStartTime", "setThirdStartTime", "thirdStartTime2", "getThirdStartTime2", "setThirdStartTime2", "thirdStartTime3", "getThirdStartTime3", "setThirdStartTime3", "thirdStartTime4", "getThirdStartTime4", "setThirdStartTime4", "thirdStopTime", "getThirdStopTime", "setThirdStopTime", "thirdStopTime2", "getThirdStopTime2", "setThirdStopTime2", "thirdStopTime3", "getThirdStopTime3", "setThirdStopTime3", "thirdStopTime4", "getThirdStopTime4", "setThirdStopTime4", "thirdTimerActiv", "getThirdTimerActiv", "setThirdTimerActiv", "thirdTimerActiv2", "getThirdTimerActiv2", "setThirdTimerActiv2", "thirdTimerActiv3", "getThirdTimerActiv3", "setThirdTimerActiv3", "thirdTimerActiv4", "getThirdTimerActiv4", "setThirdTimerActiv4", "thursdayActive", "getThursdayActive", "setThursdayActive", "thursdayActive2", "getThursdayActive2", "setThursdayActive2", "thursdayActive3", "getThursdayActive3", "setThursdayActive3", "thursdayActive4", "getThursdayActive4", "setThursdayActive4", "time", "getTime", "setTime", "tuesdayActive", "getTuesdayActive", "setTuesdayActive", "tuesdayActive2", "getTuesdayActive2", "setTuesdayActive2", "tuesdayActive3", "getTuesdayActive3", "setTuesdayActive3", "tuesdayActive4", "getTuesdayActive4", "setTuesdayActive4", "wednesdayActive", "getWednesdayActive", "setWednesdayActive", "wednesdayActive2", "getWednesdayActive2", "setWednesdayActive2", "wednesdayActive3", "getWednesdayActive3", "setWednesdayActive3", "wednesdayActive4", "getWednesdayActive4", "setWednesdayActive4", "workingTime", "getWorkingTime", "setWorkingTime", "workingTime2", "getWorkingTime2", "setWorkingTime2", "workingTime3", "getWorkingTime3", "setWorkingTime3", "workingTime4", "getWorkingTime4", "setWorkingTime4", "writeCallback", "Lcom/clj/fastble/callback/BleWriteCallback;", "checkTotalNumber", "", "connectDevice", "bleDevice", "connectDevices", "getDayInWeek", "day", "getRegister", "response", "navigateToDevice", "navigateToHome", "navigateToWelcome", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onPermissionGranted", "permission", "readFourthResponse", "readResponse", "readSecondResponse", "readThirdResponse", "readTimerSync", "readTimerSync2", "readTimerSync3", "readTimerSync4", "sendCommand", "input", "", "gatt", "sendTimeSynchCommand", "turnOnLocation", "app_localApiDebug"})
public final class SplashFragment extends androidx.fragment.app.Fragment {
    private final kotlin.Lazy prefs$delegate = null;
    @org.jetbrains.annotations.Nullable()
    private llc.aerMist.app.helpers.BluetoothController bluetoothController;
    @org.jetbrains.annotations.NotNull()
    private final llc.aerMist.app.observers.NewObservableCoordinator connectionStateCoordinator = null;
    private final int REQUEST_LOCATION_PERMISSION = 11;
    private final java.lang.String locationPermission = "android.permission.ACCESS_FINE_LOCATION";
    private final int REQUEST_CODE_PERMISSION_LOCATION = 5;
    private boolean locationEnabled = false;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String deviceOne = "";
    @org.jetbrains.annotations.Nullable()
    private llc.aerMist.app.models.MyDevice deviceOneObj;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String deviceTwo = "";
    @org.jetbrains.annotations.Nullable()
    private llc.aerMist.app.models.MyDevice deviceTwoObj;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String deviceThree = "";
    @org.jetbrains.annotations.Nullable()
    private llc.aerMist.app.models.MyDevice deviceThreeObj;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String deviceFour = "";
    @org.jetbrains.annotations.Nullable()
    private llc.aerMist.app.models.MyDevice deviceFourObj;
    @org.jetbrains.annotations.NotNull()
    private final java.nio.charset.Charset charset = null;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String firstDevice = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String firstDeviceNewName = "";
    @org.jetbrains.annotations.Nullable()
    private com.clj.fastble.data.BleDevice firstBleDevice;
    @org.jetbrains.annotations.Nullable()
    private android.bluetooth.BluetoothGatt firstGate;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String secondDevice = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String secondDeviceNewName = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String thirdDevice = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String thirdDeviceNewName = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String fourthDevice = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String fourthDeviceNewName = "";
    @org.jetbrains.annotations.Nullable()
    private com.clj.fastble.data.BleDevice secondBleDevice;
    @org.jetbrains.annotations.Nullable()
    private android.bluetooth.BluetoothGatt secondGate;
    @org.jetbrains.annotations.Nullable()
    private com.clj.fastble.data.BleDevice thirdBleDevice;
    @org.jetbrains.annotations.Nullable()
    private android.bluetooth.BluetoothGatt thirdGate;
    @org.jetbrains.annotations.Nullable()
    private com.clj.fastble.data.BleDevice fourthBleDevice;
    @org.jetbrains.annotations.Nullable()
    private android.bluetooth.BluetoothGatt fourthGate;
    private boolean firstTimerActiv = false;
    private boolean secondTimerActiv = false;
    private boolean thirdTimerActiv = false;
    private boolean fourthTimerActiv = false;
    private boolean bluetoothEnabled = false;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String workingTime = "";
    private boolean isOn = false;
    private boolean isNonStop = false;
    private boolean isSprayingMode = false;
    private boolean mondayActive = false;
    private boolean tuesdayActive = false;
    private boolean wednesdayActive = false;
    private boolean thursdayActive = false;
    private boolean fridayActive = false;
    private boolean saturdayActive = false;
    private boolean sundayActive = false;
    private boolean isSprayPerDay = false;
    private boolean isSprayFriquencu = false;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String firstStartTime = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String secondStartTime = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String thirdStartTime = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String fourtStartTime = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String firstStopTime = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String secondStopTime = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String thirdStopTime = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String fourtStopTime = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String mistTime = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String suspendTime = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String deviceNameValue = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String time = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String shortString = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String shortString2 = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String shortString3 = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String shortString4 = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String workingTime2 = "";
    private boolean isOn2 = false;
    private boolean isNonStop2 = false;
    private boolean isSprayingMode2 = false;
    private boolean mondayActive2 = false;
    private boolean tuesdayActive2 = false;
    private boolean wednesdayActive2 = false;
    private boolean thursdayActive2 = false;
    private boolean fridayActive2 = false;
    private boolean saturdayActive2 = false;
    private boolean sundayActive2 = false;
    private boolean isSprayPerDay2 = false;
    private boolean isSprayFriquencu2 = false;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String firstStartTime2 = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String secondStartTime2 = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String thirdStartTime2 = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String fourtStartTime2 = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String firstStopTime2 = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String secondStopTime2 = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String thirdStopTime2 = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String fourtStopTime2 = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String mistTime2 = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String suspendTime2 = "";
    private boolean firstTimerActiv2 = false;
    private boolean secondTimerActiv2 = false;
    private boolean thirdTimerActiv2 = false;
    private boolean fourthTimerActiv2 = false;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String dateAndTimeSynch = "";
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String firstCommand = "EE0c0.";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String workingTime3 = "";
    private boolean isOn3 = false;
    private boolean isNonStop3 = false;
    private boolean isSprayingMode3 = false;
    private boolean mondayActive3 = false;
    private boolean tuesdayActive3 = false;
    private boolean wednesdayActive3 = false;
    private boolean thursdayActive3 = false;
    private boolean fridayActive3 = false;
    private boolean saturdayActive3 = false;
    private boolean sundayActive3 = false;
    private boolean isSprayPerDay3 = false;
    private boolean isSprayFriquencu3 = false;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String firstStartTime3 = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String secondStartTime3 = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String thirdStartTime3 = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String fourtStartTime3 = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String firstStopTime3 = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String secondStopTime3 = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String thirdStopTime3 = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String fourtStopTime3 = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String mistTime3 = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String suspendTime3 = "";
    private boolean firstTimerActiv3 = false;
    private boolean secondTimerActiv3 = false;
    private boolean thirdTimerActiv3 = false;
    private boolean fourthTimerActiv3 = false;
    @org.jetbrains.annotations.Nullable()
    private android.content.DialogInterface dialogInterface;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String workingTime4 = "";
    private boolean isOn4 = false;
    private boolean isNonStop4 = false;
    private boolean isSprayingMode4 = false;
    private boolean mondayActive4 = false;
    private boolean tuesdayActive4 = false;
    private boolean wednesdayActive4 = false;
    private boolean thursdayActive4 = false;
    private boolean fridayActive4 = false;
    private boolean saturdayActive4 = false;
    private boolean sundayActive4 = false;
    private boolean isSprayPerDay4 = false;
    private boolean isSprayFriquencu4 = false;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String firstStartTime4 = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String secondStartTime4 = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String thirdStartTime4 = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String fourtStartTime4 = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String firstStopTime4 = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String secondStopTime4 = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String thirdStopTime4 = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String fourtStopTime4 = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String mistTime4 = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String suspendTime4 = "";
    private boolean firstTimerActiv4 = false;
    private boolean secondTimerActiv4 = false;
    private boolean thirdTimerActiv4 = false;
    private boolean fourthTimerActiv4 = false;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String bleDeviceToPass = "";
    private int counter = 0;
    private final int REQUEST_PERMISSIONS_REQUEST_CODE = 2;
    @org.jetbrains.annotations.NotNull()
    private final com.clj.fastble.callback.BleGattCallback gattCallback = null;
    private final com.clj.fastble.callback.BleWriteCallback writeCallback = null;
    private final com.clj.fastble.callback.BleNotifyCallback notifyCallback = null;
    private final com.clj.fastble.callback.BleNotifyCallback notifyCallback2 = null;
    private final com.clj.fastble.callback.BleNotifyCallback notifyCallback3 = null;
    private final com.clj.fastble.callback.BleNotifyCallback notifyCallback4 = null;
    private java.util.HashMap _$_findViewCache;
    
    private final llc.aerMist.app.shared.util.PreferenceCache getPrefs() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final llc.aerMist.app.helpers.BluetoothController getBluetoothController() {
        return null;
    }
    
    public final void setBluetoothController(@org.jetbrains.annotations.Nullable()
    llc.aerMist.app.helpers.BluetoothController p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final llc.aerMist.app.observers.NewObservableCoordinator getConnectionStateCoordinator() {
        return null;
    }
    
    public final int getREQUEST_CODE_PERMISSION_LOCATION() {
        return 0;
    }
    
    public final boolean getLocationEnabled() {
        return false;
    }
    
    public final void setLocationEnabled(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDeviceOne() {
        return null;
    }
    
    public final void setDeviceOne(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final llc.aerMist.app.models.MyDevice getDeviceOneObj() {
        return null;
    }
    
    public final void setDeviceOneObj(@org.jetbrains.annotations.Nullable()
    llc.aerMist.app.models.MyDevice p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDeviceTwo() {
        return null;
    }
    
    public final void setDeviceTwo(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final llc.aerMist.app.models.MyDevice getDeviceTwoObj() {
        return null;
    }
    
    public final void setDeviceTwoObj(@org.jetbrains.annotations.Nullable()
    llc.aerMist.app.models.MyDevice p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDeviceThree() {
        return null;
    }
    
    public final void setDeviceThree(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final llc.aerMist.app.models.MyDevice getDeviceThreeObj() {
        return null;
    }
    
    public final void setDeviceThreeObj(@org.jetbrains.annotations.Nullable()
    llc.aerMist.app.models.MyDevice p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDeviceFour() {
        return null;
    }
    
    public final void setDeviceFour(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final llc.aerMist.app.models.MyDevice getDeviceFourObj() {
        return null;
    }
    
    public final void setDeviceFourObj(@org.jetbrains.annotations.Nullable()
    llc.aerMist.app.models.MyDevice p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.nio.charset.Charset getCharset() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getFirstDevice() {
        return null;
    }
    
    public final void setFirstDevice(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getFirstDeviceNewName() {
        return null;
    }
    
    public final void setFirstDeviceNewName(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.clj.fastble.data.BleDevice getFirstBleDevice() {
        return null;
    }
    
    public final void setFirstBleDevice(@org.jetbrains.annotations.Nullable()
    com.clj.fastble.data.BleDevice p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.bluetooth.BluetoothGatt getFirstGate() {
        return null;
    }
    
    public final void setFirstGate(@org.jetbrains.annotations.Nullable()
    android.bluetooth.BluetoothGatt p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSecondDevice() {
        return null;
    }
    
    public final void setSecondDevice(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSecondDeviceNewName() {
        return null;
    }
    
    public final void setSecondDeviceNewName(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getThirdDevice() {
        return null;
    }
    
    public final void setThirdDevice(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getThirdDeviceNewName() {
        return null;
    }
    
    public final void setThirdDeviceNewName(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getFourthDevice() {
        return null;
    }
    
    public final void setFourthDevice(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getFourthDeviceNewName() {
        return null;
    }
    
    public final void setFourthDeviceNewName(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.clj.fastble.data.BleDevice getSecondBleDevice() {
        return null;
    }
    
    public final void setSecondBleDevice(@org.jetbrains.annotations.Nullable()
    com.clj.fastble.data.BleDevice p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.bluetooth.BluetoothGatt getSecondGate() {
        return null;
    }
    
    public final void setSecondGate(@org.jetbrains.annotations.Nullable()
    android.bluetooth.BluetoothGatt p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.clj.fastble.data.BleDevice getThirdBleDevice() {
        return null;
    }
    
    public final void setThirdBleDevice(@org.jetbrains.annotations.Nullable()
    com.clj.fastble.data.BleDevice p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.bluetooth.BluetoothGatt getThirdGate() {
        return null;
    }
    
    public final void setThirdGate(@org.jetbrains.annotations.Nullable()
    android.bluetooth.BluetoothGatt p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.clj.fastble.data.BleDevice getFourthBleDevice() {
        return null;
    }
    
    public final void setFourthBleDevice(@org.jetbrains.annotations.Nullable()
    com.clj.fastble.data.BleDevice p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.bluetooth.BluetoothGatt getFourthGate() {
        return null;
    }
    
    public final void setFourthGate(@org.jetbrains.annotations.Nullable()
    android.bluetooth.BluetoothGatt p0) {
    }
    
    public final boolean getFirstTimerActiv() {
        return false;
    }
    
    public final void setFirstTimerActiv(boolean p0) {
    }
    
    public final boolean getSecondTimerActiv() {
        return false;
    }
    
    public final void setSecondTimerActiv(boolean p0) {
    }
    
    public final boolean getThirdTimerActiv() {
        return false;
    }
    
    public final void setThirdTimerActiv(boolean p0) {
    }
    
    public final boolean getFourthTimerActiv() {
        return false;
    }
    
    public final void setFourthTimerActiv(boolean p0) {
    }
    
    public final boolean getBluetoothEnabled() {
        return false;
    }
    
    public final void setBluetoothEnabled(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getWorkingTime() {
        return null;
    }
    
    public final void setWorkingTime(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final boolean isOn() {
        return false;
    }
    
    public final void setOn(boolean p0) {
    }
    
    public final boolean isNonStop() {
        return false;
    }
    
    public final void setNonStop(boolean p0) {
    }
    
    public final boolean isSprayingMode() {
        return false;
    }
    
    public final void setSprayingMode(boolean p0) {
    }
    
    public final boolean getMondayActive() {
        return false;
    }
    
    public final void setMondayActive(boolean p0) {
    }
    
    public final boolean getTuesdayActive() {
        return false;
    }
    
    public final void setTuesdayActive(boolean p0) {
    }
    
    public final boolean getWednesdayActive() {
        return false;
    }
    
    public final void setWednesdayActive(boolean p0) {
    }
    
    public final boolean getThursdayActive() {
        return false;
    }
    
    public final void setThursdayActive(boolean p0) {
    }
    
    public final boolean getFridayActive() {
        return false;
    }
    
    public final void setFridayActive(boolean p0) {
    }
    
    public final boolean getSaturdayActive() {
        return false;
    }
    
    public final void setSaturdayActive(boolean p0) {
    }
    
    public final boolean getSundayActive() {
        return false;
    }
    
    public final void setSundayActive(boolean p0) {
    }
    
    public final boolean isSprayPerDay() {
        return false;
    }
    
    public final void setSprayPerDay(boolean p0) {
    }
    
    public final boolean isSprayFriquencu() {
        return false;
    }
    
    public final void setSprayFriquencu(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getFirstStartTime() {
        return null;
    }
    
    public final void setFirstStartTime(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSecondStartTime() {
        return null;
    }
    
    public final void setSecondStartTime(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getThirdStartTime() {
        return null;
    }
    
    public final void setThirdStartTime(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getFourtStartTime() {
        return null;
    }
    
    public final void setFourtStartTime(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getFirstStopTime() {
        return null;
    }
    
    public final void setFirstStopTime(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSecondStopTime() {
        return null;
    }
    
    public final void setSecondStopTime(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getThirdStopTime() {
        return null;
    }
    
    public final void setThirdStopTime(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getFourtStopTime() {
        return null;
    }
    
    public final void setFourtStopTime(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getMistTime() {
        return null;
    }
    
    public final void setMistTime(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSuspendTime() {
        return null;
    }
    
    public final void setSuspendTime(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDeviceNameValue() {
        return null;
    }
    
    public final void setDeviceNameValue(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTime() {
        return null;
    }
    
    public final void setTime(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getShortString() {
        return null;
    }
    
    public final void setShortString(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getShortString2() {
        return null;
    }
    
    public final void setShortString2(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getShortString3() {
        return null;
    }
    
    public final void setShortString3(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getShortString4() {
        return null;
    }
    
    public final void setShortString4(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getWorkingTime2() {
        return null;
    }
    
    public final void setWorkingTime2(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final boolean isOn2() {
        return false;
    }
    
    public final void setOn2(boolean p0) {
    }
    
    public final boolean isNonStop2() {
        return false;
    }
    
    public final void setNonStop2(boolean p0) {
    }
    
    public final boolean isSprayingMode2() {
        return false;
    }
    
    public final void setSprayingMode2(boolean p0) {
    }
    
    public final boolean getMondayActive2() {
        return false;
    }
    
    public final void setMondayActive2(boolean p0) {
    }
    
    public final boolean getTuesdayActive2() {
        return false;
    }
    
    public final void setTuesdayActive2(boolean p0) {
    }
    
    public final boolean getWednesdayActive2() {
        return false;
    }
    
    public final void setWednesdayActive2(boolean p0) {
    }
    
    public final boolean getThursdayActive2() {
        return false;
    }
    
    public final void setThursdayActive2(boolean p0) {
    }
    
    public final boolean getFridayActive2() {
        return false;
    }
    
    public final void setFridayActive2(boolean p0) {
    }
    
    public final boolean getSaturdayActive2() {
        return false;
    }
    
    public final void setSaturdayActive2(boolean p0) {
    }
    
    public final boolean getSundayActive2() {
        return false;
    }
    
    public final void setSundayActive2(boolean p0) {
    }
    
    public final boolean isSprayPerDay2() {
        return false;
    }
    
    public final void setSprayPerDay2(boolean p0) {
    }
    
    public final boolean isSprayFriquencu2() {
        return false;
    }
    
    public final void setSprayFriquencu2(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getFirstStartTime2() {
        return null;
    }
    
    public final void setFirstStartTime2(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSecondStartTime2() {
        return null;
    }
    
    public final void setSecondStartTime2(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getThirdStartTime2() {
        return null;
    }
    
    public final void setThirdStartTime2(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getFourtStartTime2() {
        return null;
    }
    
    public final void setFourtStartTime2(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getFirstStopTime2() {
        return null;
    }
    
    public final void setFirstStopTime2(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSecondStopTime2() {
        return null;
    }
    
    public final void setSecondStopTime2(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getThirdStopTime2() {
        return null;
    }
    
    public final void setThirdStopTime2(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getFourtStopTime2() {
        return null;
    }
    
    public final void setFourtStopTime2(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getMistTime2() {
        return null;
    }
    
    public final void setMistTime2(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSuspendTime2() {
        return null;
    }
    
    public final void setSuspendTime2(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final boolean getFirstTimerActiv2() {
        return false;
    }
    
    public final void setFirstTimerActiv2(boolean p0) {
    }
    
    public final boolean getSecondTimerActiv2() {
        return false;
    }
    
    public final void setSecondTimerActiv2(boolean p0) {
    }
    
    public final boolean getThirdTimerActiv2() {
        return false;
    }
    
    public final void setThirdTimerActiv2(boolean p0) {
    }
    
    public final boolean getFourthTimerActiv2() {
        return false;
    }
    
    public final void setFourthTimerActiv2(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDateAndTimeSynch() {
        return null;
    }
    
    public final void setDateAndTimeSynch(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getFirstCommand() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getWorkingTime3() {
        return null;
    }
    
    public final void setWorkingTime3(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final boolean isOn3() {
        return false;
    }
    
    public final void setOn3(boolean p0) {
    }
    
    public final boolean isNonStop3() {
        return false;
    }
    
    public final void setNonStop3(boolean p0) {
    }
    
    public final boolean isSprayingMode3() {
        return false;
    }
    
    public final void setSprayingMode3(boolean p0) {
    }
    
    public final boolean getMondayActive3() {
        return false;
    }
    
    public final void setMondayActive3(boolean p0) {
    }
    
    public final boolean getTuesdayActive3() {
        return false;
    }
    
    public final void setTuesdayActive3(boolean p0) {
    }
    
    public final boolean getWednesdayActive3() {
        return false;
    }
    
    public final void setWednesdayActive3(boolean p0) {
    }
    
    public final boolean getThursdayActive3() {
        return false;
    }
    
    public final void setThursdayActive3(boolean p0) {
    }
    
    public final boolean getFridayActive3() {
        return false;
    }
    
    public final void setFridayActive3(boolean p0) {
    }
    
    public final boolean getSaturdayActive3() {
        return false;
    }
    
    public final void setSaturdayActive3(boolean p0) {
    }
    
    public final boolean getSundayActive3() {
        return false;
    }
    
    public final void setSundayActive3(boolean p0) {
    }
    
    public final boolean isSprayPerDay3() {
        return false;
    }
    
    public final void setSprayPerDay3(boolean p0) {
    }
    
    public final boolean isSprayFriquencu3() {
        return false;
    }
    
    public final void setSprayFriquencu3(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getFirstStartTime3() {
        return null;
    }
    
    public final void setFirstStartTime3(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSecondStartTime3() {
        return null;
    }
    
    public final void setSecondStartTime3(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getThirdStartTime3() {
        return null;
    }
    
    public final void setThirdStartTime3(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getFourtStartTime3() {
        return null;
    }
    
    public final void setFourtStartTime3(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getFirstStopTime3() {
        return null;
    }
    
    public final void setFirstStopTime3(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSecondStopTime3() {
        return null;
    }
    
    public final void setSecondStopTime3(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getThirdStopTime3() {
        return null;
    }
    
    public final void setThirdStopTime3(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getFourtStopTime3() {
        return null;
    }
    
    public final void setFourtStopTime3(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getMistTime3() {
        return null;
    }
    
    public final void setMistTime3(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSuspendTime3() {
        return null;
    }
    
    public final void setSuspendTime3(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final boolean getFirstTimerActiv3() {
        return false;
    }
    
    public final void setFirstTimerActiv3(boolean p0) {
    }
    
    public final boolean getSecondTimerActiv3() {
        return false;
    }
    
    public final void setSecondTimerActiv3(boolean p0) {
    }
    
    public final boolean getThirdTimerActiv3() {
        return false;
    }
    
    public final void setThirdTimerActiv3(boolean p0) {
    }
    
    public final boolean getFourthTimerActiv3() {
        return false;
    }
    
    public final void setFourthTimerActiv3(boolean p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.content.DialogInterface getDialogInterface() {
        return null;
    }
    
    public final void setDialogInterface(@org.jetbrains.annotations.Nullable()
    android.content.DialogInterface p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getWorkingTime4() {
        return null;
    }
    
    public final void setWorkingTime4(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final boolean isOn4() {
        return false;
    }
    
    public final void setOn4(boolean p0) {
    }
    
    public final boolean isNonStop4() {
        return false;
    }
    
    public final void setNonStop4(boolean p0) {
    }
    
    public final boolean isSprayingMode4() {
        return false;
    }
    
    public final void setSprayingMode4(boolean p0) {
    }
    
    public final boolean getMondayActive4() {
        return false;
    }
    
    public final void setMondayActive4(boolean p0) {
    }
    
    public final boolean getTuesdayActive4() {
        return false;
    }
    
    public final void setTuesdayActive4(boolean p0) {
    }
    
    public final boolean getWednesdayActive4() {
        return false;
    }
    
    public final void setWednesdayActive4(boolean p0) {
    }
    
    public final boolean getThursdayActive4() {
        return false;
    }
    
    public final void setThursdayActive4(boolean p0) {
    }
    
    public final boolean getFridayActive4() {
        return false;
    }
    
    public final void setFridayActive4(boolean p0) {
    }
    
    public final boolean getSaturdayActive4() {
        return false;
    }
    
    public final void setSaturdayActive4(boolean p0) {
    }
    
    public final boolean getSundayActive4() {
        return false;
    }
    
    public final void setSundayActive4(boolean p0) {
    }
    
    public final boolean isSprayPerDay4() {
        return false;
    }
    
    public final void setSprayPerDay4(boolean p0) {
    }
    
    public final boolean isSprayFriquencu4() {
        return false;
    }
    
    public final void setSprayFriquencu4(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getFirstStartTime4() {
        return null;
    }
    
    public final void setFirstStartTime4(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSecondStartTime4() {
        return null;
    }
    
    public final void setSecondStartTime4(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getThirdStartTime4() {
        return null;
    }
    
    public final void setThirdStartTime4(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getFourtStartTime4() {
        return null;
    }
    
    public final void setFourtStartTime4(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getFirstStopTime4() {
        return null;
    }
    
    public final void setFirstStopTime4(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSecondStopTime4() {
        return null;
    }
    
    public final void setSecondStopTime4(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getThirdStopTime4() {
        return null;
    }
    
    public final void setThirdStopTime4(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getFourtStopTime4() {
        return null;
    }
    
    public final void setFourtStopTime4(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getMistTime4() {
        return null;
    }
    
    public final void setMistTime4(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSuspendTime4() {
        return null;
    }
    
    public final void setSuspendTime4(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final boolean getFirstTimerActiv4() {
        return false;
    }
    
    public final void setFirstTimerActiv4(boolean p0) {
    }
    
    public final boolean getSecondTimerActiv4() {
        return false;
    }
    
    public final void setSecondTimerActiv4(boolean p0) {
    }
    
    public final boolean getThirdTimerActiv4() {
        return false;
    }
    
    public final void setThirdTimerActiv4(boolean p0) {
    }
    
    public final boolean getFourthTimerActiv4() {
        return false;
    }
    
    public final void setFourthTimerActiv4(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getBleDeviceToPass() {
        return null;
    }
    
    public final void setBleDeviceToPass(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final int getCounter() {
        return 0;
    }
    
    public final void setCounter(int p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onActivityCreated(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    public final void turnOnLocation() {
    }
    
    private final void onPermissionGranted(java.lang.String permission) {
    }
    
    @android.annotation.SuppressLint(value = {"SetTextI18n"})
    public final void connectDevices() {
    }
    
    public final void setFirstDevice() {
    }
    
    @android.annotation.SuppressLint(value = {"SetTextI18n"})
    public final void setSecondDevice() {
    }
    
    @android.annotation.SuppressLint(value = {"SetTextI18n"})
    public final void setThirdDevice() {
    }
    
    @android.annotation.SuppressLint(value = {"SetTextI18n"})
    public final void setFourthDevice() {
    }
    
    private final void navigateToWelcome() {
    }
    
    private final void navigateToHome() {
    }
    
    public final void connectDevice(@org.jetbrains.annotations.NotNull()
    com.clj.fastble.data.BleDevice bleDevice) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.clj.fastble.callback.BleGattCallback getGattCallback() {
        return null;
    }
    
    public final void navigateToDevice() {
    }
    
    public final void readResponse() {
    }
    
    public final void readSecondResponse() {
    }
    
    public final void readThirdResponse() {
    }
    
    public final void readFourthResponse() {
    }
    
    public final void sendCommand(@org.jetbrains.annotations.NotNull()
    byte[] input, @org.jetbrains.annotations.NotNull()
    com.clj.fastble.data.BleDevice bleDevice, @org.jetbrains.annotations.NotNull()
    android.bluetooth.BluetoothGatt gatt) {
    }
    
    public final void sendTimeSynchCommand(@org.jetbrains.annotations.NotNull()
    android.bluetooth.BluetoothGatt gatt, @org.jetbrains.annotations.NotNull()
    com.clj.fastble.data.BleDevice bleDevice) {
    }
    
    public final int getDayInWeek(@org.jetbrains.annotations.NotNull()
    java.lang.String day) {
        return 0;
    }
    
    private final java.lang.String getRegister(java.lang.String response) {
        return null;
    }
    
    public final void readTimerSync(@org.jetbrains.annotations.NotNull()
    java.lang.String response) {
    }
    
    public final void readTimerSync2(@org.jetbrains.annotations.NotNull()
    java.lang.String response) {
    }
    
    public final void readTimerSync3(@org.jetbrains.annotations.NotNull()
    java.lang.String response) {
    }
    
    public final void readTimerSync4(@org.jetbrains.annotations.NotNull()
    java.lang.String response) {
    }
    
    @java.lang.Override()
    public void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable()
    android.content.Intent data) {
    }
    
    public final void checkTotalNumber() {
    }
    
    @java.lang.Override()
    public void onDestroy() {
    }
    
    public SplashFragment() {
        super();
    }
}