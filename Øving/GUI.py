import sys
from PyQt5.QtWidgets import *

# Lager en klasse, Hovedvindu, som skal arve fra klassen QWidget.
# Denne klassen er tenkt å inneholde all kode for å lage GUI som skal vises for vinduet vårt.
class Hovedvindu(QWidget):
    def __init__(self):
        super().__init__()

        self.setWindowTitle('Gridlayout')                       # Gir vinduet en tittel
        self.setGeometry(100, 100, 700, 700)                    # Gir vinduet en selvdefinert størrelse

        layout = QGridLayout()                                  # Oppretter et layout av klassen QGridLayout
        self.setLayout(layout)                                  # Sier at denne klassen (Hovedvindu) skal bruke nevnte layout

        min_label = QLabel()                                    # Oppretter en label
        min_label.setText('Dette er en label')                  # Legger tekst på labelen
        layout.addWidget(min_label,0,0)                         # Legger til labelen i layoutet, med koordinater 0,0

        min_knapp = QPushButton('min knapp')                    # Oppretter en knapp med klassen QPushButton, gir den teksten 'min knapp'
        layout.addWidget(min_knapp, 0,1)                        # Legger til knappen i layoutet, med koordinater 0,1

        min_inputlinje = QLineEdit()                            # Oppretter en inpulinje med klassen QLineEdit
        min_inputlinje.setPlaceholderText('Enkel linje, dette er standardtekst')    # Gir den en placeholdertekst
        layout.addWidget(min_inputlinje, 0, 2)                  # Legger til inputlinja i layoutet, med koordinatene 0,2

        min_radioknapp = QRadioButton('radioknapp')             # Oppretter en radioknapp med klassen QRadioButton, og gir den en tekstbeskrivelse
        layout.addWidget(min_radioknapp, 1,0)                   # Legger til radioknappen i layoutet, med koordinatene 1,0


        self.show()                                             # Her har vi lagt show() i klassen. Siden denne ligger i __init__-metoden vil den bli utført når vi oppretter et objekt av Hovedvindu

        # TO BE CONTINUED


if __name__ == '__main__':                                      # Sjekker om det er denne filen vi starter/kjører. I så tilfelle kjøres koden under.
    app = QApplication(sys.argv)                                # Må alltid med

    vindu = Hovedvindu()                                        # Oppretter et objekt av Hovedvindu()-klassen

    sys.exit(app.exec())                                        # Må alltid med