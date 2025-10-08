package org.example

/*
* Given a sequence of m words from a newspaper article and an integer k, find the kth most common word(s).
* 1. Input will consist of an integer n followed by n data sets.
*   -Each data set begins with a line containing m and k, followed by m lines
*   -each containing a word of up to 20 lowercase letters.
*   -There will be no more than 1000 words per data set.
* 2. determine the Kth most common word(s)
*   -the Kth most common if exactly k-1 distinct words occur more frequently than w
*   -w might be multiply defined
*   -w might not exist
* 3. print a title line indicating k using normal ordinal notation (1st, 2nd, 3rd, 4th, 5th, …)
*   -all the possible values for the kth most common word
*   -A blank line should follow the last word for each data set.
*/

fun cco99p2(){
    val input = System.`in`.bufferedReader()

    val datasetSize = input.readLine().toIntOrNull()?:throw Throwable("invalid int")

    val result = mutableMapOf<String,List<String>>()
    var i = 0
    while( i < datasetSize){
        val info = input.readLine()

        val words = info.split(" ")[0].toIntOrNull()?:throw Throwable("invalid int: words")
        if(words !in 1..1000)throw Throwable("out of range: words")

        val commonLevel = info.split(" ")[1].toIntOrNull()?:throw Throwable("invalid int: words")
        if(commonLevel == 0 )throw Throwable("out of range: commonLevel")

        var c = 0
        val wordMap = mutableMapOf<String,Int>()
        while (c < words){
            val word = input.readLine().lowercase()
            if(word.length > 20)throw Throwable("out of range: word")
            if(wordMap.contains(word)){
                val count = wordMap.getValue(word)
                wordMap[word] = count + 1
            }else{
                wordMap[word] = 1
            }

            c++
        }

        val sorted = wordMap.entries.sortedByDescending{it.value}
        var count = 1
        var commonCount = sorted[0].value
        val wordList = mutableListOf<String>()
        for (i in sorted){
            if(i.value < commonCount){
                count++
                commonCount = i.value
                if(count == commonLevel) break
            }
        }

        for (i in sorted){
            if(i.value == commonCount){
                wordList.add(i.key)
            }
        }

        result["$i $commonLevel"] = wordList

        i++
    }
    //println(result)
    for (i in result){
        val rank = i.key.split(" ")[1].toInt()
        var str = ""
        when(rank){
            1-> str += "1st most common word(s):\n"
            2-> str += "2nd most common word(s):\n"
            3-> str += "3rd most common word(s):\n"
            else -> str += "$rank"+"th most common word(s):\n"
        }
        for(j in i.value){
            str += "$j\n"
        }
        println(str)
    }
}

fun checkMK(v:String):Pair<Int,Int>{
    val split = v.split(" ")
    if(split.size != 2 || split[0].isEmpty() || split[1].isEmpty()) throw Exception("invalid mk=$v-")

    val m = split[0].toIntOrNull() ?: throw IllegalArgumentException("invalid int m")
    if(m !in 1..1000)throw Throwable("out of range 1..1000 m: $m")

    val k = split[1].toIntOrNull() ?: throw IllegalArgumentException("invalid int k")

    return m to k
}

fun cco99p2_answer(){
    val input = System.`in`.bufferedReader()

    val datasets = input.readLine().toIntOrNull() ?: throw IllegalArgumentException("invalid int datasets")
    val output = mutableListOf<String>()
    var i = 1
    while (i < datasets){
        val mk = (input.readLine())
        val (m,k) = checkMK(mk)
        if(i != 1) output.add("")
        when(k){
            1-> output.add("1st most common word(s):")
            2-> output.add("2nd most common word(s):")
            3-> output.add("3rd most common word(s):")
            else-> output.add("${k}th most common word(s):")
        }

        val words = mutableMapOf<String, Int>()
        var j = 0
        while(j < m){
            val word = input.readLine().lowercase()
            if(word.length > 20) throw Throwable("out of 20 length: $word")
            words[word]= words.getOrPut(word){0} + 1
        }
        val sort = words.entries.sortedByDescending { it.value }
        j = 0
        var nth =1
        var prev = sort[0].value
        while (j < sort.size){
            val(key,value) = sort[j]
            if(value < prev){
                if(nth == k) break
                nth++
                prev = value
            }
            if(nth == k)output.add(key)
            j++
        }
        i++
    }
    for(o in output){
        println(o)
    }
}

// 선생님의 코드와 비교해서 느낀(배운)점
// 1. m,k의 타입에 대한 예외 처리
// 2. Map.getOrPut(key){defaultValue} : 맵에 키가 있는 경우 해당 값 가져오기 or 없으면 defaultValue로 추가하기
// 3. Map.entries.sortedByDescending{비교할 값} :
//  entries - 키값 쌍을 set으로 반환
//  sortedByDescending{비교할 값} - 이터러블 내림차순 정렬하여 새 '리스트' 반환
// 4. break가 사용되는 건 리커젼. for 아닌 whlie 사용
// 5. 비교 값이 대상보다 클 경우에만, 비교값으로 대상을 교체하고 아닌 경우는 건너뛰는 걸 어떻게 작성해야 할지 고민이었다. while과 break 기억하기.
// 다시 비교해서 읽어보니, 내가 작성한 변수명이 매우 헷갈리는 거 같다.