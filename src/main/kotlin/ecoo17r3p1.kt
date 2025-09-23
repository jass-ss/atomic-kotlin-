package org.example

//1.Baker Brie is holding a celebration for being in business for 13 years, and having opened its 130th franchise.
//2.If, in a single day, all franchises combined sell an amount of baked goods that is equivalent to a multiple of a baker's dozen (13)	, then all franchises will receive a bonus.
//3. If an individual franchise, throughout its entire existence, has sold an amount of baked goods that is equivalent to a multiple of a baker's dozen (13), then that franchise will receive a bonus.
//4.The input will contain 10 datasets.
//  4-1. On the first line of each dataset there will be the valuesF and D separated by a space
//  4-2. F (4 <= F <= 130) represents the number of franchises that Baker Brie has,
//  4-3. D (2<= D <= 4745) represents the number of days of information.
//  4-4. On the next D lines, there will be F integers separated by spaces (each in the range 1 through 13000)
//  4-5. Ith integer on line J represents the number of baked goods sold by franchise I on day J.
//5.track how many baker's dozens were sold. Report the total number of baker's dozens as a single integer on its own line.

fun ecoo17r3p1() {
    val input = System.`in`.bufferedReader()
    val output = System.out.bufferedWriter()

    var dataset = 0
    val result = mutableListOf<Int>()
    while(dataset < 10){
        result.add(0)
        val info = input.readLine().split(" ")
        val franchise = info[0].toIntOrNull()?: throw Throwable("invalid int")
        if(franchise !in 4..130) throw Throwable("out of range: franchise")
        val days = info[1].toIntOrNull()?: throw Throwable("invalid int")
        if(days !in 2..4745) throw Throwable("out of range: days")

        //각 franchise가 행사동안 판매한 총량 리스트 초기화
        val totalFranchiseGoods = mutableListOf<Int>()
        for(i in 1..franchise){
            totalFranchiseGoods.add(0)
        }
        //days 만큼 반복문을 돌면서,
        // 1. franchise의 각 요소들을 더해서 13배수인지 확인
        // 2. days[franchise]의 값을 모두 더해서 13배수인지 확인
        var d = 0
        while(d <days){
            var totalDayGoods = 0
            val goodsPerDay = input.readLine().split(" ")

            var f = 0
            while (f < franchise){
                val goods = goodsPerDay[f].toIntOrNull()?:throw Throwable("out of range: goodsPerDay:$goodsPerDay")
                totalDayGoods += goods
                totalFranchiseGoods[f] += goods
                f++
            }
            if(totalDayGoods % 13 == 0){
                val bonus = totalDayGoods / 13
                result[dataset] += bonus
            }
            d++
        }

        for(j in 0..totalFranchiseGoods.lastIndex){
            val franchise = totalFranchiseGoods[j]
            if(franchise % 13 == 0){ //13의 배수인 경우에만
                val bonus = franchise / 13 //13의 배수만 나누기 13 하므로 무조건 양의 정수.
                result[dataset] += bonus
            }
        }

        dataset++
    }

    for(i in 0..9){
        println(result[i])
    }
}


