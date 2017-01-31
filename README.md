# RobotTest
Testprogram for a java robot  


Beskrivning av RobotTest program skrivet i Java av Erik Boström.  

RobotTest-programmet är skrivet i utbildningssyfte för att testa teoretiska kunskaper i en praktisk miljö.  
Det hela går ut på att användaren har en spelare som kan flytta sig på en spelplan/grid i fyra olika riktningar upp, ner, höger och vänster.  
Programmet styrs via tre stycken textfält som skapar spelplan, spelare och sätta en startposition.  
  
Size: Detta fält används för att skapa upp spelplanen. Genom att skriva in två st int värden som skiljs av ett mellanslag bestämmer användaren hur stor spelplanen ska vara på X och Y axeln.  
Exempeldata:  9 9  
First position: Detta fält berättar för programmet vart på spelplanen spelaren ska starta samt vilken riktning spelaren ska ha. Första siffran bestämmer vart på den vertikala linjen, den andra siffran på den horisontella linjen och den tredje bokstaven väljer riktning N, E, S eller W.  
Exempeldata: 1 2 N  
Walk: Detta fält berättar för spelaren hur den ska röra sig genom att antingen säga att den ska byta position eller gå ett steg. För att byta position så skriver användaren R eller L för att svänga höger eller vänster. För att gå ett steg skriver användaren G. Detta skrivs i en textsträng utan mellanslag.  
Exempeldata: RRGLGGRRGGLLGGG  
 
