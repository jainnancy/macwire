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

  val water: Water = wire[Water]
  val coffeeBeans: CoffeeBeans = wire[CoffeeBeans]
  val milk: Milk = wire[Milk]
  val espresso: Espresso = wire[Espresso]
  val cappuccino: Cappuccino = wire[Cappuccino]
  val latte: Latte = wire[Latte]
  val tea: Tea = wire[Tea]

  val coffeeList = List(espresso, cappuccino, latte)

  val coffeeMachine = wire[CoffeeMachine]
}
