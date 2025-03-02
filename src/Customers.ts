import { Customer } from './Customer.js'

export class Customers {
  private readonly customers: Customer[]

  constructor(customers: Customer[]) {
    this.customers = customers
  }

  findWithBirthday(today: Date): Customer[] {
    throw new Error(
      '🤦🏽‍♀️ You are using ProductionCustomerRepository in a test. It will mess up our data.',
    )
  }
}
