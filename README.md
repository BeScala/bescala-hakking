BeScala hAkking Event
===============

Use case
-------

In a wholesale market for geometric objects, a customer can publish a demand containing one or more (generally a couple of thousands) geometric object specification. 


A geometric object consist of: 

- A shape    - Square, Rectangle, Circle, Triangle and Ellipse
- A color    - Red, Orange, Yellow, Green, Blue, White and Black 
- A material - Glass, Wood, Metal, Paper, Plastic and Ceramic
- An area    - area is expressed on cm2. It can goes from from 1cm2 up to 100cm2 

Suppliers can respond with offers. Each offer has one or more (generally a couple of thousands) quotes for geometric objects. A quote consist of a GeometricObject and a price (in euro).


Since it's a wholesale market, the buyer must buy all objects in an offer. As such, the program must find which offers combination delivers the best price and the least reminder.

For example:

**Demand**

    Circle  |   Blue  |   Glass   | 10   cm2
    Circle  |   Blue  |   Glass   | 10   cm2
    Circle  |   Blue  |   Metal   | 20   cm2
    Circle  |   Blue  |   Ceramic | 11   cm2

**Offer 1**

    Circle  |   Blue  |   Glass   | 10   cm2  | 8     euro
    Circle  |   Blue  |   Glass   | 10   cm2  | 8     euro
    Circle  |   Blue  |   Paper   | 12   cm2  | 0.30  euro
    Circle  |   Blue  |   Metal   | 20   cm2  | 8     euro

**Offer 2**

    Circle  |   Blue  |   Glass   | 10   cm2  | 2     euro
    Circle  |   Blue  |   Ceramic | 11   cm2  | 4     euro

**Offer 3**

    Circle  |   Blue  |   Glass   | 10   cm2  | 2     euro
    Circle  |   Blue  |   Metal   | 20   cm2  | 2     euro
    Circle  |   Blue  |   Glass   | 10   cm2  | 3     euro
    Circle  |   Blue  |   Metal   | 60   cm2  | 15    euro
    Circle  |   Blue  |   Metal   | 70   cm2  | 20    euro       
    
**Offer 4**

    Circle  |   Blue  |   Glass   | 10   cm2  | 2     euro
    Circle  |   Blue  |   Glass   | 10   cm2  | 2     euro
    Circle  |   Blue  |   Paper   | 12   cm2  | 0.30  euro
    Circle  |   Blue  |   Metal   | 20   cm2  | 8     euro
    

The demand can be fulfilled if we buy combine (offer 1 + offer 2) or (offer 2 + offer 3) or (offer 2 + offer 4). 

The combination offer 2 + offer 4 delivers the best price and smallest reminder.


The code to search for the best combination is provided. The goal of this hacking session is not to find the algorithm that will give us the best combination, but how can we improve the performance by spliting this task over different Actors.

For the above example it's prettry easy and straitforward. No optimization is required for such a small amount of geometric objects. But does it will scale?
What about a demand of 2000 geometric objects and 5 offers with quotes going from 3000 to 10000? What about a demand of 20000 and offers up to 100000?

The first target will be to send each combination to a different actor and collecting the result.
The second target will be to, inside a combination, split it further to reduce the search space. 
 