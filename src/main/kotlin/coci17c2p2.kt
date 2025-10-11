package org.example

/*
 * 1. Zig says one letter, and Zag says a word that starts with that letter.
 *  - the word needs to be from the allowed word list and such that Zag already said it the least amount of times
 *  - If the word choice is ambiguous, then Zag will choose the one that is lexicographically smaller (sooner in the alphabet)
 *  - For each Zig's letter, it will be possible to choose a word
 *  - a list consisting of exactly K distinct words
 * 2. The first line of input contains positive integers K(1<=K<=100,000) and N(1<=N<=100,000) from the task
 *  - Each of the following K lines contains a single word consisting of lowercase letters of the English alphabet not longer than 21 characters
 *  - Each of the following N lines contains a single lowercase letter of the English alphabet.
 * 3. You must output N lines, each containing a single word from the task.
 */


fun coci17c2p2(){
    val input = System.`in`.bufferedReader()
    val output = mutableListOf<String>()

    val info = input.readLine().split((" "))
    val K = info[0].toIntOrNull()?:throw Throwable("invalid int: K")
    if(K !in 1..100_000)throw Throwable("out of range:K")

    val N = info[1].toIntOrNull()?:throw Throwable("invalid int: N")
    if(N !in 1..100_000)throw Throwable("out of range:N")

    val words = mutableListOf<String>()
    var i = 0
    while (i < K){
        val word = input.readLine() //소문자로 이루어진 단어라고 문제에서 명시했으므로 lowercase() 생략
        if(word.length > 21 || word.isEmpty()) throw Throwable("out of range:word")
        words.add(word)
        i++
    }

    val wordsMap : MutableMap<String, Int> = words.associateWith { 0 }.toMutableMap()

    fun findWord(letter: Char): String{
        var found = ""
        val letterWords = wordsMap.filter { (key,_)-> key[0] == letter  }
        val sortedLess = letterWords.entries.sortedBy { it.value }
        val min = sortedLess[0].value
        val lessWords = sortedLess.filter { (_,value)-> value == min }
        if(lessWords.size > 1){
            val sorted = lessWords.sortedBy { it.key }
            found = sorted[0].key
        }else{
            found = lessWords[0].key
        }
        wordsMap[found] = wordsMap.getOrDefault(found, 0) + 1
        return found
    }

    i=0
    while (i < N){
        val letter = input.readLine()[0] //소문자 한 글자라고 문제에서 명시했으므로 lowercase(), 길이 체크 생략
        val word = findWord(letter)
        output.add(word)
        i++
    }

    for(i in output) {
        println("$i")
    }
}

fun inputInt(v:String, range: IntRange):Int {
    val result = v.toIntOrNull() ?: throw Throwable("invalid int X")
    if(result !in range) throw Throwable("out of $range : $result")
    return result
}
fun inputAlphaLower(v:String):String{
    var i = 0
    while(i < v.length){
        if(v[i] !in 'a'..'z') throw Throwable("invalid char lower alpha: ${v[i]}")
        i++
    }
    return v
}

fun coci17c2p2_answer(){
    val input = System.`in`.bufferedReader()
    val split = input.readLine().split(" ")
    if(split.size !=2)throw Throwable("invalid input")
    val K = inputInt(split[0], 1..100_000)
    val N = inputInt(split[1], 1..100_000)
    var i = 0
    val words = mutableMapOf<Char, MutableList<String>>()
    val dic = mutableMapOf<String,Int>()
    while (i < K){
        val word = inputAlphaLower(input.readLine())
        if(word.length > 21) throw Throwable("out of range")
        if(word in dic) throw Throwable("duplicate word: $word")
        dic[word] = 0
        words.getOrPut(word[0]){mutableListOf()}.add(word)
        i++
    }

    i=0
    val letters = mutableListOf<Char>()
    while (i < N){
        val letter = inputAlphaLower(input.readLine())
        if(letter.length != 1) throw Throwable("out of range: $letter")
        if(letter[0] !in words.keys) throw Throwable("invalid word header: $letter")
        letters.add(letter[0])
        i++
    }

    for(o in letters){
        val sorted = words.getOrPut(o){mutableListOf()}.sortedWith(
            compareBy<String>{ dic.getOrPut(it){0} }.thenBy {it}
        )
        println(sorted[0])
        dic[sorted[0]] = dic.getOrPut(sorted[0]){0} + 1
    }

}


// 선생님의 코드와 비교해서 느낀(배운)점
// 1. 예외를 계속 신경쓰고 있지만, 내가 생각하지 못해서 체크하지 못한 부분이 계속 있다.
//    이번 문제 : input 사이즈 체크, 단어 중복 검사, 소문자가 제시된 단어들의 첫 글자가 아닌 경우
//    -> 이런 부분들 때문에 기계가 터지는 거라고 그러셨는데... 앞으로도 이런 에러 바운더리 설정에 더욱 신경을 쓰는 '습관'을 들여야 겠다.
// 2. 전 문제에서 배웠던 것 다시 사용해 본 부분
//    : while의 카운트 변수 i를 0으로 초기화해서 새 while문에 재사용
// 3. 답안 제출 시 시간초과로 8,9,10,11 통과를 못하는데, 내가 map을 여러 반복문을 통해 만들어서 그렇구나