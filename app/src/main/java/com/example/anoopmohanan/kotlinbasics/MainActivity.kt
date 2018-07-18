package com.example.anoopmohanan.kotlinbasics

import android.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import java.time.Duration
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //variables()
        //nullSafetyFun()
        //conditions()
        //loops()
        //typeCheck("Hello","Hello b")
        //collections()
        //setSample()
        nullableTest()

//        val vehicle = Vehicle("red",4)
//        Log.i("Kotlin", "Vehicle color is ${vehicle.color}")
//        vehicle.numberofWheels = 5
//        //vehicle = Vehicle("black",6)
//
//        val car = Car("blue", numberofWheels = 4)
//        Log.i("Kotlin", "Car color is ${car.color}")
//
//        val car1 = Car1("red", 4)
//        Log.i("Kotlin", "Car1 color is ${car1.color}")
//        Log.i("Kotlin", "Car1 color is ${car1.whoAMI}")
//        car1.startEngine()
//
//        val bike1 = Bike1("red", 2)
//        Log.i("Kotlin", "bike1 color is ${bike1.color}")
//        Log.i("Kotlin", "bike1 color is ${bike1.whoAMI}")
//        bike1.startEngine()
//
//
//        val car2 = Car2("red", 4)
//        car2.startEngine()
//
//        val bike2 = Bike2("red", 2)
//        bike2.startEngine()
//
//        val gen1 = Generic<String>("Hello")
//        Log.i("Kotlin", "Genric value is ${gen1.content}")
//
//        val gen2 = Generic<Int>(5)
//        Log.i("Kotlin", "Genric value is ${gen2.content}")
    }

    // Variables

    fun variables(){

        // Mutable
        // Kotlin infers the type
        var text = "hello"  // Inferred as String
        Log.i("Kotlin",text)
        var number = 5.45   // Inferred as Double

        var number2:Float = 5.45f// Gives error as by default decimals are interpretted as double. To fix it you need to append "f"

        // Explicit Typing
        var message: String = "hello"

        // Modify
        text = "I am modified"

        Log.i("Kotlin",text)

        // Constants

        val constantText = "Hello"

        //constantText = "I am modified"  // Gives error
    }

    fun nullSafetyFun(){

        // System has a possibility to identify which value can be null or not

        //var text: String = null // Not allowed

        var text2: String? = null // This means text2 can hold null values

        // To safely access use ?
        Log.i("Kotlin",text2?.length.toString())

        // If you are really sure that text2 has values, then read the value with force using !!
        var text3: String? = null

        // use !!
        //Log.i("Kotlin",text3!!.length.toString()) // Like forced unwrapping in swift, this may lead to null pointer exception

        // If the expression on the left of ?: is valid, then return it else send the value on right hand side

        val len = text2?.length ?: 0
        Log.i("Kotlin",len.toString())

    }
    fun maps(){

        val mymap = emptyMap<String,String>() // empty readonly map
        val anothermymap = mapOf<String, String>() // another empty readonly map
        val contentMap = mapOf("Don" to "First Name","Bosco" to "LastName")
        val mutableMap = mutableMapOf("First Name" to "Don" ,"LastName" to "Bosco")
        mutableMap.put("name","Batista")
        mutableMap.filter { it.value == "Don" }
    }

    fun nullableTest(){

        var str:String? = null

        //str = "David"

        val hello = str?.let { sayHello(it) }?: "Undefined"

        Log.i("Kotlin",hello)

    }

    fun sayHello(name: String): String{

        return "Hello $name"
    }

    fun getColorFor(color: String): Int {
            return when (color) {
            "Red" -> 0
            "Green" -> 1
            "Blue" -> 2
            else -> throw IllegalArgumentException("Invalid color param value")
        }
    }
    fun helloColor(){

        val color = try {
            getColorFor("Red")
        } catch (e: IllegalArgumentException){

            Log.i("Kotlin",e.localizedMessage)
        }


    }

    fun conditions(){

        // IF

        val threshold = 200

        if (threshold < 100){

            Log.i("Kotlin","its good")
            println("its good")
        }else if (threshold > 100){
            Log.i("Kotlin","need to worry")
            println("need to worry")
        }else if (threshold > 200){
            Log.i("Kotlin","reached maximum")
            println("reached maximum")
        }

        // WHEN

        val state: Int = 1

        when (state){

            1 ->  Log.i("Kotlin","State is Running.")
            2 -> {
                // if there is multiple lines, use curly braces
                Log.i("Kotlin","State is Stopped.")
            }
        // Any unsatisfied state
            else -> Log.i("Kotlin","State is Unknown.")

        }
    }

    fun loops(){

        // for loop
        var total = 0

        // Loop numbers 1 to 5, find their sum
        for (i in 1..5){

            Log.i("Kotlin","$i")
            total = total + i
        }
        Log.i("Kotlin","Total is $total")

        // Normal Iteration
        for (i in 1..5)
            Log.i("Kotlin","Normal Iteration $i")

        // Iterate revers

        for (i in 5 downTo 1)
            Log.i("Kotlin","Reverse iteration $i")

        // Iterate with step

        for (i in 1..5 step 2)
            Log.i("Kotlin","Step Iteration $i")

        // Exclude Iteration
        for (i in 1 until 10)
            Log.i("Kotlin","Exclude Iteration $i")

        //loop through collections
        val collectionlist = listOf("A","B","C")

        for (item in collectionlist){

            Log.i("Kotlin","Item is $item")
        }

        // Similar to SWift 3.0 enumerated() method
        for ((index, item) in collectionlist.withIndex()){

            Log.i("Kotlin","Item at $index is $item")
        }

        val myArray = arrayOf(1,2,3,4)
        for (i in myArray.indices){
            val item = myArray[i]
            Log.i("Kotlin","Item is $item")
        }

        //Break:- To Break out of the entire loop

        //Continue :- Skip a particular iteration

        //Naming loops Helpful in the case of nested loops, you can specify which loop to break and which loop to continue etc

        outer@ for (i in 1..100) {
            for (j in 1..100) {
                var stop = true
                if (stop) break@outer
            }
        }

        // While A while loop statement in Kotlin programming language repeatedly executes a target statement as long as a given condition is true.
        var index = 10
        while (index < 20) {
            Log.i("Kotlin","Value of index is $index")
            index = index + 1
        }

    }

    fun typeCheck(a:Any,b:Any ){

        //Type Check using is and !is Operators

        if (a is String) {
            Log.i("Kotlin","a is a string")
        }
        if (a !is String) {
            Log.i("Kotlin","a is not a string")
        }

        //Smart Casts

        if (a is String) {
            Log.i("Kotlin","a is a string with length ${a.length}") // val gets automatically cast to String
        }

        if (a !is String) return


        // Usage with when
        when (a) {
            is String -> Log.i("Kotlin","(when)a is a string")
            is Int -> Log.i("Kotlin",(a+1).toString())
            is IntArray -> Log.i("Kotlin",a.sum().toString())
        }

        //Type Casting : Unsafe Cast

        //val e: Int = b as Int
        // Log.i("Kotlin",e.toString()) // Result in exception
        //Type Casting : Safe Cast

        val d: Int? = b as? Int
        Log.i("Kotlin",d?.toString())

    }

    fun collections(){

        // Lists
        val items = listOf(1, 2, 3, 4)
        items.first() == 1
        items.last() == 4
        items.filter { it % 2 == 0 }   // returns [2, 4]


        val mutableitems = mutableListOf(1, 2, 3, 4)
        mutableitems.first() == 1
        mutableitems.last() == 4
        mutableitems.filter { it % 2 == 0 }   // returns [2, 4]
        mutableitems.add(5)

        // Array list: Mutable

        val arrayList = arrayListOf("A","B","C")
        val arrayList2 = arrayListOf("D","E","F")

        // Combine array lists
        val combined = arrayList + arrayList2
        println("Combined Arraylist $combined")

        // arraylist is mutable using the add method
        val added = arrayList.add("T")
        if (added){
            println("Added item to arraylist")
            println("New arraylist $arrayList")
        }else{
            println("Add failed")
        }

        // Add at a particular index. If there is no index, outof bound exception occurs
        arrayList.add(2, "T")
        println("New arraylist $arrayList")


        // Remove element
        val removed = arrayList.remove("A") //Boolean response

        if (removed){
            println("removed")
            println("arraylist after removal $arrayList")
        }else{
            println("remove failed")
        }

        // Get a sublist from an array list, provide start index and end index (end index value wont be taken)
        val sublist = arrayList.subList(1,3)
        println("sublist $sublist")


        // Arrays Immutable

        var array = arrayOf(1,2,3,4)
        val mixedarray = arrayOf("String",1,2,false) // Any
        val array2 = arrayOf(5,6,7,8)
        val numbers = intArrayOf(1,2,3,4) // Only integers are possible

        //Combine arrays, you can combine 2 arrays of same type
        val combinedArray = array2 + array
        println(combinedArray[0])

        for ((index, item) in combinedArray.withIndex()){

            println("Item at $index is $item")
        }
        // To check if array is empty

        if (array.isEmpty()){

            println("Array is empty")
        }

        // To check if array contains a particular element

        if (array.contains(2)){

            println("Array contains 2")
        }

    }

    //Set
    //Set doesnt accept duplicate values....set add unique values.

    fun setSample(){
        val myCustomSet = HashSet<String>()

        myCustomSet.add("Hello")
        myCustomSet.add("Hello")
        val size = myCustomSet.size
        println("Size of set is $size")

    }

