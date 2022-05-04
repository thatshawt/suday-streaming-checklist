import {LitElement, html, css} from 'lit-element';

export class MyElement extends LitElement {

  static get properties() {
    return {
      startText: {type: String},
      text: {type: String}
    };
  }

  render() {
    return html`
      <h1 @click=${this._onClick}>${this.text}</h1>
    `;
  }

}

window.customElements.define('random-text', MyElement);
