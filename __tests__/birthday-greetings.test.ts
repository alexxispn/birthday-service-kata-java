import { describe, it } from 'vitest'
import {BirthdayService} from "../src/BirthdayService";
import {ProductionEmailSender} from "../src/kata.email/ProductionEmailSender";
import {ProductionLogger} from "../src/kata.logger/ProductionLogger";
import {Customer} from "../src/kata.customers/Customer";
import { ProductionCustomersRepository } from '../src/kata.customers/ProductionCustomersRepository';


/*
 * README
 * Exercise:
 * We have a BirthdayService that runs every day via a cron job
 *
 *  It greets kata.customers with has birthday on that day.
 *  It generates a discount code for them.
 *  It sends an kata.email to them with the discount code.
 *  It logs the kata.email sent.
 *
 * You work is to write the required tests for this functionality.
 * You probably will need to modify the code to make it testable.
 * Use different test doubles for the dependencies.
 *
 * Start by running the test below and fixing the errors.
 * Add assertions to the test that matches the intent of the test.
 *
 *
 * Maybe you need to apply some refactorings to make the code testable in line with the Small Safe Steps workshop.
 *
 * Enrich the exercise by adding more tests:
 *
 * * Ensure that no kata.email is sent to customer not having birthday today
 * * Make a test to ensure that the service fails gracefully if the kata.email sending fails
 * * Make a test to ensure that the service fails gracefully if the repository fails
 *
 * */

describe('Birthday greetings', () => {
  it('should not send greeting emails if no customer has birthday today', () => {
    const service = new BirthdayService(
      new ProductionCustomersRepository([]),
      new ProductionEmailSender(),
      new ProductionLogger(),
    )
    service.greetCustomersWithBirthday(new Date())
  })

  it('should send greeting emails to all kata.customers with birthday today', () => {
    const service = new BirthdayService(
      new ProductionCustomersRepository([
        new Customer('John Doe', 'john@example.com', new Date('1990-02-14')),
        new Customer('Jane Doe', 'jane@example.com', new Date('2005-02-14')),
      ]),
      new ProductionEmailSender(),
      new ProductionLogger(),
    )

    service.greetCustomersWithBirthday(new Date())
  })

  it.todo('does not throw if kata.email sender fails', () => {})
  it.todo('does not throw if repository fails', () => {})
})
