import { html, LitElement } from 'lit'
import { customElement } from 'lit/decorators.js'

/**
 * A link element.
 *
 * @slot - This element has a slot
 */
@customElement('my-link')
export class MyLink extends LitElement {
  render() {
    return html`
      <a>
        <slot></slot>
      </a>
    `
  }
}

declare global {
  interface HTMLElementTagNameMap {
    'my-link': MyLink
  }
}