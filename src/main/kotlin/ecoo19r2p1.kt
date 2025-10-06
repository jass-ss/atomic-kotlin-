package org.example

//1. you can format a given address in several different ways.
//  - The entire address is case-insensitive.
//  - Dots (.) before the at-sign (@) sign are ignored.
//  - A plus (+) followed by any string can be added before the at-sign (@).
//    The plus and following string are ignored.
// 2. determine the number of unique email addresses
//  - The input will contain 10 datasets.
//  - Each dataset begins with a line containing an integer N (1<=N<=100000), the number of email addresses
//  - he next N lines each contain an email address S(1<=S<=30)
//  - address will be formatted as a non-empty user part, a single at-sign followed by a non-empty domain part.
//  - For the first 6 cases,N<=100.
// ex :foo@bar.com and fO.o+baz123@bAR.com refer to the same email address.

fun normalizeEmail(email:String):String{
    val lowerEmail = email.lowercase()
    val beforeAtSign = lowerEmail.split("@")[0]
    val afterAtSign = lowerEmail.split("@")[1]

    //+인 경우 +부터 @전까지 무시
    var i = 0
    var noPlus = true
    while(noPlus && i <= beforeAtSign.lastIndex ){
       if (beforeAtSign[i] == '+'){
           noPlus = false
       }else{
           i++
       }
    }
    val removePlusStr = beforeAtSign.substring(0, i)
    //println(removePlusStr)

    var normalized: String = ""
    //@ 앞에 있는 .들 모두 무시
    for (t in removePlusStr){
        if(t != '.') normalized += t
    }

    return normalized +"@"+ afterAtSign
}

fun ecoo19r2p1(){
    val input = System.`in`.bufferedReader()
    val output = System.out.bufferedWriter()

    val result = mutableListOf<Int>()

    for(i in 1..10){
        val n = input.readLine().toIntOrNull()?:throw Throwable("invalid int")
        if(n !in 1..100000)throw Throwable("out of range")

        var uniqueEmails = mutableSetOf<String>()

        for(i in 1..n){
            val email = input.readLine()
            if(email.isEmpty() || email.length > 30) throw Throwable("out of email range")
            uniqueEmails.add(normalizeEmail(email))
        }
        //println(uniqueEmails)
        result.add(uniqueEmails.size)
    }

    for(i in result){
        println(i)
    }
}