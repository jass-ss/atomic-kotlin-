package org.example
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
All villages are at distinct positions.
Output the smallest neighbourhood size with exactly one digit after the decimal point.
 */
fun ccc18s1() {
    val input = System.`in`.bufferedReader()
    val output = System.out.bufferedWriter()

    val length = input.readLine().toIntOrNull()?:throw Throwable("invaild int")
    if(length !in 3..100)throw Throwable("out of range")

    val list = mutableListOf<Int>()
    for(i in 1..<length){
        val position = input.readLine().toIntOrNull()?:throw Throwable("invaild int")
        list.add(position)
    }

    list.sort()
    val sizeList = mutableListOf<Int>()
    for(i in 1..<length){
        val left = (list[i] - list[i-1] ) / 2
        val right = (list[i+1] - list[i] ) / 2
        val size = left + right
        sizeList.add(size)
    }
    sizeList.sort();
    output.write("${sizeList.first()}")
    output.flush()
}