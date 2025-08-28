package org.example

class ecoo17r3p1 {
    val input = System.`in`.bufferedReader()
    val output = System.out.bufferedWriter()

    val info = readLine()?.split(' ')
    val allDay = MutableList(info[0].toInt(), init = 0)
    val bounus = 0
    var i =0

    while( i < info[1].toInt()){
        val result = readLine()?.split(' ')
        var allDayResult = 0

        for(r in result){
            allDayResult = allDayResult + r.toInt()
            allDay[i] = allDay[i] + r
        }

        if(result % 13 == 0) {
            bounus++
        }
        for(a in allDayResult){
            if(a  % 13 == 0){
                bounus++
            }
        }

        output(bounus)
    }



}