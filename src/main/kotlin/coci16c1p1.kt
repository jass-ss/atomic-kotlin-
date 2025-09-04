package org.example

/*
Pero has negotiated a Very Good data plan with his internet provider.
The provider will let Pero use up x megabytes to surf the internet per month.
Each megabyte that he doesn't spend in that month gets transferred to the next month and can still be spent.
Of course, Pero can only spend the megabytes he actually has.
If we know how many megabytes Pero has spent in each of the first N months of using the plan,
determine how many megabytes Pero will have available in the N+1 month of using the plan.

1. The first line of input contains the integer X(1<=X<=100).
   (= The provider will let Pero use up x megabytes to surf the internet per month.) =>매달 주어지는 데이터양
2. The second line of input contains the integer N(1<=N<=100). => 그 동안 사용한 개월 수
3. Each of the following N lines contains an integer P(1<=P<=10000),
   the number of megabytes spent in each of the first N months of using the plan.  => N만큼만 input.readline()
5. Numbers P will be such that Pero will never use more megabytes than he actually has. => P <= ( N * (X-spent)
6. The first and only line of output must contain the required value from the task.
   determine how many megabytes Pero will have available in the N+1 month of using the plan.
*/

fun tarifa(){
    val input = System.`in`.bufferedReader()
    val output = System.out.bufferedWriter()

    val megabytes = input.readLine().toIntOrNull() ?: throw Throwable("invalid int")
    if(megabytes !in 1..100) throw Throwable("out of range : $megabytes")

    val month = input.readLine().toIntOrNull() ?: throw Throwable("invalid int")
    if(month !in 1..100) throw Throwable("out of range : $month")

    // 반복문을 돌면서 쓰고 남은 데이터를 여기에 합산.
    // => 매 달 쓰고 남은 데이터 + 새로운 한 달 데이터 == output
    var left = 0

    var i = 0
    while(i < month){
        left += megabytes //매달 충전되는 데이터
        val spent = input.readLine().toIntOrNull() ?: throw Throwable("invalid int")
        if(spent !in 0..10000) throw Throwable("out of range : $spent")
        if(left < spent) throw Throwable("out of left range : $left < $spent")
        val monthLeft = left - spent
        left = monthLeft
        i++
    }

    var nextMonth = megabytes + left

    output.write("$nextMonth")
    output.flush()
}
