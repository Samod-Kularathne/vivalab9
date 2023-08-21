class ACC(initialBalance: Double) {
  private var balance: Double = initialBalance

  def getBalance: Double = balance

  def deposit(amount: Double): Unit = {
    require(amount > 0, "Deposit amount must be positive")
    balance += amount
  }

  def withdraw(amount: Double): Unit = {
    require(amount > 0, "Withdrawal amount must be positive")
    require(amount <= balance, "Insufficient balance")
    balance -= amount
  }

  def transfer(amount: Double, targetACC: ACC): Unit = {
    withdraw(amount)
    targetACC.deposit(amount)
  }

  def applyInterest(): Unit = {
    if (balance > 0) {
      balance += balance * 0.05
    } else {
      balance += balance * 0.1
    }
  }
}

object BankDemo {
  def main(args: Array[String]): Unit = {
    val ACCs = List(
      new ACC(1000.0),
      new ACC(-500.0),
      new ACC(200.0),
      new ACC(-300.0)
    )

    // 4.1 List of ACCs with negative balances
    val negativeBalanceACCs = ACCs.filter(_.getBalance < 0)
    println("ACCs with negative balances: " + negativeBalanceACCs)

    // 4.2 Calculate the sum of all ACC balances
    val totalBalance = ACCs.map(_.getBalance).sum
    println("Total balance of all ACCs: " + totalBalance)

    // 4.3 Calculate final balances after applying interest
    ACCs.foreach(_.applyInterest())
    println("Final balances after applying interest:")
    ACCs.foreach(ACC => println(s"ACC balance: ${ACC.getBalance}"))
  }
}
