package llc.aerMist.app.models

import android.os.Parcelable
import java.io.Serializable

data class ScheduleModel (
    val days:IntArray?=null,
    val timer:List<TimerModel>?=null,
    val nonStop:Boolean?=null,
    val mist:String?=null,
    val suspend:String?=null
) : Serializable
{

}