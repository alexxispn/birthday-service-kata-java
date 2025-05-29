export interface EmailSender {
  send(email: string, message: string): void
}
