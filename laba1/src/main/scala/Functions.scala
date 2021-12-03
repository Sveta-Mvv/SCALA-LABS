
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
  println(testCircle(50))
  


  /* b) Напишите карированную функцию которая рассчитывает площадь прямоугольника a * b.
   */
  def testRectangleCurried(a: Double)(b: Double): Double = a * b
  // многоэтапное дейтствие


  // примените вашу функцию из пукта (b) здесь, не изменяя сигнатуру
  println(testRectangleCurried(2))
  println(testRectangleCurried(2)(4))

  // c) Напишите не карированную функцию для расчета площади прямоугольника.
  def test2(a: Double, b: Double): Double = a * b



  // примените вашу функцию из пункта (c) здесь, не изменяя сигнатуру
  println(test2(2,7))
}
