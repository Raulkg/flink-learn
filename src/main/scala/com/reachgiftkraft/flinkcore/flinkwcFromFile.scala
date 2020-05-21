package com.reachgiftkraft.flinkcore

import org.apache.flink.streaming.api.scala._
import org.apache.flink.streaming.api.scala.StreamExecutionEnvironment
import org.apache.flink.streaming.api.windowing.time.Time
object flinkwcFromFile {

  def main(args: Array[String]): Unit ={


    // read text file from local files system
//    val localLines = env.readTextFile("file:///path/to/my/textfile")


    val env = StreamExecutionEnvironment.getExecutionEnvironment
    val text = env.socketTextStream("ec2-^^^^^^^.compute-1.amazonaws.com",9000)

    val counts = text.flatMap { _.toLowerCase.split("\\W+") filter { _.nonEmpty } }
      .map { (_, 1) }
      .keyBy(0)
      .timeWindow(Time.seconds(5))
      .sum(1)

    counts.print()
    counts.writeAsCsv("C:\\apache-flink\\src\\main\\scala\\com\\reachgiftkraft\\flinkcore\\");
    env.execute()



  }

}
