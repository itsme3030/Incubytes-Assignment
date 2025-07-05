# String Calculator
This repository contains a Test-Driven Development (TDD) implementation of a **String Calculator**, developed as part of the **Software Craftsperson Assessment** by **Incubyte**.


Implement a method `add(String numbers)` that returns the sum of numbers passed in a string.  
The input string can contain:
1) Empty string → should return 0  
2) One or more numbers separated by **commas (`,`)**
3) Newline characters (`\n`) as additional separators
4) Optional **custom delimiter** at the beginning in the format: `//<delimiter>\n<numbers>`
5) If any **negative numbers** are present, the method should **throw an exception**, mentioning _all_ negative numbers.


## Test Cases Covered

---

### 1. Empty Input Returns Zero
- **Input:** `""`  
- **Expected Output:** `0`

---

### 2. Invalid Comma Usage Throws
- **Input:** `"1,,2"`  
- **Expected Output:**  `RuntimeException`

---

### 3. Invalid Newline Usage Throws
- **Input:** `"3,\n4"`  
- **Expected Output:**  `RuntimeException`

---

### 4. Sum of Comma-Separated Numbers
- **Input:** `"2,4,8"`  
- **Expected Output:** `14`

---

### 5. Empty Input with Custom Delimiter Returns Zero
- **Input:** `"//;\n"`  
- **Expected Output:** `0`

---

### 6. Sum Using Custom Delimiter
- **Input:** `"//;\n2;3;5"`  
- **Expected Output:** `10`

---

### 7. Multiple Negatives Throw Exception
- **Input:** `"5,-1,6,-2"`  
- **Expected Output:**  `negative numbers not allowed <-1,-2>`

---

### 8. Negatives with Custom Delimiter Throw
- **Input:** `"//#\n3#-4#7#-6"`  
- **Expected Output:**  `negative numbers not allowed <-4,-6>`

---

## 🧾 Image of final Output after testcase passing
---
