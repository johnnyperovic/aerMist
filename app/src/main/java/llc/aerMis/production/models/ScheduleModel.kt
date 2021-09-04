package llc.aerMis.production.models

import android.os.Parcel
import android.os.Parcelable

data class ScheduleModel (
    val days:IntArray?=null,
    val timer:List<TimerModel>?=null,
    val timerToSend:List<TimerModel>?=null,
    val nonStop:Boolean?=null,
    val mist:String?=null,
    val suspend:String?=null
) : Parcelable
{


    constructor(parcel: Parcel) : this(
        parcel.createIntArray(),
        TODO("timer"),
        TODO("timerToSend"),
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeIntArray(days)
        parcel.writeValue(nonStop)
        parcel.writeString(mist)
        parcel.writeString(suspend)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ScheduleModel> {
        override fun createFromParcel(parcel: Parcel): ScheduleModel {
            return ScheduleModel(parcel)
        }

        override fun newArray(size: Int): Array<ScheduleModel?> {
            return arrayOfNulls(size)
        }
    }


}