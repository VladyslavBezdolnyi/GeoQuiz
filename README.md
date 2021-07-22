# GeoQuiz


It's a geographical game that will test your knowledge of the political map of the world. You will try to guess as many countries as possible, based only on borders and geographical objects surrounding it.


The new brand rating system will help you on your way:

- Countries are listed in order of increasing difficulty (more "popular at start").
- Each win or defeat will change your start point (rating), making your game easier or competitive.
- The game will remember countries that you handle too effortlessly or, on the contrarily, hard and will move its position.

--------------------

## Activities preview:
![1st gif vid](https://user-images.githubusercontent.com/31826511/126226271-6682d6ae-ed2d-42a3-9678-65980b950a8e.gif)
⠀⠀⠀⠀⠀
![2nd gif vid](https://user-images.githubusercontent.com/31826511/126226264-b0c75143-00d1-42d2-b0f4-61b95c72a918.gif)


###### MainActivity.java⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀  PlayGround.java

--------------------
## UML Class Diagram


![Ресурс 7](https://user-images.githubusercontent.com/31826511/126654366-0eb9e5a6-91f2-4e45-822b-442ff4050962.png)

--------------------

## RandomIndex.class


Sorts an array of numbers from 0 to N in random order, which relies on player rating. 

The countries are listed in estimated complexity order (from more popular to less ![Ресурс 8](https://user-images.githubusercontent.com/31826511/126655188-af75a0e2-6cf3-4689-908d-e6fe00c748a0.png)  ).
So the essence of the algorithm is to shuffle indexes that will be used for the input country array. 

**Output data:**
```
int [] randomIndexSequence;
```
**Shuffle Algorithm:**
The Gaussian distribution (normal distribution) will be responsible for the random part.


![safasf](https://user-images.githubusercontent.com/31826511/126667669-e8f5d691-a6b3-4294-9c4f-adc785eade14.png)

**μ** - mean (rank value)
**σ** - standart deviation

The array of indexes will be decreasing with each iteration. It's increasing the chance of falling out of bounce.
In this case, Algorithm has exceptions:


-	The value will be mirrored relative to the boundaries -  ![123](https://user-images.githubusercontent.com/31826511/126667316-37f010f6-1a32-413d-8aa6-7005a60b3360.png)

-	The mean value does not exceed the value equals «n - 2 * σ». It's because the algorithm starts to behave itself incorrectly on boundaries.
-	When the index array gets smaller, the mean value moves to the center of the array. It saves the logic of the algorithm and makes it more natural.

-----------------
## Gaussian.class
Generates a random number using a random Gaussian distribution:
```
Math.sin(2 * Math.PI * Math.random()) * (-2 * Math.log(Math.random()))
```
**Input Data:**
```
private double mean;
private double deviation;
```
**Output Data:**
```
double getGaussian(double mean){. . .}
```
-----------------
## Player.class
The class with user data(rating, avatar, etc.)

-----------------
## Country.class
Sorts the name in random order (mixedName)
Provides input for UI (dashName)
**Input Data**
```
String name;
```
**Output Data**
```
String mixedName;
String dashName;
```
-------------------
## CountrySequence.class
Connects data source to a previously randomly generated list of indexes.
**Input Data**
```
int [] randomIndexSequence;
```
**Output Data**
```
Country [] countryList;
```

