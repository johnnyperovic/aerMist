package llc.aerMist.app.ui.devices;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u00c6\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b.\n\u0002\u0010\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0011\u0010\u00c2\u0001\u001a\u00030\u00c3\u00012\u0007\u0010\u00c4\u0001\u001a\u00020#J\u0011\u0010\u00c5\u0001\u001a\u00030\u00c3\u00012\u0007\u0010\u00c4\u0001\u001a\u00020#J\u0011\u0010\u00c6\u0001\u001a\u00030\u00c3\u00012\u0007\u0010\u00c4\u0001\u001a\u00020#J\u0010\u0010\u00c7\u0001\u001a\u00030\u00c3\u00012\u0006\u0010\n\u001a\u00020\u000bJ\b\u0010\u00c8\u0001\u001a\u00030\u00c3\u0001J\b\u0010\u00c9\u0001\u001a\u00030\u00c3\u0001J\b\u0010\u00ca\u0001\u001a\u00030\u00c3\u0001J\u0010\u0010\u00cb\u0001\u001a\u00020\u00052\u0007\u0010\u00cc\u0001\u001a\u00020#J\u0010\u0010\u00cd\u0001\u001a\u00020#2\u0007\u0010\u00ce\u0001\u001a\u00020#J\u0010\u0010\u00cf\u0001\u001a\u00020#2\u0007\u0010\u00d0\u0001\u001a\u00020#J\n\u0010\u00d1\u0001\u001a\u00030\u00c3\u0001H\u0002J\u0016\u0010\u00d2\u0001\u001a\u00030\u00c3\u00012\n\u0010\u00d3\u0001\u001a\u0005\u0018\u00010\u00d4\u0001H\u0017J(\u0010\u00d5\u0001\u001a\u00030\u00c3\u00012\u0007\u0010\u00d6\u0001\u001a\u00020\u00052\u0007\u0010\u00d7\u0001\u001a\u00020\u00052\n\u0010\u00d8\u0001\u001a\u0005\u0018\u00010\u00d9\u0001H\u0016J\u0016\u0010\u00da\u0001\u001a\u00030\u00c3\u00012\n\u0010\u00db\u0001\u001a\u0005\u0018\u00010\u00dc\u0001H\u0016J.\u0010\u00dd\u0001\u001a\u0005\u0018\u00010\u00dc\u00012\b\u0010\u00de\u0001\u001a\u00030\u00df\u00012\n\u0010\u00e0\u0001\u001a\u0005\u0018\u00010\u00e1\u00012\n\u0010\u00d3\u0001\u001a\u0005\u0018\u00010\u00d4\u0001H\u0016J!\u0010\u00e2\u0001\u001a\u00030\u00c3\u00012\u0007\u0010\u00e3\u0001\u001a\u00020\u00152\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010E\u001a\u00020FJ\b\u0010\u00e4\u0001\u001a\u00030\u00c3\u0001J\b\u0010\u00e5\u0001\u001a\u00030\u00c3\u0001J\b\u0010\u00e6\u0001\u001a\u00030\u00c3\u0001J\b\u0010\u00e7\u0001\u001a\u00030\u00c3\u0001J\b\u0010\u00e8\u0001\u001a\u00030\u00c3\u0001J\b\u0010\u00e9\u0001\u001a\u00030\u00c3\u0001J\b\u0010\u00ea\u0001\u001a\u00030\u00c3\u0001J\b\u0010\u00eb\u0001\u001a\u00030\u00c3\u0001J\b\u0010\u00ec\u0001\u001a\u00030\u00c3\u0001J\u0011\u0010\u00ed\u0001\u001a\u00030\u00c3\u00012\u0007\u0010\u00ee\u0001\u001a\u00020bJ\u0019\u0010\u00ef\u0001\u001a\u00020#2\u0007\u0010\u00f0\u0001\u001a\u00020#2\u0007\u0010\u00f1\u0001\u001a\u00020#J\u0010\u0010\u00f2\u0001\u001a\u00020#2\u0007\u0010\u00f0\u0001\u001a\u00020#J\b\u0010\u00f3\u0001\u001a\u00030\u00c3\u0001J\b\u0010\u00f4\u0001\u001a\u00030\u00c3\u0001J\b\u0010\u00f5\u0001\u001a\u00030\u00c3\u0001R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0011\u0010\u001a\u001a\u00020\u001b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u001e\u001a\u00020\u001f\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020#X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010\'R\u001a\u0010(\u001a\u00020)X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001a\u0010.\u001a\u00020#X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b/\u0010%\"\u0004\b0\u0010\'R\u001a\u00101\u001a\u000202X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u0010\u00107\u001a\u0004\u0018\u000108X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u00109\u001a\u00020#X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b:\u0010%\"\u0004\b;\u0010\'R\u001a\u0010<\u001a\u00020#X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b=\u0010%\"\u0004\b>\u0010\'R\u001a\u0010?\u001a\u00020#X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b@\u0010%\"\u0004\bA\u0010\'R\u001a\u0010B\u001a\u00020#X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bC\u0010%\"\u0004\bD\u0010\'R\u0010\u0010E\u001a\u0004\u0018\u00010FX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020HX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010I\u001a\u00020\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\bJ\u0010\u0017R\u0011\u0010K\u001a\u00020\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\bL\u0010\u0017R\u0011\u0010M\u001a\u00020\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\bN\u0010\u0017R\u0011\u0010O\u001a\u00020\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\bP\u0010\u0017R\u0011\u0010Q\u001a\u00020\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\bR\u0010\u0017R\u0011\u0010S\u001a\u00020\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\bT\u0010\u0017R\u0011\u0010U\u001a\u00020\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\bV\u0010\u0017R\u0011\u0010W\u001a\u00020\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\bX\u0010\u0017R\u0011\u0010Y\u001a\u00020\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\bZ\u0010\u0017R\u001a\u0010[\u001a\u00020\u0015X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010\u0017\"\u0004\b]\u0010^R\u0011\u0010_\u001a\u00020\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b`\u0010\u0017R\u001a\u0010a\u001a\u00020bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\ba\u0010c\"\u0004\bd\u0010eR\u001a\u0010f\u001a\u00020bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bf\u0010c\"\u0004\bg\u0010eR\u001a\u0010h\u001a\u00020bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bh\u0010c\"\u0004\bi\u0010eR\u001a\u0010j\u001a\u00020bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bj\u0010c\"\u0004\bk\u0010eR\u001a\u0010l\u001a\u00020bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bl\u0010c\"\u0004\bm\u0010eR\u001a\u0010n\u001a\u00020bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bn\u0010c\"\u0004\bo\u0010eR\u001a\u0010p\u001a\u00020bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bp\u0010c\"\u0004\bq\u0010eR\u001a\u0010r\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bs\u0010\u0007\"\u0004\bt\u0010\tR\u000e\u0010u\u001a\u00020#X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010v\u001a\u00020#X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bw\u0010%\"\u0004\bx\u0010\'R\u0011\u0010y\u001a\u00020\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\bz\u0010\u0017R\u001b\u0010{\u001a\u00020|X\u0086\u000e\u00a2\u0006\u000f\n\u0000\u001a\u0004\b}\u0010~\"\u0005\b\u007f\u0010\u0080\u0001R!\u0010\u0081\u0001\u001a\u00030\u0082\u00018BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u0085\u0001\u0010\u0086\u0001\u001a\u0006\b\u0083\u0001\u0010\u0084\u0001R\u001d\u0010\u0087\u0001\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0088\u0001\u0010\u0007\"\u0005\b\u0089\u0001\u0010\tR\u001d\u0010\u008a\u0001\u001a\u00020#X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u008b\u0001\u0010%\"\u0005\b\u008c\u0001\u0010\'R\u0016\u0010\u008d\u0001\u001a\u00020#X\u0086D\u00a2\u0006\t\n\u0000\u001a\u0005\b\u008e\u0001\u0010%R\u0016\u0010\u008f\u0001\u001a\u00020#X\u0086D\u00a2\u0006\t\n\u0000\u001a\u0005\b\u0090\u0001\u0010%R\u0012\u0010\u0091\u0001\u001a\u0005\u0018\u00010\u0092\u0001X\u0082\u000e\u00a2\u0006\u0002\n\u0000R!\u0010\u0093\u0001\u001a\u00030\u0094\u00018BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u0097\u0001\u0010\u0098\u0001\u001a\u0006\b\u0095\u0001\u0010\u0096\u0001R\u0016\u0010\u0099\u0001\u001a\u00020#X\u0086D\u00a2\u0006\t\n\u0000\u001a\u0005\b\u009a\u0001\u0010%R\u0016\u0010\u009b\u0001\u001a\u00020#X\u0086D\u00a2\u0006\t\n\u0000\u001a\u0005\b\u009c\u0001\u0010%R\u0016\u0010\u009d\u0001\u001a\u00020#X\u0086D\u00a2\u0006\t\n\u0000\u001a\u0005\b\u009e\u0001\u0010%R\u0016\u0010\u009f\u0001\u001a\u00020#X\u0086D\u00a2\u0006\t\n\u0000\u001a\u0005\b\u00a0\u0001\u0010%R\u0016\u0010\u00a1\u0001\u001a\u00020#X\u0086D\u00a2\u0006\t\n\u0000\u001a\u0005\b\u00a2\u0001\u0010%R\u001d\u0010\u00a3\u0001\u001a\u00020#X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00a4\u0001\u0010%\"\u0005\b\u00a5\u0001\u0010\'R\u001d\u0010\u00a6\u0001\u001a\u00020#X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00a7\u0001\u0010%\"\u0005\b\u00a8\u0001\u0010\'R\u0013\u0010\u00a9\u0001\u001a\u00020\u0015\u00a2\u0006\t\n\u0000\u001a\u0005\b\u00aa\u0001\u0010\u0017R\u001d\u0010\u00ab\u0001\u001a\u00020#X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00ac\u0001\u0010%\"\u0005\b\u00ad\u0001\u0010\'R\u001d\u0010\u00ae\u0001\u001a\u00020\u0015X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00af\u0001\u0010\u0017\"\u0005\b\u00b0\u0001\u0010^R\u001d\u0010\u00b1\u0001\u001a\u00020#X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00b2\u0001\u0010%\"\u0005\b\u00b3\u0001\u0010\'R\u000f\u0010\u00b4\u0001\u001a\u00020#X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000f\u0010\u00b5\u0001\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u00b6\u0001\u001a\u00020#X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00b7\u0001\u0010%\"\u0005\b\u00b8\u0001\u0010\'R\u001d\u0010\u00b9\u0001\u001a\u00020#X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00ba\u0001\u0010%\"\u0005\b\u00bb\u0001\u0010\'R\u001d\u0010\u00bc\u0001\u001a\u00020#X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00bd\u0001\u0010%\"\u0005\b\u00be\u0001\u0010\'R\u001d\u0010\u00bf\u0001\u001a\u00020#X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00c0\u0001\u0010%\"\u0005\b\u00c1\u0001\u0010\'\u00a8\u0006\u00f6\u0001"}, d2 = {"Lllc/aerMist/app/ui/devices/SetDeviceFragment;", "Landroidx/fragment/app/Fragment;", "Landroid/view/View$OnClickListener;", "()V", "allDevices", "", "getAllDevices", "()I", "setAllDevices", "(I)V", "bleDevice", "Lcom/clj/fastble/data/BleDevice;", "bleList", "Ljava/util/ArrayList;", "bluetoothController", "Lllc/aerMist/app/helpers/BluetoothController;", "getBluetoothController", "()Lllc/aerMist/app/helpers/BluetoothController;", "setBluetoothController", "(Lllc/aerMist/app/helpers/BluetoothController;)V", "byteArrayOF", "", "getByteArrayOF", "()[B", "byteArrayON", "getByteArrayON", "charset", "Ljava/nio/charset/Charset;", "getCharset", "()Ljava/nio/charset/Charset;", "connectionStateCoordinator", "Lllc/aerMist/app/observers/NewObservableCoordinator;", "getConnectionStateCoordinator", "()Lllc/aerMist/app/observers/NewObservableCoordinator;", "dateAndTimeSynch", "", "getDateAndTimeSynch", "()Ljava/lang/String;", "setDateAndTimeSynch", "(Ljava/lang/String;)V", "daysInWeek", "", "getDaysInWeek", "()[I", "setDaysInWeek", "([I)V", "deviceNameValue", "getDeviceNameValue", "setDeviceNameValue", "deviceObject", "Lllc/aerMist/app/models/MyDevice;", "getDeviceObject", "()Lllc/aerMist/app/models/MyDevice;", "setDeviceObject", "(Lllc/aerMist/app/models/MyDevice;)V", "dialogDisconnectedDevice", "Lllc/aerMist/app/ui/popup/DevicesDisconnected;", "filterTime", "getFilterTime", "setFilterTime", "firstTimer", "getFirstTimer", "setFirstTimer", "fourthTimer", "getFourthTimer", "setFourthTimer", "friday", "getFriday", "setFriday", "gatt", "Landroid/bluetooth/BluetoothGatt;", "gattCallback", "Lcom/clj/fastble/callback/BleGattCallback;", "intervalFR", "getIntervalFR", "intervalFS", "getIntervalFS", "intervalMo", "getIntervalMo", "intervalOn", "getIntervalOn", "intervalSA", "getIntervalSA", "intervalSS", "getIntervalSS", "intervalSU", "getIntervalSU", "intervalTH", "getIntervalTH", "intervalTu", "getIntervalTu", "intervalValue", "getIntervalValue", "setIntervalValue", "([B)V", "intervalWE", "getIntervalWE", "isFromDB", "", "()Z", "setFromDB", "(Z)V", "isIntervalCommandSend", "setIntervalCommandSend", "isNonSTtopActiv", "setNonSTtopActiv", "isNonStopCommandSend", "setNonStopCommandSend", "isScheduleCommandSend", "setScheduleCommandSend", "isSelected", "setSelected", "isTimeSync", "setTimeSync", "mainDevicePositon", "getMainDevicePositon", "setMainDevicePositon", "mistValueSeconds", "monday", "getMonday", "setMonday", "nonStopOn", "getNonStopOn", "numberPickerPopup", "Lllc/aerMist/app/ui/popup/NumberPickerPopup;", "getNumberPickerPopup", "()Lllc/aerMist/app/ui/popup/NumberPickerPopup;", "setNumberPickerPopup", "(Lllc/aerMist/app/ui/popup/NumberPickerPopup;)V", "prefs", "Lllc/aerMist/app/shared/util/PreferenceCache;", "getPrefs", "()Lllc/aerMist/app/shared/util/PreferenceCache;", "prefs$delegate", "Lkotlin/Lazy;", "responseTimmer", "getResponseTimmer", "setResponseTimmer", "saturday", "getSaturday", "setSaturday", "scheduleFR", "getScheduleFR", "scheduleMo", "getScheduleMo", "scheduleModel", "Lllc/aerMist/app/models/ScheduleModel;", "scheduleModelArgs", "Lllc/aerMist/app/ui/devices/SetDeviceFragmentArgs;", "getScheduleModelArgs", "()Lllc/aerMist/app/ui/devices/SetDeviceFragmentArgs;", "scheduleModelArgs$delegate", "Landroidx/navigation/NavArgsLazy;", "scheduleSA", "getScheduleSA", "scheduleSU", "getScheduleSU", "scheduleTH", "getScheduleTH", "scheduleTu", "getScheduleTu", "scheduleWE", "getScheduleWE", "secondTimer", "getSecondTimer", "setSecondTimer", "singleDeviceName", "getSingleDeviceName", "setSingleDeviceName", "sprayFriq", "getSprayFriq", "sprayFriquency", "getSprayFriquency", "setSprayFriquency", "sprayPDON", "getSprayPDON", "setSprayPDON", "sunday", "getSunday", "setSunday", "suspendValueSeconds", "tag", "thirdTimer", "getThirdTimer", "setThirdTimer", "thursday", "getThursday", "setThursday", "tuesday", "getTuesday", "setTuesday", "wednesday", "getWednesday", "setWednesday", "checkIntervalResponse", "", "response", "checkNonStopResponse", "checkScheduleRespone", "connectDevice", "formatDaySchedule", "formatTimer", "getActiveDaysFromDb", "getDayInWeek", "day", "getSeconds", "value", "getTimeFromSeconds", "seconds", "navigateToSetSchedule", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onClick", "id", "Landroid/view/View;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "sendCommand", "input", "sendTimeSynchCommand", "setActiveScheduleView", "setClickListener", "setDisplayMode", "setIntervalView", "setMotionLayoutListener", "setNonStopView", "setNumberPicker", "setScheduleView", "setTabItemVisibility", "state", "setTimeZone", "time", "format", "setTimeZone2", "setTouchSwipeListener", "setViewAndSendCommand", "showDisconnectedDeviceDialog", "app_localApiDebug"})
public final class SetDeviceFragment extends androidx.fragment.app.Fragment implements android.view.View.OnClickListener {
    private final kotlin.Lazy prefs$delegate = null;
    private int tag = 0;
    @org.jetbrains.annotations.NotNull()
    private llc.aerMist.app.ui.popup.NumberPickerPopup numberPickerPopup;
    public llc.aerMist.app.helpers.BluetoothController bluetoothController;
    @org.jetbrains.annotations.NotNull()
    private final llc.aerMist.app.observers.NewObservableCoordinator connectionStateCoordinator = null;
    private com.clj.fastble.data.BleDevice bleDevice;
    private android.bluetooth.BluetoothGatt gatt;
    private java.lang.String mistValueSeconds = "005";
    private java.lang.String suspendValueSeconds = "005";
    private final androidx.navigation.NavArgsLazy scheduleModelArgs$delegate = null;
    private llc.aerMist.app.models.ScheduleModel scheduleModel;
    private llc.aerMist.app.ui.popup.DevicesDisconnected dialogDisconnectedDevice;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String dateAndTimeSynch = "";
    private boolean isTimeSync = true;
    private boolean isSelected = false;
    @org.jetbrains.annotations.NotNull()
    private final java.nio.charset.Charset charset = null;
    @org.jetbrains.annotations.NotNull()
    private final byte[] nonStopOn = null;
    @org.jetbrains.annotations.NotNull()
    private final byte[] byteArrayON = null;
    @org.jetbrains.annotations.NotNull()
    private final byte[] byteArrayOF = null;
    @org.jetbrains.annotations.NotNull()
    private final byte[] intervalOn = null;
    @org.jetbrains.annotations.NotNull()
    private final byte[] intervalMo = null;
    @org.jetbrains.annotations.NotNull()
    private final byte[] intervalTu = null;
    @org.jetbrains.annotations.NotNull()
    private final byte[] intervalWE = null;
    @org.jetbrains.annotations.NotNull()
    private final byte[] intervalTH = null;
    @org.jetbrains.annotations.NotNull()
    private final byte[] intervalFR = null;
    @org.jetbrains.annotations.NotNull()
    private final byte[] intervalSA = null;
    @org.jetbrains.annotations.NotNull()
    private final byte[] intervalSU = null;
    @org.jetbrains.annotations.NotNull()
    private final byte[] intervalSS = null;
    @org.jetbrains.annotations.NotNull()
    private final byte[] intervalFS = null;
    private int responseTimmer = 0;
    @org.jetbrains.annotations.NotNull()
    private byte[] intervalValue;
    @org.jetbrains.annotations.NotNull()
    private byte[] sprayPDON;
    @org.jetbrains.annotations.NotNull()
    private final byte[] sprayFriq = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String scheduleMo = "EE0300";
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String scheduleTu = "EE0301";
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String scheduleWE = "EE0302";
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String scheduleTH = "EE0303";
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String scheduleFR = "EE0304";
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String scheduleSA = "EE0305";
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String scheduleSU = "EE0306";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String monday = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String tuesday = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String wednesday = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String thursday = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String friday = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String saturday = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String sunday = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String firstTimer = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String secondTimer = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String thirdTimer = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String fourthTimer = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String sprayFriquency = "";
    public int[] daysInWeek;
    public llc.aerMist.app.models.MyDevice deviceObject;
    private boolean isNonSTtopActiv = true;
    private int mainDevicePositon = 0;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String deviceNameValue = "";
    private int allDevices = 0;
    private java.util.ArrayList<com.clj.fastble.data.BleDevice> bleList;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String singleDeviceName = "";
    private boolean isFromDB = true;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String filterTime = "";
    private boolean isScheduleCommandSend = false;
    private boolean isNonStopCommandSend = false;
    private boolean isIntervalCommandSend = false;
    private final com.clj.fastble.callback.BleGattCallback gattCallback = null;
    private java.util.HashMap _$_findViewCache;
    
