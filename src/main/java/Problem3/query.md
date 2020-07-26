<h1>3. Query 작성</h1>

(1) 총점(국어 + 영어 + 수학)이 높은 순으로 이름과 총점, 순위를 출력해주세요. 
todo: '순위'도 출력해야한다. 
~~~
SELECT sub.name, sub.totalscore, @vRank := @vRank + 1 AS ranking
FROM (
    SELECT name, SUM(score) totalscore
    FROM midterm AS a
    GROUP BY name
    ) sub, (SELECT @vRank := 0) AS ranking
ORDER BY totalscore DESC;
~~~
<br>

(2) 각 과목별 최저 점수가 누구인지 이름, 과목, 점수를 출력해주세요. 
~~~
SELECT *
FROM midterm
GROUP BY subject
HAVING score = MIN(score);
~~~
<br>

(3) 총점이 200 점 넘은 사람은 누구인지 이름, 총점 출력해주세요. 
~~~
SELECT name, SUM(score) totalscore
FROM midterm
GROUP BY name
HAVING totalscore > 200;
~~~
<br>

(4) 늑대의 수학점수가 잘못 입력됐습니다. 수정을 해주세요. 늑대의 수학점수는 여우와 돼지의 수학점수 평균보다 15점이 높습니다.
~~~
UPDATE midterm
SET score = (
    SELECT temp.value     
    FROM (
        SELECT AVG(score) + 15 value 
        FROM midterm 
        WHERE subject = '수학' 
        AND (name = '돼지' OR name = '여우')
        ) temp 
    ) 
WHERE subject = '수학'
AND name = '늑대';
~~~
