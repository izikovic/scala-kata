package kata04

import java.io.InputStream

/**
 * @author y079883
 */

object Data {
  def getLines(f: String) = {
    val stream: InputStream = getClass.getResourceAsStream(f)
    scala.io.Source.fromInputStream(stream).getLines
  }

  def getDataById(idCol: Int, maxCol: Int, minCol: Int, lines: List[String]) = {
    val nonEmptyLines = lines filter (l => !l.trim().isEmpty() && !l.contains("---")) drop 1 map (x => x.trim())
    (nonEmptyLines map (l => l.split(" +"))  map (x => (x(idCol) -> (x(maxCol).replace("*", "").toFloat, x(minCol).replace("*", "").toFloat)))).toMap
  }
  
  def mungData(idCol: Int, maxCol: Int, minCol: Int, file: String) = {
    val dataById = getDataById(idCol, maxCol, minCol, getLines(file).toList) map { case (id, (max, min)) => (id -> Math.abs(max - min)) }
    dataById.minBy { case (id, spread) => spread }._1
  }
}

object DataMunging extends App {

  def getLines(f: String) = {
    val stream: InputStream = getClass.getResourceAsStream(f)
    scala.io.Source.fromInputStream(stream).getLines
  }

  val temLines = getLines("weather.dat")
  val footbalLines = getLines("football.dat")

  def isNumeric(x: String) = x forall Character.isDigit

  def tempsByDay() = ((temLines drop 2) map (l => l.trim().split(" +")) map (x => (x(0) -> (x(1).replace("*", "").toFloat, x(2).replace("*", "").toFloat)))).toMap
  def goalsByTeam() = (footbalLines drop 1 filter (x => !x.startsWith("---")) map (l => l.trim().split(" +")) filter (x => x.length > 8) map (x => (x(1) -> (x(6).toInt, x(8).toInt)))).toMap

  def weatherData() = {
    val tempSpreadsByDay = tempsByDay() map { case (day, (max, min)) => (day -> (max - min)) }

    tempSpreadsByDay.filter(x => isNumeric(x._1)).minBy { case (day, spread) => spread }._1
  }

  def footballData() = {
    val goalsSpread = goalsByTeam() map { case (team, (from, against)) => (team -> Math.abs(from - against)) }

    goalsSpread.minBy { case (team, spread) => spread }._1
  }

  def timeIt(f: => Unit) = {
    val start = System.currentTimeMillis()
    f
    val end = System.currentTimeMillis()
    println("time: %s".format((end - start)))
  }
  
  
  
  
  timeIt(println(weatherData()))
  timeIt(println(footballData()))
  
  import Data._
  
  timeIt(println(mungData(0, 1, 2, "weather.dat")))
  timeIt(println(mungData(1, 6, 8, "football.dat")))
}