
/** Напишите решение в виде функции. 
  * 
  * Синтаксис:
  *   val a: Int = ???
  * 
  *   a match {
  *     case 0 => true
  *     case _ => false
  *   }
  */
object PatternMatching extends App {
  
  sealed trait Hand
  case object Rock    extends Hand
  case object Paper   extends Hand
  case object Scissor extends Hand

  sealed trait Result
  case object Win  extends Result
  case object Lose extends Result
  case object Draw extends Result

  sealed trait Food
  case object Meat       extends Food
  case object Vegetables extends Food
  case object Plants     extends Food


  sealed trait Animal {

    val name: String
    val food: Food
  }
  case class Mammal(name: String, food: Food, weight: Int) extends Animal
  case class Fish(name: String, food: Food)                extends Animal
  case class Bird(name: String, food: Food)                extends Animal

  /* a) Напишите функцию, которая ставит в соответствие числу строку слудеющим образом:
   * Если:
   *     1 => "it is one"
   *     2 => "it is two"
   *     3 => "it is three"
   *     иначе => "what's that"
   */

  def CIntToString(chesl: Int): String = chesl match {
    case 1 => "it is one"
    case 2 => "it is two"
    case 3 => "it is three"
    case _ => "i have no idea"
}

  // примените вашу функцию из пункта (a) здесь, не изменяя сигнатуру
  def testIntToString(value: Int): String = CIntToString(value)
  println(testIntToString(2))


  /* b) Напишите функцию которая возвращает true если переменная `value` принимает значение:
   *     "max" или "Max
   *     "moritz" или "Moritz"
   */
  def CIsMaxAndMoritz(znach:String):Boolean = znach == "max" || znach == "Мax" || znach == "moritz" || znach == "Moritz"

  // примените функции из пункта (b) здесь, не изменяя сигнатуру
  def testIsMaxAndMoritz(value: String): Boolean = CIsMaxAndMoritz(value)
  println(testIsMaxAndMoritz("Maxim"))

  // c) Напишите функцию проверки является ли `value` четным 
  def CIsEven(chet: Int):Boolean = chet %2 == 0


  // примените функции из пункта (c) здесь, не изменяя сигнатуру
  def testIsEven(value: Int): Boolean = CIsEven(value)
  println(testIsEven(20))

  /* d) Напишите функцию, моделирующую игру в Камень ножницы бумага 
   *     1. камень побеждает ножницы
   *     2. ножницы побеждают бумагу
   *     3. бумага побеждает камень
   *    Выиграет ли игрок `a`?
   */
  def CWin(a:Hand, b:Hand):Result = a match{
      case Rock => b match { 
        case Scissor => Win
        case Rock => Draw
        case Paper => Lose
      }
      case Scissor => b match {
        case Scissor => Draw
        case Paper => Win
        case Rock => Lose
      }
      case Paper => b match {
        case Scissor => Lose
        case Paper => Draw
        case Rock => Win
      }
  }
  // примените вашу функцию из пункта (d) здесь, не изменяя сигнатуру
  def testWinsA(a: Hand, b: Hand): Result = CWin(a,b)
  println(testWinsA(Scissor,Paper))


  // Примечание: используйте определение Animals

  // e) Верните вес (weight: Int) объекта Mammal, иначе верните -1.
  def ExtractMammaWeight(animal: Animal): Int = animal match{
    case mammal: Mammal => mammal.weight
    case _ => -1 
  }

  // примените функцию из пункта (e) здесь, не изменяйте сигнатуру
  def testExtractMammalWeight(animal: Animal): Int = ExtractMammaWeight(animal)
  println(testExtractMammalWeight(Mammal ("Wolf", Meat, 210)))

  // f) Измените поле еда объектов классов Fishes и Birds на Plants, класс Mammels оставьте неизмененным.
  def UpdateFood(animal:Animal): Animal = animal match {
    case fish: Fish => Fish (fish.name, Plants)
    case bird: Bird => Bird (bird.name, Vegetables)
    case mammal: Mammal => Mammal (mammal.name, mammal.food, mammal.weight)
  }


  // примените функцию из пункта (f) здесь, не изменяйте сигнатуру
  def testUpdateFood(animal: Animal): Animal = UpdateFood(animal)
  println(testUpdateFood(Fish ("Clown",Plants)))

}
 