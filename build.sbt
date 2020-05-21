name := "apache-flink"

version := "0.1"

scalaVersion := "2.11.8"



// https://mvnrepository.com/artifact/org.apache.flink/flink-scala
libraryDependencies += "org.apache.flink" %% "flink-scala" % "1.10.1"


// https://mvnrepository.com/artifact/org.apache.flink/flink-core
libraryDependencies += "org.apache.flink" % "flink-core" % "1.10.1"

// https://mvnrepository.com/artifact/org.apache.flink/flink-table
libraryDependencies += "org.apache.flink" % "flink-table" % "1.10.1" % "provided" pomOnly()

// https://mvnrepository.com/artifact/org.apache.flink/flink-streaming-scala
libraryDependencies += "org.apache.flink" %% "flink-streaming-scala" % "1.10.1"

// https://mvnrepository.com/artifact/org.apache.flink/flink-connector-kinesis
libraryDependencies += "org.apache.flink" %% "flink-connector-kinesis" % "1.10.1"

