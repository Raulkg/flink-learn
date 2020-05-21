package com.reachgiftkraft.flinkcore
import java.util.Properties

import org.apache.flink.streaming.api.scala._
import org.apache.flink.streaming.api.scala.StreamExecutionEnvironment
import org.apache.flink.streaming.connectors.kinesis.FlinkKinesisConsumer
import org.apache.flink.streaming.connectors.kinesis.config.{AWSConfigConstants, ConsumerConfigConstants}
import org.apache.flink.streaming.util.serialization.SimpleStringSchema


object flinkKinesis {

  def main(args: Array[String]): Unit ={

    val consumerConfig = new Properties()
    consumerConfig.put(AWSConfigConstants.AWS_REGION, "us-east-1")
    consumerConfig.put(AWSConfigConstants.AWS_ACCESS_KEY_ID, "AWS_ACCESS_KEY_ID")
    consumerConfig.put(AWSConfigConstants.AWS_SECRET_ACCESS_KEY, "AWS_SECRET_ACCESS_KEY")
    consumerConfig.put(ConsumerConfigConstants.STREAM_INITIAL_POSITION, "LATEST")

    val env = StreamExecutionEnvironment.getExecutionEnvironment
    env.enableCheckpointing(5000)
    val kinesis = env.addSource(new FlinkKinesisConsumer[String](
      "DataStream", new SimpleStringSchema, consumerConfig))

    kinesis.print()


  }

}
