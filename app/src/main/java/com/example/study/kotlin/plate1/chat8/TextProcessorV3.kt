package com.example.study.kotlin.plate1.chat8

import androidx.ui.vectormath64.transform

/**
 * <pre>
 *     author : liaozh
 *     e-mail : xxx@xx
 *     time   : 2022/09/05
 *     desc   : 统计单词频率 优化版本3
 *     version: 1.0
 * </pre>
 */
class TextProcessorV3 {
    fun processText(text : String) : List<WordFreq3> {

        //优化版本2

        return text.clean().split(" ").getWordCount()
            .mapToList { WordFreq3(it.key,it.value)}
            .sortedByDescending { it.frequency }
    }

//    private fun Map<String,Int>.sortByFrequency() : MutableList<WordFreq2>{
//        val list = mutableListOf<WordFreq2>()
//        for (entry in this) {
//            if (entry.key == "") continue
//            val freq = WordFreq2(entry.key,entry.value)
//            list.add(freq)
//        }
//        list.sortByDescending { it.frequency }
//        return list
//    }
private fun <T> Map<String, Int>.mapToList(transform:(Map.Entry<String, Int>) -> T): MutableList<T> {
    val list = mutableListOf<T>()
    for (entry in this) {
        val freq = transform(entry)
        list.add(freq)
    }
    return list
}

    private fun List<String>.getWordCount() : Map<String,Int> {
        val map = hashMapOf<String,Int>()
        for (word in this) {
            if (word == "") continue
            val trim = word.trim()
            val count = map.getOrDefault(trim, 0)
            map[trim] = count +1
        }
        return map
    }

    private fun String.clean() : String {
        return this.replace("[^A-Za-z]".toRegex()," ")
    }
}
data class WordFreq3(val word : String, val frequency : Int)