package org.example

class ccc18s1 {
    val input = System.`in`.bufferedReader()
    val output = System.out.bufferedWriter()

    val lastIndex = readLine()?.toInt()
    val list = mutableListOf<int>()
    val i = 1

    while (i =< lastIndex) {
        var position = readLine()?.toInt();
        list.add(position)
        i++
    }

    list.sort()

    var min = 0

    for(i in 1..< list.lastIndex){
        var next = i+1
        var val = (list[next] - list[i]) / 2
        var size = list[next] + val
        if(min < size) min = size
    }
    output(min)
}