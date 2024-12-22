# Sample project for OpenClassroom's fundamentals of Java

The program takes a list of symptoms in an input text file 'symptoms.txt' and then counts the number of identical symptoms, then saves the list of symptoms and their number in an output text file 'result.out'.

## Dependencies
This code was created and tested with Java version 22

## For compile and launch the program

```bash
    javac com/hemebiotech/analytics/AnalyticsCounter.java ;
    java -cp "." com.hemebiotech.main.Main ;

```

## Usage class in main

```java
        ISymptomReader reader = new ReadSymptomDataFromFile("symptoms.txt");
        ISymptomWriter writer = new WriteSymptomDataToFile("result.out");
        
        AnalyticsCounter analyCount = new AnalyticsCounter(reader, writer);
        
        List<String> symptoms = analyCount.getSymptoms();
                
        Map<String, Integer> CountSymptoms = analyCount.countSymptoms(symptoms);
        
        CountSymptoms = analyCount.sortSymptoms(CountSymptoms);
                
        analyCount.writeSymptoms(CountSymptoms);
```

- [x] Etape 1 : Mettez en place le repo Git
- [x] Etape 2 : Analysez le code existant 
- [x] Etape 3 : Créer une interface pour l'écriture des données
- [x] Etape 4 : Refactorez AnalysticsCounter en plusieurs méthodes
- [x] Etape 5 : Créez la méthode Main
- [x] Etape 6 : Nettoyez et commentez le code 
