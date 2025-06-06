# Birthday Service Kata

This is an exercise to practice how to introduce and use test doubles. It's written in Typescript.

## Exercise

We have a BirthdayService that runs every day via a cron job

* It greets customers with has birthday on that day.
* It generates a discount code for them.
* It sends an email to them with the discount code.
* It logs the email sent.

Your work is to write the required tests for this functionality. You probably will need to modify the code to make it testable and use different test doubles for the dependencies.

Start by running the test and fixing the errors.

Add assertions to the test that matches the intent of the test.

## Enrich the exercise by adding more tests:

* Ensure that the email sent is correct and it is sent to the correct customer
* Make a test to ensure that the service fails gracefully if the email sending fails
* Make a test to ensure that the service fails gracefully if the repository fails

## How to start

Install dependencies:

```bash
npm install
```

Run the tests. The test framework is [vitest](https://vitest.dev/). Running this script, `vitest` will run and watch for changes.

```bash
npm run test
```

## References

* [La guía definitiva de los dobles de test](https://franiglesias.github.io/test-doubles-guide-1/)

