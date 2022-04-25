package com.sbsj.myalarm

import android.app.TimePickerDialog
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initOnOffButton()
        initChangeAlarmButton()

    }


    private fun initOnOffButton() {
       val onOffButton = findViewById<Button>(R.id.onOffButton)
        onOffButton.setOnClickListener {

        }
    }

    private fun initChangeAlarmButton() {
        val changeAlarmButton = findViewById<Button>(R.id.changeAlarmBt)
        changeAlarmButton.setOnClickListener {
            val calendar = Calendar.getInstance()
            TimePickerDialog(this,{
                    picker,hour,minute->saveAlarmModel(hour,minute,false)



            },calendar.get(Calendar.HOUR_OF_DAY),calendar.get(Calendar.MINUTE),false)
                .show()


        }
    }

    private fun saveAlarmModel(hour : Int , minute :Int, onOff: Boolean) : AlarmDisplayModel{
        val model =  AlarmDisplayModel(hour= hour, minute = minute, onOff = onOff)

        val sharedPreferences = getSharedPreferences("time", Context.MODE_PRIVATE)
        with(sharedPreferences.edit()){
            putString("alarm",model.makeDataForDB())
            putBoolean("onOff",model.onOff)
            commit()
        }

        return model
    }


}