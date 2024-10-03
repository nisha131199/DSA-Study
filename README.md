# DSA-Study

## Content
```
1. Searching technique
2. Sorting technique
3. String
4. Patterns
5. Recursion
```


### Linear Search
```
finding the target from 0 till n -1 index
```

### Binary Search
```
Workaround: find the mid and search for target
```

```
Topics
1. Simple BS
2. Ceiling & Floor BS
3. First & last occurrence in BS
4. Searching in infinite list i.e., length is not given
5. Mountain searching
6. Rotation BS
7. Splitting into `m` sub arrays
8. Target in matrix
```


```
- Find order
- loop while start <= end
- mid = start + (end - start)/2 ==> (start + end)/2
- if mid == target return mid
- else if mid < target ==> start = mid + 1
- else end = mid - 1
- return -1 when start > end that means we're unable to find the target
```


### Sorting
1. Bubble sort
```
compare two numbers and swap them & go ahead till end to bring the highest int the last position
```
2. Selection Sort
```
select the highest among all the numbers; then place in the last index
```
3. Insertion Sort
```
take left side elements & sort them; then take next element to sort it with left sorted array
```
4. Cyclic Sort
```
when range is 0-n or 1-n its correct position will be element+1 or element itself
```

#### Stable sorting: Original order is maintained for more than one equal values eg: {1, 1(red), 2, 3}
#### Unstable sorting: If the original order is not maintained eg: {1(red), 1, 2, 3}


### String
```
1. String values are stored in string pool inside heap memory
2. string pool: separate memory structured inside heap memory
3. String pool don’t let the same string value to be created again and again but let the reference point to it
4. And any change in the value won’t reflect on it but instead it will create & store new value & the last one will point by other reference variables(if any)
5. Strings are immutable so any change will lead to creating new object in string pool
6. They are immutable because of security purpose
```

### String builder: mutable string data type


### Patterns
1. increase to decrease pattern
2. decrease to increase pattern
3. prism
4. square

### Recursion
```
What & Why recursion?
- calling itself function to perform same work with different values
- help to solve bigger/complex problem in a simpler way
- convert recursion to iteration or vice-e-versa
- space complexity: O(n)
- when you write the recursion in a formula = recurrence relation
```

```
Step 1: identify if you can break the problem into small pieces
Step 2: write the recurrence relation if possible
Step 3: Draw recursion tree
Step 4: About the tree
    - check the flow of function & how they're get store in stack
    - identify & focus on left tree calls & right tree calls
    - draw tree & pointer again & again using pen & paper
    - use debugger to check the flow
Step 5: see how the value returned at each step & see where the function call get come out

```

#### 1. Linear recurrence relation: Fibonacci
Cons : Repeated functions being called here, takes much time

**Dynamic programing**: If in recursion two or more recursion function being called to do the same work don't compute again & again

#### 2. Divide & conquer recurrence relation: Binary search because it gets reduce by a factor

#### 3. Sorting techniques with recursion
#### 4. Subsets
#### 5. Maze problems



