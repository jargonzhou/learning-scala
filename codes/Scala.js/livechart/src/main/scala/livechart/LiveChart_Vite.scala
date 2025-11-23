// package livechart

// import scala.scalajs.js
// import scala.scalajs.js.annotation.{JSImport, JSExportTopLevel, JSExport}
// import org.scalajs.dom // the DOM Library

// // import javascriptLogo from "/javascript.svg"
// @js.native @JSImport("/javascript.svg", JSImport.Default)
// val javascriptLogo: String = js.native

// @main
// def Main(): Unit =
//   dom.document.querySelector("#app").innerHTML = s"""
//   <div>
//     <a href="https://vitejs.dev" target="_blank">
//       <img src="/vite.svg" class="logo" alt="Vite logo" />
//     </a>
//     <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript" target="_blank">
//       <img src="${javascriptLogo}" class="logo vanilla" alt="JavaScript logo" />
//     </a>
//     <h1>Hello Scala.js and Vite!</h1>
//     <div class="card">
//       <button id="counter" type="button"></button>
//     </div>
//     <p class="read-the-docs">
//       Click on the Vite logo to learn more
//     </p>
//   </div>
//   """
//   setupCounter(dom.document.getElementById("counter"))
// end Main

// def setupCounter(element: dom.Element): Unit =
//   var counter = 0

//   def setCounter(count: Int): Unit =
//     counter = count
//     element.innerHTML = s"count is $counter"

//   element.addEventListener("click", e => setCounter(counter + 1))
//   setCounter(0)
// end setupCounter

// object LiveChart:
//   // append <p> to DOM node
//   def appendPar(targetNode: dom.Node, text: String): Unit =
//     val parNode = dom.document.createElement("p")
//     parNode.textContent = text
//     targetNode.appendChild(parNode)
//   end appendPar

//   // Export Scala.js API to JavaScript
//   // https://www.scala-js.org/doc/interoperability/export-to-javascript.html
//   @JSExportTopLevel("addClickedMessage")
//   def addClickedMessage(): Unit =
//     appendPar(dom.document.body, "You clicked the button!")
//   end addClickedMessage
// end LiveChart
