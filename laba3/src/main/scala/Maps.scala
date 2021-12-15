import scala.language.postfixOps
import Maps.User
/** Напишите вашу реализацию в тестовые функции.
  * 
  * https://docs.scala-lang.org/overviews/collections/maps.html
  */
object Maps extends App{

  case class User(name: String, age: Int)
  val UList: List[User] = List(User("Dima", 20), User("Dima", 19), User("Dima", 21), User("Dima", 20))
  val AdamMap = Map("1" -> User("Adame", 76), "2" -> User("Vanessa", 33), "3" -> User("Adam", 21), "4" -> User("Asuna", 16))
  val AgeMap = Map("1" -> User("Veronika", 35), "2" -> User("Milkey", 36), "3" -> User("Joshua", 19))

  /* a) В данной Seq[User] сгруппируйте пользователей по имени (`groupBy`) и вычислите средний возраст: `name -> averageAge`
   *    Вы можете реализовать ваше решение в теле тестовой функции. Не изменяйте сигнатуру.
   */
  def testGroupUsers(users: Seq[User]): Map[String, Int] = users.groupBy(_.name).map(row => (row._1, row._2(0).age)) + ("averageAge" -> users.map(_.age).sum / users.length)
  println(testGroupUsers(UList))



  /* b) Дана `Map[String, User]` состоящая из имен пользователей `User`, сколько имен пользователей, содержащихся в Map, содержат подстроку "Adam"?
   *    Вы можете реализовать ваше решение в теле тестовой функции. Не изменяйте сигнатуру.
   */
  def testNumberFrodos(map: Map[String, User]): Int = map.count(row=>row._2.name=="Adam")
  println(testNumberFrodos(AdamMap))



  /* c) Удалите всех пользователей возраст которых менее 35 лет.
   *    Вы можете реализовать ваше решение в теле тестовой функции. Не изменяйте сигнатуру.
   */
  def testUnderaged(map: Map[String, User]): Map[String, User] = map.filter(x => x._2.age >= 35)
  println(testUnderaged(AgeMap))

}
