import { html, css, LitElement } from 'lit'
import { customElement } from 'lit/decorators.js'

/**
 * A button element.
 *
 * @slot - This element has a slot
 */
@customElement('my-button')
export class MyButton extends LitElement {
  static styles = css`
    :host {
      display: block;
      border: solid 1px red;
      border-radius: 4px;
      background: yellow;
      padding: 16px;
      max-width: 800px;
    }
  `

  render() {
    return html`
      <button>
        <slot></slot>
      </button>
    `
  }
}

declare global {
  interface HTMLElementTagNameMap {
    'my-button': MyButton
  }
}