# Scala Language Specification, Version 2.13
* https://scala-lang.org/files/archive/spec/2.13/
* https://github.com/scala/scala/tree/2.13.x/spec

# 1 Lexical Syntax

## 1.1 Identifiers
## 1.2 Newline Characters
## 1.3 Literals
### 1.3.1 Integer Literals
### 1.3.2 Floating Point Literals
### 1.3.3 Boolean Literals
### 1.3.4 Character Literals
### 1.3.5 String Literals
### 1.3.6 Escape Sequences
### 1.3.7 Symbol literals
## 1.4 Whitespace and Comments
## 1.5 Trailing Commas in Multi-line Expressions
## 1.6 XML mode
# 2 Identifiers, Names & Scopes

# 3 Types

## 3.1 Paths
## 3.2 Value Types
### 3.2.1 Singleton Types
### 3.2.2 Literal Types
### 3.2.3 Stable Types
### 3.2.4 Type Projection
### 3.2.5 Type Designators
### 3.2.6 Parameterized Types
### 3.2.7 Tuple Types
### 3.2.8 Annotated Types
### 3.2.9 Compound Types
### 3.2.10 Infix Types
### 3.2.11 Function Types
### 3.2.12 Existential Types
## 3.3 Non-Value Types
### 3.3.1 Method Types
### 3.3.2 Polymorphic Method Types
### 3.3.3 Type Constructors
## 3.4 Base Types and Member Definitions
## 3.5 Relations between types
### 3.5.1 Equivalence
### 3.5.2 Conformance
### 3.5.3 Weak Conformance
### 3.5.4 Compatibility
## 3.6 Volatile Types
## 3.7 Type Erasure
# 4 Basic Declarations & Definitions

## 4.1 Value Declarations and Definitions
## 4.2 Variable Declarations and Definitions
## 4.3 Type Declarations and Type Aliases
## 4.4 Type Parameters
## 4.5 Variance Annotations
## 4.6 Function Declarations and Definitions
### 4.6.1 Default Arguments
### 4.6.2 By-Name Parameters
### 4.6.3 Repeated Parameters
### 4.6.4 Procedures
### 4.6.5 Method Return Type Inference
## 4.7 Import Clauses
# 5 Classes & Objects

## 5.1 Templates
### 5.1.1 Constructor Invocations
### 5.1.2 Class Linearization
### 5.1.3 Class Members
### 5.1.4 Overriding
### 5.1.5 Inheritance Closure
### 5.1.6 Early Definitions
## 5.2 Modifiers
### 5.2.1 private
### 5.2.2 protected
### 5.2.3 override
### 5.2.4 abstract override
### 5.2.5 abstract
### 5.2.6 final
### 5.2.7 sealed
### 5.2.8 lazy
## 5.3 Class Definitions
### 5.3.1 Constructor Definitions
### 5.3.2 Case Classes
## 5.4 Traits
## 5.5 Object Definitions
# 6 Expressions

## 6.1 Expression Typing
## 6.2 Literals
## 6.3 The Null Value
## 6.4 Designators
## 6.5 This and Super
## 6.6 Function Applications
### 6.6.1 Named and Default Arguments
### 6.6.2 Signature Polymorphic Methods
## 6.7 Method Values
## 6.8 Type Applications
## 6.9 Tuples
## 6.10 Instance Creation Expressions
## 6.11 Blocks
## 6.12 Prefix, Infix, and Postfix Operations
### 6.12.1 Prefix Operations
### 6.12.2 Postfix Operations
### 6.12.3 Infix Operations
### 6.12.4 Assignment Operators
## 6.13 Typed Expressions
## 6.14 Annotated Expressions
## 6.15 Assignments
## 6.16 Conditional Expressions
## 6.17 While Loop Expressions
## 6.18 Do Loop Expressions
## 6.19 For Comprehensions and For Loops
## 6.20 Return Expressions
## 6.21 Throw Expressions
## 6.22 Try Expressions
## 6.23 Anonymous Functions
### 6.23.1 Translation
### 6.23.2 Placeholder Syntax for Anonymous Functions
## 6.24 Constant Expressions
## 6.25 Statements
## 6.26 Implicit Conversions
### 6.26.1 Value Conversions
### 6.26.2 Method Conversions
### 6.26.3 Overloading Resolution
### 6.26.4 Local Type Inference
### 6.26.5 Eta Expansion
### 6.26.6 Dynamic Member Selection
# 7 Implicits

