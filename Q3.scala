class Account(initialBalance: Double) {
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

  def transfer(amount: Double, targetAccount: Account): Unit = {
    withdraw(amount)
    targetAccount.deposit(amount)
  }
}

object AccountDemo {
  def main(args: Array[String]): Unit = {
    val account1 = new Account(1000.0)
    val account2 = new Account(500.0)

    println("Account 1 Balance: " + account1.getBalance)
    println("Account 2 Balance: " + account2.getBalance)

    account1.deposit(200.0)
    account2.withdraw(100.0)

    println("Account 1 Balance after deposit: " + account1.getBalance)
    println("Account 2 Balance after withdrawal: " + account2.getBalance)

    account1.transfer(300.0, account2)

    println("Account 1 Balance after transfer: " + account1.getBalance)
    println("Account 2 Balance after transfer: " + account2.getBalance)
  }
}
