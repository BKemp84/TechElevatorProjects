/*
    Example of a multi-line comment just like in C#/Java
*/

let name = 'John';
let hello = "Hello " + name;
hello = `Hello ${name}`;

const x = 10;
let y;
y = 20;
y = 'Hello';

let w;
y = undefined;
w = null;
w = 0/0;   // results in Not a Number (NaN)
console.log(w);
w = 1/0;  // results in Infinity
console.log(w); 
// Single line comment

/**
 * Functions start with the word function.
 * They don't have a return type and the naming convention is camel-case.
 */
function variables() {
  // Declares a variable where the value cannot be changed
  const daysOfWeek = 7;
  console.log(`There are ${daysOfWeek} days in the week.`);
  
  // Declares a variable those value can be changed
  let daysPerMonth = 30;
  console.log('There are ' + daysPerMonth + ' days in the month.');
  
  // Declares a variable that will always be an array
  //const weekdays = [];  // defines an empty array
  const weekdays = [ 
          'Monday', 
          'Tuesday', 
          'Wednesday', 
          'Thursday', 
          'Friday',
          'Saturday',
          'Sunday' 
  ];
  console.log(weekdays);
  console.table(weekdays);
}

/**
 * Functions can also accept parameters.
 * Notice the parameters do not have types.
 * @param {Number} param1 The first number to display
 * @param {Number} param2 The second number to display
 */
function printParameters(param1, param2) {
  console.log(`The value of param1 is ${param1}`);
  console.log(`The value of param2 is ${param2}`);
}
//parseInt('1') + 1;
/**
 * Compares two values x and y.
 * == is loose equality
 * === is strict equality
 * @param {Object} x
 * @param {Object} y
 */
function equality(x, y) {
  console.log(`x is ${typeof x}`);
  console.log(`y is ${typeof y}`);

  console.log(`x == y : ${x == y}`); // true
  console.log(`x === y : ${x === y}`); // false
}

/**
 * Each value is inherently truthy or falsy.
 * false, 0, '', null, undefined, and NaN are always falsy
 * everything else is always truthy
 * @param {Object} x The object to check for truthy or falsy,
 */
function falsy(x) {
  if (x) {
    console.log(`${x} is truthy`);
  } else {
    console.log(`${x} is falsy`);
  }
}

function arrays() {
  const myArray = [];
  myArray.push(1);
  myArray.push('Hello');
  myArray.push(true);

  console.table(myArray);

  myArray.pop();
  console.table(myArray);

  myArray.unshift(15);
  console.table(myArray);

  
}

/**
 *  Objects are simple key-value pairs
    - values can be primitive data types
    - values can be arrays
    - or they can be functions
*/
function objects() {
  const person = {
    firstName: "Bill",
    lastName: "Lumbergh",
    age: 42,
    employees: [
      "Peter Gibbons",
      "Milton Waddams",
      "Samir Nagheenanajar",
      "Michael Bolton"
    ],
    toString: function() {
      return `${this.lastName}, ${this.firstName} ${this.age}`;
    }
  };

  // Log the object
  console.log(person);
  console.table(person);
  // Log the first and last name
  console.log(`${ person.firstName } ${ person.lastName }`);
  console.log(person['firstName']);
  // Log each employee
  for (let i = 0; i < person.employees.length; i++) {
    console.log( `Employee ${i + 1} is ${ person.employees[i] }`);
  }
  console.log(person.toString);  // prints the source of the function
  console.log(person.toString());  // executes the function
}

/*
########################
Function Overloading
########################

Function Overloading is not available in Javascript. If you declare a
function with the same name, more than one time in a script file, the
earlier ones are overriden and the most recent one will be used.
*/

function Add(num1, num2) {
  return num1 + num2;
}

function Add(num1, num2, num3) {
  return num1 + num2 + num3;
}

// function Add() {
//   return 'test';
// }

/*
########################
Math Library
########################

A built-in `Math` object has properties and methods for mathematical constants and functions.
*/

function mathFunctions() {
  console.log("Math.PI : " + Math.PI);
  console.log("Math.LOG10E : " + Math.LOG10E);
  console.log("Math.abs(-10) : " + Math.abs(-10));
  console.log("Math.floor(1.99) : " + Math.floor(1.99));
  console.log("Math.ceil(1.01) : " + Math.ceil(1.01));
  console.log("Math.random() : " + Math.random());

  // isNaN
  console.log('Is 1 Not A Number ' + isNaN(1) );
  console.log('Is 0/0 Not A Number ' + isNaN(0/0) );
  console.log('Is 1/0 Not A Number ' + isNaN(1/0) );
  console.log('Is a Not A Number ' + isNaN('a') );
}

/*
########################
String Methods
########################

The string data type has a lot of properties and methods similar to strings in Java/C#
*/

function stringFunctions(value) {
  console.log(`.length -  ${value.length}`);
  console.log(`.endsWith('World') - ${value.endsWith("World")}`);
  console.log(`.startsWith('Hello') - ${value.startsWith("Hello")}`);
  console.log(`.indexOf('Hello') - ${value.indexOf("Hello")}`);

  // substr( starting_index, number_of_characters ) 
  console.log(`.substr(1, 3) - ${value.substr(1, 3)}`);
  // substring (starting_index_inclusive, ending_index_exclusive )
  console.log(`.substring(1, 3) - ${value.substring(1, 3)}`);

  /*
    Other Methods
        - split(string)
        - substr(number, number)
        - substring(number, number)
        - toLowerCase()
        - trim()
        - https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/String
    */
}
