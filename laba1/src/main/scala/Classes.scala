
 // a) c)
 object Main extends App {
 class Animal (name:String, species: String, food: Food) {
   def eats(food: String): Boolean =
     ((food == "meat" && name == "cat") || (food == "vegetables" && name == "parrot") || (food == "plants" && name == "goldfish"))

 }
   println(s"That`s your food, cat? ${new Animal("cat", "mammol", Meat()).eats("meat")}")
   println(s"Am i know you? ${Animal.knownAnimal("cat")}")
   println(s"Apply plants? ${Animal.apply("plants")}")
   println(s"Apply meat? ${Food.apply("meat")}")

 // b)
 object Animal extends App {
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

object Food extends App{
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
}