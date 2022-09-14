package com.example.study.kotlin.plate1.chat8

/**
 * <pre>
 *     author : liaozh
 *     e-mail : xxx@xx
 *     time   : 2022/09/05
 *     desc   : 统计单词频率
 *     version: 1.0
 * </pre>
 */
class TextProcessorV1 {
    fun processText(text : String) : List<WordFreq> {
        //1、清洗非单词内容 如标点符号
        val cleaned = clean(text)
        //2、分割
        val words = cleaned.split(" ")
        //3、统计数量
        val map = getWordCount(words)
        //4、排序
       return sortByFrequency(map)

        //优化版本2
    }

    private fun sortByFrequency(map: Map<String,Int>) : MutableList<WordFreq>{
        val list = mutableListOf<WordFreq>()
        for (entry in map) {
            if (entry.key == "") continue
            val freq = WordFreq(entry.key,entry.value)
            list.add(freq)
        }
        list.sortByDescending { it.frequency }
        return list
    }

    private fun getWordCount(words: List<String>) : Map<String,Int> {
        val map = hashMapOf<String,Int>()
        for (word in words) {
            if (word == "") continue
            val trim = word.trim()
            val count = map.getOrDefault(trim, 0)
            map[trim] = count +1
        }
        return map
    }

    private fun clean(text: String) : String {
        return text.replace("[^A-Za-z]".toRegex()," ")
    }
}
data class WordFreq(val word : String, val frequency : Int)