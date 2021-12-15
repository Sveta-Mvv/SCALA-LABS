import scala.util.{Try, Failure, Success}

/** Реализуйте следующие функции.
  * 
  * List(1, 2) match {
  *   case head :: tail => ???
  *   case Nil          => ???
  *   case l            => ???
  * }
  * 
  * Option(1) match {
  *   case Some(a) => ???
  *   case None    => ???
  * }
  * 
  * Either.cond(true, 1, "right") match {
  *   case Left(i)  => ???
  *   case Right(s) => ???
  * }
  * 
  * Try(impureExpression()) match {
  *   case Success(a)     => ???
  *   case Failure(error) => ???
  * }
  * 
  * Try(impureExpression()).toEither
  * 
  */
object Adts extends App {

  // a) Дан List[Int], верните элемент с индексом n
  // примените функцию из пункта (a) здесь, не изменяйте сигнатуру

  def testGetNth(list: List[Int], n: Int): Option[Int] = {
    list match {
      case head :: tail => Some(list(n))
      case Nil   => None
      case null  => None
    }

  }
      println(testGetNth(List(119,2,8,565),2))


  // b) Напишите функцию, увеличивающую число в два раза.
  // примените функцию из пункта (b) здесь, не изменяйте сигнатуру

  def testDouble(n: Option[Int]): Option[Int] = {
    n match {
      case Some(y) => Some(y * 2)
      case None => None
    }
  }
    println(testDouble(Some(10907)))


  // c) Напишите функцию, проверяющую является ли число типа Int четным. Если так, верните Right. В противном случае, верните Left("Нечетное число.").
  // примените функцию из пункта (c) здесь, не изменяйте сигнатуру
  def testIsEven(n: Int): Either[String, Int] = n match {
    case value: Int if value % 2 == 0 => Right(n)
    case _ => Left("Нечетное число.")
  }
  println(testIsEven(17))



  // d) Напишите функцию, реализующую безопасное деление целых чисел. Верните Right с результатом или Left("Вы не можете делить на ноль.").
  // примените функцию из пункта (d) здесь, не изменяйте сигнатуру
  def testSafeDivide(a: Int, b: Int): Either[String, Int] = (a, b) match {
    case (a, b) if b != 0 => Right(a / b)
    case _ => Left("Вы не можете делить на ноль.")
  }
  println(testSafeDivide(40, 0))
  println(testSafeDivide(40, 2))



  // e) Обработайте исключения функции с побочным эффектом вернув 0.
  // примените функцию из пункта (e) здесь, не изменяйте сигнатуру

  def testGoodOldJava(impure: String => Int, str: String): Try[Int] = {
    Try(impure(str)) match {
      case Success(a) => Success(a)
      case Failure(error) => Failure(error)
    }
  }
  println(testGoodOldJava(x => x.toInt, "bllfress"))
  println(testGoodOldJava(x => x.toInt, "90"))
}
