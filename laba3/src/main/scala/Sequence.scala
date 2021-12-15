import scala.annotation.tailrec

/** Напишите свои решения в тестовых функциях.
  * 
  * Seq(1, 2) match {
  *   case head +: tail => ???
  *   case Nil          => ???
  *   case s            => ???
  * }
  * https://www.scala-lang.org/api/2.12.0/scala/collection/Seq.html
  */
// Примечание: напишите функции с хвостовой рекурсией

object Sequence extends App{

  // a) Найдите последний элемент Seq.

  val seq_ = Seq (44,32,90,87,65)
  val seq__ = Seq (44,67,80,2)
  val seq___ = Seq (1,2,2,1)

  def testLastElement[A](seq: Seq[A]): Option[A] = seq match {
    case init :+ last => Some(last)
    case Nil          => None
  }
  println(testLastElement(seq_))

  // b) Объедините две Seqs (то есть Seq(1, 2) и Seq(3, 4) образуют Seq((1, 3), (2, 4))) - если Seq длиннее игнорируйте оставшиеся элементы.

  def testZip[A](a: Seq[A], b: Seq[A]): Seq[(A, A)] = a.zip(b)
  println(testZip(seq_,seq__))


  // c) Проверьте, выполняется ли условие для всех элементов в Seq.

  def testForAll[A](seq: Seq[A])(cond: A => Boolean): Boolean = {
    @tailrec
    def loop(sseq:Seq[A],end:Boolean):Boolean={
      sseq match {
        case head::tail=>loop(tail,cond(head))
        case Nil=>end
      }
    }
    loop(seq,true) // любой пустой список верен
  }
  println(testForAll(seq__)(x => x > 0))



  // d) Проверьте, является ли Seq палиндромом

  def testPalindrom[A](seq: Seq[A]): Boolean = {
    @tailrec
    def loop(sseq:Seq[A],pal:Int):Int={
      sseq.length match {
        case 0 => pal
        case 1 => pal
        case _ => if (sseq.head==sseq.last) loop(sseq.tail.init,pal+1) else pal
      }
    }
    return loop(seq,0)==seq.length/2
  }
  println(testPalindrom(seq___))



  // e) Реализуйте flatMap используя foldLeft. 

  def testFlatMap[A, B](seq: Seq[A])(f: A => Seq[B]): Seq[B] = seq.foldLeft(Seq[B]())((x, y) => x++:f(y)) 
  println(testFlatMap(seq___)(x => Seq(x / 2)))
}
