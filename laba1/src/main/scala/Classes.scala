package exercise1

/* 
 * 
 a) Создать класс Animal, который имеет следующие поля:
 *      - name: String (название)
 *      - species: String (вид)
 *      - food: String
 * 
 *    Синтаксис: class MyClass(val publicField: Int, privateField: String) {
 *              // остальные поля и методы
 *            }
 * 
 * b) Создайте объект-компаньон для класса Animal и добавьте следующие сущности как поля:
 *      - cat, mammal, meat
 *      - parrot, bird, vegetables
 *      - goldfish, fish, plants
 * 
 *    Синтаксис: object MyClass {
 *              // статические поля и методы
 *            }
 * 
 * c) Добавьте следующие метод в Animals:
 *      def eats(food: String): Boolean
 *    
 *     который проверяет ест ли животное определенную пищу
 * 
 * d) Переопределите ваш класс Animal как трейт и создайте объекты класса-образца для Mammals, Birds и Fishs.
 *    Вам все еще нужно поле `species`?
 * 
 * e) Добавьте следующие функции в объект-компаньон Animal:
 *      def knownAnimal(name: String): Boolean  // true если это имя одного из трех животных из (b)
 *      def apply(name: String): Option[Animal] // возвращает одно из трех животных в соответствии с именем (Some) или ничего (None), см. ниже
 * 
 * f) Создайте трейт Food со следующими классами-образцами:
 *      - Meat
 *      - Vegetables
 *      - Plants
 *   и добавьте это в определение Animal. Так же добавьте объект-компаньон с методом apply():
 *      def apply(food: String): Option[Food]
 */

 // a) c)
 class Animal (name:String, species: String, food: Food) {
   def eats(food:String):Boolean = ((food == "meat" && name == "cat") || (food == "vegetables" && name == "parrot") || (food == "plants" && name == "goldfish"))
 }
 // b)
 object Animal {
   def CheckCat(): Animal = new Animal ("cat", "mammol", Meat())
   def CheckParrot(): Animal = new Animal ("parrot", "bird", Vegetables())
   def CheckGoldFish(): Animal = new Animal ("goldfish", "fish", Plants()) 
 
// e)
def knownAnimal(name: String):Boolean = name match {
  case "cat" => true
  case "parrot" => true
  case "goldfish" => true
  case _ => true
}
def apply (name: String): Option[Animal] = name match {
  case "сat" => Some(CheckCat())
  case "parrot" => Some(CheckParrot())
  case "goldfish" => Some(CheckGoldFish())
  case _ => None()
  }
}
 //d
 sealed trait Animals {
    val name: String
    val food: String
 }
    case class Mammals(name:String, food: String) extends Animals
    case class Birds(name: String, food: String) extends Animals
    case class Fishs(name: String, food: String) extends Animals

// f)
sealed trait Food 
case class Meat() extends Food
case class Vegetables() extends Food 
case class Plants() extends Food

object Food {
  def apply(food: String): Option[Food] = 
    food match {
    case "meat" => Some(Meat())
    case "vegetables" => Some(Vegetables())
    case "plants" => Some(Plants())
    case _ => None()
  }
}

sealed trait Option[A] {
 
  def isEmpty: Boolean
}
case class Some[A](a: A) extends Option[A] {
  val isEmpty = false
}
case class None[A]()     extends Option[A] {
  val isEmpty = true
}
