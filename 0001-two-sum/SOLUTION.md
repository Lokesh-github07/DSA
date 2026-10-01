# Two Sum

## Problem

Given an integer array `nums` and an integer `target`, return the indices of the two numbers that add up to the target.

Each input has exactly one solution, and the same element can't be used twice.

**Example**

```text
Input:  nums = [2, 7, 11, 15], target = 9
Output: [0, 1]
```

Because `nums[0] + nums[1] = 2 + 7 = 9`.

---

## My Approach: Brute Force

I went with brute force because it's the most straightforward way to solve this: check every possible pair and return the first one that adds up to the target.

1. Pick an element at index `i`.
2. Compare it with every element after it (index `j`).
3. If `nums[i] + nums[j] == target`, return `[i, j]`.
4. Otherwise, move on to the next `i`.

The inner loop starts at `i + 1`, so the same element is never used twice and no pair is checked more than once.

```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }
}
```

It needs no extra data structure, which keeps it simple. The downside is that it gets slow on large arrays.

---

## Complexity

| | Complexity | Why |
|---|---|---|
| **Time** | `O(n²)` | Two nested loops, so in the worst case almost every pair is checked |
| **Space** | `O(1)` | No extra memory used |

---

## Edge Cases I Tested

| Case | Input | Target | Output |
|---|---|---|---|
| Duplicate values | `[3, 3]` | `6` | `[0, 1]` |
| Negative numbers | `[-3, 4, 3, 90]` | `0` | `[0, 2]` |
| Negative target | `[-1, -2, -3, -4]` | `-6` | `[1, 3]` |
| Mixed signs | `[-10, 5, 15, 20]` | `5` | `[0, 2]` |
| Pair at the end | `[1, 2, 3, 7]` | `10` | `[2, 3]` |

---

## Other Ways to Solve It

### HashMap (O(n) time, O(n) space)

Instead of checking every pair, store the numbers you've already seen. For each number, compute `complement = target - current` and check whether it's already in the map.

For `nums = [2, 7, 11, 15]` and `target = 9`, when we reach `7` the complement is `9 - 7 = 2`. Since `2` is already stored, we have our answer.

### Sorting + Two Pointers (O(n log n) time)

Sort the array, then move a `left` pointer and a `right` pointer inward depending on whether the sum is too small or too big. Since the problem asks for the **original indices**, you have to keep track of each number's position before sorting, which costs extra space.

### Comparison

| Approach | Time | Space | Main Idea |
|---|---|---|---|
| Brute Force | `O(n²)` | `O(1)` | Check every pair |
| HashMap | `O(n)` | `O(n)` | Store numbers, look up the complement |
| Sorting + Two Pointers | `O(n log n)` | `O(n)` | Sort, then close in from both ends |

---

## What I Learned

- How to use nested loops to find pairs in an array.
- How to avoid reusing the same element.
- How the choice of approach changes time complexity.
- How a `HashMap` can speed up a brute-force solution by trading memory for time.

---

## Takeaway

Brute force is simple and uses constant extra space, but it runs in `O(n²)`. The HashMap approach brings that down to `O(n)` at the cost of `O(n)` extra memory. For small inputs either works, but for larger ones the HashMap is the better choice.
