from graphviz import Digraph

# Tworzenie diagramu sekwencji
seq_diagram = Digraph("SekwencjaZmianyKoloruFragmentUML", format="png")
seq_diagram.attr(rankdir="LR", size="12,5")

# Obiekty w sekwencji
seq_diagram.node("User", "User", shape="rectangle")
seq_diagram.node("GUI", "ColorChangingLabel", shape="rectangle")
seq_diagram.node("Observer", "ConsoleObserver", shape="rectangle")

# Interakcje
seq_diagram.edge("User", "GUI", label="Kliknięcie przycisku zmiany koloru")
seq_diagram.edge("GUI", "Observer", label="notifyObservers(\"Czerwony\")")
seq_diagram.edge("Observer", "Observer", label="System.out.println(...)")

# Zapis do pliku
seq_diagram.render("SekwencjaZmianyKoloruUML")
