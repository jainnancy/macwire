package com.knoldus.knolx

// Manual DI

object ManualDependency extends App {

  class Water

  class CoffeeBeans

  class Milk

  class TeaLeaves

  trait Coffee

  class Espresso(coffeeBeans: CoffeeBeans, water: Water) extends Coffee

  class Cappuccino(water: Water, milk: Milk, coffeeBeans: CoffeeBeans) extends Coffee

  class Latte(water: Water, coffeeBeans: CoffeeBeans, milk: Milk) extends Coffee

  class Tea(water: Water, milk: Milk, teaLeaves: TeaLeaves)

  class CoffeeMachine(milk: Milk,
                      coffees: List[Coffee],
                      tea: Tea) {
    println(s"Hello! Your Coffee Machine $this is ready.")
  }

  val water = new Water
  val coffeeBeans = new CoffeeBeans
  val milk = new Milk
  val teaLeaves = new TeaLeaves
  val espresso = new Espresso(coffeeBeans, water)
  val cappuccino = new Cappuccino(water, milk, coffeeBeans)
  val latte = new Latte(water, coffeeBeans, milk)
  val coffees = List(espresso, cappuccino, latte)
  val tea = new Tea(water, milk, teaLeaves)

  val coffeeMachine = new CoffeeMachine(milk, coffees, tea)
}
