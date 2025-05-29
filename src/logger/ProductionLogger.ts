export class ProductionLogger {
  log(level: string, message: string) {
    throw new Error(
      '️😱 You are using ProductionLogger in a test. It will increase our bills by zillions $$.',
    )
  }
}
