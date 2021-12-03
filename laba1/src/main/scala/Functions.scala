package exercise1

/** Напишите отдельные функции, решающие поставленную задачу. 
  * 
  * Синтаксис:
  *   // метод
  *   def myFunction(param0: Int, param1: String): Double = // тело
  * 
  *   // значение
  *   val myFunction: (Int, String) => Double (param0, param1) => // тело
  */
object Functions extends App{

  /* a) Напишите функцию, которая рассчитывает площадь окружности
   *    r^2 * Math.PI
   */
  def testCircle(r: Double): Double = r*r*Math.PI


  // примените вашу функцию из пункта (a) здесь, не изменяя сигнатуру
  println(testCircle(2))
  


  /* b) Напишите карированную функцию которая рассчитывает площадь прямоугольника a * b.
   */
  def testRectangleCurried(a: Double)(b: Double): Double = a * b // передаем сначала одно значение, потом другое
  // многоэтапное дейтствие (пока это... делаешь то)


  // примените вашу функцию из пукта (b) здесь, не изменяя сигнатуру
  println(testRectangleCurried(3))
  println(testRectangleCurried(3)(4))

  // c) Напишите не карированную функцию для расчета площади прямоугольника.
  def test2(a: Double, b: Double): Double = a * b



  // примените вашу функцию из пункта (c) здесь, не изменяя сигнатуру
  println(test2(2,7))
}
