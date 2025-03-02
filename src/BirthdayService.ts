import { Customers } from './Customers.js'
import { ProductionEmailSender } from './ProductionEmailSender.js'
import { ProductionLogger } from './ProductionLogger.js'
import { DiscountCodeGenerator } from './DiscountCodeGenerator.js'

export class BirthdayService {
  private readonly customerRepository: Customers
  private readonly emailSender: ProductionEmailSender
  private readonly logger: ProductionLogger

  constructor(
    customerRepository: Customers,
    emailSender: ProductionEmailSender,
    logger: ProductionLogger,
  ) {
    this.customerRepository = customerRepository
    this.emailSender = emailSender
    this.logger = logger
  }

  greetCustomersWithBirthday(today: Date) {
    const customers = this.customerRepository.findWithBirthday(today)
    customers.forEach((customer) => {
      const discountCode = new DiscountCodeGenerator().generate()
      const template =
        'Happy birthday, {name}! Here is your discount code: {discount}'.replace(
          '{discount}',
          discountCode.getCode(),
        )
      customer.sendEmail(template, this.emailSender)
      this.logger.log('INFO', customer.fillWithEmail('Email sent to {email}'))
    })
  }
}
