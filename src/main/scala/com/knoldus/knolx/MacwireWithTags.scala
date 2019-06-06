package com.knoldus.knolx

import com.softwaremill.macwire.wire
import com.softwaremill.tagging._

// DI using MacWire with tags

object MacwireWithTags extends App {

  case class Water()

  case class CoffeeBeans()

  trait PowderedMilk
  trait DairyMilk
  trait NormalMilk

  case class Milk() {
    println("Milk is ready")
  }

  case class Espresso(water: Water, coffeeBeans: CoffeeBeans) extends Coffee

  case class Cappuccino(water: Water, coffeeBeans: CoffeeBeans, powderedMilk: Milk @@ PowderedMilk, dairyMilk: Milk @@ DairyMilk ) extends Coffee

  case class Latte(water: Water, coffeeBeans: CoffeeBeans, milk: Milk @@ DairyMilk)  extends Coffee

  trait Coffee

  case class Tea(water: Water, milk: Milk @@ NormalMilk)

  case class CoffeeMachine(milk: Milk @@ DairyMilk,
                           coffee: List[Coffee],
                           tea: Tea) {
    println(s"Hello! Your Coffee Machine $this is ready.")
  }

  lazy val water: Water = wire[Water]
  lazy val coffeeBeans: CoffeeBeans = wire[CoffeeBeans]
  lazy val dairyMilk = wire[Milk].taggedWith[DairyMilk]
  lazy val powderedMilk = wire[Milk].taggedWith[PowderedMilk]
  lazy val normalMilk = wire[Milk].taggedWith[NormalMilk]
  lazy val espresso: Espresso = wire[Espresso]
  lazy val cappuccino: Cappuccino = wire[Cappuccino]
  lazy val latte: Latte = wire[Latte]
  lazy val tea: Tea = wire[Tea]

  lazy val coffeeList = List(espresso, cappuccino, latte)

  val coffeeMachine = wire[CoffeeMachine]
}
