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

fun occupyParking_answer (){
    val input = System.`in`.bufferedReader()
    val output = System.out.bufferedWriter()

    val n = input.readLine().toIntOrNull() ?: throw Throwable("invalid int")
    if(n !in 1..100) throw Throwable("out of range 1..100: $n")

    val yesterday = input.readLine()
    if(yesterday.length != n) throw Throwable("invalid yesterday length: ${yesterday.length}")

    var i = 0
    while (i < n){
        if(yesterday[i] !in "C.") throw Throwable("invalid char yesterday[$i]:${yesterday[i]}")
        i++
    }

    val today = input.readLine()
    if(today.length != n) throw Throwable("invalid today length: ${today.length}")

    i = 0
    while (i < n){
        if(today[i] !in "C.") throw Throwable("invalid char today[$i]:${today[i]}")
        i++
    }

    var count = 0
    for (i in 0 ..< n){
        if(yesterday[i] == 'C' && today[i] == 'C' ) count++
    }
    output.write("$count")
    output.flush()
}

// 선생님의 답과 내 답을 비교했을 때 느낀 점
// 1. 내가 작성한 예외처리의 3배!! => 아래의 코드가 깨끗한 이유는 위에서 잘못된 입력이 올 가능성을 다 제거했기 때문
//    - n의 길이와 yesterday, today의 길이는 같다. (아닐시 에러 메세지)
//    - yesterday, today는 'C'와 '.'으로만 이루어져있다. (아닐시 에러 메세지)
// 2. ..< 범위 연산자를 새로 배웠다. ..만 있는 줄 알고 i in 0 .. n-1 을 생각했는데, 더 간단한 표현 방법을 배웠다.
// 3. 도메인은 언제든지 변경될 수 있기 때문에, 도메인 변경에 유연한 코드를 짜는 부분이 정말 인상 깊었다
//    - if(yesterday[i] !in "C.") , if(today[i] !in "C.") 로 각각 조건문 작성하여 검사
//    => input의 요소는 언제든 바뀔 수 있으므로. 만약 둘 중 하나가 바뀌면? 해당 조건문의 "C." 부분만 고치면 됨