//Extension Functions
//
//Extensions are used to add a new behavior to a class eventhough we donot have access to the class's source code, it is similar to extensions in Swift. Extensions can be properties also.

    fun Fragment.show(message: CharSequence, duration: Int = Toast.LENGTH_SHORT){
        Toast.makeText(activity, message, duration).show()
    }
}









fun functions(){

//    fun <functionName>(<parameter>:<dataType>):<return datatype>{
//        return <return value>
//    }
    // Simple function

    fun hellokotlin(){

        println("Hello kotlin")
    }

// Function with parameters

    fun sayHelloTo(name: String){

        println("Hello" + name)
    }

// Function accepts parameters and returns String

    fun contructStringFrom(firstName:String, lastName:String):String{

        return firstName + lastName
    }

}




//Class
//
//Basic syntax of a class is as follows.
//
//class <ClassName>(Parameters for construction) {
//}
//
//By default a class is closed, to inherit from a class, it need to be defined as open
//
//open class <ClassName>(Parameters for construction): ParentClass {
//}
//
//For overriding properties of the parent class, the properties also need to be defined as open in the Parent class
//
//
//open class Vehicle(open val color:String,open var numberOfWheels:Int){
//
//}
//
//class Car(override val color: String, override var numberOfWheels: Int):Vehicle(color, numberOfWheels){
//
//}
//
//class Bike(override val color: String, override var numberOfWheels: Int):Vehicle(color, numberOfWheels){
//
//}

