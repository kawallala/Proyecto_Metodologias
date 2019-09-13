# Proyecto_Metodologias

Project of the course Metodologias de diseño y programacion, that consists of the creation of the game Alpaca Emblem, based on a code template given by the teaching stafff, where the student is in charge of implementing the desired functionalities.
<p>
  For the implementation of the desired functiopnalities, specially in the combat interaccion, a wide use of Double Dispatch was made, where multiple interfaces where used for a quick and easy desambiguation of the interacting items.

For now the project does not have a way to be executed, however, every functionality of it was throughly tested

# Project Classes
Actually the project consist of 3 major packages, items, map and units, each one is detailed here
## Items
All of the Items can be divided in 2 categories, detailed below

### Healing Items
Healing items heal units when they are used, for now, they are only made up of the **Staff**

### Offensive Items
Offensive Items attack units when thay are used, starting a counterattack if damage is done
There are 2 sub-categories of Offensive Items

#### Magic Offensive Items
Magic Offensive Items attack units with magic, for now, they are made up of **Anima Magic Book, Light Magic Book** and **Dark Magic Book**
Magic Offensive Items deal double damage to Physical Offensive Items

#### Physical Offensive Items
