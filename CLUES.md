# Clues labb 6 EDAA30
version 0.3

## 1 Lägg till ett element i ett träd
Tänk noga efter hur du ska jämföra två element för att upptäcka dubbletter,
respektive för att se om det nya elementet ska sättas in till vänster eller till höger.

- Kolla om roten är tom, lägg till elementet där ifall den är tom.
- Om roten inte är tom, anropa en rekursiv funktion på roten.
- Låt den rekursiva funktionen se om det nya elementet ska in till höger eller vänster.
- Om den platsen är tom, lägg ni den nya noden.
- Om platsen inte är tom, kalla metoden rekursivt på den noden som har den platsen.

## 2 Konstruktor utan parameter
När det är en kedja av konstruktorer ska de mer generella (färre parametrar),
nästan alltid kalla de med fler parametrar.
De parametrar som saknas ersätts då med ett standardvärde.

En funktion kan lagras som en lambda-funktion med hjälp av `::`.
`E::compareTo` går att tilldela till samma variabel som håller ordning på ett lambda,
och då kallas vid jämförelse.


## 3 Trädets höjd
Det är lämpligt att skriva en rekursiv privat metod som anropas i den publika
metoden.
`Math.max` är användbar.

## Om höjden på ett träd
Höjden på binära träd beräknas olika.
I den här labben gäller att ett träd med en nod har höjden 0.
Ett träd utan noder har höjden -1.
(Tänk dig gropen som blir när någon tagit ut roten.)
I en del material på Moodle är höjden för en nod 1.
Skriver du kod så att testerna passerar kommer det bli rätt.

## 4 Töm trädet
Clear är en metod på två rader.
Fundera på två sätt att definiera att ett träd är tomt.

## 5 Representera trädet som en sorterad array
Om den här inte blir rätt kan det också bero på att trädet är uppbyggt spegelvänt.
Kolla hur du jämför element.

## 5 Representera som en sträng
Det här går att lösa på flera sätt.
En kombination är 
`stream()`, `map`, `toString`, `collect` och `Collectors.joining("-)`.

## 6 Bygg om som balanserat träd
Ett träd kan bli snett (obalanserat) när man gör många insättningar och borttagningar. I
självbalanserade binära sökträd som t.ex. röd-svarta träd eller AVL-träd, undviker man
detta genom att balansera trädet i samband med varje insättning/borttagning.
Ett annat sätt kan vara att ”bygga om” trädet då och då när det blivit alltför snett
förutsatt att detta inte sker alltför ofta. I den här uppgiften ska du implementera en algoritm för detta.
Om alla element i trädet sätts in i växande ordning i en lista av typen
ArrayList är det sedan enkelt att bygga ett träd där antalet noder i vänster respektive
höger underträd aldrig skiljer sig med mer än ett och som därför är balanserat. 
Algoritmen är följande: 
- Skapa en nod som innehåller mitt-elelementet i listan. 
- Bygg (rekursivt) ett träd som innehåller elementen till vänster om mitt-elementet och ett träd som innehåller
elementen till höger om mitt-elementet. 
- Låt dessa båda träd bli vänster respektive höger
barn till roten.

En metod med följande rubrik ska implementeras i klassen BinarySearchTree:
```
/**
*/
* Builds a balanced tree from the elements in the tree.
  public void rebuild();
  Metoden ska implementeras så att den går igenom trädet i inorder och bildar en lista med
  innehållet i växande ordning. Sedan ska trädet byggas enligt algoritmen ovan. Följande
  rekursiva hjälpmetoder ska implementeras och användas inuti rebuild:
  /*
  */
* Adds all elements from the tree rooted at n in inorder to the list private void toArray(BinaryNode<E> n, List<E> sorted)
  /*
* last in the * Elements in * Returns the */
* Builds a complete tree from the elements from position first to
  list sorted.
  the list are assumed to be in ascending order.
  root of tree.
  private BinaryNode<E> buildTree(List<E> sorted, int first, int last); 
  ```

Observera att noder ska skapas och ett nytt träd ska byggas upp från scratch inuti buildTree.
Metoden `add` ska inte användas.
Testa genom att använda `BSTApplication` som bygger ett snett (men inte helt snett) träd
genom successiva `add`-anrop.
Du kan då lägga till att dem anropar `rebuild()`och köra om programmet. 
Testerna kollar också att trädet byggs om rätt.
Om du inte får rätt på andra testet,
nollställ size när du räknar om trädet och kolla att du skapar rätt antal noder.

## 7 Pre-order traversal, NLR
Besök först roten, 
gå sedan igenom det vänstra underträdet, 
sedan det högra. 
Använd rekursion.
En pre-order genomgång går igenom trädet topologiskt, 
hur noderna sitter ihop spelar roll, 
eftersom föräldern skrivs ut före barnen.

