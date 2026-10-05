<h1>LeetCode 11 — Container With Most Water</h1>

<h2>🧠 Approach</h2>

<p>
This problem is solved using the <strong>Two Pointer Algorithm</strong>.
</p>

<p>
We use two pointers:
</p>

<ul>
  <li><code>left</code> → starts at the beginning of the array</li>
  <li><code>right</code> → starts at the end of the array</li>
</ul>

<p>
The area of the container is calculated using:
</p>

<pre><code>Area = (right - left) × min(height[left], height[right])</code></pre>

<p>
After calculating the area, we move the pointer with the
<strong>smaller height</strong>, because the shorter line limits
the amount of water.
</p>

<h2>💻 Java Solution</h2>

<pre><code>class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxWater = 0;

        while (left &lt; right) {
            int width = right - left;
            int currentHeight = Math.min(height[left], height[right]);

            int area = width * currentHeight;
            maxWater = Math.max(maxWater, area);

            if (height[left] &lt; height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxWater;
    }
}</code></pre>

<h2>📌 Example</h2>

<pre><code>Input:
height = [1,8,6,2,5,4,8,3,7]

Output:
49</code></pre>

<h2>⏱️ Complexity</h2>

<table>
  <tr>
    <th>Complexity</th>
    <th>Value</th>
  </tr>
  <tr>
    <td>Time</td>
    <td>O(n)</td>
  </tr>
  <tr>
    <td>Space</td>
    <td>O(1)</td>
  </tr>
</table>

<h2>🔑 Key Idea</h2>

<p>
The <strong>shorter line determines the maximum possible height</strong>
of the container. Therefore, we always move the pointer pointing to
the shorter line.
</p>

<p>
<strong>Algorithm:</strong> Two Pointers + Greedy
</p>