open class  Vehicle (open val color:String, open var numberofWheels: Int){

}

class Car(override val color:String, override var numberofWheels: Int):Vehicle(color, numberofWheels){

}
//Abstract Classes and Methods
//
//Abstract classes are used when we want to restrict the users from creating an instance of a class, in the above example we wont end up a scenario of creating a Vehicle object, its going to be only Car or bike or may be buses later.
//
//Abstract classes are implictly open
//
//Abstract methods are used when there is different implementation of the parent class method in the child class, so in the parent class only the declaration will be made and the child classes should implement the method.


abstract class Vehicle1(open val color:String,open var numberOfWheels:Int){

    open var whoAMI = "I am a vehicle"
    abstract var modelName:String

    abstract fun startEngine()
}

class Car1(override val color: String, override var numberOfWheels: Int):Vehicle1(color, numberOfWheels){
    override var modelName: String = "BMW123"

    override var whoAMI: String = "I am a Car"

    override fun startEngine() {

        Log.i("Kotlin","Starting a Car")
    }


}

class Bike1(override val color: String, override var numberOfWheels: Int):Vehicle1(color, numberOfWheels){
    override var modelName: String = "DUKE123"
    override fun startEngine() {

        Log.i("Kotlin","Starting a Bike")
    }

}

//Interface
//
//Interface defines a contract which the adhering classes should implement, its like protocols in Swift. Interfaces can be extended also like protocol extensions, they can contain abstract methods as well as method implementations. Properties can be declared in Interface but they need to abstact or can provide implementation for accessors. Interfaces cannot store state


interface Movable{

    var modelNumber:String
    fun startEngine()
}

class Car2( val color: String, var numberOfWheels: Int):Movable{
    override var modelNumber = "BMW123"


    override fun startEngine() {
        Log.i("Kotlin","Starting a Movable Car")
    }


}
class Bike2( val color: String, var numberOfWheels: Int):Movable{
    override var modelNumber: String = "DUKE123"


    override fun startEngine() {
        Log.i("Kotlin","Starting a Movable Bike")
    }

}


//Generics
//
//If you have a common functionality which need to handle multiple data types, we use generics.

class Generic<E>(t:E){

    val content = t


}
class Bus {
    fun startBus(){

        Log.i("Kotlin","Started")
    }
    fun stopBus(){
        Log.i("Kotlin","Stopped")

    }

    fun turnRight(){
        Log.i("Kotlin","Turning Right")
    }
    fun turnLeft(){
        Log.i("Kotlin","Turning Left")
    }
}

val myBus = Bus()







