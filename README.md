# EDAA30 Labb 6
version 0.3

I den här labben kommer du implementera metoder för ett binärt sökträd.
Testerna är färdiga, men inaktiverade. 
Ta bort kommentaren framför `@Test` för ett test i taget, 
enligt instruktioner, och få det att passera innan du går vidare. 
Ibland kommer testen bli gröna redan från början, det är ok.
Kolla att de kan gå sönder.
När labben är klar ska du ha minst 35 test som passerar.
Du får också skriva egna om du behöver,
men du får inte ända i de som finns nu. (Annat än att aktivera dem.)

## Frågor att tänka på
- Är det något speciellt i din kod du vill ha feedback på?
- Klassen BinarySearchTree har två konstruktorer på liknande sätt som Javas klasser
TreeSet, TreeMap och PriorityQueue. Varför är det så?
- I vissa av de uppgifter du löst (t ex height och add) finns det en publik metod som
anropar motsvarande rekursiva metod. Varför behövs bägge metoderna?
- I samband med ombyggnaden av trädet används en lista av typen ArrayList för att
mellanlagra elementen. Skulle man lika gärna kunna använda LinkedList?

## Förkunskaper
- Materialet om Binära sökträd och rekursion på Moodle 12:1, 12:2, 13:1
- Materialet om strömmar, en del av 14:1 på Moodle  

## Syfte
Träna på rekursiva algoritmer. 
Skriva en egen generisk klass för att få djupare förståelse i hur de fungerar.

## Redovisning
Du behöver bara kunna redovisa koden som den ser ut när laborationen är klar.

## Filer att ändra i
Alla uppgifter ändrar i `BinarySearchTree.java` och aktiverar tester i `BinarySearchTreeTest.java`.
Om du vill se hur ett träd ritas ut kan du använda `BSTApplication.java` i paketet app.
Då kan du ändra i den för att lägga till trädet du vill rita ut.


## 0 Se till att testen kör och att size är noll
### Syfte
Komma igång.
### Tester att aktivera, i ordning
Inga nya.
### Teknik
Kör testerna och kolla att ett passerar och inget är rött.

## 1 Lägg till ett element i ett träd

### Syfte
Lära dig att sätta in ett element så att trädet fortsätter att vara sorterat.

### Tester att aktivera, i ordning
1, 2, 3, 4

### Teknik
Sätt in elementet så att trädet fortsätter vara sorterat.
Börja med trädet som tar ett lambda-uttryck, det andra tar vi i nästa uppgift.
Trädet tillåter inte dubbletter, och returnerar `false` 
om `add` försöker lägga till ett element som redan finns, `true` annars. 
Du ska använda rekursion. 

### Instruktioner
- Implementera konstruktorn som tar ett lambda-uttryck.
- Skriv en rekursiv funktion som placera in noden på rätt plats i trädet.
Kolla i CLUES.md om/när du vill ha instruktioner steg för steg.

## 2 Konstruktor utan parameter
`BinarySearchTree` har en konstruktor utan parameter.
Om inget lambda skickas med måste `E` vara `Comparable` och dess egna `compareTo` används vid jämförelse.

### Syfte
Öva på en konstruktor som kallar på en annan.
Öva på lambda-uttryck.

### Tester att aktivera, i ordning
5, 6, 7, 8, 9

### Teknik
Skapa en generell konstruktor som anropar en specifik konstruktor med en default-parameter.

### Instruktioner
- Implementera konstruktorn som inte har några parametrar,
  låt den kalla den andra konstruktorn med ett defaultvärde.

## 3 Trädets höjd
### Syfte
Konstruera en rekursiv funktion för att se var trädet är som högst.

### Tester att aktivera, i ordning
10, 11, 12, 13 

### Teknik
Rekursion!

### Instruktioner
Implementera metoden `public int height()` som beräknar trädets höjd.
Till skillnad från tidigare funktion, som bara gick en väg, behöver den här jämföra djupet på alla löv, 
och returnera den med störst värde.
I den här laborationen har ett tomt träd höjden -1. 
Läs mer i CLUES.md

## 4 Töm trädet

### Syfte
Förstå vad som behövs för att tömma ett träd.

### Tester att aktivera, i ordning
14, 15

### Teknik 
Använd att det enda som håller kvar trädets noder i minnet är referensen till `root`.

### Instruktioner
Implementera metoden clear. 

## 5 Representera trädet som en sorterad array
### Syfte
Lär dig ett sätt att gå igenom ett träd.

### Tester att aktivera, i ordning
16, 17, 18, 19

### Teknik
En rekursiv funktion som lägger nodernas värden i en array in-order, 
det vill säga sorterade.

### Instruktioner
- Anropa den privata `toArray` från den publika.
- Implementera den privata ´toArray` så att den går igenom trädet im-order.


## 5 Representera som en sträng
### Syfte
Skapa en textrepresentation av trädet sorterat.
Öva på streams.

### Tester att aktivera, i ordning
20, 21, 22, 23

### Teknik
Använd `toArray` och en stream för att skapa en sträng.
Skugga metoden `toString()`.

### Instruktioner
Skugga metoden toString i klassen BinarySearchTree. 
Strängen som returneras ska innehålla elementen i inorder med `-` mellan elementen.

## 6 Bygg om som balanserat träd
Ett träd kan bli obalanserat på grund av insättningar och borttagningar.
Vissa träd balanserar sig själva, det gör inte vårt.
Istället ska vi skriva en metod som konstruerar om ett träd som balanserat.
I `BSTApplication` finns det två arrayer med tal, 
den ena resulterar i ett balanserat träd och den andra i ett obalanserat.
Testa gärna att rita ut de olika och se hur de skiljer sig åt.

### Syfte
Läa dig ett enkelt sätt att skapa ett balanserat träd. 

### Tester att aktivera, i ordning
24, 25, 26, 27, 28

### Teknik
Noder ska skapas och ett nytt träd ska byggas upp från scratch inuti buildTree.
Du ska _inte_ använda `add`.

### Instruktioner
- Utgå från en sorterad lista.
- Sätt ut roten. Fler instruktioner finns i CLUES.md om du behöver.


## 7 Pre-order traversal
Ett träd kan gås igenom i olika ordning beroende på vad syftet är.
In-order används för att skriva ut ett sorterat träd.
För att avgöra strukturen på ett träd behövs både den sorterade ordningen, 
och en annan ordning.

### Syfte
Titta på ytterligare ett sätt att gå igenom ett träd, 
så att du vet att det finns flera och kan implementera dem.

### Tester att aktivera, i ordning
29, 30, 31, 32, 33

### Teknik
Använd en rekursiv funktion för att skapa en array med trädets 
värden genomgågna i pre-order.

### Instruktioner
Du ska göra som i toArray, men roten ska hanteras före höger och vänster.
I CLUES.md finns mer information.

## 8 Exception
Kolla att det sista testet också går igenom. Fundera på vad som häner. 
### Tester att aktivera, i ordning
34

