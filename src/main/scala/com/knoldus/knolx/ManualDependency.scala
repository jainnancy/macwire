package com.knoldus.knolx

// Manual DI

object ManualDependency extends App {

  case class Water()

  case class CoffeeBeans()

  case class Milk()

  trait Coffee

  case class Espresso(water: Water, coffeeBeans: CoffeeBeans) extends Coffee

  case class Cappuccino(water: Water, milk: Milk, coffeeBeans: CoffeeBeans) extends Coffee

  case class Latte(water: Water, coffeeBeans: CoffeeBeans, milk: Milk) extends Coffee

  case class Tea(water: Water, milk: Milk)

  case class CoffeeMachine(milk: Milk,
                      coffee: List[Coffee],
                      tea: Tea) {
    println(s"Hello! Your Coffee Machine $this is ready.")
  }

  val water = new Water
  val coffeeBeans = new CoffeeBeans
  val milk = new Milk
  val espresso = new Espresso(water, coffeeBeans)
  val cappuccino = new Cappuccino(water, milk, coffeeBeans)
  val latte = new Latte(water, coffeeBeans, milk)
  val coffee = List(espresso, cappuccino, latte)
  val tea = new Tea(water, milk)

  val coffeeMachine = new CoffeeMachine(milk, coffee, tea)
}
