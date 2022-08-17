package com.example.slidergame

import android.annotation.SuppressLint
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View.GONE
import android.view.View.INVISIBLE
import android.widget.Button
import android.widget.Toast
import androidx.annotation.RequiresApi

class MainActivity : AppCompatActivity() {
    var pos = 0
    var num = Array<Int>(9){it->it*0}






    @RequiresApi(Build.VERSION_CODES.M)
    @SuppressLint("ResourceType", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = Array<Button>(9){findViewById(R.id.position00)}

        button[0] = findViewById<Button>(R.id.position00)
        button[1] = findViewById<Button>(R.id.position01)
        button[2] = findViewById<Button>(R.id.position02)
        button[3] = findViewById<Button>(R.id.position10)
        button[4] = findViewById<Button>(R.id.position11)
        button[5] = findViewById<Button>(R.id.position12)
        button[6] = findViewById<Button>(R.id.position20)
        button[7] = findViewById<Button>(R.id.position21)
        button[8] = findViewById<Button>(R.id.position22)
        val buttonRestart = findViewById<Button>(R.id.restart)

        gameBegin(button)
        buttonRestart.setOnClickListener{
            gameBegin(button)
        }

        button[0].setOnClickListener{
            if(num[0] == 0){
                toast("Nothing here")
            }else if(moveCheck(0) != -1){
                exchange(0,moveCheck(0),button)
            }
            if(successCheck(num)){
                toast("success")
            }
        }
        button[1].setOnClickListener{
            if(num[1] == 0){
                toast("Nothing here")
            }else if(moveCheck(1) != -1){
                exchange(1,moveCheck(1),button)
            }
            if(successCheck(num)){
                toast("success")
            }
        }
        button[2].setOnClickListener{
            if(num[2] == 0){
                toast("Nothing here")
            }else if(moveCheck(2) != -1){
                exchange(2,moveCheck(2),button)
            }
            if(successCheck(num)){
                toast("success")
            }
        }
        button[3].setOnClickListener{
            if(num[3] == 0){
                toast("Nothing here")
            }else if(moveCheck(3) != -1){
                exchange(3,moveCheck(3),button)
            }
            if(successCheck(num)){
                toast("success")
            }
        }
        button[4].setOnClickListener{
            if(num[4] == 0){
                toast("Nothing here")
            }else if(moveCheck(4) != -1){
                exchange(4,moveCheck(4),button)
            }
            if(successCheck(num)){
                toast("success")
            }
        }
        button[5].setOnClickListener{
            if(num[5] == 0){
                toast("Nothing here")
            }else if(moveCheck(5) != -1){
                exchange(5,moveCheck(5),button)
            }
            if(successCheck(num)){
                toast("success")
            }
        }
        button[6].setOnClickListener{
            if(num[6] == 0){
                toast("Nothing here")
            }else if(moveCheck(6) != -1){
                exchange(6,moveCheck(6),button)
            }
            if(successCheck(num)){
                toast("success")
            }
        }
        button[7].setOnClickListener{
            if(num[7] == 0){
                toast("Nothing here")
            }else if(moveCheck(7) != -1){
                exchange(7,moveCheck(7),button)
            }
            if(successCheck(num)){
                toast("success")
            }
        }
        button[8].setOnClickListener{
            if(num[8] == 0){
                toast("Nothing here")
            }else if(moveCheck(8) != -1){
                exchange(8,moveCheck(8),button)
            }
            if(successCheck(num)){
                toast("success")
            }
        }


    }

    private fun successCheck(num: Array<Int>): Boolean {
        for(i in 0..6){
            if(num[i]+1 != num[i+1]){
                return false
            }
        }
        return true
    }

    fun toast(text:String){
        Toast.makeText(this,text,Toast.LENGTH_SHORT).show()
    }

    @RequiresApi(Build.VERSION_CODES.M)
    @SuppressLint("ResourceAsColor")
    fun gameBegin(button:Array<Button>){
        val invisiblePos = (0..8).random()
        for(i in 0..8){
            if(i == invisiblePos){
                button[invisiblePos].setBackgroundColor(getColor(R.color.white))
            }else{
                button[i].setBackgroundColor(getColor(R.color.purple_500))
            }
            num[i] = 0
        }

        var i = 8
        for(pos in 0..8){
            if(pos == invisiblePos){continue}
            else{

                num[pos] = i--
                button[pos].setText(num[pos].toString())
            }
        }
    }

    fun moveCheck(pos:Int):Int{
        var result = -1
        when(pos){
            0-> if(num[1]*num[3] != 0){
                toast("cannot move")
            }else if(num[1]==0){
                result = 1
                //toast("move to 1")
            }else{
                result = 3
                //toast("move to 3")
            }
            1-> if(num[0]*num[2]*num[4] != 0){
                toast("cannot move")
            }else if (num[0] == 0){
                //toast("move to 0")
                result = 0
            }else if(num[2] == 0){
                //toast("move to 2")
                result = 2
            }else{
                //toast("move to 4")
                result = 4
            }
            2-> if(num[1]*num[5] != 0){
                toast("cannot move")
                result = -1
            }else if(num[1]==0){
                result = 1
                //toast("move to 1")
            }else{
                result = 5
                //toast("move to 5")
            }
            3-> if(num[0]*num[4]*num[6]!=0){
                toast("cannot move")
            }else if(num[0] == 0){
                //toast("move to 0")
                result = 0
            }else if(num[6] == 0){
                //toast("move to 6")
                result = 6
            }else{
                //toast("move to 4")
                result = 4
            }
            4-> if(num[1]*num[3]*num[5]*num[7]!=0){
                toast("cannot move")
            }else if(num[1]==0){
                result = 1
                //toast("move to 1")
            }else if(num[3]==0){
                result = 3
                //toast("move to 3")
            }else if(num[5]==0){
                result = 5
                //toast("move to 5")
            }else{
                result = 7
                //toast("move to 7")
            }
            5-> if(num[2]*num[4]*num[8]!=0){
                toast("cannot move")
            }else if(num[2] == 0){
                //toast("move to 2")
                result = 2
            }else if(num[8] == 0){
                //toast("move to 8")
                result = 8
            }else{
                //toast("move to 4")
                result = 4
            }
            6-> if(num[3]*num[7] != 0){
                toast("cannot move")
            }else if(num[3]==0){
                result = 3
                //toast("move to 3")
            }else{
                result = 7
                //toast("move to 7")
            }
            7-> if(num[4]*num[6]*num[8] != 0){
                toast("cannot move")
            }else if(num[6] == 0){
                //toast("move to 6")
                result = 6
            }else if(num[8] == 0){
                //toast("move to 8")
                result = 8
            }else{
                //toast("move to 4")
                result = 4
            }
            8-> if(num[5]*num[7] != 0){
                toast("cannot move")
            }else if(num[5]==0){
                result = 5
                //toast("move to 5")
            }else{
                result = 7
                //toast("move to 7")
            }
        }
        return result
    }

    @RequiresApi(Build.VERSION_CODES.M)
    fun exchange(startPos:Int, targetPos:Int, button:Array<Button>){
        button[startPos].setBackgroundColor(getColor(R.color.white))
        button[targetPos].setBackgroundColor(getColor(R.color.purple_500))
        numSwap(startPos,targetPos)
        button[startPos].text = num[startPos].toString()
        button[targetPos].text = num[targetPos].toString()
    }

    fun numSwap(startPos: Int,targetPos: Int){
        var temp = 0
        temp = num[startPos]
        num[startPos] = num[targetPos]
        num[targetPos] = temp
    }





}