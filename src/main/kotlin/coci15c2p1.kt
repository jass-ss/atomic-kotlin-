package org.example

/*
* The dictionary consists of N words consisting of lowercase letters from the English alphabet,
* the total length of the word not exceeding 1,000,000 characters.
* He will give an array of key presses S, of total length at most 1000
* wants to know how many words from the dictionary can be mapped to the given array of key presses
* 1. The first line of input contains the integer N, the number of words in the dictionary. (1<=N<=1000)
* 2. Each of the following N lines contains a single word.
* 3. The last line of input contains the string S (1<=S<= 1000) consisting of digits 2-9
*/

import kotlin.text.toIntOrNull

fun checkNumber(n:Int): String{
    var range: String = ""
    when(n){
        2-> range ="abc"
        3-> range ="def"
        4-> range ="ghi"
        5-> range ="jkl"
        6-> range ="mno"
        7-> range ="pqrs"
        8-> range ="tuv"
        9-> range ="wxyz"
    }
    return range
}

fun coci15c2p1(){
    val input = System.`in`.bufferedReader()

    val N = input.readLine().toIntOrNull()?:throw Throwable("invalid int: N")
    if(N !in 1..1000) throw Throwable("out of range: N")

    val arrS = mutableListOf<String>()
    var i = 0
    while (i < N ){
        val word = input.readLine().lowercase()
        if(word.length !in 1..1_000_000)throw Throwable("out of range")
        if(word.contains(" "))throw Throwable("not a word")
        arrS.add(word)
        i++
    }

    val S = input.readLine()
    if(S.length !in 1..1000)throw Throwable("out of range:S")
    i = 0
    while (i < S.length){
        val keyS = S[i].digitToIntOrNull()?:throw Throwable("invalid int:key S")
        if(keyS !in 2..9) throw Throwable("out of range: key S")
        val range = checkNumber(keyS)
        arrS.removeAll( { word -> !range.contains(word[i]) })
        i++
    }

    println(arrS.size)

}


fun inputDigit(v:String):String{
    if(v.length !in 1..1000) throw Throwable("out of range")
    var i = 0
    while(i < v.length){
        if(v[i] !in '2'..'9') throw Throwable("invalid digit: ${v[i]}")
        i++
    }
    return v
}

fun coci15c2p1_answer(){
    val input = System.`in`.bufferedReader()
    val output = System.out.bufferedWriter()

    val MAX_LENGTH = 1000_000
    val keyPad = mapOf(
        '2' to "abc",
        '3' to "def",
        '4' to "ghi",
        '5' to "jkl",
        '6' to "mno",
        '7' to "pqrs",
        '8' to "tuv",
        '9' to "wxyz"
    )

    val N = inputInt(input.readLine(), 1..1000)
    val dic = mutableListOf<String>()
    var totalLength = 0
    var i = 0
    while (i < N){
        val word = inputAlphaLower(input.readLine())
        totalLength += word.length
        if(MAX_LENGTH < totalLength) throw Throwable("over totalLength: $totalLength")
        if(word in dic) throw Throwable("duplicate word: $word")
        dic.add(word)
        i++
    }
    var S = inputDigit(input.readLine())

    for (i in 0..S.lastIndex){
        for (j in dic.lastIndex downTo 0){
            if(dic[j].length - 1 < i || dic[j][i] !in keyPad[S[i]]!!) dic.removeAt(j)
        }
    }
    println(dic.size)
    output.flush()
}

