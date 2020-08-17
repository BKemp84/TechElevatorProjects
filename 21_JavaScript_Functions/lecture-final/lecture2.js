function greeting(name) {
    console.log("Hello " + name);
}

/*
* Spread Operator 
*/
function multipleWithSpread(x, y, z) {
    return x * y * z;
}

let args = [1, 2, 3];

// The ... spread operator populates each argument from one from the array
console.log( multipleWithSpread( ...args ) );

function addLetters(a, b, c, d) {
    return a + b + c + d;
}

const str = "JavaScript";
console.log( addLetters(...str) );

/*
* Scope
*/

// Global Scope - should be declared at top of file
const firstName = "John";

// Block Scope
if (true) {
    let blockScopeLet = "John";
    //let blockScopeLet = "Matt";  // <-- compile time error because let/const cannot be redefined in the same scope
    var blockScopeVar = "Steve";
}
var blockScopeVar = "Matt"; // <-- var can be redefined in the same scope
//greeting(blockScopeLet); // <-- error because variable is not in this scope
greeting(blockScopeVar); // <-- works because var ignores block scope

// function scope
function scope() {
    let functionScopeLet = "John";
    var functionScopeVar = "Steve";
}
//greeting(functionScopeLet);  <-- error because functionScopeLet is not in this scope
//greeting(functionScopeVar); <-- error because var obeys function scope


/*
* Anonymous Functions
*/

// Can define with function keyword and no name
const doubleSum = function (x, y) {
    return (x + y) * 2;
}

doubleSum(2,4);
// Can assign to different variable
const xyz = doubleSum;
xyz(2, 4);

// Can define without the function word using the paramters and arrow operator
const tripleSum = (x, y) => {
    return (x + y) * 3;
}

// Can skip the () if only 1 parameter
const tripleNum = x => {
    return x * 2;
}

/*
*  Array reduce()
*/

const arr = [1, 2, 3, 4, 5, 6, 7, 8, 9 , 10];

let finalSum = arr.reduce( (sum, val) => {
    return sum + val;
} );

console.log('the sum is ' +  finalSum );

// function reduceManually( arr2 ) {
//     let sum = 0;
//     for (let i = 0 ; i < arr2.length; i++) {
//         let val = arr2[i];
//         sum = ourReductionMethod( sum, arr2[i], i, arr2);
//     }
//     return sum;
// }

// function ourReductionMethod(sum, val) {
//     return sum + val;
// }


// Same code long form
function reduceManually( arr2 ) {
    let sum = 0;
    for (let i = 0 ; i < arr2.length; i++) {
        let val = arr2[i];
        sum = sum + val;
    }
    return sum;
}

// Arrays of any data type can be reduced
let finalSum2 = reduceManually(arr);

const stringArr = ['Hello ', 'John, ', 'Matt, ', 'Rachelle, ', 'and Steve'];

let joinedStrings = stringArr.reduce( (str, val) => {
    return str + val;
});

console.log( joinedStrings );

// functions held in variables can be used instead of an anonymous function
// written in place.
const addTogether = (agg, val) => {
    return agg + val;
}

console.log( arr.reduce(addTogether) );
console.log( stringArr.reduce( addTogether) );

// A more complicated reduction
let firstLetters = stringArr.reduce( (letters, val, i) => {
    let first = '';
    if (i % 2 != 0) {
        first = val.substr(0,1);
    }
    return letters + first;
});
console.log(firstLetters);

// Filter - create a new array of the values when the anonymous 
// method returns true
let newArr = arr.filter( val => {
    return val % 3 == 0;
});

console.table(arr);
console.table(newArr);

// Map - creates a new array with every index with the value at that
// index as returned by the anonymous function
let newArrFromMap = arr.map( val => {
    if (val % 3 == 0) {
        return val;
    }
    return 'Not Multiple';
});
console.table(newArrFromMap);

// Using Map to uppercase all long names and lowercase all short names
let longNamesMap = stringArr.map( name => {
    if (name.length > 7) {
        return name.toUpperCase();
    }
    return name.toLowerCase();
})
console.table(longNamesMap);


// Create an array to do FizzBuzz with
const fizzArr = [];
for (let i = 1; i <= 100; i++) {
    fizzArr[i - 1] = i;
}
//console.log(fizzArr);

// FizzBuzz using Map
const fizzBuzzed = fizzArr.map ( val => {
    if (val % 3 == 0 && val % 5 == 0) {
        return "FizzBuzz";
    }
    if (val % 3 == 0) {
        return "Fizz";
    }
    if (val % 5 == 0) {
        return "Buzz";
    }
    return val;
});
console.log(fizzBuzzed);


/*
* Anonymous functions as arguments to our methods
*/

function doMath(x, y, func) {
    const result = func(x, y);
    console.log("The math results is " + result);
}

doMath(2, 4, (x, y) => { return x + y; });
doMath(2, 4, (x, y) => { return x - y; });

doMath(2, 4, doubleSum);

doMath(-20, 5, (x, y) => {
    const distance = Math.abs(x - y);
    const power3 = Math.pow(distance, 3);
    return power3;
});

/* Functional methods can be chained */

function functionAsParam(array, filterFunc) {
    return array.filter(filterFunc).map( val => {
        return 'A' + val;
    });
}

console.table( functionAsParam( arr, num => { return num % 2 == 0; }));
console.table( functionAsParam( arr, num => { return num % 3 == 0; }));

console.table( functionAsParam( stringArr, val => { return val.length < 7; }));



const resultArr2 = fizzArr.map ( val => {
    if (val % 3 == 0 && val % 5 == 0) {
        return "FizzBuzz";
    }
    if (val % 3 == 0) {
        return "Fizz";
    }
    if (val % 5 == 0) {
        return "Buzz";
    }
    return val;
}).filter( val => {
    return typeof val == 'number';
}).reduce( (sum, val) => {
    return sum + val;
});

console.log(resultArr2);