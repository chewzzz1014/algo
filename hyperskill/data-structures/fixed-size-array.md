In programs, data is represented in the form of numbers, characters, strings, or other more complex objects. Often, some of these objects can be naturally grouped together. For example, assume that you conducted an experiment and got some measurements. They might correspond to temperature, distance, time, or something else. In such a case, it would be convenient not to store each measurement as a separate variable, but to process all of them together as a single unit. This will neatly organize our experimental observations, allowing us to analyze them quickly.

To efficiently deal with such cases, most programming languages provide a structure called a fixed-size array. The structure allows us to sequentially store a collection of elements of the same type and process them as a single unit. In this topic, we will look at this structure in more detail and learn some basic operations used for arrays.

## Fixed-size array 
A fixed-size array is a structure for storing a collection of elements of the same type. As you can guess from its name, the size of such an array is a constant: once an array is created, you can't change its size. While creating a fixed-size array, we declare its size. The computer then reserves necessary memory resources for the array. After that, the elements of a fixed-size array are stored sequentially into those memory addresses. Given below is an example of a fixed-size array that stores five floating-point numbers:

![image](https://user-images.githubusercontent.com/92832451/187616909-ae109b19-d361-42fa-8566-dc569bf70de3.png)


Arrays have some of technical characteristics. To begin with, the size of an array indicates how many elements the array contains. It is also referred to as the length of an array. The length of both of our previous arrays is 5.

The index of an element is a number that tells us where the element resides within the array. For most programming languages, the counting starts at 000. The first element of the first array is 10.810.810.8 and its index is 000, the second one is 14.314.314.3 with the index of 111. The last element is 9.79.79.7 with the index of 444. The same rule applies to the second array as well.

Using pseudocode, we can represent the first array as follows:

```measurements = [10.8, 14.3, 13.5, 12.1, 9.7]```

A variable named measurements combines the numbers in a single unit.

## Accessing elements

Programming languages provide a set of standard methods for array processing. There is one of them used most frequently. It is a method for accessing an element by its index. Let's try and access the third element of the measurementmeasurementmeasurement array and store it in a new variable valuevaluevalue.

![image](https://user-images.githubusercontent.com/92832451/187617043-029184f9-bed8-429c-bb26-af905d5d5cfe.png)

Both reading and modifying operations require O(1)O(1)O(1) time complexity. It's so efficient, because by knowing the index number, the computer can jump directly to the required memory address and fetch or modify the data.

## Inserting and deleting elements

In short, inserting an element into a fixed-size array or deleting an element from the array is not possible. This is mainly because those operations would change the length of the array and it would no longer be a fixed-size array.

Still, you may want to add one more flower named DaisyDaisyDaisy to the array of flowers mentioned earlier. There's a way to do so! After inserting, the length of our new array will be 666. Thus, you need to create another array with the length 666, and copy all the five elements from the first array to the new array. There will be a spot left in your new array. Fill it up with the new flower name. You can do the same trick for deleting an element as well.

![image](https://user-images.githubusercontent.com/92832451/187617141-8dcabc96-8cd0-422d-9553-043aa5557b81.png)


This operation requires O(n) time complexity, where nnn is the number of elements of the array, since we have to copy all nnn elements to our new array. In sense of performance, inserting and deleting are very slow operations for a fixed-size array. To overcome this limitation, programmers have introduced dynamic arrays that you will learn about later.

On the flip side, the inability to modify the size is a strong characteristic of a fixed-size array. Nothing can affect our array's length. In the example above, we've added a new flower name to the array, but still, our old array remains as it is. Thus, it is wise to use a fixed-size array when changing the array length may negatively affect your program.

Along with these operations, there are some other more sophisticated methods for array processing, such as sorting, reversing, searching elements, and others. When you use a particular programming language, check the documentation of the standard library to see what methods the language provides.

## Example

Let's consider a simple example of how to process arrays. Given an array of numbers, our task will be to calculate the mean value of the elements in the array. The mean of the array elements is the sum of all array elements divided by their number. We will consider how it can be done for our array of measurements:

```measurements = [10.8, 14.3, 13.5, 12.1, 9.7]```

The procedure is the following:

We initialize the variable sumsumsum with the value 0. Then, we sequentially read the elements of the measurement array using the index numbers from zero up to the array length minus one, which is the index of the last element, and add them to the sum variable. After that, we divide the obtained sum by the length of the array and thus get the mean value for the elements. The length of the array of measurements is known in advance.

Here is the pseudocode of the process:

```
sum = 0

for i from 0 to (len(measurements)- 1):
    sum = sum + measurements[i]

mean = sum / len(measurements) # 12.08
```

Here, len(measurements) will return the length of the measurements array. 





