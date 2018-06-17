RxJava2, DataBinding, MVVM, Dagger2, UnitTests application that shows RecyclerView with items that contains circle ImageView with randomly selected color (red or blue) and TextView with current counter. 

Below the list there are two buttons that allow you to start / stop / reset the random mechanism. 

The random mechanism assumes that: 
* if the list has less than 5 items, add an element with a random color and the current interval 
* otherwise: 
  * in 50% of cases, increase the counter of a random element  
  * in 35% of cases, reset the counter of the random element 
  * in 10% of cases, remove a random element 
  * in 5% of cases, add the previous counter to the random element (in case of the first one - the last one should be used)  

The displayed value of the counter of the blue element should be multiplied by 3.
