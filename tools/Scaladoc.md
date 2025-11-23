# Scaladoc
* https://docs.scala-lang.org/overviews/scaladoc/overview.html
* https://docs.scala-lang.org/scala3/guides/scaladoc/

topics:
- **Using the Scaladoc interface**: how to navigate and use generated Scaladoc documentation to learn more about a library.
- **Scaladoc for Library Authors**: how to add Scaladoc comments to generate documentation for your library.
- **Generating documentation for your library with Scaladoc**: how to use Scaladoc to generate documentation for your library.

# Using the Scaladoc interface

- title bar: a breadcrumb list of parent packages, links to the package object documentaion
- Source
- See also
- Linear Supertypes
- Known Subclasses
- Type Hierarchy
- Filter all members: methods, values

# Scaladoc for Library Authors

Scaladoc is **a documentation system** that lives in the comments of Scala source code and is related to the code structure within which it is written. It is based on other comment based documentation systems like Javadoc, but with some extensions such as:
- Markup may be used in the comments.
- Extended `@` tags (e.g. `@tparam`, `@see`, `@note`, `@example`, `@usecase`, `@since`, etc.)
- Macro definitions (defined values to be substituted in scaladoc).
- Automatic inheritance of comments from a super-class/trait (may be used effectively in combination with macro definitions).

Scaladoc comments go before the items they pertain to in a special comment block that starts with a `/**` and ends with a `*/`.

Scaladoc comments can go before *fields*, *methods*, *classes*, *traits*, *objects* and even (especially) *package objects*. Scaladoc comments for package objects make a great place to put an overview of a specific package or API.

For class primary constructors which in Scala coincide with the definition of the class itself, a `@constructor` tag is used to target a comment to be put on the primary constructor documentation rather than the class overview.

## Tags

example: `scala.concurrent.Future`.

1. Class specific tags
- `@constructor`: placed in the class comment will describe the primary constructor.

2. Method specific tags
- `@return`: detail the return value from a method (one per method).

3. Method, Constructor and/or Class tags
- `@throws`: what exceptions (if any) the method or constructor may throw.
- `@param`: detail a value parameter for a method or constructor, provide one per parameter to the method/constructor.
- `@tparam`: detail a type parameter for a method, constructor or class. Provide one per type parameter.

4. Usage tags
- `@see`: reference other sources of information like external document links or related entities in the documentation.
- `@note`: add a note for pre- or post-conditions, or any other notable restrictions or expectations.
- `@example`: for providing example code or related example documentation.
- `@usecase`: provide a simplified method definition for when the full method definition is too complex or noisy. An example is (in the collections API), providing documentation for methods that omit the implicit `canBuildFrom`.

5. Member grouping tags

```scala
// not enabled by default
scalacOptions in (Compile, doc) ++= Seq(
  "-groups"
)
```
- `@group <group>`: mark the entity as a member of the <group> group.
- `@groupname <group> <name>`: provide an optional name for the group. <name> is displayed as the group header before the group description.
- `@groupdesc <group> <description>`: add optional descriptive text to display under the group name. Supports multiline formatted text.
- `@groupprio <group> <priority>`: control the order of the group on the page. Defaults to 0. Ungrouped elements have an implicit priority of 1000. Use a value between 0 and 999 to set a relative position to other groups. Low values will appear before high values.

Typically, you should put `@groupprio` (and optionally `@groupname` and `@groupdesc`) in the Scaladoc for the package/trait/class/object itself, describing what all the groups are, and their order. Then put `@group` in the Scaladoc for each member, saying which group it is in.

Members that do not have a `@group` tag will be listed as “Ungrouped” in the resulting documentation.

6. Diagram tags
- `@contentDiagram`: use with traits and classes to include a content hierarchy diagram showing included types. The diagram content can be fine-tuned with additional specifiers taken from `hideNodes`, `hideOutgoingImplicits`, `hideSubclasses`, `hideEdges`, `hideIncomingImplicits`, `hideSuperclasses` and `hideInheritedNode`. `hideDiagram` can be supplied to prevent a diagram from being created if it would be created by default. **Packages and objects have content diagrams by default**.
- `@inheritanceDiagram`: ???

