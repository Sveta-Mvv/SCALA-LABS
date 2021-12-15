import scala.annotation.tailrec //хвостовая рекурсия (loop) -  цикл, щаг 1 - полный лист, убирает первое значения в 1 вложенном листе, а в конец f(1) и так далее
//на каждом этапе промежуточный результат, до тех пор пока первый лист не обнулится (reverse)

/** Реализуйте функции для решения следующих задач.
  * Примечание: Попытайтесь сделать все функции с хвостовой рекурсией, используйте аннотацию для подстверждения.
  * рекурсия будет хвостовой если:
  *   1. рекурсия реализуется в одном направлении
  *   2. вызов рекурсивной функции будет последней операцией перед возвратом
  */
object RecursiveFunctions extends App {

  def length[A](as: List[A]): Int = {
    @tailrec
    def loop(rem: List[A], agg: Int): Int = rem match {
      case Cons(_, tail) => loop(tail, agg + 1)
      case Nil() => agg
    }

    loop(as, 0)
  }


  var test_for: List[Int] = (Cons(14, Cons(7, Cons(5, Nil()))))

  // a) Напишите функцию которая записывает в обратном порядке список:
  def reverse[A](list: List[A]): List[A] = {
    @tailrec
    def loop(list: List[A], neel: List[A]): List[A] = list match {
      case Cons(x, y) => loop(y, Cons(x, neel))
      case Nil() => neel
    }

    loop(list, Nil())

  }

  // используйте функцию из пункта (a) здесь, не изменяйте сигнатуру
  def testReverse[A](list: List[A]): List[A] = reverse(list)

  println(testReverse(Cons(14, Cons(7, Cons(5, Nil())))))


  // b) Напишите функцию, которая применяет функцию к каждому значению списка:
  def map[A, B](list: List[A])(f: A => B): List[B] = { //что и в реверс, но к h применяется функция
    @tailrec
    def loop(list: List[A], l_ist: List[B]): List[B] = list match {
      case Cons(x, y) => loop(y, Cons(f(x), l_ist))
      case Nil() => reverse(l_ist)
    }

    loop(list, Nil())
  }

  val Provchet: (Int) => Int = _ + 90

  // используйте функцию из пункта  (b) здесь, не изменяйте сигнатуру
  def testMap[A, B](list: List[A], f: A => B): List[B] = map(list)(f)

  println(testMap(test_for, Provchet))


  // c) Напишите функцию, которая присоединяет один список к другому:
  def append[A](l: List[A], neel: List[A]): List[A] = l match { // как реверс, только вместо 2 параметра не пустой лист Nil, а заполненный
    case Cons(x, y) => Cons(x, append(y, neel))
    case Nil() => neel
  }

  // используйте функцию из пункта  (c) здесь, не изменяйте сигнатуру
  def testAppend[A](l: List[A], r: List[A]): List[A] = append(l, r)

  println(testAppend(test_for, test_for))


  // d) Напишите функцию, которая применяет функцию к каждому значению списка:
  def flatMap[A, B](list: List[A])(f: A => List[B]): List[B] = { //объединение, убирает все вложенности
    @tailrec
    def loop(list: List[A], num: List[B]): List[B] = list match {
      case Cons(x, y) => loop(y, testAppend(f(x), num))
      case Nil() => testReverse(num)
    }

    loop(list, Nil())
  }


  // она получает функцию, которая создает новый List[B] для каждого элемента типа A в списке. Поэтому вы создаете List[List[B]].


  // используйте функцию из пункта  (d) здесь, не изменяйте сигнатуру
  def testFlatMap[A, B](list: List[A], f: A => List[B]): List[B] = flatMap(list)(f)

  println(testFlatMap(test_for,(x:Int)=>Cons(x*5, Nil())))



  /* e) Вопрос: Возможно ли написать функцию с хвостовой рекурсией для `Tree`s? Если нет, почему? */
  // (Нельзя. Так как хвостовая рекурсия последовательна в одном направлении, а дерево ходит то "вверх-то-вниз"(бинарное))
}