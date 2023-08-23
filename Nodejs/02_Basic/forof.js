// var nodes = document.querySelector('ul')
// for (var k = 0; k < nodes.children.length; k++) {
//   var ch = nodes.children[k]
//   ch.onclick = (event) => {
//     event.target.style.backgroundColor = "orange"
//   }
// }

let nodes = document.querySelectorAll('li')
for (var node of nodes) {
  node.onclick = (event) => {
    event.target.style.backgroundColor = "orange"
  }
}