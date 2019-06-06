/*
package practice

import com.softwaremill.macwire._
import com.softwaremill.tagging._


object Demo1 extends App {

  /* case class Dependency11() extends A {

         override def abc(): Unit = println("hello>>>")
   }

   case class B() extends A {
     override def abc(): Unit = println("Hello B!")
   }

   case class Dependency12()

   case class Dependent1(dependency11: A, dependency12: Dependency12)

   case class Dependency21()

   case class Dependent2(dependency21: Dependency21)

   case class Main(dependent1: Dependent1, dependent2: Dependent2) {
     println(s"$this has been called")
   }

   trait A {
     def abc()
   }*/

  /*val dependency11 = new Dependency11
  val dependency12 = new Dependency12
  val dependent1 = new Dependent1(dependency11, dependency12)
  val dependency21 = new Dependency21
  val dependent2 = new Dependent2(dependency21)
*/
  /*val dependency11 = new Dependency11
  val dependent1 = new Dependent1(dependency11, dependency12)
  val dependency12 = new Dependency12
  val dependency21 = new Dependency21
  val dependent2 = new Dependent2(dependency21)*/

  /*lazy val dependency11 = new Dependency11
  lazy val dependent1 = new Dependent1(dependency11, dependency12)
  lazy val dependency12 = new Dependency12
  lazy val dependency21 = new Dependency21
  lazy val dependent2 = new Dependent2(dependency21)*/

  //  lazy val dependency11 = wire[Dependency11]
  /*
    lazy val dependent1 = wire[Dependent1]
    lazy val b = wire[B]
    lazy val dependency12 = wire[Dependency12]
    lazy val dependency21 = wire[Dependency21]
    lazy val dependent2 = wire[Dependent2]

    val main = wire[Main]
  */


  /*  class DatabaseAccess()
    class TaxDeductionLibrary(databaseAccess: DatabaseAccess)
    class TaxCalculator(taxBase: Double, taxDeductionLibrary: TaxDeductionLibrary)

    case class ABC(taxCalculator: TaxCalculator)

    lazy val theDatabaseAccess      = wire[DatabaseAccess]
    lazy val theTaxDeductionLibrary = wire[TaxDeductionLibrary]
    def taxCalculator(taxBase: Double) = wire[TaxCalculator]
    */

  /*class A()
  class B()

  class C(a: A, b:B, specialValue: Int)
  object C {
    def create(a: A, b:B) = new C(a, b, 42)
  }

  trait MyModule {
    lazy val a = wire[A]
    lazy val b = wire[B]
    lazy val c = wireWith(C.create _)
  }*/

  /*case class UserFinder()

  class FacebookAccess(userFind: UserFinder)

  class UserModule {
    lazy val userFinder = wire[UserFinder]
  }

  class SocialModule(userModule: UserModule) {
    import userModule._

    lazy val facebookAccess = wire[FacebookAccess]
  }*/


  /*class UserFinder()

  class FacebookAccess(userFind: UserFinder)

  @Module // This annotation will help by indicating that the members of the class should be searched by macwire when it is depended upon:
  class UserModule {
    lazy val userFinder = wire[UserFinder]
  }

  class SocialModule(userModule: UserModule) {
    lazy val facebookAccess = wire[FacebookAccess]
  }*/

  /*abstract class bTag() //marker trait
  trait cTag

  class A
  class B(a: A @@ bTag)
  class C(a: A @@ cTag)
  class D(a: A)

  val abTag = wire[A].taggedWith[bTag]
  val acTag = wire[A].taggedWith[cTag]
//  val abcTag = wire[A].taggedWith[cTag].andTaggedWith[bTag] // fail at compile time
  val b = wire[B]
  val c = wire[C]
//  val d = wire[D] // fail at compile time*/


  /*//WireSet
  trait Musician
  class RockBand(musicians: Set[Musician])

  trait RockBandModule {
    lazy val singer    = new Musician {}
    lazy val guitarist = new Musician {}
    lazy val drummer   = new Musician {}
    lazy val bassist   = new Musician {}

    lazy val musicians = wireSet[Musician] // all above musicians will be wired together
    // musicians has type Set[Musician]

    lazy val rockBand  = wire[RockBand]
  }*/

  case class Dependency11()

  case class Dependency12()

  case class Dependent1(dependency11: Dependency11, dependency12: Dependency12, str: String)

  case class Dependency21()

  case class Dependent2(dependency21: Dependency21)

  case class Main(dependent1: Dependent1, dependent2: Dependent2) {
    println(s"$this has been called")
  }

  lazy val dependency11 = wire[Dependency11]

  def dependent1(string: String) = wire[Dependent1]
  lazy val dependency12 = wire[Dependency12]
  lazy val dependency21 = wire[Dependency21]
  lazy val dependent2 = wire[Dependent2]

  val main = wire[Main]
}
*/
