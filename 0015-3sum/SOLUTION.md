# 3Sum

<h2>Problem</h2>

<p>
Given an integer array <code>nums</code>, return all the triplets
<code>[nums[i], nums[j], nums[k]]</code> such that:
</p>

<ul>
  <li><code>i != j</code>, <code>i != k</code>, and <code>j != k</code>.</li>
  <li><code>nums[i] + nums[j] + nums[k] == 0</code>.</li>
</ul>

<p>
The solution set must not contain duplicate triplets.
</p>

<h3>Example 1</h3>

<pre>
Input:  nums = [-1, 0, 1, 2, -1, -4]
Output: [[-1, -1, 2], [-1, 0, 1]]
</pre>

<h3>Example 2</h3>

<pre>
Input:  nums = [0, 1, 1]
Output: []
</pre>

<h3>Example 3</h3>

<pre>
Input:  nums = [0, 0, 0]
Output: [[0, 0, 0]]
</pre>

<hr>

<h2>My Approach: Sorting + Two Pointers</h2>

<p>
I used the sorting and two-pointer technique to find all unique triplets
whose sum equals zero. Sorting the array allows me to adjust the pointers
efficiently and skip duplicate values.
</p>

<h3>Algorithm</h3>

<ol>
  <li>Sort the array in ascending order.</li>
  <li>Iterate through the array and fix one element at index <code>i</code>.</li>
  <li>Initialize <code>left = i + 1</code> and <code>right = nums.length - 1</code>.</li>
  <li>Calculate the sum of the three selected elements.</li>
  <li>If the sum is zero, add the triplet to the result and move both pointers.</li>
  <li>If the sum is less than zero, move the left pointer forward.</li>
  <li>If the sum is greater than zero, move the right pointer backward.</li>
  <li>Skip duplicate values to avoid adding the same triplet more than once.</li>
</ol>

<h3>Java Solution</h3>

<pre>
import java.util.*;

class Solution {
    public List&lt;List&lt;Integer&gt;&gt; threeSum(int[] nums) {
        List&lt;List&lt;Integer&gt;&gt; result = new ArrayList&lt;&gt;();

        Arrays.sort(nums);

        for (int i = 0; i &lt; nums.length - 2; i++) {
            if (i &gt; 0 &amp;&amp; nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left &lt; right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    result.add(Arrays.asList(
                        nums[i], nums[left], nums[right]
                    ));

                    left++;
                    right--;

                    while (left &lt; right
                            &amp;&amp; nums[left] == nums[left - 1]) {
                        left++;
                    }

                    while (left &lt; right
                            &amp;&amp; nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else if (sum &lt; 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result;
    }
}
</pre>

<h3>Example Walkthrough</h3>

<pre>
Input: [-1, 0, 1, 2, -1, -4]

After sorting:
[-4, -1, -1, 0, 1, 2]

Unique triplets:
[-1, -1, 2]
[-1,  0, 1]

Output:
[[-1, -1, 2], [-1, 0, 1]]
</pre>

<p>
Sorting makes it possible to move the left pointer when the sum is too small
and the right pointer when the sum is too large.
</p>

<hr>

<h2>Complexity</h2>

<table>
  <thead>
    <tr>
      <th>Complexity</th>
      <th>Value</th>
      <th>Why</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td><strong>Time</strong></td>
      <td><code>O(n²)</code></td>
      <td>Sorting takes <code>O(n log n)</code>, followed by a two-pointer search for each element.</td>
    </tr>
    <tr>
      <td><strong>Space</strong></td>
      <td><code>O(1)</code> auxiliary space</td>
      <td>The algorithm uses a constant number of variables, excluding the output and sorting implementation details.</td>
    </tr>
  </tbody>
</table>

<hr>

<h2>Edge Cases I Tested</h2>

<table>
  <thead>
    <tr>
      <th>Case</th>
      <th>Input</th>
      <th>Output</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>Fewer than three elements</td>
      <td><code>[1, 2]</code></td>
      <td><code>[]</code></td>
    </tr>
    <tr>
      <td>No valid triplet</td>
      <td><code>[0, 1, 1]</code></td>
      <td><code>[]</code></td>
    </tr>
    <tr>
      <td>All zeros</td>
      <td><code>[0, 0, 0]</code></td>
      <td><code>[[0, 0, 0]]</code></td>
    </tr>
    <tr>
      <td>Duplicate values</td>
      <td><code>[-1, 0, 1, 2, -1, -4]</code></td>
      <td><code>[[-1, -1, 2], [-1, 0, 1]]</code></td>
    </tr>
    <tr>
      <td>All positive values</td>
      <td><code>[1, 2, 3, 4]</code></td>
      <td><code>[]</code></td>
    </tr>
    <tr>
      <td>Multiple valid triplets</td>
      <td><code>[-2, 0, 1, 1, 2]</code></td>
      <td><code>[[-2, 0, 2], [-2, 1, 1]]</code></td>
    </tr>
  </tbody>
</table>

<hr>

<h2>Other Ways to Solve It</h2>

<h3>Brute Force (O(n³) Time)</h3>

<p>
Check every possible combination of three elements and add the triplets
whose sum equals zero. Duplicate triplets must be removed separately.
This approach is simple but inefficient for large arrays.
</p>

<h3>HashSet Approach (Average O(n²) Time)</h3>

<p>
Fix one element and use a hash set to find pairs that complete the sum to
zero. A set of triplets can be used to eliminate duplicates. This approach
can achieve average <code>O(n²)</code> time, but requires additional memory.
</p>

<h3>Sorting + Two Pointers (O(n²) Time)</h3>

<p>
The optimized approach sorts the array and searches for pairs using two
pointers. It avoids the extra hash set and skips duplicates directly
during traversal.
</p>

<h3>Comparison</h3>

<table>
  <thead>
    <tr>
      <th>Approach</th>
      <th>Time</th>
      <th>Extra Space</th>
      <th>Main Idea</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>Brute Force</td>
      <td><code>O(n³)</code></td>
      <td>Depends on duplicate handling</td>
      <td>Check every triplet</td>
    </tr>
    <tr>
      <td>HashSet</td>
      <td><code>O(n²)</code> average</td>
      <td><code>O(n)</code> or more</td>
      <td>Find complementary pairs</td>
    </tr>
    <tr>
      <td>Sorting + Two Pointers</td>
      <td><code>O(n²)</code></td>
      <td><code>O(1)</code> auxiliary, excluding sorting details</td>
      <td>Sort and move pointers based on the sum</td>
    </tr>
  </tbody>
</table>

<hr>

<h2>What I Learned</h2>

<ul>
  <li>How sorting helps simplify array problems.</li>
  <li>How to use two pointers to find pairs efficiently.</li>
  <li>How to skip duplicate values without using an additional set.</li>
  <li>How to optimize a brute-force <code>O(n³)</code> solution to <code>O(n²)</code>.</li>
  <li>How to combine sorting with pointer-based searching.</li>
</ul>

<hr>

<h2>Takeaway</h2>

<p>
The 3Sum problem is a useful application of <strong>Sorting + Two Pointers</strong>.
</p>

<p>
By fixing one element and finding two other elements whose sum is its
negative, we can identify all unique triplets efficiently.
</p>

<pre>
nums[i] + nums[left] + nums[right] == 0
</pre>

<p>
The optimized solution runs in <strong>O(n²) time</strong> and uses
<strong>O(1) auxiliary space</strong>, excluding the output and sorting implementation details.
</p>
