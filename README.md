Implement a function that converts a hexadecimal number (as a string) into a binary number (as a string).
Write a test for this.  Bonus: Also implement the inverse function (binary -> hexadecimal)
========

Analysis
========
Adopt a functional approach to parse each digit of a hexadecimal or binary string to a base 10 representation.

Implementation
========
Use a fold to iteratively perform radix conversion within a long to allow 64 bit headroom (not arbitrary length
values). Use RichLong toXXXString to perform final conversion from long to target radix.

Invocation
=======
As scalatest test from IDE.

Quick screen shot confirming correct matching:
https://gyazo.com/469006c4ab26d23a00ebe08ee7b82960