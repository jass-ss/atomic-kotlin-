
package org.example
/*
You record all of the scoring activity at a basketball game.
Points are scored by a 3-point shot, a 2-point field goal, or a 1-point free throw.
You know the number of each of these types of scoring for the two teams: the Apples and the Bananas.
Your job is to determine which team won, or if the game ended in a tie.

도메인규칙
1.The first three lines of input describe the scoring of the Apples,
  and the next three lines of input describe the scoring of the Bananas.
  => total 6 lines. (apples: 1~3, bananas: 4~6)
2.For each team, the first line contains the number of successful 3-point shots,
  the second line contains the number of successful 2-point field goals,
  and the third line contains the number of successful 1-point free throws.
3.Each number will be an integer between 0 and 100, inclusive.
4.The output will be a single character.
  If the Apples scored more points than the Bananas, output A.
  If the Bananas scored more points than the Apples, output B.
  Otherwise, output T, to indicate a tie.
*/

fun winningScore_answer(){
    val input = System.`in`.bufferedReader()
    val output = System.out.bufferedWriter()

    val a3 = input.readLine().toIntOrNull() ?: throw Throwable("invalid int a3")
    if(a3 !in 0..100) throw Throwable("out of range 0..100 a3: $a3")

    val a2 = input.readLine().toIntOrNull() ?: throw Throwable("invalid int a2")
    if(a2 !in 0..100) throw Throwable("out of range 0..100 a2:$a2")

    val a1 = input.readLine().toIntOrNull() ?: throw Throwable("invalid int a1")
    if(a1 !in 0..100) throw Throwable("out of range 0..100 a1:$a1")

    val b3 = input.readLine().toIntOrNull() ?: throw Throwable("invalid int b3")
    if(b3 !in 0..100) throw Throwable("out of range 0..100 b3: $b3")

    val b2 = input.readLine().toIntOrNull() ?: throw Throwable("invalid int b2")
    if(b2 !in 0..100) throw Throwable("out of range 0..100 b2: $b2")

    val b1 = input.readLine().toIntOrNull() ?: throw Throwable("invalid int b1")
    if(b1 !in 0..100) throw Throwable("out of range 0..100 b1: $b1")

    val scoreA = a1 + (a2 * 2) + (a3 * 3) // 연산식 => 무조건 괄호 친다
    val scoreB = b1 + (b2 * 2) + (b3 * 3) // 연산식 => 무조건 괄호 친다

    //result는 partition.
    //교집합이 없음 = 서로소인 부분집합의 합이 전집합을 이룸
    //partition은 if 보다는 when
    val result = when{
        scoreA > scoreB -> "A"
        scoreA < scoreB -> "B"
        else -> "T"
    }

    output.write(result)
    output.flush()
}
