package kata04

object kata04 {
	import DataMunging._
	
	weatherData()                             //> java.lang.NullPointerException
                                                  //| 	at kata04.DataMunging$.tempsByDay(DataMunging.scala:14)
                                                  //| 	at kata04.DataMunging$.weatherData(DataMunging.scala:17)
                                                  //| 	at kata04.kata04$$anonfun$main$1.apply$mcV$sp(kata04.kata04.scala:6)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$$anonfun$$exe
                                                  //| cute$1.apply$mcV$sp(WorksheetSupport.scala:76)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.redirected(W
                                                  //| orksheetSupport.scala:65)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.$execute(Wor
                                                  //| ksheetSupport.scala:75)
                                                  //| 	at kata04.kata04$.main(kata04.kata04.scala:4)
                                                  //| 	at kata04.kata04.main(kata04.kata04.scala)
}