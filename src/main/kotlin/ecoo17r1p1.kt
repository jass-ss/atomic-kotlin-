package org.example

/*
* 1. For someone who has been at the school for one year Y1 , the price will be $12 ,
*    for someone who has been at the school for two years Y2, the price will be $10,
*    the three-year(Y3) price will be $7,
*    and the price for someone who has been there all four years (Y4) will be $5
* 2. Out of all the proceeds, 50% can be saved towards the year-end trip, as the other 50% is spent on the various costs to run the brunch
* 3. The input contains 10 trips, at 3 lines of data per trip.
* 4. -For each of the trips, the first line will show the cost of the trip as an integer $50 to $ 50000
     -The next line contains four floating point numbers Y1,Y2,Y3,Y4 representing the percentages of the total number of students from years 1 through 4 respectively.
     - The third line contains a single number N, which contains the total number of students attending the brunch(4 <= N <= 200)
* 5. You cannot have less than a whole person (e.g.,1.8 people is the same as 1 person). Any missing or extra people should be removed from or added to the group with the highest percentage of attendees. There will always be exactly one group with the highest percentage of attendees.
* 6. Output YES if the student council needs to find other funding, and NO if the council has raised sufficient funds.
* 7. The input contains 10 trips, at 3 lines of data per trip.
* * */

fun ecoo17r1p1(){
    val input = System.`in`.bufferedReader()
    val output = System.out.bufferedWriter()

    for(i in 1..10) {
        val tripPrice = input.readLine().toIntOrNull()?:throw Throwable("")
        if(tripPrice !in 50..50000)throw Throwable("")

        val Y = listOf<Int>(12, 10, 7, 5)
        val allRate = input.readLine().split(" ")
        var allY = 0
        val YList = mutableListOf<Int>()
        val total = input.readLine().toIntOrNull()?:throw Throwable("")
        if(total !in 4..2000)throw Throwable("")


        val i = 0
        while (i < allRate.size){
            val rate = allRate[i].toDoubleOrNull()?:throw Throwable("")
            val student = (total * rate).toInt()
            allY += student
            YList.add(student)
        }

        if(allY != total){
            val left = Math.abs(total-allY)
            val maxY = YList.max()
            val maxYIndex = YList.indexOf(maxY)
            YList[maxYIndex] = maxY + left
        }

        var funding =0
        for(i in 0..4){
            val price = YList[i] * Y[i]
            funding += price
        }

        val tripFunding = funding / 2
        when{
            (tripFunding >= tripPrice)->{
                println("NO")
            }
            else->{
                println("YES")
            }
        }
    }
}