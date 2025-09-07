package org.example

/*
Martha takes a jar of quarters to the casino with the intention of becoming rich.
She plays three machines in turn.
Unknown to her, the machines are entirely predictable.

도메인 규칙
1. Each play costs one quarter.
2. She plays three machines in turn.
3. The first 30 quarters every 35 time it is played
   the second machine pays 60 quarters every 100 time it is played
   he third pays 9 quarters every 10 time it is played.
4. Your program should take as input the number of quarters (there will be at least one and fewer than 1000),
   and the number of times each machine has been played since it last paid.
   output is the number of times Martha plays until she goes broke.
*/

fun slotMachines_answer (){
    val input = System.`in`.bufferedReader()
    val output = System.out.bufferedWriter()

    var quarter = input.readLine().toIntOrNull()?:throw Throwable("invalid int quarter")
    if(quarter !in 1..1000) throw Throwable("out of range 1..1000 quarter: $quarter")

    val turn1 = 35
    val turn2 = 100
    val turn3 = 10

    val prize1 = 30
    val prize2 = 60
    val prize3 = 9

    var played1 = input.readLine().toIntOrNull() ?: throw Throwable("invalid int played1")
    played1 %= turn1 // played1 == turn1 일 때만 0. played1 != turn1 이면 played1
    var played2 = input.readLine().toIntOrNull() ?: throw Throwable("invalid int played2")
    played2 %= turn2 // played2 == turn2 일 때만 0. played2 != turn2 이면 played2
    var played3 = input.readLine().toIntOrNull() ?: throw Throwable("invalid int played3")
    played3 %= turn3 // played3 == turn3 일 때만 0. played3 != turn3 이면 played3

    var turn =0
    var count =0
    while (quarter > 0){
        quarter--
        count++

        when(turn){
            0->played1++
            1->played2++
            2->played3++
        }
        turn = (turn + 1) % 3 // 게임할 때 마다 순차적으로 슬롯머신1,2,3 플레이.

        if(played1 == turn1){
            played1 = 0
            quarter += prize1
        }
        if(played2 == turn2){
            played2 = 0
            quarter += prize2
        }
        if(played3 == turn3){
            played3 = 0
            quarter += prize3
        }
    }


    output.write("Martha plays $count times before going broke.")
    output.flush()
}

// 이 슬롯머신 문제가 2주차 숙제 중 제일 어려운 문제였던거 같다.
// 문제 자체가 잘 이해가 안가서 계속 고민하다가
// 그냥 답안을 그대로 따라 작성하였다.
// 매직넘버 = 의미를 가진 숫자. 숫자의 의미를 가진 '이름'으로 상수 만듦.
// => 도메인 값이 변경되면 해당 상수의 값을 변경.