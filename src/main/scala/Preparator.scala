package com.template.kmeans

import io.prediction.controller.PPreparator
import io.prediction.data.storage.Event
import org.apache.spark.mllib.linalg.Vector

import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.rdd.RDD

class Preparator
  extends PPreparator[TrainingData, PreparedData] {

  def prepare(sc: SparkContext, trainingData: TrainingData): PreparedData = {
    new PreparedData(points = trainingData.points)
  }
}

class PreparedData(
  val points: RDD[Vector]
) extends Serializable
