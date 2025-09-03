package org.example

/*
You supervise a small parking lot which has N parking spaces.
Yesterday, you recorded which parking spaces were occupied by cars and which were empty.
Today, you recorded the same information.
How many of the parking spaces were occupied both yesterday and today?

도메인 규칙
1. You supervise a small parking lot which has N parking spaces
2. How many of the parking spaces were occupied both yesterday and today
3. The first line of input contains the integer N(1<=N<=100). => 반복문의 총 횟수.
   The second and third lines of input contain N characters each.
4. The second line of input records the information about yesterday's parking spaces,
   and the third line of input records the information about today's parking spaces. => 어제와 오늘의 주차 상태
5. Each of these 2N characters will either be C to indicate an occupied space =>주차된 경우 C
   or . to indicate it was an empty parking space. => 주차되지 않은 경우 .
6. Output the number of parking spaces which were occupied yesterday and today. => 2,3 라인 글자중 둘 다 C인 경우의 수
*/

fun occupyParking (){
    val input = System.`in`.bufferedReader()
    val output = System.out.bufferedWriter()

    val n = input.readLine().toIntOrNull() ?: throw Throwable("invalid int")
    if(n !in 1..100) throw Throwable("out of range : $n")

    val yesterday = input.readLine()
    val today = input.readLine()

    var result = 0

    for (i in 0 ..< n){
        if(yesterday[i] == 'C' && today[i] == 'C' ){
            result++
        }
    }
    output.write("$result")
    output.flush()
}
