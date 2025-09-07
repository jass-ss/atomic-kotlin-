package org.example

/*
Those tiny music machines that play your digital music are really computers that keep track of and play music files.
The CCC music player (C3MP) is currently in development and will be hitting the stores soon!
In this problem, you have to simulate a C3MP.

도메인 규칙
1. The C3MP music player will hold 5 songs in memory, whose titles will always be "A", "B", "C", "D" and "E"
2. Button 1: move the first song of the playlist to the end of the playlist.
   Button 2: move the last song of the playlist to the start of the playlist.
   Button 3: swap the first two songs of the playlist.
   Button 4: stop rearranging songs and output the playlist.
3. Your program should repeatedly ask for two positive integers b an n. => 홀수 = b, 짝수=n
   Here b represents the button number that the user wants to press 1<= b <=4,
   and n represents the number of times that the user wants to press button n. 1<=n<=10.
   ( user will only ever press button 4 once )
*/

fun doTheSuffle (){
    val input = System.`in`.bufferedReader()
    val output = System.out.bufferedWriter()

    var list: String="ABCDE"
    var b = input.readLine().toIntOrNull()?:throw Throwable("invalid int: b")
    if(b !in 1..4) throw Throwable("out of range: b")

    var n = 0
    while(b!=4){
        n = input.readLine().toIntOrNull()?:throw Throwable("invalid int: n")
        if(n !in 1..10) throw Throwable("out of range: n")
        when(b){
            1->{
                while(n != 0){
                    list = list.substring(1) + list.first()
                    n--
                }
            }
            2->{
                while(n != 0){
                    list = list.last() + list.substring(0,4)
                    n--
                }
            }
            3->{
                while(n != 0){
                    val firstTwo = list.substring(0, 2)
                    val restOfPlaylist = list.substring(2)
                    list = firstTwo.reversed() + restOfPlaylist
                    n--
                }
            }
        }
        b = input.readLine().toIntOrNull()?:throw Throwable("invalid int: b") //다음 동작 확인
    }


    output.write("$list")
    output.flush()
}
