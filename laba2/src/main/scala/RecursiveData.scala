sealed trait List[A]
case class Cons[A](head: A, tail: List[A]) extends List[A]
case class Nil[A]() extends List[A]

object RecursiveData extends App{


  // a) Реализуйте функцию, определяющую является ли пустым `List[Int]`.
  def ListEmpty(list: List[Int]): Boolean = list match {
    case list: Nil[Int] => true
    case list           => false
  }
  println(ListEmpty(Cons(7, Cons(4, Nil()))))
  println(ListEmpty(Nil()))

  // используйте функцию из пункта (a) здесь, не изменяйте сигнатуру
  def testListIntEmpty(list: List[Int]): Boolean = ListEmpty(list)
  println(testListIntEmpty(Cons(13, Cons(21, Nil()))))



  // b) Реализуйте функцию, которая получает head `List[Int]`или возвращает -1 в случае если он пустой.
  def ListHead(list: List[Int]): Int = list match {
    case list: Cons[Int] => list.head
    case list => -1
  }

  // используйте функцию из пункта (a) здесь, не изменяйте сигнатуру
  def testListIntHead(list: List[Int]): Int = ListHead(list)
  println(testListIntHead(Nil()))
  println(testListIntHead(Cons(99,Cons(45,Cons(21,Nil())))))




  // c) Можно ли изменить `List[A]` так чтобы гарантировать что он не является пустым?
  sealed trait SecondList[A]
  case class SecondCons[A](head: A, tail: SecondList[A]) extends SecondList[A]
  case class SecondNil[A](head: A) extends SecondList[A] //вместо пустого значения присваиваем А

  /* d) Реализуйте универсальное дерево (Tree) которое хранит значения в виде листьев и состоит из:
   *      node - левое и правое дерево (Tree)
   *      leaf - переменная типа A
   */
  sealed trait Tree[A]
  case class Node[A](left: Tree[A], right: Tree[A]) extends Tree[A]
  case class Leaf[A](leaf: A) extends Tree[A] //бинарное дерево
}