7. Other tags
- `@author`: provide author information for the following entity
- `@version`: the version of the system or API that this entity is a part of.
- `@since`: like @version but defines the system or API that this entity was first defined in.
- `@todo`: for documenting unimplemented features or unimplemented aspects of an entity.
- `@deprecated`: marks the entity as deprecated, providing both the replacement implementation that should be used and the version/date at which this entity was deprecated.
- `@inheritdoc`: take comments from a superclass as defaults if comments are not provided locally.
- `@documentable`: Expand a type alias and abstract type into a full template page. 
  - TODO: Test the “abstract type”` claim 
  - no examples of this in the Scala code base

7. Macros
- `@define <name> <definition>`: allows use of `$name` in other Scaladoc comments within the same source file which will be expanded to the contents of `<definition>`.

8. 2.12 tags 
- TODO: Move these into the above groups with a 2.12 note
- `@shortDescription`: ???
- `@hideImplicitConversion`: ???

## Comment Inheritance

implicit
- If a comment is not provided for an entity at the current inheritance level, but is supplied for the overridden entity at a higher level in the inheritance hierarchy, **the comment from the super-class will be used**.
- Likewise, if `@param`, `@tparam`, `@return` and other entity tags are omitted but available from a superclass, those comments will be used.

explicit
- For explicit comment inheritance, use the `@inheritdoc` tag.

## Markup

It is still possible to embed HTML tags in Scaladoc (like with Javadoc), but not necessary most of the time as **markup** may be used instead.

```scala
`monospace`
''italic text''
'''bold text'''
__underline__
^superscript^
,,subscript,,
[[entity link]], e.g. [[scala.collection.Seq]]
[[https://external.link External Link]],
  e.g. [[https://scala-lang.org Scala Language Site]]
```

1. Paragraphs are started with one (or more) blank lines. `*` in the margin for the comment is valid (and should be included) but the line should be blank otherwise.
2. Code blocks are contained within `{{{` this `}}}` and may be multi-line. Indentation is relative to the starting `*` for the comment.
3. Headings are defined with surrounding `=` characters, with more `=` denoting subheadings. E.g. `=Heading=`, `==Sub-Heading==`, etc.
4. Tables are defined using `|` to separate elements in a row, as described in the [blog](https://scala-lang.org/blog/2018/10/04/scaladoc-tables.html).
```scala
/**
  * | Title | ISBN | Authors |
  * | :---:  | ---  | --- |
  * | '''Structured Programming''' | `0-12-200550-3` | ''Dahl, Dijkstra and Hoare'' |
  * | '''Purely functional data structures'''^1^ | `0-521-66350-4` | ''Okasaki'' |
  *
  * | Note | Comment |
  * | ---: | --- |
  * | 1 | [[https://cambridge.org Cambridge University Press]], 1998|
*/
trait Bibliography
```
5. List blocks are a sequence of list items with the same style and level, with no interruptions from other block styles. 
- Unordered lists can be bulleted using `-`; 
- numbered lists can be denoted using `1.`, `i.`, `I.`, or `a.` for the various numbering styles. 
- In both cases, you must have extra space in front, and more space makes a sub-level.

### Links

General rules:
- You **must not use a space in the description of the signature**: this will cause Scaladoc to think the link has ended and move onto its description.
- You **must fully qualify any types you are using**: assume that you have written your program without any import statements!

To **disambiguate between objects and types**, append `$` to designate a *term* name and `!` for a type name. **Term** names include members which are not types, such as `val`, `def`, and `object` definitions. For example:
- `[[scala.collection.immutable.List!.apply class List's apply method]]`
- `[[scala.collection.immutable.List$.apply object List's apply method]]`

To deal with **ambiguous overloads**
- You must finish the signature, complete or otherwise, with a `*`, which serves as a wildcard that allows you to cut off the signature when it is umambiguous.
- You must specify the names of the arguments and they must be exactly as written in the function definition:
```scala
[[bar.foo(Int)*]]           // is illegal (no name)
[[bar.foo(y:Int)*]]         // is illegal (wrong name)
[[bar.foo(x: Int)*]]        // is illegal (space! Scaladoc sees this as bar.foo(x:)
[[bar.foo(x:Int):Boolean]]  // is illegal (no *)
[[bar.foo(x:Int)*]]         // is legal and unambiguous
[[bar.foo(x:Int*]]          // is legal, the Int is enough to disambiguate so no closing paren needed
```
- The enclosing scope (package/class/object etc) of the method must use `.`, but within the arguments and return type `\.` must be used instead to fully qualify types:
```scala
[[bar.foo(x:ListBuffer[Int],y:String)*]]                              // is illegal (no qualification on ListBuffer)
[[bar.foo(x:scala.collection.mutable.ListBuffer[Int],y:String)*]]     // is illegal (non-escaped dots!)
[[bar\.foo(x:scala\.collection\.mutable\.ListBuffer[Int],y:String)*]] // is illegal (must not escape dots in the prefix)
[[bar.foo(x:scala\.collection\.mutable\.ListBuffer[Int],y:String)*]]  // is legal
[[bar.foo(x:scala\.collection\.mutable\.ListBuffer[Int]*]]            // is legal, the first argument is enough to disambiguate.
```
- When generics are involved, additional square brackets may be used to avoid the signature accidentally closing the link. Essentially, the number of leading left brackets determines the number of right brackets required to complete the link:
```scala
[[baz(x:List[List[A]])*]]   // is illegal (it is read as baz(x:List[List[A)
[[[baz(x:List[List[A]])*]]] // is legal (the ]] is no longer a terminator, ]]] is)
```

# Generating documentation for your library with Scaladoc

- sbt
```shell
> doc
```
- `scaladoc` command
```shell
$ scaladoc src/main/scala/App.scala
$ scaladoc -d build/ src/main/scala/App.scala

$ scaladoc --help
```

# Scala3 Scaladoc
scaladoc is a tool to generate the API documentation of your Scala 3 projects. It provides similar features to `javadoc` as well as `jekyll` or `docusaurus`.

topics:
- Docstrings - specific Tags and Features
- Linking documentation
- Static documentation
- Built-in blog
- Site versioning
- Type-based search
- Snippet checking
- Settings

TODO

# See Also
* [Scala Style Guide - Scaladoc](../language/scala-style-guide.md#scaladoc)