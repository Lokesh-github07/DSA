<h1>Climbing Stairs</h1>

<h2>Problem</h2>

<p>
You are climbing a staircase. It takes <code>n</code> steps to reach the top.
</p>

<p>
Each time, you can either climb <strong>1 step</strong> or <strong>2 steps</strong>.
</p>

<p>
Given an integer <code>n</code>, return the number of distinct ways you can climb to the top.
</p>

<h3>Example 1</h3>

<pre>
Input:  n = 2
Output: 2
</pre>

<p>There are two ways to reach the top:</p>

<pre>
1 + 1
2
</pre>

<h3>Example 2</h3>

<pre>
Input:  n = 3
Output: 3
</pre>

<p>There are three ways to reach the top:</p>

<pre>
1 + 1 + 1
1 + 2
2 + 1
</pre>

<hr>

<h2>My Approach: Dynamic Programming</h2>

<p>
I went with a dynamic programming approach because the number of ways to reach
each step depends on the number of ways to reach the previous two steps.
</p>

<p>
To reach step <code>n</code>, the last move can either be:
</p>

<ol>
  <li>A <strong>1-step move</strong> from step <code>n - 1</code>.</li>
  <li>A <strong>2-step move</strong> from step <code>n - 2</code>.</li>
</ol>

<p>Therefore:</p>

<pre>
ways(n) = ways(n - 1) + ways(n - 2)
</pre>

<p>The base cases are:</p>

<pre>
ways(1) = 1
ways(2) = 2
</pre>

<p>For example:</p>

<pre>
n = 5

ways(1) = 1
ways(2) = 2
ways(3) = 3
ways(4) = 5
ways(5) = 8
</pre>

<p>
Instead of storing all the previous values in an array, I only keep the last
two values because they are enough to calculate the next result.
</p>

<pre>
class Solution {
    public int climbStairs(int n) {
        if (n &lt;= 2) {
            return n;
        }

        int first = 1;
        int second = 2;

        for (int i = 3; i &lt;= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }

        return second;
    }
}
</pre>

<p>
This approach avoids the extra memory required by a DP array while keeping
the solution simple and efficient.
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
      <td><code>O(n)</code></td>
      <td>We calculate the result for each step from <code>3</code> to <code>n</code>.</td>
    </tr>
    <tr>
      <td><strong>Space</strong></td>
      <td><code>O(1)</code></td>
      <td>Only a few integer variables are used.</td>
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
      <td>One step</td>
      <td><code>n = 1</code></td>
      <td><code>1</code></td>
    </tr>
    <tr>
      <td>Two steps</td>
      <td><code>n = 2</code></td>
      <td><code>2</code></td>
    </tr>
    <tr>
      <td>Three steps</td>
      <td><code>n = 3</code></td>
      <td><code>3</code></td>
    </tr>
    <tr>
      <td>Four steps</td>
      <td><code>n = 4</code></td>
      <td><code>5</code></td>
    </tr>
    <tr>
      <td>Five steps</td>
      <td><code>n = 5</code></td>
      <td><code>8</code></td>
    </tr>
    <tr>
      <td>Larger input</td>
      <td><code>n = 10</code></td>
      <td><code>89</code></td>
    </tr>
  </tbody>
</table>

<hr>

<h2>Other Ways to Solve It</h2>

<h3>Dynamic Programming with Array (O(n) Time, O(n) Space)</h3>

<p>
We can create a DP array where <code>dp[i]</code> represents the number of
ways to reach step <code>i</code>.
</p>

<pre>
dp[i] = dp[i - 1] + dp[i - 2]
</pre>

<p>
This approach is easy to understand, but it uses <code>O(n)</code> extra memory.
</p>

<h3>Recursion (O(2ⁿ) Time)</h3>

<p>
A recursive solution directly follows the recurrence:
</p>

<pre>
ways(n) = ways(n - 1) + ways(n - 2)
</pre>

<p>
However, without memoization, the same calculations are repeated many times,
making it inefficient for larger values of <code>n</code>.
</p>

<h3>Fibonacci Approach (O(n) Time, O(1) Space)</h3>

<p>
The number of ways follows a Fibonacci-like sequence:
</p>

<pre>
1, 2, 3, 5, 8, 13, 21, ...
</pre>

<p>
The optimized solution uses two variables to calculate this sequence without
storing every value.
</p>

<h3>Comparison</h3>

<table>
  <thead>
    <tr>
      <th>Approach</th>
      <th>Time</th>
      <th>Space</th>
      <th>Main Idea</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>Recursion</td>
      <td><code>O(2ⁿ)</code></td>
      <td><code>O(n)</code></td>
      <td>Recursively calculate previous steps</td>
    </tr>
    <tr>
      <td>DP Array</td>
      <td><code>O(n)</code></td>
      <td><code>O(n)</code></td>
      <td>Store the number of ways for every step</td>
    </tr>
    <tr>
      <td>Optimized DP</td>
      <td><code>O(n)</code></td>
      <td><code>O(1)</code></td>
      <td>Store only the previous two results</td>
    </tr>
  </tbody>
</table>

<hr>

<h2>What I Learned</h2>

<ul>
  <li>How to identify overlapping subproblems.</li>
  <li>How dynamic programming avoids repeated calculations.</li>
  <li>How the current result depends on the previous two results.</li>
  <li>How to reduce <code>O(n)</code> space to <code>O(1)</code>.</li>
  <li>How the Climbing Stairs problem follows a Fibonacci-like sequence.</li>
</ul>

<hr>

<h2>Takeaway</h2>

<p>
The Climbing Stairs problem is a simple introduction to
<strong>Dynamic Programming</strong>.
</p>

<p>
The key observation is that to reach step <code>n</code>, we must come from
either <code>n - 1</code> or <code>n - 2</code>.
</p>

<pre>
ways(n) = ways(n - 1) + ways(n - 2)
</pre>

<p>
By keeping only the previous two results, we can solve the problem in
<strong>O(n) time</strong> and <strong>O(1) space</strong>.
</p>
