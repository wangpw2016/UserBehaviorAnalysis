package com.atguigu.hotitems_analysis

import java.util.Properties

import org.apache.kafka.clients.producer.{KafkaProducer, ProducerRecord}

/**
  * Copyright (c) 2018-2028 尚硅谷 All Rights Reserved 
  *
  * Project: UserBehaviorAnalysis
  * Package: com.atguigu.hotitems_analysis
  * Version: 1.0
  *
  * Created by wushengran on 2019/9/21 16:54
  */
object KafkaProducer {
  def main(args: Array[String]): Unit = {
    writeToKafka("test")
  }
  def writeToKafka(topic: String): Unit ={
    val properties = new Properties()
    properties.put("bootstrap.servers", "47.100.106.29:9092,47.100.106.29:9093,47.100.106.29:9094")
    properties.setProperty("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
    properties.setProperty("value.serializer", "org.apache.kafka.common.serialization.StringSerializer")

    // 定义一个kafka producer
    val producer = new KafkaProducer[String, String](properties)
    val record = new ProducerRecord[String, String](topic, "1-A")
    producer.send(record)
    // 从文件中读取数据，发送
//    val bufferedSource = io.Source.fromFile( "H:\\flink\\UserBehaviorAnalysis\\HotItemsAnalysis\\src\\main\\resources\\UserBehavior.csv" )
//    for( line <- bufferedSource.getLines() ){
//      val record = new ProducerRecord[String, String](topic, line)
//      producer.send(record)
//    }
    producer.close()
  }
}
