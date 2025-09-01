
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

fun winningScore (){
    val input = System.`in`.bufferedReader()
    val output = System.out.bufferedWriter()

    var applesScore = 0
    var bananasScore = 0
    val result:Char

    for(i in 1 .. 6){ //total 6 lines
        val count = input.readLine().toIntOrNull() ?: throw Throwable("invalid int")
        if(count !in 0..100) throw Throwable("out of range")

        if(i < 4){ //apples: 1~3
            applesScore += count * (4 - i)
        }else{ //bananas: 4~6
            bananasScore += count * (7 - i)
        }
    }

    if(applesScore > bananasScore){
        result = 'A'
    }else if(applesScore < bananasScore){
        result = 'B'
    }else{
        result = 'T'
    }

    output.write("$result")
    output.flush()
}
