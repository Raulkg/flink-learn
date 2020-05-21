package com.reachgiftkraft.flinkcore

import org.apache.flink.streaming.api.scala._
import org.apache.flink.streaming.api.scala.StreamExecutionEnvironment

object flinkwc {

  def main(args: Array[String]): Unit ={

    val env = StreamExecutionEnvironment.getExecutionEnvironment
    val socketStream = env.socketTextStream("ec2-^^^^^^.compute-1.amazonaws.com",9000)
    val wordStream = socketStream.flatMap( x => x.split("\\s+")).map( a => (a,1))
    val kvPair = wordStream.keyBy(0)

    val countPair = kvPair.sum(1)
    countPair.print()


    env.execute()

  }

}