## 7.1 The Implicit Modifier
## 7.2 Implicit Parameters
## 7.3 Views
## 7.4 Context Bounds and View Bounds
## 7.5 Manifests
# 8 Pattern Matching

## 8.1 Patterns
### 8.1.1 Variable Patterns
### 8.1.2 Typed Patterns
### 8.1.3 Pattern Binders
### 8.1.4 Literal Patterns
### 8.1.5 Interpolated string patterns
### 8.1.6 Stable Identifier Patterns
### 8.1.7 Constructor Patterns
### 8.1.8 Tuple Patterns
### 8.1.9 Extractor Patterns
### 8.1.10 Pattern Sequences
### 8.1.11 Infix Operation Patterns
### 8.1.12 Pattern Alternatives
### 8.1.13 XML Patterns
### 8.1.14 Regular Expression Patterns
### 8.1.15 Irrefutable Patterns
## 8.2 Type Patterns
## 8.3 Type Parameter Inference in Patterns
### 8.3.1 Type parameter inference for typed patterns
### 8.3.2 Type parameter inference for constructor patterns
## 8.4 Pattern Matching Expressions
## 8.5 Pattern Matching Anonymous Functions
# 9 Top-Level Definitions
## 9.1 Compilation Units
## 9.2 Packagings
## 9.3 Package Objects
## 9.4 Package References
## 9.5 Programs
# 10 XML
## 10.1 XML expressions
## 10.2 XML patterns
# 11 Annotations
## 11.1 Definition
## 11.2 Predefined Annotations
### 11.2.1 Java Platform Annotations
### 11.2.2 Java Beans Annotations
### 11.2.3 Deprecation Annotations
### 11.2.4 Scala Compiler Annotations
## 11.3 User-defined Annotations
## 11.4 Host-platform Annotations
# 12 Standard Library
## 12.1 Root Classes
## 12.2 Value Classes
### 12.2.1 Numeric Value Types
### 12.2.2 Class Boolean
### 12.2.3 Class Unit
## 12.3 Standard Reference Classes
### 12.3.1 Class String
### 12.3.2 The Tuple classes
### 12.3.3 The Function Classes
### 12.3.4 Class Array
## 12.4 Class Node
## 12.5 The Predef Object
### 12.5.1 Predefined Implicit Definitions
# 13 Syntax Summary
## 13.1 Lexical Syntax
## 13.2 Context-free Syntax

# 14 References
> TODO: provide a nice reading list to get up to speed with theory,...

- Scala's Foundations

```
[@scala-overview-tech-report;
@odersky:scala-experiment;
@odersky:sca;
@odersky-et-al:ecoop03;
@odersky-zenger:fool12]
```

- Learning Scala
- Related Work

