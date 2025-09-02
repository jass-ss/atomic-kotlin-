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

fun trik (){
    val input = System.`in`.bufferedReader()
    val output = System.out.bufferedWriter()

    val moves: String = input.readLine()
    if(moves.length !in 1..50) throw Throwable("out of range")

    var temp =""
    var l = "ball"
    var m =""
    var r =""

    for(i in moves) {
        when (i) {
            'A' -> {
                temp = m
                m = l
                l= temp
            }
            'B' -> {
                temp = r
                r = m
                m = temp
            }
            'C' -> {
                temp = l
                l = r
                r= temp
            }
            else-> throw Throwable("invalid Char")
        }
    }

   if(l.isNotBlank()){
       output.write("1")
   }else if(m.isNotBlank()){
       output.write("2")
   }else if(r.isNotBlank()){
       output.write("3")
   }

    output.flush()
}
