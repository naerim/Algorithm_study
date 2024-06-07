function solution(ineq, eq, n, m) {
    if(ineq === ">") {
        return eq === "=" ? n>=m ? 1 : 0 : n>m ? 1 : 0
    } else {
        return eq === "=" ? n<=m ? 1 : 0 : n<m ? 1 : 0
    }
}