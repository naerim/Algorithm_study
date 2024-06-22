function solution(n)
{
    var answer = 0;
    (""+n).split("").forEach(v => answer += Number(v))
    return answer;
}