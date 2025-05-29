export class ProductionEmailSender  {
  send(email: string, message: string) {
    throw new Error(
      '🤬 You are using ProductionEmailSender in a test. It will cost lots of money $$.',
    )
  }
}
