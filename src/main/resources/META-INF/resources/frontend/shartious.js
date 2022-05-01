import {LitElement, html, css} from 'lit-element';

function getRandomInt(max) {
  return Math.floor(Math.random() * max)
}

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

//    constructor(){
//        setTimeout()
//    }

  _onClick() {
    var awd = this.text.split('')
    var index = getRandomInt(awd.length)
    if(getRandomInt(2) == 1){
        //javscript why you do this...
        awd[index] = String.fromCharCode(awd[index].charCodeAt(0) + 1)
    }
    else{
        awd[index] = String.fromCharCode(awd[index].charCodeAt(0) - 1)
    }

    var val = awd[index]
    if(val > 124) val = 124
    else if(val < 21) val = 21

//    return awd.join('')
    this.text = awd.join('')

  }
}

window.customElements.define('random-text', MyElement);
