package com.sbsj.myalarm

data class AlarmDisplayModel(
    val hour: Int,
    val minute: Int,
    var onOff: Boolean
) {

    //데이터 가공처리 get 할떄 호출되는 함수입니다.
    val timeText: String
        get() {
            val h = "%02d".format(if (hour < 12) hour else hour - 12)
            val m = "%02d".format(minute)

            return "$h:$m"
        }
    val ampmText: String
        get() {
            return if(hour<12) "AM" else "PM"
        }

    fun makeDataForDB():String {
        return "$hour:$minute"
    }
}