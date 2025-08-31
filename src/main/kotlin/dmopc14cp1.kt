package org.example // 이 부분이 Main.kt 파일과 동일해야 합니다.

/* DMOPC '14 Contest 5 P1 - Core Drill
Simon got a new drill recently.
Everyone knows that a drill is shaped like a right "circular cone".
Simon knows his drill has radius and height.
But now he wants to calculate the volume. Write a program to help Simon!
도메인 규칙
1.The first line of input will have an integer r (1<=r<=100)
2.The second line of input will have an intege h (1<=h<=100)
3.V is the volume of the right circular cone with radius and height (V = (π * r² * h)/3 )
*/

fun coreDrill(){
    val input = System.`in`.bufferedReader()
    val output = System.out.bufferedWriter()

    val r = input.readLine().toIntOrNull() ?: throw Throwable("invalid int")
    if(r !in 1..100) throw Throwable("out of range. r:${r}")

    val h = input.readLine().toIntOrNull() ?: throw Throwable("invalid int")
    if(r !in 1..100) throw Throwable("out of range. h:${h}")

    val V = (Math.PI * r * r * h) / 3
    val cone = String.format("%.2f", V)
    output.write(cone)
    output.flush()
}