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

fun doTheSuffle_answer (){
    val input = System.`in`.bufferedReader()
    val output = System.out.bufferedWriter()

    var p1 = "A"
    var p2 = "B"
    var p3 = "C"
    var p4 = "D"
    var p5 = "E"

    do{
        val button = input.readLine().toIntOrNull() ?: throw Throwable("invalid int button")
        if(button !in 1..4) throw Throwable("out of range 1..4 button: $button")
        val n = input.readLine().toIntOrNull() ?: throw Throwable("invalid int n")
        if(n !in 1..10) throw Throwable("out of range 1..10 n: $n")
        if(button == 4 && n != 1) throw Throwable("button 4 requires n to be 1, but was $n")

        for(i in 1..n){
            when(button){
                1->{
                    val temp = p1
                    p1 = p2
                    p2 = p3
                    p3 = p4
                    p4 = p5
                    p5 = temp
                }
                2->{
                    val temp = p5
                    p5 = p4
                    p4 = p3
                    p3 = p2
                    p2 = p1
                    p1 = temp
                }
                3->{
                    val temp = p1
                    p1 = p2
                    p2 = temp
                }
            }
        }
    }while (button!=4) //코틀린만 while 조건에서 do 본문에 선언된 변수를 사용할수 있다!

    output.write("$p1 $p2 $p3 $p4 $p5")
    output.flush()
}

//선생님과 내 답을 비교하며 느낀점
//1.do while을 생각못해서 b를 whilea문 위에서 선언하고 while문 제일 마지막에서 다시 input.readLine()으로 재선언하였다.
//  이건 4번이 1번만 나올 수 있다는 규칙 때문에 가능한거 였지, 이런 규칙이 없었다면 while을 사용해선 못풀 문제라고 생각한다.
//  do while을 기억하자!!!
//2.문자를 각각 변수에 담지않고 문자열로 생각해서 풀었다. => 어쩐지 정답처리가 하나의 테스트케이스도 통과못해서 이상하다고 생각했다..
//  좀 더 문제를 주의깊게 보는 연습을 해야할 거 같다...
//3.for와 while 선택하는게 아직 여전히 헷갈린다..

