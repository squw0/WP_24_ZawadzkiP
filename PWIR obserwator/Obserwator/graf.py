from graphviz import Digraph

# Utworzenie diagramu UML
uml = Digraph("OnlineStoreObserver", format="png")
uml.attr(rankdir="LR", size="8,5")

# Klasy
uml.node("Observer", "Observer\n+ update(message: String)", shape="record")
uml.node("Subject", "Subject\n+ addObserver(observer: Observer)\n+ removeObserver(observer: Observer)\n+ notifyObservers(message: String)", shape="record")
uml.node("Product", "Product\n- name: String\n- price: double\n- available: boolean\n+ addObserver()\n+ removeObserver()\n+ notifyObservers()\n+ setPrice()\n+ setAvailability()", shape="record")
uml.node("User", "User\n- email: String\n+ update(message: String)", shape="record")
uml.node("Main", "Main\n+ main(args: String[])", shape="record")

# Relacje
uml.edge("Observer", "User", label="implemented by")
uml.edge("Subject", "Product", label="implemented by")
uml.edge("Product", "Observer", label="manages")
uml.edge("Main", "Product", label="demonstrates")

# Generacja pliku
uml.render("/mnt/data/OnlineStoreObserverUML")
