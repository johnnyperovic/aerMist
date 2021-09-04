package llc.aerMis.production.models

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
    val firstStopTime:String="",
    val firstTimerActive:Boolean=false,
    val secondStartTime:String="",
    val secondStopTime:String="",
    val secondTimerActive:Boolean=false,
    val thirdStartTime:String="",
    val thirdStopTime:String="",
    val thirdTimerActive:Boolean=false,
    val fourtStartTime:String="",
    val fourtStopTime:String="",
    val fourthTimerActive:Boolean=false,
    val mistTime:String="",
    val suspendTime:String=""
)
{

}