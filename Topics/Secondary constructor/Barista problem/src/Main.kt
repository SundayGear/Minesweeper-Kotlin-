class EspressoMachine {
    var costPerServing: Float = 0F
    //val coffeeCapsulesCount: Int = 0
    //val coffeeBeansWeight: Float = 0F
    //val totalCost: Float = 0F

    constructor(coffeeCapsulesCount: Int, totalCost: Float){
    this.costPerServing = totalCost.toFloat() / coffeeCapsulesCount
    }
    constructor(coffeeBeansWeight: Float, totalCost: Float){
    this.costPerServing = totalCost / (coffeeBeansWeight / 10)
    }
}