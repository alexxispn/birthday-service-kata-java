import { EmailSender } from './EmailSender.js'

export class Customer {
  private readonly name: string
  private readonly email: string
  private readonly birthday: Date

  constructor(name: string, email: string, birthday: Date) {
    this.name = name
    this.email = email
    this.birthday = birthday
  }

  hasBirthday(aDate: Date): boolean {
    return this.birthday == aDate
  }

  sendEmail(template: string, sender: EmailSender) {
    const message = template.replace('{name}', this.name)
    sender.send(this.email, message)
  }

  fillWithEmail(template: string) {
    return template.replace('{email}', this.email)
  }
}
