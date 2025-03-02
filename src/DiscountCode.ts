export class DiscountCode {
  private readonly code: string

  constructor(code: string) {
    this.code = code
  }

  getCode(): string {
    return this.code
  }
}
