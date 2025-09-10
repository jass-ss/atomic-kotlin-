package org.example

import kotlin.math.abs

/*
In the country of Voronoi, there are N villages,located at distinct points on a straight road.
Each of these villages will be represented by an integer position along this road.
Each village defines its neighbourhood as all points along the road which are closer to it than to any other village.
A point which is equally close to two distinct villages A and B is in the neighbourhood of A and also in the neighbourhood of B.
Each neighbourhood has a size which is the difference between the minimum (leftmost) point in its neighbourhood and the maximum (rightmost) point in its neighbourhood.
The neighbourhoods of the leftmost and rightmost villages are defined to be of infinite size, while all other neighbourhoods are finite in size.
Determine the smallest size of any of the neighbourhoods (with exactly 1 digit after the decimal point).
The first line will contain the number 3<= N <=100, the number of villages.
On the next N ines there will be one integer per line,
where the I line will contain the integer V the position of the I village -1000000000<=V<=1000000000.
Output the smallest neighbourhood size with exactly one digit after the decimal point.
 */
fun ccc18s1_answer() {
    val input = System.`in`.bufferedReader()
    val output = System.out.bufferedWriter()

    val N = input.readLine().toIntOrNull()?:throw Throwable("invalid int N")
    if(N !in 3..100)throw Throwable("out of range 3..100 N:$N")

    val list = mutableListOf<Int>()
    var i = 0
    while(i < N){
        val V = input.readLine().toIntOrNull() ?: throw Throwable("invalid int V")
        if(V !in -1_000_000_000..10_0000_0000) throw Throwable("out of range -1m..1m V: $V")
        list.add(V)
        i++
    }
    list.sort()

    val size = mutableListOf<Double>()
    for(i in 1..< list.lastIndex){
        size.add(abs(list[i+1] - list[i-1]).toDouble() / 2.0)
    }
    size.sort()
    println("%.1f".format(size[0]))
}