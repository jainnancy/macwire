package com.knoldus.knolx

import com.softwaremill.macwire._

// DI using MacWire

object MacwireDependency extends App {

  case class Water()

  case class CoffeeBeans()

  case class Milk() {
    println("Milk is ready")
  }

  case class Espresso(water: Water, coffeeBeans: CoffeeBeans) extends Coffee

  case class Cappuccino(water: Water, coffeeBeans: CoffeeBeans, milk: Milk) extends Coffee

  case class Latte(water: Water, coffeeBeans: CoffeeBeans, milk: Milk)  extends Coffee

  trait Coffee

  case class Tea(water: Water, milk: Milk)

  case class CoffeeMachine(milk: Milk,
                           coffee: List[Coffee],
                           tea: Tea) {
    println(s"Hello! Your Coffee Machine $this is ready.")
  }

  lazy val water: Water = wire[Water]
  lazy val coffeeBeans: CoffeeBeans = wire[CoffeeBeans]
  lazy val milk: Milk = wire[Milk]
  lazy val espresso: Espresso = wire[Espresso]
  lazy val cappuccino: Cappuccino = wire[Cappuccino]
  lazy val latte: Latte = wire[Latte]
  lazy val tea: Tea = wire[Tea]

  lazy val coffeeList = List(espresso, cappuccino, latte)

  val coffeeMachine = wire[CoffeeMachine]
}
