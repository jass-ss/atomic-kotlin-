package org.example

/*
Jealous of Mirko's position as head of the village, Borko stormed into his tent
and tried to demonstrate Mirko's incompetence for leadership with a trick.
Borko puts three opaque cups onto the table next to each other (opening facing down)
and a small ball under the leftmost cup.
He then swaps two cups in one of three possible ways a number of times.
Mirko has to tell which cup the ball ends up under.
Wise Mirko grins with his arms crossed while Borko struggles to move the cups faster and faster.
What Borko does not know is that programmers in the back are recording all his moves and
will use a simple program to determine where the ball is. Write that program.
도메인 규칙
 1. The first and only line contains a string of at most 50 characters, Borko's moves.
    Each of the characters is A, B or C.
    A: 1 <--> 2
    B: 2 <--> 3
    C: 3 <--> 1
 2. Output the index of the cup under which the ball is:
    1 if it is under the left cup,
    2 if it is under the middle cup or
    3 if it is under the right cup.
*/

fun trik_answer (){
    val input = System.`in`.bufferedReader()
    val output = System.out.bufferedWriter()

    val n = input.readLine()
    if(n.length !in 1..50) throw Throwable("out of range 1..50 n.length: ${n.length}")

    var i = 0;
    while(i < n.length){
        if(n[i] !in "ABC")  throw Throwable("invalid char n[${i}]: ${n[i]}")
        i++
    }

    var pos0 = 1
    var pos1 = 0
    var pos2 = 0

    for(c in n){
        when(c){
            'A' -> {
                val temp = pos0
                pos0 = pos1
                pos1 = temp
            }
            'B' ->{
                val temp = pos1
                pos1 = pos2
                pos2 = temp
            }
            'C' -> {
                val temp = pos0
                pos0 = pos2
                pos2 = temp
            }
        }
    }

    val result = when{
        pos0 == 1 -> "1"
        pos1 == 1 -> "2"
        pos2 == 1 -> "3"
        else -> throw Throwable("fullfill partitoin")
    }
    output.write(result)
    output.flush()
}
