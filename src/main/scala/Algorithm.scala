package com.template.kmeans

import io.prediction.controller.P2LAlgorithm
import io.prediction.controller.Params
import org.apache.spark.mllib.clustering.KMeans
import org.apache.spark.mllib.clustering.KMeansModel
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.rdd.RDD
import org.apache.spark.mllib.linalg.Vector
import org.apache.spark.mllib.linalg.Vectors
import grizzled.slf4j.Logger

case class AlgorithmParams(val numberOfCenters: Int,val numberOfIterations: Int) extends Params

class Algorithm(val ap: AlgorithmParams) extends P2LAlgorithm[PreparedData, KMeansModel, Query, PredictedResult] {

  	@transient lazy val logger = Logger[this.type]
  	def train(sc: SparkContext, data: PreparedData): KMeansModel = {
		println("Running the K-Means clustering algorithm.")
		  // Creates a new KMeans class which generates the KMeansModel
  	  	val kMeansI = new KMeans()
 		  // Setting the parameters
  	  	kMeansI.setK(ap.numberOfCenters)
		  kMeansI.setMaxIterations(ap.numberOfIterations)
		  	// Return the KMeansModel which we get after running the KMeans
  	  		// algorithm on the data gathered by the DataSource component
  	  	kMeansI.run(data.points)  
  	 }

	def predict(model: KMeansModel, query: Query): PredictedResult = {
  	  // Use the KMeansModel to predict cluster for new dataPoint
  	  val result = model.predict(Vectors.dense(query.dataPoint))
  	  PredictedResult(cluster = result)  
	}
	}

	class Model(val mc: Int) extends Serializable { override def toString = s"mc=${mc}"}

