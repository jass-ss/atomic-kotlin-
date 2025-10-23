package org.example

/*
* Every evening villagers in a small village gather around a big fire and sing songs.
* A prominent member of the community is the bard.
* Every evening, if the bard is present, he sings a brand new song that no villager has heard before.
* in the event that the bard is not present, other villagers sing without him and exchange all songs that they know
* 1. The first line of input contains an integer N, 2<=N<=100, the number of villagers
* 2. The villagers are numbered 1 to N.
* 3. Villager number 1 is the bard
* 4. The second line contains an integer E, 1<=E<=50, the number of evenings.
* 5. The next E lines contain the list of villagers present on each of the E evenings.
* 6. Each line begins with a positive integer K, 2<=K<=N, the number of villagers present that evening, integers separated by spaces representing the villagers
* 7. No villager will appear twice in one night and the bard will appear at least once across all nights.
* */

fun crci06p1(){
    val input = System.`in`.bufferedReader()

    val N = input.readLine().toIntOrNull()?:throw Throwable("invalid int")
    if(N !in 2..100) throw Throwable("out of range:N")
    val peopleMap = mutableMapOf<String,Int>()
    for(i in 1..N){
        peopleMap.put("$i",0)
    }
    val bard = "1"

    val evening = input.readLine().toIntOrNull()?:throw Throwable("invalid int")
    if(evening !in 1..50) throw Throwable("out of range:evening")
    var i = 0
    var song = 0
    while (i < evening){
        val info = input.readLine().split(" ")
        val number = info[0].toIntOrNull()?: throw Throwable("invalid int")
        val people = info.slice(1..number)

        if(bard in people){
            song++
            for(i in people){
               val knew = peopleMap.getOrPut(i){0}
               peopleMap[i] = knew + 1
            }
        }else{
            val curr = peopleMap.filter { (key,_)-> people.contains(key)}
            val max = curr.maxByOrNull { it.value }?.value ?: throw Throwable("invalid")
            for(i in curr.keys){
                peopleMap[i] = max
            }
        }
        i++
    }

    val allSong = peopleMap.filter { (_,value) -> value == song }
    for( i in allSong){
        println(i.key)
    }
}

fun inputNight(v:String, N:Int):List<Int>{
    val s = v.split(" ")
    val num = inputInt(s[0], 1..N)
    if(s.size - 1 != num) throw Throwable("invalid input, ${s.size} - 1 != $num")
    val list = mutableListOf<Int>()
    for(i in 1..num){
        val villager = inputInt(s[i], 1..N)
        if(villager in list) throw Throwable("duplicate villager: $villager")
        list.add(villager)
    }
    return list
}

fun crci06p1_answer() {
    val input = System.`in`.bufferedReader()
    val output = System.out.bufferedWriter()

    val N = inputInt(input.readLine(), 2..100)
    val E = inputInt(input.readLine(), 1..50)

    var songid = 0
    val knowSong = mutableMapOf<Int, MutableList<Int>>()
    var i = 0
    while(i < E){
        val presents = inputNight(input.readLine(), N)
        if(1 in presents){
            songid++
            for(villager in presents){
                knowSong.getOrPut(villager){mutableListOf()}.add(songid)
            }
        }else{
            val allSongs = mutableSetOf<Int>()
            for(villager in presents){
                allSongs.addAll(knowSong.getOrPut(villager){mutableListOf()})
            }
            for(villager in presents){
                knowSong[villager] = allSongs.toMutableList()
            }
        }
        i++
    }
    val allKnew = mutableListOf<Int>()
    for((v, s) in knowSong){
        if(s.size == songid) allKnew.add(v)
    }
    for(villager in allKnew.sorted()){
        println(villager)
    }

    output.flush()
}
