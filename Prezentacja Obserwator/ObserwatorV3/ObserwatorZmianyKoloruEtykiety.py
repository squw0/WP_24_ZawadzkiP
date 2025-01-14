from graphviz import Digraph

# Utworzenie diagramu UML
uml = Digraph("ObserwatorZmianyKoloruEtykiety", format="png")
uml.attr(rankdir="TB", size="12,8")

# Klasy i interfejsy
uml.node("Observer", "Observer\n+ update(color: String)", shape="record")
uml.node("Subject", "Subject\n+ addObserver(observer: Observer)\n+ removeObserver(observer: Observer)\n+ notifyObservers(color: String)", shape="record")
uml.node("ColorChangingLabel", '''ColorChangingLabel\n- observers: List<Observer>\n+ addObserver(observer: Observer)\n+ removeObserver(observer: Observer)\n+ notifyObservers(color: String)\n+ changeColor(color: Color)\n- getColorName(color: Color): String''', shape="record")
uml.node("ConsoleObserver", "ConsoleObserver\n+ update(color: String)", shape="record")
uml.node("ObserwatorV2", "ObserwatorV2\n+ main(args: String[])", shape="record")

# Relacje
uml.edge("Observer", "ConsoleObserver", label="implemented by")
uml.edge("Subject", "ColorChangingLabel", label="implemented by")
uml.edge("ColorChangingLabel", "Observer", label="manages")
uml.edge("ObserwatorV2", "ColorChangingLabel", label="creates and uses")

# Generacja pliku
uml.render("ObserwatorZmianyKoloruEtykietyUML")
