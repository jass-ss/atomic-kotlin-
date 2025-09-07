package org.example

/*
Here at the Concerned Citizens of Commerce (CCC),
we have noted that telemarketers like to use seven-digit phone numbers
where the last four digits have three properties. Looking just at the last four digits,
these properties are:
the first of these four digits is an 8 or 9;
the last digit is an 8 or 9;
the second and third digits are the same.

For example,
if the last four digits of the telephone number are 8229, 8338, or 9008, these are telemarketer numbers.
Write a program to decide if a telephone number is a telemarketer number or not, based on the last four digits.
If the number is not a telemarketer number, we should answer the phone, and otherwise, we should ignore it.

도메인 규칙
1.input will be 4 lines where each line contains exactly one digit in the range from 0 to 9.
  the first of these four digits is an 8 or 9;
  the last digit is an 8 or 9;
  the second and third digits are the same.
2.Output either 'ignore' if the number matches the pattern for a telemarketer number; otherwise, output 'answer'.
*/

fun telemarketerOrNot (){
    val input = System.`in`.bufferedReader()
    val output = System.out.bufferedWriter()

    var result = "answer"
    val number1 = input.readLine().toIntOrNull() ?: throw Throwable("invalid int")
    if(number1 !in 0..9) throw Throwable("out of range")

    val number2 = input.readLine().toIntOrNull() ?: throw Throwable("invalid int")
    if(number2 !in 0..9) throw Throwable("out of range")

    val number3 = input.readLine().toIntOrNull() ?: throw Throwable("invalid int")
    if(number3 !in 0..9) throw Throwable("out of range")

    val number4 = input.readLine().toIntOrNull() ?: throw Throwable("invalid int")
    if(number4 !in 0..9) throw Throwable("out of range")

    if(number1 in 8..9 && number4 in 8..9 && number2 == number3){
        result = "ignore"
    }

    output.write(result)
    output.flush()
}
