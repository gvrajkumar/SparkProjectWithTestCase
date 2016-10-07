package com.vgunnu

import org.scalatest._
import com.vgunnu.common.spark.SparkSpec

class SparkExampleSpec extends FlatSpec with SparkSpec with GivenWhenThen with Matchers {

  "Test Empty set" should "be counted" in {
    val lines = Array("")
    val wordCounts = WordCount.count(sc, sc.parallelize(lines)).collect()
    wordCounts shouldBe empty
  }

  "Shakespeare most famous quote" should "be counted" in {
    val lines = Array("To be or not to be.", "That is the question.")

    val stopWords = Set("the")

    val wordCounts = WordCount.count(sc, sc.parallelize(lines), stopWords).collect()

    wordCounts should equal(Array(
      WordCount("be", 2),
      WordCount("is", 1),
      WordCount("not", 1),
      WordCount("or", 1),
      WordCount("question", 1),
      WordCount("that", 1),
      WordCount("to", 2)))
  }

}