from graphviz import Digraph

# Tworzenie ogólnego diagramu UML
uml_general = Digraph("WzorzecObserwatorOgolnyUML", format="png")
uml_general.attr(rankdir="TB", size="8,5")

# Definicje klas
uml_general.node("Subject", "Subject\n+ addObserver()\n+ removeObserver()\n+ notifyObservers()", shape="record")
uml_general.node("Observer", "Observer\n+ update()", shape="record")

# Relacja Subject -> Observer
uml_general.edge("Subject", "Observer", label="notifies")

# Zapis do pliku
uml_general.render("WzorzecObserwatorOgolnyUML")
