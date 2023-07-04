# Partitions with Given Difference
## Medium
<div class="problems_problem_content__Xm_eO"><p><span style="font-size: 18px;">Given an array arr, partition it into two subsets(possibly empty) such that their union is the original array. Let the sum of the element of these two subsets be S1 and S2.&nbsp;</span></p>
<p><span style="font-size: 18px;">Given a difference d, count the number of partitions in which S1 is greater than or equal to S2 and the difference S1 and S2 is equal to d. since the answer may be large return it modulo 10<sup>9</sup>&nbsp;+ 7.</span></p>
<p><strong><span style="font-size: 18px;">Example 1:</span></strong></p>
<pre><span style="font-size: 18px;"><strong>Input:</strong>
n = 4, d = 3
arr[] =  { 5, 2, 6, 4}
<strong>Output:</strong>
1
<strong>Explanation:</strong>
<code>There is only one possible partition of this array. Partition : {6, 4}, {5, 2}. The subset difference between subset sum is: (6 + 4) - (5 + 2) = 3.</code></span></pre>
<p><strong><span style="font-size: 18px;"><code>Example 2:</code></span></strong></p>
<pre><span style="font-size: 18px;"><code><strong>Input:</strong>
</code>n = 4, d = 0 arr[] = {1, 1, 1, 1} <strong>Output:</strong> 6 </span></pre>
<p><strong><span style="font-size: 18px;">Your Task:</span></strong><br><span style="font-size: 18px;">You don't have to read input or print anything. Your task is to complete the function&nbsp;<strong>countPartitions()&nbsp;</strong>which takes the integer&nbsp;<strong>n</strong>&nbsp;and <strong>d</strong> and array <strong>arr</strong> and returns the count of partitions.</span></p>
<p><strong><span style="font-size: 18px;">Constraint:</span></strong><br><span style="font-size: 18px;">1 &lt;= n &lt;= 500<br>0 &lt;= d&nbsp; &lt;= 2500<br>0 &lt;= arr[i] &lt;= 50</span></p>
<p><strong><span style="font-size: 18px;">Expected Time Complexity:&nbsp;</span></strong><span style="font-size: 18px;">O( N * MAX_SUM), where N and MAX_SUM denote the number of elements in the array and the maximum possible sum of array elements.</span><br><strong><span style="font-size: 18px;">Expected Space Complexity:&nbsp;</span></strong><span style="font-size: 18px;">O( N * MAX_SUM), where N and MAX_SUM denote the number of elements in the array and the maximum possible sum of array elements.</span></p></div>