    private final llc.aerMist.app.shared.util.PreferenceCache getPrefs() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final llc.aerMist.app.ui.popup.NumberPickerPopup getNumberPickerPopup() {
        return null;
    }
    
    public final void setNumberPickerPopup(@org.jetbrains.annotations.NotNull()
    llc.aerMist.app.ui.popup.NumberPickerPopup p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final llc.aerMist.app.helpers.BluetoothController getBluetoothController() {
        return null;
    }
    
    public final void setBluetoothController(@org.jetbrains.annotations.NotNull()
    llc.aerMist.app.helpers.BluetoothController p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final llc.aerMist.app.observers.NewObservableCoordinator getConnectionStateCoordinator() {
        return null;
    }
    
    private final llc.aerMist.app.ui.devices.SetDeviceFragmentArgs getScheduleModelArgs() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDateAndTimeSynch() {
        return null;
    }
    
    public final void setDateAndTimeSynch(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final boolean isTimeSync() {
        return false;
    }
    
    public final void setTimeSync(boolean p0) {
    }
    
    public final boolean isSelected() {
        return false;
    }
    
    public final void setSelected(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.nio.charset.Charset getCharset() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final byte[] getNonStopOn() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final byte[] getByteArrayON() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final byte[] getByteArrayOF() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final byte[] getIntervalOn() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final byte[] getIntervalMo() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final byte[] getIntervalTu() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final byte[] getIntervalWE() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final byte[] getIntervalTH() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final byte[] getIntervalFR() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final byte[] getIntervalSA() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final byte[] getIntervalSU() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final byte[] getIntervalSS() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final byte[] getIntervalFS() {
        return null;
    }
    
    public final int getResponseTimmer() {
        return 0;
    }
    
    public final void setResponseTimmer(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final byte[] getIntervalValue() {
        return null;
    }
    
    public final void setIntervalValue(@org.jetbrains.annotations.NotNull()
    byte[] p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final byte[] getSprayPDON() {
        return null;
    }
    
    public final void setSprayPDON(@org.jetbrains.annotations.NotNull()
    byte[] p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final byte[] getSprayFriq() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getScheduleMo() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getScheduleTu() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getScheduleWE() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getScheduleTH() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getScheduleFR() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getScheduleSA() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getScheduleSU() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getMonday() {
        return null;
    }
    
    public final void setMonday(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTuesday() {
        return null;
    }
    
    public final void setTuesday(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getWednesday() {
        return null;
    }
    
    public final void setWednesday(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getThursday() {
        return null;
    }
    
    public final void setThursday(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getFriday() {
        return null;
    }
    
    public final void setFriday(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSaturday() {
        return null;
    }
    
    public final void setSaturday(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSunday() {
        return null;
    }
    
    public final void setSunday(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getFirstTimer() {
        return null;
    }
    
    public final void setFirstTimer(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSecondTimer() {
        return null;
    }
    
    public final void setSecondTimer(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getThirdTimer() {
        return null;
    }
    
    public final void setThirdTimer(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getFourthTimer() {
        return null;
    }
    
    public final void setFourthTimer(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSprayFriquency() {
        return null;
    }
    
    public final void setSprayFriquency(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final int[] getDaysInWeek() {
        return null;
    }
    
    public final void setDaysInWeek(@org.jetbrains.annotations.NotNull()
    int[] p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final llc.aerMist.app.models.MyDevice getDeviceObject() {
        return null;
    }
    
    public final void setDeviceObject(@org.jetbrains.annotations.NotNull()
    llc.aerMist.app.models.MyDevice p0) {
    }
    
    public final boolean isNonSTtopActiv() {
        return false;
    }
    
    public final void setNonSTtopActiv(boolean p0) {
    }
    
    public final int getMainDevicePositon() {
        return 0;
    }
    
    public final void setMainDevicePositon(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDeviceNameValue() {
        return null;
    }
    
    public final void setDeviceNameValue(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final int getAllDevices() {
        return 0;
    }
    
    public final void setAllDevices(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSingleDeviceName() {
        return null;
    }
    
    public final void setSingleDeviceName(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final boolean isFromDB() {
        return false;
    }
    
    public final void setFromDB(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getFilterTime() {
        return null;
    }
    
    public final void setFilterTime(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final boolean isScheduleCommandSend() {
        return false;
    }
    
    public final void setScheduleCommandSend(boolean p0) {
    }
    
    public final boolean isNonStopCommandSend() {
        return false;
    }
    
    public final void setNonStopCommandSend(boolean p0) {
    }
    
    public final boolean isIntervalCommandSend() {
        return false;
    }
    
    public final void setIntervalCommandSend(boolean p0) {
    }
    
    @android.annotation.SuppressLint(value = {"ClickableViewAccessibility", "SetTextI18n"})
    @java.lang.Override()
    public void onActivityCreated(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    public final void connectDevice(@org.jetbrains.annotations.NotNull()
    com.clj.fastble.data.BleDevice bleDevice) {
    }
    
    public final void showDisconnectedDeviceDialog() {
    }
    
    public final void setDisplayMode() {
    }
    
    public final void sendTimeSynchCommand() {
    }
    
    public final int getDayInWeek(@org.jetbrains.annotations.NotNull()
    java.lang.String day) {
        return 0;
    }
    
    public final void setActiveScheduleView() {
    }
    
    public final void formatDaySchedule() {
    }
    
    public final void checkNonStopResponse(@org.jetbrains.annotations.NotNull()
    java.lang.String response) {
    }
    
    public final void checkIntervalResponse(@org.jetbrains.annotations.NotNull()
    java.lang.String response) {
    }
    
    public final void checkScheduleRespone(@org.jetbrains.annotations.NotNull()
    java.lang.String response) {
    }
    
    public final void formatTimer() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String setTimeZone2(@org.jetbrains.annotations.NotNull()
    java.lang.String time) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String setTimeZone(@org.jetbrains.annotations.NotNull()
    java.lang.String time, @org.jetbrains.annotations.NotNull()
    java.lang.String format) {
        return null;
    }
    
    public final void setClickListener() {
    }
    
    @java.lang.Override()
    public void onClick(@org.jetbrains.annotations.Nullable()
    android.view.View id) {
    }
    
    public final void setMotionLayoutListener() {
    }
    
    public final void setTouchSwipeListener() {
    }
    
    public final void setTabItemVisibility(boolean state) {
    }
    
    public final void setViewAndSendCommand() {
    }
    
    public final void sendCommand(@org.jetbrains.annotations.NotNull()
    byte[] input, @org.jetbrains.annotations.NotNull()
    com.clj.fastble.data.BleDevice bleDevice, @org.jetbrains.annotations.NotNull()
    android.bluetooth.BluetoothGatt gatt) {
    }
    
    public final void setNumberPicker() {
    }
    
    @java.lang.Override()
    public void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable()
    android.content.Intent data) {
    }
    
    public final void setNonStopView() {
    }
    
    public final void setIntervalView() {
    }
    
    public final void setScheduleView() {
    }
    
    private final void navigateToSetSchedule() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSeconds(@org.jetbrains.annotations.NotNull()
    java.lang.String value) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTimeFromSeconds(@org.jetbrains.annotations.NotNull()
    java.lang.String seconds) {
        return null;
    }
    
    public final void getActiveDaysFromDb() {
    }
    
    public SetDeviceFragment() {
        super();
    }
}