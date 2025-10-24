# almond
* https://almond.sh/
* https://github.com/almond-sh/almond

> A Scala kernel for Jupyter.

# Installation

```shell
$ cs launch --use-bootstrap almond -- --help
Usage: almond [options]
...

$ cs launch --use-bootstrap almond --scala 2.12.20 -- --install --force
Installed scala kernel under ~\AppData\Roaming\jupyter\kernels\scala
```

# Multiple kernels
```shell
$ cs launch almond --scala 2.12.20 -- --install --id scala212 --display-name "Scala (2.12)"
Installed scala kernel under ~\AppData\Roaming\jupyter\kernels\scala212
$ cs launch almond --scala 2.13.16 -- --install --id scala213 --display-name "Scala (2.13)"
Installed scala kernel under ~\AppData\Roaming\jupyter\kernels\scala213
$ cs launch almond --scala 3 -- --install --id scala3 --display-name "Scala (3)"
Installed scala kernel under C:\Users\zhouj\AppData\Roaming\jupyter\kernels\scala3
```

# Ammonite API
* https://almond.sh/docs/api-ammonite

instances
- `interp`: `ammonite.interp.api.InterpAPI`,
- `repl`: `ammonite.repl.api.ReplAPI`.

# Almond Jupyter API
* https://almond.sh/docs/api-jupyter

instances
- `kernel`: a `almond.api.JupyterApi`

# See Also
* [Interactive Computing in Scala with Jupyter and almond](https://blog.brunk.io/posts/interactive-computing-with-jupyter-and-almond/)
* [Which API for plotting](https://users.scala-lang.org/t/which-api-for-plotting/8826) - Scala users
