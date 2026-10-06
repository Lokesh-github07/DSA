<h1>Plus One</h1>

<h2>Problem</h2>

<p>
Given an integer represented as an array of digits, add <code>1</code> to the
integer and return the resulting array of digits.
</p>

<p><b>Example</b></p>

<pre>
Input:  digits = [1,2,3]
Output: [1,2,4]
</pre>

<p>
Because <code>123 + 1 = 124</code>.
</p>

<hr>

<h2>My Approach: Right-to-Left Traversal</h2>

<p>
I start from the last digit because that's where the <code>+1</code> needs to
be added. If the digit is less than <code>9</code>, I simply increase it and
return the array.
</p>

<p>
If the digit is <code>9</code>, it becomes <code>0</code> and the carry moves
to the next digit on the left. This continues until we find a digit that is
less than <code>9</code>.
</p>

<p>
If every digit is <code>9</code>, we need an extra digit at the beginning.
For example, <code>[9,9,9]</code> becomes <code>[1,0,0,0]</code>.
</p>

<pre><code>class Solution {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i &gt;= 0; i--) {

            if (digits[i] &lt; 9) {
                digits[i]++;
                return digits;
            }

            digits[i] = 0;
        }

        int[] result = new int[digits.length + 1];
        result[0] = 1;

        return result;
    }
}</code></pre>

<p>
The main idea is similar to doing addition normally: start from the right,
handle the carry, and move towards the left.
</p>

<hr>

<h2>Complexity</h2>

<table>
  <tr>
    <th></th>
    <th>Complexity</th>
    <th>Why</th>
  </tr>
  <tr>
    <td><b>Time</b></td>
    <td><code>O(n)</code></td>
    <td>In the worst case, every digit is processed.</td>
  </tr>
  <tr>
    <td><b>Space</b></td>
    <td><code>O(1)</code></td>
    <td>No extra space is needed normally; <code>O(n)</code> for the all-9 case.</td>
  </tr>
</table>

<hr>

<h2>Edge Cases I Tested</h2>

<table>
  <tr>
    <th>Case</th>
    <th>Input</th>
    <th>Output</th>
  </tr>
  <tr>
    <td>Normal number</td>
    <td><code>[1,2,3]</code></td>
    <td><code>[1,2,4]</code></td>
  </tr>
  <tr>
    <td>Last digit is 9</td>
    <td><code>[1,2,9]</code></td>
    <td><code>[1,3,0]</code></td>
  </tr>
  <tr>
    <td>Multiple 9s</td>
    <td><code>[1,9,9]</code></td>
    <td><code>[2,0,0]</code></td>
  </tr>
  <tr>
    <td>All digits are 9</td>
    <td><code>[9,9,9]</code></td>
    <td><code>[1,0,0,0]</code></td>
  </tr>
  <tr>
    <td>Single digit</td>
    <td><code>[5]</code></td>
    <td><code>[6]</code></td>
  </tr>
</table>

<hr>

<h2>Other Ways to Solve It</h2>

<h3>Convert to an Integer</h3>

<p>
You could convert the array into a number, add <code>1</code>, and convert it
back. However, this isn't suitable because the input can represent a number
too large for Java's normal integer types.
</p>

<h3>Carry Simulation</h3>

<p>
The approach used here is essentially carry simulation. Instead of converting
the entire array into a number, we directly handle the carry digit by digit.
This is the preferred approach because it works for numbers of any size.
</p>

<hr>

<h2>What I Learned</h2>

<ul>
  <li>How to process an array from right to left.</li>
  <li>How carry propagation works in addition.</li>
  <li>How to handle cases where every digit is <code>9</code>.</li>
  <li>Why converting a large digit array into an integer is not a good approach.</li>
</ul>

<hr>

<h2>Takeaway</h2>

<p>
Start from the last digit. If it's less than <code>9</code>, increment it and
finish. If it's <code>9</code>, turn it into <code>0</code> and carry
<code>1</code> to the left. If all digits are <code>9</code>, create a new
array with <code>1</code> at the beginning.
</p>
