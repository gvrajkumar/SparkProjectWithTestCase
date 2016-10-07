package com.vgunnu

import org.apache.spark.SparkContext
import org.apache.spark.broadcast.Broadcast
import org.apache.spark.rdd.RDD
import com.vgunnu.common.CLogHandler

case class WordCount(word: String, count: Int)

object WordCount {


  def count(sc: SparkContext, lines: RDD[String]): RDD[WordCount] = count(sc, lines, Set())

  def count(sc: SparkContext, lines: RDD[String], stopWords: Set[String]): RDD[WordCount] = {
    CLogHandler.log.info("In Count Method")
    val stopWordsVar = sc.broadcast(stopWords)

    val words = prepareWords(lines, stopWordsVar)

    val wordCounts = words.map(word => (word, 1)).reduceByKey(_ + _).map {
      case (word: String, count: Int) => WordCount(word, count)
    }

    val sortedWordCounts = wordCounts.sortBy(_.word)

    sortedWordCounts
  }

  

  private def prepareWords(lines: RDD[String], stopWords: Broadcast[Set[String]]): RDD[String] = {
    lines.flatMap(_.split("\\s"))
      .map(_.replace(",", "").replace(".", "").toLowerCase)
      .filter(!stopWords.value.contains(_)).filter(!_.isEmpty)
  }

}