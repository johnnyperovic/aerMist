package llc.aerMist.app.models

import com.clj.fastble.data.BleDevice

data class MyDevice (
    val name: String,
    val newName: String,
    val isConnected:Boolean,
    val workingTime:String="",
    val isOn:Boolean=false,
    val isNonStop: Boolean =false,
    val isSparayMode:Boolean=false,
    val monday:Boolean=false,
    val tuesday:Boolean=false,
    val wednesday:Boolean=false,
    val thursday:Boolean=false,
    val friday:Boolean=false,
    val saturday:Boolean=false,
    val sunday:Boolean=false,
    val isSprayPerDay:Boolean=false,
    val isFriquencyPerDay:Boolean=false,
    val firstStartTime:String="",
    val secondStartTime:String="",
    val thirdStartTime:String="",
    val fourtStartTime:String="",
    val firstStopTime:String="",
    val secondStopTime:String="",
    val thirdStopTime:String="",
    val fourtStopTime:String="",
    val mistTime:String="",
    val suspendTime:String=""
)
{

}