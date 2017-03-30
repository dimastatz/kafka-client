import scala.util.Try

/**
  * Created by dima on 3/30/2017.
  */
object Boot {
  def main(args: Array[String]): Unit = {
    println("starting kafka clients")

    val topic = Try(args(1)).getOrElse("testTopic")
    val servers = Try(args(0)).getOrElse("172.22.0.212:9092")

    val password = Try(args(3)).getOrElse("")
    val encryptionFile = Try(args(4)).getOrElse("")
    val isSSL = Try(args(2).toBoolean).getOrElse(false)

    val dataIn = "Some data to add"
    val client = new KafkaClient(servers, isSSL, password, encryptionFile, true)
    val offset = client.publish(topic, 100, dataIn)
    println(s"data published:$dataIn, ${offset.offset()}")

    val dataOut = client.consume(List(topic), true)
    println(s"data consumed:$dataOut")
  }
}
