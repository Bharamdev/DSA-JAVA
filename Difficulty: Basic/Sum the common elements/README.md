<h2><a href="https://www.geeksforgeeks.org/problems/sum-the-common-elements/1">Sum the common elements</a></h2><h3>Difficulty Level : Difficulty: Basic</h3><hr><div class="problems_problem_content__Xm_eO"><div class="problemQuestion">
<p><span style="font-size: 18px;">You are given two arrays of size<strong> n1 </strong>and<strong> n2</strong>. Your task is to find all the elements that are common to both the arrays and <strong>sum them</strong>. If there are no common elements the output would be <strong>0</strong>.</span></p>
<p><strong><span style="font-size: 18px;">Note: </span></strong><span style="font-size: 18px;">The arrays may contain duplicate elements. However, you need to sum only <strong>unique elements</strong> that are common to both arrays and answer may be too large so return it with <strong>modulo (10<sup>9</sup>+7) .</strong></span></p>
<p>&nbsp;</p>
<p><span style="font-size: 18px;"><strong>Example1:</strong></span></p>
<pre><span style="font-size: 18px;"><strong>Input:</strong>
5 6
1 2 3 4 5
2 3 4 5 6 7
<strong>Output: </strong>14<br><strong>Explanation: </strong>Common unique elements in both arrays are 2, 3, 4 and 5 so answer will be 2+3+4+5 = 14<br></span></pre>
<p><strong><span style="font-size: 18px;">Example2:</span></strong></p>
<pre><span style="font-size: 18px;"><strong>Input:</strong>
5 6
1 2 2 3 5
3 3 2 2 6 5
<strong>Output: </strong>10<br><strong>Explanation: </strong>Common unique elements in both arrays are 2, 3 and 5 so answer will be 2+3+5 = 10</span></pre>
<p><span style="font-size: 18px;"><strong>Your Task:</strong><br>Since this is a function problem, you don't need to take any input. Just complete the provided function <strong>commonSum</strong> which takes two integer <strong>n1</strong> , <strong>n2</strong> and two integer arrays <strong>arr1</strong> and <strong>arr2</strong> have sizes n1 and n2 respectively.</span></p>
<p><span style="font-size: 18px;"><strong>Expected Time Complexity : </strong>O(n1 + n2)</span></p>
<p><span style="font-size: 18px;"><strong>Expected Space Complexity :</strong> O(min(n1,n2))</span></p>
<p><span style="font-size: 18px;"><strong>Constraints:</strong><br>1 &lt;= n1,n2 &lt;= 10<sup>6</sup><br>1 &lt;= arr1[i] , arr2[i] &lt;= 10<sup>9</sup></span></p>
<p>&nbsp;</p>
</div></div><br><p><span style=font-size:18px><strong>Topic Tags : </strong><br><code>set</code>&nbsp;