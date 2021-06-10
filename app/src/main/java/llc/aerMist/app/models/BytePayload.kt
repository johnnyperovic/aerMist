package llc.aerMist.app.models

data class BytePayload(val data: UIntArray) {
    var one = data.get(0)
    var two = data.get(1)
    var three = data.get(2)
    var four = data.get(3)
    var five = data.get(4)
//    var sex = data.get(5)
//    var seven = data.get(6)
//    var eight = data.get(7)
//    var nine = data.get(8)
//    var teen = data.get(9)
//    var eleven = data.get(10)
//    var twelwe = data.get(11)
//    var thirteen = data.get(12)
//    var forteen = data.get(13)
}