```
%% Article
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
@article{milner:polymorphism,
  author	= {Robin Milner},
  title		= {A {T}heory of {T}ype {P}olymorphism in {P}rogramming},
  journal	= {Journal of Computer and System Sciences},
  year		= {1978},
  month		= {Dec},
  volume	= {17},
  pages		= {348-375},
  folder	= { 2-1}
}
@Article{wirth:ebnf,
  author	= "Niklaus Wirth",
  title		= "What can we do about the unnecessary diversity of notation
for syntactic definitions?",
  journal	= "Comm. ACM",
  year		= 1977,
  volume	= 20,
  pages		= "822-823",
  month		= nov
}
%% Book
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
@Book{abelson-sussman:structure,
  author	= {Harold Abelson and Gerald Jay Sussman and Julie Sussman},
  title		= {The Structure and Interpretation of Computer Programs, 2nd
                  edition},
  publisher	= {MIT Press},
  address	= {Cambridge, Massachusetts},
  year		= {1996},
  url		= {http://mitpress.mit.edu/sicp/full-text/sicp/book/book.html}
}
@Book{goldberg-robson:smalltalk-language,
  author	= "Adele Goldberg and David Robson",
  title		= "{Smalltalk-80}; The {L}anguage and Its {I}mplementation",
  publisher	= "Addison-Wesley",
  year		= "1983",
  note		= "ISBN 0-201-11371-6"
}
@Book{matsumtoto:ruby,
  author	= {Yukihiro Matsumoto},
  title		= {Ruby in a {N}utshell},
  publisher	= {O'Reilly \& Associates},
  year		= "2001",
  month		= "nov",
  note		= "ISBN 0-596-00214-9"
}
@Book{rossum:python,
  author	= {Guido van Rossum and Fred L. Drake},
  title		= {The {P}ython {L}anguage {R}eference {M}anual},
  publisher	= {Network Theory Ltd},
  year		= "2003",
  month		= "sep",
  note		= {ISBN 0-954-16178-5\hspace*{\fill}\\
                  \verb@http://www.python.org/doc/current/ref/ref.html@}
}
@Manual{odersky:scala-reference,
  title =        {The {S}cala {L}anguage {S}pecification, Version 2.4},
  author =       {Martin Odersky},
  organization = {EPFL},
  month =        feb,
  year =         2007,
  note =         {https://www.scala-lang.org/docu/manuals.html}
}
@Book{odersky:scala-reference,
  ALTauthor =    {Martin Odersky},
  ALTeditor =    {},
  title =        {The {S}cala {L}anguage {S}pecification, Version 2.4},
  publisher =    {},
  year =         {},
  OPTkey =       {},
  OPTvolume =    {},
  OPTnumber =    {},
  OPTseries =    {},
  OPTaddress =   {},
  OPTedition =   {},
  OPTmonth =     {},
  OPTnote =      {},
  OPTannote =    {}
}
%% InProceedings
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
@InProceedings{odersky-et-al:fool10,
  author	= {Martin Odersky and Vincent Cremet and Christine R\"ockl
                  and Matthias Zenger},
  title		= {A {N}ominal {T}heory of {O}bjects with {D}ependent {T}ypes},
  booktitle	= {Proc. FOOL 10},
  year		= 2003,
  month		= jan,
  note		= {\hspace*{\fill}\\
                  \verb@https://www.cis.upenn.edu/~bcpierce/FOOL/FOOL10.html@}
}
%% Misc
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
@Misc{w3c:dom,
  author	= {W3C},
  title		= {Document Object Model ({DOM})},
  howpublished	= {\hspace*{\fill}\\
                  \verb@https://www.w3.org/DOM/@}
}
@Misc{w3c:xml,
  author	= {W3C},
  title		= {Extensible {M}arkup {L}anguage ({XML})},
  howpublished	= {\hspace*{\fill}\\
                  \verb@https://www.w3.org/TR/REC-xml@}
}
@TechReport{scala-overview-tech-report,
  author =       {Martin Odersky and al.},
  title =        {An {O}verview of the {S}cala {P}rogramming {L}anguage},
  institution =  {EPFL Lausanne, Switzerland},
  year =         2004,
  number =       {IC/2004/64}
}
@InProceedings{odersky:sca,
  author =       {Martin Odersky and Matthias Zenger},
  title =        {Scalable {C}omponent {A}bstractions},
  booktitle =    {Proc. OOPSLA},
  year =         2005
}
@InProceedings{odersky-et-al:ecoop03,
  author =       {Martin Odersky and Vincent Cremet and Christine R\"ockl and Matthias Zenger},
  title =        {A {N}ominal {T}heory of {O}bjects with {D}ependent {T}ypes},
  booktitle =    {Proc. ECOOP'03},
  year =         2003,
  month =        jul,
  series =       {Springer LNCS}
}
@InCollection{cremet-odersky:pilib,
  author =       {Vincent Cremet and Martin Odersky},
  title =        {PiLib} - A {H}osted {L}anguage for {P}i-{C}alculus {S}tyle {C}oncurrency},
  booktitle =    {Domain-Specific Program Generation},
  publisher =    {Springer},
  year =         2005,
  volume =       3016,
  series =       {Lecture Notes in Computer Science}
}
@InProceedings{odersky-zenger:fool12,
  author =       {Martin Odersky and Matthias Zenger},
  title =        {Independently {E}xtensible {S}olutions to the {E}xpression {P}roblem},
  booktitle =    {Proc. FOOL 12},
  year =         2005,
  month =        jan,
  note =         {\verb@https://homepages.inf.ed.ac.uk/wadler/fool@}
}
@InProceedings{odersky:scala-experiment,
  author =       {Martin Odersky},
  title =        {The {S}cala {E}xperiment - {C}an {W}e {P}rovide {B}etter {L}anguage {S}upport for {C}omponent {S}ystems?},
  booktitle =    {Proc. ACM Symposium on Principles of Programming Languages},
  year =         2006
}
@MISC{kennedy-pierce:decidable,
  author = {Andrew J. Kennedy and Benjamin C. Pierce},
  title = {On {D}ecidability of {N}ominal {S}ubtyping with {V}ariance},
  year = {2007},
  month = jan,
  note = {FOOL-WOOD '07},
  short = {https://www.cis.upenn.edu/~bcpierce/papers/variance.pdf}
}
```
# 15 Changelog

This changelog was no longer maintained after version 2.8.0.
