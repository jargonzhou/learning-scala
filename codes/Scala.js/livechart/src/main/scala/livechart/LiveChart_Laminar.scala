// package livechart

// import scala.scalajs.js
// import scala.scalajs.js.annotation.{JSImport, JSExportTopLevel, JSExport}
// import org.scalajs.dom // the DOM Library

// import com.raquo.laminar.api.L.{_, given} // Laminar

// // import javascriptLogo from "/javascript.svg"
// @js.native @JSImport("/javascript.svg", JSImport.Default)
// val javascriptLogo: String = js.native

// object App:
//   // set up model
//   val model = new Model
//   import model._

//   @main
//   def main(): Unit =
//     renderOnDomContentLoaded(dom.document.getElementById("app"), appElement())
//   end main

//   def appElement(): Element =
//     // div(
//     //   a(
//     //     href := "https://vitejs.dev",
//     //     target := "_blank",
//     //     img(src := "/vite.svg", className := "logo", alt := "Vite logo")
//     //   ),
//     //   a(
//     //     href := "https://developer.mozilla.org/en-US/docs/Web/JavaScript",
//     //     target := "_blank",
//     //     img(
//     //       src := javascriptLogo,
//     //       className := "logo vanilla",
//     //       alt := "JavaScript logo"
//     //     )
//     //   ),
//     //   h1("Hello Laminar!"),
//     //   div(className := "card", counterButton()),
//     //   p(className := "read-the-docs", "Click on the Vite logo to learn more"),
//     // )
//     div(
//       idAttr := "livechart",
//       h1("Live Chart"),
//       renderDataTable(),
//       renderDataList()
//     )
//   end appElement

//   def renderDataTable(): Element =
//     table(
//       thead(
//         tr(
//           th("Label"),
//           th("Price"),
//           th("Count"),
//           th("Full price"),
//           th("Action")
//         )
//       ),
//       tbody(
//         children <-- dataSignal.split(_.id) { (id, initial, itemSignal) =>
//           renderDataItem(id, itemSignal)
//         }
//       ),
//       tfoot(
//         tr(
//           td(button("➕", onClick --> (_ => addDataItem(DataItem())))),
//           td(),
//           td(),
//           td(
//             child.text <-- dataSignal.map(data =>
//               "%.2f".format(data.map(_.fullPrice).sum)
//             )
//           )
//         )
//       )
//     )
//   end renderDataTable

//   def renderDataItem(id: DataItemID, itemSignal: Signal[DataItem]): Element =
//     tr(
//       td(
//         inputForString(
//           itemSignal.map(_.label),
//           makeDataItemUpdater(
//             id,
//             { (item, newLabel) =>
//               item.copy(label = newLabel)
//             }
//           )
//         )
//       ),
//       td(
//         inputForDouble(
//           itemSignal.map(_.price),
//           makeDataItemUpdater(
//             id,
//             { (item, newPrice) =>
//               item.copy(price = newPrice)
//             }
//           )
//         )
//       ),
//       td(
//         inputForInt(
//           itemSignal.map(_.count),
//           makeDataItemUpdater(
//             id,
//             { (item, newCount) =>
//               item.copy(count = newCount)
//             }
//           )
//         )
//       ),
//       td(
//         child.text <-- itemSignal.map(item => "%.2f".format(item.fullPrice))
//       ),
//       td(button("🗑️", onClick --> (_ => removeDataItem(id))))
//     )
//   end renderDataItem

//   // updater
//   def makeDataItemUpdater[A](
//       id: DataItemID,
//       f: (DataItem, A) => DataItem
//   ): Observer[A] =
//     dataVar.updater { (data, newValue) =>
//       data.map { item =>
//         if item.id == id then f(item, newValue) else item
//       }
//     }
//   end makeDataItemUpdater

//   //
//   // input
//   //

//   def inputForString(
//       valueSignal: Signal[String],
//       valueUpdater: Observer[String]
//   ): Input =
//     input(
//       typ := "text",
//       value <-- valueSignal,
//       onInput.mapToValue --> valueUpdater
//     )
//   end inputForString

//   def inputForDouble(
//       valueSignal: Signal[Double],
//       valueUpdater: Observer[Double]
//   ): Input =
//     val strValue = Var[String]("")
//     input(
//       typ := "text",
//       value <-- strValue.signal,
//       onInput.mapToValue --> strValue,
//       valueSignal --> strValue.updater[Double] { (prevStr, newValue) =>
//         if prevStr.toDoubleOption.contains(newValue) then prevStr
//         else newValue.toString
//       },
//       strValue.signal --> { valueStr =>
//         valueStr.toDoubleOption.foreach(valueUpdater.onNext)
//       }
//     )
//   end inputForDouble

//   def inputForInt(
//       valueSignal: Signal[Int],
//       valueUpdater: Observer[Int]
//   ): Input =
//     input(
//       typ := "text",
//       controlled(
//         value <-- valueSignal.map(_.toString),
//         onInput.mapToValue.map(_.toIntOption).collect { case Some(newCount) =>
//           newCount
//         } --> valueUpdater
//       )
//     )
//   end inputForInt

//   def renderDataList(): Element =
//     ul(
//       children <-- dataSignal.split(_.id) { (id, initial, itemSignal) =>
//         li(
//           child.text <-- itemSignal.map(item => s"${item.count} ${item.label}")
//         )
//       }
//     )
//   end renderDataList

//   def counterButton(): Element =
//     val counter = Var(0)

//     button(
//       tpe := "button",
//       "count is ",
//       child.text <-- counter, // binding value of `counter` to button's text child
//       onClick --> { event =>
//         counter.update(c => c + 1) // schedule an update of value of `counter`
//       }
//     )
//   end counterButton
// end App

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
